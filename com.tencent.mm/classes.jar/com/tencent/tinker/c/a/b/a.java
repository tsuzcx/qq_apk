package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
{
  public static final byte[] nyA = { 68, 88, 68, 73, 70, 70 };
  public int MCA;
  public int MCB;
  public int MCC;
  public int MCD;
  public int MCE;
  public int MCF;
  public int MCG;
  public int MCH;
  public int MCI;
  public int MCJ;
  public int MCK;
  public int MCL;
  public int MCM;
  public int MCN;
  public byte[] MCO;
  public final com.tencent.tinker.a.a.a.a MCt;
  private short MCu;
  public int MCv;
  private int MCw;
  public int MCx;
  public int MCy;
  public int MCz;
  
  public a(InputStream paramInputStream)
  {
    this.MCt = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.s(paramInputStream)));
    paramInputStream = this.MCt.aim(nyA.length);
    if (c.q(paramInputStream, nyA) != 0) {
      throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(paramInputStream));
    }
    this.MCu = this.MCt.aKX.getShort();
    if (c.a(this.MCu, (short)2) != 0) {
      throw new IllegalStateException("bad dex patch file version: " + this.MCu + ", expected: 2");
    }
    this.MCv = this.MCt.aKX.getInt();
    this.MCw = this.MCt.aKX.getInt();
    this.MCx = this.MCt.aKX.getInt();
    this.MCy = this.MCt.aKX.getInt();
    this.MCz = this.MCt.aKX.getInt();
    this.MCA = this.MCt.aKX.getInt();
    this.MCB = this.MCt.aKX.getInt();
    this.MCC = this.MCt.aKX.getInt();
    this.MCD = this.MCt.aKX.getInt();
    this.MCE = this.MCt.aKX.getInt();
    this.MCF = this.MCt.aKX.getInt();
    this.MCG = this.MCt.aKX.getInt();
    this.MCH = this.MCt.aKX.getInt();
    this.MCI = this.MCt.aKX.getInt();
    this.MCJ = this.MCt.aKX.getInt();
    this.MCK = this.MCt.aKX.getInt();
    this.MCL = this.MCt.aKX.getInt();
    this.MCM = this.MCt.aKX.getInt();
    this.MCN = this.MCt.aKX.getInt();
    this.MCO = this.MCt.aim(20);
    paramInputStream = this.MCt;
    int i = this.MCw;
    paramInputStream.aKX.position(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.c.a.b.a
 * JD-Core Version:    0.7.0.1
 */