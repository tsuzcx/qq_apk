package com.tencent.mm.plugin.webview.fts.ui;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.c.c;

public final class a
{
  a APW;
  b APX;
  int JT;
  float klO;
  View ktX;
  GestureDetector ktZ;
  float kub;
  int kuc;
  int kud;
  Runnable kue;
  Context mContext;
  
  public a(Context paramContext, View paramView, b paramb)
  {
    AppMethodBeat.i(78035);
    this.APW = a.APZ;
    this.klO = 0.0F;
    this.JT = 0;
    this.kub = 0.0F;
    this.kuc = -1;
    this.kud = 0;
    this.kue = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78028);
        a.this.APX.bcn();
        AppMethodBeat.o(78028);
      }
    };
    this.mContext = paramContext;
    this.APX = paramb;
    this.ktX = paramView;
    this.ktZ = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(78030);
        a.this.ktX.removeCallbacks(a.this.kue);
        a.this.APX.bco();
        AppMethodBeat.o(78030);
        return true;
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f1 = 1.0F;
        float f2 = 0.0F;
        AppMethodBeat.i(78031);
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null))
        {
          AppMethodBeat.o(78031);
          return true;
        }
        if (a.this.APW == a.a.APZ)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label157;
          }
          a.this.APW = a.a.AQc;
        }
        float f3;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f3 = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = a.this;
          if (paramAnonymousMotionEvent1.APW != a.a.AQc) {
            break;
          }
          if (paramAnonymousMotionEvent1.kuc == -1)
          {
            paramAnonymousMotionEvent1.APX.bcp();
            paramAnonymousMotionEvent1.kuc = paramAnonymousMotionEvent1.APX.getCurrentPosition();
          }
          paramAnonymousMotionEvent1.kud = paramAnonymousMotionEvent1.APX.j(paramAnonymousMotionEvent1.kuc, paramAnonymousFloat1 - paramAnonymousFloat2);
          AppMethodBeat.o(78031);
          return true;
          label157:
          if (paramAnonymousMotionEvent1.getX() < a.this.ktX.getMeasuredWidth() / 2) {
            a.this.APW = a.a.AQb;
          } else {
            a.this.APW = a.a.AQa;
          }
        }
        if (paramAnonymousMotionEvent1.APW == a.a.AQb)
        {
          paramAnonymousFloat1 = f3 * -1.0F / paramAnonymousMotionEvent1.ktX.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.klO;
          if (paramAnonymousFloat1 < 0.0F) {
            paramAnonymousFloat1 = f2;
          }
        }
        label246:
        label503:
        label506:
        for (;;)
        {
          paramAnonymousMotionEvent2 = paramAnonymousMotionEvent1.mContext;
          if ((paramAnonymousMotionEvent2 instanceof Activity))
          {
            if (paramAnonymousFloat1 >= 0.01F) {
              break label323;
            }
            paramAnonymousFloat2 = 0.01F;
          }
          for (;;)
          {
            paramAnonymousMotionEvent2 = (Activity)paramAnonymousMotionEvent2;
            WindowManager.LayoutParams localLayoutParams = paramAnonymousMotionEvent2.getWindow().getAttributes();
            localLayoutParams.screenBrightness = paramAnonymousFloat2;
            paramAnonymousMotionEvent2.getWindow().setAttributes(localLayoutParams);
            paramAnonymousMotionEvent1.APX.aw(paramAnonymousFloat1);
            break;
            if (paramAnonymousFloat1 <= 1.0F) {
              break label506;
            }
            paramAnonymousFloat1 = 1.0F;
            break label246;
            paramAnonymousFloat2 = f1;
            if (paramAnonymousFloat1 <= 1.0F) {
              paramAnonymousFloat2 = paramAnonymousFloat1;
            }
          }
          if (paramAnonymousMotionEvent1.APW != a.a.AQa) {
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
              paramAnonymousFloat1 = i / j;
              paramAnonymousMotionEvent1.APX.av(paramAnonymousFloat1);
              break;
              if (paramAnonymousFloat1 >= 0.0F) {
                break label503;
              }
              i = -1;
              break label428;
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
        AppMethodBeat.i(78029);
        a.this.ktX.postDelayed(a.this.kue, 200L);
        AppMethodBeat.o(78029);
        return true;
      }
    });
    this.klO = c.dp(paramContext);
    AppMethodBeat.o(78035);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(78034);
      APZ = new a("None", 0);
      AQa = new a("Volume", 1);
      AQb = new a("Brightness", 2);
      AQc = new a("FastBackwardOrForward", 3);
      AQd = new a[] { APZ, AQa, AQb, AQc };
      AppMethodBeat.o(78034);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void av(float paramFloat);
    
    public abstract void aw(float paramFloat);
    
    public abstract void bcn();
    
    public abstract void bco();
    
    public abstract void bcp();
    
    public abstract void bcq();
    
    public abstract void bcr();
    
    public abstract boolean dOY();
    
    public abstract int getCurrentPosition();
    
    public abstract int j(int paramInt, float paramFloat);
    
    public abstract void k(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */