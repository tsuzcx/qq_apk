package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout;", "Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderView", "Landroid/view/View;", "getBorderView", "()Landroid/view/View;", "setBorderView", "(Landroid/view/View;)V", "isHasBorder", "", "()Z", "setHasBorder", "(Z)V", "onBorderVisibilityCallback", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "getOnBorderVisibilityCallback", "()Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "setOnBorderVisibilityCallback", "(Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;)V", "dismissBorder", "", "onDown", "e", "Landroid/view/MotionEvent;", "onTouchCancel", "e1", "showBorder", "Companion", "OnBorderVisibilityCallback", "libmmui_release"})
public abstract class BaseCropLayout
  extends TouchEventLayout
{
  public static final BaseCropLayout.a Jdy = new BaseCropLayout.a((byte)0);
  private boolean Jdv = true;
  private View Jdw;
  private b Jdx;
  
  public BaseCropLayout(Context paramContext)
  {
    super(paramContext);
    setOnTouchListener((View.OnTouchListener)this);
  }
  
  public BaseCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnTouchListener((View.OnTouchListener)this);
  }
  
  public BaseCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnTouchListener((View.OnTouchListener)this);
  }
  
  public void ai(MotionEvent paramMotionEvent)
  {
    k.h(paramMotionEvent, "e1");
    if ((this.Jdv) && (this.Jdv))
    {
      paramMotionEvent = this.Jdx;
      if (paramMotionEvent != null) {
        paramMotionEvent.onDismiss();
      }
      paramMotionEvent = this.Jdw;
      if (paramMotionEvent != null) {
        paramMotionEvent.setAlpha(1.0F);
      }
      paramMotionEvent = this.Jdw;
      if (paramMotionEvent != null)
      {
        paramMotionEvent = paramMotionEvent.animate();
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.alpha(0.0F);
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.setDuration(300L);
            if (paramMotionEvent != null)
            {
              paramMotionEvent = paramMotionEvent.setStartDelay(1000L);
              if (paramMotionEvent != null) {
                paramMotionEvent.start();
              }
            }
          }
        }
      }
    }
  }
  
  public final View getBorderView()
  {
    return this.Jdw;
  }
  
  public final b getOnBorderVisibilityCallback()
  {
    return this.Jdx;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((this.Jdv) && (this.Jdv))
    {
      Object localObject = this.Jdx;
      if (localObject != null) {
        ((b)localObject).onShow();
      }
      localObject = this.Jdw;
      if (localObject != null)
      {
        localObject = ((View)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setStartDelay(0L);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
      }
    }
    return super.onDown(paramMotionEvent);
  }
  
  public final void setBorderView(View paramView)
  {
    this.Jdw = paramView;
  }
  
  public final void setHasBorder(boolean paramBoolean)
  {
    this.Jdv = paramBoolean;
  }
  
  public final void setOnBorderVisibilityCallback(b paramb)
  {
    this.Jdx = paramb;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "", "onDismiss", "", "onShow", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void onDismiss();
    
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.BaseCropLayout
 * JD-Core Version:    0.7.0.1
 */