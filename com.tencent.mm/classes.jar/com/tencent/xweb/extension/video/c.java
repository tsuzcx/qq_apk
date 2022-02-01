package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.R.id;

public final class c
{
  float BpS;
  a aabV;
  boolean aabW;
  float aabX;
  float mProgress;
  ImageView pBZ;
  ImageView pCa;
  private ImageView pCb;
  ImageView pCr;
  
  public c(FrameLayout paramFrameLayout, a parama)
  {
    AppMethodBeat.i(153561);
    this.pCr = null;
    this.pCb = null;
    this.aabW = false;
    this.BpS = 0.0F;
    this.aabV = parama;
    this.pBZ = ((ImageView)paramFrameLayout.findViewById(R.id.player_progress_bar_front));
    this.pCr = ((ImageView)paramFrameLayout.findViewById(R.id.player_progress_bar_middle));
    this.pCa = ((ImageView)paramFrameLayout.findViewById(R.id.player_progress_bar_background));
    this.pCb = ((ImageView)paramFrameLayout.findViewById(R.id.player_progress_point));
    this.pCb.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        float f1 = 0.0F;
        AppMethodBeat.i(153560);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          c.this.aabW = false;
          c.this.BpS = paramAnonymousMotionEvent.getX();
          if (c.this.aabV != null) {
            c.this.aabV.aRo();
          }
          AppMethodBeat.o(153560);
          return true;
        }
        float f2;
        if (paramAnonymousMotionEvent.getAction() == 2)
        {
          f2 = paramAnonymousMotionEvent.getX();
          float f3 = c.this.pBZ.getWidth();
          f2 = (int)(f2 - c.this.BpS + f3);
          if (f2 >= 0.0F) {}
        }
        for (;;)
        {
          c.this.aabX = (f1 * 100.0F / c.this.pCa.getWidth());
          c.this.e(c.this.aabX, true);
          if (c.this.aabV != null) {
            c.this.aabV.aRo();
          }
          c.this.aabW = true;
          break;
          if (f2 > c.this.pCa.getWidth())
          {
            f1 = c.this.pCa.getWidth();
            continue;
            if ((c.this.aabW) && (c.this.aabV != null)) {
              c.this.aabV.dk(c.this.aabX);
            }
            c.this.aabW = false;
            break;
          }
          f1 = f2;
        }
      }
    });
    AppMethodBeat.o(153561);
  }
  
  public final void e(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(153562);
    if ((this.aabW) && (!paramBoolean))
    {
      AppMethodBeat.o(153562);
      return;
    }
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      this.mProgress = f;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCb.getLayoutParams();
      localLayoutParams.leftMargin = ((int)(f / 100.0F * this.pCa.getWidth() - this.pCb.getWidth() / 2));
      this.pCb.setLayoutParams(localLayoutParams);
      this.pCb.requestLayout();
      localLayoutParams = (FrameLayout.LayoutParams)this.pBZ.getLayoutParams();
      localLayoutParams.width = ((int)(f / 100.0F * this.pCa.getWidth()));
      this.pBZ.setLayoutParams(localLayoutParams);
      this.pBZ.requestLayout();
      AppMethodBeat.o(153562);
      return;
      f = paramFloat;
      if (paramFloat > 100.0F) {
        f = 100.0F;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aRo();
    
    public abstract void dk(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c
 * JD-Core Version:    0.7.0.1
 */