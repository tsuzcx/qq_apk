package com.tencent.thumbplayer.core.drm.httpclient;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Map;

public class Request
  implements Comparable<Request>
{
  private static final int DEFAULT_TIMEOUT_MILLIS = 8000;
  private boolean mCanceled;
  private final int mDefaultTrafficStatsTag;
  private final Map<String, String> mHttpHeaders;
  private int mHttpMethod;
  private final Object mLock;
  private final byte[] mPostBody;
  private NetworkRequestCompleteListener mRequestCompleteListener;
  private Integer mSequence;
  private Object mTag;
  private final int mTimeoutMs;
  private final String mUrl;
  
  public Request(int paramInt, String paramString, NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    this(paramInt, paramString, null, 8000, paramNetworkRequestCompleteListener);
  }
  
  public Request(int paramInt1, String paramString, Map<String, String> paramMap, int paramInt2, NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    this(paramInt1, paramString, paramMap, null, paramInt2, paramNetworkRequestCompleteListener);
  }
  
  public Request(int paramInt1, String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt2, NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    AppMethodBeat.i(220646);
    this.mLock = new Object();
    this.mCanceled = false;
    this.mHttpMethod = paramInt1;
    this.mUrl = paramString;
    this.mPostBody = paramArrayOfByte;
    if (paramInt2 > 0) {}
    for (;;)
    {
      this.mTimeoutMs = paramInt2;
      this.mHttpHeaders = paramMap;
      this.mRequestCompleteListener = paramNetworkRequestCompleteListener;
      this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(paramString);
      AppMethodBeat.o(220646);
      return;
      paramInt2 = 8000;
    }
  }
  
  private static int findDefaultTrafficStatsTag(String paramString)
  {
    AppMethodBeat.i(220647);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString != null)
        {
          int i = paramString.hashCode();
          AppMethodBeat.o(220647);
          return i;
        }
      }
    }
    AppMethodBeat.o(220647);
    return 0;
  }
  
  public void cancel()
  {
    synchronized (this.mLock)
    {
      this.mCanceled = true;
      this.mRequestCompleteListener = null;
      return;
    }
  }
  
  public int compareTo(Request paramRequest)
  {
    AppMethodBeat.i(220651);
    Request.Priority localPriority1 = getPriority();
    Request.Priority localPriority2 = paramRequest.getPriority();
    if (localPriority1 == localPriority2)
    {
      i = this.mSequence.intValue();
      j = paramRequest.mSequence.intValue();
      AppMethodBeat.o(220651);
      return i - j;
    }
    int i = localPriority2.ordinal();
    int j = localPriority1.ordinal();
    AppMethodBeat.o(220651);
    return i - j;
  }
  
  public void deliverError(IOException paramIOException)
  {
    AppMethodBeat.i(220650);
    synchronized (this.mLock)
    {
      NetworkRequestCompleteListener localNetworkRequestCompleteListener = this.mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null) {
        localNetworkRequestCompleteListener.onErrorResponse(this, paramIOException);
      }
      AppMethodBeat.o(220650);
      return;
    }
  }
  
  public void deliverResponse(Response paramResponse)
  {
    AppMethodBeat.i(220649);
    synchronized (this.mLock)
    {
      NetworkRequestCompleteListener localNetworkRequestCompleteListener = this.mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null) {
        localNetworkRequestCompleteListener.onResponseReceived(this, paramResponse);
      }
      AppMethodBeat.o(220649);
      return;
    }
  }
  
  public Map<String, String> getHeaders()
  {
    return this.mHttpHeaders;
  }
  
  public int getHttpMethod()
  {
    return this.mHttpMethod;
  }
  
  public byte[] getPostBody()
  {
    return this.mPostBody;
  }
  
  public Request.Priority getPriority()
  {
    return Request.Priority.NORMAL;
  }
  
  public final int getSequence()
  {
    AppMethodBeat.i(220648);
    if (this.mSequence == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("getSequence called before setSequence");
      AppMethodBeat.o(220648);
      throw localIllegalStateException;
    }
    int i = this.mSequence.intValue();
    AppMethodBeat.o(220648);
    return i;
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public int getTimeoutMs()
  {
    return this.mTimeoutMs;
  }
  
  public int getTrafficStatsTag()
  {
    return this.mDefaultTrafficStatsTag;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public boolean isCanceled()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.mCanceled;
      return bool;
    }
  }
  
  public Request setTag(Object paramObject)
  {
    this.mTag = paramObject;
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(220652);
    String str2 = "0x" + Integer.toHexString(getTrafficStatsTag());
    StringBuilder localStringBuilder = new StringBuilder();
    if (isCanceled()) {}
    for (String str1 = "[X] ";; str1 = "[ ] ")
    {
      str1 = str1 + getUrl() + " " + str2 + " " + getPriority() + " " + this.mSequence;
      AppMethodBeat.o(220652);
      return str1;
    }
  }
  
  public static abstract interface NetworkRequestCompleteListener
  {
    public abstract void onErrorResponse(Request paramRequest, IOException paramIOException);
    
    public abstract void onResponseReceived(Request paramRequest, Response paramResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Request
 * JD-Core Version:    0.7.0.1
 */