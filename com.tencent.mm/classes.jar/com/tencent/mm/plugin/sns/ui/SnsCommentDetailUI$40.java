package com.tencent.mm.plugin.sns.ui;

import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

final class SnsCommentDetailUI$40
  implements h.c
{
  SnsCommentDetailUI$40(SnsCommentDetailUI paramSnsCommentDetailUI, CharSequence paramCharSequence, cds paramcds) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(38826);
    Object localObject2;
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        AppMethodBeat.o(38826);
        return;
        SnsCommentDetailUI.n(this.rPu).setText(this.rPM);
        h.bO(this.rPu.getContext(), this.rPu.getContext().getString(2131296896));
        localObject1 = bo.nW(v.abO(SnsCommentDetailUI.o(this.rPu)));
      } while ((this.rPN == null) || (this.rPM == null) || (localObject1 == null));
      localObject2 = a.qEl;
      a.i(4, (String)localObject1 + ":" + this.rPN.xNY, bo.apL(this.rPM.toString()));
      AppMethodBeat.o(38826);
      return;
    }
    Object localObject1 = new StringBuilder("del snsId:").append(SnsCommentDetailUI.o(this.rPu)).append(" commentId:");
    label203:
    long l;
    if (this.rPN != null)
    {
      paramInt = this.rPN.xNY;
      ab.e("MicroMsg.SnsCommentDetailUI", paramInt);
      l = v.abO(SnsCommentDetailUI.o(this.rPu));
      if (!v.Zq(SnsCommentDetailUI.o(this.rPu))) {
        break label336;
      }
    }
    label336:
    for (paramInt = 4;; paramInt = 6)
    {
      localObject1 = new r(l, paramInt, this.rPN);
      g.RM();
      g.RK().eHt.a((m)localObject1, 0);
      localObject2 = this.rPu;
      SnsCommentDetailUI localSnsCommentDetailUI = this.rPu;
      this.rPu.getString(2131297087);
      SnsCommentDetailUI.a((SnsCommentDetailUI)localObject2, h.b(localSnsCommentDetailUI, this.rPu.getString(2131303795), true, new SnsCommentDetailUI.40.1(this, (r)localObject1)));
      break;
      paramInt = 0;
      break label203;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.40
 * JD-Core Version:    0.7.0.1
 */