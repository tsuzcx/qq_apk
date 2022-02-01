package com.tencent.mm.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
{
  private int Dml;
  private c WgK;
  LinkedList<String> WgL;
  a WgM;
  int direction;
  private GestureDetector mBn;
  private MessageQueue.IdleHandler sJE;
  
  public b(a parama)
  {
    AppMethodBeat.i(141587);
    this.direction = 0;
    this.mBn = new GestureDetector(new GestureDetector.OnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(187455);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(187455);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        paramAnonymousMotionEvent1 = b.this;
        if (paramAnonymousFloat2 >= 0.0F) {}
        for (int i = 0;; i = 1)
        {
          paramAnonymousMotionEvent1.direction = i;
          return false;
        }
      }
      
      public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(187450);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(187450);
        return false;
      }
    });
    this.WgM = parama;
    this.Dml = 15;
    this.WgK = new c();
    this.WgL = new LinkedList();
    this.sJE = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(141583);
        while (b.this.WgL.size() > 0)
        {
          String str = (String)b.this.WgL.removeFirst();
          b.this.WgM.aaG(str);
        }
        AppMethodBeat.o(141583);
        return true;
      }
    };
    Looper.myQueue().addIdleHandler(this.sJE);
    AppMethodBeat.o(141587);
  }
  
  public final void B(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141589);
    if (this.mBn != null)
    {
      GestureDetector localGestureDetector = this.mBn;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aFh(), "com/tencent/mm/ui/applet/EarlyGetHeadImg", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/ui/applet/EarlyGetHeadImg", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
    if (this.Dml <= 0)
    {
      Log.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
      AppMethodBeat.o(141588);
      return;
    }
    int j = paramb.byf();
    int i = 1;
    if (i <= this.Dml)
    {
      String str;
      if (this.direction == 1)
      {
        if (paramInt - i < 0)
        {
          AppMethodBeat.o(141588);
          return;
        }
        str = paramb.yk(paramInt - i);
        if ((str != null) && (str.length() != 0) && (!this.WgK.contains(str)))
        {
          this.WgK.add(str);
          this.WgL.add(str);
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
        str = paramb.yk(paramInt + i);
        if ((str != null) && (str.length() != 0) && (!this.WgK.contains(str)))
        {
          this.WgK.add(str);
          this.WgL.add(str);
        }
      }
    }
    AppMethodBeat.o(141588);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(141590);
    if (this.sJE != null) {
      Looper.myQueue().removeIdleHandler(this.sJE);
    }
    AppMethodBeat.o(141590);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap aaG(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract int byf();
    
    public abstract String yk(int paramInt);
  }
  
  final class c
  {
    private LinkedList<String> jmy;
    private int maxSize;
    
    public c()
    {
      AppMethodBeat.i(141584);
      this.jmy = null;
      this.maxSize = 40;
      this.jmy = new LinkedList();
      AppMethodBeat.o(141584);
    }
    
    final void add(String paramString)
    {
      AppMethodBeat.i(141585);
      if (this.jmy.contains(paramString))
      {
        AppMethodBeat.o(141585);
        return;
      }
      this.jmy.add(paramString);
      if (this.jmy.size() >= this.maxSize) {
        this.jmy.removeFirst();
      }
      AppMethodBeat.o(141585);
    }
    
    final boolean contains(String paramString)
    {
      AppMethodBeat.i(141586);
      boolean bool = this.jmy.contains(paramString);
      AppMethodBeat.o(141586);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */