package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ap
  extends e
{
  private static volatile ap[] MeS;
  public int FHN = 0;
  public int MeT = 0;
  public int MeU = 0;
  public int MeV = 0;
  public String duC = "";
  public int pcE = 0;
  
  public a$ap()
  {
    this.bQO = -1;
  }
  
  public static ap[] fXB()
  {
    if (MeS == null) {}
    synchronized (c.bQN)
    {
      if (MeS == null) {
        MeS = new ap[0];
      }
      return MeS;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.pcE != 0) {
      paramb.by(1, this.pcE);
    }
    if (!this.duC.equals("")) {
      paramb.d(2, this.duC);
    }
    if (this.FHN != 0) {
      paramb.by(3, this.FHN);
    }
    if (this.MeT != 0) {
      paramb.by(4, this.MeT);
    }
    if (this.MeU != 0) {
      paramb.by(5, this.MeU);
    }
    if (this.MeV != 0) {
      paramb.by(6, this.MeV);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.pcE != 0) {
      i = j + b.bA(1, this.pcE);
    }
    j = i;
    if (!this.duC.equals("")) {
      j = i + b.e(2, this.duC);
    }
    i = j;
    if (this.FHN != 0) {
      i = j + b.bA(3, this.FHN);
    }
    j = i;
    if (this.MeT != 0) {
      j = i + b.bA(4, this.MeT);
    }
    i = j;
    if (this.MeU != 0) {
      i = j + b.bA(5, this.MeU);
    }
    j = i;
    if (this.MeV != 0) {
      j = i + b.bA(6, this.MeV);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ap
 * JD-Core Version:    0.7.0.1
 */