package com.tencent.mm.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class b
{
  private int CKE;
  private c FUe;
  LinkedList<String> FUf;
  a FUg;
  int direction;
  private GestureDetector hRv;
  private MessageQueue.IdleHandler nbI;
  
  public b(a parama)
  {
    AppMethodBeat.i(141587);
    this.direction = 0;
    this.hRv = new GestureDetector(new GestureDetector.OnGestureListener()
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
    this.FUg = parama;
    this.CKE = 15;
    this.FUe = new c();
    this.FUf = new LinkedList();
    this.nbI = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(141583);
        while (b.this.FUf.size() > 0)
        {
          String str = (String)b.this.FUf.removeFirst();
          b.this.FUg.Cl(str);
        }
        AppMethodBeat.o(141583);
        return true;
      }
    };
    Looper.myQueue().addIdleHandler(this.nbI);
    AppMethodBeat.o(141587);
  }
  
  public final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(141588);
    if (paramb == null)
    {
      ad.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
      AppMethodBeat.o(141588);
      return;
    }
    if (this.CKE <= 0)
    {
      ad.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
      AppMethodBeat.o(141588);
      return;
    }
    int j = paramb.aII();
    int i = 1;
    if (i <= this.CKE)
    {
      String str;
      if (this.direction == 1)
      {
        if (paramInt - i < 0)
        {
          AppMethodBeat.o(141588);
          return;
        }
        str = paramb.qa(paramInt - i);
        if ((str != null) && (str.length() != 0) && (!this.FUe.contains(str)))
        {
          this.FUe.xe(str);
          this.FUf.add(str);
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
        str = paramb.qa(paramInt + i);
        if ((str != null) && (str.length() != 0) && (!this.FUe.contains(str)))
        {
          this.FUe.xe(str);
          this.FUf.add(str);
        }
      }
    }
    AppMethodBeat.o(141588);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(141590);
    if (this.nbI != null) {
      Looper.myQueue().removeIdleHandler(this.nbI);
    }
    AppMethodBeat.o(141590);
  }
  
  public final void onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141589);
    if (this.hRv != null) {
      this.hRv.onTouchEvent(paramMotionEvent);
    }
    AppMethodBeat.o(141589);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap Cl(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract int aII();
    
    public abstract String qa(int paramInt);
  }
  
  final class c
  {
    private LinkedList<String> fyl;
    private int maxSize;
    
    public c()
    {
      AppMethodBeat.i(141584);
      this.fyl = null;
      this.maxSize = 40;
      this.fyl = new LinkedList();
      AppMethodBeat.o(141584);
    }
    
    final boolean contains(String paramString)
    {
      AppMethodBeat.i(141586);
      boolean bool = this.fyl.contains(paramString);
      AppMethodBeat.o(141586);
      return bool;
    }
    
    final void xe(String paramString)
    {
      AppMethodBeat.i(141585);
      if (this.fyl.contains(paramString))
      {
        AppMethodBeat.o(141585);
        return;
      }
      this.fyl.add(paramString);
      if (this.fyl.size() >= this.maxSize) {
        this.fyl.removeFirst();
      }
      AppMethodBeat.o(141585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */