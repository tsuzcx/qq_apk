package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "()V", "canShowConfig", "", "type", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "enableBlurMouth", "enableFavorite", "enableFavoriteByStatus", "enableImage2Video", "enableLyrics", "enableMusic", "enableReply", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getEasterEggRegex", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "getFavExpiredTime", "", "()Ljava/lang/Long;", "initDefaultConfig", "loadConfig", "", "loadConfigByStatus", "StoryBasicConfig", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<a>
  implements f
{
  public static final a SiJ;
  
  static
  {
    AppMethodBeat.i(118580);
    SiJ = new a();
    AppMethodBeat.o(118580);
  }
  
  public final boolean a(f.a parama)
  {
    try
    {
      AppMethodBeat.i(118577);
      boolean bool = p.a((Iterable)((a)boF()).SiK, parama);
      AppMethodBeat.o(118577);
      return bool;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void boD()
  {
    AppMethodBeat.i(118576);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118576);
      return;
    }
    boE();
    AppMethodBeat.o(118576);
  }
  
  public final void boE()
  {
    boolean bool2 = true;
    AppMethodBeat.i(367198);
    ((a)boB()).SiK.clear();
    int i;
    a locala;
    if (aC("SnsTimelineLikeCommentStoryBubbleSwitch", 1) == 1)
    {
      i = 1;
      if (i != 0) {
        ((a)boB()).SiK.add(f.a.Sii);
      }
      aC("SnsTimelineJumpStorySwitch", 0);
      com.tencent.mm.pluginsdk.ui.span.o.a.Yos = Pattern.compile(((a)boB()).SiL);
      locala = (a)boB();
      if (aC("StoryEditVideoBgmSwitch", 1) != 1) {
        break label365;
      }
      bool1 = true;
      label100:
      locala.NHu = bool1;
      i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 1);
      ((a)boB()).NHv = (i * 100);
      ((a)boB()).NHw = (i * 100);
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
        break label370;
      }
      ((a)boB()).NHx = true;
      ((a)boB()).NHy = true;
      ((a)boB()).NHz = true;
      ((a)boB()).NHC = true;
      ((a)boB()).NHB = true;
      locala = (a)boB();
      bool1 = true;
      label226:
      locala.NHD = bool1;
      ((a)boB()).NHE = aC("StoryFeaturedExpiredTime", 15552000);
      ((a)boB()).NHF = ((c)h.ax(c.class)).a(c.a.yIP, 10);
      locala = (a)boB();
      if (((c)h.ax(c.class)).a(c.a.yIL, 1) != 1) {
        break label561;
      }
      bool1 = true;
      label310:
      locala.NHA = bool1;
      locala = (a)boB();
      if (((c)h.ax(c.class)).a(c.a.yIS, 1) != 1) {
        break label566;
      }
    }
    label402:
    label546:
    label551:
    label556:
    label561:
    label566:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.CWm = bool1;
      AppMethodBeat.o(367198);
      return;
      i = 0;
      break;
      label365:
      bool1 = false;
      break label100;
      label370:
      locala = (a)boB();
      if (((c)h.ax(c.class)).a(c.a.yIK, 0) == 1)
      {
        bool1 = true;
        locala.NHx = bool1;
        ((a)boB()).NHy = true;
        ((a)boB()).NHz = true;
        locala = (a)boB();
        if (((c)h.ax(c.class)).a(c.a.yIN, 1) != 1) {
          break label546;
        }
        bool1 = true;
        label462:
        locala.NHC = bool1;
        locala = (a)boB();
        if (((c)h.ax(c.class)).a(c.a.yIM, 1) != 1) {
          break label551;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        locala.NHB = bool1;
        locala = (a)boB();
        if (((c)h.ax(c.class)).a(c.a.yIR, 0) != 1) {
          break label556;
        }
        bool1 = true;
        break;
        bool1 = false;
        break label402;
        bool1 = false;
        break label462;
      }
      bool1 = false;
      break label226;
      bool1 = false;
      break label310;
    }
  }
  
  public final boolean huP()
  {
    AppMethodBeat.i(118578);
    boolean bool = ((a)boF()).NHx;
    AppMethodBeat.o(118578);
    return bool;
  }
  
  public final boolean hve()
  {
    AppMethodBeat.i(367199);
    boolean bool = ((a)boG()).NHx;
    AppMethodBeat.o(367199);
    return bool;
  }
  
  public final boolean hvf()
  {
    AppMethodBeat.i(118579);
    boolean bool = ((a)boF()).NHz;
    AppMethodBeat.o(118579);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "regex", "", "getRegex", "()Ljava/lang/String;", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "showSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "getShowSet", "()Ljava/util/HashSet;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    boolean CWm;
    boolean NHA;
    boolean NHB;
    boolean NHC;
    public boolean NHD;
    int NHE;
    int NHF;
    private int NHt;
    boolean NHu;
    public int NHv;
    public int NHw;
    boolean NHx;
    public boolean NHy;
    boolean NHz;
    final HashSet<f.a> SiK;
    final String SiL;
    
    private a()
    {
      AppMethodBeat.i(118573);
      this.NHt = 2;
      this.NHu = true;
      this.NHv = 0;
      this.NHw = 0;
      this.SiK = new HashSet();
      this.SiL = "#冒泡#";
      this.CWm = true;
      this.NHE = 15552000;
      this.NHF = 10;
      AppMethodBeat.o(118573);
    }
    
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
      AppMethodBeat.i(118574);
      String str = "StoryBasicConfig(repeatMD5=" + this.NHt + ", showMusicIcon=" + this.NHu + ", albumThumbHeight=" + this.NHv + ", albumThumbWidth=" + this.NHw + ')';
      AppMethodBeat.o(118574);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.a
 * JD-Core Version:    0.7.0.1
 */