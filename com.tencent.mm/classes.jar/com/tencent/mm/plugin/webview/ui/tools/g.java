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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.MMWebView;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.reflect.Method;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper;", "", "bottomNavigator", "Landroid/view/View;", "root", "webview", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Landroid/view/View;Landroid/view/View;Lcom/tencent/mm/ui/widget/MMWebView;)V", "MIN_TRIGGER_HEIGHT", "", "bottomBarHeight", "currentShow", "", "deviceShowBottomNav", "Ljava/lang/Boolean;", "isXWeb", "startScrollTime", "", "startScrollY", "getWebview", "()Lcom/tencent/mm/ui/widget/MMWebView;", "setWebview", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "hideBottomNavigator", "", "huaweiNeedShowBottomNavigator", "miuiNeedShowBottomNavigator", "needShowBottomNavigator", "onDestroy", "onWebViewScrollChanged", "l", "t", "oldl", "oldt", "oppoNeedShowBottomNavigator", "setBottomNavigatorPos", "show", "setBottomNavigatorVisibility", "showBottom", "showBottomNavigator", "vivoNeedShowBottomNavigator", "Companion", "plugin-webview_release"})
public final class g
{
  private static final long CwP = 300L;
  public static final a CwQ;
  static final String TAG = "MicroMsg.WebViewBottomNavigatorHelper";
  long CwG;
  int CwH;
  final int CwI;
  boolean CwJ;
  Boolean CwK;
  private boolean CwL;
  private int CwM;
  final View CwN;
  private MMWebView CwO;
  private final View fvu;
  
  static
  {
    AppMethodBeat.i(82541);
    CwQ = new a((byte)0);
    TAG = "MicroMsg.WebViewBottomNavigatorHelper";
    CwP = 300L;
    AppMethodBeat.o(82541);
  }
  
  public g(View paramView1, View paramView2, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(82540);
    this.CwN = paramView1;
    this.fvu = paramView2;
    this.CwO = paramMMWebView;
    this.CwI = a.fromDPToPix(ai.getContext(), 16);
    paramView1 = this.CwO;
    if (paramView1 != null)
    {
      this.CwL = paramView1.isXWalkKernel();
      AppMethodBeat.o(82540);
      return;
    }
    AppMethodBeat.o(82540);
  }
  
  final void eDe()
  {
    AppMethodBeat.i(82538);
    if (this.CwN.getVisibility() == 0)
    {
      AppMethodBeat.o(82538);
      return;
    }
    ac.i(TAG, "showBottomNavigator");
    this.CwN.clearAnimation();
    this.CwN.animate().setDuration(CwP).translationY(0.0F).setInterpolator((TimeInterpolator)new AccelerateInterpolator(2.0F)).setListener((Animator.AnimatorListener)new c(this)).start();
    AppMethodBeat.o(82538);
  }
  
  final void eDf()
  {
    AppMethodBeat.i(82539);
    if (this.CwN.getVisibility() == 8)
    {
      AppMethodBeat.o(82539);
      return;
    }
    ac.i(TAG, "hideBottomNavigator");
    this.CwN.clearAnimation();
    this.CwN.animate().setDuration(CwP).translationY(this.CwN.getHeight()).setInterpolator((TimeInterpolator)new AccelerateInterpolator(2.0F)).setListener((Animator.AnimatorListener)new b(this)).start();
    AppMethodBeat.o(82539);
  }
  
  public final void uu(boolean paramBoolean)
  {
    AppMethodBeat.i(82537);
    this.CwJ = paramBoolean;
    if (!paramBoolean)
    {
      eDf();
      AppMethodBeat.o(82537);
      return;
    }
    eDe();
    AppMethodBeat.o(82537);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$Companion;", "", "()V", "TAG", "", "animationDuration", "", "checkDeviceHasNavigationBar", "", "context", "Landroid/content/Context;", "hasNavigationBar", "plugin-webview_release"})
  public static final class a
  {
    public static boolean ee(Context paramContext)
    {
      AppMethodBeat.i(82531);
      k.h(paramContext, "context");
      if (Build.VERSION.SDK_INT > 28) {
        try
        {
          Object localObject = Class.forName("android.view.WindowManagerGlobal").getMethod("getWindowManagerService", new Class[0]).invoke(null, new Object[0]);
          Class localClass1 = localObject.getClass();
          Class localClass2 = Integer.TYPE;
          if (localClass2 == null) {
            k.fOy();
          }
          paramContext = localClass1.getMethod("hasNavigationBar", new Class[] { localClass2 }).invoke(localObject, new Object[] { paramContext.getClass().getMethod("getDisplayId", new Class[0]).invoke(paramContext, new Object[0]) });
          if (paramContext == null)
          {
            paramContext = new v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(82531);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          ac.w(g.access$getTAG$cp(), "checkDeviceHasNavigationBar Q ex:%s", new Object[] { paramContext.getMessage() });
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
          paramContext = Class.forName("android.view.WindowManagerGlobal").getMethod("getWindowManagerService", new Class[0]).invoke(null, new Object[0]);
          paramContext = paramContext.getClass().getMethod("hasNavigationBar", new Class[0]).invoke(paramContext, new Object[0]);
          if (paramContext != null) {
            break;
          }
          paramContext = new v("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(82531);
          throw paramContext;
        }
        catch (Throwable paramContext)
        {
          ac.w(g.access$getTAG$cp(), "checkDeviceHasNavigationBar ex:%s", new Object[] { paramContext.getMessage() });
        }
      }
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(82531);
      return bool;
    }
    
    public static boolean gQ(Context paramContext)
    {
      AppMethodBeat.i(82532);
      k.h(paramContext, "context");
      paramContext = paramContext.getResources();
      int i = paramContext.getIdentifier("config_showNavigationBar", "bool", "android");
      if (i > 0) {}
      for (boolean bool1 = paramContext.getBoolean(i);; bool1 = false)
      {
        try
        {
          paramContext = Class.forName("android.os.SystemProperties");
          paramContext = paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { "qemu.hw.mainkeys" });
          if (paramContext == null)
          {
            paramContext = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(82532);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          ac.w(g.access$getTAG$cp(), "hasNavigationBar ex:%s", new Object[] { paramContext.getMessage() });
        }
        for (;;)
        {
          AppMethodBeat.o(82532);
          return bool1;
          paramContext = (String)paramContext;
          if (k.g("1", paramContext))
          {
            bool1 = false;
          }
          else
          {
            boolean bool2 = k.g("0", paramContext);
            if (bool2) {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$hideBottomNavigator$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(82534);
      g.a(this.CwR).setVisibility(8);
      AppMethodBeat.o(82534);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(82533);
      g.a(this.CwR, false);
      AppMethodBeat.o(82533);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$showBottomNavigator$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(82536);
      g.a(this.CwR, true);
      AppMethodBeat.o(82536);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(82535);
      g.a(this.CwR).setVisibility(0);
      AppMethodBeat.o(82535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */