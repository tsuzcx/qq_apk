package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.JsPromptResult;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.i;
import com.tencent.xweb.s;
import org.xwalk.core.Log;

public final class c
{
  public static WebResourceResponse a(s params)
  {
    AppMethodBeat.i(84659);
    if (params == null)
    {
      AppMethodBeat.o(84659);
      return null;
    }
    if ((params.BDU) && (Build.VERSION.SDK_INT >= 21)) {
      try
      {
        WebResourceResponse localWebResourceResponse1 = new WebResourceResponse(params.mMimeType, params.mEncoding, params.mStatusCode, params.mReasonPhrase, params.mResponseHeaders, params.mInputStream);
        AppMethodBeat.o(84659);
        return localWebResourceResponse1;
      }
      catch (Exception localException)
      {
        Log.e("SysWebDataTrans", "create webkit WebResourceResponse error :" + localException.getMessage());
      }
    }
    WebResourceResponse localWebResourceResponse2 = new WebResourceResponse(params.mMimeType, params.mEncoding, params.mInputStream);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((params.mStatusCode > 100) && (params.mReasonPhrase != null) && (!params.mReasonPhrase.isEmpty())) {
        localWebResourceResponse2.setStatusCodeAndReasonPhrase(params.mStatusCode, params.mReasonPhrase);
      }
      localWebResourceResponse2.setResponseHeaders(params.mResponseHeaders);
    }
    AppMethodBeat.o(84659);
    return localWebResourceResponse2;
  }
  
  public static final class c
    extends i
  {
    public JsPromptResult BHk;
    
    public c(JsPromptResult paramJsPromptResult)
    {
      this.BHk = paramJsPromptResult;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(84655);
      if (this.BHk != null) {
        this.BHk.cancel();
      }
      AppMethodBeat.o(84655);
    }
    
    public final void confirm()
    {
      AppMethodBeat.i(84654);
      if (this.BHk != null) {
        this.BHk.confirm();
      }
      AppMethodBeat.o(84654);
    }
    
    public final void confirmWithResult(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c
 * JD-Core Version:    0.7.0.1
 */