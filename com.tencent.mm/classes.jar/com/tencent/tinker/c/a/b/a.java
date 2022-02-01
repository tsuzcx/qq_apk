package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
{
  public static final byte[] mSH = { 68, 88, 68, 73, 70, 70 };
  public int KpA;
  private int KpB;
  public int KpC;
  public int KpD;
  public int KpE;
  public int KpF;
  public int KpG;
  public int KpH;
  public int KpI;
  public int KpJ;
  public int KpK;
  public int KpL;
  public int KpM;
  public int KpN;
  public int KpO;
  public int KpP;
  public int KpQ;
  public int KpR;
  public int KpS;
  public byte[] KpT;
  public final com.tencent.tinker.a.a.a.a Kpy;
  private short Kpz;
  
  public a(InputStream paramInputStream)
  {
    this.Kpy = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.o(paramInputStream)));
    paramInputStream = this.Kpy.afd(mSH.length);
    if (c.p(paramInputStream, mSH) != 0) {
      throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(paramInputStream));
    }
    this.Kpz = this.Kpy.aJg.getShort();
    if (c.a(this.Kpz, (short)2) != 0) {
      throw new IllegalStateException("bad dex patch file version: " + this.Kpz + ", expected: 2");
    }
    this.KpA = this.Kpy.aJg.getInt();
    this.KpB = this.Kpy.aJg.getInt();
    this.KpC = this.Kpy.aJg.getInt();
    this.KpD = this.Kpy.aJg.getInt();
    this.KpE = this.Kpy.aJg.getInt();
    this.KpF = this.Kpy.aJg.getInt();
    this.KpG = this.Kpy.aJg.getInt();
    this.KpH = this.Kpy.aJg.getInt();
    this.KpI = this.Kpy.aJg.getInt();
    this.KpJ = this.Kpy.aJg.getInt();
    this.KpK = this.Kpy.aJg.getInt();
    this.KpL = this.Kpy.aJg.getInt();
    this.KpM = this.Kpy.aJg.getInt();
    this.KpN = this.Kpy.aJg.getInt();
    this.KpO = this.Kpy.aJg.getInt();
    this.KpP = this.Kpy.aJg.getInt();
    this.KpQ = this.Kpy.aJg.getInt();
    this.KpR = this.Kpy.aJg.getInt();
    this.KpS = this.Kpy.aJg.getInt();
    this.KpT = this.Kpy.afd(20);
    paramInputStream = this.Kpy;
    int i = this.KpB;
    paramInputStream.aJg.position(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.c.a.b.a
 * JD-Core Version:    0.7.0.1
 */