package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.e;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.f.a.pi;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.priority.model.a.a.a.a;
import com.tencent.mm.plugin.priority.model.d.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PluginPriority
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.priority.a.a
{
  private MStorageEx.IOnStorageChange BJX;
  private MStorageEx.IOnStorageChange BJY;
  private long GRN;
  private com.tencent.mm.plugin.priority.model.b GRO;
  private com.tencent.mm.plugin.priority.model.a.c.c GRP;
  private com.tencent.mm.plugin.priority.model.a.b.c GRQ;
  private com.tencent.mm.plugin.priority.model.a.c.d GRR;
  private com.tencent.mm.plugin.priority.model.a.b.d GRS;
  private com.tencent.mm.plugin.priority.model.a.a.c GRT;
  private com.tencent.mm.plugin.priority.model.a.a.b GRU;
  private com.tencent.mm.plugin.priority.model.d GRV;
  private com.tencent.mm.plugin.priority.model.a.c.b GRW;
  private com.tencent.mm.plugin.priority.model.a.b.b GRX;
  private com.tencent.mm.plugin.priority.model.a.a.a GRY;
  private com.tencent.mm.plugin.priority.model.a.c.a GRZ;
  private com.tencent.mm.plugin.priority.model.a.b.a GSa;
  private i.a GSb;
  private IListener<pi> GSc;
  
  public PluginPriority()
  {
    AppMethodBeat.i(87770);
    this.GSb = new i.a()
    {
      public final void onNotifyChange(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(87765);
        if (CrashReportFactory.isBackupMerge())
        {
          AppMethodBeat.o(87765);
          return;
        }
        if (paramAnonymousc.EVM.equals("insert"))
        {
          int i = 0;
          if (i < paramAnonymousc.kvM.size())
          {
            paramAnonymousi = (ca)paramAnonymousc.kvM.get(i);
            label82:
            com.tencent.mm.plugin.priority.model.a.a.a locala;
            if ((paramAnonymousi.field_isSend == 0) && (paramAnonymousi.hwG()))
            {
              ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).aB(paramAnonymousi);
              if (PluginPriority.this.getC2CChatUsageLogic() != null)
              {
                if (paramAnonymousi.field_isSend != 1) {
                  break label177;
                }
                locala = PluginPriority.this.getC2CChatUsageLogic();
                paramAnonymousi = paramAnonymousi.field_talker;
                ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, paramAnonymousi, 1));
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if ((paramAnonymousi.field_isSend != 0) || (!paramAnonymousi.erk())) {
                break label82;
              }
              ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).aC(paramAnonymousi);
              break label82;
              label177:
              locala = PluginPriority.this.getC2CChatUsageLogic();
              paramAnonymousi = paramAnonymousi.field_talker;
              ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, paramAnonymousi, 3));
            }
          }
        }
        AppMethodBeat.o(87765);
      }
    };
    this.GSc = new IListener() {};
    this.BJX = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(87767);
        paramAnonymousMStorageEx = (String)paramAnonymousObject;
        if (Util.isNullOrNil(paramAnonymousMStorageEx))
        {
          AppMethodBeat.o(87767);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(87767);
          return;
          if (PluginPriority.this.getPriorityTaskRunner() != null) {
            PluginPriority.this.getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.d(paramAnonymousMStorageEx));
          }
        }
      }
    };
    this.BJY = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(87768);
        paramAnonymousMStorageEx = (String)paramAnonymousObject;
        if (Util.isNullOrNil(paramAnonymousMStorageEx))
        {
          AppMethodBeat.o(87768);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(87768);
          return;
          if (PluginPriority.this.getPriorityTaskRunner() != null) {
            PluginPriority.this.getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.d(paramAnonymousMStorageEx));
          }
        }
      }
    };
    AppMethodBeat.o(87770);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(87773);
    if (paramg.aIE()) {
      h.b(com.tencent.mm.plugin.comm.a.b.class, new a());
    }
    AppMethodBeat.o(87773);
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.a getC2CChatUsageLogic()
  {
    return this.GRY;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.b getC2CChatUsageResultStorage()
  {
    return this.GRU;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.c getC2CChatUsageStorage()
  {
    return this.GRT;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.a getC2CFileAutoDownloader()
  {
    return this.GSa;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.a getC2CImgAutoDownloader()
  {
    return this.GRZ;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.b getC2CMsgAutoDownloadFileLogic()
  {
    return this.GRX;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.c getC2CMsgAutoDownloadFileStorage()
  {
    return this.GRQ;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.b getC2CMsgAutoDownloadImgLogic()
  {
    return this.GRW;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.c getC2CMsgAutoDownloadImgStorage()
  {
    return this.GRP;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.d getC2CMsgFileUsageStorage()
  {
    return this.GRS;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.d getC2CMsgImgUsageStorage()
  {
    return this.GRR;
  }
  
  public float getFileBgBorderPriority()
  {
    AppMethodBeat.i(87776);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyp, 5);
      float f = i / 100.0F;
      AppMethodBeat.o(87776);
      return f;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(87776);
    }
    return 0.05F;
  }
  
  public long getFileBgBorderSize()
  {
    AppMethodBeat.i(87777);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyq, 10);
      long l = i * 1024;
      AppMethodBeat.o(87777);
      return l * 1024L;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(87777);
    }
    return 10485760L;
  }
  
  public float getImgBgBorderPriority()
  {
    AppMethodBeat.i(87775);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyl, 10);
      float f = i / 100.0F;
      AppMethodBeat.o(87775);
      return f;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(87775);
    }
    return 0.1F;
  }
  
  public float getImgBorderPriority()
  {
    AppMethodBeat.i(87774);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyk, 30);
      float f = i / 100.0F;
      AppMethodBeat.o(87774);
      return f;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(87774);
    }
    return 0.5F;
  }
  
  public long getInstallPriorityTime()
  {
    return this.GRN;
  }
  
  public com.tencent.mm.plugin.priority.model.b getPriorityDB()
  {
    return this.GRO;
  }
  
  public com.tencent.mm.plugin.priority.model.d getPriorityTaskRunner()
  {
    return this.GRV;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(87771);
    ThreadPool.post(new a((byte)0), "Priority.InitPriorityTask");
    com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.priority.model.a(), new String[] { "//priority" });
    this.GSc.alive();
    ((n)h.ae(n.class)).bbR().add(this.BJX);
    ((n)h.ae(n.class)).bbL().add(this.BJY);
    AppMethodBeat.o(87771);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(87772);
    this.GSc.dead();
    ((n)h.ae(n.class)).bbR().remove(this.BJX);
    ((n)h.ae(n.class)).bbL().remove(this.BJY);
    ((n)h.ae(n.class)).eSe().a(this.GSb);
    Object localObject;
    if (this.GRZ != null)
    {
      localObject = this.GRZ;
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).GSK = 0L;
      com.tencent.mm.ay.q.bmi().a((e.a)localObject);
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).lNn.dead();
      this.GRZ = null;
    }
    if (this.GRW != null) {
      this.GRW = null;
    }
    if (this.GRV != null)
    {
      localObject = this.GRV;
      ((com.tencent.mm.plugin.priority.model.d)localObject).GSm.clear();
      ((com.tencent.mm.plugin.priority.model.d)localObject).GSn.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.priority.model.d)localObject).GSn.quit();
      ((com.tencent.mm.plugin.priority.model.d)localObject).GSn = null;
      this.GRV = null;
    }
    if (this.GRP != null)
    {
      localObject = this.GRP;
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).GSv.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).GSE.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).GSG.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).GSH.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).GSI.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).GSJ.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).GSF.close();
      this.GRP = null;
    }
    if (this.GRR != null)
    {
      localObject = this.GRR;
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).GSp.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).GSq.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).GSr.close();
    }
    if (this.GRO != null)
    {
      localObject = this.GRO;
      SQLiteDatabase localSQLiteDatabase = ((com.tencent.mm.plugin.priority.model.b)localObject).GSi;
      if (((com.tencent.mm.plugin.priority.model.b)localObject).GSi == null) {}
      for (boolean bool = false;; bool = ((com.tencent.mm.plugin.priority.model.b)localObject).GSi.isOpen())
      {
        Log.w("MicroMsg.Priority.PriorityDB", "close db:%s isOpen:%b ", new Object[] { localSQLiteDatabase, Boolean.valueOf(bool) });
        if ((((com.tencent.mm.plugin.priority.model.b)localObject).GSi == null) || (!((com.tencent.mm.plugin.priority.model.b)localObject).GSi.isOpen())) {
          break label433;
        }
        Log.w("MicroMsg.Priority.PriorityDB", "close in trans :%b ", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.priority.model.b)localObject).GSi.inTransaction()) });
        while (((com.tencent.mm.plugin.priority.model.b)localObject).GSi.inTransaction()) {
          ((com.tencent.mm.plugin.priority.model.b)localObject).GSi.endTransaction();
        }
      }
      ((com.tencent.mm.plugin.priority.model.b)localObject).GSj.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).GSk.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).GSl.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).GSi.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).GSi = null;
      label433:
      this.GRO = null;
    }
    AppMethodBeat.o(87772);
  }
  
  public void parallelsDependency() {}
  
  public void registerMsgInfoStgNotify()
  {
    AppMethodBeat.i(235222);
    ((n)h.ae(n.class)).eSe().a(this.GSb, null);
    AppMethodBeat.o(235222);
  }
  
  public void unregisterMsgInfoStgNotify()
  {
    AppMethodBeat.i(235223);
    ((n)h.ae(n.class)).eSe().a(this.GSb);
    AppMethodBeat.o(235223);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(87769);
      long l1 = System.currentTimeMillis();
      int i = h.aHG().aHp().getInt(ar.a.VwD, 0);
      if (i != 6)
      {
        Log.i("MicroMsg.Priority.PluginPriority", "New DB FILE %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(6) });
        h.aHH();
        u.deleteFile(new com.tencent.mm.vfs.q(h.aHG().cachePath, "MicroMsgPriority.db").bOF());
        h.aHG().aHp().set(ar.a.VwD, Integer.valueOf(6));
      }
      Object localObject = PluginPriority.this;
      h.aHH();
      PluginPriority.access$102((PluginPriority)localObject, new com.tencent.mm.plugin.priority.model.b(h.aHG().cachePath));
      PluginPriority.access$202(PluginPriority.this, PluginPriority.this.GRO.ao(16777217L, 0L));
      if (PluginPriority.this.GRN == 0L)
      {
        PluginPriority.access$202(PluginPriority.this, System.currentTimeMillis());
        PluginPriority.this.GRO.ap(16777217L, PluginPriority.this.GRN);
      }
      Log.i("MicroMsg.Priority.PluginPriority", "install priority time %s", new Object[] { com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm:ss", PluginPriority.this.GRN / 1000L) });
      PluginPriority.access$302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.c(PluginPriority.this.GRO));
      PluginPriority.access$402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.c(PluginPriority.this.GRO));
      PluginPriority.access$502(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.d(PluginPriority.this.GRO));
      PluginPriority.access$602(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.d(PluginPriority.this.GRO));
      PluginPriority.access$702(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.c(PluginPriority.this.GRO));
      PluginPriority.access$802(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.b(PluginPriority.this.GRO));
      PluginPriority.access$902(PluginPriority.this, new com.tencent.mm.plugin.priority.model.d());
      PluginPriority.access$1002(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.b());
      PluginPriority.access$1102(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.b());
      PluginPriority.access$1202(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.a());
      PluginPriority.access$1302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.a());
      PluginPriority.access$1402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.a());
      localObject = PluginPriority.this.GRV;
      Log.i("MicroMsg.Priority.PriorityTaskRunner", "start tick");
      ((com.tencent.mm.plugin.priority.model.d)localObject).Pd(0L);
      long l3 = PluginPriority.this.GRO.ao(16777218L, -1L);
      long l2 = Calendar.getInstance().get(5);
      if (l2 != l3)
      {
        l3 = Util.getInt(((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("ChatImgAutoDownloadMax"), 0);
        localObject = String.format("%d,%d", new Object[] { Long.valueOf(Util.nullAs((Long)h.aHG().aHp().get(ar.a.VhI, null), 0L)), Long.valueOf(l3) });
        Log.i("MicroMsg.Priority.PriorityReportLogic", "report16341 %s", new Object[] { localObject });
        com.tencent.mm.plugin.report.f.Iyx.kvStat(16341, (String)localObject);
        PluginPriority.this.GRO.ap(16777218L, l2);
      }
      ((n)h.ae(n.class)).eSe().a(PluginPriority.this.GSb, null);
      localObject = PluginPriority.this.GRP;
      l2 = System.currentTimeMillis();
      String str = String.format("DELETE FROM %s WHERE createtime < ?", new Object[] { "C2CMsgAutoDownloadRes" });
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).GRO.execSQL(str, new String[] { String.valueOf(l2 - 7776000000L) });
      localObject = new com.tencent.mm.plugin.priority.model.b.c();
      PluginPriority.this.GRV.a((com.tencent.mm.plugin.priority.model.b.a)localObject);
      Log.i("MicroMsg.Priority.PluginPriority", "Init Priority Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(87769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority
 * JD-Core Version:    0.7.0.1
 */