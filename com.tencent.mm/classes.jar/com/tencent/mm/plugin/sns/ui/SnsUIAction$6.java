package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsUIAction$6
  implements SnsHeader.a
{
  SnsUIAction$6(SnsUIAction paramSnsUIAction) {}
  
  public final boolean cvj()
  {
    AppMethodBeat.i(39645);
    SnsUIAction.c(this.sbh).cwl();
    AppMethodBeat.o(39645);
    return false;
  }
  
  public final boolean md(long paramLong)
  {
    AppMethodBeat.i(39644);
    if ((SnsUIAction.b(this.sbh)) || (SnsUIAction.c(this.sbh).getType() == 1))
    {
      this.sbh.Fd(2);
      AppMethodBeat.o(39644);
      return false;
    }
    Object localObject1 = new n();
    ((n)localObject1).field_snsId = paramLong;
    ((n)localObject1).field_userName = SnsUIAction.d(this.sbh);
    Object localObject2 = e.akg();
    ((TimeLineObject)localObject2).jJA = SnsUIAction.d(this.sbh);
    ((n)localObject1).c((TimeLineObject)localObject2);
    localObject2 = ak.aax(SnsUIAction.d(this.sbh));
    ab.d("MicroMsg.SnsActivity", "friend like %s", new Object[] { SnsUIAction.d(this.sbh) });
    if (localObject2 == null) {
      an.a.a((n)localObject1, 1, "", 0);
    }
    for (;;)
    {
      localObject1 = ag.cpj().abz(SnsUIAction.d(this.sbh));
      ((l)localObject1).field_local_flag |= 0x2;
      ag.cpj().c((l)localObject1);
      SnsUIAction.e(this.sbh);
      break;
      if (((n)localObject2).csG()) {
        an.a.a((n)localObject1, 1, "", 0);
      } else {
        an.a.a((n)localObject1, 5, "", 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.6
 * JD-Core Version:    0.7.0.1
 */