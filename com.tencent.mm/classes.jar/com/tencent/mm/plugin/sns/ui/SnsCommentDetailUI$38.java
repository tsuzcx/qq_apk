package com.tencent.mm.plugin.sns.ui;

import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s;

final class SnsCommentDetailUI$38
  implements h.c
{
  SnsCommentDetailUI$38(SnsCommentDetailUI paramSnsCommentDetailUI, CharSequence paramCharSequence, btd parambtd) {}
  
  public final void gl(int paramInt)
  {
    Object localObject2;
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        return;
        SnsCommentDetailUI.n(this.oWW).setText(this.oXo);
        h.bC(this.oWW.mController.uMN, this.oWW.mController.uMN.getString(i.j.app_copy_ok));
        localObject1 = bk.hu(v.OU(SnsCommentDetailUI.o(this.oWW)));
      } while ((this.oXp == null) || (this.oXo == null) || (localObject1 == null));
      localObject2 = a.nQo;
      a.f(4, (String)localObject1 + ":" + this.oXp.tJu, bk.ZH(this.oXo.toString()));
      return;
    }
    Object localObject1 = new StringBuilder("del snsId:").append(SnsCommentDetailUI.o(this.oWW)).append(" commentId:");
    long l;
    if (this.oXp != null)
    {
      paramInt = this.oXp.tJu;
      y.e("MicroMsg.SnsCommentDetailUI", paramInt);
      l = v.OU(SnsCommentDetailUI.o(this.oWW));
      if (!v.MJ(SnsCommentDetailUI.o(this.oWW))) {
        break label329;
      }
    }
    label329:
    for (paramInt = 4;; paramInt = 6)
    {
      localObject1 = new r(l, paramInt, this.oXp);
      g.DQ();
      g.DO().dJT.a((m)localObject1, 0);
      localObject2 = this.oWW;
      SnsCommentDetailUI localSnsCommentDetailUI = this.oWW;
      this.oWW.getString(i.j.app_tip);
      SnsCommentDetailUI.a((SnsCommentDetailUI)localObject2, h.b(localSnsCommentDetailUI, this.oWW.getString(i.j.sns_deling_sns), true, new SnsCommentDetailUI.38.1(this, (r)localObject1)));
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.38
 * JD-Core Version:    0.7.0.1
 */