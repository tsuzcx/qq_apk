package com.tencent.mm.plugin.multitask.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitask.f.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.base.MultiTaskSnapViewWrapper;
import com.tencent.mm.plugin.multitask.ui.base.MultiTaskViewPager;
import com.tencent.mm.plugin.multitask.ui.base.d.a;
import com.tencent.mm.plugin.multitask.ui.base.d.b;
import com.tencent.mm.plugin.multitask.ui.base.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "(Landroid/app/Activity;Lcom/tencent/mm/ui/base/CustomViewPager;)V", "<set-?>", "getActivity", "()Landroid/app/Activity;", "setActivity", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "indicatorBottomMargin", "", "getIndicatorBottomMargin", "()I", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "isSupportSwipeToMultiTask", "", "()Z", "mMultiTaskType", "getMMultiTaskType", "setMMultiTaskType", "(I)V", "maskView", "getMaskView", "getMultiTaskRootView", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setMultiTaskRootView", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "multiTaskSwipeBackListener", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "getMultiTaskSwipeBackListener", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "setMultiTaskSwipeBackListener", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;)V", "multiTaskWrapper", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "getMultiTaskWrapper", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "setMultiTaskWrapper", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;)V", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "swipeBackListener", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "getSwipeBackListener", "()Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "setSwipeBackListener", "(Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;)V", "addMultiTaskWrapper", "", "pageHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "canConvertToTranslucent", "convertToTranslucent", "translucentCallback", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "convertToTranslucentIfNeed", "createSwipeBackListener", "finish", "withAnimation", "helper", "degree", "onCaptureBitmapBefore", "onCaptureBitmapCancel", "setMultiTaskType", "type", "setSwipeAheadEnable", "enable", "setSwipeBackEnable", "listener", "Companion", "plugin-multitask_release"})
public class b
  implements a
{
  public static final b.a zZH;
  private Activity activity;
  private CustomViewPager zZC;
  private com.tencent.mm.plugin.multitask.ui.base.d zZD;
  protected SwipeBackLayout.b zZE;
  protected a.a zZF;
  private int zZG;
  
  static
  {
    AppMethodBeat.i(200375);
    zZH = new b.a((byte)0);
    AppMethodBeat.o(200375);
  }
  
  public b(Activity paramActivity)
  {
    AppMethodBeat.i(200373);
    this.zZG = -1;
    setActivity(paramActivity);
    eqG();
    AppMethodBeat.o(200373);
  }
  
  public b(Activity paramActivity, CustomViewPager paramCustomViewPager)
  {
    AppMethodBeat.i(200374);
    this.zZG = -1;
    setActivity(paramActivity);
    this.zZC = paramCustomViewPager;
    eqG();
    AppMethodBeat.o(200374);
  }
  
  private final void eqG()
  {
    AppMethodBeat.i(200360);
    this.zZE = ((SwipeBackLayout.b)new c(this));
    AppMethodBeat.o(200360);
  }
  
  public final void RE(int paramInt)
  {
    this.zZG = paramInt;
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(200372);
    this.zZF = parama;
    if ((getActivity() instanceof MMActivity))
    {
      parama = getActivity();
      if (parama == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(200372);
        throw parama;
      }
      if (((MMActivity)parama).getSwipeBackLayout() != null)
      {
        parama = this.zZD;
        boolean bool;
        if (parama != null)
        {
          if (parama.Adq == null) {
            break label150;
          }
          bool = true;
          parama = Boolean.valueOf(bool);
          if (parama != null)
          {
            parama.booleanValue();
            Object localObject = this.zZD;
            if (localObject == null) {
              break label155;
            }
            parama = this.zZE;
            localObject = ((com.tencent.mm.plugin.multitask.ui.base.d)localObject).Adq;
            if (localObject != null) {
              ((MultiTaskViewPager)localObject).setSwipeBackListener(parama);
            }
            parama = x.SXb;
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
              AppMethodBeat.o(200372);
              throw parama;
              label150:
              bool = false;
              break;
              label155:
              parama = null;
              continue;
            }
            ((MMActivity)parama).getSwipeBackLayout().setSwipeBackListener(this.zZE);
            parama = x.SXb;
          }
        }
        AppMethodBeat.o(200372);
        return;
      }
    }
    if (((getActivity() instanceof MMFragmentActivity)) && (this.zZC != null))
    {
      parama = this.zZC;
      if (parama != null)
      {
        parama.setSwipeBackListener(this.zZE);
        AppMethodBeat.o(200372);
        return;
      }
    }
    AppMethodBeat.o(200372);
  }
  
  public void a(final a.b paramb)
  {
    AppMethodBeat.i(200369);
    Log.i("MicroMsg.MultiTaskPageAdapter", "convertToTranslucent");
    final AtomicInteger localAtomicInteger = new AtomicInteger(0);
    com.tencent.mm.ui.base.b.a(getActivity(), (com.tencent.mm.ui.base.b.b)new b(this, localAtomicInteger, paramb));
    Log.i("MicroMsg.MultiTaskPageAdapter", "multiTask page convertActivityToTranslucent");
    AppMethodBeat.o(200369);
  }
  
  public final void a(com.tencent.mm.plugin.multitask.b.b paramb)
  {
    AppMethodBeat.i(200371);
    if ((getActivity() instanceof MMFragmentActivity))
    {
      if (this.zZD == null) {
        this.zZD = new com.tencent.mm.plugin.multitask.ui.base.d(getActivity());
      }
      com.tencent.mm.plugin.multitask.ui.base.d locald = this.zZD;
      if (locald != null)
      {
        Object localObject1 = (a)this;
        Object localObject3 = new z.f();
        ((z.f)localObject3).SYG = ((a)localObject1).getContentView();
        if (((View)((z.f)localObject3).SYG == null) || (((View)((z.f)localObject3).SYG).getParent() == null))
        {
          Log.i(locald.TAG, "addMultiTaskWrapper, contentView is null");
          AppMethodBeat.o(200371);
          return;
        }
        Bitmap localBitmap = paramb.eqV();
        if ((localBitmap == null) || (localBitmap.isRecycled()))
        {
          Log.i(locald.TAG, "addMultiTaskWrapper, bitmap is null or recycle");
          AppMethodBeat.o(200371);
          return;
        }
        if (((View)((z.f)localObject3).SYG).getParent() == null)
        {
          Log.i(locald.TAG, "addMultiTaskWrapper, contentView parent is null");
          AppMethodBeat.o(200371);
          return;
        }
        locald.Adr = paramb;
        locald.Aak = ((a)localObject1);
        paramb = ((View)((z.f)localObject3).SYG).getParent();
        if (paramb == null)
        {
          paramb = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(200371);
          throw paramb;
        }
        localObject1 = (ViewGroup)paramb;
        int i = ((ViewGroup)localObject1).indexOfChild((View)((z.f)localObject3).SYG);
        ((ViewGroup)localObject1).removeView((View)((z.f)localObject3).SYG);
        ViewGroup.LayoutParams localLayoutParams = ((View)((z.f)localObject3).SYG).getLayoutParams();
        paramb = new View(((View)((z.f)localObject3).SYG).getContext());
        Object localObject2 = new FrameLayout.LayoutParams(at.fromDPToPix((Context)locald.activity, 15), -1);
        ((FrameLayout.LayoutParams)localObject2).gravity = 5;
        paramb.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        locald.Ads = ((FrameLayout)new d.b(locald, paramb, (z.f)localObject3, ((View)((z.f)localObject3).SYG).getContext()));
        localObject2 = locald.Ads;
        if (localObject2 != null)
        {
          ((FrameLayout)localObject2).addView((View)((z.f)localObject3).SYG);
          ((FrameLayout)localObject2).addView(paramb);
          localObject3 = new MultiTaskViewPager((Context)locald.activity);
          ((MultiTaskViewPager)localObject3).setCanSlide(true);
          paramb = locald.activity;
          if (paramb != null) {}
          for (paramb = (View)new MultiTaskSnapViewWrapper((Context)paramb);; paramb = null)
          {
            if (paramb != null) {
              paramb.setBackgroundColor(android.support.v4.content.b.n(((MultiTaskViewPager)localObject3).getContext(), 2131099649));
            }
            if (paramb != null) {
              break;
            }
            paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.base.IMultiTaskView");
            AppMethodBeat.o(200371);
            throw paramb;
          }
          paramb = (com.tencent.mm.plugin.multitask.ui.base.a)paramb;
          paramb.setBitmap(localBitmap);
          ((MultiTaskViewPager)localObject3).setAdapter((q)new d.a(locald, (View)localObject2, paramb.getView()));
          ((MultiTaskViewPager)localObject3).addView((View)locald.Ads);
          paramb = com.tencent.mm.plugin.multitask.f.a.AgJ;
          ((MultiTaskViewPager)localObject3).setPageMargin(com.tencent.mm.plugin.multitask.f.a.esC());
          ((MultiTaskViewPager)localObject3).setPageMarginDrawable(2131100855);
          ((MultiTaskViewPager)localObject3).setCurrentItem(0, false);
          locald.Adq = ((MultiTaskViewPager)localObject3);
          paramb = locald.Adq;
          if (paramb != null) {
            paramb.setCanOnlySlideBySide(true);
          }
          ((ViewGroup)localObject1).addView((View)locald.Adq, i, localLayoutParams);
          paramb = locald.Adq;
          if (paramb != null)
          {
            paramb.setOnPageChangeListener((ViewPager.OnPageChangeListener)new d.c(locald));
            AppMethodBeat.o(200371);
            return;
          }
          AppMethodBeat.o(200371);
          return;
        }
        AppMethodBeat.o(200371);
        return;
      }
    }
    AppMethodBeat.o(200371);
  }
  
  public void a(boolean paramBoolean, com.tencent.mm.plugin.multitask.b.b paramb)
  {
    AppMethodBeat.i(200368);
    p.h(paramb, "helper");
    Log.i("MicroMsg.MultiTaskPageAdapter", "finish, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramb.eqZ())
    {
      paramb = paramb.eqN();
      if (paramb != null)
      {
        com.tencent.mm.plugin.multitask.d locald = (com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class);
        String str = paramb.field_id;
        p.g(str, "it.field_id");
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
        paramb.putExtra("MMActivity.OverrideExitAnimation", 2130772124);
        paramb.putExtra("MMActivity.OverrideEnterAnimation", 2130771986);
      }
      for (;;)
      {
        paramb = getActivity();
        if (paramb == null) {
          break;
        }
        paramb.finish();
        AppMethodBeat.o(200368);
        return;
        label154:
        paramb.putExtra("MMActivity.OverrideExitAnimation", 0);
        paramb.putExtra("MMActivity.OverrideEnterAnimation", 0);
      }
    }
    AppMethodBeat.o(200368);
  }
  
  public final Bitmap ag(Bitmap paramBitmap)
  {
    AppMethodBeat.i(200366);
    Object localObject = c.AgL;
    if (c.Ss(this.zZG))
    {
      AppMethodBeat.o(200366);
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
        AppMethodBeat.o(200366);
        return paramBitmap;
      }
      catch (Throwable paramBitmap)
      {
        Log.e("MicroMsg.MultiTaskPageAdapter", "get rotate bitmap failed", new Object[] { paramBitmap });
      }
    }
    AppMethodBeat.o(200366);
    return null;
  }
  
  public boolean bCI()
  {
    return true;
  }
  
  public boolean bPp()
  {
    AppMethodBeat.i(200367);
    if ((getActivity() instanceof MMActivity))
    {
      Object localObject = getActivity();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(200367);
        throw ((Throwable)localObject);
      }
      if (((MMActivity)localObject).getSwipeBackLayout() != null)
      {
        AppMethodBeat.o(200367);
        return true;
      }
    }
    AppMethodBeat.o(200367);
    return false;
  }
  
  public boolean bPv()
  {
    return false;
  }
  
  public ViewGroup chG()
  {
    AppMethodBeat.i(200362);
    Object localObject = getActivity();
    if (localObject == null)
    {
      AppMethodBeat.o(200362);
      return null;
    }
    localObject = ((Activity)localObject).getWindow();
    p.g(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(200362);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup)localObject;
    AppMethodBeat.o(200362);
    return localObject;
  }
  
  public int chH()
  {
    return -1;
  }
  
  public Activity getActivity()
  {
    return this.activity;
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(200365);
    Object localObject = c.AgL;
    if (c.Ss(this.zZG))
    {
      AppMethodBeat.o(200365);
      return null;
    }
    try
    {
      getActivity();
      localObject = getMaskView();
      if (localObject != null)
      {
        localObject = com.tencent.mm.ui.n.a.a(getMaskView(), (int)(((View)localObject).getWidth() / 1.25F), (int)(((View)localObject).getHeight() / 1.25F), Bitmap.Config.RGB_565);
        AppMethodBeat.o(200365);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.MultiTaskPageAdapter", "get bitmap failed", new Object[] { localThrowable });
      AppMethodBeat.o(200365);
    }
    return null;
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(200363);
    Object localObject;
    if ((getActivity() instanceof MMActivity))
    {
      localObject = getActivity();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(200363);
        throw ((Throwable)localObject);
      }
      if (((MMActivity)localObject).getSwipeBackLayout() != null)
      {
        localObject = getActivity();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(200363);
          throw ((Throwable)localObject);
        }
        localObject = ((MMActivity)localObject).getSwipeBackLayout();
      }
    }
    for (;;)
    {
      localObject = (View)localObject;
      AppMethodBeat.o(200363);
      return localObject;
      if ((getActivity() instanceof MMFragmentActivity))
      {
        localObject = getActivity();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
          AppMethodBeat.o(200363);
          throw ((Throwable)localObject);
        }
        if (((MMFragmentActivity)localObject).getSwipeBackLayout() != null)
        {
          localObject = getActivity();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(200363);
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
    AppMethodBeat.i(200361);
    Object localObject = getActivity();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      AppMethodBeat.o(200361);
      return localObject;
    }
    AppMethodBeat.o(200361);
    return null;
  }
  
  public View getMaskView()
  {
    AppMethodBeat.i(200364);
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
          AppMethodBeat.o(200364);
          return localObject;
        }
      }
      AppMethodBeat.o(200364);
      return null;
    }
    if (((getActivity() instanceof MMFragmentActivity)) && (this.zZC != null))
    {
      View localView = (View)this.zZC;
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
        AppMethodBeat.o(200364);
        return localObject;
      }
    }
    AppMethodBeat.o(200364);
    return null;
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public final void sj(boolean paramBoolean)
  {
    AppMethodBeat.i(200370);
    com.tencent.mm.plugin.multitask.ui.base.d locald = this.zZD;
    if (locald != null)
    {
      MultiTaskViewPager localMultiTaskViewPager = locald.Adq;
      if (localMultiTaskViewPager != null) {
        localMultiTaskViewPager.setCanSlide(paramBoolean);
      }
      Log.i(locald.TAG, "canSlide:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(200370);
      return;
    }
    AppMethodBeat.o(200370);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "drawComplete", "", "onComplete"})
  static final class b
    implements com.tencent.mm.ui.base.b.b
  {
    b(b paramb, AtomicInteger paramAtomicInteger, a.b paramb1) {}
    
    public final void ei(boolean paramBoolean)
    {
      AppMethodBeat.i(200351);
      if ((!paramBoolean) && (localAtomicInteger.getAndIncrement() <= 0))
      {
        com.tencent.mm.ui.base.b.a(this.zZI.getActivity(), (com.tencent.mm.ui.base.b.b)new com.tencent.mm.ui.base.b.b()
        {
          public final void ei(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(200350);
            a.b localb = this.zZL.zZK;
            if (localb != null)
            {
              localb.ei(paramAnonymousBoolean);
              AppMethodBeat.o(200350);
              return;
            }
            AppMethodBeat.o(200350);
          }
        });
        AppMethodBeat.o(200351);
        return;
      }
      a.b localb = paramb;
      if (localb != null)
      {
        localb.ei(paramBoolean);
        AppMethodBeat.o(200351);
        return;
      }
      AppMethodBeat.o(200351);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter$createSwipeBackListener$1", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "canInterceptTouch", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "left", "top", "dx", "dy", "scrollPercent", "", "onViewReleased", "willSwipeBack", "shouldInterceptTouchEvent", "plugin-multitask_release"})
  public static final class c
    implements SwipeBackLayout.b
  {
    public final void RF(int paramInt)
    {
      AppMethodBeat.i(200358);
      a.a locala = this.zZI.zZF;
      if (locala != null)
      {
        locala.RF(paramInt);
        AppMethodBeat.o(200358);
        return;
      }
      AppMethodBeat.o(200358);
    }
    
    public final int bS(boolean paramBoolean)
    {
      AppMethodBeat.i(200354);
      if (this.zZI.zZF != null)
      {
        a.a locala = this.zZI.zZF;
        if (locala != null)
        {
          int i = locala.jJ(paramBoolean);
          AppMethodBeat.o(200354);
          return i;
        }
      }
      AppMethodBeat.o(200354);
      return 1;
    }
    
    public final void bw(float paramFloat)
    {
      AppMethodBeat.i(200352);
      if (this.zZI.zZF != null)
      {
        a.a locala = this.zZI.zZF;
        if (locala != null)
        {
          locala.aY(paramFloat);
          AppMethodBeat.o(200352);
          return;
        }
      }
      AppMethodBeat.o(200352);
    }
    
    public final int eqE()
    {
      AppMethodBeat.i(200357);
      a.a locala = this.zZI.zZF;
      if (locala != null)
      {
        int i = locala.eqE();
        AppMethodBeat.o(200357);
        return i;
      }
      AppMethodBeat.o(200357);
      return 0;
    }
    
    public final boolean eqF()
    {
      AppMethodBeat.i(200359);
      a.a locala = this.zZI.zZF;
      if (locala != null)
      {
        boolean bool = locala.eqF();
        AppMethodBeat.o(200359);
        return bool;
      }
      AppMethodBeat.o(200359);
      return false;
    }
    
    public final boolean eqH()
    {
      AppMethodBeat.i(200355);
      if (this.zZI.zZF != null)
      {
        a.a locala = this.zZI.zZF;
        if (locala != null)
        {
          boolean bool = locala.eqD();
          AppMethodBeat.o(200355);
          return bool;
        }
      }
      AppMethodBeat.o(200355);
      return false;
    }
    
    public final boolean j(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200356);
      p.h(paramMotionEvent, "ev");
      if (this.zZI.zZF != null)
      {
        a.a locala = this.zZI.zZF;
        if (locala != null)
        {
          boolean bool = locala.j(paramMotionEvent);
          AppMethodBeat.o(200356);
          return bool;
        }
      }
      AppMethodBeat.o(200356);
      return false;
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200353);
      p.h(paramMotionEvent, "ev");
      if (this.zZI.zZF != null)
      {
        a.a locala = this.zZI.zZF;
        if (locala != null)
        {
          locala.n(paramMotionEvent);
          AppMethodBeat.o(200353);
          return;
        }
      }
      AppMethodBeat.o(200353);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.a.b
 * JD-Core Version:    0.7.0.1
 */