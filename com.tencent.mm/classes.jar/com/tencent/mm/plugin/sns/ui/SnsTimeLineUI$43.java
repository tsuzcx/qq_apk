package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.k.c.b;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.vending.app.a;

final class SnsTimeLineUI$43
  implements View.OnClickListener
{
  SnsTimeLineUI$43(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155755);
    if ((SnsTimeLineUI.i(this.rYv) != null) && (SnsTimeLineUI.i(this.rYv).rFl != null)) {
      SnsTimeLineUI.i(this.rYv).rFl.rhS.lf(true);
    }
    paramView = (c.b)this.rYv.SF().m(c.b.class);
    com.tencent.mm.modelsns.b localb = com.tencent.mm.modelsns.b.lV(725);
    localb.lY(paramView.snz);
    localb.ake();
    paramView = new Intent();
    paramView.setClass(this.rYv, SnsMsgUI.class);
    paramView.putExtra("sns_msg_comment_list_scene", 1);
    this.rYv.startActivityForResult(paramView, 13);
    AppMethodBeat.o(155755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.43
 * JD-Core Version:    0.7.0.1
 */