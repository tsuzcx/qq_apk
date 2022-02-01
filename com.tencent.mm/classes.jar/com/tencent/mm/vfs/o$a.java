package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class o$a
{
  public final String agzk;
  public final String basePath;
  
  o$a(String paramString1, String paramString2)
  {
    this.basePath = paramString1;
    this.agzk = paramString2;
  }
  
  public String toString()
  {
    AppMethodBeat.i(238239);
    String str = this.basePath + " -> " + this.agzk;
    AppMethodBeat.o(238239);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.o.a
 * JD-Core Version:    0.7.0.1
 */