package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;

final class SnsCommentDetailUI$37
  implements h.c
{
  SnsCommentDetailUI$37(SnsCommentDetailUI paramSnsCommentDetailUI, Object[] paramArrayOfObject) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    SnsCommentDetailUI.b(this.oWW).bIL();
    SnsCommentDetailUI.b(this.oWW).setCommentHint(this.oWW.getString(i.j.sns_reply) + this.oXn[3]);
    SnsCommentDetailUI.b(this.oWW).setCommentInfo((btd)this.oXn[1]);
    SnsCommentDetailUI.b(this.oWW).jx(false);
    SnsCommentDetailUI.b(this.oWW).jw(true);
    int i = ((Integer)this.oXn[0]).intValue();
    paramInt = i;
    if (aj.q(h.OB(SnsCommentDetailUI.k(this.oWW))).tJY.size() > 0)
    {
      i += 1;
      paramInt = i;
      if (i > SnsCommentDetailUI.l(this.oWW).getCount()) {
        paramInt = SnsCommentDetailUI.l(this.oWW).getCount() - 1;
      }
    }
    SnsCommentDetailUI.m(this.oWW).Ln = paramInt;
    SnsCommentDetailUI.m(this.oWW).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.37
 * JD-Core Version:    0.7.0.1
 */