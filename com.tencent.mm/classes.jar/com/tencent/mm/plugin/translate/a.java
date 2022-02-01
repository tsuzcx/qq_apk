package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.g.a.vr.a;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
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
import com.tencent.mm.storage.bl;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public final class a
  implements aw
{
  ap handler;
  com.tencent.mm.plugin.translate.a.c yVv;
  be yVw;
  private c.a yVx;
  private com.tencent.mm.sdk.b.c yVy;
  private com.tencent.mm.sdk.b.c yVz;
  
  public a()
  {
    AppMethodBeat.i(29736);
    this.yVv = c.b.yVJ;
    this.yVw = new be(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    this.yVx = new c.a()
    {
      public final void a(final int paramAnonymousInt, SparseArray<c.c> paramAnonymousSparseArray)
      {
        AppMethodBeat.i(29732);
        int i = 0;
        while (i < paramAnonymousSparseArray.size())
        {
          final c.c localc = (c.c)paramAnonymousSparseArray.valueAt(i);
          if (localc != null) {
            a.this.yVw.c(new be.a()
            {
              public final boolean aus()
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
                if (bt.isNullOrNil(localc.dBs))
                {
                  ad.e("MicroMsg.SubCoreTranslate", "translate return null");
                  AppMethodBeat.o(29731);
                  return true;
                }
                bl localbl;
                if ((localc.type == 0) || (localc.type == 1))
                {
                  ad.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                  c.c localc = localc;
                  az.arV();
                  localbl = com.tencent.mm.model.c.apO().rm(bt.aGi(localc.id));
                  localbl.ob(bt.aFQ(localc.dBs));
                  localbl.field_transBrandWording = bt.aFQ(bt.nullAsNil(localc.dzt));
                  localbl.eOK = true;
                  localbl.ePe = localc.ePe;
                  localbl.erH = true;
                  if (localc.dBt != 1) {
                    break label273;
                  }
                  if (localbl.eMj()) {
                    localbl.jC(localbl.esg | 0x400);
                  }
                }
                for (;;)
                {
                  ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(localbl.field_msgId, localbl);
                  AppMethodBeat.o(29731);
                  return true;
                  label273:
                  if (localbl.eMj()) {
                    localbl.jC(localbl.esg & 0xFFFFFBFF);
                  }
                }
              }
              
              public final boolean aut()
              {
                AppMethodBeat.i(29730);
                if (paramAnonymousInt != 0) {}
                for (int i = paramAnonymousInt;; i = localc.ret)
                {
                  vu localvu = new vu();
                  localvu.dBr.ret = i;
                  localvu.dBr.dBj = localc.dBj;
                  localvu.dBr.id = localc.id;
                  localvu.dBr.dBs = localc.dBs;
                  localvu.dBr.type = localc.type;
                  localvu.dBr.source = localc.source;
                  localvu.dBr.dzt = localc.dzt;
                  localvu.dBr.dBl = localc.ePe;
                  localvu.dBr.dBt = localc.dBt;
                  com.tencent.mm.sdk.b.a.ESL.l(localvu);
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
    this.yVy = new com.tencent.mm.sdk.b.c() {};
    this.yVz = new com.tencent.mm.sdk.b.c() {};
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
    com.tencent.mm.plugin.translate.a.c localc = this.yVv;
    c.a locala = this.yVx;
    if ((locala == null) || (localc.fYf.contains(locala))) {}
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ESL.c(this.yVy);
      com.tencent.mm.sdk.b.a.ESL.c(this.yVz);
      AppMethodBeat.o(29737);
      return;
      localc.fYf.add(locala);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29738);
    com.tencent.mm.sdk.b.a.ESL.d(this.yVy);
    com.tencent.mm.sdk.b.a.ESL.d(this.yVz);
    com.tencent.mm.plugin.translate.a.c localc = this.yVv;
    Object localObject = this.yVx;
    if ((localObject == null) || (!localc.fYf.contains(localObject))) {}
    for (;;)
    {
      localc = this.yVv;
      if (localc.yVG == null) {
        break;
      }
      localObject = localc.yVG;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        com.tencent.mm.al.g localg = localObject[i];
        if (localg != null)
        {
          az.aeS().b(631, localg);
          if (localg.yVP != null)
          {
            localg.yVR.stopTimer();
            az.aeS().a(localg.yVP);
          }
          localg.dQz();
          localg.yVN = null;
        }
        i += 1;
      }
      localc.fYf.remove(localObject);
    }
    localc.yVI.clear();
    localc.yVH.clear();
    localc.fYf.clear();
    localc.fLq = 0;
    AppMethodBeat.o(29738);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a
 * JD-Core Version:    0.7.0.1
 */