package com.tencent.mm.plugin.story.h;

import a.f.a.m;
import a.l;
import a.v;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ew;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.model.i.a;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/autogen/table/BaseStoryExtItem;", "()V", "value", "", "duration", "getDuration", "()J", "setDuration", "(J)V", "isContact", "", "()Ljava/lang/Boolean;", "setContact", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "localId", "", "getLocalId", "()I", "setLocalId", "(I)V", "oneDayCount", "getOneDayCount", "setOneDayCount", "postTime", "getPostTime", "setPostTime", "preLoadCache", "getPreLoadCache", "setPreLoadCache", "", "preloadMediaId", "getPreloadMediaId", "()Ljava/lang/String;", "setPreloadMediaId", "(Ljava/lang/String;)V", "preloadStoryId", "getPreloadStoryId", "setPreloadStoryId", "readId", "getReadId", "setReadId", "readTime", "getReadTime", "setReadTime", "syncId", "getSyncId", "setSyncId", "thumbUrl", "getThumbUrl", "setThumbUrl", "updateTime", "getUpdateTime", "setUpdateTime", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "userInfo", "getUserInfo", "()Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "setUserInfo", "(Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;)V", "userName", "getUserName", "setUserName", "videoUrl", "getVideoUrl", "setVideoUrl", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hasUnread", "isEmpty", "isValid", "markPreloadCompleted", "storyId", "mediaId", "cacheSize", "resetPreLoad", "Companion", "plugin-story_release"})
public final class f
  extends ew
{
  private static final String TAG = "MicroMsg.StoryExtInfo";
  private static final c.a info;
  private static final m<Long, Long, Boolean> sGx;
  public static final f.a sGy;
  private int cIp;
  
  static
  {
    AppMethodBeat.i(109882);
    sGy = new f.a((byte)0);
    TAG = "MicroMsg.StoryExtInfo";
    info = ew.Hm();
    sGx = (m)f.b.sGz;
    AppMethodBeat.o(109882);
  }
  
  public f()
  {
    AppMethodBeat.i(109881);
    setUserName("");
    AppMethodBeat.o(109881);
  }
  
  public final void ady(String paramString)
  {
    AppMethodBeat.i(109874);
    a.f.b.j.q(paramString, "value");
    this.field_preloadMediaId = paramString;
    AppMethodBeat.o(109874);
  }
  
  public final boolean c(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(109876);
    a.f.b.j.q(paramString, "mediaId");
    if (paramLong == this.field_syncId)
    {
      this.field_preloadStoryId = paramLong;
      ady(paramString);
      this.field_preLoadResource = paramInt;
      AppMethodBeat.o(109876);
      return true;
    }
    AppMethodBeat.o(109876);
    return false;
  }
  
  public final String cEQ()
  {
    String str2 = this.field_newVideoUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cER()
  {
    String str2 = this.field_newThumbUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final long cES()
  {
    if (this.field_preloadStoryId == this.field_syncId) {
      return this.field_preLoadResource;
    }
    return 0L;
  }
  
  public final cid cET()
  {
    AppMethodBeat.i(109875);
    Object localObject;
    if (this.field_userInfo == null)
    {
      localObject = new cid();
      AppMethodBeat.o(109875);
      return localObject;
    }
    cid localcid;
    try
    {
      localObject = new cid().parseFrom(this.field_userInfo);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserInfo");
        AppMethodBeat.o(109875);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      ab.e(TAG, "error get storyUserInfo!");
      localcid = new cid();
    }
    for (;;)
    {
      AppMethodBeat.o(109875);
      return localcid;
      localcid = (cid)localcid;
    }
  }
  
  public final boolean cEU()
  {
    AppMethodBeat.i(109878);
    if ((isValid()) && (((Boolean)sGx.h(Long.valueOf(this.field_readId), Long.valueOf(this.field_syncId))).booleanValue()))
    {
      m localm = sGx;
      j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      if (((Boolean)localm.h(Long.valueOf(j.b.cAP()), Long.valueOf(this.field_updateTime))).booleanValue())
      {
        AppMethodBeat.o(109878);
        return true;
      }
    }
    AppMethodBeat.o(109878);
    return false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(109877);
    a.f.b.j.q(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.cIp = ((int)this.systemRowid);
    AppMethodBeat.o(109877);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(109880);
    c.a locala = info;
    a.f.b.j.p(locala, "StoryExtInfo.info");
    AppMethodBeat.o(109880);
    return locala;
  }
  
  public final String getUserName()
  {
    AppMethodBeat.i(109872);
    String str = this.field_userName;
    a.f.b.j.p(str, "field_userName");
    AppMethodBeat.o(109872);
    return str;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(109879);
    if (this.field_syncId != 0L)
    {
      int i = this.field_storyPostTime;
      i.a locala = i.suJ;
      if (i + i.cAp() >= cb.abr())
      {
        AppMethodBeat.o(109879);
        return true;
      }
    }
    AppMethodBeat.o(109879);
    return false;
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(109873);
    a.f.b.j.q(paramString, "value");
    this.field_userName = paramString;
    AppMethodBeat.o(109873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.f
 * JD-Core Version:    0.7.0.1
 */