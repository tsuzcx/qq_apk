package com.tencent.mm.ui.applet;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class b
{
  int direction = 0;
  private GestureDetector jEK = new GestureDetector(new b.2(this));
  private MessageQueue.IdleHandler uKq;
  private int uRY;
  private b.c uRZ;
  LinkedList<String> uSa;
  b.a uSb;
  
  public b(b.a parama)
  {
    this.uSb = parama;
    this.uRY = 15;
    this.uRZ = new b.c(this);
    this.uSa = new LinkedList();
    this.uKq = new b.1(this);
    Looper.myQueue().addIdleHandler(this.uKq);
  }
  
  public final void a(int paramInt, b.b paramb)
  {
    if (paramb == null) {
      y.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
    }
    int j;
    int i;
    label37:
    do
    {
      return;
      if (this.uRY <= 0)
      {
        y.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
        return;
      }
      j = paramb.WL();
      i = 1;
      if (i > this.uRY) {
        break;
      }
      if (this.direction != 1) {
        break label121;
      }
    } while (paramInt - i < 0);
    String str = paramb.jX(paramInt - i);
    if ((str != null) && (str.length() != 0) && (!this.uRZ.contains(str)))
    {
      this.uRZ.qh(str);
      this.uSa.add(str);
    }
    for (;;)
    {
      i += 1;
      break label37;
      break;
      label121:
      if (paramInt + i >= j) {
        break;
      }
      str = paramb.jX(paramInt + i);
      if ((str != null) && (str.length() != 0) && (!this.uRZ.contains(str)))
      {
        this.uRZ.qh(str);
        this.uSa.add(str);
      }
    }
  }
  
  public final void detach()
  {
    if (this.uKq != null) {
      Looper.myQueue().removeIdleHandler(this.uKq);
    }
  }
  
  public final void onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jEK != null) {
      this.jEK.onTouchEvent(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b
 * JD-Core Version:    0.7.0.1
 */