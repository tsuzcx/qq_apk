package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.be;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.LinkedList;

public class ac
  implements ar
{
  private ab neI;
  private v nfk;
  private b nfl = new b();
  
  private static ac btE()
  {
    return (ac)p.B(ac.class);
  }
  
  public static v btF()
  {
    g.DN().CX();
    if (btE().nfk == null) {
      btE().nfk = new v(d.spa, d.dOM);
    }
    return btE().nfk;
  }
  
  public static ab btG()
  {
    g.DN().CX();
    if (btE().neI == null) {
      btE().neI = new ab();
    }
    return btE().neI;
  }
  
  public static void btH()
  {
    bd.iL("qqmail");
    ((j)g.r(j.class)).FB().abu("qqmail");
    v localv = btF();
    e.K(v.btA(), true);
    localv.reset();
  }
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.sdk.b.a.udP.c(this.nfl);
    g.DS().O(new Runnable()
    {
      public final void run()
      {
        if (!g.DK()) {
          return;
        }
        long l = System.currentTimeMillis();
        y localy = new y();
        if (localy.neG.maL.size() > 0)
        {
          int i = 0;
          while (i < localy.neG.maL.size())
          {
            y.Lm(((w)localy.neG.maL.get(i)).ndx);
            i += 1;
          }
          localy.neG.maL.clear();
          localy.save();
        }
        com.tencent.mm.sdk.platformtools.y.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
    });
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt)
  {
    if ((paramInt & 0x1) != 0) {
      btH();
    }
  }
  
  public final void onAccountRelease()
  {
    v localv = btE().nfk;
    if (localv != null) {
      localv.reset();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.nfl);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ac
 * JD-Core Version:    0.7.0.1
 */