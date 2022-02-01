package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ay
  extends e
{
  private static volatile ay[] Inl;
  public int CrQ = 0;
  public int IkM = 0;
  public byte[] IkR = g.bIZ;
  public String Imu = "";
  public int InA = 0;
  public a.t InB = null;
  public int InC = -1;
  public String InD = "";
  public int InE = 0;
  public int InF = 0;
  public int InG = 0;
  public int Inm = 0;
  public int Inn = 0;
  public a.at Ino = null;
  public int Inp = 0;
  public String Inq = "";
  public a.au[] Inr = a.au.flx();
  public int Ins = 0;
  public int[] Int = g.bIT;
  public int Inu = 0;
  public int Inv = 0;
  public int Inw = 0;
  public int Inx = 0;
  public a.aq Iny = null;
  public String Inz = "";
  public int bvJ = 0;
  public int nPB = -1;
  public int platform = 0;
  public int status = 0;
  public int zCC = 0;
  
  public a$ay()
  {
    this.bIS = -1;
  }
  
  public static ay[] flz()
  {
    if (Inl == null) {}
    synchronized (c.bIR)
    {
      if (Inl == null) {
        Inl = new ay[0];
      }
      return Inl;
    }
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.CrQ != 0) {
      paramb.bz(1, this.CrQ);
    }
    if (this.Inm != 0) {
      paramb.bz(2, this.Inm);
    }
    if (this.status != 0) {
      paramb.bz(3, this.status);
    }
    if (this.bvJ != 0) {
      paramb.bz(4, this.bvJ);
    }
    if (this.nPB != -1) {
      paramb.by(5, this.nPB);
    }
    if (this.Inn != 0) {
      paramb.bz(6, this.Inn);
    }
    if (this.Ino != null) {
      paramb.a(7, this.Ino);
    }
    if (this.Inp != 0) {
      paramb.bz(8, this.Inp);
    }
    if (!this.Inq.equals("")) {
      paramb.d(9, this.Inq);
    }
    int i;
    if ((this.Inr != null) && (this.Inr.length > 0))
    {
      i = 0;
      while (i < this.Inr.length)
      {
        a.au localau = this.Inr[i];
        if (localau != null) {
          paramb.a(10, localau);
        }
        i += 1;
      }
    }
    if (this.Ins != 0) {
      paramb.bz(11, this.Ins);
    }
    if ((this.Int != null) && (this.Int.length > 0))
    {
      i = j;
      while (i < this.Int.length)
      {
        paramb.bz(12, this.Int[i]);
        i += 1;
      }
    }
    if (this.Inu != 0) {
      paramb.bz(13, this.Inu);
    }
    if (this.Inv != 0) {
      paramb.bz(14, this.Inv);
    }
    if (this.Inw != 0) {
      paramb.bz(15, this.Inw);
    }
    if (this.Inx != 0) {
      paramb.bz(16, this.Inx);
    }
    if (this.Iny != null) {
      paramb.a(17, this.Iny);
    }
    if (!this.Imu.equals("")) {
      paramb.d(100, this.Imu);
    }
    if (!this.Inz.equals("")) {
      paramb.d(101, this.Inz);
    }
    if (this.InA != 0) {
      paramb.bz(102, this.InA);
    }
    if (!Arrays.equals(this.IkR, g.bIZ)) {
      paramb.b(200, this.IkR);
    }
    if (this.InB != null) {
      paramb.a(201, this.InB);
    }
    if (this.InC != -1) {
      paramb.by(202, this.InC);
    }
    if (!this.InD.equals("")) {
      paramb.d(203, this.InD);
    }
    if (this.platform != 0) {
      paramb.by(204, this.platform);
    }
    if (this.InE != 0) {
      paramb.bz(205, this.InE);
    }
    if (this.zCC != 0) {
      paramb.bz(206, this.zCC);
    }
    if (this.InF != 0) {
      paramb.bz(207, this.InF);
    }
    if (this.InG != 0) {
      paramb.bz(208, this.InG);
    }
    if (this.IkM != 0) {
      paramb.bz(240, this.IkM);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.CrQ != 0) {
      i = j + b.bB(1, this.CrQ);
    }
    j = i;
    if (this.Inm != 0) {
      j = i + b.bB(2, this.Inm);
    }
    i = j;
    if (this.status != 0) {
      i = j + b.bB(3, this.status);
    }
    j = i;
    if (this.bvJ != 0) {
      j = i + b.bB(4, this.bvJ);
    }
    i = j;
    if (this.nPB != -1) {
      i = j + b.bA(5, this.nPB);
    }
    j = i;
    if (this.Inn != 0) {
      j = i + b.bB(6, this.Inn);
    }
    i = j;
    if (this.Ino != null) {
      i = j + b.b(7, this.Ino);
    }
    j = i;
    if (this.Inp != 0) {
      j = i + b.bB(8, this.Inp);
    }
    i = j;
    if (!this.Inq.equals("")) {
      i = j + b.e(9, this.Inq);
    }
    j = i;
    int k;
    if (this.Inr != null)
    {
      j = i;
      if (this.Inr.length > 0)
      {
        j = 0;
        while (j < this.Inr.length)
        {
          a.au localau = this.Inr[j];
          k = i;
          if (localau != null) {
            k = i + b.b(10, localau);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.Ins != 0) {
      i = j + b.bB(11, this.Ins);
    }
    j = i;
    if (this.Int != null)
    {
      j = i;
      if (this.Int.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.Int.length)
        {
          k += b.ga(this.Int[j]);
          j += 1;
        }
        j = i + k + this.Int.length * 1;
      }
    }
    i = j;
    if (this.Inu != 0) {
      i = j + b.bB(13, this.Inu);
    }
    j = i;
    if (this.Inv != 0) {
      j = i + b.bB(14, this.Inv);
    }
    i = j;
    if (this.Inw != 0) {
      i = j + b.bB(15, this.Inw);
    }
    j = i;
    if (this.Inx != 0) {
      j = i + b.bB(16, this.Inx);
    }
    i = j;
    if (this.Iny != null) {
      i = j + b.b(17, this.Iny);
    }
    j = i;
    if (!this.Imu.equals("")) {
      j = i + b.e(100, this.Imu);
    }
    i = j;
    if (!this.Inz.equals("")) {
      i = j + b.e(101, this.Inz);
    }
    j = i;
    if (this.InA != 0) {
      j = i + b.bB(102, this.InA);
    }
    i = j;
    if (!Arrays.equals(this.IkR, g.bIZ)) {
      i = j + b.c(200, this.IkR);
    }
    j = i;
    if (this.InB != null) {
      j = i + b.b(201, this.InB);
    }
    i = j;
    if (this.InC != -1) {
      i = j + b.bA(202, this.InC);
    }
    j = i;
    if (!this.InD.equals("")) {
      j = i + b.e(203, this.InD);
    }
    i = j;
    if (this.platform != 0) {
      i = j + b.bA(204, this.platform);
    }
    j = i;
    if (this.InE != 0) {
      j = i + b.bB(205, this.InE);
    }
    i = j;
    if (this.zCC != 0) {
      i = j + b.bB(206, this.zCC);
    }
    j = i;
    if (this.InF != 0) {
      j = i + b.bB(207, this.InF);
    }
    i = j;
    if (this.InG != 0) {
      i = j + b.bB(208, this.InG);
    }
    j = i;
    if (this.IkM != 0) {
      j = i + b.bB(240, this.IkM);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ay
 * JD-Core Version:    0.7.0.1
 */