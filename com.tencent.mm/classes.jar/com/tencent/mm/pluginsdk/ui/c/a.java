package com.tencent.mm.pluginsdk.ui.c;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends com.tencent.mm.ui.tools.a.a
{
  public int mSize = 104857600;
  private String oep;
  private a shW;
  
  private a(String paramString)
  {
    this.oep = paramString;
  }
  
  public static a WN(String paramString)
  {
    return new a(paramString);
  }
  
  protected final int afv()
  {
    int i = 10485760;
    if (bk.bl(this.oep)) {
      y.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
    }
    boolean bool1 = aq.is2G(ae.getContext());
    boolean bool2 = c.pp(this.oep);
    label53:
    double d;
    if (bool2)
    {
      String str = this.oep;
      if (bool1)
      {
        if (!bool1) {
          break label196;
        }
        d = 60000.0D;
        label62:
        i = SightVideoJNI.shouldRemuxing(str, 660, 500, i, d, 1000000);
      }
    }
    for (;;)
    {
      y.i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2) });
      switch (i)
      {
      default: 
        y.e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", new Object[] { Integer.valueOf(i) });
      case -6: 
      case -5: 
      case -4: 
      case -3: 
      case -2: 
        return 1;
        i = this.mSize;
        break label53;
        label196:
        d = this.mSize;
        break label62;
        int j = e.bJ(this.oep);
        if (bool1) {}
        for (i = 10485760;; i = 26214400)
        {
          if (j <= i) {
            break label239;
          }
          i = -1;
          break;
        }
        label239:
        i = 1;
      }
    }
    return 0;
    return 2;
  }
  
  public final int cnU()
  {
    return afv();
  }
  
  protected final void cnV()
  {
    if (this.shW == null)
    {
      y.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
      return;
    }
    afv();
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.c.a
 * JD-Core Version:    0.7.0.1
 */