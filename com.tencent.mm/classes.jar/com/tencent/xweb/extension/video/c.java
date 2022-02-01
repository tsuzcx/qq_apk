package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class c
{
  a Mra;
  boolean Mrb;
  float Mrc;
  ImageView lrJ;
  ImageView lrr;
  ImageView lrs;
  private ImageView lrt;
  float mProgress;
  float yjW;
  
  public c(FrameLayout paramFrameLayout, a parama)
  {
    AppMethodBeat.i(153561);
    this.lrJ = null;
    this.lrt = null;
    this.Mrb = false;
    this.yjW = 0.0F;
    this.Mra = parama;
    this.lrr = ((ImageView)paramFrameLayout.findViewById(2131303302));
    this.lrJ = ((ImageView)paramFrameLayout.findViewById(2131303303));
    this.lrs = ((ImageView)paramFrameLayout.findViewById(2131303301));
    this.lrt = ((ImageView)paramFrameLayout.findViewById(2131303305));
    this.lrt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(153560);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/xweb/extension/video/VideoPlayerSeekBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          c.this.Mrb = false;
          c.this.yjW = paramAnonymousMotionEvent.getX();
          if (c.this.Mra != null) {
            c.this.Mra.aqD();
          }
        }
        for (;;)
        {
          a.a(true, this, "com/tencent/xweb/extension/video/VideoPlayerSeekBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(153560);
          return true;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = c.this.lrr.getWidth();
            f2 = (int)(f1 - c.this.yjW + f2);
            if (f2 < 0.0F) {
              f1 = 0.0F;
            }
            for (;;)
            {
              c.this.Mrc = (f1 * 100.0F / c.this.lrs.getWidth());
              c.this.e(c.this.Mrc, true);
              if (c.this.Mra != null) {
                c.this.Mra.aqD();
              }
              c.this.Mrb = true;
              break;
              f1 = f2;
              if (f2 > c.this.lrs.getWidth()) {
                f1 = c.this.lrs.getWidth();
              }
            }
          }
          if ((c.this.Mrb) && (c.this.Mra != null)) {
            c.this.Mra.cm(c.this.Mrc);
          }
          c.this.Mrb = false;
        }
      }
    });
    AppMethodBeat.o(153561);
  }
  
  public final void e(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(153562);
    if ((this.Mrb) && (!paramBoolean))
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrt.getLayoutParams();
      localLayoutParams.leftMargin = ((int)(f / 100.0F * this.lrs.getWidth() - this.lrt.getWidth() / 2));
      this.lrt.setLayoutParams(localLayoutParams);
      this.lrt.requestLayout();
      localLayoutParams = (FrameLayout.LayoutParams)this.lrr.getLayoutParams();
      localLayoutParams.width = ((int)(f / 100.0F * this.lrs.getWidth()));
      this.lrr.setLayoutParams(localLayoutParams);
      this.lrr.requestLayout();
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
    public abstract void aqD();
    
    public abstract void cm(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c
 * JD-Core Version:    0.7.0.1
 */