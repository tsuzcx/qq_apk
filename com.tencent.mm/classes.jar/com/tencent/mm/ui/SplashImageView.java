package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.ar;

public class SplashImageView
  extends ImageView
{
  private ar OLl;
  private boolean hasDrawed;
  
  public SplashImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33760);
    etg();
    AppMethodBeat.o(33760);
  }
  
  public SplashImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33761);
    etg();
    AppMethodBeat.o(33761);
  }
  
  public SplashImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33762);
    etg();
    AppMethodBeat.o(33762);
  }
  
  private void etg()
  {
    AppMethodBeat.i(33763);
    setBackgroundDrawable(getResources().getDrawable(2131235369));
    AppMethodBeat.o(33763);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33764);
    super.onDraw(paramCanvas);
    setBackgroundDrawable(getResources().getDrawable(2131235369));
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if (this.OLl != null) {
        this.OLl.dSa();
      }
    }
    AppMethodBeat.o(33764);
  }
  
  public void setOnDrawListener(ar paramar)
  {
    this.OLl = paramar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.SplashImageView
 * JD-Core Version:    0.7.0.1
 */