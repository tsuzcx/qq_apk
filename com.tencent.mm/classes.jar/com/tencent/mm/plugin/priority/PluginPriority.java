package com.tencent.mm.plugin.priority;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qu;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.priority.model.c2c.a.a.a;
import com.tencent.mm.plugin.priority.model.d.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PluginPriority
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.priority.a.a
{
  private MStorageEx.IOnStorageChange HuS;
  private MStorageEx.IOnStorageChange HuT;
  private com.tencent.mm.plugin.priority.model.c2c.img.b MPA;
  private com.tencent.mm.plugin.priority.model.c2c.b.b MPB;
  private com.tencent.mm.plugin.priority.model.c2c.a.a MPC;
  private com.tencent.mm.plugin.priority.model.c2c.img.a MPD;
  private com.tencent.mm.plugin.priority.model.c2c.b.a MPE;
  private i.a MPF;
  private IListener<qu> MPG;
  private long MPr;
  private com.tencent.mm.plugin.priority.model.b MPs;
  private com.tencent.mm.plugin.priority.model.c2c.img.c MPt;
  private com.tencent.mm.plugin.priority.model.c2c.b.c MPu;
  private com.tencent.mm.plugin.priority.model.c2c.img.d MPv;
  private com.tencent.mm.plugin.priority.model.c2c.b.d MPw;
  private com.tencent.mm.plugin.priority.model.c2c.a.c MPx;
  private com.tencent.mm.plugin.priority.model.c2c.a.b MPy;
  private com.tencent.mm.plugin.priority.model.d MPz;
  
  public PluginPriority()
  {
    AppMethodBeat.i(87770);
    this.MPF = new i.a()
    {
      public final void onNotifyChange(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(87765);
        if (CrashReportFactory.isBackupMerge())
        {
          AppMethodBeat.o(87765);
          return;
        }
        if (paramAnonymousc.KRm.equals("insert"))
        {
          int i = 0;
          if (i < paramAnonymousc.mZo.size())
          {
            paramAnonymousi = (cc)paramAnonymousc.mZo.get(i);
            label82:
            com.tencent.mm.plugin.priority.model.c2c.a.a locala;
            if ((paramAnonymousi.field_isSend == 0) && (paramAnonymousi.iYk()))
            {
              ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).aK(paramAnonymousi);
              if (PluginPriority.this.getC2CChatUsageLogic() != null)
              {
                if (paramAnonymousi.field_isSend != 1) {
                  break label177;
                }
                locala = PluginPriority.this.getC2CChatUsageLogic();
                paramAnonymousi = paramAnonymousi.field_talker;
                ((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, paramAnonymousi, 1));
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if ((paramAnonymousi.field_isSend != 0) || (!paramAnonymousi.fxR())) {
                break label82;
              }
              ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).aL(paramAnonymousi);
              break label82;
              label177:
              locala = PluginPriority.this.getC2CChatUsageLogic();
              paramAnonymousi = paramAnonymousi.field_talker;
              ((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, paramAnonymousi, 3));
            }
          }
        }
        AppMethodBeat.o(87765);
      }
    };
    this.MPG = new IListener(com.tencent.mm.app.f.hfK) {};
    this.HuS = new MStorageEx.IOnStorageChange()
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
            PluginPriority.this.getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.a.d(paramAnonymousMStorageEx));
          }
        }
      }
    };
    this.HuT = new MStorageEx.IOnStorageChange()
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
            PluginPriority.this.getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.a.d(paramAnonymousMStorageEx));
          }
        }
      }
    };
    AppMethodBeat.o(87770);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(87773);
    if (paramg.bbA()) {
      h.b(com.tencent.mm.plugin.comm.a.c.class, new a());
    }
    AppMethodBeat.o(87773);
  }
  
  public com.tencent.mm.plugin.priority.model.c2c.a.a getC2CChatUsageLogic()
  {
    return this.MPC;
  }
  
  public com.tencent.mm.plugin.priority.model.c2c.a.b getC2CChatUsageResultStorage()
  {
    return this.MPy;
  }
  
  public com.tencent.mm.plugin.priority.model.c2c.a.c getC2CChatUsageStorage()
  {
    return this.MPx;
  }
  
  public com.tencent.mm.plugin.priority.model.c2c.b.a getC2CFileAutoDownloader()
  {
    return this.MPE;
  }
  
  public com.tencent.mm.plugin.priority.model.c2c.img.a getC2CImgAutoDownloader()
  {
    return this.MPD;
  }
  
  public com.tencent.mm.plugin.priority.model.c2c.b.b getC2CMsgAutoDownloadFileLogic()
  {
    return this.MPB;
  }
  
  public com.tencent.mm.plugin.priority.model.c2c.b.c getC2CMsgAutoDownloadFileStorage()
  {
    return this.MPu;
  }
  
  public com.tencent.mm.plugin.priority.model.c2c.img.b getC2CMsgAutoDownloadImgLogic()
  {
    return this.MPA;
  }
  
  public com.tencent.mm.plugin.priority.model.c2c.img.c getC2CMsgAutoDownloadImgStorage()
  {
    return this.MPt;
  }
  
  public com.tencent.mm.plugin.priority.model.c2c.b.d getC2CMsgFileUsageStorage()
  {
    return this.MPw;
  }
  
  public com.tencent.mm.plugin.priority.model.c2c.img.d getC2CMsgImgUsageStorage()
  {
    return this.MPv;
  }
  
  public float getFileBgBorderPriority()
  {
    AppMethodBeat.i(87776);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLR, 5);
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
      int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLS, 10);
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
      int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLN, 10);
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
      int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLM, 30);
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
    return this.MPr;
  }
  
  public com.tencent.mm.plugin.priority.model.b getPriorityDB()
  {
    return this.MPs;
  }
  
  public com.tencent.mm.plugin.priority.model.d getPriorityTaskRunner()
  {
    return this.MPz;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(87771);
    ThreadPool.post(new a((byte)0), "Priority.InitPriorityTask");
    com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.priority.model.a(), new String[] { "//priority" });
    this.MPG.alive();
    ((n)h.ax(n.class)).bzG().add(this.HuS);
    ((n)h.ax(n.class)).bzA().add(this.HuT);
    AppMethodBeat.o(87771);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(87772);
    this.MPG.dead();
    ((n)h.ax(n.class)).bzG().remove(this.HuS);
    ((n)h.ax(n.class)).bzA().remove(this.HuT);
    ((n)h.ax(n.class)).gaZ().a(this.MPF);
    Object localObject;
    if (this.MPD != null)
    {
      localObject = this.MPD;
      ((com.tencent.mm.plugin.priority.model.c2c.img.a)localObject).MQo = 0L;
      r.bKb().a((f.a)localObject);
      ((com.tencent.mm.plugin.priority.model.c2c.img.a)localObject).oFU.dead();
      this.MPD = null;
    }
    if (this.MPA != null) {
      this.MPA = null;
    }
    if (this.MPz != null)
    {
      localObject = this.MPz;
      ((com.tencent.mm.plugin.priority.model.d)localObject).MPQ.clear();
      ((com.tencent.mm.plugin.priority.model.d)localObject).MPR.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.priority.model.d)localObject).MPR.quit();
      ((com.tencent.mm.plugin.priority.model.d)localObject).MPR = null;
      this.MPz = null;
    }
    if (this.MPt != null)
    {
      localObject = this.MPt;
      ((com.tencent.mm.plugin.priority.model.c2c.img.c)localObject).MPZ.close();
      ((com.tencent.mm.plugin.priority.model.c2c.img.c)localObject).MQi.close();
      ((com.tencent.mm.plugin.priority.model.c2c.img.c)localObject).MQk.close();
      ((com.tencent.mm.plugin.priority.model.c2c.img.c)localObject).MQl.close();
      ((com.tencent.mm.plugin.priority.model.c2c.img.c)localObject).MQm.close();
      ((com.tencent.mm.plugin.priority.model.c2c.img.c)localObject).MQn.close();
      ((com.tencent.mm.plugin.priority.model.c2c.img.c)localObject).MQj.close();
      this.MPt = null;
    }
    if (this.MPv != null)
    {
      localObject = this.MPv;
      ((com.tencent.mm.plugin.priority.model.c2c.a)localObject).MPT.close();
      ((com.tencent.mm.plugin.priority.model.c2c.a)localObject).MPU.close();
      ((com.tencent.mm.plugin.priority.model.c2c.a)localObject).MPV.close();
    }
    if (this.MPs != null)
    {
      localObject = this.MPs;
      SQLiteDatabase localSQLiteDatabase = ((com.tencent.mm.plugin.priority.model.b)localObject).MPM;
      if (((com.tencent.mm.plugin.priority.model.b)localObject).MPM == null) {}
      for (boolean bool = false;; bool = ((com.tencent.mm.plugin.priority.model.b)localObject).MPM.isOpen())
      {
        Log.w("MicroMsg.Priority.PriorityDB", "close db:%s isOpen:%b ", new Object[] { localSQLiteDatabase, Boolean.valueOf(bool) });
        if ((((com.tencent.mm.plugin.priority.model.b)localObject).MPM == null) || (!((com.tencent.mm.plugin.priority.model.b)localObject).MPM.isOpen())) {
          break label433;
        }
        Log.w("MicroMsg.Priority.PriorityDB", "close in trans :%b ", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.priority.model.b)localObject).MPM.inTransaction()) });
        while (((com.tencent.mm.plugin.priority.model.b)localObject).MPM.inTransaction()) {
          ((com.tencent.mm.plugin.priority.model.b)localObject).MPM.endTransaction();
        }
      }
      ((com.tencent.mm.plugin.priority.model.b)localObject).MPN.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).MPO.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).MPP.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).MPM.close();
      ((com.tencent.mm.plugin.priority.model.b)localObject).MPM = null;
      label433:
      this.MPs = null;
    }
    AppMethodBeat.o(87772);
  }
  
  public void parallelsDependency() {}
  
  public void registerMsgInfoStgNotify()
  {
    AppMethodBeat.i(283836);
    ((n)h.ax(n.class)).gaZ().a(this.MPF, null);
    AppMethodBeat.o(283836);
  }
  
  public void unregisterMsgInfoStgNotify()
  {
    AppMethodBeat.i(283842);
    ((n)h.ax(n.class)).gaZ().a(this.MPF);
    AppMethodBeat.o(283842);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(87769);
      long l1 = System.currentTimeMillis();
      int i = h.baE().ban().getInt(at.a.acYo, 0);
      if (i != 6)
      {
        Log.i("MicroMsg.Priority.PluginPriority", "New DB FILE %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(6) });
        h.baF();
        y.deleteFile(ah.v(new u(h.baE().cachePath, "MicroMsgPriority.db").jKT()));
        h.baE().ban().set(at.a.acYo, Integer.valueOf(6));
      }
      Object localObject = PluginPriority.this;
      h.baF();
      PluginPriority.access$102((PluginPriority)localObject, new com.tencent.mm.plugin.priority.model.b(h.baE().cachePath));
      PluginPriority.access$202(PluginPriority.this, PluginPriority.this.MPs.aY(16777217L, 0L));
      if (PluginPriority.this.MPr == 0L)
      {
        PluginPriority.access$202(PluginPriority.this, System.currentTimeMillis());
        PluginPriority.this.MPs.aZ(16777217L, PluginPriority.this.MPr);
      }
      Log.i("MicroMsg.Priority.PluginPriority", "install priority time %s", new Object[] { com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", PluginPriority.this.MPr / 1000L) });
      PluginPriority.access$302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.c2c.img.c(PluginPriority.this.MPs));
      PluginPriority.access$402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.c2c.b.c(PluginPriority.this.MPs));
      PluginPriority.access$502(PluginPriority.this, new com.tencent.mm.plugin.priority.model.c2c.img.d(PluginPriority.this.MPs));
      PluginPriority.access$602(PluginPriority.this, new com.tencent.mm.plugin.priority.model.c2c.b.d(PluginPriority.this.MPs));
      PluginPriority.access$702(PluginPriority.this, new com.tencent.mm.plugin.priority.model.c2c.a.c(PluginPriority.this.MPs));
      PluginPriority.access$802(PluginPriority.this, new com.tencent.mm.plugin.priority.model.c2c.a.b(PluginPriority.this.MPs));
      PluginPriority.access$902(PluginPriority.this, new com.tencent.mm.plugin.priority.model.d());
      PluginPriority.access$1002(PluginPriority.this, new com.tencent.mm.plugin.priority.model.c2c.img.b());
      PluginPriority.access$1102(PluginPriority.this, new com.tencent.mm.plugin.priority.model.c2c.b.b());
      PluginPriority.access$1202(PluginPriority.this, new com.tencent.mm.plugin.priority.model.c2c.img.a());
      PluginPriority.access$1302(PluginPriority.this, new com.tencent.mm.plugin.priority.model.c2c.b.a());
      PluginPriority.access$1402(PluginPriority.this, new com.tencent.mm.plugin.priority.model.c2c.a.a());
      localObject = PluginPriority.this.MPz;
      Log.i("MicroMsg.Priority.PriorityTaskRunner", "start tick");
      ((com.tencent.mm.plugin.priority.model.d)localObject).tf(0L);
      long l3 = PluginPriority.this.MPs.aY(16777218L, -1L);
      long l2 = Calendar.getInstance().get(5);
      if (l2 != l3)
      {
        l3 = Util.getInt(((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("ChatImgAutoDownloadMax"), 0);
        localObject = String.format("%d,%d", new Object[] { Long.valueOf(Util.nullAs((Long)h.baE().ban().get(at.a.acJc, null), 0L)), Long.valueOf(l3) });
        Log.i("MicroMsg.Priority.PriorityReportLogic", "report16341 %s", new Object[] { localObject });
        com.tencent.mm.plugin.report.f.Ozc.kvStat(16341, (String)localObject);
        PluginPriority.this.MPs.aZ(16777218L, l2);
      }
      ((n)h.ax(n.class)).gaZ().a(PluginPriority.this.MPF, null);
      localObject = PluginPriority.this.MPt;
      l2 = System.currentTimeMillis();
      String str = String.format("DELETE FROM %s WHERE createtime < ?", new Object[] { "C2CMsgAutoDownloadRes" });
      ((com.tencent.mm.plugin.priority.model.c2c.img.c)localObject).MPs.execSQL(str, new String[] { String.valueOf(l2 - 7776000000L) });
      localObject = new com.tencent.mm.plugin.priority.model.a.c();
      PluginPriority.this.MPz.a((com.tencent.mm.plugin.priority.model.a.a)localObject);
      Log.i("MicroMsg.Priority.PluginPriority", "Init Priority Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(87769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority
 * JD-Core Version:    0.7.0.1
 */