package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gs;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/autogen/table/BaseStoryExtItem;", "()V", "value", "", "duration", "getDuration", "()J", "setDuration", "(J)V", "interactTime", "getInteractTime", "setInteractTime", "isContact", "", "()Ljava/lang/Boolean;", "setContact", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "localId", "", "getLocalId", "()I", "setLocalId", "(I)V", "oneDayCount", "getOneDayCount", "setOneDayCount", "postTime", "getPostTime", "setPostTime", "preLoadCache", "getPreLoadCache", "setPreLoadCache", "", "preloadMediaId", "getPreloadMediaId", "()Ljava/lang/String;", "setPreloadMediaId", "(Ljava/lang/String;)V", "preloadStoryId", "getPreloadStoryId", "setPreloadStoryId", "readId", "getReadId", "setReadId", "readTime", "getReadTime", "setReadTime", "syncId", "getSyncId", "setSyncId", "thumbUrl", "getThumbUrl", "setThumbUrl", "updateTime", "getUpdateTime", "setUpdateTime", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "userInfo", "getUserInfo", "()Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "setUserInfo", "(Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;)V", "userName", "getUserName", "setUserName", "videoUrl", "getVideoUrl", "setVideoUrl", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hasUnread", "haslocalUnread", "isDeprecated", "isEmpty", "isFriendly", "isValid", "markPreloadCompleted", "storyId", "mediaId", "cacheSize", "resetPreLoad", "Companion", "plugin-story_release"})
public final class f
  extends gs
{
  private static final m<Long, Long, Boolean> Fwd;
  public static final a Fwe;
  private static final String TAG = "MicroMsg.StoryExtInfo";
  private static final IAutoDBItem.MAutoDBInfo info;
  private int ecf;
  
  static
  {
    AppMethodBeat.i(119500);
    Fwe = new a((byte)0);
    TAG = "MicroMsg.StoryExtInfo";
    info = gs.ajs();
    Fwd = (m)f.b.Fwf;
    AppMethodBeat.o(119500);
  }
  
  public f()
  {
    AppMethodBeat.i(119499);
    setUserName("");
    AppMethodBeat.o(119499);
  }
  
  public final String aBE()
  {
    String str2 = this.field_newThumbUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void aSs(String paramString)
  {
    AppMethodBeat.i(119492);
    p.h(paramString, "value");
    this.field_preloadMediaId = paramString;
    AppMethodBeat.o(119492);
  }
  
  public final boolean b(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(119494);
    p.h(paramString, "mediaId");
    if (paramLong == this.field_syncId)
    {
      this.field_preloadStoryId = paramLong;
      aSs(paramString);
      this.field_preLoadResource = paramInt;
      AppMethodBeat.o(119494);
      return true;
    }
    AppMethodBeat.o(119494);
    return false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(119495);
    p.h(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.ecf = ((int)this.systemRowid);
    AppMethodBeat.o(119495);
  }
  
  public final boolean frA()
  {
    AppMethodBeat.i(119496);
    if ((isValid()) && (((Boolean)Fwd.invoke(Long.valueOf(this.field_readId), Long.valueOf(this.field_syncId))).booleanValue()))
    {
      m localm = Fwd;
      j.b localb = j.Fmy;
      if (((Boolean)localm.invoke(Long.valueOf(j.b.fop()), Long.valueOf(this.field_updateTime))).booleanValue())
      {
        AppMethodBeat.o(119496);
        return true;
      }
    }
    AppMethodBeat.o(119496);
    return false;
  }
  
  public final String frx()
  {
    String str2 = this.field_newVideoUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final long fry()
  {
    if (this.field_preloadStoryId == this.field_syncId) {
      return this.field_preLoadResource;
    }
    return 0L;
  }
  
  public final eel frz()
  {
    AppMethodBeat.i(119493);
    Object localObject;
    if (this.field_userInfo == null)
    {
      localObject = new eel();
      AppMethodBeat.o(119493);
      return localObject;
    }
    eel localeel;
    try
    {
      localObject = new eel().parseFrom(this.field_userInfo);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserInfo");
        AppMethodBeat.o(119493);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.e(TAG, "error get storyUserInfo!");
      localeel = new eel();
    }
    for (;;)
    {
      AppMethodBeat.o(119493);
      return localeel;
      localeel = (eel)localeel;
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(119498);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.g(localMAutoDBInfo, "StoryExtInfo.info");
    AppMethodBeat.o(119498);
    return localMAutoDBInfo;
  }
  
  public final String getUserName()
  {
    AppMethodBeat.i(119490);
    String str = this.field_userName;
    p.g(str, "field_userName");
    AppMethodBeat.o(119490);
    return str;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(119497);
    if (this.field_syncId != 0L)
    {
      int i = this.field_storyPostTime;
      i.a locala = i.Fmb;
      if (i + i.fnT() >= cl.aWB())
      {
        AppMethodBeat.o(119497);
        return true;
      }
    }
    AppMethodBeat.o(119497);
    return false;
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(119491);
    p.h(paramString, "value");
    this.field_userName = paramString;
    AppMethodBeat.o(119491);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryExtInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "compareUnsignedLong", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "i", "j", "", "getCompareUnsignedLong", "()Lkotlin/jvm/functions/Function2;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.f
 * JD-Core Version:    0.7.0.1
 */