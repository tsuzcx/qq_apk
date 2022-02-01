package com.tencent.xweb.pinus;

import android.os.Build.VERSION;
import android.webkit.SslErrorHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.t;
import org.xwalk.core.Log;

public final class g
{
  public static android.webkit.WebResourceResponse a(com.tencent.xweb.WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(213341);
    if (paramWebResourceResponse == null)
    {
      AppMethodBeat.o(213341);
      return null;
    }
    if ((paramWebResourceResponse.aifn) && (Build.VERSION.SDK_INT >= 21)) {
      try
      {
        android.webkit.WebResourceResponse localWebResourceResponse1 = new android.webkit.WebResourceResponse(paramWebResourceResponse.mMimeType, paramWebResourceResponse.mEncoding, paramWebResourceResponse.mStatusCode, paramWebResourceResponse.mReasonPhrase, paramWebResourceResponse.mResponseHeaders, paramWebResourceResponse.mInputStream);
        AppMethodBeat.o(213341);
        return localWebResourceResponse1;
      }
      finally
      {
        Log.e("PinusWebDataTrans", "create webkit WebResourceResponse error:" + localObject + ", statusCode:" + paramWebResourceResponse.mStatusCode);
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
    AppMethodBeat.o(213341);
    return localWebResourceResponse2;
  }
  
  public static final class e
    implements t
  {
    SslErrorHandler aiky;
    
    public e(SslErrorHandler paramSslErrorHandler)
    {
      this.aiky = paramSslErrorHandler;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(213289);
      this.aiky.cancel();
      AppMethodBeat.o(213289);
    }
    
    public final void proceed()
    {
      AppMethodBeat.i(213280);
      this.aiky.proceed();
      AppMethodBeat.o(213280);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.pinus.g
 * JD-Core Version:    0.7.0.1
 */