package com.tencent.mm.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
{
  private int Jfu;
  private b.c adNG;
  LinkedList<String> adNH;
  a adNI;
  int direction;
  private MessageQueue.IdleHandler fgm;
  private GestureDetector nwZ;
  
  public b(a parama)
  {
    AppMethodBeat.i(141587);
    this.direction = 0;
    this.nwZ = new GestureDetector(new b.2(this));
    this.adNI = parama;
    this.Jfu = 15;
    this.adNG = new b.c(this);
    this.adNH = new LinkedList();
    this.fgm = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(141583);
        while (b.this.adNH.size() > 0)
        {
          String str = (String)b.this.adNH.removeFirst();
          b.this.adNI.getHeadImg(str);
        }
        AppMethodBeat.o(141583);
        return true;
      }
    };
    Looper.myQueue().addIdleHandler(this.fgm);
    AppMethodBeat.o(141587);
  }
  
  public final void B(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141589);
    if (this.nwZ != null)
    {
      GestureDetector localGestureDetector = this.nwZ;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aYi(), "com/tencent/mm/ui/applet/EarlyGetHeadImg", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/ui/applet/EarlyGetHeadImg", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    AppMethodBeat.o(141589);
  }
  
  public final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(141588);
    if (paramb == null)
    {
      Log.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
      AppMethodBeat.o(141588);
      return;
    }
    if (this.Jfu <= 0)
    {
      Log.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
      AppMethodBeat.o(141588);
      return;
    }
    int j = paramb.bWT();
    int i = 1;
    if (i <= this.Jfu)
    {
      String str;
      if (this.direction == 1)
      {
        if (paramInt - i < 0)
        {
          AppMethodBeat.o(141588);
          return;
        }
        str = paramb.yq(paramInt - i);
        if ((str != null) && (str.length() != 0) && (!this.adNG.contains(str)))
        {
          this.adNG.add(str);
          this.adNH.add(str);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt + i >= j)
        {
          AppMethodBeat.o(141588);
          return;
        }
        str = paramb.yq(paramInt + i);
        if ((str != null) && (str.length() != 0) && (!this.adNG.contains(str)))
        {
          this.adNG.add(str);
          this.adNH.add(str);
        }
      }
    }
    AppMethodBeat.o(141588);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(141590);
    if (this.fgm != null) {
      Looper.myQueue().removeIdleHandler(this.fgm);
    }
    AppMethodBeat.o(141590);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap getHeadImg(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract int bWT();
    
    public abstract String yq(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */