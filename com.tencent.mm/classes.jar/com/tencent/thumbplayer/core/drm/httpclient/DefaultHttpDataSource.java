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
    AppMethodBeat.i(228393);
    CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    skipBufferReference = new AtomicReference();
    AppMethodBeat.o(228393);
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
    AppMethodBeat.i(228336);
    this.userAgent = Assertions.checkNotEmpty(paramString);
    this.contentTypePredicate = paramPredicate;
    this.requestProperties = new HttpDataSource.RequestProperties();
    this.connectTimeoutMillis = paramInt1;
    this.readTimeoutMillis = paramInt2;
    this.allowCrossProtocolRedirects = paramBoolean;
    this.defaultRequestProperties = paramRequestProperties;
    AppMethodBeat.o(228336);
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
    AppMethodBeat.i(228351);
    if (paramTransferListener != null) {
      addTransferListener(paramTransferListener);
    }
    AppMethodBeat.o(228351);
  }
  
  private void closeConnectionQuietly()
  {
    AppMethodBeat.i(228390);
    if (this.connection != null) {}
    try
    {
      this.connection.disconnect();
      label19:
      this.connection = null;
      AppMethodBeat.o(228390);
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }
  
  private static long getContentLength(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(228372);
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
      AppMethodBeat.o(228372);
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
    AppMethodBeat.i(228370);
    if (paramString == null)
    {
      paramURL = new ProtocolException("Null location redirect");
      AppMethodBeat.o(228370);
      throw paramURL;
    }
    paramURL = new URL(paramURL, paramString);
    paramString = paramURL.getProtocol();
    if ((!"https".equals(paramString)) && (!"http".equals(paramString)))
    {
      paramURL = new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(228370);
      throw paramURL;
    }
    AppMethodBeat.o(228370);
    return paramURL;
  }
  
  private HttpURLConnection makeConnection(DataSpec paramDataSpec)
  {
    AppMethodBeat.i(228360);
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
      AppMethodBeat.o(228360);
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
    AppMethodBeat.o(228360);
    return localHttpURLConnection;
    label276:
    paramDataSpec = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(k)));
    AppMethodBeat.o(228360);
    throw paramDataSpec;
  }
  
  private HttpURLConnection makeConnection(URL paramURL, int paramInt, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(228366);
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
      AppMethodBeat.o(228366);
      return localHttpURLConnection;
      paramBoolean1 = false;
      break;
      label381:
      localHttpURLConnection.connect();
    }
  }
  
  private static void maybeTerminateInputStream(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    AppMethodBeat.i(228385);
    if ((Build.VERSION.SDK_INT != 19) && (Build.VERSION.SDK_INT != 20))
    {
      AppMethodBeat.o(228385);
      return;
    }
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      if (paramLong == -1L)
      {
        int i = paramHttpURLConnection.read();
        if (i == -1) {
          AppMethodBeat.o(228385);
        }
      }
      else if (paramLong <= 2048L)
      {
        AppMethodBeat.o(228385);
        return;
      }
      Object localObject = paramHttpURLConnection.getClass().getName();
      if (("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(localObject)) || ("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(localObject)))
      {
        localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
      }
      AppMethodBeat.o(228385);
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      AppMethodBeat.o(228385);
    }
  }
  
  private int readInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228380);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(228380);
      return 0;
    }
    int i = paramInt2;
    if (this.bytesToRead != -1L)
    {
      long l = this.bytesToRead - this.bytesRead;
      if (l == 0L)
      {
        AppMethodBeat.o(228380);
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
        AppMethodBeat.o(228380);
        throw paramArrayOfByte;
      }
      AppMethodBeat.o(228380);
      return -1;
    }
    this.bytesRead += paramInt1;
    bytesTransferred(paramInt1);
    AppMethodBeat.o(228380);
    return paramInt1;
  }
  
  private void skipInternal()
  {
    AppMethodBeat.i(228375);
    if (this.bytesSkipped == this.bytesToSkip)
    {
      AppMethodBeat.o(228375);
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
        AppMethodBeat.o(228375);
        throw ((Throwable)localObject);
      }
      if (i == -1)
      {
        localObject = new EOFException();
        AppMethodBeat.o(228375);
        throw ((Throwable)localObject);
      }
      this.bytesSkipped += i;
      bytesTransferred(i);
    }
    skipBufferReference.set(localObject);
    AppMethodBeat.o(228375);
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
    AppMethodBeat.i(228414);
    this.requestProperties.clear();
    AppMethodBeat.o(228414);
  }
  
  public void clearRequestProperty(String paramString)
  {
    AppMethodBeat.i(228410);
    Assertions.checkNotNull(paramString);
    this.requestProperties.remove(paramString);
    AppMethodBeat.o(228410);
  }
  
  public void close()
  {
    AppMethodBeat.i(228427);
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
        AppMethodBeat.o(228427);
        throw localHttpDataSourceException;
      }
      AppMethodBeat.o(228427);
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
      AppMethodBeat.o(228427);
    }
  }
  
  protected final HttpURLConnection getConnection()
  {
    return this.connection;
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    AppMethodBeat.i(228402);
    if (this.connection == null)
    {
      AppMethodBeat.o(228402);
      return null;
    }
    Map localMap = this.connection.getHeaderFields();
    AppMethodBeat.o(228402);
    return localMap;
  }
  
  public Uri getUri()
  {
    AppMethodBeat.i(228397);
    if (this.connection == null)
    {
      AppMethodBeat.o(228397);
      return null;
    }
    Uri localUri = Uri.parse(this.connection.getURL().toString());
    AppMethodBeat.o(228397);
    return localUri;
  }
  
  public long open(DataSpec paramDataSpec)
  {
    long l2 = 0L;
    AppMethodBeat.i(228419);
    this.dataSpec = paramDataSpec;
    this.bytesRead = 0L;
    this.bytesSkipped = 0L;
    transferInitializing(paramDataSpec);
    int i;
    try
    {
      this.connection = makeConnection(paramDataSpec);
      String str1;
      Map localMap;
      str2 = this.connection.getContentType();
    }
    catch (IOException localIOException1)
    {
      try
      {
        i = this.connection.getResponseCode();
        str1 = this.connection.getResponseMessage();
        if ((i >= 200) && (i <= 299)) {
          break label218;
        }
        localMap = this.connection.getHeaderFields();
        closeConnectionQuietly();
        paramDataSpec = new HttpDataSource.InvalidResponseCodeException(i, str1, localMap, paramDataSpec);
        if (i == 416) {
          paramDataSpec.initCause(new DataSourceException(0));
        }
        AppMethodBeat.o(228419);
        throw paramDataSpec;
      }
      catch (IOException localIOException2)
      {
        closeConnectionQuietly();
        paramDataSpec = new HttpDataSource.HttpDataSourceException("Unable to connect to " + paramDataSpec.uri.toString(), localIOException2, paramDataSpec, 1);
        AppMethodBeat.o(228419);
        throw paramDataSpec;
      }
      localIOException1 = localIOException1;
      paramDataSpec = new HttpDataSource.HttpDataSourceException("Unable to connect to " + paramDataSpec.uri.toString(), localIOException1, paramDataSpec, 1);
      AppMethodBeat.o(228419);
      throw paramDataSpec;
    }
    label218:
    String str2;
    if ((this.contentTypePredicate != null) && (!this.contentTypePredicate.evaluate(str2)))
    {
      closeConnectionQuietly();
      paramDataSpec = new HttpDataSource.InvalidContentTypeException(str2, paramDataSpec);
      AppMethodBeat.o(228419);
      throw paramDataSpec;
    }
    long l1 = l2;
    if (i == 200)
    {
      l1 = l2;
      if (paramDataSpec.position != 0L) {
        l1 = paramDataSpec.position;
      }
    }
    this.bytesToSkip = l1;
    if (!paramDataSpec.isFlagSet(1)) {
      if (paramDataSpec.length != -1L) {
        this.bytesToRead = paramDataSpec.length;
      }
    }
    for (;;)
    {
      try
      {
        this.inputStream = this.connection.getInputStream();
        this.opened = true;
        transferStarted(paramDataSpec);
        l1 = this.bytesToRead;
        AppMethodBeat.o(228419);
        return l1;
      }
      catch (IOException localIOException3)
      {
        closeConnectionQuietly();
        paramDataSpec = new HttpDataSource.HttpDataSourceException(localIOException3, paramDataSpec, 1);
        AppMethodBeat.o(228419);
        throw paramDataSpec;
      }
      l1 = getContentLength(this.connection);
      if (l1 != -1L)
      {
        l1 -= this.bytesToSkip;
        this.bytesToRead = l1;
      }
      else
      {
        l1 = -1L;
        continue;
        this.bytesToRead = paramDataSpec.length;
      }
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228424);
    try
    {
      skipInternal();
      paramInt1 = readInternal(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(228424);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new HttpDataSource.HttpDataSourceException(paramArrayOfByte, this.dataSpec, 2);
      AppMethodBeat.o(228424);
      throw paramArrayOfByte;
    }
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228407);
    Assertions.checkNotNull(paramString1);
    Assertions.checkNotNull(paramString2);
    this.requestProperties.set(paramString1, paramString2);
    AppMethodBeat.o(228407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DefaultHttpDataSource
 * JD-Core Version:    0.7.0.1
 */