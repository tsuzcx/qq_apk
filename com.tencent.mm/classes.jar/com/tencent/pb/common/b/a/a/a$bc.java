package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$bc
  extends e
{
  private static volatile bc[] Mgn;
  public int Mgo = 0;
  public int Mgp = 0;
  public int Mgq = 0;
  public int phB = 0;
  public int rtt = 0;
  
  public a$bc()
  {
    this.bQO = -1;
  }
  
  public static bc[] fXH()
  {
    if (Mgn == null) {}
    synchronized (c.bQN)
    {
      if (Mgn == null) {
        Mgn = new bc[0];
      }
      return Mgn;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.phB != 0) {
      paramb.bx(1, this.phB);
    }
    if (this.rtt != 0) {
      paramb.bx(2, this.rtt);
    }
    if (this.Mgo != 0) {
      paramb.bx(3, this.Mgo);
    }
    if (this.Mgp != 0) {
      paramb.bx(4, this.Mgp);
    }
    if (this.Mgq != 0) {
      paramb.bx(5, this.Mgq);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.phB != 0) {
      i = j + b.bz(1, this.phB);
    }
    j = i;
    if (this.rtt != 0) {
      j = i + b.bz(2, this.rtt);
    }
    i = j;
    if (this.Mgo != 0) {
      i = j + b.bz(3, this.Mgo);
    }
    j = i;
    if (this.Mgp != 0) {
      j = i + b.bz(4, this.Mgp);
    }
    i = j;
    if (this.Mgq != 0) {
      i = j + b.bz(5, this.Mgq);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bc
 * JD-Core Version:    0.7.0.1
 */