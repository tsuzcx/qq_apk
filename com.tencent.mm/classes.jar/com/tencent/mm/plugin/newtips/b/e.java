package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public String GwV = "";
  public boolean GwW = false;
  public int path;
  
  public e(int paramInt)
  {
    this.path = paramInt;
    this.GwW = false;
  }
  
  public e(String paramString)
  {
    this.GwV = paramString;
    this.GwW = true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186282);
    String str = "NewTipsPath{dynamicPath='" + this.GwV + '\'' + ", path=" + this.path + ", isDynamicPtch=" + this.GwW + '}';
    AppMethodBeat.o(186282);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.e
 * JD-Core Version:    0.7.0.1
 */