package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public int path;
  public String wIG = "";
  public boolean wIH = false;
  
  public e(int paramInt)
  {
    this.path = paramInt;
    this.wIH = false;
  }
  
  public e(String paramString)
  {
    this.wIG = paramString;
    this.wIH = true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200603);
    String str = "NewTipsPath{dynamicPath='" + this.wIG + '\'' + ", path=" + this.path + ", isDynamicPtch=" + this.wIH + '}';
    AppMethodBeat.o(200603);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.e
 * JD-Core Version:    0.7.0.1
 */