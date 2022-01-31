package com.tencent.xweb.x5;

import android.os.Build.VERSION;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.m;
import org.xwalk.core.Log;

public final class a
{
  public static WebResourceResponse b(m paramm)
  {
    if (paramm == null) {
      return null;
    }
    if ((paramm.xgV) && (Build.VERSION.SDK_INT >= 21)) {
      try
      {
        WebResourceResponse localWebResourceResponse1 = new WebResourceResponse(paramm.mMimeType, paramm.mEncoding, paramm.mStatusCode, paramm.mReasonPhrase, paramm.mResponseHeaders, paramm.mInputStream);
        return localWebResourceResponse1;
      }
      catch (Exception localException)
      {
        Log.e("SysWebDataTrans", "create webkit WebResourceResponse error :" + localException.getMessage());
      }
    }
    WebResourceResponse localWebResourceResponse2 = new WebResourceResponse(paramm.mMimeType, paramm.mEncoding, paramm.mInputStream);
    if ((paramm.mStatusCode > 100) && (paramm.mReasonPhrase != null) && (!paramm.mReasonPhrase.isEmpty())) {
      localWebResourceResponse2.setStatusCodeAndReasonPhrase(paramm.mStatusCode, paramm.mReasonPhrase);
    }
    localWebResourceResponse2.setResponseHeaders(paramm.mResponseHeaders);
    return localWebResourceResponse2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.a
 * JD-Core Version:    0.7.0.1
 */