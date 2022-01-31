package com.tencent.mm.ui.applet;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class b
{
  int direction;
  private MessageQueue.IdleHandler jZm;
  private GestureDetector lOj;
  private b.c zgA;
  LinkedList<String> zgB;
  b.a zgC;
  private int zgz;
  
  public b(b.a parama)
  {
    AppMethodBeat.i(106227);
    this.direction = 0;
    this.lOj = new GestureDetector(new b.2(this));
    this.zgC = parama;
    this.zgz = 15;
    this.zgA = new b.c(this);
    this.zgB = new LinkedList();
    this.jZm = new b.1(this);
    Looper.myQueue().addIdleHandler(this.jZm);
    AppMethodBeat.o(106227);
  }
  
  public final void a(int paramInt, b.b paramb)
  {
    AppMethodBeat.i(106228);
    if (paramb == null)
    {
      ab.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
      AppMethodBeat.o(106228);
      return;
    }
    if (this.zgz <= 0)
    {
      ab.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
      AppMethodBeat.o(106228);
      return;
    }
    int j = paramb.aqn();
    int i = 1;
    if (i <= this.zgz)
    {
      String str;
      if (this.direction == 1)
      {
        if (paramInt - i < 0)
        {
          AppMethodBeat.o(106228);
          return;
        }
        str = paramb.mS(paramInt - i);
        if ((str != null) && (str.length() != 0) && (!this.zgA.contains(str)))
        {
          this.zgA.xB(str);
          this.zgB.add(str);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt + i >= j)
        {
          AppMethodBeat.o(106228);
          return;
        }
        str = paramb.mS(paramInt + i);
        if ((str != null) && (str.length() != 0) && (!this.zgA.contains(str)))
        {
          this.zgA.xB(str);
          this.zgB.add(str);
        }
      }
    }
    AppMethodBeat.o(106228);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(106230);
    if (this.jZm != null) {
      Looper.myQueue().removeIdleHandler(this.jZm);
    }
    AppMethodBeat.o(106230);
  }
  
  public final void onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106229);
    if (this.lOj != null) {
      this.lOj.onTouchEvent(paramMotionEvent);
    }
    AppMethodBeat.o(106229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */