package com.tencent.mm.plugin.multitask.ui.base;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "setActivity", "mPosition", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "pageContainer", "Landroid/widget/FrameLayout;", "getPageContainer", "()Landroid/widget/FrameLayout;", "setPageContainer", "(Landroid/widget/FrameLayout;)V", "pageHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getPageHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setPageHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "viewPager", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "getViewPager", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "setViewPager", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;)V", "addMultiTaskWrapper", "", "calcViewScreenLocation", "Landroid/graphics/RectF;", "view", "Landroid/view/View;", "createMultiTaskSnapView", "getMultiTaskViewPager", "inHomePanel", "", "initListener", "isAttach", "()Ljava/lang/Boolean;", "setCanSlide", "enable", "setSwipeBackListener", "listener", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "ParentAdapter", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public com.tencent.mm.plugin.multitask.a.a LBU;
  public MultiTaskViewPager LFl;
  public b LFm;
  public FrameLayout LFn;
  public final String TAG = "MicroMsg.MultiTaskWrapper";
  public Activity activity;
  int mPosition;
  
  public c(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper$initListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ViewPager.OnPageChangeListener
  {
    public c(c paramc) {}
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(304595);
      Object localObject1;
      if ((paramInt == 1) && (this.LFq.mPosition == 0))
      {
        localObject1 = this.LFq.LFm;
        if (localObject1 != null) {
          ((b)localObject1).cCe();
        }
      }
      if (paramInt == 0)
      {
        localObject1 = this.LFq.LFl;
        if ((localObject1 == null) || (((MultiTaskViewPager)localObject1).getCurrentItem() != 1)) {
          break label158;
        }
        paramInt = 1;
        if (paramInt == 0) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = this.LFq.LFn;
          if (localObject1 != null)
          {
            localc = this.LFq;
            b localb1 = localc.LFm;
            if (localb1 != null)
            {
              localb2 = localc.LFm;
              if (localb2 != null) {
                continue;
              }
              localObject1 = null;
              localb1.ar((Bitmap)localObject1);
            }
          }
        }
        finally
        {
          c localc;
          b localb2;
          label158:
          Log.e("MicroMsg.MultiTaskPageAdapter", "snapshot bitmap failed", new Object[] { localObject2 });
          continue;
        }
        localObject1 = this.LFq.LFl;
        if (localObject1 != null) {
          ((MultiTaskViewPager)localObject1).setCanSlide(false);
        }
        localObject1 = this.LFq.LFm;
        if (localObject1 != null) {
          ((b)localObject1).gjS();
        }
        AppMethodBeat.o(304595);
        return;
        paramInt = 0;
        break;
        localObject1 = localb2.aq(com.tencent.mm.ui.p.a.a((View)localc.LFn, (int)(((FrameLayout)localObject1).getWidth() / 1.25F), (int)(((FrameLayout)localObject1).getHeight() / 1.25F), true, Bitmap.Config.RGB_565));
      }
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public final void onPageSelected(int paramInt)
    {
      this.LFq.mPosition = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.c
 * JD-Core Version:    0.7.0.1
 */