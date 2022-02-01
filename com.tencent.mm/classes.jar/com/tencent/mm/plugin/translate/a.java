package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.ya.a;
import com.tencent.mm.g.a.yc;
import com.tencent.mm.g.a.yd;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.translate.a.c.a;
import com.tencent.mm.plugin.translate.a.c.b;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.plugin.translate.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public final class a
  implements bd
{
  com.tencent.mm.plugin.translate.a.c Gta;
  QueueWorkerThread Gtb;
  private c.a Gtc;
  private IListener Gtd;
  private IListener Gte;
  MMHandler handler;
  
  public a()
  {
    AppMethodBeat.i(29736);
    this.Gta = c.b.Gto;
    this.Gtb = new QueueWorkerThread(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    this.Gtc = new c.a()
    {
      public final void a(final int paramAnonymousInt, SparseArray<c.c> paramAnonymousSparseArray)
      {
        AppMethodBeat.i(29732);
        int i = 0;
        while (i < paramAnonymousSparseArray.size())
        {
          final c.c localc = (c.c)paramAnonymousSparseArray.valueAt(i);
          if (localc != null) {
            a.this.Gtb.add(new QueueWorkerThread.ThreadObject()
            {
              public final boolean doInBackground()
              {
                AppMethodBeat.i(29731);
                Log.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", new Object[] { localc.id });
                if (paramAnonymousInt != 0)
                {
                  Log.e("MicroMsg.SubCoreTranslate", "translate error");
                  AppMethodBeat.o(29731);
                  return true;
                }
                if (localc.ret != 0)
                {
                  Log.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", new Object[] { Integer.valueOf(localc.ret) });
                  AppMethodBeat.o(29731);
                  return true;
                }
                if (Util.isNullOrNil(localc.eez))
                {
                  Log.e("MicroMsg.SubCoreTranslate", "translate return null");
                  AppMethodBeat.o(29731);
                  return true;
                }
                ca localca;
                if ((localc.type == 0) || (localc.type == 1))
                {
                  Log.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                  c.c localc = localc;
                  bg.aVF();
                  localca = com.tencent.mm.model.c.aSQ().Hb(Util.safeParseLong(localc.id));
                  localca.CB(localc.eez);
                  localca.field_transBrandWording = Util.escapeSqlValue(Util.nullAsNil(localc.ecu));
                  localca.fqQ = true;
                  localca.fRc = localc.fRc;
                  localca.fqk = true;
                  if (localc.eeA != 1) {
                    break label270;
                  }
                  if (localca.gDz()) {
                    localca.nc(localca.fqJ | 0x400);
                  }
                }
                for (;;)
                {
                  ((l)g.af(l.class)).eiy().a(localca.field_msgId, localca);
                  AppMethodBeat.o(29731);
                  return true;
                  label270:
                  if (localca.gDz()) {
                    localca.nc(localca.fqJ & 0xFFFFFBFF);
                  }
                }
              }
              
              public final boolean onPostExecute()
              {
                AppMethodBeat.i(29730);
                if (paramAnonymousInt != 0) {}
                for (int i = paramAnonymousInt;; i = localc.ret)
                {
                  yd localyd = new yd();
                  localyd.eey.ret = i;
                  localyd.eey.eeq = localc.eeq;
                  localyd.eey.id = localc.id;
                  localyd.eey.eez = localc.eez;
                  localyd.eey.type = localc.type;
                  localyd.eey.source = localc.source;
                  localyd.eey.ecu = localc.ecu;
                  localyd.eey.ees = localc.fRc;
                  localyd.eey.eeA = localc.eeA;
                  EventCenter.instance.publish(localyd);
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
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Gtd = new IListener() {};
    this.Gte = new IListener() {};
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
    com.tencent.mm.plugin.translate.a.c localc = this.Gta;
    c.a locala = this.Gtc;
    if ((locala == null) || (localc.listeners.contains(locala))) {}
    for (;;)
    {
      EventCenter.instance.addListener(this.Gtd);
      EventCenter.instance.addListener(this.Gte);
      AppMethodBeat.o(29737);
      return;
      localc.listeners.add(locala);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29738);
    EventCenter.instance.removeListener(this.Gtd);
    EventCenter.instance.removeListener(this.Gte);
    com.tencent.mm.plugin.translate.a.c localc = this.Gta;
    Object localObject = this.Gtc;
    if ((localObject == null) || (!localc.listeners.contains(localObject))) {}
    for (;;)
    {
      localc = this.Gta;
      if (localc.Gtl == null) {
        break;
      }
      localObject = localc.Gtl;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        com.tencent.mm.ak.i locali = localObject[i];
        if (locali != null)
        {
          bg.azz().b(631, locali);
          if (locali.Gtu != null)
          {
            locali.Gtw.stopTimer();
            bg.azz().a(locali.Gtu);
          }
          locali.fAp();
          locali.Gts = null;
        }
        i += 1;
      }
      localc.listeners.remove(localObject);
    }
    localc.Gtn.clear();
    localc.Gtm.clear();
    localc.listeners.clear();
    localc.gVP = 0;
    AppMethodBeat.o(29738);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a
 * JD-Core Version:    0.7.0.1
 */