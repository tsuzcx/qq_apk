package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DrawedCallBackFrameLayout
  extends FrameLayout
{
  private DrawedCallBackFrameLayout.a zho;
  
  public DrawedCallBackFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106263);
    try
    {
      super.dispatchDraw(paramCanvas);
      label10:
      if (this.zho != null)
      {
        this.zho.bEm();
        this.zho = null;
      }
      AppMethodBeat.o(106263);
      return;
    }
    catch (Throwable paramCanvas)
    {
      break label10;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106262);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(106262);
  }
  
  public void setListener(DrawedCallBackFrameLayout.a parama)
  {
    this.zho = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.DrawedCallBackFrameLayout
 * JD-Core Version:    0.7.0.1
 */