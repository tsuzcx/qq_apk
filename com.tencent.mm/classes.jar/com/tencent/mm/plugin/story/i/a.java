package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory;", "", "()V", "Companion", "StoryCommentSyncFlag", "StoryFavConstants", "StoryInfoLocalFlag", "StoryMixLocalFlag", "StoryMsgType", "StoryRangeDatailUI", "StoryRecommendAudio", "UploadStatus", "plugin-story_release"})
public final class a
{
  private static final String ynA = "story_table_";
  private static final int ynB = 10;
  private static final int ynC = 20;
  private static final int ynD = 30;
  private static final String ynE = "@__weixinstory";
  private static final String ynF = "@__weixinhistory";
  private static final int ynG = 1;
  private static final int ynH = 2;
  private static final int ynI = 2;
  private static final int ynJ = 311;
  private static final int ynK = 314;
  private static final int ynL = 315;
  private static final int ynM = 317;
  private static final int ynN = 323;
  private static final int ynO = 324;
  private static final int ynP = 1;
  private static final int ynQ = 2;
  private static final int ynR = 4;
  private static final int ynS = 5;
  private static final int ynT = 1;
  private static final int ynU = 2;
  private static final int ynV = 1;
  private static final int ynW = 2;
  private static final int ynX = 3;
  private static final int ynY = 4;
  private static final int ynZ = 5;
  private static final int ynx = 4;
  private static final int yny = 8;
  private static final int ynz = 16;
  private static final int yoa = 6;
  private static final int yob = 14400;
  private static final int yoc = 86400;
  private static final int yod = 100;
  private static final long yoe = 1L;
  private static final long yof = 2L;
  private static final int yog = 9;
  private static final int yoh = 4;
  private static final int yoi = 8;
  private static final float yoj = 1.78F;
  private static final float yok = 2.18F;
  private static final int yol = 3;
  private static final int yom = 0;
  private static final int yon = 1;
  private static final int yoo = 5;
  private static final int yop = 7;
  private static final int yoq = 54;
  public static final a yor;
  
  static
  {
    AppMethodBeat.i(119474);
    yor = new a((byte)0);
    ynx = 4;
    yny = 8;
    ynz = 16;
    ynA = "story_table_";
    ynB = 10;
    ynC = 20;
    ynD = 30;
    ynE = "@__weixinstory";
    ynF = "@__weixinhistory";
    ynG = 1;
    ynH = 2;
    ynI = 2;
    ynJ = 311;
    ynK = 314;
    ynL = 315;
    ynM = 317;
    ynN = 323;
    ynO = 324;
    ynP = 1;
    ynQ = 2;
    ynR = 4;
    ynS = 5;
    ynT = 1;
    ynU = 2;
    ynV = 1;
    ynW = 2;
    ynX = 3;
    ynY = 4;
    ynZ = 5;
    yoa = 6;
    yob = 14400;
    yoc = 86400;
    yod = 100;
    yoe = 1L;
    yof = 2L;
    yog = 9;
    yoh = 4;
    yoi = 8;
    yoj = 1.78F;
    yok = 2.18F;
    yol = 3;
    yon = 1;
    yoo = 5;
    yop = 7;
    yoq = 54;
    AppMethodBeat.o(119474);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$Companion;", "", "()V", "DEFAULT_AUDIO_COUNT", "", "EDITOR_SAFE_AREA_DEFAULT_DAMPING", "getEDITOR_SAFE_AREA_DEFAULT_DAMPING", "()I", "ERR_LOCAL_MEDIA_DB_NOT_E", "getERR_LOCAL_MEDIA_DB_NOT_E", "ERR_NOT_WITH_ARG", "getERR_NOT_WITH_ARG", "ERR_PARSER_ERROR", "getERR_PARSER_ERROR", "ERR_PULL_XML", "getERR_PULL_XML", "ERR_TIMELINE_NULL", "getERR_TIMELINE_NULL", "ERR_TLE", "getERR_TLE", "FAV_COUNT", "getFAV_COUNT", "HISTORY_COUNT", "getHISTORY_COUNT", "HISTORY_NAME", "", "getHISTORY_NAME", "()Ljava/lang/String;", "LOCAL_FLAG_MP4_OPT", "MAX_FAULT_NUM", "getMAX_FAULT_NUM", "MAX_FAVORITE_COUNT", "getMAX_FAVORITE_COUNT", "MAX_SAFE_AREA_SCALE", "", "getMAX_SAFE_AREA_SCALE", "()F", "MIN_SAFE_AREA_SCALE", "getMIN_SAFE_AREA_SCALE", "MIN_THREAD_NUM", "getMIN_THREAD_NUM", "MMSTORY_MENU_ITEM_ID_DEL", "getMMSTORY_MENU_ITEM_ID_DEL", "MMSTORY_MENU_ITEM_ID_RESEND", "getMMSTORY_MENU_ITEM_ID_RESEND", "MMSTORY_OBJ_OP_DEL_COMMENT_TYPE", "getMMSTORY_OBJ_OP_DEL_COMMENT_TYPE", "MMSTORY_OBJ_OP_DEL_OBJ_TYPE", "getMMSTORY_OBJ_OP_DEL_OBJ_TYPE", "MMSTORY_OBJ_OP_FAV_TYPE", "getMMSTORY_OBJ_OP_FAV_TYPE", "MMSTORY_OBJ_OP_VISIBILITY_TYPE", "getMMSTORY_OBJ_OP_VISIBILITY_TYPE", "MMSTORY_RET_EMPTY", "getMMSTORY_RET_EMPTY", "MMSTORY_RET_ERR_WITH_MSG", "getMMSTORY_RET_ERR_WITH_MSG", "MMSTORY_RET_NO_MORE_DATA", "getMMSTORY_RET_NO_MORE_DATA", "MMSTORY_RET_POST_DUPLICATE_ERR", "getMMSTORY_RET_POST_DUPLICATE_ERR", "MMSTORY_RET_SAME_MD5", "getMMSTORY_RET_SAME_MD5", "MMSTORY_RET_SET_FAV_OVERSIZE_ERR", "getMMSTORY_RET_SET_FAV_OVERSIZE_ERR", "MMSTORY_URL_CDN", "getMMSTORY_URL_CDN", "MMSTORY_URL_OTHER", "getMMSTORY_URL_OTHER", "MMSTORY_URL_WEIXIN", "getMMSTORY_URL_WEIXIN", "STORY_DIED_TIMS_SECOND", "getSTORY_DIED_TIMS_SECOND", "STORY_ITEM_FAVORITE_FLAG", "getSTORY_ITEM_FAVORITE_FLAG", "STORY_ITEM_VISIABLE_ONLY_SELF_FLAG", "getSTORY_ITEM_VISIABLE_ONLY_SELF_FLAG", "STORY_NAME", "getSTORY_NAME", "STORY_RPT_15615_SCENE", "getSTORY_RPT_15615_SCENE", "STORY_RPT_SEND_SOURCE_CAPTURE", "", "getSTORY_RPT_SEND_SOURCE_CAPTURE", "()J", "STORY_RPT_SEND_SOURCE_LOCAL", "getSTORY_RPT_SEND_SOURCE_LOCAL", "STORY_SOURCE_ALBUM_HISTORY", "getSTORY_SOURCE_ALBUM_HISTORY", "STORY_SOURCE_USERPAGE_OTHERS", "getSTORY_SOURCE_USERPAGE_OTHERS", "STORY_SOURCE_USERPAGE_SELF", "getSTORY_SOURCE_USERPAGE_SELF", "STORY_TRY_TIMS_SECOND", "getSTORY_TRY_TIMS_SECOND", "TABLE_STORY", "getTABLE_STORY", "USERPAGE_COUNT", "getUSERPAGE_COUNT", "USER_PAGE_SOURCE_FAV", "getUSER_PAGE_SOURCE_FAV", "USER_PAGE_SOURCE_HISTORY", "getUSER_PAGE_SOURCE_HISTORY", "USER_PAGE_SOURCE_PROFILE", "getUSER_PAGE_SOURCE_PROFILE", "USER_PAGE_SOURCE_SELECT_FAV", "getUSER_PAGE_SOURCE_SELECT_FAV", "plugin-story_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryInfoLocalFlag;", "", "()V", "LOCAL_FLAG_SHOW_INDICATOR", "", "getLOCAL_FLAG_SHOW_INDICATOR", "()I", "LOCAL_FLAG_STATE_MIX", "getLOCAL_FLAG_STATE_MIX", "LOCAL_FLAG_STATE_WAITING", "getLOCAL_FLAG_STATE_WAITING", "LOCAL_POST_STATE_DIE", "getLOCAL_POST_STATE_DIE", "plugin-story_release"})
  public static final class d
  {
    public static final d yoA;
    private static final int yow = 2;
    private static final int yox = 4;
    private static final int yoy = 8;
    private static final int yoz = 16;
    
    static
    {
      AppMethodBeat.i(119470);
      yoA = new d();
      yow = 2;
      yox = 4;
      yoy = 8;
      yoz = 16;
      AppMethodBeat.o(119470);
    }
    
    public static int dKn()
    {
      return yow;
    }
    
    public static int dKo()
    {
      return yox;
    }
    
    public static int dKp()
    {
      return yoy;
    }
    
    public static int dKq()
    {
      return yoz;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$UploadStatus;", "", "()V", "STORY_STATE_ERROR", "", "getSTORY_STATE_ERROR", "()I", "STORY_STATE_FINISH", "getSTORY_STATE_FINISH", "STORY_STATE_WAITTING", "getSTORY_STATE_WAITTING", "plugin-story_release"})
  public static final class g
  {
    private static final int yoF = 1;
    private static final int yoG = 2;
    private static final int yoH = 3;
    public static final g yoI;
    
    static
    {
      AppMethodBeat.i(119473);
      yoI = new g();
      yoF = 1;
      yoG = 2;
      yoH = 3;
      AppMethodBeat.o(119473);
    }
    
    public static int dKt()
    {
      return yoF;
    }
    
    public static int dKu()
    {
      return yoG;
    }
    
    public static int dKv()
    {
      return yoH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.a
 * JD-Core Version:    0.7.0.1
 */