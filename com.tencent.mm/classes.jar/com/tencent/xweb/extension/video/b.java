package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.R.id;

public final class b
{
  a aigt;
  boolean aigu;
  float aigv;
  float mProgress;
  float puO;
  ImageView sHD;
  ImageView sHm;
  ImageView sHn;
  private ImageView sHo;
  
  public b(View paramView)
  {
    AppMethodBeat.i(212752);
    this.sHm = ((ImageView)paramView.findViewById(R.id.player_progress_bar_front));
    this.sHD = ((ImageView)paramView.findViewById(R.id.player_progress_bar_middle));
    this.sHn = ((ImageView)paramView.findViewById(R.id.player_progress_bar_background));
    this.sHo = ((ImageView)paramView.findViewById(R.id.player_progress_point));
    this.sHo.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        float f1 = 0.0F;
        AppMethodBeat.i(153560);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          b.this.aigu = false;
          b.this.puO = paramAnonymousMotionEvent.getX();
          if (b.this.aigt != null) {
            b.this.aigt.blc();
          }
          AppMethodBeat.o(153560);
          return true;
        }
        float f2;
        if (paramAnonymousMotionEvent.getAction() == 2)
        {
          f2 = paramAnonymousMotionEvent.getX();
          float f3 = b.this.sHm.getWidth();
          f2 = f2 - b.this.puO + f3;
          if (f2 >= 0.0F) {}
        }
        for (;;)
        {
          b.this.aigv = (f1 * 100.0F / b.this.sHn.getWidth());
          b.this.h(b.this.aigv, true);
          if (b.this.aigt != null) {
            b.this.aigt.blc();
          }
          b.this.aigu = true;
          break;
          if (f2 > b.this.sHn.getWidth())
          {
            f1 = b.this.sHn.getWidth();
            continue;
            if ((b.this.aigu) && (b.this.aigt != null)) {
              b.this.aigt.eG(b.this.aigv);
            }
            b.this.aigu = false;
            break;
          }
          f1 = f2;
        }
      }
    });
    AppMethodBeat.o(212752);
  }
  
  public final void h(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(153562);
    if ((this.aigu) && (!paramBoolean))
    {
      AppMethodBeat.o(153562);
      return;
    }
    if (this.sHo == null)
    {
      AppMethodBeat.o(153562);
      return;
    }
    if (this.sHn.getWidth() == 0)
    {
      AppMethodBeat.o(153562);
      return;
    }
    float f;
    FrameLayout.LayoutParams localLayoutParams;
    int i;
    if (paramFloat < 0.0F)
    {
      f = 0.0F;
      this.mProgress = f;
      localLayoutParams = (FrameLayout.LayoutParams)this.sHm.getLayoutParams();
      localLayoutParams.width = ((int)(f / 100.0F * this.sHn.getWidth()));
      this.sHm.setLayoutParams(localLayoutParams);
      this.sHm.requestLayout();
      localLayoutParams = (FrameLayout.LayoutParams)this.sHo.getLayoutParams();
      i = this.sHn.getWidth();
      if (f > 0.0F) {
        break label185;
      }
      i = 0;
    }
    for (;;)
    {
      localLayoutParams.leftMargin = i;
      this.sHo.setLayoutParams(localLayoutParams);
      this.sHo.requestLayout();
      AppMethodBeat.o(153562);
      return;
      f = paramFloat;
      if (paramFloat <= 100.0F) {
        break;
      }
      f = 100.0F;
      break;
      label185:
      if (f >= 100.0F) {
        i -= (this.sHo.getWidth() - this.sHo.getPaddingLeft() - this.sHo.getPaddingRight()) / 2;
      } else {
        i = (int)(f / 100.0F * (i - (this.sHo.getWidth() - this.sHo.getPaddingLeft() - this.sHo.getPaddingRight()) / 2));
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void blc();
    
    public abstract void eG(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.xweb.extension.video.b
 * JD-Core Version:    0.7.0.1
 */