package com.tencent.mm.plugin.webcanvas;

import android.app.Service;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.Display;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.f.b;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MBViewManager.a;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ax;
import d.n.k;
import d.n.n;
import d.v;
import d.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlinx.a.c.a.r;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "()V", "JSON", "Lcom/eclipsesource/v8/V8Object;", "kotlin.jvm.PlatformType", "getJSON", "()Lcom/eclipsesource/v8/V8Object;", "JSON$delegate", "Lkotlin/Lazy;", "MAX_HEIGHT", "", "MAX_WIDTH", "TAG", "", "appId", "getAppId", "()Ljava/lang/String;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getBizPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "bizPkg$delegate", "canvasContexts", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "canvasElements", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$CanvasElement;", "dimensions", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasDimension;", "engine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "getEngine", "()Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "engine$delegate", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "fontSize", "", "getFontSize", "()F", "isDarkMode", "", "()Z", "layoutCaches", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$LayoutCache;", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "performance", "", "popupCloseListener", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "Lcom/tencent/mm/plugin/webcanvas/PopupCloseListener;", "popupListener", "Lkotlin/Function10;", "Lkotlin/Function0;", "Lcom/tencent/mm/plugin/webcanvas/PopupListener;", "resizedListener", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/webcanvas/ResizeListener;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "webJsApiHandler", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineAPI;", "wxaPkg", "getWxaPkg", "wxaPkg$delegate", "addPopupCloseListener", "listener", "addPopupListener", "addResizedListener", "attach", "canvasId", "canvasElementId", "bind", "clear", "create", "type", "data", "elementId", "dimension", "createClientJsApi", "", "detach", "emit", "event", "expend", "getCacheKey", "width", "getCanvasView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "context", "Landroid/content/Context;", "getLayoutCache", "onError", "contextId", "name", "message", "stackTrace", "onScreenShot", "pause", "removePopupCloseListener", "removePopupListener", "removeResizedListener", "render", "resize", "height", "restoreLayout", "key", "resume", "saveLayout", "layoutCache", "scroll", "unbind", "default", "", "def", "parseJSON", "stringify", "use", "R", "T", "block", "(Lcom/eclipsesource/v8/V8Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "CanvasElement", "Companion", "LayoutCache", "WebCanvasJsApiInterface", "webview-sdk_release"})
public abstract class b
  extends com.tencent.mm.plugin.ac.b
{
  private static final String Dyn;
  private static final String Dyo = Dyn + "/webtimeline.wspkg";
  private static final String Dyp = Dyn + "/index.wspkg";
  private static final d.f Dyq = d.g.O((d.g.a.a)b.i.DyB);
  private static final d.f Dyr = d.g.O((d.g.a.a)b.h.DyA);
  public static final g Dys = new g((byte)0);
  final LinkedList<d.g.a.q<String, Integer, Integer, z>> DxZ = new LinkedList();
  final LinkedList<d.g.a.c<String, String, Integer, Integer, Integer, Integer, Integer, Integer, d.g.a.a<z>, d.g.a.a<z>, Integer>> Dya = new LinkedList();
  final LinkedList<d.g.a.b<String, z>> Dyb = new LinkedList();
  private final d.f Dyc = d.g.O((d.g.a.a)new o(this));
  private final com.tencent.mm.plugin.ac.g Dyd = new com.tencent.mm.plugin.ac.g();
  private final HashMap<Integer, Long> Dye = new HashMap();
  private final d.f Dyf = d.g.O((d.g.a.a)new j(this));
  private final HashMap<String, b.k> Dyg = new HashMap();
  private final HashMap<String, Integer> Dyh = new HashMap();
  final d Dyi;
  private final d.f Dyj;
  private final d.f Dyk;
  final HashMap<String, a> Dyl;
  final HashMap<String, b.f> Dym;
  com.tencent.mm.plugin.ac.e OdU;
  final String TAG = "MicroMsg.WebCanvasJsEngine";
  private final int ciA = 2048;
  private final int ciz = 2048;
  
  static
  {
    String str = com.tencent.mm.loader.j.b.arU() + "/skiaCanvas_debug";
    ad.d("DEBUG_PATH", "WebCanvas debug path = ".concat(String.valueOf(str)));
    Dyn = str;
  }
  
  public b()
  {
    Object localObject1 = new com.tencent.magicbrush.e();
    ((com.tencent.magicbrush.f)localObject1).context = aj.getContext();
    ((com.tencent.magicbrush.e)localObject1).ad(com.tencent.mm.plugin.appbrand.z.g.bBm());
    ((com.tencent.magicbrush.f)localObject1).cwX = ((d.g.a.a)new b.a(this));
    ((com.tencent.magicbrush.f)localObject1).cwW = ((com.tencent.magicbrush.handler.a)new b(this));
    ((com.tencent.magicbrush.e)localObject1).b(a.b.czP);
    Object localObject2 = com.tencent.mm.loader.j.b.arO();
    d.g.b.p.g(localObject2, "CConstants.SDCARD_ROOT()");
    ((com.tencent.magicbrush.e)localObject1).dB((String)localObject2);
    ((com.tencent.magicbrush.e)localObject1).bS(false);
    localObject1 = ((com.tencent.magicbrush.e)localObject1).Ho();
    if (localObject1 == null) {
      d.g.b.p.gfZ();
    }
    ((d)localObject1).cwJ.a((d.g.a.b)new c((d)localObject1, this));
    ((d)localObject1).cwM.addListener((MBViewManager.a)new b.d((d)localObject1, this));
    this.Dyi = ((d)localObject1);
    this.Dyj = d.g.O((d.g.a.a)new b.r(this));
    this.Dyk = d.g.O((d.g.a.a)new b.m(this));
    ad.i(this.TAG, "init");
    localObject1 = new com.tencent.magicbrush.handler.glfont.i();
    ((com.tencent.magicbrush.handler.glfont.i)localObject1).init(1024, 1024);
    localObject2 = bqi();
    com.tencent.mm.plugin.appbrand.jsruntime.a locala = (com.tencent.mm.plugin.appbrand.jsruntime.a)this;
    m localm = bqf();
    d.g.b.p.g(localm, "this@WebCanvasJsEngine.v8Context");
    this.OdU = ((com.tencent.mm.plugin.ac.e)new b.e(locala, localm, this, (com.tencent.magicbrush.handler.glfont.i)localObject1));
    ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject2).addJavascriptInterface(this.OdU, "__weixincore");
    cxZ();
    new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(214046);
        d.g.b.p.h(paramAnonymousString, "activity");
        this.Dyt.evaluateJavascript("WeixinCore.emit('background')", null);
        AppMethodBeat.o(214046);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(214045);
        d.g.b.p.h(paramAnonymousString, "activity");
        this.Dyt.evaluateJavascript("WeixinCore.emit('foreground')", null);
        AppMethodBeat.o(214045);
      }
    }.alive();
    this.Dyl = new HashMap();
    this.Dym = new HashMap();
  }
  
  private final com.tencent.mm.plugin.appbrand.appcache.p eKY()
  {
    return (com.tencent.mm.plugin.appbrand.appcache.p)this.Dyk.getValue();
  }
  
  static String fr(String paramString, int paramInt)
  {
    paramString = new StringBuilder().append(paramString).append('-');
    if (paramInt != 0) {}
    for (;;)
    {
      return paramInt + '-' + com.tencent.mm.cc.a.eb(g.getAppContext());
      paramInt = g.eLi();
    }
  }
  
  public final void a(final String paramString1, final String paramString2, final String paramString3, final int paramInt, a parama)
  {
    d.g.b.p.h(paramString1, "type");
    d.g.b.p.h(paramString2, "canvasId");
    d.g.b.p.h(paramString3, "data");
    if (parama != null) {
      ((Map)this.Dyl).put(paramString2, parama);
    }
    if (this.Dyh.containsKey(paramString2)) {
      return;
    }
    ad.i(this.TAG, "create #" + paramString2 + ':' + paramInt);
    parama = (Map)this.Dyh;
    com.tencent.mm.plugin.appbrand.jsruntime.g localg = bqj();
    localg.addJavascriptInterface(eK(paramString2, paramString3), "__weixincanvas");
    d.g.b.p.g(localg, "this");
    a(localg, "CanvasContext#".concat(String.valueOf(paramString2)), getAppId(), eKY(), paramString1, (d.g.a.b)new n(this, paramString2, paramString3, paramString1, paramInt));
    parama.put(paramString2, Integer.valueOf(localg.bqh()));
  }
  
  final b.k aFx(String paramString)
  {
    Object localObject2 = (b.k)this.Dyg.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (ax)g.eLh().aQb(paramString);
      if (localObject1 != null)
      {
        localObject1 = ((ax)localObject1).getString(paramString, "");
        if (localObject1 != null)
        {
          d.g.b.p.g(localObject1, "layoutStore");
          if (!n.aE((CharSequence)localObject1))
          {
            i = 1;
            if (i == 0) {
              break label236;
            }
            localObject2 = kotlinx.a.c.a.NNk;
            localObject2 = b.k.DyD;
            localObject2 = (kotlinx.a.f)b.k.a.DyE;
            d.g.b.p.h(localObject2, "deserializer");
            d.g.b.p.h(localObject1, "string");
            kotlinx.a.c.a locala = kotlinx.a.c.a.gxe();
            d.g.b.p.h(localObject2, "deserializer");
            d.g.b.p.h(localObject1, "string");
            localObject1 = new kotlinx.a.c.a.f((String)localObject1);
            localObject2 = kotlinx.a.e.c((kotlinx.a.c)new kotlinx.a.c.a.l(locala, r.NOw, (kotlinx.a.c.a.f)localObject1), (kotlinx.a.f)localObject2);
            if (((kotlinx.a.c.a.f)localObject1).NOi != 12) {
              break label204;
            }
          }
          label204:
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label209;
            }
            throw ((Throwable)new IllegalStateException("Reader has not consumed the whole input: ".concat(String.valueOf(localObject1)).toString()));
            i = 0;
            break;
          }
          label209:
          localObject1 = (b.k)localObject2;
          ((Map)this.Dyg).put(paramString, localObject1);
          return (b.k)localObject2;
          label236:
          return null;
        }
      }
      localObject1 = null;
    }
    return localObject1;
  }
  
  public abstract Class<? extends Service> bOJ();
  
  /* Error */
  public final MagicBrushView bw(final Context paramContext, final String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc_w 793
    //   6: invokestatic 588	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc_w 703
    //   13: invokestatic 588	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 499	com/tencent/mm/plugin/webcanvas/b:Dym	Ljava/util/HashMap;
    //   20: astore 5
    //   22: aload 5
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 481	com/tencent/mm/plugin/webcanvas/b:OdU	Lcom/tencent/mm/plugin/ac/e;
    //   29: astore 4
    //   31: aload 4
    //   33: ifnull +9 -> 42
    //   36: aload 4
    //   38: aload_1
    //   39: invokevirtual 797	com/tencent/mm/plugin/ac/e:setContext	(Landroid/content/Context;)V
    //   42: aload_0
    //   43: getfield 499	com/tencent/mm/plugin/webcanvas/b:Dym	Ljava/util/HashMap;
    //   46: aload_2
    //   47: invokevirtual 708	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   50: ifne +269 -> 319
    //   53: new 799	android/content/MutableContextWrapper
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 801	android/content/MutableContextWrapper:<init>	(Landroid/content/Context;)V
    //   61: astore 6
    //   63: new 803	com/tencent/magicbrush/ui/MagicBrushView
    //   66: dup
    //   67: aload 6
    //   69: checkcast 524	android/content/Context
    //   72: getstatic 809	com/tencent/magicbrush/ui/MagicBrushView$h:cAq	Lcom/tencent/magicbrush/ui/MagicBrushView$h;
    //   75: invokespecial 812	com/tencent/magicbrush/ui/MagicBrushView:<init>	(Landroid/content/Context;Lcom/tencent/magicbrush/ui/MagicBrushView$h;)V
    //   78: astore 4
    //   80: aload_0
    //   81: getfield 439	com/tencent/mm/plugin/webcanvas/b:Dyi	Lcom/tencent/magicbrush/d;
    //   84: astore 7
    //   86: aload 7
    //   88: invokevirtual 815	com/tencent/magicbrush/d:Hd	()V
    //   91: aload 4
    //   93: aload 7
    //   95: invokevirtual 819	com/tencent/magicbrush/ui/MagicBrushView:setMagicBrush	(Lcom/tencent/magicbrush/d;)V
    //   98: aload_0
    //   99: getfield 301	com/tencent/mm/plugin/webcanvas/b:TAG	Ljava/lang/String;
    //   102: new 225	java/lang/StringBuilder
    //   105: dup
    //   106: ldc_w 821
    //   109: invokespecial 522	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_2
    //   113: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: bipush 58
    //   118: invokevirtual 633	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   121: aload 4
    //   123: invokevirtual 824	com/tencent/magicbrush/ui/MagicBrushView:getVirtualElementId	()I
    //   126: invokevirtual 530	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 454	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 4
    //   137: iconst_0
    //   138: invokevirtual 827	com/tencent/magicbrush/ui/MagicBrushView:setOpaque	(Z)V
    //   141: aload 4
    //   143: iconst_0
    //   144: invokevirtual 830	com/tencent/magicbrush/ui/MagicBrushView:setClipChildren	(Z)V
    //   147: aload 4
    //   149: iconst_0
    //   150: invokevirtual 833	com/tencent/magicbrush/ui/MagicBrushView:setClipToPadding	(Z)V
    //   153: aload 4
    //   155: iconst_1
    //   156: invokevirtual 836	com/tencent/magicbrush/ui/MagicBrushView:setEnableTouchEvent	(Z)V
    //   159: aload_0
    //   160: getfield 499	com/tencent/mm/plugin/webcanvas/b:Dym	Ljava/util/HashMap;
    //   163: checkcast 547	java/util/Map
    //   166: aload_2
    //   167: new 16	com/tencent/mm/plugin/webcanvas/b$f
    //   170: dup
    //   171: aload 4
    //   173: invokevirtual 824	com/tencent/magicbrush/ui/MagicBrushView:getVirtualElementId	()I
    //   176: aload 6
    //   178: invokespecial 839	com/tencent/mm/plugin/webcanvas/b$f:<init>	(ILandroid/content/MutableContextWrapper;)V
    //   181: invokeinterface 551 3 0
    //   186: pop
    //   187: aload 4
    //   189: new 40	com/tencent/mm/plugin/webcanvas/b$p
    //   192: dup
    //   193: aload 4
    //   195: aload 6
    //   197: aload_0
    //   198: aload_1
    //   199: aload_2
    //   200: invokespecial 842	com/tencent/mm/plugin/webcanvas/b$p:<init>	(Lcom/tencent/magicbrush/ui/MagicBrushView;Landroid/content/MutableContextWrapper;Lcom/tencent/mm/plugin/webcanvas/b;Landroid/content/Context;Ljava/lang/String;)V
    //   203: checkcast 844	android/view/View$OnLayoutChangeListener
    //   206: invokevirtual 848	com/tencent/magicbrush/ui/MagicBrushView:addOnLayoutChangeListener	(Landroid/view/View$OnLayoutChangeListener;)V
    //   209: aload 4
    //   211: astore_1
    //   212: aload_0
    //   213: getfield 301	com/tencent/mm/plugin/webcanvas/b:TAG	Ljava/lang/String;
    //   216: ldc_w 850
    //   219: aload_2
    //   220: invokestatic 251	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   223: invokevirtual 255	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   226: invokestatic 261	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_1
    //   230: invokevirtual 824	com/tencent/magicbrush/ui/MagicBrushView:getVirtualElementId	()I
    //   233: istore_3
    //   234: aload_2
    //   235: ldc_w 703
    //   238: invokestatic 588	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   241: aload_0
    //   242: getfield 301	com/tencent/mm/plugin/webcanvas/b:TAG	Ljava/lang/String;
    //   245: new 225	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 852
    //   252: invokespecial 522	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload_2
    //   256: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: bipush 58
    //   261: invokevirtual 633	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   264: iload_3
    //   265: invokevirtual 530	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 454	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: ldc_w 853
    //   278: aload_2
    //   279: iload_3
    //   280: aconst_null
    //   281: bipush 8
    //   283: invokestatic 855	com/tencent/mm/plugin/webcanvas/b:a	(Lcom/tencent/mm/plugin/webcanvas/b;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V
    //   286: aload_0
    //   287: getfield 329	com/tencent/mm/plugin/webcanvas/b:Dye	Ljava/util/HashMap;
    //   290: checkcast 547	java/util/Map
    //   293: aload_1
    //   294: invokevirtual 824	com/tencent/magicbrush/ui/MagicBrushView:getVirtualElementId	()I
    //   297: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   300: invokestatic 861	java/lang/System:currentTimeMillis	()J
    //   303: invokestatic 866	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   306: invokeinterface 551 3 0
    //   311: pop
    //   312: aload 5
    //   314: monitorexit
    //   315: aload_0
    //   316: monitorexit
    //   317: aload_1
    //   318: areturn
    //   319: aload_0
    //   320: getfield 499	com/tencent/mm/plugin/webcanvas/b:Dym	Ljava/util/HashMap;
    //   323: aload_2
    //   324: invokevirtual 738	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   327: astore 4
    //   329: aload 4
    //   331: ifnonnull +6 -> 337
    //   334: invokestatic 407	d/g/b/p:gfZ	()V
    //   337: aload 4
    //   339: checkcast 16	com/tencent/mm/plugin/webcanvas/b$f
    //   342: astore 4
    //   344: aload 4
    //   346: getfield 869	com/tencent/mm/plugin/webcanvas/b$f:id	I
    //   349: istore_3
    //   350: aload 4
    //   352: getfield 873	com/tencent/mm/plugin/webcanvas/b$f:Dyz	Landroid/content/MutableContextWrapper;
    //   355: astore 6
    //   357: aload_0
    //   358: getfield 439	com/tencent/mm/plugin/webcanvas/b:Dyi	Lcom/tencent/magicbrush/d;
    //   361: getfield 426	com/tencent/magicbrush/d:cwM	Lcom/tencent/magicbrush/ui/MBViewManager;
    //   364: iload_3
    //   365: invokevirtual 877	com/tencent/magicbrush/ui/MBViewManager:find	(I)Lcom/tencent/magicbrush/ui/MagicBrushView;
    //   368: astore 4
    //   370: aload_0
    //   371: getfield 301	com/tencent/mm/plugin/webcanvas/b:TAG	Ljava/lang/String;
    //   374: new 225	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 879
    //   381: invokespecial 522	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: aload_2
    //   385: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: bipush 58
    //   390: invokevirtual 633	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   393: aload 4
    //   395: invokevirtual 824	com/tencent/magicbrush/ui/MagicBrushView:getVirtualElementId	()I
    //   398: invokevirtual 530	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   401: ldc_w 881
    //   404: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 6
    //   409: invokevirtual 884	android/content/MutableContextWrapper:getBaseContext	()Landroid/content/Context;
    //   412: aload_1
    //   413: invokestatic 511	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   416: invokevirtual 887	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   419: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 454	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: new 42	com/tencent/mm/plugin/webcanvas/b$q
    //   428: dup
    //   429: aload 4
    //   431: aload 6
    //   433: aload_0
    //   434: aload_1
    //   435: aload_2
    //   436: invokespecial 888	com/tencent/mm/plugin/webcanvas/b$q:<init>	(Lcom/tencent/magicbrush/ui/MagicBrushView;Landroid/content/MutableContextWrapper;Lcom/tencent/mm/plugin/webcanvas/b;Landroid/content/Context;Ljava/lang/String;)V
    //   439: checkcast 279	d/g/a/a
    //   442: invokestatic 893	com/tencent/mm/ad/c:g	(Ld/g/a/a;)V
    //   445: aload 4
    //   447: astore_1
    //   448: goto -236 -> 212
    //   451: astore_1
    //   452: aload 5
    //   454: monitorexit
    //   455: aload_1
    //   456: athrow
    //   457: astore_1
    //   458: aload_0
    //   459: monitorexit
    //   460: aload_1
    //   461: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	b
    //   0	462	1	paramContext	Context
    //   0	462	2	paramString	String
    //   233	132	3	i	int
    //   29	417	4	localObject	Object
    //   61	371	6	localMutableContextWrapper	MutableContextWrapper
    //   84	10	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   25	31	451	finally
    //   36	42	451	finally
    //   42	209	451	finally
    //   212	312	451	finally
    //   319	329	451	finally
    //   334	337	451	finally
    //   337	445	451	finally
    //   2	25	457	finally
    //   312	315	457	finally
    //   452	457	457	finally
  }
  
  protected Object eK(String paramString1, String paramString2)
  {
    d.g.b.p.h(paramString1, "canvasId");
    d.g.b.p.h(paramString2, "data");
    return new l(paramString1, paramString2);
  }
  
  public final m eKV()
  {
    return (m)this.Dyc.getValue();
  }
  
  public final com.tencent.mm.plugin.ac.g eKW()
  {
    return this.Dyd;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.p eKX()
  {
    return (com.tencent.mm.plugin.appbrand.appcache.p)this.Dyj.getValue();
  }
  
  public final void fs(String paramString, int paramInt)
  {
    d.g.b.p.h(paramString, "canvasId");
    ad.i(this.TAG, "attach #" + paramString + ':' + paramInt);
    a(this, "attach", paramString, 0, null, 12);
  }
  
  public final void ft(String paramString, int paramInt)
  {
    d.g.b.p.h(paramString, "canvasId");
    ad.i(this.TAG, "render #" + paramString + ':' + paramInt);
    a(this, "render", paramString, paramInt, null, 8);
  }
  
  public final void g(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    d.g.b.p.h(paramString1, "name");
    com.tencent.mm.ac.i locali = new com.tencent.mm.ac.i();
    locali.R("id", paramInt);
    locali.h("name", paramString1);
    locali.h("message", paramString2);
    locali.h("stackTrace", paramString3);
    evaluateJavascript("WeixinCore.emit('error', '" + locali + "')", null);
  }
  
  public abstract String getAppId();
  
  public final void resize(int paramInt1, int paramInt2, int paramInt3)
  {
    ad.i(this.TAG, "resize :".concat(String.valueOf(paramInt1)));
    evaluateJavascript("WeixinCore.resize(" + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ')', null);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$magicBrush$1$2", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "", "post", "", "p0", "Ljava/lang/Runnable;", "p1", "webview-sdk_release"})
  public static final class b
    implements com.tencent.magicbrush.handler.a
  {
    b(b paramb) {}
    
    public final boolean Ct()
    {
      AppMethodBeat.i(214032);
      IJSRuntime localIJSRuntime = b.j(this.Dyt);
      d.g.b.p.g(localIJSRuntime, "this@WebCanvasJsEngine.jsRuntime");
      boolean bool = localIJSRuntime.Np();
      AppMethodBeat.o(214032);
      return bool;
    }
    
    public final String Cu()
    {
      AppMethodBeat.i(214030);
      String str = this.Dyt.Cu();
      AppMethodBeat.o(214030);
      return str;
    }
    
    public final void a(Runnable paramRunnable, boolean paramBoolean)
    {
      AppMethodBeat.i(214031);
      d.g.b.p.h(paramRunnable, "p0");
      this.Dyt.a(paramRunnable, paramBoolean);
      AppMethodBeat.o(214031);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$magicBrush$2$1"})
  static final class c
    extends d.g.b.q
    implements d.g.a.b<f.b, z>
  {
    c(d paramd, b paramb)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$Companion;", "", "()V", "DEBUG_BIZ", "", "DEBUG_PATH", "DEBUG_PKG", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getAppContext", "()Landroid/content/Context;", "appContext$delegate", "Lkotlin/Lazy;", "canvasStorage", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getCanvasStorage", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "canvasStorage$delegate", "getViewportHeight", "", "getViewportWidth", "webview-sdk_release"})
  public static final class g
  {
    public static ar eLh()
    {
      AppMethodBeat.i(214055);
      Object localObject = b.eLd();
      g localg = b.Dys;
      localObject = (ar)((d.f)localObject).getValue();
      AppMethodBeat.o(214055);
      return localObject;
    }
    
    static int eLi()
    {
      AppMethodBeat.i(214057);
      Object localObject = getAppContext().getSystemService("window");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(214057);
        throw ((Throwable)localObject);
      }
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      d.g.b.p.g(localObject, "(appContext.getSystemSer…owManager).defaultDisplay");
      int i = ((Display)localObject).getWidth();
      AppMethodBeat.o(214057);
      return i;
    }
    
    static Context getAppContext()
    {
      AppMethodBeat.i(214056);
      Object localObject = b.eLe();
      g localg = b.Dys;
      localObject = (Context)((d.f)localObject).getValue();
      AppMethodBeat.o(214056);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/eclipsesource/v8/V8Object;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<V8Object>
  {
    j(b paramb)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$WebCanvasJsApiInterface;", "", "canvasId", "", "dataStr", "(Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;Ljava/lang/String;Ljava/lang/String;)V", "getCanvasId", "()Ljava/lang/String;", "getDataStr", "closePopup", "", "getData", "getFontSize", "", "getId", "getPhyHeight", "", "getPhyOffsetHeight", "getPhyOffsetTop", "getPhyWidth", "getVersion", "isDarkMode", "", "performance", "elementId", "key", "duration", "", "popup", "popupId", "width", "", "height", "left", "top", "mode", "colorRGBA", "onDismiss", "Lcom/eclipsesource/v8/V8Function;", "onOuterClick", "restore", "save", "layout", "updatePhyHeight", "webview-sdk_release"})
  public class l
  {
    protected final String ktn;
    private final String kwS;
    
    public l(String paramString)
    {
      AppMethodBeat.i(214088);
      this.ktn = paramString;
      this.kwS = localObject;
      AppMethodBeat.o(214088);
    }
    
    @JavascriptInterface
    public final void closePopup()
    {
      AppMethodBeat.i(214085);
      Iterator localIterator = ((Iterable)b.h(b.this)).iterator();
      while (localIterator.hasNext()) {
        ((d.g.a.b)localIterator.next()).invoke(this.ktn);
      }
      AppMethodBeat.o(214085);
    }
    
    @JavascriptInterface
    public final String getData()
    {
      return this.kwS;
    }
    
    @JavascriptInterface
    public final float getFontSize()
    {
      AppMethodBeat.i(214081);
      float f = b.eKZ();
      AppMethodBeat.o(214081);
      return f;
    }
    
    @JavascriptInterface
    public final String getId()
    {
      return this.ktn;
    }
    
    @JavascriptInterface
    public final int getPhyHeight()
    {
      AppMethodBeat.i(214078);
      Object localObject = (a)b.d(b.this).get(this.ktn);
      if (localObject != null)
      {
        localObject = Integer.valueOf(((a)localObject).getHeight());
        if (((Number)localObject).intValue() != 0)
        {
          i = 1;
          if (i == 0) {
            break label74;
          }
        }
        for (;;)
        {
          if (localObject == null) {
            break label79;
          }
          i = ((Integer)localObject).intValue();
          AppMethodBeat.o(214078);
          return i;
          i = 0;
          break;
          label74:
          localObject = null;
        }
      }
      label79:
      localObject = b.Dys;
      localObject = b.g.getAppContext().getSystemService("window");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(214078);
        throw ((Throwable)localObject);
      }
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      d.g.b.p.g(localObject, "(appContext.getSystemSer…owManager).defaultDisplay");
      int i = ((Display)localObject).getHeight();
      AppMethodBeat.o(214078);
      return i;
    }
    
    @JavascriptInterface
    public final int getPhyOffsetHeight()
    {
      AppMethodBeat.i(214080);
      a locala = (a)b.d(b.this).get(this.ktn);
      if (locala != null)
      {
        int i = locala.eKU();
        AppMethodBeat.o(214080);
        return i;
      }
      AppMethodBeat.o(214080);
      return 0;
    }
    
    @JavascriptInterface
    public final int getPhyOffsetTop()
    {
      AppMethodBeat.i(214079);
      a locala = (a)b.d(b.this).get(this.ktn);
      if (locala != null)
      {
        int i = locala.eKT();
        AppMethodBeat.o(214079);
        return i;
      }
      AppMethodBeat.o(214079);
      return 0;
    }
    
    @JavascriptInterface
    public final int getPhyWidth()
    {
      AppMethodBeat.i(214077);
      Object localObject = (a)b.d(b.this).get(this.ktn);
      if (localObject != null)
      {
        localObject = Integer.valueOf(((a)localObject).getWidth());
        if (((Number)localObject).intValue() != 0)
        {
          i = 1;
          if (i == 0) {
            break label74;
          }
        }
        for (;;)
        {
          if (localObject == null) {
            break label79;
          }
          i = ((Integer)localObject).intValue();
          AppMethodBeat.o(214077);
          return i;
          i = 0;
          break;
          label74:
          localObject = null;
        }
      }
      label79:
      localObject = b.Dys;
      int i = b.g.eLi();
      AppMethodBeat.o(214077);
      return i;
    }
    
    @JavascriptInterface
    public final int getVersion()
    {
      AppMethodBeat.i(214075);
      try
      {
        i = b.a(b.a(b.this));
        AppMethodBeat.o(214075);
        return i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e(b.b(b.this), "getVersion ex " + localException.getMessage());
          int i = 0;
        }
      }
    }
    
    @JavascriptInterface
    public final boolean isDarkMode()
    {
      AppMethodBeat.i(214082);
      boolean bool = b.eLa();
      AppMethodBeat.o(214082);
      return bool;
    }
    
    @JavascriptInterface
    public final void performance(Object paramObject, String paramString, long paramLong)
    {
      AppMethodBeat.i(214076);
      d.g.b.p.h(paramObject, "elementId");
      d.g.b.p.h(paramString, "key");
      Object localObject = (Long)((Map)b.c(b.this)).get(paramObject);
      if (localObject != null)
      {
        long l = ((Number)localObject).longValue();
        localObject = b.b(b.this);
        paramString = new StringBuilder("performance:").append(paramObject).append(" [").append(paramString).append("]:").append(System.currentTimeMillis() - l).append("ms");
        if (paramLong > 0L) {}
        for (paramObject = " duration:" + paramLong + "ms";; paramObject = "")
        {
          ad.i((String)localObject, paramObject);
          AppMethodBeat.o(214076);
          return;
        }
      }
      AppMethodBeat.o(214076);
    }
    
    @JavascriptInterface
    public final int popup(final String paramString1, final Number paramNumber1, final Number paramNumber2, final Number paramNumber3, final Number paramNumber4, final int paramInt, String paramString2, final V8Function paramV8Function1, final V8Function paramV8Function2)
    {
      AppMethodBeat.i(214084);
      d.g.b.p.h(paramString1, "popupId");
      d.g.b.p.h(paramNumber1, "width");
      d.g.b.p.h(paramNumber2, "height");
      d.g.b.p.h(paramNumber3, "left");
      d.g.b.p.h(paramNumber4, "top");
      d.g.b.p.h(paramString2, "colorRGBA");
      d.g.b.p.h(paramV8Function1, "onDismiss");
      d.g.b.p.h(paramV8Function2, "onOuterClick");
      paramV8Function1 = paramV8Function1.twin();
      paramV8Function2 = paramV8Function2.twin();
      Object localObject = new char[1];
      localObject[0] = 35;
      d.g.b.p.h(paramString2, "$this$trimStart");
      d.g.b.p.h(localObject, "chars");
      paramString2 = (CharSequence)paramString2;
      final int i = 0;
      int j = paramString2.length();
      if (i < j) {
        if (d.a.e.contains((char[])localObject, paramString2.charAt(i))) {}
      }
      for (paramString2 = paramString2.subSequence(i, paramString2.length());; paramString2 = (CharSequence)"")
      {
        paramString2 = paramString2.toString();
        if (paramString2 != null) {
          break label220;
        }
        paramString1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(214084);
        throw paramString1;
        i += 1;
        break;
      }
      label220:
      paramString2 = paramString2.toUpperCase();
      d.g.b.p.g(paramString2, "(this as java.lang.String).toUpperCase()");
      localObject = (CharSequence)paramString2;
      if (new k("[A-F0-9]{8}").aC((CharSequence)localObject))
      {
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(214084);
          throw paramString1;
        }
        localObject = paramString2.substring(6, 8);
        d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        i = Integer.parseInt((String)localObject, d.n.a.aly(16));
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(214084);
          throw paramString1;
        }
        localObject = paramString2.substring(0, 2);
        d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        j = Integer.parseInt((String)localObject, d.n.a.aly(16));
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(214084);
          throw paramString1;
        }
        localObject = paramString2.substring(2, 4);
        d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int k = Integer.parseInt((String)localObject, d.n.a.aly(16));
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(214084);
          throw paramString1;
        }
        paramString2 = paramString2.substring(4, 6);
        d.g.b.p.g(paramString2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        i = Color.argb(i, j, k, Integer.parseInt(paramString2, d.n.a.aly(16)));
        localObject = ((Iterable)b.g(b.this)).iterator();
        label501:
        if (!((Iterator)localObject).hasNext()) {
          break label688;
        }
        paramString2 = ((d.g.a.c)((Iterator)localObject).next()).a(paramString1, this.ktn, Integer.valueOf(paramNumber1.intValue()), Integer.valueOf(paramNumber2.intValue()), Integer.valueOf(paramNumber3.intValue()), Integer.valueOf(paramNumber4.intValue()), Integer.valueOf(paramInt), Integer.valueOf(i), new a(this, paramString1, paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramInt, i, paramV8Function2, paramV8Function1), new b(this, paramString1, paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramInt, i, paramV8Function2, paramV8Function1));
        if (((Number)paramString2).intValue() == -1) {
          break label676;
        }
        j = 1;
        label634:
        if (j == 0) {
          break label682;
        }
      }
      for (;;)
      {
        paramString2 = (Integer)paramString2;
        if (paramString2 == null) {
          break label501;
        }
        paramInt = ((Number)paramString2).intValue();
        AppMethodBeat.o(214084);
        return paramInt;
        i = 0;
        break;
        label676:
        j = 0;
        break label634;
        label682:
        paramString2 = null;
      }
      label688:
      AppMethodBeat.o(214084);
      return -1;
    }
    
    @JavascriptInterface
    public final String restore(String paramString)
    {
      AppMethodBeat.i(214087);
      d.g.b.p.h(paramString, "canvasId");
      paramString = b.a(b.this, b.fu(paramString, getPhyWidth()));
      if (paramString != null)
      {
        paramString = paramString.DyC;
        AppMethodBeat.o(214087);
        return paramString;
      }
      AppMethodBeat.o(214087);
      return null;
    }
    
    @JavascriptInterface
    public final void save(String paramString1, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, String paramString2)
    {
      AppMethodBeat.i(214086);
      d.g.b.p.h(paramString1, "canvasId");
      d.g.b.p.h(paramNumber1, "left");
      d.g.b.p.h(paramNumber2, "top");
      d.g.b.p.h(paramNumber3, "width");
      d.g.b.p.h(paramNumber4, "height");
      d.g.b.p.h(paramString2, "layout");
      b.a(b.this, b.fu(paramString1, getPhyWidth()), new b.k(paramString1, b.a(paramNumber4, -2), b.a(paramNumber3, -1), paramNumber1.intValue(), paramNumber2.intValue(), paramString2));
      AppMethodBeat.o(214086);
    }
    
    @JavascriptInterface
    public final void updatePhyHeight(Number paramNumber)
    {
      AppMethodBeat.i(214083);
      d.g.b.p.h(paramNumber, "height");
      ad.i(b.b(b.this), "updatePhyHeight:".concat(String.valueOf(paramNumber)));
      String str = b.fu(this.ktn, getPhyWidth());
      b localb = b.this;
      Object localObject = (b.k)b.e(b.this).get(str);
      if (localObject != null)
      {
        ((b.k)localObject).height = paramNumber.intValue();
        if (localObject != null) {}
      }
      else
      {
        localObject = new b.k(this.ktn, paramNumber.intValue());
      }
      for (;;)
      {
        b.a(localb, str, (b.k)localObject);
        localObject = ((Iterable)b.f(b.this)).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((d.g.a.q)((Iterator)localObject).next()).d(this.ktn, Integer.valueOf(-1), Integer.valueOf(paramNumber.intValue()));
        }
        AppMethodBeat.o(214083);
        return;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$WebCanvasJsApiInterface$popup$1$1"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      a(b.l paraml, String paramString, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, int paramInt1, int paramInt2, V8Function paramV8Function1, V8Function paramV8Function2)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$WebCanvasJsApiInterface$popup$1$2"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      b(b.l paraml, String paramString, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, int paramInt1, int paramInt2, V8Function paramV8Function1, V8Function paramV8Function2)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$create$2$1"})
  static final class n
    extends d.g.b.q
    implements d.g.a.b<String, z>
  {
    n(b paramb, String paramString1, String paramString2, String paramString3, int paramInt)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "invoke"})
  static final class o
    extends d.g.b.q
    implements d.g.a.a<m>
  {
    o(b paramb)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "<anonymous parameter 5>", "<anonymous parameter 6>", "<anonymous parameter 7>", "<anonymous parameter 8>", "onLayoutChange", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$getCanvasView$1$1$2", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$$special$$inlined$apply$lambda$1"})
  static final class p
    implements View.OnLayoutChangeListener
  {
    p(MagicBrushView paramMagicBrushView, MutableContextWrapper paramMutableContextWrapper, b paramb, Context paramContext, String paramString) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(214093);
      ad.i(b.b(jdField_this), "OnLayoutChange [" + (paramInt3 - paramInt1) + ',' + (paramInt4 - paramInt2) + ']');
      jdField_this.ft(paramString, this.DyV.getVirtualElementId());
      jdField_this.resize(this.DyV.getVirtualElementId(), paramInt3 - paramInt1, paramInt4 - paramInt2);
      AppMethodBeat.o(214093);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$getCanvasView$1$2$1$1", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$$special$$inlined$apply$lambda$2", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$$special$$inlined$let$lambda$1"})
  static final class q
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    q(MagicBrushView paramMagicBrushView, MutableContextWrapper paramMutableContextWrapper, b paramb, Context paramContext, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.b
 * JD-Core Version:    0.7.0.1
 */