package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.av.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.a.b;
import kotlinx.a.b.bf;
import kotlinx.a.c.a.r;
import kotlinx.a.c.u;
import kotlinx.a.h;
import kotlinx.a.v;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;", "canvasId", "", "needCheckDrawChanged", "", "logicJsEngineReference", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "renderJsEngineReference", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "updateHeight", "(Ljava/lang/String;ZLjava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Z)V", "barrier", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$SyncBarrierInfo;", "barrierStartTime", "", "getBarrierStartTime", "()J", "lastDraw", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$DrawInfo;", "layoutCache", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "logicJsEngine", "getLogicJsEngine$webview_sdk_release", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "getMagicBrush$webview_sdk_release", "()Lcom/tencent/magicbrush/MagicBrush;", "magicBrushView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "getMagicBrushView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "methodInQueue", "getMethodInQueue", "()Z", "onGetFontSize", "Lkotlin/Function0;", "", "getOnGetFontSize", "()Lkotlin/jvm/functions/Function0;", "setOnGetFontSize", "(Lkotlin/jvm/functions/Function0;)V", "onGetWidth", "getOnGetWidth", "setOnGetWidth", "onSetHeight", "getOnSetHeight", "setOnSetHeight", "renderJsEngine", "getRenderJsEngine$webview_sdk_release", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "videoCanAutoPlayNow", "getVideoCanAutoPlayNow", "setVideoCanAutoPlayNow", "(Z)V", "videoPos", "", "getVideoPos", "()[F", "setVideoPos", "([F)V", "view", "getView", "viewContext", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasViewContext;", "isParentPaused", "Landroid/view/View;", "(Landroid/view/View;)Z", "offsetHeight", "", "getOffsetHeight", "(Landroid/view/View;)I", "offsetTop", "getOffsetTop", "parentListView", "Landroid/view/ViewGroup;", "getParentListView", "(Landroid/view/View;)Landroid/view/ViewGroup;", "attach", "", "attach$webview_sdk_release", "canVideoAutoPlay", "checkDrawChanged", "start", "createCanvasView", "context", "Landroid/content/Context;", "createCanvasView$webview_sdk_release", "currentOrientation", "destroy", "destroy$webview_sdk_release", "getCacheKey", "getCanvas", "Lcom/eclipsesource/mmv8/V8Object;", "getElementId", "getFontSize", "getFps", "getHeight", "getId", "getLayoutCache", "getWidth", "isOnScreen", "postSyncBarrier", "postSyncBarrier$webview_sdk_release", "removeSyncBarrier", "removeSyncBarrier$webview_sdk_release", "restore", "save", "left", "", "top", "width", "height", "layout", "saveLastDraw", "setHeight", "setVideo", "bottom", "absoluteWidth", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "resumeLayout", "takeWhenValid", "Companion", "DrawInfo", "LayoutCache", "SyncBarrierInfo", "webview-sdk_release"})
public final class a
  implements com.tencent.mm.plugin.av.g, j
{
  private static final kotlin.f Ptk;
  private static final kotlin.f Ptm;
  private static final kotlin.f Ptn;
  private static int Pto = 0;
  public static final a Ptp;
  static final String TAG = "MicroMsg.WebCanvasContext";
  n PsX;
  public kotlin.g.a.a<Float> PsY;
  public kotlin.g.a.a<Float> PsZ;
  public kotlin.g.a.a<Boolean> Pta;
  float[] Ptb;
  public boolean Ptc;
  g Ptd;
  f Pte;
  e Ptf;
  final boolean Ptg;
  private final WeakReference<c> Pth;
  private final WeakReference<k> Pti;
  private final boolean Ptj;
  final String owd;
  
  static
  {
    AppMethodBeat.i(206225);
    Ptp = new a((byte)0);
    TAG = "MicroMsg.WebCanvasContext";
    Ptk = kotlin.g.ar((kotlin.g.a.a)d.Pts);
    Ptm = kotlin.g.ar((kotlin.g.a.a)b.Ptq);
    Ptn = kotlin.g.ar((kotlin.g.a.a)c.Ptr);
    AppMethodBeat.o(206225);
  }
  
  public a(String paramString, boolean paramBoolean1, WeakReference<c> paramWeakReference, WeakReference<k> paramWeakReference1, boolean paramBoolean2)
  {
    AppMethodBeat.i(206223);
    this.owd = paramString;
    this.Ptg = paramBoolean1;
    this.Pth = paramWeakReference;
    this.Pti = paramWeakReference1;
    this.Ptj = paramBoolean2;
    this.Ptc = true;
    AppMethodBeat.o(206223);
  }
  
  private final f bia(String paramString)
  {
    AppMethodBeat.i(206216);
    j localj = new j(bib(paramString));
    Log.d(TAG, "getLayoutCache: #".concat(String.valueOf(paramString)));
    if (p.h(paramString, this.owd))
    {
      f localf = this.Pte;
      paramString = localf;
      if (localf == null)
      {
        paramString = localj.gPg();
        if (paramString != null)
        {
          this.Pte = paramString;
          AppMethodBeat.o(206216);
          return paramString;
        }
        AppMethodBeat.o(206216);
        return null;
      }
    }
    else
    {
      paramString = localj.gPg();
    }
    AppMethodBeat.o(206216);
    return paramString;
  }
  
  private final String bib(String paramString)
  {
    AppMethodBeat.i(206221);
    paramString = new StringBuilder().append(paramString).append('-').append(gOY()).append('-').append(getWidth()).append('-').append(getFontSize()).append('-');
    f.a locala = com.tencent.mm.plugin.av.f.Pvm;
    paramString = ar.isDarkMode();
    AppMethodBeat.o(206221);
    return paramString;
  }
  
  static boolean gOW()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  static int gOY()
  {
    AppMethodBeat.i(206222);
    Object localObject = com.tencent.mm.plugin.av.f.Pvm;
    localObject = f.a.getAppContext().getResources();
    p.j(localObject, "appContext.resources");
    int i = ((Resources)localObject).getConfiguration().orientation;
    AppMethodBeat.o(206222);
    return i;
  }
  
  private final ViewGroup hl(View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(206198);
    Object localObject1 = paramView;
    ViewParent localViewParent = ((View)localObject1).getParent();
    paramView = localViewParent;
    if (!(localViewParent instanceof ListView)) {
      paramView = null;
    }
    paramView = (ListView)paramView;
    if (paramView != null) {}
    for (paramView = (ViewGroup)paramView;; paramView = (ViewGroup)paramView)
    {
      if (paramView != null) {
        break label107;
      }
      localObject1 = ((View)localObject1).getParent();
      paramView = (View)localObject1;
      if (!(localObject1 instanceof View)) {
        paramView = null;
      }
      localObject1 = (View)paramView;
      paramView = localObject2;
      if (localObject1 == null) {
        break label107;
      }
      break;
      localViewParent = ((View)localObject1).getParent();
      paramView = localViewParent;
      if (!(localViewParent instanceof RecyclerView)) {
        paramView = null;
      }
    }
    label107:
    AppMethodBeat.o(206198);
    return paramView;
  }
  
  private static Integer w(Integer paramInteger)
  {
    AppMethodBeat.i(206205);
    if (paramInteger != null)
    {
      if (((Number)paramInteger).intValue() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(206205);
        return paramInteger;
      }
      AppMethodBeat.o(206205);
      return null;
    }
    AppMethodBeat.o(206205);
    return null;
  }
  
  final MagicBrushView PI()
  {
    AppMethodBeat.i(206197);
    Object localObject = this.PsX;
    if (localObject != null)
    {
      localObject = ((n)localObject).PI();
      AppMethodBeat.o(206197);
      return localObject;
    }
    AppMethodBeat.o(206197);
    return null;
  }
  
  public final boolean canVideoAutoPlay()
  {
    AppMethodBeat.i(206212);
    if (!((Boolean)Ptk.getValue()).booleanValue())
    {
      AppMethodBeat.o(206212);
      return true;
    }
    Log.i(TAG, "canVideoAutoPlay videoCanAutoPlayNow=" + this.Ptc);
    boolean bool = this.Ptc;
    AppMethodBeat.o(206212);
    return bool;
  }
  
  final void f(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(206220);
    f localf = bia(this.owd);
    if (localf != null)
    {
      int i;
      if ((localf.width != 0) && (localf.height != 0) && (paramMagicBrushView.getWidth() != localf.width) && (paramMagicBrushView.getHeight() != localf.height))
      {
        i = 1;
        if (i == 0) {
          break label166;
        }
      }
      for (;;)
      {
        if (localf == null) {
          break label171;
        }
        ViewGroup.LayoutParams localLayoutParams = paramMagicBrushView.getLayoutParams();
        localLayoutParams.width = localf.width;
        localLayoutParams.height = localf.height;
        Log.i(TAG, "resume layout:#" + this.owd + " size:[" + localLayoutParams.width + ", " + localLayoutParams.height + ']');
        paramMagicBrushView.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(206220);
        return;
        i = 0;
        break;
        label166:
        localf = null;
      }
    }
    label171:
    AppMethodBeat.o(206220);
  }
  
  public final k gOT()
  {
    AppMethodBeat.i(206194);
    Object localObject = this.Pti.get();
    if (localObject == null) {
      p.iCn();
    }
    p.j(localObject, "renderJsEngineReference.get()!!");
    localObject = (k)localObject;
    AppMethodBeat.o(206194);
    return localObject;
  }
  
  public final c gOU()
  {
    AppMethodBeat.i(206195);
    Object localObject = this.Pth.get();
    if (localObject == null) {
      p.iCn();
    }
    p.j(localObject, "logicJsEngineReference.get()!!");
    localObject = (c)localObject;
    AppMethodBeat.o(206195);
    return localObject;
  }
  
  public final void gOV()
  {
    AppMethodBeat.i(206217);
    Object localObject1 = this.Pte;
    if (localObject1 != null)
    {
      int i = ((f)localObject1).width;
      int j = ((f)localObject1).height;
      float f = getFontSize();
      Object localObject2 = com.tencent.mm.plugin.av.f.Pvm;
      this.Ptf = new e(i, j, f, ar.isDarkMode(), gOY());
      localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder("saveLastDraw:[").append(((f)localObject1).width).append(", ").append(((f)localObject1).height).append(", ");
      localObject1 = this.Ptf;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((e)localObject1).FO);; localObject1 = null)
      {
        Log.d((String)localObject2, localObject1 + ']');
        AppMethodBeat.o(206217);
        return;
      }
    }
    AppMethodBeat.o(206217);
  }
  
  public final boolean gOX()
  {
    boolean bool = true;
    AppMethodBeat.i(206219);
    for (;;)
    {
      try
      {
        Object localObject1 = this.Ptd;
        if (localObject1 != null)
        {
          int i = ((g)localObject1).kPS;
          if (gOW())
          {
            localObject1 = MessageQueue.class.getMethod("removeSyncBarrier", new Class[] { Integer.TYPE });
            Looper localLooper = Looper.getMainLooper();
            p.j(localLooper, "Looper.getMainLooper()");
            ((Method)localObject1).invoke(localLooper.getQueue(), new Object[] { Integer.valueOf(i) });
            Log.d(TAG, "removeSyncBarrier " + this.owd + " token:" + i);
            this.Ptd = null;
            return bool;
          }
          Looper.class.getMethod("removeSyncBarrier", new Class[] { Integer.TYPE }).invoke(Looper.getMainLooper(), new Object[] { Integer.valueOf(i) });
          continue;
        }
        bool = false;
      }
      finally
      {
        AppMethodBeat.o(206219);
      }
    }
  }
  
  public final V8Object getCanvas()
  {
    AppMethodBeat.i(206199);
    try
    {
      localObject1 = gOT();
      Object localObject3 = this.PsX;
      if (localObject3 == null) {
        p.iCn();
      }
      int i = ((n)localObject3).aSn;
      localObject3 = ((k)localObject1).bYR();
      p.j(localObject3, "v8Context");
      localObject1 = ((m)localObject3).getGlobalObject().getObject("NativeGlobal").executeObjectFunction("findElementById", ((k)localObject1).bYR().newV8Array().push(i));
      p.j(localObject1, "v8Context.globalObject.g…8Array().push(elementId))");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Log.printErrStackTrace(TAG, (Throwable)localException, "getCanvas", new Object[0]);
        Object localObject2 = null;
      }
    }
    AppMethodBeat.o(206199);
    return localObject1;
  }
  
  public final int getElementId()
  {
    AppMethodBeat.i(206200);
    n localn = this.PsX;
    if (localn == null) {
      p.iCn();
    }
    int i = localn.aSn;
    AppMethodBeat.o(206200);
    return i;
  }
  
  public final float getFontSize()
  {
    AppMethodBeat.i(206204);
    Object localObject = this.PsY;
    if (localObject != null)
    {
      localObject = (Float)((kotlin.g.a.a)localObject).invoke();
      if (localObject != null)
      {
        f = ((Float)localObject).floatValue();
        AppMethodBeat.o(206204);
        return f;
      }
    }
    localObject = com.tencent.mm.plugin.av.f.Pvm;
    float f = com.tencent.mm.ci.a.ez(MMApplicationContext.getContext());
    AppMethodBeat.o(206204);
    return f;
  }
  
  public final int getFps()
  {
    AppMethodBeat.i(206201);
    int i = (int)gOT().szG.Uw().cLa;
    AppMethodBeat.o(206201);
    return i;
  }
  
  public final int getHeight()
  {
    Object localObject2 = null;
    AppMethodBeat.i(206207);
    Object localObject1 = this.Pte;
    Object localObject3;
    int i;
    label57:
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject1 = w(Integer.valueOf(((f)localObject1).height));
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.plugin.av.f.Pvm;
        localObject1 = Integer.valueOf(f.a.e((Number)localObject1));
        if (localObject1 == null) {
          break label220;
        }
        i = ((Integer)localObject1).intValue();
        localObject3 = TAG;
        localStringBuilder = new StringBuilder("getHeight canvasId=").append(this.owd).append(" measuredHeight = ");
        localObject1 = PI();
        if (localObject1 == null) {
          break label225;
        }
      }
    }
    label215:
    label220:
    label225:
    for (localObject1 = Integer.valueOf(((MagicBrushView)localObject1).getMeasuredHeight());; localObject1 = null)
    {
      Integer localInteger = w((Integer)localObject1);
      localObject1 = localObject2;
      if (localInteger != null)
      {
        localObject1 = com.tencent.mm.plugin.av.f.Pvm;
        localObject1 = Integer.valueOf(f.a.e((Number)localInteger));
      }
      Log.v((String)localObject3, localObject1 + " height=" + i);
      AppMethodBeat.o(206207);
      return i;
      localObject1 = PI();
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((MagicBrushView)localObject1).getMeasuredHeight());; localObject1 = null)
      {
        localObject1 = w((Integer)localObject1);
        if (localObject1 == null) {
          break label215;
        }
        localObject3 = com.tencent.mm.plugin.av.f.Pvm;
        localObject1 = Integer.valueOf(f.a.e((Number)localObject1));
        break;
      }
      localObject1 = null;
      break;
      i = 0;
      break label57;
    }
  }
  
  public final String getId()
  {
    return this.owd;
  }
  
  public final int getOffsetHeight()
  {
    AppMethodBeat.i(206209);
    Object localObject = PI();
    if (localObject != null)
    {
      localObject = hl((View)localObject);
      if (localObject != null)
      {
        localObject = w(Integer.valueOf(((ViewGroup)localObject).getMeasuredHeight()));
        if (localObject != null)
        {
          f.a locala = com.tencent.mm.plugin.av.f.Pvm;
          int i = f.a.e((Number)localObject);
          AppMethodBeat.o(206209);
          return i;
        }
      }
      AppMethodBeat.o(206209);
      return 0;
    }
    AppMethodBeat.o(206209);
    return 0;
  }
  
  public final int getOffsetTop()
  {
    AppMethodBeat.i(206208);
    Object localObject = PI();
    if (localObject != null)
    {
      localObject = (View)localObject;
      ViewGroup localViewGroup = hl((View)localObject);
      if (localViewGroup != null)
      {
        f.a locala = com.tencent.mm.plugin.av.f.Pvm;
        int i = f.a.e((Number)Integer.valueOf(d.cE(localObject)[1] - d.cE((View)localViewGroup)[1]));
        AppMethodBeat.o(206208);
        return i;
      }
      AppMethodBeat.o(206208);
      return 0;
    }
    AppMethodBeat.o(206208);
    return 0;
  }
  
  public final int getWidth()
  {
    Object localObject3 = null;
    AppMethodBeat.i(206206);
    Object localObject1 = this.Pte;
    int i;
    Object localObject2;
    label140:
    label170:
    label200:
    label211:
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((f)localObject1).width);
      if (localObject1 != null)
      {
        int j = ((Number)localObject1).intValue();
        i = j;
        if (j == -1)
        {
          localObject1 = PI();
          i = j;
          if (localObject1 != null)
          {
            int k = ((MagicBrushView)localObject1).getMeasuredWidth();
            localObject1 = com.tencent.mm.plugin.av.f.Pvm;
            i = j;
            if (k == com.tencent.mm.ci.a.ks(f.a.getAppContext()))
            {
              localObject1 = com.tencent.mm.plugin.av.f.Pvm;
              i = com.tencent.mm.ci.a.kr(f.a.getAppContext());
            }
          }
        }
        localObject1 = Integer.valueOf(i);
        if (localObject1 == null) {
          break label335;
        }
        localObject1 = w((Integer)localObject1);
        if (localObject1 == null) {
          break label335;
        }
        localObject2 = com.tencent.mm.plugin.av.f.Pvm;
        localObject1 = Integer.valueOf(f.a.e((Number)localObject1));
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = PI();
          if (localObject1 == null) {
            break label385;
          }
          localObject1 = Integer.valueOf(((MagicBrushView)localObject1).getMeasuredWidth());
          localObject1 = w((Integer)localObject1);
          if (localObject1 == null) {
            break label391;
          }
          localObject2 = com.tencent.mm.plugin.av.f.Pvm;
          localObject2 = Integer.valueOf(f.a.e((Number)localObject1));
        }
        if (localObject2 == null) {
          break label397;
        }
        i = ((Integer)localObject2).intValue();
        localObject2 = TAG;
        localStringBuilder = new StringBuilder("getWidth canvasId=").append(this.owd).append(" measuredWidth = ");
        localObject1 = PI();
        if (localObject1 == null) {
          break label482;
        }
      }
    }
    label335:
    label482:
    for (localObject1 = Integer.valueOf(((MagicBrushView)localObject1).getMeasuredWidth());; localObject1 = null)
    {
      Integer localInteger = w((Integer)localObject1);
      localObject1 = localObject3;
      if (localInteger != null)
      {
        localObject1 = com.tencent.mm.plugin.av.f.Pvm;
        localObject1 = Integer.valueOf(f.a.e((Number)localInteger));
      }
      Log.v((String)localObject2, localObject1 + " width=" + i);
      AppMethodBeat.o(206206);
      return i;
      localObject1 = null;
      break;
      localObject1 = this.PsZ;
      if (localObject1 != null)
      {
        localObject1 = (Float)((kotlin.g.a.a)localObject1).invoke();
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(kotlin.h.a.dm(((Float)localObject1).floatValue()));
          break label140;
        }
      }
      localObject1 = null;
      break label140;
      localObject1 = null;
      break label170;
      localObject2 = null;
      break label200;
      localObject1 = com.tencent.mm.plugin.av.f.Pvm;
      localObject1 = com.tencent.mm.plugin.av.f.Pvm;
      localObject1 = f.a.getAppContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(206206);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.j(localObject1, "(appContext.getSystemSer…owManager).defaultDisplay");
      i = f.a.e((Number)Integer.valueOf(((Display)localObject1).getWidth()));
      break label211;
    }
  }
  
  public final boolean isOnScreen()
  {
    AppMethodBeat.i(206203);
    Object localObject1 = this.PsX;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((n)localObject1).PI();
      if (localObject1 != null) {
        if ((((MagicBrushView)localObject1).isShown()) || (((MagicBrushView)localObject1).isAttachedToWindow()))
        {
          View localView = (View)localObject1;
          localObject2 = localView.getContext();
          localObject1 = localObject2;
          if (!(localObject2 instanceof MutableContextWrapper)) {
            localObject1 = null;
          }
          localObject1 = (MutableContextWrapper)localObject1;
          if (localObject1 != null)
          {
            localObject1 = ((MutableContextWrapper)localObject1).getBaseContext();
            if (localObject1 != null) {
              break label143;
            }
          }
          localObject1 = localView.getContext();
        }
      }
    }
    label143:
    for (;;)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof MMActivity)) {
        localObject2 = null;
      }
      localObject1 = (MMActivity)localObject2;
      if (localObject1 != null) {}
      for (boolean bool = ((MMActivity)localObject1).isPaused(); !bool; bool = false)
      {
        AppMethodBeat.o(206203);
        return true;
      }
      AppMethodBeat.o(206203);
      return false;
      AppMethodBeat.o(206203);
      return false;
    }
  }
  
  public final String restore(String paramString)
  {
    AppMethodBeat.i(206215);
    p.k(paramString, "canvasId");
    paramString = bia(paramString);
    if (paramString != null)
    {
      paramString = paramString.Ptt;
      AppMethodBeat.o(206215);
      return paramString;
    }
    AppMethodBeat.o(206215);
    return null;
  }
  
  public final void save(String paramString1, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, String paramString2)
  {
    AppMethodBeat.i(206213);
    p.k(paramString1, "canvasId");
    p.k(paramNumber1, "left");
    p.k(paramNumber2, "top");
    p.k(paramNumber3, "width");
    p.k(paramNumber4, "height");
    p.k(paramString2, "layout");
    Log.i(TAG, "saveLayout:#" + paramString1 + " location:[" + paramNumber1 + ", " + paramNumber2 + "], size:[" + paramNumber3 + ", " + paramNumber4 + ']');
    if ((p.h(paramNumber3, Integer.valueOf(0))) && (p.h(paramNumber4, Integer.valueOf(0))))
    {
      Log.e(TAG, "saveLayout:#" + paramString1 + " invalid params");
      AppMethodBeat.o(206213);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)a.gPc().getSlotForWrite();
    String str = bib(paramString1);
    Object localObject = kotlinx.a.c.a.abCB;
    localObject = f.Ptu;
    localObject = (v)a.f.a.Ptv;
    paramNumber1 = new f(paramString1, a.a(paramNumber4, -2), a.a(paramNumber3, -1), paramNumber1.intValue(), paramNumber2.intValue(), paramString2);
    if (p.h(paramString1, this.owd))
    {
      setHeight(paramNumber4);
      this.Pte = paramNumber1;
    }
    p.k(localObject, "serializer");
    paramNumber2 = kotlinx.a.c.a.iTU();
    p.k(localObject, "serializer");
    paramString1 = new StringBuilder();
    paramNumber2 = (kotlinx.a.g)new kotlinx.a.c.a.n(paramString1, paramNumber2, r.abDN, new u[r.values().length]);
    p.k(paramNumber2, "$this$encode");
    p.k(localObject, "strategy");
    paramNumber2.a((v)localObject, paramNumber1);
    paramString1 = paramString1.toString();
    p.j(paramString1, "result.toString()");
    localMultiProcessMMKV.putString(str, paramString1);
    AppMethodBeat.o(206213);
  }
  
  public final void setHeight(final Number paramNumber)
  {
    Object localObject2 = null;
    int k = -1;
    AppMethodBeat.i(206210);
    p.k(paramNumber, "height");
    if ((!this.Ptj) || (p.h(paramNumber, Integer.valueOf(0))))
    {
      AppMethodBeat.o(206210);
      return;
    }
    Object localObject1 = this.Pta;
    if (localObject1 != null) {
      ((kotlin.g.a.a)localObject1).invoke();
    }
    localObject1 = com.tencent.mm.plugin.av.f.Pvm;
    final int m = f.a.d(paramNumber);
    String str = TAG;
    Object localObject3 = new StringBuilder("#setHeight# pixelHeight=").append(m).append(", cacheHeight=");
    localObject1 = this.Pte;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((f)localObject1).height);
      Log.d(str, localObject1 + " canvasId=#" + this.owd + ' ' + hashCode());
      localObject1 = this.Pte;
      if ((localObject1 == null) || (m != ((f)localObject1).height))
      {
        str = this.owd;
        localObject1 = this.Pte;
        if (localObject1 == null) {
          break label362;
        }
        i = ((f)localObject1).width;
        label207:
        localObject1 = this.Pte;
        if (localObject1 == null) {
          break label367;
        }
      }
    }
    label362:
    label367:
    for (int j = ((f)localObject1).left;; j = -1)
    {
      localObject1 = this.Pte;
      if (localObject1 != null) {
        k = ((f)localObject1).top;
      }
      localObject3 = this.Pte;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((f)localObject3).Ptt;
      }
      this.Pte = new f(str, m, i, j, k, (String)localObject1);
      gOT().bii(this.owd);
      d.uiThread((kotlin.g.a.a)new l(this, m, paramNumber));
      Log.i(TAG, "setHeight:#" + this.owd + ", " + paramNumber);
      AppMethodBeat.o(206210);
      return;
      localObject1 = null;
      break;
      i = -1;
      break label207;
    }
  }
  
  public final void setVideo(Number paramNumber1, Number paramNumber2)
  {
    AppMethodBeat.i(206211);
    p.k(paramNumber1, "top");
    p.k(paramNumber2, "bottom");
    Log.d(TAG, "setVideo:" + this.owd + " to " + paramNumber1 + ' ' + paramNumber2);
    this.Ptb = new float[] { paramNumber1.floatValue(), paramNumber2.floatValue() };
    AppMethodBeat.o(206211);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$Companion;", "", "()V", "TAG", "", "attachCount", "", "getAttachCount", "()I", "setAttachCount", "(I)V", "canvasStorage", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getCanvasStorage", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "canvasStorage$delegate", "Lkotlin/Lazy;", "pauseOnNoViewAttach", "", "getPauseOnNoViewAttach", "()Z", "pauseOnNoViewAttach$delegate", "videoAutoPlayOpen", "getVideoAutoPlayOpen", "videoAutoPlayOpen$delegate", "default", "", "def", "webview-sdk_release"})
  public static final class a
  {
    static int a(Number paramNumber, int paramInt)
    {
      AppMethodBeat.i(209043);
      if (p.h(paramNumber, Integer.valueOf(0)))
      {
        AppMethodBeat.o(209043);
        return paramInt;
      }
      f.a locala = com.tencent.mm.plugin.av.f.Pvm;
      paramInt = f.a.d(paramNumber);
      AppMethodBeat.o(209043);
      return paramInt;
    }
    
    public static MMKVSlotManager gPc()
    {
      AppMethodBeat.i(209042);
      Object localObject = a.gOZ();
      a locala = a.Ptp;
      localObject = (MMKVSlotManager)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(209042);
      return localObject;
    }
    
    public static boolean gPd()
    {
      AppMethodBeat.i(209045);
      kotlin.f localf = a.gPa();
      a locala = a.Ptp;
      boolean bool = ((Boolean)localf.getValue()).booleanValue();
      AppMethodBeat.o(209045);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<MMKVSlotManager>
  {
    public static final b Ptq;
    
    static
    {
      AppMethodBeat.i(213930);
      Ptq = new b();
      AppMethodBeat.o(213930);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final c Ptr;
    
    static
    {
      AppMethodBeat.i(207162);
      Ptr = new c();
      AppMethodBeat.o(207162);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final d Pts;
    
    static
    {
      AppMethodBeat.i(206458);
      Pts = new d();
      AppMethodBeat.o(206458);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$DrawInfo;", "", "width", "", "height", "fontSize", "", "isDarkMode", "", "orientation", "(IIFZI)V", "getFontSize", "()F", "getHeight", "()I", "()Z", "getOrientation", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "webview-sdk_release"})
  public static final class e
  {
    final int FO;
    final boolean cpt;
    final float fontSize;
    final int height;
    final int width;
    
    public e(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean, int paramInt3)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.fontSize = paramFloat;
      this.cpt = paramBoolean;
      this.FO = paramInt3;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206251);
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((this.width != paramObject.width) || (this.height != paramObject.height) || (Float.compare(this.fontSize, paramObject.fontSize) != 0) || (this.cpt != paramObject.cpt) || (this.FO != paramObject.FO)) {}
        }
      }
      else
      {
        AppMethodBeat.o(206251);
        return true;
      }
      AppMethodBeat.o(206251);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206248);
      String str = "DrawInfo(width=" + this.width + ", height=" + this.height + ", fontSize=" + this.fontSize + ", isDarkMode=" + this.cpt + ", orientation=" + this.FO + ")";
      AppMethodBeat.o(206248);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "", "seen1", "", "canvasId", "", "height", "width", "left", "top", "layout", "serializationConstructorMarker", "Lkotlinx/serialization/SerializationConstructorMarker;", "(ILjava/lang/String;IIIILjava/lang/String;Lkotlinx/serialization/SerializationConstructorMarker;)V", "(Ljava/lang/String;IIIILjava/lang/String;)V", "getCanvasId", "()Ljava/lang/String;", "setCanvasId", "(Ljava/lang/String;)V", "getHeight", "()I", "setHeight", "(I)V", "getLayout", "setLayout", "getLeft", "setLeft", "getTop", "setTop", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "$serializer", "Companion", "webview-sdk_release"})
  public static final class f
  {
    public static final b Ptu;
    String Ptt;
    int height;
    int left;
    private String owd;
    int top;
    int width;
    
    static
    {
      AppMethodBeat.i(205767);
      Ptu = new b((byte)0);
      AppMethodBeat.o(205767);
    }
    
    public f(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
    {
      AppMethodBeat.i(205766);
      this.owd = paramString1;
      this.height = paramInt1;
      this.width = paramInt2;
      this.left = paramInt3;
      this.top = paramInt4;
      this.Ptt = paramString2;
      AppMethodBeat.o(205766);
    }
    
    public static final void a(f paramf, b paramb, kotlinx.a.n paramn)
    {
      int j = 1;
      AppMethodBeat.i(205774);
      p.k(paramf, "self");
      p.k(paramb, "output");
      p.k(paramn, "serialDesc");
      paramb.a(paramn, paramf.owd);
      paramb.a(paramn, 1, paramf.height);
      if (paramf.width != 0)
      {
        i = 1;
        if ((i != 0) || (paramb.c(paramn))) {
          paramb.a(paramn, 2, paramf.width);
        }
        if (paramf.left == 0) {
          break label206;
        }
        i = 1;
        label93:
        if ((i != 0) || (paramb.c(paramn))) {
          paramb.a(paramn, 3, paramf.left);
        }
        if (paramf.top == 0) {
          break label211;
        }
      }
      label206:
      label211:
      for (int i = j;; i = 0)
      {
        if ((i != 0) || (paramb.c(paramn))) {
          paramb.a(paramn, 4, paramf.top);
        }
        if (((p.h(paramf.Ptt, null) ^ true)) || (paramb.c(paramn))) {
          paramb.a(paramn, (h)bf.abCk, paramf.Ptt);
        }
        AppMethodBeat.o(205774);
        return;
        i = 0;
        break;
        i = 0;
        break label93;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(205770);
      if (this != paramObject)
      {
        if ((paramObject instanceof f))
        {
          paramObject = (f)paramObject;
          if ((!p.h(this.owd, paramObject.owd)) || (this.height != paramObject.height) || (this.width != paramObject.width) || (this.left != paramObject.left) || (this.top != paramObject.top) || (!p.h(this.Ptt, paramObject.Ptt))) {}
        }
      }
      else
      {
        AppMethodBeat.o(205770);
        return true;
      }
      AppMethodBeat.o(205770);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(205769);
      String str = this.owd;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int k = this.height;
        int m = this.width;
        int n = this.left;
        int i1 = this.top;
        str = this.Ptt;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(205769);
        return ((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205768);
      String str = "LayoutCache(canvasId=" + this.owd + ", height=" + this.height + ", width=" + this.width + ", left=" + this.left + ", top=" + this.top + ", layout=" + this.Ptt + ")";
      AppMethodBeat.o(205768);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "webview-sdk_release"})
    public static final class b {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$SyncBarrierInfo;", "", "token", "", "start", "", "(IJ)V", "getStart", "()J", "getToken", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "webview-sdk_release"})
  static final class g
  {
    final int kPS;
    final long start;
    
    public g(int paramInt, long paramLong)
    {
      this.kPS = paramInt;
      this.start = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof g))
        {
          paramObject = (g)paramObject;
          if ((this.kPS != paramObject.kPS) || (this.start != paramObject.start)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      int i = this.kPS;
      long l = this.start;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(211286);
      String str = "SyncBarrierInfo(token=" + this.kPS + ", start=" + this.start + ")";
      AppMethodBeat.o(211286);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasContext$attach$2$1"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(n paramn, MutableContextWrapper paramMutableContextWrapper, a parama, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  static final class i<T>
    implements ValueCallback<String>
  {
    i(n paramn) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"restoreFromStorage", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<a.f>
  {
    j(String paramString)
    {
      super();
    }
    
    public final a.f gPg()
    {
      AppMethodBeat.i(205827);
      Object localObject1 = a.Ptp;
      localObject1 = (MultiProcessMMKV)a.a.gPc().findSlot(this.PtC);
      if (localObject1 != null)
      {
        localObject1 = ((MultiProcessMMKV)localObject1).getString(this.PtC, "");
        if (localObject1 != null)
        {
          p.j(localObject1, "it");
          int i;
          if (!kotlin.n.n.ba((CharSequence)localObject1))
          {
            i = 1;
            if (i == 0) {
              break label113;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label118;
            }
            Object localObject2 = kotlinx.a.c.a.abCB;
            localObject2 = a.f.Ptu;
            localObject2 = (kotlinx.a.f)a.f.a.Ptv;
            p.j(localObject1, "it");
            localObject1 = (a.f)kotlinx.a.c.a.a.a((kotlinx.a.f)localObject2, (String)localObject1);
            AppMethodBeat.o(205827);
            return localObject1;
            i = 0;
            break;
            label113:
            localObject1 = null;
          }
        }
      }
      label118:
      AppMethodBeat.o(205827);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/webcanvas/WebCanvasContext$postSyncBarrier$1$1"})
  static final class k
    implements Runnable
  {
    k(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(210562);
      if (this.Ptz.gOX()) {
        Log.e(a.access$getTAG$cp(), "removeSyncBarrier by delay:" + a.b(this.Ptz));
      }
      AppMethodBeat.o(210562);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(a parama, int paramInt, Number paramNumber)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.a
 * JD-Core Version:    0.7.0.1
 */