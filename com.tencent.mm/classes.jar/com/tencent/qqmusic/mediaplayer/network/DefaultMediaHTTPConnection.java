package com.tencent.qqmusic.mediaplayer.network;

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
    if ("android-allow-cross-domain-redirect".equalsIgnoreCase(paramString1))
    {
      this.mAllowCrossDomainRedirect = parseBoolean(paramString2);
      this.mAllowCrossProtocolRedirect = this.mAllowCrossDomainRedirect;
      return true;
    }
    return false;
  }
  
  private static final boolean isLocalHost(URL paramURL)
  {
    if (paramURL == null) {}
    for (;;)
    {
      return false;
      paramURL = paramURL.getHost();
      if (paramURL != null) {
        try
        {
          boolean bool = paramURL.equalsIgnoreCase("localhost");
          if (bool) {
            return true;
          }
        }
        catch (IllegalArgumentException paramURL)
        {
          Logger.e("MediaHTTPConnection", "isLocalHost", paramURL);
        }
      }
    }
    return false;
  }
  
  private boolean parseBoolean(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l == 0L) {
        break label13;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label13:
      while (("true".equalsIgnoreCase(paramString)) || ("yes".equalsIgnoreCase(paramString))) {}
    }
    return true;
    return false;
    return false;
  }
  
  private void seekTo(long paramLong)
  {
    teardownConnection();
    label278:
    label803:
    label806:
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
                break label803;
              }
              i = 1;
              break label803;
            }
          }
        }
        else
        {
          this.mConnection = ((HttpURLConnection)((URL)localObject1).openConnection());
          continue;
        }
        if (paramLong <= 0L) {
          break label278;
        }
      }
      catch (IOException localIOException)
      {
        this.mTotalSize = -1L;
        this.mInputStream = null;
        this.mConnection = null;
        this.mCurrentOffset = -1L;
        Logger.e("MediaHTTPConnection", "seekTo", localIOException);
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
          break label623;
        }
        j += 1;
        if (j > 20) {
          throw new NoRouteToHostException("Too many redirects: " + j);
        }
      }
      catch (Exception localException)
      {
        throw new IOException("An suspicious exception occurred: " + localException.getMessage());
      }
      Object localObject2 = this.mConnection.getRequestMethod();
      if ((i == 307) && (!((String)localObject2).equals("GET")) && (!((String)localObject2).equals("HEAD"))) {
        throw new NoRouteToHostException("Invalid redirect");
      }
      localObject2 = this.mConnection.getHeaderField("Location");
      if (localObject2 == null) {
        throw new NoRouteToHostException("Invalid redirect");
      }
      localObject2 = new URL(this.mURL, (String)localObject2);
      if ((!((URL)localObject2).getProtocol().equals("https")) && (!((URL)localObject2).getProtocol().equals("http"))) {
        throw new NoRouteToHostException("Unsupported protocol redirect");
      }
      boolean bool2 = this.mURL.getProtocol().equals(((URL)localObject2).getProtocol());
      if ((!this.mAllowCrossProtocolRedirect) && (!bool2)) {
        throw new NoRouteToHostException("Cross-protocol redirects are disallowed");
      }
      bool2 = this.mURL.getHost().equals(((URL)localObject2).getHost());
      if ((!this.mAllowCrossDomainRedirect) && (!bool2)) {
        throw new NoRouteToHostException("Cross-domain redirects are disallowed");
      }
      if (i != 307)
      {
        this.mURL = ((URL)localObject2);
        break label806;
        label623:
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
            label706:
            throw new ProtocolException();
            if (i != 200) {
              throw new IOException("failed! status code: " + i);
            }
          }
          this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
          this.mCurrentOffset = paramLong;
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          break label706;
        }
      }
    }
  }
  
  private void teardownConnection()
  {
    if (this.mConnection != null)
    {
      this.mInputStream = null;
      this.mConnection.disconnect();
      this.mConnection = null;
      this.mCurrentOffset = -1L;
    }
  }
  
  public boolean connect(URL paramURL, Map<String, String> paramMap)
  {
    disconnect();
    this.mAllowCrossDomainRedirect = true;
    this.mURL = paramURL;
    this.mHeaders = paramMap;
    return true;
  }
  
  public void disconnect()
  {
    teardownConnection();
    this.mHeaders = null;
    this.mURL = null;
  }
  
  public String getMIMEType()
  {
    if (this.mConnection == null) {}
    try
    {
      seekTo(0L);
      return this.mConnection.getContentType();
    }
    catch (IOException localIOException)
    {
      Logger.e("MediaHTTPConnection", "getMIMEType", localIOException);
    }
    return "application/octet-stream";
  }
  
  public long getSize()
  {
    if (this.mConnection == null) {}
    try
    {
      seekTo(0L);
      return this.mTotalSize;
    }
    catch (IOException localIOException)
    {
      Logger.e("MediaHTTPConnection", "getSize", localIOException);
    }
    return -1L;
  }
  
  public String getUri()
  {
    return this.mURL.toString();
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
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
      return paramInt1;
    }
    catch (ProtocolException paramArrayOfByte)
    {
      Logger.w("MediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
      return -1010;
    }
    catch (NoRouteToHostException paramArrayOfByte)
    {
      Logger.w("MediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
      return -1010;
    }
    catch (UnknownServiceException paramArrayOfByte)
    {
      Logger.w("MediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
      return -1010;
    }
    catch (IOException paramArrayOfByte)
    {
      return -2;
    }
    catch (Exception paramArrayOfByte) {}
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPConnection
 * JD-Core Version:    0.7.0.1
 */