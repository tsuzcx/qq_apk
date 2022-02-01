package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  public static String muL = "]]>";
  public String ETA;
  public StringBuffer muN;
  
  public k()
  {
    AppMethodBeat.i(157525);
    this.ETA = "";
    this.muN = new StringBuffer();
    AppMethodBeat.o(157525);
  }
  
  public k(String paramString)
  {
    AppMethodBeat.i(157526);
    this.ETA = "";
    this.muN = new StringBuffer();
    this.ETA = paramString;
    Oq(this.ETA);
    AppMethodBeat.o(157526);
  }
  
  private void Oq(String paramString)
  {
    AppMethodBeat.i(157527);
    this.muN.append("<" + paramString + ">");
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
    if (paramString.contains(muL))
    {
      this.muN.append("<![CDATA[" + bt.aGf(paramString) + "]]>");
      AppMethodBeat.o(157529);
      return;
    }
    this.muN.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(157529);
  }
  
  public final void Or(String paramString)
  {
    AppMethodBeat.i(157528);
    this.muN.append("</" + paramString + ">");
    AppMethodBeat.o(157528);
  }
  
  public final void eb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157530);
    Oq(paramString1);
    setText(paramString2);
    Or(paramString1);
    AppMethodBeat.o(157530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.k
 * JD-Core Version:    0.7.0.1
 */