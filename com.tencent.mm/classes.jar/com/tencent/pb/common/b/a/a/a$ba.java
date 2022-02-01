package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$ba
  extends e
{
  private static volatile ba[] ahgk;
  public int UXy = 0;
  public int Yzt = 0;
  public int ahdE = 0;
  public byte[] ahdO = g.dXB;
  public a.u ahgA = null;
  public int ahgB = -1;
  public String ahgC = "";
  public int ahgD = 0;
  public int ahgE = 0;
  public int ahgF = 0;
  public int ahgl = 0;
  public int ahgm = 0;
  public a.av ahgn = null;
  public int ahgo = 0;
  public String ahgp = "";
  public a.aw[] ahgq = a.aw.jRk();
  public int ahgr = 0;
  public int[] ahgs = g.dTZ;
  public int ahgt = 0;
  public int ahgu = 0;
  public int ahgv = 0;
  public int ahgw = 0;
  public a.as ahgx = null;
  public String ahgy = "";
  public int ahgz = 0;
  public String hJs = "";
  public int platform = 0;
  public int reason = 0;
  public int status = 0;
  public int wTC = -1;
  
  public a$ba()
  {
    this.dXv = -1;
  }
  
  public static ba[] jRm()
  {
    if (ahgk == null) {}
    synchronized (c.dXu)
    {
      if (ahgk == null) {
        ahgk = new ba[0];
      }
      return ahgk;
    }
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.Yzt != 0) {
      paramb.cG(1, this.Yzt);
    }
    if (this.ahgl != 0) {
      paramb.cG(2, this.ahgl);
    }
    if (this.status != 0) {
      paramb.cG(3, this.status);
    }
    if (this.reason != 0) {
      paramb.cG(4, this.reason);
    }
    if (this.wTC != -1) {
      paramb.cF(5, this.wTC);
    }
    if (this.ahgm != 0) {
      paramb.cG(6, this.ahgm);
    }
    if (this.ahgn != null) {
      paramb.a(7, this.ahgn);
    }
    if (this.ahgo != 0) {
      paramb.cG(8, this.ahgo);
    }
    if (!this.ahgp.equals("")) {
      paramb.g(9, this.ahgp);
    }
    int i;
    if ((this.ahgq != null) && (this.ahgq.length > 0))
    {
      i = 0;
      while (i < this.ahgq.length)
      {
        a.aw localaw = this.ahgq[i];
        if (localaw != null) {
          paramb.a(10, localaw);
        }
        i += 1;
      }
    }
    if (this.ahgr != 0) {
      paramb.cG(11, this.ahgr);
    }
    if ((this.ahgs != null) && (this.ahgs.length > 0))
    {
      i = j;
      while (i < this.ahgs.length)
      {
        paramb.cG(12, this.ahgs[i]);
        i += 1;
      }
    }
    if (this.ahgt != 0) {
      paramb.cG(13, this.ahgt);
    }
    if (this.ahgu != 0) {
      paramb.cG(14, this.ahgu);
    }
    if (this.ahgv != 0) {
      paramb.cG(15, this.ahgv);
    }
    if (this.ahgw != 0) {
      paramb.cG(16, this.ahgw);
    }
    if (this.ahgx != null) {
      paramb.a(17, this.ahgx);
    }
    if (!this.hJs.equals("")) {
      paramb.g(100, this.hJs);
    }
    if (!this.ahgy.equals("")) {
      paramb.g(101, this.ahgy);
    }
    if (this.ahgz != 0) {
      paramb.cG(102, this.ahgz);
    }
    if (!Arrays.equals(this.ahdO, g.dXB)) {
      paramb.b(200, this.ahdO);
    }
    if (this.ahgA != null) {
      paramb.a(201, this.ahgA);
    }
    if (this.ahgB != -1) {
      paramb.cF(202, this.ahgB);
    }
    if (!this.ahgC.equals("")) {
      paramb.g(203, this.ahgC);
    }
    if (this.platform != 0) {
      paramb.cF(204, this.platform);
    }
    if (this.ahgD != 0) {
      paramb.cG(205, this.ahgD);
    }
    if (this.UXy != 0) {
      paramb.cG(206, this.UXy);
    }
    if (this.ahgE != 0) {
      paramb.cG(207, this.ahgE);
    }
    if (this.ahgF != 0) {
      paramb.cG(208, this.ahgF);
    }
    if (this.ahdE != 0) {
      paramb.cG(240, this.ahdE);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.Yzt != 0) {
      i = j + b.cK(1, this.Yzt);
    }
    j = i;
    if (this.ahgl != 0) {
      j = i + b.cK(2, this.ahgl);
    }
    i = j;
    if (this.status != 0) {
      i = j + b.cK(3, this.status);
    }
    j = i;
    if (this.reason != 0) {
      j = i + b.cK(4, this.reason);
    }
    i = j;
    if (this.wTC != -1) {
      i = j + b.cJ(5, this.wTC);
    }
    j = i;
    if (this.ahgm != 0) {
      j = i + b.cK(6, this.ahgm);
    }
    i = j;
    if (this.ahgn != null) {
      i = j + b.b(7, this.ahgn);
    }
    j = i;
    if (this.ahgo != 0) {
      j = i + b.cK(8, this.ahgo);
    }
    i = j;
    if (!this.ahgp.equals("")) {
      i = j + b.h(9, this.ahgp);
    }
    j = i;
    int k;
    if (this.ahgq != null)
    {
      j = i;
      if (this.ahgq.length > 0)
      {
        j = 0;
        while (j < this.ahgq.length)
        {
          a.aw localaw = this.ahgq[j];
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
    if (this.ahgr != 0) {
      i = j + b.cK(11, this.ahgr);
    }
    j = i;
    if (this.ahgs != null)
    {
      j = i;
      if (this.ahgs.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.ahgs.length)
        {
          k += b.kv(this.ahgs[j]);
          j += 1;
        }
        j = i + k + this.ahgs.length * 1;
      }
    }
    i = j;
    if (this.ahgt != 0) {
      i = j + b.cK(13, this.ahgt);
    }
    j = i;
    if (this.ahgu != 0) {
      j = i + b.cK(14, this.ahgu);
    }
    i = j;
    if (this.ahgv != 0) {
      i = j + b.cK(15, this.ahgv);
    }
    j = i;
    if (this.ahgw != 0) {
      j = i + b.cK(16, this.ahgw);
    }
    i = j;
    if (this.ahgx != null) {
      i = j + b.b(17, this.ahgx);
    }
    j = i;
    if (!this.hJs.equals("")) {
      j = i + b.h(100, this.hJs);
    }
    i = j;
    if (!this.ahgy.equals("")) {
      i = j + b.h(101, this.ahgy);
    }
    j = i;
    if (this.ahgz != 0) {
      j = i + b.cK(102, this.ahgz);
    }
    i = j;
    if (!Arrays.equals(this.ahdO, g.dXB)) {
      i = j + b.c(200, this.ahdO);
    }
    j = i;
    if (this.ahgA != null) {
      j = i + b.b(201, this.ahgA);
    }
    i = j;
    if (this.ahgB != -1) {
      i = j + b.cJ(202, this.ahgB);
    }
    j = i;
    if (!this.ahgC.equals("")) {
      j = i + b.h(203, this.ahgC);
    }
    i = j;
    if (this.platform != 0) {
      i = j + b.cJ(204, this.platform);
    }
    j = i;
    if (this.ahgD != 0) {
      j = i + b.cK(205, this.ahgD);
    }
    i = j;
    if (this.UXy != 0) {
      i = j + b.cK(206, this.UXy);
    }
    j = i;
    if (this.ahgE != 0) {
      j = i + b.cK(207, this.ahgE);
    }
    i = j;
    if (this.ahgF != 0) {
      i = j + b.cK(208, this.ahgF);
    }
    j = i;
    if (this.ahdE != 0) {
      j = i + b.cK(240, this.ahdE);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ba
 * JD-Core Version:    0.7.0.1
 */