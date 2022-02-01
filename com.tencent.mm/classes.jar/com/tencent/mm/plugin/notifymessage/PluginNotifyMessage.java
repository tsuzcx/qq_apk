package com.tencent.mm.plugin.notifymessage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vending.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PluginNotifyMessage
  extends f
  implements com.tencent.mm.kernel.api.a, c, a
{
  private cf AHY;
  private final i.a AHZ;
  private b kJs;
  private MMHandler mHandler;
  
  public PluginNotifyMessage()
  {
    AppMethodBeat.i(231772);
    this.kJs = null;
    this.mHandler = null;
    this.AHZ = new i.a()
    {
      public final void a(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(231770);
        if ((paramAnonymousi != null) && (paramAnonymousc.hIs != null))
        {
          paramAnonymousi = paramAnonymousc.hIs.iterator();
          while (paramAnonymousi.hasNext())
          {
            ca localca = (ca)paramAnonymousi.next();
            if ((localca != null) && ("notifymessage".equals(paramAnonymousc.talker)))
            {
              cf localcf = PluginNotifyMessage.this.getNotifyMessageRecordStorage();
              if (localcf == null)
              {
                Log.e("MicroMsg.PluginNotifyMessage", "get message notify storage return null");
                AppMethodBeat.o(231770);
                return;
              }
              String str2 = cf.bc(localca);
              if (Util.isNullOrNil(str2)) {
                Log.i("MicroMsg.PluginNotifyMessage", "username is null or nil");
              }
              String str1 = cf.bd(localca);
              localca.Cy(str2);
              str2 = paramAnonymousc.zqn;
              int i = -1;
              switch (str2.hashCode())
              {
              }
              for (;;)
              {
                switch (i)
                {
                default: 
                  break;
                case 0: 
                  localcf.e(localca, str1);
                  break;
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
              localcf.bb(localca);
              continue;
              localcf.f(localca, str1);
            }
          }
        }
        AppMethodBeat.o(231770);
      }
    };
    AppMethodBeat.o(231772);
  }
  
  private void checkNotifyRecord()
  {
    AppMethodBeat.i(231777);
    Log.i("MicroMsg.PluginNotifyMessage", "check record");
    final cf localcf = getNotifyMessageRecordStorage();
    if (localcf == null)
    {
      Log.e("MicroMsg.PluginNotifyMessage", "get message notify storage return null");
      AppMethodBeat.o(231777);
      return;
    }
    if (localcf.gEh() != localcf.gEi()) {}
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
            AppMethodBeat.i(231771);
            Log.i("MicroMsg.PluginNotifyMessage", "before sync");
            long l1 = Util.currentTicks();
            cf localcf = localcf;
            boolean bool;
            if (cf.Orv)
            {
              Log.e("MicroMsg.NotifyMessageRecordStorage", "sync is running");
              bool = false;
            }
            for (;;)
            {
              l1 = Util.ticksToNow(l1);
              Log.i("MicroMsg.PluginNotifyMessage", "syncNotifyRecord finish, ret: %b, cost: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
              PluginNotifyMessage.access$000(PluginNotifyMessage.this, l1);
              AppMethodBeat.o(231771);
              return;
              Log.i("MicroMsg.NotifyMessageRecordStorage", "syncRecord");
              long l2 = Util.currentTicks();
              cf.Orv = true;
              bool = localcf.gEj();
              Log.i("MicroMsg.NotifyMessageRecordStorage", "handle msg info done, cost: %d", new Object[] { Long.valueOf(Util.ticksToNow(l2)) });
              cf.Orv = false;
            }
          }
        });
      }
      AppMethodBeat.o(231777);
      return;
    }
  }
  
  private void reportTimeCost(long paramLong)
  {
    AppMethodBeat.i(231778);
    h.CyF.n(1584L, 0L, paramLong);
    h.CyF.n(1584L, 1L, 1L);
    paramLong /= 1000L;
    int i;
    if (paramLong >= 600L)
    {
      i = 32;
      h.CyF.n(1584L, i, 1L);
      AppMethodBeat.o(231778);
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
    AppMethodBeat.i(231773);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("NotifyMessageRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return cf.SQL_CREATE;
      }
    });
    AppMethodBeat.o(231773);
    return localHashMap;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public cf getNotifyMessageRecordStorage()
  {
    AppMethodBeat.i(231776);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.AHY == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.AHY = new cf(com.tencent.mm.kernel.g.aAh().hqK);
    }
    cf localcf = this.AHY;
    AppMethodBeat.o(231776);
    return localcf;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(231774);
    Log.d("MicroMsg.PluginNotifyMessage", "onAccountInitialized");
    Log.i("MicroMsg.PluginNotifyMessage", "onAccountPostReset updated %b", new Object[] { Boolean.valueOf(paramc.hrc) });
    getNotifyMessageRecordStorage();
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.AHZ, Looper.getMainLooper());
    checkNotifyRecord();
    AppMethodBeat.o(231774);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(231775);
    Log.d("MicroMsg.PluginNotifyMessage", "onAccountRelease");
    if (this.kJs != null)
    {
      this.kJs.dead();
      this.kJs = null;
    }
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.AHZ);
    AppMethodBeat.o(231775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.notifymessage.PluginNotifyMessage
 * JD-Core Version:    0.7.0.1
 */