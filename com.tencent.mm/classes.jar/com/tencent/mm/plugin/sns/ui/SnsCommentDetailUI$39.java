package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;

final class SnsCommentDetailUI$39
  implements h.c
{
  SnsCommentDetailUI$39(SnsCommentDetailUI paramSnsCommentDetailUI, Object[] paramArrayOfObject) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(38824);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38824);
      return;
      SnsCommentDetailUI.c(this.rPu).rQa = 0;
      SnsCommentDetailUI.c(this.rPu).cvf();
      SnsCommentDetailUI.c(this.rPu).setCommentHint(this.rPu.getString(2131303938) + this.rPL[3]);
      SnsCommentDetailUI.c(this.rPu).setCommentInfo((cds)this.rPL[1]);
      SnsCommentDetailUI.c(this.rPu).lD(false);
      SnsCommentDetailUI.c(this.rPu).lC(true);
      int i = ((Integer)this.rPL[0]).intValue();
      paramInt = i;
      if (ak.q(h.abv(SnsCommentDetailUI.k(this.rPu))).LikeUserList.size() > 0)
      {
        i += 1;
        paramInt = i;
        if (i > SnsCommentDetailUI.l(this.rPu).getCount()) {
          paramInt = SnsCommentDetailUI.l(this.rPu).getCount() - 1;
        }
      }
      SnsCommentDetailUI.m(this.rPu).KY = paramInt;
      SnsCommentDetailUI.m(this.rPu).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.39
 * JD-Core Version:    0.7.0.1
 */