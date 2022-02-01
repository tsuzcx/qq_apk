package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$u
  extends e
{
  public long YSo = 0L;
  public long YSp = 0L;
  public String ahdX = "";
  public String aheq = "";
  public String aher = "";
  public int ahes = 1;
  public long ahet = 0L;
  public int aheu = 0;
  public long ahev = 0L;
  public int ahew = 0;
  public String countrycode = "";
  public String nPT = "";
  public String username = "";
  
  public a$u()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.YSo != 0L) {
      paramb.n(1, this.YSo);
    }
    if (!this.aheq.equals("")) {
      paramb.g(2, this.aheq);
    }
    if (!this.aher.equals("")) {
      paramb.g(3, this.aher);
    }
    if (this.ahes != 1) {
      paramb.cF(4, this.ahes);
    }
    if (!this.username.equals("")) {
      paramb.g(5, this.username);
    }
    if (!this.nPT.equals("")) {
      paramb.g(6, this.nPT);
    }
    if (!this.ahdX.equals("")) {
      paramb.g(7, this.ahdX);
    }
    if (this.ahet != 0L) {
      paramb.n(8, this.ahet);
    }
    if (this.aheu != 0) {
      paramb.cG(9, this.aheu);
    }
    if (!this.countrycode.equals("")) {
      paramb.g(10, this.countrycode);
    }
    if (this.ahev != 0L) {
      paramb.n(11, this.ahev);
    }
    if (this.ahew != 0) {
      paramb.cG(12, this.ahew);
    }
    if (this.YSp != 0L) {
      paramb.n(13, this.YSp);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.YSo != 0L) {
      i = j + b.r(1, this.YSo);
    }
    j = i;
    if (!this.aheq.equals("")) {
      j = i + b.h(2, this.aheq);
    }
    i = j;
    if (!this.aher.equals("")) {
      i = j + b.h(3, this.aher);
    }
    j = i;
    if (this.ahes != 1) {
      j = i + b.cJ(4, this.ahes);
    }
    i = j;
    if (!this.username.equals("")) {
      i = j + b.h(5, this.username);
    }
    j = i;
    if (!this.nPT.equals("")) {
      j = i + b.h(6, this.nPT);
    }
    i = j;
    if (!this.ahdX.equals("")) {
      i = j + b.h(7, this.ahdX);
    }
    j = i;
    if (this.ahet != 0L) {
      j = i + b.r(8, this.ahet);
    }
    i = j;
    if (this.aheu != 0) {
      i = j + b.cK(9, this.aheu);
    }
    j = i;
    if (!this.countrycode.equals("")) {
      j = i + b.h(10, this.countrycode);
    }
    i = j;
    if (this.ahev != 0L) {
      i = j + b.r(11, this.ahev);
    }
    j = i;
    if (this.ahew != 0) {
      j = i + b.cK(12, this.ahew);
    }
    i = j;
    if (this.YSp != 0L) {
      i = j + b.r(13, this.YSp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.u
 * JD-Core Version:    0.7.0.1
 */