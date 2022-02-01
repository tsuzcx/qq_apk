package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.jm.a;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dga;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.LinkedList;

public final class d
  extends c<jm>
  implements f
{
  private int yVK;
  private SnsObject yVL;
  private com.tencent.mm.plugin.sns.storage.p yVM;
  private av yVN;
  
  public d()
  {
    AppMethodBeat.i(160632);
    this.__eventId = jm.class.getName().hashCode();
    AppMethodBeat.o(160632);
  }
  
  private boolean a(jm paramjm)
  {
    AppMethodBeat.i(94890);
    if (!(paramjm instanceof jm))
    {
      ad.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
      AppMethodBeat.o(94890);
      return false;
    }
    this.yVK = paramjm.dwo.dqR;
    this.yVM = ag.dUe().QP(this.yVK);
    this.yVL = ak.u(this.yVM);
    if ((this.yVL != null) && (((this.yVL.ExtFlag == 3) && (this.yVL.BlackList != null) && (this.yVL.BlackList.size() > 0)) || ((this.yVL.ExtFlag == 5) && (this.yVL.GroupUser != null) && (this.yVL.GroupUser.size() > 0))))
    {
      paramjm.dwp.dwq = this.yVL;
      AppMethodBeat.o(94890);
      return true;
    }
    paramjm = new com.tencent.mm.plugin.sns.model.p(this.yVM.field_snsId);
    ((dga)paramjm.rr.hNK.hNQ).Hun = 1;
    g.ajD();
    g.ajB().gAO.a(210, this);
    g.ajD();
    g.ajB().gAO.a(paramjm, 0);
    this.yVN = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94889);
        rx localrx = new rx();
        localrx.dGw.dwq = null;
        a.IbL.l(localrx);
        AppMethodBeat.o(94889);
        return false;
      }
    }, false);
    this.yVN.az(10000L, 10000L);
    AppMethodBeat.o(94890);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(94891);
    ad.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yVN.stopTimer();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ag.dUe().Ai(this.yVM.field_snsId);
      paramn = new rx();
      paramn.dGw.dwq = ak.u(paramString);
      a.IbL.l(paramn);
      AppMethodBeat.o(94891);
      return;
    }
    paramString = new rx();
    paramString.dGw.dwq = null;
    a.IbL.l(paramString);
    AppMethodBeat.o(94891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d
 * JD-Core Version:    0.7.0.1
 */