package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsCommentDetailUI$14
  implements SnsCommentFooter.c
{
  SnsCommentDetailUI$14(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn) {}
  
  public final void OZ(String paramString)
  {
    int j = 8;
    if (!m.Nj(this.oNX.bGE()))
    {
      if (this.oWW.oWS.yD(0) != null) {
        a.e(this.oWW.mController.uMN, this.oWW.oWS.yD(0));
      }
      return;
    }
    if (this.oNX.yr(32)) {}
    for (int i = SnsCommentDetailUI.b(this.oWW).getCommentFlag();; i = 0)
    {
      if (i == 8)
      {
        paramString = paramString.substring(SnsCommentDetailUI.b(this.oWW).getCommentAtPrefix().length());
        am.a.a(this.oNX, 16, paramString, SnsCommentDetailUI.b(this.oWW).getCommentInfo(), i, SnsCommentDetailUI.f(this.oWW));
        SnsCommentDetailUI.b(this.oWW).setText("");
        SnsCommentDetailUI.b(this.oWW).jw(false);
        y.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
        SnsCommentDetailUI.w(this.oWW);
        return;
      }
      n localn = this.oNX;
      if (this.oNX.yr(32)) {}
      for (;;)
      {
        am.a.a(localn, j, paramString, SnsCommentDetailUI.b(this.oWW).getCommentInfo(), i, SnsCommentDetailUI.f(this.oWW));
        break;
        j = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.14
 * JD-Core Version:    0.7.0.1
 */