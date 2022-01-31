package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;

public enum q
{
  public String rKM;
  public String rKN;
  public boolean rKO;
  public String rKP;
  public String rKQ;
  public boolean rKR;
  public boolean rKS = false;
  
  private q(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.rKM = paramString1;
    this.rKN = paramString2;
    this.rKP = paramString3;
    this.rKQ = paramString4;
    this.rKO = false;
    this.rKR = paramBoolean1;
  }
  
  public static q a(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return rKJ;
    }
    if ((paramParagraphStyle instanceof m)) {
      return rKK;
    }
    if ((paramParagraphStyle instanceof k)) {
      return rKL;
    }
    return null;
  }
  
  public final boolean cjg()
  {
    return this == rKJ;
  }
  
  public final boolean cjh()
  {
    return this == rKK;
  }
  
  public final boolean cji()
  {
    return this == rKL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.q
 * JD-Core Version:    0.7.0.1
 */