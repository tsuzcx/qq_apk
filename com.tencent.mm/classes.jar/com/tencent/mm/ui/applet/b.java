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
  private int KVM;
  private c ONm;
  LinkedList<String> ONn;
  a ONo;
  int direction;
  private GestureDetector jKk;
  private MessageQueue.IdleHandler pzA;
  
  public b(a parama)
  {
    AppMethodBeat.i(141587);
    this.direction = 0;
    this.jKk = new GestureDetector(new GestureDetector.OnGestureListener()
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
        AppMethodBeat.i(205202);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(205202);
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
        AppMethodBeat.i(205201);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205201);
        return false;
      }
    });
    this.ONo = parama;
    this.KVM = 15;
    this.ONm = new c();
    this.ONn = new LinkedList();
    this.pzA = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(141583);
        while (b.this.ONn.size() > 0)
        {
          String str = (String)b.this.ONn.removeFirst();
          b.this.ONo.Ta(str);
        }
        AppMethodBeat.o(141583);
        return true;
      }
    };
    Looper.myQueue().addIdleHandler(this.pzA);
    AppMethodBeat.o(141587);
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
    if (this.KVM <= 0)
    {
      Log.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
      AppMethodBeat.o(141588);
      return;
    }
    int j = paramb.bnW();
    int i = 1;
    if (i <= this.KVM)
    {
      String str;
      if (this.direction == 1)
      {
        if (paramInt - i < 0)
        {
          AppMethodBeat.o(141588);
          return;
        }
        str = paramb.vg(paramInt - i);
        if ((str != null) && (str.length() != 0) && (!this.ONm.contains(str)))
        {
          this.ONm.add(str);
          this.ONn.add(str);
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
        str = paramb.vg(paramInt + i);
        if ((str != null) && (str.length() != 0) && (!this.ONm.contains(str)))
        {
          this.ONm.add(str);
          this.ONn.add(str);
        }
      }
    }
    AppMethodBeat.o(141588);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(141590);
    if (this.pzA != null) {
      Looper.myQueue().removeIdleHandler(this.pzA);
    }
    AppMethodBeat.o(141590);
  }
  
  public final void onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141589);
    if (this.jKk != null)
    {
      GestureDetector localGestureDetector = this.jKk;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.axQ(), "com/tencent/mm/ui/applet/EarlyGetHeadImg", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/ui/applet/EarlyGetHeadImg", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    AppMethodBeat.o(141589);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap Ta(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract int bnW();
    
    public abstract String vg(int paramInt);
  }
  
  final class c
  {
    private LinkedList<String> gCs;
    private int maxSize;
    
    public c()
    {
      AppMethodBeat.i(141584);
      this.gCs = null;
      this.maxSize = 40;
      this.gCs = new LinkedList();
      AppMethodBeat.o(141584);
    }
    
    final void add(String paramString)
    {
      AppMethodBeat.i(141585);
      if (this.gCs.contains(paramString))
      {
        AppMethodBeat.o(141585);
        return;
      }
      this.gCs.add(paramString);
      if (this.gCs.size() >= this.maxSize) {
        this.gCs.removeFirst();
      }
      AppMethodBeat.o(141585);
    }
    
    final boolean contains(String paramString)
    {
      AppMethodBeat.i(141586);
      boolean bool = this.gCs.contains(paramString);
      AppMethodBeat.o(141586);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */