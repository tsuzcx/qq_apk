package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public String ADR = "";
  public boolean ADS = false;
  public int path;
  
  public e(int paramInt)
  {
    this.path = paramInt;
    this.ADS = false;
  }
  
  public e(String paramString)
  {
    this.ADR = paramString;
    this.ADS = true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188570);
    String str = "NewTipsPath{dynamicPath='" + this.ADR + '\'' + ", path=" + this.path + ", isDynamicPtch=" + this.ADS + '}';
    AppMethodBeat.o(188570);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.e
 * JD-Core Version:    0.7.0.1
 */