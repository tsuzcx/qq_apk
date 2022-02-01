package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.h;
import d.a.j;
import d.l;
import java.util.HashSet;
import java.util.regex.Pattern;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "()V", "canShowConfig", "", "type", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "enableBlurMouth", "enableFavorite", "enableImage2Video", "enableLyrics", "enableMusic", "enableReply", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getEasterEggRegex", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "getFavExpiredTime", "", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-story_release"})
public final class a
  extends com.tencent.mm.plugin.story.c.b<a>
  implements f
{
  public static final a ydB;
  
  static
  {
    AppMethodBeat.i(118580);
    ydB = new a();
    AppMethodBeat.o(118580);
  }
  
  public final boolean a(f.a parama)
  {
    try
    {
      AppMethodBeat.i(118577);
      boolean bool = j.a((Iterable)((a)ajp()).ydC, parama);
      AppMethodBeat.o(118577);
      return bool;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void ajo()
  {
    boolean bool2 = true;
    AppMethodBeat.i(118576);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118576);
      return;
    }
    ((a)ajm()).ydC.clear();
    int i;
    a locala;
    if (P("SnsTimelineLikeCommentStoryBubbleSwitch", 1) == 1)
    {
      i = 1;
      if (i != 0) {
        ((a)ajm()).ydC.add(f.a.yda);
      }
      P("SnsTimelineJumpStorySwitch", 0);
      com.tencent.mm.pluginsdk.ui.span.j.a.CjU = Pattern.compile(((a)ajm()).regex);
      locala = (a)ajm();
      if (P("StoryEditVideoBgmSwitch", 1) != 1) {
        break label377;
      }
      bool1 = true;
      label112:
      locala.vhs = bool1;
      i = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 1);
      ((a)ajm()).vht = (i * 100);
      ((a)ajm()).vhu = (i * 100);
      if ((!h.IS_FLAVOR_RED) && (!h.IS_FLAVOR_PURPLE) && (!h.DEBUG)) {
        break label382;
      }
      ((a)ajm()).vhh = true;
      ((a)ajm()).vhi = true;
      ((a)ajm()).vhj = true;
      ((a)ajm()).vhm = true;
      ((a)ajm()).vhl = true;
      locala = (a)ajm();
      bool1 = true;
      label238:
      locala.vho = bool1;
      ((a)ajm()).vhp = P("StoryFeaturedExpiredTime", 15552000);
      ((a)ajm()).vhq = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjK, 10);
      locala = (a)ajm();
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjG, 1) != 1) {
        break label637;
      }
      bool1 = true;
      label322:
      locala.vhk = bool1;
      locala = (a)ajm();
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjN, 1) != 1) {
        break label642;
      }
    }
    label642:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.vhn = bool1;
      AppMethodBeat.o(118576);
      return;
      i = 0;
      break;
      label377:
      bool1 = false;
      break label112;
      label382:
      locala = (a)ajm();
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjD, 0) == 1)
      {
        bool1 = true;
        label414:
        locala.vhh = bool1;
        locala = (a)ajm();
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjE, 0) != 1) {
          break label612;
        }
        bool1 = true;
        label452:
        locala.vhi = bool1;
        locala = (a)ajm();
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjF, 0) != 1) {
          break label617;
        }
        bool1 = true;
        label490:
        locala.vhj = bool1;
        locala = (a)ajm();
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjI, 1) != 1) {
          break label622;
        }
        bool1 = true;
        label528:
        locala.vhm = bool1;
        locala = (a)ajm();
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjH, 1) != 1) {
          break label627;
        }
      }
      label612:
      label617:
      label622:
      label627:
      for (bool1 = true;; bool1 = false)
      {
        locala.vhl = bool1;
        locala = (a)ajm();
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjM, 0) != 1) {
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
  
  public final boolean dGf()
  {
    AppMethodBeat.i(118578);
    boolean bool = ((a)ajp()).vhh;
    AppMethodBeat.o(118578);
    return bool;
  }
  
  public final boolean dGv()
  {
    AppMethodBeat.i(118579);
    boolean bool = ((a)ajp()).vhj;
    AppMethodBeat.o(118579);
    return bool;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "regex", "", "getRegex", "()Ljava/lang/String;", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "showSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "getShowSet", "()Ljava/util/HashSet;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-story_release"})
  public static final class a
  {
    final String regex;
    boolean vhh;
    public boolean vhi;
    boolean vhj;
    boolean vhk;
    boolean vhl;
    boolean vhm;
    boolean vhn;
    public boolean vho;
    int vhp;
    int vhq;
    private int vhr;
    boolean vhs;
    public int vht;
    public int vhu;
    final HashSet<f.a> ydC;
    
    private a()
    {
      AppMethodBeat.i(118573);
      this.vhr = 2;
      this.vhs = true;
      this.vht = 0;
      this.vhu = 0;
      this.ydC = new HashSet();
      this.regex = "#冒泡#";
      this.vhn = true;
      this.vhp = 15552000;
      this.vhq = 10;
      AppMethodBeat.o(118573);
    }
    
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
      AppMethodBeat.i(118574);
      String str = "StoryBasicConfig(repeatMD5=" + this.vhr + ", showMusicIcon=" + this.vhs + ", albumThumbHeight=" + this.vht + ", albumThumbWidth=" + this.vhu + ")";
      AppMethodBeat.o(118574);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.a
 * JD-Core Version:    0.7.0.1
 */