package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.ui.chatting.at;

public class SplashImageView
  extends ImageView
{
  private at adKr;
  private boolean hasDrawed;
  
  public SplashImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33760);
    gmt();
    AppMethodBeat.o(33760);
  }
  
  public SplashImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33761);
    gmt();
    AppMethodBeat.o(33761);
  }
  
  public SplashImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33762);
    gmt();
    AppMethodBeat.o(33762);
  }
  
  private void gmt()
  {
    AppMethodBeat.i(33763);
    setBackgroundDrawable(getResources().getDrawable(R.g.ui_loading));
    AppMethodBeat.o(33763);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33764);
    super.onDraw(paramCanvas);
    setBackgroundDrawable(getResources().getDrawable(R.g.ui_loading));
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if (this.adKr != null) {
        this.adKr.fBx();
      }
    }
    AppMethodBeat.o(33764);
  }
  
  public void setOnDrawListener(at paramat)
  {
    this.adKr = paramat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.SplashImageView
 * JD-Core Version:    0.7.0.1
 */