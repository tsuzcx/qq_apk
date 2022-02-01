package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gh;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/autogen/table/BaseStoryExtItem;", "()V", "value", "", "duration", "getDuration", "()J", "setDuration", "(J)V", "interactTime", "getInteractTime", "setInteractTime", "isContact", "", "()Ljava/lang/Boolean;", "setContact", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "localId", "", "getLocalId", "()I", "setLocalId", "(I)V", "oneDayCount", "getOneDayCount", "setOneDayCount", "postTime", "getPostTime", "setPostTime", "preLoadCache", "getPreLoadCache", "setPreLoadCache", "", "preloadMediaId", "getPreloadMediaId", "()Ljava/lang/String;", "setPreloadMediaId", "(Ljava/lang/String;)V", "preloadStoryId", "getPreloadStoryId", "setPreloadStoryId", "readId", "getReadId", "setReadId", "readTime", "getReadTime", "setReadTime", "syncId", "getSyncId", "setSyncId", "thumbUrl", "getThumbUrl", "setThumbUrl", "updateTime", "getUpdateTime", "setUpdateTime", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "userInfo", "getUserInfo", "()Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "setUserInfo", "(Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;)V", "userName", "getUserName", "setUserName", "videoUrl", "getVideoUrl", "setVideoUrl", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hasUnread", "haslocalUnread", "isDeprecated", "isEmpty", "isFriendly", "isValid", "markPreloadCompleted", "storyId", "mediaId", "cacheSize", "resetPreLoad", "Companion", "plugin-story_release"})
public final class f
  extends gh
{
  private static final m<Long, Long, Boolean> Bln;
  public static final f.a Blo;
  private static final String TAG = "MicroMsg.StoryExtInfo";
  private static final c.a info;
  private int dKr;
  
  static
  {
    AppMethodBeat.i(119500);
    Blo = new f.a((byte)0);
    TAG = "MicroMsg.StoryExtInfo";
    info = gh.VD();
    Bln = (m)f.b.Blp;
    AppMethodBeat.o(119500);
  }
  
  public f()
  {
    AppMethodBeat.i(119499);
    setUserName("");
    AppMethodBeat.o(119499);
  }
  
  public final boolean a(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(119494);
    p.h(paramString, "mediaId");
    if (paramLong == this.field_syncId)
    {
      this.field_preloadStoryId = paramLong;
      aDx(paramString);
      this.field_preLoadResource = paramInt;
      AppMethodBeat.o(119494);
      return true;
    }
    AppMethodBeat.o(119494);
    return false;
  }
  
  public final void aDx(String paramString)
  {
    AppMethodBeat.i(119492);
    p.h(paramString, "value");
    this.field_preloadMediaId = paramString;
    AppMethodBeat.o(119492);
  }
  
  public final String all()
  {
    String str2 = this.field_newThumbUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(119495);
    p.h(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.dKr = ((int)this.systemRowid);
    AppMethodBeat.o(119495);
  }
  
  public final String eoX()
  {
    String str2 = this.field_newVideoUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final long eoY()
  {
    if (this.field_preloadStoryId == this.field_syncId) {
      return this.field_preLoadResource;
    }
    return 0L;
  }
  
  public final dky eoZ()
  {
    AppMethodBeat.i(119493);
    Object localObject;
    if (this.field_userInfo == null)
    {
      localObject = new dky();
      AppMethodBeat.o(119493);
      return localObject;
    }
    dky localdky;
    try
    {
      localObject = new dky().parseFrom(this.field_userInfo);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserInfo");
        AppMethodBeat.o(119493);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      ae.e(TAG, "error get storyUserInfo!");
      localdky = new dky();
    }
    for (;;)
    {
      AppMethodBeat.o(119493);
      return localdky;
      localdky = (dky)localdky;
    }
  }
  
  public final boolean epa()
  {
    AppMethodBeat.i(119496);
    if ((isValid()) && (((Boolean)Bln.p(Long.valueOf(this.field_readId), Long.valueOf(this.field_syncId))).booleanValue()))
    {
      m localm = Bln;
      j.b localb = j.BbE;
      if (((Boolean)localm.p(Long.valueOf(j.b.elO()), Long.valueOf(this.field_updateTime))).booleanValue())
      {
        AppMethodBeat.o(119496);
        return true;
      }
    }
    AppMethodBeat.o(119496);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(119498);
    c.a locala = info;
    p.g(locala, "StoryExtInfo.info");
    AppMethodBeat.o(119498);
    return locala;
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
      i.a locala = i.Bbh;
      if (i + i.els() >= ch.aDd())
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.f
 * JD-Core Version:    0.7.0.1
 */