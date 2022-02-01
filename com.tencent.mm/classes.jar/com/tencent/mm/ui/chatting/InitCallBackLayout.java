package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InitCallBackLayout
  extends FrameLayout
{
  private at adKr;
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
      if (this.adKr != null) {
        this.adKr.fBx();
      }
    }
    AppMethodBeat.o(34834);
  }
  
  public void setListener(at paramat)
  {
    this.adKr = paramat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.InitCallBackLayout
 * JD-Core Version:    0.7.0.1
 */