package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.model.a.a.a.a;
import com.tencent.mm.plugin.priority.model.d.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PluginPriority
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.priority.a.a
{
  private n.b twl;
  private n.b twm;
  private com.tencent.mm.plugin.priority.model.b wKA;
  private com.tencent.mm.plugin.priority.model.a.c.c wKB;
  private com.tencent.mm.plugin.priority.model.a.b.c wKC;
  private com.tencent.mm.plugin.priority.model.a.c.d wKD;
  private com.tencent.mm.plugin.priority.model.a.b.d wKE;
  private com.tencent.mm.plugin.priority.model.a.a.c wKF;
  private com.tencent.mm.plugin.priority.model.a.a.b wKG;
  private com.tencent.mm.plugin.priority.model.d wKH;
  private com.tencent.mm.plugin.priority.model.a.c.b wKI;
  private com.tencent.mm.plugin.priority.model.a.b.b wKJ;
  private com.tencent.mm.plugin.priority.model.a.a.a wKK;
  private com.tencent.mm.plugin.priority.model.a.c.a wKL;
  private com.tencent.mm.plugin.priority.model.a.b.a wKM;
  private i.a wKN;
  private com.tencent.mm.sdk.b.c<ns> wKO;
  private long wKz;
  
  public PluginPriority()
  {
    AppMethodBeat.i(87770);
    this.wKN = new i.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(87765);
        if (paramAnonymousc.vKe.equals("insert"))
        {
          int i = 0;
          if (i < paramAnonymousc.gNE.size())
          {
            paramAnonymousi = (bu)paramAnonymousc.gNE.get(i);
            label70:
            com.tencent.mm.plugin.priority.model.a.a.a locala;
            if ((paramAnonymousi.field_isSend == 0) && (paramAnonymousi.fpi()))
            {
              ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aj(paramAnonymousi);
              if (PluginPriority.this.getC2CChatUsageLogic() != null)
              {
                if (paramAnonymousi.field_isSend != 1) {
                  break label165;
                }
                locala = PluginPriority.this.getC2CChatUsageLogic();
                paramAnonymousi = paramAnonymousi.field_talker;
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, paramAnonymousi, 1));
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if ((paramAnonymousi.field_isSend != 0) || (!paramAnonymousi.cTc())) {
                break label70;
              }
              ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ak(paramAnonymousi);
              break label70;
              label165:
              locala = PluginPriority.this.getC2CChatUsageLogic();
              paramAnonymousi = paramAnonymousi.field_talker;
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, paramAnonymousi, 3));
            }
          }
        }
        AppMethodBeat.o(87765);
      }
    };
    this.wKO = new com.tencent.mm.sdk.b.c() {};
    this.twl = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(87767);
        paramAnonymousn = (String)paramAnonymousObject;
        if (bt.isNullOrNil(paramAnonymousn))
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
            PluginPriority.this.getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.d(paramAnonymousn));
          }
        }
      }
    };
    this.twm = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(87768);
        paramAnonymousn = (String)paramAnonymousObject;
        if (bt.isNullOrNil(paramAnonymousn))
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
            PluginPriority.this.getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.d(paramAnonymousn));
          }
        }
      }
    };
    AppMethodBeat.o(87770);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(87773);
    if (paramg.akw()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.comm.a.b.class, new a());
    }
    AppMethodBeat.o(87773);
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.a getC2CChatUsageLogic()
  {
    return this.wKK;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.b getC2CChatUsageResultStorage()
  {
    return this.wKG;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.c getC2CChatUsageStorage()
  {
    return this.wKF;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.a getC2CFileAutoDownloader()
  {
    return this.wKM;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.a getC2CImgAutoDownloader()
  {
    return this.wKL;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.b getC2CMsgAutoDownloadFileLogic()
  {
    return this.wKJ;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.c getC2CMsgAutoDownloadFileStorage()
  {
    return this.wKC;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.b getC2CMsgAutoDownloadImgLogic()
  {
    return this.wKI;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.c getC2CMsgAutoDownloadImgStorage()
  {
    return this.wKB;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.d getC2CMsgFileUsageStorage()
  {
    return this.wKE;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.d getC2CMsgImgUsageStorage()
  {
    return this.wKD;
  }
  
  public float getFileBgBorderPriority()
  {
    AppMethodBeat.i(87776);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsS, 5);
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
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsT, 10);
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
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsO, 10);
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
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsN, 30);
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
    return this.wKz;
  }
  
  public com.tencent.mm.plugin.priority.model.b getPriorityDB()
  {
    return this.wKA;
  }
  
  public com.tencent.mm.plugin.priority.model.d getPriorityTaskRunner()
  {
    return this.wKH;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(87771);
    com.tencent.mm.sdk.g.b.c(new a((byte)0), "Priority.InitPriorityTask");
    com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.priority.model.a(), new String[] { "//priority" });
    this.wKO.alive();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().a(this.twl);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().a(this.twm);
    AppMethodBeat.o(87771);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(87772);
    this.wKO.dead();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().b(this.twl);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().b(this.twm);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.wKN);
    Object localObject;
    if (this.wKL != null)
    {
      localObject = this.wKL;
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).wLw = 0L;
      com.tencent.mm.aw.q.aIG().a((e.a)localObject);
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).hZc.dead();
      this.wKL = null;
    }
    if (this.wKI != null) {
      this.wKI = null;
    }
    if (this.wKH != null)
    {
      localObject = this.wKH;
      ((com.tencent.mm.plugin.priority.model.d)localObject).wKY.clear();
      ((com.tencent.mm.plugin.priority.model.d)localObject).wKZ.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.priority.model.d)localObject).wKZ.quit();
      ((com.tencent.mm.plugin.priority.model.d)localObject).wKZ = null;
      this.wKH = null;
    }
    if (this.wKB != null)
    {
      localObject = this.wKB;
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).wLh.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).wLq.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).wLs.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).wLt.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).wLu.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).wLv.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).wLr.close();
      this.wKB = null;
    }
    if (this.wKD != null)
    {
      localObject = this.wKD;
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).wLb.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).wLc.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).wLd.close();
    }
    if (this.wKA != null)
    {
      localObject = this.wKA;
      SQLiteDatabase localSQLiteDatabase = ((com.tencent.mm.plugin.priority.model.b)localObject).wKU;
      if (((com.tencent.mm.plugin.priority.model.b)localObject).wKU == null) {}
      for (boolean bool = false;; bool = ((com.tencent.mm.plugin.priority.model.b)localObject).wKU.isOpen())
      {
        ad.w("MicroMsg.Priority.PriorityDB", "close db:%s isOpen:%b ", new Object[] { localSQLiteDatabase, Boolean.valueOf(bool) });
        if ((((com.tencent.mm.plugin.priority.model.b)localObject).wKU == null) || (!((com.tencent.mm.plugin.priority.model.b)localObject).wKU.isOpen())) {
          break label433;
        }
        ad.w("MicroMsg.Priority.PriorityDB", "close in trans :%b ", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.priority.model.b)localObject).wKU.inTransaction()) });
        while (((com.tencent.mm.plugin.priority.model.b)localObject).wKU.inTransaction()) {
          ((com.tencent.mm.plugin.priority.model.b)localObject).wKU.endTransaction();
        }
      }
      ((com.tencent.mm.plugin.priority.model.b)localObject).wKV.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).wKW.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).wKX.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).wKU.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).wKU = null;
      label433:
      this.wKA = null;
    }
    AppMethodBeat.o(87772);
  }
  
  public void parallelsDependency() {}
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(87769);
      long l1 = System.currentTimeMillis();
      int i = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IFi, 0);
      if (i != 6)
      {
        ad.i("MicroMsg.Priority.PluginPriority", "New DB FILE %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(6) });
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.ajC().cachePath, "MicroMsgPriority.db").fOK()));
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFi, Integer.valueOf(6));
      }
      Object localObject = PluginPriority.this;
      com.tencent.mm.kernel.g.ajD();
      PluginPriority.access$102((PluginPriority)localObject, new com.tencent.mm.plugin.priority.model.b(com.tencent.mm.kernel.g.ajC().cachePath));
      PluginPriority.access$202(PluginPriority.this, PluginPriority.this.wKA.ad(16777217L, 0L));
      if (PluginPriority.this.wKz == 0L)
      {
        PluginPriority.access$202(PluginPriority.this, System.currentTimeMillis());
        PluginPriority.this.wKA.ae(16777217L, PluginPriority.this.wKz);
      }
      ad.i("MicroMsg.Priority.PluginPriority", "install priority time %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", PluginPriority.this.wKz / 1000L) });
      PluginPriority.access$302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.c(PluginPriority.this.wKA));
      PluginPriority.access$402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.c(PluginPriority.this.wKA));
      PluginPriority.access$502(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.d(PluginPriority.this.wKA));
      PluginPriority.access$602(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.d(PluginPriority.this.wKA));
      PluginPriority.access$702(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.c(PluginPriority.this.wKA));
      PluginPriority.access$802(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.b(PluginPriority.this.wKA));
      PluginPriority.access$902(PluginPriority.this, new com.tencent.mm.plugin.priority.model.d());
      PluginPriority.access$1002(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.b());
      PluginPriority.access$1102(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.b());
      PluginPriority.access$1202(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.a());
      PluginPriority.access$1302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.a());
      PluginPriority.access$1402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.a());
      localObject = PluginPriority.this.wKH;
      ad.i("MicroMsg.Priority.PriorityTaskRunner", "start tick");
      ((com.tencent.mm.plugin.priority.model.d)localObject).yu(0L);
      long l3 = PluginPriority.this.wKA.ad(16777218L, -1L);
      long l2 = Calendar.getInstance().get(5);
      if (l2 != l3)
      {
        l3 = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("ChatImgAutoDownloadMax"), 0);
        localObject = String.format("%d,%d", new Object[] { Long.valueOf(bt.a((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Irk, null), 0L)), Long.valueOf(l3) });
        ad.i("MicroMsg.Priority.PriorityReportLogic", "report16341 %s", new Object[] { localObject });
        com.tencent.mm.plugin.report.e.ygI.kvStat(16341, (String)localObject);
        PluginPriority.this.wKA.ae(16777218L, l2);
      }
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(PluginPriority.this.wKN, null);
      localObject = PluginPriority.this.wKB;
      l2 = System.currentTimeMillis();
      String str = String.format("DELETE FROM %s WHERE createtime < ?", new Object[] { "C2CMsgAutoDownloadRes" });
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).wKA.execSQL(str, new String[] { String.valueOf(l2 - 7776000000L) });
      localObject = new com.tencent.mm.plugin.priority.model.b.c();
      PluginPriority.this.wKH.a((com.tencent.mm.plugin.priority.model.b.a)localObject);
      ad.i("MicroMsg.Priority.PluginPriority", "Init Priority Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(87769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority
 * JD-Core Version:    0.7.0.1
 */