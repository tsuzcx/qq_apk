package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory;", "", "()V", "Companion", "StoryCommentSyncFlag", "StoryFavConstants", "StoryInfoLocalFlag", "StoryMixLocalFlag", "StoryMsgType", "StoryRangeDatailUI", "StoryRecommendAudio", "UploadStatus", "plugin-story_release"})
public final class a
{
  private static final int BjT = 4;
  private static final int BjU = 8;
  private static final int BjV = 16;
  private static final String BjW = "story_table_";
  private static final int BjX = 10;
  private static final int BjY = 20;
  private static final int BjZ = 30;
  private static final long BkA = 1L;
  private static final long BkB = 2L;
  private static final int BkC = 9;
  private static final int BkD = 4;
  private static final int BkE = 8;
  private static final float BkF = 1.78F;
  private static final float BkG = 2.18F;
  private static final int BkH = 3;
  private static final int BkI = 0;
  private static final int BkJ = 1;
  private static final int BkK = 5;
  private static final int BkL = 7;
  private static final int BkM = 54;
  public static final a.a BkN;
  private static final String Bka = "@__weixinstory";
  private static final String Bkb = "@__weixinhistory";
  private static final int Bkc = 1;
  private static final int Bkd = 2;
  private static final int Bke = 2;
  private static final int Bkf = 311;
  private static final int Bkg = 314;
  private static final int Bkh = 315;
  private static final int Bki = 317;
  private static final int Bkj = 323;
  private static final int Bkk = 324;
  private static final int Bkl = 1;
  private static final int Bkm = 2;
  private static final int Bkn = 4;
  private static final int Bko = 5;
  private static final int Bkp = 1;
  private static final int Bkq = 2;
  private static final int Bkr = 1;
  private static final int Bks = 2;
  private static final int Bkt = 3;
  private static final int Bku = 4;
  private static final int Bkv = 5;
  private static final int Bkw = 6;
  private static final int Bkx = 14400;
  private static final int Bky = 86400;
  private static final int Bkz = 100;
  
  static
  {
    AppMethodBeat.i(119474);
    BkN = new a.a((byte)0);
    BjT = 4;
    BjU = 8;
    BjV = 16;
    BjW = "story_table_";
    BjX = 10;
    BjY = 20;
    BjZ = 30;
    Bka = "@__weixinstory";
    Bkb = "@__weixinhistory";
    Bkc = 1;
    Bkd = 2;
    Bke = 2;
    Bkf = 311;
    Bkg = 314;
    Bkh = 315;
    Bki = 317;
    Bkj = 323;
    Bkk = 324;
    Bkl = 1;
    Bkm = 2;
    Bkn = 4;
    Bko = 5;
    Bkp = 1;
    Bkq = 2;
    Bkr = 1;
    Bks = 2;
    Bkt = 3;
    Bku = 4;
    Bkv = 5;
    Bkw = 6;
    Bkx = 14400;
    Bky = 86400;
    Bkz = 100;
    BkA = 1L;
    BkB = 2L;
    BkC = 9;
    BkD = 4;
    BkE = 8;
    BkF = 1.78F;
    BkG = 2.18F;
    BkH = 3;
    BkJ = 1;
    BkK = 5;
    BkL = 7;
    BkM = 54;
    AppMethodBeat.o(119474);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryFavConstants;", "", "()V", "MAX_SELECT_COUNT", "", "getMAX_SELECT_COUNT", "()I", "plugin-story_release"})
  public static final class c
  {
    private static final int BkQ = 9;
    public static final c BkR;
    
    static
    {
      AppMethodBeat.i(119469);
      BkR = new c();
      BkQ = 9;
      AppMethodBeat.o(119469);
    }
    
    public static int eoL()
    {
      return BkQ;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryInfoLocalFlag;", "", "()V", "LOCAL_FLAG_SHOW_INDICATOR", "", "getLOCAL_FLAG_SHOW_INDICATOR", "()I", "LOCAL_FLAG_STATE_MIX", "getLOCAL_FLAG_STATE_MIX", "LOCAL_FLAG_STATE_WAITING", "getLOCAL_FLAG_STATE_WAITING", "LOCAL_POST_STATE_DIE", "getLOCAL_POST_STATE_DIE", "plugin-story_release"})
  public static final class d
  {
    private static final int BkS = 2;
    private static final int BkT = 4;
    private static final int BkU = 8;
    private static final int BkV = 16;
    public static final d BkW;
    
    static
    {
      AppMethodBeat.i(119470);
      BkW = new d();
      BkS = 2;
      BkT = 4;
      BkU = 8;
      BkV = 16;
      AppMethodBeat.o(119470);
    }
    
    public static int eoM()
    {
      return BkS;
    }
    
    public static int eoN()
    {
      return BkT;
    }
    
    public static int eoO()
    {
      return BkU;
    }
    
    public static int eoP()
    {
      return BkV;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$UploadStatus;", "", "()V", "STORY_STATE_ERROR", "", "getSTORY_STATE_ERROR", "()I", "STORY_STATE_FINISH", "getSTORY_STATE_FINISH", "STORY_STATE_WAITTING", "getSTORY_STATE_WAITTING", "plugin-story_release"})
  public static final class g
  {
    private static final int Blb = 1;
    private static final int Blc = 2;
    private static final int Bld = 3;
    public static final g Ble;
    
    static
    {
      AppMethodBeat.i(119473);
      Ble = new g();
      Blb = 1;
      Blc = 2;
      Bld = 3;
      AppMethodBeat.o(119473);
    }
    
    public static int eoS()
    {
      return Blb;
    }
    
    public static int eoT()
    {
      return Blc;
    }
    
    public static int eoU()
    {
      return Bld;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.a
 * JD-Core Version:    0.7.0.1
 */