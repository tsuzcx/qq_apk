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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.webview.fts.c.c;

public final class a
{
  a Edo;
  b Edp;
  int MG;
  float lnw;
  View lwK;
  GestureDetector lwM;
  float lwO;
  int lwP;
  int lwQ;
  Runnable lwR;
  Context mContext;
  
  public a(Context paramContext, View paramView, b paramb)
  {
    AppMethodBeat.i(78035);
    this.Edo = a.Edr;
    this.lnw = 0.0F;
    this.MG = 0;
    this.lwO = 0.0F;
    this.lwP = -1;
    this.lwQ = 0;
    this.lwR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78028);
        a.this.Edp.bnF();
        AppMethodBeat.o(78028);
      }
    };
    this.mContext = paramContext;
    this.Edp = paramb;
    this.lwK = paramView;
    this.lwM = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(197998);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(197998);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(78030);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        a.this.lwK.removeCallbacks(a.this.lwR);
        a.this.Edp.bnG();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(78030);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(197997);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(197997);
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
        if (a.this.Edo == a.a.Edr)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label157;
          }
          a.this.Edo = a.a.Edu;
        }
        float f3;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f3 = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = a.this;
          if (paramAnonymousMotionEvent1.Edo != a.a.Edu) {
            break;
          }
          if (paramAnonymousMotionEvent1.lwP == -1)
          {
            paramAnonymousMotionEvent1.Edp.bnH();
            paramAnonymousMotionEvent1.lwP = paramAnonymousMotionEvent1.Edp.getCurrentPosition();
          }
          paramAnonymousMotionEvent1.lwQ = paramAnonymousMotionEvent1.Edp.k(paramAnonymousMotionEvent1.lwP, paramAnonymousFloat1 - paramAnonymousFloat2);
          AppMethodBeat.o(78031);
          return true;
          label157:
          if (paramAnonymousMotionEvent1.getX() < a.this.lwK.getMeasuredWidth() / 2) {
            a.this.Edo = a.a.Edt;
          } else {
            a.this.Edo = a.a.Eds;
          }
        }
        if (paramAnonymousMotionEvent1.Edo == a.a.Edt)
        {
          paramAnonymousFloat1 = f3 * -1.0F / paramAnonymousMotionEvent1.lwK.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.lnw;
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
            paramAnonymousMotionEvent1.Edp.aD(paramAnonymousFloat1);
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
          if (paramAnonymousMotionEvent1.Edo != a.a.Eds) {
            break;
          }
          paramAnonymousFloat1 = f3 * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.lwK.getMeasuredHeight();
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
            int k = i + paramAnonymousMotionEvent1.MG;
            if (k < 0) {
              i = 0;
            }
            for (;;)
            {
              com.tencent.mm.compatible.b.a.b(paramAnonymousMotionEvent2, 3, i);
              paramAnonymousFloat1 = i / j;
              paramAnonymousMotionEvent1.Edp.aC(paramAnonymousFloat1);
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
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        a.this.lwK.postDelayed(a.this.lwR, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(78029);
        return true;
      }
    });
    this.lnw = c.dA(paramContext);
    AppMethodBeat.o(78035);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(78034);
      Edr = new a("None", 0);
      Eds = new a("Volume", 1);
      Edt = new a("Brightness", 2);
      Edu = new a("FastBackwardOrForward", 3);
      Edv = new a[] { Edr, Eds, Edt, Edu };
      AppMethodBeat.o(78034);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void aC(float paramFloat);
    
    public abstract void aD(float paramFloat);
    
    public abstract void bnF();
    
    public abstract void bnG();
    
    public abstract void bnH();
    
    public abstract void bnI();
    
    public abstract void bnJ();
    
    public abstract boolean etx();
    
    public abstract int getCurrentPosition();
    
    public abstract int k(int paramInt, float paramFloat);
    
    public abstract void l(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */