package com.tencent.mm.plugin.priority;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.model.q;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.comm.a.c
{
  public final void a(cc paramcc, Runnable paramRunnable)
  {
    AppMethodBeat.i(87789);
    if ((h.baz()) && (((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner().a(new f(paramcc, new WeakReference(paramRunnable)));
    }
    AppMethodBeat.o(87789);
  }
  
  public final void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(87790);
    if ((h.baz()) && (((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner().a(new a(paramBoolean1, paramString, paramLong, paramBoolean2));
    }
    AppMethodBeat.o(87790);
  }
  
  public final void aJ(cc paramcc)
  {
    AppMethodBeat.i(87787);
    if ((h.baz()) && (((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner().a(new e(paramcc));
    }
    AppMethodBeat.o(87787);
  }
  
  public final void aK(cc paramcc)
  {
    AppMethodBeat.i(87788);
    if ((h.baz()) && (((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.a.b(paramcc));
    }
    AppMethodBeat.o(87788);
  }
  
  public final void aL(cc paramcc)
  {
    AppMethodBeat.i(87792);
    if ((h.baz()) && (((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner().a(new c(paramcc));
    }
    AppMethodBeat.o(87792);
  }
  
  public final void ae(String paramString, long paramLong)
  {
    AppMethodBeat.i(87791);
    if ((h.baz()) && (((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner().a(new b(paramString, paramLong));
    }
    AppMethodBeat.o(87791);
  }
  
  public final void amp(String paramString)
  {
    AppMethodBeat.i(87793);
    dQ(paramString, 1);
    AppMethodBeat.o(87793);
  }
  
  public final void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(87786);
    if ((h.baz()) && (((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner().a(new d(paramLong, paramBoolean1, paramBoolean2));
    }
    AppMethodBeat.o(87786);
  }
  
  public final void dQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(174312);
    if ((h.baz()) && (((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner() != null)) {
      ((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner().a(new g(paramString, paramInt));
    }
    AppMethodBeat.o(174312);
  }
  
  public final List<Pair<String, String>> dsU()
  {
    AppMethodBeat.i(87794);
    new com.tencent.mm.plugin.priority.model.a.c().run();
    List localList = ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageResultStorage().gzT();
    AppMethodBeat.o(87794);
    return localList;
  }
  
  public final List<Pair<String, String>> kJ(long paramLong)
  {
    AppMethodBeat.i(87795);
    List localList = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().tg(paramLong);
    AppMethodBeat.o(87795);
    return localList;
  }
  
  public final List<Pair<String, String>> kK(long paramLong)
  {
    AppMethodBeat.i(87796);
    List localList = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().tg(paramLong);
    AppMethodBeat.o(87796);
    return localList;
  }
  
  final class a
    extends com.tencent.mm.plugin.priority.model.a.a
  {
    private long hTh;
    private String id;
    private boolean isSuccess;
    private boolean nzW;
    private boolean xon;
    
    public a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
    {
      this.xon = paramBoolean1;
      this.id = paramString;
      this.hTh = paramLong;
      this.isSuccess = paramBoolean2;
      this.nzW = false;
    }
    
    public final String getName()
    {
      return "Priority.onC2CFileDownloadedTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87779);
      if (((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        com.tencent.mm.plugin.priority.model.c2c.b.b.a(this.xon, this.id, this.hTh, this.isSuccess, this.nzW);
      }
      AppMethodBeat.o(87779);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.priority.model.a.a
  {
    private long hTh;
    private String id;
    
    public b(String paramString, long paramLong)
    {
      this.id = paramString;
      this.hTh = paramLong;
    }
    
    public final String getName()
    {
      return "Priority.C2CFileOpenTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87780);
      if (((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        com.tencent.mm.plugin.priority.model.c2c.b.b.bp(this.id, this.hTh);
      }
      AppMethodBeat.o(87780);
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.priority.model.a.a
  {
    private cc hTm;
    
    public c(cc paramcc)
    {
      this.hTm = paramcc;
    }
    
    public final String getName()
    {
      return "C2CFileReceiveTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87781);
      if (this.hTm.getCreateTime() <= ((PluginPriority)h.az(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CFileReceive time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.hTm.getCreateTime() / 1000L) });
        AppMethodBeat.o(87781);
        return;
      }
      if (((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null)
      {
        ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
        Object localObject3 = this.hTm;
        Object localObject1 = ((fi)localObject3).field_talker;
        if ((au.bwE(((fi)localObject3).field_talker)) && (((fi)localObject3).field_isSend == 0))
        {
          localObject2 = br.JK(((fi)localObject3).field_content);
          localObject1 = Util.nullAs(br.JJ(((fi)localObject3).field_content), "");
        }
        Object localObject4;
        for (;;)
        {
          localObject4 = k.b.Hf((String)localObject2);
          if (localObject4 != null) {
            break;
          }
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "appMsgContent is null");
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((fi)localObject3).field_content;
        }
        if ((au.bwE(((fi)localObject3).field_talker)) && (((fi)localObject3).field_isSend == 0)) {
          localObject2 = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().kX(((fi)localObject3).field_talker, "@all");
        }
        double d;
        String str;
        for (int i = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().kZ(((fi)localObject3).field_talker, "@all");; i = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().kZ(((fi)localObject3).field_talker, ((fi)localObject3).field_talker))
        {
          d = com.tencent.mm.plugin.priority.model.c2c.b.b.d((double[])localObject2);
          if (((k.b)localObject4).type != 6) {
            break label742;
          }
          str = String.valueOf(((fi)localObject3).field_msgId);
          if (!((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().br(str, ((fi)localObject3).field_msgSvrId)) {
            break;
          }
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { Long.valueOf(((fi)localObject3).field_msgId), Long.valueOf(((fi)localObject3).field_msgSvrId) });
          AppMethodBeat.o(87781);
          return;
          localObject2 = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().kX(((fi)localObject3).field_talker, ((fi)localObject3).field_talker);
        }
        Object localObject2 = new in();
        ((in)localObject2).Id = str;
        ((in)localObject2).YKk = ((fi)localObject3).field_talker;
        ((in)localObject2).YKl = ((String)localObject1);
        ((in)localObject2).YKm = 2;
        ((in)localObject2).YKn = ((cc)localObject3).getCreateTime();
        if (i < 2) {}
        for (i = 1;; i = 0)
        {
          ((in)localObject2).YKo = i;
          ((in)localObject2).vhk = 1;
          ((in)localObject2).YKp = 0L;
          ((in)localObject2).YKq = ((fi)localObject3).field_msgSvrId;
          ((in)localObject2).YKr = ((k.b)localObject4).nRd;
          ((in)localObject2).YKs = ((k.b)localObject4).nRe;
          ((in)localObject2).YKu = d;
          ((in)localObject2).YKv = 1;
          ((in)localObject2).YKw = ((k.b)localObject4).hzM;
          localObject1 = com.tencent.mm.plugin.openapi.a.cWJ().bpI(((k.b)localObject4).hzM);
          if (localObject1 != null)
          {
            localObject3 = new u(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((((u)localObject3).jKS()) && (((u)localObject3).length() == ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen))
            {
              ((in)localObject2).YKp = System.currentTimeMillis();
              ((in)localObject2).vhk = 6;
            }
          }
          Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { ((in)localObject2).YKk, Util.getSizeMB(((in)localObject2).YKr), ((in)localObject2).YKs, Integer.valueOf(((in)localObject2).YKo), Double.valueOf(((in)localObject2).YKu) });
          ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a((in)localObject2);
          if (au.bwE(((in)localObject2).YKk)) {
            ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().kV(((in)localObject2).YKk, "@all");
          }
          ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().kV(((in)localObject2).YKk, ((in)localObject2).YKl);
          com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), ((in)localObject2).vhk, (in)localObject2);
          AppMethodBeat.o(87781);
          return;
        }
        label742:
        if (((k.b)localObject4).type == 19)
        {
          localObject2 = q.aSH(((k.b)localObject4).nRF).nUC.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (arf)((Iterator)localObject2).next();
            if (((arf)localObject4).dataType == 8)
            {
              str = ((arf)localObject4).hIQ;
              if (((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().br(str, ((fi)localObject3).field_msgSvrId))
              {
                Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", new Object[] { str, Long.valueOf(((fi)localObject3).field_msgSvrId) });
              }
              else
              {
                in localin = new in();
                localin.Id = str;
                localin.YKk = ((fi)localObject3).field_talker;
                localin.YKl = ((String)localObject1);
                localin.YKm = 3;
                localin.YKn = ((cc)localObject3).getCreateTime();
                if (i < 2) {}
                for (int j = 1;; j = 0)
                {
                  localin.YKo = j;
                  localin.vhk = 1;
                  localin.YKp = 0L;
                  localin.YKq = ((fi)localObject3).field_msgSvrId;
                  localin.YKr = ((arf)localObject4).Zza;
                  localin.YKs = ((arf)localObject4).ZyU;
                  localin.YKu = d;
                  localin.YKv = 1;
                  localin.YKw = ((arf)localObject4).Ysw;
                  Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", new Object[] { localin.YKk, Util.getSizeMB(localin.YKr), localin.YKs, Integer.valueOf(localin.YKo), Double.valueOf(localin.YKu) });
                  ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a(localin);
                  if (au.bwE(localin.YKk)) {
                    ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().kV(localin.YKk, "@all");
                  }
                  ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().kV(localin.YKk, localin.YKl);
                  com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), localin.vhk, localin);
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
    extends com.tencent.mm.plugin.priority.model.a.a
  {
    private boolean isSuccess;
    private long msgId;
    private boolean nzW;
    
    public d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.msgId = paramLong;
      this.isSuccess = paramBoolean1;
      this.nzW = paramBoolean2;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgDownloadedTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87782);
      cc localcc = ((n)h.ax(n.class)).gaZ().sl(this.msgId);
      if (localcc.getCreateTime() <= ((PluginPriority)h.az(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CImgDownloaded time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", localcc.getCreateTime() / 1000L) });
        AppMethodBeat.o(87782);
        return;
      }
      if (((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        com.tencent.mm.plugin.priority.model.c2c.img.b.a(localcc, this.isSuccess, this.nzW);
      }
      AppMethodBeat.o(87782);
    }
  }
  
  final class e
    extends com.tencent.mm.plugin.priority.model.a.a
  {
    private cc hTm;
    
    public e(cc paramcc)
    {
      this.hTm = paramcc;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgOpenTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87783);
      if (this.hTm.getCreateTime() <= ((PluginPriority)h.az(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CImgOpen time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.hTm.getCreateTime() / 1000L) });
        AppMethodBeat.o(87783);
        return;
      }
      if (((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
      {
        ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
        com.tencent.mm.plugin.priority.model.c2c.img.b.bm(this.hTm);
      }
      AppMethodBeat.o(87783);
    }
  }
  
  final class f
    extends com.tencent.mm.plugin.priority.model.a.a
  {
    private WeakReference<Runnable> MPJ;
    private cc hTm;
    
    f(WeakReference<Runnable> paramWeakReference)
    {
      this.hTm = paramWeakReference;
      Object localObject;
      this.MPJ = localObject;
    }
    
    public final String getName()
    {
      return "Priority.onC2CImgScrollTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87784);
      if (this.hTm.getCreateTime() <= ((PluginPriority)h.az(PluginPriority.class)).getInstallPriorityTime())
      {
        Log.i("MicroMsg.Priority.PriorityService", "onC2CImgScroll time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.hTm.getCreateTime() / 1000L) });
        AppMethodBeat.o(87784);
        return;
      }
      Log.i("MicroMsg.Priority.PriorityService", "C2CImgScrollTask Start To Auto Download %d MsgId %d", new Object[] { Integer.valueOf(32), Long.valueOf(this.hTm.field_msgId) });
      if (this.MPJ.get() != null) {
        ((Runnable)this.MPJ.get()).run();
      }
      ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      com.tencent.mm.plugin.priority.model.c2c.img.b.bl(this.hTm);
      AppMethodBeat.o(87784);
    }
  }
  
  final class g
    extends com.tencent.mm.plugin.priority.model.a.a
  {
    private String MPK;
    private int score;
    
    public g(String paramString, int paramInt)
    {
      this.MPK = paramString;
      this.score = paramInt;
    }
    
    public final String getName()
    {
      return "Priority.C2CMsgConsumeTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(87785);
      if (((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageLogic() != null)
      {
        com.tencent.mm.plugin.priority.model.c2c.a.a locala = ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageLogic();
        String str = this.MPK;
        int i = this.score;
        ((PluginPriority)h.az(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.c2c.a.a.a(locala, str, i, (byte)0));
      }
      AppMethodBeat.o(87785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a
 * JD-Core Version:    0.7.0.1
 */