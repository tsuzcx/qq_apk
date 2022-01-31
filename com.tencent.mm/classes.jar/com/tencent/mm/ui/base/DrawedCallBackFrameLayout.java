package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class DrawedCallBackFrameLayout
  extends FrameLayout
{
  private DrawedCallBackFrameLayout.a uSO;
  
  public DrawedCallBackFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      label5:
      if (this.uSO != null)
      {
        this.uSO.aXH();
        this.uSO = null;
      }
      return;
    }
    catch (Throwable paramCanvas)
    {
      break label5;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setListener(DrawedCallBackFrameLayout.a parama)
  {
    this.uSO = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.DrawedCallBackFrameLayout
 * JD-Core Version:    0.7.0.1
 */