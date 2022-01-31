package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.protocal.c.bkf;
import com.tencent.mm.sdk.platformtools.y;

final class GestureGuardLogicUI$14
  implements w.a
{
  GestureGuardLogicUI$14(GestureGuardLogicUI paramGestureGuardLogicUI, w.a parama) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    GestureGuardLogicUI.o(this.qPX);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      d.a(((bkf)paramb.ecF.ecN).twt);
      g localg = g.qQZ;
      g.kR(false);
      GestureGuardLogicUI.bYq();
    }
    i.qRd.bYG();
    if (this.eeu != null) {
      return this.eeu.a(paramInt1, paramInt2, paramString, paramb, paramm);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.14
 * JD-Core Version:    0.7.0.1
 */