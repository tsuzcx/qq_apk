package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.Log;

public class MMSightCaptureTouchView
  extends RelativeLayout
{
  private GestureDetector irA;
  private float jck;
  private int jcl;
  private long uQZ;
  private a uRa;
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94512);
    this.uQZ = 0L;
    this.jck = -1.0F;
    this.jcl = 0;
    this.irA = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(94510);
        Log.i("MicroMsg.MMSightCaptureTouchView", "onDoubleTap");
        if (System.currentTimeMillis() - MMSightCaptureTouchView.b(MMSightCaptureTouchView.this) > 1000L)
        {
          if (MMSightCaptureTouchView.a(MMSightCaptureTouchView.this) != null) {
            MMSightCaptureTouchView.a(MMSightCaptureTouchView.this).cfQ();
          }
          MMSightCaptureTouchView.a(MMSightCaptureTouchView.this, System.currentTimeMillis());
        }
        AppMethodBeat.o(94510);
        return false;
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
        Log.i("MicroMsg.MMSightCaptureTouchView", "onSingleTapUp");
        if (MMSightCaptureTouchView.a(MMSightCaptureTouchView.this) != null) {
          MMSightCaptureTouchView.a(MMSightCaptureTouchView.this).D(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
        }
        AppMethodBeat.o(94509);
        return false;
      }
    });
    this.irA.setIsLongpressEnabled(false);
    AppMethodBeat.o(94512);
  }
  
  private float w(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(94514);
    try
    {
      if (this.jcl >= 2)
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
    this.irA.onTouchEvent(paramMotionEvent);
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
            this.jck = -1.0F;
            this.jcl += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
            this.jcl += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
            this.jcl -= 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
            this.jck = -1.0F;
            this.jcl = 0;
          }
        } while (this.jcl < 2);
        f = w(paramMotionEvent);
        Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.jck <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.jck) <= 15.0F);
    if (f > this.jck)
    {
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
      if (this.uRa != null) {
        this.uRa.aSi();
      }
    }
    for (;;)
    {
      this.jck = f;
      break;
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
      if (this.uRa != null) {
        this.uRa.aSj();
      }
    }
  }
  
  public void setTouchCallback(a parama)
  {
    this.uRa = parama;
  }
  
  public static abstract interface a
  {
    public abstract void D(float paramFloat1, float paramFloat2);
    
    public abstract void aSi();
    
    public abstract void aSj();
    
    public abstract void cfQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView
 * JD-Core Version:    0.7.0.1
 */