package com.tencent.mm.pluginsdk.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.a.ae;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.n.d;
import d.o;
import d.u;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter;", "", "()V", "ENABLE_CHECK_ON_SCREEN", "", "HOST_NAME_MAP", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "REPORT_THREAD_LOOP_TAG", "TAG", "appMsgUrlMap", "isFlinging", "mLoadCountInfo", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "reportInfoMap", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "clearAppMsgUrl", "", "fillReportInfo", "reportInfo", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "finishAction", "action", "", "url", "timestamp", "", "finishAndReport", "getAppMsgKey", "msgId", "msgIndex", "getIdByUrl", "plusImageLoadCount", "reportBlank", "reportImageLoadCountInfo", "resetImageLoadCountInfo", "resumeAll", "retryDownload", "runTask", "runnable", "Ljava/lang/Runnable;", "setAppMsgUrl", "appMsgUrl", "showList", "urlSet", "", "simplifyUrl", "startAction", "startLoad", "item", "Lcom/tencent/mm/message/BizReaderItem;", "cellPosition", "stopAllByFling", "Action", "ActionTimeInfo", "BizImageBlankReportInfo", "ImageLoadCountInfo", "Status", "plugin-biz_release"})
public final class a
{
  static final HashMap<String, b> Dgj;
  static final HashMap<String, String> Dgk;
  private static a.c Dgl;
  public static boolean Dgm;
  private static final HashMap<String, String> Dgn;
  public static final a Dgo;
  
  static
  {
    AppMethodBeat.i(124821);
    Dgo = new a();
    Dgj = new HashMap();
    Dgk = new HashMap();
    Dgl = new a.c();
    Dgn = ae.c(new o[] { u.Q("mp.weixin.qq.com", "1"), u.Q("mmbiz.qpic.cn", "2"), u.Q("vpic.video.qq.com", "3"), u.Q("mmbiz.qlogo.cn", "4") });
    AppMethodBeat.o(124821);
  }
  
  public static String aFT(String paramString)
  {
    AppMethodBeat.i(124820);
    k.h(paramString, "url");
    paramString = paramString.getBytes(d.UTF_8);
    k.g(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = g.getMessageDigest(paramString);
    k.g(paramString, "MD5.getMessageDigest(url.toByteArray())");
    AppMethodBeat.o(124820);
    return paramString;
  }
  
  static String ad(long paramLong, int paramInt)
  {
    AppMethodBeat.i(124814);
    String str = String.valueOf(paramLong) + "," + String.valueOf(paramInt);
    AppMethodBeat.o(124814);
    return str;
  }
  
  public static void c(final int paramInt, String paramString, final long paramLong)
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
  
  public static void eKr()
  {
    AppMethodBeat.i(124813);
    Dgk.clear();
    AppMethodBeat.o(124813);
  }
  
  public static void eKs()
  {
    AppMethodBeat.i(124819);
    h.JZN.f((Runnable)a.g.DgL, "biz_image_blank_report");
    AppMethodBeat.o(124819);
  }
  
  public static void l(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(124812);
    k.h(paramString, "appMsgUrl");
    ((Map)Dgk).put(ad(paramLong, paramInt), paramString);
    AppMethodBeat.o(124812);
  }
  
  public static void v(Runnable paramRunnable)
  {
    AppMethodBeat.i(124818);
    k.h(paramRunnable, "runnable");
    ap.f(paramRunnable);
    AppMethodBeat.o(124818);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "", "id", "", "action", "", "(Ljava/lang/String;I)V", "getAction", "()I", "setAction", "(I)V", "begin", "", "getBegin", "()J", "setBegin", "(J)V", "end", "getEnd", "setEnd", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "total", "getTotal", "setTotal", "addTime", "", "finish", "timestamp", "isFinished", "", "onResume", "pause", "reset", "resume", "start", "plugin-biz_release"})
  public static final class a
  {
    int action;
    long beH;
    private long cpR;
    long dne;
    String id;
    int status;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(124794);
      this.action = -1;
      this.id = "";
      this.dne = 0L;
      this.cpR = 0L;
      this.beH = 0L;
      this.status = 0;
      this.id = paramString;
      this.action = paramInt;
      AppMethodBeat.o(124794);
    }
    
    final void eKw()
    {
      if (this.beH >= this.cpR) {
        this.dne += this.beH - this.cpR;
      }
    }
    
    public final boolean isFinished()
    {
      return this.status == 4;
    }
    
    public final void zJ(long paramLong)
    {
      AppMethodBeat.i(124792);
      if ((this.status == 3) || (this.status == 1))
      {
        ac.v("MicroMsg.BizImageBlankReporter", "alvinluo resume action: %d, id: %s, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Long.valueOf(paramLong) });
        this.status = 2;
        if (paramLong < 0L) {
          break label83;
        }
      }
      for (;;)
      {
        this.cpR = paramLong;
        this.beH = 0L;
        AppMethodBeat.o(124792);
        return;
        label83:
        paramLong = System.currentTimeMillis();
      }
    }
    
    public final void zK(long paramLong)
    {
      AppMethodBeat.i(124793);
      if (this.status == 2)
      {
        ac.v("MicroMsg.BizImageBlankReporter", "alvinluo pause action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Integer.valueOf(this.status), Long.valueOf(paramLong) });
        if (paramLong < 0L) {
          break label84;
        }
      }
      for (;;)
      {
        this.beH = paramLong;
        eKw();
        this.status = 3;
        AppMethodBeat.o(124793);
        return;
        label84:
        paramLong = System.currentTimeMillis();
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "", "url", "", "(Ljava/lang/String;)V", "actionTimePointMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "Lkotlin/collections/HashMap;", "appMsgUrl", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "currentAction", "getCurrentAction", "()I", "setCurrentAction", "(I)V", "downloadSuccess", "", "getDownloadSuccess", "()Z", "setDownloadSuccess", "(Z)V", "hasTask", "getHasTask", "setHasTask", "id", "imageSize", "", "getImageSize", "()J", "setImageSize", "(J)V", "isPausedByScrollFling", "setPausedByScrollFling", "isTaskRunning", "setTaskRunning", "local", "getLocal", "setLocal", "netType", "getNetType", "setNetType", "onScreen", "getOnScreen", "setOnScreen", "position", "getPosition", "setPosition", "resultValid", "retryCount", "getRetryCount", "setRetryCount", "timeFile", "getTimeFile", "setTimeFile", "timeHevc", "getTimeHevc", "setTimeHevc", "timeNet", "getTimeNet", "setTimeNet", "timeScroll", "getTimeScroll", "setTimeScroll", "timeTaskRun", "getTimeTaskRun", "setTimeTaskRun", "timeThread", "getTimeThread", "setTimeThread", "timeTotal", "getTimeTotal", "setTimeTotal", "getUrl", "setUrl", "fillResult", "", "fillTime", "action", "time", "finish", "timestamp", "hide", "isBlank", "isFinished", "isResultValid", "offScreen", "pause", "reset", "resume", "retryDownload", "show", "start", "toString", "plugin-biz_release"})
  public static final class b
  {
    boolean DgA;
    boolean DgB;
    boolean DgC;
    HashMap<Integer, a.a> DgD;
    boolean DgE;
    long Dgp;
    long Dgq;
    long Dgr;
    long Dgs;
    long Dgt;
    long Dgu;
    private long Dgv;
    String Dgw;
    long Dgx;
    boolean Dgy;
    boolean Dgz;
    String id;
    int ikz;
    int position;
    int retryCount;
    String rzt;
    boolean sRE;
    String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(124800);
      this.url = "";
      this.Dgw = "";
      this.rzt = "";
      this.position = -1;
      this.ikz = -1;
      this.id = "";
      this.DgD = new HashMap();
      this.url = paramString;
      a locala = a.Dgo;
      this.id = a.aFT(paramString);
      AppMethodBeat.o(124800);
    }
    
    public final void aB(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124797);
      a.a locala1;
      if (paramInt == 2)
      {
        this.sRE = true;
        this.DgA = true;
        a.a locala2 = (a.a)this.DgD.get(Integer.valueOf(paramInt));
        locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a.a(this.id, paramInt);
          ((Map)this.DgD).put(Integer.valueOf(paramInt), locala1);
        }
        if (locala1.status == 0)
        {
          ac.v("MicroMsg.BizImageBlankReporter", "alvinluo start action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(locala1.action), locala1.id, Integer.valueOf(locala1.status), Long.valueOf(paramLong) });
          locala1.status = 1;
        }
        if ((paramInt != 1) && (paramInt != 2)) {
          break label187;
        }
        locala1.zJ(paramLong);
      }
      for (;;)
      {
        if (paramInt != 9) {
          this.ikz = paramInt;
        }
        AppMethodBeat.o(124797);
        return;
        if (paramInt != 9) {
          break;
        }
        this.DgB = true;
        break;
        label187:
        locala1.zJ(paramLong);
      }
    }
    
    public final void aC(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124798);
      a.a locala = (a.a)this.DgD.get(Integer.valueOf(paramInt));
      if ((locala != null) && ((locala.status == 2) || (locala.status == 3)))
      {
        ac.v("MicroMsg.BizImageBlankReporter", "alvinluo finish action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(locala.action), locala.id, Integer.valueOf(locala.status), Long.valueOf(paramLong) });
        if (locala.status == 2) {
          if (paramLong < 0L) {
            break label146;
          }
        }
      }
      for (;;)
      {
        locala.beH = paramLong;
        locala.eKw();
        locala.status = 4;
        this.ikz = -1;
        if (paramInt == 9) {
          this.DgB = false;
        }
        AppMethodBeat.o(124798);
        return;
        label146:
        paramLong = System.currentTimeMillis();
      }
    }
    
    final void aD(int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        this.Dgp = paramLong;
        return;
      case 3: 
        this.Dgr = paramLong;
        return;
      case 5: 
      case 6: 
      case 7: 
        this.Dgq += paramLong;
        return;
      case 4: 
        this.Dgp = paramLong;
        return;
      case 8: 
        this.Dgu = paramLong;
        return;
      case 2: 
        this.Dgv = paramLong;
        return;
      }
      this.Dgs = paramLong;
    }
    
    public final void aFU(String paramString)
    {
      AppMethodBeat.i(124795);
      k.h(paramString, "<set-?>");
      this.Dgw = paramString;
      AppMethodBeat.o(124795);
    }
    
    public final boolean eKx()
    {
      AppMethodBeat.i(124799);
      a.a locala = (a.a)this.DgD.get(Integer.valueOf(1));
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
      Object localObject = z.KUT;
      int i = hashCode();
      localObject = a.Dgo;
      localObject = String.format("BizImageBlankReportInfo %s {id: %s, timeTotal: %d, timeTaskRun: %d, timeFile: %d, timeNet: %d, timeScroll: %d, timeHevc: %d, timeThread: %d, \nnetType: %s, position: %d, imageSize: %d, retryCount: %d, downloadSuccess: %b, local: %b, \nurl: %s}", Arrays.copyOf(new Object[] { Integer.valueOf(i), a.aFT(this.url), Long.valueOf(this.Dgp), Long.valueOf(this.Dgv), Long.valueOf(this.Dgq), Long.valueOf(this.Dgr), Long.valueOf(this.Dgs), Long.valueOf(this.Dgt), Long.valueOf(this.Dgu), this.rzt, Integer.valueOf(this.position), Long.valueOf(this.Dgx), Integer.valueOf(this.retryCount), Boolean.valueOf(this.Dgy), Boolean.valueOf(this.Dgz), this.url }, 16));
      k.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(124796);
      return localObject;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124802);
      Object localObject = a.Dgo;
      localObject = (a.b)a.eKt().get(this.kFm);
      if (localObject != null)
      {
        ((a.b)localObject).aC(this.iij, this.DgI);
        AppMethodBeat.o(124802);
        return;
      }
      AppMethodBeat.o(124802);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString, long paramLong, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(124803);
      if (((CharSequence)this.kFm).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(124803);
        return;
      }
      Object localObject = a.Dgo;
      a.b localb = (a.b)a.eKt().get(this.kFm);
      if (localb == null)
      {
        AppMethodBeat.o(124803);
        return;
      }
      if (localb.eKx())
      {
        localObject = a.Dgo;
        ac.w("MicroMsg.BizImageBlankReporter", "alvinluo finishAndReport id: %s TOTAL is finished", new Object[] { a.aFT(this.kFm) });
        localObject = a.Dgo;
        a.eKt().remove(this.kFm);
        AppMethodBeat.o(124803);
        return;
      }
      localb.aC(1, this.iim);
      localObject = localb.DgD.keySet();
      k.g(localObject, "actionTimePointMap.keys");
      localObject = ((Iterable)localObject).iterator();
      boolean bool = true;
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        a.a locala = (a.a)localb.DgD.get(localInteger);
        if (locala == null) {
          break label422;
        }
        if (locala.isFinished())
        {
          k.g(localInteger, "action");
          localb.aD(localInteger.intValue(), locala.dne);
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
          while ((localInteger.intValue() != 9) || (localb.DgA))
          {
            ac.e("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult invalid action: %d, id: %s", new Object[] { localInteger, localb.id });
            bool = false;
            break;
            if ((localInteger.intValue() != 8) || (localb.DgA)) {
              break label236;
            }
            k.g(localInteger, "action");
            localb.aD(localInteger.intValue(), 0L);
            bool = true;
            break;
          }
          k.g(localInteger, "action");
          localb.aD(localInteger.intValue(), 0L);
          bool = true;
        }
      }
      localb.DgE = bool;
      bool = localb.DgE;
      localObject = (a.a)localb.DgD.get(Integer.valueOf(1));
      if (localObject != null) {}
      for (localObject = Long.valueOf(((a.a)localObject).dne);; localObject = null)
      {
        ac.d("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult resultValid: %b, timeTotal: %s, id: %s", new Object[] { Boolean.valueOf(bool), localObject, localb.id });
        label422:
        localObject = a.Dgo;
        a.eKt().remove(this.kFm);
        localObject = a.Dgo;
        a.a(localb, this.DgJ);
        AppMethodBeat.o(124803);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a.b paramb, b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(124804);
      Object localObject = a.Dgo;
      a.b(this.DgK, this.DgJ);
      localObject = a.Dgo;
      a.a(this.DgJ);
      if (this.DgK.DgE)
      {
        localObject = this.DgK;
        long l1 = ((a.b)localObject).Dgq;
        long l2 = ((a.b)localObject).Dgr;
        long l3 = ((a.b)localObject).Dgs;
        if (((a.b)localObject).Dgt + (l1 + l2 + l3) < 50L) {
          break label113;
        }
      }
      label113:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject = a.Dgo;
          a.a(this.DgK);
        }
        AppMethodBeat.o(124804);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class h
    implements Runnable
  {
    public h(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124807);
      ac.d("MicroMsg.BizImageBlankReporter", "alvinluo resumeAll");
      Object localObject1 = a.Dgo;
      a.uR(false);
      localObject1 = a.Dgo;
      localObject1 = a.eKt().keySet();
      k.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = a.Dgo;
        localObject2 = (a.b)a.eKt().get(str);
        if ((localObject2 != null) && (((a.b)localObject2).DgB))
        {
          a locala = a.Dgo;
          k.g(str, "url");
          ac.d("MicroMsg.BizImageBlankReporter", "alvinluo resume Scroll_Fling id: %s", new Object[] { a.aFT(str) });
          ((a.b)localObject2).aC(9, this.iim);
        }
      }
      AppMethodBeat.o(124807);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class i
    implements Runnable
  {
    public i(String paramString, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124808);
      Object localObject = a.Dgo;
      localObject = (a.b)a.eKt().get(this.kFm);
      if (localObject != null)
      {
        long l = this.iim;
        ((a.b)localObject).retryCount += 1;
        a.a locala = (a.a)((a.b)localObject).DgD.get(Integer.valueOf(3));
        if (locala != null)
        {
          if (locala.status == 4)
          {
            ac.i("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload force restart id: %s", new Object[] { ((a.b)localObject).id });
            locala.status = 1;
            locala.zJ(l);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class j
    implements Runnable
  {
    public j(Set paramSet, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124809);
      Object localObject1 = ((Iterable)this.DgM).iterator();
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
          localObject3 = a.Dgo;
          localObject2 = (a.b)a.eKt().get(localObject2);
          if (localObject2 == null) {
            break;
          }
          l = this.iim;
          localObject3 = (a.a)((a.b)localObject2).DgD.get(Integer.valueOf(((a.b)localObject2).ikz));
          if (localObject3 != null) {
            ((a.a)localObject3).zJ(l);
          }
          ((a.b)localObject2).DgC = true;
          if (!((a.b)localObject2).DgB) {
            break;
          }
          localObject2 = (a.a)((a.b)localObject2).DgD.get(Integer.valueOf(9));
          if (localObject2 == null) {
            break;
          }
          ((a.a)localObject2).zJ(l);
          break;
        }
      }
      localObject1 = a.Dgo;
      localObject1 = a.eKt().keySet();
      k.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = a.Dgo;
        localObject2 = (a.b)a.eKt().get(localObject2);
        if ((localObject2 != null) && (!this.DgM.contains(((a.b)localObject2).url)))
        {
          l = this.iim;
          localObject3 = (a.a)((a.b)localObject2).DgD.get(Integer.valueOf(((a.b)localObject2).ikz));
          if (localObject3 != null) {
            ((a.a)localObject3).zK(l);
          }
          ((a.b)localObject2).DgC = false;
          if (((a.b)localObject2).DgB)
          {
            localObject2 = (a.a)((a.b)localObject2).DgD.get(Integer.valueOf(9));
            if (localObject2 != null) {
              ((a.a)localObject2).zK(l);
            }
          }
        }
      }
      AppMethodBeat.o(124809);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124810);
      Object localObject1 = a.Dgo;
      Object localObject2 = (a.b)a.eKt().get(this.kFm);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a.b(this.kFm);
        localObject2 = a.Dgo;
        ((Map)a.eKt()).put(this.kFm, localObject1);
      }
      ((a.b)localObject1).aB(paramInt, paramLong);
      AppMethodBeat.o(124810);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class l
    implements Runnable
  {
    public l(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124811);
      ac.d("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling");
      Object localObject1 = a.Dgo;
      a.uR(true);
      localObject1 = a.Dgo;
      localObject1 = a.eKt().keySet();
      k.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        a locala = a.Dgo;
        localObject2 = (a.b)a.eKt().get(localObject2);
        if ((localObject2 != null) && (!((a.b)localObject2).sRE) && (!((a.b)localObject2).eKx()))
        {
          locala = a.Dgo;
          ac.v("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling task not running and start SCROLL_FLING id: %s, %s", new Object[] { a.aFT(((a.b)localObject2).url), ((a.b)localObject2).url });
          ((a.b)localObject2).aB(9, this.iim);
        }
      }
      AppMethodBeat.o(124811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a
 * JD-Core Version:    0.7.0.1
 */