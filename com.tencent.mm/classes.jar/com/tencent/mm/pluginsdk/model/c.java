package com.tencent.mm.pluginsdk.model;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.d.b;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.biz.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.o;
import kotlin.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter;", "", "()V", "ENABLE_CHECK_ON_SCREEN", "", "HOST_NAME_MAP", "Ljava/util/HashMap;", "", "kotlin.jvm.PlatformType", "Lkotlin/collections/HashMap;", "REPORT_THREAD_LOOP_TAG", "TAG", "appMsgUrlMap", "isFlinging", "mLoadCountInfo", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "reportInfoMap", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "clearAppMsgUrl", "", "fillReportInfo", "reportInfo", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "finishAction", "action", "", "url", "timestamp", "", "finishAndReport", "getAppMsgKey", "msgId", "msgIndex", "getIdByUrl", "plusImageLoadCount", "reportBlank", "reportImageLoadCountInfo", "resetImageLoadCountInfo", "resumeAll", "retryDownload", "runTask", "runnable", "Ljava/lang/Runnable;", "setAppMsgUrl", "appMsgUrl", "showList", "urlSet", "", "simplifyUrl", "startAction", "startLoad", "item", "Lcom/tencent/mm/message/BizReaderItem;", "cellPosition", "stopAllByFling", "Action", "ActionTimeInfo", "BizImageBlankReportInfo", "ImageLoadCountInfo", "Status", "plugin-biz_release"})
public final class c
{
  static final HashMap<String, b> FHN;
  static final HashMap<String, String> QUp;
  private static c QUq;
  public static boolean QUr;
  private static final HashMap<String, String> QUs;
  public static final c QUt;
  
  static
  {
    AppMethodBeat.i(124821);
    QUt = new c();
    FHN = new HashMap();
    QUp = new HashMap();
    QUq = new c();
    QUs = ae.g(new o[] { s.M(WeChatHosts.domainString(b.f.host_mp_weixin_qq_com), "1"), s.M("mmbiz.qpic.cn", "2"), s.M("vpic.video.qq.com", "3"), s.M("mmbiz.qlogo.cn", "4") });
    AppMethodBeat.o(124821);
  }
  
  static String au(long paramLong, int paramInt)
  {
    AppMethodBeat.i(124814);
    String str = String.valueOf(paramLong) + "," + String.valueOf(paramInt);
    AppMethodBeat.o(124814);
    return str;
  }
  
  public static String bpB(String paramString)
  {
    AppMethodBeat.i(124820);
    p.k(paramString, "url");
    paramString = paramString.getBytes(d.UTF_8);
    p.j(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = g.getMessageDigest(paramString);
    p.j(paramString, "MD5.getMessageDigest(url.toByteArray())");
    AppMethodBeat.o(124820);
    return paramString;
  }
  
  public static void e(final int paramInt, String paramString, final long paramLong)
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
      u((Runnable)new k(paramString, paramInt, paramLong));
      AppMethodBeat.o(124815);
      return;
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static void hgH()
  {
    AppMethodBeat.i(124813);
    QUp.clear();
    AppMethodBeat.o(124813);
  }
  
  public static void hgI()
  {
    AppMethodBeat.i(124819);
    com.tencent.e.h.ZvG.d((Runnable)g.QUP, "biz_image_blank_report");
    AppMethodBeat.o(124819);
  }
  
  public static void m(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(124812);
    p.k(paramString, "appMsgUrl");
    ((Map)QUp).put(au(paramLong, paramInt), paramString);
    AppMethodBeat.o(124812);
  }
  
  public static void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(124818);
    p.k(paramRunnable, "runnable");
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(124818);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "", "id", "", "action", "", "(Ljava/lang/String;I)V", "getAction", "()I", "setAction", "(I)V", "begin", "", "getBegin", "()J", "setBegin", "(J)V", "end", "getEnd", "setEnd", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "total", "getTotal", "setTotal", "addTime", "", "finish", "timestamp", "isFinished", "", "onResume", "pause", "reset", "resume", "start", "plugin-biz_release"})
  public static final class a
  {
    long aYz;
    int action;
    private long begin;
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
      this.aYz = 0L;
      this.status = 0;
      this.id = paramString;
      this.action = paramInt;
      AppMethodBeat.o(124794);
    }
    
    public final void TO(long paramLong)
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
        this.aYz = 0L;
        AppMethodBeat.o(124792);
        return;
        label83:
        paramLong = System.currentTimeMillis();
      }
    }
    
    public final void TP(long paramLong)
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
        this.aYz = paramLong;
        hgM();
        this.status = 3;
        AppMethodBeat.o(124793);
        return;
        label84:
        paramLong = System.currentTimeMillis();
      }
    }
    
    final void hgM()
    {
      if (this.aYz >= this.begin) {
        this.total += this.aYz - this.begin;
      }
    }
    
    public final boolean isFinished()
    {
      return this.status == 4;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "", "url", "", "(Ljava/lang/String;)V", "actionTimePointMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "Lkotlin/collections/HashMap;", "appMsgUrl", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "currentAction", "getCurrentAction", "()I", "setCurrentAction", "(I)V", "downloadSuccess", "", "getDownloadSuccess", "()Z", "setDownloadSuccess", "(Z)V", "hasTask", "getHasTask", "setHasTask", "id", "imageSize", "", "getImageSize", "()J", "setImageSize", "(J)V", "isPausedByScrollFling", "setPausedByScrollFling", "isTaskRunning", "setTaskRunning", "local", "getLocal", "setLocal", "netType", "getNetType", "setNetType", "onScreen", "getOnScreen", "setOnScreen", "position", "getPosition", "setPosition", "resultValid", "retryCount", "getRetryCount", "setRetryCount", "timeFile", "getTimeFile", "setTimeFile", "timeHevc", "getTimeHevc", "setTimeHevc", "timeNet", "getTimeNet", "setTimeNet", "timeScroll", "getTimeScroll", "setTimeScroll", "timeTaskRun", "getTimeTaskRun", "setTimeTaskRun", "timeThread", "getTimeThread", "setTimeThread", "timeTotal", "getTimeTotal", "setTimeTotal", "getUrl", "setUrl", "fillResult", "", "fillTime", "action", "time", "finish", "timestamp", "hide", "isBlank", "isFinished", "isResultValid", "offScreen", "pause", "reset", "resume", "retryDownload", "show", "start", "toString", "plugin-biz_release"})
  public static final class b
  {
    String ARR;
    boolean CcI;
    boolean HLG;
    private long QUA;
    String QUB;
    long QUC;
    boolean QUD;
    boolean QUE;
    boolean QUF;
    boolean QUG;
    HashMap<Integer, c.a> QUH;
    boolean QUI;
    long QUu;
    long QUv;
    long QUw;
    long QUx;
    long QUy;
    long QUz;
    String id;
    int msZ;
    int position;
    int retryCount;
    String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(124800);
      this.url = "";
      this.QUB = "";
      this.ARR = "";
      this.position = -1;
      this.msZ = -1;
      this.id = "";
      this.QUH = new HashMap();
      this.url = paramString;
      c localc = c.QUt;
      this.id = c.bpB(paramString);
      AppMethodBeat.o(124800);
    }
    
    public final void bc(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124797);
      c.a locala1;
      if (paramInt == 2)
      {
        this.CcI = true;
        this.QUE = true;
        c.a locala2 = (c.a)this.QUH.get(Integer.valueOf(paramInt));
        locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new c.a(this.id, paramInt);
          ((Map)this.QUH).put(Integer.valueOf(paramInt), locala1);
        }
        if (locala1.status == 0)
        {
          Log.v("MicroMsg.BizImageBlankReporter", "alvinluo start action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(locala1.action), locala1.id, Integer.valueOf(locala1.status), Long.valueOf(paramLong) });
          locala1.status = 1;
        }
        if ((paramInt != 1) && (paramInt != 2)) {
          break label187;
        }
        locala1.TO(paramLong);
      }
      for (;;)
      {
        if (paramInt != 9) {
          this.msZ = paramInt;
        }
        AppMethodBeat.o(124797);
        return;
        if (paramInt != 9) {
          break;
        }
        this.QUF = true;
        break;
        label187:
        locala1.TO(paramLong);
      }
    }
    
    public final void bd(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124798);
      c.a locala = (c.a)this.QUH.get(Integer.valueOf(paramInt));
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
        locala.aYz = paramLong;
        locala.hgM();
        locala.status = 4;
        this.msZ = -1;
        if (paramInt == 9) {
          this.QUF = false;
        }
        AppMethodBeat.o(124798);
        return;
        label146:
        paramLong = System.currentTimeMillis();
      }
    }
    
    final void be(int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        this.QUu = paramLong;
        return;
      case 3: 
        this.QUw = paramLong;
        return;
      case 5: 
      case 6: 
      case 7: 
        this.QUv += paramLong;
        return;
      case 4: 
        this.QUu = paramLong;
        return;
      case 8: 
        this.QUz = paramLong;
        return;
      case 2: 
        this.QUA = paramLong;
        return;
      }
      this.QUx = paramLong;
    }
    
    public final void bpC(String paramString)
    {
      AppMethodBeat.i(124795);
      p.k(paramString, "<set-?>");
      this.QUB = paramString;
      AppMethodBeat.o(124795);
    }
    
    public final boolean hgN()
    {
      AppMethodBeat.i(124799);
      c.a locala = (c.a)this.QUH.get(Integer.valueOf(1));
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
      Object localObject = af.aaBG;
      int i = hashCode();
      localObject = c.QUt;
      localObject = String.format("BizImageBlankReportInfo %s {id: %s, timeTotal: %d, timeTaskRun: %d, timeFile: %d, timeNet: %d, timeScroll: %d, timeHevc: %d, timeThread: %d, \nnetType: %s, position: %d, imageSize: %d, retryCount: %d, downloadSuccess: %b, local: %b, \nurl: %s}", Arrays.copyOf(new Object[] { Integer.valueOf(i), c.bpB(this.url), Long.valueOf(this.QUu), Long.valueOf(this.QUA), Long.valueOf(this.QUv), Long.valueOf(this.QUw), Long.valueOf(this.QUx), Long.valueOf(this.QUy), Long.valueOf(this.QUz), this.ARR, Integer.valueOf(this.position), Long.valueOf(this.QUC), Integer.valueOf(this.retryCount), Boolean.valueOf(this.QUD), Boolean.valueOf(this.HLG), this.url }, 16));
      p.j(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(124796);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "", "()V", "fromFileCount", "", "getFromFileCount", "()I", "setFromFileCount", "(I)V", "fromMemoryCount", "getFromMemoryCount", "setFromMemoryCount", "fromNetCount", "getFromNetCount", "setFromNetCount", "totalCount", "getTotalCount", "setTotalCount", "reset", "", "toString", "", "plugin-biz_release"})
  public static final class c
  {
    int QUJ;
    int QUK;
    int QUL;
    int jlf;
    
    public final String toString()
    {
      AppMethodBeat.i(124801);
      Object localObject = af.aaBG;
      localObject = String.format("totalCount: %d, fromNetCount: %d, fromFileCount: %d, fromMemoryCount: %d", Arrays.copyOf(new Object[] { Integer.valueOf(this.jlf), Integer.valueOf(this.QUJ), Integer.valueOf(this.QUK), Integer.valueOf(this.QUL) }, 4));
      p.j(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(124801);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124802);
      Object localObject = c.QUt;
      localObject = (c.b)c.hgJ().get(this.piM);
      if (localObject != null)
      {
        ((c.b)localObject).bd(this.mpJ, this.QUM);
        AppMethodBeat.o(124802);
        return;
      }
      AppMethodBeat.o(124802);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString, long paramLong, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(124803);
      if (((CharSequence)this.piM).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(124803);
        return;
      }
      Object localObject = c.QUt;
      c.b localb = (c.b)c.hgJ().get(this.piM);
      if (localb == null)
      {
        AppMethodBeat.o(124803);
        return;
      }
      if (localb.hgN())
      {
        localObject = c.QUt;
        Log.w("MicroMsg.BizImageBlankReporter", "alvinluo finishAndReport id: %s TOTAL is finished", new Object[] { c.bpB(this.piM) });
        localObject = c.QUt;
        c.hgJ().remove(this.piM);
        AppMethodBeat.o(124803);
        return;
      }
      localb.bd(1, this.nJi);
      localObject = localb.QUH.keySet();
      p.j(localObject, "actionTimePointMap.keys");
      localObject = ((Iterable)localObject).iterator();
      boolean bool = true;
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        c.a locala = (c.a)localb.QUH.get(localInteger);
        if (locala == null) {
          break label422;
        }
        if (locala.isFinished())
        {
          p.j(localInteger, "action");
          localb.be(localInteger.intValue(), locala.total);
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
          while ((localInteger.intValue() != 9) || (localb.QUE))
          {
            Log.e("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult invalid action: %d, id: %s", new Object[] { localInteger, localb.id });
            bool = false;
            break;
            if ((localInteger.intValue() != 8) || (localb.QUE)) {
              break label236;
            }
            p.j(localInteger, "action");
            localb.be(localInteger.intValue(), 0L);
            bool = true;
            break;
          }
          p.j(localInteger, "action");
          localb.be(localInteger.intValue(), 0L);
          bool = true;
        }
      }
      localb.QUI = bool;
      bool = localb.QUI;
      localObject = (c.a)localb.QUH.get(Integer.valueOf(1));
      if (localObject != null) {}
      for (localObject = Long.valueOf(((c.a)localObject).total);; localObject = null)
      {
        Log.d("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult resultValid: %b, timeTotal: %s, id: %s", new Object[] { Boolean.valueOf(bool), localObject, localb.id });
        label422:
        localObject = c.QUt;
        c.hgJ().remove(this.piM);
        localObject = c.QUt;
        c.a(localb, this.QUN);
        AppMethodBeat.o(124803);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(c.b paramb, b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(124804);
      Object localObject = c.QUt;
      c.b(this.QUO, this.QUN);
      localObject = c.QUt;
      c.a(this.QUN);
      if (this.QUO.QUI)
      {
        localObject = this.QUO;
        long l1 = ((c.b)localObject).QUv;
        long l2 = ((c.b)localObject).QUw;
        long l3 = ((c.b)localObject).QUx;
        if (((c.b)localObject).QUy + (l1 + l2 + l3) < 50L) {
          break label113;
        }
      }
      label113:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject = c.QUt;
          c.a(this.QUO);
        }
        AppMethodBeat.o(124804);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    public static final g QUP;
    
    static
    {
      AppMethodBeat.i(124806);
      QUP = new g();
      AppMethodBeat.o(124806);
    }
    
    public final void run()
    {
      AppMethodBeat.i(124805);
      Object localObject = c.QUt;
      Log.i("MicroMsg.BizImageBlankReporter", "alvinluo reportImageLoadCountInfo %s", new Object[] { c.hgK() });
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      c localc = c.QUt;
      int i = c.hgK().jlf;
      localc = c.QUt;
      int j = c.hgK().QUL;
      localc = c.QUt;
      int k = c.hgK().QUK;
      localc = c.QUt;
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17890, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(c.hgK().QUJ) });
      localObject = c.QUt;
      c.hgL();
      AppMethodBeat.o(124805);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class h
    implements Runnable
  {
    public h(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124807);
      Log.d("MicroMsg.BizImageBlankReporter", "alvinluo resumeAll");
      Object localObject1 = c.QUt;
      c.DM(false);
      localObject1 = c.QUt;
      localObject1 = c.hgJ().keySet();
      p.j(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = c.QUt;
        localObject2 = (c.b)c.hgJ().get(str);
        if ((localObject2 != null) && (((c.b)localObject2).QUF))
        {
          c localc = c.QUt;
          p.j(str, "url");
          Log.d("MicroMsg.BizImageBlankReporter", "alvinluo resume Scroll_Fling id: %s", new Object[] { c.bpB(str) });
          ((c.b)localObject2).bd(9, this.nJi);
        }
      }
      AppMethodBeat.o(124807);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class i
    implements Runnable
  {
    public i(String paramString, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124808);
      Object localObject = c.QUt;
      localObject = (c.b)c.hgJ().get(this.piM);
      if (localObject != null)
      {
        long l = this.nJi;
        ((c.b)localObject).retryCount += 1;
        c.a locala = (c.a)((c.b)localObject).QUH.get(Integer.valueOf(3));
        if (locala != null)
        {
          if (locala.status == 4)
          {
            Log.i("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload force restart id: %s", new Object[] { ((c.b)localObject).id });
            locala.status = 1;
            locala.TO(l);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class j
    implements Runnable
  {
    public j(Set paramSet, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124809);
      Object localObject1 = ((Iterable)this.QUQ).iterator();
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
          localObject3 = c.QUt;
          localObject2 = (c.b)c.hgJ().get(localObject2);
          if (localObject2 == null) {
            break;
          }
          l = this.nJi;
          localObject3 = (c.a)((c.b)localObject2).QUH.get(Integer.valueOf(((c.b)localObject2).msZ));
          if (localObject3 != null) {
            ((c.a)localObject3).TO(l);
          }
          ((c.b)localObject2).QUG = true;
          if (!((c.b)localObject2).QUF) {
            break;
          }
          localObject2 = (c.a)((c.b)localObject2).QUH.get(Integer.valueOf(9));
          if (localObject2 == null) {
            break;
          }
          ((c.a)localObject2).TO(l);
          break;
        }
      }
      localObject1 = c.QUt;
      localObject1 = c.hgJ().keySet();
      p.j(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = c.QUt;
        localObject2 = (c.b)c.hgJ().get(localObject2);
        if ((localObject2 != null) && (!this.QUQ.contains(((c.b)localObject2).url)))
        {
          l = this.nJi;
          localObject3 = (c.a)((c.b)localObject2).QUH.get(Integer.valueOf(((c.b)localObject2).msZ));
          if (localObject3 != null) {
            ((c.a)localObject3).TP(l);
          }
          ((c.b)localObject2).QUG = false;
          if (((c.b)localObject2).QUF)
          {
            localObject2 = (c.a)((c.b)localObject2).QUH.get(Integer.valueOf(9));
            if (localObject2 != null) {
              ((c.a)localObject2).TP(l);
            }
          }
        }
      }
      AppMethodBeat.o(124809);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124810);
      Object localObject1 = c.QUt;
      Object localObject2 = (c.b)c.hgJ().get(this.piM);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new c.b(this.piM);
        localObject2 = c.QUt;
        ((Map)c.hgJ()).put(this.piM, localObject1);
      }
      ((c.b)localObject1).bc(paramInt, paramLong);
      AppMethodBeat.o(124810);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class l
    implements Runnable
  {
    public l(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124811);
      Log.d("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling");
      Object localObject1 = c.QUt;
      c.DM(true);
      localObject1 = c.QUt;
      localObject1 = c.hgJ().keySet();
      p.j(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        c localc = c.QUt;
        localObject2 = (c.b)c.hgJ().get(localObject2);
        if ((localObject2 != null) && (!((c.b)localObject2).CcI) && (!((c.b)localObject2).hgN()))
        {
          localc = c.QUt;
          Log.v("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling task not running and start SCROLL_FLING id: %s, %s", new Object[] { c.bpB(((c.b)localObject2).url), ((c.b)localObject2).url });
          ((c.b)localObject2).bc(9, this.nJi);
        }
      }
      AppMethodBeat.o(124811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.c
 * JD-Core Version:    0.7.0.1
 */