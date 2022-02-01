package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/xeffect/PAGTextInfo;", "", "text", "", "fontSize", "", "fontFamily", "italic", "", "bold", "(Ljava/lang/String;FLjava/lang/String;ZZ)V", "getBold", "()Z", "setBold", "(Z)V", "getFontFamily", "()Ljava/lang/String;", "setFontFamily", "(Ljava/lang/String;)V", "getFontSize", "()F", "setFontSize", "(F)V", "getItalic", "setItalic", "getText", "setText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "renderlib_release"})
public final class c
{
  boolean LBk;
  String fontFamily;
  float fontSize;
  boolean sWe;
  String text;
  
  public c()
  {
    this(null, null, 31);
  }
  
  private c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220318);
    this.text = paramString1;
    this.fontSize = 0.0F;
    this.fontFamily = paramString2;
    this.LBk = false;
    this.sWe = false;
    AppMethodBeat.o(220318);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220322);
    if (this != paramObject)
    {
      if (!(paramObject instanceof c)) {
        break label115;
      }
      paramObject = (c)paramObject;
      if ((!p.i(this.text, paramObject.text)) || (Float.compare(this.fontSize, paramObject.fontSize) != 0) || (!p.i(this.fontFamily, paramObject.fontFamily))) {
        break label115;
      }
      if (this.LBk != paramObject.LBk) {
        break label105;
      }
      i = 1;
      if (i == 0) {
        break label115;
      }
      if (this.sWe != paramObject.sWe) {
        break label110;
      }
    }
    label105:
    label110:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label115;
      }
      AppMethodBeat.o(220322);
      return true;
      i = 0;
      break;
    }
    label115:
    AppMethodBeat.o(220322);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220320);
    String str = "PAGTextInfo(text=" + this.text + ", fontSize=" + this.fontSize + ", fontFamily=" + this.fontFamily + ", italic=" + this.LBk + ", bold=" + this.sWe + ")";
    AppMethodBeat.o(220320);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.xeffect.c
 * JD-Core Version:    0.7.0.1
 */