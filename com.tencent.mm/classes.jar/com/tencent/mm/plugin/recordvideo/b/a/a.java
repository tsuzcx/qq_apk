package com.tencent.mm.plugin.recordvideo.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.b.i;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/IRecordBasicConfig;", "()V", "enableFavorite", "", "enableImage2Video", "enableLyrics", "enableMusic", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getElementName", "Lcom/tencent/mm/plugin/recordvideo/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-recordvideo_release"})
public final class a
  extends i<a>
{
  public static final a HKu;
  
  static
  {
    AppMethodBeat.i(75393);
    HKu = new a();
    AppMethodBeat.o(75393);
  }
  
  public final void aTZ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(75390);
    a locala = (a)aTX();
    if (at("StoryEditVideoBgmSwitch", 1) == 1)
    {
      bool1 = true;
      locala.HKF = bool1;
      int i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 1);
      ((a)aTX()).HKG = (i * 100);
      ((a)aTX()).HKH = (i * 100);
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
        break label294;
      }
      ((a)aTX()).HKv = true;
      ((a)aTX()).HKw = true;
      ((a)aTX()).HKx = true;
      ((a)aTX()).HKA = true;
      ((a)aTX()).HKz = true;
      locala = (a)aTX();
      bool1 = true;
      label155:
      locala.HKB = bool1;
      ((a)aTX()).HKC = at("StoryFeaturedExpiredTime", 15552000);
      ((a)aTX()).HKD = ((b)h.ae(b.class)).a(b.a.vvO, 10);
      locala = (a)aTX();
      if (((b)h.ae(b.class)).a(b.a.vvK, 1) != 1) {
        break label549;
      }
      bool1 = true;
      label239:
      locala.HKy = bool1;
      locala = (a)aTX();
      if (((b)h.ae(b.class)).a(b.a.vvR, 1) != 1) {
        break label554;
      }
    }
    label294:
    label554:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.ynt = bool1;
      AppMethodBeat.o(75390);
      return;
      bool1 = false;
      break;
      locala = (a)aTX();
      if (((b)h.ae(b.class)).a(b.a.vvH, 0) == 1)
      {
        bool1 = true;
        label326:
        locala.HKv = bool1;
        locala = (a)aTX();
        if (((b)h.ae(b.class)).a(b.a.vvI, 0) != 1) {
          break label524;
        }
        bool1 = true;
        label364:
        locala.HKw = bool1;
        locala = (a)aTX();
        if (((b)h.ae(b.class)).a(b.a.vvJ, 0) != 1) {
          break label529;
        }
        bool1 = true;
        locala.HKx = bool1;
        locala = (a)aTX();
        if (((b)h.ae(b.class)).a(b.a.vvM, 1) != 1) {
          break label534;
        }
        bool1 = true;
        label440:
        locala.HKA = bool1;
        locala = (a)aTX();
        if (((b)h.ae(b.class)).a(b.a.vvL, 1) != 1) {
          break label539;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        locala.HKz = bool1;
        locala = (a)aTX();
        if (((b)h.ae(b.class)).a(b.a.vvQ, 0) != 1) {
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
  
  public final boolean fvN()
  {
    AppMethodBeat.i(75391);
    boolean bool = ((a)aUb()).HKw;
    AppMethodBeat.o(75391);
    return bool;
  }
  
  public final int fvO()
  {
    AppMethodBeat.i(219750);
    int i = ((a)aUb()).HKD;
    AppMethodBeat.o(219750);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
  public static final class a
  {
    public boolean HKA;
    boolean HKB;
    int HKC = 15552000;
    int HKD = 10;
    private int HKE = 2;
    boolean HKF = true;
    int HKG = 0;
    int HKH = 0;
    boolean HKv;
    boolean HKw;
    boolean HKx;
    public boolean HKy;
    boolean HKz;
    public boolean ynt = true;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.HKE != paramObject.HKE) || (this.HKF != paramObject.HKF) || (this.HKG != paramObject.HKG) || (this.HKH != paramObject.HKH)) {}
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
      String str = "StoryBasicConfig(repeatMD5=" + this.HKE + ", showMusicIcon=" + this.HKF + ", albumThumbHeight=" + this.HKG + ", albumThumbWidth=" + this.HKH + ")";
      AppMethodBeat.o(75388);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.a.a
 * JD-Core Version:    0.7.0.1
 */