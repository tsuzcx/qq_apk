package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$y
  extends e
{
  private static volatile y[] REI;
  public String REJ = "";
  public String sXO = "";
  
  public a$y()
  {
    this.cbo = -1;
  }
  
  public static y[] hje()
  {
    if (REI == null) {}
    synchronized (c.cbn)
    {
      if (REI == null) {
        REI = new y[0];
      }
      return REI;
    }
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (!this.sXO.equals("")) {
      i = j + b.f(1, this.sXO);
    }
    j = i;
    if (!this.REJ.equals("")) {
      j = i + b.f(2, this.REJ);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (!this.sXO.equals("")) {
      paramb.e(1, this.sXO);
    }
    if (!this.REJ.equals("")) {
      paramb.e(2, this.REJ);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.y
 * JD-Core Version:    0.7.0.1
 */