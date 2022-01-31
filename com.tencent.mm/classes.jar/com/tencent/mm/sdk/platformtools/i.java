package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public static String jDr = "]]>";
  public StringBuffer jDt;
  public String ymP;
  
  public i()
  {
    AppMethodBeat.i(51972);
    this.ymP = "";
    this.jDt = new StringBuffer();
    AppMethodBeat.o(51972);
  }
  
  public i(String paramString)
  {
    AppMethodBeat.i(51973);
    this.ymP = "";
    this.jDt = new StringBuffer();
    this.ymP = paramString;
    Gp(this.ymP);
    AppMethodBeat.o(51973);
  }
  
  private void Gp(String paramString)
  {
    AppMethodBeat.i(51974);
    this.jDt.append("<" + paramString + ">");
    AppMethodBeat.o(51974);
  }
  
  private void setText(String paramString)
  {
    AppMethodBeat.i(51976);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(51976);
      return;
    }
    if (paramString.contains(jDr))
    {
      this.jDt.append("<![CDATA[" + bo.apT(paramString) + "]]>");
      AppMethodBeat.o(51976);
      return;
    }
    this.jDt.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(51976);
  }
  
  public final void Gq(String paramString)
  {
    AppMethodBeat.i(51975);
    this.jDt.append("</" + paramString + ">");
    AppMethodBeat.o(51975);
  }
  
  public final void da(String paramString1, String paramString2)
  {
    AppMethodBeat.i(51977);
    Gp(paramString1);
    setText(paramString2);
    Gq(paramString1);
    AppMethodBeat.o(51977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.i
 * JD-Core Version:    0.7.0.1
 */