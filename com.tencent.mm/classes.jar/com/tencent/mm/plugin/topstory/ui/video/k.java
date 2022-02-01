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
  a Adv;
  c Adw;
  boolean Adx;
  boolean Ady;
  int KO;
  float kNg;
  View kVm;
  private GestureDetector kVo;
  private float kVq;
  int kVr;
  int kVs;
  Runnable kVt;
  Context mContext;
  
  public k(Context paramContext, View paramView, c paramc)
  {
    AppMethodBeat.i(126104);
    this.Adv = a.AdA;
    this.kNg = 0.0F;
    this.KO = 0;
    this.kVq = 0.0F;
    this.kVr = -1;
    this.kVs = 0;
    this.kVt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126097);
        k.this.Adw.bjj();
        AppMethodBeat.o(126097);
      }
    };
    this.mContext = paramContext;
    this.Adw = paramc;
    this.kVm = paramView;
    this.kVo = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(126099);
        k.this.kVm.removeCallbacks(k.this.kVt);
        k.this.Adw.bjk();
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
        if (k.this.Adv == k.a.AdA)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label153;
          }
          k.this.Adv = k.a.AdD;
        }
        float f3;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f3 = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = k.this;
          if (paramAnonymousMotionEvent1.Adv != k.a.AdD) {
            break;
          }
          if (paramAnonymousMotionEvent1.kVr == -1)
          {
            paramAnonymousMotionEvent1.Adw.bjl();
            paramAnonymousMotionEvent1.kVr = paramAnonymousMotionEvent1.Adw.getCurrentPosition();
          }
          paramAnonymousMotionEvent1.kVs = paramAnonymousMotionEvent1.Adw.bG(paramAnonymousFloat1 - paramAnonymousFloat2);
          AppMethodBeat.o(126100);
          return true;
          label153:
          if (paramAnonymousMotionEvent1.getX() < k.this.kVm.getMeasuredWidth() / 2) {
            k.this.Adv = k.a.AdC;
          } else {
            k.this.Adv = k.a.AdB;
          }
        }
        if ((paramAnonymousMotionEvent1.Adv == k.a.AdC) && (paramAnonymousMotionEvent1.Ady))
        {
          paramAnonymousFloat1 = f3 * -1.0F / paramAnonymousMotionEvent1.kVm.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.kNg;
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
          if ((paramAnonymousMotionEvent1.Adv != k.a.AdB) || (!paramAnonymousMotionEvent1.Adx)) {
            break;
          }
          paramAnonymousFloat1 = f3 * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.kVm.getMeasuredHeight();
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
            int k = i + paramAnonymousMotionEvent1.KO;
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
        k.this.kVm.postDelayed(k.this.kVt, 200L);
        AppMethodBeat.o(126098);
        return true;
      }
    });
    this.kNg = com.tencent.mm.plugin.websearch.ui.a.dy(paramContext);
    AppMethodBeat.o(126104);
  }
  
  public final void bkY()
  {
    this.kVr = -1;
    this.kVs = 0;
    this.kVq = 0.0F;
  }
  
  public final void y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126105);
    if (!this.Adw.edy())
    {
      this.Adv = a.AdA;
      AppMethodBeat.o(126105);
      return;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.kVq = paramMotionEvent.getRawX();
      this.KO = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
      this.kNg = com.tencent.mm.plugin.websearch.ui.a.dy(this.mContext);
    }
    this.kVo.onTouchEvent(paramMotionEvent);
    if ((i == 1) || (i == 3))
    {
      if (this.Adv != a.AdD) {
        break label157;
      }
      c localc = this.Adw;
      i = this.kVs;
      paramMotionEvent.getRawX();
      localc.Rq(i);
      this.kVr = -1;
      this.kVs = 0;
      this.kVq = 0.0F;
    }
    for (;;)
    {
      this.Adv = a.AdA;
      AppMethodBeat.o(126105);
      return;
      label157:
      if (this.Adv == a.AdB) {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
      } else {
        paramMotionEvent = a.AdC;
      }
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(126103);
      AdA = new a("None", 0);
      AdB = new a("Volume", 1);
      AdC = new a("Brightness", 2);
      AdD = new a("FastBackwardOrForward", 3);
      AdE = new a[] { AdA, AdB, AdC, AdD };
      AppMethodBeat.o(126103);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.k
 * JD-Core Version:    0.7.0.1
 */