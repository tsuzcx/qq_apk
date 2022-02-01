package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ay
  extends e
{
  private static volatile ay[] LIH;
  public int CuX = 0;
  public int Fpp = 0;
  public int LGg = 0;
  public byte[] LGl = g.bQV;
  public int LII = 0;
  public int LIJ = 0;
  public a.at LIK = null;
  public int LIL = 0;
  public String LIM = "";
  public a.au[] LIN = a.au.fTd();
  public int LIO = 0;
  public int[] LIP = g.bQP;
  public int LIQ = 0;
  public int LIR = 0;
  public int LIS = 0;
  public int LIT = 0;
  public a.aq LIU = null;
  public String LIV = "";
  public int LIW = 0;
  public a.t LIX = null;
  public int LIY = -1;
  public String LIZ = "";
  public int LJa = 0;
  public int LJb = 0;
  public int LJc = 0;
  public String dtx = "";
  public int oWb = -1;
  public int platform = 0;
  public int reason = 0;
  public int status = 0;
  
  public a$ay()
  {
    this.bQO = -1;
  }
  
  public static ay[] fTf()
  {
    if (LIH == null) {}
    synchronized (c.bQN)
    {
      if (LIH == null) {
        LIH = new ay[0];
      }
      return LIH;
    }
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.Fpp != 0) {
      paramb.by(1, this.Fpp);
    }
    if (this.LII != 0) {
      paramb.by(2, this.LII);
    }
    if (this.status != 0) {
      paramb.by(3, this.status);
    }
    if (this.reason != 0) {
      paramb.by(4, this.reason);
    }
    if (this.oWb != -1) {
      paramb.bx(5, this.oWb);
    }
    if (this.LIJ != 0) {
      paramb.by(6, this.LIJ);
    }
    if (this.LIK != null) {
      paramb.a(7, this.LIK);
    }
    if (this.LIL != 0) {
      paramb.by(8, this.LIL);
    }
    if (!this.LIM.equals("")) {
      paramb.d(9, this.LIM);
    }
    int i;
    if ((this.LIN != null) && (this.LIN.length > 0))
    {
      i = 0;
      while (i < this.LIN.length)
      {
        a.au localau = this.LIN[i];
        if (localau != null) {
          paramb.a(10, localau);
        }
        i += 1;
      }
    }
    if (this.LIO != 0) {
      paramb.by(11, this.LIO);
    }
    if ((this.LIP != null) && (this.LIP.length > 0))
    {
      i = j;
      while (i < this.LIP.length)
      {
        paramb.by(12, this.LIP[i]);
        i += 1;
      }
    }
    if (this.LIQ != 0) {
      paramb.by(13, this.LIQ);
    }
    if (this.LIR != 0) {
      paramb.by(14, this.LIR);
    }
    if (this.LIS != 0) {
      paramb.by(15, this.LIS);
    }
    if (this.LIT != 0) {
      paramb.by(16, this.LIT);
    }
    if (this.LIU != null) {
      paramb.a(17, this.LIU);
    }
    if (!this.dtx.equals("")) {
      paramb.d(100, this.dtx);
    }
    if (!this.LIV.equals("")) {
      paramb.d(101, this.LIV);
    }
    if (this.LIW != 0) {
      paramb.by(102, this.LIW);
    }
    if (!Arrays.equals(this.LGl, g.bQV)) {
      paramb.b(200, this.LGl);
    }
    if (this.LIX != null) {
      paramb.a(201, this.LIX);
    }
    if (this.LIY != -1) {
      paramb.bx(202, this.LIY);
    }
    if (!this.LIZ.equals("")) {
      paramb.d(203, this.LIZ);
    }
    if (this.platform != 0) {
      paramb.bx(204, this.platform);
    }
    if (this.LJa != 0) {
      paramb.by(205, this.LJa);
    }
    if (this.CuX != 0) {
      paramb.by(206, this.CuX);
    }
    if (this.LJb != 0) {
      paramb.by(207, this.LJb);
    }
    if (this.LJc != 0) {
      paramb.by(208, this.LJc);
    }
    if (this.LGg != 0) {
      paramb.by(240, this.LGg);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.Fpp != 0) {
      i = j + b.bA(1, this.Fpp);
    }
    j = i;
    if (this.LII != 0) {
      j = i + b.bA(2, this.LII);
    }
    i = j;
    if (this.status != 0) {
      i = j + b.bA(3, this.status);
    }
    j = i;
    if (this.reason != 0) {
      j = i + b.bA(4, this.reason);
    }
    i = j;
    if (this.oWb != -1) {
      i = j + b.bz(5, this.oWb);
    }
    j = i;
    if (this.LIJ != 0) {
      j = i + b.bA(6, this.LIJ);
    }
    i = j;
    if (this.LIK != null) {
      i = j + b.b(7, this.LIK);
    }
    j = i;
    if (this.LIL != 0) {
      j = i + b.bA(8, this.LIL);
    }
    i = j;
    if (!this.LIM.equals("")) {
      i = j + b.e(9, this.LIM);
    }
    j = i;
    int k;
    if (this.LIN != null)
    {
      j = i;
      if (this.LIN.length > 0)
      {
        j = 0;
        while (j < this.LIN.length)
        {
          a.au localau = this.LIN[j];
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
    if (this.LIO != 0) {
      i = j + b.bA(11, this.LIO);
    }
    j = i;
    if (this.LIP != null)
    {
      j = i;
      if (this.LIP.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.LIP.length)
        {
          k += b.fP(this.LIP[j]);
          j += 1;
        }
        j = i + k + this.LIP.length * 1;
      }
    }
    i = j;
    if (this.LIQ != 0) {
      i = j + b.bA(13, this.LIQ);
    }
    j = i;
    if (this.LIR != 0) {
      j = i + b.bA(14, this.LIR);
    }
    i = j;
    if (this.LIS != 0) {
      i = j + b.bA(15, this.LIS);
    }
    j = i;
    if (this.LIT != 0) {
      j = i + b.bA(16, this.LIT);
    }
    i = j;
    if (this.LIU != null) {
      i = j + b.b(17, this.LIU);
    }
    j = i;
    if (!this.dtx.equals("")) {
      j = i + b.e(100, this.dtx);
    }
    i = j;
    if (!this.LIV.equals("")) {
      i = j + b.e(101, this.LIV);
    }
    j = i;
    if (this.LIW != 0) {
      j = i + b.bA(102, this.LIW);
    }
    i = j;
    if (!Arrays.equals(this.LGl, g.bQV)) {
      i = j + b.c(200, this.LGl);
    }
    j = i;
    if (this.LIX != null) {
      j = i + b.b(201, this.LIX);
    }
    i = j;
    if (this.LIY != -1) {
      i = j + b.bz(202, this.LIY);
    }
    j = i;
    if (!this.LIZ.equals("")) {
      j = i + b.e(203, this.LIZ);
    }
    i = j;
    if (this.platform != 0) {
      i = j + b.bz(204, this.platform);
    }
    j = i;
    if (this.LJa != 0) {
      j = i + b.bA(205, this.LJa);
    }
    i = j;
    if (this.CuX != 0) {
      i = j + b.bA(206, this.CuX);
    }
    j = i;
    if (this.LJb != 0) {
      j = i + b.bA(207, this.LJb);
    }
    i = j;
    if (this.LJc != 0) {
      i = j + b.bA(208, this.LJc);
    }
    j = i;
    if (this.LGg != 0) {
      j = i + b.bA(240, this.LGg);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ay
 * JD-Core Version:    0.7.0.1
 */