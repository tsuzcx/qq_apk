package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.a.a.a;
import com.tencent.mm.plugin.multitask.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "page", "Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;", "(Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "indicatorBottomMargin", "", "getIndicatorBottomMargin", "()I", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "isSupportSwipeToMultiTask", "", "()Z", "mIntent", "mPage", "maskView", "getMaskView", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "convertToTranslucent", "", "translucentCallback", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "finish", "withAnimation", "helper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setSwipeBackEnable", "enable", "setSwipeBackListener", "listener", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "useActivityEnv", "Companion", "plugin-webview_release"})
public final class u
  extends com.tencent.mm.plugin.multitask.a.b
{
  public static final u.a IVf;
  private static final String TAG = "MicroMsg.LuggageWebViewMultiTaskPageAdapter";
  private final g ISU;
  private Activity activity;
  private final Intent mIntent;
  
  static
  {
    AppMethodBeat.i(210334);
    IVf = new u.a((byte)0);
    TAG = "MicroMsg.LuggageWebViewMultiTaskPageAdapter";
    AppMethodBeat.o(210334);
  }
  
  public u(g paramg)
  {
    super((Activity)localContext);
    AppMethodBeat.i(210333);
    this.ISU = paramg;
    this.mIntent = new Intent();
    this.mIntent.putExtras(this.ISU.getParams());
    paramg = this.ISU.getContext();
    if (paramg == null)
    {
      paramg = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(210333);
      throw paramg;
    }
    this.activity = ((Activity)paramg);
    AppMethodBeat.o(210333);
  }
  
  private final boolean gbx()
  {
    AppMethodBeat.i(210332);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder("useActivityEnv: ");
    j localj = this.ISU.Lg();
    p.g(localj, "mPage.containerCtrl");
    Log.i((String)localObject, localj.Lx().size());
    localObject = this.ISU.Lg();
    p.g(localObject, "mPage.containerCtrl");
    if (((j)localObject).Lx().size() <= 1)
    {
      AppMethodBeat.o(210332);
      return true;
    }
    AppMethodBeat.o(210332);
    return false;
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(210329);
    this.zZF = parama;
    if (gbx())
    {
      if ((this.activity instanceof MMActivity))
      {
        parama = this.activity;
        if (parama == null)
        {
          parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(210329);
          throw parama;
        }
        if (((MMActivity)parama).getSwipeBackLayout() != null)
        {
          parama = this.activity;
          if (parama == null)
          {
            parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(210329);
            throw parama;
          }
          ((MMActivity)parama).getSwipeBackLayout().setSwipeBackListener(this.zZE);
          AppMethodBeat.o(210329);
        }
      }
    }
    else
    {
      View localView = this.ISU.getContentView();
      if (localView == null)
      {
        parama = new t("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
        AppMethodBeat.o(210329);
        throw parama;
      }
      ((me.imid.swipebacklayout.lib.SwipeBackLayout)localView).a((SwipeBackLayout.a)new b(parama));
    }
    AppMethodBeat.o(210329);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(210330);
    if (gbx())
    {
      super.a(paramb);
      AppMethodBeat.o(210330);
      return;
    }
    if (paramb != null)
    {
      paramb.ei(true);
      AppMethodBeat.o(210330);
      return;
    }
    AppMethodBeat.o(210330);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.multitask.b.b paramb)
  {
    AppMethodBeat.i(210331);
    p.h(paramb, "helper");
    paramb = this.ISU.Lg();
    p.g(paramb, "mPage.containerCtrl");
    if (!paramb.Ly().bR(false))
    {
      if (paramBoolean)
      {
        paramb = this.activity;
        if (paramb != null)
        {
          paramb = paramb.getIntent();
          if (paramb != null) {
            paramb.putExtra("MMActivity.OverrideExitAnimation", 2130772124);
          }
        }
        paramb = this.activity;
        if (paramb != null)
        {
          paramb = paramb.getIntent();
          if (paramb != null) {
            paramb.putExtra("MMActivity.OverrideEnterAnimation", 2130771986);
          }
        }
      }
      for (;;)
      {
        paramb = this.activity;
        if (paramb == null) {
          break;
        }
        paramb.finish();
        AppMethodBeat.o(210331);
        return;
        paramb = this.activity;
        if (paramb != null)
        {
          paramb = paramb.getIntent();
          if (paramb != null) {
            paramb.putExtra("MMActivity.OverrideExitAnimation", 0);
          }
        }
        paramb = this.activity;
        if (paramb != null)
        {
          paramb = paramb.getIntent();
          if (paramb != null) {
            paramb.putExtra("MMActivity.OverrideEnterAnimation", 0);
          }
        }
      }
    }
    AppMethodBeat.o(210331);
  }
  
  public final boolean bPp()
  {
    AppMethodBeat.i(210327);
    if (getContentView() != null)
    {
      AppMethodBeat.o(210327);
      return true;
    }
    AppMethodBeat.o(210327);
    return false;
  }
  
  public final ViewGroup chG()
  {
    AppMethodBeat.i(210324);
    if (gbx())
    {
      localObject = this.activity;
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getWindow();
        if (localObject == null) {}
      }
      for (localObject = ((Window)localObject).getDecorView(); localObject == null; localObject = null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(210324);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup)localObject;
      AppMethodBeat.o(210324);
      return localObject;
    }
    Object localObject = this.ISU.getContentView();
    p.g(localObject, "mPage.contentView");
    localObject = ((View)localObject).getParent();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(210324);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup)localObject;
    AppMethodBeat.o(210324);
    return localObject;
  }
  
  public final int chH()
  {
    AppMethodBeat.i(210328);
    if (gbx())
    {
      AppMethodBeat.o(210328);
      return -1;
    }
    AppMethodBeat.o(210328);
    return 0;
  }
  
  public final Activity getActivity()
  {
    return this.activity;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(210325);
    if (gbx())
    {
      localObject = this.activity;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(210325);
        throw ((Throwable)localObject);
      }
      localObject = (View)((MMActivity)localObject).getSwipeBackLayout();
      AppMethodBeat.o(210325);
      return localObject;
    }
    Object localObject = this.ISU.getContentView();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
      AppMethodBeat.o(210325);
      throw ((Throwable)localObject);
    }
    localObject = (View)localObject;
    AppMethodBeat.o(210325);
    return localObject;
  }
  
  public final Intent getIntent()
  {
    return this.mIntent;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(210326);
    if (gbx())
    {
      localObject = this.activity;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(210326);
        throw ((Throwable)localObject);
      }
      localObject = ((MMActivity)localObject).getSwipeBackLayout();
      p.g(localObject, "(activity as MMActivity).swipeBackLayout");
      localObject = ((com.tencent.mm.ui.widget.SwipeBackLayout)localObject).getTargetContentView();
      AppMethodBeat.o(210326);
      return localObject;
    }
    Object localObject = this.ISU.getContentView();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
      AppMethodBeat.o(210326);
      throw ((Throwable)localObject);
    }
    localObject = ((me.imid.swipebacklayout.lib.SwipeBackLayout)localObject).getTargetView();
    AppMethodBeat.o(210326);
    return localObject;
  }
  
  public final void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskPageAdapter$setSwipeBackListener$1", "Lme/imid/swipebacklayout/lib/SwipeBackLayout$SwipeListener;", "onDispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onEdgeTouch", "edgeFlag", "", "onScrollOverThreshold", "onScrollStateChange", "state", "scrollPercent", "", "onViewReleased", "willSwipeBack", "", "plugin-webview_release"})
  public static final class b
    implements SwipeBackLayout.a
  {
    b(a.a parama) {}
    
    public final void LN()
    {
      AppMethodBeat.i(210321);
      a.a locala = this.IVg;
      if (locala != null)
      {
        locala.RF(1);
        AppMethodBeat.o(210321);
        return;
      }
      AppMethodBeat.o(210321);
    }
    
    public final int bS(boolean paramBoolean)
    {
      AppMethodBeat.i(210322);
      u.a locala = u.IVf;
      Log.i(u.access$getTAG$cp(), "onViewReleased, ".concat(String.valueOf(paramBoolean)));
      if (this.IVg != null)
      {
        int i = this.IVg.jJ(paramBoolean);
        AppMethodBeat.o(210322);
        return i;
      }
      AppMethodBeat.o(210322);
      return 1;
    }
    
    public final void i(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(210320);
      a.a locala = this.IVg;
      if (locala != null)
      {
        locala.aY(paramFloat);
        AppMethodBeat.o(210320);
        return;
      }
      AppMethodBeat.o(210320);
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(210323);
      p.h(paramMotionEvent, "ev");
      a.a locala = this.IVg;
      if (locala != null)
      {
        locala.n(paramMotionEvent);
        AppMethodBeat.o(210323);
        return;
      }
      AppMethodBeat.o(210323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.u
 * JD-Core Version:    0.7.0.1
 */