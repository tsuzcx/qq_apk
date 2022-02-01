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
  a Gnk;
  c Gnl;
  boolean Gnm;
  boolean Gnn;
  int MQ;
  Context mContext;
  View mDH;
  private GestureDetector mDJ;
  private float mDL;
  int mDM;
  int mDN;
  Runnable mDO;
  float mue;
  
  public k(Context paramContext, View paramView, c paramc)
  {
    AppMethodBeat.i(126104);
    this.Gnk = a.Gnp;
    this.mue = 0.0F;
    this.MQ = 0;
    this.mDL = 0.0F;
    this.mDM = -1;
    this.mDN = 0;
    this.mDO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126097);
        k.this.Gnl.bJj();
        AppMethodBeat.o(126097);
      }
    };
    this.mContext = paramContext;
    this.Gnl = paramc;
    this.mDH = paramView;
    this.mDJ = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(236390);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(236390);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(126099);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        k.this.mDH.removeCallbacks(k.this.mDO);
        k.this.Gnl.bJk();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(126099);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(236389);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(236389);
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
        if (k.this.Gnk == k.a.Gnp)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label153;
          }
          k.this.Gnk = k.a.Gns;
        }
        float f3;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f3 = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = k.this;
          if (paramAnonymousMotionEvent1.Gnk != k.a.Gns) {
            break;
          }
          if (paramAnonymousMotionEvent1.mDM == -1)
          {
            paramAnonymousMotionEvent1.Gnl.bJl();
            paramAnonymousMotionEvent1.mDM = paramAnonymousMotionEvent1.Gnl.getCurrentPosition();
          }
          paramAnonymousMotionEvent1.mDN = paramAnonymousMotionEvent1.Gnl.ce(paramAnonymousFloat1 - paramAnonymousFloat2);
          AppMethodBeat.o(126100);
          return true;
          label153:
          if (paramAnonymousMotionEvent1.getX() < k.this.mDH.getMeasuredWidth() / 2) {
            k.this.Gnk = k.a.Gnr;
          } else {
            k.this.Gnk = k.a.Gnq;
          }
        }
        if ((paramAnonymousMotionEvent1.Gnk == k.a.Gnr) && (paramAnonymousMotionEvent1.Gnn))
        {
          paramAnonymousFloat1 = f3 * -1.0F / paramAnonymousMotionEvent1.mDH.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.mue;
          if (paramAnonymousFloat1 < 0.0F) {
            paramAnonymousFloat1 = f2;
          }
        }
        label317:
        label487:
        label490:
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
              break label490;
            }
            paramAnonymousFloat1 = 1.0F;
            break;
            paramAnonymousFloat2 = f1;
            if (paramAnonymousFloat1 <= 1.0F) {
              paramAnonymousFloat2 = paramAnonymousFloat1;
            }
          }
          if ((paramAnonymousMotionEvent1.Gnk != k.a.Gnq) || (!paramAnonymousMotionEvent1.Gnm)) {
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
              break;
              if (paramAnonymousFloat1 >= 0.0F) {
                break label487;
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
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        k.this.mDH.postDelayed(k.this.mDO, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(126098);
        return true;
      }
    });
    this.mue = com.tencent.mm.plugin.websearch.ui.a.dV(paramContext);
    AppMethodBeat.o(126104);
  }
  
  public final void A(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126105);
    if (!this.Gnl.fyT())
    {
      this.Gnk = a.Gnp;
      AppMethodBeat.o(126105);
      return;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.mDL = paramMotionEvent.getRawX();
      this.MQ = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
      this.mue = com.tencent.mm.plugin.websearch.ui.a.dV(this.mContext);
    }
    Object localObject = this.mDJ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((i == 1) || (i == 3))
    {
      if (this.Gnk != a.Gns) {
        break label217;
      }
      localObject = this.Gnl;
      i = this.mDN;
      paramMotionEvent.getRawX();
      ((c)localObject).abX(i);
      this.mDM = -1;
      this.mDN = 0;
      this.mDL = 0.0F;
    }
    for (;;)
    {
      this.Gnk = a.Gnp;
      AppMethodBeat.o(126105);
      return;
      label217:
      if (this.Gnk == a.Gnq) {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
      } else {
        paramMotionEvent = a.Gnr;
      }
    }
  }
  
  public final void bKZ()
  {
    this.mDM = -1;
    this.mDN = 0;
    this.mDL = 0.0F;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(126103);
      Gnp = new a("None", 0);
      Gnq = new a("Volume", 1);
      Gnr = new a("Brightness", 2);
      Gns = new a("FastBackwardOrForward", 3);
      Gnt = new a[] { Gnp, Gnq, Gnr, Gns };
      AppMethodBeat.o(126103);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.k
 * JD-Core Version:    0.7.0.1
 */