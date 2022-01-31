package com.tencent.mm.plugin.priority;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.List;

public class PluginPriority
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.priority.a.a
{
  private long ptd;
  private com.tencent.mm.plugin.priority.b.b pte;
  private com.tencent.mm.plugin.priority.b.a.c ptf;
  private com.tencent.mm.plugin.priority.b.a.d ptg;
  private com.tencent.mm.plugin.priority.b.d pth;
  private com.tencent.mm.plugin.priority.b.a.b pti;
  private com.tencent.mm.plugin.priority.b.a.a ptj;
  private h.a ptk;
  
  public PluginPriority()
  {
    AppMethodBeat.i(54868);
    this.ptk = new PluginPriority.1(this);
    AppMethodBeat.o(54868);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(54871);
    if (paramg.SD()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.comm.a.b.class, new a());
    }
    AppMethodBeat.o(54871);
  }
  
  public float getBgBorderPriority()
  {
    AppMethodBeat.i(54873);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTU, 10);
      float f = i / 100.0F;
      AppMethodBeat.o(54873);
      return f;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54873);
    }
    return 0.1F;
  }
  
  public float getBorderPriority()
  {
    AppMethodBeat.i(54872);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTT, 30);
      float f = i / 100.0F;
      AppMethodBeat.o(54872);
      return f;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54872);
    }
    return 0.5F;
  }
  
  public com.tencent.mm.plugin.priority.b.a.a getC2CImgAutoDownloader()
  {
    return this.ptj;
  }
  
  public com.tencent.mm.plugin.priority.b.a.b getC2CMsgAutoDownloadResLogic()
  {
    return this.pti;
  }
  
  public com.tencent.mm.plugin.priority.b.a.c getC2CMsgAutoDownloadResStorage()
  {
    return this.ptf;
  }
  
  public com.tencent.mm.plugin.priority.b.a.d getC2CMsgImgUsageStorage()
  {
    return this.ptg;
  }
  
  public long getInstallPriorityTime()
  {
    return this.ptd;
  }
  
  public com.tencent.mm.plugin.priority.b.d getPriorityTaskRunner()
  {
    return this.pth;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(54869);
    com.tencent.mm.sdk.g.d.post(new PluginPriority.a(this, (byte)0), "Priority.InitPriorityTask");
    com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.priority.b.a(), new String[] { "//priority" });
    AppMethodBeat.o(54869);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(54870);
    ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.ptk);
    Object localObject;
    if (this.ptj != null)
    {
      localObject = this.ptj;
      ((com.tencent.mm.plugin.priority.b.a.a)localObject).ptz = 0L;
      o.ahD().a((com.tencent.mm.at.d.a)localObject);
      ((com.tencent.mm.plugin.priority.b.a.a)localObject).fDu.dead();
      this.ptj = null;
    }
    if (this.pti != null) {
      this.pti = null;
    }
    if (this.pth != null)
    {
      localObject = this.pth;
      ((com.tencent.mm.plugin.priority.b.d)localObject).ptv.clear();
      ((com.tencent.mm.plugin.priority.b.d)localObject).ptx.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.priority.b.d)localObject).ptw.oNc.quit();
      ((com.tencent.mm.plugin.priority.b.d)localObject).ptx = null;
      ((com.tencent.mm.plugin.priority.b.d)localObject).ptw = null;
      this.pth = null;
    }
    if (this.ptf != null)
    {
      localObject = this.ptf;
      ((com.tencent.mm.plugin.priority.b.a.c)localObject).ptG.close();
      ((com.tencent.mm.plugin.priority.b.a.c)localObject).ptH.close();
      ((com.tencent.mm.plugin.priority.b.a.c)localObject).ptI.close();
      ((com.tencent.mm.plugin.priority.b.a.c)localObject).ptJ.close();
      ((com.tencent.mm.plugin.priority.b.a.c)localObject).ptK.close();
      ((com.tencent.mm.plugin.priority.b.a.c)localObject).ptL.close();
      this.ptf = null;
    }
    if (this.ptg != null)
    {
      localObject = this.ptg;
      ((com.tencent.mm.plugin.priority.b.a.d)localObject).ptM.close();
      ((com.tencent.mm.plugin.priority.b.a.d)localObject).ptN.close();
      ((com.tencent.mm.plugin.priority.b.a.d)localObject).ptO.close();
    }
    if (this.pte != null)
    {
      localObject = this.pte;
      SQLiteDatabase localSQLiteDatabase = ((com.tencent.mm.plugin.priority.b.b)localObject).ptp;
      if (((com.tencent.mm.plugin.priority.b.b)localObject).ptp == null) {}
      for (boolean bool = false;; bool = ((com.tencent.mm.plugin.priority.b.b)localObject).ptp.isOpen())
      {
        ab.w("MicroMsg.Priority.PriorityDB", "close db:%s isOpen:%b ", new Object[] { localSQLiteDatabase, Boolean.valueOf(bool) });
        if ((((com.tencent.mm.plugin.priority.b.b)localObject).ptp == null) || (!((com.tencent.mm.plugin.priority.b.b)localObject).ptp.isOpen())) {
          break label379;
        }
        ab.w("MicroMsg.Priority.PriorityDB", "close in trans :%b ", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.priority.b.b)localObject).ptp.inTransaction()) });
        while (((com.tencent.mm.plugin.priority.b.b)localObject).ptp.inTransaction()) {
          ((com.tencent.mm.plugin.priority.b.b)localObject).ptp.endTransaction();
        }
      }
      ((com.tencent.mm.plugin.priority.b.b)localObject).ptq.close();
      ((com.tencent.mm.plugin.priority.b.b)localObject).ptt.close();
      ((com.tencent.mm.plugin.priority.b.b)localObject).ptu.close();
      ((com.tencent.mm.plugin.priority.b.b)localObject).ptp.close();
      ((com.tencent.mm.plugin.priority.b.b)localObject).ptp = null;
      label379:
      this.pte = null;
    }
    AppMethodBeat.o(54870);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority
 * JD-Core Version:    0.7.0.1
 */