package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$u
  extends e
{
  public long KTS = 0L;
  public long KTT = 0L;
  public String RDO = "";
  public String REh = "";
  public String REi = "";
  public int REj = 1;
  public long REk = 0L;
  public int REl = 0;
  public long REm = 0L;
  public int REn = 0;
  public String countrycode = "";
  public String ivR = "";
  public String username = "";
  
  public a$u()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.KTS != 0L) {
      i = j + b.p(1, this.KTS);
    }
    j = i;
    if (!this.REh.equals("")) {
      j = i + b.f(2, this.REh);
    }
    i = j;
    if (!this.REi.equals("")) {
      i = j + b.f(3, this.REi);
    }
    j = i;
    if (this.REj != 1) {
      j = i + b.bu(4, this.REj);
    }
    i = j;
    if (!this.username.equals("")) {
      i = j + b.f(5, this.username);
    }
    j = i;
    if (!this.ivR.equals("")) {
      j = i + b.f(6, this.ivR);
    }
    i = j;
    if (!this.RDO.equals("")) {
      i = j + b.f(7, this.RDO);
    }
    j = i;
    if (this.REk != 0L) {
      j = i + b.p(8, this.REk);
    }
    i = j;
    if (this.REl != 0) {
      i = j + b.bC(9, this.REl);
    }
    j = i;
    if (!this.countrycode.equals("")) {
      j = i + b.f(10, this.countrycode);
    }
    i = j;
    if (this.REm != 0L) {
      i = j + b.p(11, this.REm);
    }
    j = i;
    if (this.REn != 0) {
      j = i + b.bC(12, this.REn);
    }
    i = j;
    if (this.KTT != 0L) {
      i = j + b.p(13, this.KTT);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.KTS != 0L) {
      paramb.n(1, this.KTS);
    }
    if (!this.REh.equals("")) {
      paramb.e(2, this.REh);
    }
    if (!this.REi.equals("")) {
      paramb.e(3, this.REi);
    }
    if (this.REj != 1) {
      paramb.bs(4, this.REj);
    }
    if (!this.username.equals("")) {
      paramb.e(5, this.username);
    }
    if (!this.ivR.equals("")) {
      paramb.e(6, this.ivR);
    }
    if (!this.RDO.equals("")) {
      paramb.e(7, this.RDO);
    }
    if (this.REk != 0L) {
      paramb.n(8, this.REk);
    }
    if (this.REl != 0) {
      paramb.bB(9, this.REl);
    }
    if (!this.countrycode.equals("")) {
      paramb.e(10, this.countrycode);
    }
    if (this.REm != 0L) {
      paramb.n(11, this.REm);
    }
    if (this.REn != 0) {
      paramb.bB(12, this.REn);
    }
    if (this.KTT != 0L) {
      paramb.n(13, this.KTT);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.u
 * JD-Core Version:    0.7.0.1
 */