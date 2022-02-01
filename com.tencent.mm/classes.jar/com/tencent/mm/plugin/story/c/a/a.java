package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import d.a.j;
import d.l;
import java.util.HashSet;
import java.util.regex.Pattern;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "()V", "canShowConfig", "", "type", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "enableBlurMouth", "enableFavorite", "enableImage2Video", "enableLyrics", "enableMusic", "enableReply", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getEasterEggRegex", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "getFavExpiredTime", "", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-story_release"})
public final class a
  extends com.tencent.mm.plugin.story.c.b<a>
  implements f
{
  public static final a AIv;
  
  static
  {
    AppMethodBeat.i(118580);
    AIv = new a();
    AppMethodBeat.o(118580);
  }
  
  public final boolean a(f.a parama)
  {
    try
    {
      AppMethodBeat.i(118577);
      boolean bool = j.a((Iterable)((a)ate()).AIw, parama);
      AppMethodBeat.o(118577);
      return bool;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void atd()
  {
    boolean bool2 = true;
    AppMethodBeat.i(118576);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118576);
      return;
    }
    ((a)atb()).AIw.clear();
    int i;
    a locala;
    if (Y("SnsTimelineLikeCommentStoryBubbleSwitch", 1) == 1)
    {
      i = 1;
      if (i != 0) {
        ((a)atb()).AIw.add(f.a.AHU);
      }
      Y("SnsTimelineJumpStorySwitch", 0);
      com.tencent.mm.pluginsdk.ui.span.j.a.Fhs = Pattern.compile(((a)atb()).regex);
      locala = (a)atb();
      if (Y("StoryEditVideoBgmSwitch", 1) != 1) {
        break label377;
      }
      bool1 = true;
      label112:
      locala.xxU = bool1;
      i = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 1);
      ((a)atb()).xxV = (i * 100);
      ((a)atb()).xxW = (i * 100);
      if ((!i.IS_FLAVOR_RED) && (!i.IS_FLAVOR_PURPLE) && (!i.DEBUG)) {
        break label382;
      }
      ((a)atb()).xxJ = true;
      ((a)atb()).xxK = true;
      ((a)atb()).xxL = true;
      ((a)atb()).xxO = true;
      ((a)atb()).xxN = true;
      locala = (a)atb();
      bool1 = true;
      label238:
      locala.xxQ = bool1;
      ((a)atb()).xxR = Y("StoryFeaturedExpiredTime", 15552000);
      ((a)atb()).xxS = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqY, 10);
      locala = (a)atb();
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqU, 1) != 1) {
        break label637;
      }
      bool1 = true;
      label322:
      locala.xxM = bool1;
      locala = (a)atb();
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qrb, 1) != 1) {
        break label642;
      }
    }
    label642:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.xxP = bool1;
      AppMethodBeat.o(118576);
      return;
      i = 0;
      break;
      label377:
      bool1 = false;
      break label112;
      label382:
      locala = (a)atb();
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqR, 0) == 1)
      {
        bool1 = true;
        label414:
        locala.xxJ = bool1;
        locala = (a)atb();
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqS, 0) != 1) {
          break label612;
        }
        bool1 = true;
        label452:
        locala.xxK = bool1;
        locala = (a)atb();
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqT, 0) != 1) {
          break label617;
        }
        bool1 = true;
        label490:
        locala.xxL = bool1;
        locala = (a)atb();
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqW, 1) != 1) {
          break label622;
        }
        bool1 = true;
        label528:
        locala.xxO = bool1;
        locala = (a)atb();
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqV, 1) != 1) {
          break label627;
        }
      }
      label612:
      label617:
      label622:
      label627:
      for (bool1 = true;; bool1 = false)
      {
        locala.xxN = bool1;
        locala = (a)atb();
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qra, 0) != 1) {
          break label632;
        }
        bool1 = true;
        break;
        bool1 = false;
        break label414;
        bool1 = false;
        break label452;
        bool1 = false;
        break label490;
        bool1 = false;
        break label528;
      }
      label632:
      bool1 = false;
      break label238;
      label637:
      bool1 = false;
      break label322;
    }
  }
  
  public final boolean egU()
  {
    AppMethodBeat.i(118578);
    boolean bool = ((a)ate()).xxJ;
    AppMethodBeat.o(118578);
    return bool;
  }
  
  public final boolean ehl()
  {
    AppMethodBeat.i(118579);
    boolean bool = ((a)ate()).xxL;
    AppMethodBeat.o(118579);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "regex", "", "getRegex", "()Ljava/lang/String;", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "showSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "getShowSet", "()Ljava/util/HashSet;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-story_release"})
  public static final class a
  {
    final HashSet<f.a> AIw;
    final String regex;
    boolean xxJ;
    public boolean xxK;
    boolean xxL;
    boolean xxM;
    boolean xxN;
    boolean xxO;
    boolean xxP;
    public boolean xxQ;
    int xxR;
    int xxS;
    private int xxT;
    boolean xxU;
    public int xxV;
    public int xxW;
    
    private a()
    {
      AppMethodBeat.i(118573);
      this.xxT = 2;
      this.xxU = true;
      this.xxV = 0;
      this.xxW = 0;
      this.AIw = new HashSet();
      this.regex = "#冒泡#";
      this.xxP = true;
      this.xxR = 15552000;
      this.xxS = 10;
      AppMethodBeat.o(118573);
    }
    
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
      AppMethodBeat.i(118574);
      String str = "StoryBasicConfig(repeatMD5=" + this.xxT + ", showMusicIcon=" + this.xxU + ", albumThumbHeight=" + this.xxV + ", albumThumbWidth=" + this.xxW + ")";
      AppMethodBeat.o(118574);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.a
 * JD-Core Version:    0.7.0.1
 */