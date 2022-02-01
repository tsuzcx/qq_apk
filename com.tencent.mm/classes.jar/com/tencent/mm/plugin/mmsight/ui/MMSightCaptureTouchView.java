package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.wcdb.support.Log;

public class MMSightCaptureTouchView
  extends RelativeLayout
{
  private GestureDetector jKk;
  private float kyX;
  private int kyY;
  private long zAN;
  private a zAO;
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94512);
    this.zAN = 0L;
    this.kyX = -1.0F;
    this.kyY = 0;
    this.jKk = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(187077);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(187077);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(94510);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        Log.i("MicroMsg.MMSightCaptureTouchView", "onDoubleTap");
        if (System.currentTimeMillis() - MMSightCaptureTouchView.b(MMSightCaptureTouchView.this) > 1000L)
        {
          if (MMSightCaptureTouchView.a(MMSightCaptureTouchView.this) != null) {
            MMSightCaptureTouchView.a(MMSightCaptureTouchView.this).cJL();
          }
          MMSightCaptureTouchView.a(MMSightCaptureTouchView.this, System.currentTimeMillis());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(94510);
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(187076);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(187076);
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(94511);
        Log.i("MicroMsg.MMSightCaptureTouchView", "onSingleTapConfirmed");
        AppMethodBeat.o(94511);
        return true;
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(94509);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        Log.i("MicroMsg.MMSightCaptureTouchView", "onSingleTapUp");
        if (MMSightCaptureTouchView.a(MMSightCaptureTouchView.this) != null) {
          MMSightCaptureTouchView.a(MMSightCaptureTouchView.this).I(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(94509);
        return false;
      }
    });
    this.jKk.setIsLongpressEnabled(false);
    AppMethodBeat.o(94512);
  }
  
  private float x(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(94514);
    try
    {
      if (this.kyY >= 2)
      {
        float f3 = paramMotionEvent.getX(0);
        float f1 = paramMotionEvent.getY(0);
        float f4 = paramMotionEvent.getX(1);
        float f2 = paramMotionEvent.getY(1);
        f3 = Math.abs(f3 - f4);
        f1 = Math.abs(f1 - f2);
        AppMethodBeat.o(94514);
        return f3 + f1;
      }
    }
    catch (Exception paramMotionEvent)
    {
      Log.e("MicroMsg.MMSightCaptureTouchView", "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
      AppMethodBeat.o(94514);
    }
    return 0.0F;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(94513);
    GestureDetector localGestureDetector = this.jKk;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    float f;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(94513);
            return true;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_DOWN");
            this.kyX = -1.0F;
            this.kyY += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
            this.kyY += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
            this.kyY -= 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
            this.kyX = -1.0F;
            this.kyY = 0;
          }
        } while (this.kyY < 2);
        f = x(paramMotionEvent);
        Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.kyX <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.kyX) <= 15.0F);
    if (f > this.kyX)
    {
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
      if (this.zAO != null) {
        this.zAO.bqQ();
      }
    }
    for (;;)
    {
      this.kyX = f;
      break;
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
      if (this.zAO != null) {
        this.zAO.bqR();
      }
    }
  }
  
  public void setTouchCallback(a parama)
  {
    this.zAO = parama;
  }
  
  public static abstract interface a
  {
    public abstract void I(float paramFloat1, float paramFloat2);
    
    public abstract void bqQ();
    
    public abstract void bqR();
    
    public abstract void cJL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView
 * JD-Core Version:    0.7.0.1
 */