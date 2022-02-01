package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.cmf;
import java.util.LinkedList;

public final class b
{
  public String Title;
  public String dnB;
  public int evt;
  public int mBH;
  public String sWi;
  public int ubA;
  public LinkedList<cmf> ubB;
  public float ubC;
  public String ubD;
  public SKBuiltinBuffer_t ubE;
  public blc ubF;
  public String ubw;
  public float ubx;
  public int uby;
  public LinkedList<Integer> ubz;
  
  public b(String paramString, blc paramblc)
  {
    AppMethodBeat.i(26547);
    this.ubz = new LinkedList();
    this.ubB = new LinkedList();
    this.sWi = paramString;
    this.ubw = paramblc.ubw;
    this.Title = paramblc.Title;
    this.ubx = paramblc.ubx;
    this.uby = paramblc.uby;
    this.ubz = paramblc.ubz;
    this.ubA = paramblc.ubA;
    this.ubB = paramblc.ubB;
    this.ubC = paramblc.ubC;
    this.ubD = paramblc.ubD;
    this.mBH = paramblc.mBH;
    this.ubE = paramblc.ubE;
    this.evt = paramblc.DJg;
    this.ubF = paramblc;
    AppMethodBeat.o(26547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.b
 * JD-Core Version:    0.7.0.1
 */