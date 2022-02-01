package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.h.c;

final class SnsStrangerCommentDetailUI$6
  implements h.c
{
  SnsStrangerCommentDetailUI$6(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI) {}
  
  public final void lh(int paramInt)
  {
    AppMethodBeat.i(99144);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99144);
      return;
      if (SnsStrangerCommentDetailUI.c(this.AAw).adv())
      {
        x.u(SnsStrangerCommentDetailUI.c(this.AAw));
        SnsStrangerCommentDetailUI.c(this.AAw).acV();
        a.iUA.MM();
        AppMethodBeat.o(99144);
        return;
      }
      x.t(SnsStrangerCommentDetailUI.c(this.AAw));
      SnsStrangerCommentDetailUI.c(this.AAw).acU();
      a.iUA.MM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.6
 * JD-Core Version:    0.7.0.1
 */