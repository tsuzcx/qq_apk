package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ba
  extends e
{
  private static volatile ba[] ZhJ;
  public int Ojd = 0;
  public int RCR = 0;
  public int Zfb = 0;
  public byte[] Zfl = g.ccX;
  public int ZhK = 0;
  public int ZhL = 0;
  public a.av ZhM = null;
  public int ZhN = 0;
  public String ZhO = "";
  public a.aw[] ZhP = a.aw.ikT();
  public int ZhQ = 0;
  public int[] ZhR = g.bZR;
  public int ZhS = 0;
  public int ZhT = 0;
  public int ZhU = 0;
  public int ZhV = 0;
  public a.as ZhW = null;
  public String ZhX = "";
  public int ZhY = 0;
  public a.u ZhZ = null;
  public int Zia = -1;
  public String Zib = "";
  public int Zic = 0;
  public int Zid = 0;
  public int Zie = 0;
  public int bnA = 0;
  public String fEC = "";
  public int platform = 0;
  public int status = 0;
  public int tQm = -1;
  
  public a$ba()
  {
    this.ccR = -1;
  }
  
  public static ba[] ikV()
  {
    if (ZhJ == null) {}
    synchronized (c.ccQ)
    {
      if (ZhJ == null) {
        ZhJ = new ba[0];
      }
      return ZhJ;
    }
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.RCR != 0) {
      i = j + b.bN(1, this.RCR);
    }
    j = i;
    if (this.ZhK != 0) {
      j = i + b.bN(2, this.ZhK);
    }
    i = j;
    if (this.status != 0) {
      i = j + b.bN(3, this.status);
    }
    j = i;
    if (this.bnA != 0) {
      j = i + b.bN(4, this.bnA);
    }
    i = j;
    if (this.tQm != -1) {
      i = j + b.bM(5, this.tQm);
    }
    j = i;
    if (this.ZhL != 0) {
      j = i + b.bN(6, this.ZhL);
    }
    i = j;
    if (this.ZhM != null) {
      i = j + b.b(7, this.ZhM);
    }
    j = i;
    if (this.ZhN != 0) {
      j = i + b.bN(8, this.ZhN);
    }
    i = j;
    if (!this.ZhO.equals("")) {
      i = j + b.g(9, this.ZhO);
    }
    j = i;
    int k;
    if (this.ZhP != null)
    {
      j = i;
      if (this.ZhP.length > 0)
      {
        j = 0;
        while (j < this.ZhP.length)
        {
          a.aw localaw = this.ZhP[j];
          k = i;
          if (localaw != null) {
            k = i + b.b(10, localaw);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.ZhQ != 0) {
      i = j + b.bN(11, this.ZhQ);
    }
    j = i;
    if (this.ZhR != null)
    {
      j = i;
      if (this.ZhR.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.ZhR.length)
        {
          k += b.gR(this.ZhR[j]);
          j += 1;
        }
        j = i + k + this.ZhR.length * 1;
      }
    }
    i = j;
    if (this.ZhS != 0) {
      i = j + b.bN(13, this.ZhS);
    }
    j = i;
    if (this.ZhT != 0) {
      j = i + b.bN(14, this.ZhT);
    }
    i = j;
    if (this.ZhU != 0) {
      i = j + b.bN(15, this.ZhU);
    }
    j = i;
    if (this.ZhV != 0) {
      j = i + b.bN(16, this.ZhV);
    }
    i = j;
    if (this.ZhW != null) {
      i = j + b.b(17, this.ZhW);
    }
    j = i;
    if (!this.fEC.equals("")) {
      j = i + b.g(100, this.fEC);
    }
    i = j;
    if (!this.ZhX.equals("")) {
      i = j + b.g(101, this.ZhX);
    }
    j = i;
    if (this.ZhY != 0) {
      j = i + b.bN(102, this.ZhY);
    }
    i = j;
    if (!Arrays.equals(this.Zfl, g.ccX)) {
      i = j + b.c(200, this.Zfl);
    }
    j = i;
    if (this.ZhZ != null) {
      j = i + b.b(201, this.ZhZ);
    }
    i = j;
    if (this.Zia != -1) {
      i = j + b.bM(202, this.Zia);
    }
    j = i;
    if (!this.Zib.equals("")) {
      j = i + b.g(203, this.Zib);
    }
    i = j;
    if (this.platform != 0) {
      i = j + b.bM(204, this.platform);
    }
    j = i;
    if (this.Zic != 0) {
      j = i + b.bN(205, this.Zic);
    }
    i = j;
    if (this.Ojd != 0) {
      i = j + b.bN(206, this.Ojd);
    }
    j = i;
    if (this.Zid != 0) {
      j = i + b.bN(207, this.Zid);
    }
    i = j;
    if (this.Zie != 0) {
      i = j + b.bN(208, this.Zie);
    }
    j = i;
    if (this.Zfb != 0) {
      j = i + b.bN(240, this.Zfb);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.RCR != 0) {
      paramb.bK(1, this.RCR);
    }
    if (this.ZhK != 0) {
      paramb.bK(2, this.ZhK);
    }
    if (this.status != 0) {
      paramb.bK(3, this.status);
    }
    if (this.bnA != 0) {
      paramb.bK(4, this.bnA);
    }
    if (this.tQm != -1) {
      paramb.bJ(5, this.tQm);
    }
    if (this.ZhL != 0) {
      paramb.bK(6, this.ZhL);
    }
    if (this.ZhM != null) {
      paramb.a(7, this.ZhM);
    }
    if (this.ZhN != 0) {
      paramb.bK(8, this.ZhN);
    }
    if (!this.ZhO.equals("")) {
      paramb.f(9, this.ZhO);
    }
    int i;
    if ((this.ZhP != null) && (this.ZhP.length > 0))
    {
      i = 0;
      while (i < this.ZhP.length)
      {
        a.aw localaw = this.ZhP[i];
        if (localaw != null) {
          paramb.a(10, localaw);
        }
        i += 1;
      }
    }
    if (this.ZhQ != 0) {
      paramb.bK(11, this.ZhQ);
    }
    if ((this.ZhR != null) && (this.ZhR.length > 0))
    {
      i = j;
      while (i < this.ZhR.length)
      {
        paramb.bK(12, this.ZhR[i]);
        i += 1;
      }
    }
    if (this.ZhS != 0) {
      paramb.bK(13, this.ZhS);
    }
    if (this.ZhT != 0) {
      paramb.bK(14, this.ZhT);
    }
    if (this.ZhU != 0) {
      paramb.bK(15, this.ZhU);
    }
    if (this.ZhV != 0) {
      paramb.bK(16, this.ZhV);
    }
    if (this.ZhW != null) {
      paramb.a(17, this.ZhW);
    }
    if (!this.fEC.equals("")) {
      paramb.f(100, this.fEC);
    }
    if (!this.ZhX.equals("")) {
      paramb.f(101, this.ZhX);
    }
    if (this.ZhY != 0) {
      paramb.bK(102, this.ZhY);
    }
    if (!Arrays.equals(this.Zfl, g.ccX)) {
      paramb.b(200, this.Zfl);
    }
    if (this.ZhZ != null) {
      paramb.a(201, this.ZhZ);
    }
    if (this.Zia != -1) {
      paramb.bJ(202, this.Zia);
    }
    if (!this.Zib.equals("")) {
      paramb.f(203, this.Zib);
    }
    if (this.platform != 0) {
      paramb.bJ(204, this.platform);
    }
    if (this.Zic != 0) {
      paramb.bK(205, this.Zic);
    }
    if (this.Ojd != 0) {
      paramb.bK(206, this.Ojd);
    }
    if (this.Zid != 0) {
      paramb.bK(207, this.Zid);
    }
    if (this.Zie != 0) {
      paramb.bK(208, this.Zie);
    }
    if (this.Zfb != 0) {
      paramb.bK(240, this.Zfb);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ba
 * JD-Core Version:    0.7.0.1
 */