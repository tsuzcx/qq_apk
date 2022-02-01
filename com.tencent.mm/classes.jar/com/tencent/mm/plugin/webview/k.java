package com.tencent.mm.plugin.webview;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Looper;
import androidx.lifecycle.j.b;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.plugin.webview.k.p;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.cb;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebTransPageLogic;", "Landroidx/lifecycle/LifecycleOwner;", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "autoCompleteViewJob", "Lkotlinx/coroutines/Job;", "checkFile", "checkTask", "Lcom/tencent/mm/plugin/webview/util/WebViewLanguageCheckTask;", "cyclicTasksInterval", "", "cyclicTasksNum", "", "hasInjectedBefore", "", "getHasInjectedBefore", "()Z", "setHasInjectedBefore", "(Z)V", "hasRepeatSearchNum", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "livePageTransCheckResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/webview/WebTransCheckResult;", "getLivePageTransCheckResult", "()Landroidx/lifecycle/MutableLiveData;", "setLivePageTransCheckResult", "(Landroidx/lifecycle/MutableLiveData;)V", "liveTipsStatus", "Lcom/tencent/mm/plugin/webview/WebTransTipsStatus;", "getLiveTipsStatus", "mCallback", "Lcom/tencent/mm/plugin/webview/PageLogicCallback;", "getMCallback", "()Lcom/tencent/mm/plugin/webview/PageLogicCallback;", "setMCallback", "(Lcom/tencent/mm/plugin/webview/PageLogicCallback;)V", "transBrand", "getTransBrand", "setTransBrand", "(Ljava/lang/String;)V", "transCgiLogic", "Lcom/tencent/mm/plugin/webview/WebTransCgiLogic;", "transFile", "getWebView", "()Lcom/tencent/mm/ui/widget/MMWebView;", "setWebView", "callJSRevertApi", "", "callJSTransApi", "cancelDebounce", "checkHasInjectedBefore", "deBounceTransDone", "delayTime", "executeJS", "script", "executeSearchScript", "jScript", "getJsScript", "fileName", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getWebPageLanguage", "handleWebPageContent", "contentArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "injectScriptAndStartTrans", "injectTransJS", "onDestroy", "onReceivedWebInfo", "content", "onStart", "performCyclicTasks", "replaceHTML", "json", "revertTrans", "setPageLogicCallback", "callback", "startLanguageIdentifier", "sampleArray", "", "([Ljava/lang/String;)V", "unzipAndStoreCache", "pack", "Lcom/tencent/mm/plugin/webview/WebTransData$WebTransPack;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements q
{
  final String TAG;
  String WuQ;
  final d WuR;
  private final String WuS;
  private final String WuT;
  boolean WuU;
  b WuV;
  final x<o> WuW;
  cb WuX;
  private final long WuY;
  private final int WuZ;
  private int Wva;
  private final p Wvb;
  x<e> Wvc;
  androidx.lifecycle.s nvu;
  MMWebView webView;
  
  public k(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(294868);
    this.webView = paramMMWebView;
    this.TAG = "MicroMsg.WebTransPageLogic";
    paramMMWebView = MMApplicationContext.getContext().getResources().getString(c.i.webview_menu_tranlate_tips_brand);
    kotlin.g.b.s.s(paramMMWebView, "getContext().resources.g…menu_tranlate_tips_brand)");
    this.WuQ = paramMMWebView;
    this.WuR = new d();
    this.WuS = "jsapi/doTranslate.js";
    this.WuT = "jsapi/preCheckNeedTrans.js";
    this.WuW = new x();
    this.nvu = new androidx.lifecycle.s((q)this);
    this.nvu.e(j.b.bHi);
    this.WuY = 500L;
    this.WuZ = 10;
    this.Wvb = new p();
    this.Wvc = new x();
    AppMethodBeat.o(294868);
  }
  
  private static final void a(k paramk, f.b paramb)
  {
    AppMethodBeat.i(294910);
    kotlin.g.b.s.u(paramk, "this$0");
    Log.i(paramk.TAG, "get liveTransTextRes");
    if (paramb != null)
    {
      Object localObject1 = new ArrayList();
      Iterator localIterator = ((Iterable)paramb.WuC).iterator();
      label220:
      while (localIterator.hasNext())
      {
        Object localObject2 = (f.a)localIterator.next();
        if ((Util.isNullOrNil(((f.a)localObject2).WuB)) || (Util.isNullOrNil(((f.a)localObject2).Wuz))) {
          Log.w(paramk.TAG, kotlin.g.b.s.X("node.transText == nil or hashCode == nil , node.orgText = ", ((f.a)localObject2).WuA));
        }
        for (;;)
        {
          if ((Util.isNullOrNil(((f.a)localObject2).WuB)) || (Util.isNullOrNil(((f.a)localObject2).WuA))) {
            break label220;
          }
          b localb = paramk.WuV;
          if (localb == null) {
            break;
          }
          String str = ((f.a)localObject2).WuA;
          kotlin.g.b.s.checkNotNull(str);
          localObject2 = ((f.a)localObject2).WuB;
          kotlin.g.b.s.checkNotNull(localObject2);
          localb.nY(str, (String)localObject2);
          break;
          ((ArrayList)localObject1).add(ak.e(new r[] { v.Y("transText", ((f.a)localObject2).WuB), v.Y("hashCode", ((f.a)localObject2).Wuz) }));
        }
      }
      localObject1 = new f((Collection)localObject1).toString();
      kotlin.g.b.s.s(localObject1, "JSONArray(needReplaceTextArr).toString()");
      Log.i(paramk.TAG, kotlin.g.b.s.X("jsonData is ", localObject1));
      if (!Util.isNullOrNil(((f.a)paramb.WuC.get(0)).brand))
      {
        paramb = String.valueOf(((f.a)paramb.WuC.get(0)).brand);
        kotlin.g.b.s.u(paramb, "<set-?>");
        paramk.WuQ = paramb;
      }
      paramk.biT((String)localObject1);
    }
    AppMethodBeat.o(294910);
  }
  
  private static final void a(k paramk, String paramString1, String paramString2)
  {
    AppMethodBeat.i(294927);
    kotlin.g.b.s.u(paramk, "this$0");
    int j;
    String[] arrayOfString;
    int i;
    for (;;)
    {
      Object localObject;
      try
      {
        paramString2 = (JSONArray)new f(paramString2);
        j = paramString2.length();
        arrayOfString = new String[j];
        i = 0;
        if (i >= j) {
          break;
        }
        localObject = paramString2.get(i);
        if (localObject == null)
        {
          paramk = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(294927);
          throw paramk;
        }
      }
      catch (Exception paramk)
      {
        Log.printErrStackTrace("MicroMsg.WebViewTransHelper", (Throwable)paramk, "", new Object[0]);
        AppMethodBeat.o(294927);
        return;
      }
      arrayOfString[i] = ((String)localObject);
      i += 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (paramk.Wva >= paramk.WuZ)
        {
          Log.w("MicroMsg.WebViewTransHelper", "performCyclicTasks finish!");
          AppMethodBeat.o(294927);
          return;
        }
        new MTimerHandler(Looper.getMainLooper(), new k..ExternalSyntheticLambda3(paramk, paramString1), false).startTimer(paramk.WuY * (paramk.Wva + 1));
        AppMethodBeat.o(294927);
        return;
      }
      h.ahAA.bm(new k..ExternalSyntheticLambda4(paramk, arrayOfString));
      AppMethodBeat.o(294927);
      return;
      if (j == 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  private static final void a(k paramk, String[] paramArrayOfString)
  {
    int j = 0;
    AppMethodBeat.i(294938);
    kotlin.g.b.s.u(paramk, "this$0");
    kotlin.g.b.s.u(paramArrayOfString, "$sampleArray");
    p localp = paramk.Wvb;
    Object localObject = LocaleUtil.getApplicationLanguage();
    kotlin.g.b.s.s(localObject, "getApplicationLanguage()");
    kotlin.g.a.a locala = (kotlin.g.a.a)new b(paramk);
    kotlin.g.b.s.u(paramArrayOfString, "sampleArray");
    kotlin.g.b.s.u(localObject, "targetLanguage");
    kotlin.g.b.s.u(locala, "onGetCheckResult");
    int i;
    if (paramArrayOfString.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label275;
      }
      paramk = kotlin.a.k.ae(paramArrayOfString);
      if (paramk.size() <= 1000) {
        break label282;
      }
      paramk = paramk.subList(0, 1000);
    }
    label258:
    label275:
    label282:
    for (;;)
    {
      paramArrayOfString = (List)new ArrayList();
      paramk = paramk.iterator();
      for (i = j;; i = localObject.length + i)
      {
        if (!paramk.hasNext()) {
          break label258;
        }
        localObject = (CharSequence)paramk.next();
        localObject = new kotlin.n.k("[0-9]").e((CharSequence)localObject, "");
        if (!p.bmZ((String)localObject)) {
          paramArrayOfString.add(localObject);
        }
        Charset localCharset = localp.Xto;
        if (localObject == null)
        {
          paramk = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(294938);
          throw paramk;
          i = 0;
          break;
        }
        localObject = ((String)localObject).getBytes(localCharset);
        kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      }
      if (i >= 0) {
        localp.b(localp.ml(paramArrayOfString), locala);
      }
      AppMethodBeat.o(294938);
      return;
    }
  }
  
  private static final boolean a(k paramk, String paramString)
  {
    AppMethodBeat.i(294915);
    kotlin.g.b.s.u(paramk, "this$0");
    paramk.Wva += 1;
    paramk.biS(paramString);
    AppMethodBeat.o(294915);
    return false;
  }
  
  private static final void b(k paramk, String paramString)
  {
    AppMethodBeat.i(294942);
    kotlin.g.b.s.u(paramk, "this$0");
    Log.i(paramk.TAG, "execute js success!");
    AppMethodBeat.o(294942);
  }
  
  private final void biS(String paramString)
  {
    AppMethodBeat.i(294883);
    this.webView.evaluateJavascript(paramString, new k..ExternalSyntheticLambda1(this, paramString));
    AppMethodBeat.o(294883);
  }
  
  private final void biT(String paramString)
  {
    AppMethodBeat.i(294889);
    iru();
    if (Util.isNullOrNil(paramString))
    {
      Log.i(this.TAG, "json.length == 0");
      AppMethodBeat.o(294889);
      return;
    }
    Log.i(this.TAG, kotlin.g.b.s.X("replaceHTML: ", paramString));
    paramString = "window.WeixinTranslate.replaceText(" + paramString + ')';
    b(this.webView, paramString);
    AppMethodBeat.o(294889);
  }
  
  private static String biU(String paramString)
  {
    AppMethodBeat.i(294897);
    Log.i("MicroMsg.WebViewTransHelper", "getTransJS: %s", new Object[] { paramString });
    try
    {
      paramString = org.apache.commons.b.d.toByteArray(MMApplicationContext.getContext().getAssets().open(paramString));
      kotlin.g.b.s.s(paramString, "toByteArray(MMApplicatio…().assets.open(fileName))");
      paramString = new String(paramString, kotlin.n.d.UTF_8);
      AppMethodBeat.o(294897);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewTransHelper", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { paramString });
        paramString = "";
      }
    }
  }
  
  private final void iru()
  {
    AppMethodBeat.i(294876);
    cb localcb = this.WuX;
    if (localcb != null) {
      localcb.a(null);
    }
    this.WuX = kotlinx.coroutines.j.a(ar.kBZ(), null, null, (m)new a(2000L, this, null), 3);
    AppMethodBeat.o(294876);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(294977);
    kotlin.g.b.s.u(paramb, "callback");
    this.WuV = paramb;
    AppMethodBeat.o(294977);
  }
  
  final void b(MMWebView paramMMWebView, String paramString)
  {
    AppMethodBeat.i(295018);
    try
    {
      paramMMWebView.evaluateJavascript(paramString, new k..ExternalSyntheticLambda0(this));
      this.WuU = true;
      AppMethodBeat.o(295018);
      return;
    }
    catch (Exception paramMMWebView)
    {
      Log.e(this.TAG, kotlin.g.b.s.X("execute js error! ", paramMMWebView));
      AppMethodBeat.o(295018);
    }
  }
  
  final void bO(ArrayList<Map<String, String>> paramArrayList)
  {
    AppMethodBeat.i(295008);
    f.b localb = new f.b();
    Object localObject1 = this.WuV;
    ArrayList localArrayList;
    if (localObject1 == null)
    {
      localObject1 = null;
      localArrayList = new ArrayList();
      paramArrayList = ((Iterable)paramArrayList).iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label218;
      }
      Object localObject2 = (Map)paramArrayList.next();
      f.a locala = new f.a();
      locala.Wuz = String.valueOf(((Map)localObject2).get("hashID"));
      locala.WuA = String.valueOf(((Map)localObject2).get("text"));
      if (localObject1 != null)
      {
        localObject2 = locala.WuA;
        kotlin.g.b.s.checkNotNull(localObject2);
        if (((Map)localObject1).containsKey(localObject2))
        {
          localObject2 = locala.WuA;
          kotlin.g.b.s.checkNotNull(localObject2);
          localArrayList.add(ak.e(new r[] { v.Y("transText", ((Map)localObject1).get(localObject2)), v.Y("hashCode", locala.Wuz) }));
          continue;
          localObject1 = ((b)localObject1).irr();
          break;
        }
      }
      localb.WuC.add(locala);
    }
    label218:
    if (((Collection)localArrayList).size() > 0)
    {
      paramArrayList = new f((Collection)localArrayList).toString();
      kotlin.g.b.s.s(paramArrayList, "JSONArray(needReplaceTextArrInCache).toString()");
      biT(paramArrayList);
    }
    if (((Collection)localb.WuC).size() == 0)
    {
      Log.i(this.TAG, "all nodes are in cache");
      AppMethodBeat.o(295008);
      return;
    }
    this.WuW.setValue(o.Wvv);
    this.WuR.a(localb);
    AppMethodBeat.o(295008);
  }
  
  public final androidx.lifecycle.j getLifecycle()
  {
    return (androidx.lifecycle.j)this.nvu;
  }
  
  public final void irt()
  {
    AppMethodBeat.i(294982);
    Log.i(this.TAG, "injectScriptAndStartTrans");
    this.WuW.setValue(o.Wvv);
    this.WuR.nvu.e(j.b.bHj);
    this.WuR.Wun.a((q)this.WuR, new k..ExternalSyntheticLambda2(this));
    String str = biU(this.WuS);
    if (Util.isNullOrNil(str)) {
      Log.e("MicroMsg.WebViewTransHelper", "check js script is null, inject fail!");
    }
    for (;;)
    {
      b(this.webView, "window.WeixinTranslate.startTrans()");
      AppMethodBeat.o(294982);
      return;
      Object localObject = this.WuV;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((b)localObject).irp())
      {
        if (!Util.isNullOrNil((String)localObject)) {
          break label146;
        }
        Log.e("MicroMsg.WebViewTransHelper", "can't get random id from trans helper!");
        break;
      }
      label146:
      kotlin.g.b.s.checkNotNull(str);
      localObject = this.WuV;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = kotlin.n.n.m(str, "__wx_trans_xxyy", ((b)localObject).irp(), false);
      b(this.webView, (String)localObject);
    }
  }
  
  public final void irv()
  {
    AppMethodBeat.i(295000);
    String str = biU(this.WuT);
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.WebViewTransHelper", "check js script is null, inject fail!");
      AppMethodBeat.o(295000);
      return;
    }
    this.Wva = 0;
    biS(str);
    AppMethodBeat.o(295000);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(294995);
    this.nvu.e(j.b.bHj);
    Object localObject = this.WuV;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((b)localObject).irq())
    {
      if (localObject == n.Wvr) {
        irt();
      }
      AppMethodBeat.o(294995);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(long paramLong, k paramk, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(294645);
      paramObject = (kotlin.d.d)new a(this.Wvd, this.Wve, paramd);
      AppMethodBeat.o(294645);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(294638);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(294638);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        long l = this.Wvd;
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (bb.e(l, paramObject) == locala)
        {
          AppMethodBeat.o(294638);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      this.Wve.WuW.setValue(o.Wvw);
      paramObject = ah.aiuX;
      AppMethodBeat.o(294638);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k
 * JD-Core Version:    0.7.0.1
 */