package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.b;

final class WebViewUI$23
  implements View.OnLongClickListener
{
  WebViewUI$23(WebViewUI paramWebViewUI) {}
  
  private boolean deO()
  {
    boolean bool2 = true;
    AppMethodBeat.i(153236);
    Object localObject = null;
    try
    {
      WebView.b localb = this.vgz.pOd.getHitTestResult();
      localObject = localb;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewUI", "getHitTestResult exp %s", new Object[] { localException1.getMessage() });
      }
    }
    if ((localObject == null) || (bo.isNullOrNil(localObject.mExtra)))
    {
      ab.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
      AppMethodBeat.o(153236);
      return false;
    }
    try
    {
      bool1 = this.vgz.igU.dM(localObject.mExtra);
      if (!bool1) {}
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        label137:
        boolean bool1 = true;
        ab.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + localException2.getMessage());
      }
    }
    try
    {
      this.vgz.igU.dO(localObject.mExtra, this.vgz.hashCode());
      if (bool1) {
        break label181;
      }
      WebViewUI.b(this.vgz, localObject.mExtra);
      bool1 = bool2;
    }
    catch (Exception localException3)
    {
      break label148;
      break label137;
    }
    AppMethodBeat.o(153236);
    return bool1;
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(153235);
    if (this.vgz.getIntent().getBooleanExtra("show_long_click_popup_menu", true))
    {
      boolean bool = deO();
      AppMethodBeat.o(153235);
      return bool;
    }
    AppMethodBeat.o(153235);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23
 * JD-Core Version:    0.7.0.1
 */