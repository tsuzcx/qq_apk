package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dq
{
  public byte[] a;
  public String b = "GBK";
  
  public String toString()
  {
    AppMethodBeat.i(150139);
    try
    {
      String str = new String(this.a, this.b);
      AppMethodBeat.o(150139);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150139);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dq
 * JD-Core Version:    0.7.0.1
 */