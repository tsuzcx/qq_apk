package com.tencent.mm.plugin.priority;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.wcdb.database.SQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.comm.a.b
{
  public final void S(String paramString, long paramLong)
  {
    AppMethodBeat.i(87791);
    if ((com.tencent.mm.kernel.g.afw()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new b(paramString, paramLong));
    }
    AppMethodBeat.o(87791);
  }
  
  public final void Sa(String paramString)
  {
    AppMethodBeat.i(87793);
    cE(paramString, 1);
    AppMethodBeat.o(87793);
  }
  
  public final void a(bl parambl, Runnable paramRunnable)
  {
    AppMethodBeat.i(87789);
    if ((com.tencent.mm.kernel.g.afw()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new f(parambl, new WeakReference(paramRunnable)));
    }
    AppMethodBeat.o(87789);
  }
  
  public final void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(87790);
    if ((com.tencent.mm.kernel.g.afw()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a(paramBoolean1, paramString, paramLong, paramBoolean2));
    }
    AppMethodBeat.o(87790);
  }
  
  public final void af(bl parambl)
  {
    AppMethodBeat.i(87787);
    if ((com.tencent.mm.kernel.g.afw()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new e(parambl));
    }
    AppMethodBeat.o(87787);
  }
  
  public final void ag(bl parambl)
  {
    AppMethodBeat.i(87788);
    if ((com.tencent.mm.kernel.g.afw()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.b(parambl));
    }
    AppMethodBeat.o(87788);
  }
  
  public final void ah(bl parambl)
  {
    AppMethodBeat.i(87792);
    if ((com.tencent.mm.kernel.g.afw()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new c(parambl));
    }
    AppMethodBeat.o(87792);
  }
  
  public final List<Pair<String, String>> bPI()
  {
    AppMethodBeat.i(87794);
    new com.tencent.mm.plugin.priority.model.b.c().run();
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().dbd();
    AppMethodBeat.o(87794);
    return localList;
  }
  
  public final void cE(String paramString, int paramInt)
  {
    AppMethodBeat.i(174312);
    if ((com.tencent.mm.kernel.g.afw()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new g(paramString, paramInt));
    }
    AppMethodBeat.o(174312);
  }
  
  public final void d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(87786);
    if ((com.tencent.mm.kernel.g.afw()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new d(paramLong, paramBoolean1, paramBoolean2));
    }
    AppMethodBeat.o(87786);
  }
  
  public final List<Pair<String, String>> ob(long paramLong)
  {
    AppMethodBeat.i(87795);
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().rH(paramLong);
    AppMethodBeat.o(87795);
    return localList;
  }
  
  public final List<Pair<String, String>> oc(long paramLong)
  {
    AppMethodBeat.i(87796);
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().rH(paramLong);
    AppMethodBeat.o(87796);
    return localList;
  }
  
  final class a
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private boolean dhg;
    private long drA;
    private boolean gqP;
    private String id;
    private boolean ofM;
    
    public a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
    {
      this.ofM = paramBoolean1;
      this.id = paramString;
      this.drA = paramLong;
      this.dhg = paramBoolean2;
      this.gqP = false;
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
      hd localhd;
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        boolean bool1 = this.ofM;
        localObject = this.id;
        l1 = this.drA;
        boolean bool2 = this.dhg;
        bool3 = this.gqP;
        if (bool2)
        {
          localhd = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().aY((String)localObject, l1);
          if (localhd == null)
          {
            ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "sender file %s %s", new Object[] { localObject, Long.valueOf(l1) });
            AppMethodBeat.o(87779);
            return;
          }
          if ((localhd.mBi == 1) || (localhd.mBi == 2) || (localhd.mBi == 4)) {
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
        com.tencent.mm.plugin.priority.model.c.a(1, l1, i, localhd);
        localObject = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
        String str = localhd.Id;
        long l2 = localhd.CCg;
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).uvv.bindLong(1, l1);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).uvv.bindLong(2, i);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).uvv.bindString(3, str);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).uvv.bindLong(4, l2);
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatusAndDownloadTime %s res %s %s %s %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.b.c)localObject).uvv.executeUpdateDelete()), str, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
        AppMethodBeat.o(87779);
        return;
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "already auto download msgid %s %s", new Object[] { localObject, Long.valueOf(l1) });
        AppMethodBeat.o(87779);
        return;
        if (bool3)
        {
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download cancel %s %s", new Object[] { localObject, Long.valueOf(l1) });
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().j((String)localObject, l1, 1);
          AppMethodBeat.o(87779);
          return;
        }
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download fail %s %s", new Object[] { localObject, Long.valueOf(l1) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().j((String)localObject, l1, 4);
        AppMethodBeat.o(87779);
        return;
      }
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private long drA;
    private String id;
    
    public b(String paramString, long paramLong)
    {
      this.id = paramString;
      this.drA = paramLong;
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
        long l1 = this.drA;
        hd localhd = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().aY(str, l1);
        if (localhd == null)
        {
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "This File Sender is Me");
          AppMethodBeat.o(87780);
          return;
        }
        if (localhd.CCj > 0L)
        {
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "onFileOpen file already use %s %s", new Object[] { str, Long.valueOf(l1) });
          AppMethodBeat.o(87780);
          return;
        }
        if (w.pF(localhd.uKU)) {
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().hR(localhd.uKU, "@all");
        }
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().hR(localhd.uKU, localhd.CCb);
        localhd.CCj = System.currentTimeMillis();
        com.tencent.mm.plugin.priority.model.a.b.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
        long l2 = localhd.CCj;
        localc.uvw.bindLong(1, l2);
        localc.uvw.bindString(2, str);
        localc.uvw.bindLong(3, l1);
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateOpenTime %s res %s %s %s", new Object[] { Integer.valueOf(localc.uvw.executeUpdateDelete()), str, Long.valueOf(l1), Long.valueOf(l2) });
        com.tencent.mm.plugin.priority.model.c.a(2, System.currentTimeMillis(), localhd.mBi, localhd);
      }
      AppMethodBeat.o(87780);
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bl drF;
    
    public c(bl parambl)
    {
      this.drF = parambl;
    }
    
    public final String getName()
    {
      return "C2CFileReceiveTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87781);
      if (this.drF.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ad.i("MicroMsg.Priority.PriorityService", "onC2CFileReceive time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", this.drF.field_createTime / 1000L) });
        AppMethodBeat.o(87781);
        return;
      }
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        Object localObject3 = this.drF;
        Object localObject1 = ((du)localObject3).field_talker;
        if ((w.pF(((du)localObject3).field_talker)) && (((du)localObject3).field_isSend == 0))
        {
          localObject2 = bi.ug(((du)localObject3).field_content);
          localObject1 = bt.by(bi.uf(((du)localObject3).field_content), "");
        }
        Object localObject4;
        for (;;)
        {
          localObject4 = k.b.rx((String)localObject2);
          if (localObject4 != null) {
            break;
          }
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "appMsgContent is null");
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((du)localObject3).field_content;
        }
        if ((w.pF(((du)localObject3).field_talker)) && (((du)localObject3).field_isSend == 0)) {
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().hS(((du)localObject3).field_talker, "@all");
        }
        double d;
        String str;
        for (int i = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().hU(((du)localObject3).field_talker, "@all");; i = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().hU(((du)localObject3).field_talker, ((du)localObject3).field_talker))
        {
          d = Math.max(Math.max(localObject2[0], localObject2[1]), localObject2[2]);
          if (((k.b)localObject4).type != 6) {
            break label755;
          }
          str = String.valueOf(((du)localObject3).field_msgId);
          if (!((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().aX(str, ((du)localObject3).field_msgSvrId)) {
            break;
          }
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { Long.valueOf(((du)localObject3).field_msgId), Long.valueOf(((du)localObject3).field_msgSvrId) });
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().hS(((du)localObject3).field_talker, ((du)localObject3).field_talker);
        }
        Object localObject2 = new hd();
        ((hd)localObject2).Id = str;
        ((hd)localObject2).uKU = ((du)localObject3).field_talker;
        ((hd)localObject2).CCb = ((String)localObject1);
        ((hd)localObject2).CCc = 2;
        ((hd)localObject2).CCd = ((du)localObject3).field_createTime;
        if (i < 2) {}
        for (i = 1;; i = 0)
        {
          ((hd)localObject2).CCe = i;
          ((hd)localObject2).mBi = 1;
          ((hd)localObject2).CCf = 0L;
          ((hd)localObject2).CCg = ((du)localObject3).field_msgSvrId;
          ((hd)localObject2).CCh = ((k.b)localObject4).gHe;
          ((hd)localObject2).CCi = ((k.b)localObject4).gHf;
          ((hd)localObject2).CCk = d;
          ((hd)localObject2).CCl = 1;
          ((hd)localObject2).CCm = ((k.b)localObject4).dbA;
          localObject1 = com.tencent.mm.plugin.s.a.bxS().aAL(((k.b)localObject4).dbA);
          if (localObject1 != null)
          {
            localObject3 = new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((((com.tencent.mm.vfs.e)localObject3).exists()) && (((com.tencent.mm.vfs.e)localObject3).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen))
            {
              ((hd)localObject2).CCf = System.currentTimeMillis();
              ((hd)localObject2).mBi = 6;
            }
          }
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { ((hd)localObject2).uKU, bt.vK(((hd)localObject2).CCh), ((hd)localObject2).CCi, Integer.valueOf(((hd)localObject2).CCe), Double.valueOf(((hd)localObject2).CCk) });
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a((hd)localObject2);
          if (w.pF(((hd)localObject2).uKU)) {
            ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().hQ(((hd)localObject2).uKU, "@all");
          }
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().hQ(((hd)localObject2).uKU, ((hd)localObject2).CCb);
          com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), ((hd)localObject2).mBi, (hd)localObject2);
          AppMethodBeat.o(87781);
          return;
        }
        label755:
        if (((k.b)localObject4).type == 19)
        {
          localObject2 = n.alt(((k.b)localObject4).gHI).gKs.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (afy)((Iterator)localObject2).next();
            if (((afy)localObject4).dataType == 8)
            {
              str = ((afy)localObject4).dkb;
              if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().aX(str, ((du)localObject3).field_msgSvrId))
              {
                ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { str, Long.valueOf(((du)localObject3).field_msgSvrId) });
              }
              else
              {
                hd localhd = new hd();
                localhd.Id = str;
                localhd.uKU = ((du)localObject3).field_talker;
                localhd.CCb = ((String)localObject1);
                localhd.CCc = 3;
                localhd.CCd = ((du)localObject3).field_createTime;
                if (i < 2) {}
                for (int j = 1;; j = 0)
                {
                  localhd.CCe = j;
                  localhd.mBi = 1;
                  localhd.CCf = 0L;
                  localhd.CCg = ((du)localObject3).field_msgSvrId;
                  localhd.CCh = ((afy)localObject4).Dgu;
                  localhd.CCi = ((afy)localObject4).Dgo;
                  localhd.CCk = d;
                  localhd.CCl = 1;
                  localhd.CCm = ((afy)localObject4).DfZ;
                  ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { localhd.uKU, bt.vK(localhd.CCh), localhd.CCi, Integer.valueOf(localhd.CCe), Double.valueOf(localhd.CCk) });
                  ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a(localhd);
                  if (w.pF(localhd.uKU)) {
                    ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().hQ(localhd.uKU, "@all");
                  }
                  ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().hQ(localhd.uKU, localhd.CCb);
                  com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), localhd.mBi, localhd);
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
    private boolean dhg;
    private boolean gqP;
    private long msgId;
    
    public d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.msgId = paramLong;
      this.dhg = paramBoolean1;
      this.gqP = paramBoolean2;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgDownloadedTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87782);
      Object localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(this.msgId);
      if (((du)localObject).field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ad.i("MicroMsg.Priority.PriorityService", "onC2CImgDownloaded time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((du)localObject).field_createTime / 1000L) });
        AppMethodBeat.o(87782);
        return;
      }
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        boolean bool1 = this.dhg;
        boolean bool2 = this.gqP;
        if (bool1)
        {
          he localhe = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().rJ(((du)localObject).field_msgId);
          if (localhe == null)
          {
            ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "sender img %d", new Object[] { Long.valueOf(((du)localObject).field_msgId) });
            AppMethodBeat.o(87782);
            return;
          }
          if (localhe.mBi == 3)
          {
            ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "already auto download msgid %d", new Object[] { Long.valueOf(((du)localObject).field_msgId) });
            AppMethodBeat.o(87782);
            return;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 20L, 1L, false);
          if (localhe != null)
          {
            long l1 = System.currentTimeMillis();
            localObject = o.ayF().mr(localhe.CCg);
            localhe.CCo = ((com.tencent.mm.aw.e)localObject).gTY;
            com.tencent.mm.plugin.priority.model.c.a(1, l1, 0, localhe);
            com.tencent.mm.plugin.priority.model.a.c.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
            long l2 = localhe.CCn;
            int i = ((com.tencent.mm.aw.e)localObject).gTY;
            localc.uvv.bindLong(1, l1);
            localc.uvv.bindLong(2, 3L);
            localc.uvv.bindLong(3, i);
            localc.uvv.bindLong(4, l2);
            ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndDownloadTime %d res %d %d %d", new Object[] { Integer.valueOf(localc.uvv.executeUpdateDelete()), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(3) });
            if (com.tencent.mm.plugin.priority.a.a.a.gA(localhe.CCe, 1))
            {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 21L, 1L, false);
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 22L, ((com.tencent.mm.aw.e)localObject).gTY, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gA(localhe.CCe, 8))
            {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 23L, 1L, false);
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 24L, ((com.tencent.mm.aw.e)localObject).gTY, false);
            }
            if ((com.tencent.mm.plugin.priority.a.a.a.gA(localhe.CCe, 2)) || (com.tencent.mm.plugin.priority.a.a.a.gA(localhe.CCe, 4)))
            {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 25L, 1L, false);
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 26L, ((com.tencent.mm.aw.e)localObject).gTY, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gA(localhe.CCe, 16))
            {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 27L, 1L, false);
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 28L, ((com.tencent.mm.aw.e)localObject).gTY, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gA(localhe.CCe, 32))
            {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 29L, 1L, false);
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 30L, ((com.tencent.mm.aw.e)localObject).gTY, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gA(localhe.CCe, 64))
            {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 33L, 1L, false);
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 34L, ((com.tencent.mm.aw.e)localObject).gTY, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gA(localhe.CCe, 128))
            {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 35L, 1L, false);
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 36L, ((com.tencent.mm.aw.e)localObject).gTY, false);
            }
            AppMethodBeat.o(87782);
            return;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 31L, 1L, false);
          AppMethodBeat.o(87782);
          return;
        }
        if (!bool2) {
          break label814;
        }
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download cancel %d", new Object[] { Long.valueOf(((du)localObject).field_msgId) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().L(((du)localObject).field_msgId, 1);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 32L, 1L, false);
        AppMethodBeat.o(87782);
        return;
        label814:
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download fail %d", new Object[] { Long.valueOf(((du)localObject).field_msgId) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().L(((du)localObject).field_msgId, 4);
      }
    }
  }
  
  final class e
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bl drF;
    
    public e(bl parambl)
    {
      this.drF = parambl;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgOpenTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87783);
      if (this.drF.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ad.i("MicroMsg.Priority.PriorityService", "onC2CImgOpen time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", this.drF.field_createTime / 1000L) });
        AppMethodBeat.o(87783);
        return;
      }
      he localhe;
      int i;
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        bl localbl = this.drF;
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 10L, 1L, false);
        localhe = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().rJ(localbl.field_msgId);
        if (localhe == null)
        {
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 13L, 1L, false);
          AppMethodBeat.o(87783);
          return;
        }
        if (localhe.CCj > 0L)
        {
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgOpen img already use %d", new Object[] { Long.valueOf(localbl.field_msgId) });
          AppMethodBeat.o(87783);
          return;
        }
        if (w.pF(localbl.field_talker)) {
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().hR(localhe.uKU, "@all");
        }
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().hR(localhe.uKU, localhe.CCb);
        localhe.CCj = System.currentTimeMillis();
        com.tencent.mm.plugin.priority.model.a.c.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        long l1 = localbl.field_msgId;
        long l2 = localhe.CCj;
        localc.uvw.bindLong(1, l2);
        localc.uvw.bindLong(2, l1);
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateOpenTime %d res %d %d", new Object[] { Integer.valueOf(localc.uvw.executeUpdateDelete()), Long.valueOf(l1), Long.valueOf(l2) });
        if (localhe.mBi != 3) {
          break label394;
        }
        i = 1;
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 14L, 1L, false);
      }
      for (;;)
      {
        com.tencent.mm.plugin.priority.model.c.a(2, localhe.CCj, i, localhe);
        AppMethodBeat.o(87783);
        return;
        label394:
        if (localhe.mBi == 2)
        {
          i = 3;
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 16L, 1L, false);
        }
        else if (localhe.mBi == 4)
        {
          i = 4;
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 17L, 1L, false);
        }
        else if (localhe.mBi == 5)
        {
          i = 5;
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 18L, 1L, false);
        }
        else
        {
          i = 2;
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(957L, 15L, 1L, false);
        }
      }
    }
  }
  
  final class f
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bl drF;
    private WeakReference<Runnable> uuS;
    
    f(WeakReference<Runnable> paramWeakReference)
    {
      this.drF = paramWeakReference;
      Object localObject;
      this.uuS = localObject;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgScrollTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87784);
      if (this.drF.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ad.i("MicroMsg.Priority.PriorityService", "onC2CImgScroll time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", this.drF.field_createTime / 1000L) });
        AppMethodBeat.o(87784);
        return;
      }
      ad.i("MicroMsg.Priority.PriorityService", "C2CImgScrollTask Start To Auto Download %d MsgId %d", new Object[] { Integer.valueOf(32), Long.valueOf(this.drF.field_msgId) });
      if (this.uuS.get() != null) {
        ((Runnable)this.uuS.get()).run();
      }
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      bl localbl = this.drF;
      he localhe = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().rJ(localbl.field_msgId);
      if (localhe == null)
      {
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
        AppMethodBeat.o(87784);
        return;
      }
      if (localhe.mBi == 1) {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().l(localbl.field_msgId, 32, 2);
      }
      AppMethodBeat.o(87784);
    }
  }
  
  final class g
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private int score;
    private String uuT;
    
    public g(String paramString, int paramInt)
    {
      this.uuT = paramString;
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
        String str = this.uuT;
        int i = this.score;
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.a.a.a.a(locala, str, i, (byte)0));
      }
      AppMethodBeat.o(87785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a
 * JD-Core Version:    0.7.0.1
 */