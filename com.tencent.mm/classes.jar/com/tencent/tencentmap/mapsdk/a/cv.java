package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cv
{
  private String a;
  private String b;
  
  public cv(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    AppMethodBeat.i(150022);
    String str = this.a + "_" + this.b;
    AppMethodBeat.o(150022);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cv
 * JD-Core Version:    0.7.0.1
 */