package com.tencent.mm.pluginsdk.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.plugin.biz.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.n.f;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter;", "", "()V", "ENABLE_CHECK_ON_SCREEN", "", "HOST_NAME_MAP", "Ljava/util/HashMap;", "", "kotlin.jvm.PlatformType", "Lkotlin/collections/HashMap;", "REPORT_THREAD_LOOP_TAG", "TAG", "appMsgUrlMap", "isFlinging", "mLoadCountInfo", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "reportInfoMap", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "clearAppMsgUrl", "", "fillReportInfo", "reportInfo", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "finishAction", "action", "", "url", "timestamp", "", "finishAndReport", "getAppMsgKey", "msgId", "msgIndex", "getIdByUrl", "plusImageLoadCount", "reportBlank", "reportImageLoadCountInfo", "resetImageLoadCountInfo", "resumeAll", "retryDownload", "runTask", "runnable", "Ljava/lang/Runnable;", "setAppMsgUrl", "appMsgUrl", "showList", "urlSet", "", "simplifyUrl", "startAction", "startLoad", "item", "Lcom/tencent/mm/message/BizReaderItem;", "cellPosition", "stopAllByFling", "Action", "ActionTimeInfo", "BizImageBlankReportInfo", "ImageLoadCountInfo", "Status", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  static final HashMap<String, b> LDk;
  public static final e XQp;
  static final HashMap<String, String> XQq;
  private static e.c XQr;
  static boolean XQs;
  private static final HashMap<String, String> XQt;
  
  static
  {
    AppMethodBeat.i(124821);
    XQp = new e();
    LDk = new HashMap();
    XQq = new HashMap();
    XQr = new e.c();
    XQt = ak.g(new r[] { v.Y(WeChatHosts.domainString(b.f.host_mp_weixin_qq_com), "1"), v.Y("mmbiz.qpic.cn", "2"), v.Y("vpic.video.qq.com", "3"), v.Y("mmbiz.qlogo.cn", "4") });
    AppMethodBeat.o(124821);
  }
  
  public static void J(Set<String> paramSet)
  {
    AppMethodBeat.i(244758);
    s.u(paramSet, "urlSet");
    Set localSet = (Set)new LinkedHashSet();
    localSet.addAll((Collection)paramSet);
    y(new e..ExternalSyntheticLambda7(localSet, System.currentTimeMillis()));
    AppMethodBeat.o(244758);
  }
  
  private static final void K(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(244775);
    b localb2 = (b)LDk.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b(paramString);
      ((Map)LDk).put(paramString, localb1);
    }
    localb1.bl(paramInt, paramLong);
    AppMethodBeat.o(244775);
  }
  
  private static final void L(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(244784);
    paramString = (b)LDk.get(paramString);
    if (paramString != null) {
      paramString.bm(paramInt, paramLong);
    }
    AppMethodBeat.o(244784);
  }
  
  private static final void a(b paramb, b paramb1)
  {
    int j = 1;
    AppMethodBeat.i(244807);
    s.u(paramb, "$reportInfo");
    int i;
    boolean bool;
    label43:
    long l1;
    label58:
    Object localObject2;
    Object localObject4;
    if ((paramb1 != null) && (paramb1.from == 2))
    {
      i = 1;
      if (i == 0) {
        break label507;
      }
      if (paramb1.data == null) {
        break label501;
      }
      bool = true;
      paramb.XQD = bool;
      if (paramb1 != null) {
        break label551;
      }
      l1 = -1L;
      paramb.XQC = l1;
      localObject1 = com.tencent.mm.pluginsdk.ui.applet.g.Ybp;
      localObject1 = com.tencent.mm.pluginsdk.ui.applet.g.lB(MMApplicationContext.getContext());
      s.u(localObject1, "<set-?>");
      paramb.GtP = ((String)localObject1);
      localObject2 = paramb.XQB;
      localObject4 = new k("https?://([0-9a-zA-Z.]+)/").n((CharSequence)localObject2, 0);
      if (localObject4 != null) {
        break label561;
      }
    }
    label514:
    label545:
    label551:
    label561:
    for (Object localObject1 = null;; localObject1 = ((kotlin.n.i)localObject4).kBo())
    {
      if (localObject1 != null) {
        break label573;
      }
      paramb.bps((String)localObject2);
      if (paramb.XQC <= 0L) {
        paramb.XQC = com.tencent.mm.vfs.y.bEl(y.bpF(paramb.url));
      }
      localObject1 = XQr;
      ((e.c)localObject1).lNX += 1;
      if ((paramb1 == null) || (paramb1.from != 0)) {
        break label802;
      }
      i = 1;
      label190:
      if (i == 0) {
        break label807;
      }
      paramb1 = XQr;
      paramb1.XQL += 1;
      label208:
      label370:
      if (paramb.XQI)
      {
        if (paramb.XQv + paramb.XQw + paramb.XQx + paramb.XQy < 50L) {
          break label887;
        }
        i = 1;
        label243:
        if (i != 0)
        {
          Log.i("MicroMsg.BizImageBlankReporter", "alvinluo reportBlank doReport reportInfo %s", new Object[] { paramb });
          paramb1 = com.tencent.mm.pluginsdk.ui.applet.g.Ybp;
          paramb1 = Uri.parse(paramb.url);
          s.s(paramb1, "parse(reportInfo.url)");
          paramb1 = com.tencent.mm.pluginsdk.ui.applet.g.b(paramb1, "tp");
          s.u(paramb1, "<set-?>");
          paramb.url = paramb1;
          paramb1 = com.tencent.mm.plugin.report.service.h.OAn;
          l1 = paramb.XQu;
          long l2 = paramb.XQv;
          long l3 = paramb.XQw;
          long l4 = paramb.XQx;
          int k = paramb.position;
          localObject1 = paramb.GtP;
          localObject2 = paramb.url;
          long l5 = paramb.XQC;
          int m = paramb.retryCount;
          if (!paramb.XQD) {
            break label892;
          }
          i = j;
          paramb1.b(17611, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(k), localObject1, localObject2, Long.valueOf(l5), Integer.valueOf(m), Integer.valueOf(i), Long.valueOf(paramb.XQy), Long.valueOf(paramb.XQz), paramb.XQB });
        }
      }
      AppMethodBeat.o(244807);
      return;
      i = 0;
      break;
      label501:
      bool = false;
      break label43;
      label507:
      if (paramb1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label545;
        }
      }
      for (bool = true;; bool = false)
      {
        paramb.XQD = bool;
        paramb.NIH = true;
        break;
        localObject1 = paramb1.bitmap;
        break label514;
      }
      l1 = paramb1.oKT;
      break label58;
    }
    label573:
    Object localObject3;
    if (((kotlin.n.i)localObject4).kBo().size() > 1)
    {
      localObject1 = ((kotlin.n.i)localObject4).kBo().aMz(1);
      if (localObject1 == null)
      {
        localObject3 = null;
        localObject1 = ((kotlin.n.i)localObject4).kBo().aMz(1);
        if (localObject1 != null) {
          break label697;
        }
        localObject1 = null;
        label635:
        localObject3 = (String)XQt.get(localObject3);
        if (localObject3 != null) {
          break label707;
        }
        localObject3 = "0";
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          if (localObject2 == null)
          {
            paramb = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(244807);
            throw paramb;
            localObject3 = ((f)localObject1).value;
            break;
            label697:
            localObject1 = ((f)localObject1).ajuK;
            break label635;
            label707:
            continue;
          }
          localObject4 = (CharSequence)localObject2;
          localObject3 = (CharSequence)localObject3;
          s.u(localObject4, "$this$replaceRange");
          s.u(localObject1, "range");
          s.u(localObject3, "replacement");
        }
      }
    }
    for (localObject1 = n.a((CharSequence)localObject4, ((kotlin.k.e)localObject1).fIj, ((kotlin.k.e)localObject1).aixs + 1, (CharSequence)localObject3).toString();; localObject1 = localObject2)
    {
      Log.v("MicroMsg.BizImageBlankReporter", "alvinluo simplifyAppMsg old: %s, new: %s", new Object[] { localObject2, localObject1 });
      localObject2 = localObject1;
      break;
      label802:
      i = 0;
      break label190;
      label807:
      if ((paramb1 != null) && (paramb1.from == 1)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label847;
        }
        paramb1 = XQr;
        paramb1.XQK += 1;
        break;
      }
      label847:
      if ((paramb1 != null) && (paramb1.from == 2)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label885;
        }
        paramb1 = XQr;
        paramb1.XQJ += 1;
        break;
      }
      label885:
      break label208;
      label887:
      i = 0;
      break label243;
      label892:
      i = 0;
      break label370;
    }
  }
  
  private static final void a(String paramString, long paramLong, b paramb)
  {
    AppMethodBeat.i(244771);
    s.u(paramString, "$url");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(244771);
      return;
    }
    b localb = (b)LDk.get(paramString);
    if (localb == null)
    {
      AppMethodBeat.o(244771);
      return;
    }
    if (localb.iHL())
    {
      Log.w("MicroMsg.BizImageBlankReporter", "alvinluo finishAndReport id: %s TOTAL is finished", new Object[] { bpr(paramString) });
      LDk.remove(paramString);
      AppMethodBeat.o(244771);
      return;
    }
    localb.bm(1, paramLong);
    Object localObject = localb.XQH.keySet();
    s.s(localObject, "actionTimePointMap.keys");
    localObject = ((Iterable)localObject).iterator();
    boolean bool = true;
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      a locala = (a)localb.XQH.get(localInteger);
      if (locala == null) {
        break label430;
      }
      if (locala.isFinished())
      {
        s.s(localInteger, "action");
        localb.bn(localInteger.intValue(), locala.total);
      }
      else
      {
        if (localInteger == null) {
          label234:
          if (localInteger != null) {
            break label314;
          }
        }
        label314:
        while ((localInteger.intValue() != 9) || (localb.XQE))
        {
          Log.e("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult invalid action: %d, id: %s", new Object[] { localInteger, localb.id });
          bool = false;
          break;
          if ((localInteger.intValue() != 8) || (localb.XQE)) {
            break label234;
          }
          s.s(localInteger, "action");
          localb.bn(localInteger.intValue(), 0L);
          bool = true;
          break;
        }
        s.s(localInteger, "action");
        localb.bn(localInteger.intValue(), 0L);
        bool = true;
      }
    }
    localb.XQI = bool;
    bool = localb.XQI;
    localObject = (a)localb.XQH.get(Integer.valueOf(1));
    if (localObject == null) {}
    for (localObject = null;; localObject = Long.valueOf(((a)localObject).total))
    {
      Log.d("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult resultValid: %b, timeTotal: %s, id: %s", new Object[] { Boolean.valueOf(bool), localObject, localb.id });
      label430:
      LDk.remove(paramString);
      com.tencent.threadpool.h.ahAA.g(new e..ExternalSyntheticLambda2(localb, paramb), "biz_image_blank_report");
      AppMethodBeat.o(244771);
      return;
    }
  }
  
  private static final void a(Set paramSet, long paramLong)
  {
    AppMethodBeat.i(244789);
    s.u(paramSet, "$urlList");
    Object localObject1 = ((Iterable)paramSet).iterator();
    Object localObject2;
    a locala;
    label164:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (((CharSequence)localObject2).length() == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label164;
        }
        localObject2 = (b)LDk.get(localObject2);
        if (localObject2 == null) {
          break;
        }
        locala = (a)((b)localObject2).XQH.get(Integer.valueOf(((b)localObject2).pmw));
        if (locala != null) {
          locala.yd(paramLong);
        }
        ((b)localObject2).XQG = true;
        if (!((b)localObject2).XQF) {
          break;
        }
        localObject2 = (a)((b)localObject2).XQH.get(Integer.valueOf(9));
        if (localObject2 == null) {
          break;
        }
        ((a)localObject2).yd(paramLong);
        break;
      }
    }
    localObject1 = LDk.keySet();
    s.s(localObject1, "reportInfoMap.keys");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (b)LDk.get(localObject2);
      if ((localObject2 != null) && (!paramSet.contains(((b)localObject2).url)))
      {
        locala = (a)((b)localObject2).XQH.get(Integer.valueOf(((b)localObject2).pmw));
        if (locala != null) {
          locala.yf(paramLong);
        }
        ((b)localObject2).XQG = false;
        if (((b)localObject2).XQF)
        {
          localObject2 = (a)((b)localObject2).XQH.get(Integer.valueOf(9));
          if (localObject2 != null) {
            ((a)localObject2).yf(paramLong);
          }
        }
      }
    }
    AppMethodBeat.o(244789);
  }
  
  static String aK(long paramLong, int paramInt)
  {
    AppMethodBeat.i(124814);
    String str = paramLong + ',' + paramInt;
    AppMethodBeat.o(124814);
    return str;
  }
  
  public static void b(String paramString, b paramb)
  {
    AppMethodBeat.i(244739);
    s.u(paramString, "url");
    y(new e..ExternalSyntheticLambda6(paramString, System.currentTimeMillis(), paramb));
    AppMethodBeat.o(244739);
  }
  
  public static void bpq(String paramString)
  {
    AppMethodBeat.i(244760);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(244760);
      return;
    }
    Log.d("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload id: %s, url: %s", new Object[] { bpr(paramString), paramString });
    y(new e..ExternalSyntheticLambda5(paramString, System.currentTimeMillis()));
    AppMethodBeat.o(244760);
  }
  
  public static String bpr(String paramString)
  {
    AppMethodBeat.i(124820);
    s.u(paramString, "url");
    paramString = paramString.getBytes(d.UTF_8);
    s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = com.tencent.mm.b.g.getMessageDigest(paramString);
    s.s(paramString, "getMessageDigest(url.toByteArray())");
    AppMethodBeat.o(124820);
    return paramString;
  }
  
  private static final void ci(String paramString, long paramLong)
  {
    AppMethodBeat.i(244796);
    paramString = (b)LDk.get(paramString);
    a locala;
    if (paramString != null)
    {
      paramString.retryCount += 1;
      locala = (a)paramString.XQH.get(Integer.valueOf(3));
      if ((locala == null) || (locala.status != 4)) {
        break label106;
      }
    }
    label106:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload force restart id: %s", new Object[] { paramString.id });
        locala.status = 1;
        locala.yd(paramLong);
      }
      AppMethodBeat.o(244796);
      return;
    }
  }
  
  public static void e(int paramInt, String paramString, long paramLong)
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
      y(new e..ExternalSyntheticLambda3(paramString, paramInt, paramLong));
      AppMethodBeat.o(124815);
      return;
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static void iHF()
  {
    AppMethodBeat.i(124813);
    XQq.clear();
    AppMethodBeat.o(124813);
  }
  
  public static void iHG()
  {
    AppMethodBeat.i(244753);
    if (!XQs)
    {
      AppMethodBeat.o(244753);
      return;
    }
    y(new e..ExternalSyntheticLambda1(System.currentTimeMillis()));
    AppMethodBeat.o(244753);
  }
  
  public static void iHH()
  {
    AppMethodBeat.i(244755);
    if (XQs)
    {
      AppMethodBeat.o(244755);
      return;
    }
    y(new e..ExternalSyntheticLambda0(System.currentTimeMillis()));
    AppMethodBeat.o(244755);
  }
  
  public static void iHI()
  {
    AppMethodBeat.i(124819);
    com.tencent.threadpool.h.ahAA.g(e..ExternalSyntheticLambda8.INSTANCE, "biz_image_blank_report");
    AppMethodBeat.o(124819);
  }
  
  private static final void iHJ()
  {
    AppMethodBeat.i(244813);
    Log.i("MicroMsg.BizImageBlankReporter", "alvinluo reportImageLoadCountInfo %s", new Object[] { XQr });
    com.tencent.mm.plugin.report.service.h.OAn.b(17890, new Object[] { Integer.valueOf(XQr.lNX), Integer.valueOf(XQr.XQL), Integer.valueOf(XQr.XQK), Integer.valueOf(XQr.XQJ) });
    Log.i("MicroMsg.BizImageBlankReporter", "alvinluo resetImageLoadCountInfo %s", new Object[] { XQr });
    e.c localc = XQr;
    localc.lNX = 0;
    localc.XQJ = 0;
    localc.XQK = 0;
    localc.XQL = 0;
    AppMethodBeat.o(244813);
  }
  
  public static void o(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(124812);
    if (paramString == null)
    {
      AppMethodBeat.o(124812);
      return;
    }
    ((Map)XQq).put(aK(paramLong, paramInt), paramString);
    AppMethodBeat.o(124812);
  }
  
  private static void y(Runnable paramRunnable)
  {
    AppMethodBeat.i(124818);
    s.u(paramRunnable, "runnable");
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(124818);
  }
  
  private static final void yb(long paramLong)
  {
    AppMethodBeat.i(244779);
    Log.d("MicroMsg.BizImageBlankReporter", "alvinluo resumeAll");
    XQs = false;
    Object localObject = LDk.keySet();
    s.s(localObject, "reportInfoMap.keys");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      b localb = (b)LDk.get(str);
      if ((localb != null) && (localb.XQF))
      {
        s.s(str, "url");
        Log.d("MicroMsg.BizImageBlankReporter", "alvinluo resume Scroll_Fling id: %s", new Object[] { bpr(str) });
        localb.bm(9, paramLong);
      }
    }
    AppMethodBeat.o(244779);
  }
  
  private static final void yc(long paramLong)
  {
    AppMethodBeat.i(244782);
    Log.d("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling");
    XQs = true;
    Object localObject1 = LDk.keySet();
    s.s(localObject1, "reportInfoMap.keys");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (b)LDk.get(localObject2);
      if ((localObject2 != null) && (!((b)localObject2).HOL) && (!((b)localObject2).iHL()))
      {
        Log.v("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling task not running and start SCROLL_FLING id: %s, %s", new Object[] { bpr(((b)localObject2).url), ((b)localObject2).url });
        ((b)localObject2).bl(9, paramLong);
      }
    }
    AppMethodBeat.o(244782);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "", "id", "", "action", "", "(Ljava/lang/String;I)V", "getAction", "()I", "setAction", "(I)V", "begin", "", "getBegin", "()J", "setBegin", "(J)V", "end", "getEnd", "setEnd", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "total", "getTotal", "setTotal", "addTime", "", "finish", "timestamp", "isFinished", "", "onResume", "pause", "reset", "resume", "start", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private int action;
    private long axI;
    private long begin;
    private String id;
    int status;
    long total;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(124794);
      this.action = -1;
      this.id = "";
      this.total = 0L;
      this.begin = 0L;
      this.axI = 0L;
      this.status = 0;
      this.id = paramString;
      this.action = paramInt;
      AppMethodBeat.o(124794);
    }
    
    private final void iHK()
    {
      if (this.axI >= this.begin) {
        this.total += this.axI - this.begin;
      }
    }
    
    private void ye(long paramLong)
    {
      AppMethodBeat.i(244665);
      this.status = 2;
      if (paramLong >= 0L) {}
      for (;;)
      {
        this.begin = paramLong;
        this.axI = 0L;
        AppMethodBeat.o(244665);
        return;
        paramLong = System.currentTimeMillis();
      }
    }
    
    public final boolean isFinished()
    {
      return this.status == 4;
    }
    
    public final void start(long paramLong)
    {
      AppMethodBeat.i(244679);
      if (this.status == 0)
      {
        Log.v("MicroMsg.BizImageBlankReporter", "alvinluo start action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Integer.valueOf(this.status), Long.valueOf(paramLong) });
        this.status = 1;
      }
      AppMethodBeat.o(244679);
    }
    
    public final void yd(long paramLong)
    {
      AppMethodBeat.i(124792);
      if ((this.status == 3) || (this.status == 1))
      {
        Log.v("MicroMsg.BizImageBlankReporter", "alvinluo resume action: %d, id: %s, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Long.valueOf(paramLong) });
        ye(paramLong);
      }
      AppMethodBeat.o(124792);
    }
    
    public final void yf(long paramLong)
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
        this.axI = paramLong;
        iHK();
        this.status = 3;
        AppMethodBeat.o(124793);
        return;
        label84:
        paramLong = System.currentTimeMillis();
      }
    }
    
    public final void yg(long paramLong)
    {
      AppMethodBeat.i(244703);
      if ((this.status == 2) || (this.status == 3))
      {
        Log.v("MicroMsg.BizImageBlankReporter", "alvinluo finish action: %d, id: %s, status: %d, timestamp: %d", new Object[] { Integer.valueOf(this.action), this.id, Integer.valueOf(this.status), Long.valueOf(paramLong) });
        if (this.status == 2) {
          if (paramLong < 0L) {
            break label100;
          }
        }
      }
      for (;;)
      {
        this.axI = paramLong;
        iHK();
        this.status = 4;
        AppMethodBeat.o(244703);
        return;
        label100:
        paramLong = System.currentTimeMillis();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "", "url", "", "(Ljava/lang/String;)V", "actionTimePointMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "Lkotlin/collections/HashMap;", "appMsgUrl", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "currentAction", "getCurrentAction", "()I", "setCurrentAction", "(I)V", "downloadSuccess", "", "getDownloadSuccess", "()Z", "setDownloadSuccess", "(Z)V", "hasTask", "getHasTask", "setHasTask", "id", "imageSize", "", "getImageSize", "()J", "setImageSize", "(J)V", "isPausedByScrollFling", "setPausedByScrollFling", "isTaskRunning", "setTaskRunning", "local", "getLocal", "setLocal", "netType", "getNetType", "setNetType", "onScreen", "getOnScreen", "setOnScreen", "position", "getPosition", "setPosition", "resultValid", "retryCount", "getRetryCount", "setRetryCount", "timeFile", "getTimeFile", "setTimeFile", "timeHevc", "getTimeHevc", "setTimeHevc", "timeNet", "getTimeNet", "setTimeNet", "timeScroll", "getTimeScroll", "setTimeScroll", "timeTaskRun", "getTimeTaskRun", "setTimeTaskRun", "timeThread", "getTimeThread", "setTimeThread", "timeTotal", "getTimeTotal", "setTimeTotal", "getUrl", "setUrl", "fillResult", "", "fillTime", "action", "time", "finish", "timestamp", "hide", "isBlank", "isFinished", "isResultValid", "offScreen", "pause", "reset", "resume", "retryDownload", "show", "start", "toString", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    String GtP;
    boolean HOL;
    boolean NIH;
    private long XQA;
    String XQB;
    long XQC;
    boolean XQD;
    boolean XQE;
    boolean XQF;
    boolean XQG;
    HashMap<Integer, e.a> XQH;
    boolean XQI;
    long XQu;
    long XQv;
    long XQw;
    long XQx;
    long XQy;
    long XQz;
    String id;
    int pmw;
    int position;
    int retryCount;
    String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(124800);
      this.url = "";
      this.XQB = "";
      this.GtP = "";
      this.position = -1;
      this.pmw = -1;
      this.id = "";
      this.XQH = new HashMap();
      this.url = paramString;
      e locale = e.XQp;
      this.id = e.bpr(paramString);
      AppMethodBeat.o(124800);
    }
    
    public final void bl(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124797);
      e.a locala1;
      switch (paramInt)
      {
      default: 
        e.a locala2 = (e.a)this.XQH.get(Integer.valueOf(paramInt));
        locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new e.a(this.id, paramInt);
          ((Map)this.XQH).put(Integer.valueOf(paramInt), locala1);
        }
        locala1.start(paramLong);
        if ((paramInt == 1) || (paramInt == 2)) {
          locala1.yd(paramLong);
        }
        break;
      }
      for (;;)
      {
        if (paramInt != 9) {
          this.pmw = paramInt;
        }
        AppMethodBeat.o(124797);
        return;
        this.HOL = true;
        this.XQE = true;
        break;
        this.XQF = true;
        break;
        locala1.yd(paramLong);
      }
    }
    
    public final void bm(int paramInt, long paramLong)
    {
      AppMethodBeat.i(124798);
      e.a locala = (e.a)this.XQH.get(Integer.valueOf(paramInt));
      if (locala != null) {
        locala.yg(paramLong);
      }
      this.pmw = -1;
      if (paramInt == 9) {
        this.XQF = false;
      }
      AppMethodBeat.o(124798);
    }
    
    final void bn(int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        this.XQu = paramLong;
        return;
      case 3: 
        this.XQw = paramLong;
        return;
      case 5: 
      case 6: 
      case 7: 
        this.XQv += paramLong;
        return;
      case 4: 
        this.XQu = paramLong;
        return;
      case 8: 
        this.XQz = paramLong;
        return;
      case 2: 
        this.XQA = paramLong;
        return;
      }
      this.XQx = paramLong;
    }
    
    public final void bps(String paramString)
    {
      AppMethodBeat.i(124795);
      s.u(paramString, "<set-?>");
      this.XQB = paramString;
      AppMethodBeat.o(124795);
    }
    
    public final boolean iHL()
    {
      AppMethodBeat.i(124799);
      e.a locala = (e.a)this.XQH.get(Integer.valueOf(1));
      if (locala == null)
      {
        AppMethodBeat.o(124799);
        return true;
      }
      boolean bool = locala.isFinished();
      AppMethodBeat.o(124799);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(124796);
      Object localObject = am.aixg;
      int i = hashCode();
      localObject = e.XQp;
      localObject = String.format("BizImageBlankReportInfo %s {id: %s, timeTotal: %d, timeTaskRun: %d, timeFile: %d, timeNet: %d, timeScroll: %d, timeHevc: %d, timeThread: %d, \nnetType: %s, position: %d, imageSize: %d, retryCount: %d, downloadSuccess: %b, local: %b, \nurl: %s}", Arrays.copyOf(new Object[] { Integer.valueOf(i), e.bpr(this.url), Long.valueOf(this.XQu), Long.valueOf(this.XQA), Long.valueOf(this.XQv), Long.valueOf(this.XQw), Long.valueOf(this.XQx), Long.valueOf(this.XQy), Long.valueOf(this.XQz), this.GtP, Integer.valueOf(this.position), Long.valueOf(this.XQC), Integer.valueOf(this.retryCount), Boolean.valueOf(this.XQD), Boolean.valueOf(this.NIH), this.url }, 16));
      s.s(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(124796);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.e
 * JD-Core Version:    0.7.0.1
 */