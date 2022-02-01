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
  a Cij;
  b Cik;
  int KO;
  float kNg;
  View kVm;
  GestureDetector kVo;
  float kVq;
  int kVr;
  int kVs;
  Runnable kVt;
  Context mContext;
  
  public a(Context paramContext, View paramView, b paramb)
  {
    AppMethodBeat.i(78035);
    this.Cij = a.Cim;
    this.kNg = 0.0F;
    this.KO = 0;
    this.kVq = 0.0F;
    this.kVr = -1;
    this.kVs = 0;
    this.kVt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78028);
        a.this.Cik.bjj();
        AppMethodBeat.o(78028);
      }
    };
    this.mContext = paramContext;
    this.Cik = paramb;
    this.kVm = paramView;
    this.kVo = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(78030);
        a.this.kVm.removeCallbacks(a.this.kVt);
        a.this.Cik.bjk();
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
        if (a.this.Cij == a.a.Cim)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label157;
          }
          a.this.Cij = a.a.Cip;
        }
        float f3;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f3 = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = a.this;
          if (paramAnonymousMotionEvent1.Cij != a.a.Cip) {
            break;
          }
          if (paramAnonymousMotionEvent1.kVr == -1)
          {
            paramAnonymousMotionEvent1.Cik.bjl();
            paramAnonymousMotionEvent1.kVr = paramAnonymousMotionEvent1.Cik.getCurrentPosition();
          }
          paramAnonymousMotionEvent1.kVs = paramAnonymousMotionEvent1.Cik.j(paramAnonymousMotionEvent1.kVr, paramAnonymousFloat1 - paramAnonymousFloat2);
          AppMethodBeat.o(78031);
          return true;
          label157:
          if (paramAnonymousMotionEvent1.getX() < a.this.kVm.getMeasuredWidth() / 2) {
            a.this.Cij = a.a.Cio;
          } else {
            a.this.Cij = a.a.Cin;
          }
        }
        if (paramAnonymousMotionEvent1.Cij == a.a.Cio)
        {
          paramAnonymousFloat1 = f3 * -1.0F / paramAnonymousMotionEvent1.kVm.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.kNg;
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
            paramAnonymousMotionEvent1.Cik.aA(paramAnonymousFloat1);
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
          if (paramAnonymousMotionEvent1.Cij != a.a.Cin) {
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
              paramAnonymousFloat1 = i / j;
              paramAnonymousMotionEvent1.Cik.az(paramAnonymousFloat1);
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
        a.this.kVm.postDelayed(a.this.kVt, 200L);
        AppMethodBeat.o(78029);
        return true;
      }
    });
    this.kNg = c.dy(paramContext);
    AppMethodBeat.o(78035);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(78034);
      Cim = new a("None", 0);
      Cin = new a("Volume", 1);
      Cio = new a("Brightness", 2);
      Cip = new a("FastBackwardOrForward", 3);
      Ciq = new a[] { Cim, Cin, Cio, Cip };
      AppMethodBeat.o(78034);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void aA(float paramFloat);
    
    public abstract void az(float paramFloat);
    
    public abstract void bjj();
    
    public abstract void bjk();
    
    public abstract void bjl();
    
    public abstract void bjm();
    
    public abstract void bjn();
    
    public abstract boolean edy();
    
    public abstract int getCurrentPosition();
    
    public abstract int j(int paramInt, float paramFloat);
    
    public abstract void k(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */