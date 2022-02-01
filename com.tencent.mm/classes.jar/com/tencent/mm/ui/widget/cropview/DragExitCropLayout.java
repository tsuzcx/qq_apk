package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/DragExitCropLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "beginDragExitScale", "", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "setBgView", "(Landroid/view/View;)V", "isBeginDragExit", "", "isEnableDragExit", "()Z", "setEnableDragExit", "(Z)V", "onScroll", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "distanceY", "onTouchCancel", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class DragExitCropLayout
  extends CropLayout
{
  private View AhP;
  private boolean agdC;
  private boolean agdD;
  private float agdE;
  
  public DragExitCropLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164450);
    this.agdE = 1.0F;
    AppMethodBeat.o(164450);
  }
  
  public DragExitCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164451);
    this.agdE = 1.0F;
    AppMethodBeat.o(164451);
  }
  
  public DragExitCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164452);
    this.agdE = 1.0F;
    AppMethodBeat.o(164452);
  }
  
  public final void ap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164449);
    s.u(paramMotionEvent, "e1");
    super.ap(paramMotionEvent);
    if (this.agdD)
    {
      paramMotionEvent = this.AhP;
      if (paramMotionEvent != null)
      {
        paramMotionEvent = paramMotionEvent.animate();
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.setDuration(200L);
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.alpha(1.0F);
            if (paramMotionEvent != null) {
              paramMotionEvent.start();
            }
          }
        }
      }
    }
    this.agdD = false;
    AppMethodBeat.o(164449);
  }
  
  public final View getBgView()
  {
    return this.AhP;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164448);
    s.u(paramMotionEvent1, "e1");
    s.u(paramMotionEvent2, "e2");
    if ((this.agdC) && (!jHp()) && (!jHt()) && (paramMotionEvent1.getPointerCount() == 1) && (paramMotionEvent2.getPointerCount() == 1) && ((this.agdD) || (paramFloat2 < 0.0F)))
    {
      if (!this.agdD) {
        this.agdE = getContentViewScale()[0];
      }
      this.agdD = true;
      float f = (getContentRect().exactCenterY() - getVisibilityRect().centerY()) / (getVisibilityRect().height() / 2.0F);
      z((1.0F - 0.6F * f) * this.agdE / getContentViewScale()[0], getContentRect().exactCenterX(), getContentRect().exactCenterY());
      View localView = this.AhP;
      if (localView != null) {
        localView.setAlpha(1.0F - f);
      }
    }
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    AppMethodBeat.o(164448);
    return bool;
  }
  
  public final void setBgView(View paramView)
  {
    this.AhP = paramView;
  }
  
  public final void setEnableDragExit(boolean paramBoolean)
  {
    this.agdC = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.DragExitCropLayout
 * JD-Core Version:    0.7.0.1
 */