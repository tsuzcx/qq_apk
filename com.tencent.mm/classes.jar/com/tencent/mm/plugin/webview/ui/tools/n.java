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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper;", "", "bottomNavigator", "Landroid/view/View;", "root", "webview", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Landroid/view/View;Landroid/view/View;Lcom/tencent/mm/ui/widget/MMWebView;)V", "MIN_TRIGGER_HEIGHT", "", "bottomBarHeight", "currentShow", "", "deviceShowBottomNav", "Ljava/lang/Boolean;", "deviceUseSysGesture", "getDeviceUseSysGesture", "()Z", "deviceUseSysGesture$delegate", "Lkotlin/Lazy;", "isXWeb", "startScrollTime", "", "startScrollY", "getWebview", "()Lcom/tencent/mm/ui/widget/MMWebView;", "setWebview", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "hideBottomNavigator", "", "huaweiNeedShowBottomNavigator", "miuiNeedShowBottomNavigator", "needShowBottomNavigator", "onDestroy", "onWebViewScrollChanged", "l", "t", "oldl", "oldt", "oppoNeedShowBottomNavigator", "setBottomNavigatorPos", "show", "setBottomNavigatorVisibility", "showBottom", "showBottomNavigator", "vivoNeedShowBottomNavigator", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  private static final long EHU;
  static final String TAG;
  public static final a WUw;
  int WUA;
  final int WUB;
  boolean WUC;
  Boolean WUD;
  private boolean WUE;
  private int WUF;
  private final j WUG;
  final View WUx;
  private MMWebView WUy;
  long WUz;
  private final View lBX;
  
  static
  {
    AppMethodBeat.i(82541);
    WUw = new a((byte)0);
    TAG = "MicroMsg.WebViewBottomNavigatorHelper";
    EHU = 300L;
    AppMethodBeat.o(82541);
  }
  
  public n(View paramView1, View paramView2, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(82540);
    this.WUx = paramView1;
    this.lBX = paramView2;
    this.WUy = paramMMWebView;
    this.WUB = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    paramView1 = this.WUy;
    if (paramView1 != null) {
      this.WUE = paramView1.isXWalkKernel();
    }
    this.WUG = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(82540);
  }
  
  public final void IL(boolean paramBoolean)
  {
    AppMethodBeat.i(82537);
    this.WUC = paramBoolean;
    if (!paramBoolean)
    {
      ixA();
      AppMethodBeat.o(82537);
      return;
    }
    ixz();
    AppMethodBeat.o(82537);
  }
  
  final void ixA()
  {
    AppMethodBeat.i(82539);
    if (this.WUx.getVisibility() == 8)
    {
      AppMethodBeat.o(82539);
      return;
    }
    Log.i(TAG, "hideBottomNavigator");
    this.WUx.clearAnimation();
    this.WUx.animate().setDuration(EHU).translationY(this.WUx.getHeight()).setInterpolator((TimeInterpolator)new AccelerateInterpolator(2.0F)).setListener((Animator.AnimatorListener)new c(this)).start();
    AppMethodBeat.o(82539);
  }
  
  public final boolean ixB()
  {
    AppMethodBeat.i(296126);
    boolean bool = ((Boolean)this.WUG.getValue()).booleanValue();
    AppMethodBeat.o(296126);
    return bool;
  }
  
  final void ixz()
  {
    AppMethodBeat.i(82538);
    if (this.WUx.getVisibility() == 0)
    {
      AppMethodBeat.o(82538);
      return;
    }
    Log.i(TAG, "showBottomNavigator");
    this.WUx.clearAnimation();
    this.WUx.animate().setDuration(EHU).translationY(0.0F).setInterpolator((TimeInterpolator)new AccelerateInterpolator(2.0F)).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(82538);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$Companion;", "", "()V", "TAG", "", "animationDuration", "", "checkDeviceHasNavigationBar", "", "context", "Landroid/content/Context;", "hasNavigationBar", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean fx(Context paramContext)
    {
      AppMethodBeat.i(82531);
      s.u(paramContext, "context");
      if (Build.VERSION.SDK_INT > 28) {
        try
        {
          Object localObject = Class.forName("android.view.WindowManagerGlobal").getMethod("getWindowManagerService", new Class[0]).invoke(null, new Object[0]);
          Class localClass1 = localObject.getClass();
          Class localClass2 = Integer.TYPE;
          s.checkNotNull(localClass2);
          paramContext = localClass1.getMethod("hasNavigationBar", new Class[] { localClass2 }).invoke(localObject, new Object[] { paramContext.getClass().getMethod("getDisplayId", new Class[0]).invoke(paramContext, new Object[0]) });
          if (paramContext == null)
          {
            paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(82531);
            throw paramContext;
          }
        }
        finally
        {
          Log.w(n.access$getTAG$cp(), "checkDeviceHasNavigationBar Q ex:%s", new Object[] { paramContext.getMessage() });
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
          paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(82531);
          throw paramContext;
        }
        finally
        {
          Log.w(n.access$getTAG$cp(), "checkDeviceHasNavigationBar ex:%s", new Object[] { paramContext.getMessage() });
        }
      }
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(82531);
      return bool;
    }
    
    public static boolean kT(Context paramContext)
    {
      AppMethodBeat.i(82532);
      s.u(paramContext, "context");
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
            paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(82532);
            throw paramContext;
          }
        }
        finally
        {
          Log.w(n.access$getTAG$cp(), "hasNavigationBar ex:%s", new Object[] { paramContext.getMessage() });
        }
        for (;;)
        {
          AppMethodBeat.o(82532);
          return bool1;
          paramContext = (String)paramContext;
          if (s.p("1", paramContext))
          {
            bool1 = false;
          }
          else
          {
            boolean bool2 = s.p("0", paramContext);
            if (bool2) {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    b(n paramn)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$hideBottomNavigator$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(n paramn) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(82534);
      n.a(this.WUH).setVisibility(8);
      AppMethodBeat.o(82534);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(82533);
      n.a(this.WUH, false);
      AppMethodBeat.o(82533);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$showBottomNavigator$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(n paramn) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(82536);
      n.a(this.WUH, true);
      AppMethodBeat.o(82536);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(82535);
      n.a(this.WUH).setVisibility(0);
      AppMethodBeat.o(82535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n
 * JD-Core Version:    0.7.0.1
 */