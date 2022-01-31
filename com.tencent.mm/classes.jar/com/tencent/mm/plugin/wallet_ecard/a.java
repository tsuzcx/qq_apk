package com.tencent.mm.plugin.wallet_ecard;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.cp;
import com.tencent.mm.h.a.lj;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class a
  implements ar
{
  private c<cp> qJF = new a.1(this);
  private c<lj> qJG = new a.2(this);
  
  public final void bh(boolean paramBoolean)
  {
    this.qJF.cqo();
    this.qJG.cqo();
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    this.qJF.dead();
    this.qJG.dead();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a
 * JD-Core Version:    0.7.0.1
 */