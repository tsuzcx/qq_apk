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
  a IOj;
  boolean IOk;
  float IOl;
  float aae;
  ImageView kte;
  ImageView ktf;
  private ImageView ktg;
  ImageView ktw;
  float vLY;
  
  public c(FrameLayout paramFrameLayout, a parama)
  {
    AppMethodBeat.i(153561);
    this.ktw = null;
    this.ktg = null;
    this.IOk = false;
    this.vLY = 0.0F;
    this.IOj = parama;
    this.kte = ((ImageView)paramFrameLayout.findViewById(2131303302));
    this.ktw = ((ImageView)paramFrameLayout.findViewById(2131303303));
    this.ktf = ((ImageView)paramFrameLayout.findViewById(2131303301));
    this.ktg = ((ImageView)paramFrameLayout.findViewById(2131303305));
    this.ktg.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        float f1 = 0.0F;
        AppMethodBeat.i(153560);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          c.this.IOk = false;
          c.this.vLY = paramAnonymousMotionEvent.getX();
          if (c.this.IOj != null) {
            c.this.IOj.bcv();
          }
          AppMethodBeat.o(153560);
          return true;
        }
        float f2;
        if (paramAnonymousMotionEvent.getAction() == 2)
        {
          f2 = paramAnonymousMotionEvent.getX();
          float f3 = c.this.kte.getWidth();
          f2 = (int)(f2 - c.this.vLY + f3);
          if (f2 >= 0.0F) {}
        }
        for (;;)
        {
          c.this.IOl = (f1 * 100.0F / c.this.ktf.getWidth());
          c.this.e(c.this.IOl, true);
          if (c.this.IOj != null) {
            c.this.IOj.bcv();
          }
          c.this.IOk = true;
          break;
          if (f2 > c.this.ktf.getWidth())
          {
            f1 = c.this.ktf.getWidth();
            continue;
            if ((c.this.IOk) && (c.this.IOj != null)) {
              c.this.IOj.bS(c.this.IOl);
            }
            c.this.IOk = false;
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
    if ((this.IOk) && (!paramBoolean))
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
      this.aae = f;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ktg.getLayoutParams();
      localLayoutParams.leftMargin = ((int)(f / 100.0F * this.ktf.getWidth() - this.ktg.getWidth() / 2));
      this.ktg.setLayoutParams(localLayoutParams);
      this.ktg.requestLayout();
      localLayoutParams = (FrameLayout.LayoutParams)this.kte.getLayoutParams();
      localLayoutParams.width = ((int)(f / 100.0F * this.ktf.getWidth()));
      this.kte.setLayoutParams(localLayoutParams);
      this.kte.requestLayout();
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
    public abstract void bS(float paramFloat);
    
    public abstract void bcv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c
 * JD-Core Version:    0.7.0.1
 */