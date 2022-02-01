package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  public static String nCE = "]]>";
  public String IwM;
  public StringBuffer nCG;
  
  public m()
  {
    AppMethodBeat.i(157525);
    this.IwM = "";
    this.nCG = new StringBuffer();
    AppMethodBeat.o(157525);
  }
  
  public m(String paramString)
  {
    AppMethodBeat.i(157526);
    this.IwM = "";
    this.nCG = new StringBuffer();
    this.IwM = paramString;
    WK(this.IwM);
    AppMethodBeat.o(157526);
  }
  
  private void WK(String paramString)
  {
    AppMethodBeat.i(157527);
    this.nCG.append("<" + paramString + ">");
    AppMethodBeat.o(157527);
  }
  
  private void setText(String paramString)
  {
    AppMethodBeat.i(157529);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157529);
      return;
    }
    if (paramString.contains(nCE))
    {
      this.nCG.append("<![CDATA[" + bu.aSz(paramString) + "]]>");
      AppMethodBeat.o(157529);
      return;
    }
    this.nCG.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(157529);
  }
  
  public final void WL(String paramString)
  {
    AppMethodBeat.i(157528);
    this.nCG.append("</" + paramString + ">");
    AppMethodBeat.o(157528);
  }
  
  public final void ez(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157530);
    WK(paramString1);
    setText(paramString2);
    WL(paramString1);
    AppMethodBeat.o(157530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.m
 * JD-Core Version:    0.7.0.1
 */