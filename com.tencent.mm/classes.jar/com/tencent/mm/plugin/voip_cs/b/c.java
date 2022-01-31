package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class c
  implements ar
{
  private static c qcU = null;
  private com.tencent.mm.plugin.voip_cs.b.b.a qcV = new com.tencent.mm.plugin.voip_cs.b.b.a();
  private e qcW = new e();
  private d qcX = new d();
  private com.tencent.mm.plugin.voip_cs.a.a qcY = new com.tencent.mm.plugin.voip_cs.a.a();
  private com.tencent.mm.sdk.b.c qcZ = new c.1(this);
  
  private static c bSN()
  {
    return (c)p.B(c.class);
  }
  
  public static com.tencent.mm.plugin.voip_cs.b.b.a bSO()
  {
    return bSN().qcV;
  }
  
  public static e bSP()
  {
    g.DN().CX();
    if (bSN().qcW == null) {
      bSN().qcW = new e();
    }
    return bSN().qcW;
  }
  
  public static d bSQ()
  {
    return bSN().qcX;
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.d("MicroMsg.SubCoreVoipCS", "now account reset!");
    com.tencent.mm.sdk.b.a.udP.c(this.qcY);
    com.tencent.mm.sdk.b.a.udP.c(this.qcZ);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.qcY);
    com.tencent.mm.sdk.b.a.udP.d(this.qcZ);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c
 * JD-Core Version:    0.7.0.1
 */