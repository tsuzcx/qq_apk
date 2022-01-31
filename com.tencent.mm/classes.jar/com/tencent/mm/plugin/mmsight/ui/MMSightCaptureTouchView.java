package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.Log;

public class MMSightCaptureTouchView
  extends RelativeLayout
{
  private float gOv;
  private int gOw;
  private GestureDetector lOj;
  private long oNu;
  private MMSightCaptureTouchView.a oNv;
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55076);
    this.oNu = 0L;
    this.gOv = -1.0F;
    this.gOw = 0;
    this.lOj = new GestureDetector(getContext(), new MMSightCaptureTouchView.1(this));
    this.lOj.setIsLongpressEnabled(false);
    AppMethodBeat.o(55076);
  }
  
  private float x(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(55078);
    try
    {
      if (this.gOw >= 2)
      {
        float f3 = paramMotionEvent.getX(0);
        float f1 = paramMotionEvent.getY(0);
        float f4 = paramMotionEvent.getX(1);
        float f2 = paramMotionEvent.getY(1);
        f3 = Math.abs(f3 - f4);
        f1 = Math.abs(f1 - f2);
        AppMethodBeat.o(55078);
        return f3 + f1;
      }
    }
    catch (Exception paramMotionEvent)
    {
      Log.e("MicroMsg.MMSightCaptureTouchView", "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
      AppMethodBeat.o(55078);
    }
    return 0.0F;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(55077);
    this.lOj.onTouchEvent(paramMotionEvent);
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
            AppMethodBeat.o(55077);
            return true;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_DOWN");
            this.gOv = -1.0F;
            this.gOw += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
            this.gOw += 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
            this.gOw -= 1;
            continue;
            Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
            this.gOv = -1.0F;
            this.gOw = 0;
          }
        } while (this.gOw < 2);
        f = x(paramMotionEvent);
        Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.gOv <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.gOv) <= 15.0F);
    if (f > this.gOv)
    {
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
      if (this.oNv != null) {
        this.oNv.asQ();
      }
    }
    for (;;)
    {
      this.gOv = f;
      break;
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
      if (this.oNv != null) {
        this.oNv.asR();
      }
    }
  }
  
  public void setTouchCallback(MMSightCaptureTouchView.a parama)
  {
    this.oNv = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView
 * JD-Core Version:    0.7.0.1
 */