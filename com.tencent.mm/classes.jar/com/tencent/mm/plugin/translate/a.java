package com.tencent.mm.plugin.translate;

import android.os.Looper;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.translate.a.c.a;
import com.tencent.mm.plugin.translate.a.c.b;
import com.tencent.mm.plugin.translate.a.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.av;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public final class a
  implements ar
{
  ah handler = new ah(Looper.getMainLooper());
  com.tencent.mm.plugin.translate.a.c pKs = c.b.pKG;
  av pKt = new av(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
  private c.a pKu = new a.1(this);
  private com.tencent.mm.sdk.b.c pKv = new a.2(this);
  private com.tencent.mm.sdk.b.c pKw = new a.3(this);
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.plugin.translate.a.c localc = this.pKs;
    c.a locala = this.pKu;
    if ((locala == null) || (localc.dFz.contains(locala))) {}
    for (;;)
    {
      com.tencent.mm.sdk.b.a.udP.c(this.pKv);
      com.tencent.mm.sdk.b.a.udP.c(this.pKw);
      return;
      localc.dFz.add(locala);
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.pKv);
    com.tencent.mm.sdk.b.a.udP.d(this.pKw);
    com.tencent.mm.plugin.translate.a.c localc = this.pKs;
    Object localObject = this.pKu;
    if ((localObject == null) || (!localc.dFz.contains(localObject))) {}
    for (;;)
    {
      localc = this.pKs;
      if (localc.pKD == null) {
        break;
      }
      localObject = localc.pKD;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        f localf = localObject[i];
        if (localf != null)
        {
          au.Dk().b(631, localf);
          if (localf.pKN != null)
          {
            localf.pKP.stopTimer();
            au.Dk().c(localf.pKN);
          }
          localf.bOX();
          localf.pKL = null;
        }
        i += 1;
      }
      localc.dFz.remove(localObject);
    }
    localc.pKF.clear();
    localc.pKE.clear();
    localc.dFz.clear();
    localc.iks = 0;
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a
 * JD-Core Version:    0.7.0.1
 */