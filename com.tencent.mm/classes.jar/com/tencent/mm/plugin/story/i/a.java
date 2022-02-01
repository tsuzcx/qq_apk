package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory;", "", "()V", "Companion", "StoryCommentSyncFlag", "StoryFavConstants", "StoryInfoLocalFlag", "StoryMixLocalFlag", "StoryMsgType", "StoryRangeDatailUI", "StoryRecommendAudio", "UploadStatus", "plugin-story_release"})
public final class a
{
  private static final int ASA = 20;
  private static final int ASB = 30;
  private static final String ASC = "@__weixinstory";
  private static final String ASD = "@__weixinhistory";
  private static final int ASE = 1;
  private static final int ASF = 2;
  private static final int ASG = 2;
  private static final int ASH = 311;
  private static final int ASI = 314;
  private static final int ASJ = 315;
  private static final int ASK = 317;
  private static final int ASL = 323;
  private static final int ASM = 324;
  private static final int ASN = 1;
  private static final int ASO = 2;
  private static final int ASP = 4;
  private static final int ASQ = 5;
  private static final int ASR = 1;
  private static final int ASS = 2;
  private static final int AST = 1;
  private static final int ASU = 2;
  private static final int ASV = 3;
  private static final int ASW = 4;
  private static final int ASX = 5;
  private static final int ASY = 6;
  private static final int ASZ = 14400;
  private static final int ASv = 4;
  private static final int ASw = 8;
  private static final int ASx = 16;
  private static final String ASy = "story_table_";
  private static final int ASz = 10;
  private static final int ATa = 86400;
  private static final int ATb = 100;
  private static final long ATc = 1L;
  private static final long ATd = 2L;
  private static final int ATe = 9;
  private static final int ATf = 4;
  private static final int ATg = 8;
  private static final float ATh = 1.78F;
  private static final float ATi = 2.18F;
  private static final int ATj = 3;
  private static final int ATk = 0;
  private static final int ATl = 1;
  private static final int ATm = 5;
  private static final int ATn = 7;
  private static final int ATo = 54;
  public static final a.a ATp;
  
  static
  {
    AppMethodBeat.i(119474);
    ATp = new a.a((byte)0);
    ASv = 4;
    ASw = 8;
    ASx = 16;
    ASy = "story_table_";
    ASz = 10;
    ASA = 20;
    ASB = 30;
    ASC = "@__weixinstory";
    ASD = "@__weixinhistory";
    ASE = 1;
    ASF = 2;
    ASG = 2;
    ASH = 311;
    ASI = 314;
    ASJ = 315;
    ASK = 317;
    ASL = 323;
    ASM = 324;
    ASN = 1;
    ASO = 2;
    ASP = 4;
    ASQ = 5;
    ASR = 1;
    ASS = 2;
    AST = 1;
    ASU = 2;
    ASV = 3;
    ASW = 4;
    ASX = 5;
    ASY = 6;
    ASZ = 14400;
    ATa = 86400;
    ATb = 100;
    ATc = 1L;
    ATd = 2L;
    ATe = 9;
    ATf = 4;
    ATg = 8;
    ATh = 1.78F;
    ATi = 2.18F;
    ATj = 3;
    ATl = 1;
    ATm = 5;
    ATn = 7;
    ATo = 54;
    AppMethodBeat.o(119474);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryFavConstants;", "", "()V", "MAX_SELECT_COUNT", "", "getMAX_SELECT_COUNT", "()I", "plugin-story_release"})
  public static final class c
  {
    private static final int ATs = 9;
    public static final c ATt;
    
    static
    {
      AppMethodBeat.i(119469);
      ATt = new c();
      ATs = 9;
      AppMethodBeat.o(119469);
    }
    
    public static int elc()
    {
      return ATs;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryInfoLocalFlag;", "", "()V", "LOCAL_FLAG_SHOW_INDICATOR", "", "getLOCAL_FLAG_SHOW_INDICATOR", "()I", "LOCAL_FLAG_STATE_MIX", "getLOCAL_FLAG_STATE_MIX", "LOCAL_FLAG_STATE_WAITING", "getLOCAL_FLAG_STATE_WAITING", "LOCAL_POST_STATE_DIE", "getLOCAL_POST_STATE_DIE", "plugin-story_release"})
  public static final class d
  {
    private static final int ATu = 2;
    private static final int ATv = 4;
    private static final int ATw = 8;
    private static final int ATx = 16;
    public static final d ATy;
    
    static
    {
      AppMethodBeat.i(119470);
      ATy = new d();
      ATu = 2;
      ATv = 4;
      ATw = 8;
      ATx = 16;
      AppMethodBeat.o(119470);
    }
    
    public static int eld()
    {
      return ATu;
    }
    
    public static int ele()
    {
      return ATv;
    }
    
    public static int elf()
    {
      return ATw;
    }
    
    public static int elg()
    {
      return ATx;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$UploadStatus;", "", "()V", "STORY_STATE_ERROR", "", "getSTORY_STATE_ERROR", "()I", "STORY_STATE_FINISH", "getSTORY_STATE_FINISH", "STORY_STATE_WAITTING", "getSTORY_STATE_WAITTING", "plugin-story_release"})
  public static final class g
  {
    private static final int ATD = 1;
    private static final int ATE = 2;
    private static final int ATF = 3;
    public static final g ATG;
    
    static
    {
      AppMethodBeat.i(119473);
      ATG = new g();
      ATD = 1;
      ATE = 2;
      ATF = 3;
      AppMethodBeat.o(119473);
    }
    
    public static int elj()
    {
      return ATD;
    }
    
    public static int elk()
    {
      return ATE;
    }
    
    public static int ell()
    {
      return ATF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.a
 * JD-Core Version:    0.7.0.1
 */