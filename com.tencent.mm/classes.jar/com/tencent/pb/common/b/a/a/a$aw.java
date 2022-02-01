package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$aw
  extends e
{
  public byte[] MfA = g.bQV;
  public byte[] MfB = g.bQV;
  public byte[] MfC = g.bQV;
  public byte[] MfD = g.bQV;
  public int MfE = 0;
  public byte[] MfF = g.bQV;
  public byte[] MfG = g.bQV;
  public int MfH = 0;
  public a.o[] MfI = a.o.fXx();
  public byte[] Mfp = g.bQV;
  public long Mfq = 0L;
  public byte[] Mfr = g.bQV;
  public byte[] Mfs = g.bQV;
  public byte[] Mft = g.bQV;
  public a.ba Mfu = null;
  public byte[] Mfv = g.bQV;
  public a.as Mfw = null;
  public String Mfx = "";
  public String Mfy = "";
  public long Mfz = 0L;
  public byte[] bZO = g.bQV;
  public int dui = 0;
  public String name = "";
  
  public a$aw()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.name.equals("")) {
      paramb.d(1, this.name);
    }
    if (!Arrays.equals(this.Mfp, g.bQV)) {
      paramb.b(2, this.Mfp);
    }
    if (this.dui != 0) {
      paramb.bx(3, this.dui);
    }
    if (this.Mfq != 0L) {
      paramb.m(4, this.Mfq);
    }
    if (!Arrays.equals(this.Mfr, g.bQV)) {
      paramb.b(5, this.Mfr);
    }
    if (!Arrays.equals(this.Mfs, g.bQV)) {
      paramb.b(6, this.Mfs);
    }
    if (!Arrays.equals(this.Mft, g.bQV)) {
      paramb.b(7, this.Mft);
    }
    if (this.Mfu != null) {
      paramb.a(8, this.Mfu);
    }
    if (!Arrays.equals(this.Mfv, g.bQV)) {
      paramb.b(9, this.Mfv);
    }
    if (this.Mfw != null) {
      paramb.a(10, this.Mfw);
    }
    if (!this.Mfx.equals("")) {
      paramb.d(100, this.Mfx);
    }
    if (!this.Mfy.equals("")) {
      paramb.d(101, this.Mfy);
    }
    if (this.Mfz != 0L) {
      paramb.m(200, this.Mfz);
    }
    if (!Arrays.equals(this.MfA, g.bQV)) {
      paramb.b(201, this.MfA);
    }
    if (!Arrays.equals(this.MfB, g.bQV)) {
      paramb.b(202, this.MfB);
    }
    if (!Arrays.equals(this.MfC, g.bQV)) {
      paramb.b(203, this.MfC);
    }
    if (!Arrays.equals(this.MfD, g.bQV)) {
      paramb.b(204, this.MfD);
    }
    if (this.MfE != 0) {
      paramb.bx(220, this.MfE);
    }
    if (!Arrays.equals(this.MfF, g.bQV)) {
      paramb.b(221, this.MfF);
    }
    if (!Arrays.equals(this.MfG, g.bQV)) {
      paramb.b(222, this.MfG);
    }
    if (!Arrays.equals(this.bZO, g.bQV)) {
      paramb.b(223, this.bZO);
    }
    if (this.MfH != 0) {
      paramb.by(224, this.MfH);
    }
    if ((this.MfI != null) && (this.MfI.length > 0))
    {
      int i = 0;
      while (i < this.MfI.length)
      {
        a.o localo = this.MfI[i];
        if (localo != null) {
          paramb.a(225, localo);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (!this.name.equals("")) {
      i = j + b.e(1, this.name);
    }
    j = i;
    if (!Arrays.equals(this.Mfp, g.bQV)) {
      j = i + b.c(2, this.Mfp);
    }
    i = j;
    if (this.dui != 0) {
      i = j + b.bz(3, this.dui);
    }
    j = i;
    if (this.Mfq != 0L) {
      j = i + b.o(4, this.Mfq);
    }
    i = j;
    if (!Arrays.equals(this.Mfr, g.bQV)) {
      i = j + b.c(5, this.Mfr);
    }
    j = i;
    if (!Arrays.equals(this.Mfs, g.bQV)) {
      j = i + b.c(6, this.Mfs);
    }
    i = j;
    if (!Arrays.equals(this.Mft, g.bQV)) {
      i = j + b.c(7, this.Mft);
    }
    j = i;
    if (this.Mfu != null) {
      j = i + b.b(8, this.Mfu);
    }
    i = j;
    if (!Arrays.equals(this.Mfv, g.bQV)) {
      i = j + b.c(9, this.Mfv);
    }
    j = i;
    if (this.Mfw != null) {
      j = i + b.b(10, this.Mfw);
    }
    i = j;
    if (!this.Mfx.equals("")) {
      i = j + b.e(100, this.Mfx);
    }
    j = i;
    if (!this.Mfy.equals("")) {
      j = i + b.e(101, this.Mfy);
    }
    i = j;
    if (this.Mfz != 0L) {
      i = j + b.o(200, this.Mfz);
    }
    j = i;
    if (!Arrays.equals(this.MfA, g.bQV)) {
      j = i + b.c(201, this.MfA);
    }
    i = j;
    if (!Arrays.equals(this.MfB, g.bQV)) {
      i = j + b.c(202, this.MfB);
    }
    j = i;
    if (!Arrays.equals(this.MfC, g.bQV)) {
      j = i + b.c(203, this.MfC);
    }
    i = j;
    if (!Arrays.equals(this.MfD, g.bQV)) {
      i = j + b.c(204, this.MfD);
    }
    j = i;
    if (this.MfE != 0) {
      j = i + b.bz(220, this.MfE);
    }
    i = j;
    if (!Arrays.equals(this.MfF, g.bQV)) {
      i = j + b.c(221, this.MfF);
    }
    j = i;
    if (!Arrays.equals(this.MfG, g.bQV)) {
      j = i + b.c(222, this.MfG);
    }
    int k = j;
    if (!Arrays.equals(this.bZO, g.bQV)) {
      k = j + b.c(223, this.bZO);
    }
    i = k;
    if (this.MfH != 0) {
      i = k + b.bA(224, this.MfH);
    }
    j = i;
    if (this.MfI != null)
    {
      j = i;
      if (this.MfI.length > 0)
      {
        j = 0;
        while (j < this.MfI.length)
        {
          a.o localo = this.MfI[j];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aw
 * JD-Core Version:    0.7.0.1
 */