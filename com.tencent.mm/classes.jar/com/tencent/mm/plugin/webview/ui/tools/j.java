package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.reflect.Method;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper;", "", "bottomNavigator", "Landroid/view/View;", "root", "webview", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Landroid/view/View;Landroid/view/View;Lcom/tencent/mm/ui/widget/MMWebView;)V", "MIN_TRIGGER_HEIGHT", "", "bottomBarHeight", "currentShow", "", "deviceShowBottomNav", "Ljava/lang/Boolean;", "deviceUseSysGesture", "getDeviceUseSysGesture", "()Z", "deviceUseSysGesture$delegate", "Lkotlin/Lazy;", "isXWeb", "startScrollTime", "", "startScrollY", "getWebview", "()Lcom/tencent/mm/ui/widget/MMWebView;", "setWebview", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "hideBottomNavigator", "", "huaweiNeedShowBottomNavigator", "miuiNeedShowBottomNavigator", "needShowBottomNavigator", "onDestroy", "onWebViewScrollChanged", "l", "t", "oldl", "oldt", "oppoNeedShowBottomNavigator", "setBottomNavigatorPos", "show", "setBottomNavigatorVisibility", "showBottom", "showBottomNavigator", "vivoNeedShowBottomNavigator", "Companion", "plugin-webview_release"})
public final class j
{
  private static final long IZJ = 300L;
  public static final a QcU;
  static final String TAG = "MicroMsg.WebViewBottomNavigatorHelper";
  long QcK;
  int QcL;
  final int QcM;
  boolean QcN;
  Boolean QcO;
  private boolean QcP;
  private int QcQ;
  private final f QcR;
  final View QcS;
  private MMWebView QcT;
  private final View jac;
  
  static
  {
    AppMethodBeat.i(82541);
    QcU = new a((byte)0);
    TAG = "MicroMsg.WebViewBottomNavigatorHelper";
    IZJ = 300L;
    AppMethodBeat.o(82541);
  }
  
  public j(View paramView1, View paramView2, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(82540);
    this.QcS = paramView1;
    this.jac = paramView2;
    this.QcT = paramMMWebView;
    this.QcM = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    paramView1 = this.QcT;
    if (paramView1 != null) {
      this.QcP = paramView1.isXWalkKernel();
    }
    this.QcR = g.ar((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(82540);
  }
  
  public final void Dd(boolean paramBoolean)
  {
    AppMethodBeat.i(82537);
    this.QcN = paramBoolean;
    if (!paramBoolean)
    {
      gXD();
      AppMethodBeat.o(82537);
      return;
    }
    gXC();
    AppMethodBeat.o(82537);
  }
  
  final void gXC()
  {
    AppMethodBeat.i(82538);
    if (this.QcS.getVisibility() == 0)
    {
      AppMethodBeat.o(82538);
      return;
    }
    Log.i(TAG, "showBottomNavigator");
    this.QcS.clearAnimation();
    this.QcS.animate().setDuration(IZJ).translationY(0.0F).setInterpolator((TimeInterpolator)new AccelerateInterpolator(2.0F)).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(82538);
  }
  
  final void gXD()
  {
    AppMethodBeat.i(82539);
    if (this.QcS.getVisibility() == 8)
    {
      AppMethodBeat.o(82539);
      return;
    }
    Log.i(TAG, "hideBottomNavigator");
    this.QcS.clearAnimation();
    this.QcS.animate().setDuration(IZJ).translationY(this.QcS.getHeight()).setInterpolator((TimeInterpolator)new AccelerateInterpolator(2.0F)).setListener((Animator.AnimatorListener)new c(this)).start();
    AppMethodBeat.o(82539);
  }
  
  public final boolean gXE()
  {
    AppMethodBeat.i(217815);
    boolean bool = ((Boolean)this.QcR.getValue()).booleanValue();
    AppMethodBeat.o(217815);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$Companion;", "", "()V", "TAG", "", "animationDuration", "", "checkDeviceHasNavigationBar", "", "context", "Landroid/content/Context;", "hasNavigationBar", "plugin-webview_release"})
  public static final class a
  {
    public static boolean aw(Context paramContext)
    {
      AppMethodBeat.i(82532);
      p.k(paramContext, "context");
      paramContext = paramContext.getResources();
      int i = paramContext.getIdentifier("config_showNavigationBar", "bool", "android");
      if (i > 0) {}
      for (boolean bool1 = paramContext.getBoolean(i);; bool1 = false)
      {
        try
        {
          paramContext = Class.forName("android.os.SystemProperties");
          p.j(paramContext, "Class.forName(\"android.os.SystemProperties\")");
          Method localMethod = paramContext.getMethod("get", new Class[] { String.class });
          p.j(localMethod, "systemPropertiesClass.ge…get\", String::class.java)");
          paramContext = localMethod.invoke(paramContext, new Object[] { "qemu.hw.mainkeys" });
          if (paramContext == null)
          {
            paramContext = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(82532);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          Log.w(j.access$getTAG$cp(), "hasNavigationBar ex:%s", new Object[] { paramContext.getMessage() });
        }
        for (;;)
        {
          AppMethodBeat.o(82532);
          return bool1;
          paramContext = (String)paramContext;
          if (p.h("1", paramContext))
          {
            bool1 = false;
          }
          else
          {
            boolean bool2 = p.h("0", paramContext);
            if (bool2) {
              bool1 = true;
            }
          }
        }
      }
    }
    
    public static boolean eB(Context paramContext)
    {
      AppMethodBeat.i(82531);
      p.k(paramContext, "context");
      Object localObject1;
      if (Build.VERSION.SDK_INT > 28) {
        try
        {
          localObject1 = Class.forName("android.view.WindowManagerGlobal");
          p.j(localObject1, "Class.forName(\"android.view.WindowManagerGlobal\")");
          localObject1 = ((Class)localObject1).getMethod("getWindowManagerService", new Class[0]);
          p.j(localObject1, "clazz.getMethod(\"getWindowManagerService\")");
          localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
          Object localObject2 = localObject1.getClass();
          Object localObject3 = Integer.TYPE;
          if (localObject3 == null) {
            p.iCn();
          }
          localObject2 = ((Class)localObject2).getMethod("hasNavigationBar", new Class[] { localObject3 });
          p.j(localObject2, "windowManagerClazz.getMe…lass.javaPrimitiveType!!)");
          localObject3 = paramContext.getClass().getMethod("getDisplayId", new Class[0]);
          p.j(localObject3, "contextClazz.getMethod(\"getDisplayId\")");
          paramContext = ((Method)localObject2).invoke(localObject1, new Object[] { ((Method)localObject3).invoke(paramContext, new Object[0]) });
          if (paramContext == null)
          {
            paramContext = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(82531);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          Log.w(j.access$getTAG$cp(), "checkDeviceHasNavigationBar Q ex:%s", new Object[] { paramContext.getMessage() });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(82531);
        return false;
        bool = ((Boolean)paramContext).booleanValue();
        AppMethodBeat.o(82531);
        return bool;
        try
        {
          paramContext = Class.forName("android.view.WindowManagerGlobal");
          p.j(paramContext, "Class.forName(\"android.view.WindowManagerGlobal\")");
          paramContext = paramContext.getMethod("getWindowManagerService", new Class[0]);
          p.j(paramContext, "clazz.getMethod(\"getWindowManagerService\")");
          paramContext = paramContext.invoke(null, new Object[0]);
          localObject1 = paramContext.getClass().getMethod("hasNavigationBar", new Class[0]);
          p.j(localObject1, "windowManagerClazz.getMethod(\"hasNavigationBar\")");
          paramContext = ((Method)localObject1).invoke(paramContext, new Object[0]);
          if (paramContext != null) {
            break;
          }
          paramContext = new t("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(82531);
          throw paramContext;
        }
        catch (Throwable paramContext)
        {
          Log.w(j.access$getTAG$cp(), "checkDeviceHasNavigationBar ex:%s", new Object[] { paramContext.getMessage() });
        }
      }
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(82531);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    b(j paramj)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$hideBottomNavigator$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(82534);
      j.a(this.QcV).setVisibility(8);
      AppMethodBeat.o(82534);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(82533);
      j.a(this.QcV, false);
      AppMethodBeat.o(82533);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$showBottomNavigator$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(82536);
      j.a(this.QcV, true);
      AppMethodBeat.o(82536);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(82535);
      j.a(this.QcV).setVisibility(0);
      AppMethodBeat.o(82535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */