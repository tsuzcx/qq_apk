package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.protocal.protobuf.cxn;
import java.util.LinkedList;

public final class b
{
  public String Title;
  public String dyb;
  public int eQZ;
  public int nJA;
  public String vtl;
  public LinkedList<cxn> wFA;
  public float wFB;
  public String wFC;
  public SKBuiltinBuffer_t wFD;
  public buf wFE;
  public String wFv;
  public float wFw;
  public int wFx;
  public LinkedList<Integer> wFy;
  public int wFz;
  
  public b(String paramString, buf parambuf)
  {
    AppMethodBeat.i(26547);
    this.wFy = new LinkedList();
    this.wFA = new LinkedList();
    this.vtl = paramString;
    this.wFv = parambuf.wFv;
    this.Title = parambuf.Title;
    this.wFw = parambuf.wFw;
    this.wFx = parambuf.wFx;
    this.wFy = parambuf.wFy;
    this.wFz = parambuf.wFz;
    this.wFA = parambuf.wFA;
    this.wFB = parambuf.wFB;
    this.wFC = parambuf.wFC;
    this.nJA = parambuf.nJA;
    this.wFD = parambuf.wFD;
    this.eQZ = parambuf.HhF;
    this.wFE = parambuf;
    AppMethodBeat.o(26547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.b
 * JD-Core Version:    0.7.0.1
 */