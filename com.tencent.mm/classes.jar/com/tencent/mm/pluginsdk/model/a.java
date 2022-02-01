package com.tencent.mm.pluginsdk.model;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.o;
import kotlin.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter;", "", "()V", "ENABLE_CHECK_ON_SCREEN", "", "HOST_NAME_MAP", "Ljava/util/HashMap;", "", "kotlin.jvm.PlatformType", "Lkotlin/collections/HashMap;", "REPORT_THREAD_LOOP_TAG", "TAG", "appMsgUrlMap", "isFlinging", "mLoadCountInfo", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "reportInfoMap", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "clearAppMsgUrl", "", "fillReportInfo", "reportInfo", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "finishAction", "action", "", "url", "timestamp", "", "finishAndReport", "getAppMsgKey", "msgId", "msgIndex", "getIdByUrl", "plusImageLoadCount", "reportBlank", "reportImageLoadCountInfo", "resetImageLoadCountInfo", "resumeAll", "retryDownload", "runTask", "runnable", "Ljava/lang/Runnable;", "setAppMsgUrl", "appMsgUrl", "showList", "urlSet", "", "simplifyUrl", "startAction", "startLoad", "item", "Lcom/tencent/mm/message/BizReaderItem;", "cellPosition", "stopAllByFling", "Action", "ActionTimeInfo", "BizImageBlankReportInfo", "ImageLoadCountInfo", "Status", "plugin-biz_release"})
public final class a
{
  static final HashMap<String, b> AbY;
  static final HashMap<String, String> JUh;
  private static c JUi;
  public static boolean JUj;
  private static final HashMap<String, String> JUk;
  public static final a JUl;
  
  static
  {
    AppMethodBeat.i(124821);
    JUl = new a();
    AbY = new HashMap();
    JUh = new HashMap();
    JUi = new c();
    JUk = kotlin.a.ae.g(new o[] { s.U(WeChatHosts.domainString(2131761726), "1"), s.U("mmbiz.qpic.cn", "2"), s.U("vpic.video.qq.com", "3"), s.U("mmbiz.qlogo.cn", "4") });
    AppMethodBeat.o(124821);
  }
  
  static String al(long paramLong, int paramInt)
  {
    AppMethodBeat.i(124814);
    String str = String.valueOf(paramLong) + "," + String.valueOf(paramInt);
    AppMethodBeat.o(124814);
    return str;
  }
  
  public static String bdl(String paramString)
  {
    AppMethodBeat.i(124820);
    p.h(paramString, "url");
    paramString = paramString.getBytes(d.UTF_8);
    p.g(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = g.getMessageDigest(paramString);
    p.g(paramString, "MD5.getMessageDigest(url.toByteArray())");
    AppMethodBeat.o(124820);
    return paramString;
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
  
  public static void gmj()
  {
    AppMethodBeat.i(124813);
    JUh.clear();
    AppMethodBeat.o(124813);
  }
  
  public static void gmk()
  {
    AppMethodBeat.i(124819);
    com.tencent.f.h.RTc.b((Runnable)g.JUH, "biz_image_blank_report");
    AppMethodBeat.o(124819);
  }
  
  public static void n(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(124812);
    p.h(paramString, "appMsgUrl");
    ((Map)JUh).put(al(paramLong, paramInt), paramString);
    AppMethodBeat.o(124812);
  }
  
  public static void v(Runnable paramRunnable)
  {
    AppMethodBeat.i(124818);
    p.h(paramRunnable, "runnable");
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(124818);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "", "id", "", "action", "", "(Ljava/lang/String;I)V", "getAction", "()I", "setAction", "(I)V", "begin", "", "getBegin", "()J", "setBegin", "(J)V", "end", "getEnd", "setEnd", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "total", "getTotal", "setTotal", "addTime", "", "finish", "timestamp", "isFinished", "", "onResume", "pause", "reset", "resume", "start", "plugin-biz_release"})
  public static final class a
  {
    int action;
    private long begin;
    long boX;
    String id;
    int status;
    long total;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(124794);
      this.action = -1;
      this.id = "";
      this.total = 0L;
      this.begin = 0L;
      this.boX = 0L;
      this.status = 0;
      this.id = paramString;
      this.action = paramInt;
      AppMethodBeat.o(124794);
    }
    
    public final void Mm(long paramLong)
    {
      AppMethodBeat.i(124792);
      if ((this.status == 3) || (this.status == 1))
      {
        Log.v("MicroMsg.BizImageBlankReporter", "alvinluo resume action: %d, id: %s, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Long.valueOf(paramLong) });
        this.status = 2;
        if (paramLong < 0L) {
          break label83;
        }
      }
      for (;;)
      {
        this.begin = paramLong;
        this.boX = 0L;
        AppMethodBeat.o(124792);
        return;
        label83:
        paramLong = System.currentTimeMillis();
      }
    }
    
    public final void Mn(long paramLong)
    {
      AppMethodBeat.i(124793);
      if (this.status == 2)
      {
        Log.v("MicroMsg.BizImageBlankReporter", "alvinluo pause action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Integer.valueOf(this.status), Long.valueOf(paramLong) });
        if (paramLong < 0L) {
          break label84;
        }
      }
      for (;;)
      {
        this.boX = paramLong;
        gmo();
        this.status = 3;
        AppMethodBeat.o(124793);
        return;
        label84:
        paramLong = System.currentTimeMillis();
      }
    }
    
    final void gmo()
    {
      if (this.boX >= this.begin) {
        this.total += this.boX - this.begin;
      }
    }
    
    public final boolean isFinished()
    {
      return this.status == 4;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "", "url", "", "(Ljava/lang/String;)V", "actionTimePointMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "Lkotlin/collections/HashMap;", "appMsgUrl", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "currentAction", "getCurrentAction", "()I", "setCurrentAction", "(I)V", "downloadSuccess", "", "getDownloadSuccess", "()Z", "setDownloadSuccess", "(Z)V", "hasTask", "getHasTask", "setHasTask", "id", "imageSize", "", "getImageSize", "()J", "setImageSize", "(J)V", "isPausedByScrollFling", "setPausedByScrollFling", "isTaskRunning", "setTaskRunning", "local", "getLocal", "setLocal", "netType", "getNetType", "setNetType", "onScreen", "getOnScreen", "setOnScreen", "position", "getPosition", "setPosition", "resultValid", "retryCount", "getRetryCount", "setRetryCount", "timeFile", "getTimeFile", "setTimeFile", "timeHevc", "getTimeHevc", "setTimeHevc", "timeNet", "getTimeNet", "setTimeNet", "timeScroll", "getTimeScroll", "setTimeScroll", "timeTaskRun", "getTimeTaskRun", "setTimeTaskRun", "timeThread", "getTimeThread", "setTimeThread", "timeTotal", "getTimeTotal", "setTimeTotal", "getUrl", "setUrl", "fillResult", "", "fillTime", "action", "time", "finish", "timestamp", "hide", "isBlank", "isFinished", "isResultValid", "offScreen", "pause", "reset", "resume", "retryDownload", "show", "start", "toString", "plugin-biz_release"})
  public static final class b
  {
    boolean BPb;
    boolean JUA;
    long JUm;
    long JUn;
    long JUo;
    long JUp;
    long JUq;
    long JUr;
    private long JUs;
    String JUt;
    long JUu;
    boolean JUv;
    boolean JUw;
    boolean JUx;
    boolean JUy;
    HashMap<Integer, a.a> JUz;
    String id;
    int jCM;
    int position;
    int retryCount;
    String url;
    String wib;
    boolean xqn;
    
    public b(String paramString)
    {
      AppMethodBeat.i(124800);
      this.url = "";
      this.JUt = "";
      this.wib = "";
      this.position = -1;
      this.jCM = -1;
      this.id = "";
      this.JUz = new HashMap();
      this.url = paramString;
      a locala = a.JUl;
      this.id = a.bdl(paramString);
      AppMethodBeat.o(124800);
    }
    
    public final void aQ(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124797);
      a.a locala1;
      if (paramInt == 2)
      {
        this.xqn = true;
        this.JUw = true;
        a.a locala2 = (a.a)this.JUz.get(Integer.valueOf(paramInt));
        locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a.a(this.id, paramInt);
          ((Map)this.JUz).put(Integer.valueOf(paramInt), locala1);
        }
        if (locala1.status == 0)
        {
          Log.v("MicroMsg.BizImageBlankReporter", "alvinluo start action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(locala1.action), locala1.id, Integer.valueOf(locala1.status), Long.valueOf(paramLong) });
          locala1.status = 1;
        }
        if ((paramInt != 1) && (paramInt != 2)) {
          break label187;
        }
        locala1.Mm(paramLong);
      }
      for (;;)
      {
        if (paramInt != 9) {
          this.jCM = paramInt;
        }
        AppMethodBeat.o(124797);
        return;
        if (paramInt != 9) {
          break;
        }
        this.JUx = true;
        break;
        label187:
        locala1.Mm(paramLong);
      }
    }
    
    public final void aR(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124798);
      a.a locala = (a.a)this.JUz.get(Integer.valueOf(paramInt));
      if ((locala != null) && ((locala.status == 2) || (locala.status == 3)))
      {
        Log.v("MicroMsg.BizImageBlankReporter", "alvinluo finish action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(locala.action), locala.id, Integer.valueOf(locala.status), Long.valueOf(paramLong) });
        if (locala.status == 2) {
          if (paramLong < 0L) {
            break label146;
          }
        }
      }
      for (;;)
      {
        locala.boX = paramLong;
        locala.gmo();
        locala.status = 4;
        this.jCM = -1;
        if (paramInt == 9) {
          this.JUx = false;
        }
        AppMethodBeat.o(124798);
        return;
        label146:
        paramLong = System.currentTimeMillis();
      }
    }
    
    final void aS(int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        this.JUm = paramLong;
        return;
      case 3: 
        this.JUo = paramLong;
        return;
      case 5: 
      case 6: 
      case 7: 
        this.JUn += paramLong;
        return;
      case 4: 
        this.JUm = paramLong;
        return;
      case 8: 
        this.JUr = paramLong;
        return;
      case 2: 
        this.JUs = paramLong;
        return;
      }
      this.JUp = paramLong;
    }
    
    public final void bdm(String paramString)
    {
      AppMethodBeat.i(124795);
      p.h(paramString, "<set-?>");
      this.JUt = paramString;
      AppMethodBeat.o(124795);
    }
    
    public final boolean gmp()
    {
      AppMethodBeat.i(124799);
      a.a locala = (a.a)this.JUz.get(Integer.valueOf(1));
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
      Object localObject = kotlin.g.b.ae.SYK;
      int i = hashCode();
      localObject = a.JUl;
      localObject = String.format("BizImageBlankReportInfo %s {id: %s, timeTotal: %d, timeTaskRun: %d, timeFile: %d, timeNet: %d, timeScroll: %d, timeHevc: %d, timeThread: %d, \nnetType: %s, position: %d, imageSize: %d, retryCount: %d, downloadSuccess: %b, local: %b, \nurl: %s}", Arrays.copyOf(new Object[] { Integer.valueOf(i), a.bdl(this.url), Long.valueOf(this.JUm), Long.valueOf(this.JUs), Long.valueOf(this.JUn), Long.valueOf(this.JUo), Long.valueOf(this.JUp), Long.valueOf(this.JUq), Long.valueOf(this.JUr), this.wib, Integer.valueOf(this.position), Long.valueOf(this.JUu), Integer.valueOf(this.retryCount), Boolean.valueOf(this.JUv), Boolean.valueOf(this.BPb), this.url }, 16));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(124796);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "", "()V", "fromFileCount", "", "getFromFileCount", "()I", "setFromFileCount", "(I)V", "fromMemoryCount", "getFromMemoryCount", "setFromMemoryCount", "fromNetCount", "getFromNetCount", "setFromNetCount", "totalCount", "getTotalCount", "setTotalCount", "reset", "", "toString", "", "plugin-biz_release"})
  public static final class c
  {
    int JUB;
    int JUC;
    int JUD;
    int gAZ;
    
    public final String toString()
    {
      AppMethodBeat.i(124801);
      Object localObject = kotlin.g.b.ae.SYK;
      localObject = String.format("totalCount: %d, fromNetCount: %d, fromFileCount: %d, fromMemoryCount: %d", Arrays.copyOf(new Object[] { Integer.valueOf(this.gAZ), Integer.valueOf(this.JUB), Integer.valueOf(this.JUC), Integer.valueOf(this.JUD) }, 4));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(124801);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124802);
      Object localObject = a.JUl;
      localObject = (a.b)a.gml().get(this.mkH);
      if (localObject != null)
      {
        ((a.b)localObject).aR(this.jAd, this.JUE);
        AppMethodBeat.o(124802);
        return;
      }
      AppMethodBeat.o(124802);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString, long paramLong, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(124803);
      if (((CharSequence)this.mkH).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(124803);
        return;
      }
      Object localObject = a.JUl;
      a.b localb = (a.b)a.gml().get(this.mkH);
      if (localb == null)
      {
        AppMethodBeat.o(124803);
        return;
      }
      if (localb.gmp())
      {
        localObject = a.JUl;
        Log.w("MicroMsg.BizImageBlankReporter", "alvinluo finishAndReport id: %s TOTAL is finished", new Object[] { a.bdl(this.mkH) });
        localObject = a.JUl;
        a.gml().remove(this.mkH);
        AppMethodBeat.o(124803);
        return;
      }
      localb.aR(1, this.kPc);
      localObject = localb.JUz.keySet();
      p.g(localObject, "actionTimePointMap.keys");
      localObject = ((Iterable)localObject).iterator();
      boolean bool = true;
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        a.a locala = (a.a)localb.JUz.get(localInteger);
        if (locala == null) {
          break label422;
        }
        if (locala.isFinished())
        {
          p.g(localInteger, "action");
          localb.aS(localInteger.intValue(), locala.total);
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
          while ((localInteger.intValue() != 9) || (localb.JUw))
          {
            Log.e("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult invalid action: %d, id: %s", new Object[] { localInteger, localb.id });
            bool = false;
            break;
            if ((localInteger.intValue() != 8) || (localb.JUw)) {
              break label236;
            }
            p.g(localInteger, "action");
            localb.aS(localInteger.intValue(), 0L);
            bool = true;
            break;
          }
          p.g(localInteger, "action");
          localb.aS(localInteger.intValue(), 0L);
          bool = true;
        }
      }
      localb.JUA = bool;
      bool = localb.JUA;
      localObject = (a.a)localb.JUz.get(Integer.valueOf(1));
      if (localObject != null) {}
      for (localObject = Long.valueOf(((a.a)localObject).total);; localObject = null)
      {
        Log.d("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult resultValid: %b, timeTotal: %s, id: %s", new Object[] { Boolean.valueOf(bool), localObject, localb.id });
        label422:
        localObject = a.JUl;
        a.gml().remove(this.mkH);
        localObject = a.JUl;
        a.a(localb, this.JUF);
        AppMethodBeat.o(124803);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a.b paramb, b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(124804);
      Object localObject = a.JUl;
      a.b(this.JUG, this.JUF);
      localObject = a.JUl;
      a.a(this.JUF);
      if (this.JUG.JUA)
      {
        localObject = this.JUG;
        long l1 = ((a.b)localObject).JUn;
        long l2 = ((a.b)localObject).JUo;
        long l3 = ((a.b)localObject).JUp;
        if (((a.b)localObject).JUq + (l1 + l2 + l3) < 50L) {
          break label113;
        }
      }
      label113:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject = a.JUl;
          a.a(this.JUG);
        }
        AppMethodBeat.o(124804);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    public static final g JUH;
    
    static
    {
      AppMethodBeat.i(124806);
      JUH = new g();
      AppMethodBeat.o(124806);
    }
    
    public final void run()
    {
      AppMethodBeat.i(124805);
      Object localObject = a.JUl;
      Log.i("MicroMsg.BizImageBlankReporter", "alvinluo reportImageLoadCountInfo %s", new Object[] { a.gmm() });
      localObject = com.tencent.mm.plugin.report.service.h.CyF;
      a locala = a.JUl;
      int i = a.gmm().gAZ;
      locala = a.JUl;
      int j = a.gmm().JUD;
      locala = a.JUl;
      int k = a.gmm().JUC;
      locala = a.JUl;
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17890, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(a.gmm().JUB) });
      localObject = a.JUl;
      a.gmn();
      AppMethodBeat.o(124805);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class h
    implements Runnable
  {
    public h(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124807);
      Log.d("MicroMsg.BizImageBlankReporter", "alvinluo resumeAll");
      Object localObject1 = a.JUl;
      a.zH(false);
      localObject1 = a.JUl;
      localObject1 = a.gml().keySet();
      p.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = a.JUl;
        localObject2 = (a.b)a.gml().get(str);
        if ((localObject2 != null) && (((a.b)localObject2).JUx))
        {
          a locala = a.JUl;
          p.g(str, "url");
          Log.d("MicroMsg.BizImageBlankReporter", "alvinluo resume Scroll_Fling id: %s", new Object[] { a.bdl(str) });
          ((a.b)localObject2).aR(9, this.kPc);
        }
      }
      AppMethodBeat.o(124807);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class i
    implements Runnable
  {
    public i(String paramString, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124808);
      Object localObject = a.JUl;
      localObject = (a.b)a.gml().get(this.mkH);
      if (localObject != null)
      {
        long l = this.kPc;
        ((a.b)localObject).retryCount += 1;
        a.a locala = (a.a)((a.b)localObject).JUz.get(Integer.valueOf(3));
        if (locala != null)
        {
          if (locala.status == 4)
          {
            Log.i("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload force restart id: %s", new Object[] { ((a.b)localObject).id });
            locala.status = 1;
            locala.Mm(l);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class j
    implements Runnable
  {
    public j(Set paramSet, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124809);
      Object localObject1 = ((Iterable)this.JUI).iterator();
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
          localObject3 = a.JUl;
          localObject2 = (a.b)a.gml().get(localObject2);
          if (localObject2 == null) {
            break;
          }
          l = this.kPc;
          localObject3 = (a.a)((a.b)localObject2).JUz.get(Integer.valueOf(((a.b)localObject2).jCM));
          if (localObject3 != null) {
            ((a.a)localObject3).Mm(l);
          }
          ((a.b)localObject2).JUy = true;
          if (!((a.b)localObject2).JUx) {
            break;
          }
          localObject2 = (a.a)((a.b)localObject2).JUz.get(Integer.valueOf(9));
          if (localObject2 == null) {
            break;
          }
          ((a.a)localObject2).Mm(l);
          break;
        }
      }
      localObject1 = a.JUl;
      localObject1 = a.gml().keySet();
      p.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = a.JUl;
        localObject2 = (a.b)a.gml().get(localObject2);
        if ((localObject2 != null) && (!this.JUI.contains(((a.b)localObject2).url)))
        {
          l = this.kPc;
          localObject3 = (a.a)((a.b)localObject2).JUz.get(Integer.valueOf(((a.b)localObject2).jCM));
          if (localObject3 != null) {
            ((a.a)localObject3).Mn(l);
          }
          ((a.b)localObject2).JUy = false;
          if (((a.b)localObject2).JUx)
          {
            localObject2 = (a.a)((a.b)localObject2).JUz.get(Integer.valueOf(9));
            if (localObject2 != null) {
              ((a.a)localObject2).Mn(l);
            }
          }
        }
      }
      AppMethodBeat.o(124809);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124810);
      Object localObject1 = a.JUl;
      Object localObject2 = (a.b)a.gml().get(this.mkH);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a.b(this.mkH);
        localObject2 = a.JUl;
        ((Map)a.gml()).put(this.mkH, localObject1);
      }
      ((a.b)localObject1).aQ(paramInt, paramLong);
      AppMethodBeat.o(124810);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class l
    implements Runnable
  {
    public l(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124811);
      Log.d("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling");
      Object localObject1 = a.JUl;
      a.zH(true);
      localObject1 = a.JUl;
      localObject1 = a.gml().keySet();
      p.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        a locala = a.JUl;
        localObject2 = (a.b)a.gml().get(localObject2);
        if ((localObject2 != null) && (!((a.b)localObject2).xqn) && (!((a.b)localObject2).gmp()))
        {
          locala = a.JUl;
          Log.v("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling task not running and start SCROLL_FLING id: %s, %s", new Object[] { a.bdl(((a.b)localObject2).url), ((a.b)localObject2).url });
          ((a.b)localObject2).aQ(9, this.kPc);
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