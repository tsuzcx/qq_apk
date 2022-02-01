package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import androidx.recyclerview.widget.RecyclerView;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ax.f;
import com.tencent.mm.plugin.ax.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.aw;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;
import kotlinx.a.b.e;
import kotlinx.a.d.al;
import kotlinx.a.e.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;", "canvasId", "", "needCheckDrawChanged", "", "logicJsEngineReference", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "renderJsEngineReference", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "updateHeight", "(Ljava/lang/String;ZLjava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Z)V", "barrier", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$SyncBarrierInfo;", "barrierStartTime", "", "getBarrierStartTime", "()J", "lastDraw", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$DrawInfo;", "lastWidth", "", "getLastWidth", "()I", "setLastWidth", "(I)V", "layoutCache", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "logicJsEngine", "getLogicJsEngine$webview_sdk_release", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "getMagicBrush$webview_sdk_release", "()Lcom/tencent/magicbrush/MagicBrush;", "magicBrushView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "getMagicBrushView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "methodInQueue", "getMethodInQueue", "()Z", "onGetFontSize", "Lkotlin/Function0;", "", "getOnGetFontSize", "()Lkotlin/jvm/functions/Function0;", "setOnGetFontSize", "(Lkotlin/jvm/functions/Function0;)V", "onGetWidth", "getOnGetWidth", "setOnGetWidth", "onSetHeight", "getOnSetHeight", "setOnSetHeight", "renderJsEngine", "getRenderJsEngine$webview_sdk_release", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "videoCanAutoPlayNow", "getVideoCanAutoPlayNow", "setVideoCanAutoPlayNow", "(Z)V", "videoPos", "", "getVideoPos", "()[F", "setVideoPos", "([F)V", "view", "getView", "viewContext", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasViewContext;", "isParentPaused", "Landroid/view/View;", "(Landroid/view/View;)Z", "offsetHeight", "getOffsetHeight", "(Landroid/view/View;)I", "offsetTop", "getOffsetTop", "parentListView", "Landroid/view/ViewGroup;", "getParentListView", "(Landroid/view/View;)Landroid/view/ViewGroup;", "attach", "", "attach$webview_sdk_release", "canVideoAutoPlay", "checkDrawChanged", "start", "checkHeight", "createCanvasView", "context", "Landroid/content/Context;", "createCanvasView$webview_sdk_release", "currentOrientation", "destroy", "getCacheKey", "getCanvas", "Lcom/eclipsesource/mmv8/V8Object;", "getElementId", "getFontSize", "getFps", "getHeight", "getId", "getLayoutCache", "getWidth", "isOnScreen", "postSyncBarrier", "postSyncBarrier$webview_sdk_release", "removeSyncBarrier", "removeSyncBarrier$webview_sdk_release", "restore", "resume", "save", "left", "", "top", "width", "height", "layout", "saveLastDraw", "setHeight", "setVideo", "bottom", "absoluteWidth", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "resumeLayout", "takeWhenValid", "Companion", "DrawInfo", "LayoutCache", "SyncBarrierInfo", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.ax.g, h
{
  static final String TAG;
  public static final a WjK;
  private static final j<Boolean> WjY;
  private static final j<MMKVSlotManager> WjZ;
  private static final j<Boolean> Wka;
  private static int Wkb;
  final boolean WjL;
  private final WeakReference<c> WjM;
  private final WeakReference<i> WjN;
  private final boolean WjO;
  l WjP;
  public kotlin.g.a.a<Float> WjQ;
  public kotlin.g.a.a<Float> WjR;
  public kotlin.g.a.a<Boolean> WjS;
  float[] WjT;
  public boolean WjU;
  g WjV;
  f WjW;
  e WjX;
  final String rzx;
  private int uJy;
  
  static
  {
    AppMethodBeat.i(261370);
    WjK = new a((byte)0);
    TAG = "MicroMsg.WebCanvasContext";
    WjY = k.cm((kotlin.g.a.a)d.Wke);
    WjZ = k.cm((kotlin.g.a.a)b.Wkc);
    Wka = k.cm((kotlin.g.a.a)c.Wkd);
    AppMethodBeat.o(261370);
  }
  
  public a(String paramString, boolean paramBoolean1, WeakReference<c> paramWeakReference, WeakReference<i> paramWeakReference1, boolean paramBoolean2)
  {
    AppMethodBeat.i(261308);
    this.rzx = paramString;
    this.WjL = paramBoolean1;
    this.WjM = paramWeakReference;
    this.WjN = paramWeakReference1;
    this.WjO = paramBoolean2;
    this.WjU = true;
    this.uJy = -1;
    AppMethodBeat.o(261308);
  }
  
  private static Integer D(Integer paramInteger)
  {
    AppMethodBeat.i(261322);
    if (paramInteger != null)
    {
      if (((Number)paramInteger).intValue() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(261322);
        return paramInteger;
      }
    }
    AppMethodBeat.o(261322);
    return null;
  }
  
  private static final void a(MagicBrushView paramMagicBrushView, a parama)
  {
    AppMethodBeat.i(261342);
    boolean bool = paramMagicBrushView.isShown();
    Log.v(TAG, "check layout height:#" + parama.rzx + ", " + paramMagicBrushView.getHeight() + ", " + bool);
    Object localObject = parama.WjW;
    int i;
    if (localObject == null)
    {
      i = -1;
      if ((bool) && (paramMagicBrushView.getLayoutParams() != null))
      {
        localObject = paramMagicBrushView.getLayoutParams();
        if ((localObject == null) || (((ViewGroup.LayoutParams)localObject).height != i)) {
          break label195;
        }
      }
    }
    label195:
    for (int j = 1;; j = 0)
    {
      if ((j == 0) && (i > 0))
      {
        localObject = paramMagicBrushView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i;
        Log.i(TAG, "check layout height:#" + parama.rzx + ", " + ((ViewGroup.LayoutParams)localObject).height);
        parama = ah.aiuX;
        paramMagicBrushView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(261342);
      return;
      i = ((f)localObject).height;
      break;
    }
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(261350);
    s.u(parama, "this$0");
    if (parama.iom()) {
      Log.e(TAG, s.X("removeSyncBarrier by delay:", parama.rzx));
    }
    AppMethodBeat.o(261350);
  }
  
  private static final void b(MagicBrushView paramMagicBrushView, a parama)
  {
    AppMethodBeat.i(261345);
    s.u(paramMagicBrushView, "$this_apply");
    s.u(parama, "this$0");
    a(paramMagicBrushView, parama);
    AppMethodBeat.o(261345);
  }
  
  private final f bhJ(String paramString)
  {
    AppMethodBeat.i(261326);
    String str = bhK(paramString);
    Log.d(TAG, s.X("getLayoutCache: #", paramString));
    if (s.p(paramString, this.rzx))
    {
      paramString = this.WjW;
      if (paramString == null)
      {
        paramString = bhL(str);
        if (paramString == null)
        {
          AppMethodBeat.o(261326);
          return null;
        }
        this.WjW = paramString;
        AppMethodBeat.o(261326);
        return paramString;
      }
      AppMethodBeat.o(261326);
      return paramString;
    }
    paramString = bhL(str);
    AppMethodBeat.o(261326);
    return paramString;
  }
  
  private final String bhK(String paramString)
  {
    AppMethodBeat.i(261335);
    paramString = new StringBuilder().append(paramString).append('-').append(ion()).append('-').append(getWidth()).append('-').append(getFontSize()).append('-');
    f.a locala = f.WlF;
    paramString = aw.isDarkMode();
    AppMethodBeat.o(261335);
    return paramString;
  }
  
  private static final f bhL(String paramString)
  {
    AppMethodBeat.i(261348);
    Object localObject = (MultiProcessMMKV)a.ior().findSlot(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(261348);
      return null;
    }
    paramString = ((MultiProcessMMKV)localObject).getString(paramString, "");
    if (paramString == null)
    {
      AppMethodBeat.o(261348);
      return null;
    }
    int i;
    if (!n.bp((CharSequence)paramString))
    {
      i = 1;
      if (i == 0) {
        break label83;
      }
    }
    for (;;)
    {
      if (paramString != null) {
        break label88;
      }
      AppMethodBeat.o(261348);
      return null;
      i = 0;
      break;
      label83:
      paramString = null;
    }
    label88:
    localObject = kotlinx.a.e.a.ajEc;
    a.f.b localb = f.Wkf;
    paramString = (f)((kotlinx.a.e.a.a)localObject).a((kotlinx.a.a)a.f.a.Wkh, paramString);
    AppMethodBeat.o(261348);
    return paramString;
  }
  
  private static final void bhM(String paramString) {}
  
  private static boolean iok()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  static int ion()
  {
    AppMethodBeat.i(261337);
    f.a locala = f.WlF;
    int i = f.a.getAppContext().getResources().getConfiguration().orientation;
    AppMethodBeat.o(261337);
    return i;
  }
  
  private final ViewGroup kz(View paramView)
  {
    AppMethodBeat.i(261318);
    View localView = paramView;
    paramView = localView.getParent();
    if ((paramView instanceof ListView))
    {
      paramView = (ListView)paramView;
      label25:
      if (paramView != null) {
        break label109;
      }
      paramView = localView.getParent();
      if (!(paramView instanceof RecyclerView)) {
        break label91;
      }
      paramView = (RecyclerView)paramView;
      label46:
      paramView = (ViewGroup)paramView;
      if (paramView != null) {
        break label101;
      }
      paramView = localView.getParent();
      if (!(paramView instanceof View)) {
        break label96;
      }
    }
    label91:
    label96:
    for (paramView = (View)paramView;; paramView = null)
    {
      localView = paramView;
      if (paramView != null) {
        break;
      }
      AppMethodBeat.o(261318);
      return null;
      paramView = null;
      break label25;
      paramView = null;
      break label46;
    }
    label101:
    AppMethodBeat.o(261318);
    return paramView;
    label109:
    paramView = (ViewGroup)paramView;
    AppMethodBeat.o(261318);
    return paramView;
  }
  
  final MagicBrushView apS()
  {
    AppMethodBeat.i(261392);
    Object localObject = this.WjP;
    if (localObject == null)
    {
      AppMethodBeat.o(261392);
      return null;
    }
    localObject = ((l)localObject).apS();
    AppMethodBeat.o(261392);
    return localObject;
  }
  
  public final boolean canVideoAutoPlay()
  {
    AppMethodBeat.i(261483);
    if (!((Boolean)WjY.getValue()).booleanValue())
    {
      AppMethodBeat.o(261483);
      return true;
    }
    Log.i(TAG, s.X("canVideoAutoPlay videoCanAutoPlayNow=", Boolean.valueOf(this.WjU)));
    boolean bool = this.WjU;
    AppMethodBeat.o(261483);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(261544);
    l locall = this.WjP;
    if (locall != null)
    {
      ioh().BL(locall.Wly);
      ioh().b("destroy", "{target:'" + this.rzx + "'}", a..ExternalSyntheticLambda0.INSTANCE);
      localObject = locall.apS().getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label209;
      }
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView((View)locall.apS());
      }
      localObject = locall.apS().getContext();
      if (!(localObject instanceof MutableContextWrapper)) {
        break label214;
      }
    }
    label209:
    label214:
    for (Object localObject = (MutableContextWrapper)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((MutableContextWrapper)localObject).setBaseContext(MMApplicationContext.getContext());
      }
      Log.i(TAG, "canvas#" + this.rzx + ':' + locall.Wly + '@' + locall.apS().getVirtualElementId() + " has been destroyed");
      locall.apS().destroy();
      this.WjP = null;
      AppMethodBeat.o(261544);
      return;
      localObject = null;
      break;
    }
  }
  
  final void f(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(261536);
    Object localObject = bhJ(this.rzx);
    int i;
    if (localObject != null)
    {
      if ((((f)localObject).width == 0) || (((f)localObject).height == 0) || (paramMagicBrushView.getWidth() == ((f)localObject).width) || (paramMagicBrushView.getHeight() == ((f)localObject).height)) {
        break label165;
      }
      i = 1;
      if (i == 0) {
        break label170;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramMagicBrushView.getLayoutParams();
        localLayoutParams.width = ((f)localObject).width;
        localLayoutParams.height = ((f)localObject).height;
        Log.i(TAG, "resume layout:#" + this.rzx + " size:[" + localLayoutParams.width + ", " + localLayoutParams.height + ']');
        localObject = ah.aiuX;
        paramMagicBrushView.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(261536);
      return;
      label165:
      i = 0;
      break;
      label170:
      localObject = null;
    }
  }
  
  public final V8Object getCanvas()
  {
    AppMethodBeat.i(261405);
    try
    {
      Object localObject1 = ioh();
      l locall = this.WjP;
      s.checkNotNull(locall);
      int i = locall.cMj;
      localObject1 = ((com.tencent.mm.plugin.appbrand.n.a)localObject1).sSU.getGlobalObject().getObject("NativeGlobal").executeObjectFunction("findElementById", ((com.tencent.mm.plugin.appbrand.n.a)localObject1).sSU.aEm().newV8Array().push(i));
      s.s(localObject1, "v8Context.globalObject.g…8Array().push(elementId))");
      AppMethodBeat.o(261405);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "getCanvas", new Object[0]);
        Object localObject2 = null;
      }
    }
  }
  
  public final int getElementId()
  {
    AppMethodBeat.i(261410);
    l locall = this.WjP;
    s.checkNotNull(locall);
    int i = locall.cMj;
    AppMethodBeat.o(261410);
    return i;
  }
  
  public final float getFontSize()
  {
    AppMethodBeat.i(261425);
    Object localObject = this.WjQ;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = (Float)((kotlin.g.a.a)localObject).invoke())
    {
      localObject = f.WlF;
      f = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
      AppMethodBeat.o(261425);
      return f;
    }
    float f = ((Float)localObject).floatValue();
    AppMethodBeat.o(261425);
    return f;
  }
  
  public final int getFps()
  {
    AppMethodBeat.i(261414);
    int i = (int)ioh().SKU.eod.auZ().eGw;
    AppMethodBeat.o(261414);
    return i;
  }
  
  public final int getHeight()
  {
    f.a locala = null;
    AppMethodBeat.i(261446);
    Object localObject1 = this.WjW;
    label34:
    int i;
    label45:
    Object localObject2;
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label195;
      }
      localObject1 = apS();
      if (localObject1 != null) {
        break label168;
      }
      localObject1 = null;
      localObject1 = D((Integer)localObject1);
      if (localObject1 != null) {
        break label179;
      }
      i = 0;
      localObject2 = TAG;
      localStringBuilder = new StringBuilder("getHeight canvasId=").append(this.rzx).append(" measuredHeight = ");
      localObject1 = apS();
      if (localObject1 != null) {
        break label203;
      }
      localObject1 = null;
      label86:
      localObject1 = D((Integer)localObject1);
      if (localObject1 != null) {
        break label214;
      }
    }
    for (localObject1 = locala;; localObject1 = Integer.valueOf(f.a.e((Number)localObject1)))
    {
      Log.v((String)localObject2, localObject1 + " height=" + i);
      AppMethodBeat.o(261446);
      return i;
      localObject1 = D(Integer.valueOf(((f)localObject1).height));
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject2 = f.WlF;
      localObject1 = Integer.valueOf(f.a.e((Number)localObject1));
      break;
      label168:
      localObject1 = Integer.valueOf(((MagicBrushView)localObject1).getMeasuredHeight());
      break label34;
      label179:
      localObject2 = f.WlF;
      i = f.a.e((Number)localObject1);
      break label45;
      label195:
      i = ((Integer)localObject1).intValue();
      break label45;
      label203:
      localObject1 = Integer.valueOf(((MagicBrushView)localObject1).getMeasuredHeight());
      break label86;
      label214:
      locala = f.WlF;
    }
  }
  
  public final String getId()
  {
    return this.rzx;
  }
  
  public final int getOffsetHeight()
  {
    AppMethodBeat.i(261459);
    Object localObject = apS();
    if (localObject == null)
    {
      AppMethodBeat.o(261459);
      return 0;
    }
    localObject = kz((View)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(261459);
      return 0;
    }
    localObject = D(Integer.valueOf(((ViewGroup)localObject).getMeasuredHeight()));
    if (localObject == null)
    {
      AppMethodBeat.o(261459);
      return 0;
    }
    f.a locala = f.WlF;
    int i = f.a.e((Number)localObject);
    AppMethodBeat.o(261459);
    return i;
  }
  
  public final int getOffsetTop()
  {
    AppMethodBeat.i(261456);
    Object localObject = apS();
    if (localObject == null)
    {
      AppMethodBeat.o(261456);
      return 0;
    }
    localObject = (View)localObject;
    ViewGroup localViewGroup = kz((View)localObject);
    if (localViewGroup == null)
    {
      AppMethodBeat.o(261456);
      return 0;
    }
    f.a locala = f.WlF;
    int i = f.a.e((Number)Integer.valueOf(com.tencent.mm.ae.d.cZ(localObject)[1] - com.tencent.mm.ae.d.cZ((View)localViewGroup)[1]));
    AppMethodBeat.o(261456);
    return i;
  }
  
  public final int getWidth()
  {
    f.a locala = null;
    AppMethodBeat.i(261438);
    Object localObject1 = this.WjW;
    label42:
    label61:
    label76:
    int i;
    label90:
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label457;
      }
      localObject1 = this.WjR;
      if (localObject1 != null) {
        break label366;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label448;
      }
      localObject1 = apS();
      if (localObject1 != null) {
        break label405;
      }
      localObject1 = null;
      localObject1 = D((Integer)localObject1);
      if (localObject1 != null) {
        break label418;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label439;
      }
      localObject1 = f.WlF;
      i = f.a.hBY();
      localObject2 = new StringBuilder("getWidth canvasId=").append(this.rzx).append(" measuredWidth = ");
      localObject1 = apS();
      if (localObject1 != null) {
        break label466;
      }
      localObject1 = null;
      label129:
      localObject1 = D((Integer)localObject1);
      if (localObject1 != null) {
        break label479;
      }
      localObject1 = locala;
      label145:
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append(" viewportWidth=");
      locala = f.WlF;
      localObject1 = f.a.hBY() + " width=" + i;
      if (this.uJy != i) {
        break label500;
      }
      Log.d(TAG, (String)localObject1);
    }
    for (;;)
    {
      this.uJy = i;
      AppMethodBeat.o(261438);
      return i;
      localObject1 = Integer.valueOf(((f)localObject1).width);
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label327;
        }
        localObject1 = null;
        break;
      }
      int k = ((Number)localObject1).intValue();
      localObject1 = f.WlF;
      localObject1 = ao.mX(f.a.getAppContext());
      int j = k;
      if (k == -1)
      {
        localObject2 = apS();
        if ((localObject2 == null) || (((MagicBrushView)localObject2).getMeasuredWidth() != ((ao.a)localObject1).height)) {
          break label322;
        }
      }
      label322:
      for (i = 1;; i = 0)
      {
        j = k;
        if (i != 0) {
          j = ((ao.a)localObject1).width;
        }
        localObject1 = Integer.valueOf(j);
        break;
      }
      label327:
      localObject1 = D((Integer)localObject1);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject2 = f.WlF;
      localObject1 = Integer.valueOf(f.a.e((Number)localObject1));
      break;
      label366:
      localObject1 = (Float)((kotlin.g.a.a)localObject1).invoke();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label42;
      }
      localObject1 = Integer.valueOf(kotlin.h.a.eH(((Float)localObject1).floatValue()));
      break label42;
      label405:
      localObject1 = Integer.valueOf(((MagicBrushView)localObject1).getMeasuredWidth());
      break label61;
      label418:
      localObject2 = f.WlF;
      localObject1 = Integer.valueOf(f.a.e((Number)localObject1));
      break label76;
      label439:
      i = ((Integer)localObject1).intValue();
      break label90;
      label448:
      i = ((Integer)localObject1).intValue();
      break label90;
      label457:
      i = ((Integer)localObject1).intValue();
      break label90;
      label466:
      localObject1 = Integer.valueOf(((MagicBrushView)localObject1).getMeasuredWidth());
      break label129;
      label479:
      locala = f.WlF;
      localObject1 = Integer.valueOf(f.a.e((Number)localObject1));
      break label145;
      label500:
      Log.i(TAG, (String)localObject1);
    }
  }
  
  public final i ioh()
  {
    AppMethodBeat.i(261383);
    Object localObject = this.WjN.get();
    s.checkNotNull(localObject);
    s.s(localObject, "renderJsEngineReference.get()!!");
    localObject = (i)localObject;
    AppMethodBeat.o(261383);
    return localObject;
  }
  
  public final c ioi()
  {
    AppMethodBeat.i(261386);
    Object localObject = this.WjM.get();
    s.checkNotNull(localObject);
    s.s(localObject, "logicJsEngineReference.get()!!");
    localObject = (c)localObject;
    AppMethodBeat.o(261386);
    return localObject;
  }
  
  public final void ioj()
  {
    AppMethodBeat.i(261505);
    Object localObject1 = this.WjW;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      int i = ((f)localObject1).width;
      int j = ((f)localObject1).height;
      float f = getFontSize();
      localObject2 = f.WlF;
      this.WjX = new e(i, j, f, aw.isDarkMode(), ion());
      localObject2 = TAG;
      localStringBuilder = new StringBuilder("saveLastDraw:[").append(((f)localObject1).width).append(", ").append(((f)localObject1).height).append(", ");
      localObject1 = this.WjX;
      if (localObject1 != null) {
        break label145;
      }
    }
    label145:
    for (localObject1 = null;; localObject1 = Integer.valueOf(((e)localObject1).orientation))
    {
      Log.d((String)localObject2, localObject1 + ']');
      AppMethodBeat.o(261505);
      return;
    }
  }
  
  public final void iol()
  {
    AppMethodBeat.i(261517);
    for (;;)
    {
      try
      {
        if (this.WjV != null)
        {
          Log.e(TAG, "barrier exists");
          return;
        }
        com.tencent.threadpool.h.ahAA.a(new a..ExternalSyntheticLambda2(this), 100L, TAG);
        if (iok())
        {
          Object localObject1 = MessageQueue.class.getMethod("postSyncBarrier", new Class[0]).invoke(Looper.getMainLooper().getQueue(), new Object[0]);
          Log.d(TAG, "postSyncBarrier " + this.rzx + " token:" + localObject1);
          ah localah = ah.aiuX;
          if (localObject1 != null) {
            break;
          }
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(261517);
          throw ((Throwable)localObject1);
        }
      }
      finally
      {
        AppMethodBeat.o(261517);
      }
      localObject3 = Looper.class.getMethod("postSyncBarrier", new Class[0]).invoke(Looper.getMainLooper(), new Object[0]);
    }
    this.WjV = new g(((Integer)localObject3).intValue(), MMSlotKt.now());
    Object localObject3 = ah.aiuX;
    AppMethodBeat.o(261517);
  }
  
  /* Error */
  public final boolean iom()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc_w 903
    //   5: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 840	com/tencent/mm/plugin/webcanvas/a:WjV	Lcom/tencent/mm/plugin/webcanvas/a$g;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnonnull +13 -> 29
    //   19: aload_0
    //   20: monitorexit
    //   21: ldc_w 903
    //   24: invokestatic 226	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iload_2
    //   28: ireturn
    //   29: aload_3
    //   30: getfield 906	com/tencent/mm/plugin/webcanvas/a$g:nrw	I
    //   33: istore_1
    //   34: invokestatic 861	com/tencent/mm/plugin/webcanvas/a:iok	()Z
    //   37: ifeq +89 -> 126
    //   40: ldc_w 863
    //   43: ldc_w 907
    //   46: iconst_1
    //   47: anewarray 866	java/lang/Class
    //   50: dup
    //   51: iconst_0
    //   52: getstatic 911	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   55: aastore
    //   56: invokevirtual 870	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   59: invokestatic 876	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   62: invokevirtual 880	android/os/Looper:getQueue	()Landroid/os/MessageQueue;
    //   65: iconst_1
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: iload_1
    //   72: invokestatic 758	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: aastore
    //   76: invokevirtual 885	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   79: pop
    //   80: getstatic 250	com/tencent/mm/plugin/webcanvas/a:TAG	Ljava/lang/String;
    //   83: new 319	java/lang/StringBuilder
    //   86: dup
    //   87: ldc_w 913
    //   90: invokespecial 323	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload_0
    //   94: getfield 290	com/tencent/mm/plugin/webcanvas/a:rzx	Ljava/lang/String;
    //   97: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 889
    //   103: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_1
    //   107: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 840	com/tencent/mm/plugin/webcanvas/a:WjV	Lcom/tencent/mm/plugin/webcanvas/a$g;
    //   121: iconst_1
    //   122: istore_2
    //   123: goto -104 -> 19
    //   126: ldc_w 872
    //   129: ldc_w 907
    //   132: iconst_1
    //   133: anewarray 866	java/lang/Class
    //   136: dup
    //   137: iconst_0
    //   138: getstatic 911	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   141: aastore
    //   142: invokevirtual 870	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   145: invokestatic 876	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   148: iconst_1
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: iload_1
    //   155: invokestatic 758	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: aastore
    //   159: invokevirtual 885	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   162: pop
    //   163: goto -83 -> 80
    //   166: astore_3
    //   167: aload_0
    //   168: monitorexit
    //   169: ldc_w 903
    //   172: invokestatic 226	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_3
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	a
    //   33	122	1	i	int
    //   1	122	2	bool	boolean
    //   14	16	3	localg	g
    //   166	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	15	166	finally
    //   29	80	166	finally
    //   80	121	166	finally
    //   126	163	166	finally
  }
  
  public final boolean isOnScreen()
  {
    AppMethodBeat.i(261421);
    Object localObject = this.WjP;
    if (localObject == null)
    {
      AppMethodBeat.o(261421);
      return false;
    }
    localObject = ((l)localObject).apS();
    if ((((MagicBrushView)localObject).isShown()) || (((MagicBrushView)localObject).isAttachedToWindow()))
    {
      View localView = (View)localObject;
      localObject = localView.getContext();
      if ((localObject instanceof MutableContextWrapper))
      {
        localObject = (MutableContextWrapper)localObject;
        if (localObject != null) {
          break label114;
        }
        localObject = null;
        label70:
        if (localObject != null) {
          break label122;
        }
        localObject = localView.getContext();
        label79:
        if (!(localObject instanceof MMActivity)) {
          break label125;
        }
        localObject = (MMActivity)localObject;
        label91:
        if (localObject != null) {
          break label130;
        }
      }
      label130:
      for (boolean bool = false;; bool = ((MMActivity)localObject).isPaused())
      {
        if (bool) {
          break label138;
        }
        AppMethodBeat.o(261421);
        return true;
        localObject = null;
        break;
        label114:
        localObject = ((MutableContextWrapper)localObject).getBaseContext();
        break label70;
        label122:
        break label79;
        label125:
        localObject = null;
        break label91;
      }
    }
    label138:
    AppMethodBeat.o(261421);
    return false;
  }
  
  public final String restore(String paramString)
  {
    AppMethodBeat.i(261499);
    s.u(paramString, "canvasId");
    paramString = bhJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(261499);
      return null;
    }
    paramString = paramString.Wkg;
    AppMethodBeat.o(261499);
    return paramString;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(261477);
    MagicBrushView localMagicBrushView = apS();
    if (localMagicBrushView != null)
    {
      a(localMagicBrushView, this);
      localMagicBrushView.post(new a..ExternalSyntheticLambda1(localMagicBrushView, this));
    }
    AppMethodBeat.o(261477);
  }
  
  public final void save(String paramString1, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, String paramString2)
  {
    AppMethodBeat.i(261493);
    s.u(paramString1, "canvasId");
    s.u(paramNumber1, "left");
    s.u(paramNumber2, "top");
    s.u(paramNumber3, "width");
    s.u(paramNumber4, "height");
    s.u(paramString2, "layout");
    Log.i(TAG, "saveLayout:#" + paramString1 + " location:[" + paramNumber1 + ", " + paramNumber2 + "], size:[" + paramNumber3 + ", " + paramNumber4 + ']');
    if ((s.p(paramNumber3, Integer.valueOf(0))) && (s.p(paramNumber4, Integer.valueOf(0))))
    {
      Log.e(TAG, "saveLayout:#" + paramString1 + " invalid params");
      AppMethodBeat.o(261493);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)a.ior().getSlotForWrite();
    String str = bhK(paramString1);
    kotlinx.a.e.a.a locala = kotlinx.a.e.a.ajEc;
    Object localObject = f.Wkf;
    localObject = (kotlinx.a.g)a.f.a.Wkh;
    paramNumber1 = new f(paramString1, a.a(paramNumber4, -2), a.a(paramNumber3, -1), paramNumber1.intValue(), paramNumber2.intValue(), paramString2);
    if (s.p(paramString1, this.rzx))
    {
      setHeight(paramNumber4);
      this.WjW = paramNumber1;
    }
    paramString1 = ah.aiuX;
    s.u(localObject, "serializer");
    paramString1 = new StringBuilder();
    new kotlinx.a.e.a.m(paramString1, locala, q.ajER, new kotlinx.a.e.g[q.values().length]).a((kotlinx.a.g)localObject, paramNumber1);
    paramString1 = paramString1.toString();
    s.s(paramString1, "result.toString()");
    localMultiProcessMMKV.putString(str, paramString1);
    AppMethodBeat.o(261493);
  }
  
  public final void setHeight(final Number paramNumber)
  {
    Object localObject2 = null;
    int i = 1;
    int k = -1;
    AppMethodBeat.i(261470);
    s.u(paramNumber, "height");
    if ((!this.WjO) || (s.p(paramNumber, Integer.valueOf(0))))
    {
      AppMethodBeat.o(261470);
      return;
    }
    Object localObject1 = this.WjS;
    if (localObject1 != null) {
      ((kotlin.g.a.a)localObject1).invoke();
    }
    localObject1 = f.WlF;
    final int m = f.a.d(paramNumber);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("#setHeight# pixelHeight=").append(m).append(", cacheHeight=");
    localObject1 = this.WjW;
    boolean bool;
    label168:
    label204:
    label227:
    int j;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = localStringBuilder.append(localObject1).append(" canvasId=#").append(this.rzx).append(' ').append(hashCode()).append(" onSetHeight:");
      if (this.WjS != null) {
        break label371;
      }
      bool = true;
      Log.d(str, bool);
      localObject1 = this.WjW;
      if ((localObject1 == null) || (m != ((f)localObject1).height)) {
        break label377;
      }
      if (i == 0)
      {
        str = this.rzx;
        localObject1 = this.WjW;
        if (localObject1 != null) {
          break label382;
        }
        i = -1;
        localObject1 = this.WjW;
        if (localObject1 != null) {
          break label391;
        }
        j = -1;
        label240:
        localObject1 = this.WjW;
        if (localObject1 != null) {
          break label400;
        }
        label251:
        localObject1 = this.WjW;
        if (localObject1 != null) {
          break label410;
        }
      }
    }
    label391:
    label400:
    label410:
    for (localObject1 = localObject2;; localObject1 = ((f)localObject1).Wkg)
    {
      this.WjW = new f(str, m, i, j, k, (String)localObject1);
      ioh().bhU(this.rzx);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this, m, paramNumber));
      Log.i(TAG, "setHeight:#" + this.rzx + ", " + paramNumber);
      AppMethodBeat.o(261470);
      return;
      localObject1 = Integer.valueOf(((f)localObject1).height);
      break;
      label371:
      bool = false;
      break label168;
      label377:
      i = 0;
      break label204;
      label382:
      i = ((f)localObject1).width;
      break label227;
      j = ((f)localObject1).left;
      break label240;
      k = ((f)localObject1).top;
      break label251;
    }
  }
  
  public final void setVideo(Number paramNumber1, Number paramNumber2)
  {
    AppMethodBeat.i(261481);
    s.u(paramNumber1, "top");
    s.u(paramNumber2, "bottom");
    Log.d(TAG, "setVideo:" + this.rzx + " to " + paramNumber1 + ' ' + paramNumber2);
    this.WjT = new float[] { paramNumber1.floatValue(), paramNumber2.floatValue() };
    AppMethodBeat.o(261481);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$Companion;", "", "()V", "TAG", "", "attachCount", "", "getAttachCount", "()I", "setAttachCount", "(I)V", "canvasStorage", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getCanvasStorage", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "canvasStorage$delegate", "Lkotlin/Lazy;", "pauseOnNoViewAttach", "", "getPauseOnNoViewAttach", "()Z", "pauseOnNoViewAttach$delegate", "videoAutoPlayOpen", "getVideoAutoPlayOpen", "videoAutoPlayOpen$delegate", "default", "", "def", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static int a(Number paramNumber, int paramInt)
    {
      AppMethodBeat.i(261226);
      if (s.p(paramNumber, Integer.valueOf(0)))
      {
        AppMethodBeat.o(261226);
        return paramInt;
      }
      f.a locala = f.WlF;
      paramInt = f.a.d(paramNumber);
      AppMethodBeat.o(261226);
      return paramInt;
    }
    
    public static MMKVSlotManager ior()
    {
      AppMethodBeat.i(261223);
      MMKVSlotManager localMMKVSlotManager = (MMKVSlotManager)a.ioo().getValue();
      AppMethodBeat.o(261223);
      return localMMKVSlotManager;
    }
    
    public static boolean ios()
    {
      AppMethodBeat.i(261231);
      boolean bool = ((Boolean)a.iop().getValue()).booleanValue();
      AppMethodBeat.o(261231);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<MMKVSlotManager>
  {
    public static final b Wkc;
    
    static
    {
      AppMethodBeat.i(261221);
      Wkc = new b();
      AppMethodBeat.o(261221);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final c Wkd;
    
    static
    {
      AppMethodBeat.i(261246);
      Wkd = new c();
      AppMethodBeat.o(261246);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final d Wke;
    
    static
    {
      AppMethodBeat.i(261251);
      Wke = new d();
      AppMethodBeat.o(261251);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$DrawInfo;", "", "width", "", "height", "fontSize", "", "isDarkMode", "", "orientation", "(IIFZI)V", "getFontSize", "()F", "getHeight", "()I", "()Z", "getOrientation", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
  {
    final boolean ehd;
    final float fontSize;
    final int height;
    final int orientation;
    final int width;
    
    public e(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean, int paramInt3)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.fontSize = paramFloat;
      this.ehd = paramBoolean;
      this.orientation = paramInt3;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(261266);
      if (this == paramObject)
      {
        AppMethodBeat.o(261266);
        return true;
      }
      if (!(paramObject instanceof e))
      {
        AppMethodBeat.o(261266);
        return false;
      }
      paramObject = (e)paramObject;
      if (this.width != paramObject.width)
      {
        AppMethodBeat.o(261266);
        return false;
      }
      if (this.height != paramObject.height)
      {
        AppMethodBeat.o(261266);
        return false;
      }
      if (!s.p(Float.valueOf(this.fontSize), Float.valueOf(paramObject.fontSize)))
      {
        AppMethodBeat.o(261266);
        return false;
      }
      if (this.ehd != paramObject.ehd)
      {
        AppMethodBeat.o(261266);
        return false;
      }
      if (this.orientation != paramObject.orientation)
      {
        AppMethodBeat.o(261266);
        return false;
      }
      AppMethodBeat.o(261266);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(261257);
      String str = "DrawInfo(width=" + this.width + ", height=" + this.height + ", fontSize=" + this.fontSize + ", isDarkMode=" + this.ehd + ", orientation=" + this.orientation + ')';
      AppMethodBeat.o(261257);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "", "seen1", "", "canvasId", "", "height", "width", "left", "top", "layout", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IIIILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;IIIILjava/lang/String;)V", "getCanvasId", "()Ljava/lang/String;", "setCanvasId", "(Ljava/lang/String;)V", "getHeight", "()I", "setHeight", "(I)V", "getLayout", "setLayout", "getLeft", "setLeft", "getTop", "setTop", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
  {
    public static final b Wkf;
    String Wkg;
    int height;
    int left;
    private String rzx;
    int top;
    int width;
    
    static
    {
      AppMethodBeat.i(261279);
      Wkf = new b((byte)0);
      AppMethodBeat.o(261279);
    }
    
    public f(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
    {
      AppMethodBeat.i(261261);
      this.rzx = paramString1;
      this.height = paramInt1;
      this.width = paramInt2;
      this.left = paramInt3;
      this.top = paramInt4;
      this.Wkg = paramString2;
      AppMethodBeat.o(261261);
    }
    
    public static final void a(f paramf, kotlinx.a.c.d paramd, e parame)
    {
      int j = 1;
      AppMethodBeat.i(261268);
      s.u(paramf, "self");
      s.u(paramd, "output");
      s.u(parame, "serialDesc");
      paramd.a(parame, paramf.rzx);
      paramd.a(parame, 1, paramf.height);
      int i;
      if (paramd.f(parame))
      {
        i = 1;
        if (i != 0) {
          paramd.a(parame, 2, paramf.width);
        }
        if (!paramd.f(parame)) {
          break label190;
        }
        i = 1;
        label89:
        if (i != 0) {
          paramd.a(parame, 3, paramf.left);
        }
        if (!paramd.f(parame)) {
          break label207;
        }
        i = 1;
        label117:
        if (i != 0) {
          paramd.a(parame, 4, paramf.top);
        }
        if (!paramd.f(parame)) {
          break label224;
        }
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          paramd.a(parame, (kotlinx.a.g)al.ajDU, paramf.Wkg);
        }
        AppMethodBeat.o(261268);
        return;
        if (paramf.width != 0)
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        label190:
        if (paramf.left != 0)
        {
          i = 1;
          break label89;
        }
        i = 0;
        break label89;
        label207:
        if (paramf.top != 0)
        {
          i = 1;
          break label117;
        }
        i = 0;
        break label117;
        label224:
        i = j;
        if (paramf.Wkg == null) {
          i = 0;
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(261304);
      if (this == paramObject)
      {
        AppMethodBeat.o(261304);
        return true;
      }
      if (!(paramObject instanceof f))
      {
        AppMethodBeat.o(261304);
        return false;
      }
      paramObject = (f)paramObject;
      if (!s.p(this.rzx, paramObject.rzx))
      {
        AppMethodBeat.o(261304);
        return false;
      }
      if (this.height != paramObject.height)
      {
        AppMethodBeat.o(261304);
        return false;
      }
      if (this.width != paramObject.width)
      {
        AppMethodBeat.o(261304);
        return false;
      }
      if (this.left != paramObject.left)
      {
        AppMethodBeat.o(261304);
        return false;
      }
      if (this.top != paramObject.top)
      {
        AppMethodBeat.o(261304);
        return false;
      }
      if (!s.p(this.Wkg, paramObject.Wkg))
      {
        AppMethodBeat.o(261304);
        return false;
      }
      AppMethodBeat.o(261304);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(261295);
      int j = this.rzx.hashCode();
      int k = this.height;
      int m = this.width;
      int n = this.left;
      int i1 = this.top;
      if (this.Wkg == null) {}
      for (int i = 0;; i = this.Wkg.hashCode())
      {
        AppMethodBeat.o(261295);
        return i + ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(261286);
      String str = "LayoutCache(canvasId=" + this.rzx + ", height=" + this.height + ", width=" + this.width + ", left=" + this.left + ", top=" + this.top + ", layout=" + this.Wkg + ')';
      AppMethodBeat.o(261286);
      return str;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$SyncBarrierInfo;", "", "token", "", "start", "", "(IJ)V", "getStart", "()J", "getToken", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class g
  {
    final int nrw;
    final long start;
    
    public g(int paramInt, long paramLong)
    {
      this.nrw = paramInt;
      this.start = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof g)) {
          return false;
        }
        paramObject = (g)paramObject;
        if (this.nrw != paramObject.nrw) {
          return false;
        }
      } while (this.start == paramObject.start);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(261264);
      int i = this.nrw;
      int j = q.a..ExternalSyntheticBackport0.m(this.start);
      AppMethodBeat.o(261264);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(261260);
      String str = "SyncBarrierInfo(token=" + this.nrw + ", start=" + this.start + ')';
      AppMethodBeat.o(261260);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(MutableContextWrapper paramMutableContextWrapper, ViewGroup paramViewGroup, l paraml, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(a parama, int paramInt, Number paramNumber)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.a
 * JD-Core Version:    0.7.0.1
 */