package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bk;

public final class p$b
{
  private String fGR;
  private String fGS;
  private String fGT;
  
  public p$b(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.fGR = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.fGS = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this.fGT = paramString1;
  }
  
  public final String acH()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((bk.Zz(this.fGR)) || (bk.Zz(this.fGS)) || (bk.Zz(this.fGT)))
    {
      if (this.fGT.trim().length() > 0) {
        localStringBuilder.append(this.fGT);
      }
      if (this.fGS.trim().length() > 0) {
        localStringBuilder.append(this.fGS);
      }
      if (this.fGR.trim().length() > 0) {
        localStringBuilder.append(this.fGR);
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (this.fGR.trim().length() > 0) {
        localStringBuilder.append(this.fGR);
      }
      if (this.fGS.trim().length() > 0)
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.fGS);
      }
      if (this.fGT.trim().length() > 0)
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.fGT);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.p.b
 * JD-Core Version:    0.7.0.1
 */