package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.regex.Pattern;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "()V", "canShowConfig", "", "type", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "enableBlurMouth", "enableFavorite", "enableFavoriteByStatus", "enableImage2Video", "enableLyrics", "enableMusic", "enableReply", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getEasterEggRegex", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "getFavExpiredTime", "", "initDefaultConfig", "loadConfig", "", "loadConfigByStatus", "StoryBasicConfig", "plugin-story_release"})
public final class a
  extends com.tencent.mm.plugin.story.c.b<a>
  implements f
{
  public static final a LEY;
  
  static
  {
    AppMethodBeat.i(118580);
    LEY = new a();
    AppMethodBeat.o(118580);
  }
  
  public final boolean a(f.a parama)
  {
    try
    {
      AppMethodBeat.i(118577);
      boolean bool = j.a((Iterable)((a)aUb()).LEZ, parama);
      AppMethodBeat.o(118577);
      return bool;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void aTZ()
  {
    AppMethodBeat.i(118576);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118576);
      return;
    }
    aUa();
    AppMethodBeat.o(118576);
  }
  
  public final void aUa()
  {
    boolean bool2 = true;
    AppMethodBeat.i(213156);
    ((a)aTX()).LEZ.clear();
    int i;
    a locala;
    if (at("SnsTimelineLikeCommentStoryBubbleSwitch", 1) == 1)
    {
      i = 1;
      if (i != 0) {
        ((a)aTX()).LEZ.add(f.a.LEx);
      }
      at("SnsTimelineJumpStorySwitch", 0);
      com.tencent.mm.pluginsdk.ui.span.k.a.RrZ = Pattern.compile(((a)aTX()).regex);
      locala = (a)aTX();
      if (at("StoryEditVideoBgmSwitch", 1) != 1) {
        break label365;
      }
      bool1 = true;
      label100:
      locala.HKF = bool1;
      i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 1);
      ((a)aTX()).HKG = (i * 100);
      ((a)aTX()).HKH = (i * 100);
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
        break label370;
      }
      ((a)aTX()).HKv = true;
      ((a)aTX()).HKw = true;
      ((a)aTX()).HKx = true;
      ((a)aTX()).HKA = true;
      ((a)aTX()).HKz = true;
      locala = (a)aTX();
      bool1 = true;
      label226:
      locala.HKB = bool1;
      ((a)aTX()).HKC = at("StoryFeaturedExpiredTime", 15552000);
      ((a)aTX()).HKD = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvO, 10);
      locala = (a)aTX();
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvK, 1) != 1) {
        break label625;
      }
      bool1 = true;
      label310:
      locala.HKy = bool1;
      locala = (a)aTX();
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvR, 1) != 1) {
        break label630;
      }
    }
    label365:
    label370:
    label630:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.ynt = bool1;
      AppMethodBeat.o(213156);
      return;
      i = 0;
      break;
      bool1 = false;
      break label100;
      locala = (a)aTX();
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvH, 0) == 1)
      {
        bool1 = true;
        locala.HKv = bool1;
        locala = (a)aTX();
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvI, 0) != 1) {
          break label600;
        }
        bool1 = true;
        locala.HKw = bool1;
        locala = (a)aTX();
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvJ, 0) != 1) {
          break label605;
        }
        bool1 = true;
        locala.HKx = bool1;
        locala = (a)aTX();
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvM, 1) != 1) {
          break label610;
        }
        bool1 = true;
        locala.HKA = bool1;
        locala = (a)aTX();
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvL, 1) != 1) {
          break label615;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        locala.HKz = bool1;
        locala = (a)aTX();
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvQ, 0) != 1) {
          break label620;
        }
        bool1 = true;
        break;
        bool1 = false;
        break label402;
        bool1 = false;
        break label440;
        bool1 = false;
        break label478;
        bool1 = false;
        break label516;
      }
      bool1 = false;
      break label226;
      bool1 = false;
      break label310;
    }
  }
  
  public final boolean gbN()
  {
    AppMethodBeat.i(213159);
    boolean bool = ((a)aUc()).HKv;
    AppMethodBeat.o(213159);
    return bool;
  }
  
  public final boolean gbO()
  {
    AppMethodBeat.i(118579);
    boolean bool = ((a)aUb()).HKx;
    AppMethodBeat.o(118579);
    return bool;
  }
  
  public final boolean gbw()
  {
    AppMethodBeat.i(118578);
    boolean bool = ((a)aUb()).HKv;
    AppMethodBeat.o(118578);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "regex", "", "getRegex", "()Ljava/lang/String;", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "showSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "getShowSet", "()Ljava/util/HashSet;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-story_release"})
  public static final class a
  {
    boolean HKA;
    public boolean HKB;
    int HKC;
    int HKD;
    private int HKE;
    boolean HKF;
    public int HKG;
    public int HKH;
    boolean HKv;
    public boolean HKw;
    boolean HKx;
    boolean HKy;
    boolean HKz;
    final HashSet<f.a> LEZ;
    final String regex;
    boolean ynt;
    
    private a()
    {
      AppMethodBeat.i(118573);
      this.HKE = 2;
      this.HKF = true;
      this.HKG = 0;
      this.HKH = 0;
      this.LEZ = new HashSet();
      this.regex = "#冒泡#";
      this.ynt = true;
      this.HKC = 15552000;
      this.HKD = 10;
      AppMethodBeat.o(118573);
    }
    
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
      AppMethodBeat.i(118574);
      String str = "StoryBasicConfig(repeatMD5=" + this.HKE + ", showMusicIcon=" + this.HKF + ", albumThumbHeight=" + this.HKG + ", albumThumbWidth=" + this.HKH + ")";
      AppMethodBeat.o(118574);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.a
 * JD-Core Version:    0.7.0.1
 */