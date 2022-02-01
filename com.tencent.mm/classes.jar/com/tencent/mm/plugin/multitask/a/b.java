package com.tencent.mm.plugin.multitask.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.multitask.d;
import com.tencent.mm.plugin.multitask.j.a;
import com.tencent.mm.plugin.multitask.j.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.base.MultiTaskSnapViewWrapper;
import com.tencent.mm.plugin.multitask.ui.base.MultiTaskViewPager;
import com.tencent.mm.plugin.multitask.ui.base.c.a;
import com.tencent.mm.plugin.multitask.ui.base.c.b;
import com.tencent.mm.plugin.multitask.ui.base.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.c;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "(Landroid/app/Activity;Lcom/tencent/mm/ui/base/CustomViewPager;)V", "<set-?>", "getActivity", "()Landroid/app/Activity;", "setActivity", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "indicatorBottomMargin", "", "getIndicatorBottomMargin", "()I", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "isSupportSwipeToMultiTask", "", "()Z", "mMultiTaskType", "getMMultiTaskType", "setMMultiTaskType", "(I)V", "maskView", "getMaskView", "getMultiTaskRootView", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setMultiTaskRootView", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "multiTaskSwipeBackListener", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "getMultiTaskSwipeBackListener", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "setMultiTaskSwipeBackListener", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;)V", "multiTaskWrapper", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "getMultiTaskWrapper", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "setMultiTaskWrapper", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;)V", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "swipeBackListener", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "getSwipeBackListener", "()Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "setSwipeBackListener", "(Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;)V", "addMultiTaskWrapper", "", "pageHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "canConvertToTranslucent", "convertToTranslucent", "translucentCallback", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "convertToTranslucentIfNeed", "createSwipeBackListener", "finish", "withAnimation", "helper", "degree", "getMultiTaskViewPager", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "onCaptureBitmapBefore", "onCaptureBitmapCancel", "setMultiTaskType", "type", "setSwipeAheadEnable", "enable", "setSwipeBackEnable", "listener", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  implements a
{
  public static final b.a LBr;
  private CustomViewPager LBs;
  public com.tencent.mm.plugin.multitask.ui.base.c LBt;
  private SwipeBackLayout.c LBu;
  protected a.a LBv;
  private int LBw;
  private Activity activity;
  
  static
  {
    AppMethodBeat.i(303821);
    LBr = new b.a((byte)0);
    AppMethodBeat.o(303821);
  }
  
  public b(Activity paramActivity)
  {
    AppMethodBeat.i(303780);
    this.LBw = -1;
    setActivity(paramActivity);
    gjC();
    AppMethodBeat.o(303780);
  }
  
  public b(Activity paramActivity, CustomViewPager paramCustomViewPager)
  {
    AppMethodBeat.i(303787);
    this.LBw = -1;
    setActivity(paramActivity);
    this.LBs = paramCustomViewPager;
    gjC();
    AppMethodBeat.o(303787);
  }
  
  private static final void a(a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(303801);
    if (paramb != null) {
      paramb.onComplete(paramBoolean);
    }
    AppMethodBeat.o(303801);
  }
  
  private static final void a(AtomicInteger paramAtomicInteger, b paramb, a.b paramb1, boolean paramBoolean)
  {
    AppMethodBeat.i(303812);
    s.u(paramAtomicInteger, "$tryCount");
    s.u(paramb, "this$0");
    if ((!paramBoolean) && (paramAtomicInteger.getAndIncrement() <= 0))
    {
      com.tencent.mm.ui.base.b.a(paramb.getActivity(), new b..ExternalSyntheticLambda0(paramb1));
      AppMethodBeat.o(303812);
      return;
    }
    if (paramb1 != null) {
      paramb1.onComplete(paramBoolean);
    }
    AppMethodBeat.o(303812);
  }
  
  private final void gjC()
  {
    AppMethodBeat.i(303795);
    this.LBu = ((SwipeBackLayout.c)new b.b(this));
    AppMethodBeat.o(303795);
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(303957);
    this.LBv = parama;
    if ((getActivity() instanceof MMActivity))
    {
      parama = getActivity();
      if (parama == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(303957);
        throw parama;
      }
      if (((MMActivity)parama).getSwipeBackLayout() != null)
      {
        parama = this.LBt;
        if (parama == null) {
          parama = null;
        }
        while (parama == null)
        {
          parama = getActivity();
          if (parama == null)
          {
            parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(303957);
            throw parama;
            if (parama.LFl != null) {}
            for (boolean bool = true;; bool = false)
            {
              parama = Boolean.valueOf(bool);
              if (parama != null) {
                break label125;
              }
              parama = null;
              break;
            }
            label125:
            parama.booleanValue();
            Object localObject = this.LBt;
            if (localObject == null)
            {
              parama = null;
            }
            else
            {
              parama = this.LBu;
              localObject = ((com.tencent.mm.plugin.multitask.ui.base.c)localObject).LFl;
              if (localObject != null) {
                ((MultiTaskViewPager)localObject).setSwipeBackListener(parama);
              }
              parama = ah.aiuX;
            }
          }
          else
          {
            ((MMActivity)parama).getSwipeBackLayout().setSwipeBackListener(this.LBu);
            AppMethodBeat.o(303957);
            return;
          }
        }
        AppMethodBeat.o(303957);
        return;
      }
    }
    if (((getActivity() instanceof MMFragmentActivity)) && (this.LBs != null))
    {
      parama = this.LBs;
      if (parama != null) {
        parama.setSwipeBackListener(this.LBu);
      }
    }
    AppMethodBeat.o(303957);
  }
  
  public void a(a.b paramb)
  {
    AppMethodBeat.i(303909);
    Log.i("MicroMsg.MultiTaskPageAdapter", "convertToTranslucent");
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    com.tencent.mm.ui.base.b.a(getActivity(), new b..ExternalSyntheticLambda1(localAtomicInteger, this, paramb));
    Log.i("MicroMsg.MultiTaskPageAdapter", "multiTask page convertActivityToTranslucent");
    AppMethodBeat.o(303909);
  }
  
  public final void a(com.tencent.mm.plugin.multitask.b.b paramb)
  {
    boolean bool2 = false;
    AppMethodBeat.i(303946);
    com.tencent.mm.plugin.multitask.ui.base.c localc;
    Object localObject2;
    int i;
    ViewGroup.LayoutParams localLayoutParams;
    if ((getActivity() instanceof MMFragmentActivity))
    {
      if (this.LBt == null) {
        this.LBt = new com.tencent.mm.plugin.multitask.ui.base.c(getActivity());
      }
      localc = this.LBt;
      if (localc != null)
      {
        localObject2 = (a)this;
        Object localObject1 = ((a)localObject2).getContentView();
        if ((localObject1 == null) || (((View)localObject1).getParent() == null))
        {
          Log.i(localc.TAG, "addMultiTaskWrapper, contentView is null");
          AppMethodBeat.o(303946);
          return;
        }
        Bitmap localBitmap = paramb.gjU();
        if ((localBitmap == null) || (localBitmap.isRecycled()))
        {
          Log.i(localc.TAG, "addMultiTaskWrapper, bitmap is null or recycle");
          AppMethodBeat.o(303946);
          return;
        }
        if (((View)localObject1).getParent() == null)
        {
          Log.i(localc.TAG, "addMultiTaskWrapper, contentView parent is null");
          AppMethodBeat.o(303946);
          return;
        }
        localc.LFm = paramb;
        localc.LBU = ((a)localObject2);
        localObject2 = ((View)localObject1).getParent();
        if (localObject2 == null)
        {
          paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(303946);
          throw paramb;
        }
        localObject2 = (ViewGroup)localObject2;
        i = ((ViewGroup)localObject2).indexOfChild((View)localObject1);
        ((ViewGroup)localObject2).removeView((View)localObject1);
        localLayoutParams = ((View)localObject1).getLayoutParams();
        Object localObject4 = new View(((View)localObject1).getContext());
        Object localObject3 = new FrameLayout.LayoutParams(bd.fromDPToPix((Context)localc.activity, 15), -1);
        ((FrameLayout.LayoutParams)localObject3).gravity = 5;
        ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localc.LFn = ((FrameLayout)new c.b(localc, (View)localObject4, ((View)localObject1).getContext()));
        localObject3 = localc.LFn;
        if (localObject3 != null)
        {
          ((FrameLayout)localObject3).addView((View)localObject1);
          ((FrameLayout)localObject3).addView((View)localObject4);
          localObject4 = new MultiTaskViewPager((Context)localc.activity);
          ((MultiTaskViewPager)localObject4).setCanSlide(true);
          localObject1 = localc.activity;
          if (localObject1 != null) {}
          for (localObject1 = (View)new MultiTaskSnapViewWrapper((Context)localObject1);; localObject1 = null)
          {
            if (localObject1 != null) {
              ((View)localObject1).setBackgroundColor(androidx.core.content.a.w(((MultiTaskViewPager)localObject4).getContext(), j.b.BG_1));
            }
            if (localObject1 != null) {
              break;
            }
            paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.base.IMultiTaskView");
            AppMethodBeat.o(303946);
            throw paramb;
          }
          localObject1 = (com.tencent.mm.plugin.multitask.ui.base.a)localObject1;
          ((com.tencent.mm.plugin.multitask.ui.base.a)localObject1).setBitmap(localBitmap);
          ((MultiTaskViewPager)localObject4).setAdapter((androidx.viewpager.widget.a)new c.a(localc, (View)localObject3, ((com.tencent.mm.plugin.multitask.ui.base.a)localObject1).getView()));
          ((MultiTaskViewPager)localObject4).addView((View)localc.LFn);
          localObject1 = com.tencent.mm.plugin.multitask.f.a.LIu;
          ((MultiTaskViewPager)localObject4).setPageMargin(com.tencent.mm.plugin.multitask.f.a.glP());
          ((MultiTaskViewPager)localObject4).setPageMarginDrawable(j.b.multi_task_item_margin_bg);
          ((MultiTaskViewPager)localObject4).setCurrentItem(0, false);
          localObject1 = ah.aiuX;
          localc.LFl = ((MultiTaskViewPager)localObject4);
          paramb = paramb.gjO();
          if (paramb != null) {
            break label625;
          }
        }
      }
    }
    label625:
    for (boolean bool1 = false;; bool1 = paramb.booleanValue())
    {
      paramb = localc.LFl;
      if (paramb != null)
      {
        if (!bool1) {
          bool2 = true;
        }
        paramb.setCanOnlySlideBySide(bool2);
      }
      ((ViewGroup)localObject2).addView((View)localc.LFl, i, localLayoutParams);
      paramb = localc.LFl;
      if (paramb != null) {
        paramb.setOnPageChangeListener((ViewPager.OnPageChangeListener)new c.c(localc));
      }
      AppMethodBeat.o(303946);
      return;
    }
  }
  
  public void a(boolean paramBoolean, com.tencent.mm.plugin.multitask.b.b paramb)
  {
    AppMethodBeat.i(303901);
    s.u(paramb, "helper");
    Log.i("MicroMsg.MultiTaskPageAdapter", "finish, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramb.gjZ())
    {
      paramb = paramb.gjJ();
      if (paramb != null)
      {
        d locald = (d)h.az(d.class);
        String str = paramb.field_id;
        s.s(str, "it.field_id");
        locald.sendMultiTaskEvent(0, str, paramb.field_type);
      }
    }
    if ((getActivity() instanceof MMActivity))
    {
      paramb = getIntent();
      if (paramb != null)
      {
        if (!paramBoolean) {
          break label155;
        }
        paramb.putExtra("MMActivity.OverrideExitAnimation", j.a.pop_out);
        paramb.putExtra("MMActivity.OverrideEnterAnimation", j.a.anim_not_change);
      }
    }
    for (;;)
    {
      paramb = getActivity();
      if (paramb != null) {
        paramb.finish();
      }
      AppMethodBeat.o(303901);
      return;
      label155:
      paramb.putExtra("MMActivity.OverrideExitAnimation", 0);
      paramb.putExtra("MMActivity.OverrideEnterAnimation", 0);
    }
  }
  
  public final void ach(int paramInt)
  {
    this.LBw = paramInt;
  }
  
  public final Bitmap ap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(303886);
    Object localObject = com.tencent.mm.plugin.multitask.f.c.LIw;
    if (com.tencent.mm.plugin.multitask.f.c.ada(this.LBw))
    {
      AppMethodBeat.o(303886);
      return null;
    }
    if (paramBitmap != null) {
      try
      {
        float f1 = paramBitmap.getWidth();
        float f2 = paramBitmap.getHeight();
        localObject = new Matrix();
        ((Matrix)localObject).setRotate(90.0F, f1 / 2.0F, f2 / 2.0F);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, (int)f1, (int)f2, (Matrix)localObject, true);
        AppMethodBeat.o(303886);
        return paramBitmap;
      }
      finally
      {
        Log.e("MicroMsg.MultiTaskPageAdapter", "get rotate bitmap failed", new Object[] { paramBitmap });
      }
    }
    AppMethodBeat.o(303886);
    return null;
  }
  
  public boolean cBZ()
  {
    AppMethodBeat.i(303895);
    if ((getActivity() instanceof MMActivity))
    {
      Object localObject = getActivity();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(303895);
        throw ((Throwable)localObject);
      }
      if (((MMActivity)localObject).getSwipeBackLayout() != null)
      {
        AppMethodBeat.o(303895);
        return true;
      }
    }
    AppMethodBeat.o(303895);
    return false;
  }
  
  public boolean cCf()
  {
    return false;
  }
  
  public ViewGroup cXB()
  {
    AppMethodBeat.i(303852);
    Object localObject = getActivity();
    if (localObject == null)
    {
      AppMethodBeat.o(303852);
      return null;
    }
    localObject = (ViewGroup)((Activity)localObject).getWindow().getDecorView();
    AppMethodBeat.o(303852);
    return localObject;
  }
  
  public int cXC()
  {
    return -1;
  }
  
  public boolean cor()
  {
    return true;
  }
  
  public Activity getActivity()
  {
    return this.activity;
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(303880);
    Object localObject1 = com.tencent.mm.plugin.multitask.f.c.LIw;
    if (com.tencent.mm.plugin.multitask.f.c.ada(this.LBw))
    {
      AppMethodBeat.o(303880);
      return null;
    }
    try
    {
      getActivity();
      localObject1 = getMaskView();
      if (localObject1 != null)
      {
        localObject1 = com.tencent.mm.ui.p.a.a(getMaskView(), (int)(((View)localObject1).getWidth() / 1.25F), (int)(((View)localObject1).getHeight() / 1.25F), true, Bitmap.Config.RGB_565);
        AppMethodBeat.o(303880);
        return localObject1;
      }
    }
    finally
    {
      Log.e("MicroMsg.MultiTaskPageAdapter", "get bitmap failed", new Object[] { localObject2 });
      AppMethodBeat.o(303880);
    }
    return null;
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(303859);
    Object localObject;
    if ((getActivity() instanceof MMActivity))
    {
      localObject = getActivity();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(303859);
        throw ((Throwable)localObject);
      }
      if (((MMActivity)localObject).getSwipeBackLayout() != null)
      {
        localObject = getActivity();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(303859);
          throw ((Throwable)localObject);
        }
        localObject = (View)((MMActivity)localObject).getSwipeBackLayout();
        AppMethodBeat.o(303859);
        return localObject;
      }
    }
    if ((getActivity() instanceof MMFragmentActivity))
    {
      localObject = getActivity();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(303859);
        throw ((Throwable)localObject);
      }
      if (((MMFragmentActivity)localObject).getSwipeBackLayout() != null)
      {
        localObject = getActivity();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
          AppMethodBeat.o(303859);
          throw ((Throwable)localObject);
        }
        localObject = (View)((MMFragmentActivity)localObject).getSwipeBackLayout();
        AppMethodBeat.o(303859);
        return localObject;
      }
    }
    AppMethodBeat.o(303859);
    return null;
  }
  
  public Intent getIntent()
  {
    AppMethodBeat.i(303846);
    Object localObject = getActivity();
    if (localObject == null)
    {
      AppMethodBeat.o(303846);
      return null;
    }
    localObject = ((Activity)localObject).getIntent();
    AppMethodBeat.o(303846);
    return localObject;
  }
  
  public View getMaskView()
  {
    AppMethodBeat.i(303864);
    Object localObject;
    if ((getActivity() instanceof MMActivity))
    {
      localObject = getActivity();
      if (localObject == null)
      {
        AppMethodBeat.o(303864);
        return null;
      }
      localObject = ((Activity)localObject).getWindow();
      if (localObject == null)
      {
        AppMethodBeat.o(303864);
        return null;
      }
      localObject = ((Window)localObject).getDecorView();
      AppMethodBeat.o(303864);
      return localObject;
    }
    if (((getActivity() instanceof MMFragmentActivity)) && (this.LBs != null))
    {
      View localView = (View)this.LBs;
      localObject = localView;
      if (localView == null)
      {
        localObject = getActivity();
        if (localObject != null) {
          break label113;
        }
        localObject = null;
      }
      for (;;)
      {
        AppMethodBeat.o(303864);
        return localObject;
        label113:
        localObject = ((Activity)localObject).getWindow();
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((Window)localObject).getDecorView();
        }
      }
    }
    AppMethodBeat.o(303864);
    return null;
  }
  
  protected final SwipeBackLayout.c gjB()
  {
    return this.LBu;
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public final void zD(boolean paramBoolean)
  {
    AppMethodBeat.i(303922);
    com.tencent.mm.plugin.multitask.ui.base.c localc = this.LBt;
    if (localc != null)
    {
      MultiTaskViewPager localMultiTaskViewPager = localc.LFl;
      if (localMultiTaskViewPager != null) {
        localMultiTaskViewPager.setCanSlide(paramBoolean);
      }
      Log.i(localc.TAG, "canSlide:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(303922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.a.b
 * JD-Core Version:    0.7.0.1
 */