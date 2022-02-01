package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public static String nxj = "]]>";
  public String IcB;
  public StringBuffer nxl;
  
  public l()
  {
    AppMethodBeat.i(157525);
    this.IcB = "";
    this.nxl = new StringBuffer();
    AppMethodBeat.o(157525);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(157526);
    this.IcB = "";
    this.nxl = new StringBuffer();
    this.IcB = paramString;
    VY(this.IcB);
    AppMethodBeat.o(157526);
  }
  
  private void VY(String paramString)
  {
    AppMethodBeat.i(157527);
    this.nxl.append("<" + paramString + ">");
    AppMethodBeat.o(157527);
  }
  
  private void setText(String paramString)
  {
    AppMethodBeat.i(157529);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157529);
      return;
    }
    if (paramString.contains(nxj))
    {
      this.nxl.append("<![CDATA[" + bt.aRc(paramString) + "]]>");
      AppMethodBeat.o(157529);
      return;
    }
    this.nxl.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(157529);
  }
  
  public final void VZ(String paramString)
  {
    AppMethodBeat.i(157528);
    this.nxl.append("</" + paramString + ">");
    AppMethodBeat.o(157528);
  }
  
  public final void ew(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157530);
    VY(paramString1);
    setText(paramString2);
    VZ(paramString1);
    AppMethodBeat.o(157530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.l
 * JD-Core Version:    0.7.0.1
 */