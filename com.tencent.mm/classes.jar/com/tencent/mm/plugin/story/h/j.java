package com.tencent.mm.plugin.story.h;

import a.l;
import a.v;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dc;
import com.tencent.mm.model.cb;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.story.e.b.a;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.model.i.a;
import com.tencent.mm.plugin.story.model.q;
import com.tencent.mm.plugin.story.model.q.a;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryInfo;", "()V", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "date", "getDate", "setDate", "localId", "getLocalId", "setLocalId", "readCount", "getReadCount", "setReadCount", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "type", "getType", "setType", "", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "addSourceFlag", "", "mmsourceType", "addStoryItemFlag", "storyItemFlag", "checkFavorite", "", "checkNotifySns", "checkVisiableSelfOnly", "cleanPostFinish", "clearItemDie", "convertFrom", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "getTimeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "isDeprecated", "isDeprecatedForFav", "isItemDie", "isItemFinish", "isReadStatus", "isTimeLimit", "tryCount", "startTime", "isUnreadStatus", "removeSourceFlag", "removeStoryItemFlag", "setContent", "contentObj", "setItemDie", "setPostBuf", "postBuf", "", "setPostFinish", "setPostMixFinish", "setPostMixWaiting", "setPostWaiting", "setReadStatus", "setTimeLine", "timeline", "setUnreadStatus", "Companion", "plugin-story_release"})
public final class j
  extends dc
{
  private static final String COL_ROWID = "rowid";
  private static final String TAG = "MicroMsg.StoryInfo";
  private static final c.a info;
  private static final String sGL = "serverStoryNameIndex";
  private static final String sGM = "serverStoryNameTimeIndex";
  private static final String sGN = "serverStoryUsernameCreateTimeIndex";
  public static final j.a sGO;
  public int cIp;
  public int sGK;
  
  static
  {
    AppMethodBeat.i(109928);
    sGO = new j.a((byte)0);
    TAG = "MicroMsg.StoryInfo";
    info = dc.Hm();
    COL_ROWID = "rowid";
    sGL = "serverStoryNameIndex";
    sGM = "serverStoryNameTimeIndex";
    sGN = "serverStoryUsernameCreateTimeIndex";
    AppMethodBeat.o(109928);
  }
  
  public static boolean ag(int paramInt, long paramLong)
  {
    boolean bool4 = true;
    AppMethodBeat.i(109926);
    if (ae.glM)
    {
      ab.i(TAG, "Android Test time limit fail " + ae.glM);
      AppMethodBeat.o(109926);
      return true;
    }
    int i = cb.abr();
    int j = (int)paramLong;
    a.a locala = a.sFV;
    boolean bool1;
    boolean bool2;
    if (i - j > a.cEm())
    {
      bool1 = true;
      if (paramInt <= 5) {
        break label178;
      }
      bool2 = true;
      label79:
      bool3 = bool4;
      if (!bool1) {
        if (!bool2) {
          break label184;
        }
      }
    }
    label178:
    label184:
    for (boolean bool3 = bool4;; bool3 = false)
    {
      if (bool3) {
        ab.i(TAG, "isTimeLimit " + bool1 + "  " + bool2 + " tryCount:" + paramInt + " startTime " + paramLong + "  svr: " + cb.abr());
      }
      AppMethodBeat.o(109926);
      return bool3;
      bool1 = false;
      break;
      bool2 = false;
      break label79;
    }
  }
  
  public final void Eu(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final void FZ(int paramInt)
  {
    this.field_itemStoryFlag |= paramInt;
  }
  
  public final void Ga(int paramInt)
  {
    this.field_itemStoryFlag &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final void b(cic paramcic)
  {
    AppMethodBeat.i(109916);
    a.f.b.j.q(paramcic, "timeline");
    try
    {
      this.field_content = paramcic.toByteArray();
      AppMethodBeat.o(109916);
      return;
    }
    catch (Exception paramcic)
    {
      ab.printErrStackTrace(TAG, (Throwable)paramcic, "", new Object[0]);
      AppMethodBeat.o(109916);
    }
  }
  
  public final void bl(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109917);
    a.f.b.j.q(paramArrayOfByte, "postBuf");
    this.field_postBuf = paramArrayOfByte;
    AppMethodBeat.o(109917);
  }
  
  public final boolean c(cic paramcic)
  {
    AppMethodBeat.i(109922);
    a.f.b.j.q(paramcic, "contentObj");
    try
    {
      this.field_content = paramcic.toByteArray();
      AppMethodBeat.o(109922);
      return true;
    }
    catch (Exception paramcic)
    {
      ab.printErrStackTrace(TAG, (Throwable)paramcic, "", new Object[0]);
      AppMethodBeat.o(109922);
    }
    return false;
  }
  
  public final cic cEY()
  {
    AppMethodBeat.i(109915);
    Object localObject1;
    if (this.field_content == null)
    {
      localObject1 = q.svz;
      localObject1 = q.a.cAY();
      AppMethodBeat.o(109915);
      return localObject1;
    }
    try
    {
      localObject1 = new cic().parseFrom(this.field_content);
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryTimelineObject");
        AppMethodBeat.o(109915);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      ab.e(TAG, "error get storyinfo timeline!");
      localObject2 = q.svz;
      localObject2 = q.a.cAY();
      AppMethodBeat.o(109915);
      return localObject2;
    }
    Object localObject2 = (cic)localObject2;
    AppMethodBeat.o(109915);
    return localObject2;
  }
  
  public final void cEZ()
  {
    AppMethodBeat.i(109918);
    int i = this.field_localFlag;
    a.d locald = a.d.sGd;
    this.field_localFlag = (i | a.d.cEy());
    AppMethodBeat.o(109918);
  }
  
  public final boolean cFa()
  {
    AppMethodBeat.i(109921);
    int i = this.field_localFlag;
    a.d locald = a.d.sGd;
    if ((i & a.d.cEz()) != 0)
    {
      AppMethodBeat.o(109921);
      return true;
    }
    AppMethodBeat.o(109921);
    return false;
  }
  
  public final chm cFb()
  {
    AppMethodBeat.i(109923);
    Object localObject = new chm();
    if (this.field_postBuf == null)
    {
      AppMethodBeat.o(109923);
      return localObject;
    }
    try
    {
      localObject = new chm().parseFrom(this.field_postBuf);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
        AppMethodBeat.o(109923);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      ab.e(TAG, "error get StoryMediaPostInfo " + this.field_storyID);
      localchm = new chm();
      AppMethodBeat.o(109923);
      return localchm;
    }
    chm localchm = (chm)localchm;
    AppMethodBeat.o(109923);
    return localchm;
  }
  
  public final boolean cFc()
  {
    AppMethodBeat.i(109924);
    int i = this.field_itemStoryFlag;
    a.a locala = a.sFV;
    boolean bool = com.tencent.mm.ab.b.ck(i, a.cEp());
    AppMethodBeat.o(109924);
    return bool;
  }
  
  public final boolean cFd()
  {
    AppMethodBeat.i(109925);
    int i = this.field_itemStoryFlag;
    a.a locala = a.sFV;
    boolean bool = com.tencent.mm.ab.b.ck(i, a.cEq());
    AppMethodBeat.o(109925);
    return bool;
  }
  
  public final boolean cFe()
  {
    AppMethodBeat.i(109927);
    int i = this.field_createTime;
    int j = cb.abr();
    i.a locala = i.suJ;
    if (i <= j - i.cAp())
    {
      AppMethodBeat.o(109927);
      return true;
    }
    AppMethodBeat.o(109927);
    return false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(109914);
    a.f.b.j.q(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.cIp = ((int)this.systemRowid);
    paramCursor = com.tencent.mm.plugin.story.e.b.ssx;
    this.sGK = b.a.mt(this.field_createTime * 1000L);
    AppMethodBeat.o(109914);
  }
  
  public final void csK()
  {
    AppMethodBeat.i(109920);
    int i = this.field_localFlag;
    a.d locald = a.d.sGd;
    this.field_localFlag = (i & (a.d.cEz() ^ 0xFFFFFFFF));
    AppMethodBeat.o(109920);
  }
  
  public final void csL()
  {
    AppMethodBeat.i(109919);
    int i = this.field_localFlag;
    a.d locald = a.d.sGd;
    this.field_localFlag = (i | a.d.cEz());
    AppMethodBeat.o(109919);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(109913);
    c.a locala = info;
    a.f.b.j.p(locala, "info");
    AppMethodBeat.o(109913);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.j
 * JD-Core Version:    0.7.0.1
 */