package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DrawedCallBackFrameLayout
  extends FrameLayout
{
  private a adOk;
  
  public DrawedCallBackFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141624);
    try
    {
      super.dispatchDraw(paramCanvas);
      label10:
      if (this.adOk != null)
      {
        this.adOk.fBx();
        this.adOk = null;
      }
      AppMethodBeat.o(141624);
      return;
    }
    finally
    {
      break label10;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141623);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141623);
  }
  
  public void setListener(a parama)
  {
    this.adOk = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fBx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.DrawedCallBackFrameLayout
 * JD-Core Version:    0.7.0.1
 */