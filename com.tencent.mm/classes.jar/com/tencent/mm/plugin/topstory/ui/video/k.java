package com.tencent.mm.plugin.topstory.ui.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  int JT;
  float klO;
  View ktX;
  private GestureDetector ktZ;
  private float kub;
  int kuc;
  int kud;
  Runnable kue;
  Context mContext;
  a yPE;
  c yPF;
  boolean yPG;
  boolean yPH;
  
  public k(Context paramContext, View paramView, c paramc)
  {
    AppMethodBeat.i(126104);
    this.yPE = a.yPJ;
    this.klO = 0.0F;
    this.JT = 0;
    this.kub = 0.0F;
    this.kuc = -1;
    this.kud = 0;
    this.kue = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126097);
        k.this.yPF.bcn();
        AppMethodBeat.o(126097);
      }
    };
    this.mContext = paramContext;
    this.yPF = paramc;
    this.ktX = paramView;
    this.ktZ = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(126099);
        k.this.ktX.removeCallbacks(k.this.kue);
        k.this.yPF.bco();
        AppMethodBeat.o(126099);
        return true;
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f1 = 1.0F;
        float f2 = 0.0F;
        AppMethodBeat.i(126100);
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null))
        {
          AppMethodBeat.o(126100);
          return true;
        }
        if (k.this.yPE == k.a.yPJ)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label153;
          }
          k.this.yPE = k.a.yPM;
        }
        float f3;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f3 = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = k.this;
          if (paramAnonymousMotionEvent1.yPE != k.a.yPM) {
            break;
          }
          if (paramAnonymousMotionEvent1.kuc == -1)
          {
            paramAnonymousMotionEvent1.yPF.bcp();
            paramAnonymousMotionEvent1.kuc = paramAnonymousMotionEvent1.yPF.getCurrentPosition();
          }
          paramAnonymousMotionEvent1.kud = paramAnonymousMotionEvent1.yPF.by(paramAnonymousFloat1 - paramAnonymousFloat2);
          AppMethodBeat.o(126100);
          return true;
          label153:
          if (paramAnonymousMotionEvent1.getX() < k.this.ktX.getMeasuredWidth() / 2) {
            k.this.yPE = k.a.yPL;
          } else {
            k.this.yPE = k.a.yPK;
          }
        }
        if ((paramAnonymousMotionEvent1.yPE == k.a.yPL) && (paramAnonymousMotionEvent1.yPH))
        {
          paramAnonymousFloat1 = f3 * -1.0F / paramAnonymousMotionEvent1.ktX.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.klO;
          if (paramAnonymousFloat1 < 0.0F) {
            paramAnonymousFloat1 = f2;
          }
        }
        label317:
        label486:
        label489:
        for (;;)
        {
          paramAnonymousMotionEvent1 = paramAnonymousMotionEvent1.mContext;
          if ((paramAnonymousMotionEvent1 instanceof Activity))
          {
            if (paramAnonymousFloat1 >= 0.01F) {
              break label317;
            }
            paramAnonymousFloat2 = 0.01F;
          }
          for (;;)
          {
            paramAnonymousMotionEvent1 = (Activity)paramAnonymousMotionEvent1;
            paramAnonymousMotionEvent2 = paramAnonymousMotionEvent1.getWindow().getAttributes();
            paramAnonymousMotionEvent2.screenBrightness = paramAnonymousFloat2;
            paramAnonymousMotionEvent1.getWindow().setAttributes(paramAnonymousMotionEvent2);
            AppMethodBeat.o(126100);
            return true;
            if (paramAnonymousFloat1 <= 1.0F) {
              break label489;
            }
            paramAnonymousFloat1 = 1.0F;
            break;
            paramAnonymousFloat2 = f1;
            if (paramAnonymousFloat1 <= 1.0F) {
              paramAnonymousFloat2 = paramAnonymousFloat1;
            }
          }
          if ((paramAnonymousMotionEvent1.yPE != k.a.yPK) || (!paramAnonymousMotionEvent1.yPG)) {
            break;
          }
          paramAnonymousFloat1 = f3 * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.ktX.getMeasuredHeight();
          paramAnonymousMotionEvent2 = (AudioManager)paramAnonymousMotionEvent1.mContext.getSystemService("audio");
          int j = paramAnonymousMotionEvent2.getStreamMaxVolume(3);
          paramAnonymousFloat2 = 1.2F * (paramAnonymousFloat2 * j);
          int i = (int)paramAnonymousFloat2;
          if ((i == 0) && (Math.abs(paramAnonymousFloat2) > 0.2F)) {
            if (paramAnonymousFloat1 > 0.0F) {
              i = 1;
            }
          }
          for (;;)
          {
            int k = i + paramAnonymousMotionEvent1.JT;
            if (k < 0) {
              i = 0;
            }
            for (;;)
            {
              com.tencent.mm.compatible.b.a.b(paramAnonymousMotionEvent2, 3, i);
              break;
              if (paramAnonymousFloat1 >= 0.0F) {
                break label486;
              }
              i = -1;
              break label429;
              i = k;
              if (k >= j) {
                i = j;
              }
            }
          }
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(126098);
        k.this.ktX.postDelayed(k.this.kue, 200L);
        AppMethodBeat.o(126098);
        return true;
      }
    });
    this.klO = com.tencent.mm.plugin.websearch.ui.a.dp(paramContext);
    AppMethodBeat.o(126104);
  }
  
  public final void A(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126105);
    if (!this.yPF.dOY())
    {
      this.yPE = a.yPJ;
      AppMethodBeat.o(126105);
      return;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.kub = paramMotionEvent.getRawX();
      this.JT = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
      this.klO = com.tencent.mm.plugin.websearch.ui.a.dp(this.mContext);
    }
    this.ktZ.onTouchEvent(paramMotionEvent);
    if ((i == 1) || (i == 3))
    {
      if (this.yPE != a.yPM) {
        break label157;
      }
      c localc = this.yPF;
      i = this.kud;
      paramMotionEvent.getRawX();
      localc.Pk(i);
      this.kuc = -1;
      this.kud = 0;
      this.kub = 0.0F;
    }
    for (;;)
    {
      this.yPE = a.yPJ;
      AppMethodBeat.o(126105);
      return;
      label157:
      if (this.yPE == a.yPK) {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
      } else {
        paramMotionEvent = a.yPL;
      }
    }
  }
  
  public final void bee()
  {
    this.kuc = -1;
    this.kud = 0;
    this.kub = 0.0F;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(126103);
      yPJ = new a("None", 0);
      yPK = new a("Volume", 1);
      yPL = new a("Brightness", 2);
      yPM = new a("FastBackwardOrForward", 3);
      yPN = new a[] { yPJ, yPK, yPL, yPM };
      AppMethodBeat.o(126103);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.k
 * JD-Core Version:    0.7.0.1
 */