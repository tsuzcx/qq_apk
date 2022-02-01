package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$bc
  extends e
{
  private static volatile bc[] JPx;
  public int JPA = 0;
  public int JPy = 0;
  public int JPz = 0;
  public int oxC = 0;
  public int rtt = 0;
  
  public a$bc()
  {
    this.bGA = -1;
  }
  
  public static bc[] fBS()
  {
    if (JPx == null) {}
    synchronized (c.bGz)
    {
      if (JPx == null) {
        JPx = new bc[0];
      }
      return JPx;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.oxC != 0) {
      paramb.bv(1, this.oxC);
    }
    if (this.rtt != 0) {
      paramb.bv(2, this.rtt);
    }
    if (this.JPy != 0) {
      paramb.bv(3, this.JPy);
    }
    if (this.JPz != 0) {
      paramb.bv(4, this.JPz);
    }
    if (this.JPA != 0) {
      paramb.bv(5, this.JPA);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.oxC != 0) {
      i = j + b.bx(1, this.oxC);
    }
    j = i;
    if (this.rtt != 0) {
      j = i + b.bx(2, this.rtt);
    }
    i = j;
    if (this.JPy != 0) {
      i = j + b.bx(3, this.JPy);
    }
    j = i;
    if (this.JPz != 0) {
      j = i + b.bx(4, this.JPz);
    }
    i = j;
    if (this.JPA != 0) {
      i = j + b.bx(5, this.JPA);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bc
 * JD-Core Version:    0.7.0.1
 */