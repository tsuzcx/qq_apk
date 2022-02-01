package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$aw
  extends e
{
  public byte[] ImP = g.bIZ;
  public long ImQ = 0L;
  public byte[] ImR = g.bIZ;
  public byte[] ImS = g.bIZ;
  public byte[] ImT = g.bIZ;
  public a.ba ImU = null;
  public byte[] ImV = g.bIZ;
  public a.as ImW = null;
  public String ImX = "";
  public String ImY = "";
  public long ImZ = 0L;
  public byte[] Ina = g.bIZ;
  public byte[] Inb = g.bIZ;
  public byte[] Inc = g.bIZ;
  public byte[] Ind = g.bIZ;
  public int Ine = 0;
  public byte[] Inf = g.bIZ;
  public byte[] Ing = g.bIZ;
  public int Inh = 0;
  public a.o[] Ini = a.o.flr();
  public byte[] bRT = g.bIZ;
  public int dkj = 0;
  public String name = "";
  
  public a$aw()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.name.equals("")) {
      paramb.d(1, this.name);
    }
    if (!Arrays.equals(this.ImP, g.bIZ)) {
      paramb.b(2, this.ImP);
    }
    if (this.dkj != 0) {
      paramb.by(3, this.dkj);
    }
    if (this.ImQ != 0L) {
      paramb.n(4, this.ImQ);
    }
    if (!Arrays.equals(this.ImR, g.bIZ)) {
      paramb.b(5, this.ImR);
    }
    if (!Arrays.equals(this.ImS, g.bIZ)) {
      paramb.b(6, this.ImS);
    }
    if (!Arrays.equals(this.ImT, g.bIZ)) {
      paramb.b(7, this.ImT);
    }
    if (this.ImU != null) {
      paramb.a(8, this.ImU);
    }
    if (!Arrays.equals(this.ImV, g.bIZ)) {
      paramb.b(9, this.ImV);
    }
    if (this.ImW != null) {
      paramb.a(10, this.ImW);
    }
    if (!this.ImX.equals("")) {
      paramb.d(100, this.ImX);
    }
    if (!this.ImY.equals("")) {
      paramb.d(101, this.ImY);
    }
    if (this.ImZ != 0L) {
      paramb.n(200, this.ImZ);
    }
    if (!Arrays.equals(this.Ina, g.bIZ)) {
      paramb.b(201, this.Ina);
    }
    if (!Arrays.equals(this.Inb, g.bIZ)) {
      paramb.b(202, this.Inb);
    }
    if (!Arrays.equals(this.Inc, g.bIZ)) {
      paramb.b(203, this.Inc);
    }
    if (!Arrays.equals(this.Ind, g.bIZ)) {
      paramb.b(204, this.Ind);
    }
    if (this.Ine != 0) {
      paramb.by(220, this.Ine);
    }
    if (!Arrays.equals(this.Inf, g.bIZ)) {
      paramb.b(221, this.Inf);
    }
    if (!Arrays.equals(this.Ing, g.bIZ)) {
      paramb.b(222, this.Ing);
    }
    if (!Arrays.equals(this.bRT, g.bIZ)) {
      paramb.b(223, this.bRT);
    }
    if (this.Inh != 0) {
      paramb.bz(224, this.Inh);
    }
    if ((this.Ini != null) && (this.Ini.length > 0))
    {
      int i = 0;
      while (i < this.Ini.length)
      {
        a.o localo = this.Ini[i];
        if (localo != null) {
          paramb.a(225, localo);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (!this.name.equals("")) {
      i = j + b.e(1, this.name);
    }
    j = i;
    if (!Arrays.equals(this.ImP, g.bIZ)) {
      j = i + b.c(2, this.ImP);
    }
    i = j;
    if (this.dkj != 0) {
      i = j + b.bA(3, this.dkj);
    }
    j = i;
    if (this.ImQ != 0L) {
      j = i + b.p(4, this.ImQ);
    }
    i = j;
    if (!Arrays.equals(this.ImR, g.bIZ)) {
      i = j + b.c(5, this.ImR);
    }
    j = i;
    if (!Arrays.equals(this.ImS, g.bIZ)) {
      j = i + b.c(6, this.ImS);
    }
    i = j;
    if (!Arrays.equals(this.ImT, g.bIZ)) {
      i = j + b.c(7, this.ImT);
    }
    j = i;
    if (this.ImU != null) {
      j = i + b.b(8, this.ImU);
    }
    i = j;
    if (!Arrays.equals(this.ImV, g.bIZ)) {
      i = j + b.c(9, this.ImV);
    }
    j = i;
    if (this.ImW != null) {
      j = i + b.b(10, this.ImW);
    }
    i = j;
    if (!this.ImX.equals("")) {
      i = j + b.e(100, this.ImX);
    }
    j = i;
    if (!this.ImY.equals("")) {
      j = i + b.e(101, this.ImY);
    }
    i = j;
    if (this.ImZ != 0L) {
      i = j + b.p(200, this.ImZ);
    }
    j = i;
    if (!Arrays.equals(this.Ina, g.bIZ)) {
      j = i + b.c(201, this.Ina);
    }
    i = j;
    if (!Arrays.equals(this.Inb, g.bIZ)) {
      i = j + b.c(202, this.Inb);
    }
    j = i;
    if (!Arrays.equals(this.Inc, g.bIZ)) {
      j = i + b.c(203, this.Inc);
    }
    i = j;
    if (!Arrays.equals(this.Ind, g.bIZ)) {
      i = j + b.c(204, this.Ind);
    }
    j = i;
    if (this.Ine != 0) {
      j = i + b.bA(220, this.Ine);
    }
    i = j;
    if (!Arrays.equals(this.Inf, g.bIZ)) {
      i = j + b.c(221, this.Inf);
    }
    j = i;
    if (!Arrays.equals(this.Ing, g.bIZ)) {
      j = i + b.c(222, this.Ing);
    }
    int k = j;
    if (!Arrays.equals(this.bRT, g.bIZ)) {
      k = j + b.c(223, this.bRT);
    }
    i = k;
    if (this.Inh != 0) {
      i = k + b.bB(224, this.Inh);
    }
    j = i;
    if (this.Ini != null)
    {
      j = i;
      if (this.Ini.length > 0)
      {
        j = 0;
        while (j < this.Ini.length)
        {
          a.o localo = this.Ini[j];
          k = i;
          if (localo != null) {
            k = i + b.b(225, localo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aw
 * JD-Core Version:    0.7.0.1
 */