package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.wv.a;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.translate.a.c.a;
import com.tencent.mm.plugin.translate.a.c.b;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.plugin.translate.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public final class a
  implements ax
{
  com.tencent.mm.plugin.translate.a.c BAW;
  be BAX;
  private c.a BAY;
  private com.tencent.mm.sdk.b.c BAZ;
  private com.tencent.mm.sdk.b.c BBa;
  ap handler;
  
  public a()
  {
    AppMethodBeat.i(29736);
    this.BAW = c.b.BBk;
    this.BAX = new be(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    this.BAY = new c.a()
    {
      public final void a(final int paramAnonymousInt, SparseArray<c.c> paramAnonymousSparseArray)
      {
        AppMethodBeat.i(29732);
        int i = 0;
        while (i < paramAnonymousSparseArray.size())
        {
          final c.c localc = (c.c)paramAnonymousSparseArray.valueAt(i);
          if (localc != null) {
            a.this.BAX.c(new be.a()
            {
              public final boolean aEm()
              {
                AppMethodBeat.i(29731);
                ad.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", new Object[] { localc.id });
                if (paramAnonymousInt != 0)
                {
                  ad.e("MicroMsg.SubCoreTranslate", "translate error");
                  AppMethodBeat.o(29731);
                  return true;
                }
                if (localc.ret != 0)
                {
                  ad.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", new Object[] { Integer.valueOf(localc.ret) });
                  AppMethodBeat.o(29731);
                  return true;
                }
                if (bt.isNullOrNil(localc.dLs))
                {
                  ad.e("MicroMsg.SubCoreTranslate", "translate return null");
                  AppMethodBeat.o(29731);
                  return true;
                }
                bu localbu;
                if ((localc.type == 0) || (localc.type == 1))
                {
                  ad.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                  c.c localc = localc;
                  ba.aBQ();
                  localbu = com.tencent.mm.model.c.azs().xY(bt.aRf(localc.id));
                  localbu.tQ(bt.aQN(localc.dLs));
                  localbu.field_transBrandWording = bt.aQN(bt.nullAsNil(localc.dJr));
                  localbu.eLy = true;
                  localbu.fkB = localc.fkB;
                  localbu.eKU = true;
                  if (localc.dLt != 1) {
                    break label273;
                  }
                  if (localbu.frS()) {
                    localbu.jY(localbu.eLr | 0x400);
                  }
                }
                for (;;)
                {
                  ((l)g.ab(l.class)).dlK().a(localbu.field_msgId, localbu);
                  AppMethodBeat.o(29731);
                  return true;
                  label273:
                  if (localbu.frS()) {
                    localbu.jY(localbu.eLr & 0xFFFFFBFF);
                  }
                }
              }
              
              public final boolean aEn()
              {
                AppMethodBeat.i(29730);
                if (paramAnonymousInt != 0) {}
                for (int i = paramAnonymousInt;; i = localc.ret)
                {
                  wy localwy = new wy();
                  localwy.dLr.ret = i;
                  localwy.dLr.dLj = localc.dLj;
                  localwy.dLr.id = localc.id;
                  localwy.dLr.dLs = localc.dLs;
                  localwy.dLr.type = localc.type;
                  localwy.dLr.source = localc.source;
                  localwy.dLr.dJr = localc.dJr;
                  localwy.dLr.dLl = localc.fkB;
                  localwy.dLr.dLt = localc.dLt;
                  com.tencent.mm.sdk.b.a.IbL.l(localwy);
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
    this.handler = new ap(Looper.getMainLooper());
    this.BAZ = new com.tencent.mm.sdk.b.c() {};
    this.BBa = new a.3(this);
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
    com.tencent.mm.plugin.translate.a.c localc = this.BAW;
    c.a locala = this.BAY;
    if ((locala == null) || (localc.listeners.contains(locala))) {}
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IbL.c(this.BAZ);
      com.tencent.mm.sdk.b.a.IbL.c(this.BBa);
      AppMethodBeat.o(29737);
      return;
      localc.listeners.add(locala);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29738);
    com.tencent.mm.sdk.b.a.IbL.d(this.BAZ);
    com.tencent.mm.sdk.b.a.IbL.d(this.BBa);
    com.tencent.mm.plugin.translate.a.c localc = this.BAW;
    Object localObject = this.BAY;
    if ((localObject == null) || (!localc.listeners.contains(localObject))) {}
    for (;;)
    {
      localc = this.BAW;
      if (localc.BBh == null) {
        break;
      }
      localObject = localc.BBh;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        f localf = localObject[i];
        if (localf != null)
        {
          ba.aiU().b(631, localf);
          if (localf.BBq != null)
          {
            localf.BBs.stopTimer();
            ba.aiU().a(localf.BBq);
          }
          localf.erp();
          localf.BBo = null;
        }
        i += 1;
      }
      localc.listeners.remove(localObject);
    }
    localc.BBj.clear();
    localc.BBi.clear();
    localc.listeners.clear();
    localc.giC = 0;
    AppMethodBeat.o(29738);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a
 * JD-Core Version:    0.7.0.1
 */