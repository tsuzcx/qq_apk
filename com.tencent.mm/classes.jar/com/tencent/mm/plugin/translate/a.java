package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.zh;
import com.tencent.mm.f.a.zh.a;
import com.tencent.mm.f.a.zj;
import com.tencent.mm.f.a.zk;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.translate.a.c;
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
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public final class a
  implements be
{
  private c NfM;
  private QueueWorkerThread NfN;
  private c.a NfO;
  private IListener NfP;
  private IListener NfQ;
  private MMHandler handler;
  
  public a()
  {
    AppMethodBeat.i(29736);
    this.NfM = c.b.Nga;
    this.NfN = new QueueWorkerThread(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    this.NfO = new c.a()
    {
      public final void a(final int paramAnonymousInt, SparseArray<c.c> paramAnonymousSparseArray)
      {
        AppMethodBeat.i(29732);
        int i = 0;
        while (i < paramAnonymousSparseArray.size())
        {
          final c.c localc = (c.c)paramAnonymousSparseArray.valueAt(i);
          if (localc != null) {
            a.a(a.this).add(new QueueWorkerThread.ThreadObject()
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
                if (Util.isNullOrNil(localc.fYO))
                {
                  Log.e("MicroMsg.SubCoreTranslate", "translate return null");
                  AppMethodBeat.o(29731);
                  return true;
                }
                if ((localc.type == 0) || (localc.type == 1))
                {
                  Log.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                  a.a(localc);
                }
                AppMethodBeat.o(29731);
                return true;
              }
              
              public final boolean onPostExecute()
              {
                AppMethodBeat.i(29730);
                if (paramAnonymousInt != 0) {}
                for (int i = paramAnonymousInt;; i = localc.ret)
                {
                  zk localzk = new zk();
                  localzk.fYN.ret = i;
                  localzk.fYN.fYF = localc.fYF;
                  localzk.fYN.id = localc.id;
                  localzk.fYN.fYO = localc.fYO;
                  localzk.fYN.type = localc.type;
                  localzk.fYN.source = localc.source;
                  localzk.fYN.fWy = localc.fWy;
                  localzk.fYN.fYH = localc.ils;
                  localzk.fYN.fYP = localc.fYP;
                  EventCenter.instance.publish(localzk);
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
    this.NfP = new IListener() {};
    this.NfQ = new IListener() {};
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
    c localc = this.NfM;
    c.a locala = this.NfO;
    if ((locala == null) || (localc.listeners.contains(locala))) {}
    for (;;)
    {
      EventCenter.instance.addListener(this.NfP);
      EventCenter.instance.addListener(this.NfQ);
      AppMethodBeat.o(29737);
      return;
      localc.listeners.add(locala);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29738);
    EventCenter.instance.removeListener(this.NfP);
    EventCenter.instance.removeListener(this.NfQ);
    c localc = this.NfM;
    Object localObject = this.NfO;
    if ((localObject == null) || (!localc.listeners.contains(localObject))) {}
    for (;;)
    {
      localc = this.NfM;
      if (localc.NfX == null) {
        break;
      }
      localObject = localc.NfX;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        i locali = localObject[i];
        if (locali != null)
        {
          bh.aGY().b(631, locali);
          if (locali.Ngg != null)
          {
            locali.Ngi.stopTimer();
            bh.aGY().a(locali.Ngg);
          }
          locali.gsq();
          locali.Nge = null;
        }
        i += 1;
      }
      localc.listeners.remove(localObject);
    }
    localc.NfZ.clear();
    localc.NfY.clear();
    localc.listeners.clear();
    localc.jGL = 0;
    AppMethodBeat.o(29738);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a
 * JD-Core Version:    0.7.0.1
 */