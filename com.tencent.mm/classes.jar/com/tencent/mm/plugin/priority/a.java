package com.tencent.mm.plugin.priority;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.k;
import com.tencent.wcdb.database.SQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.comm.a.b
{
  public final void a(bv parambv, Runnable paramRunnable)
  {
    AppMethodBeat.i(87789);
    if ((com.tencent.mm.kernel.g.ajM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new f(parambv, new WeakReference(paramRunnable)));
    }
    AppMethodBeat.o(87789);
  }
  
  public final void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(87790);
    if ((com.tencent.mm.kernel.g.ajM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a(paramBoolean1, paramString, paramLong, paramBoolean2));
    }
    AppMethodBeat.o(87790);
  }
  
  public final void aa(String paramString, long paramLong)
  {
    AppMethodBeat.i(87791);
    if ((com.tencent.mm.kernel.g.ajM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new b(paramString, paramLong));
    }
    AppMethodBeat.o(87791);
  }
  
  public final void aaK(String paramString)
  {
    AppMethodBeat.i(87793);
    cQ(paramString, 1);
    AppMethodBeat.o(87793);
  }
  
  public final void ah(bv parambv)
  {
    AppMethodBeat.i(87787);
    if ((com.tencent.mm.kernel.g.ajM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new e(parambv));
    }
    AppMethodBeat.o(87787);
  }
  
  public final void ai(bv parambv)
  {
    AppMethodBeat.i(87788);
    if ((com.tencent.mm.kernel.g.ajM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.b(parambv));
    }
    AppMethodBeat.o(87788);
  }
  
  public final void aj(bv parambv)
  {
    AppMethodBeat.i(87792);
    if ((com.tencent.mm.kernel.g.ajM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new c(parambv));
    }
    AppMethodBeat.o(87792);
  }
  
  public final void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(87786);
    if ((com.tencent.mm.kernel.g.ajM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new d(paramLong, paramBoolean1, paramBoolean2));
    }
    AppMethodBeat.o(87786);
  }
  
  public final void cQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(174312);
    if ((com.tencent.mm.kernel.g.ajM()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new g(paramString, paramInt));
    }
    AppMethodBeat.o(174312);
  }
  
  public final List<Pair<String, String>> ccQ()
  {
    AppMethodBeat.i(87794);
    new com.tencent.mm.plugin.priority.model.b.c().run();
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().dCE();
    AppMethodBeat.o(87794);
    return localList;
  }
  
  public final List<Pair<String, String>> ud(long paramLong)
  {
    AppMethodBeat.i(87795);
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().yU(paramLong);
    AppMethodBeat.o(87795);
    return localList;
  }
  
  public final List<Pair<String, String>> ue(long paramLong)
  {
    AppMethodBeat.i(87796);
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().yU(paramLong);
    AppMethodBeat.o(87796);
    return localList;
  }
  
  final class a
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private long dCd;
    private boolean drc;
    private boolean hmD;
    private String id;
    private boolean ptB;
    
    public a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
    {
      this.ptB = paramBoolean1;
      this.id = paramString;
      this.dCd = paramLong;
      this.drc = paramBoolean2;
      this.hmD = false;
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
      ho localho;
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        boolean bool1 = this.ptB;
        localObject = this.id;
        l1 = this.dCd;
        boolean bool2 = this.drc;
        bool3 = this.hmD;
        if (bool2)
        {
          localho = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bd((String)localObject, l1);
          if (localho == null)
          {
            ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "sender file %s %s", new Object[] { localObject, Long.valueOf(l1) });
            AppMethodBeat.o(87779);
            return;
          }
          if ((localho.nJb == 1) || (localho.nJb == 2) || (localho.nJb == 4)) {
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
        com.tencent.mm.plugin.priority.model.c.a(1, l1, i, localho);
        localObject = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
        String str = localho.Id;
        long l2 = localho.FSw;
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).xbi.bindLong(1, l1);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).xbi.bindLong(2, i);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).xbi.bindString(3, str);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).xbi.bindLong(4, l2);
        ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatusAndDownloadTime %s res %s %s %s %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.b.c)localObject).xbi.executeUpdateDelete()), str, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
        AppMethodBeat.o(87779);
        return;
        ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "already auto download msgid %s %s", new Object[] { localObject, Long.valueOf(l1) });
        AppMethodBeat.o(87779);
        return;
        if (bool3)
        {
          ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download cancel %s %s", new Object[] { localObject, Long.valueOf(l1) });
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l((String)localObject, l1, 1);
          AppMethodBeat.o(87779);
          return;
        }
        ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download fail %s %s", new Object[] { localObject, Long.valueOf(l1) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l((String)localObject, l1, 4);
        AppMethodBeat.o(87779);
        return;
      }
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private long dCd;
    private String id;
    
    public b(String paramString, long paramLong)
    {
      this.id = paramString;
      this.dCd = paramLong;
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
        long l1 = this.dCd;
        ho localho = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bd(str, l1);
        if (localho == null)
        {
          ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "This File Sender is Me");
          AppMethodBeat.o(87780);
          return;
        }
        if (localho.FSz > 0L)
        {
          ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "onFileOpen file already use %s %s", new Object[] { str, Long.valueOf(l1) });
          AppMethodBeat.o(87780);
          return;
        }
        if (x.wb(localho.FSq)) {
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iE(localho.FSq, "@all");
        }
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iE(localho.FSq, localho.FSr);
        localho.FSz = System.currentTimeMillis();
        com.tencent.mm.plugin.priority.model.a.b.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
        long l2 = localho.FSz;
        localc.xbj.bindLong(1, l2);
        localc.xbj.bindString(2, str);
        localc.xbj.bindLong(3, l1);
        ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateOpenTime %s res %s %s %s", new Object[] { Integer.valueOf(localc.xbj.executeUpdateDelete()), str, Long.valueOf(l1), Long.valueOf(l2) });
        com.tencent.mm.plugin.priority.model.c.a(2, System.currentTimeMillis(), localho.nJb, localho);
      }
      AppMethodBeat.o(87780);
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bv dCi;
    
    public c(bv parambv)
    {
      this.dCi = parambv;
    }
    
    public final String getName()
    {
      return "C2CFileReceiveTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87781);
      if (this.dCi.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ae.i("MicroMsg.Priority.PriorityService", "onC2CFileReceive time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", this.dCi.field_createTime / 1000L) });
        AppMethodBeat.o(87781);
        return;
      }
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        Object localObject3 = this.dCi;
        Object localObject1 = ((ei)localObject3).field_talker;
        if ((x.wb(((ei)localObject3).field_talker)) && (((ei)localObject3).field_isSend == 0))
        {
          localObject2 = bl.BN(((ei)localObject3).field_content);
          localObject1 = bu.bI(bl.BM(((ei)localObject3).field_content), "");
        }
        Object localObject4;
        for (;;)
        {
          localObject4 = k.b.zb((String)localObject2);
          if (localObject4 != null) {
            break;
          }
          ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "appMsgContent is null");
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((ei)localObject3).field_content;
        }
        if ((x.wb(((ei)localObject3).field_talker)) && (((ei)localObject3).field_isSend == 0)) {
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iF(((ei)localObject3).field_talker, "@all");
        }
        double d;
        String str;
        for (int i = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iH(((ei)localObject3).field_talker, "@all");; i = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iH(((ei)localObject3).field_talker, ((ei)localObject3).field_talker))
        {
          d = Math.max(Math.max(localObject2[0], localObject2[1]), localObject2[2]);
          if (((k.b)localObject4).type != 6) {
            break label755;
          }
          str = String.valueOf(((ei)localObject3).field_msgId);
          if (!((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bc(str, ((ei)localObject3).field_msgSvrId)) {
            break;
          }
          ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId) });
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iF(((ei)localObject3).field_talker, ((ei)localObject3).field_talker);
        }
        Object localObject2 = new ho();
        ((ho)localObject2).Id = str;
        ((ho)localObject2).FSq = ((ei)localObject3).field_talker;
        ((ho)localObject2).FSr = ((String)localObject1);
        ((ho)localObject2).FSs = 2;
        ((ho)localObject2).FSt = ((ei)localObject3).field_createTime;
        if (i < 2) {}
        for (i = 1;; i = 0)
        {
          ((ho)localObject2).FSu = i;
          ((ho)localObject2).nJb = 1;
          ((ho)localObject2).FSv = 0L;
          ((ho)localObject2).FSw = ((ei)localObject3).field_msgSvrId;
          ((ho)localObject2).FSx = ((k.b)localObject4).hCC;
          ((ho)localObject2).FSy = ((k.b)localObject4).hCD;
          ((ho)localObject2).FSA = d;
          ((ho)localObject2).FSB = 1;
          ((ho)localObject2).FSC = ((k.b)localObject4).dlu;
          localObject1 = com.tencent.mm.plugin.s.a.bJV().aMZ(((k.b)localObject4).dlu);
          if (localObject1 != null)
          {
            localObject3 = new k(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((((k)localObject3).exists()) && (((k)localObject3).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen))
            {
              ((ho)localObject2).FSv = System.currentTimeMillis();
              ((ho)localObject2).nJb = 6;
            }
          }
          ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { ((ho)localObject2).FSq, bu.DB(((ho)localObject2).FSx), ((ho)localObject2).FSy, Integer.valueOf(((ho)localObject2).FSu), Double.valueOf(((ho)localObject2).FSA) });
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a((ho)localObject2);
          if (x.wb(((ho)localObject2).FSq)) {
            ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iD(((ho)localObject2).FSq, "@all");
          }
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iD(((ho)localObject2).FSq, ((ho)localObject2).FSr);
          com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), ((ho)localObject2).nJb, (ho)localObject2);
          AppMethodBeat.o(87781);
          return;
        }
        label755:
        if (((k.b)localObject4).type == 19)
        {
          localObject2 = p.awG(((k.b)localObject4).hDg).hFT.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (ajx)((Iterator)localObject2).next();
            if (((ajx)localObject4).dataType == 8)
            {
              str = ((ajx)localObject4).dua;
              if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bc(str, ((ei)localObject3).field_msgSvrId))
              {
                ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { str, Long.valueOf(((ei)localObject3).field_msgSvrId) });
              }
              else
              {
                ho localho = new ho();
                localho.Id = str;
                localho.FSq = ((ei)localObject3).field_talker;
                localho.FSr = ((String)localObject1);
                localho.FSs = 3;
                localho.FSt = ((ei)localObject3).field_createTime;
                if (i < 2) {}
                for (int j = 1;; j = 0)
                {
                  localho.FSu = j;
                  localho.nJb = 1;
                  localho.FSv = 0L;
                  localho.FSw = ((ei)localObject3).field_msgSvrId;
                  localho.FSx = ((ajx)localObject4).GzV;
                  localho.FSy = ((ajx)localObject4).GzP;
                  localho.FSA = d;
                  localho.FSB = 1;
                  localho.FSC = ((ajx)localObject4).GzA;
                  ae.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { localho.FSq, bu.DB(localho.FSx), localho.FSy, Integer.valueOf(localho.FSu), Double.valueOf(localho.FSA) });
                  ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a(localho);
                  if (x.wb(localho.FSq)) {
                    ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iD(localho.FSq, "@all");
                  }
                  ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iD(localho.FSq, localho.FSr);
                  com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), localho.nJb, localho);
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
    private boolean drc;
    private boolean hmD;
    private long msgId;
    
    public d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.msgId = paramLong;
      this.drc = paramBoolean1;
      this.hmD = paramBoolean2;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgDownloadedTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87782);
      Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.msgId);
      if (((ei)localObject).field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ae.i("MicroMsg.Priority.PriorityService", "onC2CImgDownloaded time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((ei)localObject).field_createTime / 1000L) });
        AppMethodBeat.o(87782);
        return;
      }
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        boolean bool1 = this.drc;
        boolean bool2 = this.hmD;
        if (bool1)
        {
          hp localhp = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().yW(((ei)localObject).field_msgId);
          if (localhp == null)
          {
            ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "sender img %d", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
            AppMethodBeat.o(87782);
            return;
          }
          if (localhp.nJb == 3)
          {
            ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "already auto download msgid %d", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
            AppMethodBeat.o(87782);
            return;
          }
          e.ywz.idkeyStat(957L, 20L, 1L, false);
          if (localhp != null)
          {
            long l1 = System.currentTimeMillis();
            localObject = q.aIX().F(((ei)localObject).field_talker, localhp.FSw);
            localhp.FSE = ((com.tencent.mm.av.g)localObject).hPI;
            com.tencent.mm.plugin.priority.model.c.a(1, l1, 0, localhp);
            com.tencent.mm.plugin.priority.model.a.c.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
            long l2 = localhp.FSD;
            int i = ((com.tencent.mm.av.g)localObject).hPI;
            localc.xbi.bindLong(1, l1);
            localc.xbi.bindLong(2, 3L);
            localc.xbi.bindLong(3, i);
            localc.xbi.bindLong(4, l2);
            ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndDownloadTime %d res %d %d %d", new Object[] { Integer.valueOf(localc.xbi.executeUpdateDelete()), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(3) });
            if (com.tencent.mm.plugin.priority.a.a.a.hb(localhp.FSu, 1))
            {
              e.ywz.idkeyStat(957L, 21L, 1L, false);
              e.ywz.idkeyStat(957L, 22L, ((com.tencent.mm.av.g)localObject).hPI, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.hb(localhp.FSu, 8))
            {
              e.ywz.idkeyStat(957L, 23L, 1L, false);
              e.ywz.idkeyStat(957L, 24L, ((com.tencent.mm.av.g)localObject).hPI, false);
            }
            if ((com.tencent.mm.plugin.priority.a.a.a.hb(localhp.FSu, 2)) || (com.tencent.mm.plugin.priority.a.a.a.hb(localhp.FSu, 4)))
            {
              e.ywz.idkeyStat(957L, 25L, 1L, false);
              e.ywz.idkeyStat(957L, 26L, ((com.tencent.mm.av.g)localObject).hPI, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.hb(localhp.FSu, 16))
            {
              e.ywz.idkeyStat(957L, 27L, 1L, false);
              e.ywz.idkeyStat(957L, 28L, ((com.tencent.mm.av.g)localObject).hPI, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.hb(localhp.FSu, 32))
            {
              e.ywz.idkeyStat(957L, 29L, 1L, false);
              e.ywz.idkeyStat(957L, 30L, ((com.tencent.mm.av.g)localObject).hPI, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.hb(localhp.FSu, 64))
            {
              e.ywz.idkeyStat(957L, 33L, 1L, false);
              e.ywz.idkeyStat(957L, 34L, ((com.tencent.mm.av.g)localObject).hPI, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.hb(localhp.FSu, 128))
            {
              e.ywz.idkeyStat(957L, 35L, 1L, false);
              e.ywz.idkeyStat(957L, 36L, ((com.tencent.mm.av.g)localObject).hPI, false);
            }
            AppMethodBeat.o(87782);
            return;
          }
          e.ywz.idkeyStat(957L, 31L, 1L, false);
          AppMethodBeat.o(87782);
          return;
        }
        if (!bool2) {
          break label819;
        }
        ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download cancel %d", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(((ei)localObject).field_msgId, 1);
      }
      for (;;)
      {
        e.ywz.idkeyStat(957L, 32L, 1L, false);
        AppMethodBeat.o(87782);
        return;
        label819:
        ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download fail %d", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(((ei)localObject).field_msgId, 4);
      }
    }
  }
  
  final class e
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bv dCi;
    
    public e(bv parambv)
    {
      this.dCi = parambv;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgOpenTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87783);
      if (this.dCi.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ae.i("MicroMsg.Priority.PriorityService", "onC2CImgOpen time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", this.dCi.field_createTime / 1000L) });
        AppMethodBeat.o(87783);
        return;
      }
      hp localhp;
      int i;
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        bv localbv = this.dCi;
        e.ywz.idkeyStat(957L, 10L, 1L, false);
        localhp = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().yW(localbv.field_msgId);
        if (localhp == null)
        {
          ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
          e.ywz.idkeyStat(957L, 13L, 1L, false);
          AppMethodBeat.o(87783);
          return;
        }
        if (localhp.FSz > 0L)
        {
          ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgOpen img already use %d", new Object[] { Long.valueOf(localbv.field_msgId) });
          AppMethodBeat.o(87783);
          return;
        }
        if (x.wb(localbv.field_talker)) {
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iE(localhp.FSq, "@all");
        }
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iE(localhp.FSq, localhp.FSr);
        localhp.FSz = System.currentTimeMillis();
        com.tencent.mm.plugin.priority.model.a.c.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        long l1 = localbv.field_msgId;
        long l2 = localhp.FSz;
        localc.xbj.bindLong(1, l2);
        localc.xbj.bindLong(2, l1);
        ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateOpenTime %d res %d %d", new Object[] { Integer.valueOf(localc.xbj.executeUpdateDelete()), Long.valueOf(l1), Long.valueOf(l2) });
        if (localhp.nJb != 3) {
          break label394;
        }
        i = 1;
        e.ywz.idkeyStat(957L, 14L, 1L, false);
      }
      for (;;)
      {
        com.tencent.mm.plugin.priority.model.c.a(2, localhp.FSz, i, localhp);
        AppMethodBeat.o(87783);
        return;
        label394:
        if (localhp.nJb == 2)
        {
          i = 3;
          e.ywz.idkeyStat(957L, 16L, 1L, false);
        }
        else if (localhp.nJb == 4)
        {
          i = 4;
          e.ywz.idkeyStat(957L, 17L, 1L, false);
        }
        else if (localhp.nJb == 5)
        {
          i = 5;
          e.ywz.idkeyStat(957L, 18L, 1L, false);
        }
        else
        {
          i = 2;
          e.ywz.idkeyStat(957L, 15L, 1L, false);
        }
      }
    }
  }
  
  final class f
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bv dCi;
    private WeakReference<Runnable> xaF;
    
    f(WeakReference<Runnable> paramWeakReference)
    {
      this.dCi = paramWeakReference;
      Object localObject;
      this.xaF = localObject;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgScrollTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87784);
      if (this.dCi.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ae.i("MicroMsg.Priority.PriorityService", "onC2CImgScroll time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", this.dCi.field_createTime / 1000L) });
        AppMethodBeat.o(87784);
        return;
      }
      ae.i("MicroMsg.Priority.PriorityService", "C2CImgScrollTask Start To Auto Download %d MsgId %d", new Object[] { Integer.valueOf(32), Long.valueOf(this.dCi.field_msgId) });
      if (this.xaF.get() != null) {
        ((Runnable)this.xaF.get()).run();
      }
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      bv localbv = this.dCi;
      hp localhp = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().yW(localbv.field_msgId);
      if (localhp == null)
      {
        ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
        AppMethodBeat.o(87784);
        return;
      }
      if (localhp.nJb == 1) {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().n(localbv.field_msgId, 32, 2);
      }
      AppMethodBeat.o(87784);
    }
  }
  
  final class g
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private int score;
    private String xaG;
    
    public g(String paramString, int paramInt)
    {
      this.xaG = paramString;
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
        String str = this.xaG;
        int i = this.score;
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.a.a.a.a(locala, str, i, (byte)0));
      }
      AppMethodBeat.o(87785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a
 * JD-Core Version:    0.7.0.1
 */