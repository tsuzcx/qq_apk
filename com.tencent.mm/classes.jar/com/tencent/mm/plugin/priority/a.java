package com.tencent.mm.plugin.priority;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.wcdb.database.SQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.comm.a.b
{
  public final void T(String paramString, long paramLong)
  {
    AppMethodBeat.i(87791);
    if ((com.tencent.mm.kernel.g.agM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new b(paramString, paramLong));
    }
    AppMethodBeat.o(87791);
  }
  
  public final void Wm(String paramString)
  {
    AppMethodBeat.i(87793);
    cJ(paramString, 1);
    AppMethodBeat.o(87793);
  }
  
  public final void a(bo parambo, Runnable paramRunnable)
  {
    AppMethodBeat.i(87789);
    if ((com.tencent.mm.kernel.g.agM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new f(parambo, new WeakReference(paramRunnable)));
    }
    AppMethodBeat.o(87789);
  }
  
  public final void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(87790);
    if ((com.tencent.mm.kernel.g.agM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a(paramBoolean1, paramString, paramLong, paramBoolean2));
    }
    AppMethodBeat.o(87790);
  }
  
  public final void af(bo parambo)
  {
    AppMethodBeat.i(87787);
    if ((com.tencent.mm.kernel.g.agM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new e(parambo));
    }
    AppMethodBeat.o(87787);
  }
  
  public final void ag(bo parambo)
  {
    AppMethodBeat.i(87788);
    if ((com.tencent.mm.kernel.g.agM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.b(parambo));
    }
    AppMethodBeat.o(87788);
  }
  
  public final void ah(bo parambo)
  {
    AppMethodBeat.i(87792);
    if ((com.tencent.mm.kernel.g.agM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new c(parambo));
    }
    AppMethodBeat.o(87792);
  }
  
  public final void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(87786);
    if ((com.tencent.mm.kernel.g.agM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new d(paramLong, paramBoolean1, paramBoolean2));
    }
    AppMethodBeat.o(87786);
  }
  
  public final List<Pair<String, String>> bWY()
  {
    AppMethodBeat.i(87794);
    new com.tencent.mm.plugin.priority.model.b.c().run();
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().doL();
    AppMethodBeat.o(87794);
    return localList;
  }
  
  public final void cJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(174312);
    if ((com.tencent.mm.kernel.g.agM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new g(paramString, paramInt));
    }
    AppMethodBeat.o(174312);
  }
  
  public final List<Pair<String, String>> rN(long paramLong)
  {
    AppMethodBeat.i(87795);
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().wk(paramLong);
    AppMethodBeat.o(87795);
    return localList;
  }
  
  public final List<Pair<String, String>> rO(long paramLong)
  {
    AppMethodBeat.i(87796);
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().wk(paramLong);
    AppMethodBeat.o(87796);
    return localList;
  }
  
  final class a
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private boolean deB;
    private long dpl;
    private boolean gRx;
    private String id;
    private boolean oJn;
    
    public a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
    {
      this.oJn = paramBoolean1;
      this.id = paramString;
      this.dpl = paramLong;
      this.deB = paramBoolean2;
      this.gRx = false;
    }
    
    public final String getName()
    {
      return "Priority.onC2CFileDownloadedTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87779);
      Object localObject;
      long l1;
      boolean bool3;
      hh localhh;
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        boolean bool1 = this.oJn;
        localObject = this.id;
        l1 = this.dpl;
        boolean bool2 = this.deB;
        bool3 = this.gRx;
        if (bool2)
        {
          localhh = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().ba((String)localObject, l1);
          if (localhh == null)
          {
            ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "sender file %s %s", new Object[] { localObject, Long.valueOf(l1) });
            AppMethodBeat.o(87779);
            return;
          }
          if ((localhh.ndj == 1) || (localhh.ndj == 2) || (localhh.ndj == 4)) {
            if (bool1) {
              break label428;
            }
          }
        }
      }
      label428:
      for (int i = 5;; i = 3)
      {
        l1 = System.currentTimeMillis();
        com.tencent.mm.plugin.priority.model.c.a(1, l1, i, localhh);
        localObject = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
        String str = localhh.Id;
        long l2 = localhh.DUD;
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).vEo.bindLong(1, l1);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).vEo.bindLong(2, i);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).vEo.bindString(3, str);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).vEo.bindLong(4, l2);
        ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatusAndDownloadTime %s res %s %s %s %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.b.c)localObject).vEo.executeUpdateDelete()), str, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
        AppMethodBeat.o(87779);
        return;
        ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "already auto download msgid %s %s", new Object[] { localObject, Long.valueOf(l1) });
        AppMethodBeat.o(87779);
        return;
        if (bool3)
        {
          ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download cancel %s %s", new Object[] { localObject, Long.valueOf(l1) });
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().j((String)localObject, l1, 1);
          AppMethodBeat.o(87779);
          return;
        }
        ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download fail %s %s", new Object[] { localObject, Long.valueOf(l1) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().j((String)localObject, l1, 4);
        AppMethodBeat.o(87779);
        return;
      }
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private long dpl;
    private String id;
    
    public b(String paramString, long paramLong)
    {
      this.id = paramString;
      this.dpl = paramLong;
    }
    
    public final String getName()
    {
      return "Priority.C2CFileOpenTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87780);
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        String str = this.id;
        long l1 = this.dpl;
        hh localhh = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().ba(str, l1);
        if (localhh == null)
        {
          ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "This File Sender is Me");
          AppMethodBeat.o(87780);
          return;
        }
        if (localhh.DUG > 0L)
        {
          ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "onFileOpen file already use %s %s", new Object[] { str, Long.valueOf(l1) });
          AppMethodBeat.o(87780);
          return;
        }
        if (w.sQ(localhh.vTL)) {
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().ik(localhh.vTL, "@all");
        }
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().ik(localhh.vTL, localhh.DUy);
        localhh.DUG = System.currentTimeMillis();
        com.tencent.mm.plugin.priority.model.a.b.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
        long l2 = localhh.DUG;
        localc.vEp.bindLong(1, l2);
        localc.vEp.bindString(2, str);
        localc.vEp.bindLong(3, l1);
        ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateOpenTime %s res %s %s %s", new Object[] { Integer.valueOf(localc.vEp.executeUpdateDelete()), str, Long.valueOf(l1), Long.valueOf(l2) });
        com.tencent.mm.plugin.priority.model.c.a(2, System.currentTimeMillis(), localhh.ndj, localhh);
      }
      AppMethodBeat.o(87780);
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bo dpq;
    
    public c(bo parambo)
    {
      this.dpq = parambo;
    }
    
    public final String getName()
    {
      return "C2CFileReceiveTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87781);
      if (this.dpq.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ac.i("MicroMsg.Priority.PriorityService", "onC2CFileReceive time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", this.dpq.field_createTime / 1000L) });
        AppMethodBeat.o(87781);
        return;
      }
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        Object localObject3 = this.dpq;
        Object localObject1 = ((dy)localObject3).field_talker;
        if ((w.sQ(((dy)localObject3).field_talker)) && (((dy)localObject3).field_isSend == 0))
        {
          localObject2 = bi.ym(((dy)localObject3).field_content);
          localObject1 = bs.bG(bi.yl(((dy)localObject3).field_content), "");
        }
        Object localObject4;
        for (;;)
        {
          localObject4 = k.b.vA((String)localObject2);
          if (localObject4 != null) {
            break;
          }
          ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "appMsgContent is null");
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((dy)localObject3).field_content;
        }
        if ((w.sQ(((dy)localObject3).field_talker)) && (((dy)localObject3).field_isSend == 0)) {
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().il(((dy)localObject3).field_talker, "@all");
        }
        double d;
        String str;
        for (int i = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().in(((dy)localObject3).field_talker, "@all");; i = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().in(((dy)localObject3).field_talker, ((dy)localObject3).field_talker))
        {
          d = Math.max(Math.max(localObject2[0], localObject2[1]), localObject2[2]);
          if (((k.b)localObject4).type != 6) {
            break label755;
          }
          str = String.valueOf(((dy)localObject3).field_msgId);
          if (!((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().aZ(str, ((dy)localObject3).field_msgSvrId)) {
            break;
          }
          ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { Long.valueOf(((dy)localObject3).field_msgId), Long.valueOf(((dy)localObject3).field_msgSvrId) });
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().il(((dy)localObject3).field_talker, ((dy)localObject3).field_talker);
        }
        Object localObject2 = new hh();
        ((hh)localObject2).Id = str;
        ((hh)localObject2).vTL = ((dy)localObject3).field_talker;
        ((hh)localObject2).DUy = ((String)localObject1);
        ((hh)localObject2).DUz = 2;
        ((hh)localObject2).DUA = ((dy)localObject3).field_createTime;
        if (i < 2) {}
        for (i = 1;; i = 0)
        {
          ((hh)localObject2).DUB = i;
          ((hh)localObject2).ndj = 1;
          ((hh)localObject2).DUC = 0L;
          ((hh)localObject2).DUD = ((dy)localObject3).field_msgSvrId;
          ((hh)localObject2).DUE = ((k.b)localObject4).hhF;
          ((hh)localObject2).DUF = ((k.b)localObject4).hhG;
          ((hh)localObject2).DUH = d;
          ((hh)localObject2).DUI = 1;
          ((hh)localObject2).DUJ = ((k.b)localObject4).cZa;
          localObject1 = com.tencent.mm.plugin.s.a.bEO().aGd(((k.b)localObject4).cZa);
          if (localObject1 != null)
          {
            localObject3 = new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((((com.tencent.mm.vfs.e)localObject3).exists()) && (((com.tencent.mm.vfs.e)localObject3).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen))
            {
              ((hh)localObject2).DUC = System.currentTimeMillis();
              ((hh)localObject2).ndj = 6;
            }
          }
          ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { ((hh)localObject2).vTL, bs.An(((hh)localObject2).DUE), ((hh)localObject2).DUF, Integer.valueOf(((hh)localObject2).DUB), Double.valueOf(((hh)localObject2).DUH) });
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a((hh)localObject2);
          if (w.sQ(((hh)localObject2).vTL)) {
            ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().ij(((hh)localObject2).vTL, "@all");
          }
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().ij(((hh)localObject2).vTL, ((hh)localObject2).DUy);
          com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), ((hh)localObject2).ndj, (hh)localObject2);
          AppMethodBeat.o(87781);
          return;
        }
        label755:
        if (((k.b)localObject4).type == 19)
        {
          localObject2 = n.aqs(((k.b)localObject4).hij).hkS.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (agx)((Iterator)localObject2).next();
            if (((agx)localObject4).dataType == 8)
            {
              str = ((agx)localObject4).dhw;
              if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().aZ(str, ((dy)localObject3).field_msgSvrId))
              {
                ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { str, Long.valueOf(((dy)localObject3).field_msgSvrId) });
              }
              else
              {
                hh localhh = new hh();
                localhh.Id = str;
                localhh.vTL = ((dy)localObject3).field_talker;
                localhh.DUy = ((String)localObject1);
                localhh.DUz = 3;
                localhh.DUA = ((dy)localObject3).field_createTime;
                if (i < 2) {}
                for (int j = 1;; j = 0)
                {
                  localhh.DUB = j;
                  localhh.ndj = 1;
                  localhh.DUC = 0L;
                  localhh.DUD = ((dy)localObject3).field_msgSvrId;
                  localhh.DUE = ((agx)localObject4).EzA;
                  localhh.DUF = ((agx)localObject4).Ezu;
                  localhh.DUH = d;
                  localhh.DUI = 1;
                  localhh.DUJ = ((agx)localObject4).Ezf;
                  ac.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { localhh.vTL, bs.An(localhh.DUE), localhh.DUF, Integer.valueOf(localhh.DUB), Double.valueOf(localhh.DUH) });
                  ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a(localhh);
                  if (w.sQ(localhh.vTL)) {
                    ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().ij(localhh.vTL, "@all");
                  }
                  ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().ij(localhh.vTL, localhh.DUy);
                  com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), localhh.ndj, localhh);
                  break;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(87781);
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private boolean deB;
    private boolean gRx;
    private long msgId;
    
    public d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.msgId = paramLong;
      this.deB = paramBoolean1;
      this.gRx = paramBoolean2;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgDownloadedTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87782);
      Object localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(this.msgId);
      if (((dy)localObject).field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ac.i("MicroMsg.Priority.PriorityService", "onC2CImgDownloaded time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((dy)localObject).field_createTime / 1000L) });
        AppMethodBeat.o(87782);
        return;
      }
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        boolean bool1 = this.deB;
        boolean bool2 = this.gRx;
        if (bool1)
        {
          hi localhi = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().wm(((dy)localObject).field_msgId);
          if (localhi == null)
          {
            ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "sender img %d", new Object[] { Long.valueOf(((dy)localObject).field_msgId) });
            AppMethodBeat.o(87782);
            return;
          }
          if (localhi.ndj == 3)
          {
            ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "already auto download msgid %d", new Object[] { Long.valueOf(((dy)localObject).field_msgId) });
            AppMethodBeat.o(87782);
            return;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 20L, 1L, false);
          if (localhi != null)
          {
            long l1 = System.currentTimeMillis();
            localObject = o.aFx().qf(localhi.DUD);
            localhi.DUL = ((com.tencent.mm.av.e)localObject).hux;
            com.tencent.mm.plugin.priority.model.c.a(1, l1, 0, localhi);
            com.tencent.mm.plugin.priority.model.a.c.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
            long l2 = localhi.DUK;
            int i = ((com.tencent.mm.av.e)localObject).hux;
            localc.vEo.bindLong(1, l1);
            localc.vEo.bindLong(2, 3L);
            localc.vEo.bindLong(3, i);
            localc.vEo.bindLong(4, l2);
            ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndDownloadTime %d res %d %d %d", new Object[] { Integer.valueOf(localc.vEo.executeUpdateDelete()), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(3) });
            if (com.tencent.mm.plugin.priority.a.a.a.gH(localhi.DUB, 1))
            {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 21L, 1L, false);
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 22L, ((com.tencent.mm.av.e)localObject).hux, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gH(localhi.DUB, 8))
            {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 23L, 1L, false);
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 24L, ((com.tencent.mm.av.e)localObject).hux, false);
            }
            if ((com.tencent.mm.plugin.priority.a.a.a.gH(localhi.DUB, 2)) || (com.tencent.mm.plugin.priority.a.a.a.gH(localhi.DUB, 4)))
            {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 25L, 1L, false);
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 26L, ((com.tencent.mm.av.e)localObject).hux, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gH(localhi.DUB, 16))
            {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 27L, 1L, false);
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 28L, ((com.tencent.mm.av.e)localObject).hux, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gH(localhi.DUB, 32))
            {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 29L, 1L, false);
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 30L, ((com.tencent.mm.av.e)localObject).hux, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gH(localhi.DUB, 64))
            {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 33L, 1L, false);
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 34L, ((com.tencent.mm.av.e)localObject).hux, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gH(localhi.DUB, 128))
            {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 35L, 1L, false);
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 36L, ((com.tencent.mm.av.e)localObject).hux, false);
            }
            AppMethodBeat.o(87782);
            return;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 31L, 1L, false);
          AppMethodBeat.o(87782);
          return;
        }
        if (!bool2) {
          break label814;
        }
        ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download cancel %d", new Object[] { Long.valueOf(((dy)localObject).field_msgId) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().O(((dy)localObject).field_msgId, 1);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 32L, 1L, false);
        AppMethodBeat.o(87782);
        return;
        label814:
        ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download fail %d", new Object[] { Long.valueOf(((dy)localObject).field_msgId) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().O(((dy)localObject).field_msgId, 4);
      }
    }
  }
  
  final class e
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bo dpq;
    
    public e(bo parambo)
    {
      this.dpq = parambo;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgOpenTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87783);
      if (this.dpq.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ac.i("MicroMsg.Priority.PriorityService", "onC2CImgOpen time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", this.dpq.field_createTime / 1000L) });
        AppMethodBeat.o(87783);
        return;
      }
      hi localhi;
      int i;
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        bo localbo = this.dpq;
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 10L, 1L, false);
        localhi = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().wm(localbo.field_msgId);
        if (localhi == null)
        {
          ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 13L, 1L, false);
          AppMethodBeat.o(87783);
          return;
        }
        if (localhi.DUG > 0L)
        {
          ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgOpen img already use %d", new Object[] { Long.valueOf(localbo.field_msgId) });
          AppMethodBeat.o(87783);
          return;
        }
        if (w.sQ(localbo.field_talker)) {
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().ik(localhi.vTL, "@all");
        }
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().ik(localhi.vTL, localhi.DUy);
        localhi.DUG = System.currentTimeMillis();
        com.tencent.mm.plugin.priority.model.a.c.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        long l1 = localbo.field_msgId;
        long l2 = localhi.DUG;
        localc.vEp.bindLong(1, l2);
        localc.vEp.bindLong(2, l1);
        ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateOpenTime %d res %d %d", new Object[] { Integer.valueOf(localc.vEp.executeUpdateDelete()), Long.valueOf(l1), Long.valueOf(l2) });
        if (localhi.ndj != 3) {
          break label394;
        }
        i = 1;
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 14L, 1L, false);
      }
      for (;;)
      {
        com.tencent.mm.plugin.priority.model.c.a(2, localhi.DUG, i, localhi);
        AppMethodBeat.o(87783);
        return;
        label394:
        if (localhi.ndj == 2)
        {
          i = 3;
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 16L, 1L, false);
        }
        else if (localhi.ndj == 4)
        {
          i = 4;
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 17L, 1L, false);
        }
        else if (localhi.ndj == 5)
        {
          i = 5;
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 18L, 1L, false);
        }
        else
        {
          i = 2;
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(957L, 15L, 1L, false);
        }
      }
    }
  }
  
  final class f
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bo dpq;
    private WeakReference<Runnable> vDL;
    
    f(WeakReference<Runnable> paramWeakReference)
    {
      this.dpq = paramWeakReference;
      Object localObject;
      this.vDL = localObject;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgScrollTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87784);
      if (this.dpq.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ac.i("MicroMsg.Priority.PriorityService", "onC2CImgScroll time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", this.dpq.field_createTime / 1000L) });
        AppMethodBeat.o(87784);
        return;
      }
      ac.i("MicroMsg.Priority.PriorityService", "C2CImgScrollTask Start To Auto Download %d MsgId %d", new Object[] { Integer.valueOf(32), Long.valueOf(this.dpq.field_msgId) });
      if (this.vDL.get() != null) {
        ((Runnable)this.vDL.get()).run();
      }
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      bo localbo = this.dpq;
      hi localhi = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().wm(localbo.field_msgId);
      if (localhi == null)
      {
        ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
        AppMethodBeat.o(87784);
        return;
      }
      if (localhi.ndj == 1) {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().m(localbo.field_msgId, 32, 2);
      }
      AppMethodBeat.o(87784);
    }
  }
  
  final class g
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private int score;
    private String vDM;
    
    public g(String paramString, int paramInt)
    {
      this.vDM = paramString;
      this.score = paramInt;
    }
    
    public final String getName()
    {
      return "Priority.C2CMsgConsumeTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87785);
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CChatUsageLogic() != null)
      {
        com.tencent.mm.plugin.priority.model.a.a.a locala = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CChatUsageLogic();
        String str = this.vDM;
        int i = this.score;
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.a.a.a.a(locala, str, i, (byte)0));
      }
      AppMethodBeat.o(87785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a
 * JD-Core Version:    0.7.0.1
 */