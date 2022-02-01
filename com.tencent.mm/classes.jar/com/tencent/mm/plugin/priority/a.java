package com.tencent.mm.plugin.priority;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.wcdb.database.SQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.comm.a.b
{
  public final List<Pair<String, String>> Ci(long paramLong)
  {
    AppMethodBeat.i(87795);
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().HK(paramLong);
    AppMethodBeat.o(87795);
    return localList;
  }
  
  public final List<Pair<String, String>> Cj(long paramLong)
  {
    AppMethodBeat.i(87796);
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().HK(paramLong);
    AppMethodBeat.o(87796);
    return localList;
  }
  
  public final void Z(String paramString, long paramLong)
  {
    AppMethodBeat.i(87791);
    if ((com.tencent.mm.kernel.g.aAc()) && (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new b(paramString, paramLong));
    }
    AppMethodBeat.o(87791);
  }
  
  public final void a(ca paramca, Runnable paramRunnable)
  {
    AppMethodBeat.i(87789);
    if ((com.tencent.mm.kernel.g.aAc()) && (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new f(paramca, new WeakReference(paramRunnable)));
    }
    AppMethodBeat.o(87789);
  }
  
  public final void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(87790);
    if ((com.tencent.mm.kernel.g.aAc()) && (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new a(paramBoolean1, paramString, paramLong, paramBoolean2));
    }
    AppMethodBeat.o(87790);
  }
  
  public final void akR(String paramString)
  {
    AppMethodBeat.i(87793);
    cV(paramString, 1);
    AppMethodBeat.o(87793);
  }
  
  public final void as(ca paramca)
  {
    AppMethodBeat.i(87787);
    if ((com.tencent.mm.kernel.g.aAc()) && (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new e(paramca));
    }
    AppMethodBeat.o(87787);
  }
  
  public final void at(ca paramca)
  {
    AppMethodBeat.i(87788);
    if ((com.tencent.mm.kernel.g.aAc()) && (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.b(paramca));
    }
    AppMethodBeat.o(87788);
  }
  
  public final void au(ca paramca)
  {
    AppMethodBeat.i(87792);
    if ((com.tencent.mm.kernel.g.aAc()) && (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new c(paramca));
    }
    AppMethodBeat.o(87792);
  }
  
  public final void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(87786);
    if ((com.tencent.mm.kernel.g.aAc()) && (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new d(paramLong, paramBoolean1, paramBoolean2));
    }
    AppMethodBeat.o(87786);
  }
  
  public final List<Pair<String, String>> cAL()
  {
    AppMethodBeat.i(87794);
    new com.tencent.mm.plugin.priority.model.b.c().run();
    List localList = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CChatUsageResultStorage().eCW();
    AppMethodBeat.o(87794);
    return localList;
  }
  
  public final void cV(String paramString, int paramInt)
  {
    AppMethodBeat.i(174312);
    if ((com.tencent.mm.kernel.g.aAc()) && (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new g(paramString, paramInt));
    }
    AppMethodBeat.o(174312);
  }
  
  final class a
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private long dTS;
    private String id;
    private boolean ifz;
    private boolean isSuccess;
    private boolean qJf;
    
    public a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
    {
      this.qJf = paramBoolean1;
      this.id = paramString;
      this.dTS = paramLong;
      this.isSuccess = paramBoolean2;
      this.ifz = false;
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
      ib localib;
      if (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        boolean bool1 = this.qJf;
        localObject = this.id;
        l1 = this.dTS;
        boolean bool2 = this.isSuccess;
        bool3 = this.ifz;
        if (bool2)
        {
          localib = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bf((String)localObject, l1);
          if (localib == null)
          {
            Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "sender file %s %s", new Object[] { localObject, Long.valueOf(l1) });
            AppMethodBeat.o(87779);
            return;
          }
          if ((localib.oTW == 1) || (localib.oTW == 2) || (localib.oTW == 4)) {
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
        com.tencent.mm.plugin.priority.model.c.a(1, l1, i, localib);
        localObject = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
        String str = localib.Id;
        long l2 = localib.KMf;
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).AYK.bindLong(1, l1);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).AYK.bindLong(2, i);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).AYK.bindString(3, str);
        ((com.tencent.mm.plugin.priority.model.a.b.c)localObject).AYK.bindLong(4, l2);
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatusAndDownloadTime %s res %s %s %s %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.priority.model.a.b.c)localObject).AYK.executeUpdateDelete()), str, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
        AppMethodBeat.o(87779);
        return;
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "already auto download msgid %s %s", new Object[] { localObject, Long.valueOf(l1) });
        AppMethodBeat.o(87779);
        return;
        if (bool3)
        {
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download cancel %s %s", new Object[] { localObject, Long.valueOf(l1) });
          ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l((String)localObject, l1, 1);
          AppMethodBeat.o(87779);
          return;
        }
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download fail %s %s", new Object[] { localObject, Long.valueOf(l1) });
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l((String)localObject, l1, 4);
        AppMethodBeat.o(87779);
        return;
      }
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private long dTS;
    private String id;
    
    public b(String paramString, long paramLong)
    {
      this.id = paramString;
      this.dTS = paramLong;
    }
    
    public final String getName()
    {
      return "Priority.C2CFileOpenTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87780);
      if (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        String str = this.id;
        long l1 = this.dTS;
        ib localib = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bf(str, l1);
        if (localib == null)
        {
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "This File Sender is Me");
          AppMethodBeat.o(87780);
          return;
        }
        if (localib.KMi > 0L)
        {
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "onFileOpen file already use %s %s", new Object[] { str, Long.valueOf(l1) });
          AppMethodBeat.o(87780);
          return;
        }
        if (ab.Eq(localib.KLZ)) {
          ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jq(localib.KLZ, "@all");
        }
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jq(localib.KLZ, localib.KMa);
        localib.KMi = System.currentTimeMillis();
        com.tencent.mm.plugin.priority.model.a.b.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
        long l2 = localib.KMi;
        localc.AYL.bindLong(1, l2);
        localc.AYL.bindString(2, str);
        localc.AYL.bindLong(3, l1);
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateOpenTime %s res %s %s %s", new Object[] { Integer.valueOf(localc.AYL.executeUpdateDelete()), str, Long.valueOf(l1), Long.valueOf(l2) });
        com.tencent.mm.plugin.priority.model.c.a(2, System.currentTimeMillis(), localib.oTW, localib);
      }
      AppMethodBeat.o(87780);
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private ca dTX;
    
    public c(ca paramca)
    {
      this.dTX = paramca;
    }
    
    public final String getName()
    {
      return "C2CFileReceiveTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87781);
      if (this.dTX.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CFileReceive time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.dTX.field_createTime / 1000L) });
        AppMethodBeat.o(87781);
        return;
      }
      if (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        Object localObject3 = this.dTX;
        Object localObject1 = ((eo)localObject3).field_talker;
        if ((ab.Eq(((eo)localObject3).field_talker)) && (((eo)localObject3).field_isSend == 0))
        {
          localObject2 = bp.Kt(((eo)localObject3).field_content);
          localObject1 = Util.nullAs(bp.Ks(((eo)localObject3).field_content), "");
        }
        Object localObject4;
        for (;;)
        {
          localObject4 = k.b.HD((String)localObject2);
          if (localObject4 != null) {
            break;
          }
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "appMsgContent is null");
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((eo)localObject3).field_content;
        }
        if ((ab.Eq(((eo)localObject3).field_talker)) && (((eo)localObject3).field_isSend == 0)) {
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jr(((eo)localObject3).field_talker, "@all");
        }
        double d;
        String str;
        for (int i = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jt(((eo)localObject3).field_talker, "@all");; i = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jt(((eo)localObject3).field_talker, ((eo)localObject3).field_talker))
        {
          d = Math.max(Math.max(localObject2[0], localObject2[1]), localObject2[2]);
          if (((k.b)localObject4).type != 6) {
            break label755;
          }
          str = String.valueOf(((eo)localObject3).field_msgId);
          if (!((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().be(str, ((eo)localObject3).field_msgSvrId)) {
            break;
          }
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { Long.valueOf(((eo)localObject3).field_msgId), Long.valueOf(((eo)localObject3).field_msgSvrId) });
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jr(((eo)localObject3).field_talker, ((eo)localObject3).field_talker);
        }
        Object localObject2 = new ib();
        ((ib)localObject2).Id = str;
        ((ib)localObject2).KLZ = ((eo)localObject3).field_talker;
        ((ib)localObject2).KMa = ((String)localObject1);
        ((ib)localObject2).KMb = 2;
        ((ib)localObject2).KMc = ((eo)localObject3).field_createTime;
        if (i < 2) {}
        for (i = 1;; i = 0)
        {
          ((ib)localObject2).KMd = i;
          ((ib)localObject2).oTW = 1;
          ((ib)localObject2).KMe = 0L;
          ((ib)localObject2).KMf = ((eo)localObject3).field_msgSvrId;
          ((ib)localObject2).KMg = ((k.b)localObject4).iwI;
          ((ib)localObject2).KMh = ((k.b)localObject4).iwJ;
          ((ib)localObject2).KMj = d;
          ((ib)localObject2).KMk = 1;
          ((ib)localObject2).KMl = ((k.b)localObject4).dCK;
          localObject1 = com.tencent.mm.plugin.r.a.cgO().bdx(((k.b)localObject4).dCK);
          if (localObject1 != null)
          {
            localObject3 = new o(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((((o)localObject3).exists()) && (((o)localObject3).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen))
            {
              ((ib)localObject2).KMe = System.currentTimeMillis();
              ((ib)localObject2).oTW = 6;
            }
          }
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { ((ib)localObject2).KLZ, Util.getSizeMB(((ib)localObject2).KMg), ((ib)localObject2).KMh, Integer.valueOf(((ib)localObject2).KMd), Double.valueOf(((ib)localObject2).KMj) });
          ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a((ib)localObject2);
          if (ab.Eq(((ib)localObject2).KLZ)) {
            ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jp(((ib)localObject2).KLZ, "@all");
          }
          ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jp(((ib)localObject2).KLZ, ((ib)localObject2).KMa);
          com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), ((ib)localObject2).oTW, (ib)localObject2);
          AppMethodBeat.o(87781);
          return;
        }
        label755:
        if (((k.b)localObject4).type == 19)
        {
          localObject2 = p.aKY(((k.b)localObject4).ixl).iAd.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (aml)((Iterator)localObject2).next();
            if (((aml)localObject4).dataType == 8)
            {
              str = ((aml)localObject4).dLl;
              if (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().be(str, ((eo)localObject3).field_msgSvrId))
              {
                Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { str, Long.valueOf(((eo)localObject3).field_msgSvrId) });
              }
              else
              {
                ib localib = new ib();
                localib.Id = str;
                localib.KLZ = ((eo)localObject3).field_talker;
                localib.KMa = ((String)localObject1);
                localib.KMb = 3;
                localib.KMc = ((eo)localObject3).field_createTime;
                if (i < 2) {}
                for (int j = 1;; j = 0)
                {
                  localib.KMd = j;
                  localib.oTW = 1;
                  localib.KMe = 0L;
                  localib.KMf = ((eo)localObject3).field_msgSvrId;
                  localib.KMg = ((aml)localObject4).LvI;
                  localib.KMh = ((aml)localObject4).LvC;
                  localib.KMj = d;
                  localib.KMk = 1;
                  localib.KMl = ((aml)localObject4).KuR;
                  Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { localib.KLZ, Util.getSizeMB(localib.KMg), localib.KMh, Integer.valueOf(localib.KMd), Double.valueOf(localib.KMj) });
                  ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a(localib);
                  if (ab.Eq(localib.KLZ)) {
                    ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jp(localib.KLZ, "@all");
                  }
                  ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jp(localib.KLZ, localib.KMa);
                  com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), localib.oTW, localib);
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
    private boolean ifz;
    private boolean isSuccess;
    private long msgId;
    
    public d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.msgId = paramLong;
      this.isSuccess = paramBoolean1;
      this.ifz = paramBoolean2;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgDownloadedTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87782);
      Object localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.msgId);
      if (((eo)localObject).field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CImgDownloaded time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", ((eo)localObject).field_createTime / 1000L) });
        AppMethodBeat.o(87782);
        return;
      }
      if (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        boolean bool1 = this.isSuccess;
        boolean bool2 = this.ifz;
        if (bool1)
        {
          ic localic = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().HM(((eo)localObject).field_msgId);
          if (localic == null)
          {
            Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "sender img %d", new Object[] { Long.valueOf(((eo)localObject).field_msgId) });
            AppMethodBeat.o(87782);
            return;
          }
          if (localic.oTW == 3)
          {
            Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "already auto download msgid %d", new Object[] { Long.valueOf(((eo)localObject).field_msgId) });
            AppMethodBeat.o(87782);
            return;
          }
          e.Cxv.idkeyStat(957L, 20L, 1L, false);
          if (localic != null)
          {
            long l1 = System.currentTimeMillis();
            localObject = q.bcR().G(((eo)localObject).field_talker, localic.KMf);
            localic.KMn = ((com.tencent.mm.av.g)localObject).iKP;
            com.tencent.mm.plugin.priority.model.c.a(1, l1, 0, localic);
            com.tencent.mm.plugin.priority.model.a.c.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
            long l2 = localic.KMm;
            int i = ((com.tencent.mm.av.g)localObject).iKP;
            localc.AYK.bindLong(1, l1);
            localc.AYK.bindLong(2, 3L);
            localc.AYK.bindLong(3, i);
            localc.AYK.bindLong(4, l2);
            Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndDownloadTime %d res %d %d %d", new Object[] { Integer.valueOf(localc.AYK.executeUpdateDelete()), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(3) });
            if (com.tencent.mm.plugin.priority.a.a.a.hL(localic.KMd, 1))
            {
              e.Cxv.idkeyStat(957L, 21L, 1L, false);
              e.Cxv.idkeyStat(957L, 22L, ((com.tencent.mm.av.g)localObject).iKP, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.hL(localic.KMd, 8))
            {
              e.Cxv.idkeyStat(957L, 23L, 1L, false);
              e.Cxv.idkeyStat(957L, 24L, ((com.tencent.mm.av.g)localObject).iKP, false);
            }
            if ((com.tencent.mm.plugin.priority.a.a.a.hL(localic.KMd, 2)) || (com.tencent.mm.plugin.priority.a.a.a.hL(localic.KMd, 4)))
            {
              e.Cxv.idkeyStat(957L, 25L, 1L, false);
              e.Cxv.idkeyStat(957L, 26L, ((com.tencent.mm.av.g)localObject).iKP, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.hL(localic.KMd, 16))
            {
              e.Cxv.idkeyStat(957L, 27L, 1L, false);
              e.Cxv.idkeyStat(957L, 28L, ((com.tencent.mm.av.g)localObject).iKP, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.hL(localic.KMd, 32))
            {
              e.Cxv.idkeyStat(957L, 29L, 1L, false);
              e.Cxv.idkeyStat(957L, 30L, ((com.tencent.mm.av.g)localObject).iKP, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.hL(localic.KMd, 64))
            {
              e.Cxv.idkeyStat(957L, 33L, 1L, false);
              e.Cxv.idkeyStat(957L, 34L, ((com.tencent.mm.av.g)localObject).iKP, false);
            }
            if (com.tencent.mm.plugin.priority.a.a.a.hL(localic.KMd, 128))
            {
              e.Cxv.idkeyStat(957L, 35L, 1L, false);
              e.Cxv.idkeyStat(957L, 36L, ((com.tencent.mm.av.g)localObject).iKP, false);
            }
            AppMethodBeat.o(87782);
            return;
          }
          e.Cxv.idkeyStat(957L, 31L, 1L, false);
          AppMethodBeat.o(87782);
          return;
        }
        if (!bool2) {
          break label819;
        }
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download cancel %d", new Object[] { Long.valueOf(((eo)localObject).field_msgId) });
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(((eo)localObject).field_msgId, 1);
      }
      for (;;)
      {
        e.Cxv.idkeyStat(957L, 32L, 1L, false);
        AppMethodBeat.o(87782);
        return;
        label819:
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download fail %d", new Object[] { Long.valueOf(((eo)localObject).field_msgId) });
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(((eo)localObject).field_msgId, 4);
      }
    }
  }
  
  final class e
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private ca dTX;
    
    public e(ca paramca)
    {
      this.dTX = paramca;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgOpenTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87783);
      if (this.dTX.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CImgOpen time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.dTX.field_createTime / 1000L) });
        AppMethodBeat.o(87783);
        return;
      }
      ic localic;
      int i;
      if (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        ca localca = this.dTX;
        e.Cxv.idkeyStat(957L, 10L, 1L, false);
        localic = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().HM(localca.field_msgId);
        if (localic == null)
        {
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
          e.Cxv.idkeyStat(957L, 13L, 1L, false);
          AppMethodBeat.o(87783);
          return;
        }
        if (localic.KMi > 0L)
        {
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgOpen img already use %d", new Object[] { Long.valueOf(localca.field_msgId) });
          AppMethodBeat.o(87783);
          return;
        }
        if (ab.Eq(localca.field_talker)) {
          ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jq(localic.KLZ, "@all");
        }
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jq(localic.KLZ, localic.KMa);
        localic.KMi = System.currentTimeMillis();
        com.tencent.mm.plugin.priority.model.a.c.c localc = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        long l1 = localca.field_msgId;
        long l2 = localic.KMi;
        localc.AYL.bindLong(1, l2);
        localc.AYL.bindLong(2, l1);
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateOpenTime %d res %d %d", new Object[] { Integer.valueOf(localc.AYL.executeUpdateDelete()), Long.valueOf(l1), Long.valueOf(l2) });
        if (localic.oTW != 3) {
          break label394;
        }
        i = 1;
        e.Cxv.idkeyStat(957L, 14L, 1L, false);
      }
      for (;;)
      {
        com.tencent.mm.plugin.priority.model.c.a(2, localic.KMi, i, localic);
        AppMethodBeat.o(87783);
        return;
        label394:
        if (localic.oTW == 2)
        {
          i = 3;
          e.Cxv.idkeyStat(957L, 16L, 1L, false);
        }
        else if (localic.oTW == 4)
        {
          i = 4;
          e.Cxv.idkeyStat(957L, 17L, 1L, false);
        }
        else if (localic.oTW == 5)
        {
          i = 5;
          e.Cxv.idkeyStat(957L, 18L, 1L, false);
        }
        else
        {
          i = 2;
          e.Cxv.idkeyStat(957L, 15L, 1L, false);
        }
      }
    }
  }
  
  final class f
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private WeakReference<Runnable> AYh;
    private ca dTX;
    
    f(WeakReference<Runnable> paramWeakReference)
    {
      this.dTX = paramWeakReference;
      Object localObject;
      this.AYh = localObject;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgScrollTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87784);
      if (this.dTX.field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CImgScroll time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.dTX.field_createTime / 1000L) });
        AppMethodBeat.o(87784);
        return;
      }
      Log.i("MicroMsg.Priority.PriorityService", "C2CImgScrollTask Start To Auto Download %d MsgId %d", new Object[] { Integer.valueOf(32), Long.valueOf(this.dTX.field_msgId) });
      if (this.AYh.get() != null) {
        ((Runnable)this.AYh.get()).run();
      }
      ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      ca localca = this.dTX;
      ic localic = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().HM(localca.field_msgId);
      if (localic == null)
      {
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
        AppMethodBeat.o(87784);
        return;
      }
      if (localic.oTW == 1) {
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().m(localca.field_msgId, 32, 2);
      }
      AppMethodBeat.o(87784);
    }
  }
  
  final class g
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private String AYi;
    private int score;
    
    public g(String paramString, int paramInt)
    {
      this.AYi = paramString;
      this.score = paramInt;
    }
    
    public final String getName()
    {
      return "Priority.C2CMsgConsumeTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87785);
      if (((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CChatUsageLogic() != null)
      {
        com.tencent.mm.plugin.priority.model.a.a.a locala = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CChatUsageLogic();
        String str = this.AYi;
        int i = this.score;
        ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.a.a.a.a(locala, str, i, (byte)0));
      }
      AppMethodBeat.o(87785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a
 * JD-Core Version:    0.7.0.1
 */