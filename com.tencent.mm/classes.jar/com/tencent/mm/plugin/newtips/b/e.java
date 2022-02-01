package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public int path;
  public String vnE = "";
  public boolean vnF = false;
  
  public e(int paramInt)
  {
    this.path = paramInt;
    this.vnF = false;
  }
  
  public e(String paramString)
  {
    this.vnE = paramString;
    this.vnF = true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204975);
    String str = "NewTipsPath{dynamicPath='" + this.vnE + '\'' + ", path=" + this.path + ", isDynamicPtch=" + this.vnF + '}';
    AppMethodBeat.o(204975);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.e
 * JD-Core Version:    0.7.0.1
 */