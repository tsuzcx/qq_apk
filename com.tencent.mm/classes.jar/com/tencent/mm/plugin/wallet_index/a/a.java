package com.tencent.mm.plugin.wallet_index.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.wallet_index.c.k;
import java.util.HashMap;

public class a
  implements ar
{
  private k qKW = new k();
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.sdk.b.a.udP.c(this.qKW.qLr);
    com.tencent.mm.sdk.b.a.udP.c(this.qKW.qLs);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.qKW.qLr);
    com.tencent.mm.sdk.b.a.udP.d(this.qKW.qLs);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.a.a
 * JD-Core Version:    0.7.0.1
 */