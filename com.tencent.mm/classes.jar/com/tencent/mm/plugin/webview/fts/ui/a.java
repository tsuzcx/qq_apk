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
  a IPO;
  b IPP;
  int MQ;
  Context mContext;
  View mDH;
  GestureDetector mDJ;
  float mDL;
  int mDM;
  int mDN;
  Runnable mDO;
  float mue;
  
  public a(Context paramContext, View paramView, b paramb)
  {
    AppMethodBeat.i(78035);
    this.IPO = a.IPR;
    this.mue = 0.0F;
    this.MQ = 0;
    this.mDL = 0.0F;
    this.mDM = -1;
    this.mDN = 0;
    this.mDO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78028);
        a.this.IPP.bJj();
        AppMethodBeat.o(78028);
      }
    };
    this.mContext = paramContext;
    this.IPP = paramb;
    this.mDH = paramView;
    this.mDJ = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210855);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(210855);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(78030);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        a.this.mDH.removeCallbacks(a.this.mDO);
        a.this.IPP.bJk();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(78030);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210854);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(210854);
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
        if (a.this.IPO == a.a.IPR)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label157;
          }
          a.this.IPO = a.a.IPU;
        }
        float f3;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f3 = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = a.this;
          if (paramAnonymousMotionEvent1.IPO != a.a.IPU) {
            break;
          }
          if (paramAnonymousMotionEvent1.mDM == -1)
          {
            paramAnonymousMotionEvent1.IPP.bJl();
            paramAnonymousMotionEvent1.mDM = paramAnonymousMotionEvent1.IPP.getCurrentPosition();
          }
          paramAnonymousMotionEvent1.mDN = paramAnonymousMotionEvent1.IPP.k(paramAnonymousMotionEvent1.mDM, paramAnonymousFloat1 - paramAnonymousFloat2);
          AppMethodBeat.o(78031);
          return true;
          label157:
          if (paramAnonymousMotionEvent1.getX() < a.this.mDH.getMeasuredWidth() / 2) {
            a.this.IPO = a.a.IPT;
          } else {
            a.this.IPO = a.a.IPS;
          }
        }
        if (paramAnonymousMotionEvent1.IPO == a.a.IPT)
        {
          paramAnonymousFloat1 = f3 * -1.0F / paramAnonymousMotionEvent1.mDH.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.mue;
          if (paramAnonymousFloat1 < 0.0F) {
            paramAnonymousFloat1 = f2;
          }
        }
        label246:
        label504:
        label507:
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
            paramAnonymousMotionEvent1.IPP.aN(paramAnonymousFloat1);
            break;
            if (paramAnonymousFloat1 <= 1.0F) {
              break label507;
            }
            paramAnonymousFloat1 = 1.0F;
            break label246;
            paramAnonymousFloat2 = f1;
            if (paramAnonymousFloat1 <= 1.0F) {
              paramAnonymousFloat2 = paramAnonymousFloat1;
            }
          }
          if (paramAnonymousMotionEvent1.IPO != a.a.IPS) {
            break;
          }
          paramAnonymousFloat1 = f3 * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.mDH.getMeasuredHeight();
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
            int k = i + paramAnonymousMotionEvent1.MQ;
            if (k < 0) {
              i = 0;
            }
            for (;;)
            {
              com.tencent.mm.compatible.b.a.a(paramAnonymousMotionEvent2, 3, i, 0);
              paramAnonymousFloat1 = i / j;
              paramAnonymousMotionEvent1.IPP.aM(paramAnonymousFloat1);
              break;
              if (paramAnonymousFloat1 >= 0.0F) {
                break label504;
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
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        a.this.mDH.postDelayed(a.this.mDO, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(78029);
        return true;
      }
    });
    this.mue = c.dV(paramContext);
    AppMethodBeat.o(78035);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(78034);
      IPR = new a("None", 0);
      IPS = new a("Volume", 1);
      IPT = new a("Brightness", 2);
      IPU = new a("FastBackwardOrForward", 3);
      IPV = new a[] { IPR, IPS, IPT, IPU };
      AppMethodBeat.o(78034);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void aM(float paramFloat);
    
    public abstract void aN(float paramFloat);
    
    public abstract void bJj();
    
    public abstract void bJk();
    
    public abstract void bJl();
    
    public abstract void bJm();
    
    public abstract void bJn();
    
    public abstract boolean fyT();
    
    public abstract int getCurrentPosition();
    
    public abstract int k(int paramInt, float paramFloat);
    
    public abstract void l(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */