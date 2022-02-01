package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ay
  extends e
{
  public byte[] ZhA = g.ccX;
  public int ZhB = 0;
  public byte[] ZhC = g.ccX;
  public byte[] ZhD = g.ccX;
  public byte[] ZhE = g.ccX;
  public int ZhF = 0;
  public a.p[] ZhG = a.p.ikM();
  public byte[] Zhm = g.ccX;
  public long Zhn = 0L;
  public byte[] Zho = g.ccX;
  public byte[] Zhp = g.ccX;
  public byte[] Zhq = g.ccX;
  public a.bc Zhr = null;
  public byte[] Zhs = g.ccX;
  public a.au Zht = null;
  public String Zhu = "";
  public String Zhv = "";
  public long Zhw = 0L;
  public byte[] Zhx = g.ccX;
  public byte[] Zhy = g.ccX;
  public byte[] Zhz = g.ccX;
  public int fEi = 0;
  public String name = "";
  
  public a$ay()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (!this.name.equals("")) {
      i = j + b.g(1, this.name);
    }
    j = i;
    if (!Arrays.equals(this.Zhm, g.ccX)) {
      j = i + b.c(2, this.Zhm);
    }
    i = j;
    if (this.fEi != 0) {
      i = j + b.bM(3, this.fEi);
    }
    j = i;
    if (this.Zhn != 0L) {
      j = i + b.q(4, this.Zhn);
    }
    i = j;
    if (!Arrays.equals(this.Zho, g.ccX)) {
      i = j + b.c(5, this.Zho);
    }
    j = i;
    if (!Arrays.equals(this.Zhp, g.ccX)) {
      j = i + b.c(6, this.Zhp);
    }
    i = j;
    if (!Arrays.equals(this.Zhq, g.ccX)) {
      i = j + b.c(7, this.Zhq);
    }
    j = i;
    if (this.Zhr != null) {
      j = i + b.b(8, this.Zhr);
    }
    i = j;
    if (!Arrays.equals(this.Zhs, g.ccX)) {
      i = j + b.c(9, this.Zhs);
    }
    j = i;
    if (this.Zht != null) {
      j = i + b.b(10, this.Zht);
    }
    i = j;
    if (!this.Zhu.equals("")) {
      i = j + b.g(100, this.Zhu);
    }
    j = i;
    if (!this.Zhv.equals("")) {
      j = i + b.g(101, this.Zhv);
    }
    i = j;
    if (this.Zhw != 0L) {
      i = j + b.q(200, this.Zhw);
    }
    j = i;
    if (!Arrays.equals(this.Zhx, g.ccX)) {
      j = i + b.c(201, this.Zhx);
    }
    i = j;
    if (!Arrays.equals(this.Zhy, g.ccX)) {
      i = j + b.c(202, this.Zhy);
    }
    j = i;
    if (!Arrays.equals(this.Zhz, g.ccX)) {
      j = i + b.c(203, this.Zhz);
    }
    i = j;
    if (!Arrays.equals(this.ZhA, g.ccX)) {
      i = j + b.c(204, this.ZhA);
    }
    j = i;
    if (this.ZhB != 0) {
      j = i + b.bM(220, this.ZhB);
    }
    i = j;
    if (!Arrays.equals(this.ZhC, g.ccX)) {
      i = j + b.c(221, this.ZhC);
    }
    j = i;
    if (!Arrays.equals(this.ZhD, g.ccX)) {
      j = i + b.c(222, this.ZhD);
    }
    int k = j;
    if (!Arrays.equals(this.ZhE, g.ccX)) {
      k = j + b.c(223, this.ZhE);
    }
    i = k;
    if (this.ZhF != 0) {
      i = k + b.bN(224, this.ZhF);
    }
    j = i;
    if (this.ZhG != null)
    {
      j = i;
      if (this.ZhG.length > 0)
      {
        j = 0;
        while (j < this.ZhG.length)
        {
          a.p localp = this.ZhG[j];
          k = i;
          if (localp != null) {
            k = i + b.b(225, localp);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (!this.name.equals("")) {
      paramb.f(1, this.name);
    }
    if (!Arrays.equals(this.Zhm, g.ccX)) {
      paramb.b(2, this.Zhm);
    }
    if (this.fEi != 0) {
      paramb.bJ(3, this.fEi);
    }
    if (this.Zhn != 0L) {
      paramb.n(4, this.Zhn);
    }
    if (!Arrays.equals(this.Zho, g.ccX)) {
      paramb.b(5, this.Zho);
    }
    if (!Arrays.equals(this.Zhp, g.ccX)) {
      paramb.b(6, this.Zhp);
    }
    if (!Arrays.equals(this.Zhq, g.ccX)) {
      paramb.b(7, this.Zhq);
    }
    if (this.Zhr != null) {
      paramb.a(8, this.Zhr);
    }
    if (!Arrays.equals(this.Zhs, g.ccX)) {
      paramb.b(9, this.Zhs);
    }
    if (this.Zht != null) {
      paramb.a(10, this.Zht);
    }
    if (!this.Zhu.equals("")) {
      paramb.f(100, this.Zhu);
    }
    if (!this.Zhv.equals("")) {
      paramb.f(101, this.Zhv);
    }
    if (this.Zhw != 0L) {
      paramb.n(200, this.Zhw);
    }
    if (!Arrays.equals(this.Zhx, g.ccX)) {
      paramb.b(201, this.Zhx);
    }
    if (!Arrays.equals(this.Zhy, g.ccX)) {
      paramb.b(202, this.Zhy);
    }
    if (!Arrays.equals(this.Zhz, g.ccX)) {
      paramb.b(203, this.Zhz);
    }
    if (!Arrays.equals(this.ZhA, g.ccX)) {
      paramb.b(204, this.ZhA);
    }
    if (this.ZhB != 0) {
      paramb.bJ(220, this.ZhB);
    }
    if (!Arrays.equals(this.ZhC, g.ccX)) {
      paramb.b(221, this.ZhC);
    }
    if (!Arrays.equals(this.ZhD, g.ccX)) {
      paramb.b(222, this.ZhD);
    }
    if (!Arrays.equals(this.ZhE, g.ccX)) {
      paramb.b(223, this.ZhE);
    }
    if (this.ZhF != 0) {
      paramb.bK(224, this.ZhF);
    }
    if ((this.ZhG != null) && (this.ZhG.length > 0))
    {
      int i = 0;
      while (i < this.ZhG.length)
      {
        a.p localp = this.ZhG[i];
        if (localp != null) {
          paramb.a(225, localp);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ay
 * JD-Core Version:    0.7.0.1
 */