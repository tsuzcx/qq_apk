package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q
{
  public String mStartTag;
  public String oTO;
  public boolean oTP;
  public String oTQ;
  public String oTR;
  public boolean oTS;
  public boolean oTT = false;
  
  static
  {
    AppMethodBeat.i(30662);
    CWT = new q("NONE", 0, "", "", "", "", false);
    CWU = new q("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    CWV = new q("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    CWW = new q("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    CWX = new q[] { CWT, CWU, CWV, CWW };
    AppMethodBeat.o(30662);
  }
  
  private q(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mStartTag = paramString1;
    this.oTO = paramString2;
    this.oTQ = paramString3;
    this.oTR = paramString4;
    this.oTP = false;
    this.oTS = paramBoolean1;
  }
  
  public static q b(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return CWU;
    }
    if ((paramParagraphStyle instanceof m)) {
      return CWV;
    }
    if ((paramParagraphStyle instanceof k)) {
      return CWW;
    }
    return null;
  }
  
  public final boolean caP()
  {
    return this == CWU;
  }
  
  public final boolean caQ()
  {
    return this == CWV;
  }
  
  public final boolean caR()
  {
    return this == CWW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.q
 * JD-Core Version:    0.7.0.1
 */