package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/cropview/DragExitCropLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "beginDragExitScale", "", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "setBgView", "(Landroid/view/View;)V", "isBeginDragExit", "", "isEnableDragExit", "()Z", "setEnableDragExit", "(Z)V", "onScroll", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "distanceY", "onTouchCancel", "", "libmmui_release"})
public class DragExitCropLayout
  extends CropLayout
{
  private boolean HEb;
  private boolean HEc;
  private float HEd;
  private View qeH;
  
  public DragExitCropLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164450);
    this.HEd = 1.0F;
    AppMethodBeat.o(164450);
  }
  
  public DragExitCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164451);
    this.HEd = 1.0F;
    AppMethodBeat.o(164451);
  }
  
  public DragExitCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164452);
    this.HEd = 1.0F;
    AppMethodBeat.o(164452);
  }
  
  public final void ai(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164449);
    k.h(paramMotionEvent, "e1");
    super.ai(paramMotionEvent);
    if (this.HEc)
    {
      paramMotionEvent = this.qeH;
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
    this.HEc = false;
    AppMethodBeat.o(164449);
  }
  
  public final View getBgView()
  {
    return this.qeH;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164448);
    k.h(paramMotionEvent1, "e1");
    k.h(paramMotionEvent2, "e2");
    if ((this.HEb) && (!this.HDq) && (!ffl()) && (paramMotionEvent1.getPointerCount() == 1) && (paramMotionEvent2.getPointerCount() == 1) && ((this.HEc) || (paramFloat2 < 0.0F)))
    {
      if (!this.HEc) {
        this.HEd = getContentViewScale()[0];
      }
      this.HEc = true;
      float f = (getContentRect().exactCenterY() - getVisibilityRect().centerY()) / (getVisibilityRect().height() / 2.0F);
      o((1.0F - 0.6F * f) * this.HEd / getContentViewScale()[0], getContentRect().exactCenterX(), getContentRect().exactCenterY());
      View localView = this.qeH;
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
    this.qeH = paramView;
  }
  
  public final void setEnableDragExit(boolean paramBoolean)
  {
    this.HEb = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.DragExitCropLayout
 * JD-Core Version:    0.7.0.1
 */