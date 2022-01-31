package com.tencent.xweb.x5;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.s;
import org.xwalk.core.Log;

public final class a
{
  public static WebResourceResponse b(s params)
  {
    AppMethodBeat.i(84795);
    if (params == null)
    {
      AppMethodBeat.o(84795);
      return null;
    }
    if ((params.BDU) && (Build.VERSION.SDK_INT >= 21)) {
      try
      {
        WebResourceResponse localWebResourceResponse1 = new WebResourceResponse(params.mMimeType, params.mEncoding, params.mStatusCode, params.mReasonPhrase, params.mResponseHeaders, params.mInputStream);
        AppMethodBeat.o(84795);
        return localWebResourceResponse1;
      }
      catch (Exception localException)
      {
        Log.e("SysWebDataTrans", "create webkit WebResourceResponse error :" + localException.getMessage());
      }
    }
    WebResourceResponse localWebResourceResponse2 = new WebResourceResponse(params.mMimeType, params.mEncoding, params.mInputStream);
    if ((params.mStatusCode > 100) && (params.mReasonPhrase != null) && (!params.mReasonPhrase.isEmpty())) {
      localWebResourceResponse2.setStatusCodeAndReasonPhrase(params.mStatusCode, params.mReasonPhrase);
    }
    localWebResourceResponse2.setResponseHeaders(params.mResponseHeaders);
    AppMethodBeat.o(84795);
    return localWebResourceResponse2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.a
 * JD-Core Version:    0.7.0.1
 */