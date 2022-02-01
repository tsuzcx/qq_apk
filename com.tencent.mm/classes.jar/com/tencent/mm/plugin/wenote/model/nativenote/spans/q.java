package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q
{
  public String mStartTag;
  public String qTt;
  public boolean qTu;
  public String qTv;
  public String qTw;
  public boolean qTx;
  public boolean qTy = false;
  
  static
  {
    AppMethodBeat.i(30662);
    JIZ = new q("NONE", 0, "", "", "", "", false);
    JJa = new q("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    JJb = new q("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    JJc = new q("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    JJd = new q[] { JIZ, JJa, JJb, JJc };
    AppMethodBeat.o(30662);
  }
  
  private q(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mStartTag = paramString1;
    this.qTt = paramString2;
    this.qTv = paramString3;
    this.qTw = paramString4;
    this.qTu = false;
    this.qTx = paramBoolean1;
  }
  
  public static q b(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return JJa;
    }
    if ((paramParagraphStyle instanceof m)) {
      return JJb;
    }
    if ((paramParagraphStyle instanceof k)) {
      return JJc;
    }
    return null;
  }
  
  public final boolean cEw()
  {
    return this == JJa;
  }
  
  public final boolean cEx()
  {
    return this == JJb;
  }
  
  public final boolean cEy()
  {
    return this == JJc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.q
 * JD-Core Version:    0.7.0.1
 */