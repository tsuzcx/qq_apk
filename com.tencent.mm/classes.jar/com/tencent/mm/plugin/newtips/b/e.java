package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public int path;
  public String wsW = "";
  public boolean wsX = false;
  
  public e(int paramInt)
  {
    this.path = paramInt;
    this.wsX = false;
  }
  
  public e(String paramString)
  {
    this.wsW = paramString;
    this.wsX = true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(214434);
    String str = "NewTipsPath{dynamicPath='" + this.wsW + '\'' + ", path=" + this.path + ", isDynamicPtch=" + this.wsX + '}';
    AppMethodBeat.o(214434);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.e
 * JD-Core Version:    0.7.0.1
 */