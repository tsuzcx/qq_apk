package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.voip.model.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.pb.talkroom.sdk.b;

public final class d
  implements f
{
  c.a bDg = new d.2(this);
  com.tencent.mm.f.b.c iEq;
  public com.tencent.pb.talkroom.sdk.d mtp;
  c mtq;
  com.tencent.pb.talkroom.sdk.c mtr;
  b mts;
  a mtt = new d.3(this);
  
  public d()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
    Context localContext = ae.getContext();
    com.tencent.wecall.talkroom.model.e locale = com.tencent.wecall.talkroom.model.e.cRH();
    com.tencent.wecall.talkroom.model.e.ii(localContext);
    this.mtp = locale;
    this.mtp.cOn();
    this.mtq = new c();
    int i = bk.g((Integer)g.DP().dKo.get(1));
    this.mtp.a(p.blF(), new d.1(this));
    this.mtp.bk(i, q.Gj());
    g.Dk().a(1918, this);
    g.Dk().a(1919, this);
    g.Dk().a(1927, this);
    g.Dk().a(1928, this);
    g.Dk().a(1929, this);
    g.Dk().a(1931, this);
    g.Dk().a(1932, this);
    g.Dk().a(1933, this);
    g.Dk().a(1935, this);
    g.Dk().a(1937, this);
    g.Dk().a(1938, this);
    g.Dk().a(1939, this);
  }
  
  public final void hH(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.y.l("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      int i = (byte)j;
      this.mtp.setAppCmd(425, new byte[] { i }, 1);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramString = (o)paramm;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + paramInt1 + " errCode " + paramInt2 + " cmdid " + paramString.jsS);
    this.mtp.c(paramInt2, paramString.jsR, paramString.jsS, paramString.ccD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.d
 * JD-Core Version:    0.7.0.1
 */