package com.tencent.mm.pluginsdk.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter;", "", "()V", "ENABLE_CHECK_ON_SCREEN", "", "HOST_NAME_MAP", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "REPORT_THREAD_LOOP_TAG", "TAG", "appMsgUrlMap", "isFlinging", "mLoadCountInfo", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "reportInfoMap", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "clearAppMsgUrl", "", "fillReportInfo", "reportInfo", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "finishAction", "action", "", "url", "timestamp", "", "finishAndReport", "getAppMsgKey", "msgId", "msgIndex", "getIdByUrl", "plusImageLoadCount", "reportBlank", "reportImageLoadCountInfo", "resetImageLoadCountInfo", "resumeAll", "retryDownload", "runTask", "runnable", "Ljava/lang/Runnable;", "setAppMsgUrl", "appMsgUrl", "showList", "urlSet", "", "simplifyUrl", "startAction", "startLoad", "item", "Lcom/tencent/mm/message/BizReaderItem;", "cellPosition", "stopAllByFling", "Action", "ActionTimeInfo", "BizImageBlankReportInfo", "ImageLoadCountInfo", "Status", "plugin-biz_release"})
public final class a
{
  static final HashMap<String, b> BNV;
  static final HashMap<String, String> BNW;
  private static a.c BNX;
  public static boolean BNY;
  private static final HashMap<String, String> BNZ;
  public static final a BOa;
  
  static
  {
    AppMethodBeat.i(124821);
    BOa = new a();
    BNV = new HashMap();
    BNW = new HashMap();
    BNX = new a.c();
    BNZ = ae.c(new o[] { u.P("mp.weixin.qq.com", "1"), u.P("mmbiz.qpic.cn", "2"), u.P("vpic.video.qq.com", "3"), u.P("mmbiz.qlogo.cn", "4") });
    AppMethodBeat.o(124821);
  }
  
  public static String aAB(String paramString)
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
  
  static String aa(long paramLong, int paramInt)
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
      u((Runnable)new k(paramString, paramInt, paramLong));
      AppMethodBeat.o(124815);
      return;
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static void euX()
  {
    AppMethodBeat.i(124813);
    BNW.clear();
    AppMethodBeat.o(124813);
  }
  
  public static void euY()
  {
    AppMethodBeat.i(124819);
    h.Iye.f((Runnable)a.g.BOx, "biz_image_blank_report");
    AppMethodBeat.o(124819);
  }
  
  public static void i(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(124812);
    k.h(paramString, "appMsgUrl");
    ((Map)BNW).put(aa(paramLong, paramInt), paramString);
    AppMethodBeat.o(124812);
  }
  
  public static void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(124818);
    k.h(paramRunnable, "runnable");
    aq.f(paramRunnable);
    AppMethodBeat.o(124818);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "", "id", "", "action", "", "(Ljava/lang/String;I)V", "getAction", "()I", "setAction", "(I)V", "begin", "", "getBegin", "()J", "setBegin", "(J)V", "end", "getEnd", "setEnd", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "total", "getTotal", "setTotal", "addTime", "", "finish", "timestamp", "isFinished", "", "onResume", "pause", "reset", "resume", "start", "plugin-biz_release"})
  public static final class a
  {
    int action;
    long bdV;
    private long csJ;
    long dpt;
    String id;
    int status;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(124794);
      this.action = -1;
      this.id = "";
      this.dpt = 0L;
      this.csJ = 0L;
      this.bdV = 0L;
      this.status = 0;
      this.id = paramString;
      this.action = paramInt;
      AppMethodBeat.o(124794);
    }
    
    final void evc()
    {
      if (this.bdV >= this.csJ) {
        this.dpt += this.bdV - this.csJ;
      }
    }
    
    public final boolean isFinished()
    {
      return this.status == 4;
    }
    
    public final void vg(long paramLong)
    {
      AppMethodBeat.i(124792);
      if ((this.status == 3) || (this.status == 1))
      {
        ad.v("MicroMsg.BizImageBlankReporter", "alvinluo resume action: %d, id: %s, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Long.valueOf(paramLong) });
        this.status = 2;
        if (paramLong < 0L) {
          break label83;
        }
      }
      for (;;)
      {
        this.csJ = paramLong;
        this.bdV = 0L;
        AppMethodBeat.o(124792);
        return;
        label83:
        paramLong = System.currentTimeMillis();
      }
    }
    
    public final void vh(long paramLong)
    {
      AppMethodBeat.i(124793);
      if (this.status == 2)
      {
        ad.v("MicroMsg.BizImageBlankReporter", "alvinluo pause action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Integer.valueOf(this.status), Long.valueOf(paramLong) });
        if (paramLong < 0L) {
          break label84;
        }
      }
      for (;;)
      {
        this.bdV = paramLong;
        evc();
        this.status = 3;
        AppMethodBeat.o(124793);
        return;
        label84:
        paramLong = System.currentTimeMillis();
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "", "url", "", "(Ljava/lang/String;)V", "actionTimePointMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "Lkotlin/collections/HashMap;", "appMsgUrl", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "currentAction", "getCurrentAction", "()I", "setCurrentAction", "(I)V", "downloadSuccess", "", "getDownloadSuccess", "()Z", "setDownloadSuccess", "(Z)V", "hasTask", "getHasTask", "setHasTask", "id", "imageSize", "", "getImageSize", "()J", "setImageSize", "(J)V", "isPausedByScrollFling", "setPausedByScrollFling", "isTaskRunning", "setTaskRunning", "local", "getLocal", "setLocal", "netType", "getNetType", "setNetType", "onScreen", "getOnScreen", "setOnScreen", "position", "getPosition", "setPosition", "resultValid", "retryCount", "getRetryCount", "setRetryCount", "timeFile", "getTimeFile", "setTimeFile", "timeHevc", "getTimeHevc", "setTimeHevc", "timeNet", "getTimeNet", "setTimeNet", "timeScroll", "getTimeScroll", "setTimeScroll", "timeTaskRun", "getTimeTaskRun", "setTimeTaskRun", "timeThread", "getTimeThread", "setTimeThread", "timeTotal", "getTimeTotal", "setTimeTotal", "getUrl", "setUrl", "fillResult", "", "fillTime", "action", "time", "finish", "timestamp", "hide", "isBlank", "isFinished", "isResultValid", "offScreen", "pause", "reset", "resume", "retryDownload", "show", "start", "toString", "plugin-biz_release"})
  public static final class b
  {
    long BOb;
    long BOc;
    long BOd;
    long BOe;
    long BOf;
    long BOg;
    private long BOh;
    String BOi;
    long BOj;
    boolean BOk;
    boolean BOl;
    boolean BOm;
    boolean BOn;
    boolean BOo;
    HashMap<Integer, a.a> BOp;
    boolean BOq;
    int hKc;
    String id;
    int position;
    String qGK;
    boolean rJP;
    int retryCount;
    String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(124800);
      this.url = "";
      this.BOi = "";
      this.qGK = "";
      this.position = -1;
      this.hKc = -1;
      this.id = "";
      this.BOp = new HashMap();
      this.url = paramString;
      a locala = a.BOa;
      this.id = a.aAB(paramString);
      AppMethodBeat.o(124800);
    }
    
    public final void aAC(String paramString)
    {
      AppMethodBeat.i(124795);
      k.h(paramString, "<set-?>");
      this.BOi = paramString;
      AppMethodBeat.o(124795);
    }
    
    public final void aB(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124797);
      a.a locala1;
      if (paramInt == 2)
      {
        this.rJP = true;
        this.BOm = true;
        a.a locala2 = (a.a)this.BOp.get(Integer.valueOf(paramInt));
        locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a.a(this.id, paramInt);
          ((Map)this.BOp).put(Integer.valueOf(paramInt), locala1);
        }
        if (locala1.status == 0)
        {
          ad.v("MicroMsg.BizImageBlankReporter", "alvinluo start action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(locala1.action), locala1.id, Integer.valueOf(locala1.status), Long.valueOf(paramLong) });
          locala1.status = 1;
        }
        if ((paramInt != 1) && (paramInt != 2)) {
          break label187;
        }
        locala1.vg(paramLong);
      }
      for (;;)
      {
        if (paramInt != 9) {
          this.hKc = paramInt;
        }
        AppMethodBeat.o(124797);
        return;
        if (paramInt != 9) {
          break;
        }
        this.BOn = true;
        break;
        label187:
        locala1.vg(paramLong);
      }
    }
    
    public final void aC(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124798);
      a.a locala = (a.a)this.BOp.get(Integer.valueOf(paramInt));
      if ((locala != null) && ((locala.status == 2) || (locala.status == 3)))
      {
        ad.v("MicroMsg.BizImageBlankReporter", "alvinluo finish action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(locala.action), locala.id, Integer.valueOf(locala.status), Long.valueOf(paramLong) });
        if (locala.status == 2) {
          if (paramLong < 0L) {
            break label146;
          }
        }
      }
      for (;;)
      {
        locala.bdV = paramLong;
        locala.evc();
        locala.status = 4;
        this.hKc = -1;
        if (paramInt == 9) {
          this.BOn = false;
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
        this.BOb = paramLong;
        return;
      case 3: 
        this.BOd = paramLong;
        return;
      case 5: 
      case 6: 
      case 7: 
        this.BOc += paramLong;
        return;
      case 4: 
        this.BOb = paramLong;
        return;
      case 8: 
        this.BOg = paramLong;
        return;
      case 2: 
        this.BOh = paramLong;
        return;
      }
      this.BOe = paramLong;
    }
    
    public final boolean evd()
    {
      AppMethodBeat.i(124799);
      a.a locala = (a.a)this.BOp.get(Integer.valueOf(1));
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
      Object localObject = z.Jhz;
      int i = hashCode();
      localObject = a.BOa;
      localObject = String.format("BizImageBlankReportInfo %s {id: %s, timeTotal: %d, timeTaskRun: %d, timeFile: %d, timeNet: %d, timeScroll: %d, timeHevc: %d, timeThread: %d, \nnetType: %s, position: %d, imageSize: %d, retryCount: %d, downloadSuccess: %b, local: %b, \nurl: %s}", Arrays.copyOf(new Object[] { Integer.valueOf(i), a.aAB(this.url), Long.valueOf(this.BOb), Long.valueOf(this.BOh), Long.valueOf(this.BOc), Long.valueOf(this.BOd), Long.valueOf(this.BOe), Long.valueOf(this.BOf), Long.valueOf(this.BOg), this.qGK, Integer.valueOf(this.position), Long.valueOf(this.BOj), Integer.valueOf(this.retryCount), Boolean.valueOf(this.BOk), Boolean.valueOf(this.BOl), this.url }, 16));
      k.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(124796);
      return localObject;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124802);
      Object localObject = a.BOa;
      localObject = (a.b)a.euZ().get(this.keu);
      if (localObject != null)
      {
        ((a.b)localObject).aC(this.hHH, this.BOu);
        AppMethodBeat.o(124802);
        return;
      }
      AppMethodBeat.o(124802);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString, long paramLong, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(124803);
      if (((CharSequence)this.keu).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(124803);
        return;
      }
      Object localObject = a.BOa;
      a.b localb = (a.b)a.euZ().get(this.keu);
      if (localb == null)
      {
        AppMethodBeat.o(124803);
        return;
      }
      if (localb.evd())
      {
        localObject = a.BOa;
        ad.w("MicroMsg.BizImageBlankReporter", "alvinluo finishAndReport id: %s TOTAL is finished", new Object[] { a.aAB(this.keu) });
        localObject = a.BOa;
        a.euZ().remove(this.keu);
        AppMethodBeat.o(124803);
        return;
      }
      localb.aC(1, this.hHK);
      localObject = localb.BOp.keySet();
      k.g(localObject, "actionTimePointMap.keys");
      localObject = ((Iterable)localObject).iterator();
      boolean bool = true;
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        a.a locala = (a.a)localb.BOp.get(localInteger);
        if (locala == null) {
          break label422;
        }
        if (locala.isFinished())
        {
          k.g(localInteger, "action");
          localb.aD(localInteger.intValue(), locala.dpt);
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
          while ((localInteger.intValue() != 9) || (localb.BOm))
          {
            ad.e("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult invalid action: %d, id: %s", new Object[] { localInteger, localb.id });
            bool = false;
            break;
            if ((localInteger.intValue() != 8) || (localb.BOm)) {
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
      localb.BOq = bool;
      bool = localb.BOq;
      localObject = (a.a)localb.BOp.get(Integer.valueOf(1));
      if (localObject != null) {}
      for (localObject = Long.valueOf(((a.a)localObject).dpt);; localObject = null)
      {
        ad.d("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult resultValid: %b, timeTotal: %s, id: %s", new Object[] { Boolean.valueOf(bool), localObject, localb.id });
        label422:
        localObject = a.BOa;
        a.euZ().remove(this.keu);
        localObject = a.BOa;
        a.a(localb, this.BOv);
        AppMethodBeat.o(124803);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a.b paramb, b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(124804);
      Object localObject = a.BOa;
      a.b(this.BOw, this.BOv);
      localObject = a.BOa;
      a.a(this.BOv);
      if (this.BOw.BOq)
      {
        localObject = this.BOw;
        long l1 = ((a.b)localObject).BOc;
        long l2 = ((a.b)localObject).BOd;
        long l3 = ((a.b)localObject).BOe;
        if (((a.b)localObject).BOf + (l1 + l2 + l3) < 50L) {
          break label113;
        }
      }
      label113:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject = a.BOa;
          a.a(this.BOw);
        }
        AppMethodBeat.o(124804);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class h
    implements Runnable
  {
    public h(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124807);
      ad.d("MicroMsg.BizImageBlankReporter", "alvinluo resumeAll");
      Object localObject1 = a.BOa;
      a.tQ(false);
      localObject1 = a.BOa;
      localObject1 = a.euZ().keySet();
      k.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = a.BOa;
        localObject2 = (a.b)a.euZ().get(str);
        if ((localObject2 != null) && (((a.b)localObject2).BOn))
        {
          a locala = a.BOa;
          k.g(str, "url");
          ad.d("MicroMsg.BizImageBlankReporter", "alvinluo resume Scroll_Fling id: %s", new Object[] { a.aAB(str) });
          ((a.b)localObject2).aC(9, this.hHK);
        }
      }
      AppMethodBeat.o(124807);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class i
    implements Runnable
  {
    public i(String paramString, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124808);
      Object localObject = a.BOa;
      localObject = (a.b)a.euZ().get(this.keu);
      if (localObject != null)
      {
        long l = this.hHK;
        ((a.b)localObject).retryCount += 1;
        a.a locala = (a.a)((a.b)localObject).BOp.get(Integer.valueOf(3));
        if (locala != null)
        {
          if (locala.status == 4)
          {
            ad.i("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload force restart id: %s", new Object[] { ((a.b)localObject).id });
            locala.status = 1;
            locala.vg(l);
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class j
    implements Runnable
  {
    public j(Set paramSet, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124809);
      Object localObject1 = ((Iterable)this.BOy).iterator();
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
          localObject3 = a.BOa;
          localObject2 = (a.b)a.euZ().get(localObject2);
          if (localObject2 == null) {
            break;
          }
          l = this.hHK;
          localObject3 = (a.a)((a.b)localObject2).BOp.get(Integer.valueOf(((a.b)localObject2).hKc));
          if (localObject3 != null) {
            ((a.a)localObject3).vg(l);
          }
          ((a.b)localObject2).BOo = true;
          if (!((a.b)localObject2).BOn) {
            break;
          }
          localObject2 = (a.a)((a.b)localObject2).BOp.get(Integer.valueOf(9));
          if (localObject2 == null) {
            break;
          }
          ((a.a)localObject2).vg(l);
          break;
        }
      }
      localObject1 = a.BOa;
      localObject1 = a.euZ().keySet();
      k.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = a.BOa;
        localObject2 = (a.b)a.euZ().get(localObject2);
        if ((localObject2 != null) && (!this.BOy.contains(((a.b)localObject2).url)))
        {
          l = this.hHK;
          localObject3 = (a.a)((a.b)localObject2).BOp.get(Integer.valueOf(((a.b)localObject2).hKc));
          if (localObject3 != null) {
            ((a.a)localObject3).vh(l);
          }
          ((a.b)localObject2).BOo = false;
          if (((a.b)localObject2).BOn)
          {
            localObject2 = (a.a)((a.b)localObject2).BOp.get(Integer.valueOf(9));
            if (localObject2 != null) {
              ((a.a)localObject2).vh(l);
            }
          }
        }
      }
      AppMethodBeat.o(124809);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(String paramString, int paramInt, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124810);
      Object localObject1 = a.BOa;
      Object localObject2 = (a.b)a.euZ().get(this.keu);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a.b(this.keu);
        localObject2 = a.BOa;
        ((Map)a.euZ()).put(this.keu, localObject1);
      }
      ((a.b)localObject1).aB(paramInt, paramLong);
      AppMethodBeat.o(124810);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class l
    implements Runnable
  {
    public l(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124811);
      ad.d("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling");
      Object localObject1 = a.BOa;
      a.tQ(true);
      localObject1 = a.BOa;
      localObject1 = a.euZ().keySet();
      k.g(localObject1, "reportInfoMap.keys");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        a locala = a.BOa;
        localObject2 = (a.b)a.euZ().get(localObject2);
        if ((localObject2 != null) && (!((a.b)localObject2).rJP) && (!((a.b)localObject2).evd()))
        {
          locala = a.BOa;
          ad.v("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling task not running and start SCROLL_FLING id: %s, %s", new Object[] { a.aAB(((a.b)localObject2).url), ((a.b)localObject2).url });
          ((a.b)localObject2).aB(9, this.hHK);
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