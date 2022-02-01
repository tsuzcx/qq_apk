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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper;", "", "bottomNavigator", "Landroid/view/View;", "root", "webview", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Landroid/view/View;Landroid/view/View;Lcom/tencent/mm/ui/widget/MMWebView;)V", "MIN_TRIGGER_HEIGHT", "", "bottomBarHeight", "currentShow", "", "deviceShowBottomNav", "Ljava/lang/Boolean;", "isXWeb", "startScrollTime", "", "startScrollY", "getWebview", "()Lcom/tencent/mm/ui/widget/MMWebView;", "setWebview", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "hideBottomNavigator", "", "huaweiNeedShowBottomNavigator", "miuiNeedShowBottomNavigator", "needShowBottomNavigator", "onDestroy", "onWebViewScrollChanged", "l", "t", "oldl", "oldt", "oppoNeedShowBottomNavigator", "setBottomNavigatorPos", "show", "setBottomNavigatorVisibility", "showBottom", "showBottomNavigator", "vivoNeedShowBottomNavigator", "Companion", "plugin-webview_release"})
public final class h
{
  private static final long CUo = 300L;
  public static final a JfI;
  static final String TAG = "MicroMsg.WebViewBottomNavigatorHelper";
  int JfA;
  final int JfB;
  boolean JfC;
  Boolean JfD;
  private boolean JfE;
  private int JfF;
  final View JfG;
  private MMWebView JfH;
  long Jfz;
  private final View gvQ;
  
  static
  {
    AppMethodBeat.i(82541);
    JfI = new a((byte)0);
    TAG = "MicroMsg.WebViewBottomNavigatorHelper";
    CUo = 300L;
    AppMethodBeat.o(82541);
  }
  
  public h(View paramView1, View paramView2, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(82540);
    this.JfG = paramView1;
    this.gvQ = paramView2;
    this.JfH = paramMMWebView;
    this.JfB = a.fromDPToPix(MMApplicationContext.getContext(), 16);
    paramView1 = this.JfH;
    if (paramView1 != null)
    {
      this.JfE = paramView1.isXWalkKernel();
      AppMethodBeat.o(82540);
      return;
    }
    AppMethodBeat.o(82540);
  }
  
  final void geB()
  {
    AppMethodBeat.i(82538);
    if (this.JfG.getVisibility() == 0)
    {
      AppMethodBeat.o(82538);
      return;
    }
    Log.i(TAG, "showBottomNavigator");
    this.JfG.clearAnimation();
    this.JfG.animate().setDuration(CUo).translationY(0.0F).setInterpolator((TimeInterpolator)new AccelerateInterpolator(2.0F)).setListener((Animator.AnimatorListener)new c(this)).start();
    AppMethodBeat.o(82538);
  }
  
  final void geC()
  {
    AppMethodBeat.i(82539);
    if (this.JfG.getVisibility() == 8)
    {
      AppMethodBeat.o(82539);
      return;
    }
    Log.i(TAG, "hideBottomNavigator");
    this.JfG.clearAnimation();
    this.JfG.animate().setDuration(CUo).translationY(this.JfG.getHeight()).setInterpolator((TimeInterpolator)new AccelerateInterpolator(2.0F)).setListener((Animator.AnimatorListener)new b(this)).start();
    AppMethodBeat.o(82539);
  }
  
  public final void zi(boolean paramBoolean)
  {
    AppMethodBeat.i(82537);
    this.JfC = paramBoolean;
    if (!paramBoolean)
    {
      geC();
      AppMethodBeat.o(82537);
      return;
    }
    geB();
    AppMethodBeat.o(82537);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$Companion;", "", "()V", "TAG", "", "animationDuration", "", "checkDeviceHasNavigationBar", "", "context", "Landroid/content/Context;", "hasNavigationBar", "plugin-webview_release"})
  public static final class a
  {
    public static boolean eB(Context paramContext)
    {
      AppMethodBeat.i(82531);
      p.h(paramContext, "context");
      Object localObject1;
      if (Build.VERSION.SDK_INT > 28) {
        try
        {
          localObject1 = Class.forName("android.view.WindowManagerGlobal");
          p.g(localObject1, "Class.forName(\"android.view.WindowManagerGlobal\")");
          localObject1 = ((Class)localObject1).getMethod("getWindowManagerService", new Class[0]);
          p.g(localObject1, "clazz.getMethod(\"getWindowManagerService\")");
          localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
          Object localObject2 = localObject1.getClass();
          Object localObject3 = Integer.TYPE;
          if (localObject3 == null) {
            p.hyc();
          }
          localObject2 = ((Class)localObject2).getMethod("hasNavigationBar", new Class[] { localObject3 });
          p.g(localObject2, "windowManagerClazz.getMe…lass.javaPrimitiveType!!)");
          localObject3 = paramContext.getClass().getMethod("getDisplayId", new Class[0]);
          p.g(localObject3, "contextClazz.getMethod(\"getDisplayId\")");
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
          Log.w(h.access$getTAG$cp(), "checkDeviceHasNavigationBar Q ex:%s", new Object[] { paramContext.getMessage() });
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
          p.g(paramContext, "Class.forName(\"android.view.WindowManagerGlobal\")");
          paramContext = paramContext.getMethod("getWindowManagerService", new Class[0]);
          p.g(paramContext, "clazz.getMethod(\"getWindowManagerService\")");
          paramContext = paramContext.invoke(null, new Object[0]);
          localObject1 = paramContext.getClass().getMethod("hasNavigationBar", new Class[0]);
          p.g(localObject1, "windowManagerClazz.getMethod(\"hasNavigationBar\")");
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
          Log.w(h.access$getTAG$cp(), "checkDeviceHasNavigationBar ex:%s", new Object[] { paramContext.getMessage() });
        }
      }
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(82531);
      return bool;
    }
    
    public static boolean hW(Context paramContext)
    {
      AppMethodBeat.i(82532);
      p.h(paramContext, "context");
      paramContext = paramContext.getResources();
      int i = paramContext.getIdentifier("config_showNavigationBar", "bool", "android");
      if (i > 0) {}
      for (boolean bool1 = paramContext.getBoolean(i);; bool1 = false)
      {
        try
        {
          paramContext = Class.forName("android.os.SystemProperties");
          p.g(paramContext, "Class.forName(\"android.os.SystemProperties\")");
          Method localMethod = paramContext.getMethod("get", new Class[] { String.class });
          p.g(localMethod, "systemPropertiesClass.ge…get\", String::class.java)");
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
          Log.w(h.access$getTAG$cp(), "hasNavigationBar ex:%s", new Object[] { paramContext.getMessage() });
        }
        for (;;)
        {
          AppMethodBeat.o(82532);
          return bool1;
          paramContext = (String)paramContext;
          if (p.j("1", paramContext))
          {
            bool1 = false;
          }
          else
          {
            boolean bool2 = p.j("0", paramContext);
            if (bool2) {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$hideBottomNavigator$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(82534);
      h.a(this.JfJ).setVisibility(8);
      AppMethodBeat.o(82534);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(82533);
      h.a(this.JfJ, false);
      AppMethodBeat.o(82533);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$showBottomNavigator$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(82536);
      h.a(this.JfJ, true);
      AppMethodBeat.o(82536);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(82535);
      h.a(this.JfJ).setVisibility(0);
      AppMethodBeat.o(82535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */