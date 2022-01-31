package com.tencent.mm.plugin.report;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MatrixReport.Builder;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mrs.util.MatrixReportBroadcast;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginReport
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.b, com.tencent.mm.kernel.api.c, c
{
  private com.tencent.mm.model.p nEF;
  
  public List<String> collectStoragePaths()
  {
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "logcat/" });
    return localLinkedList;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    if (ae.cqV())
    {
      y.i("Matrix.PluginReport", "load matrixmrs so");
      k.b("matrixmrs", PluginReport.class.getClassLoader());
    }
    this.nEF = new com.tencent.mm.model.p(j.class);
    com.tencent.mm.kernel.g.a(com.tencent.mm.model.p.class, new e(this.nEF));
    Object localObject1 = f.nEG;
    Object localObject2 = com.tencent.mm.plugin.report.service.h.nFQ;
    y.i("MicroMsg.ReportService", "instance set %s", new Object[] { localObject2 });
    ((f)localObject1).nEH = ((d)localObject2);
    MatrixReport.setMrsCallback(new com.tencent.mrs.a.a());
    paramg = paramg.bT;
    com.tencent.matrix.a.a(new com.tencent.mrs.a.1());
    boolean bool1;
    if ((com.tencent.mm.sdk.platformtools.d.ENABLE_FPS_ANALYSE) && (!com.tencent.mm.protocal.d.spb))
    {
      bool1 = true;
      if ((!com.tencent.mm.sdk.platformtools.d.ENABLE_MATRIX) || (com.tencent.mm.protocal.d.spb)) {
        break label492;
      }
    }
    label492:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject1 = new com.tencent.matrix.a.a(paramg);
      localObject2 = new com.tencent.matrix.trace.a.a.a();
      ((com.tencent.matrix.trace.a.a.a)localObject2).bqJ = bool2;
      ((com.tencent.matrix.trace.a.a.a)localObject2).bqI = bool1;
      ((com.tencent.matrix.trace.a.a.a)localObject2).bqR = "com.tencent.mm.app.WeChatSplashActivity";
      ((com.tencent.matrix.a.a)localObject1).a(new com.tencent.matrix.trace.a(new com.tencent.matrix.trace.a.a(((com.tencent.matrix.trace.a.a.a)localObject2).bqI, ((com.tencent.matrix.trace.a.a.a)localObject2).bqJ, ((com.tencent.matrix.trace.a.a.a)localObject2).bqL, ((com.tencent.matrix.trace.a.a.a)localObject2).bqM, ((com.tencent.matrix.trace.a.a.a)localObject2).bqP, ((com.tencent.matrix.trace.a.a.a)localObject2).bqQ, ((com.tencent.matrix.trace.a.a.a)localObject2).bqN, ((com.tencent.matrix.trace.a.a.a)localObject2).bqO, ((com.tencent.matrix.trace.a.a.a)localObject2).bqK, ((com.tencent.matrix.trace.a.a.a)localObject2).bqS, ((com.tencent.matrix.trace.a.a.a)localObject2).bqR, (byte)0)));
      if (bool2)
      {
        localObject2 = new com.tencent.matrix.resource.b.a.a();
        ((com.tencent.matrix.resource.b.a.a)localObject2).boV = com.tencent.mm.sdk.a.b.cqi();
        ((com.tencent.matrix.a.a)localObject1).a(new com.tencent.matrix.resource.c(new com.tencent.matrix.resource.b.a(((com.tencent.matrix.resource.b.a.a)localObject2).boT, ((com.tencent.matrix.resource.b.a.a)localObject2).boU, ((com.tencent.matrix.resource.b.a.a)localObject2).boV, (byte)0)));
        ((com.tencent.matrix.a.a)localObject1).a(new com.tencent.matrix.a.a(new com.tencent.matrix.a.a.a.a().ee(1).ee(4).ee(8).qP()));
        com.tencent.matrix.resource.c.a(paramg);
        ((com.tencent.matrix.a.a)localObject1).a(new com.tencent.matrix.iocanary.a());
        ((com.tencent.matrix.a.a)localObject1).a(new com.tencent.sqlitelint.h(com.tencent.mrs.a.cNE()));
      }
      com.tencent.mrs.a.wDn = new com.tencent.mrs.b.a(paramg);
      ((com.tencent.matrix.a.a)localObject1).bmp = com.tencent.mrs.a.wDn;
      if (((com.tencent.matrix.a.a)localObject1).bmp == null) {
        ((com.tencent.matrix.a.a)localObject1).bmp = new com.tencent.matrix.b.a(((com.tencent.matrix.a.a)localObject1).application);
      }
      com.tencent.matrix.a.a(new com.tencent.matrix.a(((com.tencent.matrix.a.a)localObject1).application, ((com.tencent.matrix.a.a)localObject1).bmp, ((com.tencent.matrix.a.a)localObject1).bmo, (byte)0));
      if (!bool2) {
        break label497;
      }
      paramg = com.tencent.matrix.a.qO().bmo.iterator();
      while (paramg.hasNext()) {
        ((com.tencent.matrix.b.b)paramg.next()).start();
      }
      bool1 = false;
      break;
    }
    label497:
    ((com.tencent.matrix.trace.a)com.tencent.matrix.a.qO().l(com.tencent.matrix.trace.a.class)).start();
  }
  
  public void dependency()
  {
    dependsOn(com.tencent.mm.plugin.messenger.foundation.a.p.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (!com.tencent.matrix.a.isInstalled())
    {
      com.tencent.matrix.d.b.e("Matrix.Manager", "init matrix report, matrix is not installed, just return", new Object[0]);
      return;
    }
    com.tencent.matrix.d.b.i("Matrix.Manager", "try to init matrix report", new Object[0]);
    MatrixReport.init(new MatrixReport.Builder(ae.getContext()).clientVersion(com.tencent.mm.protocal.d.spa).isDebug(com.tencent.mm.sdk.a.b.cqi()).revision(com.tencent.mm.sdk.platformtools.d.REV).processName(ae.getProcessName()).isReportProcess(ae.cqV()).build());
  }
  
  public void installed()
  {
    alias(c.class);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    if (!MatrixReport.isInstalled())
    {
      com.tencent.matrix.d.b.e("Matrix.Manager", "setUin, matrix report is not installed, just return", new Object[0]);
      return;
    }
    com.tencent.matrix.d.b.i("Matrix.Manager", "matrix report set the uin", new Object[0]);
    paramc = MatrixReport.with();
    com.tencent.mm.kernel.g.DN();
    paramc.setUin(com.tencent.mm.kernel.a.CK());
    paramc = com.tencent.mrs.a.wDn;
    Looper.getMainLooper();
    Looper.myQueue().addIdleHandler(new com.tencent.mrs.b.a.1(paramc));
    MatrixReportBroadcast.cNF();
  }
  
  public void onAccountRelease() {}
  
  public String toString()
  {
    return "plugin-report";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.PluginReport
 * JD-Core Version:    0.7.0.1
 */