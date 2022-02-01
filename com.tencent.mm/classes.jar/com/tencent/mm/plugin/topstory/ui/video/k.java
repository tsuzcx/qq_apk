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
import com.tencent.mm.hellhoundlib.b.b;

public final class k
{
  a BME;
  c BMF;
  boolean BMG;
  boolean BMH;
  int MG;
  float lnw;
  View lwK;
  private GestureDetector lwM;
  private float lwO;
  int lwP;
  int lwQ;
  Runnable lwR;
  Context mContext;
  
  public k(Context paramContext, View paramView, c paramc)
  {
    AppMethodBeat.i(126104);
    this.BME = a.BMJ;
    this.lnw = 0.0F;
    this.MG = 0;
    this.lwO = 0.0F;
    this.lwP = -1;
    this.lwQ = 0;
    this.lwR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126097);
        k.this.BMF.bnF();
        AppMethodBeat.o(126097);
      }
    };
    this.mContext = paramContext;
    this.BMF = paramc;
    this.lwK = paramView;
    this.lwM = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(220239);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(220239);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(126099);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        k.this.lwK.removeCallbacks(k.this.lwR);
        k.this.BMF.bnG();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(126099);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(220238);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(220238);
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
        if (k.this.BME == k.a.BMJ)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label153;
          }
          k.this.BME = k.a.BMM;
        }
        float f3;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f3 = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = k.this;
          if (paramAnonymousMotionEvent1.BME != k.a.BMM) {
            break;
          }
          if (paramAnonymousMotionEvent1.lwP == -1)
          {
            paramAnonymousMotionEvent1.BMF.bnH();
            paramAnonymousMotionEvent1.lwP = paramAnonymousMotionEvent1.BMF.getCurrentPosition();
          }
          paramAnonymousMotionEvent1.lwQ = paramAnonymousMotionEvent1.BMF.bH(paramAnonymousFloat1 - paramAnonymousFloat2);
          AppMethodBeat.o(126100);
          return true;
          label153:
          if (paramAnonymousMotionEvent1.getX() < k.this.lwK.getMeasuredWidth() / 2) {
            k.this.BME = k.a.BML;
          } else {
            k.this.BME = k.a.BMK;
          }
        }
        if ((paramAnonymousMotionEvent1.BME == k.a.BML) && (paramAnonymousMotionEvent1.BMH))
        {
          paramAnonymousFloat1 = f3 * -1.0F / paramAnonymousMotionEvent1.lwK.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.lnw;
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
          if ((paramAnonymousMotionEvent1.BME != k.a.BMK) || (!paramAnonymousMotionEvent1.BMG)) {
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
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        k.this.lwK.postDelayed(k.this.lwR, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(126098);
        return true;
      }
    });
    this.lnw = com.tencent.mm.plugin.websearch.ui.a.dA(paramContext);
    AppMethodBeat.o(126104);
  }
  
  public final void bpt()
  {
    this.lwP = -1;
    this.lwQ = 0;
    this.lwO = 0.0F;
  }
  
  public final void w(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126105);
    if (!this.BMF.etx())
    {
      this.BME = a.BMJ;
      AppMethodBeat.o(126105);
      return;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.lwO = paramMotionEvent.getRawX();
      this.MG = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
      this.lnw = com.tencent.mm.plugin.websearch.ui.a.dA(this.mContext);
    }
    Object localObject = this.lwM;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((i == 1) || (i == 3))
    {
      if (this.BME != a.BMM) {
        break label217;
      }
      localObject = this.BMF;
      i = this.lwQ;
      paramMotionEvent.getRawX();
      ((c)localObject).TH(i);
      this.lwP = -1;
      this.lwQ = 0;
      this.lwO = 0.0F;
    }
    for (;;)
    {
      this.BME = a.BMJ;
      AppMethodBeat.o(126105);
      return;
      label217:
      if (this.BME == a.BMK) {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
      } else {
        paramMotionEvent = a.BML;
      }
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(126103);
      BMJ = new a("None", 0);
      BMK = new a("Volume", 1);
      BML = new a("Brightness", 2);
      BMM = new a("FastBackwardOrForward", 3);
      BMN = new a[] { BMJ, BMK, BML, BMM };
      AppMethodBeat.o(126103);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.k
 * JD-Core Version:    0.7.0.1
 */