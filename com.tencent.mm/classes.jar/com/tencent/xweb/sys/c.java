package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.xweb.m;
import org.xwalk.core.Log;

public final class c
{
  public static WebResourceResponse a(m paramm)
  {
    WebResourceResponse localWebResourceResponse1;
    if (paramm == null) {
      localWebResourceResponse1 = null;
    }
    WebResourceResponse localWebResourceResponse2;
    do
    {
      return localWebResourceResponse1;
      if ((paramm.xgV) && (Build.VERSION.SDK_INT >= 21)) {
        try
        {
          localWebResourceResponse1 = new WebResourceResponse(paramm.mMimeType, paramm.mEncoding, paramm.mStatusCode, paramm.mReasonPhrase, paramm.mResponseHeaders, paramm.mInputStream);
          return localWebResourceResponse1;
        }
        catch (Exception localException)
        {
          Log.e("SysWebDataTrans", "create webkit WebResourceResponse error :" + localException.getMessage());
        }
      }
      localWebResourceResponse2 = new WebResourceResponse(paramm.mMimeType, paramm.mEncoding, paramm.mInputStream);
      Object localObject = localWebResourceResponse2;
    } while (Build.VERSION.SDK_INT < 21);
    if ((paramm.mStatusCode > 100) && (paramm.mReasonPhrase != null) && (!paramm.mReasonPhrase.isEmpty())) {
      localWebResourceResponse2.setStatusCodeAndReasonPhrase(paramm.mStatusCode, paramm.mReasonPhrase);
    }
    localWebResourceResponse2.setResponseHeaders(paramm.mResponseHeaders);
    return localWebResourceResponse2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.sys.c
 * JD-Core Version:    0.7.0.1
 */