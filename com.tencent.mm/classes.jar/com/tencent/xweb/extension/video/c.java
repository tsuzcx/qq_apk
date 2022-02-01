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
  a KAF;
  boolean KAG;
  float KAH;
  float aaZ;
  ImageView kUL;
  ImageView kUt;
  ImageView kUu;
  private ImageView kUv;
  float wWl;
  
  public c(FrameLayout paramFrameLayout, a parama)
  {
    AppMethodBeat.i(153561);
    this.kUL = null;
    this.kUv = null;
    this.KAG = false;
    this.wWl = 0.0F;
    this.KAF = parama;
    this.kUt = ((ImageView)paramFrameLayout.findViewById(2131303302));
    this.kUL = ((ImageView)paramFrameLayout.findViewById(2131303303));
    this.kUu = ((ImageView)paramFrameLayout.findViewById(2131303301));
    this.kUv = ((ImageView)paramFrameLayout.findViewById(2131303305));
    this.kUv.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        float f1 = 0.0F;
        AppMethodBeat.i(153560);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          c.this.KAG = false;
          c.this.wWl = paramAnonymousMotionEvent.getX();
          if (c.this.KAF != null) {
            c.this.KAF.anR();
          }
          AppMethodBeat.o(153560);
          return true;
        }
        float f2;
        if (paramAnonymousMotionEvent.getAction() == 2)
        {
          f2 = paramAnonymousMotionEvent.getX();
          float f3 = c.this.kUt.getWidth();
          f2 = (int)(f2 - c.this.wWl + f3);
          if (f2 >= 0.0F) {}
        }
        for (;;)
        {
          c.this.KAH = (f1 * 100.0F / c.this.kUu.getWidth());
          c.this.e(c.this.KAH, true);
          if (c.this.KAF != null) {
            c.this.KAF.anR();
          }
          c.this.KAG = true;
          break;
          if (f2 > c.this.kUu.getWidth())
          {
            f1 = c.this.kUu.getWidth();
            continue;
            if ((c.this.KAG) && (c.this.KAF != null)) {
              c.this.KAF.ch(c.this.KAH);
            }
            c.this.KAG = false;
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
    if ((this.KAG) && (!paramBoolean))
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
      this.aaZ = f;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kUv.getLayoutParams();
      localLayoutParams.leftMargin = ((int)(f / 100.0F * this.kUu.getWidth() - this.kUv.getWidth() / 2));
      this.kUv.setLayoutParams(localLayoutParams);
      this.kUv.requestLayout();
      localLayoutParams = (FrameLayout.LayoutParams)this.kUt.getLayoutParams();
      localLayoutParams.width = ((int)(f / 100.0F * this.kUu.getWidth()));
      this.kUt.setLayoutParams(localLayoutParams);
      this.kUt.requestLayout();
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
    public abstract void anR();
    
    public abstract void ch(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c
 * JD-Core Version:    0.7.0.1
 */