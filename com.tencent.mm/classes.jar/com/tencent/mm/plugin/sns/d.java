package com.tencent.mm.plugin.sns;

import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.hx;
import com.tencent.mm.h.a.hx.a;
import com.tencent.mm.h.a.oj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.btp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class d
  extends c<hx>
  implements f
{
  private int ojc;
  private bto ojd;
  private n oje;
  private am ojf;
  
  public d()
  {
    this.udX = hx.class.getName().hashCode();
  }
  
  private boolean a(hx paramhx)
  {
    if (!(paramhx instanceof hx))
    {
      y.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
      return false;
    }
    this.ojc = paramhx.bPV.bLK;
    this.oje = af.bDF().yt(this.ojc);
    this.ojd = aj.p(this.oje);
    if ((this.ojd != null) && (((this.ojd.ttI == 3) && (this.ojd.tKj != null) && (this.ojd.tKj.size() > 0)) || ((this.ojd.ttI == 5) && (this.ojd.tsx != null) && (this.ojd.tsx.size() > 0))))
    {
      paramhx.bPW.bPX = this.ojd;
      return true;
    }
    paramhx = new q(this.oje.field_snsId);
    ((btp)paramhx.dmK.ecE.ecN).tKp = 1;
    g.DQ();
    g.DO().dJT.a(210, this);
    g.DQ();
    g.DO().dJT.a(paramhx, 0);
    this.ojf = new am(new d.1(this), false);
    this.ojf.S(10000L, 10000L);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ojf.stopTimer();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = af.bDF().gt(this.oje.field_snsId);
      paramm = new oj();
      paramm.bXX.bPX = aj.p(paramString);
      a.udP.m(paramm);
      return;
    }
    paramString = new oj();
    paramString.bXX.bPX = null;
    a.udP.m(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d
 * JD-Core Version:    0.7.0.1
 */