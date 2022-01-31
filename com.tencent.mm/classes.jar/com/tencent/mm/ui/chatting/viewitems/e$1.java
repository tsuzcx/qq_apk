package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.sdk.platformtools.ah;

final class e$1
  implements Runnable
{
  e$1(e.a parama, c paramc, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(32862);
    int i = this.zTh.jYu.getHeight();
    int j = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 20);
    int k = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 168);
    aus localaus = new aus();
    localaus.subType = this.zTi.subType;
    localaus.xjM = new aut();
    aut localaut = localaus.xjM;
    if (this.zTj)
    {
      str = this.zTi.fgb;
      localaut.xjV = str;
      localaut = localaus.xjM;
      if (!this.zTj) {
        break label176;
      }
    }
    label176:
    for (String str = this.zTi.fgc;; str = this.zTi.fga)
    {
      localaut.xjY = str;
      ((com.tencent.mm.plugin.luckymoney.a.a)g.E(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.zTh.owb, i - j, k, localaus, this.zTj);
      AppMethodBeat.o(32862);
      return;
      str = this.zTi.ffZ;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.1
 * JD-Core Version:    0.7.0.1
 */