package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory;", "", "()V", "Companion", "StoryCommentSyncFlag", "StoryFavConstants", "StoryInfoLocalFlag", "StoryMixLocalFlag", "StoryMsgType", "StoryRangeDatailUI", "StoryRecommendAudio", "UploadStatus", "plugin-story_release"})
public final class a
{
  private static final int FuJ = 4;
  private static final int FuK = 8;
  private static final int FuL = 16;
  private static final String FuM = "story_table_";
  private static final int FuN = 10;
  private static final int FuO = 20;
  private static final int FuP = 30;
  private static final String FuQ = "@__weixinstory";
  private static final String FuR = "@__weixinhistory";
  private static final int FuS = 1;
  private static final int FuT = 2;
  private static final int FuU = 2;
  private static final int FuV = 311;
  private static final int FuW = 314;
  private static final int FuX = 315;
  private static final int FuY = 317;
  private static final int FuZ = 323;
  private static final int FvA = 5;
  private static final int FvB = 7;
  private static final int FvC = 54;
  public static final a FvD;
  private static final int Fva = 324;
  private static final int Fvb = 1;
  private static final int Fvc = 2;
  private static final int Fvd = 4;
  private static final int Fve = 5;
  private static final int Fvf = 1;
  private static final int Fvg = 2;
  private static final int Fvh = 1;
  private static final int Fvi = 2;
  private static final int Fvj = 3;
  private static final int Fvk = 4;
  private static final int Fvl = 5;
  private static final int Fvm = 6;
  private static final int Fvn = 14400;
  private static final int Fvo = 86400;
  private static final int Fvp = 100;
  private static final long Fvq = 1L;
  private static final long Fvr = 2L;
  private static final int Fvs = 9;
  private static final int Fvt = 4;
  private static final int Fvu = 8;
  private static final float Fvv = 1.78F;
  private static final float Fvw = 2.18F;
  private static final int Fvx = 3;
  private static final int Fvy = 0;
  private static final int Fvz = 1;
  
  static
  {
    AppMethodBeat.i(119474);
    FvD = new a((byte)0);
    FuJ = 4;
    FuK = 8;
    FuL = 16;
    FuM = "story_table_";
    FuN = 10;
    FuO = 20;
    FuP = 30;
    FuQ = "@__weixinstory";
    FuR = "@__weixinhistory";
    FuS = 1;
    FuT = 2;
    FuU = 2;
    FuV = 311;
    FuW = 314;
    FuX = 315;
    FuY = 317;
    FuZ = 323;
    Fva = 324;
    Fvb = 1;
    Fvc = 2;
    Fvd = 4;
    Fve = 5;
    Fvf = 1;
    Fvg = 2;
    Fvh = 1;
    Fvi = 2;
    Fvj = 3;
    Fvk = 4;
    Fvl = 5;
    Fvm = 6;
    Fvn = 14400;
    Fvo = 86400;
    Fvp = 100;
    Fvq = 1L;
    Fvr = 2L;
    Fvs = 9;
    Fvt = 4;
    Fvu = 8;
    Fvv = 1.78F;
    Fvw = 2.18F;
    Fvx = 3;
    Fvz = 1;
    FvA = 5;
    FvB = 7;
    FvC = 54;
    AppMethodBeat.o(119474);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$Companion;", "", "()V", "DEFAULT_AUDIO_COUNT", "", "EDITOR_SAFE_AREA_DEFAULT_DAMPING", "getEDITOR_SAFE_AREA_DEFAULT_DAMPING", "()I", "ERR_LOCAL_MEDIA_DB_NOT_E", "getERR_LOCAL_MEDIA_DB_NOT_E", "ERR_NOT_WITH_ARG", "getERR_NOT_WITH_ARG", "ERR_PARSER_ERROR", "getERR_PARSER_ERROR", "ERR_PULL_XML", "getERR_PULL_XML", "ERR_TIMELINE_NULL", "getERR_TIMELINE_NULL", "ERR_TLE", "getERR_TLE", "FAV_COUNT", "getFAV_COUNT", "HISTORY_COUNT", "getHISTORY_COUNT", "HISTORY_NAME", "", "getHISTORY_NAME", "()Ljava/lang/String;", "LOCAL_FLAG_MP4_OPT", "MAX_FAULT_NUM", "getMAX_FAULT_NUM", "MAX_FAVORITE_COUNT", "getMAX_FAVORITE_COUNT", "MAX_SAFE_AREA_SCALE", "", "getMAX_SAFE_AREA_SCALE", "()F", "MIN_SAFE_AREA_SCALE", "getMIN_SAFE_AREA_SCALE", "MIN_THREAD_NUM", "getMIN_THREAD_NUM", "MMSTORY_MENU_ITEM_ID_DEL", "getMMSTORY_MENU_ITEM_ID_DEL", "MMSTORY_MENU_ITEM_ID_RESEND", "getMMSTORY_MENU_ITEM_ID_RESEND", "MMSTORY_OBJ_OP_DEL_COMMENT_TYPE", "getMMSTORY_OBJ_OP_DEL_COMMENT_TYPE", "MMSTORY_OBJ_OP_DEL_OBJ_TYPE", "getMMSTORY_OBJ_OP_DEL_OBJ_TYPE", "MMSTORY_OBJ_OP_FAV_TYPE", "getMMSTORY_OBJ_OP_FAV_TYPE", "MMSTORY_OBJ_OP_VISIBILITY_TYPE", "getMMSTORY_OBJ_OP_VISIBILITY_TYPE", "MMSTORY_RET_EMPTY", "getMMSTORY_RET_EMPTY", "MMSTORY_RET_ERR_WITH_MSG", "getMMSTORY_RET_ERR_WITH_MSG", "MMSTORY_RET_NO_MORE_DATA", "getMMSTORY_RET_NO_MORE_DATA", "MMSTORY_RET_POST_DUPLICATE_ERR", "getMMSTORY_RET_POST_DUPLICATE_ERR", "MMSTORY_RET_SAME_MD5", "getMMSTORY_RET_SAME_MD5", "MMSTORY_RET_SET_FAV_OVERSIZE_ERR", "getMMSTORY_RET_SET_FAV_OVERSIZE_ERR", "MMSTORY_URL_CDN", "getMMSTORY_URL_CDN", "MMSTORY_URL_OTHER", "getMMSTORY_URL_OTHER", "MMSTORY_URL_WEIXIN", "getMMSTORY_URL_WEIXIN", "STORY_DIED_TIMS_SECOND", "getSTORY_DIED_TIMS_SECOND", "STORY_ITEM_FAVORITE_FLAG", "getSTORY_ITEM_FAVORITE_FLAG", "STORY_ITEM_VISIABLE_ONLY_SELF_FLAG", "getSTORY_ITEM_VISIABLE_ONLY_SELF_FLAG", "STORY_NAME", "getSTORY_NAME", "STORY_RPT_15615_SCENE", "getSTORY_RPT_15615_SCENE", "STORY_RPT_SEND_SOURCE_CAPTURE", "", "getSTORY_RPT_SEND_SOURCE_CAPTURE", "()J", "STORY_RPT_SEND_SOURCE_LOCAL", "getSTORY_RPT_SEND_SOURCE_LOCAL", "STORY_SOURCE_ALBUM_HISTORY", "getSTORY_SOURCE_ALBUM_HISTORY", "STORY_SOURCE_USERPAGE_OTHERS", "getSTORY_SOURCE_USERPAGE_OTHERS", "STORY_SOURCE_USERPAGE_SELF", "getSTORY_SOURCE_USERPAGE_SELF", "STORY_TRY_TIMS_SECOND", "getSTORY_TRY_TIMS_SECOND", "TABLE_STORY", "getTABLE_STORY", "USERPAGE_COUNT", "getUSERPAGE_COUNT", "USER_PAGE_SOURCE_FAV", "getUSER_PAGE_SOURCE_FAV", "USER_PAGE_SOURCE_HISTORY", "getUSER_PAGE_SOURCE_HISTORY", "USER_PAGE_SOURCE_PROFILE", "getUSER_PAGE_SOURCE_PROFILE", "USER_PAGE_SOURCE_SELECT_FAV", "getUSER_PAGE_SOURCE_SELECT_FAV", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryCommentSyncFlag;", "", "()V", "STORY_COMMENT_SYNC_FLAG_UNREAD", "", "getSTORY_COMMENT_SYNC_FLAG_UNREAD", "()I", "plugin-story_release"})
  public static final class b
  {
    private static final int FvE = 1;
    public static final b FvF;
    
    static
    {
      AppMethodBeat.i(119468);
      FvF = new b();
      FvE = 1;
      AppMethodBeat.o(119468);
    }
    
    public static int frk()
    {
      return FvE;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryInfoLocalFlag;", "", "()V", "LOCAL_FLAG_SHOW_INDICATOR", "", "getLOCAL_FLAG_SHOW_INDICATOR", "()I", "LOCAL_FLAG_STATE_MIX", "getLOCAL_FLAG_STATE_MIX", "LOCAL_FLAG_STATE_WAITING", "getLOCAL_FLAG_STATE_WAITING", "LOCAL_POST_STATE_DIE", "getLOCAL_POST_STATE_DIE", "plugin-story_release"})
  public static final class d
  {
    private static final int FvI = 2;
    private static final int FvJ = 4;
    private static final int FvK = 8;
    private static final int FvL = 16;
    public static final d FvM;
    
    static
    {
      AppMethodBeat.i(119470);
      FvM = new d();
      FvI = 2;
      FvJ = 4;
      FvK = 8;
      FvL = 16;
      AppMethodBeat.o(119470);
    }
    
    public static int frm()
    {
      return FvI;
    }
    
    public static int frn()
    {
      return FvJ;
    }
    
    public static int fro()
    {
      return FvK;
    }
    
    public static int frp()
    {
      return FvL;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryMsgType;", "", "()V", "STORY_VISIT_FLAG", "", "getSTORY_VISIT_FLAG", "()I", "plugin-story_release"})
  public static final class e
  {
    private static final int FvN = 4;
    public static final e FvO;
    
    static
    {
      AppMethodBeat.i(119471);
      FvO = new e();
      FvN = 4;
      AppMethodBeat.o(119471);
    }
    
    public static int frq()
    {
      return FvN;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$StoryRangeDatailUI;", "", "()V", "KEY_STORY_LOCAL_ID", "", "getKEY_STORY_LOCAL_ID", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class f
  {
    private static final String FvP = "key_story_local_id";
    public static final f FvQ;
    
    static
    {
      AppMethodBeat.i(119472);
      FvQ = new f();
      FvP = "key_story_local_id";
      AppMethodBeat.o(119472);
    }
    
    public static String frr()
    {
      return FvP;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/ConstantsStory$UploadStatus;", "", "()V", "STORY_STATE_ERROR", "", "getSTORY_STATE_ERROR", "()I", "STORY_STATE_FINISH", "getSTORY_STATE_FINISH", "STORY_STATE_WAITTING", "getSTORY_STATE_WAITTING", "plugin-story_release"})
  public static final class g
  {
    private static final int FvR = 1;
    private static final int FvS = 2;
    private static final int FvT = 3;
    public static final g FvU;
    
    static
    {
      AppMethodBeat.i(119473);
      FvU = new g();
      FvR = 1;
      FvS = 2;
      FvT = 3;
      AppMethodBeat.o(119473);
    }
    
    public static int frs()
    {
      return FvR;
    }
    
    public static int frt()
    {
      return FvS;
    }
    
    public static int fru()
    {
      return FvT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.a
 * JD-Core Version:    0.7.0.1
 */