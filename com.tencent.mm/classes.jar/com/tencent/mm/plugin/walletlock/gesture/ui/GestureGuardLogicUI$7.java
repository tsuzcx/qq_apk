package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.protocal.protobuf.bho;
import com.tencent.mm.sdk.platformtools.ab;

final class GestureGuardLogicUI$7
  implements w.a
{
  GestureGuardLogicUI$7(GestureGuardLogicUI paramGestureGuardLogicUI, w.a parama) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(51592);
    ab.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    GestureGuardLogicUI.o(this.uFf);
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      d.a(((bho)paramb.fsW.fta).xwH);
      if (GestureGuardLogicUI.q(this.uFf) != 0) {
        break label197;
      }
      if (GestureGuardLogicUI.r(this.uFf) != 1) {
        break label152;
      }
      localObject = new bt();
      ((bt)localObject).cRI = 8L;
      ((bt)localObject).cYT = 2L;
      ((bt)localObject).ake();
    }
    while (this.fux != null)
    {
      paramInt1 = this.fux.a(paramInt1, paramInt2, paramString, paramb, paramm);
      AppMethodBeat.o(51592);
      return paramInt1;
      label152:
      if (GestureGuardLogicUI.r(this.uFf) == 2)
      {
        localObject = new bt();
        ((bt)localObject).cRI = 10L;
        ((bt)localObject).cYT = 2L;
        ((bt)localObject).ake();
        continue;
        label197:
        localObject = this.uFf.getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(localObject))
        {
          localObject = new bt();
          ((bt)localObject).cRI = 5L;
          ((bt)localObject).cYT = 2L;
          ((bt)localObject).ake();
        }
        else if ("next_action.switch_on_pattern".equals(localObject))
        {
          localObject = new bt();
          ((bt)localObject).cRI = 4L;
          ((bt)localObject).cYT = 2L;
          ((bt)localObject).ake();
        }
        else
        {
          localObject = new bt();
          ((bt)localObject).cRI = 5L;
          ((bt)localObject).cYT = 2L;
          ((bt)localObject).ake();
        }
      }
    }
    AppMethodBeat.o(51592);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.7
 * JD-Core Version:    0.7.0.1
 */