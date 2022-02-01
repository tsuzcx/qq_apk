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
  a Bvg;
  c Bvh;
  boolean Bvi;
  boolean Bvj;
  int MG;
  float ljJ;
  View lsl;
  private GestureDetector lsn;
  private float lsp;
  int lsq;
  int lsr;
  Runnable lss;
  Context mContext;
  
  public k(Context paramContext, View paramView, c paramc)
  {
    AppMethodBeat.i(126104);
    this.Bvg = a.Bvl;
    this.ljJ = 0.0F;
    this.MG = 0;
    this.lsp = 0.0F;
    this.lsq = -1;
    this.lsr = 0;
    this.lss = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126097);
        k.this.Bvh.bmV();
        AppMethodBeat.o(126097);
      }
    };
    this.mContext = paramContext;
    this.Bvh = paramc;
    this.lsl = paramView;
    this.lsn = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(199595);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(199595);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(126099);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        k.this.lsl.removeCallbacks(k.this.lss);
        k.this.Bvh.bmW();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(126099);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(199594);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(199594);
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
        if (k.this.Bvg == k.a.Bvl)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label153;
          }
          k.this.Bvg = k.a.Bvo;
        }
        float f3;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f3 = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = k.this;
          if (paramAnonymousMotionEvent1.Bvg != k.a.Bvo) {
            break;
          }
          if (paramAnonymousMotionEvent1.lsq == -1)
          {
            paramAnonymousMotionEvent1.Bvh.bmX();
            paramAnonymousMotionEvent1.lsq = paramAnonymousMotionEvent1.Bvh.getCurrentPosition();
          }
          paramAnonymousMotionEvent1.lsr = paramAnonymousMotionEvent1.Bvh.bJ(paramAnonymousFloat1 - paramAnonymousFloat2);
          AppMethodBeat.o(126100);
          return true;
          label153:
          if (paramAnonymousMotionEvent1.getX() < k.this.lsl.getMeasuredWidth() / 2) {
            k.this.Bvg = k.a.Bvn;
          } else {
            k.this.Bvg = k.a.Bvm;
          }
        }
        if ((paramAnonymousMotionEvent1.Bvg == k.a.Bvn) && (paramAnonymousMotionEvent1.Bvj))
        {
          paramAnonymousFloat1 = f3 * -1.0F / paramAnonymousMotionEvent1.lsl.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.ljJ;
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
          if ((paramAnonymousMotionEvent1.Bvg != k.a.Bvm) || (!paramAnonymousMotionEvent1.Bvi)) {
            break;
          }
          paramAnonymousFloat1 = f3 * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.lsl.getMeasuredHeight();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        k.this.lsl.postDelayed(k.this.lss, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(126098);
        return true;
      }
    });
    this.ljJ = com.tencent.mm.plugin.websearch.ui.a.dw(paramContext);
    AppMethodBeat.o(126104);
  }
  
  public final void boJ()
  {
    this.lsq = -1;
    this.lsr = 0;
    this.lsp = 0.0F;
  }
  
  public final void w(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126105);
    if (!this.Bvh.epQ())
    {
      this.Bvg = a.Bvl;
      AppMethodBeat.o(126105);
      return;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.lsp = paramMotionEvent.getRawX();
      this.MG = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
      this.ljJ = com.tencent.mm.plugin.websearch.ui.a.dw(this.mContext);
    }
    Object localObject = this.lsn;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((i == 1) || (i == 3))
    {
      if (this.Bvg != a.Bvo) {
        break label217;
      }
      localObject = this.Bvh;
      i = this.lsr;
      paramMotionEvent.getRawX();
      ((c)localObject).Ta(i);
      this.lsq = -1;
      this.lsr = 0;
      this.lsp = 0.0F;
    }
    for (;;)
    {
      this.Bvg = a.Bvl;
      AppMethodBeat.o(126105);
      return;
      label217:
      if (this.Bvg == a.Bvm) {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
      } else {
        paramMotionEvent = a.Bvn;
      }
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(126103);
      Bvl = new a("None", 0);
      Bvm = new a("Volume", 1);
      Bvn = new a("Brightness", 2);
      Bvo = new a("FastBackwardOrForward", 3);
      Bvp = new a[] { Bvl, Bvm, Bvn, Bvo };
      AppMethodBeat.o(126103);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.k
 * JD-Core Version:    0.7.0.1
 */