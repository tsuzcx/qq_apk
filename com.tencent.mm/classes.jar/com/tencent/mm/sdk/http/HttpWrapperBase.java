package com.tencent.mm.sdk.http;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class HttpWrapperBase
{
  protected static final String ACCEPT_ENCODING = "compress;q=0.5, gzip;q=1.0";
  protected static final String CHARSET = "utf-8";
  public static final int METHOD_GET = 0;
  public static final int METHOD_POST = 1;
  public static final String PROTOCAL_HTTP = "http://";
  public static final String PROTOCAL_HTTPS = "https://";
  private static final String TAG = "MicroMsg.HttpWrapperBase";
  protected final String userAgent = "weixin/android";
  
  public static String getCookie(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(URLEncoder.encode(str, "utf-8")).append('=').append(URLEncoder.encode((String)paramMap.get(str), "utf-8"));
      i += 1;
      if (paramMap.size() > i) {
        localStringBuilder.append("; ");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static Map<String, String> parseCookie(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return localHashMap;
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length == 2) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
  }
  
  public void asyncSend(final HttpWrapperBase.Request paramRequest, final Response paramResponse, final MMHandler paramMMHandler)
  {
    ThreadPool.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(157521);
        HttpWrapperBase.this.send(paramRequest, paramResponse);
        if (paramMMHandler != null)
        {
          paramMMHandler.post(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(157520);
              HttpWrapperBase.1.this.val$response.onComplete();
              AppMethodBeat.o(157520);
            }
          });
          AppMethodBeat.o(157521);
          return;
        }
        paramResponse.onComplete();
        AppMethodBeat.o(157521);
      }
    }, getClass().getName());
  }
  
  public abstract void cancel();
  
  public abstract void send(HttpWrapperBase.Request paramRequest, Response paramResponse);
  
  public static class Attachment
  {
    public String filePath;
    public String param;
    
    public Attachment(String paramString1, String paramString2)
    {
      this.param = paramString1;
      this.filePath = paramString2;
    }
  }
  
  public static class Response
  {
    public HttpWrapperBase.Attachment attachment;
    public String content;
    public long contentLength;
    public Map<String, String> cookie;
    public int status = 0;
    
    public Response(int paramInt, Map<String, String> paramMap, String paramString)
    {
      this.status = paramInt;
      this.cookie = paramMap;
      this.content = paramString;
    }
    
    public void onComplete() {}
    
    public String toString()
    {
      AppMethodBeat.i(157524);
      StringBuilder localStringBuilder = new StringBuilder("Response status:").append(this.status).append(", cookie:");
      Object localObject;
      if (this.cookie != null)
      {
        localObject = this.cookie;
        localObject = localStringBuilder.append(localObject).append(", content length :");
        if (this.content == null) {
          break label87;
        }
      }
      label87:
      for (int i = this.content.length();; i = 0)
      {
        localObject = i;
        AppMethodBeat.o(157524);
        return localObject;
        localObject = "";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.http.HttpWrapperBase
 * JD-Core Version:    0.7.0.1
 */