package com.tencent.mm.pluginsdk.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.sdk.platformtools.aq;
import d.a.ae;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter;", "", "()V", "ENABLE_CHECK_ON_SCREEN", "", "HOST_NAME_MAP", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "REPORT_THREAD_LOOP_TAG", "TAG", "appMsgUrlMap", "isFlinging", "mLoadCountInfo", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "reportInfoMap", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "clearAppMsgUrl", "", "fillReportInfo", "reportInfo", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "finishAction", "action", "", "url", "timestamp", "", "finishAndReport", "getAppMsgKey", "msgId", "msgIndex", "getIdByUrl", "plusImageLoadCount", "reportBlank", "reportImageLoadCountInfo", "resetImageLoadCountInfo", "resumeAll", "retryDownload", "runTask", "runnable", "Ljava/lang/Runnable;", "setAppMsgUrl", "appMsgUrl", "showList", "urlSet", "", "simplifyUrl", "startAction", "startLoad", "item", "Lcom/tencent/mm/message/BizReaderItem;", "cellPosition", "stopAllByFling", "Action", "ActionTimeInfo", "BizImageBlankReportInfo", "ImageLoadCountInfo", "Status", "plugin-biz_release"})
public final class a
{
  static final HashMap<String, b> EKT;
  static final HashMap<String, String> EKU;
  private static c EKV;
  public static boolean EKW;
  private static final HashMap<String, String> EKX;
  public static final a EKY;
  
  static
  {
    AppMethodBeat.i(124821);
    EKY = new a();
    EKT = new HashMap();
    EKU = new HashMap();
    EKV = new c();
    EKX = ae.c(new o[] { u.S("mp.weixin.qq.com", "1"), u.S("mmbiz.qpic.cn", "2"), u.S("vpic.video.qq.com", "3"), u.S("mmbiz.qlogo.cn", "4") });
    AppMethodBeat.o(124821);
  }
  
  public static String aLt(String paramString)
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
      v((Runnable)new k(paramString, paramInt, paramLong));
      AppMethodBeat.o(124815);
      return;
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static void eZl()
  {
    AppMethodBeat.i(124813);
    EKU.clear();
    AppMethodBeat.o(124813);
  }
  
  public static void eZm()
  {
    AppMethodBeat.i(124819);
    h.LTJ.f((Runnable)g.ELv, "biz_image_blank_report");
    AppMethodBeat.o(124819);
  }
  
  public static void m(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(124812);
    p.h(paramString, "appMsgUrl");
    ((Map)EKU).put(ai(paramLong, paramInt), paramString);
    AppMethodBeat.o(124812);
  }
  
  public static void v(Runnable paramRunnable)
  {
    AppMethodBeat.i(124818);
    p.h(paramRunnable, "runnable");
    aq.f(paramRunnable);
    AppMethodBeat.o(124818);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "", "id", "", "action", "", "(Ljava/lang/String;I)V", "getAction", "()I", "setAction", "(I)V", "begin", "", "getBegin", "()J", "setBegin", "(J)V", "end", "getEnd", "setEnd", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "total", "getTotal", "setTotal", "addTime", "", "finish", "timestamp", "isFinished", "", "onResume", "pause", "reset", "resume", "start", "plugin-biz_release"})
  public static final class a
  {
    int action;
    long bpc;
    private long cAI;
    long dyS;
    String id;
    int status;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(124794);
      this.action = -1;
      this.id = "";
      this.dyS = 0L;
      this.cAI = 0L;
      this.bpc = 0L;
      this.status = 0;
      this.id = paramString;
      this.action = paramInt;
      AppMethodBeat.o(124794);
    }
    
    public final void Cy(long paramLong)
    {
      AppMethodBeat.i(124792);
      if ((this.status == 3) || (this.status == 1))
      {
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.BizImageBlankReporter", "alvinluo resume action: %d, id: %s, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Long.valueOf(paramLong) });
        this.status = 2;
        if (paramLong < 0L) {
          break label83;
        }
      }
      for (;;)
      {
        this.cAI = paramLong;
        this.bpc = 0L;
        AppMethodBeat.o(124792);
        return;
        label83:
        paramLong = System.currentTimeMillis();
      }
    }
    
    public final void Cz(long paramLong)
    {
      AppMethodBeat.i(124793);
      if (this.status == 2)
      {
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.BizImageBlankReporter", "alvinluo pause action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Integer.valueOf(this.status), Long.valueOf(paramLong) });
        if (paramLong < 0L) {
          break label84;
        }
      }
      for (;;)
      {
        this.bpc = paramLong;
        eZq();
        this.status = 3;
        AppMethodBeat.o(124793);
        return;
        label84:
        paramLong = System.currentTimeMillis();
      }
    }
    
    final void eZq()
    {
      if (this.bpc >= this.cAI) {
        this.dyS += this.bpc - this.cAI;
      }
    }
    
    public final boolean isFinished()
    {
      return this.status == 4;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "", "url", "", "(Ljava/lang/String;)V", "actionTimePointMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "Lkotlin/collections/HashMap;", "appMsgUrl", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "currentAction", "getCurrentAction", "()I", "setCurrentAction", "(I)V", "downloadSuccess", "", "getDownloadSuccess", "()Z", "setDownloadSuccess", "(Z)V", "hasTask", "getHasTask", "setHasTask", "id", "imageSize", "", "getImageSize", "()J", "setImageSize", "(J)V", "isPausedByScrollFling", "setPausedByScrollFling", "isTaskRunning", "setTaskRunning", "local", "getLocal", "setLocal", "netType", "getNetType", "setNetType", "onScreen", "getOnScreen", "setOnScreen", "position", "getPosition", "setPosition", "resultValid", "retryCount", "getRetryCount", "setRetryCount", "timeFile", "getTimeFile", "setTimeFile", "timeHevc", "getTimeHevc", "setTimeHevc", "timeNet", "getTimeNet", "setTimeNet", "timeScroll", "getTimeScroll", "setTimeScroll", "timeTaskRun", "getTimeTaskRun", "setTimeTaskRun", "timeThread", "getTimeThread", "setTimeThread", "timeTotal", "getTimeTotal", "setTimeTotal", "getUrl", "setUrl", "fillResult", "", "fillTime", "action", "time", "finish", "timestamp", "hide", "isBlank", "isFinished", "isResultValid", "offScreen", "pause", "reset", "resume", "retryDownload", "show", "start", "toString", "plugin-biz_release"})
  public static final class b
  {
    long EKZ;
    long ELa;
    long ELb;
    long ELc;
    long ELd;
    long ELe;
    private long ELf;
    String ELg;
    long ELh;
    boolean ELi;
    boolean ELj;
    boolean ELk;
    boolean ELl;
    boolean ELm;
    HashMap<Integer, a.a> ELn;
    boolean ELo;
    int iDQ;
    String id;
    int position;
    int retryCount;
    String srd;
    boolean tOi;
    String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(124800);
      this.url = "";
      this.ELg = "";
      this.srd = "";
      this.position = -1;
      this.iDQ = -1;
      this.id = "";
      this.ELn = new HashMap();
      this.url = paramString;
      a locala = a.EKY;
      this.id = a.aLt(paramString);
      AppMethodBeat.o(124800);
    }
    
    public final void aL(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124797);
      a.a locala1;
      if (paramInt == 2)
      {
        this.tOi = true;
        this.ELk = true;
        a.a locala2 = (a.a)this.ELn.get(Integer.valueOf(paramInt));
        locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a.a(this.id, paramInt);
          ((Map)this.ELn).put(Integer.valueOf(paramInt), locala1);
        }
        if (locala1.status == 0)
        {
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.BizImageBlankReporter", "alvinluo start action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(locala1.action), locala1.id, Integer.valueOf(locala1.status), Long.valueOf(paramLong) });
          locala1.status = 1;
        }
        if ((paramInt != 1) && (paramInt != 2)) {
          break label187;
        }
        locala1.Cy(paramLong);
      }
      for (;;)
      {
        if (paramInt != 9) {
          this.iDQ = paramInt;
        }
        AppMethodBeat.o(124797);
        return;
        if (paramInt != 9) {
          break;
        }
        this.ELl = true;
        break;
        label187:
        locala1.Cy(paramLong);
      }
    }
    
    public final void aLu(String paramString)
    {
      AppMethodBeat.i(124795);
      p.h(paramString, "<set-?>");
      this.ELg = paramString;
      AppMethodBeat.o(124795);
    }
    
    public final void aM(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124798);
      a.a locala = (a.a)this.ELn.get(Integer.valueOf(paramInt));
      if ((locala != null) && ((locala.status == 2) || (locala.status == 3)))
      {
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.BizImageBlankReporter", "alvinluo finish action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(locala.action), locala.id, Integer.valueOf(locala.status), Long.valueOf(paramLong) });
        if (locala.status == 2) {
          if (paramLong < 0L) {
            break label146;
          }
        }
      }
      for (;;)
      {
        locala.bpc = paramLong;
        locala.eZq();
        locala.status = 4;
        this.iDQ = -1;
        if (paramInt == 9) {
          this.ELl = false;
        }
        AppMethodBeat.o(124798);
        return;
        label146:
        paramLong = System.currentTimeMillis();
      }
    }
    
    final void aN(int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        this.EKZ = paramLong;
        return;
      case 3: 
        this.ELb = paramLong;
        return;
      case 5: 
      case 6: 
      case 7: 
        this.ELa += paramLong;
        return;
      case 4: 
        this.EKZ = paramLong;
        return;
      case 8: 
        this.ELe = paramLong;
        return;
      case 2: 
        this.ELf = paramLong;
        return;
      }
      this.ELc = paramLong;
    }
    
    public final boolean eZr()
    {
      AppMethodBeat.i(124799);
      a.a locala = (a.a)this.ELn.get(Integer.valueOf(1));
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
      Object localObject = d.g.b.ad.MLZ;
      int i = hashCode();
      localObject = a.EKY;
      localObject = String.format("BizImageBlankReportInfo %s {id: %s, timeTotal: %d, timeTaskRun: %d, timeFile: %d, timeNet: %d, timeScroll: %d, timeHevc: %d, timeThread: %d, \nnetType: %s, position: %d, imageSize: %d, retryCount: %d, downloadSuccess: %b, local: %b, \nurl: %s}", Arrays.copyOf(new Object[] { Integer.valueOf(i), a.aLt(this.url), Long.valueOf(this.EKZ), Long.valueOf(this.ELf), Long.valueOf(this.ELa), Long.valueOf(this.ELb), Long.valueOf(this.ELc), Long.valueOf(this.ELd), Long.valueOf(this.ELe), this.srd, Integer.valueOf(this.position), Long.valueOf(this.ELh), Integer.valueOf(this.retryCount), Boolean.valueOf(this.ELi), Boolean.valueOf(this.ELj), this.url }, 16));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(124796);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "", "()V", "fromFileCount", "", "getFromFileCount", "()I", "setFromFileCount", "(I)V", "fromMemoryCount", "getFromMemoryCount", "setFromMemoryCount", "fromNetCount", "getFromNetCount", "setFromNetCount", "totalCount", "getTotalCount", "setTotalCount", "reset", "", "toString", "", "plugin-biz_release"})
  public static final class c
  {
    int ELp;
    int ELq;
    int ELr;
    int fTM;
    
    public final String toString()
    {
      AppMethodBeat.i(124801);
      Object localObject = d.g.b.ad.MLZ;
      localObject = String.format("totalCount: %d, fromNetCount: %d, fromFileCount: %d, fromMemoryCount: %d", Arrays.copyOf(new Object[] { Integer.valueOf(this.fTM), Integer.valueOf(this.ELp), Integer.valueOf(this.ELq), Integer.valueOf(this.ELr) }, 4));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(124801);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124802);
      Object localObject = a.EKY;
      localObject = (a.b)a.eZn().get(this.lby);
      if (localObject != null)
      {
        ((a.b)localObject).aM(this.iBD, this.ELs);
        AppMethodBeat.o(124802);
        return;
      }
      AppMethodBeat.o(124802);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString, long paramLong, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(124803);
      if (((CharSequence)this.lby).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(124803);
        return;
      }
      Object localObject = a.EKY;
      a.b localb = (a.b)a.eZn().get(this.lby);
      if (localb == null)
      {
        AppMethodBeat.o(124803);
        return;
      }
      if (localb.eZr())
      {
        localObject = a.EKY;
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BizImageBlankReporter", "alvinluo finishAndReport id: %s TOTAL is finished", new Object[] { a.aLt(this.lby) });
        localObject = a.EKY;
        a.eZn().remove(this.lby);
        AppMethodBeat.o(124803);
        return;
      }
      localb.aM(1, this.iBG);
      localObject = localb.ELn.keySet();
      p.g(localObject, "actionTimePointMap.keys");
      localObject = ((Iterable)localObject).iterator();
      boolean bool = true;
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        a.a locala = (a.a)localb.ELn.get(localInteger);
        if (locala == null) {
          break label422;
        }
        if (locala.isFinished())
        {
          p.g(localInteger, "action");
          localb.aN(localInteger.intValue(), locala.dyS);
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
          while ((localInteger.intValue() != 9) || (localb.ELk))
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult invalid action: %d, id: %s", new Object[] { localInteger, localb.id });
            bool = false;
            break;
            if ((localInteger.intValue() != 8) || (localb.ELk)) {
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
      localb.ELo = bool;
      bool = localb.ELo;
      localObject = (a.a)localb.ELn.get(Integer.valueOf(1));
      if (localObject != null) {}
      for (localObject = Long.valueOf(((a.a)localObject).dyS);; localObject = null)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult resultValid: %b, timeTotal: %s, id: %s", new Object[] { Boolean.valueOf(bool), localObject, localb.id });
        label422:
        localObject = a.EKY;
        a.eZn().remove(this.lby);
        localObject = a.EKY;
        a.a(localb, this.ELt);
        AppMethodBeat.o(124803);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a.b paramb, b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(124804);
      Object localObject = a.EKY;
      a.b(this.ELu, this.ELt);
      localObject = a.EKY;
      a.a(this.ELt);
      if (this.ELu.ELo)
      {
        localObject = this.ELu;
        long l1 = ((a.b)localObject).ELa;
        long l2 = ((a.b)localObject).ELb;
        long l3 = ((a.b)localObject).ELc;
        if (((a.b)localObject).ELd + (l1 + l2 + l3) < 50L) {
          break label113;
        }
      }
      label113:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject = a.EKY;
          a.a(this.ELu);
        }
        AppMethodBeat.o(124804);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    public static final g ELv;
    
    static
    {
      AppMethodBeat.i(124806);
      ELv = new g();
      AppMethodBeat.o(124806);
    }
    
    public final void run()
    {
      AppMethodBeat.i(124805);
      Object localObject = a.EKY;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizImageBlankReporter", "alvinluo reportImageLoadCountInfo %s", new Object[] { a.eZo() });
      localObject = com.tencent.mm.plugin.report.service.g.yhR;
      a locala = a.EKY;
      int i = a.eZo().fTM;
      locala = a.EKY;
      int j = a.eZo().ELr;
      locala = a.EKY;
      int k = a.eZo().ELq;
      locala = a.EKY;
      ((com.tencent.mm.plugin.report.service.g)localObject).f(17890, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(a.eZo().ELp) });
      localObject = a.EKY;
      a.eZp();
      AppMethodBeat.o(124805);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class h
    implements Runnable
  {
    public h(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124807);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BizImageBlankReporter", "alvinluo resumeAll");
      Object localObject1 = a.EKY;
      a.vC(false);
      localObject1 = a.EKY;
      localObject1 = a.eZn().keySet();
      p.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = a.EKY;
        localObject2 = (a.b)a.eZn().get(str);
        if ((localObject2 != null) && (((a.b)localObject2).ELl))
        {
          a locala = a.EKY;
          p.g(str, "url");
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BizImageBlankReporter", "alvinluo resume Scroll_Fling id: %s", new Object[] { a.aLt(str) });
          ((a.b)localObject2).aM(9, this.iBG);
        }
      }
      AppMethodBeat.o(124807);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class i
    implements Runnable
  {
    public i(String paramString, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124808);
      Object localObject = a.EKY;
      localObject = (a.b)a.eZn().get(this.lby);
      if (localObject != null)
      {
        long l = this.iBG;
        ((a.b)localObject).retryCount += 1;
        a.a locala = (a.a)((a.b)localObject).ELn.get(Integer.valueOf(3));
        if (locala != null)
        {
          if (locala.status == 4)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload force restart id: %s", new Object[] { ((a.b)localObject).id });
            locala.status = 1;
            locala.Cy(l);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class j
    implements Runnable
  {
    public j(Set paramSet, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124809);
      Object localObject1 = ((Iterable)this.ELw).iterator();
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
          localObject3 = a.EKY;
          localObject2 = (a.b)a.eZn().get(localObject2);
          if (localObject2 == null) {
            break;
          }
          l = this.iBG;
          localObject3 = (a.a)((a.b)localObject2).ELn.get(Integer.valueOf(((a.b)localObject2).iDQ));
          if (localObject3 != null) {
            ((a.a)localObject3).Cy(l);
          }
          ((a.b)localObject2).ELm = true;
          if (!((a.b)localObject2).ELl) {
            break;
          }
          localObject2 = (a.a)((a.b)localObject2).ELn.get(Integer.valueOf(9));
          if (localObject2 == null) {
            break;
          }
          ((a.a)localObject2).Cy(l);
          break;
        }
      }
      localObject1 = a.EKY;
      localObject1 = a.eZn().keySet();
      p.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = a.EKY;
        localObject2 = (a.b)a.eZn().get(localObject2);
        if ((localObject2 != null) && (!this.ELw.contains(((a.b)localObject2).url)))
        {
          l = this.iBG;
          localObject3 = (a.a)((a.b)localObject2).ELn.get(Integer.valueOf(((a.b)localObject2).iDQ));
          if (localObject3 != null) {
            ((a.a)localObject3).Cz(l);
          }
          ((a.b)localObject2).ELm = false;
          if (((a.b)localObject2).ELl)
          {
            localObject2 = (a.a)((a.b)localObject2).ELn.get(Integer.valueOf(9));
            if (localObject2 != null) {
              ((a.a)localObject2).Cz(l);
            }
          }
        }
      }
      AppMethodBeat.o(124809);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124810);
      Object localObject1 = a.EKY;
      Object localObject2 = (a.b)a.eZn().get(this.lby);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a.b(this.lby);
        localObject2 = a.EKY;
        ((Map)a.eZn()).put(this.lby, localObject1);
      }
      ((a.b)localObject1).aL(paramInt, paramLong);
      AppMethodBeat.o(124810);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class l
    implements Runnable
  {
    public l(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124811);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling");
      Object localObject1 = a.EKY;
      a.vC(true);
      localObject1 = a.EKY;
      localObject1 = a.eZn().keySet();
      p.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        a locala = a.EKY;
        localObject2 = (a.b)a.eZn().get(localObject2);
        if ((localObject2 != null) && (!((a.b)localObject2).tOi) && (!((a.b)localObject2).eZr()))
        {
          locala = a.EKY;
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling task not running and start SCROLL_FLING id: %s, %s", new Object[] { a.aLt(((a.b)localObject2).url), ((a.b)localObject2).url });
          ((a.b)localObject2).aL(9, this.iBG);
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