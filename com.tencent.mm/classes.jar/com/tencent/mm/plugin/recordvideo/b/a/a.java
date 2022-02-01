package com.tencent.mm.plugin.recordvideo.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/IRecordBasicConfig;", "()V", "enableFavorite", "", "enableImage2Video", "enableLyrics", "enableMusic", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getElementName", "Lcom/tencent/mm/plugin/recordvideo/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-recordvideo_release"})
public final class a
  extends h<a>
{
  public static final a xxI;
  
  static
  {
    AppMethodBeat.i(75393);
    xxI = new a();
    AppMethodBeat.o(75393);
  }
  
  public final void atd()
  {
    boolean bool2 = true;
    AppMethodBeat.i(75390);
    a locala = (a)atb();
    if (Y("StoryEditVideoBgmSwitch", 1) == 1)
    {
      bool1 = true;
      locala.xxU = bool1;
      int i = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 1);
      ((a)atb()).xxV = (i * 100);
      ((a)atb()).xxW = (i * 100);
      if ((!i.IS_FLAVOR_RED) && (!i.IS_FLAVOR_PURPLE) && (!i.DEBUG)) {
        break label294;
      }
      ((a)atb()).xxJ = true;
      ((a)atb()).xxK = true;
      ((a)atb()).xxL = true;
      ((a)atb()).xxO = true;
      ((a)atb()).xxN = true;
      locala = (a)atb();
      bool1 = true;
      label155:
      locala.xxQ = bool1;
      ((a)atb()).xxR = Y("StoryFeaturedExpiredTime", 15552000);
      ((a)atb()).xxS = ((b)g.ab(b.class)).a(b.a.qqY, 10);
      locala = (a)atb();
      if (((b)g.ab(b.class)).a(b.a.qqU, 1) != 1) {
        break label549;
      }
      bool1 = true;
      label239:
      locala.xxM = bool1;
      locala = (a)atb();
      if (((b)g.ab(b.class)).a(b.a.qrb, 1) != 1) {
        break label554;
      }
    }
    label294:
    label554:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.xxP = bool1;
      AppMethodBeat.o(75390);
      return;
      bool1 = false;
      break;
      locala = (a)atb();
      if (((b)g.ab(b.class)).a(b.a.qqR, 0) == 1)
      {
        bool1 = true;
        label326:
        locala.xxJ = bool1;
        locala = (a)atb();
        if (((b)g.ab(b.class)).a(b.a.qqS, 0) != 1) {
          break label524;
        }
        bool1 = true;
        label364:
        locala.xxK = bool1;
        locala = (a)atb();
        if (((b)g.ab(b.class)).a(b.a.qqT, 0) != 1) {
          break label529;
        }
        bool1 = true;
        locala.xxL = bool1;
        locala = (a)atb();
        if (((b)g.ab(b.class)).a(b.a.qqW, 1) != 1) {
          break label534;
        }
        bool1 = true;
        label440:
        locala.xxO = bool1;
        locala = (a)atb();
        if (((b)g.ab(b.class)).a(b.a.qqV, 1) != 1) {
          break label539;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        locala.xxN = bool1;
        locala = (a)atb();
        if (((b)g.ab(b.class)).a(b.a.qra, 0) != 1) {
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
  
  public final boolean dFA()
  {
    AppMethodBeat.i(200291);
    boolean bool = ((a)ate()).xxP;
    AppMethodBeat.o(200291);
    return bool;
  }
  
  public final boolean dFz()
  {
    AppMethodBeat.i(75391);
    boolean bool = ((a)ate()).xxK;
    AppMethodBeat.o(75391);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
  public static final class a
  {
    boolean xxJ;
    boolean xxK;
    boolean xxL;
    public boolean xxM;
    boolean xxN;
    public boolean xxO;
    boolean xxP = true;
    boolean xxQ;
    int xxR = 15552000;
    public int xxS = 10;
    private int xxT = 2;
    boolean xxU = true;
    int xxV = 0;
    int xxW = 0;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.xxT != paramObject.xxT) || (this.xxU != paramObject.xxU) || (this.xxV != paramObject.xxV) || (this.xxW != paramObject.xxW)) {}
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
      String str = "StoryBasicConfig(repeatMD5=" + this.xxT + ", showMusicIcon=" + this.xxU + ", albumThumbHeight=" + this.xxV + ", albumThumbWidth=" + this.xxW + ")";
      AppMethodBeat.o(75388);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.a.a
 * JD-Core Version:    0.7.0.1
 */