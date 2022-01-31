package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.b;

final class WebViewUI$25
  implements View.OnLongClickListener
{
  WebViewUI$25(WebViewUI paramWebViewUI) {}
  
  private boolean cVr()
  {
    localObject = null;
    try
    {
      WebView.b localb = this.rpH.niQ.getHitTestResult();
      localObject = localb;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        y.e("MicroMsg.WebViewUI", "getHitTestResult exp %s", new Object[] { localException1.getMessage() });
      }
      try
      {
        boolean bool = this.rpH.gGn.cz(localObject.mExtra);
        if (!bool) {
          break label104;
        }
        return bool;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          try
          {
            this.rpH.gGn.cP(localObject.mExtra, this.rpH.hashCode());
            if (bool) {
              return bool;
            }
            WebViewUI.d(this.rpH, localObject.mExtra);
            return true;
          }
          catch (Exception localException3)
          {
            continue;
          }
          localException2 = localException2;
          bool = true;
          y.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + localException2.getMessage());
        }
      }
    }
    if ((localObject == null) || (bk.bl(localObject.mExtra)))
    {
      y.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
      return false;
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    boolean bool = true;
    if (this.rpH.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
      bool = cVr();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.25
 * JD-Core Version:    0.7.0.1
 */