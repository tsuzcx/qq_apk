package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public String MsV = "";
  public boolean MsW = false;
  public int path;
  
  public e(int paramInt)
  {
    this.path = paramInt;
    this.MsW = false;
  }
  
  public e(String paramString)
  {
    this.MsV = paramString;
    this.MsW = true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(266262);
    String str = "NewTipsPath{dynamicPath='" + this.MsV + '\'' + ", path=" + this.path + ", isDynamicPtch=" + this.MsW + '}';
    AppMethodBeat.o(266262);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.e
 * JD-Core Version:    0.7.0.1
 */