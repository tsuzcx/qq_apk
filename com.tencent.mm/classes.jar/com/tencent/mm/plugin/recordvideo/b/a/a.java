package com.tencent.mm.plugin.recordvideo.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/IRecordBasicConfig;", "()V", "enableFavorite", "", "enableImage2Video", "enableLyrics", "enableMusic", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getElementName", "Lcom/tencent/mm/plugin/recordvideo/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-recordvideo_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.b.h<a>
{
  public static final a wpS;
  
  static
  {
    AppMethodBeat.i(75393);
    wpS = new a();
    AppMethodBeat.o(75393);
  }
  
  public final void aqo()
  {
    boolean bool2 = true;
    AppMethodBeat.i(75390);
    a locala = (a)aqm();
    if (U("StoryEditVideoBgmSwitch", 1) == 1)
    {
      bool1 = true;
      locala.wqe = bool1;
      int i = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 1);
      ((a)aqm()).wqf = (i * 100);
      ((a)aqm()).wqg = (i * 100);
      if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.h.DEBUG)) {
        break label294;
      }
      ((a)aqm()).wpT = true;
      ((a)aqm()).wpU = true;
      ((a)aqm()).wpV = true;
      ((a)aqm()).wpY = true;
      ((a)aqm()).wpX = true;
      locala = (a)aqm();
      bool1 = true;
      label155:
      locala.wqa = bool1;
      ((a)aqm()).wqb = U("StoryFeaturedExpiredTime", 15552000);
      ((a)aqm()).wqc = ((b)g.ab(b.class)).a(b.a.pNb, 10);
      locala = (a)aqm();
      if (((b)g.ab(b.class)).a(b.a.pMX, 1) != 1) {
        break label549;
      }
      bool1 = true;
      label239:
      locala.wpW = bool1;
      locala = (a)aqm();
      if (((b)g.ab(b.class)).a(b.a.pNe, 1) != 1) {
        break label554;
      }
    }
    label294:
    label554:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.wpZ = bool1;
      AppMethodBeat.o(75390);
      return;
      bool1 = false;
      break;
      locala = (a)aqm();
      if (((b)g.ab(b.class)).a(b.a.pMU, 0) == 1)
      {
        bool1 = true;
        label326:
        locala.wpT = bool1;
        locala = (a)aqm();
        if (((b)g.ab(b.class)).a(b.a.pMV, 0) != 1) {
          break label524;
        }
        bool1 = true;
        label364:
        locala.wpU = bool1;
        locala = (a)aqm();
        if (((b)g.ab(b.class)).a(b.a.pMW, 0) != 1) {
          break label529;
        }
        bool1 = true;
        locala.wpV = bool1;
        locala = (a)aqm();
        if (((b)g.ab(b.class)).a(b.a.pMZ, 1) != 1) {
          break label534;
        }
        bool1 = true;
        label440:
        locala.wpY = bool1;
        locala = (a)aqm();
        if (((b)g.ab(b.class)).a(b.a.pMY, 1) != 1) {
          break label539;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        locala.wpX = bool1;
        locala = (a)aqm();
        if (((b)g.ab(b.class)).a(b.a.pNd, 0) != 1) {
          break label544;
        }
        bool1 = true;
        break;
        bool1 = false;
        break label326;
        bool1 = false;
        break label364;
        bool1 = false;
        break label402;
        bool1 = false;
        break label440;
      }
      bool1 = false;
      break label155;
      bool1 = false;
      break label239;
    }
  }
  
  public final boolean dve()
  {
    AppMethodBeat.i(75391);
    boolean bool = ((a)aqp()).wpU;
    AppMethodBeat.o(75391);
    return bool;
  }
  
  public final boolean dvf()
  {
    AppMethodBeat.i(75392);
    boolean bool = ((a)aqp()).wpW;
    AppMethodBeat.o(75392);
    return bool;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
  public static final class a
  {
    boolean wpT;
    boolean wpU;
    boolean wpV;
    boolean wpW;
    boolean wpX;
    public boolean wpY;
    public boolean wpZ = true;
    boolean wqa;
    int wqb = 15552000;
    public int wqc = 10;
    private int wqd = 2;
    boolean wqe = true;
    int wqf = 0;
    int wqg = 0;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.wqd != paramObject.wqd) || (this.wqe != paramObject.wqe) || (this.wqf != paramObject.wqf) || (this.wqg != paramObject.wqg)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(75388);
      String str = "StoryBasicConfig(repeatMD5=" + this.wqd + ", showMusicIcon=" + this.wqe + ", albumThumbHeight=" + this.wqf + ", albumThumbWidth=" + this.wqg + ")";
      AppMethodBeat.o(75388);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.a.a
 * JD-Core Version:    0.7.0.1
 */