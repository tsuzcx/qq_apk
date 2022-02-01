package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ap
  extends e
{
  private static volatile ap[] JOe;
  public int DKi = 0;
  public int JOf = 0;
  public String dhV = "";
  public int osF = 0;
  
  public a$ap()
  {
    this.bGA = -1;
  }
  
  public static ap[] fBM()
  {
    if (JOe == null) {}
    synchronized (c.bGz)
    {
      if (JOe == null) {
        JOe = new ap[0];
      }
      return JOe;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.osF != 0) {
      paramb.bw(1, this.osF);
    }
    if (!this.dhV.equals("")) {
      paramb.d(2, this.dhV);
    }
    if (this.DKi != 0) {
      paramb.bw(3, this.DKi);
    }
    if (this.JOf != 0) {
      paramb.bw(4, this.JOf);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.osF != 0) {
      i = j + b.by(1, this.osF);
    }
    j = i;
    if (!this.dhV.equals("")) {
      j = i + b.e(2, this.dhV);
    }
    i = j;
    if (this.DKi != 0) {
      i = j + b.by(3, this.DKi);
    }
    j = i;
    if (this.JOf != 0) {
      j = i + b.by(4, this.JOf);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ap
 * JD-Core Version:    0.7.0.1
 */