package com.tencent.mm.plugin.recordvideo.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/IRecordBasicConfig;", "()V", "enableFavorite", "", "enableImage2Video", "enableLyrics", "enableMusic", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getElementName", "Lcom/tencent/mm/plugin/recordvideo/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-recordvideo_release"})
public final class a
  extends h<a>
{
  public static final a BNL;
  
  static
  {
    AppMethodBeat.i(75393);
    BNL = new a();
    AppMethodBeat.o(75393);
  }
  
  public final void aLS()
  {
    boolean bool2 = true;
    AppMethodBeat.i(75390);
    a locala = (a)aLQ();
    if (ab("StoryEditVideoBgmSwitch", 1) == 1)
    {
      bool1 = true;
      locala.BNX = bool1;
      int i = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
      ((a)aLQ()).BNY = (i * 100);
      ((a)aLQ()).BNZ = (i * 100);
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
        break label294;
      }
      ((a)aLQ()).BNM = true;
      ((a)aLQ()).BNN = true;
      ((a)aLQ()).BNO = true;
      ((a)aLQ()).BNR = true;
      ((a)aLQ()).BNQ = true;
      locala = (a)aLQ();
      bool1 = true;
      label155:
      locala.BNT = bool1;
      ((a)aLQ()).BNU = ab("StoryFeaturedExpiredTime", 15552000);
      ((a)aLQ()).BNV = ((b)g.af(b.class)).a(b.a.rPD, 10);
      locala = (a)aLQ();
      if (((b)g.af(b.class)).a(b.a.rPz, 1) != 1) {
        break label549;
      }
      bool1 = true;
      label239:
      locala.BNP = bool1;
      locala = (a)aLQ();
      if (((b)g.af(b.class)).a(b.a.rPG, 1) != 1) {
        break label554;
      }
    }
    label294:
    label554:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.BNS = bool1;
      AppMethodBeat.o(75390);
      return;
      bool1 = false;
      break;
      locala = (a)aLQ();
      if (((b)g.af(b.class)).a(b.a.rPw, 0) == 1)
      {
        bool1 = true;
        label326:
        locala.BNM = bool1;
        locala = (a)aLQ();
        if (((b)g.af(b.class)).a(b.a.rPx, 0) != 1) {
          break label524;
        }
        bool1 = true;
        label364:
        locala.BNN = bool1;
        locala = (a)aLQ();
        if (((b)g.af(b.class)).a(b.a.rPy, 0) != 1) {
          break label529;
        }
        bool1 = true;
        locala.BNO = bool1;
        locala = (a)aLQ();
        if (((b)g.af(b.class)).a(b.a.rPB, 1) != 1) {
          break label534;
        }
        bool1 = true;
        label440:
        locala.BNR = bool1;
        locala = (a)aLQ();
        if (((b)g.af(b.class)).a(b.a.rPA, 1) != 1) {
          break label539;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        locala.BNQ = bool1;
        locala = (a)aLQ();
        if (((b)g.af(b.class)).a(b.a.rPF, 0) != 1) {
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
  
  public final boolean eJD()
  {
    AppMethodBeat.i(75391);
    boolean bool = ((a)aLT()).BNN;
    AppMethodBeat.o(75391);
    return bool;
  }
  
  public final int eJE()
  {
    AppMethodBeat.i(237257);
    int i = ((a)aLT()).BNV;
    AppMethodBeat.o(237257);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
  public static final class a
  {
    boolean BNM;
    boolean BNN;
    boolean BNO;
    public boolean BNP;
    boolean BNQ;
    public boolean BNR;
    public boolean BNS = true;
    boolean BNT;
    int BNU = 15552000;
    int BNV = 10;
    private int BNW = 2;
    boolean BNX = true;
    int BNY = 0;
    int BNZ = 0;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.BNW != paramObject.BNW) || (this.BNX != paramObject.BNX) || (this.BNY != paramObject.BNY) || (this.BNZ != paramObject.BNZ)) {}
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
      String str = "StoryBasicConfig(repeatMD5=" + this.BNW + ", showMusicIcon=" + this.BNX + ", albumThumbHeight=" + this.BNY + ", albumThumbWidth=" + this.BNZ + ")";
      AppMethodBeat.o(75388);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.a.a
 * JD-Core Version:    0.7.0.1
 */