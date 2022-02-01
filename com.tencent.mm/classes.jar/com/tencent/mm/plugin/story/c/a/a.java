package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "()V", "canShowConfig", "", "type", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "enableBlurMouth", "enableFavorite", "enableFavoriteByStatus", "enableImage2Video", "enableLyrics", "enableMusic", "enableReply", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getEasterEggRegex", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "getFavExpiredTime", "", "initDefaultConfig", "loadConfig", "", "loadConfigByStatus", "StoryBasicConfig", "plugin-story_release"})
public final class a
  extends com.tencent.mm.plugin.story.c.b<a>
  implements f
{
  public static final a FkW;
  
  static
  {
    AppMethodBeat.i(118580);
    FkW = new a();
    AppMethodBeat.o(118580);
  }
  
  public final boolean a(f.a parama)
  {
    try
    {
      AppMethodBeat.i(118577);
      boolean bool = j.a((Iterable)((a)aLT()).FkX, parama);
      AppMethodBeat.o(118577);
      return bool;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void aLS()
  {
    AppMethodBeat.i(118576);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118576);
      return;
    }
    ajX();
    AppMethodBeat.o(118576);
  }
  
  public final void ajX()
  {
    boolean bool2 = true;
    AppMethodBeat.i(258524);
    ((a)aLQ()).FkX.clear();
    int i;
    a locala;
    if (ab("SnsTimelineLikeCommentStoryBubbleSwitch", 1) == 1)
    {
      i = 1;
      if (i != 0) {
        ((a)aLQ()).FkX.add(f.a.Fkv);
      }
      ab("SnsTimelineJumpStorySwitch", 0);
      com.tencent.mm.pluginsdk.ui.span.k.a.KqS = Pattern.compile(((a)aLQ()).regex);
      locala = (a)aLQ();
      if (ab("StoryEditVideoBgmSwitch", 1) != 1) {
        break label365;
      }
      bool1 = true;
      label100:
      locala.BNX = bool1;
      i = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
      ((a)aLQ()).BNY = (i * 100);
      ((a)aLQ()).BNZ = (i * 100);
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
        break label370;
      }
      ((a)aLQ()).BNM = true;
      ((a)aLQ()).BNN = true;
      ((a)aLQ()).BNO = true;
      ((a)aLQ()).BNR = true;
      ((a)aLQ()).BNQ = true;
      locala = (a)aLQ();
      bool1 = true;
      label226:
      locala.BNT = bool1;
      ((a)aLQ()).BNU = ab("StoryFeaturedExpiredTime", 15552000);
      ((a)aLQ()).BNV = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPD, 10);
      locala = (a)aLQ();
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPz, 1) != 1) {
        break label625;
      }
      bool1 = true;
      label310:
      locala.BNP = bool1;
      locala = (a)aLQ();
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPG, 1) != 1) {
        break label630;
      }
    }
    label365:
    label370:
    label630:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.BNS = bool1;
      AppMethodBeat.o(258524);
      return;
      i = 0;
      break;
      bool1 = false;
      break label100;
      locala = (a)aLQ();
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPw, 0) == 1)
      {
        bool1 = true;
        locala.BNM = bool1;
        locala = (a)aLQ();
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPx, 0) != 1) {
          break label600;
        }
        bool1 = true;
        locala.BNN = bool1;
        locala = (a)aLQ();
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPy, 0) != 1) {
          break label605;
        }
        bool1 = true;
        locala.BNO = bool1;
        locala = (a)aLQ();
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPB, 1) != 1) {
          break label610;
        }
        bool1 = true;
        locala.BNR = bool1;
        locala = (a)aLQ();
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPA, 1) != 1) {
          break label615;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        locala.BNQ = bool1;
        locala = (a)aLQ();
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPF, 0) != 1) {
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
  
  public final boolean fnd()
  {
    AppMethodBeat.i(118578);
    boolean bool = ((a)aLT()).BNM;
    AppMethodBeat.o(118578);
    return bool;
  }
  
  public final boolean fnu()
  {
    AppMethodBeat.i(118579);
    boolean bool = ((a)aLT()).BNO;
    AppMethodBeat.o(118579);
    return bool;
  }
  
  public final boolean gIi()
  {
    AppMethodBeat.i(258525);
    boolean bool = ((a)ajY()).BNM;
    AppMethodBeat.o(258525);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "regex", "", "getRegex", "()Ljava/lang/String;", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "showSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "getShowSet", "()Ljava/util/HashSet;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-story_release"})
  public static final class a
  {
    boolean BNM;
    public boolean BNN;
    boolean BNO;
    boolean BNP;
    boolean BNQ;
    boolean BNR;
    boolean BNS;
    public boolean BNT;
    int BNU;
    int BNV;
    private int BNW;
    boolean BNX;
    public int BNY;
    public int BNZ;
    final HashSet<f.a> FkX;
    final String regex;
    
    private a()
    {
      AppMethodBeat.i(118573);
      this.BNW = 2;
      this.BNX = true;
      this.BNY = 0;
      this.BNZ = 0;
      this.FkX = new HashSet();
      this.regex = "#冒泡#";
      this.BNS = true;
      this.BNU = 15552000;
      this.BNV = 10;
      AppMethodBeat.o(118573);
    }
    
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
      AppMethodBeat.i(118574);
      String str = "StoryBasicConfig(repeatMD5=" + this.BNW + ", showMusicIcon=" + this.BNX + ", albumThumbHeight=" + this.BNY + ", albumThumbWidth=" + this.BNZ + ")";
      AppMethodBeat.o(118574);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.a
 * JD-Core Version:    0.7.0.1
 */