package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.cwt;
import java.util.LinkedList;

public final class b
{
  public String Title;
  public String dwW;
  public int ePo;
  public int nEf;
  public String vhe;
  public String wpM;
  public float wpN;
  public int wpO;
  public LinkedList<Integer> wpP;
  public int wpQ;
  public LinkedList<cwt> wpR;
  public float wpS;
  public String wpT;
  public SKBuiltinBuffer_t wpU;
  public btl wpV;
  
  public b(String paramString, btl parambtl)
  {
    AppMethodBeat.i(26547);
    this.wpP = new LinkedList();
    this.wpR = new LinkedList();
    this.vhe = paramString;
    this.wpM = parambtl.wpM;
    this.Title = parambtl.Title;
    this.wpN = parambtl.wpN;
    this.wpO = parambtl.wpO;
    this.wpP = parambtl.wpP;
    this.wpQ = parambtl.wpQ;
    this.wpR = parambtl.wpR;
    this.wpS = parambtl.wpS;
    this.wpT = parambtl.wpT;
    this.nEf = parambtl.nEf;
    this.wpU = parambtl.wpU;
    this.ePo = parambtl.GOf;
    this.wpV = parambtl;
    AppMethodBeat.o(26547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.b
 * JD-Core Version:    0.7.0.1
 */