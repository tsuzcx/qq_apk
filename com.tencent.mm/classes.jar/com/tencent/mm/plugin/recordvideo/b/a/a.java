package com.tencent.mm.plugin.recordvideo.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/IRecordBasicConfig;", "()V", "enableFavorite", "", "enableImage2Video", "enableLyrics", "enableMusic", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getElementName", "Lcom/tencent/mm/plugin/recordvideo/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-recordvideo_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.b.h<a>
{
  public static final a vhg;
  
  static
  {
    AppMethodBeat.i(75393);
    vhg = new a();
    AppMethodBeat.o(75393);
  }
  
  public final void ajo()
  {
    boolean bool2 = true;
    AppMethodBeat.i(75390);
    a locala = (a)ajm();
    if (P("StoryEditVideoBgmSwitch", 1) == 1)
    {
      bool1 = true;
      locala.vhs = bool1;
      int i = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 1);
      ((a)ajm()).vht = (i * 100);
      ((a)ajm()).vhu = (i * 100);
      if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.h.DEBUG)) {
        break label294;
      }
      ((a)ajm()).vhh = true;
      ((a)ajm()).vhi = true;
      ((a)ajm()).vhj = true;
      ((a)ajm()).vhm = true;
      ((a)ajm()).vhl = true;
      locala = (a)ajm();
      bool1 = true;
      label155:
      locala.vho = bool1;
      ((a)ajm()).vhp = P("StoryFeaturedExpiredTime", 15552000);
      ((a)ajm()).vhq = ((b)g.ab(b.class)).a(b.a.pjK, 10);
      locala = (a)ajm();
      if (((b)g.ab(b.class)).a(b.a.pjG, 1) != 1) {
        break label549;
      }
      bool1 = true;
      label239:
      locala.vhk = bool1;
      locala = (a)ajm();
      if (((b)g.ab(b.class)).a(b.a.pjN, 1) != 1) {
        break label554;
      }
    }
    label294:
    label554:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.vhn = bool1;
      AppMethodBeat.o(75390);
      return;
      bool1 = false;
      break;
      locala = (a)ajm();
      if (((b)g.ab(b.class)).a(b.a.pjD, 0) == 1)
      {
        bool1 = true;
        label326:
        locala.vhh = bool1;
        locala = (a)ajm();
        if (((b)g.ab(b.class)).a(b.a.pjE, 0) != 1) {
          break label524;
        }
        bool1 = true;
        label364:
        locala.vhi = bool1;
        locala = (a)ajm();
        if (((b)g.ab(b.class)).a(b.a.pjF, 0) != 1) {
          break label529;
        }
        bool1 = true;
        locala.vhj = bool1;
        locala = (a)ajm();
        if (((b)g.ab(b.class)).a(b.a.pjI, 1) != 1) {
          break label534;
        }
        bool1 = true;
        label440:
        locala.vhm = bool1;
        locala = (a)ajm();
        if (((b)g.ab(b.class)).a(b.a.pjH, 1) != 1) {
          break label539;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        locala.vhl = bool1;
        locala = (a)ajm();
        if (((b)g.ab(b.class)).a(b.a.pjM, 0) != 1) {
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
  
  public final boolean dhx()
  {
    AppMethodBeat.i(75391);
    boolean bool = ((a)ajp()).vhi;
    AppMethodBeat.o(75391);
    return bool;
  }
  
  public final boolean dhy()
  {
    AppMethodBeat.i(75392);
    boolean bool = ((a)ajp()).vhk;
    AppMethodBeat.o(75392);
    return bool;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
  public static final class a
  {
    boolean vhh;
    boolean vhi;
    boolean vhj;
    boolean vhk;
    boolean vhl;
    public boolean vhm;
    public boolean vhn = true;
    boolean vho;
    int vhp = 15552000;
    public int vhq = 10;
    private int vhr = 2;
    boolean vhs = true;
    int vht = 0;
    int vhu = 0;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.vhr != paramObject.vhr) || (this.vhs != paramObject.vhs) || (this.vht != paramObject.vht) || (this.vhu != paramObject.vhu)) {}
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
      String str = "StoryBasicConfig(repeatMD5=" + this.vhr + ", showMusicIcon=" + this.vhs + ", albumThumbHeight=" + this.vht + ", albumThumbWidth=" + this.vhu + ")";
      AppMethodBeat.o(75388);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.a.a
 * JD-Core Version:    0.7.0.1
 */