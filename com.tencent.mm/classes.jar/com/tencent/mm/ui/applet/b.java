package com.tencent.mm.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class b
{
  private int GbL;
  private c JCu;
  LinkedList<String> JCv;
  a JCw;
  int direction;
  private GestureDetector iNw;
  private MessageQueue.IdleHandler omO;
  
  public b(a parama)
  {
    AppMethodBeat.i(141587);
    this.direction = 0;
    this.iNw = new GestureDetector(new GestureDetector.OnGestureListener()
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
        AppMethodBeat.i(193708);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(193708);
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
        AppMethodBeat.i(193707);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193707);
        return false;
      }
    });
    this.JCw = parama;
    this.GbL = 15;
    this.JCu = new c();
    this.JCv = new LinkedList();
    this.omO = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(141583);
        while (b.this.JCv.size() > 0)
        {
          String str = (String)b.this.JCv.removeFirst();
          b.this.JCw.Kc(str);
        }
        AppMethodBeat.o(141583);
        return true;
      }
    };
    Looper.myQueue().addIdleHandler(this.omO);
    AppMethodBeat.o(141587);
  }
  
  public final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(141588);
    if (paramb == null)
    {
      ae.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
      AppMethodBeat.o(141588);
      return;
    }
    if (this.GbL <= 0)
    {
      ae.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
      AppMethodBeat.o(141588);
      return;
    }
    int j = paramb.aTk();
    int i = 1;
    if (i <= this.GbL)
    {
      String str;
      if (this.direction == 1)
      {
        if (paramInt - i < 0)
        {
          AppMethodBeat.o(141588);
          return;
        }
        str = paramb.rq(paramInt - i);
        if ((str != null) && (str.length() != 0) && (!this.JCu.contains(str)))
        {
          this.JCu.EL(str);
          this.JCv.add(str);
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
        str = paramb.rq(paramInt + i);
        if ((str != null) && (str.length() != 0) && (!this.JCu.contains(str)))
        {
          this.JCu.EL(str);
          this.JCv.add(str);
        }
      }
    }
    AppMethodBeat.o(141588);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(141590);
    if (this.omO != null) {
      Looper.myQueue().removeIdleHandler(this.omO);
    }
    AppMethodBeat.o(141590);
  }
  
  public final void onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141589);
    if (this.iNw != null)
    {
      GestureDetector localGestureDetector = this.iNw;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.ahE(), "com/tencent/mm/ui/applet/EarlyGetHeadImg", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.mt(0)), "com/tencent/mm/ui/applet/EarlyGetHeadImg", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    AppMethodBeat.o(141589);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap Kc(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract int aTk();
    
    public abstract String rq(int paramInt);
  }
  
  final class c
  {
    private LinkedList<String> fXm;
    private int maxSize;
    
    public c()
    {
      AppMethodBeat.i(141584);
      this.fXm = null;
      this.maxSize = 40;
      this.fXm = new LinkedList();
      AppMethodBeat.o(141584);
    }
    
    final void EL(String paramString)
    {
      AppMethodBeat.i(141585);
      if (this.fXm.contains(paramString))
      {
        AppMethodBeat.o(141585);
        return;
      }
      this.fXm.add(paramString);
      if (this.fXm.size() >= this.maxSize) {
        this.fXm.removeFirst();
      }
      AppMethodBeat.o(141585);
    }
    
    final boolean contains(String paramString)
    {
      AppMethodBeat.i(141586);
      boolean bool = this.fXm.contains(paramString);
      AppMethodBeat.o(141586);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */