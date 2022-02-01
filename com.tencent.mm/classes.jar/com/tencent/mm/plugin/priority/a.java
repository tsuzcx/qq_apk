package com.tencent.mm.plugin.priority;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.wcdb.database.SQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.comm.a.b
{
  public final void ZT(String paramString)
  {
    AppMethodBeat.i(87793);
    cM(paramString, 1);
    AppMethodBeat.o(87793);
  }
  
  public final void a(bu parambu, Runnable paramRunnable)
  {
    AppMethodBeat.i(87789);
    if ((com.tencent.mm.kernel.g.ajx()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new f(parambu, new WeakReference(paramRunnable)));
    }
    AppMethodBeat.o(87789);
  }
  
  public final void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(87790);
    if ((com.tencent.mm.kernel.g.ajx()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a(paramBoolean1, paramString, paramLong, paramBoolean2));
    }
    AppMethodBeat.o(87790);
  }
  
  public final void aa(String paramString, long paramLong)
  {
    AppMethodBeat.i(87791);
    if ((com.tencent.mm.kernel.g.ajx()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new b(paramString, paramLong));
    }
    AppMethodBeat.o(87791);
  }
  
  public final void ai(bu parambu)
  {
    AppMethodBeat.i(87787);
    if ((com.tencent.mm.kernel.g.ajx()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new e(parambu));
    }
    AppMethodBeat.o(87787);
  }
  
  public final void aj(bu parambu)
  {
    AppMethodBeat.i(87788);
    if ((com.tencent.mm.kernel.g.ajx()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.b(parambu));
    }
    AppMethodBeat.o(87788);
  }
  
  public final void ak(bu parambu)
  {
    AppMethodBeat.i(87792);
    if ((com.tencent.mm.kernel.g.ajx()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new c(parambu));
    }
    AppMethodBeat.o(87792);
  }
  
  public final void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(87786);
    if ((com.tencent.mm.kernel.g.ajx()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new d(paramLong, paramBoolean1, paramBoolean2));
    }
    AppMethodBeat.o(87786);
  }
  
  public final void cM(String paramString, int paramInt)
  {
    AppMethodBeat.i(174312);
    if ((com.tencent.mm.kernel.g.ajx()) && (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new g(paramString, paramInt));
    }
    AppMethodBeat.o(174312);
  }
  
  public final List<Pair<String, String>> cbB()
  {
    AppMethodBeat.i(87794);
    new com.tencent.mm.plugin.priority.model.b.c().run();
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().dzn();
    AppMethodBeat.o(87794);
    return localList;
  }
  
  public final List<Pair<String, String>> tM(long paramLong)
  {
    AppMethodBeat.i(87795);
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().yv(paramLong);
    AppMethodBeat.o(87795);
    return localList;
  }
  
  public final List<Pair<String, String>> tN(long paramLong)
  {
    AppMethodBeat.i(87796);
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().yv(paramLong);
    AppMethodBeat.o(87796);
    return localList;
  }
  
  final class a
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private long dAY;
    private boolean dpX;
    private boolean hjP;
    private String id;
    private boolean pmU;
    
    public a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
    {
      this.pmU = paramBoolean1;
      this.id = paramString;
      this.dAY = paramLong;
      this.dpX = paramBoolean2;
      this.hjP = false;
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
        boolean bool1 = this.pmU;
        localObject = this.id;
        l1 = this.dAY;
        boolean bool2 = this.dpX;
        bool3 = this.hjP;
        if (bool2)
        {
          localho = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bc((String)localObject, l1);
          if (localho == null)
          {
            ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "sender file %s %s", new Object[] { localObject, Long.valueOf(l1) });
            AppMethodBeat.o(87779);
            return;
          }
          if ((localho.nDG == 1) || (localho.nDG == 2) || (localho.nDG == 4)) {
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
        long l2 = localho.FzY;
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).wLu.bindLong(1, l1);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).wLu.bindLong(2, i);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).wLu.bindString(3, str);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).wLu.bindLong(4, l2);
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatusAndDownloadTime %s res %s %s %s %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.b.c)localObject).wLu.executeUpdateDelete()), str, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
        AppMethodBeat.o(87779);
        return;
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "already auto download msgid %s %s", new Object[] { localObject, Long.valueOf(l1) });
        AppMethodBeat.o(87779);
        return;
        if (bool3)
        {
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download cancel %s %s", new Object[] { localObject, Long.valueOf(l1) });
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l((String)localObject, l1, 1);
          AppMethodBeat.o(87779);
          return;
        }
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download fail %s %s", new Object[] { localObject, Long.valueOf(l1) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l((String)localObject, l1, 4);
        AppMethodBeat.o(87779);
        return;
      }
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private long dAY;
    private String id;
    
    public b(String paramString, long paramLong)
    {
      this.id = paramString;
      this.dAY = paramLong;
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
        long l1 = this.dAY;
        ho localho = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bc(str, l1);
        if (localho == null)
        {
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "This File Sender is Me");
          AppMethodBeat.o(87780);
          return;
        }
        if (localho.FAb > 0L)
        {
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "onFileOpen file already use %s %s", new Object[] { str, Long.valueOf(l1) });
          AppMethodBeat.o(87780);
          return;
        }
        if (w.vF(localho.FzS)) {
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iy(localho.FzS, "@all");
        }
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iy(localho.FzS, localho.FzT);
        localho.FAb = System.currentTimeMillis();
        com.tencent.mm.plugin.priority.model.a.b.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
        long l2 = localho.FAb;
        localc.wLv.bindLong(1, l2);
        localc.wLv.bindString(2, str);
        localc.wLv.bindLong(3, l1);
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateOpenTime %s res %s %s %s", new Object[] { Integer.valueOf(localc.wLv.executeUpdateDelete()), str, Long.valueOf(l1), Long.valueOf(l2) });
        com.tencent.mm.plugin.priority.model.c.a(2, System.currentTimeMillis(), localho.nDG, localho);
      }
      AppMethodBeat.o(87780);
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bu dBd;
    
    public c(bu parambu)
    {
      this.dBd = parambu;
    }
    
    public final String getName()
    {
      return "C2CFileReceiveTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87781);
      if (this.dBd.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ad.i("MicroMsg.Priority.PriorityService", "onC2CFileReceive time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", this.dBd.field_createTime / 1000L) });
        AppMethodBeat.o(87781);
        return;
      }
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        Object localObject3 = this.dBd;
        Object localObject1 = ((ei)localObject3).field_talker;
        if ((w.vF(((ei)localObject3).field_talker)) && (((ei)localObject3).field_isSend == 0))
        {
          localObject2 = bj.Bl(((ei)localObject3).field_content);
          localObject1 = bt.bI(bj.Bk(((ei)localObject3).field_content), "");
        }
        Object localObject4;
        for (;;)
        {
          localObject4 = k.b.yr((String)localObject2);
          if (localObject4 != null) {
            break;
          }
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "appMsgContent is null");
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((ei)localObject3).field_content;
        }
        if ((w.vF(((ei)localObject3).field_talker)) && (((ei)localObject3).field_isSend == 0)) {
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iz(((ei)localObject3).field_talker, "@all");
        }
        double d;
        String str;
        for (int i = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iB(((ei)localObject3).field_talker, "@all");; i = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iB(((ei)localObject3).field_talker, ((ei)localObject3).field_talker))
        {
          d = Math.max(Math.max(localObject2[0], localObject2[1]), localObject2[2]);
          if (((k.b)localObject4).type != 6) {
            break label755;
          }
          str = String.valueOf(((ei)localObject3).field_msgId);
          if (!((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bb(str, ((ei)localObject3).field_msgSvrId)) {
            break;
          }
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { Long.valueOf(((ei)localObject3).field_msgId), Long.valueOf(((ei)localObject3).field_msgSvrId) });
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().iz(((ei)localObject3).field_talker, ((ei)localObject3).field_talker);
        }
        Object localObject2 = new ho();
        ((ho)localObject2).Id = str;
        ((ho)localObject2).FzS = ((ei)localObject3).field_talker;
        ((ho)localObject2).FzT = ((String)localObject1);
        ((ho)localObject2).FzU = 2;
        ((ho)localObject2).FzV = ((ei)localObject3).field_createTime;
        if (i < 2) {}
        for (i = 1;; i = 0)
        {
          ((ho)localObject2).FzW = i;
          ((ho)localObject2).nDG = 1;
          ((ho)localObject2).FzX = 0L;
          ((ho)localObject2).FzY = ((ei)localObject3).field_msgSvrId;
          ((ho)localObject2).FzZ = ((k.b)localObject4).hzO;
          ((ho)localObject2).FAa = ((k.b)localObject4).hzP;
          ((ho)localObject2).FAc = d;
          ((ho)localObject2).FAd = 1;
          ((ho)localObject2).FAe = ((k.b)localObject4).dks;
          localObject1 = com.tencent.mm.plugin.s.a.bIX().aLD(((k.b)localObject4).dks);
          if (localObject1 != null)
          {
            localObject3 = new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((((com.tencent.mm.vfs.e)localObject3).exists()) && (((com.tencent.mm.vfs.e)localObject3).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen))
            {
              ((ho)localObject2).FzX = System.currentTimeMillis();
              ((ho)localObject2).nDG = 6;
            }
          }
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { ((ho)localObject2).FzS, bt.Dd(((ho)localObject2).FzZ), ((ho)localObject2).FAa, Integer.valueOf(((ho)localObject2).FzW), Double.valueOf(((ho)localObject2).FAc) });
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a((ho)localObject2);
          if (w.vF(((ho)localObject2).FzS)) {
            ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().ix(((ho)localObject2).FzS, "@all");
          }
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().ix(((ho)localObject2).FzS, ((ho)localObject2).FzT);
          com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), ((ho)localObject2).nDG, (ho)localObject2);
          AppMethodBeat.o(87781);
          return;
        }
        label755:
        if (((k.b)localObject4).type == 19)
        {
          localObject2 = p.avr(((k.b)localObject4).hAs).hDb.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (ajn)((Iterator)localObject2).next();
            if (((ajn)localObject4).dataType == 8)
            {
              str = ((ajn)localObject4).dsU;
              if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bb(str, ((ei)localObject3).field_msgSvrId))
              {
                ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { str, Long.valueOf(((ei)localObject3).field_msgSvrId) });
              }
              else
              {
                ho localho = new ho();
                localho.Id = str;
                localho.FzS = ((ei)localObject3).field_talker;
                localho.FzT = ((String)localObject1);
                localho.FzU = 3;
                localho.FzV = ((ei)localObject3).field_createTime;
                if (i < 2) {}
                for (int j = 1;; j = 0)
                {
                  localho.FzW = j;
                  localho.nDG = 1;
                  localho.FzX = 0L;
                  localho.FzY = ((ei)localObject3).field_msgSvrId;
                  localho.FzZ = ((ajn)localObject4).Ghm;
                  localho.FAa = ((ajn)localObject4).Ghg;
                  localho.FAc = d;
                  localho.FAd = 1;
                  localho.FAe = ((ajn)localObject4).GgR;
                  ad.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { localho.FzS, bt.Dd(localho.FzZ), localho.FAa, Integer.valueOf(localho.FzW), Double.valueOf(localho.FAc) });
                  ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a(localho);
                  if (w.vF(localho.FzS)) {
                    ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().ix(localho.FzS, "@all");
                  }
                  ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgFileUsageStorage().ix(localho.FzS, localho.FzT);
                  com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), localho.nDG, localho);
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
    private boolean dpX;
    private boolean hjP;
    private long msgId;
    
    public d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.msgId = paramLong;
      this.dpX = paramBoolean1;
      this.hjP = paramBoolean2;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgDownloadedTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87782);
      Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(this.msgId);
      if (((ei)localObject).field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ad.i("MicroMsg.Priority.PriorityService", "onC2CImgDownloaded time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((ei)localObject).field_createTime / 1000L) });
        AppMethodBeat.o(87782);
        return;
      }
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        boolean bool1 = this.dpX;
        boolean bool2 = this.hjP;
        if (bool1)
        {
          hp localhp = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().yx(((ei)localObject).field_msgId);
          if (localhp == null)
          {
            ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "sender img %d", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
            AppMethodBeat.o(87782);
            return;
          }
          if (localhp.nDG == 3)
          {
            ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "already auto download msgid %d", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
            AppMethodBeat.o(87782);
            return;
          }
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 20L, 1L, false);
          if (localhp != null)
          {
            long l1 = System.currentTimeMillis();
            localObject = q.aIF().F(((ei)localObject).field_talker, localhp.FzY);
            localhp.FAg = ((com.tencent.mm.aw.g)localObject).hMP;
            com.tencent.mm.plugin.priority.model.c.a(1, l1, 0, localhp);
            com.tencent.mm.plugin.priority.model.a.c.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
            long l2 = localhp.FAf;
            int i = ((com.tencent.mm.aw.g)localObject).hMP;
            localc.wLu.bindLong(1, l1);
            localc.wLu.bindLong(2, 3L);
            localc.wLu.bindLong(3, i);
            localc.wLu.bindLong(4, l2);
            ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndDownloadTime %d res %d %d %d", new Object[] { Integer.valueOf(localc.wLu.executeUpdateDelete()), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(3) });
            if (com.tencent.mm.plugin.priority.a.a.a.gZ(localhp.FzW, 1))
            {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 21L, 1L, false);
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 22L, ((com.tencent.mm.aw.g)localObject).hMP, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gZ(localhp.FzW, 8))
            {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 23L, 1L, false);
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 24L, ((com.tencent.mm.aw.g)localObject).hMP, false);
            }
            if ((com.tencent.mm.plugin.priority.a.a.a.gZ(localhp.FzW, 2)) || (com.tencent.mm.plugin.priority.a.a.a.gZ(localhp.FzW, 4)))
            {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 25L, 1L, false);
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 26L, ((com.tencent.mm.aw.g)localObject).hMP, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gZ(localhp.FzW, 16))
            {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 27L, 1L, false);
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 28L, ((com.tencent.mm.aw.g)localObject).hMP, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gZ(localhp.FzW, 32))
            {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 29L, 1L, false);
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 30L, ((com.tencent.mm.aw.g)localObject).hMP, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gZ(localhp.FzW, 64))
            {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 33L, 1L, false);
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 34L, ((com.tencent.mm.aw.g)localObject).hMP, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.gZ(localhp.FzW, 128))
            {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 35L, 1L, false);
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 36L, ((com.tencent.mm.aw.g)localObject).hMP, false);
            }
            AppMethodBeat.o(87782);
            return;
          }
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 31L, 1L, false);
          AppMethodBeat.o(87782);
          return;
        }
        if (!bool2) {
          break label819;
        }
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download cancel %d", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(((ei)localObject).field_msgId, 1);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 32L, 1L, false);
        AppMethodBeat.o(87782);
        return;
        label819:
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download fail %d", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().S(((ei)localObject).field_msgId, 4);
      }
    }
  }
  
  final class e
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bu dBd;
    
    public e(bu parambu)
    {
      this.dBd = parambu;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgOpenTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87783);
      if (this.dBd.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ad.i("MicroMsg.Priority.PriorityService", "onC2CImgOpen time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", this.dBd.field_createTime / 1000L) });
        AppMethodBeat.o(87783);
        return;
      }
      hp localhp;
      int i;
      if (((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        bu localbu = this.dBd;
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 10L, 1L, false);
        localhp = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().yx(localbu.field_msgId);
        if (localhp == null)
        {
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 13L, 1L, false);
          AppMethodBeat.o(87783);
          return;
        }
        if (localhp.FAb > 0L)
        {
          ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgOpen img already use %d", new Object[] { Long.valueOf(localbu.field_msgId) });
          AppMethodBeat.o(87783);
          return;
        }
        if (w.vF(localbu.field_talker)) {
          ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iy(localhp.FzS, "@all");
        }
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iy(localhp.FzS, localhp.FzT);
        localhp.FAb = System.currentTimeMillis();
        com.tencent.mm.plugin.priority.model.a.c.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        long l1 = localbu.field_msgId;
        long l2 = localhp.FAb;
        localc.wLv.bindLong(1, l2);
        localc.wLv.bindLong(2, l1);
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateOpenTime %d res %d %d", new Object[] { Integer.valueOf(localc.wLv.executeUpdateDelete()), Long.valueOf(l1), Long.valueOf(l2) });
        if (localhp.nDG != 3) {
          break label394;
        }
        i = 1;
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 14L, 1L, false);
      }
      for (;;)
      {
        com.tencent.mm.plugin.priority.model.c.a(2, localhp.FAb, i, localhp);
        AppMethodBeat.o(87783);
        return;
        label394:
        if (localhp.nDG == 2)
        {
          i = 3;
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 16L, 1L, false);
        }
        else if (localhp.nDG == 4)
        {
          i = 4;
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 17L, 1L, false);
        }
        else if (localhp.nDG == 5)
        {
          i = 5;
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 18L, 1L, false);
        }
        else
        {
          i = 2;
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(957L, 15L, 1L, false);
        }
      }
    }
  }
  
  final class f
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private bu dBd;
    private WeakReference<Runnable> wKR;
    
    f(WeakReference<Runnable> paramWeakReference)
    {
      this.dBd = paramWeakReference;
      Object localObject;
      this.wKR = localObject;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgScrollTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87784);
      if (this.dBd.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getInstallPriorityTime())
      {
        ad.i("MicroMsg.Priority.PriorityService", "onC2CImgScroll time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", this.dBd.field_createTime / 1000L) });
        AppMethodBeat.o(87784);
        return;
      }
      ad.i("MicroMsg.Priority.PriorityService", "C2CImgScrollTask Start To Auto Download %d MsgId %d", new Object[] { Integer.valueOf(32), Long.valueOf(this.dBd.field_msgId) });
      if (this.wKR.get() != null) {
        ((Runnable)this.wKR.get()).run();
      }
      ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      bu localbu = this.dBd;
      hp localhp = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().yx(localbu.field_msgId);
      if (localhp == null)
      {
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
        AppMethodBeat.o(87784);
        return;
      }
      if (localhp.nDG == 1) {
        ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().n(localbu.field_msgId, 32, 2);
      }
      AppMethodBeat.o(87784);
    }
  }
  
  final class g
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private int score;
    private String wKS;
    
    public g(String paramString, int paramInt)
    {
      this.wKS = paramString;
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
        String str = this.wKS;
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