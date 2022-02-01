package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.g.a.jn.a;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.LinkedList;

public final class d
  extends c<jn>
  implements f
{
  private int zlU;
  private SnsObject zlV;
  private p zlW;
  private aw zlX;
  
  public d()
  {
    AppMethodBeat.i(160632);
    this.__eventId = jn.class.getName().hashCode();
    AppMethodBeat.o(160632);
  }
  
  private boolean a(jn paramjn)
  {
    AppMethodBeat.i(94890);
    if (!(paramjn instanceof jn))
    {
      ae.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
      AppMethodBeat.o(94890);
      return false;
    }
    this.zlU = paramjn.dxt.drW;
    this.zlW = ah.dXE().Rw(this.zlU);
    this.zlV = al.u(this.zlW);
    if ((this.zlV != null) && (((this.zlV.ExtFlag == 3) && (this.zlV.BlackList != null) && (this.zlV.BlackList.size() > 0)) || ((this.zlV.ExtFlag == 5) && (this.zlV.GroupUser != null) && (this.zlV.GroupUser.size() > 0))))
    {
      paramjn.dxu.dxv = this.zlV;
      AppMethodBeat.o(94890);
      return true;
    }
    paramjn = new com.tencent.mm.plugin.sns.model.q(this.zlW.field_snsId);
    ((dgu)paramjn.rr.hQD.hQJ).HNQ = 1;
    g.ajS();
    g.ajQ().gDv.a(210, this);
    g.ajS();
    g.ajQ().gDv.a(paramjn, 0);
    this.zlX = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94889);
        ry localry = new ry();
        localry.dHC.dxv = null;
        a.IvT.l(localry);
        AppMethodBeat.o(94889);
        return false;
      }
    }, false);
    this.zlX.ay(10000L, 10000L);
    AppMethodBeat.o(94890);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(94891);
    ae.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.zlX.stopTimer();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ah.dXE().AG(this.zlW.field_snsId);
      paramn = new ry();
      paramn.dHC.dxv = al.u(paramString);
      a.IvT.l(paramn);
      AppMethodBeat.o(94891);
      return;
    }
    paramString = new ry();
    paramString.dHC.dxv = null;
    a.IvT.l(paramString);
    AppMethodBeat.o(94891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d
 * JD-Core Version:    0.7.0.1
 */