package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ay
  extends e
{
  private static volatile ay[] JOV;
  public int AUP = 0;
  public int DKi = 0;
  public byte[] JMC = g.bGH;
  public int JMx = 0;
  public int JOW = 0;
  public int JOX = 0;
  public a.at JOY = null;
  public int JOZ = 0;
  public String JPa = "";
  public a.au[] JPb = a.au.fBO();
  public int JPc = 0;
  public int[] JPd = g.bGB;
  public int JPe = 0;
  public int JPf = 0;
  public int JPg = 0;
  public int JPh = 0;
  public a.aq JPi = null;
  public String JPj = "";
  public int JPk = 0;
  public a.t JPl = null;
  public int JPm = -1;
  public String JPn = "";
  public int JPo = 0;
  public int JPp = 0;
  public int JPq = 0;
  public String dhV = "";
  public int osF = -1;
  public int platform = 0;
  public int reason = 0;
  public int status = 0;
  
  public a$ay()
  {
    this.bGA = -1;
  }
  
  public static ay[] fBQ()
  {
    if (JOV == null) {}
    synchronized (c.bGz)
    {
      if (JOV == null) {
        JOV = new ay[0];
      }
      return JOV;
    }
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.DKi != 0) {
      paramb.bw(1, this.DKi);
    }
    if (this.JOW != 0) {
      paramb.bw(2, this.JOW);
    }
    if (this.status != 0) {
      paramb.bw(3, this.status);
    }
    if (this.reason != 0) {
      paramb.bw(4, this.reason);
    }
    if (this.osF != -1) {
      paramb.bv(5, this.osF);
    }
    if (this.JOX != 0) {
      paramb.bw(6, this.JOX);
    }
    if (this.JOY != null) {
      paramb.a(7, this.JOY);
    }
    if (this.JOZ != 0) {
      paramb.bw(8, this.JOZ);
    }
    if (!this.JPa.equals("")) {
      paramb.d(9, this.JPa);
    }
    int i;
    if ((this.JPb != null) && (this.JPb.length > 0))
    {
      i = 0;
      while (i < this.JPb.length)
      {
        a.au localau = this.JPb[i];
        if (localau != null) {
          paramb.a(10, localau);
        }
        i += 1;
      }
    }
    if (this.JPc != 0) {
      paramb.bw(11, this.JPc);
    }
    if ((this.JPd != null) && (this.JPd.length > 0))
    {
      i = j;
      while (i < this.JPd.length)
      {
        paramb.bw(12, this.JPd[i]);
        i += 1;
      }
    }
    if (this.JPe != 0) {
      paramb.bw(13, this.JPe);
    }
    if (this.JPf != 0) {
      paramb.bw(14, this.JPf);
    }
    if (this.JPg != 0) {
      paramb.bw(15, this.JPg);
    }
    if (this.JPh != 0) {
      paramb.bw(16, this.JPh);
    }
    if (this.JPi != null) {
      paramb.a(17, this.JPi);
    }
    if (!this.dhV.equals("")) {
      paramb.d(100, this.dhV);
    }
    if (!this.JPj.equals("")) {
      paramb.d(101, this.JPj);
    }
    if (this.JPk != 0) {
      paramb.bw(102, this.JPk);
    }
    if (!Arrays.equals(this.JMC, g.bGH)) {
      paramb.b(200, this.JMC);
    }
    if (this.JPl != null) {
      paramb.a(201, this.JPl);
    }
    if (this.JPm != -1) {
      paramb.bv(202, this.JPm);
    }
    if (!this.JPn.equals("")) {
      paramb.d(203, this.JPn);
    }
    if (this.platform != 0) {
      paramb.bv(204, this.platform);
    }
    if (this.JPo != 0) {
      paramb.bw(205, this.JPo);
    }
    if (this.AUP != 0) {
      paramb.bw(206, this.AUP);
    }
    if (this.JPp != 0) {
      paramb.bw(207, this.JPp);
    }
    if (this.JPq != 0) {
      paramb.bw(208, this.JPq);
    }
    if (this.JMx != 0) {
      paramb.bw(240, this.JMx);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.DKi != 0) {
      i = j + b.by(1, this.DKi);
    }
    j = i;
    if (this.JOW != 0) {
      j = i + b.by(2, this.JOW);
    }
    i = j;
    if (this.status != 0) {
      i = j + b.by(3, this.status);
    }
    j = i;
    if (this.reason != 0) {
      j = i + b.by(4, this.reason);
    }
    i = j;
    if (this.osF != -1) {
      i = j + b.bx(5, this.osF);
    }
    j = i;
    if (this.JOX != 0) {
      j = i + b.by(6, this.JOX);
    }
    i = j;
    if (this.JOY != null) {
      i = j + b.b(7, this.JOY);
    }
    j = i;
    if (this.JOZ != 0) {
      j = i + b.by(8, this.JOZ);
    }
    i = j;
    if (!this.JPa.equals("")) {
      i = j + b.e(9, this.JPa);
    }
    j = i;
    int k;
    if (this.JPb != null)
    {
      j = i;
      if (this.JPb.length > 0)
      {
        j = 0;
        while (j < this.JPb.length)
        {
          a.au localau = this.JPb[j];
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
    if (this.JPc != 0) {
      i = j + b.by(11, this.JPc);
    }
    j = i;
    if (this.JPd != null)
    {
      j = i;
      if (this.JPd.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.JPd.length)
        {
          k += b.fM(this.JPd[j]);
          j += 1;
        }
        j = i + k + this.JPd.length * 1;
      }
    }
    i = j;
    if (this.JPe != 0) {
      i = j + b.by(13, this.JPe);
    }
    j = i;
    if (this.JPf != 0) {
      j = i + b.by(14, this.JPf);
    }
    i = j;
    if (this.JPg != 0) {
      i = j + b.by(15, this.JPg);
    }
    j = i;
    if (this.JPh != 0) {
      j = i + b.by(16, this.JPh);
    }
    i = j;
    if (this.JPi != null) {
      i = j + b.b(17, this.JPi);
    }
    j = i;
    if (!this.dhV.equals("")) {
      j = i + b.e(100, this.dhV);
    }
    i = j;
    if (!this.JPj.equals("")) {
      i = j + b.e(101, this.JPj);
    }
    j = i;
    if (this.JPk != 0) {
      j = i + b.by(102, this.JPk);
    }
    i = j;
    if (!Arrays.equals(this.JMC, g.bGH)) {
      i = j + b.c(200, this.JMC);
    }
    j = i;
    if (this.JPl != null) {
      j = i + b.b(201, this.JPl);
    }
    i = j;
    if (this.JPm != -1) {
      i = j + b.bx(202, this.JPm);
    }
    j = i;
    if (!this.JPn.equals("")) {
      j = i + b.e(203, this.JPn);
    }
    i = j;
    if (this.platform != 0) {
      i = j + b.bx(204, this.platform);
    }
    j = i;
    if (this.JPo != 0) {
      j = i + b.by(205, this.JPo);
    }
    i = j;
    if (this.AUP != 0) {
      i = j + b.by(206, this.AUP);
    }
    j = i;
    if (this.JPp != 0) {
      j = i + b.by(207, this.JPp);
    }
    i = j;
    if (this.JPq != 0) {
      i = j + b.by(208, this.JPq);
    }
    j = i;
    if (this.JMx != 0) {
      j = i + b.by(240, this.JMx);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ay
 * JD-Core Version:    0.7.0.1
 */