package com.tencent.mm.plugin.story.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.b.fg;
import com.tencent.mm.model.cn;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.model.i.a;
import com.tencent.mm.plugin.story.model.p;
import com.tencent.mm.plugin.story.model.p.a;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.protocal.protobuf.fiz;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryInfo;", "()V", "blackList", "", "", "getBlackList", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "date", "getDate", "setDate", "groupList", "getGroupList", "setGroupList", "localId", "getLocalId", "setLocalId", "readCount", "getReadCount", "setReadCount", "", "showIndicator", "getShowIndicator", "()Z", "setShowIndicator", "(Z)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "type", "getType", "setType", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "addSourceFlag", "", "mmsourceType", "addStoryItemFlag", "storyItemFlag", "checkFavorite", "checkNotifySns", "checkVisiableSelfOnly", "cleanPostFinish", "clearItemDie", "convertFrom", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "getTimeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "isDeprecated", "isDeprecatedForFav", "isItemDie", "isItemFinish", "isReadStatus", "isTimeLimit", "tryCount", "startTime", "isUnreadStatus", "removeSourceFlag", "removeStoryItemFlag", "setContent", "contentObj", "setItemDie", "setPostBuf", "postBuf", "", "setPostFinish", "setPostMixFinish", "setPostMixWaiting", "setPostWaiting", "setReadStatus", "setTimeLine", "timeline", "setUnreadStatus", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends fg
{
  private static final String COL_ROWID;
  public static final j.a Ste;
  private static final String Stf;
  private static final String Stg;
  private static final String TABLEINDEXUSERNAME;
  private static final String TAG;
  private static final IAutoDBItem.MAutoDBInfo info;
  private List<String> Dig;
  private List<String> RPB;
  public int date;
  public int icg;
  
  static
  {
    AppMethodBeat.i(119550);
    Ste = new j.a((byte)0);
    TAG = "MicroMsg.StoryInfo";
    info = fg.aJm();
    COL_ROWID = "rowid";
    TABLEINDEXUSERNAME = "serverStoryNameIndex";
    Stf = "serverStoryNameTimeIndex";
    Stg = "serverStoryUsernameCreateTimeIndex";
    AppMethodBeat.o(119550);
  }
  
  public j()
  {
    AppMethodBeat.i(119549);
    this.RPB = ((List)new ArrayList());
    this.Dig = ((List)new ArrayList());
    AppMethodBeat.o(119549);
  }
  
  public static boolean isTimeLimit(int paramInt, long paramLong)
  {
    boolean bool4 = true;
    AppMethodBeat.i(119547);
    if (z.pDt)
    {
      Log.i(TAG, s.X("Android Test time limit fail ", Boolean.valueOf(z.pDt)));
      AppMethodBeat.o(119547);
      return true;
    }
    int i = cn.getSyncServerTimeSecond();
    int j = (int)paramLong;
    a.a locala = a.Sry;
    boolean bool1;
    boolean bool2;
    if (i - j > a.hyS())
    {
      bool1 = true;
      if (paramInt <= 5) {
        break label171;
      }
      bool2 = true;
      label72:
      bool3 = bool4;
      if (!bool1) {
        if (!bool2) {
          break label177;
        }
      }
    }
    label171:
    label177:
    for (boolean bool3 = bool4;; bool3 = false)
    {
      if (bool3) {
        Log.i(TAG, "isTimeLimit " + bool1 + "  " + bool2 + " tryCount:" + paramInt + " startTime " + paramLong + "  svr: " + cn.getSyncServerTimeSecond());
      }
      AppMethodBeat.o(119547);
      return bool3;
      bool1 = false;
      break;
      bool2 = false;
      break label72;
    }
  }
  
  public final void ER(boolean paramBoolean)
  {
    AppMethodBeat.i(119533);
    int i;
    a.d locald;
    if (paramBoolean)
    {
      i = this.field_localFlag;
      locald = a.d.Ssx;
      i |= a.d.hzd();
    }
    for (;;)
    {
      this.field_localFlag = i;
      AppMethodBeat.o(119533);
      return;
      i = this.field_localFlag;
      locald = a.d.Ssx;
      i &= (a.d.hzd() ^ 0xFFFFFFFF);
    }
  }
  
  public final List<String> aVm()
  {
    AppMethodBeat.i(119530);
    Object localObject1 = new fiz();
    Object localObject2 = (com.tencent.mm.bx.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((fiz)localObject1).GroupUser;
      if ((localObject3 == null) || (((Collection)localObject3).isEmpty()))
      {
        i = 1;
        if (i == 0) {
          break label115;
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
      label115:
      localObject1 = ((fiz)localObject1).GroupUser;
      s.s(localObject1, "storyObj.GroupUser");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localException.add(((etl)((Iterator)localObject1).next()).abwM);
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
  
  public final void ant(int paramInt)
  {
    this.field_itemStoryFlag |= paramInt;
  }
  
  public final void anu(int paramInt)
  {
    this.field_itemStoryFlag &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final void b(fjj paramfjj)
  {
    AppMethodBeat.i(119537);
    s.u(paramfjj, "timeline");
    try
    {
      this.field_content = paramfjj.toByteArray();
      AppMethodBeat.o(119537);
      return;
    }
    catch (Exception paramfjj)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramfjj, "", new Object[0]);
      AppMethodBeat.o(119537);
    }
  }
  
  public final boolean c(fjj paramfjj)
  {
    AppMethodBeat.i(119543);
    s.u(paramfjj, "contentObj");
    try
    {
      this.field_content = paramfjj.toByteArray();
      AppMethodBeat.o(119543);
      return true;
    }
    catch (Exception paramfjj)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramfjj, "", new Object[0]);
      AppMethodBeat.o(119543);
    }
    return false;
  }
  
  public final void clearItemDie()
  {
    AppMethodBeat.i(119541);
    int i = this.field_localFlag;
    a.d locald = a.d.Ssx;
    this.field_localFlag = (i & (a.d.hzb() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119541);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(119535);
    s.u(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.icg = ((int)this.systemRowid);
    paramCursor = com.tencent.mm.plugin.story.e.a.Sjk;
    this.date = com.tencent.mm.plugin.story.e.a.a.vL(this.field_createTime * 1000L);
    AppMethodBeat.o(119535);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(119534);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(119534);
    return localMAutoDBInfo;
  }
  
  public final List<String> hzr()
  {
    AppMethodBeat.i(119531);
    Object localObject1 = new fiz();
    Object localObject2 = (com.tencent.mm.bx.a)localObject1;
    Object localObject3 = this.field_attrBuf;
    try
    {
      ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject3);
      localObject2 = new ArrayList();
      localObject3 = (Collection)((fiz)localObject1).BlackList;
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
      localObject1 = ((fiz)localObject1).BlackList;
      s.s(localObject1, "storyObj.BlackList");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localException.add(((etl)((Iterator)localObject1).next()).abwM);
      }
      localObject1 = (List)localException;
      AppMethodBeat.o(119531);
    }
    return localObject1;
  }
  
  public final boolean hzs()
  {
    AppMethodBeat.i(119532);
    int i = this.field_localFlag;
    a.d locald = a.d.Ssx;
    boolean bool = d.ee(i, a.d.hzd());
    AppMethodBeat.o(119532);
    return bool;
  }
  
  public final fjj hzt()
  {
    AppMethodBeat.i(119536);
    Object localObject1;
    if (this.field_content == null)
    {
      localObject1 = p.Sku;
      localObject1 = p.a.hwl();
      AppMethodBeat.o(119536);
      return localObject1;
    }
    try
    {
      localObject1 = new fjj().parseFrom(this.field_content);
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryTimelineObject");
        AppMethodBeat.o(119536);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      Log.e(TAG, "error get storyinfo timeline!");
      localObject2 = p.Sku;
      localObject2 = p.a.hwl();
      AppMethodBeat.o(119536);
      return localObject2;
    }
    Object localObject2 = (fjj)localObject2;
    AppMethodBeat.o(119536);
    return localObject2;
  }
  
  public final boolean hzu()
  {
    AppMethodBeat.i(119542);
    int i = this.field_localFlag;
    a.d locald = a.d.Ssx;
    if ((i & a.d.hzb()) != 0)
    {
      AppMethodBeat.o(119542);
      return true;
    }
    AppMethodBeat.o(119542);
    return false;
  }
  
  public final fit hzv()
  {
    AppMethodBeat.i(119544);
    Object localObject = new fit();
    if (this.field_postBuf == null)
    {
      AppMethodBeat.o(119544);
      return localObject;
    }
    try
    {
      localObject = new fit().parseFrom(this.field_postBuf);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
        AppMethodBeat.o(119544);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.e(TAG, s.X("error get StoryMediaPostInfo ", Long.valueOf(this.field_storyID)));
      localfit = new fit();
      AppMethodBeat.o(119544);
      return localfit;
    }
    fit localfit = (fit)localfit;
    AppMethodBeat.o(119544);
    return localfit;
  }
  
  public final boolean hzw()
  {
    AppMethodBeat.i(119545);
    int i = this.field_itemStoryFlag;
    a.a locala = a.Sry;
    boolean bool = d.ee(i, a.hyT());
    AppMethodBeat.o(119545);
    return bool;
  }
  
  public final boolean hzx()
  {
    AppMethodBeat.i(119546);
    int i = this.field_itemStoryFlag;
    a.a locala = a.Sry;
    boolean bool = d.ee(i, a.hyU());
    AppMethodBeat.o(119546);
    return bool;
  }
  
  public final boolean hzy()
  {
    AppMethodBeat.i(119548);
    int i = this.field_createTime;
    int j = cn.getSyncServerTimeSecond();
    i.a locala = i.SjL;
    if (i <= j - i.hvz())
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
    a.d locald = a.d.Ssx;
    this.field_localFlag = (i | a.d.hzb());
    AppMethodBeat.o(119540);
  }
  
  public final void setPostBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(119538);
    s.u(paramArrayOfByte, "postBuf");
    this.field_postBuf = paramArrayOfByte;
    AppMethodBeat.o(119538);
  }
  
  public final void setPostWaiting()
  {
    AppMethodBeat.i(119539);
    int i = this.field_localFlag;
    a.d locald = a.d.Ssx;
    this.field_localFlag = (i | a.d.hza());
    AppMethodBeat.o(119539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.j
 * JD-Core Version:    0.7.0.1
 */