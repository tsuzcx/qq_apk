package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
{
  public static final byte[] hFK = { 68, 88, 68, 73, 70, 70 };
  private short version;
  public final com.tencent.tinker.a.a.a.a wUQ;
  public int wUR;
  private int wUS;
  public int wUT;
  public int wUU;
  public int wUV;
  public int wUW;
  public int wUX;
  public int wUY;
  public int wUZ;
  public int wVa;
  public int wVb;
  public int wVc;
  public int wVd;
  public int wVe;
  public int wVf;
  public int wVg;
  public int wVh;
  public int wVi;
  public int wVj;
  public byte[] wVk;
  
  public a(InputStream paramInputStream)
  {
    this.wUQ = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.r(paramInputStream)));
    paramInputStream = this.wUQ.JB(hFK.length);
    if (c.l(paramInputStream, hFK) != 0) {
      throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(paramInputStream));
    }
    this.version = this.wUQ.ayD.getShort();
    if (c.b(this.version, (short)2) != 0) {
      throw new IllegalStateException("bad dex patch file version: " + this.version + ", expected: 2");
    }
    this.wUR = this.wUQ.ayD.getInt();
    this.wUS = this.wUQ.ayD.getInt();
    this.wUT = this.wUQ.ayD.getInt();
    this.wUU = this.wUQ.ayD.getInt();
    this.wUV = this.wUQ.ayD.getInt();
    this.wUW = this.wUQ.ayD.getInt();
    this.wUX = this.wUQ.ayD.getInt();
    this.wUY = this.wUQ.ayD.getInt();
    this.wUZ = this.wUQ.ayD.getInt();
    this.wVa = this.wUQ.ayD.getInt();
    this.wVb = this.wUQ.ayD.getInt();
    this.wVc = this.wUQ.ayD.getInt();
    this.wVd = this.wUQ.ayD.getInt();
    this.wVe = this.wUQ.ayD.getInt();
    this.wVf = this.wUQ.ayD.getInt();
    this.wVg = this.wUQ.ayD.getInt();
    this.wVh = this.wUQ.ayD.getInt();
    this.wVi = this.wUQ.ayD.getInt();
    this.wVj = this.wUQ.ayD.getInt();
    this.wVk = this.wUQ.JB(20);
    paramInputStream = this.wUQ;
    int i = this.wUS;
    paramInputStream.ayD.position(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.c.a.b.a
 * JD-Core Version:    0.7.0.1
 */