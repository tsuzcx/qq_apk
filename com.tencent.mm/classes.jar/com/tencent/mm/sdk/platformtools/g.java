package com.tencent.mm.sdk.platformtools;

public final class g
{
  public static String hJN = "]]>";
  public StringBuffer hJQ = new StringBuffer();
  public String ueo = "";
  
  public g() {}
  
  public g(String paramString)
  {
    this.ueo = paramString;
    xw(this.ueo);
  }
  
  private void xw(String paramString)
  {
    this.hJQ.append("<" + paramString + ">");
  }
  
  public final void cj(String paramString1, String paramString2)
  {
    xw(paramString1);
    if (!bk.bl(paramString2))
    {
      if (!paramString2.contains(hJN)) {
        break label60;
      }
      this.hJQ.append("<![CDATA[" + bk.ZP(paramString2) + "]]>");
    }
    for (;;)
    {
      xx(paramString1);
      return;
      label60:
      this.hJQ.append("<![CDATA[" + paramString2 + "]]>");
    }
  }
  
  public final void xx(String paramString)
  {
    this.hJQ.append("</" + paramString + ">");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.g
 * JD-Core Version:    0.7.0.1
 */