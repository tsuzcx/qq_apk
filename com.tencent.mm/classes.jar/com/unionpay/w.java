package com.unionpay;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.unionpay.utils.j;

final class w
  extends WebViewClient
{
  private w(b paramb) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(207255);
    j.kkB();
    AppMethodBeat.o(207255);
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(207272);
    "shouldOverrideUrlLoading：".concat(String.valueOf(paramString));
    j.kkB();
    if ((b.a(this.aisX)) && (!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("http"))) {
      try
      {
        Object localObject = new Intent();
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        ((Intent)localObject).setData(Uri.parse(paramString));
        Activity localActivity = this.aisX.mContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/unionpay/u", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/unionpay/u", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(207272);
        return true;
      }
      catch (Exception localException) {}
    }
    boolean bool = super.shouldOverrideUrlLoading(paramWebView, paramString);
    AppMethodBeat.o(207272);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.w
 * JD-Core Version:    0.7.0.1
 */