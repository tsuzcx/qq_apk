package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bwc;
import java.util.LinkedList;

public final class a
{
  public String Title;
  public int dqG;
  public int jKs;
  public String ohd;
  public String ohe;
  public String pdW;
  public float pdX;
  public int pdY;
  public LinkedList<Integer> pdZ;
  public int pea;
  public LinkedList<bwc> peb;
  public float pec;
  public String ped;
  public SKBuiltinBuffer_t pee;
  public azs pef;
  
  public a(String paramString, azs paramazs)
  {
    AppMethodBeat.i(22923);
    this.pdZ = new LinkedList();
    this.peb = new LinkedList();
    this.ohd = paramString;
    this.pdW = paramazs.pdW;
    this.Title = paramazs.Title;
    this.pdX = paramazs.pdX;
    this.pdY = paramazs.pdY;
    this.pdZ = paramazs.pdZ;
    this.pea = paramazs.pea;
    this.peb = paramazs.peb;
    this.pec = paramazs.pec;
    this.ped = paramazs.ped;
    this.jKs = paramazs.jKs;
    this.pee = paramazs.pee;
    this.dqG = paramazs.xpp;
    this.pef = paramazs;
    AppMethodBeat.o(22923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.a
 * JD-Core Version:    0.7.0.1
 */