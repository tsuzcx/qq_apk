package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$ay
  extends e
{
  public byte[] ahfN = g.dXB;
  public long ahfO = 0L;
  public byte[] ahfP = g.dXB;
  public byte[] ahfQ = g.dXB;
  public byte[] ahfR = g.dXB;
  public a.bc ahfS = null;
  public byte[] ahfT = g.dXB;
  public a.au ahfU = null;
  public String ahfV = "";
  public String ahfW = "";
  public long ahfX = 0L;
  public byte[] ahfY = g.dXB;
  public byte[] ahfZ = g.dXB;
  public byte[] ahga = g.dXB;
  public byte[] ahgb = g.dXB;
  public int ahgc = 0;
  public byte[] ahgd = g.dXB;
  public byte[] ahge = g.dXB;
  public byte[] ahgf = g.dXB;
  public int ahgg = 0;
  public a.p[] ahgh = a.p.jRd();
  public int hIY = 0;
  public String name = "";
  
  public a$ay()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.name.equals("")) {
      paramb.g(1, this.name);
    }
    if (!Arrays.equals(this.ahfN, g.dXB)) {
      paramb.b(2, this.ahfN);
    }
    if (this.hIY != 0) {
      paramb.cF(3, this.hIY);
    }
    if (this.ahfO != 0L) {
      paramb.n(4, this.ahfO);
    }
    if (!Arrays.equals(this.ahfP, g.dXB)) {
      paramb.b(5, this.ahfP);
    }
    if (!Arrays.equals(this.ahfQ, g.dXB)) {
      paramb.b(6, this.ahfQ);
    }
    if (!Arrays.equals(this.ahfR, g.dXB)) {
      paramb.b(7, this.ahfR);
    }
    if (this.ahfS != null) {
      paramb.a(8, this.ahfS);
    }
    if (!Arrays.equals(this.ahfT, g.dXB)) {
      paramb.b(9, this.ahfT);
    }
    if (this.ahfU != null) {
      paramb.a(10, this.ahfU);
    }
    if (!this.ahfV.equals("")) {
      paramb.g(100, this.ahfV);
    }
    if (!this.ahfW.equals("")) {
      paramb.g(101, this.ahfW);
    }
    if (this.ahfX != 0L) {
      paramb.n(200, this.ahfX);
    }
    if (!Arrays.equals(this.ahfY, g.dXB)) {
      paramb.b(201, this.ahfY);
    }
    if (!Arrays.equals(this.ahfZ, g.dXB)) {
      paramb.b(202, this.ahfZ);
    }
    if (!Arrays.equals(this.ahga, g.dXB)) {
      paramb.b(203, this.ahga);
    }
    if (!Arrays.equals(this.ahgb, g.dXB)) {
      paramb.b(204, this.ahgb);
    }
    if (this.ahgc != 0) {
      paramb.cF(220, this.ahgc);
    }
    if (!Arrays.equals(this.ahgd, g.dXB)) {
      paramb.b(221, this.ahgd);
    }
    if (!Arrays.equals(this.ahge, g.dXB)) {
      paramb.b(222, this.ahge);
    }
    if (!Arrays.equals(this.ahgf, g.dXB)) {
      paramb.b(223, this.ahgf);
    }
    if (this.ahgg != 0) {
      paramb.cG(224, this.ahgg);
    }
    if ((this.ahgh != null) && (this.ahgh.length > 0))
    {
      int i = 0;
      while (i < this.ahgh.length)
      {
        a.p localp = this.ahgh[i];
        if (localp != null) {
          paramb.a(225, localp);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (!this.name.equals("")) {
      i = j + b.h(1, this.name);
    }
    j = i;
    if (!Arrays.equals(this.ahfN, g.dXB)) {
      j = i + b.c(2, this.ahfN);
    }
    i = j;
    if (this.hIY != 0) {
      i = j + b.cJ(3, this.hIY);
    }
    j = i;
    if (this.ahfO != 0L) {
      j = i + b.r(4, this.ahfO);
    }
    i = j;
    if (!Arrays.equals(this.ahfP, g.dXB)) {
      i = j + b.c(5, this.ahfP);
    }
    j = i;
    if (!Arrays.equals(this.ahfQ, g.dXB)) {
      j = i + b.c(6, this.ahfQ);
    }
    i = j;
    if (!Arrays.equals(this.ahfR, g.dXB)) {
      i = j + b.c(7, this.ahfR);
    }
    j = i;
    if (this.ahfS != null) {
      j = i + b.b(8, this.ahfS);
    }
    i = j;
    if (!Arrays.equals(this.ahfT, g.dXB)) {
      i = j + b.c(9, this.ahfT);
    }
    j = i;
    if (this.ahfU != null) {
      j = i + b.b(10, this.ahfU);
    }
    i = j;
    if (!this.ahfV.equals("")) {
      i = j + b.h(100, this.ahfV);
    }
    j = i;
    if (!this.ahfW.equals("")) {
      j = i + b.h(101, this.ahfW);
    }
    i = j;
    if (this.ahfX != 0L) {
      i = j + b.r(200, this.ahfX);
    }
    j = i;
    if (!Arrays.equals(this.ahfY, g.dXB)) {
      j = i + b.c(201, this.ahfY);
    }
    i = j;
    if (!Arrays.equals(this.ahfZ, g.dXB)) {
      i = j + b.c(202, this.ahfZ);
    }
    j = i;
    if (!Arrays.equals(this.ahga, g.dXB)) {
      j = i + b.c(203, this.ahga);
    }
    i = j;
    if (!Arrays.equals(this.ahgb, g.dXB)) {
      i = j + b.c(204, this.ahgb);
    }
    j = i;
    if (this.ahgc != 0) {
      j = i + b.cJ(220, this.ahgc);
    }
    i = j;
    if (!Arrays.equals(this.ahgd, g.dXB)) {
      i = j + b.c(221, this.ahgd);
    }
    j = i;
    if (!Arrays.equals(this.ahge, g.dXB)) {
      j = i + b.c(222, this.ahge);
    }
    int k = j;
    if (!Arrays.equals(this.ahgf, g.dXB)) {
      k = j + b.c(223, this.ahgf);
    }
    i = k;
    if (this.ahgg != 0) {
      i = k + b.cK(224, this.ahgg);
    }
    j = i;
    if (this.ahgh != null)
    {
      j = i;
      if (this.ahgh.length > 0)
      {
        j = 0;
        while (j < this.ahgh.length)
        {
          a.p localp = this.ahgh[j];
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ay
 * JD-Core Version:    0.7.0.1
 */