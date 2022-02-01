package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.g.c.dt;
import com.tencent.mm.model.ce;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryInfo;", "()V", "blackList", "", "", "getBlackList", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "date", "getDate", "setDate", "groupList", "getGroupList", "setGroupList", "localId", "getLocalId", "setLocalId", "readCount", "getReadCount", "setReadCount", "", "showIndicator", "getShowIndicator", "()Z", "setShowIndicator", "(Z)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "type", "getType", "setType", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "addSourceFlag", "", "mmsourceType", "addStoryItemFlag", "storyItemFlag", "checkFavorite", "checkNotifySns", "checkVisiableSelfOnly", "cleanPostFinish", "clearItemDie", "convertFrom", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "getTimeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "isDeprecated", "isDeprecatedForFav", "isItemDie", "isItemFinish", "isReadStatus", "isTimeLimit", "tryCount", "startTime", "isUnreadStatus", "removeSourceFlag", "removeStoryItemFlag", "setContent", "contentObj", "setItemDie", "setPostBuf", "postBuf", "", "setPostFinish", "setPostMixFinish", "setPostMixWaiting", "setPostWaiting", "setReadStatus", "setTimeLine", "timeline", "setUnreadStatus", "Companion", "plugin-story_release"})
public final class j
  extends dt
{
  private static final String COL_ROWID = "rowid";
  private static final String TAG = "MicroMsg.StoryInfo";
  private static final c.a info;
  private static final String qKh = "serverStoryNameIndex";
  private static final String ype = "serverStoryNameTimeIndex";
  private static final String ypf = "serverStoryUsernameCreateTimeIndex";
  public static final a ypg;
  public int dzf;
  private List<String> xTb;
  private List<String> yct;
  public int ypd;
  
  static
  {
    AppMethodBeat.i(119550);
    ypg = new a((byte)0);
    TAG = "MicroMsg.StoryInfo";
    info = dt.So();
    COL_ROWID = "rowid";
    qKh = "serverStoryNameIndex";
    ype = "serverStoryNameTimeIndex";
    ypf = "serverStoryUsernameCreateTimeIndex";
    AppMethodBeat.o(119550);
  }
  
  public j()
  {
    AppMethodBeat.i(119549);
    this.xTb = ((List)new ArrayList());
    this.yct = ((List)new ArrayList());
    AppMethodBeat.o(119549);
  }
  
  public static boolean ay(int paramInt, long paramLong)
  {
    boolean bool4 = true;
    AppMethodBeat.i(119547);
    if (ab.hWJ)
    {
      ad.i(TAG, "Android Test time limit fail " + ab.hWJ);
      AppMethodBeat.o(119547);
      return true;
    }
    int i = ce.asT();
    int j = (int)paramLong;
    a.a locala = a.yor;
    boolean bool1;
    boolean bool2;
    if (i - j > a.dKf())
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
        ad.i(TAG, "isTimeLimit " + bool1 + "  " + bool2 + " tryCount:" + paramInt + " startTime " + paramLong + "  svr: " + ce.asT());
      }
      AppMethodBeat.o(119547);
      return bool3;
      bool1 = false;
      break;
      bool2 = false;
      break label79;
    }
  }
  
  public final void MY(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final void OG(int paramInt)
  {
    this.field_itemStoryFlag |= paramInt;
  }
  
  public final void OH(int paramInt)
  {
    this.field_itemStoryFlag &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final List<String> abP()
  {
    AppMethodBeat.i(119530);
    Object localObject1 = new cyt();
    Object localObject2 = (com.tencent.mm.bx.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((cyt)localObject1).GroupUser;
      if ((localObject3 == null) || (((Collection)localObject3).isEmpty()))
      {
        i = 1;
        if (i == 0) {
          break label113;
        }
        localObject1 = (List)new ArrayList();
        AppMethodBeat.o(119530);
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
        continue;
        int i = 0;
      }
      label113:
      localObject1 = ((cyt)localObject1).GroupUser;
      k.g(localObject1, "storyObj.GroupUser");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (cmf)((Iterator)localObject1).next();
        k.g(localObject3, "it");
        localException.add(((cmf)localObject3).getString());
      }
      localObject1 = (List)localException;
      AppMethodBeat.o(119530);
    }
    return localObject1;
  }
  
  public final void b(czd paramczd)
  {
    AppMethodBeat.i(119537);
    k.h(paramczd, "timeline");
    try
    {
      this.field_content = paramczd.toByteArray();
      AppMethodBeat.o(119537);
      return;
    }
    catch (Exception paramczd)
    {
      ad.printErrStackTrace(TAG, (Throwable)paramczd, "", new Object[0]);
      AppMethodBeat.o(119537);
    }
  }
  
  public final void bE(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(119538);
    k.h(paramArrayOfByte, "postBuf");
    this.field_postBuf = paramArrayOfByte;
    AppMethodBeat.o(119538);
  }
  
  public final boolean c(czd paramczd)
  {
    AppMethodBeat.i(119543);
    k.h(paramczd, "contentObj");
    try
    {
      this.field_content = paramczd.toByteArray();
      AppMethodBeat.o(119543);
      return true;
    }
    catch (Exception paramczd)
    {
      ad.printErrStackTrace(TAG, (Throwable)paramczd, "", new Object[0]);
      AppMethodBeat.o(119543);
    }
    return false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(119535);
    k.h(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.dzf = ((int)this.systemRowid);
    paramCursor = com.tencent.mm.plugin.story.e.a.yef;
    this.ypd = com.tencent.mm.plugin.story.e.a.a.tE(this.field_createTime * 1000L);
    AppMethodBeat.o(119535);
  }
  
  public final List<String> dKF()
  {
    AppMethodBeat.i(119531);
    Object localObject1 = new cyt();
    Object localObject2 = (com.tencent.mm.bx.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((cyt)localObject1).BlackList;
      if ((localObject3 == null) || (((Collection)localObject3).isEmpty()))
      {
        i = 1;
        if (i == 0) {
          break label115;
        }
        localObject1 = (List)new ArrayList();
        AppMethodBeat.o(119531);
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
        continue;
        int i = 0;
      }
      label115:
      localObject1 = ((cyt)localObject1).BlackList;
      k.g(localObject1, "storyObj.BlackList");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (cmf)((Iterator)localObject1).next();
        k.g(localObject3, "it");
        localException.add(((cmf)localObject3).getString());
      }
      localObject1 = (List)localException;
      AppMethodBeat.o(119531);
    }
    return localObject1;
  }
  
  public final boolean dKG()
  {
    AppMethodBeat.i(119532);
    int i = this.field_localFlag;
    a.d locald = a.d.yoA;
    boolean bool = c.cQ(i, a.d.dKq());
    AppMethodBeat.o(119532);
    return bool;
  }
  
  public final czd dKH()
  {
    AppMethodBeat.i(119536);
    Object localObject1;
    if (this.field_content == null)
    {
      localObject1 = q.yfy;
      localObject1 = q.a.dHx();
      AppMethodBeat.o(119536);
      return localObject1;
    }
    try
    {
      localObject1 = new czd().parseFrom(this.field_content);
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryTimelineObject");
        AppMethodBeat.o(119536);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      ad.e(TAG, "error get storyinfo timeline!");
      localObject2 = q.yfy;
      localObject2 = q.a.dHx();
      AppMethodBeat.o(119536);
      return localObject2;
    }
    Object localObject2 = (czd)localObject2;
    AppMethodBeat.o(119536);
    return localObject2;
  }
  
  public final boolean dKI()
  {
    AppMethodBeat.i(119542);
    int i = this.field_localFlag;
    a.d locald = a.d.yoA;
    if ((i & a.d.dKo()) != 0)
    {
      AppMethodBeat.o(119542);
      return true;
    }
    AppMethodBeat.o(119542);
    return false;
  }
  
  public final cyn dKJ()
  {
    AppMethodBeat.i(119544);
    Object localObject = new cyn();
    if (this.field_postBuf == null)
    {
      AppMethodBeat.o(119544);
      return localObject;
    }
    try
    {
      localObject = new cyn().parseFrom(this.field_postBuf);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
        AppMethodBeat.o(119544);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      ad.e(TAG, "error get StoryMediaPostInfo " + this.field_storyID);
      localcyn = new cyn();
      AppMethodBeat.o(119544);
      return localcyn;
    }
    cyn localcyn = (cyn)localcyn;
    AppMethodBeat.o(119544);
    return localcyn;
  }
  
  public final boolean dKK()
  {
    AppMethodBeat.i(119545);
    int i = this.field_itemStoryFlag;
    a.a locala = a.yor;
    boolean bool = c.cQ(i, a.dKg());
    AppMethodBeat.o(119545);
    return bool;
  }
  
  public final boolean dKL()
  {
    AppMethodBeat.i(119546);
    int i = this.field_itemStoryFlag;
    a.a locala = a.yor;
    boolean bool = c.cQ(i, a.dKh());
    AppMethodBeat.o(119546);
    return bool;
  }
  
  public final boolean dKM()
  {
    AppMethodBeat.i(119548);
    int i = this.field_createTime;
    int j = ce.asT();
    i.a locala = i.yeK;
    if (i <= j - i.dGU())
    {
      AppMethodBeat.o(119548);
      return true;
    }
    AppMethodBeat.o(119548);
    return false;
  }
  
  public final void dya()
  {
    AppMethodBeat.i(119541);
    int i = this.field_localFlag;
    a.d locald = a.d.yoA;
    this.field_localFlag = (i & (a.d.dKo() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119541);
  }
  
  public final void dyb()
  {
    AppMethodBeat.i(119540);
    int i = this.field_localFlag;
    a.d locald = a.d.yoA;
    this.field_localFlag = (i | a.d.dKo());
    AppMethodBeat.o(119540);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(119534);
    c.a locala = info;
    k.g(locala, "info");
    AppMethodBeat.o(119534);
    return locala;
  }
  
  public final void qR(boolean paramBoolean)
  {
    AppMethodBeat.i(119533);
    int i;
    a.d locald;
    if (paramBoolean)
    {
      i = this.field_localFlag;
      locald = a.d.yoA;
      i |= a.d.dKq();
    }
    for (;;)
    {
      this.field_localFlag = i;
      AppMethodBeat.o(119533);
      return;
      i = this.field_localFlag;
      locald = a.d.yoA;
      i &= (a.d.dKq() ^ 0xFFFFFFFF);
    }
  }
  
  public final void setPostWaiting()
  {
    AppMethodBeat.i(119539);
    int i = this.field_localFlag;
    a.d locald = a.d.yoA;
    this.field_localFlag = (i | a.d.dKn());
    AppMethodBeat.o(119539);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/StoryInfo$Companion;", "", "()V", "COL_ROWID", "", "getCOL_ROWID", "()Ljava/lang/String;", "TABLEINDEXUSERNAME", "getTABLEINDEXUSERNAME", "TAG", "getTAG", "TableIndexUsernameCreateTime", "getTableIndexUsernameCreateTime", "TableIndexUsernameTime", "getTableIndexUsernameTime", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.j
 * JD-Core Version:    0.7.0.1
 */