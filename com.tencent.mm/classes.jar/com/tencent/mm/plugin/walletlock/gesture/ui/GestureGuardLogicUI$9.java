package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.Intent;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.h.b.a.aa;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.sdk.platformtools.y;

final class GestureGuardLogicUI$9
  implements w.a
{
  GestureGuardLogicUI$9(GestureGuardLogicUI paramGestureGuardLogicUI, w.a parama) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    GestureGuardLogicUI.o(this.qPX);
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      d.a(((bal)paramb.ecF.ecN).twt);
      GestureGuardLogicUI.bYq();
      if (GestureGuardLogicUI.q(this.qPX) != 0) {
        break label194;
      }
      if (GestureGuardLogicUI.r(this.qPX) != 1) {
        break label149;
      }
      localObject = new aa();
      ((aa)localObject).ckr = 8L;
      ((aa)localObject).cks = 2L;
      ((aa)localObject).QX();
    }
    for (;;)
    {
      i.qRd.bYG();
      if (this.eeu == null) {
        break;
      }
      return this.eeu.a(paramInt1, paramInt2, paramString, paramb, paramm);
      label149:
      if (GestureGuardLogicUI.r(this.qPX) == 2)
      {
        localObject = new aa();
        ((aa)localObject).ckr = 10L;
        ((aa)localObject).cks = 2L;
        ((aa)localObject).QX();
        continue;
        label194:
        localObject = this.qPX.getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(localObject))
        {
          localObject = new aa();
          ((aa)localObject).ckr = 5L;
          ((aa)localObject).cks = 2L;
          ((aa)localObject).QX();
        }
        else if ("next_action.switch_on_pattern".equals(localObject))
        {
          localObject = new aa();
          ((aa)localObject).ckr = 4L;
          ((aa)localObject).cks = 2L;
          ((aa)localObject).QX();
        }
        else
        {
          localObject = new aa();
          ((aa)localObject).ckr = 5L;
          ((aa)localObject).cks = 2L;
          ((aa)localObject).QX();
        }
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.9
 * JD-Core Version:    0.7.0.1
 */