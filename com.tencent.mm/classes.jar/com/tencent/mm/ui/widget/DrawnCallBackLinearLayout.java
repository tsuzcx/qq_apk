package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class DrawnCallBackLinearLayout
  extends LinearLayout
{
  public final boolean DEBUG = true;
  public final String TAG = "MicroMsg.TestTimeForChatting";
  private DrawnCallBackLinearLayout.a wuT;
  private b xvN;
  
  public DrawnCallBackLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DrawnCallBackLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public DrawnCallBackLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.wuT != null)
    {
      this.wuT.cVv();
      this.wuT = null;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.xvN != null)
    {
      this.xvN.bIG();
      this.xvN = null;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setListener(DrawnCallBackLinearLayout.a parama)
  {
    this.wuT = parama;
  }
  
  public void setTouchedCallback(b paramb)
  {
    this.xvN = paramb;
  }
  
  public static abstract interface b
  {
    public abstract void bIG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.DrawnCallBackLinearLayout
 * JD-Core Version:    0.7.0.1
 */