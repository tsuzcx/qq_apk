package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ListView;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.ab.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;", "canvasId", "", "needCheckDrawChanged", "", "logicJsEngineReference", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "renderJsEngineReference", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "updateHeight", "(Ljava/lang/String;ZLjava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Z)V", "barrier", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$SyncBarrierInfo;", "barrierStartTime", "", "getBarrierStartTime", "()J", "lastDraw", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$DrawInfo;", "layoutCache", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "logicJsEngine", "getLogicJsEngine$webview_sdk_release", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "getMagicBrush$webview_sdk_release", "()Lcom/tencent/magicbrush/MagicBrush;", "magicBrushView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "getMagicBrushView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "methodInQueue", "getMethodInQueue", "()Z", "onGetFontSize", "Lkotlin/Function0;", "", "getOnGetFontSize", "()Lkotlin/jvm/functions/Function0;", "setOnGetFontSize", "(Lkotlin/jvm/functions/Function0;)V", "onGetWidth", "getOnGetWidth", "setOnGetWidth", "onSetHeight", "getOnSetHeight", "setOnSetHeight", "renderJsEngine", "getRenderJsEngine$webview_sdk_release", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "videoCanAutoPlayNow", "getVideoCanAutoPlayNow", "setVideoCanAutoPlayNow", "(Z)V", "videoPos", "", "getVideoPos", "()[F", "setVideoPos", "([F)V", "view", "getView", "viewContext", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasViewContext;", "isParentPaused", "Landroid/view/View;", "(Landroid/view/View;)Z", "offsetHeight", "", "getOffsetHeight", "(Landroid/view/View;)I", "offsetTop", "getOffsetTop", "parentListView", "Landroid/view/ViewGroup;", "getParentListView", "(Landroid/view/View;)Landroid/view/ViewGroup;", "attach", "", "attach$webview_sdk_release", "canVideoAutoPlay", "checkDrawChanged", "start", "createCanvasView", "context", "Landroid/content/Context;", "createCanvasView$webview_sdk_release", "currentOrientation", "destroy", "destroy$webview_sdk_release", "getCacheKey", "getCanvas", "Lcom/eclipsesource/v8/V8Object;", "getElementId", "getFontSize", "getFps", "getHeight", "getId", "getLayoutCache", "getWidth", "isOnScreen", "postSyncBarrier", "postSyncBarrier$webview_sdk_release", "removeSyncBarrier", "removeSyncBarrier$webview_sdk_release", "restore", "save", "left", "", "top", "width", "height", "layout", "saveLastDraw", "setHeight", "setVideo", "bottom", "absoluteWidth", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "resumeLayout", "takeWhenValid", "Companion", "DrawInfo", "LayoutCache", "SyncBarrierInfo", "webview-sdk_release"})
public final class a
  implements com.tencent.mm.plugin.ab.g, j
{
  private static final kotlin.f Izh;
  private static final kotlin.f Izi;
  private static final kotlin.f Izj;
  private static int Izk = 0;
  public static final a Izl;
  static final String TAG = "MicroMsg.WebCanvasContext";
  n IyU;
  public kotlin.g.a.a<Float> IyV;
  public kotlin.g.a.a<Float> IyW;
  public kotlin.g.a.a<Boolean> IyX;
  float[] IyY;
  public boolean IyZ;
  a.g Iza;
  f Izb;
  e Izc;
  final boolean Izd;
  private final WeakReference<c> Ize;
  private final WeakReference<k> Izf;
  private final boolean Izg;
  final String lAN;
  
  static
  {
    AppMethodBeat.i(224613);
    Izl = new a((byte)0);
    TAG = "MicroMsg.WebCanvasContext";
    Izh = kotlin.g.ah((kotlin.g.a.a)a.d.Izo);
    Izi = kotlin.g.ah((kotlin.g.a.a)a.b.Izm);
    Izj = kotlin.g.ah((kotlin.g.a.a)a.c.Izn);
    AppMethodBeat.o(224613);
  }
  
  public a(String paramString, boolean paramBoolean1, WeakReference<c> paramWeakReference, WeakReference<k> paramWeakReference1, boolean paramBoolean2)
  {
    AppMethodBeat.i(224612);
    this.lAN = paramString;
    this.Izd = paramBoolean1;
    this.Ize = paramWeakReference;
    this.Izf = paramWeakReference1;
    this.Izg = paramBoolean2;
    this.IyZ = true;
    AppMethodBeat.o(224612);
  }
  
  private final f aWt(String paramString)
  {
    AppMethodBeat.i(224605);
    j localj = new j(aWu(paramString));
    Log.d(TAG, "getLayoutCache: #".concat(String.valueOf(paramString)));
    if (p.j(paramString, this.lAN))
    {
      f localf = this.Izb;
      paramString = localf;
      if (localf == null)
      {
        paramString = localj.fWx();
        if (paramString != null)
        {
          this.Izb = paramString;
          AppMethodBeat.o(224605);
          return paramString;
        }
        AppMethodBeat.o(224605);
        return null;
      }
    }
    else
    {
      paramString = localj.fWx();
    }
    AppMethodBeat.o(224605);
    return paramString;
  }
  
  private final String aWu(String paramString)
  {
    AppMethodBeat.i(224610);
    paramString = new StringBuilder().append(paramString).append('-').append(fWp()).append('-').append(getWidth()).append('-').append(getFontSize()).append('-');
    f.a locala = com.tencent.mm.plugin.ab.f.IBd;
    paramString = ao.isDarkMode();
    AppMethodBeat.o(224610);
    return paramString;
  }
  
  static boolean fWn()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  static int fWp()
  {
    AppMethodBeat.i(224611);
    Object localObject = com.tencent.mm.plugin.ab.f.IBd;
    localObject = f.a.getAppContext().getResources();
    p.g(localObject, "appContext.resources");
    int i = ((Resources)localObject).getConfiguration().orientation;
    AppMethodBeat.o(224611);
    return i;
  }
  
  private final ViewGroup gc(View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(224589);
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
    AppMethodBeat.o(224589);
    return paramView;
  }
  
  private static Integer o(Integer paramInteger)
  {
    AppMethodBeat.i(224595);
    if (paramInteger != null)
    {
      if (((Number)paramInteger).intValue() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(224595);
        return paramInteger;
      }
      AppMethodBeat.o(224595);
      return null;
    }
    AppMethodBeat.o(224595);
    return null;
  }
  
  final MagicBrushView MQ()
  {
    AppMethodBeat.i(224588);
    Object localObject = this.IyU;
    if (localObject != null)
    {
      localObject = ((n)localObject).MQ();
      AppMethodBeat.o(224588);
      return localObject;
    }
    AppMethodBeat.o(224588);
    return null;
  }
  
  public final boolean canVideoAutoPlay()
  {
    AppMethodBeat.i(224602);
    if (!((Boolean)Izh.getValue()).booleanValue())
    {
      AppMethodBeat.o(224602);
      return true;
    }
    Log.i(TAG, "canVideoAutoPlay videoCanAutoPlayNow=" + this.IyZ);
    boolean bool = this.IyZ;
    AppMethodBeat.o(224602);
    return bool;
  }
  
  final void e(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(224609);
    f localf = aWt(this.lAN);
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
        Log.i(TAG, "resume layout:#" + this.lAN + " size:[" + localLayoutParams.width + ", " + localLayoutParams.height + ']');
        paramMagicBrushView.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(224609);
        return;
        i = 0;
        break;
        label166:
        localf = null;
      }
    }
    label171:
    AppMethodBeat.o(224609);
  }
  
  public final k fWk()
  {
    AppMethodBeat.i(224586);
    Object localObject = this.Izf.get();
    if (localObject == null) {
      p.hyc();
    }
    p.g(localObject, "renderJsEngineReference.get()!!");
    localObject = (k)localObject;
    AppMethodBeat.o(224586);
    return localObject;
  }
  
  public final c fWl()
  {
    AppMethodBeat.i(224587);
    Object localObject = this.Ize.get();
    if (localObject == null) {
      p.hyc();
    }
    p.g(localObject, "logicJsEngineReference.get()!!");
    localObject = (c)localObject;
    AppMethodBeat.o(224587);
    return localObject;
  }
  
  public final void fWm()
  {
    AppMethodBeat.i(224606);
    Object localObject1 = this.Izb;
    if (localObject1 != null)
    {
      int i = ((f)localObject1).width;
      int j = ((f)localObject1).height;
      float f = getFontSize();
      Object localObject2 = com.tencent.mm.plugin.ab.f.IBd;
      this.Izc = new e(i, j, f, ao.isDarkMode(), fWp());
      localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder("saveLastDraw:[").append(((f)localObject1).width).append(", ").append(((f)localObject1).height).append(", ");
      localObject1 = this.Izc;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((e)localObject1).orientation);; localObject1 = null)
      {
        Log.d((String)localObject2, localObject1 + ']');
        AppMethodBeat.o(224606);
        return;
      }
    }
    AppMethodBeat.o(224606);
  }
  
  public final boolean fWo()
  {
    boolean bool = true;
    AppMethodBeat.i(224608);
    for (;;)
    {
      try
      {
        Object localObject1 = this.Iza;
        if (localObject1 != null)
        {
          int i = ((a.g)localObject1).token;
          if (fWn())
          {
            localObject1 = MessageQueue.class.getMethod("removeSyncBarrier", new Class[] { Integer.TYPE });
            Looper localLooper = Looper.getMainLooper();
            p.g(localLooper, "Looper.getMainLooper()");
            ((Method)localObject1).invoke(localLooper.getQueue(), new Object[] { Integer.valueOf(i) });
            Log.d(TAG, "removeSyncBarrier " + this.lAN + " token:" + i);
            this.Iza = null;
            return bool;
          }
          Looper.class.getMethod("removeSyncBarrier", new Class[] { Integer.TYPE }).invoke(Looper.getMainLooper(), new Object[] { Integer.valueOf(i) });
          continue;
        }
        bool = false;
      }
      finally
      {
        AppMethodBeat.o(224608);
      }
    }
  }
  
  public final V8Object getCanvas()
  {
    AppMethodBeat.i(224590);
    try
    {
      localObject1 = fWk();
      Object localObject3 = this.IyU;
      if (localObject3 == null) {
        p.hyc();
      }
      int i = ((n)localObject3).biJ;
      localObject3 = ((k)localObject1).bMA();
      p.g(localObject3, "v8Context");
      localObject1 = ((m)localObject3).getGlobalObject().getObject("NativeGlobal").executeObjectFunction("findElementById", ((k)localObject1).bMA().newV8Array().push(i));
      p.g(localObject1, "v8Context.globalObject.g…8Array().push(elementId))");
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
    AppMethodBeat.o(224590);
    return localObject1;
  }
  
  public final int getElementId()
  {
    AppMethodBeat.i(224591);
    n localn = this.IyU;
    if (localn == null) {
      p.hyc();
    }
    int i = localn.biJ;
    AppMethodBeat.o(224591);
    return i;
  }
  
  public final float getFontSize()
  {
    AppMethodBeat.i(224594);
    Object localObject = this.IyV;
    if (localObject != null)
    {
      localObject = (Float)((kotlin.g.a.a)localObject).invoke();
      if (localObject != null)
      {
        f = ((Float)localObject).floatValue();
        AppMethodBeat.o(224594);
        return f;
      }
    }
    localObject = com.tencent.mm.plugin.ab.f.IBd;
    float f = com.tencent.mm.cb.a.ez(MMApplicationContext.getContext());
    AppMethodBeat.o(224594);
    return f;
  }
  
  public final int getFps()
  {
    AppMethodBeat.i(224592);
    int i = (int)fWk().pqH.QP().cKu;
    AppMethodBeat.o(224592);
    return i;
  }
  
  public final int getHeight()
  {
    Object localObject2 = null;
    AppMethodBeat.i(224597);
    Object localObject1 = this.Izb;
    Object localObject3;
    int i;
    label57:
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject1 = o(Integer.valueOf(((f)localObject1).height));
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.plugin.ab.f.IBd;
        localObject1 = Integer.valueOf(f.a.d((Number)localObject1));
        if (localObject1 == null) {
          break label220;
        }
        i = ((Integer)localObject1).intValue();
        localObject3 = TAG;
        localStringBuilder = new StringBuilder("getHeight canvasId=").append(this.lAN).append(" measuredHeight = ");
        localObject1 = MQ();
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
      Integer localInteger = o((Integer)localObject1);
      localObject1 = localObject2;
      if (localInteger != null)
      {
        localObject1 = com.tencent.mm.plugin.ab.f.IBd;
        localObject1 = Integer.valueOf(f.a.d((Number)localInteger));
      }
      Log.v((String)localObject3, localObject1 + " height=" + i);
      AppMethodBeat.o(224597);
      return i;
      localObject1 = MQ();
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((MagicBrushView)localObject1).getMeasuredHeight());; localObject1 = null)
      {
        localObject1 = o((Integer)localObject1);
        if (localObject1 == null) {
          break label215;
        }
        localObject3 = com.tencent.mm.plugin.ab.f.IBd;
        localObject1 = Integer.valueOf(f.a.d((Number)localObject1));
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
    return this.lAN;
  }
  
  public final int getOffsetHeight()
  {
    AppMethodBeat.i(224599);
    Object localObject = MQ();
    if (localObject != null)
    {
      localObject = gc((View)localObject);
      if (localObject != null)
      {
        localObject = o(Integer.valueOf(((ViewGroup)localObject).getMeasuredHeight()));
        if (localObject != null)
        {
          f.a locala = com.tencent.mm.plugin.ab.f.IBd;
          int i = f.a.d((Number)localObject);
          AppMethodBeat.o(224599);
          return i;
        }
      }
      AppMethodBeat.o(224599);
      return 0;
    }
    AppMethodBeat.o(224599);
    return 0;
  }
  
  public final int getOffsetTop()
  {
    AppMethodBeat.i(224598);
    Object localObject = MQ();
    if (localObject != null)
    {
      localObject = (View)localObject;
      ViewGroup localViewGroup = gc((View)localObject);
      if (localViewGroup != null)
      {
        f.a locala = com.tencent.mm.plugin.ab.f.IBd;
        int i = f.a.d((Number)Integer.valueOf(d.cm(localObject)[1] - d.cm((View)localViewGroup)[1]));
        AppMethodBeat.o(224598);
        return i;
      }
      AppMethodBeat.o(224598);
      return 0;
    }
    AppMethodBeat.o(224598);
    return 0;
  }
  
  public final int getWidth()
  {
    Object localObject3 = null;
    AppMethodBeat.i(224596);
    Object localObject1 = this.Izb;
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
          localObject1 = MQ();
          i = j;
          if (localObject1 != null)
          {
            int k = ((MagicBrushView)localObject1).getMeasuredWidth();
            localObject1 = com.tencent.mm.plugin.ab.f.IBd;
            i = j;
            if (k == com.tencent.mm.cb.a.jo(f.a.getAppContext()))
            {
              localObject1 = com.tencent.mm.plugin.ab.f.IBd;
              i = com.tencent.mm.cb.a.jn(f.a.getAppContext());
            }
          }
        }
        localObject1 = Integer.valueOf(i);
        if (localObject1 == null) {
          break label335;
        }
        localObject1 = o((Integer)localObject1);
        if (localObject1 == null) {
          break label335;
        }
        localObject2 = com.tencent.mm.plugin.ab.f.IBd;
        localObject1 = Integer.valueOf(f.a.d((Number)localObject1));
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = MQ();
          if (localObject1 == null) {
            break label385;
          }
          localObject1 = Integer.valueOf(((MagicBrushView)localObject1).getMeasuredWidth());
          localObject1 = o((Integer)localObject1);
          if (localObject1 == null) {
            break label391;
          }
          localObject2 = com.tencent.mm.plugin.ab.f.IBd;
          localObject2 = Integer.valueOf(f.a.d((Number)localObject1));
        }
        if (localObject2 == null) {
          break label397;
        }
        i = ((Integer)localObject2).intValue();
        localObject2 = TAG;
        localStringBuilder = new StringBuilder("getWidth canvasId=").append(this.lAN).append(" measuredWidth = ");
        localObject1 = MQ();
        if (localObject1 == null) {
          break label482;
        }
      }
    }
    label335:
    label482:
    for (localObject1 = Integer.valueOf(((MagicBrushView)localObject1).getMeasuredWidth());; localObject1 = null)
    {
      Integer localInteger = o((Integer)localObject1);
      localObject1 = localObject3;
      if (localInteger != null)
      {
        localObject1 = com.tencent.mm.plugin.ab.f.IBd;
        localObject1 = Integer.valueOf(f.a.d((Number)localInteger));
      }
      Log.v((String)localObject2, localObject1 + " width=" + i);
      AppMethodBeat.o(224596);
      return i;
      localObject1 = null;
      break;
      localObject1 = this.IyW;
      if (localObject1 != null)
      {
        localObject1 = (Float)((kotlin.g.a.a)localObject1).invoke();
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(kotlin.h.a.cR(((Float)localObject1).floatValue()));
          break label140;
        }
      }
      localObject1 = null;
      break label140;
      localObject1 = null;
      break label170;
      localObject2 = null;
      break label200;
      localObject1 = com.tencent.mm.plugin.ab.f.IBd;
      localObject1 = com.tencent.mm.plugin.ab.f.IBd;
      localObject1 = f.a.getAppContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(224596);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.g(localObject1, "(appContext.getSystemSer…owManager).defaultDisplay");
      i = f.a.d((Number)Integer.valueOf(((Display)localObject1).getWidth()));
      break label211;
    }
  }
  
  public final boolean isOnScreen()
  {
    AppMethodBeat.i(224593);
    Object localObject1 = this.IyU;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((n)localObject1).MQ();
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
        AppMethodBeat.o(224593);
        return true;
      }
      AppMethodBeat.o(224593);
      return false;
      AppMethodBeat.o(224593);
      return false;
    }
  }
  
  public final String restore(String paramString)
  {
    AppMethodBeat.i(224604);
    p.h(paramString, "canvasId");
    paramString = aWt(paramString);
    if (paramString != null)
    {
      paramString = paramString.Izp;
      AppMethodBeat.o(224604);
      return paramString;
    }
    AppMethodBeat.o(224604);
    return null;
  }
  
  public final void save(String paramString1, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, String paramString2)
  {
    AppMethodBeat.i(224603);
    p.h(paramString1, "canvasId");
    p.h(paramNumber1, "left");
    p.h(paramNumber2, "top");
    p.h(paramNumber3, "width");
    p.h(paramNumber4, "height");
    p.h(paramString2, "layout");
    Log.i(TAG, "saveLayout:#" + paramString1 + " location:[" + paramNumber1 + ", " + paramNumber2 + "], size:[" + paramNumber3 + ", " + paramNumber4 + ']');
    if ((p.j(paramNumber3, Integer.valueOf(0))) && (p.j(paramNumber4, Integer.valueOf(0))))
    {
      Log.e(TAG, "saveLayout:#" + paramString1 + " invalid params");
      AppMethodBeat.o(224603);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)a.fWt().getSlot();
    String str = aWu(paramString1);
    Object localObject = kotlinx.a.c.a.TZl;
    localObject = f.Izq;
    localObject = (v)a.f.a.Izr;
    paramNumber1 = new f(paramString1, a.a(paramNumber4, -2), a.a(paramNumber3, -1), paramNumber1.intValue(), paramNumber2.intValue(), paramString2);
    if (p.j(paramString1, this.lAN))
    {
      setHeight(paramNumber4);
      this.Izb = paramNumber1;
    }
    p.h(localObject, "serializer");
    paramNumber2 = kotlinx.a.c.a.hON();
    p.h(localObject, "serializer");
    paramString1 = new StringBuilder();
    paramNumber2 = (kotlinx.a.g)new kotlinx.a.c.a.n(paramString1, paramNumber2, r.Uaz, new u[r.values().length]);
    p.h(paramNumber2, "$this$encode");
    p.h(localObject, "strategy");
    paramNumber2.a((v)localObject, paramNumber1);
    paramString1 = paramString1.toString();
    p.g(paramString1, "result.toString()");
    localMultiProcessMMKV.putString(str, paramString1);
    AppMethodBeat.o(224603);
  }
  
  public final void setHeight(final Number paramNumber)
  {
    Object localObject2 = null;
    int k = -1;
    AppMethodBeat.i(224600);
    p.h(paramNumber, "height");
    if ((!this.Izg) || (p.j(paramNumber, Integer.valueOf(0))))
    {
      AppMethodBeat.o(224600);
      return;
    }
    Object localObject1 = this.IyX;
    if (localObject1 != null) {
      ((kotlin.g.a.a)localObject1).invoke();
    }
    localObject1 = com.tencent.mm.plugin.ab.f.IBd;
    final int m = f.a.c(paramNumber);
    String str = TAG;
    Object localObject3 = new StringBuilder("#setHeight# pixelHeight=").append(m).append(", cacheHeight=");
    localObject1 = this.Izb;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((f)localObject1).height);
      Log.d(str, localObject1 + " canvasId=#" + this.lAN + ' ' + hashCode());
      localObject1 = this.Izb;
      if ((localObject1 == null) || (m != ((f)localObject1).height))
      {
        str = this.lAN;
        localObject1 = this.Izb;
        if (localObject1 == null) {
          break label362;
        }
        i = ((f)localObject1).width;
        label207:
        localObject1 = this.Izb;
        if (localObject1 == null) {
          break label367;
        }
      }
    }
    label362:
    label367:
    for (int j = ((f)localObject1).left;; j = -1)
    {
      localObject1 = this.Izb;
      if (localObject1 != null) {
        k = ((f)localObject1).top;
      }
      localObject3 = this.Izb;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((f)localObject3).Izp;
      }
      this.Izb = new f(str, m, i, j, k, (String)localObject1);
      fWk().aWB(this.lAN);
      d.h((kotlin.g.a.a)new l(this, m, paramNumber));
      Log.i(TAG, "setHeight:#" + this.lAN + ", " + paramNumber);
      AppMethodBeat.o(224600);
      return;
      localObject1 = null;
      break;
      i = -1;
      break label207;
    }
  }
  
  public final void setVideo(Number paramNumber1, Number paramNumber2)
  {
    AppMethodBeat.i(224601);
    p.h(paramNumber1, "top");
    p.h(paramNumber2, "bottom");
    Log.d(TAG, "setVideo:" + this.lAN + " to " + paramNumber1 + ' ' + paramNumber2);
    this.IyY = new float[] { paramNumber1.floatValue(), paramNumber2.floatValue() };
    AppMethodBeat.o(224601);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$Companion;", "", "()V", "TAG", "", "attachCount", "", "getAttachCount", "()I", "setAttachCount", "(I)V", "canvasStorage", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getCanvasStorage", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "canvasStorage$delegate", "Lkotlin/Lazy;", "pauseOnNoViewAttach", "", "getPauseOnNoViewAttach", "()Z", "pauseOnNoViewAttach$delegate", "videoAutoPlayOpen", "getVideoAutoPlayOpen", "videoAutoPlayOpen$delegate", "default", "", "def", "webview-sdk_release"})
  public static final class a
  {
    static int a(Number paramNumber, int paramInt)
    {
      AppMethodBeat.i(224561);
      if (p.j(paramNumber, Integer.valueOf(0)))
      {
        AppMethodBeat.o(224561);
        return paramInt;
      }
      f.a locala = com.tencent.mm.plugin.ab.f.IBd;
      paramInt = f.a.c(paramNumber);
      AppMethodBeat.o(224561);
      return paramInt;
    }
    
    public static MMKVSlotManager fWt()
    {
      AppMethodBeat.i(224560);
      Object localObject = a.fWq();
      a locala = a.Izl;
      localObject = (MMKVSlotManager)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(224560);
      return localObject;
    }
    
    public static boolean fWu()
    {
      AppMethodBeat.i(224562);
      kotlin.f localf = a.fWr();
      a locala = a.Izl;
      boolean bool = ((Boolean)localf.getValue()).booleanValue();
      AppMethodBeat.o(224562);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$DrawInfo;", "", "width", "", "height", "fontSize", "", "isDarkMode", "", "orientation", "(IIFZI)V", "getFontSize", "()F", "getHeight", "()I", "()Z", "getOrientation", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "webview-sdk_release"})
  public static final class e
  {
    final boolean crv;
    final float fontSize;
    final int height;
    final int orientation;
    final int width;
    
    public e(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean, int paramInt3)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.fontSize = paramFloat;
      this.crv = paramBoolean;
      this.orientation = paramInt3;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(224565);
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((this.width != paramObject.width) || (this.height != paramObject.height) || (Float.compare(this.fontSize, paramObject.fontSize) != 0) || (this.crv != paramObject.crv) || (this.orientation != paramObject.orientation)) {}
        }
      }
      else
      {
        AppMethodBeat.o(224565);
        return true;
      }
      AppMethodBeat.o(224565);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(224563);
      String str = "DrawInfo(width=" + this.width + ", height=" + this.height + ", fontSize=" + this.fontSize + ", isDarkMode=" + this.crv + ", orientation=" + this.orientation + ")";
      AppMethodBeat.o(224563);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "", "seen1", "", "canvasId", "", "height", "width", "left", "top", "layout", "serializationConstructorMarker", "Lkotlinx/serialization/SerializationConstructorMarker;", "(ILjava/lang/String;IIIILjava/lang/String;Lkotlinx/serialization/SerializationConstructorMarker;)V", "(Ljava/lang/String;IIIILjava/lang/String;)V", "getCanvasId", "()Ljava/lang/String;", "setCanvasId", "(Ljava/lang/String;)V", "getHeight", "()I", "setHeight", "(I)V", "getLayout", "setLayout", "getLeft", "setLeft", "getTop", "setTop", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "$serializer", "Companion", "webview-sdk_release"})
  public static final class f
  {
    public static final a.f.b Izq;
    String Izp;
    int height;
    private String lAN;
    int left;
    int top;
    int width;
    
    static
    {
      AppMethodBeat.i(224572);
      Izq = new a.f.b((byte)0);
      AppMethodBeat.o(224572);
    }
    
    public f(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
    {
      AppMethodBeat.i(224571);
      this.lAN = paramString1;
      this.height = paramInt1;
      this.width = paramInt2;
      this.left = paramInt3;
      this.top = paramInt4;
      this.Izp = paramString2;
      AppMethodBeat.o(224571);
    }
    
    public static final void a(f paramf, b paramb, kotlinx.a.n paramn)
    {
      int j = 1;
      AppMethodBeat.i(224577);
      p.h(paramf, "self");
      p.h(paramb, "output");
      p.h(paramn, "serialDesc");
      paramb.a(paramn, paramf.lAN);
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
        if (((p.j(paramf.Izp, null) ^ true)) || (paramb.c(paramn))) {
          paramb.a(paramn, (h)bf.TYV, paramf.Izp);
        }
        AppMethodBeat.o(224577);
        return;
        i = 0;
        break;
        i = 0;
        break label93;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(224575);
      if (this != paramObject)
      {
        if ((paramObject instanceof f))
        {
          paramObject = (f)paramObject;
          if ((!p.j(this.lAN, paramObject.lAN)) || (this.height != paramObject.height) || (this.width != paramObject.width) || (this.left != paramObject.left) || (this.top != paramObject.top) || (!p.j(this.Izp, paramObject.Izp))) {}
        }
      }
      else
      {
        AppMethodBeat.o(224575);
        return true;
      }
      AppMethodBeat.o(224575);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(224574);
      String str = this.lAN;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int k = this.height;
        int m = this.width;
        int n = this.left;
        int i1 = this.top;
        str = this.Izp;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(224574);
        return ((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(224573);
      String str = "LayoutCache(canvasId=" + this.lAN + ", height=" + this.height + ", width=" + this.width + ", left=" + this.left + ", top=" + this.top + ", layout=" + this.Izp + ")";
      AppMethodBeat.o(224573);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"restoreFromStorage", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<a.f>
  {
    j(String paramString)
    {
      super();
    }
    
    public final a.f fWx()
    {
      AppMethodBeat.i(224583);
      Object localObject1 = a.Izl;
      localObject1 = (MultiProcessMMKV)a.a.fWt().findSlot(this.Izy);
      if (localObject1 != null)
      {
        localObject1 = ((MultiProcessMMKV)localObject1).getString(this.Izy, "");
        if (localObject1 != null)
        {
          p.g(localObject1, "it");
          int i;
          if (!kotlin.n.n.aL((CharSequence)localObject1))
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
            Object localObject2 = kotlinx.a.c.a.TZl;
            localObject2 = a.f.Izq;
            localObject2 = (kotlinx.a.f)a.f.a.Izr;
            p.g(localObject1, "it");
            localObject1 = (a.f)kotlinx.a.c.a.a.a((kotlinx.a.f)localObject2, (String)localObject1);
            AppMethodBeat.o(224583);
            return localObject1;
            i = 0;
            break;
            label113:
            localObject1 = null;
          }
        }
      }
      label118:
      AppMethodBeat.o(224583);
      return null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/webcanvas/WebCanvasContext$postSyncBarrier$1$1"})
  static final class k
    implements Runnable
  {
    k(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(224584);
      if (this.Izv.fWo()) {
        Log.e(a.access$getTAG$cp(), "removeSyncBarrier by delay:" + a.b(this.Izv));
      }
      AppMethodBeat.o(224584);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.a
 * JD-Core Version:    0.7.0.1
 */