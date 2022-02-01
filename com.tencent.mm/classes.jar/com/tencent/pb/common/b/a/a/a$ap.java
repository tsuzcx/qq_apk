package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ap
  extends e
{
  private static volatile ap[] Imt;
  public int CrQ = 0;
  public String Imu = "";
  public int Imv = 0;
  public int nPB = 0;
  
  public a$ap()
  {
    this.bIS = -1;
  }
  
  public static ap[] flv()
  {
    if (Imt == null) {}
    synchronized (c.bIR)
    {
      if (Imt == null) {
        Imt = new ap[0];
      }
      return Imt;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.nPB != 0) {
      paramb.bz(1, this.nPB);
    }
    if (!this.Imu.equals("")) {
      paramb.d(2, this.Imu);
    }
    if (this.CrQ != 0) {
      paramb.bz(3, this.CrQ);
    }
    if (this.Imv != 0) {
      paramb.bz(4, this.Imv);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.nPB != 0) {
      i = j + b.bB(1, this.nPB);
    }
    j = i;
    if (!this.Imu.equals("")) {
      j = i + b.e(2, this.Imu);
    }
    i = j;
    if (this.CrQ != 0) {
      i = j + b.bB(3, this.CrQ);
    }
    j = i;
    if (this.Imv != 0) {
      j = i + b.bB(4, this.Imv);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ap
 * JD-Core Version:    0.7.0.1
 */