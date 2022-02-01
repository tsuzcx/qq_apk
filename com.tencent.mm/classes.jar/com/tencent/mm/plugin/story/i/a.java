package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory;", "", "()V", "Companion", "StoryCommentSyncFlag", "StoryFavConstants", "StoryInfoLocalFlag", "StoryMixLocalFlag", "StoryMsgType", "StoryRangeDatailUI", "StoryRecommendAudio", "UploadStatus", "plugin-story_release"})
public final class a
{
  private static final int LOL = 4;
  private static final int LOM = 8;
  private static final int LON = 16;
  private static final String LOO = "story_table_";
  private static final int LOP = 10;
  private static final int LOQ = 20;
  private static final int LOR = 30;
  private static final String LOS = "@__weixinstory";
  private static final String LOT = "@__weixinhistory";
  private static final int LOU = 1;
  private static final int LOV = 2;
  private static final int LOX = 2;
  private static final int LOY = 311;
  private static final int LOZ = 314;
  private static final int LPA = 3;
  private static final int LPB = 0;
  private static final int LPC = 1;
  private static final int LPD = 5;
  private static final int LPE = 7;
  private static final int LPF = 54;
  public static final a LPG;
  private static final int LPa = 315;
  private static final int LPb = 317;
  private static final int LPc = 323;
  private static final int LPd = 324;
  private static final int LPe = 1;
  private static final int LPf = 2;
  private static final int LPg = 4;
  private static final int LPh = 5;
  private static final int LPi = 1;
  private static final int LPj = 2;
  private static final int LPk = 1;
  private static final int LPl = 2;
  private static final int LPm = 3;
  private static final int LPn = 4;
  private static final int LPo = 5;
  private static final int LPp = 6;
  private static final int LPq = 14400;
  private static final int LPr = 86400;
  private static final int LPs = 100;
  private static final long LPt = 1L;
  private static final long LPu = 2L;
  private static final int LPv = 9;
  private static final int LPw = 4;
  private static final int LPx = 8;
  private static final float LPy = 1.78F;
  private static final float LPz = 2.18F;
  
  static
  {
    AppMethodBeat.i(119474);
    LPG = new a((byte)0);
    LOL = 4;
    LOM = 8;
    LON = 16;
    LOO = "story_table_";
    LOP = 10;
    LOQ = 20;
    LOR = 30;
    LOS = "@__weixinstory";
    LOT = "@__weixinhistory";
    LOU = 1;
    LOV = 2;
    LOX = 2;
    LOY = 311;
    LOZ = 314;
    LPa = 315;
    LPb = 317;
    LPc = 323;
    LPd = 324;
    LPe = 1;
    LPf = 2;
    LPg = 4;
    LPh = 5;
    LPi = 1;
    LPj = 2;
    LPk = 1;
    LPl = 2;
    LPm = 3;
    LPn = 4;
    LPo = 5;
    LPp = 6;
    LPq = 14400;
    LPr = 86400;
    LPs = 100;
    LPt = 1L;
    LPu = 2L;
    LPv = 9;
    LPw = 4;
    LPx = 8;
    LPy = 1.78F;
    LPz = 2.18F;
    LPA = 3;
    LPC = 1;
    LPD = 5;
    LPE = 7;
    LPF = 54;
    AppMethodBeat.o(119474);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$Companion;", "", "()V", "DEFAULT_AUDIO_COUNT", "", "EDITOR_SAFE_AREA_DEFAULT_DAMPING", "getEDITOR_SAFE_AREA_DEFAULT_DAMPING", "()I", "ERR_LOCAL_MEDIA_DB_NOT_E", "getERR_LOCAL_MEDIA_DB_NOT_E", "ERR_NOT_WITH_ARG", "getERR_NOT_WITH_ARG", "ERR_PARSER_ERROR", "getERR_PARSER_ERROR", "ERR_PULL_XML", "getERR_PULL_XML", "ERR_TIMELINE_NULL", "getERR_TIMELINE_NULL", "ERR_TLE", "getERR_TLE", "FAV_COUNT", "getFAV_COUNT", "HISTORY_COUNT", "getHISTORY_COUNT", "HISTORY_NAME", "", "getHISTORY_NAME", "()Ljava/lang/String;", "LOCAL_FLAG_MP4_OPT", "MAX_FAULT_NUM", "getMAX_FAULT_NUM", "MAX_FAVORITE_COUNT", "getMAX_FAVORITE_COUNT", "MAX_SAFE_AREA_SCALE", "", "getMAX_SAFE_AREA_SCALE", "()F", "MIN_SAFE_AREA_SCALE", "getMIN_SAFE_AREA_SCALE", "MIN_THREAD_NUM", "getMIN_THREAD_NUM", "MMSTORY_MENU_ITEM_ID_DEL", "getMMSTORY_MENU_ITEM_ID_DEL", "MMSTORY_MENU_ITEM_ID_RESEND", "getMMSTORY_MENU_ITEM_ID_RESEND", "MMSTORY_OBJ_OP_DEL_COMMENT_TYPE", "getMMSTORY_OBJ_OP_DEL_COMMENT_TYPE", "MMSTORY_OBJ_OP_DEL_OBJ_TYPE", "getMMSTORY_OBJ_OP_DEL_OBJ_TYPE", "MMSTORY_OBJ_OP_FAV_TYPE", "getMMSTORY_OBJ_OP_FAV_TYPE", "MMSTORY_OBJ_OP_VISIBILITY_TYPE", "getMMSTORY_OBJ_OP_VISIBILITY_TYPE", "MMSTORY_RET_EMPTY", "getMMSTORY_RET_EMPTY", "MMSTORY_RET_ERR_WITH_MSG", "getMMSTORY_RET_ERR_WITH_MSG", "MMSTORY_RET_NO_MORE_DATA", "getMMSTORY_RET_NO_MORE_DATA", "MMSTORY_RET_POST_DUPLICATE_ERR", "getMMSTORY_RET_POST_DUPLICATE_ERR", "MMSTORY_RET_SAME_MD5", "getMMSTORY_RET_SAME_MD5", "MMSTORY_RET_SET_FAV_OVERSIZE_ERR", "getMMSTORY_RET_SET_FAV_OVERSIZE_ERR", "MMSTORY_URL_CDN", "getMMSTORY_URL_CDN", "MMSTORY_URL_OTHER", "getMMSTORY_URL_OTHER", "MMSTORY_URL_WEIXIN", "getMMSTORY_URL_WEIXIN", "STORY_DIED_TIMS_SECOND", "getSTORY_DIED_TIMS_SECOND", "STORY_ITEM_FAVORITE_FLAG", "getSTORY_ITEM_FAVORITE_FLAG", "STORY_ITEM_VISIABLE_ONLY_SELF_FLAG", "getSTORY_ITEM_VISIABLE_ONLY_SELF_FLAG", "STORY_NAME", "getSTORY_NAME", "STORY_RPT_15615_SCENE", "getSTORY_RPT_15615_SCENE", "STORY_RPT_SEND_SOURCE_CAPTURE", "", "getSTORY_RPT_SEND_SOURCE_CAPTURE", "()J", "STORY_RPT_SEND_SOURCE_LOCAL", "getSTORY_RPT_SEND_SOURCE_LOCAL", "STORY_SOURCE_ALBUM_HISTORY", "getSTORY_SOURCE_ALBUM_HISTORY", "STORY_SOURCE_USERPAGE_OTHERS", "getSTORY_SOURCE_USERPAGE_OTHERS", "STORY_SOURCE_USERPAGE_SELF", "getSTORY_SOURCE_USERPAGE_SELF", "STORY_TRY_TIMS_SECOND", "getSTORY_TRY_TIMS_SECOND", "TABLE_STORY", "getTABLE_STORY", "USERPAGE_COUNT", "getUSERPAGE_COUNT", "USER_PAGE_SOURCE_FAV", "getUSER_PAGE_SOURCE_FAV", "USER_PAGE_SOURCE_HISTORY", "getUSER_PAGE_SOURCE_HISTORY", "USER_PAGE_SOURCE_PROFILE", "getUSER_PAGE_SOURCE_PROFILE", "USER_PAGE_SOURCE_SELECT_FAV", "getUSER_PAGE_SOURCE_SELECT_FAV", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryCommentSyncFlag;", "", "()V", "STORY_COMMENT_SYNC_FLAG_UNREAD", "", "getSTORY_COMMENT_SYNC_FLAG_UNREAD", "()I", "plugin-story_release"})
  public static final class b
  {
    private static final int LPH = 1;
    public static final b LPI;
    
    static
    {
      AppMethodBeat.i(119468);
      LPI = new b();
      LPH = 1;
      AppMethodBeat.o(119468);
    }
    
    public static int gfG()
    {
      return LPH;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryFavConstants;", "", "()V", "MAX_SELECT_COUNT", "", "getMAX_SELECT_COUNT", "()I", "plugin-story_release"})
  public static final class c
  {
    private static final int LPJ = 9;
    public static final c LPK;
    
    static
    {
      AppMethodBeat.i(119469);
      LPK = new c();
      LPJ = 9;
      AppMethodBeat.o(119469);
    }
    
    public static int gfH()
    {
      return LPJ;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryInfoLocalFlag;", "", "()V", "LOCAL_FLAG_SHOW_INDICATOR", "", "getLOCAL_FLAG_SHOW_INDICATOR", "()I", "LOCAL_FLAG_STATE_MIX", "getLOCAL_FLAG_STATE_MIX", "LOCAL_FLAG_STATE_WAITING", "getLOCAL_FLAG_STATE_WAITING", "LOCAL_POST_STATE_DIE", "getLOCAL_POST_STATE_DIE", "plugin-story_release"})
  public static final class d
  {
    private static final int LPL = 2;
    private static final int LPM = 4;
    private static final int LPN = 8;
    private static final int LPO = 16;
    public static final d LPP;
    
    static
    {
      AppMethodBeat.i(119470);
      LPP = new d();
      LPL = 2;
      LPM = 4;
      LPN = 8;
      LPO = 16;
      AppMethodBeat.o(119470);
    }
    
    public static int gfI()
    {
      return LPL;
    }
    
    public static int gfJ()
    {
      return LPM;
    }
    
    public static int gfK()
    {
      return LPN;
    }
    
    public static int gfL()
    {
      return LPO;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryMsgType;", "", "()V", "STORY_VISIT_FLAG", "", "getSTORY_VISIT_FLAG", "()I", "plugin-story_release"})
  public static final class e
  {
    private static final int LPQ = 4;
    public static final e LPR;
    
    static
    {
      AppMethodBeat.i(119471);
      LPR = new e();
      LPQ = 4;
      AppMethodBeat.o(119471);
    }
    
    public static int gfM()
    {
      return LPQ;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryRangeDatailUI;", "", "()V", "KEY_STORY_LOCAL_ID", "", "getKEY_STORY_LOCAL_ID", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class f
  {
    private static final String LPS = "key_story_local_id";
    public static final f LPT;
    
    static
    {
      AppMethodBeat.i(119472);
      LPT = new f();
      LPS = "key_story_local_id";
      AppMethodBeat.o(119472);
    }
    
    public static String gfN()
    {
      return LPS;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$UploadStatus;", "", "()V", "STORY_STATE_ERROR", "", "getSTORY_STATE_ERROR", "()I", "STORY_STATE_FINISH", "getSTORY_STATE_FINISH", "STORY_STATE_WAITTING", "getSTORY_STATE_WAITTING", "plugin-story_release"})
  public static final class g
  {
    private static final int LPU = 1;
    private static final int LPV = 2;
    private static final int LPW = 3;
    public static final g LPX;
    
    static
    {
      AppMethodBeat.i(119473);
      LPX = new g();
      LPU = 1;
      LPV = 2;
      LPW = 3;
      AppMethodBeat.o(119473);
    }
    
    public static int gfO()
    {
      return LPU;
    }
    
    public static int gfP()
    {
      return LPV;
    }
    
    public static int gfQ()
    {
      return LPW;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.a
 * JD-Core Version:    0.7.0.1
 */