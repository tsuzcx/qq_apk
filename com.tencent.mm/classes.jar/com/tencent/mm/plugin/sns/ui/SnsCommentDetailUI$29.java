package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsCommentDetailUI$29
  implements View.OnClickListener
{
  SnsCommentDetailUI$29(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn) {}
  
  public final void onClick(View paramView)
  {
    if (!m.Nj(this.oNX.bGE()))
    {
      a.e(this.oWW.mController.uMN, this.oWW.oWS.yD(0));
      return;
    }
    SnsCommentDetailUI.b(this.oWW).setCommentInfo(null);
    SnsCommentDetailUI.b(this.oWW).setCommentFlag(0);
    SnsCommentDetailUI.b(this.oWW).setCommentHint(this.oWW.getString(i.j.sns_ui_comment));
    SnsCommentDetailUI.b(this.oWW).setCommentInfo(new btd());
    SnsCommentDetailUI.b(this.oWW).jw(true);
    if ((this.oNX.yr(32)) && ((this.oNX.bGe().tNr.sPK & 0x8) != 0)) {
      SnsCommentDetailUI.b(this.oWW).jx(true);
    }
    for (;;)
    {
      SnsCommentDetailUI.F(this.oWW).setVisibility(8);
      SnsCommentDetailUI.y(this.oWW);
      return;
      SnsCommentDetailUI.b(this.oWW).jx(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.29
 * JD-Core Version:    0.7.0.1
 */