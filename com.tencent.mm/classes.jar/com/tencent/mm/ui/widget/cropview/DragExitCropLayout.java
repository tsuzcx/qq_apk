package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/cropview/DragExitCropLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "beginDragExitScale", "", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "setBgView", "(Landroid/view/View;)V", "isBeginDragExit", "", "isEnableDragExit", "()Z", "setEnableDragExit", "(Z)V", "onScroll", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "distanceY", "onTouchCancel", "", "libmmui_release"})
public class DragExitCropLayout
  extends CropLayout
{
  private boolean YlN;
  private boolean YlO;
  private float YlP;
  private View cCj;
  
  public DragExitCropLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164450);
    this.YlP = 1.0F;
    AppMethodBeat.o(164450);
  }
  
  public DragExitCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164451);
    this.YlP = 1.0F;
    AppMethodBeat.o(164451);
  }
  
  public DragExitCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164452);
    this.YlP = 1.0F;
    AppMethodBeat.o(164452);
  }
  
  public final void am(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164449);
    p.k(paramMotionEvent, "e1");
    super.am(paramMotionEvent);
    if (this.YlO)
    {
      paramMotionEvent = this.cCj;
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
    this.YlO = false;
    AppMethodBeat.o(164449);
  }
  
  public final View getBgView()
  {
    return this.cCj;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164448);
    p.k(paramMotionEvent1, "e1");
    p.k(paramMotionEvent2, "e2");
    if ((this.YlN) && (!icb()) && (!icf()) && (paramMotionEvent1.getPointerCount() == 1) && (paramMotionEvent2.getPointerCount() == 1) && ((this.YlO) || (paramFloat2 < 0.0F)))
    {
      if (!this.YlO) {
        this.YlP = getContentViewScale()[0];
      }
      this.YlO = true;
      float f = (getContentRect().exactCenterY() - getVisibilityRect().centerY()) / (getVisibilityRect().height() / 2.0F);
      u((1.0F - 0.6F * f) * this.YlP / getContentViewScale()[0], getContentRect().exactCenterX(), getContentRect().exactCenterY());
      View localView = this.cCj;
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
    this.cCj = paramView;
  }
  
  public final void setEnableDragExit(boolean paramBoolean)
  {
    this.YlN = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.DragExitCropLayout
 * JD-Core Version:    0.7.0.1
 */