package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.a.kc.a;
import com.tencent.mm.g.a.su;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.eac;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.LinkedList;

public final class d
  extends IListener<kc>
  implements i
{
  private int DqM;
  private SnsObject DqN;
  private SnsInfo DqO;
  private MTimerHandler DqP;
  
  public d()
  {
    AppMethodBeat.i(160632);
    this.__eventId = kc.class.getName().hashCode();
    AppMethodBeat.o(160632);
  }
  
  private boolean a(kc paramkc)
  {
    AppMethodBeat.i(94890);
    if (!(paramkc instanceof kc))
    {
      Log.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
      AppMethodBeat.o(94890);
      return false;
    }
    this.DqM = paramkc.dPa.dJi;
    this.DqO = aj.faO().Zr(this.DqM);
    this.DqN = an.B(this.DqO);
    if ((this.DqN != null) && (((this.DqN.ExtFlag == 3) && (this.DqN.BlackList != null) && (this.DqN.BlackList.size() > 0)) || ((this.DqN.ExtFlag == 5) && (this.DqN.GroupUser != null) && (this.DqN.GroupUser.size() > 0))))
    {
      paramkc.dPb.dPc = this.DqN;
      AppMethodBeat.o(94890);
      return true;
    }
    paramkc = new r(this.DqO.field_snsId);
    ((eac)paramkc.rr.iLK.iLR).MZx = 1;
    g.aAi();
    g.aAg().hqi.a(210, this);
    g.aAi();
    g.aAg().hqi.a(paramkc, 0);
    this.DqP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94889);
        su localsu = new su();
        localsu.dZn.dPc = null;
        EventCenter.instance.publish(localsu);
        AppMethodBeat.o(94889);
        return false;
      }
    }, false);
    this.DqP.startTimer(10000L);
    AppMethodBeat.o(94890);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(94891);
    Log.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.DqP.stopTimer();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = aj.faO().JJ(this.DqO.field_snsId);
      paramq = new su();
      paramq.dZn.dPc = an.B(paramString);
      EventCenter.instance.publish(paramq);
      AppMethodBeat.o(94891);
      return;
    }
    paramString = new su();
    paramString.dZn.dPc = null;
    EventCenter.instance.publish(paramString);
    AppMethodBeat.o(94891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d
 * JD-Core Version:    0.7.0.1
 */