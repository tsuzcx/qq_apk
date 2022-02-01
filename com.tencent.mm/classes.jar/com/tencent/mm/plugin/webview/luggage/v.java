package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.a.a.a;
import com.tencent.mm.plugin.multitask.a.a.b;
import com.tencent.mm.plugin.multitask.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import kotlin.Metadata;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "page", "Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;", "(Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "indicatorBottomMargin", "", "getIndicatorBottomMargin", "()I", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "isSupportSwipeToMultiTask", "", "()Z", "mIntent", "mPage", "maskView", "getMaskView", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "convertToTranslucent", "", "translucentCallback", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "finish", "withAnimation", "helper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setSwipeBackEnable", "enable", "setSwipeBackListener", "listener", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "useActivityEnv", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends com.tencent.mm.plugin.multitask.a.b
{
  private static final String TAG;
  public static final a WHS;
  private final g WFG;
  private Activity activity;
  private final Intent mIntent;
  
  static
  {
    AppMethodBeat.i(295941);
    WHS = new a((byte)0);
    TAG = "MicroMsg.LuggageWebViewMultiTaskPageAdapter";
    AppMethodBeat.o(295941);
  }
  
  public v(g paramg)
  {
    super((Activity)localContext);
    AppMethodBeat.i(295935);
    this.WFG = paramg;
    this.mIntent = new Intent();
    this.mIntent.putExtras(this.WFG.ejT);
    paramg = this.WFG.mContext;
    if (paramg == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(295935);
      throw paramg;
    }
    this.activity = ((Activity)paramg);
    AppMethodBeat.o(295935);
  }
  
  private final boolean itZ()
  {
    AppMethodBeat.i(295937);
    Log.i(TAG, kotlin.g.b.s.X("useActivityEnv: ", Integer.valueOf(this.WFG.eje.aov().size())));
    if (this.WFG.eje.aov().size() <= 1)
    {
      AppMethodBeat.o(295937);
      return true;
    }
    AppMethodBeat.o(295937);
    return false;
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(295961);
    this.LBv = parama;
    if (itZ())
    {
      if ((this.activity instanceof MMActivity))
      {
        parama = this.activity;
        if (parama == null)
        {
          parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(295961);
          throw parama;
        }
        if (((MMActivity)parama).getSwipeBackLayout() != null)
        {
          parama = this.activity;
          if (parama == null)
          {
            parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(295961);
            throw parama;
          }
          ((MMActivity)parama).getSwipeBackLayout().setSwipeBackListener(gjB());
          AppMethodBeat.o(295961);
        }
      }
    }
    else
    {
      View localView = this.WFG.mContentView;
      if (localView == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
        AppMethodBeat.o(295961);
        throw parama;
      }
      ((me.imid.swipebacklayout.lib.SwipeBackLayout)localView).a((SwipeBackLayout.a)new b(parama));
    }
    AppMethodBeat.o(295961);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(295963);
    if (itZ())
    {
      super.a(paramb);
      AppMethodBeat.o(295963);
      return;
    }
    if (paramb != null) {
      paramb.onComplete(true);
    }
    AppMethodBeat.o(295963);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.multitask.b.b paramb)
  {
    AppMethodBeat.i(295965);
    kotlin.g.b.s.u(paramb, "helper");
    if (!this.WFG.eje.aow().cH(false))
    {
      if (!paramBoolean) {
        break label110;
      }
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
      if (paramb != null) {
        paramb.finish();
      }
      AppMethodBeat.o(295965);
      return;
      label110:
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
  
  public final boolean cBZ()
  {
    AppMethodBeat.i(295955);
    if (getContentView() != null)
    {
      AppMethodBeat.o(295955);
      return true;
    }
    AppMethodBeat.o(295955);
    return false;
  }
  
  public final ViewGroup cXB()
  {
    Object localObject1 = null;
    AppMethodBeat.i(295946);
    if (itZ())
    {
      Object localObject2 = this.activity;
      if (localObject2 == null) {}
      while (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(295946);
        throw ((Throwable)localObject1);
        localObject2 = ((Activity)localObject2).getWindow();
        if (localObject2 != null) {
          localObject1 = ((Window)localObject2).getDecorView();
        }
      }
      localObject1 = (ViewGroup)localObject1;
      AppMethodBeat.o(295946);
      return localObject1;
    }
    localObject1 = this.WFG.mContentView.getParent();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(295946);
      throw ((Throwable)localObject1);
    }
    localObject1 = (ViewGroup)localObject1;
    AppMethodBeat.o(295946);
    return localObject1;
  }
  
  public final int cXC()
  {
    AppMethodBeat.i(295959);
    if (itZ())
    {
      AppMethodBeat.o(295959);
      return -1;
    }
    AppMethodBeat.o(295959);
    return 0;
  }
  
  public final Activity getActivity()
  {
    return this.activity;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(295948);
    if (itZ())
    {
      localObject = this.activity;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(295948);
        throw ((Throwable)localObject);
      }
      localObject = (View)((MMActivity)localObject).getSwipeBackLayout();
      AppMethodBeat.o(295948);
      return localObject;
    }
    Object localObject = this.WFG.mContentView;
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
      AppMethodBeat.o(295948);
      throw ((Throwable)localObject);
    }
    localObject = (View)localObject;
    AppMethodBeat.o(295948);
    return localObject;
  }
  
  public final Intent getIntent()
  {
    return this.mIntent;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(295951);
    if (itZ())
    {
      localObject = this.activity;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(295951);
        throw ((Throwable)localObject);
      }
      localObject = ((MMActivity)localObject).getSwipeBackLayout().getTargetContentView();
      AppMethodBeat.o(295951);
      return localObject;
    }
    Object localObject = this.WFG.mContentView;
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
      AppMethodBeat.o(295951);
      throw ((Throwable)localObject);
    }
    localObject = ((me.imid.swipebacklayout.lib.SwipeBackLayout)localObject).getTargetView();
    AppMethodBeat.o(295951);
    return localObject;
  }
  
  public final void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskPageAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskPageAdapter$setSwipeBackListener$1", "Lme/imid/swipebacklayout/lib/SwipeBackLayout$SwipeListener;", "onDispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onEdgeTouch", "edgeFlag", "", "onScrollOverThreshold", "onScrollStateChange", "state", "scrollPercent", "", "onViewReleased", "willSwipeBack", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements SwipeBackLayout.a
  {
    b(a.a parama) {}
    
    public final void aoM()
    {
      AppMethodBeat.i(295918);
      a.a locala = this.WHT;
      if (locala != null) {
        locala.aci(1);
      }
      AppMethodBeat.o(295918);
    }
    
    public final int cI(boolean paramBoolean)
    {
      AppMethodBeat.i(295921);
      v.a locala = v.WHS;
      Log.i(v.access$getTAG$cp(), kotlin.g.b.s.X("onViewReleased, ", Boolean.valueOf(paramBoolean)));
      if (this.WHT != null)
      {
        int i = this.WHT.zE(paramBoolean);
        AppMethodBeat.o(295921);
        return i;
      }
      AppMethodBeat.o(295921);
      return 1;
    }
    
    public final void n(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(295916);
      a.a locala = this.WHT;
      if (locala != null) {
        locala.cC(paramFloat);
      }
      AppMethodBeat.o(295916);
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(295926);
      kotlin.g.b.s.u(paramMotionEvent, "ev");
      a.a locala = this.WHT;
      if (locala != null) {
        locala.n(paramMotionEvent);
      }
      AppMethodBeat.o(295926);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.v
 * JD-Core Version:    0.7.0.1
 */