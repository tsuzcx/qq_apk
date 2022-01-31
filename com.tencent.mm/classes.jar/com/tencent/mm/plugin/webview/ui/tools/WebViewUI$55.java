package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.d;

final class WebViewUI$55
  implements h.d
{
  WebViewUI$55(WebViewUI paramWebViewUI) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      y.i("MicroMsg.WebViewUI", "do del cancel");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("fav_local_id", this.rpH.getIntent().getLongExtra("fav_local_id", -1L));
    try
    {
      if (this.rpH.gGn.R(localBundle))
      {
        y.i("MicroMsg.WebViewUI", "del fav web url ok, finish webview ui");
        this.rpH.rfg.n("mm_del_fav", Boolean.valueOf(true));
        this.rpH.finish();
        return;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.WebViewUI", localException, "", new Object[0]);
      y.e("MicroMsg.WebViewUI", "try to del web url crash");
      return;
    }
    y.w("MicroMsg.WebViewUI", "try to del web url fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.55
 * JD-Core Version:    0.7.0.1
 */