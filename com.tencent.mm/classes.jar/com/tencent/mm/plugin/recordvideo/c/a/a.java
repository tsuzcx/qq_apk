package com.tencent.mm.plugin.recordvideo.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.c.i;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/IRecordBasicConfig;", "()V", "enableFavorite", "", "enableImage2Video", "enableLyrics", "enableMusic", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getElementName", "Lcom/tencent/mm/plugin/recordvideo/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends i<a>
{
  public static final a NHs;
  
  static
  {
    AppMethodBeat.i(75393);
    NHs = new a();
    AppMethodBeat.o(75393);
  }
  
  public final void boD()
  {
    boolean bool2 = true;
    AppMethodBeat.i(75390);
    a locala = (a)boB();
    if (aC("StoryEditVideoBgmSwitch", 1) == 1)
    {
      bool1 = true;
      locala.NHu = bool1;
      int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 1);
      ((a)boB()).NHv = (i * 100);
      ((a)boB()).NHw = (i * 100);
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
        break label294;
      }
      ((a)boB()).NHx = true;
      ((a)boB()).NHy = true;
      ((a)boB()).NHz = true;
      ((a)boB()).NHC = true;
      ((a)boB()).NHB = true;
      locala = (a)boB();
      bool1 = true;
      label155:
      locala.NHD = bool1;
      ((a)boB()).NHE = aC("StoryFeaturedExpiredTime", 15552000);
      ((a)boB()).NHF = ((c)h.ax(c.class)).a(c.a.yIP, 10);
      locala = (a)boB();
      if (((c)h.ax(c.class)).a(c.a.yIL, 1) != 1) {
        break label485;
      }
      bool1 = true;
      label239:
      locala.NHA = bool1;
      locala = (a)boB();
      if (((c)h.ax(c.class)).a(c.a.yIS, 1) != 1) {
        break label490;
      }
    }
    label294:
    label326:
    label470:
    label475:
    label480:
    label485:
    label490:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.CWm = bool1;
      AppMethodBeat.o(75390);
      return;
      bool1 = false;
      break;
      locala = (a)boB();
      if (((c)h.ax(c.class)).a(c.a.yIK, 0) == 1)
      {
        bool1 = true;
        locala.NHx = bool1;
        ((a)boB()).NHy = true;
        ((a)boB()).NHz = true;
        locala = (a)boB();
        if (((c)h.ax(c.class)).a(c.a.yIN, 1) != 1) {
          break label470;
        }
        bool1 = true;
        locala.NHC = bool1;
        locala = (a)boB();
        if (((c)h.ax(c.class)).a(c.a.yIM, 1) != 1) {
          break label475;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        locala.NHB = bool1;
        locala = (a)boB();
        if (((c)h.ax(c.class)).a(c.a.yIR, 0) != 1) {
          break label480;
        }
        bool1 = true;
        break;
        bool1 = false;
        break label326;
        bool1 = false;
        break label386;
      }
      bool1 = false;
      break label155;
      bool1 = false;
      break label239;
    }
  }
  
  public final boolean gHB()
  {
    AppMethodBeat.i(75391);
    boolean bool = ((a)boF()).NHy;
    AppMethodBeat.o(75391);
    return bool;
  }
  
  public final boolean gHC()
  {
    AppMethodBeat.i(75392);
    boolean bool = ((a)boF()).NHA;
    AppMethodBeat.o(75392);
    return bool;
  }
  
  public final int gHD()
  {
    AppMethodBeat.i(279706);
    int i = ((a)boF()).NHF;
    AppMethodBeat.o(279706);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public boolean CWm = true;
    boolean NHA;
    boolean NHB;
    public boolean NHC;
    boolean NHD;
    int NHE = 15552000;
    int NHF = 10;
    private int NHt = 2;
    boolean NHu = true;
    int NHv = 0;
    int NHw = 0;
    boolean NHx;
    boolean NHy;
    boolean NHz;
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.NHt != paramObject.NHt) {
          return false;
        }
        if (this.NHu != paramObject.NHu) {
          return false;
        }
        if (this.NHv != paramObject.NHv) {
          return false;
        }
      } while (this.NHw == paramObject.NHw);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(75388);
      String str = "StoryBasicConfig(repeatMD5=" + this.NHt + ", showMusicIcon=" + this.NHu + ", albumThumbHeight=" + this.NHv + ", albumThumbWidth=" + this.NHw + ')';
      AppMethodBeat.o(75388);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.a.a
 * JD-Core Version:    0.7.0.1
 */