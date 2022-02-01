package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.priority.model.a.a.a.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PluginPriority
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.priority.a.a
{
  private n.b szK;
  private n.b szL;
  private com.tencent.mm.plugin.priority.model.a.a.b vDA;
  private com.tencent.mm.plugin.priority.model.d vDB;
  private com.tencent.mm.plugin.priority.model.a.c.b vDC;
  private com.tencent.mm.plugin.priority.model.a.b.b vDD;
  private com.tencent.mm.plugin.priority.model.a.a.a vDE;
  private com.tencent.mm.plugin.priority.model.a.c.a vDF;
  private com.tencent.mm.plugin.priority.model.a.b.a vDG;
  private h.a vDH;
  private com.tencent.mm.sdk.b.c<nk> vDI;
  private long vDt;
  private com.tencent.mm.plugin.priority.model.b vDu;
  private com.tencent.mm.plugin.priority.model.a.c.c vDv;
  private com.tencent.mm.plugin.priority.model.a.b.c vDw;
  private com.tencent.mm.plugin.priority.model.a.c.d vDx;
  private com.tencent.mm.plugin.priority.model.a.b.d vDy;
  private com.tencent.mm.plugin.priority.model.a.a.c vDz;
  
  public PluginPriority()
  {
    AppMethodBeat.i(87770);
    this.vDH = new h.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramAnonymoush, h.c paramAnonymousc)
      {
        AppMethodBeat.i(87765);
        if (paramAnonymousc.uHb.equals("insert"))
        {
          int i = 0;
          if (i < paramAnonymousc.gtT.size())
          {
            paramAnonymoush = (bo)paramAnonymousc.gtT.get(i);
            label70:
            com.tencent.mm.plugin.priority.model.a.a.a locala;
            if ((paramAnonymoush.field_isSend == 0) && (paramAnonymoush.eZm()))
            {
              ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ag(paramAnonymoush);
              if (PluginPriority.this.getC2CChatUsageLogic() != null)
              {
                if (paramAnonymoush.field_isSend != 1) {
                  break label165;
                }
                locala = PluginPriority.this.getC2CChatUsageLogic();
                paramAnonymoush = paramAnonymoush.field_talker;
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, paramAnonymoush, 1));
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if ((paramAnonymoush.field_isSend != 0) || (!paramAnonymoush.cKN())) {
                break label70;
              }
              ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ah(paramAnonymoush);
              break label70;
              label165:
              locala = PluginPriority.this.getC2CChatUsageLogic();
              paramAnonymoush = paramAnonymoush.field_talker;
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, paramAnonymoush, 3));
            }
          }
        }
        AppMethodBeat.o(87765);
      }
    };
    this.vDI = new com.tencent.mm.sdk.b.c() {};
    this.szK = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(87767);
        paramAnonymousn = (String)paramAnonymousObject;
        if (bs.isNullOrNil(paramAnonymousn))
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
    this.szL = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(87768);
        paramAnonymousn = (String)paramAnonymousObject;
        if (bs.isNullOrNil(paramAnonymousn))
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
    if (paramg.ahL()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.comm.a.b.class, new a());
    }
    AppMethodBeat.o(87773);
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.a getC2CChatUsageLogic()
  {
    return this.vDE;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.b getC2CChatUsageResultStorage()
  {
    return this.vDA;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.c getC2CChatUsageStorage()
  {
    return this.vDz;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.a getC2CFileAutoDownloader()
  {
    return this.vDG;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.a getC2CImgAutoDownloader()
  {
    return this.vDF;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.b getC2CMsgAutoDownloadFileLogic()
  {
    return this.vDD;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.c getC2CMsgAutoDownloadFileStorage()
  {
    return this.vDw;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.b getC2CMsgAutoDownloadImgLogic()
  {
    return this.vDC;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.c getC2CMsgAutoDownloadImgStorage()
  {
    return this.vDv;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.d getC2CMsgFileUsageStorage()
  {
    return this.vDy;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.d getC2CMsgImgUsageStorage()
  {
    return this.vDx;
  }
  
  public float getFileBgBorderPriority()
  {
    AppMethodBeat.i(87776);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOT, 5);
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
      int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOU, 10);
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
      int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOP, 10);
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
      int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOO, 30);
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
    return this.vDt;
  }
  
  public com.tencent.mm.plugin.priority.model.b getPriorityDB()
  {
    return this.vDu;
  }
  
  public com.tencent.mm.plugin.priority.model.d getPriorityTaskRunner()
  {
    return this.vDB;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(87771);
    com.tencent.mm.sdk.g.b.c(new a((byte)0), "Priority.InitPriorityTask");
    com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.priority.model.a(), new String[] { "//priority" });
    this.vDI.alive();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().a(this.szK);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().a(this.szL);
    AppMethodBeat.o(87771);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(87772);
    this.vDI.dead();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().b(this.szK);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().b(this.szL);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(this.vDH);
    Object localObject;
    if (this.vDF != null)
    {
      localObject = this.vDF;
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).vEq = 0L;
      o.aFy().a((com.tencent.mm.av.d.a)localObject);
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).hGv.dead();
      this.vDF = null;
    }
    if (this.vDC != null) {
      this.vDC = null;
    }
    if (this.vDB != null)
    {
      localObject = this.vDB;
      ((com.tencent.mm.plugin.priority.model.d)localObject).vDS.clear();
      ((com.tencent.mm.plugin.priority.model.d)localObject).vDT.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.priority.model.d)localObject).vDT.quit();
      ((com.tencent.mm.plugin.priority.model.d)localObject).vDT = null;
      this.vDB = null;
    }
    if (this.vDv != null)
    {
      localObject = this.vDv;
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).vEb.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).vEk.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).vEm.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).vEn.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).vEo.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).vEp.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).vEl.close();
      this.vDv = null;
    }
    if (this.vDx != null)
    {
      localObject = this.vDx;
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).vDV.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).vDW.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).vDX.close();
    }
    if (this.vDu != null)
    {
      localObject = this.vDu;
      SQLiteDatabase localSQLiteDatabase = ((com.tencent.mm.plugin.priority.model.b)localObject).vDO;
      if (((com.tencent.mm.plugin.priority.model.b)localObject).vDO == null) {}
      for (boolean bool = false;; bool = ((com.tencent.mm.plugin.priority.model.b)localObject).vDO.isOpen())
      {
        ac.w("MicroMsg.Priority.PriorityDB", "close db:%s isOpen:%b ", new Object[] { localSQLiteDatabase, Boolean.valueOf(bool) });
        if ((((com.tencent.mm.plugin.priority.model.b)localObject).vDO == null) || (!((com.tencent.mm.plugin.priority.model.b)localObject).vDO.isOpen())) {
          break label433;
        }
        ac.w("MicroMsg.Priority.PriorityDB", "close in trans :%b ", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.priority.model.b)localObject).vDO.inTransaction()) });
        while (((com.tencent.mm.plugin.priority.model.b)localObject).vDO.inTransaction()) {
          ((com.tencent.mm.plugin.priority.model.b)localObject).vDO.endTransaction();
        }
      }
      ((com.tencent.mm.plugin.priority.model.b)localObject).vDP.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).vDQ.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).vDR.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).vDO.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).vDO = null;
      label433:
      this.vDu = null;
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
      int i = com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GSD, 0);
      if (i != 6)
      {
        ac.i("MicroMsg.Priority.PluginPriority", "New DB FILE %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(6) });
        com.tencent.mm.kernel.g.agS();
        i.deleteFile(q.B(new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.agR().cachePath, "MicroMsgPriority.db").fxV()));
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GSD, Integer.valueOf(6));
      }
      Object localObject = PluginPriority.this;
      com.tencent.mm.kernel.g.agS();
      PluginPriority.access$102((PluginPriority)localObject, new com.tencent.mm.plugin.priority.model.b(com.tencent.mm.kernel.g.agR().cachePath));
      PluginPriority.access$202(PluginPriority.this, PluginPriority.this.vDu.ab(16777217L, 0L));
      if (PluginPriority.this.vDt == 0L)
      {
        PluginPriority.access$202(PluginPriority.this, System.currentTimeMillis());
        PluginPriority.this.vDu.ac(16777217L, PluginPriority.this.vDt);
      }
      ac.i("MicroMsg.Priority.PluginPriority", "install priority time %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", PluginPriority.this.vDt / 1000L) });
      PluginPriority.access$302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.c(PluginPriority.this.vDu));
      PluginPriority.access$402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.c(PluginPriority.this.vDu));
      PluginPriority.access$502(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.d(PluginPriority.this.vDu));
      PluginPriority.access$602(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.d(PluginPriority.this.vDu));
      PluginPriority.access$702(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.c(PluginPriority.this.vDu));
      PluginPriority.access$802(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.b(PluginPriority.this.vDu));
      PluginPriority.access$902(PluginPriority.this, new com.tencent.mm.plugin.priority.model.d());
      PluginPriority.access$1002(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.b());
      PluginPriority.access$1102(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.b());
      PluginPriority.access$1202(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.a());
      PluginPriority.access$1302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.a());
      PluginPriority.access$1402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.a());
      localObject = PluginPriority.this.vDB;
      ac.i("MicroMsg.Priority.PriorityTaskRunner", "start tick");
      ((com.tencent.mm.plugin.priority.model.d)localObject).wj(0L);
      long l3 = PluginPriority.this.vDu.ab(16777218L, -1L);
      long l2 = Calendar.getInstance().get(5);
      if (l2 != l3)
      {
        l3 = bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("ChatImgAutoDownloadMax"), 0);
        localObject = String.format("%d,%d", new Object[] { Long.valueOf(bs.a((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GER, null), 0L)), Long.valueOf(l3) });
        ac.i("MicroMsg.Priority.PriorityReportLogic", "report16341 %s", new Object[] { localObject });
        com.tencent.mm.plugin.report.e.wTc.kvStat(16341, (String)localObject);
        PluginPriority.this.vDu.ac(16777218L, l2);
      }
      ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(PluginPriority.this.vDH, null);
      localObject = PluginPriority.this.vDv;
      l2 = System.currentTimeMillis();
      String str = String.format("DELETE FROM %s WHERE createtime < ?", new Object[] { "C2CMsgAutoDownloadRes" });
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).vDu.execSQL(str, new String[] { String.valueOf(l2 - 7776000000L) });
      localObject = new com.tencent.mm.plugin.priority.model.b.c();
      PluginPriority.this.vDB.a((com.tencent.mm.plugin.priority.model.b.a)localObject);
      ac.i("MicroMsg.Priority.PluginPriority", "Init Priority Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(87769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority
 * JD-Core Version:    0.7.0.1
 */