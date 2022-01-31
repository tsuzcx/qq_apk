package com.tencent.mm.plugin.story.c.a;

import a.a.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.c.c;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;
import java.util.regex.Pattern;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "()V", "canShowConfig", "", "type", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "enableBlurMouth", "enableFavorite", "enableImage2Video", "enableLyrics", "enableMusic", "enableReply", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getEasterEggRegex", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "getFavExpiredTime", "", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-story_release"})
public final class a
  extends c<a.a>
  implements com.tencent.mm.plugin.story.api.f
{
  public static final a srz;
  
  static
  {
    AppMethodBeat.i(108952);
    srz = new a();
    AppMethodBeat.o(108952);
  }
  
  public final void Uv()
  {
    boolean bool2 = true;
    AppMethodBeat.i(108949);
    if (!n.isShowStoryCheck())
    {
      AppMethodBeat.o(108949);
      return;
    }
    ((a.a)Ut()).srA.clear();
    int i;
    a.a locala;
    if (L("SnsTimelineLikeCommentStoryBubbleSwitch", 1) == 1)
    {
      i = 1;
      if (i != 0) {
        ((a.a)Ut()).srA.add(f.a.sqN);
      }
      L("SnsTimelineJumpStorySwitch", 0);
      com.tencent.mm.pluginsdk.ui.d.i.a.wci = Pattern.compile(((a.a)Ut()).regex);
      locala = (a.a)Ut();
      if (L("StoryEditVideoBgmSwitch", 1) != 1) {
        break label377;
      }
      bool1 = true;
      label112:
      locala.srM = bool1;
      i = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 1);
      ((a.a)Ut()).srN = (i * 100);
      ((a.a)Ut()).srO = (i * 100);
      if ((!com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.f.DEBUG)) {
        break label382;
      }
      ((a.a)Ut()).srB = true;
      ((a.a)Ut()).srC = true;
      ((a.a)Ut()).srD = true;
      ((a.a)Ut()).srG = true;
      ((a.a)Ut()).srF = true;
      locala = (a.a)Ut();
      bool1 = true;
      label238:
      locala.srI = bool1;
      ((a.a)Ut()).srJ = L("StoryFeaturedExpiredTime", 15552000);
      ((a.a)Ut()).srK = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lSq, 10);
      locala = (a.a)Ut();
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lSm, 1) != 1) {
        break label637;
      }
      bool1 = true;
      label322:
      locala.srE = bool1;
      locala = (a.a)Ut();
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lSt, 1) != 1) {
        break label642;
      }
    }
    label642:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.srH = bool1;
      AppMethodBeat.o(108949);
      return;
      i = 0;
      break;
      label377:
      bool1 = false;
      break label112;
      label382:
      locala = (a.a)Ut();
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lSj, 0) == 1)
      {
        bool1 = true;
        label414:
        locala.srB = bool1;
        locala = (a.a)Ut();
        if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lSk, 0) != 1) {
          break label612;
        }
        bool1 = true;
        label452:
        locala.srC = bool1;
        locala = (a.a)Ut();
        if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lSl, 0) != 1) {
          break label617;
        }
        bool1 = true;
        label490:
        locala.srD = bool1;
        locala = (a.a)Ut();
        if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lSo, 1) != 1) {
          break label622;
        }
        bool1 = true;
        label528:
        locala.srG = bool1;
        locala = (a.a)Ut();
        if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lSn, 1) != 1) {
          break label627;
        }
      }
      label612:
      label617:
      label622:
      label627:
      for (bool1 = true;; bool1 = false)
      {
        locala.srF = bool1;
        locala = (a.a)Ut();
        if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lSs, 0) != 1) {
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
  
  public final boolean a(f.a parama)
  {
    try
    {
      AppMethodBeat.i(108950);
      boolean bool = j.a((Iterable)((a.a)Uw()).srA, parama);
      AppMethodBeat.o(108950);
      return bool;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final boolean czD()
  {
    AppMethodBeat.i(138744);
    boolean bool = ((a.a)Uw()).srC;
    AppMethodBeat.o(138744);
    return bool;
  }
  
  public final boolean czE()
  {
    AppMethodBeat.i(138745);
    boolean bool = ((a.a)Uw()).srD;
    AppMethodBeat.o(138745);
    return bool;
  }
  
  public final boolean czF()
  {
    AppMethodBeat.i(150988);
    boolean bool = ((a.a)Uw()).srH;
    AppMethodBeat.o(150988);
    return bool;
  }
  
  public final boolean czq()
  {
    AppMethodBeat.i(108951);
    boolean bool = ((a.a)Uw()).srB;
    AppMethodBeat.o(108951);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.a
 * JD-Core Version:    0.7.0.1
 */