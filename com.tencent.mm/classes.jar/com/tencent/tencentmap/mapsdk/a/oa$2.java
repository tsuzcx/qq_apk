package com.tencent.tencentmap.mapsdk.a;

import android.view.MotionEvent;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.f;

class oa$2
  implements oa.a
{
  private qf b = null;
  private boolean c = false;
  
  oa$2(oa paramoa) {}
  
  public void a()
  {
    this.c = false;
    this.b = null;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((oa.b(this.a) == null) || (!this.c) || (this.b == null)) {}
    do
    {
      return;
      ah.m localm = this.b.s();
      switch (paramMotionEvent.getAction())
      {
      case 0: 
      default: 
        return;
      case 1: 
      case 3: 
      case 4: 
        this.c = false;
        if (localm != null) {
          localm.c(this.b);
        }
        if (oa.c(this.a) != null) {
          oa.c(this.a).c(this.b);
        }
        this.b = null;
        return;
      }
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      paramMotionEvent = new DoublePoint(i, j);
      paramMotionEvent = lq.a(oa.b(this.a).getMap().t().a(paramMotionEvent));
      this.b.a(paramMotionEvent);
      if (localm != null) {
        localm.b(this.b);
      }
    } while (oa.c(this.a) == null);
    oa.c(this.a).b(this.b);
  }
  
  public void a(String paramString)
  {
    if (paramString.trim().length() == 0)
    {
      this.b = null;
      this.c = false;
    }
    do
    {
      do
      {
        return;
        this.b = oa.a(this.a, paramString);
      } while (this.b == null);
      if (!this.b.i())
      {
        this.b = null;
        this.c = false;
        return;
      }
      this.c = true;
    } while (oa.c(this.a) == null);
    oa.c(this.a).a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.oa.2
 * JD-Core Version:    0.7.0.1
 */