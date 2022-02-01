package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
{
  public static final byte[] bTZ = { 68, 88, 68, 73, 70, 70 };
  public int ahQA;
  public int ahQB;
  public int ahQC;
  public byte[] ahQD;
  public final com.tencent.tinker.a.a.a.a ahQi;
  private short ahQj;
  public int ahQk;
  private int ahQl;
  public int ahQm;
  public int ahQn;
  public int ahQo;
  public int ahQp;
  public int ahQq;
  public int ahQr;
  public int ahQs;
  public int ahQt;
  public int ahQu;
  public int ahQv;
  public int ahQw;
  public int ahQx;
  public int ahQy;
  public int ahQz;
  
  public a(InputStream paramInputStream)
  {
    this.ahQi = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.B(paramInputStream)));
    paramInputStream = this.ahQi.aIm(bTZ.length);
    if (c.s(paramInputStream, bTZ) != 0) {
      throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(paramInputStream));
    }
    this.ahQj = this.ahQi.cKQ.getShort();
    if (c.c(this.ahQj, (short)2) != 0) {
      throw new IllegalStateException("bad dex patch file version: " + this.ahQj + ", expected: 2");
    }
    this.ahQk = this.ahQi.cKQ.getInt();
    this.ahQl = this.ahQi.cKQ.getInt();
    this.ahQm = this.ahQi.cKQ.getInt();
    this.ahQn = this.ahQi.cKQ.getInt();
    this.ahQo = this.ahQi.cKQ.getInt();
    this.ahQp = this.ahQi.cKQ.getInt();
    this.ahQq = this.ahQi.cKQ.getInt();
    this.ahQr = this.ahQi.cKQ.getInt();
    this.ahQs = this.ahQi.cKQ.getInt();
    this.ahQt = this.ahQi.cKQ.getInt();
    this.ahQu = this.ahQi.cKQ.getInt();
    this.ahQv = this.ahQi.cKQ.getInt();
    this.ahQw = this.ahQi.cKQ.getInt();
    this.ahQx = this.ahQi.cKQ.getInt();
    this.ahQy = this.ahQi.cKQ.getInt();
    this.ahQz = this.ahQi.cKQ.getInt();
    this.ahQA = this.ahQi.cKQ.getInt();
    this.ahQB = this.ahQi.cKQ.getInt();
    this.ahQC = this.ahQi.cKQ.getInt();
    this.ahQD = this.ahQi.aIm(20);
    paramInputStream = this.ahQi;
    int i = this.ahQl;
    paramInputStream.cKQ.position(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.c.a.b.a
 * JD-Core Version:    0.7.0.1
 */