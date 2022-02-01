package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.model.d.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Calendar;
import java.util.List;

public class PluginPriority
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.priority.a.a
{
  private n.b tHc;
  private n.b tHd;
  private com.tencent.mm.plugin.priority.model.a.b.a xaA;
  private i.a xaB;
  private com.tencent.mm.sdk.b.c<nt> xaC;
  private long xan;
  private com.tencent.mm.plugin.priority.model.b xao;
  private com.tencent.mm.plugin.priority.model.a.c.c xap;
  private com.tencent.mm.plugin.priority.model.a.b.c xaq;
  private com.tencent.mm.plugin.priority.model.a.c.d xar;
  private com.tencent.mm.plugin.priority.model.a.b.d xas;
  private com.tencent.mm.plugin.priority.model.a.a.c xat;
  private com.tencent.mm.plugin.priority.model.a.a.b xau;
  private com.tencent.mm.plugin.priority.model.d xav;
  private com.tencent.mm.plugin.priority.model.a.c.b xaw;
  private com.tencent.mm.plugin.priority.model.a.b.b xax;
  private com.tencent.mm.plugin.priority.model.a.a.a xay;
  private com.tencent.mm.plugin.priority.model.a.c.a xaz;
  
  public PluginPriority()
  {
    AppMethodBeat.i(87770);
    this.xaB = new PluginPriority.1(this);
    this.xaC = new PluginPriority.2(this);
    this.tHc = new PluginPriority.3(this);
    this.tHd = new PluginPriority.4(this);
    AppMethodBeat.o(87770);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(87773);
    if (paramg.akL()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.comm.a.b.class, new a());
    }
    AppMethodBeat.o(87773);
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.a getC2CChatUsageLogic()
  {
    return this.xay;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.b getC2CChatUsageResultStorage()
  {
    return this.xau;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.c getC2CChatUsageStorage()
  {
    return this.xat;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.a getC2CFileAutoDownloader()
  {
    return this.xaA;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.a getC2CImgAutoDownloader()
  {
    return this.xaz;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.b getC2CMsgAutoDownloadFileLogic()
  {
    return this.xax;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.c getC2CMsgAutoDownloadFileStorage()
  {
    return this.xaq;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.b getC2CMsgAutoDownloadImgLogic()
  {
    return this.xaw;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.c getC2CMsgAutoDownloadImgStorage()
  {
    return this.xap;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.d getC2CMsgFileUsageStorage()
  {
    return this.xas;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.d getC2CMsgImgUsageStorage()
  {
    return this.xar;
  }
  
  public float getFileBgBorderPriority()
  {
    AppMethodBeat.i(87776);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzH, 5);
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
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzI, 10);
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
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzD, 10);
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
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzC, 30);
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
    return this.xan;
  }
  
  public com.tencent.mm.plugin.priority.model.b getPriorityDB()
  {
    return this.xao;
  }
  
  public com.tencent.mm.plugin.priority.model.d getPriorityTaskRunner()
  {
    return this.xav;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(87771);
    com.tencent.mm.sdk.g.b.c(new a((byte)0), "Priority.InitPriorityTask");
    com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.priority.model.a(), new String[] { "//priority" });
    this.xaC.alive();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a(this.tHc);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().a(this.tHd);
    AppMethodBeat.o(87771);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(87772);
    this.xaC.dead();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().b(this.tHc);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().b(this.tHd);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.xaB);
    Object localObject;
    if (this.xaz != null)
    {
      localObject = this.xaz;
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).xbk = 0L;
      q.aIY().a((e.a)localObject);
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).ibU.dead();
      this.xaz = null;
    }
    if (this.xaw != null) {
      this.xaw = null;
    }
    if (this.xav != null)
    {
      localObject = this.xav;
      ((com.tencent.mm.plugin.priority.model.d)localObject).xaM.clear();
      ((com.tencent.mm.plugin.priority.model.d)localObject).xaN.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.priority.model.d)localObject).xaN.quit();
      ((com.tencent.mm.plugin.priority.model.d)localObject).xaN = null;
      this.xav = null;
    }
    if (this.xap != null)
    {
      localObject = this.xap;
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).xaV.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).xbe.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).xbg.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).xbh.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).xbi.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).xbj.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).xbf.close();
      this.xap = null;
    }
    if (this.xar != null)
    {
      localObject = this.xar;
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).xaP.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).xaQ.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).xaR.close();
    }
    if (this.xao != null)
    {
      localObject = this.xao;
      SQLiteDatabase localSQLiteDatabase = ((com.tencent.mm.plugin.priority.model.b)localObject).xaI;
      if (((com.tencent.mm.plugin.priority.model.b)localObject).xaI == null) {}
      for (boolean bool = false;; bool = ((com.tencent.mm.plugin.priority.model.b)localObject).xaI.isOpen())
      {
        ae.w("MicroMsg.Priority.PriorityDB", "close db:%s isOpen:%b ", new Object[] { localSQLiteDatabase, Boolean.valueOf(bool) });
        if ((((com.tencent.mm.plugin.priority.model.b)localObject).xaI == null) || (!((com.tencent.mm.plugin.priority.model.b)localObject).xaI.isOpen())) {
          break label433;
        }
        ae.w("MicroMsg.Priority.PriorityDB", "close in trans :%b ", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.priority.model.b)localObject).xaI.inTransaction()) });
        while (((com.tencent.mm.plugin.priority.model.b)localObject).xaI.inTransaction()) {
          ((com.tencent.mm.plugin.priority.model.b)localObject).xaI.endTransaction();
        }
      }
      ((com.tencent.mm.plugin.priority.model.b)localObject).xaJ.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).xaK.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).xaL.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).xaI.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).xaI = null;
      label433:
      this.xao = null;
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
      int i = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.IZI, 0);
      if (i != 6)
      {
        ae.i("MicroMsg.Priority.PluginPriority", "New DB FILE %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(6) });
        com.tencent.mm.kernel.g.ajS();
        o.deleteFile(w.B(new k(com.tencent.mm.kernel.g.ajR().cachePath, "MicroMsgPriority.db").fTh()));
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IZI, Integer.valueOf(6));
      }
      Object localObject = PluginPriority.this;
      com.tencent.mm.kernel.g.ajS();
      PluginPriority.access$102((PluginPriority)localObject, new com.tencent.mm.plugin.priority.model.b(com.tencent.mm.kernel.g.ajR().cachePath));
      PluginPriority.access$202(PluginPriority.this, PluginPriority.this.xao.ac(16777217L, 0L));
      if (PluginPriority.this.xan == 0L)
      {
        PluginPriority.access$202(PluginPriority.this, System.currentTimeMillis());
        PluginPriority.this.xao.ad(16777217L, PluginPriority.this.xan);
      }
      ae.i("MicroMsg.Priority.PluginPriority", "install priority time %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", PluginPriority.this.xan / 1000L) });
      PluginPriority.access$302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.c(PluginPriority.this.xao));
      PluginPriority.access$402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.c(PluginPriority.this.xao));
      PluginPriority.access$502(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.d(PluginPriority.this.xao));
      PluginPriority.access$602(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.d(PluginPriority.this.xao));
      PluginPriority.access$702(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.c(PluginPriority.this.xao));
      PluginPriority.access$802(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.b(PluginPriority.this.xao));
      PluginPriority.access$902(PluginPriority.this, new com.tencent.mm.plugin.priority.model.d());
      PluginPriority.access$1002(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.b());
      PluginPriority.access$1102(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.b());
      PluginPriority.access$1202(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.a());
      PluginPriority.access$1302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.a());
      PluginPriority.access$1402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.a());
      localObject = PluginPriority.this.xav;
      ae.i("MicroMsg.Priority.PriorityTaskRunner", "start tick");
      ((com.tencent.mm.plugin.priority.model.d)localObject).yT(0L);
      long l3 = PluginPriority.this.xao.ac(16777218L, -1L);
      long l2 = Calendar.getInstance().get(5);
      if (l2 != l3)
      {
        l3 = bu.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("ChatImgAutoDownloadMax"), 0);
        localObject = String.format("%d,%d", new Object[] { Long.valueOf(bu.a((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILG, null), 0L)), Long.valueOf(l3) });
        ae.i("MicroMsg.Priority.PriorityReportLogic", "report16341 %s", new Object[] { localObject });
        com.tencent.mm.plugin.report.e.ywz.kvStat(16341, (String)localObject);
        PluginPriority.this.xao.ad(16777218L, l2);
      }
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(PluginPriority.this.xaB, null);
      localObject = PluginPriority.this.xap;
      l2 = System.currentTimeMillis();
      String str = String.format("DELETE FROM %s WHERE createtime < ?", new Object[] { "C2CMsgAutoDownloadRes" });
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).xao.execSQL(str, new String[] { String.valueOf(l2 - 7776000000L) });
      localObject = new com.tencent.mm.plugin.priority.model.b.c();
      PluginPriority.this.xav.a((com.tencent.mm.plugin.priority.model.b.a)localObject);
      ae.i("MicroMsg.Priority.PluginPriority", "Init Priority Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(87769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority
 * JD-Core Version:    0.7.0.1
 */