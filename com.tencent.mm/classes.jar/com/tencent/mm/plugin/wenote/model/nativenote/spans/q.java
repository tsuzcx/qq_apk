package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q
{
  public String mStartTag;
  public boolean uvA;
  public String uvB;
  public String uvC;
  public boolean uvD;
  public boolean uvE = false;
  public String uvz;
  
  static
  {
    AppMethodBeat.i(30662);
    QIr = new q("NONE", 0, "", "", "", "", false);
    QIs = new q("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    QIt = new q("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    QIu = new q("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    QIv = new q[] { QIr, QIs, QIt, QIu };
    AppMethodBeat.o(30662);
  }
  
  private q(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.mStartTag = paramString1;
    this.uvz = paramString2;
    this.uvB = paramString3;
    this.uvC = paramString4;
    this.uvA = false;
    this.uvD = paramBoolean;
  }
  
  public static q b(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return QIs;
    }
    if ((paramParagraphStyle instanceof m)) {
      return QIt;
    }
    if ((paramParagraphStyle instanceof k)) {
      return QIu;
    }
    return null;
  }
  
  public final boolean cTc()
  {
    return this == QIs;
  }
  
  public final boolean cTd()
  {
    return this == QIt;
  }
  
  public final boolean cTe()
  {
    return this == QIu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.q
 * JD-Core Version:    0.7.0.1
 */