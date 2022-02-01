package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.c.es;
import com.tencent.mm.model.cm;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryInfo;", "()V", "blackList", "", "", "getBlackList", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "date", "getDate", "setDate", "groupList", "getGroupList", "setGroupList", "localId", "getLocalId", "setLocalId", "readCount", "getReadCount", "setReadCount", "", "showIndicator", "getShowIndicator", "()Z", "setShowIndicator", "(Z)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "type", "getType", "setType", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "addSourceFlag", "", "mmsourceType", "addStoryItemFlag", "storyItemFlag", "checkFavorite", "checkNotifySns", "checkVisiableSelfOnly", "cleanPostFinish", "clearItemDie", "convertFrom", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "getTimeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "isDeprecated", "isDeprecatedForFav", "isItemDie", "isItemFinish", "isReadStatus", "isTimeLimit", "tryCount", "startTime", "isUnreadStatus", "removeSourceFlag", "removeStoryItemFlag", "setContent", "contentObj", "setItemDie", "setPostBuf", "postBuf", "", "setPostFinish", "setPostMixFinish", "setPostMixWaiting", "setPostWaiting", "setReadStatus", "setTimeLine", "timeline", "setUnreadStatus", "Companion", "plugin-story_release"})
public final class j
  extends es
{
  private static final String COL_ROWID = "rowid";
  private static final String LQs = "serverStoryNameTimeIndex";
  private static final String LQt = "serverStoryUsernameCreateTimeIndex";
  public static final a LQu;
  private static final String TABLEINDEXUSERNAME = "serverStoryNameIndex";
  private static final String TAG = "MicroMsg.StoryInfo";
  private static final IAutoDBItem.MAutoDBInfo info;
  private List<String> Low;
  private List<String> Lyy;
  public int date;
  public int fWh;
  
  static
  {
    AppMethodBeat.i(119550);
    LQu = new a((byte)0);
    TAG = "MicroMsg.StoryInfo";
    info = es.aoY();
    COL_ROWID = "rowid";
    TABLEINDEXUSERNAME = "serverStoryNameIndex";
    LQs = "serverStoryNameTimeIndex";
    LQt = "serverStoryUsernameCreateTimeIndex";
    AppMethodBeat.o(119550);
  }
  
  public j()
  {
    AppMethodBeat.i(119549);
    this.Low = ((List)new ArrayList());
    this.Lyy = ((List)new ArrayList());
    AppMethodBeat.o(119549);
  }
  
  public static boolean isTimeLimit(int paramInt, long paramLong)
  {
    boolean bool4 = true;
    AppMethodBeat.i(119547);
    if (ac.mGT)
    {
      Log.i(TAG, "Android Test time limit fail " + ac.mGT);
      AppMethodBeat.o(119547);
      return true;
    }
    int i = cm.bfF();
    int j = (int)paramLong;
    a.a locala = a.LPG;
    boolean bool1;
    boolean bool2;
    if (i - j > a.gfA())
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
        Log.i(TAG, "isTimeLimit " + bool1 + "  " + bool2 + " tryCount:" + paramInt + " startTime " + paramLong + "  svr: " + cm.bfF());
      }
      AppMethodBeat.o(119547);
      return bool3;
      bool1 = false;
      break;
      bool2 = false;
      break label79;
    }
  }
  
  public final List<String> aCq()
  {
    AppMethodBeat.i(119530);
    Object localObject1 = new eob();
    Object localObject2 = (com.tencent.mm.cd.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.cd.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((eob)localObject1).GroupUser;
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
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        continue;
        int i = 0;
      }
      label113:
      localObject1 = ((eob)localObject1).GroupUser;
      p.j(localObject1, "storyObj.GroupUser");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (eaf)((Iterator)localObject1).next();
        p.j(localObject3, "it");
        localException.add(((eaf)localObject3).Ufy);
      }
      localObject1 = (List)localException;
      AppMethodBeat.o(119530);
    }
    return localObject1;
  }
  
  public final void addSourceFlag(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final void ait(int paramInt)
  {
    this.field_itemStoryFlag |= paramInt;
  }
  
  public final void aiu(int paramInt)
  {
    this.field_itemStoryFlag &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final void b(eol parameol)
  {
    AppMethodBeat.i(119537);
    p.k(parameol, "timeline");
    try
    {
      this.field_content = parameol.toByteArray();
      AppMethodBeat.o(119537);
      return;
    }
    catch (Exception parameol)
    {
      Log.printErrStackTrace(TAG, (Throwable)parameol, "", new Object[0]);
      AppMethodBeat.o(119537);
    }
  }
  
  public final boolean c(eol parameol)
  {
    AppMethodBeat.i(119543);
    p.k(parameol, "contentObj");
    try
    {
      this.field_content = parameol.toByteArray();
      AppMethodBeat.o(119543);
      return true;
    }
    catch (Exception parameol)
    {
      Log.printErrStackTrace(TAG, (Throwable)parameol, "", new Object[0]);
      AppMethodBeat.o(119543);
    }
    return false;
  }
  
  public final void clearItemDie()
  {
    AppMethodBeat.i(119541);
    int i = this.field_localFlag;
    a.d locald = a.d.LPP;
    this.field_localFlag = (i & (a.d.gfJ() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119541);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(119535);
    p.k(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.fWh = ((int)this.systemRowid);
    paramCursor = com.tencent.mm.plugin.story.e.a.LFy;
    this.date = com.tencent.mm.plugin.story.e.a.a.RC(this.field_createTime * 1000L);
    AppMethodBeat.o(119535);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(119534);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.j(localMAutoDBInfo, "info");
    AppMethodBeat.o(119534);
    return localMAutoDBInfo;
  }
  
  public final List<String> gga()
  {
    AppMethodBeat.i(119531);
    Object localObject1 = new eob();
    Object localObject2 = (com.tencent.mm.cd.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.cd.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((eob)localObject1).BlackList;
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
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        continue;
        int i = 0;
      }
      label115:
      localObject1 = ((eob)localObject1).BlackList;
      p.j(localObject1, "storyObj.BlackList");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (eaf)((Iterator)localObject1).next();
        p.j(localObject3, "it");
        localException.add(((eaf)localObject3).Ufy);
      }
      localObject1 = (List)localException;
      AppMethodBeat.o(119531);
    }
    return localObject1;
  }
  
  public final boolean ggb()
  {
    AppMethodBeat.i(119532);
    int i = this.field_localFlag;
    a.d locald = a.d.LPP;
    boolean bool = d.dr(i, a.d.gfL());
    AppMethodBeat.o(119532);
    return bool;
  }
  
  public final eol ggc()
  {
    AppMethodBeat.i(119536);
    Object localObject1;
    if (this.field_content == null)
    {
      localObject1 = q.LGQ;
      localObject1 = q.a.gcR();
      AppMethodBeat.o(119536);
      return localObject1;
    }
    try
    {
      localObject1 = new eol().parseFrom(this.field_content);
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryTimelineObject");
        AppMethodBeat.o(119536);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      Log.e(TAG, "error get storyinfo timeline!");
      localObject2 = q.LGQ;
      localObject2 = q.a.gcR();
      AppMethodBeat.o(119536);
      return localObject2;
    }
    Object localObject2 = (eol)localObject2;
    AppMethodBeat.o(119536);
    return localObject2;
  }
  
  public final boolean ggd()
  {
    AppMethodBeat.i(119542);
    int i = this.field_localFlag;
    a.d locald = a.d.LPP;
    if ((i & a.d.gfJ()) != 0)
    {
      AppMethodBeat.o(119542);
      return true;
    }
    AppMethodBeat.o(119542);
    return false;
  }
  
  public final env gge()
  {
    AppMethodBeat.i(119544);
    Object localObject = new env();
    if (this.field_postBuf == null)
    {
      AppMethodBeat.o(119544);
      return localObject;
    }
    try
    {
      localObject = new env().parseFrom(this.field_postBuf);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
        AppMethodBeat.o(119544);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.e(TAG, "error get StoryMediaPostInfo " + this.field_storyID);
      localenv = new env();
      AppMethodBeat.o(119544);
      return localenv;
    }
    env localenv = (env)localenv;
    AppMethodBeat.o(119544);
    return localenv;
  }
  
  public final boolean ggf()
  {
    AppMethodBeat.i(119545);
    int i = this.field_itemStoryFlag;
    a.a locala = a.LPG;
    boolean bool = d.dr(i, a.gfB());
    AppMethodBeat.o(119545);
    return bool;
  }
  
  public final boolean ggg()
  {
    AppMethodBeat.i(119546);
    int i = this.field_itemStoryFlag;
    a.a locala = a.LPG;
    boolean bool = d.dr(i, a.gfC());
    AppMethodBeat.o(119546);
    return bool;
  }
  
  public final boolean ggh()
  {
    AppMethodBeat.i(119548);
    int i = this.field_createTime;
    int j = cm.bfF();
    i.a locala = i.LGd;
    if (i <= j - i.gcn())
    {
      AppMethodBeat.o(119548);
      return true;
    }
    AppMethodBeat.o(119548);
    return false;
  }
  
  public final void setItemDie()
  {
    AppMethodBeat.i(119540);
    int i = this.field_localFlag;
    a.d locald = a.d.LPP;
    this.field_localFlag = (i | a.d.gfJ());
    AppMethodBeat.o(119540);
  }
  
  public final void setPostBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(119538);
    p.k(paramArrayOfByte, "postBuf");
    this.field_postBuf = paramArrayOfByte;
    AppMethodBeat.o(119538);
  }
  
  public final void setPostWaiting()
  {
    AppMethodBeat.i(119539);
    int i = this.field_localFlag;
    a.d locald = a.d.LPP;
    this.field_localFlag = (i | a.d.gfI());
    AppMethodBeat.o(119539);
  }
  
  public final void zB(boolean paramBoolean)
  {
    AppMethodBeat.i(119533);
    int i;
    a.d locald;
    if (paramBoolean)
    {
      i = this.field_localFlag;
      locald = a.d.LPP;
      i |= a.d.gfL();
    }
    for (;;)
    {
      this.field_localFlag = i;
      AppMethodBeat.o(119533);
      return;
      i = this.field_localFlag;
      locald = a.d.LPP;
      i &= (a.d.gfL() ^ 0xFFFFFFFF);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/StoryInfo$Companion;", "", "()V", "COL_ROWID", "", "getCOL_ROWID", "()Ljava/lang/String;", "TABLEINDEXUSERNAME", "getTABLEINDEXUSERNAME", "TAG", "getTAG", "TableIndexUsernameCreateTime", "getTableIndexUsernameCreateTime", "TableIndexUsernameTime", "getTableIndexUsernameTime", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.j
 * JD-Core Version:    0.7.0.1
 */