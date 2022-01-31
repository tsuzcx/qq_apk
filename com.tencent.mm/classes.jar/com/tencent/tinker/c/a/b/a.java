package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
{
  public static final byte[] jzh = { 68, 88, 68, 73, 70, 70 };
  public int BrA;
  public int BrB;
  public int BrC;
  public int BrD;
  public int BrE;
  public int BrF;
  public int BrG;
  public int BrH;
  public int BrI;
  public int BrJ;
  public int BrK;
  public int BrL;
  public int BrM;
  public int BrN;
  public int BrO;
  public byte[] BrP;
  public final com.tencent.tinker.a.a.a.a Bru;
  private short Brv;
  public int Brw;
  private int Brx;
  public int Bry;
  public int Brz;
  
  public a(InputStream paramInputStream)
  {
    this.Bru = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.u(paramInputStream)));
    paramInputStream = this.Bru.Sw(jzh.length);
    if (c.o(paramInputStream, jzh) != 0) {
      throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(paramInputStream));
    }
    this.Brv = this.Bru.aAS.getShort();
    if (c.b(this.Brv, (short)2) != 0) {
      throw new IllegalStateException("bad dex patch file version: " + this.Brv + ", expected: 2");
    }
    this.Brw = this.Bru.aAS.getInt();
    this.Brx = this.Bru.aAS.getInt();
    this.Bry = this.Bru.aAS.getInt();
    this.Brz = this.Bru.aAS.getInt();
    this.BrA = this.Bru.aAS.getInt();
    this.BrB = this.Bru.aAS.getInt();
    this.BrC = this.Bru.aAS.getInt();
    this.BrD = this.Bru.aAS.getInt();
    this.BrE = this.Bru.aAS.getInt();
    this.BrF = this.Bru.aAS.getInt();
    this.BrG = this.Bru.aAS.getInt();
    this.BrH = this.Bru.aAS.getInt();
    this.BrI = this.Bru.aAS.getInt();
    this.BrJ = this.Bru.aAS.getInt();
    this.BrK = this.Bru.aAS.getInt();
    this.BrL = this.Bru.aAS.getInt();
    this.BrM = this.Bru.aAS.getInt();
    this.BrN = this.Bru.aAS.getInt();
    this.BrO = this.Bru.aAS.getInt();
    this.BrP = this.Bru.Sw(20);
    paramInputStream = this.Bru;
    int i = this.Brx;
    paramInputStream.aAS.position(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.c.a.b.a
 * JD-Core Version:    0.7.0.1
 */