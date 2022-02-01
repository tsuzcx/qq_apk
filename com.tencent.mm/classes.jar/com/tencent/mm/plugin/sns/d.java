package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ks;
import com.tencent.mm.f.a.ks.a;
import com.tencent.mm.f.a.tv;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ekc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.LinkedList;

public final class d
  extends IListener<ks>
  implements i
{
  private int Jwq;
  private SnsObject Jwr;
  private SnsInfo Jws;
  private MTimerHandler Jwt;
  
  public d()
  {
    AppMethodBeat.i(160632);
    this.__eventId = ks.class.getName().hashCode();
    AppMethodBeat.o(160632);
  }
  
  private boolean a(ks paramks)
  {
    AppMethodBeat.i(94890);
    if (!(paramks instanceof ks))
    {
      Log.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
      AppMethodBeat.o(94890);
      return false;
    }
    this.Jwq = paramks.fIl.fBX;
    this.Jws = aj.fOI().agI(this.Jwq);
    this.Jwr = an.C(this.Jws);
    if ((this.Jwr != null) && (((this.Jwr.ExtFlag == 3) && (this.Jwr.BlackList != null) && (this.Jwr.BlackList.size() > 0)) || ((this.Jwr.ExtFlag == 5) && (this.Jwr.GroupUser != null) && (this.Jwr.GroupUser.size() > 0))))
    {
      paramks.fIm.fIn = this.Jwr;
      AppMethodBeat.o(94890);
      return true;
    }
    paramks = new r(this.Jws.field_snsId);
    ((ekc)d.b.b(paramks.rr.lBR)).UlR = 1;
    h.aHH();
    h.aHF().kcd.a(210, this);
    h.aHH();
    h.aHF().kcd.a(paramks, 0);
    this.Jwt = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94889);
        tv localtv = new tv();
        localtv.fTg.fIn = null;
        EventCenter.instance.publish(localtv);
        AppMethodBeat.o(94889);
        return false;
      }
    }, false);
    this.Jwt.startTimer(10000L);
    AppMethodBeat.o(94890);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(94891);
    Log.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Jwt.stopTimer();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = aj.fOI().Rd(this.Jws.field_snsId);
      paramq = new tv();
      paramq.fTg.fIn = an.C(paramString);
      EventCenter.instance.publish(paramq);
      AppMethodBeat.o(94891);
      return;
    }
    paramString = new tv();
    paramString.fTg.fIn = null;
    EventCenter.instance.publish(paramString);
    AppMethodBeat.o(94891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d
 * JD-Core Version:    0.7.0.1
 */