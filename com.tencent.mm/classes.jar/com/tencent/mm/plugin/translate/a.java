package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wc;
import com.tencent.mm.g.a.wc.a;
import com.tencent.mm.g.a.we;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.translate.a.c.a;
import com.tencent.mm.plugin.translate.a.c.b;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.plugin.translate.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public final class a
  implements aw
{
  com.tencent.mm.plugin.translate.a.c Ajk;
  bd Ajl;
  private c.a Ajm;
  private com.tencent.mm.sdk.b.c Ajn;
  private com.tencent.mm.sdk.b.c Ajo;
  ao handler;
  
  public a()
  {
    AppMethodBeat.i(29736);
    this.Ajk = c.b.Ajy;
    this.Ajl = new bd(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    this.Ajm = new c.a()
    {
      public final void a(final int paramAnonymousInt, SparseArray<c.c> paramAnonymousSparseArray)
      {
        AppMethodBeat.i(29732);
        int i = 0;
        while (i < paramAnonymousSparseArray.size())
        {
          final c.c localc = (c.c)paramAnonymousSparseArray.valueAt(i);
          if (localc != null) {
            a.this.Ajl.c(new bd.a()
            {
              public final boolean aBj()
              {
                AppMethodBeat.i(29731);
                ac.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", new Object[] { localc.id });
                if (paramAnonymousInt != 0)
                {
                  ac.e("MicroMsg.SubCoreTranslate", "translate error");
                  AppMethodBeat.o(29731);
                  return true;
                }
                if (localc.ret != 0)
                {
                  ac.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", new Object[] { Integer.valueOf(localc.ret) });
                  AppMethodBeat.o(29731);
                  return true;
                }
                if (bs.isNullOrNil(localc.dzg))
                {
                  ac.e("MicroMsg.SubCoreTranslate", "translate return null");
                  AppMethodBeat.o(29731);
                  return true;
                }
                bo localbo;
                if ((localc.type == 0) || (localc.type == 1))
                {
                  ac.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                  c.c localc = localc;
                  az.ayM();
                  localbo = com.tencent.mm.model.c.awD().vP(bs.aLz(localc.id));
                  localbo.rh(bs.aLh(localc.dzg));
                  localbo.field_transBrandWording = bs.aLh(bs.nullAsNil(localc.dxf));
                  localbo.eRS = true;
                  localbo.eSm = localc.eSm;
                  localbo.etL = true;
                  if (localc.dzh != 1) {
                    break label273;
                  }
                  if (localbo.fbO()) {
                    localbo.jA(localbo.euk | 0x400);
                  }
                }
                for (;;)
                {
                  ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(localbo.field_msgId, localbo);
                  AppMethodBeat.o(29731);
                  return true;
                  label273:
                  if (localbo.fbO()) {
                    localbo.jA(localbo.euk & 0xFFFFFBFF);
                  }
                }
              }
              
              public final boolean aBk()
              {
                AppMethodBeat.i(29730);
                if (paramAnonymousInt != 0) {}
                for (int i = paramAnonymousInt;; i = localc.ret)
                {
                  wf localwf = new wf();
                  localwf.dzf.ret = i;
                  localwf.dzf.dyX = localc.dyX;
                  localwf.dzf.id = localc.id;
                  localwf.dzf.dzg = localc.dzg;
                  localwf.dzf.type = localc.type;
                  localwf.dzf.source = localc.source;
                  localwf.dzf.dxf = localc.dxf;
                  localwf.dzf.dyZ = localc.eSm;
                  localwf.dzf.dzh = localc.dzh;
                  com.tencent.mm.sdk.b.a.GpY.l(localwf);
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
    this.handler = new ao(Looper.getMainLooper());
    this.Ajn = new com.tencent.mm.sdk.b.c() {};
    this.Ajo = new com.tencent.mm.sdk.b.c() {};
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
    com.tencent.mm.plugin.translate.a.c localc = this.Ajk;
    c.a locala = this.Ajm;
    if ((locala == null) || (localc.listeners.contains(locala))) {}
    for (;;)
    {
      com.tencent.mm.sdk.b.a.GpY.c(this.Ajn);
      com.tencent.mm.sdk.b.a.GpY.c(this.Ajo);
      AppMethodBeat.o(29737);
      return;
      localc.listeners.add(locala);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29738);
    com.tencent.mm.sdk.b.a.GpY.d(this.Ajn);
    com.tencent.mm.sdk.b.a.GpY.d(this.Ajo);
    com.tencent.mm.plugin.translate.a.c localc = this.Ajk;
    Object localObject = this.Ajm;
    if ((localObject == null) || (!localc.listeners.contains(localObject))) {}
    for (;;)
    {
      localc = this.Ajk;
      if (localc.Ajv == null) {
        break;
      }
      localObject = localc.Ajv;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        com.tencent.mm.ak.g localg = localObject[i];
        if (localg != null)
        {
          az.agi().b(631, localg);
          if (localg.AjE != null)
          {
            localg.AjG.stopTimer();
            az.agi().a(localg.AjE);
          }
          localg.eeY();
          localg.AjC = null;
        }
        i += 1;
      }
      localc.listeners.remove(localObject);
    }
    localc.Ajx.clear();
    localc.Ajw.clear();
    localc.listeners.clear();
    localc.fPc = 0;
    AppMethodBeat.o(29738);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a
 * JD-Core Version:    0.7.0.1
 */