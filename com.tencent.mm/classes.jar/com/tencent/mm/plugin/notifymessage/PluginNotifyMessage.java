package com.tencent.mm.plugin.notifymessage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PluginNotifyMessage
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, c, a
{
  private cf GBi;
  private final i.a GBj;
  private MMHandler mHandler;
  private com.tencent.mm.vending.b.b nDk;
  
  public PluginNotifyMessage()
  {
    AppMethodBeat.i(274603);
    this.nDk = null;
    this.mHandler = null;
    this.GBj = new i.a()
    {
      public final void onNotifyChange(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(276377);
        if (CrashReportFactory.isBackupMerge())
        {
          AppMethodBeat.o(276377);
          return;
        }
        if ((paramAnonymousi != null) && (paramAnonymousc.kvM != null))
        {
          paramAnonymousi = paramAnonymousc.kvM.iterator();
          while (paramAnonymousi.hasNext())
          {
            ca localca = (ca)paramAnonymousi.next();
            if ((localca != null) && ("notifymessage".equals(paramAnonymousc.talker)))
            {
              cf localcf = PluginNotifyMessage.this.getNotifyMessageRecordStorage();
              if (localcf == null)
              {
                Log.e("MicroMsg.PluginNotifyMessage", "get message notify storage return null");
                AppMethodBeat.o(276377);
                return;
              }
              String str2 = cf.bv(localca);
              String str1 = cf.bw(localca);
              label129:
              int i;
              if (Util.isNullOrNil(str2))
              {
                Log.i("MicroMsg.PluginNotifyMessage", "username is null or nil");
                str2 = paramAnonymousc.EVM;
                i = -1;
                switch (str2.hashCode())
                {
                }
              }
              for (;;)
              {
                switch (i)
                {
                default: 
                  break;
                case 0: 
                  localcf.g(localca, str1);
                  break;
                  localca.Jm(str2);
                  break label129;
                  if (str2.equals("insert"))
                  {
                    i = 0;
                    continue;
                    if (str2.equals("delete"))
                    {
                      i = 1;
                      continue;
                      if (str2.equals("update")) {
                        i = 2;
                      }
                    }
                  }
                  break;
                }
              }
              localcf.bu(localca);
              continue;
              localcf.h(localca, str1);
            }
          }
        }
        AppMethodBeat.o(276377);
      }
    };
    AppMethodBeat.o(274603);
  }
  
  private void checkNotifyRecord()
  {
    AppMethodBeat.i(274614);
    Log.i("MicroMsg.PluginNotifyMessage", "check record");
    final cf localcf = getNotifyMessageRecordStorage();
    if (localcf == null)
    {
      Log.e("MicroMsg.PluginNotifyMessage", "get message notify storage return null");
      AppMethodBeat.o(274614);
      return;
    }
    if (localcf.hAx() != localcf.hAy()) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NotifyMessageRecordStorage", "need sync record: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        if (this.mHandler == null) {
          this.mHandler = new MMHandler("PluginNotifyMessage#syncRecord");
        }
        Log.i("MicroMsg.PluginNotifyMessage", "pre sync");
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(290094);
            Log.i("MicroMsg.PluginNotifyMessage", "before sync");
            long l1 = Util.currentTicks();
            cf localcf = localcf;
            boolean bool;
            if (cf.VHr)
            {
              Log.e("MicroMsg.NotifyMessageRecordStorage", "sync is running");
              bool = false;
            }
            for (;;)
            {
              l1 = Util.ticksToNow(l1);
              Log.i("MicroMsg.PluginNotifyMessage", "syncNotifyRecord finish, ret: %b, cost: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
              PluginNotifyMessage.access$000(PluginNotifyMessage.this, l1);
              AppMethodBeat.o(290094);
              return;
              Log.i("MicroMsg.NotifyMessageRecordStorage", "syncRecord");
              long l2 = Util.currentTicks();
              cf.VHr = true;
              bool = localcf.hAz();
              Log.i("MicroMsg.NotifyMessageRecordStorage", "handle msg info done, cost: %d", new Object[] { Long.valueOf(Util.ticksToNow(l2)) });
              cf.VHr = false;
            }
          }
        });
      }
      AppMethodBeat.o(274614);
      return;
    }
  }
  
  private void reportTimeCost(long paramLong)
  {
    AppMethodBeat.i(274615);
    com.tencent.mm.plugin.report.service.h.IzE.p(1584L, 0L, paramLong);
    com.tencent.mm.plugin.report.service.h.IzE.p(1584L, 1L, 1L);
    paramLong /= 1000L;
    int i;
    if (paramLong >= 600L)
    {
      i = 32;
      com.tencent.mm.plugin.report.service.h.IzE.p(1584L, i, 1L);
      AppMethodBeat.o(274615);
      return;
    }
    int k = 21;
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= 11) {
        break;
      }
      if (paramLong < new int[] { 5, 10, 20, 30, 40, 50, 60, 90, 180, 360, 600 }[j])
      {
        i = j + 21;
        break;
      }
      j += 1;
    }
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(274606);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("NotifyMessageRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return cf.SQL_CREATE;
      }
    });
    AppMethodBeat.o(274606);
    return localHashMap;
  }
  
  public void execute(g paramg) {}
  
  public cf getNotifyMessageRecordStorage()
  {
    AppMethodBeat.i(274611);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.GBi == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.GBi = new cf(com.tencent.mm.kernel.h.aHG().kcF);
    }
    cf localcf = this.GBi;
    AppMethodBeat.o(274611);
    return localcf;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(274607);
    Log.d("MicroMsg.PluginNotifyMessage", "onAccountInitialized");
    Log.i("MicroMsg.PluginNotifyMessage", "onAccountPostReset updated %b", new Object[] { Boolean.valueOf(paramc.kcX) });
    getNotifyMessageRecordStorage();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.GBj, Looper.getMainLooper());
    checkNotifyRecord();
    AppMethodBeat.o(274607);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(274609);
    Log.d("MicroMsg.PluginNotifyMessage", "onAccountRelease");
    if (this.nDk != null)
    {
      this.nDk.dead();
      this.nDk = null;
    }
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.GBj);
    AppMethodBeat.o(274609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notifymessage.PluginNotifyMessage
 * JD-Core Version:    0.7.0.1
 */