package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q
{
  public String mStartTag;
  public String pEc;
  public boolean pEd;
  public String pEe;
  public String pEf;
  public boolean pEg;
  public boolean pEh = false;
  
  static
  {
    AppMethodBeat.i(30662);
    ETl = new q("NONE", 0, "", "", "", "", false);
    ETm = new q("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    ETn = new q("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    ETo = new q("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    ETp = new q[] { ETl, ETm, ETn, ETo };
    AppMethodBeat.o(30662);
  }
  
  private q(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mStartTag = paramString1;
    this.pEc = paramString2;
    this.pEe = paramString3;
    this.pEf = paramString4;
    this.pEd = false;
    this.pEg = paramBoolean1;
  }
  
  public static q b(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return ETm;
    }
    if ((paramParagraphStyle instanceof m)) {
      return ETn;
    }
    if ((paramParagraphStyle instanceof k)) {
      return ETo;
    }
    return null;
  }
  
  public final boolean cgJ()
  {
    return this == ETm;
  }
  
  public final boolean cgK()
  {
    return this == ETn;
  }
  
  public final boolean cgL()
  {
    return this == ETo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.q
 * JD-Core Version:    0.7.0.1
 */