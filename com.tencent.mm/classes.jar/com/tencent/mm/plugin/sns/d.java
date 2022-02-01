package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.je.a;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.LinkedList;

public final class d
  extends c<je>
  implements com.tencent.mm.ak.g
{
  private int xHa;
  private SnsObject xHb;
  private com.tencent.mm.plugin.sns.storage.p xHc;
  private au xHd;
  
  public d()
  {
    AppMethodBeat.i(160632);
    this.__eventId = je.class.getName().hashCode();
    AppMethodBeat.o(160632);
  }
  
  private boolean a(je paramje)
  {
    AppMethodBeat.i(94890);
    if (!(paramje instanceof je))
    {
      ac.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
      AppMethodBeat.o(94890);
      return false;
    }
    this.xHa = paramje.dkB.dfv;
    this.xHc = af.dHR().Ph(this.xHa);
    this.xHb = aj.s(this.xHc);
    if ((this.xHb != null) && (((this.xHb.ExtFlag == 3) && (this.xHb.BlackList != null) && (this.xHb.BlackList.size() > 0)) || ((this.xHb.ExtFlag == 5) && (this.xHb.GroupUser != null) && (this.xHb.GroupUser.size() > 0))))
    {
      paramje.dkC.dkD = this.xHb;
      AppMethodBeat.o(94890);
      return true;
    }
    paramje = new com.tencent.mm.plugin.sns.model.p(this.xHc.field_snsId);
    ((dan)paramje.rr.hvr.hvw).FJF = 1;
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(210, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramje, 0);
    this.xHd = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94889);
        rm localrm = new rm();
        localrm.duw.dkD = null;
        a.GpY.l(localrm);
        AppMethodBeat.o(94889);
        return false;
      }
    }, false);
    this.xHd.au(10000L, 10000L);
    AppMethodBeat.o(94890);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(94891);
    ac.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xHd.stopTimer();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = af.dHR().xK(this.xHc.field_snsId);
      paramn = new rm();
      paramn.duw.dkD = aj.s(paramString);
      a.GpY.l(paramn);
      AppMethodBeat.o(94891);
      return;
    }
    paramString = new rm();
    paramString.duw.dkD = null;
    a.GpY.l(paramString);
    AppMethodBeat.o(94891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d
 * JD-Core Version:    0.7.0.1
 */