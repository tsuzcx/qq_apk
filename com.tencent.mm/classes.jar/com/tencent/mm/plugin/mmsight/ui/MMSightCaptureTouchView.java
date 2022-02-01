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
  private GestureDetector iNw;
  private float jyo;
  private int jyp;
  private long wgn;
  private a wgo;
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94512);
    this.wgn = 0L;
    this.jyo = -1.0F;
    this.jyp = 0;
    this.iNw = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189032);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(189032);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(94510);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        Log.i("MicroMsg.MMSightCaptureTouchView", "onDoubleTap");
        if (System.currentTimeMillis() - MMSightCaptureTouchView.b(MMSightCaptureTouchView.this) > 1000L)
        {
          if (MMSightCaptureTouchView.a(MMSightCaptureTouchView.this) != null) {
            MMSightCaptureTouchView.a(MMSightCaptureTouchView.this).clJ();
          }
          MMSightCaptureTouchView.a(MMSightCaptureTouchView.this, System.currentTimeMillis());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(94510);
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189031);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(189031);
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
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        Log.i("MicroMsg.MMSightCaptureTouchView", "onSingleTapUp");
        if (MMSightCaptureTouchView.a(MMSightCaptureTouchView.this) != null) {
          MMSightCaptureTouchView.a(MMSightCaptureTouchView.this).E(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(94509);
        return false;
      }
    });
    this.iNw.setIsLongpressEnabled(false);
    AppMethodBeat.o(94512);
  }
  
  private float t(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(94514);
    try
    {
      if (this.jyp >= 2)
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
    GestureDetector localGestureDetector = this.iNw;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
            this.jyo = -1.0F;
            this.jyp += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
            this.jyp += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
            this.jyp -= 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
            this.jyo = -1.0F;
            this.jyp = 0;
          }
        } while (this.jyp < 2);
        f = t(paramMotionEvent);
        Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.jyo <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.jyo) <= 15.0F);
    if (f > this.jyo)
    {
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
      if (this.wgo != null) {
        this.wgo.aVT();
      }
    }
    for (;;)
    {
      this.jyo = f;
      break;
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
      if (this.wgo != null) {
        this.wgo.aVU();
      }
    }
  }
  
  public void setTouchCallback(a parama)
  {
    this.wgo = parama;
  }
  
  public static abstract interface a
  {
    public abstract void E(float paramFloat1, float paramFloat2);
    
    public abstract void aVT();
    
    public abstract void aVU();
    
    public abstract void clJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView
 * JD-Core Version:    0.7.0.1
 */