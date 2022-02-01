package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q
{
  public String xBX;
  public String xBY;
  public boolean xBZ;
  public String xCa;
  public String xCb;
  public boolean xCc;
  public boolean xCd = false;
  
  static
  {
    AppMethodBeat.i(30662);
    XBQ = new q("NONE", 0, "", "", "", "", false);
    XBR = new q("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    XBS = new q("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    XBT = new q("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    XBU = new q[] { XBQ, XBR, XBS, XBT };
    AppMethodBeat.o(30662);
  }
  
  private q(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.xBX = paramString1;
    this.xBY = paramString2;
    this.xCa = paramString3;
    this.xCb = paramString4;
    this.xBZ = false;
    this.xCc = paramBoolean;
  }
  
  public static q b(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return XBR;
    }
    if ((paramParagraphStyle instanceof m)) {
      return XBS;
    }
    if ((paramParagraphStyle instanceof k)) {
      return XBT;
    }
    return null;
  }
  
  public final boolean dxv()
  {
    return this == XBR;
  }
  
  public final boolean dxw()
  {
    return this == XBS;
  }
  
  public final boolean dxx()
  {
    return this == XBT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.q
 * JD-Core Version:    0.7.0.1
 */