package com.tencent.mm.plugin.recordvideo.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/IRecordBasicConfig;", "()V", "enableFavorite", "", "enableImage2Video", "enableLyrics", "enableMusic", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getElementName", "Lcom/tencent/mm/plugin/recordvideo/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-recordvideo_release"})
public final class a
  extends h<a>
{
  public static final a xNF;
  
  static
  {
    AppMethodBeat.i(75393);
    xNF = new a();
    AppMethodBeat.o(75393);
  }
  
  public final void ats()
  {
    boolean bool2 = true;
    AppMethodBeat.i(75390);
    a locala = (a)atq();
    if (Z("StoryEditVideoBgmSwitch", 1) == 1)
    {
      bool1 = true;
      locala.xNR = bool1;
      int i = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 1);
      ((a)atq()).xNS = (i * 100);
      ((a)atq()).xNT = (i * 100);
      if ((!j.IS_FLAVOR_RED) && (!j.IS_FLAVOR_PURPLE) && (!j.DEBUG)) {
        break label294;
      }
      ((a)atq()).xNG = true;
      ((a)atq()).xNH = true;
      ((a)atq()).xNI = true;
      ((a)atq()).xNL = true;
      ((a)atq()).xNK = true;
      locala = (a)atq();
      bool1 = true;
      label155:
      locala.xNN = bool1;
      ((a)atq()).xNO = Z("StoryFeaturedExpiredTime", 15552000);
      ((a)atq()).xNP = ((b)g.ab(b.class)).a(b.a.qxL, 10);
      locala = (a)atq();
      if (((b)g.ab(b.class)).a(b.a.qxH, 1) != 1) {
        break label549;
      }
      bool1 = true;
      label239:
      locala.xNJ = bool1;
      locala = (a)atq();
      if (((b)g.ab(b.class)).a(b.a.qxO, 1) != 1) {
        break label554;
      }
    }
    label294:
    label554:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.xNM = bool1;
      AppMethodBeat.o(75390);
      return;
      bool1 = false;
      break;
      locala = (a)atq();
      if (((b)g.ab(b.class)).a(b.a.qxE, 0) == 1)
      {
        bool1 = true;
        label326:
        locala.xNG = bool1;
        locala = (a)atq();
        if (((b)g.ab(b.class)).a(b.a.qxF, 0) != 1) {
          break label524;
        }
        bool1 = true;
        label364:
        locala.xNH = bool1;
        locala = (a)atq();
        if (((b)g.ab(b.class)).a(b.a.qxG, 0) != 1) {
          break label529;
        }
        bool1 = true;
        locala.xNI = bool1;
        locala = (a)atq();
        if (((b)g.ab(b.class)).a(b.a.qxJ, 1) != 1) {
          break label534;
        }
        bool1 = true;
        label440:
        locala.xNL = bool1;
        locala = (a)atq();
        if (((b)g.ab(b.class)).a(b.a.qxI, 1) != 1) {
          break label539;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        locala.xNK = bool1;
        locala = (a)atq();
        if (((b)g.ab(b.class)).a(b.a.qxN, 0) != 1) {
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
  
  public final boolean dIQ()
  {
    AppMethodBeat.i(75391);
    boolean bool = ((a)att()).xNH;
    AppMethodBeat.o(75391);
    return bool;
  }
  
  public final boolean dIR()
  {
    AppMethodBeat.i(206552);
    boolean bool = ((a)att()).xNM;
    AppMethodBeat.o(206552);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
  public static final class a
  {
    boolean xNG;
    boolean xNH;
    boolean xNI;
    public boolean xNJ;
    boolean xNK;
    public boolean xNL;
    boolean xNM = true;
    boolean xNN;
    int xNO = 15552000;
    public int xNP = 10;
    private int xNQ = 2;
    boolean xNR = true;
    int xNS = 0;
    int xNT = 0;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.xNQ != paramObject.xNQ) || (this.xNR != paramObject.xNR) || (this.xNS != paramObject.xNS) || (this.xNT != paramObject.xNT)) {}
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
      String str = "StoryBasicConfig(repeatMD5=" + this.xNQ + ", showMusicIcon=" + this.xNR + ", albumThumbHeight=" + this.xNS + ", albumThumbWidth=" + this.xNT + ")";
      AppMethodBeat.o(75388);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.a.a
 * JD-Core Version:    0.7.0.1
 */