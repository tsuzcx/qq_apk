package com.unionpay;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t
  extends WebChromeClient
{
  private t(b paramb) {}
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return true;
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(207290);
    paramJsResult.cancel();
    Toast.makeText(this.aisX.mContext, paramString2, 0).show();
    AppMethodBeat.o(207290);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.t
 * JD-Core Version:    0.7.0.1
 */