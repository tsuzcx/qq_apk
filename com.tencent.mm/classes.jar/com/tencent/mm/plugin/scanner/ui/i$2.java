package com.tencent.mm.plugin.scanner.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.y;

final class i$2
  extends GestureDetector.SimpleOnGestureListener
{
  i$2(i parami) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    y.d("MicroMsg.scanner.ScanMode", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramMotionEvent.getActionIndex()), Float.valueOf(paramMotionEvent.getX(paramMotionEvent.getActionIndex())), Float.valueOf(paramMotionEvent.getY(paramMotionEvent.getActionIndex())) });
    this.nLF.nLB.V(5, 2, 100);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.i.2
 * JD-Core Version:    0.7.0.1
 */