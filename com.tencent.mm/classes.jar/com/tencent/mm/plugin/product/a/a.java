package com.tencent.mm.plugin.product.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import java.util.HashMap;

public class a
  implements ar
{
  private c mRL = null;
  private d mRM = null;
  private com.tencent.mm.plugin.product.b.a mRN = new com.tencent.mm.plugin.product.b.a();
  
  public static a brN()
  {
    return (a)p.B(a.class);
  }
  
  public static c brO()
  {
    g.DN().CX();
    if (brN().mRL == null) {
      brN().mRL = new c();
    }
    return brN().mRL;
  }
  
  public final void bh(boolean paramBoolean)
  {
    this.mRL = null;
    com.tencent.mm.sdk.b.a.udP.c(this.mRN);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final d brP()
  {
    g.DN().CX();
    if (this.mRM == null) {
      this.mRM = new d();
    }
    return this.mRM;
  }
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.mRN);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.a.a
 * JD-Core Version:    0.7.0.1
 */