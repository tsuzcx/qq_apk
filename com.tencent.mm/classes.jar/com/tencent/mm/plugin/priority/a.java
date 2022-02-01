package com.tencent.mm.plugin.priority;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.q;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.comm.a.b
{
  public final List<Pair<String, String>> Ir(long paramLong)
  {
    AppMethodBeat.i(87795);
    List localList = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgFileUsageStorage().Pe(paramLong);
    AppMethodBeat.o(87795);
    return localList;
  }
  
  public final List<Pair<String, String>> Is(long paramLong)
  {
    AppMethodBeat.i(87796);
    List localList = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().Pe(paramLong);
    AppMethodBeat.o(87796);
    return localList;
  }
  
  public final void a(ca paramca, Runnable paramRunnable)
  {
    AppMethodBeat.i(87789);
    if ((h.aHB()) && (((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new f(paramca, new WeakReference(paramRunnable)));
    }
    AppMethodBeat.o(87789);
  }
  
  public final void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(87790);
    if ((h.aHB()) && (((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new a(paramBoolean1, paramString, paramLong, paramBoolean2));
    }
    AppMethodBeat.o(87790);
  }
  
  public final void aA(ca paramca)
  {
    AppMethodBeat.i(87787);
    if ((h.aHB()) && (((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new e(paramca));
    }
    AppMethodBeat.o(87787);
  }
  
  public final void aB(ca paramca)
  {
    AppMethodBeat.i(87788);
    if ((h.aHB()) && (((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.b(paramca));
    }
    AppMethodBeat.o(87788);
  }
  
  public final void aC(ca paramca)
  {
    AppMethodBeat.i(87792);
    if ((h.aHB()) && (((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new c(paramca));
    }
    AppMethodBeat.o(87792);
  }
  
  public final void aa(String paramString, long paramLong)
  {
    AppMethodBeat.i(87791);
    if ((h.aHB()) && (((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new b(paramString, paramLong));
    }
    AppMethodBeat.o(87791);
  }
  
  public final void asK(String paramString)
  {
    AppMethodBeat.i(87793);
    dp(paramString, 1);
    AppMethodBeat.o(87793);
  }
  
  public final void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(87786);
    if ((h.aHB()) && (((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new d(paramLong, paramBoolean1, paramBoolean2));
    }
    AppMethodBeat.o(87786);
  }
  
  public final List<Pair<String, String>> cPo()
  {
    AppMethodBeat.i(87794);
    new com.tencent.mm.plugin.priority.model.b.c().run();
    List localList = ((PluginPriority)h.ag(PluginPriority.class)).getC2CChatUsageResultStorage().foP();
    AppMethodBeat.o(87794);
    return localList;
  }
  
  public final void dp(String paramString, int paramInt)
  {
    AppMethodBeat.i(174312);
    if ((h.aHB()) && (((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new g(paramString, paramInt));
    }
    AppMethodBeat.o(174312);
  }
  
  final class a
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private long fNu;
    private String id;
    private boolean isSuccess;
    private boolean kUn;
    private boolean uii;
    
    public a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
    {
      this.uii = paramBoolean1;
      this.id = paramString;
      this.fNu = paramLong;
      this.isSuccess = paramBoolean2;
      this.kUn = false;
    }
    
    public final String getName()
    {
      return "Priority.onC2CFileDownloadedTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87779);
      if (((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        com.tencent.mm.plugin.priority.model.a.b.b.a(this.uii, this.id, this.fNu, this.isSuccess, this.kUn);
      }
      AppMethodBeat.o(87779);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private long fNu;
    private String id;
    
    public b(String paramString, long paramLong)
    {
      this.id = paramString;
      this.fNu = paramLong;
    }
    
    public final String getName()
    {
      return "Priority.C2CFileOpenTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87780);
      if (((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        com.tencent.mm.plugin.priority.model.a.b.b.bf(this.id, this.fNu);
      }
      AppMethodBeat.o(87780);
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private ca fNz;
    
    public c(ca paramca)
    {
      this.fNz = paramca;
    }
    
    public final String getName()
    {
      return "C2CFileReceiveTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87781);
      if (this.fNz.field_createTime <= ((PluginPriority)h.ag(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CFileReceive time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.fNz.field_createTime / 1000L) });
        AppMethodBeat.o(87781);
        return;
      }
      if (((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        Object localObject3 = this.fNz;
        Object localObject1 = ((et)localObject3).field_talker;
        if ((ab.Lj(((et)localObject3).field_talker)) && (((et)localObject3).field_isSend == 0))
        {
          localObject2 = bq.RM(((et)localObject3).field_content);
          localObject1 = Util.nullAs(bq.RL(((et)localObject3).field_content), "");
        }
        Object localObject4;
        for (;;)
        {
          localObject4 = k.b.OQ((String)localObject2);
          if (localObject4 != null) {
            break;
          }
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "appMsgContent is null");
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((et)localObject3).field_content;
        }
        if ((ab.Lj(((et)localObject3).field_talker)) && (((et)localObject3).field_isSend == 0)) {
          localObject2 = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgFileUsageStorage().jD(((et)localObject3).field_talker, "@all");
        }
        double d;
        String str;
        for (int i = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgFileUsageStorage().jF(((et)localObject3).field_talker, "@all");; i = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgFileUsageStorage().jF(((et)localObject3).field_talker, ((et)localObject3).field_talker))
        {
          d = com.tencent.mm.plugin.priority.model.a.b.b.b((double[])localObject2);
          if (((k.b)localObject4).type != 6) {
            break label742;
          }
          str = String.valueOf(((et)localObject3).field_msgId);
          if (!((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bg(str, ((et)localObject3).field_msgSvrId)) {
            break;
          }
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { Long.valueOf(((et)localObject3).field_msgId), Long.valueOf(((et)localObject3).field_msgSvrId) });
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgFileUsageStorage().jD(((et)localObject3).field_talker, ((et)localObject3).field_talker);
        }
        Object localObject2 = new hr();
        ((hr)localObject2).Id = str;
        ((hr)localObject2).RMW = ((et)localObject3).field_talker;
        ((hr)localObject2).RMX = ((String)localObject1);
        ((hr)localObject2).RMY = 2;
        ((hr)localObject2).RMZ = ((et)localObject3).field_createTime;
        if (i < 2) {}
        for (i = 1;; i = 0)
        {
          ((hr)localObject2).RNa = i;
          ((hr)localObject2).rVU = 1;
          ((hr)localObject2).RNb = 0L;
          ((hr)localObject2).RNc = ((et)localObject3).field_msgSvrId;
          ((hr)localObject2).RNd = ((k.b)localObject4).llX;
          ((hr)localObject2).RNe = ((k.b)localObject4).llY;
          ((hr)localObject2).RNg = d;
          ((hr)localObject2).RNh = 1;
          ((hr)localObject2).RNi = ((k.b)localObject4).fvr;
          localObject1 = com.tencent.mm.plugin.ab.a.ctZ().bpR(((k.b)localObject4).fvr);
          if (localObject1 != null)
          {
            localObject3 = new q(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((((q)localObject3).ifE()) && (((q)localObject3).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen))
            {
              ((hr)localObject2).RNb = System.currentTimeMillis();
              ((hr)localObject2).rVU = 6;
            }
          }
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { ((hr)localObject2).RMW, Util.getSizeMB(((hr)localObject2).RNd), ((hr)localObject2).RNe, Integer.valueOf(((hr)localObject2).RNa), Double.valueOf(((hr)localObject2).RNg) });
          ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a((hr)localObject2);
          if (ab.Lj(((hr)localObject2).RMW)) {
            ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgFileUsageStorage().jB(((hr)localObject2).RMW, "@all");
          }
          ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgFileUsageStorage().jB(((hr)localObject2).RMW, ((hr)localObject2).RMX);
          com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), ((hr)localObject2).rVU, (hr)localObject2);
          AppMethodBeat.o(87781);
          return;
        }
        label742:
        if (((k.b)localObject4).type == 19)
        {
          localObject2 = p.aVz(((k.b)localObject4).lmA).lpz.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (anm)((Iterator)localObject2).next();
            if (((anm)localObject4).dataType == 8)
            {
              str = ((anm)localObject4).fEa;
              if (((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bg(str, ((et)localObject3).field_msgSvrId))
              {
                Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { str, Long.valueOf(((et)localObject3).field_msgSvrId) });
              }
              else
              {
                hr localhr = new hr();
                localhr.Id = str;
                localhr.RMW = ((et)localObject3).field_talker;
                localhr.RMX = ((String)localObject1);
                localhr.RMY = 3;
                localhr.RMZ = ((et)localObject3).field_createTime;
                if (i < 2) {}
                for (int j = 1;; j = 0)
                {
                  localhr.RNa = j;
                  localhr.rVU = 1;
                  localhr.RNb = 0L;
                  localhr.RNc = ((et)localObject3).field_msgSvrId;
                  localhr.RNd = ((anm)localObject4).Syi;
                  localhr.RNe = ((anm)localObject4).Syc;
                  localhr.RNg = d;
                  localhr.RNh = 1;
                  localhr.RNi = ((anm)localObject4).Rwb;
                  Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { localhr.RMW, Util.getSizeMB(localhr.RNd), localhr.RNe, Integer.valueOf(localhr.RNa), Double.valueOf(localhr.RNg) });
                  ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a(localhr);
                  if (ab.Lj(localhr.RMW)) {
                    ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgFileUsageStorage().jB(localhr.RMW, "@all");
                  }
                  ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgFileUsageStorage().jB(localhr.RMW, localhr.RMX);
                  com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), localhr.rVU, localhr);
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
    private boolean isSuccess;
    private boolean kUn;
    private long msgId;
    
    public d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.msgId = paramLong;
      this.isSuccess = paramBoolean1;
      this.kUn = paramBoolean2;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgDownloadedTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87782);
      ca localca = ((n)h.ae(n.class)).eSe().Oq(this.msgId);
      if (localca.field_createTime <= ((PluginPriority)h.ag(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CImgDownloaded time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", localca.field_createTime / 1000L) });
        AppMethodBeat.o(87782);
        return;
      }
      if (((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        com.tencent.mm.plugin.priority.model.a.c.b.a(localca, this.isSuccess, this.kUn);
      }
      AppMethodBeat.o(87782);
    }
  }
  
  final class e
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private ca fNz;
    
    public e(ca paramca)
    {
      this.fNz = paramca;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgOpenTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87783);
      if (this.fNz.field_createTime <= ((PluginPriority)h.ag(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CImgOpen time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.fNz.field_createTime / 1000L) });
        AppMethodBeat.o(87783);
        return;
      }
      if (((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        com.tencent.mm.plugin.priority.model.a.c.b.aV(this.fNz);
      }
      AppMethodBeat.o(87783);
    }
  }
  
  final class f
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private WeakReference<Runnable> GSf;
    private ca fNz;
    
    f(WeakReference<Runnable> paramWeakReference)
    {
      this.fNz = paramWeakReference;
      Object localObject;
      this.GSf = localObject;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgScrollTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87784);
      if (this.fNz.field_createTime <= ((PluginPriority)h.ag(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CImgScroll time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.fNz.field_createTime / 1000L) });
        AppMethodBeat.o(87784);
        return;
      }
      Log.i("MicroMsg.Priority.PriorityService", "C2CImgScrollTask Start To Auto Download %d MsgId %d", new Object[] { Integer.valueOf(32), Long.valueOf(this.fNz.field_msgId) });
      if (this.GSf.get() != null) {
        ((Runnable)this.GSf.get()).run();
      }
      ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      com.tencent.mm.plugin.priority.model.a.c.b.aU(this.fNz);
      AppMethodBeat.o(87784);
    }
  }
  
  final class g
    extends com.tencent.mm.plugin.priority.model.b.a
  {
    private String GSg;
    private int score;
    
    public g(String paramString, int paramInt)
    {
      this.GSg = paramString;
      this.score = paramInt;
    }
    
    public final String getName()
    {
      return "Priority.C2CMsgConsumeTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87785);
      if (((PluginPriority)h.ag(PluginPriority.class)).getC2CChatUsageLogic() != null)
      {
        com.tencent.mm.plugin.priority.model.a.a.a locala = ((PluginPriority)h.ag(PluginPriority.class)).getC2CChatUsageLogic();
        String str = this.GSg;
        int i = this.score;
        ((PluginPriority)h.ag(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.a.a.a.a(locala, str, i, (byte)0));
      }
      AppMethodBeat.o(87785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a
 * JD-Core Version:    0.7.0.1
 */