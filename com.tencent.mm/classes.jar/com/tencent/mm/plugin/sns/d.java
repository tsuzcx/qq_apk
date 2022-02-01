package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.a.ix.a;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.LinkedList;

public final class d
  extends c<ix>
  implements com.tencent.mm.al.g
{
  private int wvK;
  private SnsObject wvL;
  private com.tencent.mm.plugin.sns.storage.p wvM;
  private av wvN;
  
  public d()
  {
    AppMethodBeat.i(160632);
    this.__eventId = ix.class.getName().hashCode();
    AppMethodBeat.o(160632);
  }
  
  private boolean a(ix paramix)
  {
    AppMethodBeat.i(94890);
    if (!(paramix instanceof ix))
    {
      ad.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
      AppMethodBeat.o(94890);
      return false;
    }
    this.wvK = paramix.dmT.dia;
    this.wvM = af.dtu().Ne(this.wvK);
    this.wvL = aj.s(this.wvM);
    if ((this.wvL != null) && (((this.wvL.ExtFlag == 3) && (this.wvL.BlackList != null) && (this.wvL.BlackList.size() > 0)) || ((this.wvL.ExtFlag == 5) && (this.wvL.GroupUser != null) && (this.wvL.GroupUser.size() > 0))))
    {
      paramix.dmU.dmV = this.wvL;
      AppMethodBeat.o(94890);
      return true;
    }
    paramix = new com.tencent.mm.plugin.sns.model.p(this.wvM.field_snsId);
    ((cvb)paramix.rr.gUS.gUX).EmG = 1;
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(210, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramix, 0);
    this.wvN = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94889);
        rd localrd = new rd();
        localrd.dwJ.dmV = null;
        a.ESL.l(localrd);
        AppMethodBeat.o(94889);
        return false;
      }
    }, false);
    this.wvN.av(10000L, 10000L);
    AppMethodBeat.o(94890);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(94891);
    ad.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wvN.stopTimer();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = af.dtu().th(this.wvM.field_snsId);
      paramn = new rd();
      paramn.dwJ.dmV = aj.s(paramString);
      a.ESL.l(paramn);
      AppMethodBeat.o(94891);
      return;
    }
    paramString = new rd();
    paramString.dwJ.dmV = null;
    a.ESL.l(paramString);
    AppMethodBeat.o(94891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d
 * JD-Core Version:    0.7.0.1
 */