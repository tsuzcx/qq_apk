package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsCommentDetailUI$11
  implements SnsCommentFooter.a
{
  SnsCommentDetailUI$11(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn) {}
  
  public final void bIG()
  {
    if (!m.Nj(this.oNX.bGE())) {
      if ((SnsCommentDetailUI.x(this.oWW) == null) || (!SnsCommentDetailUI.x(this.oWW).isShowing())) {}
    }
    while ((this.oWW.mController.uNh == 1) || (SnsCommentDetailUI.b(this.oWW).bIJ()))
    {
      return;
      SnsCommentDetailUI.a(this.oWW, a.e(this.oWW.mController.uMN, this.oWW.oWS.yD(0)));
      return;
    }
    SnsCommentDetailUI.y(this.oWW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.11
 * JD-Core Version:    0.7.0.1
 */