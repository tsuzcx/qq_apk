package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$az
  extends e
{
  public byte[] RFH = g.cbu;
  public long RFI = 0L;
  public byte[] RFJ = g.cbu;
  public byte[] RFK = g.cbu;
  public byte[] RFL = g.cbu;
  public a.bd RFM = null;
  public byte[] RFN = g.cbu;
  public a.av RFO = null;
  public String RFP = "";
  public String RFQ = "";
  public long RFR = 0L;
  public byte[] RFS = g.cbu;
  public byte[] RFT = g.cbu;
  public byte[] RFU = g.cbu;
  public byte[] RFV = g.cbu;
  public int RFW = 0;
  public byte[] RFX = g.cbu;
  public byte[] RFY = g.cbu;
  public int RFZ = 0;
  public a.p[] RGa = a.p.hjc();
  public byte[] ckv = g.cbu;
  public int dLt = 0;
  public String name = "";
  
  public a$az()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (!this.name.equals("")) {
      i = j + b.f(1, this.name);
    }
    j = i;
    if (!Arrays.equals(this.RFH, g.cbu)) {
      j = i + b.c(2, this.RFH);
    }
    i = j;
    if (this.dLt != 0) {
      i = j + b.bu(3, this.dLt);
    }
    j = i;
    if (this.RFI != 0L) {
      j = i + b.p(4, this.RFI);
    }
    i = j;
    if (!Arrays.equals(this.RFJ, g.cbu)) {
      i = j + b.c(5, this.RFJ);
    }
    j = i;
    if (!Arrays.equals(this.RFK, g.cbu)) {
      j = i + b.c(6, this.RFK);
    }
    i = j;
    if (!Arrays.equals(this.RFL, g.cbu)) {
      i = j + b.c(7, this.RFL);
    }
    j = i;
    if (this.RFM != null) {
      j = i + b.b(8, this.RFM);
    }
    i = j;
    if (!Arrays.equals(this.RFN, g.cbu)) {
      i = j + b.c(9, this.RFN);
    }
    j = i;
    if (this.RFO != null) {
      j = i + b.b(10, this.RFO);
    }
    i = j;
    if (!this.RFP.equals("")) {
      i = j + b.f(100, this.RFP);
    }
    j = i;
    if (!this.RFQ.equals("")) {
      j = i + b.f(101, this.RFQ);
    }
    i = j;
    if (this.RFR != 0L) {
      i = j + b.p(200, this.RFR);
    }
    j = i;
    if (!Arrays.equals(this.RFS, g.cbu)) {
      j = i + b.c(201, this.RFS);
    }
    i = j;
    if (!Arrays.equals(this.RFT, g.cbu)) {
      i = j + b.c(202, this.RFT);
    }
    j = i;
    if (!Arrays.equals(this.RFU, g.cbu)) {
      j = i + b.c(203, this.RFU);
    }
    i = j;
    if (!Arrays.equals(this.RFV, g.cbu)) {
      i = j + b.c(204, this.RFV);
    }
    j = i;
    if (this.RFW != 0) {
      j = i + b.bu(220, this.RFW);
    }
    i = j;
    if (!Arrays.equals(this.RFX, g.cbu)) {
      i = j + b.c(221, this.RFX);
    }
    j = i;
    if (!Arrays.equals(this.RFY, g.cbu)) {
      j = i + b.c(222, this.RFY);
    }
    int k = j;
    if (!Arrays.equals(this.ckv, g.cbu)) {
      k = j + b.c(223, this.ckv);
    }
    i = k;
    if (this.RFZ != 0) {
      i = k + b.bC(224, this.RFZ);
    }
    j = i;
    if (this.RGa != null)
    {
      j = i;
      if (this.RGa.length > 0)
      {
        j = 0;
        while (j < this.RGa.length)
        {
          a.p localp = this.RGa[j];
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
      paramb.e(1, this.name);
    }
    if (!Arrays.equals(this.RFH, g.cbu)) {
      paramb.b(2, this.RFH);
    }
    if (this.dLt != 0) {
      paramb.bs(3, this.dLt);
    }
    if (this.RFI != 0L) {
      paramb.n(4, this.RFI);
    }
    if (!Arrays.equals(this.RFJ, g.cbu)) {
      paramb.b(5, this.RFJ);
    }
    if (!Arrays.equals(this.RFK, g.cbu)) {
      paramb.b(6, this.RFK);
    }
    if (!Arrays.equals(this.RFL, g.cbu)) {
      paramb.b(7, this.RFL);
    }
    if (this.RFM != null) {
      paramb.a(8, this.RFM);
    }
    if (!Arrays.equals(this.RFN, g.cbu)) {
      paramb.b(9, this.RFN);
    }
    if (this.RFO != null) {
      paramb.a(10, this.RFO);
    }
    if (!this.RFP.equals("")) {
      paramb.e(100, this.RFP);
    }
    if (!this.RFQ.equals("")) {
      paramb.e(101, this.RFQ);
    }
    if (this.RFR != 0L) {
      paramb.n(200, this.RFR);
    }
    if (!Arrays.equals(this.RFS, g.cbu)) {
      paramb.b(201, this.RFS);
    }
    if (!Arrays.equals(this.RFT, g.cbu)) {
      paramb.b(202, this.RFT);
    }
    if (!Arrays.equals(this.RFU, g.cbu)) {
      paramb.b(203, this.RFU);
    }
    if (!Arrays.equals(this.RFV, g.cbu)) {
      paramb.b(204, this.RFV);
    }
    if (this.RFW != 0) {
      paramb.bs(220, this.RFW);
    }
    if (!Arrays.equals(this.RFX, g.cbu)) {
      paramb.b(221, this.RFX);
    }
    if (!Arrays.equals(this.RFY, g.cbu)) {
      paramb.b(222, this.RFY);
    }
    if (!Arrays.equals(this.ckv, g.cbu)) {
      paramb.b(223, this.ckv);
    }
    if (this.RFZ != 0) {
      paramb.bB(224, this.RFZ);
    }
    if ((this.RGa != null) && (this.RGa.length > 0))
    {
      int i = 0;
      while (i < this.RGa.length)
      {
        a.p localp = this.RGa[i];
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.az
 * JD-Core Version:    0.7.0.1
 */