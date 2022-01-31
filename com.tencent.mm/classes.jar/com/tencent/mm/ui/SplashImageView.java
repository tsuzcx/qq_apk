package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.ao;

public class SplashImageView
  extends ImageView
{
  private boolean hasDrawed;
  private ao zfl;
  
  public SplashImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(29908);
    setImageResource(2130840935);
    AppMethodBeat.o(29908);
  }
  
  public SplashImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29909);
    setImageResource(2130840935);
    AppMethodBeat.o(29909);
  }
  
  public SplashImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29910);
    setImageResource(2130840935);
    AppMethodBeat.o(29910);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(29911);
    super.onDraw(paramCanvas);
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if (this.zfl != null) {
        this.zfl.bEm();
      }
    }
    AppMethodBeat.o(29911);
  }
  
  public void setOnDrawListener(ao paramao)
  {
    this.zfl = paramao;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.SplashImageView
 * JD-Core Version:    0.7.0.1
 */