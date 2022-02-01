package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "", "text", "", "fontSize", "", "fontFamily", "italic", "", "bold", "(Ljava/lang/String;FLjava/lang/String;ZZ)V", "getBold", "()Z", "setBold", "(Z)V", "getFontFamily", "()Ljava/lang/String;", "setFontFamily", "(Ljava/lang/String;)V", "getFontSize", "()F", "setFontSize", "(F)V", "getItalic", "setItalic", "getText", "setText", "renderlib_release"})
public final class h
{
  boolean RxU;
  String fontFamily;
  float fontSize;
  boolean sYW;
  String text;
  
  public h()
  {
    this(null, null, 31);
  }
  
  public h(String paramString1, float paramFloat, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(237073);
    this.text = paramString1;
    this.fontSize = paramFloat;
    this.fontFamily = paramString2;
    this.RxU = paramBoolean1;
    this.sYW = paramBoolean2;
    AppMethodBeat.o(237073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.h
 * JD-Core Version:    0.7.0.1
 */