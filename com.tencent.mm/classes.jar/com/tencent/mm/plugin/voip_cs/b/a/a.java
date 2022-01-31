package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip_cs.a.d;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  private static a qei;
  public i pTJ = new i(ae.getContext());
  
  public static a bSV()
  {
    if (qei == null) {
      qei = new a();
    }
    return qei;
  }
  
  public static a bSW()
  {
    if (qei == null) {
      qei = bSV();
    }
    return qei;
  }
  
  public final boolean bRj()
  {
    if (this.pTJ != null) {
      return this.pTJ.amn();
    }
    return true;
  }
  
  public final void bSX()
  {
    if (this.pTJ != null) {
      this.pTJ.n(a.d.phonering, 0, true);
    }
  }
  
  public final void stopRing()
  {
    if (this.pTJ != null) {
      this.pTJ.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.a
 * JD-Core Version:    0.7.0.1
 */