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
  private a Lbj;
  private long nwU;
  private float nwV;
  private GestureDetector nwZ;
  private int pointerCount;
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94512);
    this.nwU = 0L;
    this.nwV = -1.0F;
    this.pointerCount = 0;
    this.nwZ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(303629);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(303629);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(94510);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        Log.i("MicroMsg.MMSightCaptureTouchView", "onDoubleTap");
        if (System.currentTimeMillis() - MMSightCaptureTouchView.b(MMSightCaptureTouchView.this) > 1000L)
        {
          if (MMSightCaptureTouchView.a(MMSightCaptureTouchView.this) != null) {
            MMSightCaptureTouchView.a(MMSightCaptureTouchView.this).bow();
          }
          MMSightCaptureTouchView.a(MMSightCaptureTouchView.this, System.currentTimeMillis());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(94510);
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(303628);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(303628);
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
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        Log.i("MicroMsg.MMSightCaptureTouchView", "onSingleTapUp");
        if (MMSightCaptureTouchView.a(MMSightCaptureTouchView.this) != null) {
          MMSightCaptureTouchView.a(MMSightCaptureTouchView.this).al(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(94509);
        return false;
      }
    });
    this.nwZ.setIsLongpressEnabled(false);
    AppMethodBeat.o(94512);
  }
  
  private float x(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(94514);
    try
    {
      if (this.pointerCount >= 2)
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
    GestureDetector localGestureDetector = this.nwZ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
            this.nwV = -1.0F;
            this.pointerCount += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
            this.pointerCount += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
            this.pointerCount -= 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
            this.nwV = -1.0F;
            this.pointerCount = 0;
          }
        } while (this.pointerCount < 2);
        f = x(paramMotionEvent);
        Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.nwV <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.nwV) <= 15.0F);
    if (f > this.nwV)
    {
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
      if (this.Lbj != null) {
        this.Lbj.bof();
      }
    }
    for (;;)
    {
      this.nwV = f;
      break;
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
      if (this.Lbj != null) {
        this.Lbj.bog();
      }
    }
  }
  
  public void setTouchCallback(a parama)
  {
    this.Lbj = parama;
  }
  
  public static abstract interface a
  {
    public abstract void al(float paramFloat1, float paramFloat2);
    
    public abstract void bof();
    
    public abstract void bog();
    
    public abstract void bow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView
 * JD-Core Version:    0.7.0.1
 */