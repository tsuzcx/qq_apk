package com.tencent.mm.plugin.multitask.ui.base;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "setActivity", "mPosition", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "pageContainer", "Landroid/widget/FrameLayout;", "getPageContainer", "()Landroid/widget/FrameLayout;", "setPageContainer", "(Landroid/widget/FrameLayout;)V", "pageHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getPageHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setPageHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "viewPager", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "getViewPager", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "setViewPager", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;)V", "addMultiTaskWrapper", "", "calcViewScreenLocation", "Landroid/graphics/RectF;", "view", "Landroid/view/View;", "createMultiTaskSnapView", "inHomePanel", "", "initListener", "isAttach", "()Ljava/lang/Boolean;", "setCanSlide", "enable", "setSwipeBackListener", "listener", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "ParentAdapter", "plugin-multitask_release"})
public final class d
{
  public com.tencent.mm.plugin.multitask.a.a Aak;
  public MultiTaskViewPager Adq;
  public b Adr;
  public FrameLayout Ads;
  public final String TAG = "MicroMsg.MultiTaskWrapper";
  public Activity activity;
  int mPosition;
  
  public d(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper$initListener$1", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-multitask_release"})
  public static final class c
    implements ViewPager.OnPageChangeListener
  {
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(200768);
      Object localObject;
      if ((paramInt == 1) && (this.Adv.mPosition == 0))
      {
        localObject = this.Adv.Adr;
        if (localObject != null) {
          ((b)localObject).bPu();
        }
        h.RTc.aX((Runnable)new a(this));
      }
      if (paramInt == 0)
      {
        localObject = this.Adv.Adq;
        if ((localObject != null) && (((MultiTaskViewPager)localObject).getCurrentItem() == 1)) {}
        for (paramInt = 1; paramInt != 0; paramInt = 0)
        {
          localObject = this.Adv.Adq;
          if (localObject != null) {
            ((MultiTaskViewPager)localObject).setCanSlide(false);
          }
          localObject = this.Adv.Adr;
          if (localObject == null) {
            break;
          }
          ((b)localObject).eqT();
          AppMethodBeat.o(200768);
          return;
        }
      }
      AppMethodBeat.o(200768);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public final void onPageSelected(int paramInt)
    {
      this.Adv.mPosition = paramInt;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(200767);
        for (;;)
        {
          try
          {
            Object localObject1 = this.Ady.Adv.Ads;
            if (localObject1 != null)
            {
              b localb1 = this.Ady.Adv.Adr;
              if (localb1 != null)
              {
                b localb2 = this.Ady.Adv.Adr;
                if (localb2 == null) {
                  break label141;
                }
                localObject1 = localb2.aj(com.tencent.mm.ui.n.a.a((View)this.Ady.Adv.Ads, (int)(((FrameLayout)localObject1).getWidth() / 1.25F), (int)(((FrameLayout)localObject1).getHeight() / 1.25F), Bitmap.Config.RGB_565));
                localb1.ah((Bitmap)localObject1);
                AppMethodBeat.o(200767);
                return;
              }
              AppMethodBeat.o(200767);
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            Log.e("MicroMsg.MultiTaskPageAdapter", "snapshot bitmap failed", new Object[] { localThrowable });
            AppMethodBeat.o(200767);
            return;
          }
          AppMethodBeat.o(200767);
          return;
          label141:
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.d
 * JD-Core Version:    0.7.0.1
 */