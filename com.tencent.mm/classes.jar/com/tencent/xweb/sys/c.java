package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.SslErrorHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.t;
import org.xwalk.core.Log;

public final class c
{
  public static android.webkit.WebResourceResponse a(com.tencent.xweb.WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(153667);
    if (paramWebResourceResponse == null)
    {
      AppMethodBeat.o(153667);
      return null;
    }
    if ((paramWebResourceResponse.aifn) && (Build.VERSION.SDK_INT >= 21)) {
      try
      {
        android.webkit.WebResourceResponse localWebResourceResponse1 = new android.webkit.WebResourceResponse(paramWebResourceResponse.mMimeType, paramWebResourceResponse.mEncoding, paramWebResourceResponse.mStatusCode, paramWebResourceResponse.mReasonPhrase, paramWebResourceResponse.mResponseHeaders, paramWebResourceResponse.mInputStream);
        AppMethodBeat.o(153667);
        return localWebResourceResponse1;
      }
      finally
      {
        Log.e("SysWebDataTrans", "create webkit WebResourceResponse error:".concat(String.valueOf(localObject)));
      }
    }
    android.webkit.WebResourceResponse localWebResourceResponse2 = new android.webkit.WebResourceResponse(paramWebResourceResponse.mMimeType, paramWebResourceResponse.mEncoding, paramWebResourceResponse.mInputStream);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramWebResourceResponse.mStatusCode > 100) && (paramWebResourceResponse.mReasonPhrase != null) && (!paramWebResourceResponse.mReasonPhrase.isEmpty())) {
        localWebResourceResponse2.setStatusCodeAndReasonPhrase(paramWebResourceResponse.mStatusCode, paramWebResourceResponse.mReasonPhrase);
      }
      localWebResourceResponse2.setResponseHeaders(paramWebResourceResponse.mResponseHeaders);
    }
    AppMethodBeat.o(153667);
    return localWebResourceResponse2;
  }
  
  public static final class a
    implements t
  {
    SslErrorHandler aiky;
    
    public a(SslErrorHandler paramSslErrorHandler)
    {
      this.aiky = paramSslErrorHandler;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(153658);
      this.aiky.cancel();
      AppMethodBeat.o(153658);
    }
    
    public final void proceed()
    {
      AppMethodBeat.i(153657);
      this.aiky.proceed();
      AppMethodBeat.o(153657);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.sys.c
 * JD-Core Version:    0.7.0.1
 */