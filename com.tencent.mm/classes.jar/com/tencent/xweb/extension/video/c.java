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
  a MOe;
  boolean MOf;
  float MOg;
  ImageView lvR;
  ImageView lvS;
  private ImageView lvT;
  ImageView lwj;
  float mProgress;
  float yzV;
  
  public c(FrameLayout paramFrameLayout, a parama)
  {
    AppMethodBeat.i(153561);
    this.lwj = null;
    this.lvT = null;
    this.MOf = false;
    this.yzV = 0.0F;
    this.MOe = parama;
    this.lvR = ((ImageView)paramFrameLayout.findViewById(2131303302));
    this.lwj = ((ImageView)paramFrameLayout.findViewById(2131303303));
    this.lvS = ((ImageView)paramFrameLayout.findViewById(2131303301));
    this.lvT = ((ImageView)paramFrameLayout.findViewById(2131303305));
    this.lvT.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(153560);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/xweb/extension/video/VideoPlayerSeekBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          c.this.MOf = false;
          c.this.yzV = paramAnonymousMotionEvent.getX();
          if (c.this.MOe != null) {
            c.this.MOe.aqS();
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
            float f2 = c.this.lvR.getWidth();
            f2 = (int)(f1 - c.this.yzV + f2);
            if (f2 < 0.0F) {
              f1 = 0.0F;
            }
            for (;;)
            {
              c.this.MOg = (f1 * 100.0F / c.this.lvS.getWidth());
              c.this.e(c.this.MOg, true);
              if (c.this.MOe != null) {
                c.this.MOe.aqS();
              }
              c.this.MOf = true;
              break;
              f1 = f2;
              if (f2 > c.this.lvS.getWidth()) {
                f1 = c.this.lvS.getWidth();
              }
            }
          }
          if ((c.this.MOf) && (c.this.MOe != null)) {
            c.this.MOe.ck(c.this.MOg);
          }
          c.this.MOf = false;
        }
      }
    });
    AppMethodBeat.o(153561);
  }
  
  public final void e(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(153562);
    if ((this.MOf) && (!paramBoolean))
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lvT.getLayoutParams();
      localLayoutParams.leftMargin = ((int)(f / 100.0F * this.lvS.getWidth() - this.lvT.getWidth() / 2));
      this.lvT.setLayoutParams(localLayoutParams);
      this.lvT.requestLayout();
      localLayoutParams = (FrameLayout.LayoutParams)this.lvR.getLayoutParams();
      localLayoutParams.width = ((int)(f / 100.0F * this.lvS.getWidth()));
      this.lvR.setLayoutParams(localLayoutParams);
      this.lvR.requestLayout();
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
    public abstract void aqS();
    
    public abstract void ck(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c
 * JD-Core Version:    0.7.0.1
 */