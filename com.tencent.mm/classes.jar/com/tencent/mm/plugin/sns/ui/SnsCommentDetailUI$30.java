package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.vi;

final class SnsCommentDetailUI$30
  implements View.OnClickListener
{
  SnsCommentDetailUI$30(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38813);
    if (!m.ZV(this.rFG.csH()))
    {
      a.f(this.rPu.getContext(), this.rPu.rPq.EJ(0));
      AppMethodBeat.o(38813);
      return;
    }
    SnsCommentDetailUI.c(this.rPu).setCommentInfo(null);
    SnsCommentDetailUI.c(this.rPu).setCommentFlag(0);
    SnsCommentDetailUI.c(this.rPu).setCommentHint(this.rPu.getString(2131304029));
    SnsCommentDetailUI.c(this.rPu).setCommentInfo(new cds());
    SnsCommentDetailUI.c(this.rPu).lC(true);
    if ((this.rFG.Ex(32)) && ((this.rFG.csh().xTS.wOb & 0x8) != 0)) {
      SnsCommentDetailUI.c(this.rPu).lD(true);
    }
    for (;;)
    {
      SnsCommentDetailUI.E(this.rPu).setVisibility(8);
      SnsCommentDetailUI.z(this.rPu);
      AppMethodBeat.o(38813);
      return;
      SnsCommentDetailUI.c(this.rPu).lD(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.30
 * JD-Core Version:    0.7.0.1
 */