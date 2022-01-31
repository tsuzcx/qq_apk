package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Color;
import android.location.Location;

public class po
  extends pa
{
  private nx a = null;
  private ou b = null;
  private ow c = null;
  private ae.a d = null;
  private ae e = null;
  private boolean f = false;
  private qf g = null;
  private pv h = null;
  private ah.n i = null;
  private qh j = new qh();
  private int k = Color.argb(102, 0, 163, 255);
  private Location l = null;
  
  public po(nx paramnx, ou paramou, ow paramow)
  {
    this.a = paramnx;
    this.b = paramou;
    this.c = paramow;
    this.d = f();
  }
  
  private ae.a f()
  {
    return new po.1(this);
  }
  
  boolean a()
  {
    if (this.f == true) {}
    do
    {
      return true;
      this.f = true;
      if (this.d == null) {
        this.d = f();
      }
      if (this.g != null) {
        this.g.b(true);
      }
      if (this.h != null) {
        this.h.a(true);
      }
    } while (this.e == null);
    this.e.a(this.d);
    return true;
  }
  
  void b()
  {
    if (this.g != null)
    {
      this.g.b(false);
      this.g.b();
      this.g = null;
    }
    if (this.h != null)
    {
      this.h.a(false);
      this.h.b();
      this.h = null;
    }
    if (!this.f) {}
    do
    {
      return;
      this.f = false;
      this.d = null;
    } while (this.e == null);
    this.e.a();
  }
  
  boolean c()
  {
    return this.f;
  }
  
  Location d()
  {
    if (this.l == null) {
      return null;
    }
    return new Location(this.l);
  }
  
  public void e()
  {
    b();
    this.a = null;
    this.b = null;
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.po
 * JD-Core Version:    0.7.0.1
 */