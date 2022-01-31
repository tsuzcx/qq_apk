package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.MMActivity;

final class g$128
  implements Runnable
{
  g$128(g paramg, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(155041);
    Intent localIntent = new Intent();
    localIntent.putExtra("scene_from", 4);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    localIntent.putExtra("Retr_Msg_thumb_path", this.iiy);
    localIntent.putExtra("emoji_activity_id", this.vrD);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
    if ((g.j(this.vqm) instanceof MMActivity)) {
      d.a((MMActivity)g.j(this.vqm), ".ui.transmit.SelectConversationUI", localIntent, 52, this.vqm);
    }
    AppMethodBeat.o(155041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.128
 * JD-Core Version:    0.7.0.1
 */