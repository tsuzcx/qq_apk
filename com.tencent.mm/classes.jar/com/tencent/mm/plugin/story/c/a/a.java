package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
import d.a.j;
import d.l;
import java.util.HashSet;
import java.util.regex.Pattern;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "()V", "canShowConfig", "", "type", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "enableBlurMouth", "enableFavorite", "enableImage2Video", "enableLyrics", "enableMusic", "enableReply", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getEasterEggRegex", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "getFavExpiredTime", "", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-story_release"})
public final class a
  extends com.tencent.mm.plugin.story.c.b<a>
  implements f
{
  public static final a zqB;
  
  static
  {
    AppMethodBeat.i(118580);
    zqB = new a();
    AppMethodBeat.o(118580);
  }
  
  public final boolean a(f.a parama)
  {
    try
    {
      AppMethodBeat.i(118577);
      boolean bool = j.a((Iterable)((a)aqp()).zqC, parama);
      AppMethodBeat.o(118577);
      return bool;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void aqo()
  {
    boolean bool2 = true;
    AppMethodBeat.i(118576);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118576);
      return;
    }
    ((a)aqm()).zqC.clear();
    int i;
    a locala;
    if (U("SnsTimelineLikeCommentStoryBubbleSwitch", 1) == 1)
    {
      i = 1;
      if (i != 0) {
        ((a)aqm()).zqC.add(f.a.zqa);
      }
      U("SnsTimelineJumpStorySwitch", 0);
      com.tencent.mm.pluginsdk.ui.span.j.a.DCl = Pattern.compile(((a)aqm()).regex);
      locala = (a)aqm();
      if (U("StoryEditVideoBgmSwitch", 1) != 1) {
        break label377;
      }
      bool1 = true;
      label112:
      locala.wqe = bool1;
      i = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 1);
      ((a)aqm()).wqf = (i * 100);
      ((a)aqm()).wqg = (i * 100);
      if ((!h.IS_FLAVOR_RED) && (!h.IS_FLAVOR_PURPLE) && (!h.DEBUG)) {
        break label382;
      }
      ((a)aqm()).wpT = true;
      ((a)aqm()).wpU = true;
      ((a)aqm()).wpV = true;
      ((a)aqm()).wpY = true;
      ((a)aqm()).wpX = true;
      locala = (a)aqm();
      bool1 = true;
      label238:
      locala.wqa = bool1;
      ((a)aqm()).wqb = U("StoryFeaturedExpiredTime", 15552000);
      ((a)aqm()).wqc = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pNb, 10);
      locala = (a)aqm();
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMX, 1) != 1) {
        break label637;
      }
      bool1 = true;
      label322:
      locala.wpW = bool1;
      locala = (a)aqm();
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pNe, 1) != 1) {
        break label642;
      }
    }
    label642:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.wpZ = bool1;
      AppMethodBeat.o(118576);
      return;
      i = 0;
      break;
      label377:
      bool1 = false;
      break label112;
      label382:
      locala = (a)aqm();
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMU, 0) == 1)
      {
        bool1 = true;
        label414:
        locala.wpT = bool1;
        locala = (a)aqm();
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMV, 0) != 1) {
          break label612;
        }
        bool1 = true;
        label452:
        locala.wpU = bool1;
        locala = (a)aqm();
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMW, 0) != 1) {
          break label617;
        }
        bool1 = true;
        label490:
        locala.wpV = bool1;
        locala = (a)aqm();
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMZ, 1) != 1) {
          break label622;
        }
        bool1 = true;
        label528:
        locala.wpY = bool1;
        locala = (a)aqm();
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMY, 1) != 1) {
          break label627;
        }
      }
      label612:
      label617:
      label622:
      label627:
      for (bool1 = true;; bool1 = false)
      {
        locala.wpX = bool1;
        locala = (a)aqm();
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pNd, 0) != 1) {
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
  
  public final boolean dUG()
  {
    AppMethodBeat.i(118578);
    boolean bool = ((a)aqp()).wpT;
    AppMethodBeat.o(118578);
    return bool;
  }
  
  public final boolean dUW()
  {
    AppMethodBeat.i(118579);
    boolean bool = ((a)aqp()).wpV;
    AppMethodBeat.o(118579);
    return bool;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "regex", "", "getRegex", "()Ljava/lang/String;", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "showSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "getShowSet", "()Ljava/util/HashSet;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-story_release"})
  public static final class a
  {
    final String regex;
    boolean wpT;
    public boolean wpU;
    boolean wpV;
    boolean wpW;
    boolean wpX;
    boolean wpY;
    boolean wpZ;
    public boolean wqa;
    int wqb;
    int wqc;
    private int wqd;
    boolean wqe;
    public int wqf;
    public int wqg;
    final HashSet<f.a> zqC;
    
    private a()
    {
      AppMethodBeat.i(118573);
      this.wqd = 2;
      this.wqe = true;
      this.wqf = 0;
      this.wqg = 0;
      this.zqC = new HashSet();
      this.regex = "#冒泡#";
      this.wpZ = true;
      this.wqb = 15552000;
      this.wqc = 10;
      AppMethodBeat.o(118573);
    }
    
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
      AppMethodBeat.i(118574);
      String str = "StoryBasicConfig(repeatMD5=" + this.wqd + ", showMusicIcon=" + this.wqe + ", albumThumbHeight=" + this.wqf + ", albumThumbWidth=" + this.wqg + ")";
      AppMethodBeat.o(118574);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.a
 * JD-Core Version:    0.7.0.1
 */