package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q
{
  public String mStartTag;
  public String oqo;
  public boolean oqp;
  public String oqq;
  public String oqr;
  public boolean oqs;
  public boolean oqt = false;
  
  static
  {
    AppMethodBeat.i(30662);
    BEM = new q("NONE", 0, "", "", "", "", false);
    BEN = new q("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    BEO = new q("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    BEP = new q("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    BEQ = new q[] { BEM, BEN, BEO, BEP };
    AppMethodBeat.o(30662);
  }
  
  private q(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mStartTag = paramString1;
    this.oqo = paramString2;
    this.oqq = paramString3;
    this.oqr = paramString4;
    this.oqp = false;
    this.oqs = paramBoolean1;
  }
  
  public static q b(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return BEN;
    }
    if ((paramParagraphStyle instanceof m)) {
      return BEO;
    }
    if ((paramParagraphStyle instanceof k)) {
      return BEP;
    }
    return null;
  }
  
  public final boolean bTB()
  {
    return this == BEN;
  }
  
  public final boolean bTC()
  {
    return this == BEO;
  }
  
  public final boolean bTD()
  {
    return this == BEP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.q
 * JD-Core Version:    0.7.0.1
 */