package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.sdk.platformtools.ak;
import d.l;
import java.util.HashSet;
import java.util.regex.Pattern;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "()V", "canShowConfig", "", "type", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "enableBlurMouth", "enableFavorite", "enableImage2Video", "enableLyrics", "enableMusic", "enableReply", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getEasterEggRegex", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "getFavExpiredTime", "", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-story_release"})
public final class a
  extends com.tencent.mm.plugin.story.c.b<a>
  implements f
{
  public static final a AZY;
  
  static
  {
    AppMethodBeat.i(118580);
    AZY = new a();
    AppMethodBeat.o(118580);
  }
  
  public final boolean a(f.a parama)
  {
    try
    {
      AppMethodBeat.i(118577);
      boolean bool = d.a.j.a((Iterable)((a)att()).AZZ, parama);
      AppMethodBeat.o(118577);
      return bool;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void ats()
  {
    boolean bool2 = true;
    AppMethodBeat.i(118576);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118576);
      return;
    }
    ((a)atq()).AZZ.clear();
    int i;
    a locala;
    if (Z("SnsTimelineLikeCommentStoryBubbleSwitch", 1) == 1)
    {
      i = 1;
      if (i != 0) {
        ((a)atq()).AZZ.add(f.a.AZx);
      }
      Z("SnsTimelineJumpStorySwitch", 0);
      com.tencent.mm.pluginsdk.ui.span.j.a.FzQ = Pattern.compile(((a)atq()).regex);
      locala = (a)atq();
      if (Z("StoryEditVideoBgmSwitch", 1) != 1) {
        break label377;
      }
      bool1 = true;
      label112:
      locala.xNR = bool1;
      i = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 1);
      ((a)atq()).xNS = (i * 100);
      ((a)atq()).xNT = (i * 100);
      if ((!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.j.DEBUG)) {
        break label382;
      }
      ((a)atq()).xNG = true;
      ((a)atq()).xNH = true;
      ((a)atq()).xNI = true;
      ((a)atq()).xNL = true;
      ((a)atq()).xNK = true;
      locala = (a)atq();
      bool1 = true;
      label238:
      locala.xNN = bool1;
      ((a)atq()).xNO = Z("StoryFeaturedExpiredTime", 15552000);
      ((a)atq()).xNP = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxL, 10);
      locala = (a)atq();
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxH, 1) != 1) {
        break label637;
      }
      bool1 = true;
      label322:
      locala.xNJ = bool1;
      locala = (a)atq();
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxO, 1) != 1) {
        break label642;
      }
    }
    label642:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.xNM = bool1;
      AppMethodBeat.o(118576);
      return;
      i = 0;
      break;
      label377:
      bool1 = false;
      break label112;
      label382:
      locala = (a)atq();
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxE, 0) == 1)
      {
        bool1 = true;
        label414:
        locala.xNG = bool1;
        locala = (a)atq();
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxF, 0) != 1) {
          break label612;
        }
        bool1 = true;
        label452:
        locala.xNH = bool1;
        locala = (a)atq();
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxG, 0) != 1) {
          break label617;
        }
        bool1 = true;
        label490:
        locala.xNI = bool1;
        locala = (a)atq();
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxJ, 1) != 1) {
          break label622;
        }
        bool1 = true;
        label528:
        locala.xNL = bool1;
        locala = (a)atq();
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxI, 1) != 1) {
          break label627;
        }
      }
      label612:
      label617:
      label622:
      label627:
      for (bool1 = true;; bool1 = false)
      {
        locala.xNK = bool1;
        locala = (a)atq();
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxN, 0) != 1) {
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
  
  public final boolean ekC()
  {
    AppMethodBeat.i(118578);
    boolean bool = ((a)att()).xNG;
    AppMethodBeat.o(118578);
    return bool;
  }
  
  public final boolean ekT()
  {
    AppMethodBeat.i(118579);
    boolean bool = ((a)att()).xNI;
    AppMethodBeat.o(118579);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "regex", "", "getRegex", "()Ljava/lang/String;", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "showSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "getShowSet", "()Ljava/util/HashSet;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-story_release"})
  public static final class a
  {
    final HashSet<f.a> AZZ;
    final String regex;
    boolean xNG;
    public boolean xNH;
    boolean xNI;
    boolean xNJ;
    boolean xNK;
    boolean xNL;
    boolean xNM;
    public boolean xNN;
    int xNO;
    int xNP;
    private int xNQ;
    boolean xNR;
    public int xNS;
    public int xNT;
    
    private a()
    {
      AppMethodBeat.i(118573);
      this.xNQ = 2;
      this.xNR = true;
      this.xNS = 0;
      this.xNT = 0;
      this.AZZ = new HashSet();
      this.regex = "#冒泡#";
      this.xNM = true;
      this.xNO = 15552000;
      this.xNP = 10;
      AppMethodBeat.o(118573);
    }
    
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
      AppMethodBeat.i(118574);
      String str = "StoryBasicConfig(repeatMD5=" + this.xNQ + ", showMusicIcon=" + this.xNR + ", albumThumbHeight=" + this.xNS + ", albumThumbWidth=" + this.xNT + ")";
      AppMethodBeat.o(118574);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.a
 * JD-Core Version:    0.7.0.1
 */