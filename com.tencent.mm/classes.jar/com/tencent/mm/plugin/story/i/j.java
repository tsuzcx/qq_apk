package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.en;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryInfo;", "()V", "blackList", "", "", "getBlackList", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "date", "getDate", "setDate", "groupList", "getGroupList", "setGroupList", "localId", "getLocalId", "setLocalId", "readCount", "getReadCount", "setReadCount", "", "showIndicator", "getShowIndicator", "()Z", "setShowIndicator", "(Z)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "type", "getType", "setType", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "addSourceFlag", "", "mmsourceType", "addStoryItemFlag", "storyItemFlag", "checkFavorite", "checkNotifySns", "checkVisiableSelfOnly", "cleanPostFinish", "clearItemDie", "convertFrom", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "getTimeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "isDeprecated", "isDeprecatedForFav", "isItemDie", "isItemFinish", "isReadStatus", "isTimeLimit", "tryCount", "startTime", "isUnreadStatus", "removeSourceFlag", "removeStoryItemFlag", "setContent", "contentObj", "setItemDie", "setPostBuf", "postBuf", "", "setPostFinish", "setPostMixFinish", "setPostMixWaiting", "setPostWaiting", "setReadStatus", "setTimeLine", "timeline", "setUnreadStatus", "Companion", "plugin-story_release"})
public final class j
  extends en
{
  private static final String COL_ROWID = "rowid";
  private static final String Fwq = "serverStoryNameTimeIndex";
  private static final String Fwr = "serverStoryUsernameCreateTimeIndex";
  public static final a Fws;
  private static final String TABLEINDEXUSERNAME = "serverStoryNameIndex";
  private static final String TAG = "MicroMsg.StoryInfo";
  private static final IAutoDBItem.MAutoDBInfo info;
  private List<String> EZY;
  private List<String> FjN;
  public int Fwp;
  public int ecf;
  
  static
  {
    AppMethodBeat.i(119550);
    Fws = new a((byte)0);
    TAG = "MicroMsg.StoryInfo";
    info = en.ajs();
    COL_ROWID = "rowid";
    TABLEINDEXUSERNAME = "serverStoryNameIndex";
    Fwq = "serverStoryNameTimeIndex";
    Fwr = "serverStoryUsernameCreateTimeIndex";
    AppMethodBeat.o(119550);
  }
  
  public j()
  {
    AppMethodBeat.i(119549);
    this.EZY = ((List)new ArrayList());
    this.FjN = ((List)new ArrayList());
    AppMethodBeat.o(119549);
  }
  
  public static boolean isTimeLimit(int paramInt, long paramLong)
  {
    boolean bool4 = true;
    AppMethodBeat.i(119547);
    if (ac.jPJ)
    {
      Log.i(TAG, "Android Test time limit fail " + ac.jPJ);
      AppMethodBeat.o(119547);
      return true;
    }
    int i = cl.aWB();
    int j = (int)paramLong;
    a.a locala = a.FvD;
    boolean bool1;
    boolean bool2;
    if (i - j > a.fre())
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
        Log.i(TAG, "isTimeLimit " + bool1 + "  " + bool2 + " tryCount:" + paramInt + " startTime " + paramLong + "  svr: " + cl.aWB());
      }
      AppMethodBeat.o(119547);
      return bool3;
      bool1 = false;
      break;
      bool2 = false;
      break label79;
    }
  }
  
  public final void aaY(int paramInt)
  {
    this.field_itemStoryFlag |= paramInt;
  }
  
  public final void aaZ(int paramInt)
  {
    this.field_itemStoryFlag &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final void addSourceFlag(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final List<String> avv()
  {
    AppMethodBeat.i(119530);
    Object localObject1 = new eea();
    Object localObject2 = (com.tencent.mm.bw.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((eea)localObject1).GroupUser;
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
      localObject1 = ((eea)localObject1).GroupUser;
      p.g(localObject1, "storyObj.GroupUser");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (dqi)((Iterator)localObject1).next();
        p.g(localObject3, "it");
        localException.add(((dqi)localObject3).MTo);
      }
      localObject1 = (List)localException;
      AppMethodBeat.o(119530);
    }
    return localObject1;
  }
  
  public final void b(eek parameek)
  {
    AppMethodBeat.i(119537);
    p.h(parameek, "timeline");
    try
    {
      this.field_content = parameek.toByteArray();
      AppMethodBeat.o(119537);
      return;
    }
    catch (Exception parameek)
    {
      Log.printErrStackTrace(TAG, (Throwable)parameek, "", new Object[0]);
      AppMethodBeat.o(119537);
    }
  }
  
  public final boolean c(eek parameek)
  {
    AppMethodBeat.i(119543);
    p.h(parameek, "contentObj");
    try
    {
      this.field_content = parameek.toByteArray();
      AppMethodBeat.o(119543);
      return true;
    }
    catch (Exception parameek)
    {
      Log.printErrStackTrace(TAG, (Throwable)parameek, "", new Object[0]);
      AppMethodBeat.o(119543);
    }
    return false;
  }
  
  public final void clearItemDie()
  {
    AppMethodBeat.i(119541);
    int i = this.field_localFlag;
    a.d locald = a.d.FvM;
    this.field_localFlag = (i & (a.d.frn() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119541);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(119535);
    p.h(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.ecf = ((int)this.systemRowid);
    paramCursor = com.tencent.mm.plugin.story.e.a.Flw;
    this.Fwp = com.tencent.mm.plugin.story.e.a.a.Ki(this.field_createTime * 1000L);
    AppMethodBeat.o(119535);
  }
  
  public final List<String> frE()
  {
    AppMethodBeat.i(119531);
    Object localObject1 = new eea();
    Object localObject2 = (com.tencent.mm.bw.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((eea)localObject1).BlackList;
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
      localObject1 = ((eea)localObject1).BlackList;
      p.g(localObject1, "storyObj.BlackList");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (dqi)((Iterator)localObject1).next();
        p.g(localObject3, "it");
        localException.add(((dqi)localObject3).MTo);
      }
      localObject1 = (List)localException;
      AppMethodBeat.o(119531);
    }
    return localObject1;
  }
  
  public final boolean frF()
  {
    AppMethodBeat.i(119532);
    int i = this.field_localFlag;
    a.d locald = a.d.FvM;
    boolean bool = d.cW(i, a.d.frp());
    AppMethodBeat.o(119532);
    return bool;
  }
  
  public final eek frG()
  {
    AppMethodBeat.i(119536);
    Object localObject1;
    if (this.field_content == null)
    {
      localObject1 = q.FmO;
      localObject1 = q.a.fox();
      AppMethodBeat.o(119536);
      return localObject1;
    }
    try
    {
      localObject1 = new eek().parseFrom(this.field_content);
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
      localObject2 = q.FmO;
      localObject2 = q.a.fox();
      AppMethodBeat.o(119536);
      return localObject2;
    }
    Object localObject2 = (eek)localObject2;
    AppMethodBeat.o(119536);
    return localObject2;
  }
  
  public final boolean frH()
  {
    AppMethodBeat.i(119542);
    int i = this.field_localFlag;
    a.d locald = a.d.FvM;
    if ((i & a.d.frn()) != 0)
    {
      AppMethodBeat.o(119542);
      return true;
    }
    AppMethodBeat.o(119542);
    return false;
  }
  
  public final edu frI()
  {
    AppMethodBeat.i(119544);
    Object localObject = new edu();
    if (this.field_postBuf == null)
    {
      AppMethodBeat.o(119544);
      return localObject;
    }
    try
    {
      localObject = new edu().parseFrom(this.field_postBuf);
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
      localedu = new edu();
      AppMethodBeat.o(119544);
      return localedu;
    }
    edu localedu = (edu)localedu;
    AppMethodBeat.o(119544);
    return localedu;
  }
  
  public final boolean frJ()
  {
    AppMethodBeat.i(119545);
    int i = this.field_itemStoryFlag;
    a.a locala = a.FvD;
    boolean bool = d.cW(i, a.frf());
    AppMethodBeat.o(119545);
    return bool;
  }
  
  public final boolean frK()
  {
    AppMethodBeat.i(119546);
    int i = this.field_itemStoryFlag;
    a.a locala = a.FvD;
    boolean bool = d.cW(i, a.frg());
    AppMethodBeat.o(119546);
    return bool;
  }
  
  public final boolean frL()
  {
    AppMethodBeat.i(119548);
    int i = this.field_createTime;
    int j = cl.aWB();
    i.a locala = i.Fmb;
    if (i <= j - i.fnT())
    {
      AppMethodBeat.o(119548);
      return true;
    }
    AppMethodBeat.o(119548);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(119534);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.g(localMAutoDBInfo, "info");
    AppMethodBeat.o(119534);
    return localMAutoDBInfo;
  }
  
  public final void setItemDie()
  {
    AppMethodBeat.i(119540);
    int i = this.field_localFlag;
    a.d locald = a.d.FvM;
    this.field_localFlag = (i | a.d.frn());
    AppMethodBeat.o(119540);
  }
  
  public final void setPostBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(119538);
    p.h(paramArrayOfByte, "postBuf");
    this.field_postBuf = paramArrayOfByte;
    AppMethodBeat.o(119538);
  }
  
  public final void setPostWaiting()
  {
    AppMethodBeat.i(119539);
    int i = this.field_localFlag;
    a.d locald = a.d.FvM;
    this.field_localFlag = (i | a.d.frm());
    AppMethodBeat.o(119539);
  }
  
  public final void vX(boolean paramBoolean)
  {
    AppMethodBeat.i(119533);
    int i;
    a.d locald;
    if (paramBoolean)
    {
      i = this.field_localFlag;
      locald = a.d.FvM;
      i |= a.d.frp();
    }
    for (;;)
    {
      this.field_localFlag = i;
      AppMethodBeat.o(119533);
      return;
      i = this.field_localFlag;
      locald = a.d.FvM;
      i &= (a.d.frp() ^ 0xFFFFFFFF);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryInfo$Companion;", "", "()V", "COL_ROWID", "", "getCOL_ROWID", "()Ljava/lang/String;", "TABLEINDEXUSERNAME", "getTABLEINDEXUSERNAME", "TAG", "getTAG", "TableIndexUsernameCreateTime", "getTableIndexUsernameCreateTime", "TableIndexUsernameTime", "getTableIndexUsernameTime", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.j
 * JD-Core Version:    0.7.0.1
 */