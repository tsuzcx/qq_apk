package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.priority.model.a.a.a.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
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
  private n.b rqQ;
  private n.b rqR;
  private long uuA;
  private com.tencent.mm.plugin.priority.model.b uuB;
  private com.tencent.mm.plugin.priority.model.a.c.c uuC;
  private com.tencent.mm.plugin.priority.model.a.b.c uuD;
  private com.tencent.mm.plugin.priority.model.a.c.d uuE;
  private com.tencent.mm.plugin.priority.model.a.b.d uuF;
  private com.tencent.mm.plugin.priority.model.a.a.c uuG;
  private com.tencent.mm.plugin.priority.model.a.a.b uuH;
  private com.tencent.mm.plugin.priority.model.d uuI;
  private com.tencent.mm.plugin.priority.model.a.c.b uuJ;
  private com.tencent.mm.plugin.priority.model.a.b.b uuK;
  private com.tencent.mm.plugin.priority.model.a.a.a uuL;
  private com.tencent.mm.plugin.priority.model.a.c.a uuM;
  private com.tencent.mm.plugin.priority.model.a.b.a uuN;
  private h.a uuO;
  private com.tencent.mm.sdk.b.c<nb> uuP;
  
  public PluginPriority()
  {
    AppMethodBeat.i(87770);
    this.uuO = new h.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramAnonymoush, h.c paramAnonymousc)
      {
        AppMethodBeat.i(87765);
        if (paramAnonymousc.tyD.equals("insert"))
        {
          int i = 0;
          if (i < paramAnonymousc.tyE.size())
          {
            paramAnonymoush = (bl)paramAnonymousc.tyE.get(i);
            label70:
            com.tencent.mm.plugin.priority.model.a.a.a locala;
            if ((paramAnonymoush.field_isSend == 0) && (paramAnonymoush.eJO()))
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
              if ((paramAnonymoush.field_isSend != 0) || (!paramAnonymoush.cxB())) {
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
    this.uuP = new com.tencent.mm.sdk.b.c() {};
    this.rqQ = new n.b()
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
    this.rqR = new n.b()
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
    if (paramg.agu()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.comm.a.b.class, new a());
    }
    AppMethodBeat.o(87773);
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.a getC2CChatUsageLogic()
  {
    return this.uuL;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.b getC2CChatUsageResultStorage()
  {
    return this.uuH;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.c getC2CChatUsageStorage()
  {
    return this.uuG;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.a getC2CFileAutoDownloader()
  {
    return this.uuN;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.a getC2CImgAutoDownloader()
  {
    return this.uuM;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.b getC2CMsgAutoDownloadFileLogic()
  {
    return this.uuK;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.c getC2CMsgAutoDownloadFileStorage()
  {
    return this.uuD;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.b getC2CMsgAutoDownloadImgLogic()
  {
    return this.uuJ;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.c getC2CMsgAutoDownloadImgStorage()
  {
    return this.uuC;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.d getC2CMsgFileUsageStorage()
  {
    return this.uuF;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.d getC2CMsgImgUsageStorage()
  {
    return this.uuE;
  }
  
  public float getFileBgBorderPriority()
  {
    AppMethodBeat.i(87776);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plx, 5);
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
      int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ply, 10);
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
      int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plt, 10);
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
      int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pls, 30);
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
    return this.uuA;
  }
  
  public com.tencent.mm.plugin.priority.model.b getPriorityDB()
  {
    return this.uuB;
  }
  
  public com.tencent.mm.plugin.priority.model.d getPriorityTaskRunner()
  {
    return this.uuI;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(87771);
    com.tencent.mm.sdk.g.b.c(new a((byte)0), "Priority.InitPriorityTask");
    com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.priority.model.a(), new String[] { "//priority" });
    this.uuP.alive();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().a(this.rqQ);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().a(this.rqR);
    AppMethodBeat.o(87771);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(87772);
    this.uuP.dead();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().b(this.rqQ);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().b(this.rqR);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(this.uuO);
    Object localObject;
    if (this.uuM != null)
    {
      localObject = this.uuM;
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).uvx = 0L;
      o.ayG().a((com.tencent.mm.aw.d.a)localObject);
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).hfS.dead();
      this.uuM = null;
    }
    if (this.uuJ != null) {
      this.uuJ = null;
    }
    if (this.uuI != null)
    {
      localObject = this.uuI;
      ((com.tencent.mm.plugin.priority.model.d)localObject).uuZ.clear();
      ((com.tencent.mm.plugin.priority.model.d)localObject).uva.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.priority.model.d)localObject).uva.quit();
      ((com.tencent.mm.plugin.priority.model.d)localObject).uva = null;
      this.uuI = null;
    }
    if (this.uuC != null)
    {
      localObject = this.uuC;
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).uvi.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).uvr.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).uvt.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).uvu.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).uvv.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).uvw.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).uvs.close();
      this.uuC = null;
    }
    if (this.uuE != null)
    {
      localObject = this.uuE;
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).uvc.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).uvd.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).uve.close();
    }
    if (this.uuB != null)
    {
      localObject = this.uuB;
      SQLiteDatabase localSQLiteDatabase = ((com.tencent.mm.plugin.priority.model.b)localObject).uuV;
      if (((com.tencent.mm.plugin.priority.model.b)localObject).uuV == null) {}
      for (boolean bool = false;; bool = ((com.tencent.mm.plugin.priority.model.b)localObject).uuV.isOpen())
      {
        ad.w("MicroMsg.Priority.PriorityDB", "close db:%s isOpen:%b ", new Object[] { localSQLiteDatabase, Boolean.valueOf(bool) });
        if ((((com.tencent.mm.plugin.priority.model.b)localObject).uuV == null) || (!((com.tencent.mm.plugin.priority.model.b)localObject).uuV.isOpen())) {
          break label433;
        }
        ad.w("MicroMsg.Priority.PriorityDB", "close in trans :%b ", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.priority.model.b)localObject).uuV.inTransaction()) });
        while (((com.tencent.mm.plugin.priority.model.b)localObject).uuV.inTransaction()) {
          ((com.tencent.mm.plugin.priority.model.b)localObject).uuV.endTransaction();
        }
      }
      ((com.tencent.mm.plugin.priority.model.b)localObject).uuW.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).uuX.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).uuY.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).uuV.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).uuV = null;
      label433:
      this.uuB = null;
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
      int i = com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.FuJ, 0);
      if (i != 6)
      {
        ad.i("MicroMsg.Priority.PluginPriority", "New DB FILE %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(6) });
        com.tencent.mm.kernel.g.afC();
        i.deleteFile(q.B(new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.afB().cachePath, "MicroMsgPriority.db").fhU()));
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FuJ, Integer.valueOf(6));
      }
      Object localObject = PluginPriority.this;
      com.tencent.mm.kernel.g.afC();
      PluginPriority.access$102((PluginPriority)localObject, new com.tencent.mm.plugin.priority.model.b(com.tencent.mm.kernel.g.afB().cachePath));
      PluginPriority.access$202(PluginPriority.this, PluginPriority.this.uuB.ae(16777217L, 0L));
      if (PluginPriority.this.uuA == 0L)
      {
        PluginPriority.access$202(PluginPriority.this, System.currentTimeMillis());
        PluginPriority.this.uuB.af(16777217L, PluginPriority.this.uuA);
      }
      ad.i("MicroMsg.Priority.PluginPriority", "install priority time %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", PluginPriority.this.uuA / 1000L) });
      PluginPriority.access$302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.c(PluginPriority.this.uuB));
      PluginPriority.access$402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.c(PluginPriority.this.uuB));
      PluginPriority.access$502(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.d(PluginPriority.this.uuB));
      PluginPriority.access$602(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.d(PluginPriority.this.uuB));
      PluginPriority.access$702(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.c(PluginPriority.this.uuB));
      PluginPriority.access$802(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.b(PluginPriority.this.uuB));
      PluginPriority.access$902(PluginPriority.this, new com.tencent.mm.plugin.priority.model.d());
      PluginPriority.access$1002(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.b());
      PluginPriority.access$1102(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.b());
      PluginPriority.access$1202(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.a());
      PluginPriority.access$1302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.a());
      PluginPriority.access$1402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.a());
      localObject = PluginPriority.this.uuI;
      ad.i("MicroMsg.Priority.PriorityTaskRunner", "start tick");
      ((com.tencent.mm.plugin.priority.model.d)localObject).rG(0L);
      long l3 = PluginPriority.this.uuB.ae(16777218L, -1L);
      long l2 = Calendar.getInstance().get(5);
      if (l2 != l3)
      {
        l3 = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("ChatImgAutoDownloadMax"), 0);
        localObject = String.format("%d,%d", new Object[] { Long.valueOf(bt.a((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fhd, null), 0L)), Long.valueOf(l3) });
        ad.i("MicroMsg.Priority.PriorityReportLogic", "report16341 %s", new Object[] { localObject });
        com.tencent.mm.plugin.report.e.vIY.kvStat(16341, (String)localObject);
        PluginPriority.this.uuB.af(16777218L, l2);
      }
      ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(PluginPriority.this.uuO, null);
      localObject = PluginPriority.this.uuC;
      l2 = System.currentTimeMillis();
      String str = String.format("DELETE FROM %s WHERE createtime < ?", new Object[] { "C2CMsgAutoDownloadRes" });
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).uuB.execSQL(str, new String[] { String.valueOf(l2 - 7776000000L) });
      localObject = new com.tencent.mm.plugin.priority.model.b.c();
      PluginPriority.this.uuI.a((com.tencent.mm.plugin.priority.model.b.a)localObject);
      ad.i("MicroMsg.Priority.PluginPriority", "Init Priority Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(87769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority
 * JD-Core Version:    0.7.0.1
 */