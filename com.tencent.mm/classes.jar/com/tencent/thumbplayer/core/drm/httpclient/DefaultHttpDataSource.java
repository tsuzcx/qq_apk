package com.tencent.thumbplayer.core.drm.httpclient;

import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultHttpDataSource
  extends BaseDataSource
  implements HttpDataSource
{
  private static final Pattern CONTENT_RANGE_HEADER;
  public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
  public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
  private static final int HTTP_STATUS_PERMANENT_REDIRECT = 308;
  private static final int HTTP_STATUS_TEMPORARY_REDIRECT = 307;
  private static final long MAX_BYTES_TO_DRAIN = 2048L;
  private static final int MAX_REDIRECTS = 20;
  private static final String TAG = "DefaultHttpDataSource";
  private static final AtomicReference<byte[]> skipBufferReference;
  private final boolean allowCrossProtocolRedirects;
  private long bytesRead;
  private long bytesSkipped;
  private long bytesToRead;
  private long bytesToSkip;
  private final int connectTimeoutMillis;
  private HttpURLConnection connection;
  private final Predicate<String> contentTypePredicate;
  private DataSpec dataSpec;
  private final HttpDataSource.RequestProperties defaultRequestProperties;
  private InputStream inputStream;
  private boolean opened;
  private final int readTimeoutMillis;
  private final HttpDataSource.RequestProperties requestProperties;
  private final String userAgent;
  
  static
  {
    AppMethodBeat.i(193846);
    CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    skipBufferReference = new AtomicReference();
    AppMethodBeat.o(193846);
  }
  
  public DefaultHttpDataSource(String paramString)
  {
    this(paramString, null);
  }
  
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate)
  {
    this(paramString, paramPredicate, 8000, 8000);
  }
  
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, int paramInt1, int paramInt2)
  {
    this(paramString, paramPredicate, paramInt1, paramInt2, false, null);
  }
  
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, int paramInt1, int paramInt2, boolean paramBoolean, HttpDataSource.RequestProperties paramRequestProperties)
  {
    super(true);
    AppMethodBeat.i(193828);
    this.userAgent = Assertions.checkNotEmpty(paramString);
    this.contentTypePredicate = paramPredicate;
    this.requestProperties = new HttpDataSource.RequestProperties();
    this.connectTimeoutMillis = paramInt1;
    this.readTimeoutMillis = paramInt2;
    this.allowCrossProtocolRedirects = paramBoolean;
    this.defaultRequestProperties = paramRequestProperties;
    AppMethodBeat.o(193828);
  }
  
  @Deprecated
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, TransferListener paramTransferListener)
  {
    this(paramString, paramPredicate, paramTransferListener, 8000, 8000);
  }
  
  @Deprecated
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, TransferListener paramTransferListener, int paramInt1, int paramInt2)
  {
    this(paramString, paramPredicate, paramTransferListener, paramInt1, paramInt2, false, null);
  }
  
  @Deprecated
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, TransferListener paramTransferListener, int paramInt1, int paramInt2, boolean paramBoolean, HttpDataSource.RequestProperties paramRequestProperties)
  {
    this(paramString, paramPredicate, paramInt1, paramInt2, paramBoolean, paramRequestProperties);
    AppMethodBeat.i(193829);
    if (paramTransferListener != null) {
      addTransferListener(paramTransferListener);
    }
    AppMethodBeat.o(193829);
  }
  
  private void closeConnectionQuietly()
  {
    AppMethodBeat.i(193845);
    if (this.connection != null) {}
    try
    {
      this.connection.disconnect();
      label19:
      this.connection = null;
      AppMethodBeat.o(193845);
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }
  
  private static long getContentLength(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(193841);
    l2 = -1L;
    String str = paramHttpURLConnection.getHeaderField("Content-Length");
    l1 = l2;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      l1 = Long.parseLong(str);
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Range");
      l2 = l1;
      Matcher localMatcher;
      if (!TextUtils.isEmpty(paramHttpURLConnection))
      {
        localMatcher = CONTENT_RANGE_HEADER.matcher(paramHttpURLConnection);
        l2 = l1;
        if (!localMatcher.find()) {}
      }
      try
      {
        l2 = Long.parseLong(localMatcher.group(2));
        l3 = Long.parseLong(localMatcher.group(1));
        l3 = l2 - l3 + 1L;
        if (l1 >= 0L) {
          break label140;
        }
        l2 = l3;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        for (;;)
        {
          long l3;
          new StringBuilder("Unexpected Content-Range [").append(paramHttpURLConnection).append("]");
          l2 = l1;
        }
      }
      AppMethodBeat.o(193841);
      return l2;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      for (;;)
      {
        new StringBuilder("Unexpected Content-Length [").append(str).append("]");
        l1 = l2;
        continue;
        label140:
        l2 = l1;
        if (l1 != l3)
        {
          new StringBuilder("Inconsistent headers [").append(str).append("] [").append(paramHttpURLConnection).append("]");
          l2 = Math.max(l1, l3);
        }
      }
    }
  }
  
  private static URL handleRedirect(URL paramURL, String paramString)
  {
    AppMethodBeat.i(193840);
    if (paramString == null)
    {
      paramURL = new ProtocolException("Null location redirect");
      AppMethodBeat.o(193840);
      throw paramURL;
    }
    paramURL = new URL(paramURL, paramString);
    paramString = paramURL.getProtocol();
    if ((!"https".equals(paramString)) && (!"http".equals(paramString)))
    {
      paramURL = new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(193840);
      throw paramURL;
    }
    AppMethodBeat.o(193840);
    return paramURL;
  }
  
  private HttpURLConnection makeConnection(DataSpec paramDataSpec)
  {
    AppMethodBeat.i(193838);
    Object localObject = new URL(paramDataSpec.uri.toString());
    int j = paramDataSpec.httpMethod;
    byte[] arrayOfByte = paramDataSpec.httpBody;
    long l1 = paramDataSpec.position;
    long l2 = paramDataSpec.length;
    boolean bool1 = paramDataSpec.isFlagSet(1);
    boolean bool2 = paramDataSpec.isFlagSet(2);
    if (!this.allowCrossProtocolRedirects)
    {
      paramDataSpec = makeConnection((URL)localObject, j, arrayOfByte, l1, l2, bool1, bool2, true);
      AppMethodBeat.o(193838);
      return paramDataSpec;
    }
    int i = 0;
    paramDataSpec = (DataSpec)localObject;
    int k;
    HttpURLConnection localHttpURLConnection;
    for (;;)
    {
      k = i + 1;
      if (i > 20) {
        break label276;
      }
      localHttpURLConnection = makeConnection(paramDataSpec, j, arrayOfByte, l1, l2, bool1, bool2, false);
      i = localHttpURLConnection.getResponseCode();
      localObject = localHttpURLConnection.getHeaderField("Location");
      if (((j == 1) || (j == 3)) && ((i == 300) || (i == 301) || (i == 302) || (i == 303) || (i == 307) || (i == 308)))
      {
        localHttpURLConnection.disconnect();
        paramDataSpec = handleRedirect(paramDataSpec, (String)localObject);
        i = k;
      }
      else
      {
        if ((j != 2) || ((i != 300) && (i != 301) && (i != 302) && (i != 303))) {
          break;
        }
        localHttpURLConnection.disconnect();
        j = 1;
        arrayOfByte = null;
        paramDataSpec = handleRedirect(paramDataSpec, (String)localObject);
        i = k;
      }
    }
    AppMethodBeat.o(193838);
    return localHttpURLConnection;
    label276:
    paramDataSpec = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(k)));
    AppMethodBeat.o(193838);
    throw paramDataSpec;
  }
  
  private HttpURLConnection makeConnection(URL paramURL, int paramInt, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(193839);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.connectTimeoutMillis);
    localHttpURLConnection.setReadTimeout(this.readTimeoutMillis);
    Object localObject;
    if (this.defaultRequestProperties != null)
    {
      paramURL = this.defaultRequestProperties.getSnapshot().entrySet().iterator();
      while (paramURL.hasNext())
      {
        localObject = (Map.Entry)paramURL.next();
        localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramURL = this.requestProperties.getSnapshot().entrySet().iterator();
    while (paramURL.hasNext())
    {
      localObject = (Map.Entry)paramURL.next();
      localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      localObject = "bytes=" + paramLong1 + "-";
      paramURL = (URL)localObject;
      if (paramLong2 != -1L) {
        paramURL = (String)localObject + (paramLong1 + paramLong2 - 1L);
      }
      localHttpURLConnection.setRequestProperty("Range", paramURL);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.userAgent);
    if (!paramBoolean1) {
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    if (paramBoolean2) {
      localHttpURLConnection.setRequestProperty("Icy-MetaData", "1");
    }
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean3);
    if (paramArrayOfByte != null)
    {
      paramBoolean1 = true;
      localHttpURLConnection.setDoOutput(paramBoolean1);
      localHttpURLConnection.setRequestMethod(DataSpec.getStringForHttpMethod(paramInt));
      if (paramArrayOfByte == null) {
        break label381;
      }
      localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      localHttpURLConnection.connect();
      paramURL = localHttpURLConnection.getOutputStream();
      paramURL.write(paramArrayOfByte);
      paramURL.close();
    }
    for (;;)
    {
      AppMethodBeat.o(193839);
      return localHttpURLConnection;
      paramBoolean1 = false;
      break;
      label381:
      localHttpURLConnection.connect();
    }
  }
  
  private static void maybeTerminateInputStream(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    AppMethodBeat.i(193844);
    if ((Build.VERSION.SDK_INT != 19) && (Build.VERSION.SDK_INT != 20))
    {
      AppMethodBeat.o(193844);
      return;
    }
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      if (paramLong == -1L)
      {
        int i = paramHttpURLConnection.read();
        if (i == -1) {
          AppMethodBeat.o(193844);
        }
      }
      else if (paramLong <= 2048L)
      {
        AppMethodBeat.o(193844);
        return;
      }
      Object localObject = paramHttpURLConnection.getClass().getName();
      if (("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(localObject)) || ("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(localObject)))
      {
        localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
      }
      AppMethodBeat.o(193844);
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      AppMethodBeat.o(193844);
    }
  }
  
  private int readInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193843);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(193843);
      return 0;
    }
    int i = paramInt2;
    if (this.bytesToRead != -1L)
    {
      long l = this.bytesToRead - this.bytesRead;
      if (l == 0L)
      {
        AppMethodBeat.o(193843);
        return -1;
      }
      i = (int)Math.min(paramInt2, l);
    }
    paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, i);
    if (paramInt1 == -1)
    {
      if (this.bytesToRead != -1L)
      {
        paramArrayOfByte = new EOFException();
        AppMethodBeat.o(193843);
        throw paramArrayOfByte;
      }
      AppMethodBeat.o(193843);
      return -1;
    }
    this.bytesRead += paramInt1;
    bytesTransferred(paramInt1);
    AppMethodBeat.o(193843);
    return paramInt1;
  }
  
  private void skipInternal()
  {
    AppMethodBeat.i(193842);
    if (this.bytesSkipped == this.bytesToSkip)
    {
      AppMethodBeat.o(193842);
      return;
    }
    byte[] arrayOfByte = (byte[])skipBufferReference.getAndSet(null);
    Object localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4096];
    }
    while (this.bytesSkipped != this.bytesToSkip)
    {
      int i = (int)Math.min(this.bytesToSkip - this.bytesSkipped, localObject.length);
      i = this.inputStream.read((byte[])localObject, 0, i);
      if (Thread.currentThread().isInterrupted())
      {
        localObject = new InterruptedIOException();
        AppMethodBeat.o(193842);
        throw ((Throwable)localObject);
      }
      if (i == -1)
      {
        localObject = new EOFException();
        AppMethodBeat.o(193842);
        throw ((Throwable)localObject);
      }
      this.bytesSkipped += i;
      bytesTransferred(i);
    }
    skipBufferReference.set(localObject);
    AppMethodBeat.o(193842);
  }
  
  protected final long bytesRead()
  {
    return this.bytesRead;
  }
  
  protected final long bytesRemaining()
  {
    if (this.bytesToRead == -1L) {
      return this.bytesToRead;
    }
    return this.bytesToRead - this.bytesRead;
  }
  
  protected final long bytesSkipped()
  {
    return this.bytesSkipped;
  }
  
  public void clearAllRequestProperties()
  {
    AppMethodBeat.i(193834);
    this.requestProperties.clear();
    AppMethodBeat.o(193834);
  }
  
  public void clearRequestProperty(String paramString)
  {
    AppMethodBeat.i(193833);
    Assertions.checkNotNull(paramString);
    this.requestProperties.remove(paramString);
    AppMethodBeat.o(193833);
  }
  
  public void close()
  {
    AppMethodBeat.i(193837);
    try
    {
      if (this.inputStream != null) {
        maybeTerminateInputStream(this.connection, bytesRemaining());
      }
      try
      {
        this.inputStream.close();
        return;
      }
      catch (IOException localIOException)
      {
        HttpDataSource.HttpDataSourceException localHttpDataSourceException = new HttpDataSource.HttpDataSourceException(localIOException, this.dataSpec, 3);
        AppMethodBeat.o(193837);
        throw localHttpDataSourceException;
      }
      AppMethodBeat.o(193837);
    }
    finally
    {
      this.inputStream = null;
      closeConnectionQuietly();
      if (this.opened)
      {
        this.opened = false;
        transferEnded();
      }
      AppMethodBeat.o(193837);
    }
  }
  
  protected final HttpURLConnection getConnection()
  {
    return this.connection;
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    AppMethodBeat.i(193831);
    if (this.connection == null)
    {
      AppMethodBeat.o(193831);
      return null;
    }
    Map localMap = this.connection.getHeaderFields();
    AppMethodBeat.o(193831);
    return localMap;
  }
  
  public Uri getUri()
  {
    AppMethodBeat.i(193830);
    if (this.connection == null)
    {
      AppMethodBeat.o(193830);
      return null;
    }
    Uri localUri = Uri.parse(this.connection.getURL().toString());
    AppMethodBeat.o(193830);
    return localUri;
  }
  
  /* Error */
  public long open(DataSpec paramDataSpec)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 5
    //   3: ldc_w 559
    //   6: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 561	com/tencent/thumbplayer/core/drm/httpclient/MyHostnameVerifier
    //   12: dup
    //   13: invokespecial 562	com/tencent/thumbplayer/core/drm/httpclient/MyHostnameVerifier:<init>	()V
    //   16: astore 7
    //   18: new 564	com/tencent/thumbplayer/core/drm/httpclient/SSLTrustAllSocketFactory
    //   21: dup
    //   22: invokespecial 565	com/tencent/thumbplayer/core/drm/httpclient/SSLTrustAllSocketFactory:<init>	()V
    //   25: invokestatic 571	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   28: aload 7
    //   30: invokestatic 575	javax/net/ssl/HttpsURLConnection:setDefaultHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   33: aload_0
    //   34: aload_1
    //   35: putfield 531	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:dataSpec	Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;
    //   38: aload_0
    //   39: lconst_0
    //   40: putfield 457	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesRead	J
    //   43: aload_0
    //   44: lconst_0
    //   45: putfield 474	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesSkipped	J
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 579	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:transferInitializing	(Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   53: aload_0
    //   54: aload_0
    //   55: aload_1
    //   56: invokespecial 581	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:makeConnection	(Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)Ljava/net/HttpURLConnection;
    //   59: putfield 145	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   62: aload_0
    //   63: getfield 145	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   66: invokevirtual 289	java/net/HttpURLConnection:getResponseCode	()I
    //   69: istore_2
    //   70: aload_0
    //   71: getfield 145	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   74: invokevirtual 584	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   77: astore 7
    //   79: iload_2
    //   80: sipush 200
    //   83: if_icmplt +10 -> 93
    //   86: iload_2
    //   87: sipush 299
    //   90: if_icmple +152 -> 242
    //   93: aload_0
    //   94: getfield 145	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   97: invokevirtual 541	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   100: astore 8
    //   102: aload_0
    //   103: invokespecial 522	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   106: new 586	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException
    //   109: dup
    //   110: iload_2
    //   111: aload 7
    //   113: aload 8
    //   115: aload_1
    //   116: invokespecial 589	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException:<init>	(ILjava/lang/String;Ljava/util/Map;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   119: astore_1
    //   120: iload_2
    //   121: sipush 416
    //   124: if_icmpne +16 -> 140
    //   127: aload_1
    //   128: new 591	com/tencent/thumbplayer/core/drm/httpclient/DataSourceException
    //   131: dup
    //   132: iconst_0
    //   133: invokespecial 593	com/tencent/thumbplayer/core/drm/httpclient/DataSourceException:<init>	(I)V
    //   136: invokevirtual 597	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   139: pop
    //   140: ldc_w 559
    //   143: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_1
    //   147: athrow
    //   148: astore 7
    //   150: new 529	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException
    //   153: dup
    //   154: new 192	java/lang/StringBuilder
    //   157: dup
    //   158: ldc_w 599
    //   161: invokespecial 196	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: aload_1
    //   165: getfield 259	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:uri	Landroid/net/Uri;
    //   168: invokevirtual 264	android/net/Uri:toString	()Ljava/lang/String;
    //   171: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: aload 7
    //   179: aload_1
    //   180: iconst_1
    //   181: invokespecial 602	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;I)V
    //   184: astore_1
    //   185: ldc_w 559
    //   188: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_1
    //   192: athrow
    //   193: astore 7
    //   195: aload_0
    //   196: invokespecial 522	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   199: new 529	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException
    //   202: dup
    //   203: new 192	java/lang/StringBuilder
    //   206: dup
    //   207: ldc_w 599
    //   210: invokespecial 196	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   213: aload_1
    //   214: getfield 259	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:uri	Landroid/net/Uri;
    //   217: invokevirtual 264	android/net/Uri:toString	()Ljava/lang/String;
    //   220: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: aload 7
    //   228: aload_1
    //   229: iconst_1
    //   230: invokespecial 602	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;I)V
    //   233: astore_1
    //   234: ldc_w 559
    //   237: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aload_1
    //   241: athrow
    //   242: aload_0
    //   243: getfield 145	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   246: invokevirtual 605	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   249: astore 7
    //   251: aload_0
    //   252: getfield 108	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:contentTypePredicate	Lcom/tencent/thumbplayer/core/drm/httpclient/Predicate;
    //   255: ifnull +40 -> 295
    //   258: aload_0
    //   259: getfield 108	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:contentTypePredicate	Lcom/tencent/thumbplayer/core/drm/httpclient/Predicate;
    //   262: aload 7
    //   264: invokeinterface 610 2 0
    //   269: ifne +26 -> 295
    //   272: aload_0
    //   273: invokespecial 522	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   276: new 612	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidContentTypeException
    //   279: dup
    //   280: aload 7
    //   282: aload_1
    //   283: invokespecial 615	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidContentTypeException:<init>	(Ljava/lang/String;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   286: astore_1
    //   287: ldc_w 559
    //   290: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: aload_1
    //   294: athrow
    //   295: lload 5
    //   297: lstore_3
    //   298: iload_2
    //   299: sipush 200
    //   302: if_icmpne +20 -> 322
    //   305: lload 5
    //   307: lstore_3
    //   308: aload_1
    //   309: getfield 275	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:position	J
    //   312: lconst_0
    //   313: lcmp
    //   314: ifeq +8 -> 322
    //   317: aload_1
    //   318: getfield 275	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:position	J
    //   321: lstore_3
    //   322: aload_0
    //   323: lload_3
    //   324: putfield 476	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToSkip	J
    //   327: aload_1
    //   328: iconst_1
    //   329: invokevirtual 282	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:isFlagSet	(I)Z
    //   332: ifne +94 -> 426
    //   335: aload_1
    //   336: getfield 278	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:length	J
    //   339: ldc2_w 156
    //   342: lcmp
    //   343: ifeq +45 -> 388
    //   346: aload_0
    //   347: aload_1
    //   348: getfield 278	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:length	J
    //   351: putfield 455	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   354: aload_0
    //   355: aload_0
    //   356: getfield 145	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   359: invokevirtual 412	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   362: putfield 462	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   365: aload_0
    //   366: iconst_1
    //   367: putfield 524	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:opened	Z
    //   370: aload_0
    //   371: aload_1
    //   372: invokevirtual 618	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:transferStarted	(Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   375: aload_0
    //   376: getfield 455	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   379: lstore_3
    //   380: ldc_w 559
    //   383: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: lload_3
    //   387: lreturn
    //   388: aload_0
    //   389: getfield 145	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   392: invokestatic 620	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:getContentLength	(Ljava/net/HttpURLConnection;)J
    //   395: lstore_3
    //   396: lload_3
    //   397: ldc2_w 156
    //   400: lcmp
    //   401: ifeq +18 -> 419
    //   404: lload_3
    //   405: aload_0
    //   406: getfield 476	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToSkip	J
    //   409: lsub
    //   410: lstore_3
    //   411: aload_0
    //   412: lload_3
    //   413: putfield 455	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   416: goto -62 -> 354
    //   419: ldc2_w 156
    //   422: lstore_3
    //   423: goto -12 -> 411
    //   426: aload_0
    //   427: aload_1
    //   428: getfield 278	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:length	J
    //   431: putfield 455	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   434: goto -80 -> 354
    //   437: astore 7
    //   439: aload_0
    //   440: invokespecial 522	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   443: new 529	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException
    //   446: dup
    //   447: aload 7
    //   449: aload_1
    //   450: iconst_1
    //   451: invokespecial 534	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/io/IOException;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;I)V
    //   454: astore_1
    //   455: ldc_w 559
    //   458: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   461: aload_1
    //   462: athrow
    //   463: astore 8
    //   465: goto -437 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	DefaultHttpDataSource
    //   0	468	1	paramDataSpec	DataSpec
    //   69	234	2	i	int
    //   297	126	3	l1	long
    //   1	305	5	l2	long
    //   16	96	7	localObject	Object
    //   148	30	7	localIOException1	IOException
    //   193	34	7	localIOException2	IOException
    //   249	32	7	str	String
    //   437	11	7	localIOException3	IOException
    //   100	14	8	localMap	Map
    //   463	1	8	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   53	62	148	java/io/IOException
    //   62	79	193	java/io/IOException
    //   354	365	437	java/io/IOException
    //   18	28	463	java/lang/Throwable
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193836);
    try
    {
      skipInternal();
      paramInt1 = readInternal(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(193836);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new HttpDataSource.HttpDataSourceException(paramArrayOfByte, this.dataSpec, 2);
      AppMethodBeat.o(193836);
      throw paramArrayOfByte;
    }
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193832);
    Assertions.checkNotNull(paramString1);
    Assertions.checkNotNull(paramString2);
    this.requestProperties.set(paramString1, paramString2);
    AppMethodBeat.o(193832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DefaultHttpDataSource
 * JD-Core Version:    0.7.0.1
 */