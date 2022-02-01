package com.tencent.mm.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class b
{
  private int Edg;
  private c HtT;
  LinkedList<String> HtU;
  a HtV;
  int direction;
  private GestureDetector irA;
  private MessageQueue.IdleHandler nEp;
  
  public b(a parama)
  {
    AppMethodBeat.i(141587);
    this.direction = 0;
    this.irA = new GestureDetector(new GestureDetector.OnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
      
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
        return false;
      }
    });
    this.HtV = parama;
    this.Edg = 15;
    this.HtT = new c();
    this.HtU = new LinkedList();
    this.nEp = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(141583);
        while (b.this.HtU.size() > 0)
        {
          String str = (String)b.this.HtU.removeFirst();
          b.this.HtV.Go(str);
        }
        AppMethodBeat.o(141583);
        return true;
      }
    };
    Looper.myQueue().addIdleHandler(this.nEp);
    AppMethodBeat.o(141587);
  }
  
  public final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(141588);
    if (paramb == null)
    {
      ac.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
      AppMethodBeat.o(141588);
      return;
    }
    if (this.Edg <= 0)
    {
      ac.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
      AppMethodBeat.o(141588);
      return;
    }
    int j = paramb.aPz();
    int i = 1;
    if (i <= this.Edg)
    {
      String str;
      if (this.direction == 1)
      {
        if (paramInt - i < 0)
        {
          AppMethodBeat.o(141588);
          return;
        }
        str = paramb.qN(paramInt - i);
        if ((str != null) && (str.length() != 0) && (!this.HtT.contains(str)))
        {
          this.HtT.Bk(str);
          this.HtU.add(str);
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
        str = paramb.qN(paramInt + i);
        if ((str != null) && (str.length() != 0) && (!this.HtT.contains(str)))
        {
          this.HtT.Bk(str);
          this.HtU.add(str);
        }
      }
    }
    AppMethodBeat.o(141588);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(141590);
    if (this.nEp != null) {
      Looper.myQueue().removeIdleHandler(this.nEp);
    }
    AppMethodBeat.o(141590);
  }
  
  public final void onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141589);
    if (this.irA != null) {
      this.irA.onTouchEvent(paramMotionEvent);
    }
    AppMethodBeat.o(141589);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap Go(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract int aPz();
    
    public abstract String qN(int paramInt);
  }
  
  final class c
  {
    private LinkedList<String> fBS;
    private int maxSize;
    
    public c()
    {
      AppMethodBeat.i(141584);
      this.fBS = null;
      this.maxSize = 40;
      this.fBS = new LinkedList();
      AppMethodBeat.o(141584);
    }
    
    final void Bk(String paramString)
    {
      AppMethodBeat.i(141585);
      if (this.fBS.contains(paramString))
      {
        AppMethodBeat.o(141585);
        return;
      }
      this.fBS.add(paramString);
      if (this.fBS.size() >= this.maxSize) {
        this.fBS.removeFirst();
      }
      AppMethodBeat.o(141585);
    }
    
    final boolean contains(String paramString)
    {
      AppMethodBeat.i(141586);
      boolean bool = this.fBS.contains(paramString);
      AppMethodBeat.o(141586);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */