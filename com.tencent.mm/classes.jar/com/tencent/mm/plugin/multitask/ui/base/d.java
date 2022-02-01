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
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "setActivity", "mPosition", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "pageContainer", "Landroid/widget/FrameLayout;", "getPageContainer", "()Landroid/widget/FrameLayout;", "setPageContainer", "(Landroid/widget/FrameLayout;)V", "pageHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getPageHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setPageHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "viewPager", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "getViewPager", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "setViewPager", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;)V", "addMultiTaskWrapper", "", "calcViewScreenLocation", "Landroid/graphics/RectF;", "view", "Landroid/view/View;", "createMultiTaskSnapView", "getMultiTaskViewPager", "inHomePanel", "", "initListener", "isAttach", "()Ljava/lang/Boolean;", "setCanSlide", "enable", "setSwipeBackListener", "listener", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "ParentAdapter", "plugin-multitask_release"})
public final class d
{
  public com.tencent.mm.plugin.multitask.a.a FGb;
  public MultiTaskViewPager FJV;
  public b FJW;
  public FrameLayout FJX;
  public final String TAG = "MicroMsg.MultiTaskWrapper";
  public Activity activity;
  int mPosition;
  
  public d(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper$initListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-multitask_release"})
  public static final class c
    implements ViewPager.OnPageChangeListener
  {
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(247576);
      Object localObject;
      if ((paramInt == 1) && (this.FKa.mPosition == 0))
      {
        localObject = this.FKa.FJW;
        if (localObject != null) {
          ((b)localObject).cbL();
        }
      }
      if (paramInt == 0)
      {
        localObject = this.FKa.FJV;
        if ((localObject != null) && (((MultiTaskViewPager)localObject).getCurrentItem() == 1))
        {
          paramInt = 1;
          if (paramInt == 0) {}
        }
        else
        {
          for (;;)
          {
            try
            {
              localObject = this.FKa.FJX;
              if (localObject != null)
              {
                b localb1 = this.FKa.FJW;
                if (localb1 != null)
                {
                  b localb2 = this.FKa.FJW;
                  if (localb2 == null) {
                    continue;
                  }
                  localObject = localb2.ae(com.tencent.mm.ui.p.a.a((View)this.FKa.FJX, (int)(((FrameLayout)localObject).getWidth() / 1.25F), (int)(((FrameLayout)localObject).getHeight() / 1.25F), Bitmap.Config.RGB_565));
                  localb1.af((Bitmap)localObject);
                }
              }
            }
            catch (Throwable localThrowable)
            {
              Log.e("MicroMsg.MultiTaskPageAdapter", "snapshot bitmap failed", new Object[] { localThrowable });
              continue;
            }
            localObject = this.FKa.FJV;
            if (localObject != null) {
              ((MultiTaskViewPager)localObject).setCanSlide(false);
            }
            localObject = this.FKa.FJW;
            if (localObject == null) {
              break label225;
            }
            ((b)localObject).faN();
            AppMethodBeat.o(247576);
            return;
            paramInt = 0;
            break;
            localObject = null;
          }
        }
      }
      label225:
      AppMethodBeat.o(247576);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public final void onPageSelected(int paramInt)
    {
      this.FKa.mPosition = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.d
 * JD-Core Version:    0.7.0.1
 */