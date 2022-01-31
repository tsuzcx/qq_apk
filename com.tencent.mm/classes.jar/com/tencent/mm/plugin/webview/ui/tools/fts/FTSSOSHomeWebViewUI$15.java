package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FTSSOSHomeWebViewUI$15
  implements View.OnClickListener
{
  FTSSOSHomeWebViewUI$15(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    int i = 2;
    boolean bool = a.a(this.ruD, "android.permission.RECORD_AUDIO", 80, "", "");
    y.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.ruD });
    if (!bool) {
      return;
    }
    paramView = new Intent();
    paramView.putExtra("sessionId", this.ruD.bIB);
    paramView.putExtra("subSessionId", this.ruD.bVp);
    paramView.putExtra("key_scene", this.ruD.scene);
    if (this.ruD.ruj.cfG()) {
      i = 1;
    }
    paramView.putExtra("key_is_nav_voice", i);
    paramView.setClass(this.ruD, WebSearchVoiceUI.class);
    this.ruD.startActivityForResult(paramView, 1);
    this.ruD.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.15
 * JD-Core Version:    0.7.0.1
 */