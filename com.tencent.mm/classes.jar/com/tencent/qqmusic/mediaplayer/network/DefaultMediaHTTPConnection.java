package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DefaultMediaHTTPConnection
  implements IMediaHTTPConnection
{
  private static final int CONNECT_TIMEOUT_MS = 30000;
  private static final int HTTP_TEMP_REDIRECT = 307;
  private static final int MAX_REDIRECTS = 20;
  private static final String TAG = "MediaHTTPConnection";
  private static final boolean VERBOSE = false;
  private boolean mAllowCrossDomainRedirect = true;
  private boolean mAllowCrossProtocolRedirect = true;
  private HttpURLConnection mConnection = null;
  private long mCurrentOffset = -1L;
  private Map<String, String> mHeaders = null;
  private InputStream mInputStream = null;
  private long mTotalSize = -1L;
  private URL mURL = null;
  
  private boolean filterOutInternalHeaders(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104790);
    if ("android-allow-cross-domain-redirect".equalsIgnoreCase(paramString1))
    {
      this.mAllowCrossDomainRedirect = parseBoolean(paramString2);
      this.mAllowCrossProtocolRedirect = this.mAllowCrossDomainRedirect;
      AppMethodBeat.o(104790);
      return true;
    }
    AppMethodBeat.o(104790);
    return false;
  }
  
  private static final boolean isLocalHost(URL paramURL)
  {
    AppMethodBeat.i(104793);
    if (paramURL == null)
    {
      AppMethodBeat.o(104793);
      return false;
    }
    paramURL = paramURL.getHost();
    if (paramURL == null)
    {
      AppMethodBeat.o(104793);
      return false;
    }
    try
    {
      boolean bool = paramURL.equalsIgnoreCase("localhost");
      if (bool)
      {
        AppMethodBeat.o(104793);
        return true;
      }
    }
    catch (IllegalArgumentException paramURL)
    {
      Logger.e("MediaHTTPConnection", "isLocalHost", paramURL);
      AppMethodBeat.o(104793);
    }
    return false;
  }
  
  private boolean parseBoolean(String paramString)
  {
    AppMethodBeat.i(104789);
    try
    {
      if (Long.parseLong(paramString) != 0L)
      {
        AppMethodBeat.o(104789);
        return true;
      }
      AppMethodBeat.o(104789);
      return false;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (("true".equalsIgnoreCase(paramString)) || ("yes".equalsIgnoreCase(paramString)))
      {
        AppMethodBeat.o(104789);
        return true;
      }
      AppMethodBeat.o(104789);
    }
    return false;
  }
  
  private void seekTo(long paramLong)
  {
    AppMethodBeat.i(104794);
    teardownConnection();
    label288:
    label693:
    label889:
    label892:
    for (;;)
    {
      int j;
      int k;
      int i;
      try
      {
        Object localObject1 = this.mURL;
        boolean bool1 = isLocalHost((URL)localObject1);
        j = 0;
        if (bool1)
        {
          this.mConnection = ((HttpURLConnection)((URL)localObject1).openConnection(Proxy.NO_PROXY));
          Logger.i("MediaHTTPConnection", "setConnectTimeout " + this.mURL);
          this.mConnection.setConnectTimeout(30000);
          this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
          k = 0;
          i = 0;
          if (this.mHeaders != null)
          {
            localObject1 = this.mHeaders.entrySet().iterator();
            k = i;
            if (((Iterator)localObject1).hasNext())
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
              this.mConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
              if ((i != 0) || (!"Accept-Encoding".equals(localEntry.getKey()))) {
                break label889;
              }
              i = 1;
              break label889;
            }
          }
        }
        else
        {
          this.mConnection = ((HttpURLConnection)((URL)localObject1).openConnection());
          continue;
        }
        if (paramLong <= 0L) {
          break label288;
        }
      }
      catch (IOException localIOException)
      {
        this.mTotalSize = -1L;
        this.mInputStream = null;
        this.mConnection = null;
        this.mCurrentOffset = -1L;
        Logger.e("MediaHTTPConnection", "seekTo", localIOException);
        AppMethodBeat.o(104794);
        throw localIOException;
      }
      this.mConnection.setRequestProperty("Range", "bytes=" + paramLong + "-");
      if (k == 0) {
        this.mConnection.setRequestProperty("Accept-Encoding", "");
      }
      try
      {
        i = this.mConnection.getResponseCode();
        if ((i != 300) && (i != 301) && (i != 302) && (i != 303) && (i != 307)) {
          break label693;
        }
        j += 1;
        if (j > 20)
        {
          NoRouteToHostException localNoRouteToHostException = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(j)));
          AppMethodBeat.o(104794);
          throw localNoRouteToHostException;
        }
      }
      catch (Exception localException)
      {
        localObject2 = new IOException("An suspicious exception occurred: " + localException.getMessage());
        AppMethodBeat.o(104794);
        throw ((Throwable)localObject2);
      }
      Object localObject2 = this.mConnection.getRequestMethod();
      if ((i == 307) && (!((String)localObject2).equals("GET")) && (!((String)localObject2).equals("HEAD")))
      {
        localObject2 = new NoRouteToHostException("Invalid redirect");
        AppMethodBeat.o(104794);
        throw ((Throwable)localObject2);
      }
      localObject2 = this.mConnection.getHeaderField("Location");
      if (localObject2 == null)
      {
        localObject2 = new NoRouteToHostException("Invalid redirect");
        AppMethodBeat.o(104794);
        throw ((Throwable)localObject2);
      }
      localObject2 = new URL(this.mURL, (String)localObject2);
      if ((!((URL)localObject2).getProtocol().equals("https")) && (!((URL)localObject2).getProtocol().equals("http")))
      {
        localObject2 = new NoRouteToHostException("Unsupported protocol redirect");
        AppMethodBeat.o(104794);
        throw ((Throwable)localObject2);
      }
      boolean bool2 = this.mURL.getProtocol().equals(((URL)localObject2).getProtocol());
      if ((!this.mAllowCrossProtocolRedirect) && (!bool2))
      {
        localObject2 = new NoRouteToHostException("Cross-protocol redirects are disallowed");
        AppMethodBeat.o(104794);
        throw ((Throwable)localObject2);
      }
      bool2 = this.mURL.getHost().equals(((URL)localObject2).getHost());
      if ((!this.mAllowCrossDomainRedirect) && (!bool2))
      {
        localObject2 = new NoRouteToHostException("Cross-domain redirects are disallowed");
        AppMethodBeat.o(104794);
        throw ((Throwable)localObject2);
      }
      if (i != 307)
      {
        this.mURL = ((URL)localObject2);
        break label892;
        if (this.mAllowCrossDomainRedirect) {
          this.mURL = this.mConnection.getURL();
        }
        if (i == 206)
        {
          localObject2 = this.mConnection.getHeaderField("Content-Range");
          this.mTotalSize = -1L;
          if (localObject2 != null)
          {
            j = ((String)localObject2).lastIndexOf('/');
            if (j >= 0) {
              localObject2 = ((String)localObject2).substring(j + 1);
            }
          }
        }
        try
        {
          for (this.mTotalSize = Long.parseLong((String)localObject2); (paramLong > 0L) && (i != 206); this.mTotalSize = this.mConnection.getContentLength())
          {
            localObject2 = new ProtocolException();
            AppMethodBeat.o(104794);
            throw ((Throwable)localObject2);
            if (i != 200)
            {
              localObject2 = new IOException("failed! status code: ".concat(String.valueOf(i)));
              AppMethodBeat.o(104794);
              throw ((Throwable)localObject2);
            }
          }
          this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
          this.mCurrentOffset = paramLong;
          AppMethodBeat.o(104794);
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          break label776;
        }
      }
    }
  }
  
  private void teardownConnection()
  {
    AppMethodBeat.i(104792);
    if (this.mConnection != null)
    {
      this.mInputStream = null;
      this.mConnection.disconnect();
      this.mConnection = null;
      this.mCurrentOffset = -1L;
    }
    AppMethodBeat.o(104792);
  }
  
  public boolean connect(URL paramURL, Map<String, String> paramMap)
  {
    AppMethodBeat.i(104788);
    disconnect();
    this.mAllowCrossDomainRedirect = true;
    this.mURL = paramURL;
    this.mHeaders = paramMap;
    AppMethodBeat.o(104788);
    return true;
  }
  
  public void disconnect()
  {
    AppMethodBeat.i(104791);
    teardownConnection();
    this.mHeaders = null;
    this.mURL = null;
    AppMethodBeat.o(104791);
  }
  
  public String getMIMEType()
  {
    AppMethodBeat.i(104797);
    if (this.mConnection == null) {}
    try
    {
      seekTo(0L);
      String str = this.mConnection.getContentType();
      AppMethodBeat.o(104797);
      return str;
    }
    catch (IOException localIOException)
    {
      Logger.e("MediaHTTPConnection", "getMIMEType", localIOException);
      AppMethodBeat.o(104797);
    }
    return "application/octet-stream";
  }
  
  public long getSize()
  {
    AppMethodBeat.i(104796);
    if (this.mConnection == null) {}
    try
    {
      seekTo(0L);
      long l = this.mTotalSize;
      AppMethodBeat.o(104796);
      return l;
    }
    catch (IOException localIOException)
    {
      Logger.e("MediaHTTPConnection", "getSize", localIOException);
      AppMethodBeat.o(104796);
    }
    return -1L;
  }
  
  public String getUri()
  {
    AppMethodBeat.i(104798);
    String str = this.mURL.toString();
    AppMethodBeat.o(104798);
    return str;
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104795);
    try
    {
      if (paramLong != this.mCurrentOffset) {
        seekTo(paramLong);
      }
      int i = this.mInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = i;
      if (i == -1) {
        paramInt1 = 0;
      }
      this.mCurrentOffset += paramInt1;
      AppMethodBeat.o(104795);
      return paramInt1;
    }
    catch (ProtocolException paramArrayOfByte)
    {
      Logger.w("MediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
      AppMethodBeat.o(104795);
      return -1010;
    }
    catch (NoRouteToHostException paramArrayOfByte)
    {
      Logger.w("MediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
      AppMethodBeat.o(104795);
      return -1010;
    }
    catch (UnknownServiceException paramArrayOfByte)
    {
      Logger.w("MediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
      AppMethodBeat.o(104795);
      return -1010;
    }
    catch (IOException paramArrayOfByte)
    {
      AppMethodBeat.o(104795);
      return -2;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(104795);
    }
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPConnection
 * JD-Core Version:    0.7.0.1
 */