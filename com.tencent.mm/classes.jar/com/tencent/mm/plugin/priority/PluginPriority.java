package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.model.a.a.a.a;
import com.tencent.mm.plugin.priority.model.d.a;
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
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PluginPriority
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.priority.a.a
{
  private long AXP;
  private com.tencent.mm.plugin.priority.model.b AXQ;
  private com.tencent.mm.plugin.priority.model.a.c.c AXR;
  private com.tencent.mm.plugin.priority.model.a.b.c AXS;
  private com.tencent.mm.plugin.priority.model.a.c.d AXT;
  private com.tencent.mm.plugin.priority.model.a.b.d AXU;
  private com.tencent.mm.plugin.priority.model.a.a.c AXV;
  private com.tencent.mm.plugin.priority.model.a.a.b AXW;
  private com.tencent.mm.plugin.priority.model.d AXX;
  private com.tencent.mm.plugin.priority.model.a.c.b AXY;
  private com.tencent.mm.plugin.priority.model.a.b.b AXZ;
  private com.tencent.mm.plugin.priority.model.a.a.a AYa;
  private com.tencent.mm.plugin.priority.model.a.c.a AYb;
  private com.tencent.mm.plugin.priority.model.a.b.a AYc;
  private i.a AYd;
  private IListener<ol> AYe;
  private MStorageEx.IOnStorageChange wYb;
  private MStorageEx.IOnStorageChange wYc;
  
  public PluginPriority()
  {
    AppMethodBeat.i(87770);
    this.AYd = new i.a()
    {
      public final void a(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(87765);
        if (paramAnonymousc.zqn.equals("insert"))
        {
          int i = 0;
          if (i < paramAnonymousc.hIs.size())
          {
            paramAnonymousi = (ca)paramAnonymousc.hIs.get(i);
            label70:
            com.tencent.mm.plugin.priority.model.a.a.a locala;
            if ((paramAnonymousi.field_isSend == 0) && (paramAnonymousi.gAz()))
            {
              ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).at(paramAnonymousi);
              if (PluginPriority.this.getC2CChatUsageLogic() != null)
              {
                if (paramAnonymousi.field_isSend != 1) {
                  break label165;
                }
                locala = PluginPriority.this.getC2CChatUsageLogic();
                paramAnonymousi = paramAnonymousi.field_talker;
                ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, paramAnonymousi, 1));
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if ((paramAnonymousi.field_isSend != 0) || (!paramAnonymousi.dOQ())) {
                break label70;
              }
              ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).au(paramAnonymousi);
              break label70;
              label165:
              locala = PluginPriority.this.getC2CChatUsageLogic();
              paramAnonymousi = paramAnonymousi.field_talker;
              ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, paramAnonymousi, 3));
            }
          }
        }
        AppMethodBeat.o(87765);
      }
    };
    this.AYe = new IListener() {};
    this.wYb = new MStorageEx.IOnStorageChange()
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
    this.wYc = new MStorageEx.IOnStorageChange()
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
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(87773);
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.comm.a.b.class, new a());
    }
    AppMethodBeat.o(87773);
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.a getC2CChatUsageLogic()
  {
    return this.AYa;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.b getC2CChatUsageResultStorage()
  {
    return this.AXW;
  }
  
  public com.tencent.mm.plugin.priority.model.a.a.c getC2CChatUsageStorage()
  {
    return this.AXV;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.a getC2CFileAutoDownloader()
  {
    return this.AYc;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.a getC2CImgAutoDownloader()
  {
    return this.AYb;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.b getC2CMsgAutoDownloadFileLogic()
  {
    return this.AXZ;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.c getC2CMsgAutoDownloadFileStorage()
  {
    return this.AXS;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.b getC2CMsgAutoDownloadImgLogic()
  {
    return this.AXY;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.c getC2CMsgAutoDownloadImgStorage()
  {
    return this.AXR;
  }
  
  public com.tencent.mm.plugin.priority.model.a.b.d getC2CMsgFileUsageStorage()
  {
    return this.AXU;
  }
  
  public com.tencent.mm.plugin.priority.model.a.c.d getC2CMsgImgUsageStorage()
  {
    return this.AXT;
  }
  
  public float getFileBgBorderPriority()
  {
    AppMethodBeat.i(87776);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRS, 5);
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
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRT, 10);
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
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRO, 10);
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
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRN, 30);
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
    return this.AXP;
  }
  
  public com.tencent.mm.plugin.priority.model.b getPriorityDB()
  {
    return this.AXQ;
  }
  
  public com.tencent.mm.plugin.priority.model.d getPriorityTaskRunner()
  {
    return this.AXX;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(87771);
    ThreadPool.post(new a((byte)0), "Priority.InitPriorityTask");
    com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.priority.model.a(), new String[] { "//priority" });
    this.AYe.alive();
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().add(this.wYb);
    ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().add(this.wYc);
    AppMethodBeat.o(87771);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(87772);
    this.AYe.dead();
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().remove(this.wYb);
    ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().remove(this.wYc);
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.AYd);
    Object localObject;
    if (this.AYb != null)
    {
      localObject = this.AYb;
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).AYM = 0L;
      q.bcS().a((e.a)localObject);
      ((com.tencent.mm.plugin.priority.model.a.c.a)localObject).iWS.dead();
      this.AYb = null;
    }
    if (this.AXY != null) {
      this.AXY = null;
    }
    if (this.AXX != null)
    {
      localObject = this.AXX;
      ((com.tencent.mm.plugin.priority.model.d)localObject).AYo.clear();
      ((com.tencent.mm.plugin.priority.model.d)localObject).AYp.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.priority.model.d)localObject).AYp.quit();
      ((com.tencent.mm.plugin.priority.model.d)localObject).AYp = null;
      this.AXX = null;
    }
    if (this.AXR != null)
    {
      localObject = this.AXR;
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).AYx.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).AYG.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).AYI.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).AYJ.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).AYK.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).AYL.close();
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).AYH.close();
      this.AXR = null;
    }
    if (this.AXT != null)
    {
      localObject = this.AXT;
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).AYr.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).AYs.close();
      ((com.tencent.mm.plugin.priority.model.a.a)localObject).AYt.close();
    }
    if (this.AXQ != null)
    {
      localObject = this.AXQ;
      SQLiteDatabase localSQLiteDatabase = ((com.tencent.mm.plugin.priority.model.b)localObject).AYk;
      if (((com.tencent.mm.plugin.priority.model.b)localObject).AYk == null) {}
      for (boolean bool = false;; bool = ((com.tencent.mm.plugin.priority.model.b)localObject).AYk.isOpen())
      {
        Log.w("MicroMsg.Priority.PriorityDB", "close db:%s isOpen:%b ", new Object[] { localSQLiteDatabase, Boolean.valueOf(bool) });
        if ((((com.tencent.mm.plugin.priority.model.b)localObject).AYk == null) || (!((com.tencent.mm.plugin.priority.model.b)localObject).AYk.isOpen())) {
          break label433;
        }
        Log.w("MicroMsg.Priority.PriorityDB", "close in trans :%b ", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.priority.model.b)localObject).AYk.inTransaction()) });
        while (((com.tencent.mm.plugin.priority.model.b)localObject).AYk.inTransaction()) {
          ((com.tencent.mm.plugin.priority.model.b)localObject).AYk.endTransaction();
        }
      }
      ((com.tencent.mm.plugin.priority.model.b)localObject).AYl.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).AYm.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).AYn.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).AYk.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).AYk = null;
      label433:
      this.AXQ = null;
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
      int i = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Oin, 0);
      if (i != 6)
      {
        Log.i("MicroMsg.Priority.PluginPriority", "New DB FILE %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(6) });
        com.tencent.mm.kernel.g.aAi();
        s.deleteFile(aa.z(new o(com.tencent.mm.kernel.g.aAh().cachePath, "MicroMsgPriority.db").her()));
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oin, Integer.valueOf(6));
      }
      Object localObject = PluginPriority.this;
      com.tencent.mm.kernel.g.aAi();
      PluginPriority.access$102((PluginPriority)localObject, new com.tencent.mm.plugin.priority.model.b(com.tencent.mm.kernel.g.aAh().cachePath));
      PluginPriority.access$202(PluginPriority.this, PluginPriority.this.AXQ.ag(16777217L, 0L));
      if (PluginPriority.this.AXP == 0L)
      {
        PluginPriority.access$202(PluginPriority.this, System.currentTimeMillis());
        PluginPriority.this.AXQ.ah(16777217L, PluginPriority.this.AXP);
      }
      Log.i("MicroMsg.Priority.PluginPriority", "install priority time %s", new Object[] { com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", PluginPriority.this.AXP / 1000L) });
      PluginPriority.access$302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.c(PluginPriority.this.AXQ));
      PluginPriority.access$402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.c(PluginPriority.this.AXQ));
      PluginPriority.access$502(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.d(PluginPriority.this.AXQ));
      PluginPriority.access$602(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.d(PluginPriority.this.AXQ));
      PluginPriority.access$702(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.c(PluginPriority.this.AXQ));
      PluginPriority.access$802(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.b(PluginPriority.this.AXQ));
      PluginPriority.access$902(PluginPriority.this, new com.tencent.mm.plugin.priority.model.d());
      PluginPriority.access$1002(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.b());
      PluginPriority.access$1102(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.b());
      PluginPriority.access$1202(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.c.a());
      PluginPriority.access$1302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.b.a());
      PluginPriority.access$1402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.a.a.a());
      localObject = PluginPriority.this.AXX;
      Log.i("MicroMsg.Priority.PriorityTaskRunner", "start tick");
      ((com.tencent.mm.plugin.priority.model.d)localObject).HJ(0L);
      long l3 = PluginPriority.this.AXQ.ag(16777218L, -1L);
      long l2 = Calendar.getInstance().get(5);
      if (l2 != l3)
      {
        l3 = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ChatImgAutoDownloadMax"), 0);
        localObject = String.format("%d,%d", new Object[] { Long.valueOf(Util.nullAs((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTI, null), 0L)), Long.valueOf(l3) });
        Log.i("MicroMsg.Priority.PriorityReportLogic", "report16341 %s", new Object[] { localObject });
        com.tencent.mm.plugin.report.e.Cxv.kvStat(16341, (String)localObject);
        PluginPriority.this.AXQ.ah(16777218L, l2);
      }
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(PluginPriority.this.AYd, null);
      localObject = PluginPriority.this.AXR;
      l2 = System.currentTimeMillis();
      String str = String.format("DELETE FROM %s WHERE createtime < ?", new Object[] { "C2CMsgAutoDownloadRes" });
      ((com.tencent.mm.plugin.priority.model.a.c.c)localObject).AXQ.execSQL(str, new String[] { String.valueOf(l2 - 7776000000L) });
      localObject = new com.tencent.mm.plugin.priority.model.b.c();
      PluginPriority.this.AXX.a((com.tencent.mm.plugin.priority.model.b.a)localObject);
      Log.i("MicroMsg.Priority.PluginPriority", "Init Priority Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(87769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority
 * JD-Core Version:    0.7.0.1
 */