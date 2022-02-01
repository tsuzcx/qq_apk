package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ap
  extends e
{
  private static volatile ap[] LHO;
  public int Fpp = 0;
  public int LHP = 0;
  public int LHQ = 0;
  public int LHR = 0;
  public String dtx = "";
  public int oWb = 0;
  
  public a$ap()
  {
    this.bQO = -1;
  }
  
  public static ap[] fTb()
  {
    if (LHO == null) {}
    synchronized (c.bQN)
    {
      if (LHO == null) {
        LHO = new ap[0];
      }
      return LHO;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.oWb != 0) {
      paramb.by(1, this.oWb);
    }
    if (!this.dtx.equals("")) {
      paramb.d(2, this.dtx);
    }
    if (this.Fpp != 0) {
      paramb.by(3, this.Fpp);
    }
    if (this.LHP != 0) {
      paramb.by(4, this.LHP);
    }
    if (this.LHQ != 0) {
      paramb.by(5, this.LHQ);
    }
    if (this.LHR != 0) {
      paramb.by(6, this.LHR);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.oWb != 0) {
      i = j + b.bA(1, this.oWb);
    }
    j = i;
    if (!this.dtx.equals("")) {
      j = i + b.e(2, this.dtx);
    }
    i = j;
    if (this.Fpp != 0) {
      i = j + b.bA(3, this.Fpp);
    }
    j = i;
    if (this.LHP != 0) {
      j = i + b.bA(4, this.LHP);
    }
    i = j;
    if (this.LHQ != 0) {
      i = j + b.bA(5, this.LHQ);
    }
    j = i;
    if (this.LHR != 0) {
      j = i + b.bA(6, this.LHR);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ap
 * JD-Core Version:    0.7.0.1
 */