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
  private GestureDetector hRv;
  private float iCj;
  private int iCk;
  private long tID;
  private a tIE;
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94512);
    this.tID = 0L;
    this.iCj = -1.0F;
    this.iCk = 0;
    this.hRv = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(94510);
        Log.i("MicroMsg.MMSightCaptureTouchView", "onDoubleTap");
        if (System.currentTimeMillis() - MMSightCaptureTouchView.b(MMSightCaptureTouchView.this) > 1000L)
        {
          if (MMSightCaptureTouchView.a(MMSightCaptureTouchView.this) != null) {
            MMSightCaptureTouchView.a(MMSightCaptureTouchView.this).bYD();
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
          MMSightCaptureTouchView.a(MMSightCaptureTouchView.this).A(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
        }
        AppMethodBeat.o(94509);
        return false;
      }
    });
    this.hRv.setIsLongpressEnabled(false);
    AppMethodBeat.o(94512);
  }
  
  private float y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(94514);
    try
    {
      if (this.iCk >= 2)
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
    this.hRv.onTouchEvent(paramMotionEvent);
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
            this.iCj = -1.0F;
            this.iCk += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
            this.iCk += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
            this.iCk -= 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
            this.iCj = -1.0F;
            this.iCk = 0;
          }
        } while (this.iCk < 2);
        f = y(paramMotionEvent);
        Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.iCj <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.iCj) <= 15.0F);
    if (f > this.iCj)
    {
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
      if (this.tIE != null) {
        this.tIE.aLr();
      }
    }
    for (;;)
    {
      this.iCj = f;
      break;
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
      if (this.tIE != null) {
        this.tIE.aLs();
      }
    }
  }
  
  public void setTouchCallback(a parama)
  {
    this.tIE = parama;
  }
  
  public static abstract interface a
  {
    public abstract void A(float paramFloat1, float paramFloat2);
    
    public abstract void aLr();
    
    public abstract void aLs();
    
    public abstract void bYD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView
 * JD-Core Version:    0.7.0.1
 */