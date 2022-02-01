package com.tencent.mm.plugin.story.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.story.h.a.a;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.l;
import com.tencent.mm.plugin.story.model.m.a;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.plugin.story.model.p.a;
import com.tencent.mm.protocal.protobuf.fio;
import com.tencent.mm.protocal.protobuf.fip;
import com.tencent.mm.protocal.protobuf.fiq;
import com.tencent.mm.protocal.protobuf.fiz;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "(Ljava/lang/String;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "deleteFaultdData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "existFaultData", "getType", "insertList", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryPageResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.am.p
  implements com.tencent.mm.network.m
{
  public static final e.a Slj;
  private static final String TAG;
  private String QsM;
  public boolean Qsg;
  private long Qsh;
  public long QtH;
  private long Sli;
  private com.tencent.mm.am.h callback;
  private boolean hHq;
  private long maxId;
  private c rr;
  private int sourceType;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118812);
    Slj = new e.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
    AppMethodBeat.o(118812);
  }
  
  public e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(118811);
    this.userName = paramString;
    this.maxId = paramLong;
    this.hHq = paramBoolean;
    this.QsM = "";
    if (this.maxId == 0L) {
      Log.i(TAG, kotlin.g.b.s.X("fp mUserName ", this.userName));
    }
    int j;
    for (;;)
    {
      paramString = com.tencent.mm.plugin.story.h.a.Sry;
      j = com.tencent.mm.plugin.story.h.a.hyw();
      paramString = com.tencent.mm.plugin.story.h.a.Sry;
      this.sourceType = (j | com.tencent.mm.plugin.story.h.a.hyu());
      paramString = new c.a();
      paramString.otE = ((com.tencent.mm.bx.a)new fip());
      paramString.otF = ((com.tencent.mm.bx.a)new fiq());
      paramString.uri = "/cgi-bin/micromsg-bin/mmstoryhistorypage";
      paramString.funcId = 191;
      paramString.otG = 0;
      paramString.respCmdId = 0;
      paramString = paramString.bEF();
      kotlin.g.b.s.s(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = c.b.b(this.rr.otB);
      if (paramString != null) {
        break;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageRequest");
      AppMethodBeat.o(118811);
      throw paramString;
      Log.i(TAG, kotlin.g.b.s.X("np mUserName ", this.userName));
    }
    paramString = (fip)paramString;
    paramString.UserName = this.userName;
    paramString.abDv = this.maxId;
    Object localObject;
    if (this.maxId == 0L)
    {
      paramBoolean = true;
      this.Qsg = paramBoolean;
      localObject = StoryCore.SjP;
      StoryCore.b.hwa();
      j = n.a.bbR(this.userName);
      localObject = StoryCore.SjP;
      localObject = StoryCore.b.hvR();
      if (!this.Qsg) {
        break label514;
      }
    }
    label514:
    for (paramLong = l;; paramLong = this.maxId)
    {
      this.Qsh = ((k)localObject).aC(paramLong, j);
      paramString.abEV = this.Qsh;
      paramString.abEW = 0;
      try
      {
        localObject = Util.getTimeZoneOffset();
        kotlin.g.b.s.s(localObject, "getTimeZoneOffset()");
        float f = Float.parseFloat((String)localObject);
        i = (int)f;
      }
      catch (Exception localException)
      {
        label342:
        a.a locala;
        break label342;
      }
      paramString.ytH = i;
      if (this.Qsg)
      {
        localObject = StoryCore.SjP;
        localObject = StoryCore.b.hvS();
        locala = com.tencent.mm.plugin.story.h.a.Sry;
        this.QsM = ((com.tencent.mm.plugin.story.h.g)localObject).aZS(com.tencent.mm.plugin.story.h.a.hyA());
        if (this.QsM == null) {
          this.QsM = "";
        }
        paramString.abDu = this.QsM;
      }
      this.Sli = this.maxId;
      Log.i(TAG, "req.mUserName:" + paramString.UserName + " req.MaxId:" + paramString.abDv + " req.MinFilterId:" + paramString.abEV + " req.LastRequestTime:" + paramString.abEW + " req.FirstPageMd5:" + paramString.abDu + " req.TimeZone:" + paramString.ytH);
      AppMethodBeat.o(118811);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final void a(fiq paramfiq)
  {
    AppMethodBeat.i(118810);
    Object localObject1 = paramfiq.abJw;
    kotlin.g.b.s.s(localObject1, "resp.HistoryItemList");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      fio localfio = (fio)localIterator.next();
      Log.d(TAG, "date=" + localfio.ZrX + " count=" + localfio.abIQ + " id=" + localfio.Id);
      localObject1 = com.tencent.mm.plugin.story.model.m.Sks;
      Object localObject4 = this.userName;
      Object localObject3 = localfio.abJh;
      kotlin.g.b.s.s(localObject3, "it.StoryObject");
      int i = this.sourceType;
      kotlin.g.b.s.u(localObject4, "userName");
      kotlin.g.b.s.u(localObject3, "storyObj");
      localObject1 = StoryCore.SjP;
      localObject1 = StoryCore.b.hvR();
      Log.d(com.tencent.mm.plugin.story.model.m.access$getTAG$cp(), kotlin.g.b.s.X("insertStory storyObj.id:", Long.valueOf(((fiz)localObject3).Id)));
      Object localObject2 = ((k)localObject1).wa(((fiz)localObject3).Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new j();
      }
      kotlin.g.b.s.u(localObject1, "storyInfo");
      kotlin.g.b.s.u(localObject3, "storyObj");
      kotlin.g.b.s.u(localObject4, "userName");
      if ((((fiz)localObject3).abJK == null) || (((fiz)localObject3).abJK.aaxD == null)) {
        Log.i(com.tencent.mm.plugin.story.model.m.access$getTAG$cp(), "object desc is null");
      }
      for (;;)
      {
        localObject1 = l.Skr;
        kotlin.g.b.s.s(localfio, "it");
        kotlin.g.b.s.u(localfio, "item");
        localObject1 = com.tencent.mm.plugin.story.h.h.Stc;
        kotlin.g.b.s.u(localfio, "item");
        localObject3 = new com.tencent.mm.plugin.story.h.h();
        localObject2 = localfio.ZrX;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((com.tencent.mm.plugin.story.h.h)localObject3).field_date = ((String)localObject1);
        ((com.tencent.mm.plugin.story.h.h)localObject3).field_count = localfio.abIQ;
        localObject1 = StoryCore.SjP;
        StoryCore.b.hvW().a((com.tencent.mm.plugin.story.h.h)localObject3);
        break;
        localObject2 = ((fiz)localObject3).abJK.aaxD.toByteArray();
        kotlin.g.b.s.s(localObject2, "storyObj.ObjDesc.getBuffer().toByteArray()");
        localObject2 = new String((byte[])localObject2, d.UTF_8);
        Log.d(com.tencent.mm.plugin.story.model.m.access$getTAG$cp(), "from server %d \n%s", new Object[] { Long.valueOf(((fiz)localObject3).Id), localObject2 });
        localObject4 = com.tencent.mm.plugin.story.model.p.Sku;
        localObject4 = p.a.bbS((String)localObject2);
        if ((!Util.isNullOrNil((String)localObject2)) && (localObject4 != null) && (((j)localObject1).c((fjj)localObject4)))
        {
          Log.d(com.tencent.mm.plugin.story.model.m.access$getTAG$cp(), kotlin.g.b.s.X("from server xml ok %d \n ", localObject2), new Object[] { Long.valueOf(((fiz)localObject3).Id) });
          ((fiz)localObject3).abJK.df(new byte[0]);
          ((j)localObject1).field_userName = ((fiz)localObject3).UserName;
          ((j)localObject1).field_createTime = ((fiz)localObject3).CreateTime;
          ((j)localObject1).field_storyID = ((fiz)localObject3).Id;
          if (!((fiz)localObject3).abJL.isEmpty()) {
            ((j)localObject1).field_attrBuf = ((fiz)localObject3).toByteArray();
          }
          Log.i(com.tencent.mm.plugin.story.model.m.access$getTAG$cp(), "id:" + ((j)localObject1).field_storyID + " createTime:" + ((j)localObject1).field_createTime + " CommentListSize:" + ((fiz)localObject3).abJL.size() + " BubbleListSize:" + ((fiz)localObject3).abJN.size());
          ((j)localObject1).addSourceFlag(i);
          localObject2 = ((j)localObject1).hzt();
          ((fjj)localObject2).UserName = ((fiz)localObject3).UserName;
          ((j)localObject1).b((fjj)localObject2);
          localObject2 = StoryCore.SjP;
          localObject2 = StoryCore.b.hvR();
          long l = ((fiz)localObject3).Id;
          localObject4 = "select *,rowid from MMStoryInfo  where " + k.ptT + ".storyID = " + l;
          localObject2 = ((k)localObject2).db.rawQuery((String)localObject4, null);
          i = ((Cursor)localObject2).getCount();
          ((Cursor)localObject2).close();
          if (i > 0) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label785;
            }
            localObject2 = StoryCore.SjP;
            StoryCore.b.hvR().e((j)localObject1);
            localObject1 = StoryCore.SjP;
            StoryCore.b.hvR().wd(((fiz)localObject3).Id);
            break;
          }
          label785:
          localObject2 = StoryCore.SjP;
          StoryCore.b.hvR().f((j)localObject1);
        }
      }
    }
    if (this.maxId == 0L) {
      this.maxId = ((fio)paramfiq.abJw.getFirst()).Id;
    }
    this.Qsh = ((fio)paramfiq.abJw.getLast()).Id;
    Log.i(TAG, "insertList mUserName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.maxId), Long.valueOf(this.Qsh), Integer.valueOf(paramfiq.abFi) });
    AppMethodBeat.o(118810);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(118808);
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(118808);
    return i;
  }
  
  public final int getType()
  {
    return 191;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118809);
    Log.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    params = c.c.b(this.rr.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageResponse");
      AppMethodBeat.o(118809);
      throw paramString;
    }
    fiq localfiq = (fiq)params;
    this.QtH = localfiq.abJj;
    paramArrayOfByte = localfiq.abDu;
    params = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      params = "";
    }
    Log.i(TAG, "objCount:" + localfiq.abJv + " firstPageMd5:" + params + ", expiredTime:" + localfiq.aaiS);
    if (localfiq.abJw.isEmpty())
    {
      Log.i(TAG, "server give size zero");
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      AppMethodBeat.o(118809);
      return;
    }
    paramArrayOfByte = StoryCore.SjP;
    paramArrayOfByte = StoryCore.b.hvS();
    a.a locala = com.tencent.mm.plugin.story.h.a.Sry;
    paramArrayOfByte.mO(com.tencent.mm.plugin.story.h.a.hyA(), params);
    long l;
    if (this.Qsg)
    {
      l = ((fio)localfiq.abJw.get(localfiq.abJw.size() - 1)).Id;
      params = com.tencent.mm.plugin.story.model.m.Sks;
      if (l <= m.a.bbQ(this.userName).field_storyID) {
        break label565;
      }
    }
    label565:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        l = ((fio)localfiq.abJw.get(localfiq.abJw.size() - 1)).Id;
        params = this.userName;
        paramArrayOfByte = StoryCore.SjP;
        if (Util.isEqual(params, StoryCore.b.hgg()))
        {
          params = com.tencent.mm.plugin.story.model.m.Sks;
          params = this.userName;
          kotlin.g.b.s.u(params, "userName");
          paramArrayOfByte = StoryCore.SjP;
          paramArrayOfByte = StoryCore.b.hvR();
          locala = com.tencent.mm.plugin.story.h.a.Sry;
          paramInt1 = com.tencent.mm.plugin.story.h.a.hyu();
          kotlin.g.b.s.u(params, "userName");
          params = "UPDATE " + k.ptT + " SET sourceType = " + paramInt1 + " Where userName = '" + params + "' AND storyID < " + l;
          Log.d(k.TAG, kotlin.g.b.s.X("updateSourceTypeBefore sql ", params));
          paramArrayOfByte.db.execSQL(k.ptT, params);
        }
      }
      a(localfiq);
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      AppMethodBeat.o(118809);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.e
 * JD-Core Version:    0.7.0.1
 */