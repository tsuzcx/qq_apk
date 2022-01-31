package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.b;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.ca.a;
import com.tencent.mm.plugin.multitalk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

public class p
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private ca.a kul = new p.3(this);
  private d muU;
  private f muV;
  private m muW;
  private i muX;
  private p.a muY;
  private h muZ;
  private com.tencent.mm.plugin.multitalk.b.a mva;
  private c mvb;
  private g mvc;
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new p.1());
    dgp.put(Integer.valueOf("MULTITALKMEMBER_TABLE".hashCode()), new p.2());
  }
  
  private static p blA()
  {
    return (p)com.tencent.mm.model.p.B(p.class);
  }
  
  public static com.tencent.mm.plugin.multitalk.b.a blB()
  {
    com.tencent.mm.kernel.g.DN();
    if (com.tencent.mm.kernel.a.CK() == 0) {
      throw new b();
    }
    if (blA().mva == null) {
      blA().mva = new com.tencent.mm.plugin.multitalk.b.a(com.tencent.mm.kernel.g.DP().dKu);
    }
    return blA().mva;
  }
  
  public static c blC()
  {
    com.tencent.mm.kernel.g.DN();
    if (com.tencent.mm.kernel.a.CK() == 0) {
      throw new b();
    }
    if (blA().mvb == null) {
      blA().mvb = new c(com.tencent.mm.kernel.g.DP().dKu);
    }
    return blA().mvb;
  }
  
  public static i blD()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (blA().muX == null) {
      blA().muX = new i();
    }
    return blA().muX;
  }
  
  public static d blE()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (blA().muU == null) {
      blA().muU = new d();
    }
    return blA().muU;
  }
  
  public static f blF()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (blA().muV == null) {
      blA().muV = new f();
    }
    return blA().muV;
  }
  
  public static m blG()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (blA().muW == null) {
      blA().muW = new m();
    }
    return blA().muW;
  }
  
  public static h blH()
  {
    if (blA().muZ == null) {
      blA().muZ = new h();
    }
    return blA().muZ;
  }
  
  public static g blI()
  {
    if (blA().mvc == null) {
      blA().mvc = new g();
    }
    return blA().mvc;
  }
  
  public final void bh(boolean paramBoolean)
  {
    this.muU = new d();
    this.muY = new p.a(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("multivoip", this.muY, true);
    com.tencent.mm.kernel.g.DR().a(this.kul);
    com.tencent.mm.kernel.g.a(a.class, blH());
    blH().blt();
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    Object localObject;
    if (this.muU != null)
    {
      localObject = this.muU;
      com.tencent.mm.kernel.g.Dk().b(1918, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(1919, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(1927, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(1928, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(1929, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(1931, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(1932, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(1933, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(1935, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(1937, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(1938, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(1939, (com.tencent.mm.ah.f)localObject);
      this.muU = null;
    }
    if (this.muV != null)
    {
      localObject = this.muV;
      ae.getContext().unregisterReceiver(((f)localObject).mtX);
      com.tencent.mm.sdk.b.a.udP.d(((f)localObject).mtY);
      ((f)localObject).h(false, false, false);
      this.muV = null;
    }
    if (this.muW != null)
    {
      this.muW.blz();
      this.muW = null;
    }
    if (this.muX != null)
    {
      this.muX.reset();
      this.muX = null;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("multivoip", this.muY, true);
    com.tencent.mm.kernel.g.DR().b(this.kul);
    com.tencent.mm.kernel.g.s(a.class);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.p
 * JD-Core Version:    0.7.0.1
 */