package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$aw
  extends e
{
  public long JOA = 0L;
  public byte[] JOB = g.bGH;
  public byte[] JOC = g.bGH;
  public byte[] JOD = g.bGH;
  public a.ba JOE = null;
  public byte[] JOF = g.bGH;
  public a.as JOG = null;
  public String JOH = "";
  public String JOI = "";
  public long JOJ = 0L;
  public byte[] JOK = g.bGH;
  public byte[] JOL = g.bGH;
  public byte[] JOM = g.bGH;
  public byte[] JON = g.bGH;
  public int JOO = 0;
  public byte[] JOP = g.bGH;
  public byte[] JOQ = g.bGH;
  public int JOR = 0;
  public a.o[] JOS = a.o.fBI();
  public byte[] JOz = g.bGH;
  public byte[] bPB = g.bGH;
  public int dhE = 0;
  public String name = "";
  
  public a$aw()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.name.equals("")) {
      paramb.d(1, this.name);
    }
    if (!Arrays.equals(this.JOz, g.bGH)) {
      paramb.b(2, this.JOz);
    }
    if (this.dhE != 0) {
      paramb.bv(3, this.dhE);
    }
    if (this.JOA != 0L) {
      paramb.m(4, this.JOA);
    }
    if (!Arrays.equals(this.JOB, g.bGH)) {
      paramb.b(5, this.JOB);
    }
    if (!Arrays.equals(this.JOC, g.bGH)) {
      paramb.b(6, this.JOC);
    }
    if (!Arrays.equals(this.JOD, g.bGH)) {
      paramb.b(7, this.JOD);
    }
    if (this.JOE != null) {
      paramb.a(8, this.JOE);
    }
    if (!Arrays.equals(this.JOF, g.bGH)) {
      paramb.b(9, this.JOF);
    }
    if (this.JOG != null) {
      paramb.a(10, this.JOG);
    }
    if (!this.JOH.equals("")) {
      paramb.d(100, this.JOH);
    }
    if (!this.JOI.equals("")) {
      paramb.d(101, this.JOI);
    }
    if (this.JOJ != 0L) {
      paramb.m(200, this.JOJ);
    }
    if (!Arrays.equals(this.JOK, g.bGH)) {
      paramb.b(201, this.JOK);
    }
    if (!Arrays.equals(this.JOL, g.bGH)) {
      paramb.b(202, this.JOL);
    }
    if (!Arrays.equals(this.JOM, g.bGH)) {
      paramb.b(203, this.JOM);
    }
    if (!Arrays.equals(this.JON, g.bGH)) {
      paramb.b(204, this.JON);
    }
    if (this.JOO != 0) {
      paramb.bv(220, this.JOO);
    }
    if (!Arrays.equals(this.JOP, g.bGH)) {
      paramb.b(221, this.JOP);
    }
    if (!Arrays.equals(this.JOQ, g.bGH)) {
      paramb.b(222, this.JOQ);
    }
    if (!Arrays.equals(this.bPB, g.bGH)) {
      paramb.b(223, this.bPB);
    }
    if (this.JOR != 0) {
      paramb.bw(224, this.JOR);
    }
    if ((this.JOS != null) && (this.JOS.length > 0))
    {
      int i = 0;
      while (i < this.JOS.length)
      {
        a.o localo = this.JOS[i];
        if (localo != null) {
          paramb.a(225, localo);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (!this.name.equals("")) {
      i = j + b.e(1, this.name);
    }
    j = i;
    if (!Arrays.equals(this.JOz, g.bGH)) {
      j = i + b.c(2, this.JOz);
    }
    i = j;
    if (this.dhE != 0) {
      i = j + b.bx(3, this.dhE);
    }
    j = i;
    if (this.JOA != 0L) {
      j = i + b.o(4, this.JOA);
    }
    i = j;
    if (!Arrays.equals(this.JOB, g.bGH)) {
      i = j + b.c(5, this.JOB);
    }
    j = i;
    if (!Arrays.equals(this.JOC, g.bGH)) {
      j = i + b.c(6, this.JOC);
    }
    i = j;
    if (!Arrays.equals(this.JOD, g.bGH)) {
      i = j + b.c(7, this.JOD);
    }
    j = i;
    if (this.JOE != null) {
      j = i + b.b(8, this.JOE);
    }
    i = j;
    if (!Arrays.equals(this.JOF, g.bGH)) {
      i = j + b.c(9, this.JOF);
    }
    j = i;
    if (this.JOG != null) {
      j = i + b.b(10, this.JOG);
    }
    i = j;
    if (!this.JOH.equals("")) {
      i = j + b.e(100, this.JOH);
    }
    j = i;
    if (!this.JOI.equals("")) {
      j = i + b.e(101, this.JOI);
    }
    i = j;
    if (this.JOJ != 0L) {
      i = j + b.o(200, this.JOJ);
    }
    j = i;
    if (!Arrays.equals(this.JOK, g.bGH)) {
      j = i + b.c(201, this.JOK);
    }
    i = j;
    if (!Arrays.equals(this.JOL, g.bGH)) {
      i = j + b.c(202, this.JOL);
    }
    j = i;
    if (!Arrays.equals(this.JOM, g.bGH)) {
      j = i + b.c(203, this.JOM);
    }
    i = j;
    if (!Arrays.equals(this.JON, g.bGH)) {
      i = j + b.c(204, this.JON);
    }
    j = i;
    if (this.JOO != 0) {
      j = i + b.bx(220, this.JOO);
    }
    i = j;
    if (!Arrays.equals(this.JOP, g.bGH)) {
      i = j + b.c(221, this.JOP);
    }
    j = i;
    if (!Arrays.equals(this.JOQ, g.bGH)) {
      j = i + b.c(222, this.JOQ);
    }
    int k = j;
    if (!Arrays.equals(this.bPB, g.bGH)) {
      k = j + b.c(223, this.bPB);
    }
    i = k;
    if (this.JOR != 0) {
      i = k + b.by(224, this.JOR);
    }
    j = i;
    if (this.JOS != null)
    {
      j = i;
      if (this.JOS.length > 0)
      {
        j = 0;
        while (j < this.JOS.length)
        {
          a.o localo = this.JOS[j];
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