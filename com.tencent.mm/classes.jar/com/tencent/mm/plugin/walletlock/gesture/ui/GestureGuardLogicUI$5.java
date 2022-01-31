package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.sdk.platformtools.ab;

final class GestureGuardLogicUI$5
  implements w.a
{
  GestureGuardLogicUI$5(GestureGuardLogicUI paramGestureGuardLogicUI, w.a parama) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(51590);
    ab.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    GestureGuardLogicUI.o(this.uFf);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      d.a(((btf)paramb.fsW.fta).xwH);
      GestureGuardLogicUI.cYb();
      ((com.tencent.mm.plugin.walletlock.a.b)g.E(com.tencent.mm.plugin.walletlock.a.b.class)).IL(1);
    }
    i.uGl.cYq();
    if (this.fux != null)
    {
      paramInt1 = this.fux.a(paramInt1, paramInt2, paramString, paramb, paramm);
      AppMethodBeat.o(51590);
      return paramInt1;
    }
    AppMethodBeat.o(51590);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.5
 * JD-Core Version:    0.7.0.1
 */