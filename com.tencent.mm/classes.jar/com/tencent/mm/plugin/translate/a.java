package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wz;
import com.tencent.mm.g.a.wz.a;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.translate.a.c.a;
import com.tencent.mm.plugin.translate.a.c.b;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.plugin.translate.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public final class a
  implements az
{
  com.tencent.mm.plugin.translate.a.c BSu;
  bf BSv;
  private c.a BSw;
  private com.tencent.mm.sdk.b.c BSx;
  private com.tencent.mm.sdk.b.c BSy;
  aq handler;
  
  public a()
  {
    AppMethodBeat.i(29736);
    this.BSu = c.b.BSI;
    this.BSv = new bf(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    this.BSw = new c.a()
    {
      public final void a(final int paramAnonymousInt, SparseArray<c.c> paramAnonymousSparseArray)
      {
        AppMethodBeat.i(29732);
        int i = 0;
        while (i < paramAnonymousSparseArray.size())
        {
          final c.c localc = (c.c)paramAnonymousSparseArray.valueAt(i);
          if (localc != null) {
            a.this.BSv.c(new bf.a()
            {
              public final boolean aEC()
              {
                AppMethodBeat.i(29731);
                ae.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", new Object[] { localc.id });
                if (paramAnonymousInt != 0)
                {
                  ae.e("MicroMsg.SubCoreTranslate", "translate error");
                  AppMethodBeat.o(29731);
                  return true;
                }
                if (localc.ret != 0)
                {
                  ae.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", new Object[] { Integer.valueOf(localc.ret) });
                  AppMethodBeat.o(29731);
                  return true;
                }
                if (bu.isNullOrNil(localc.dMH))
                {
                  ae.e("MicroMsg.SubCoreTranslate", "translate return null");
                  AppMethodBeat.o(29731);
                  return true;
                }
                bv localbv;
                if ((localc.type == 0) || (localc.type == 1))
                {
                  ae.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                  c.c localc = localc;
                  bc.aCg();
                  localbv = com.tencent.mm.model.c.azI().ys(bu.aSC(localc.id));
                  localbv.ul(bu.aSk(localc.dMH));
                  localbv.field_transBrandWording = bu.aSk(bu.nullAsNil(localc.dKF));
                  localbv.eNj = true;
                  localbv.fmy = localc.fmy;
                  localbv.eMD = true;
                  if (localc.dMI != 1) {
                    break label273;
                  }
                  if (localbv.fvS()) {
                    localbv.ka(localbv.eNc | 0x400);
                  }
                }
                for (;;)
                {
                  ((l)g.ab(l.class)).doJ().a(localbv.field_msgId, localbv);
                  AppMethodBeat.o(29731);
                  return true;
                  label273:
                  if (localbv.fvS()) {
                    localbv.ka(localbv.eNc & 0xFFFFFBFF);
                  }
                }
              }
              
              public final boolean aED()
              {
                AppMethodBeat.i(29730);
                if (paramAnonymousInt != 0) {}
                for (int i = paramAnonymousInt;; i = localc.ret)
                {
                  xc localxc = new xc();
                  localxc.dMG.ret = i;
                  localxc.dMG.dMy = localc.dMy;
                  localxc.dMG.id = localc.id;
                  localxc.dMG.dMH = localc.dMH;
                  localxc.dMG.type = localc.type;
                  localxc.dMG.source = localc.source;
                  localxc.dMG.dKF = localc.dKF;
                  localxc.dMG.dMA = localc.fmy;
                  localxc.dMG.dMI = localc.dMI;
                  com.tencent.mm.sdk.b.a.IvT.l(localxc);
                  AppMethodBeat.o(29730);
                  return false;
                }
              }
            });
          }
          i += 1;
        }
        AppMethodBeat.o(29732);
      }
    };
    this.handler = new aq(Looper.getMainLooper());
    this.BSx = new com.tencent.mm.sdk.b.c() {};
    this.BSy = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(29736);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(29737);
    com.tencent.mm.plugin.translate.a.c localc = this.BSu;
    c.a locala = this.BSw;
    if ((locala == null) || (localc.listeners.contains(locala))) {}
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IvT.c(this.BSx);
      com.tencent.mm.sdk.b.a.IvT.c(this.BSy);
      AppMethodBeat.o(29737);
      return;
      localc.listeners.add(locala);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29738);
    com.tencent.mm.sdk.b.a.IvT.d(this.BSx);
    com.tencent.mm.sdk.b.a.IvT.d(this.BSy);
    com.tencent.mm.plugin.translate.a.c localc = this.BSu;
    Object localObject = this.BSw;
    if ((localObject == null) || (!localc.listeners.contains(localObject))) {}
    for (;;)
    {
      localc = this.BSu;
      if (localc.BSF == null) {
        break;
      }
      localObject = localc.BSF;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        f localf = localObject[i];
        if (localf != null)
        {
          bc.ajj().b(631, localf);
          if (localf.BSO != null)
          {
            localf.BSQ.stopTimer();
            bc.ajj().a(localf.BSO);
          }
          localf.euW();
          localf.BSM = null;
        }
        i += 1;
      }
      localc.listeners.remove(localObject);
    }
    localc.BSH.clear();
    localc.BSG.clear();
    localc.listeners.clear();
    localc.gkU = 0;
    AppMethodBeat.o(29738);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a
 * JD-Core Version:    0.7.0.1
 */