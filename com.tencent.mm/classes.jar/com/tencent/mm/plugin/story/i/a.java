package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory;", "", "()V", "Companion", "StoryCommentSyncFlag", "StoryFavConstants", "StoryInfoLocalFlag", "StoryMixLocalFlag", "StoryMsgType", "StoryRangeDatailUI", "StoryRecommendAudio", "UploadStatus", "plugin-story_release"})
public final class a
{
  private static final int zAW = 4;
  private static final int zAX = 8;
  private static final int zAY = 16;
  private static final String zAZ = "story_table_";
  private static final int zBA = 14400;
  private static final int zBB = 86400;
  private static final int zBC = 100;
  private static final long zBD = 1L;
  private static final long zBE = 2L;
  private static final int zBF = 9;
  private static final int zBG = 4;
  private static final int zBH = 8;
  private static final float zBI = 1.78F;
  private static final float zBJ = 2.18F;
  private static final int zBK = 3;
  private static final int zBL = 0;
  private static final int zBM = 1;
  private static final int zBN = 5;
  private static final int zBO = 7;
  private static final int zBP = 54;
  public static final a.a zBQ;
  private static final int zBa = 10;
  private static final int zBb = 20;
  private static final int zBc = 30;
  private static final String zBd = "@__weixinstory";
  private static final String zBe = "@__weixinhistory";
  private static final int zBf = 1;
  private static final int zBg = 2;
  private static final int zBh = 2;
  private static final int zBi = 311;
  private static final int zBj = 314;
  private static final int zBk = 315;
  private static final int zBl = 317;
  private static final int zBm = 323;
  private static final int zBn = 324;
  private static final int zBo = 1;
  private static final int zBp = 2;
  private static final int zBq = 4;
  private static final int zBr = 5;
  private static final int zBs = 1;
  private static final int zBt = 2;
  private static final int zBu = 1;
  private static final int zBv = 2;
  private static final int zBw = 3;
  private static final int zBx = 4;
  private static final int zBy = 5;
  private static final int zBz = 6;
  
  static
  {
    AppMethodBeat.i(119474);
    zBQ = new a.a((byte)0);
    zAW = 4;
    zAX = 8;
    zAY = 16;
    zAZ = "story_table_";
    zBa = 10;
    zBb = 20;
    zBc = 30;
    zBd = "@__weixinstory";
    zBe = "@__weixinhistory";
    zBf = 1;
    zBg = 2;
    zBh = 2;
    zBi = 311;
    zBj = 314;
    zBk = 315;
    zBl = 317;
    zBm = 323;
    zBn = 324;
    zBo = 1;
    zBp = 2;
    zBq = 4;
    zBr = 5;
    zBs = 1;
    zBt = 2;
    zBu = 1;
    zBv = 2;
    zBw = 3;
    zBx = 4;
    zBy = 5;
    zBz = 6;
    zBA = 14400;
    zBB = 86400;
    zBC = 100;
    zBD = 1L;
    zBE = 2L;
    zBF = 9;
    zBG = 4;
    zBH = 8;
    zBI = 1.78F;
    zBJ = 2.18F;
    zBK = 3;
    zBM = 1;
    zBN = 5;
    zBO = 7;
    zBP = 54;
    AppMethodBeat.o(119474);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryFavConstants;", "", "()V", "MAX_SELECT_COUNT", "", "getMAX_SELECT_COUNT", "()I", "plugin-story_release"})
  public static final class c
  {
    private static final int zBT = 9;
    public static final c zBU;
    
    static
    {
      AppMethodBeat.i(119469);
      zBU = new c();
      zBT = 9;
      AppMethodBeat.o(119469);
    }
    
    public static int dYN()
    {
      return zBT;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryInfoLocalFlag;", "", "()V", "LOCAL_FLAG_SHOW_INDICATOR", "", "getLOCAL_FLAG_SHOW_INDICATOR", "()I", "LOCAL_FLAG_STATE_MIX", "getLOCAL_FLAG_STATE_MIX", "LOCAL_FLAG_STATE_WAITING", "getLOCAL_FLAG_STATE_WAITING", "LOCAL_POST_STATE_DIE", "getLOCAL_POST_STATE_DIE", "plugin-story_release"})
  public static final class d
  {
    private static final int zBV = 2;
    private static final int zBW = 4;
    private static final int zBX = 8;
    private static final int zBY = 16;
    public static final d zBZ;
    
    static
    {
      AppMethodBeat.i(119470);
      zBZ = new d();
      zBV = 2;
      zBW = 4;
      zBX = 8;
      zBY = 16;
      AppMethodBeat.o(119470);
    }
    
    public static int dYO()
    {
      return zBV;
    }
    
    public static int dYP()
    {
      return zBW;
    }
    
    public static int dYQ()
    {
      return zBX;
    }
    
    public static int dYR()
    {
      return zBY;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$UploadStatus;", "", "()V", "STORY_STATE_ERROR", "", "getSTORY_STATE_ERROR", "()I", "STORY_STATE_FINISH", "getSTORY_STATE_FINISH", "STORY_STATE_WAITTING", "getSTORY_STATE_WAITTING", "plugin-story_release"})
  public static final class g
  {
    private static final int zCe = 1;
    private static final int zCf = 2;
    private static final int zCg = 3;
    public static final g zCh;
    
    static
    {
      AppMethodBeat.i(119473);
      zCh = new g();
      zCe = 1;
      zCf = 2;
      zCg = 3;
      AppMethodBeat.o(119473);
    }
    
    public static int dYU()
    {
      return zCe;
    }
    
    public static int dYV()
    {
      return zCf;
    }
    
    public static int dYW()
    {
      return zCg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.a
 * JD-Core Version:    0.7.0.1
 */