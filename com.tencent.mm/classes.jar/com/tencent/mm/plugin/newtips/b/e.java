package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public int path;
  public String ueF = "";
  public boolean ueG = false;
  
  public e(int paramInt)
  {
    this.path = paramInt;
    this.ueG = false;
  }
  
  public e(String paramString)
  {
    this.ueF = paramString;
    this.ueG = true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189177);
    String str = "NewTipsPath{dynamicPath='" + this.ueF + '\'' + ", path=" + this.path + ", isDynamicPtch=" + this.ueG + '}';
    AppMethodBeat.o(189177);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.e
 * JD-Core Version:    0.7.0.1
 */