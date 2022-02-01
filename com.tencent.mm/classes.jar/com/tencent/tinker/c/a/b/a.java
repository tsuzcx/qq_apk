package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
{
  public static final byte[] ntf = { 68, 88, 68, 73, 70, 70 };
  public int MfA;
  public int MfB;
  public int MfC;
  public int MfD;
  public int MfE;
  public int MfF;
  public int MfG;
  public int MfH;
  public int MfI;
  public int MfJ;
  public int MfK;
  public int MfL;
  public int MfM;
  public int MfN;
  public int MfO;
  public int MfP;
  public int MfQ;
  public byte[] MfR;
  public final com.tencent.tinker.a.a.a.a Mfw;
  private short Mfx;
  public int Mfy;
  private int Mfz;
  
  public a(InputStream paramInputStream)
  {
    this.Mfw = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.s(paramInputStream)));
    paramInputStream = this.Mfw.ahD(ntf.length);
    if (c.p(paramInputStream, ntf) != 0) {
      throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(paramInputStream));
    }
    this.Mfx = this.Mfw.aKX.getShort();
    if (c.a(this.Mfx, (short)2) != 0) {
      throw new IllegalStateException("bad dex patch file version: " + this.Mfx + ", expected: 2");
    }
    this.Mfy = this.Mfw.aKX.getInt();
    this.Mfz = this.Mfw.aKX.getInt();
    this.MfA = this.Mfw.aKX.getInt();
    this.MfB = this.Mfw.aKX.getInt();
    this.MfC = this.Mfw.aKX.getInt();
    this.MfD = this.Mfw.aKX.getInt();
    this.MfE = this.Mfw.aKX.getInt();
    this.MfF = this.Mfw.aKX.getInt();
    this.MfG = this.Mfw.aKX.getInt();
    this.MfH = this.Mfw.aKX.getInt();
    this.MfI = this.Mfw.aKX.getInt();
    this.MfJ = this.Mfw.aKX.getInt();
    this.MfK = this.Mfw.aKX.getInt();
    this.MfL = this.Mfw.aKX.getInt();
    this.MfM = this.Mfw.aKX.getInt();
    this.MfN = this.Mfw.aKX.getInt();
    this.MfO = this.Mfw.aKX.getInt();
    this.MfP = this.Mfw.aKX.getInt();
    this.MfQ = this.Mfw.aKX.getInt();
    this.MfR = this.Mfw.ahD(20);
    paramInputStream = this.Mfw;
    int i = this.Mfz;
    paramInputStream.aKX.position(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.c.a.b.a
 * JD-Core Version:    0.7.0.1
 */