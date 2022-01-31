package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.a.ib.a;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;

public final class d
  extends c<ib>
  implements f
{
  private int qXn;
  private SnsObject qXo;
  private n qXp;
  private ap qXq;
  
  public d()
  {
    AppMethodBeat.i(35604);
    this.__eventId = ib.class.getName().hashCode();
    AppMethodBeat.o(35604);
  }
  
  private boolean a(ib paramib)
  {
    AppMethodBeat.i(35605);
    if (!(paramib instanceof ib))
    {
      ab.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
      AppMethodBeat.o(35605);
      return false;
    }
    this.qXn = paramib.cxo.cte;
    this.qXp = ag.cpf().Ez(this.qXn);
    this.qXo = ak.p(this.qXp);
    if ((this.qXo != null) && (((this.qXo.ExtFlag == 3) && (this.qXo.BlackList != null) && (this.qXo.BlackList.size() > 0)) || ((this.qXo.ExtFlag == 5) && (this.qXo.GroupUser != null) && (this.qXo.GroupUser.size() > 0))))
    {
      paramib.cxp.cxq = this.qXo;
      AppMethodBeat.o(35605);
      return true;
    }
    paramib = new q(this.qXp.field_snsId);
    ((cee)paramib.rr.fsV.fta).xOE = 1;
    g.RM();
    g.RK().eHt.a(210, this);
    g.RM();
    g.RK().eHt.a(paramib, 0);
    this.qXq = new ap(new d.1(this), false);
    this.qXq.ag(10000L, 10000L);
    AppMethodBeat.o(35605);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(35606);
    ab.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qXq.stopTimer();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ag.cpf().lZ(this.qXp.field_snsId);
      paramm = new pl();
      paramm.cFY.cxq = ak.p(paramString);
      a.ymk.l(paramm);
      AppMethodBeat.o(35606);
      return;
    }
    paramString = new pl();
    paramString.cFY.cxq = null;
    a.ymk.l(paramString);
    AppMethodBeat.o(35606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d
 * JD-Core Version:    0.7.0.1
 */