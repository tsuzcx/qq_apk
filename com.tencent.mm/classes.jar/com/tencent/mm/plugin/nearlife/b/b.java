package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.crm;
import java.util.LinkedList;

public final class b
{
  public String Title;
  public String dlj;
  public int exP;
  public int ndI;
  public String uev;
  public float vkA;
  public String vkB;
  public SKBuiltinBuffer_t vkC;
  public boy vkD;
  public String vku;
  public float vkv;
  public int vkw;
  public LinkedList<Integer> vkx;
  public int vky;
  public LinkedList<crm> vkz;
  
  public b(String paramString, boy paramboy)
  {
    AppMethodBeat.i(26547);
    this.vkx = new LinkedList();
    this.vkz = new LinkedList();
    this.uev = paramString;
    this.vku = paramboy.vku;
    this.Title = paramboy.Title;
    this.vkv = paramboy.vkv;
    this.vkw = paramboy.vkw;
    this.vkx = paramboy.vkx;
    this.vky = paramboy.vky;
    this.vkz = paramboy.vkz;
    this.vkA = paramboy.vkA;
    this.vkB = paramboy.vkB;
    this.ndI = paramboy.ndI;
    this.vkC = paramboy.vkC;
    this.exP = paramboy.FeB;
    this.vkD = paramboy;
    AppMethodBeat.o(26547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.b
 * JD-Core Version:    0.7.0.1
 */