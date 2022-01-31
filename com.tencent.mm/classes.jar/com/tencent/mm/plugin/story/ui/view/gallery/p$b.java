package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "preloadFinish", "(ZJJZ)V", "()Z", "getLength", "()J", "getOffset", "getPreloadFinish", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-story_release"})
public final class p$b
{
  final long aPF;
  final long offset;
  final boolean sUU;
  final boolean sUV;
  
  public p$b(boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
  {
    this.sUU = paramBoolean1;
    this.offset = paramLong1;
    this.aPF = paramLong2;
    this.sUV = paramBoolean2;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof b)) {
        break label107;
      }
      paramObject = (b)paramObject;
      if (this.sUU != paramObject.sUU) {
        break label109;
      }
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        break label107;
      }
      if (this.offset != paramObject.offset) {
        break label114;
      }
      i = 1;
      label57:
      bool1 = bool2;
      if (i == 0) {
        break label107;
      }
      if (this.aPF != paramObject.aPF) {
        break label119;
      }
      i = 1;
      label78:
      bool1 = bool2;
      if (i == 0) {
        break label107;
      }
      if (this.sUV != paramObject.sUV) {
        break label124;
      }
    }
    label107:
    label109:
    label114:
    label119:
    label124:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
      i = 0;
      break label57;
      i = 0;
      break label78;
    }
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110875);
    String str = "MoovReadyInfo(isMoovReady=" + this.sUU + ", offset=" + this.offset + ", length=" + this.aPF + ", preloadFinish=" + this.sUV + ")";
    AppMethodBeat.o(110875);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.p.b
 * JD-Core Version:    0.7.0.1
 */