package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q
{
  public String mStartTag;
  public String pxA;
  public String pxB;
  public boolean pxC;
  public boolean pxD = false;
  public String pxy;
  public boolean pxz;
  
  static
  {
    AppMethodBeat.i(30662);
    EAP = new q("NONE", 0, "", "", "", "", false);
    EAQ = new q("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    EAR = new q("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    EAS = new q("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    EAT = new q[] { EAP, EAQ, EAR, EAS };
    AppMethodBeat.o(30662);
  }
  
  private q(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mStartTag = paramString1;
    this.pxy = paramString2;
    this.pxA = paramString3;
    this.pxB = paramString4;
    this.pxz = false;
    this.pxC = paramBoolean1;
  }
  
  public static q b(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return EAQ;
    }
    if ((paramParagraphStyle instanceof m)) {
      return EAR;
    }
    if ((paramParagraphStyle instanceof k)) {
      return EAS;
    }
    return null;
  }
  
  public final boolean cft()
  {
    return this == EAQ;
  }
  
  public final boolean cfu()
  {
    return this == EAR;
  }
  
  public final boolean cfv()
  {
    return this == EAS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.q
 * JD-Core Version:    0.7.0.1
 */