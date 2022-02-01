package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
{
  public static final byte[] rLo = { 68, 88, 68, 73, 70, 70 };
  public int ZLA;
  public byte[] ZLB;
  public final com.tencent.tinker.a.a.a.a ZLg;
  private short ZLh;
  public int ZLi;
  private int ZLj;
  public int ZLk;
  public int ZLl;
  public int ZLm;
  public int ZLn;
  public int ZLo;
  public int ZLp;
  public int ZLq;
  public int ZLr;
  public int ZLs;
  public int ZLt;
  public int ZLu;
  public int ZLv;
  public int ZLw;
  public int ZLx;
  public int ZLy;
  public int ZLz;
  
  public a(InputStream paramInputStream)
  {
    this.ZLg = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.p(paramInputStream)));
    paramInputStream = this.ZLg.aBA(rLo.length);
    if (c.r(paramInputStream, rLo) != 0) {
      throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(paramInputStream));
    }
    this.ZLh = this.ZLg.aQU.getShort();
    if (c.a(this.ZLh, (short)2) != 0) {
      throw new IllegalStateException("bad dex patch file version: " + this.ZLh + ", expected: 2");
    }
    this.ZLi = this.ZLg.aQU.getInt();
    this.ZLj = this.ZLg.aQU.getInt();
    this.ZLk = this.ZLg.aQU.getInt();
    this.ZLl = this.ZLg.aQU.getInt();
    this.ZLm = this.ZLg.aQU.getInt();
    this.ZLn = this.ZLg.aQU.getInt();
    this.ZLo = this.ZLg.aQU.getInt();
    this.ZLp = this.ZLg.aQU.getInt();
    this.ZLq = this.ZLg.aQU.getInt();
    this.ZLr = this.ZLg.aQU.getInt();
    this.ZLs = this.ZLg.aQU.getInt();
    this.ZLt = this.ZLg.aQU.getInt();
    this.ZLu = this.ZLg.aQU.getInt();
    this.ZLv = this.ZLg.aQU.getInt();
    this.ZLw = this.ZLg.aQU.getInt();
    this.ZLx = this.ZLg.aQU.getInt();
    this.ZLy = this.ZLg.aQU.getInt();
    this.ZLz = this.ZLg.aQU.getInt();
    this.ZLA = this.ZLg.aQU.getInt();
    this.ZLB = this.ZLg.aBA(20);
    paramInputStream = this.ZLg;
    int i = this.ZLj;
    paramInputStream.aQU.position(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.c.a.b.a
 * JD-Core Version:    0.7.0.1
 */