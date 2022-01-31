package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class FTSSOSHomeWebViewUI$15
  implements View.OnClickListener
{
  FTSSOSHomeWebViewUI$15(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    int i = 2;
    AppMethodBeat.i(153299);
    boolean bool = b.a(this.vkS, "android.permission.RECORD_AUDIO", 80, "", "");
    ab.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.vkS });
    if (!bool)
    {
      AppMethodBeat.o(153299);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("sessionId", this.vkS.cpW);
    paramView.putExtra("subSessionId", this.vkS.cCW);
    paramView.putExtra("key_scene", this.vkS.scene);
    if (this.vkS.dfE()) {
      i = 1;
    }
    paramView.putExtra("key_is_nav_voice", i);
    d.b(this.vkS, ".ui.websearch.WebSearchVoiceUI", paramView, 1);
    this.vkS.overridePendingTransition(0, 0);
    AppMethodBeat.o(153299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.15
 * JD-Core Version:    0.7.0.1
 */