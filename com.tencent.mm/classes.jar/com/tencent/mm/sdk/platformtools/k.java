package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  public static String mWM = "]]>";
  public String GqN;
  public StringBuffer mWO;
  
  public k()
  {
    AppMethodBeat.i(157525);
    this.GqN = "";
    this.mWO = new StringBuffer();
    AppMethodBeat.o(157525);
  }
  
  public k(String paramString)
  {
    AppMethodBeat.i(157526);
    this.GqN = "";
    this.mWO = new StringBuffer();
    this.GqN = paramString;
    SA(this.GqN);
    AppMethodBeat.o(157526);
  }
  
  private void SA(String paramString)
  {
    AppMethodBeat.i(157527);
    this.mWO.append("<" + paramString + ">");
    AppMethodBeat.o(157527);
  }
  
  private void setText(String paramString)
  {
    AppMethodBeat.i(157529);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157529);
      return;
    }
    if (paramString.contains(mWM))
    {
      this.mWO.append("<![CDATA[" + bs.aLw(paramString) + "]]>");
      AppMethodBeat.o(157529);
      return;
    }
    this.mWO.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(157529);
  }
  
  public final void SB(String paramString)
  {
    AppMethodBeat.i(157528);
    this.mWO.append("</" + paramString + ">");
    AppMethodBeat.o(157528);
  }
  
  public final void en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157530);
    SA(paramString1);
    setText(paramString2);
    SB(paramString1);
    AppMethodBeat.o(157530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.k
 * JD-Core Version:    0.7.0.1
 */