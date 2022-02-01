package com.tencent.mm.pluginsdk.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.n.d;
import d.o;
import d.u;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter;", "", "()V", "ENABLE_CHECK_ON_SCREEN", "", "HOST_NAME_MAP", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "REPORT_THREAD_LOOP_TAG", "TAG", "appMsgUrlMap", "isFlinging", "mLoadCountInfo", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "reportInfoMap", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "clearAppMsgUrl", "", "fillReportInfo", "reportInfo", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "finishAction", "action", "", "url", "timestamp", "", "finishAndReport", "getAppMsgKey", "msgId", "msgIndex", "getIdByUrl", "plusImageLoadCount", "reportBlank", "reportImageLoadCountInfo", "resetImageLoadCountInfo", "resumeAll", "retryDownload", "runTask", "runnable", "Ljava/lang/Runnable;", "setAppMsgUrl", "appMsgUrl", "showList", "urlSet", "", "simplifyUrl", "startAction", "startLoad", "item", "Lcom/tencent/mm/message/BizReaderItem;", "cellPosition", "stopAllByFling", "Action", "ActionTimeInfo", "BizImageBlankReportInfo", "ImageLoadCountInfo", "Status", "plugin-biz_release"})
public final class a
{
  static final HashMap<String, b> Fdr;
  static final HashMap<String, String> Fds;
  private static c Fdt;
  public static boolean Fdu;
  private static final HashMap<String, String> Fdv;
  public static final a Fdw;
  
  static
  {
    AppMethodBeat.i(124821);
    Fdw = new a();
    Fdr = new HashMap();
    Fds = new HashMap();
    Fdt = new c();
    Fdv = d.a.ae.c(new o[] { u.R("mp.weixin.qq.com", "1"), u.R("mmbiz.qpic.cn", "2"), u.R("vpic.video.qq.com", "3"), u.R("mmbiz.qlogo.cn", "4") });
    AppMethodBeat.o(124821);
  }
  
  public static String aMP(String paramString)
  {
    AppMethodBeat.i(124820);
    p.h(paramString, "url");
    paramString = paramString.getBytes(d.UTF_8);
    p.g(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = com.tencent.mm.b.g.getMessageDigest(paramString);
    p.g(paramString, "MD5.getMessageDigest(url.toByteArray())");
    AppMethodBeat.o(124820);
    return paramString;
  }
  
  static String ai(long paramLong, int paramInt)
  {
    AppMethodBeat.i(124814);
    String str = String.valueOf(paramLong) + "," + String.valueOf(paramInt);
    AppMethodBeat.o(124814);
    return str;
  }
  
  public static void d(final int paramInt, String paramString, final long paramLong)
  {
    AppMethodBeat.i(124815);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(124815);
      return;
    }
    if (paramLong != 0L) {}
    for (;;)
    {
      t((Runnable)new k(paramString, paramInt, paramLong));
      AppMethodBeat.o(124815);
      return;
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static void fcZ()
  {
    AppMethodBeat.i(124813);
    Fds.clear();
    AppMethodBeat.o(124813);
  }
  
  public static void fda()
  {
    AppMethodBeat.i(124819);
    h.MqF.f((Runnable)g.FdT, "biz_image_blank_report");
    AppMethodBeat.o(124819);
  }
  
  public static void l(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(124812);
    p.h(paramString, "appMsgUrl");
    ((Map)Fds).put(ai(paramLong, paramInt), paramString);
    AppMethodBeat.o(124812);
  }
  
  public static void t(Runnable paramRunnable)
  {
    AppMethodBeat.i(124818);
    p.h(paramRunnable, "runnable");
    ar.f(paramRunnable);
    AppMethodBeat.o(124818);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "", "id", "", "action", "", "(Ljava/lang/String;I)V", "getAction", "()I", "setAction", "(I)V", "begin", "", "getBegin", "()J", "setBegin", "(J)V", "end", "getEnd", "setEnd", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "total", "getTotal", "setTotal", "addTime", "", "finish", "timestamp", "isFinished", "", "onResume", "pause", "reset", "resume", "start", "plugin-biz_release"})
  public static final class a
  {
    int action;
    long bpc;
    private long cBp;
    long dzX;
    String id;
    int status;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(124794);
      this.action = -1;
      this.id = "";
      this.dzX = 0L;
      this.cBp = 0L;
      this.bpc = 0L;
      this.status = 0;
      this.id = paramString;
      this.action = paramInt;
      AppMethodBeat.o(124794);
    }
    
    public final void CW(long paramLong)
    {
      AppMethodBeat.i(124792);
      if ((this.status == 3) || (this.status == 1))
      {
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BizImageBlankReporter", "alvinluo resume action: %d, id: %s, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Long.valueOf(paramLong) });
        this.status = 2;
        if (paramLong < 0L) {
          break label83;
        }
      }
      for (;;)
      {
        this.cBp = paramLong;
        this.bpc = 0L;
        AppMethodBeat.o(124792);
        return;
        label83:
        paramLong = System.currentTimeMillis();
      }
    }
    
    public final void CX(long paramLong)
    {
      AppMethodBeat.i(124793);
      if (this.status == 2)
      {
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BizImageBlankReporter", "alvinluo pause action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Integer.valueOf(this.status), Long.valueOf(paramLong) });
        if (paramLong < 0L) {
          break label84;
        }
      }
      for (;;)
      {
        this.bpc = paramLong;
        fde();
        this.status = 3;
        AppMethodBeat.o(124793);
        return;
        label84:
        paramLong = System.currentTimeMillis();
      }
    }
    
    final void fde()
    {
      if (this.bpc >= this.cBp) {
        this.dzX += this.bpc - this.cBp;
      }
    }
    
    public final boolean isFinished()
    {
      return this.status == 4;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "", "url", "", "(Ljava/lang/String;)V", "actionTimePointMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "Lkotlin/collections/HashMap;", "appMsgUrl", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "currentAction", "getCurrentAction", "()I", "setCurrentAction", "(I)V", "downloadSuccess", "", "getDownloadSuccess", "()Z", "setDownloadSuccess", "(Z)V", "hasTask", "getHasTask", "setHasTask", "id", "imageSize", "", "getImageSize", "()J", "setImageSize", "(J)V", "isPausedByScrollFling", "setPausedByScrollFling", "isTaskRunning", "setTaskRunning", "local", "getLocal", "setLocal", "netType", "getNetType", "setNetType", "onScreen", "getOnScreen", "setOnScreen", "position", "getPosition", "setPosition", "resultValid", "retryCount", "getRetryCount", "setRetryCount", "timeFile", "getTimeFile", "setTimeFile", "timeHevc", "getTimeHevc", "setTimeHevc", "timeNet", "getTimeNet", "setTimeNet", "timeScroll", "getTimeScroll", "setTimeScroll", "timeTaskRun", "getTimeTaskRun", "setTimeTaskRun", "timeThread", "getTimeThread", "setTimeThread", "timeTotal", "getTimeTotal", "setTimeTotal", "getUrl", "setUrl", "fillResult", "", "fillTime", "action", "time", "finish", "timestamp", "hide", "isBlank", "isFinished", "isResultValid", "offScreen", "pause", "reset", "resume", "retryDownload", "show", "start", "toString", "plugin-biz_release"})
  public static final class b
  {
    long FdA;
    long FdB;
    long FdC;
    private long FdD;
    String FdE;
    long FdF;
    boolean FdG;
    boolean FdH;
    boolean FdI;
    boolean FdJ;
    boolean FdK;
    HashMap<Integer, a.a> FdL;
    boolean FdM;
    long Fdx;
    long Fdy;
    long Fdz;
    int iGJ;
    String id;
    int position;
    int retryCount;
    String sBn;
    boolean tYZ;
    String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(124800);
      this.url = "";
      this.FdE = "";
      this.sBn = "";
      this.position = -1;
      this.iGJ = -1;
      this.id = "";
      this.FdL = new HashMap();
      this.url = paramString;
      a locala = a.Fdw;
      this.id = a.aMP(paramString);
      AppMethodBeat.o(124800);
    }
    
    public final void aL(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124797);
      a.a locala1;
      if (paramInt == 2)
      {
        this.tYZ = true;
        this.FdI = true;
        a.a locala2 = (a.a)this.FdL.get(Integer.valueOf(paramInt));
        locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a.a(this.id, paramInt);
          ((Map)this.FdL).put(Integer.valueOf(paramInt), locala1);
        }
        if (locala1.status == 0)
        {
          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BizImageBlankReporter", "alvinluo start action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(locala1.action), locala1.id, Integer.valueOf(locala1.status), Long.valueOf(paramLong) });
          locala1.status = 1;
        }
        if ((paramInt != 1) && (paramInt != 2)) {
          break label187;
        }
        locala1.CW(paramLong);
      }
      for (;;)
      {
        if (paramInt != 9) {
          this.iGJ = paramInt;
        }
        AppMethodBeat.o(124797);
        return;
        if (paramInt != 9) {
          break;
        }
        this.FdJ = true;
        break;
        label187:
        locala1.CW(paramLong);
      }
    }
    
    public final void aM(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124798);
      a.a locala = (a.a)this.FdL.get(Integer.valueOf(paramInt));
      if ((locala != null) && ((locala.status == 2) || (locala.status == 3)))
      {
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BizImageBlankReporter", "alvinluo finish action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(locala.action), locala.id, Integer.valueOf(locala.status), Long.valueOf(paramLong) });
        if (locala.status == 2) {
          if (paramLong < 0L) {
            break label146;
          }
        }
      }
      for (;;)
      {
        locala.bpc = paramLong;
        locala.fde();
        locala.status = 4;
        this.iGJ = -1;
        if (paramInt == 9) {
          this.FdJ = false;
        }
        AppMethodBeat.o(124798);
        return;
        label146:
        paramLong = System.currentTimeMillis();
      }
    }
    
    public final void aMQ(String paramString)
    {
      AppMethodBeat.i(124795);
      p.h(paramString, "<set-?>");
      this.FdE = paramString;
      AppMethodBeat.o(124795);
    }
    
    final void aN(int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        this.Fdx = paramLong;
        return;
      case 3: 
        this.Fdz = paramLong;
        return;
      case 5: 
      case 6: 
      case 7: 
        this.Fdy += paramLong;
        return;
      case 4: 
        this.Fdx = paramLong;
        return;
      case 8: 
        this.FdC = paramLong;
        return;
      case 2: 
        this.FdD = paramLong;
        return;
      }
      this.FdA = paramLong;
    }
    
    public final boolean fdf()
    {
      AppMethodBeat.i(124799);
      a.a locala = (a.a)this.FdL.get(Integer.valueOf(1));
      if (locala != null)
      {
        boolean bool = locala.isFinished();
        AppMethodBeat.o(124799);
        return bool;
      }
      AppMethodBeat.o(124799);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(124796);
      Object localObject = ad.Njc;
      int i = hashCode();
      localObject = a.Fdw;
      localObject = String.format("BizImageBlankReportInfo %s {id: %s, timeTotal: %d, timeTaskRun: %d, timeFile: %d, timeNet: %d, timeScroll: %d, timeHevc: %d, timeThread: %d, \nnetType: %s, position: %d, imageSize: %d, retryCount: %d, downloadSuccess: %b, local: %b, \nurl: %s}", Arrays.copyOf(new Object[] { Integer.valueOf(i), a.aMP(this.url), Long.valueOf(this.Fdx), Long.valueOf(this.FdD), Long.valueOf(this.Fdy), Long.valueOf(this.Fdz), Long.valueOf(this.FdA), Long.valueOf(this.FdB), Long.valueOf(this.FdC), this.sBn, Integer.valueOf(this.position), Long.valueOf(this.FdF), Integer.valueOf(this.retryCount), Boolean.valueOf(this.FdG), Boolean.valueOf(this.FdH), this.url }, 16));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(124796);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "", "()V", "fromFileCount", "", "getFromFileCount", "()I", "setFromFileCount", "(I)V", "fromMemoryCount", "getFromMemoryCount", "setFromMemoryCount", "fromNetCount", "getFromNetCount", "setFromNetCount", "totalCount", "getTotalCount", "setTotalCount", "reset", "", "toString", "", "plugin-biz_release"})
  public static final class c
  {
    int FdN;
    int FdO;
    int FdP;
    int fVS;
    
    public final String toString()
    {
      AppMethodBeat.i(124801);
      Object localObject = ad.Njc;
      localObject = String.format("totalCount: %d, fromNetCount: %d, fromFileCount: %d, fromMemoryCount: %d", Arrays.copyOf(new Object[] { Integer.valueOf(this.fVS), Integer.valueOf(this.FdN), Integer.valueOf(this.FdO), Integer.valueOf(this.FdP) }, 4));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(124801);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124802);
      Object localObject = a.Fdw;
      localObject = (a.b)a.fdb().get(this.lfj);
      if (localObject != null)
      {
        ((a.b)localObject).aM(this.iEw, this.FdQ);
        AppMethodBeat.o(124802);
        return;
      }
      AppMethodBeat.o(124802);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString, long paramLong, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(124803);
      if (((CharSequence)this.lfj).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(124803);
        return;
      }
      Object localObject = a.Fdw;
      a.b localb = (a.b)a.fdb().get(this.lfj);
      if (localb == null)
      {
        AppMethodBeat.o(124803);
        return;
      }
      if (localb.fdf())
      {
        localObject = a.Fdw;
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BizImageBlankReporter", "alvinluo finishAndReport id: %s TOTAL is finished", new Object[] { a.aMP(this.lfj) });
        localObject = a.Fdw;
        a.fdb().remove(this.lfj);
        AppMethodBeat.o(124803);
        return;
      }
      localb.aM(1, this.iEz);
      localObject = localb.FdL.keySet();
      p.g(localObject, "actionTimePointMap.keys");
      localObject = ((Iterable)localObject).iterator();
      boolean bool = true;
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        a.a locala = (a.a)localb.FdL.get(localInteger);
        if (locala == null) {
          break label422;
        }
        if (locala.isFinished())
        {
          p.g(localInteger, "action");
          localb.aN(localInteger.intValue(), locala.dzX);
        }
        else
        {
          if (localInteger == null) {
            label236:
            if (localInteger != null) {
              break label311;
            }
          }
          label311:
          while ((localInteger.intValue() != 9) || (localb.FdI))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult invalid action: %d, id: %s", new Object[] { localInteger, localb.id });
            bool = false;
            break;
            if ((localInteger.intValue() != 8) || (localb.FdI)) {
              break label236;
            }
            p.g(localInteger, "action");
            localb.aN(localInteger.intValue(), 0L);
            bool = true;
            break;
          }
          p.g(localInteger, "action");
          localb.aN(localInteger.intValue(), 0L);
          bool = true;
        }
      }
      localb.FdM = bool;
      bool = localb.FdM;
      localObject = (a.a)localb.FdL.get(Integer.valueOf(1));
      if (localObject != null) {}
      for (localObject = Long.valueOf(((a.a)localObject).dzX);; localObject = null)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult resultValid: %b, timeTotal: %s, id: %s", new Object[] { Boolean.valueOf(bool), localObject, localb.id });
        label422:
        localObject = a.Fdw;
        a.fdb().remove(this.lfj);
        localObject = a.Fdw;
        a.a(localb, this.FdR);
        AppMethodBeat.o(124803);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a.b paramb, b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(124804);
      Object localObject = a.Fdw;
      a.b(this.FdS, this.FdR);
      localObject = a.Fdw;
      a.a(this.FdR);
      if (this.FdS.FdM)
      {
        localObject = this.FdS;
        long l1 = ((a.b)localObject).Fdy;
        long l2 = ((a.b)localObject).Fdz;
        long l3 = ((a.b)localObject).FdA;
        if (((a.b)localObject).FdB + (l1 + l2 + l3) < 50L) {
          break label113;
        }
      }
      label113:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject = a.Fdw;
          a.a(this.FdS);
        }
        AppMethodBeat.o(124804);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    public static final g FdT;
    
    static
    {
      AppMethodBeat.i(124806);
      FdT = new g();
      AppMethodBeat.o(124806);
    }
    
    public final void run()
    {
      AppMethodBeat.i(124805);
      Object localObject = a.Fdw;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizImageBlankReporter", "alvinluo reportImageLoadCountInfo %s", new Object[] { a.fdc() });
      localObject = com.tencent.mm.plugin.report.service.g.yxI;
      a locala = a.Fdw;
      int i = a.fdc().fVS;
      locala = a.Fdw;
      int j = a.fdc().FdP;
      locala = a.Fdw;
      int k = a.fdc().FdO;
      locala = a.Fdw;
      ((com.tencent.mm.plugin.report.service.g)localObject).f(17890, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(a.fdc().FdN) });
      localObject = a.Fdw;
      a.fdd();
      AppMethodBeat.o(124805);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class h
    implements Runnable
  {
    public h(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124807);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BizImageBlankReporter", "alvinluo resumeAll");
      Object localObject1 = a.Fdw;
      a.vK(false);
      localObject1 = a.Fdw;
      localObject1 = a.fdb().keySet();
      p.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = a.Fdw;
        localObject2 = (a.b)a.fdb().get(str);
        if ((localObject2 != null) && (((a.b)localObject2).FdJ))
        {
          a locala = a.Fdw;
          p.g(str, "url");
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BizImageBlankReporter", "alvinluo resume Scroll_Fling id: %s", new Object[] { a.aMP(str) });
          ((a.b)localObject2).aM(9, this.iEz);
        }
      }
      AppMethodBeat.o(124807);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class i
    implements Runnable
  {
    public i(String paramString, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124808);
      Object localObject = a.Fdw;
      localObject = (a.b)a.fdb().get(this.lfj);
      if (localObject != null)
      {
        long l = this.iEz;
        ((a.b)localObject).retryCount += 1;
        a.a locala = (a.a)((a.b)localObject).FdL.get(Integer.valueOf(3));
        if (locala != null)
        {
          if (locala.status == 4)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload force restart id: %s", new Object[] { ((a.b)localObject).id });
            locala.status = 1;
            locala.CW(l);
          }
          AppMethodBeat.o(124808);
          return;
        }
        AppMethodBeat.o(124808);
        return;
      }
      AppMethodBeat.o(124808);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class j
    implements Runnable
  {
    public j(Set paramSet, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124809);
      Object localObject1 = ((Iterable)this.FdU).iterator();
      Object localObject2;
      Object localObject3;
      long l;
      label169:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((CharSequence)localObject2).length() == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label169;
          }
          localObject3 = a.Fdw;
          localObject2 = (a.b)a.fdb().get(localObject2);
          if (localObject2 == null) {
            break;
          }
          l = this.iEz;
          localObject3 = (a.a)((a.b)localObject2).FdL.get(Integer.valueOf(((a.b)localObject2).iGJ));
          if (localObject3 != null) {
            ((a.a)localObject3).CW(l);
          }
          ((a.b)localObject2).FdK = true;
          if (!((a.b)localObject2).FdJ) {
            break;
          }
          localObject2 = (a.a)((a.b)localObject2).FdL.get(Integer.valueOf(9));
          if (localObject2 == null) {
            break;
          }
          ((a.a)localObject2).CW(l);
          break;
        }
      }
      localObject1 = a.Fdw;
      localObject1 = a.fdb().keySet();
      p.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = a.Fdw;
        localObject2 = (a.b)a.fdb().get(localObject2);
        if ((localObject2 != null) && (!this.FdU.contains(((a.b)localObject2).url)))
        {
          l = this.iEz;
          localObject3 = (a.a)((a.b)localObject2).FdL.get(Integer.valueOf(((a.b)localObject2).iGJ));
          if (localObject3 != null) {
            ((a.a)localObject3).CX(l);
          }
          ((a.b)localObject2).FdK = false;
          if (((a.b)localObject2).FdJ)
          {
            localObject2 = (a.a)((a.b)localObject2).FdL.get(Integer.valueOf(9));
            if (localObject2 != null) {
              ((a.a)localObject2).CX(l);
            }
          }
        }
      }
      AppMethodBeat.o(124809);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124810);
      Object localObject1 = a.Fdw;
      Object localObject2 = (a.b)a.fdb().get(this.lfj);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a.b(this.lfj);
        localObject2 = a.Fdw;
        ((Map)a.fdb()).put(this.lfj, localObject1);
      }
      ((a.b)localObject1).aL(paramInt, paramLong);
      AppMethodBeat.o(124810);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class l
    implements Runnable
  {
    public l(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124811);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling");
      Object localObject1 = a.Fdw;
      a.vK(true);
      localObject1 = a.Fdw;
      localObject1 = a.fdb().keySet();
      p.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        a locala = a.Fdw;
        localObject2 = (a.b)a.fdb().get(localObject2);
        if ((localObject2 != null) && (!((a.b)localObject2).tYZ) && (!((a.b)localObject2).fdf()))
        {
          locala = a.Fdw;
          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling task not running and start SCROLL_FLING id: %s, %s", new Object[] { a.aMP(((a.b)localObject2).url), ((a.b)localObject2).url });
          ((a.b)localObject2).aL(9, this.iEz);
        }
      }
      AppMethodBeat.o(124811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a
 * JD-Core Version:    0.7.0.1
 */