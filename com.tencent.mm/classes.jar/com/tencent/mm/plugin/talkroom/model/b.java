package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ah.e.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.network.n;
import java.util.HashMap;

public final class b
  implements ar
{
  private n nIV = new b.1(this);
  g pAl;
  private d pAm = new d();
  public c pAn = new c();
  private e pAo;
  f pAp;
  
  public static b bMt()
  {
    au.Hq();
    b localb2 = (b)bu.iR("plugin.talkroom");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      au.Hq().a("plugin.talkroom", localb1);
    }
    return localb1;
  }
  
  public static g bMu()
  {
    if (bMt().pAl == null) {
      bMt().pAl = new g();
    }
    return bMt().pAl;
  }
  
  public static e bMv()
  {
    if (bMt().pAo == null) {
      bMt().pAo = new e();
    }
    return bMt().pAo;
  }
  
  public static String bMw()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    return com.tencent.mm.model.c.FT() + "talkroom/";
  }
  
  public static f bMx()
  {
    if (bMt().pAp == null) {
      bMt().pAp = new f();
    }
    return bMt().pAp;
  }
  
  public final void bh(boolean paramBoolean)
  {
    e.d.a(Integer.valueOf(56), this.pAm);
    au.a(this.nIV);
    com.tencent.mm.bf.g.eEV = bMv();
    com.tencent.mm.bf.g.eEW = bMu();
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    e.d.b(Integer.valueOf(56), this.pAm);
    au.b(this.nIV);
    com.tencent.mm.bf.g.eEV = null;
    com.tencent.mm.bf.g.eEW = null;
    if (this.pAl != null)
    {
      this.pAl.beA();
      this.pAl = null;
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */