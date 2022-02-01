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
import com.tencent.mm.plugin.multitask.f.c;
import com.tencent.mm.plugin.multitask.j.a;
import com.tencent.mm.plugin.multitask.j.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.base.MultiTaskSnapViewWrapper;
import com.tencent.mm.plugin.multitask.ui.base.MultiTaskViewPager;
import com.tencent.mm.plugin.multitask.ui.base.d.a;
import com.tencent.mm.plugin.multitask.ui.base.d.b;
import com.tencent.mm.plugin.multitask.ui.base.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "(Landroid/app/Activity;Lcom/tencent/mm/ui/base/CustomViewPager;)V", "<set-?>", "getActivity", "()Landroid/app/Activity;", "setActivity", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "indicatorBottomMargin", "", "getIndicatorBottomMargin", "()I", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "isSupportSwipeToMultiTask", "", "()Z", "mMultiTaskType", "getMMultiTaskType", "setMMultiTaskType", "(I)V", "maskView", "getMaskView", "getMultiTaskRootView", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setMultiTaskRootView", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "multiTaskSwipeBackListener", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "getMultiTaskSwipeBackListener", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "setMultiTaskSwipeBackListener", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;)V", "multiTaskWrapper", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "getMultiTaskWrapper", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "setMultiTaskWrapper", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;)V", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "swipeBackListener", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "getSwipeBackListener", "()Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "setSwipeBackListener", "(Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;)V", "addMultiTaskWrapper", "", "pageHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "canConvertToTranslucent", "convertToTranslucent", "translucentCallback", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "convertToTranslucentIfNeed", "createSwipeBackListener", "finish", "withAnimation", "helper", "degree", "getMultiTaskViewPager", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "onCaptureBitmapBefore", "onCaptureBitmapCancel", "setMultiTaskType", "type", "setSwipeAheadEnable", "enable", "setSwipeBackEnable", "listener", "Companion", "plugin-multitask_release"})
public class b
  implements a
{
  public static final b.a FFx;
  private CustomViewPager FFs;
  public com.tencent.mm.plugin.multitask.ui.base.d FFt;
  private SwipeBackLayout.b FFu;
  protected a.a FFv;
  private int FFw;
  private Activity activity;
  
  static
  {
    AppMethodBeat.i(248755);
    FFx = new b.a((byte)0);
    AppMethodBeat.o(248755);
  }
  
  public b(Activity paramActivity)
  {
    AppMethodBeat.i(248750);
    this.FFw = -1;
    setActivity(paramActivity);
    fax();
    AppMethodBeat.o(248750);
  }
  
  public b(Activity paramActivity, CustomViewPager paramCustomViewPager)
  {
    AppMethodBeat.i(248752);
    this.FFw = -1;
    setActivity(paramActivity);
    this.FFs = paramCustomViewPager;
    fax();
    AppMethodBeat.o(248752);
  }
  
  private final void fax()
  {
    AppMethodBeat.i(248717);
    this.FFu = ((SwipeBackLayout.b)new b.c(this));
    AppMethodBeat.o(248717);
  }
  
  public final void XU(int paramInt)
  {
    this.FFw = paramInt;
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(248748);
    this.FFv = parama;
    if ((getActivity() instanceof MMActivity))
    {
      parama = getActivity();
      if (parama == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(248748);
        throw parama;
      }
      if (((MMActivity)parama).getSwipeBackLayout() != null)
      {
        parama = this.FFt;
        boolean bool;
        if (parama != null)
        {
          if (parama.FJV == null) {
            break label150;
          }
          bool = true;
          parama = Boolean.valueOf(bool);
          if (parama != null)
          {
            parama.booleanValue();
            Object localObject = this.FFt;
            if (localObject == null) {
              break label155;
            }
            parama = this.FFu;
            localObject = ((com.tencent.mm.plugin.multitask.ui.base.d)localObject).FJV;
            if (localObject != null) {
              ((MultiTaskViewPager)localObject).setSwipeBackListener(parama);
            }
            parama = x.aazN;
          }
        }
        for (;;)
        {
          if (parama == null)
          {
            parama = getActivity();
            if (parama == null)
            {
              parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(248748);
              throw parama;
              label150:
              bool = false;
              break;
              label155:
              parama = null;
              continue;
            }
            ((MMActivity)parama).getSwipeBackLayout().setSwipeBackListener(this.FFu);
            parama = x.aazN;
          }
        }
        AppMethodBeat.o(248748);
        return;
      }
    }
    if (((getActivity() instanceof MMFragmentActivity)) && (this.FFs != null))
    {
      parama = this.FFs;
      if (parama != null)
      {
        parama.setSwipeBackListener(this.FFu);
        AppMethodBeat.o(248748);
        return;
      }
    }
    AppMethodBeat.o(248748);
  }
  
  public void a(final a.b paramb)
  {
    AppMethodBeat.i(248731);
    Log.i("MicroMsg.MultiTaskPageAdapter", "convertToTranslucent");
    final AtomicInteger localAtomicInteger = new AtomicInteger(0);
    com.tencent.mm.ui.base.b.a(getActivity(), (com.tencent.mm.ui.base.b.b)new b(this, localAtomicInteger, paramb));
    Log.i("MicroMsg.MultiTaskPageAdapter", "multiTask page convertActivityToTranslucent");
    AppMethodBeat.o(248731);
  }
  
  public final void a(com.tencent.mm.plugin.multitask.b.b paramb)
  {
    boolean bool2 = false;
    AppMethodBeat.i(248743);
    if ((getActivity() instanceof MMFragmentActivity))
    {
      if (this.FFt == null) {
        this.FFt = new com.tencent.mm.plugin.multitask.ui.base.d(getActivity());
      }
      com.tencent.mm.plugin.multitask.ui.base.d locald = this.FFt;
      if (locald != null)
      {
        Object localObject2 = (a)this;
        Object localObject1 = ((a)localObject2).getContentView();
        if ((localObject1 == null) || (((View)localObject1).getParent() == null))
        {
          Log.i(locald.TAG, "addMultiTaskWrapper, contentView is null");
          AppMethodBeat.o(248743);
          return;
        }
        Bitmap localBitmap = paramb.faP();
        if ((localBitmap == null) || (localBitmap.isRecycled()))
        {
          Log.i(locald.TAG, "addMultiTaskWrapper, bitmap is null or recycle");
          AppMethodBeat.o(248743);
          return;
        }
        if (((View)localObject1).getParent() == null)
        {
          Log.i(locald.TAG, "addMultiTaskWrapper, contentView parent is null");
          AppMethodBeat.o(248743);
          return;
        }
        locald.FJW = paramb;
        locald.FGb = ((a)localObject2);
        localObject2 = ((View)localObject1).getParent();
        if (localObject2 == null)
        {
          paramb = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(248743);
          throw paramb;
        }
        localObject2 = (ViewGroup)localObject2;
        int i = ((ViewGroup)localObject2).indexOfChild((View)localObject1);
        ((ViewGroup)localObject2).removeView((View)localObject1);
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
        Object localObject4 = new View(((View)localObject1).getContext());
        Object localObject3 = new FrameLayout.LayoutParams(aw.fromDPToPix((Context)locald.activity, 15), -1);
        ((FrameLayout.LayoutParams)localObject3).gravity = 5;
        ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        locald.FJX = ((FrameLayout)new d.b(locald, (View)localObject4, (View)localObject1, ((View)localObject1).getContext()));
        localObject3 = locald.FJX;
        if (localObject3 != null)
        {
          ((FrameLayout)localObject3).addView((View)localObject1);
          ((FrameLayout)localObject3).addView((View)localObject4);
          localObject4 = new MultiTaskViewPager((Context)locald.activity);
          ((MultiTaskViewPager)localObject4).setCanSlide(true);
          localObject1 = locald.activity;
          if (localObject1 != null) {}
          for (localObject1 = (View)new MultiTaskSnapViewWrapper((Context)localObject1);; localObject1 = null)
          {
            if (localObject1 != null) {
              ((View)localObject1).setBackgroundColor(androidx.core.content.a.w(((MultiTaskViewPager)localObject4).getContext(), j.b.BG_1));
            }
            if (localObject1 != null) {
              break;
            }
            paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.base.IMultiTaskView");
            AppMethodBeat.o(248743);
            throw paramb;
          }
          localObject1 = (com.tencent.mm.plugin.multitask.ui.base.a)localObject1;
          ((com.tencent.mm.plugin.multitask.ui.base.a)localObject1).setBitmap(localBitmap);
          ((MultiTaskViewPager)localObject4).setAdapter((androidx.viewpager.widget.a)new d.a(locald, (View)localObject3, ((com.tencent.mm.plugin.multitask.ui.base.a)localObject1).getView()));
          ((MultiTaskViewPager)localObject4).addView((View)locald.FJX);
          localObject1 = com.tencent.mm.plugin.multitask.f.a.FNz;
          ((MultiTaskViewPager)localObject4).setPageMargin(com.tencent.mm.plugin.multitask.f.a.fcM());
          ((MultiTaskViewPager)localObject4).setPageMarginDrawable(j.b.multi_task_item_margin_bg);
          ((MultiTaskViewPager)localObject4).setCurrentItem(0, false);
          locald.FJV = ((MultiTaskViewPager)localObject4);
          paramb = paramb.faJ();
          if (paramb != null) {}
          for (boolean bool1 = paramb.booleanValue();; bool1 = false)
          {
            paramb = locald.FJV;
            if (paramb != null)
            {
              if (!bool1) {
                bool2 = true;
              }
              paramb.setCanOnlySlideBySide(bool2);
            }
            ((ViewGroup)localObject2).addView((View)locald.FJV, i, localLayoutParams);
            paramb = locald.FJV;
            if (paramb == null) {
              break;
            }
            paramb.setOnPageChangeListener((ViewPager.OnPageChangeListener)new d.c(locald));
            AppMethodBeat.o(248743);
            return;
          }
          AppMethodBeat.o(248743);
          return;
        }
        AppMethodBeat.o(248743);
        return;
      }
    }
    AppMethodBeat.o(248743);
  }
  
  public void a(boolean paramBoolean, com.tencent.mm.plugin.multitask.b.b paramb)
  {
    AppMethodBeat.i(248728);
    p.k(paramb, "helper");
    Log.i("MicroMsg.MultiTaskPageAdapter", "finish, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramb.faT())
    {
      paramb = paramb.faE();
      if (paramb != null)
      {
        com.tencent.mm.plugin.multitask.d locald = (com.tencent.mm.plugin.multitask.d)h.ag(com.tencent.mm.plugin.multitask.d.class);
        String str = paramb.field_id;
        p.j(str, "it.field_id");
        locald.sendMultiTaskEvent(0, str, paramb.field_type);
      }
    }
    if ((getActivity() instanceof MMActivity))
    {
      paramb = getIntent();
      if (paramb != null)
      {
        if (!paramBoolean) {
          break label154;
        }
        paramb.putExtra("MMActivity.OverrideExitAnimation", j.a.pop_out);
        paramb.putExtra("MMActivity.OverrideEnterAnimation", j.a.anim_not_change);
      }
      for (;;)
      {
        paramb = getActivity();
        if (paramb == null) {
          break;
        }
        paramb.finish();
        AppMethodBeat.o(248728);
        return;
        label154:
        paramb.putExtra("MMActivity.OverrideExitAnimation", 0);
        paramb.putExtra("MMActivity.OverrideEnterAnimation", 0);
      }
    }
    AppMethodBeat.o(248728);
  }
  
  public final Bitmap ad(Bitmap paramBitmap)
  {
    AppMethodBeat.i(248725);
    Object localObject = c.FNB;
    if (c.YO(this.FFw))
    {
      AppMethodBeat.o(248725);
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
        AppMethodBeat.o(248725);
        return paramBitmap;
      }
      catch (Throwable paramBitmap)
      {
        Log.e("MicroMsg.MultiTaskPageAdapter", "get rotate bitmap failed", new Object[] { paramBitmap });
      }
    }
    AppMethodBeat.o(248725);
    return null;
  }
  
  public boolean bOd()
  {
    return true;
  }
  
  public boolean cbG()
  {
    AppMethodBeat.i(248726);
    if ((getActivity() instanceof MMActivity))
    {
      Object localObject = getActivity();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(248726);
        throw ((Throwable)localObject);
      }
      if (((MMActivity)localObject).getSwipeBackLayout() != null)
      {
        AppMethodBeat.o(248726);
        return true;
      }
    }
    AppMethodBeat.o(248726);
    return false;
  }
  
  public boolean cbM()
  {
    return false;
  }
  
  public ViewGroup cuR()
  {
    AppMethodBeat.i(248720);
    Object localObject = getActivity();
    if (localObject == null)
    {
      AppMethodBeat.o(248720);
      return null;
    }
    localObject = ((Activity)localObject).getWindow();
    p.j(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(248720);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup)localObject;
    AppMethodBeat.o(248720);
    return localObject;
  }
  
  public int cuS()
  {
    return -1;
  }
  
  protected final SwipeBackLayout.b faw()
  {
    return this.FFu;
  }
  
  public Activity getActivity()
  {
    return this.activity;
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(248723);
    Object localObject = c.FNB;
    if (c.YO(this.FFw))
    {
      AppMethodBeat.o(248723);
      return null;
    }
    try
    {
      getActivity();
      localObject = getMaskView();
      if (localObject != null)
      {
        localObject = com.tencent.mm.ui.p.a.a(getMaskView(), (int)(((View)localObject).getWidth() / 1.25F), (int)(((View)localObject).getHeight() / 1.25F), Bitmap.Config.RGB_565);
        AppMethodBeat.o(248723);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.MultiTaskPageAdapter", "get bitmap failed", new Object[] { localThrowable });
      AppMethodBeat.o(248723);
    }
    return null;
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(248721);
    Object localObject;
    if ((getActivity() instanceof MMActivity))
    {
      localObject = getActivity();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(248721);
        throw ((Throwable)localObject);
      }
      if (((MMActivity)localObject).getSwipeBackLayout() != null)
      {
        localObject = getActivity();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(248721);
          throw ((Throwable)localObject);
        }
        localObject = ((MMActivity)localObject).getSwipeBackLayout();
      }
    }
    for (;;)
    {
      localObject = (View)localObject;
      AppMethodBeat.o(248721);
      return localObject;
      if ((getActivity() instanceof MMFragmentActivity))
      {
        localObject = getActivity();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
          AppMethodBeat.o(248721);
          throw ((Throwable)localObject);
        }
        if (((MMFragmentActivity)localObject).getSwipeBackLayout() != null)
        {
          localObject = getActivity();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(248721);
            throw ((Throwable)localObject);
          }
          localObject = ((MMFragmentActivity)localObject).getSwipeBackLayout();
          continue;
        }
      }
      localObject = null;
    }
  }
  
  public Intent getIntent()
  {
    AppMethodBeat.i(248718);
    Object localObject = getActivity();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      AppMethodBeat.o(248718);
      return localObject;
    }
    AppMethodBeat.o(248718);
    return null;
  }
  
  public View getMaskView()
  {
    AppMethodBeat.i(248722);
    Object localObject;
    if ((getActivity() instanceof MMActivity))
    {
      localObject = getActivity();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          AppMethodBeat.o(248722);
          return localObject;
        }
      }
      AppMethodBeat.o(248722);
      return null;
    }
    if (((getActivity() instanceof MMFragmentActivity)) && (this.FFs != null))
    {
      View localView = (View)this.FFs;
      localObject = localView;
      if (localView == null)
      {
        localObject = getActivity();
        if (localObject == null) {
          break label117;
        }
        localObject = ((Activity)localObject).getWindow();
        if (localObject == null) {
          break label117;
        }
      }
      label117:
      for (localObject = ((Window)localObject).getDecorView();; localObject = null)
      {
        AppMethodBeat.o(248722);
        return localObject;
      }
    }
    AppMethodBeat.o(248722);
    return null;
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public final void vl(boolean paramBoolean)
  {
    AppMethodBeat.i(248736);
    com.tencent.mm.plugin.multitask.ui.base.d locald = this.FFt;
    if (locald != null)
    {
      MultiTaskViewPager localMultiTaskViewPager = locald.FJV;
      if (localMultiTaskViewPager != null) {
        localMultiTaskViewPager.setCanSlide(paramBoolean);
      }
      Log.i(locald.TAG, "canSlide:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(248736);
      return;
    }
    AppMethodBeat.o(248736);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "drawComplete", "", "onComplete"})
  static final class b
    implements com.tencent.mm.ui.base.b.b
  {
    b(b paramb, AtomicInteger paramAtomicInteger, a.b paramb1) {}
    
    public final void eG(boolean paramBoolean)
    {
      AppMethodBeat.i(248331);
      if ((!paramBoolean) && (localAtomicInteger.getAndIncrement() <= 0))
      {
        com.tencent.mm.ui.base.b.a(this.FFy.getActivity(), (com.tencent.mm.ui.base.b.b)new com.tencent.mm.ui.base.b.b()
        {
          public final void eG(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(247722);
            a.b localb = this.FFB.FFA;
            if (localb != null)
            {
              localb.eG(paramAnonymousBoolean);
              AppMethodBeat.o(247722);
              return;
            }
            AppMethodBeat.o(247722);
          }
        });
        AppMethodBeat.o(248331);
        return;
      }
      a.b localb = paramb;
      if (localb != null)
      {
        localb.eG(paramBoolean);
        AppMethodBeat.o(248331);
        return;
      }
      AppMethodBeat.o(248331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.a.b
 * JD-Core Version:    0.7.0.1
 */