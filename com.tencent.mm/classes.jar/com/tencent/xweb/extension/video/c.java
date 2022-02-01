package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  float CBd;
  a SBa;
  boolean SBb;
  float SBc;
  ImageView mCM;
  ImageView mCN;
  private ImageView mCO;
  ImageView mDf;
  float mProgress;
  
  public c(FrameLayout paramFrameLayout, a parama)
  {
    AppMethodBeat.i(153561);
    this.mDf = null;
    this.mCO = null;
    this.SBb = false;
    this.CBd = 0.0F;
    this.SBa = parama;
    this.mCM = ((ImageView)paramFrameLayout.findViewById(2131305975));
    this.mDf = ((ImageView)paramFrameLayout.findViewById(2131305976));
    this.mCN = ((ImageView)paramFrameLayout.findViewById(2131305974));
    this.mCO = ((ImageView)paramFrameLayout.findViewById(2131305978));
    this.mCO.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        float f1 = 0.0F;
        AppMethodBeat.i(153560);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          c.this.SBb = false;
          c.this.CBd = paramAnonymousMotionEvent.getX();
          if (c.this.SBa != null) {
            c.this.SBa.aJq();
          }
          AppMethodBeat.o(153560);
          return true;
        }
        float f2;
        if (paramAnonymousMotionEvent.getAction() == 2)
        {
          f2 = paramAnonymousMotionEvent.getX();
          float f3 = c.this.mCM.getWidth();
          f2 = (int)(f2 - c.this.CBd + f3);
          if (f2 >= 0.0F) {}
        }
        for (;;)
        {
          c.this.SBc = (f1 * 100.0F / c.this.mCN.getWidth());
          c.this.e(c.this.SBc, true);
          if (c.this.SBa != null) {
            c.this.SBa.aJq();
          }
          c.this.SBb = true;
          break;
          if (f2 > c.this.mCN.getWidth())
          {
            f1 = c.this.mCN.getWidth();
            continue;
            if ((c.this.SBb) && (c.this.SBa != null)) {
              c.this.SBa.cP(c.this.SBc);
            }
            c.this.SBb = false;
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
    if ((this.SBb) && (!paramBoolean))
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCO.getLayoutParams();
      localLayoutParams.leftMargin = ((int)(f / 100.0F * this.mCN.getWidth() - this.mCO.getWidth() / 2));
      this.mCO.setLayoutParams(localLayoutParams);
      this.mCO.requestLayout();
      localLayoutParams = (FrameLayout.LayoutParams)this.mCM.getLayoutParams();
      localLayoutParams.width = ((int)(f / 100.0F * this.mCN.getWidth()));
      this.mCM.setLayoutParams(localLayoutParams);
      this.mCM.requestLayout();
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
    public abstract void aJq();
    
    public abstract void cP(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c
 * JD-Core Version:    0.7.0.1
 */