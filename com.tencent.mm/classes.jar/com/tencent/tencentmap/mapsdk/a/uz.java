package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.view.MotionEvent;

public class uz
  implements tx
{
  protected boolean a = true;
  protected float b = 0.0F;
  protected tn c;
  protected uy d;
  protected th e;
  protected String f = j();
  
  public void a() {}
  
  public void a(Canvas paramCanvas)
  {
    a(paramCanvas, this.d);
  }
  
  protected void a(Canvas paramCanvas, uy paramuy) {}
  
  public void a(rx paramrx) {}
  
  public boolean a(MotionEvent paramMotionEvent, uy paramuy)
  {
    return false;
  }
  
  public boolean a(rx paramrx, MotionEvent paramMotionEvent, uy paramuy)
  {
    return false;
  }
  
  public boolean a(rx paramrx, uy paramuy)
  {
    return false;
  }
  
  public boolean a(tx paramtx)
  {
    return (equals(paramtx)) || (paramtx.j().equals(j()));
  }
  
  public void b(float paramFloat)
  {
    this.b = paramFloat;
    this.e.c();
    this.c.a(false, false);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
    this.c.a(false, false);
  }
  
  public boolean h()
  {
    return false;
  }
  
  public void i()
  {
    this.e.b(j());
    a();
  }
  
  public String j()
  {
    if (this.f == null) {
      this.f = th.a("Overlay");
    }
    return this.f;
  }
  
  public float k()
  {
    return this.b;
  }
  
  public boolean l()
  {
    return this.a;
  }
  
  public int m()
  {
    return 0;
  }
  
  public void n() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uz
 * JD-Core Version:    0.7.0.1
 */