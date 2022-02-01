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
import com.tencent.mm.plugin.multitask.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "page", "Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;", "(Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "indicatorBottomMargin", "", "getIndicatorBottomMargin", "()I", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "isSupportSwipeToMultiTask", "", "()Z", "mIntent", "mPage", "maskView", "getMaskView", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "convertToTranslucent", "", "translucentCallback", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "finish", "withAnimation", "helper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setSwipeBackEnable", "enable", "setSwipeBackListener", "listener", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "useActivityEnv", "Companion", "plugin-webview_release"})
public final class u
  extends com.tencent.mm.plugin.multitask.a.b
{
  public static final a PRv;
  private static final String TAG = "MicroMsg.LuggageWebViewMultiTaskPageAdapter";
  private final g PPn;
  private Activity activity;
  private final Intent mIntent;
  
  static
  {
    AppMethodBeat.i(218875);
    PRv = new a((byte)0);
    TAG = "MicroMsg.LuggageWebViewMultiTaskPageAdapter";
    AppMethodBeat.o(218875);
  }
  
  public u(g paramg)
  {
    super((Activity)localContext);
    AppMethodBeat.i(218873);
    this.PPn = paramg;
    this.mIntent = new Intent();
    this.mIntent.putExtras(this.PPn.OA());
    paramg = this.PPn.getContext();
    if (paramg == null)
    {
      paramg = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(218873);
      throw paramg;
    }
    this.activity = ((Activity)paramg);
    AppMethodBeat.o(218873);
  }
  
  private final boolean gUr()
  {
    AppMethodBeat.i(218872);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder("useActivityEnv: ");
    j localj = this.PPn.NX();
    p.j(localj, "mPage.containerCtrl");
    Log.i((String)localObject, localj.On().size());
    localObject = this.PPn.NX();
    p.j(localObject, "mPage.containerCtrl");
    if (((j)localObject).On().size() <= 1)
    {
      AppMethodBeat.o(218872);
      return true;
    }
    AppMethodBeat.o(218872);
    return false;
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(218864);
    this.FFv = parama;
    if (gUr())
    {
      if ((this.activity instanceof MMActivity))
      {
        parama = this.activity;
        if (parama == null)
        {
          parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(218864);
          throw parama;
        }
        if (((MMActivity)parama).getSwipeBackLayout() != null)
        {
          parama = this.activity;
          if (parama == null)
          {
            parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(218864);
            throw parama;
          }
          ((MMActivity)parama).getSwipeBackLayout().setSwipeBackListener(faw());
          AppMethodBeat.o(218864);
        }
      }
    }
    else
    {
      View localView = this.PPn.getContentView();
      if (localView == null)
      {
        parama = new t("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
        AppMethodBeat.o(218864);
        throw parama;
      }
      ((me.imid.swipebacklayout.lib.SwipeBackLayout)localView).a((SwipeBackLayout.a)new b(parama));
    }
    AppMethodBeat.o(218864);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(218866);
    if (gUr())
    {
      super.a(paramb);
      AppMethodBeat.o(218866);
      return;
    }
    if (paramb != null)
    {
      paramb.eG(true);
      AppMethodBeat.o(218866);
      return;
    }
    AppMethodBeat.o(218866);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.multitask.b.b paramb)
  {
    AppMethodBeat.i(218870);
    p.k(paramb, "helper");
    paramb = this.PPn.NX();
    p.j(paramb, "mPage.containerCtrl");
    if (!paramb.Oo().cb(false))
    {
      if (paramBoolean)
      {
        paramb = this.activity;
        if (paramb != null)
        {
          paramb = paramb.getIntent();
          if (paramb != null) {
            paramb.putExtra("MMActivity.OverrideExitAnimation", j.a.pop_out);
          }
        }
        paramb = this.activity;
        if (paramb != null)
        {
          paramb = paramb.getIntent();
          if (paramb != null) {
            paramb.putExtra("MMActivity.OverrideEnterAnimation", j.a.anim_not_change);
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
        AppMethodBeat.o(218870);
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
    AppMethodBeat.o(218870);
  }
  
  public final boolean cbG()
  {
    AppMethodBeat.i(218861);
    if (getContentView() != null)
    {
      AppMethodBeat.o(218861);
      return true;
    }
    AppMethodBeat.o(218861);
    return false;
  }
  
  public final ViewGroup cuR()
  {
    AppMethodBeat.i(218856);
    if (gUr())
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
        AppMethodBeat.o(218856);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup)localObject;
      AppMethodBeat.o(218856);
      return localObject;
    }
    Object localObject = this.PPn.getContentView();
    p.j(localObject, "mPage.contentView");
    localObject = ((View)localObject).getParent();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(218856);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup)localObject;
    AppMethodBeat.o(218856);
    return localObject;
  }
  
  public final int cuS()
  {
    AppMethodBeat.i(218862);
    if (gUr())
    {
      AppMethodBeat.o(218862);
      return -1;
    }
    AppMethodBeat.o(218862);
    return 0;
  }
  
  public final Activity getActivity()
  {
    return this.activity;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(218857);
    if (gUr())
    {
      localObject = this.activity;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(218857);
        throw ((Throwable)localObject);
      }
      localObject = (View)((MMActivity)localObject).getSwipeBackLayout();
      AppMethodBeat.o(218857);
      return localObject;
    }
    Object localObject = this.PPn.getContentView();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
      AppMethodBeat.o(218857);
      throw ((Throwable)localObject);
    }
    localObject = (View)localObject;
    AppMethodBeat.o(218857);
    return localObject;
  }
  
  public final Intent getIntent()
  {
    return this.mIntent;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(218858);
    if (gUr())
    {
      localObject = this.activity;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(218858);
        throw ((Throwable)localObject);
      }
      localObject = ((MMActivity)localObject).getSwipeBackLayout();
      p.j(localObject, "(activity as MMActivity).swipeBackLayout");
      localObject = ((com.tencent.mm.ui.widget.SwipeBackLayout)localObject).getTargetContentView();
      AppMethodBeat.o(218858);
      return localObject;
    }
    Object localObject = this.PPn.getContentView();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
      AppMethodBeat.o(218858);
      throw ((Throwable)localObject);
    }
    localObject = ((me.imid.swipebacklayout.lib.SwipeBackLayout)localObject).getTargetView();
    AppMethodBeat.o(218858);
    return localObject;
  }
  
  public final void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskPageAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-webview_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskPageAdapter$setSwipeBackListener$1", "Lme/imid/swipebacklayout/lib/SwipeBackLayout$SwipeListener;", "onDispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onEdgeTouch", "edgeFlag", "", "onScrollOverThreshold", "onScrollStateChange", "state", "scrollPercent", "", "onViewReleased", "willSwipeBack", "", "plugin-webview_release"})
  public static final class b
    implements SwipeBackLayout.a
  {
    b(a.a parama) {}
    
    public final void OE()
    {
      AppMethodBeat.i(214265);
      a.a locala = this.PRw;
      if (locala != null)
      {
        locala.XV(1);
        AppMethodBeat.o(214265);
        return;
      }
      AppMethodBeat.o(214265);
    }
    
    public final int cc(boolean paramBoolean)
    {
      AppMethodBeat.i(214267);
      u.a locala = u.PRv;
      Log.i(u.access$getTAG$cp(), "onViewReleased, ".concat(String.valueOf(paramBoolean)));
      if (this.PRw != null)
      {
        int i = this.PRw.vm(paramBoolean);
        AppMethodBeat.o(214267);
        return i;
      }
      AppMethodBeat.o(214267);
      return 1;
    }
    
    public final void j(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(214262);
      a.a locala = this.PRw;
      if (locala != null)
      {
        locala.by(paramFloat);
        AppMethodBeat.o(214262);
        return;
      }
      AppMethodBeat.o(214262);
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(214271);
      p.k(paramMotionEvent, "ev");
      a.a locala = this.PRw;
      if (locala != null)
      {
        locala.n(paramMotionEvent);
        AppMethodBeat.o(214271);
        return;
      }
      AppMethodBeat.o(214271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.u
 * JD-Core Version:    0.7.0.1
 */