package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class FTSSOSHomeWebViewUI$9
  implements View.OnClickListener
{
  FTSSOSHomeWebViewUI$9(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(211249);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jos, "android.permission.RECORD_AUDIO", 80, "", "");
    Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.Jos });
    if (!bool)
    {
      a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211249);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("sessionId", this.Jos.sessionId);
    paramView.putExtra("subSessionId", this.Jos.dVO);
    paramView.putExtra("key_scene", this.Jos.scene);
    if (this.Jos.ggO()) {}
    for (int i = 1;; i = 2)
    {
      paramView.putExtra("key_is_nav_voice", i);
      c.c(this.Jos, ".ui.websearch.WebSearchVoiceUI", paramView, 1);
      this.Jos.overridePendingTransition(0, 0);
      a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211249);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.9
 * JD-Core Version:    0.7.0.1
 */