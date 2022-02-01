package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
{
  public static final byte[] mqF = { 68, 88, 68, 73, 70, 70 };
  public int IDA;
  public int IDB;
  public int IDC;
  public int IDD;
  public int IDE;
  public int IDF;
  public int IDG;
  public int IDH;
  public int IDI;
  public int IDJ;
  public byte[] IDK;
  public final com.tencent.tinker.a.a.a.a IDp;
  private short IDq;
  public int IDr;
  private int IDs;
  public int IDt;
  public int IDu;
  public int IDv;
  public int IDw;
  public int IDx;
  public int IDy;
  public int IDz;
  
  public a(InputStream paramInputStream)
  {
    this.IDp = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.p(paramInputStream)));
    paramInputStream = this.IDp.ach(mqF.length);
    if (c.p(paramInputStream, mqF) != 0) {
      throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(paramInputStream));
    }
    this.IDq = this.IDp.aIq.getShort();
    if (c.a(this.IDq, (short)2) != 0) {
      throw new IllegalStateException("bad dex patch file version: " + this.IDq + ", expected: 2");
    }
    this.IDr = this.IDp.aIq.getInt();
    this.IDs = this.IDp.aIq.getInt();
    this.IDt = this.IDp.aIq.getInt();
    this.IDu = this.IDp.aIq.getInt();
    this.IDv = this.IDp.aIq.getInt();
    this.IDw = this.IDp.aIq.getInt();
    this.IDx = this.IDp.aIq.getInt();
    this.IDy = this.IDp.aIq.getInt();
    this.IDz = this.IDp.aIq.getInt();
    this.IDA = this.IDp.aIq.getInt();
    this.IDB = this.IDp.aIq.getInt();
    this.IDC = this.IDp.aIq.getInt();
    this.IDD = this.IDp.aIq.getInt();
    this.IDE = this.IDp.aIq.getInt();
    this.IDF = this.IDp.aIq.getInt();
    this.IDG = this.IDp.aIq.getInt();
    this.IDH = this.IDp.aIq.getInt();
    this.IDI = this.IDp.aIq.getInt();
    this.IDJ = this.IDp.aIq.getInt();
    this.IDK = this.IDp.ach(20);
    paramInputStream = this.IDp;
    int i = this.IDs;
    paramInputStream.aIq.position(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.c.a.b.a
 * JD-Core Version:    0.7.0.1
 */