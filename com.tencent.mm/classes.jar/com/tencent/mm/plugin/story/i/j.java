package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.c.eh;
import com.tencent.mm.model.ch;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryInfo;", "()V", "blackList", "", "", "getBlackList", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "date", "getDate", "setDate", "groupList", "getGroupList", "setGroupList", "localId", "getLocalId", "setLocalId", "readCount", "getReadCount", "setReadCount", "", "showIndicator", "getShowIndicator", "()Z", "setShowIndicator", "(Z)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "type", "getType", "setType", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "addSourceFlag", "", "mmsourceType", "addStoryItemFlag", "storyItemFlag", "checkFavorite", "checkNotifySns", "checkVisiableSelfOnly", "cleanPostFinish", "clearItemDie", "convertFrom", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "getTimeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "isDeprecated", "isDeprecatedForFav", "isItemDie", "isItemFinish", "isReadStatus", "isTimeLimit", "tryCount", "startTime", "isUnreadStatus", "removeSourceFlag", "removeStoryItemFlag", "setContent", "contentObj", "setItemDie", "setPostBuf", "postBuf", "", "setPostFinish", "setPostMixFinish", "setPostMixWaiting", "setPostWaiting", "setReadStatus", "setTimeLine", "timeline", "setUnreadStatus", "Companion", "plugin-story_release"})
public final class j
  extends eh
{
  private static final String BlA = "serverStoryNameTimeIndex";
  private static final String BlB = "serverStoryUsernameCreateTimeIndex";
  public static final j.a BlC;
  private static final String COL_ROWID = "rowid";
  private static final String TAG = "MicroMsg.StoryInfo";
  private static final c.a info;
  private static final String sKi = "serverStoryNameIndex";
  private List<String> APp;
  private List<String> AYQ;
  public int Blz;
  public int dKr;
  
  static
  {
    AppMethodBeat.i(119550);
    BlC = new j.a((byte)0);
    TAG = "MicroMsg.StoryInfo";
    info = eh.VD();
    COL_ROWID = "rowid";
    sKi = "serverStoryNameIndex";
    BlA = "serverStoryNameTimeIndex";
    BlB = "serverStoryUsernameCreateTimeIndex";
    AppMethodBeat.o(119550);
  }
  
  public j()
  {
    AppMethodBeat.i(119549);
    this.APp = ((List)new ArrayList());
    this.AYQ = ((List)new ArrayList());
    AppMethodBeat.o(119549);
  }
  
  public static boolean aE(int paramInt, long paramLong)
  {
    boolean bool4 = true;
    AppMethodBeat.i(119547);
    if (ac.iSO)
    {
      ae.i(TAG, "Android Test time limit fail " + ac.iSO);
      AppMethodBeat.o(119547);
      return true;
    }
    int i = ch.aDd();
    int j = (int)paramLong;
    a.a locala = a.BkN;
    boolean bool1;
    boolean bool2;
    if (i - j > a.eoE())
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
        ae.i(TAG, "isTimeLimit " + bool1 + "  " + bool2 + " tryCount:" + paramInt + " startTime " + paramLong + "  svr: " + ch.aDd());
      }
      AppMethodBeat.o(119547);
      return bool3;
      bool1 = false;
      break;
      bool2 = false;
      break label79;
    }
  }
  
  public final void Rq(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final void Tc(int paramInt)
  {
    this.field_itemStoryFlag |= paramInt;
  }
  
  public final void Td(int paramInt)
  {
    this.field_itemStoryFlag &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final List<String> afH()
  {
    AppMethodBeat.i(119530);
    Object localObject1 = new dkn();
    Object localObject2 = (com.tencent.mm.bw.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((dkn)localObject1).GroupUser;
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
        ae.l("safeParser", "", new Object[] { localException });
        continue;
        int i = 0;
      }
      label113:
      localObject1 = ((dkn)localObject1).GroupUser;
      p.g(localObject1, "storyObj.GroupUser");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (cxn)((Iterator)localObject1).next();
        p.g(localObject3, "it");
        localException.add(((cxn)localObject3).getString());
      }
      localObject1 = (List)localException;
      AppMethodBeat.o(119530);
    }
    return localObject1;
  }
  
  public final void b(dkx paramdkx)
  {
    AppMethodBeat.i(119537);
    p.h(paramdkx, "timeline");
    try
    {
      this.field_content = paramdkx.toByteArray();
      AppMethodBeat.o(119537);
      return;
    }
    catch (Exception paramdkx)
    {
      ae.printErrStackTrace(TAG, (Throwable)paramdkx, "", new Object[0]);
      AppMethodBeat.o(119537);
    }
  }
  
  public final void bN(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(119538);
    p.h(paramArrayOfByte, "postBuf");
    this.field_postBuf = paramArrayOfByte;
    AppMethodBeat.o(119538);
  }
  
  public final boolean c(dkx paramdkx)
  {
    AppMethodBeat.i(119543);
    p.h(paramdkx, "contentObj");
    try
    {
      this.field_content = paramdkx.toByteArray();
      AppMethodBeat.o(119543);
      return true;
    }
    catch (Exception paramdkx)
    {
      ae.printErrStackTrace(TAG, (Throwable)paramdkx, "", new Object[0]);
      AppMethodBeat.o(119543);
    }
    return false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(119535);
    p.h(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.dKr = ((int)this.systemRowid);
    paramCursor = com.tencent.mm.plugin.story.e.a.BaC;
    this.Blz = com.tencent.mm.plugin.story.e.a.a.Bd(this.field_createTime * 1000L);
    AppMethodBeat.o(119535);
  }
  
  public final void ecr()
  {
    AppMethodBeat.i(119541);
    int i = this.field_localFlag;
    a.d locald = a.d.BkW;
    this.field_localFlag = (i & (a.d.eoN() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119541);
  }
  
  public final void ecs()
  {
    AppMethodBeat.i(119540);
    int i = this.field_localFlag;
    a.d locald = a.d.BkW;
    this.field_localFlag = (i | a.d.eoN());
    AppMethodBeat.o(119540);
  }
  
  public final List<String> epe()
  {
    AppMethodBeat.i(119531);
    Object localObject1 = new dkn();
    Object localObject2 = (com.tencent.mm.bw.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((dkn)localObject1).BlackList;
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
        ae.l("safeParser", "", new Object[] { localException });
        continue;
        int i = 0;
      }
      label115:
      localObject1 = ((dkn)localObject1).BlackList;
      p.g(localObject1, "storyObj.BlackList");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (cxn)((Iterator)localObject1).next();
        p.g(localObject3, "it");
        localException.add(((cxn)localObject3).getString());
      }
      localObject1 = (List)localException;
      AppMethodBeat.o(119531);
    }
    return localObject1;
  }
  
  public final boolean epf()
  {
    AppMethodBeat.i(119532);
    int i = this.field_localFlag;
    a.d locald = a.d.BkW;
    boolean bool = c.cQ(i, a.d.eoP());
    AppMethodBeat.o(119532);
    return bool;
  }
  
  public final dkx epg()
  {
    AppMethodBeat.i(119536);
    Object localObject1;
    if (this.field_content == null)
    {
      localObject1 = q.BbV;
      localObject1 = q.a.elV();
      AppMethodBeat.o(119536);
      return localObject1;
    }
    try
    {
      localObject1 = new dkx().parseFrom(this.field_content);
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryTimelineObject");
        AppMethodBeat.o(119536);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      ae.e(TAG, "error get storyinfo timeline!");
      localObject2 = q.BbV;
      localObject2 = q.a.elV();
      AppMethodBeat.o(119536);
      return localObject2;
    }
    Object localObject2 = (dkx)localObject2;
    AppMethodBeat.o(119536);
    return localObject2;
  }
  
  public final boolean eph()
  {
    AppMethodBeat.i(119542);
    int i = this.field_localFlag;
    a.d locald = a.d.BkW;
    if ((i & a.d.eoN()) != 0)
    {
      AppMethodBeat.o(119542);
      return true;
    }
    AppMethodBeat.o(119542);
    return false;
  }
  
  public final dkh epi()
  {
    AppMethodBeat.i(119544);
    Object localObject = new dkh();
    if (this.field_postBuf == null)
    {
      AppMethodBeat.o(119544);
      return localObject;
    }
    try
    {
      localObject = new dkh().parseFrom(this.field_postBuf);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
        AppMethodBeat.o(119544);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      ae.e(TAG, "error get StoryMediaPostInfo " + this.field_storyID);
      localdkh = new dkh();
      AppMethodBeat.o(119544);
      return localdkh;
    }
    dkh localdkh = (dkh)localdkh;
    AppMethodBeat.o(119544);
    return localdkh;
  }
  
  public final boolean epj()
  {
    AppMethodBeat.i(119545);
    int i = this.field_itemStoryFlag;
    a.a locala = a.BkN;
    boolean bool = c.cQ(i, a.eoF());
    AppMethodBeat.o(119545);
    return bool;
  }
  
  public final boolean epk()
  {
    AppMethodBeat.i(119546);
    int i = this.field_itemStoryFlag;
    a.a locala = a.BkN;
    boolean bool = c.cQ(i, a.eoG());
    AppMethodBeat.o(119546);
    return bool;
  }
  
  public final boolean epl()
  {
    AppMethodBeat.i(119548);
    int i = this.field_createTime;
    int j = ch.aDd();
    i.a locala = i.Bbh;
    if (i <= j - i.els())
    {
      AppMethodBeat.o(119548);
      return true;
    }
    AppMethodBeat.o(119548);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(119534);
    c.a locala = info;
    p.g(locala, "info");
    AppMethodBeat.o(119534);
    return locala;
  }
  
  public final void sC(boolean paramBoolean)
  {
    AppMethodBeat.i(119533);
    int i;
    a.d locald;
    if (paramBoolean)
    {
      i = this.field_localFlag;
      locald = a.d.BkW;
      i |= a.d.eoP();
    }
    for (;;)
    {
      this.field_localFlag = i;
      AppMethodBeat.o(119533);
      return;
      i = this.field_localFlag;
      locald = a.d.BkW;
      i &= (a.d.eoP() ^ 0xFFFFFFFF);
    }
  }
  
  public final void setPostWaiting()
  {
    AppMethodBeat.i(119539);
    int i = this.field_localFlag;
    a.d locald = a.d.BkW;
    this.field_localFlag = (i | a.d.eoM());
    AppMethodBeat.o(119539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.j
 * JD-Core Version:    0.7.0.1
 */