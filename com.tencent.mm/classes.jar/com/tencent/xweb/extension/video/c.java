package com.tencent.xweb.extension.video;

import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import org.xwalk.core.R.id;

public final class c
{
  float St;
  ImageView gDX = null;
  ImageView ofo;
  ImageView ofp;
  private ImageView ofq = null;
  float vRH = 0.0F;
  a xhE;
  boolean xhF = false;
  float xhG;
  
  public c(FrameLayout paramFrameLayout, a parama)
  {
    this.xhE = parama;
    this.ofo = ((ImageView)paramFrameLayout.findViewById(R.id.player_progress_bar_front));
    this.gDX = ((ImageView)paramFrameLayout.findViewById(R.id.player_progress_bar_middle));
    this.ofp = ((ImageView)paramFrameLayout.findViewById(R.id.player_progress_bar_background));
    this.ofq = ((ImageView)paramFrameLayout.findViewById(R.id.player_progress_point));
    this.ofq.setOnTouchListener(new c.1(this));
  }
  
  public final void c(float paramFloat, boolean paramBoolean)
  {
    if ((this.xhF) && (!paramBoolean)) {
      return;
    }
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      this.St = f;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ofq.getLayoutParams();
      localLayoutParams.leftMargin = ((int)(f / 100.0F * this.ofp.getWidth() - this.ofq.getWidth() / 2));
      this.ofq.setLayoutParams(localLayoutParams);
      this.ofq.requestLayout();
      localLayoutParams = (FrameLayout.LayoutParams)this.ofo.getLayoutParams();
      localLayoutParams.width = ((int)(f / 100.0F * this.ofp.getWidth()));
      this.ofo.setLayoutParams(localLayoutParams);
      this.ofo.requestLayout();
      return;
      f = paramFloat;
      if (paramFloat > 100.0F) {
        f = 100.0F;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aT(float paramFloat);
    
    public abstract void akz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c
 * JD-Core Version:    0.7.0.1
 */