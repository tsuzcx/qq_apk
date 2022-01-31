package com.tencent.mm.y;

import android.util.SparseArray;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;

public final class c
  implements ar
{
  private static c dFR;
  private a dFS;
  
  private c()
  {
    if (a.dFx == null) {
      a.dFx = new a();
    }
    this.dFS = a.dFx;
  }
  
  public static a BS()
  {
    g.DN().CX();
    if (dFR == null)
    {
      c localc = new c();
      dFR = localc;
      localc.dFS.init();
    }
    return dFR.dFS;
  }
  
  public final void bh(boolean paramBoolean)
  {
    this.dFS.init();
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    a locala = this.dFS;
    locala.dFz.clear();
    b localb = locala.dFy;
    y.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
    localb.dFH.clear();
    localb.dFJ.clear();
    localb.dFI.clear();
    localb.dFK.clear();
    locala.initialized = false;
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.y.c
 * JD-Core Version:    0.7.0.1
 */