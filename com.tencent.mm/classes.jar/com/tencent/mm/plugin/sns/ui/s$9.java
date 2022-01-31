package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;

final class s$9
  implements View.OnClickListener
{
  s$9(s params, n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(145457);
    ab.i("MicroMsg.GalleryTitleManager", "request deal QBAR string");
    if (this.rHr.rHk.isShowing()) {
      this.rHr.rHk.cre();
    }
    paramView = new Bundle();
    paramView.putString("stat_msg_id", "sns_" + i.lq(this.rHq.field_snsId));
    paramView.putString("stat_send_msg_user", this.rHq.field_userName);
    paramView.putInt("stat_scene", 3);
    s locals = this.rHr;
    ab.i("MicroMsg.GalleryTitleManager", "request deal QBAR string");
    cg localcg = new cg();
    localcg.cpD.activity = ((Activity)locals.context);
    localcg.cpD.cnR = locals.rGz;
    localcg.cpD.cpE = locals.cpE;
    localcg.cpD.cpF = locals.cpF;
    localcg.cpD.cpJ = paramView;
    a.ymk.l(localcg);
    AppMethodBeat.o(145457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s.9
 * JD-Core Version:    0.7.0.1
 */