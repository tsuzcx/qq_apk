package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.R.g;
import com.tencent.mm.ui.chatting.ar;

public class SplashImageView
  extends ImageView
{
  private boolean hasDrawed;
  private ar uQZ;
  
  public SplashImageView(Context paramContext)
  {
    super(paramContext);
    setImageResource(R.g.welcome_bg);
  }
  
  public SplashImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setImageResource(R.g.welcome_bg);
  }
  
  public SplashImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setImageResource(R.g.welcome_bg);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if (this.uQZ != null) {
        this.uQZ.aXH();
      }
    }
  }
  
  public void setOnDrawListener(ar paramar)
  {
    this.uQZ = paramar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.SplashImageView
 * JD-Core Version:    0.7.0.1
 */