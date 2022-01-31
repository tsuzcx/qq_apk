package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.R.a;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;

final class g$118
  implements Runnable
{
  g$118(g paramg, String paramString1, String paramString2) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("scene_from", 4);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    localIntent.putExtra("Retr_Msg_thumb_path", this.grU);
    localIntent.putExtra("emoji_activity_id", this.rAA);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
    if ((g.i(this.rzi) instanceof MMActivity)) {
      d.a((MMActivity)g.i(this.rzi), ".ui.transmit.SelectConversationUI", localIntent, 52, this.rzi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.118
 * JD-Core Version:    0.7.0.1
 */