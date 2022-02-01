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
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cg;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PluginNotifyMessage
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, c, com.tencent.mm.message.b.b
{
  private cg Mxr;
  private final i.a Mxs;
  private MMHandler mHandler;
  private com.tencent.mm.vending.b.b qDd;
  
  public PluginNotifyMessage()
  {
    AppMethodBeat.i(260354);
    this.qDd = null;
    this.mHandler = null;
    this.Mxs = new i.a()
    {
      public final void onNotifyChange(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(260358);
        if (CrashReportFactory.isBackupMerge())
        {
          AppMethodBeat.o(260358);
          return;
        }
        com.tencent.mm.message.b.a locala = PluginNotifyMessage.this.getNotifyMessageRecordStorage();
        if (locala == null)
        {
          Log.e("MicroMsg.PluginNotifyMessage", "get message notify storage return null");
          AppMethodBeat.o(260358);
          return;
        }
        if ((paramAnonymousi != null) && (paramAnonymousc.mZo != null) && (!paramAnonymousc.mZo.isEmpty()))
        {
          paramAnonymousi = paramAnonymousc.mZo.iterator();
          while (paramAnonymousi.hasNext())
          {
            cc localcc = (cc)paramAnonymousi.next();
            if ((localcc != null) && ("notifymessage".equals(paramAnonymousc.talker)))
            {
              String str2 = locala.z(localcc);
              String str1 = locala.A(localcc);
              label147:
              int i;
              if (Util.isNullOrNil(str2))
              {
                Log.i("MicroMsg.PluginNotifyMessage", "username is null or nil");
                str2 = paramAnonymousc.KRm;
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
                  locala.a(localcc, str1);
                  break;
                  localcc.BS(str2);
                  break label147;
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
              locala.y(localcc);
              continue;
              locala.b(localcc, str1);
            }
          }
          AppMethodBeat.o(260358);
          return;
        }
        if (("delete".equals(paramAnonymousc.KRm)) && ("notifymessage".equals(paramAnonymousc.talker)) && (((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLW(paramAnonymousc.talker) == 0))
        {
          Log.i("MicroMsg.PluginNotifyMessage", "clear service notify record");
          locala.bwy();
        }
        AppMethodBeat.o(260358);
      }
    };
    AppMethodBeat.o(260354);
  }
  
  private void checkNotifyRecord()
  {
    AppMethodBeat.i(260357);
    Log.i("MicroMsg.PluginNotifyMessage", "check record");
    final com.tencent.mm.message.b.a locala = getNotifyMessageRecordStorage();
    if (locala == null)
    {
      Log.e("MicroMsg.PluginNotifyMessage", "get message notify storage return null");
      AppMethodBeat.o(260357);
      return;
    }
    if (locala.bwv())
    {
      if (this.mHandler == null) {
        this.mHandler = new MMHandler("PluginNotifyMessage#syncRecord");
      }
      Log.i("MicroMsg.PluginNotifyMessage", "pre sync");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(260360);
          Log.i("MicroMsg.PluginNotifyMessage", "before sync");
          long l = Util.currentTicks();
          boolean bool = locala.bwx();
          l = Util.ticksToNow(l);
          Log.i("MicroMsg.PluginNotifyMessage", "syncNotifyRecord finish, ret: %b, cost: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
          PluginNotifyMessage.access$000(PluginNotifyMessage.this, l);
          AppMethodBeat.o(260360);
        }
      });
    }
    AppMethodBeat.o(260357);
  }
  
  private void reportTimeCost(long paramLong)
  {
    AppMethodBeat.i(260359);
    com.tencent.mm.plugin.report.service.h.OAn.p(1584L, 0L, paramLong);
    com.tencent.mm.plugin.report.service.h.OAn.p(1584L, 1L, 1L);
    paramLong /= 1000L;
    int i;
    if (paramLong >= 600L)
    {
      i = 32;
      com.tencent.mm.plugin.report.service.h.OAn.p(1584L, i, 1L);
      AppMethodBeat.o(260359);
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
    AppMethodBeat.i(260365);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("NotifyMessageRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return cg.SQL_CREATE;
      }
    });
    AppMethodBeat.o(260365);
    return localHashMap;
  }
  
  public void execute(g paramg) {}
  
  public com.tencent.mm.message.b.a getNotifyMessageRecordStorage()
  {
    AppMethodBeat.i(260369);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.Mxr == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.Mxr = new cg(com.tencent.mm.kernel.h.baE().mCN);
    }
    cg localcg = this.Mxr;
    AppMethodBeat.o(260369);
    return localcg;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(260366);
    Log.d("MicroMsg.PluginNotifyMessage", "onAccountInitialized");
    Log.i("MicroMsg.PluginNotifyMessage", "onAccountPostReset updated %b", new Object[] { Boolean.valueOf(paramc.mDg) });
    getNotifyMessageRecordStorage();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.Mxs, Looper.getMainLooper());
    checkNotifyRecord();
    AppMethodBeat.o(260366);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(260368);
    Log.d("MicroMsg.PluginNotifyMessage", "onAccountRelease");
    if (this.qDd != null)
    {
      this.qDd.dead();
      this.qDd = null;
    }
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.Mxs);
    AppMethodBeat.o(260368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notifymessage.PluginNotifyMessage
 * JD-Core Version:    0.7.0.1
 */