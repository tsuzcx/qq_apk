package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "", "text", "", "fontSize", "", "fontFamily", "italic", "", "bold", "(Ljava/lang/String;FLjava/lang/String;ZZ)V", "getBold", "()Z", "setBold", "(Z)V", "getFontFamily", "()Ljava/lang/String;", "setFontFamily", "(Ljava/lang/String;)V", "getFontSize", "()F", "setFontSize", "(F)V", "getItalic", "setItalic", "getText", "setText", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class h
{
  boolean agXM;
  boolean bold;
  String fontFamily;
  float fontSize;
  String text;
  
  public h()
  {
    this(null, null, 31);
  }
  
  private h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234547);
    this.text = paramString1;
    this.fontSize = 0.0F;
    this.fontFamily = paramString2;
    this.agXM = false;
    this.bold = false;
    AppMethodBeat.o(234547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.h
 * JD-Core Version:    0.7.0.1
 */