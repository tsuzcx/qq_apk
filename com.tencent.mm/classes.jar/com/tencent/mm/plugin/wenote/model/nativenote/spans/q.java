package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q
{
  public String vBq;
  public String vBr;
  public boolean vBs;
  public String vBt;
  public String vBu;
  public boolean vBv;
  public boolean vBw = false;
  
  static
  {
    AppMethodBeat.i(26968);
    vBm = new q("NONE", 0, "", "", "", "", false);
    vBn = new q("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    vBo = new q("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    vBp = new q("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    vBx = new q[] { vBm, vBn, vBo, vBp };
    AppMethodBeat.o(26968);
  }
  
  private q(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.vBq = paramString1;
    this.vBr = paramString2;
    this.vBt = paramString3;
    this.vBu = paramString4;
    this.vBs = false;
    this.vBv = paramBoolean1;
  }
  
  public static q a(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return vBn;
    }
    if ((paramParagraphStyle instanceof m)) {
      return vBo;
    }
    if ((paramParagraphStyle instanceof k)) {
      return vBp;
    }
    return null;
  }
  
  public final boolean djH()
  {
    return this == vBn;
  }
  
  public final boolean djI()
  {
    return this == vBo;
  }
  
  public final boolean djJ()
  {
    return this == vBp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.q
 * JD-Core Version:    0.7.0.1
 */