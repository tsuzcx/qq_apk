package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$bb
  extends e
{
  private static volatile bb[] RGd;
  public int Hrs = 0;
  public int KBb = 0;
  public byte[] RDF = g.cbu;
  public int RDz = 0;
  public int RGe = 0;
  public int RGf = 0;
  public a.aw RGg = null;
  public int RGh = 0;
  public String RGi = "";
  public a.ax[] RGj = a.ax.hjj();
  public int RGk = 0;
  public int[] RGl = g.bYn;
  public int RGm = 0;
  public int RGn = 0;
  public int RGo = 0;
  public int RGp = 0;
  public a.at RGq = null;
  public String RGr = "";
  public int RGs = 0;
  public a.u RGt = null;
  public int RGu = -1;
  public String RGv = "";
  public int RGw = 0;
  public int RGx = 0;
  public int RGy = 0;
  public int bDZ = 0;
  public String dLN = "";
  public int platform = 0;
  public int qrD = -1;
  public int status = 0;
  
  public a$bb()
  {
    this.cbo = -1;
  }
  
  public static bb[] hjl()
  {
    if (RGd == null) {}
    synchronized (c.cbn)
    {
      if (RGd == null) {
        RGd = new bb[0];
      }
      return RGd;
    }
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.KBb != 0) {
      i = j + b.bC(1, this.KBb);
    }
    j = i;
    if (this.RGe != 0) {
      j = i + b.bC(2, this.RGe);
    }
    i = j;
    if (this.status != 0) {
      i = j + b.bC(3, this.status);
    }
    j = i;
    if (this.bDZ != 0) {
      j = i + b.bC(4, this.bDZ);
    }
    i = j;
    if (this.qrD != -1) {
      i = j + b.bu(5, this.qrD);
    }
    j = i;
    if (this.RGf != 0) {
      j = i + b.bC(6, this.RGf);
    }
    i = j;
    if (this.RGg != null) {
      i = j + b.b(7, this.RGg);
    }
    j = i;
    if (this.RGh != 0) {
      j = i + b.bC(8, this.RGh);
    }
    i = j;
    if (!this.RGi.equals("")) {
      i = j + b.f(9, this.RGi);
    }
    j = i;
    int k;
    if (this.RGj != null)
    {
      j = i;
      if (this.RGj.length > 0)
      {
        j = 0;
        while (j < this.RGj.length)
        {
          a.ax localax = this.RGj[j];
          k = i;
          if (localax != null) {
            k = i + b.b(10, localax);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.RGk != 0) {
      i = j + b.bC(11, this.RGk);
    }
    j = i;
    if (this.RGl != null)
    {
      j = i;
      if (this.RGl.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.RGl.length)
        {
          k += b.fY(this.RGl[j]);
          j += 1;
        }
        j = i + k + this.RGl.length * 1;
      }
    }
    i = j;
    if (this.RGm != 0) {
      i = j + b.bC(13, this.RGm);
    }
    j = i;
    if (this.RGn != 0) {
      j = i + b.bC(14, this.RGn);
    }
    i = j;
    if (this.RGo != 0) {
      i = j + b.bC(15, this.RGo);
    }
    j = i;
    if (this.RGp != 0) {
      j = i + b.bC(16, this.RGp);
    }
    i = j;
    if (this.RGq != null) {
      i = j + b.b(17, this.RGq);
    }
    j = i;
    if (!this.dLN.equals("")) {
      j = i + b.f(100, this.dLN);
    }
    i = j;
    if (!this.RGr.equals("")) {
      i = j + b.f(101, this.RGr);
    }
    j = i;
    if (this.RGs != 0) {
      j = i + b.bC(102, this.RGs);
    }
    i = j;
    if (!Arrays.equals(this.RDF, g.cbu)) {
      i = j + b.c(200, this.RDF);
    }
    j = i;
    if (this.RGt != null) {
      j = i + b.b(201, this.RGt);
    }
    i = j;
    if (this.RGu != -1) {
      i = j + b.bu(202, this.RGu);
    }
    j = i;
    if (!this.RGv.equals("")) {
      j = i + b.f(203, this.RGv);
    }
    i = j;
    if (this.platform != 0) {
      i = j + b.bu(204, this.platform);
    }
    j = i;
    if (this.RGw != 0) {
      j = i + b.bC(205, this.RGw);
    }
    i = j;
    if (this.Hrs != 0) {
      i = j + b.bC(206, this.Hrs);
    }
    j = i;
    if (this.RGx != 0) {
      j = i + b.bC(207, this.RGx);
    }
    i = j;
    if (this.RGy != 0) {
      i = j + b.bC(208, this.RGy);
    }
    j = i;
    if (this.RDz != 0) {
      j = i + b.bC(240, this.RDz);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.KBb != 0) {
      paramb.bB(1, this.KBb);
    }
    if (this.RGe != 0) {
      paramb.bB(2, this.RGe);
    }
    if (this.status != 0) {
      paramb.bB(3, this.status);
    }
    if (this.bDZ != 0) {
      paramb.bB(4, this.bDZ);
    }
    if (this.qrD != -1) {
      paramb.bs(5, this.qrD);
    }
    if (this.RGf != 0) {
      paramb.bB(6, this.RGf);
    }
    if (this.RGg != null) {
      paramb.a(7, this.RGg);
    }
    if (this.RGh != 0) {
      paramb.bB(8, this.RGh);
    }
    if (!this.RGi.equals("")) {
      paramb.e(9, this.RGi);
    }
    int i;
    if ((this.RGj != null) && (this.RGj.length > 0))
    {
      i = 0;
      while (i < this.RGj.length)
      {
        a.ax localax = this.RGj[i];
        if (localax != null) {
          paramb.a(10, localax);
        }
        i += 1;
      }
    }
    if (this.RGk != 0) {
      paramb.bB(11, this.RGk);
    }
    if ((this.RGl != null) && (this.RGl.length > 0))
    {
      i = j;
      while (i < this.RGl.length)
      {
        paramb.bB(12, this.RGl[i]);
        i += 1;
      }
    }
    if (this.RGm != 0) {
      paramb.bB(13, this.RGm);
    }
    if (this.RGn != 0) {
      paramb.bB(14, this.RGn);
    }
    if (this.RGo != 0) {
      paramb.bB(15, this.RGo);
    }
    if (this.RGp != 0) {
      paramb.bB(16, this.RGp);
    }
    if (this.RGq != null) {
      paramb.a(17, this.RGq);
    }
    if (!this.dLN.equals("")) {
      paramb.e(100, this.dLN);
    }
    if (!this.RGr.equals("")) {
      paramb.e(101, this.RGr);
    }
    if (this.RGs != 0) {
      paramb.bB(102, this.RGs);
    }
    if (!Arrays.equals(this.RDF, g.cbu)) {
      paramb.b(200, this.RDF);
    }
    if (this.RGt != null) {
      paramb.a(201, this.RGt);
    }
    if (this.RGu != -1) {
      paramb.bs(202, this.RGu);
    }
    if (!this.RGv.equals("")) {
      paramb.e(203, this.RGv);
    }
    if (this.platform != 0) {
      paramb.bs(204, this.platform);
    }
    if (this.RGw != 0) {
      paramb.bB(205, this.RGw);
    }
    if (this.Hrs != 0) {
      paramb.bB(206, this.Hrs);
    }
    if (this.RGx != 0) {
      paramb.bB(207, this.RGx);
    }
    if (this.RGy != 0) {
      paramb.bB(208, this.RGy);
    }
    if (this.RDz != 0) {
      paramb.bB(240, this.RDz);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bb
 * JD-Core Version:    0.7.0.1
 */