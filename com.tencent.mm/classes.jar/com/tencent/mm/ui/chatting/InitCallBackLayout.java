package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InitCallBackLayout
  extends FrameLayout
{
  private ar OLl;
  private boolean hasDrawed;
  
  public InitCallBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(34834);
    super.onDraw(paramCanvas);
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if (this.OLl != null) {
        this.OLl.dSa();
      }
    }
    AppMethodBeat.o(34834);
  }
  
  public void setListener(ar paramar)
  {
    this.OLl = paramar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.InitCallBackLayout
 * JD-Core Version:    0.7.0.1
 */