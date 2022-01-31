package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InitCallBackLayout
  extends FrameLayout
{
  private boolean hasDrawed;
  private ao zfl;
  
  public InitCallBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(30954);
    super.onDraw(paramCanvas);
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if (this.zfl != null) {
        this.zfl.bEm();
      }
    }
    AppMethodBeat.o(30954);
  }
  
  public void setListener(ao paramao)
  {
    this.zfl = paramao;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.InitCallBackLayout
 * JD-Core Version:    0.7.0.1
 */