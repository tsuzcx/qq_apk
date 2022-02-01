package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.g.c.eh;
import com.tencent.mm.model.cf;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryInfo;", "()V", "blackList", "", "", "getBlackList", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "date", "getDate", "setDate", "groupList", "getGroupList", "setGroupList", "localId", "getLocalId", "setLocalId", "readCount", "getReadCount", "setReadCount", "", "showIndicator", "getShowIndicator", "()Z", "setShowIndicator", "(Z)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "type", "getType", "setType", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "addSourceFlag", "", "mmsourceType", "addStoryItemFlag", "storyItemFlag", "checkFavorite", "checkNotifySns", "checkVisiableSelfOnly", "cleanPostFinish", "clearItemDie", "convertFrom", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "getTimeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "isDeprecated", "isDeprecatedForFav", "isItemDie", "isItemFinish", "isReadStatus", "isTimeLimit", "tryCount", "startTime", "isUnreadStatus", "removeSourceFlag", "removeStoryItemFlag", "setContent", "contentObj", "setItemDie", "setPostBuf", "postBuf", "", "setPostFinish", "setPostMixFinish", "setPostMixWaiting", "setPostWaiting", "setReadStatus", "setTimeLine", "timeline", "setUnreadStatus", "Companion", "plugin-story_release"})
public final class j
  extends eh
{
  private static final String AUc = "serverStoryNameTimeIndex";
  private static final String AUd = "serverStoryUsernameCreateTimeIndex";
  public static final j.a AUe;
  private static final String COL_ROWID = "rowid";
  private static final String TAG = "MicroMsg.StoryInfo";
  private static final c.a info;
  private static final String szr = "serverStoryNameIndex";
  private List<String> AHn;
  public int AUb;
  private List<String> AxW;
  public int dJd;
  
  static
  {
    AppMethodBeat.i(119550);
    AUe = new j.a((byte)0);
    TAG = "MicroMsg.StoryInfo";
    info = eh.Vv();
    COL_ROWID = "rowid";
    szr = "serverStoryNameIndex";
    AUc = "serverStoryNameTimeIndex";
    AUd = "serverStoryUsernameCreateTimeIndex";
    AppMethodBeat.o(119550);
  }
  
  public j()
  {
    AppMethodBeat.i(119549);
    this.AxW = ((List)new ArrayList());
    this.AHn = ((List)new ArrayList());
    AppMethodBeat.o(119549);
  }
  
  public static boolean aE(int paramInt, long paramLong)
  {
    boolean bool4 = true;
    AppMethodBeat.i(119547);
    if (ac.iPV)
    {
      ad.i(TAG, "Android Test time limit fail " + ac.iPV);
      AppMethodBeat.o(119547);
      return true;
    }
    int i = cf.aCN();
    int j = (int)paramLong;
    a.a locala = a.ATp;
    boolean bool1;
    boolean bool2;
    if (i - j > a.ekV())
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
        ad.i(TAG, "isTimeLimit " + bool1 + "  " + bool2 + " tryCount:" + paramInt + " startTime " + paramLong + "  svr: " + cf.aCN());
      }
      AppMethodBeat.o(119547);
      return bool3;
      bool1 = false;
      break;
      bool2 = false;
      break label79;
    }
  }
  
  public final void QJ(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final void Sv(int paramInt)
  {
    this.field_itemStoryFlag |= paramInt;
  }
  
  public final void Sw(int paramInt)
  {
    this.field_itemStoryFlag &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final List<String> aft()
  {
    AppMethodBeat.i(119530);
    Object localObject1 = new djs();
    Object localObject2 = (com.tencent.mm.bx.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((djs)localObject1).GroupUser;
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
      localObject1 = ((djs)localObject1).GroupUser;
      p.g(localObject1, "storyObj.GroupUser");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (cwt)((Iterator)localObject1).next();
        p.g(localObject3, "it");
        localException.add(((cwt)localObject3).getString());
      }
      localObject1 = (List)localException;
      AppMethodBeat.o(119530);
    }
    return localObject1;
  }
  
  public final void b(dkc paramdkc)
  {
    AppMethodBeat.i(119537);
    p.h(paramdkc, "timeline");
    try
    {
      this.field_content = paramdkc.toByteArray();
      AppMethodBeat.o(119537);
      return;
    }
    catch (Exception paramdkc)
    {
      ad.printErrStackTrace(TAG, (Throwable)paramdkc, "", new Object[0]);
      AppMethodBeat.o(119537);
    }
  }
  
  public final void bK(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(119538);
    p.h(paramArrayOfByte, "postBuf");
    this.field_postBuf = paramArrayOfByte;
    AppMethodBeat.o(119538);
  }
  
  public final boolean c(dkc paramdkc)
  {
    AppMethodBeat.i(119543);
    p.h(paramdkc, "contentObj");
    try
    {
      this.field_content = paramdkc.toByteArray();
      AppMethodBeat.o(119543);
      return true;
    }
    catch (Exception paramdkc)
    {
      ad.printErrStackTrace(TAG, (Throwable)paramdkc, "", new Object[0]);
      AppMethodBeat.o(119543);
    }
    return false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(119535);
    p.h(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.dJd = ((int)this.systemRowid);
    paramCursor = com.tencent.mm.plugin.story.e.a.AIZ;
    this.AUb = com.tencent.mm.plugin.story.e.a.a.AF(this.field_createTime * 1000L);
    AppMethodBeat.o(119535);
  }
  
  public final void dYN()
  {
    AppMethodBeat.i(119541);
    int i = this.field_localFlag;
    a.d locald = a.d.ATy;
    this.field_localFlag = (i & (a.d.ele() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119541);
  }
  
  public final void dYO()
  {
    AppMethodBeat.i(119540);
    int i = this.field_localFlag;
    a.d locald = a.d.ATy;
    this.field_localFlag = (i | a.d.ele());
    AppMethodBeat.o(119540);
  }
  
  public final boolean elA()
  {
    AppMethodBeat.i(119545);
    int i = this.field_itemStoryFlag;
    a.a locala = a.ATp;
    boolean bool = c.cQ(i, a.ekW());
    AppMethodBeat.o(119545);
    return bool;
  }
  
  public final boolean elB()
  {
    AppMethodBeat.i(119546);
    int i = this.field_itemStoryFlag;
    a.a locala = a.ATp;
    boolean bool = c.cQ(i, a.ekX());
    AppMethodBeat.o(119546);
    return bool;
  }
  
  public final boolean elC()
  {
    AppMethodBeat.i(119548);
    int i = this.field_createTime;
    int j = cf.aCN();
    i.a locala = i.AJE;
    if (i <= j - i.ehK())
    {
      AppMethodBeat.o(119548);
      return true;
    }
    AppMethodBeat.o(119548);
    return false;
  }
  
  public final List<String> elv()
  {
    AppMethodBeat.i(119531);
    Object localObject1 = new djs();
    Object localObject2 = (com.tencent.mm.bx.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((djs)localObject1).BlackList;
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
      localObject1 = ((djs)localObject1).BlackList;
      p.g(localObject1, "storyObj.BlackList");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (cwt)((Iterator)localObject1).next();
        p.g(localObject3, "it");
        localException.add(((cwt)localObject3).getString());
      }
      localObject1 = (List)localException;
      AppMethodBeat.o(119531);
    }
    return localObject1;
  }
  
  public final boolean elw()
  {
    AppMethodBeat.i(119532);
    int i = this.field_localFlag;
    a.d locald = a.d.ATy;
    boolean bool = c.cQ(i, a.d.elg());
    AppMethodBeat.o(119532);
    return bool;
  }
  
  public final dkc elx()
  {
    AppMethodBeat.i(119536);
    Object localObject1;
    if (this.field_content == null)
    {
      localObject1 = q.AKs;
      localObject1 = q.a.ein();
      AppMethodBeat.o(119536);
      return localObject1;
    }
    try
    {
      localObject1 = new dkc().parseFrom(this.field_content);
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
      localObject2 = q.AKs;
      localObject2 = q.a.ein();
      AppMethodBeat.o(119536);
      return localObject2;
    }
    Object localObject2 = (dkc)localObject2;
    AppMethodBeat.o(119536);
    return localObject2;
  }
  
  public final boolean ely()
  {
    AppMethodBeat.i(119542);
    int i = this.field_localFlag;
    a.d locald = a.d.ATy;
    if ((i & a.d.ele()) != 0)
    {
      AppMethodBeat.o(119542);
      return true;
    }
    AppMethodBeat.o(119542);
    return false;
  }
  
  public final djm elz()
  {
    AppMethodBeat.i(119544);
    Object localObject = new djm();
    if (this.field_postBuf == null)
    {
      AppMethodBeat.o(119544);
      return localObject;
    }
    try
    {
      localObject = new djm().parseFrom(this.field_postBuf);
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
      localdjm = new djm();
      AppMethodBeat.o(119544);
      return localdjm;
    }
    djm localdjm = (djm)localdjm;
    AppMethodBeat.o(119544);
    return localdjm;
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(119534);
    c.a locala = info;
    p.g(locala, "info");
    AppMethodBeat.o(119534);
    return locala;
  }
  
  public final void setPostWaiting()
  {
    AppMethodBeat.i(119539);
    int i = this.field_localFlag;
    a.d locald = a.d.ATy;
    this.field_localFlag = (i | a.d.eld());
    AppMethodBeat.o(119539);
  }
  
  public final void sv(boolean paramBoolean)
  {
    AppMethodBeat.i(119533);
    int i;
    a.d locald;
    if (paramBoolean)
    {
      i = this.field_localFlag;
      locald = a.d.ATy;
      i |= a.d.elg();
    }
    for (;;)
    {
      this.field_localFlag = i;
      AppMethodBeat.o(119533);
      return;
      i = this.field_localFlag;
      locald = a.d.ATy;
      i &= (a.d.elg() ^ 0xFFFFFFFF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.j
 * JD-Core Version:    0.7.0.1
 */