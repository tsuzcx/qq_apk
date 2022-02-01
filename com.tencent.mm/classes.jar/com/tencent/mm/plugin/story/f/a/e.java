package com.tencent.mm.plugin.story.f.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.i.a.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.edp;
import com.tencent.mm.protocal.protobuf.edq;
import com.tencent.mm.protocal.protobuf.edr;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "(Ljava/lang/String;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "deleteFaultdData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "existFaultData", "getType", "insertList", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryPageResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.ak.q
  implements com.tencent.mm.network.m
{
  public static final a FnF;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
  private String DIL;
  public boolean DIe;
  private long DIf;
  private long DIg;
  public long DJB;
  private long FnD;
  private com.tencent.mm.ak.i callback;
  private boolean dJM;
  private com.tencent.mm.ak.d rr;
  private int sourceType;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118812);
    FnF = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
    AppMethodBeat.o(118812);
  }
  
  public e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(118811);
    this.userName = paramString;
    this.DIf = paramLong;
    this.dJM = paramBoolean;
    this.DIL = "";
    if (this.DIf == 0L) {
      Log.i(TAG, "fp mUserName " + this.userName);
    }
    int j;
    for (;;)
    {
      paramString = com.tencent.mm.plugin.story.i.a.FvD;
      j = com.tencent.mm.plugin.story.i.a.fqI();
      paramString = com.tencent.mm.plugin.story.i.a.FvD;
      this.sourceType = (j | com.tencent.mm.plugin.story.i.a.fqG());
      paramString = new d.a();
      paramString.c((com.tencent.mm.bw.a)new edq());
      paramString.d((com.tencent.mm.bw.a)new edr());
      paramString.MB("/cgi-bin/micromsg-bin/mmstoryhistorypage");
      paramString.sG(191);
      paramString.sI(0);
      paramString.sJ(0);
      paramString = paramString.aXF();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = this.rr.aYJ();
      if (paramString != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageRequest");
      AppMethodBeat.o(118811);
      throw paramString;
      Log.i(TAG, "np mUserName " + this.userName);
    }
    paramString = (edq)paramString;
    paramString.UserName = this.userName;
    paramString.MZh = this.DIf;
    Object localObject;
    if (this.DIf == 0L)
    {
      paramBoolean = true;
      this.DIe = paramBoolean;
      localObject = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.fol();
      j = o.a.aSa(this.userName);
      localObject = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject = j.b.foc();
      if (!this.DIe) {
        break label531;
      }
    }
    label531:
    for (paramLong = l;; paramLong = this.DIf)
    {
      this.DIg = ((k)localObject).ab(paramLong, j);
      paramString.Nau = this.DIg;
      paramString.Nav = 0;
      try
      {
        localObject = Util.getTimeZoneOffset();
        p.g(localObject, "Util.getTimeZoneOffset()");
        float f = Float.parseFloat((String)localObject);
        i = (int)f;
      }
      catch (Exception localException)
      {
        label359:
        a.a locala;
        break label359;
      }
      paramString.rBY = i;
      if (this.DIe)
      {
        localObject = com.tencent.mm.plugin.story.f.j.Fmy;
        localObject = j.b.fod();
        locala = com.tencent.mm.plugin.story.i.a.FvD;
        this.DIL = ((com.tencent.mm.plugin.story.i.g)localObject).aSu(com.tencent.mm.plugin.story.i.a.fqM());
        if (this.DIL == null) {
          this.DIL = "";
        }
        paramString.MZg = this.DIL;
      }
      this.FnD = this.DIf;
      Log.i(TAG, "req.mUserName:" + paramString.UserName + " req.MaxId:" + paramString.MZh + " req.MinFilterId:" + paramString.Nau + " req.LastRequestTime:" + paramString.Nav + " req.FirstPageMd5:" + paramString.MZg + " req.TimeZone:" + paramString.rBY);
      AppMethodBeat.o(118811);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final void a(edr paramedr)
  {
    AppMethodBeat.i(118810);
    Object localObject1 = paramedr.NdY;
    p.g(localObject1, "resp.HistoryItemList");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      edp localedp = (edp)localIterator.next();
      Log.d(TAG, "date=" + localedp.Lrr + " count=" + localedp.Ndu + " id=" + localedp.Id);
      localObject1 = n.FmM;
      Object localObject4 = this.userName;
      Object localObject3 = localedp.NdL;
      p.g(localObject3, "it.StoryObject");
      int i = this.sourceType;
      p.h(localObject4, "userName");
      p.h(localObject3, "storyObj");
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject1 = j.b.foc();
      Log.d(n.access$getTAG$cp(), "insertStory storyObj.id:" + ((eea)localObject3).Id);
      Object localObject2 = ((k)localObject1).Kx(((eea)localObject3).Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      p.h(localObject1, "storyInfo");
      p.h(localObject3, "storyObj");
      p.h(localObject4, "userName");
      if ((((eea)localObject3).Nem == null) || (((eea)localObject3).Nem.getBuffer() == null)) {
        Log.i(n.access$getTAG$cp(), "object desc is null");
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.story.f.m.FmL;
        p.g(localedp, "it");
        p.h(localedp, "item");
        localObject1 = h.Fwn;
        p.h(localedp, "item");
        localObject3 = new h();
        localObject2 = localedp.Lrr;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((h)localObject3).field_date = ((String)localObject1);
        ((h)localObject3).field_count = localedp.Ndu;
        localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.foh().a((h)localObject3);
        break;
        localObject2 = ((eea)localObject3).Nem.getBuffer().toByteArray();
        p.g(localObject2, "storyObj.ObjDesc.getBuffer().toByteArray()");
        localObject2 = new String((byte[])localObject2, kotlin.n.d.UTF_8);
        Log.d(n.access$getTAG$cp(), "from server %d \n%s", new Object[] { Long.valueOf(((eea)localObject3).Id), localObject2 });
        localObject4 = com.tencent.mm.plugin.story.f.q.FmO;
        localObject4 = q.a.aSb((String)localObject2);
        if ((!Util.isNullOrNil((String)localObject2)) && (localObject4 != null) && (((com.tencent.mm.plugin.story.i.j)localObject1).c((eek)localObject4)))
        {
          Log.d(n.access$getTAG$cp(), "from server xml ok %d \n ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(((eea)localObject3).Id) });
          ((eea)localObject3).Nem.setBuffer(new byte[0]);
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = ((eea)localObject3).UserName;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = ((eea)localObject3).CreateTime;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = ((eea)localObject3).Id;
          if (!((eea)localObject3).Nen.isEmpty()) {
            ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = ((eea)localObject3).toByteArray();
          }
          Log.i(n.access$getTAG$cp(), "id:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID + " createTime:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime + " CommentListSize:" + ((eea)localObject3).Nen.size() + " BubbleListSize:" + ((eea)localObject3).Nep.size());
          ((com.tencent.mm.plugin.story.i.j)localObject1).addSourceFlag(i);
          localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).frG();
          ((eek)localObject2).UserName = ((eea)localObject3).UserName;
          ((com.tencent.mm.plugin.story.i.j)localObject1).b((eek)localObject2);
          localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
          localObject2 = j.b.foc();
          long l = ((eea)localObject3).Id;
          localObject4 = "select *,rowid from MMStoryInfo  where " + k.TABLE + ".storyID = " + l;
          localObject2 = ((k)localObject2).db.rawQuery((String)localObject4, null);
          p.g(localObject2, "cu");
          i = ((Cursor)localObject2).getCount();
          ((Cursor)localObject2).close();
          if (i > 0) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label803;
            }
            localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foc().e((com.tencent.mm.plugin.story.i.j)localObject1);
            localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foc().KA(((eea)localObject3).Id);
            break;
          }
          label803:
          localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.foc().f((com.tencent.mm.plugin.story.i.j)localObject1);
        }
      }
    }
    if (this.DIf == 0L)
    {
      localObject1 = paramedr.NdY;
      p.g(localObject1, "resp.HistoryItemList");
      this.DIf = ((edp)((LinkedList)localObject1).getFirst()).Id;
    }
    localObject1 = paramedr.NdY;
    p.g(localObject1, "resp.HistoryItemList");
    this.DIg = ((edp)((LinkedList)localObject1).getLast()).Id;
    Log.i(TAG, "insertList mUserName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.DIf), Long.valueOf(this.DIg), Integer.valueOf(paramedr.NaG) });
    AppMethodBeat.o(118810);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(118808);
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(118808);
    return i;
  }
  
  public final int getType()
  {
    return 191;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118809);
    Log.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    params = this.rr.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageResponse");
      AppMethodBeat.o(118809);
      throw paramString;
    }
    edr localedr = (edr)params;
    this.DJB = localedr.NdN;
    paramArrayOfByte = localedr.MZg;
    params = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      params = "";
    }
    Log.i(TAG, "objCount:" + localedr.NdX + " firstPageMd5:" + params + ", expiredTime:" + localedr.KCC);
    if (localedr.NdY.isEmpty())
    {
      Log.i(TAG, "server give size zero");
      params = this.callback;
      if (params == null) {
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.q)this);
      AppMethodBeat.o(118809);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.story.f.j.Fmy;
    paramArrayOfByte = j.b.fod();
    a.a locala = com.tencent.mm.plugin.story.i.a.FvD;
    paramArrayOfByte.kJ(com.tencent.mm.plugin.story.i.a.fqM(), params);
    long l;
    if (this.DIe)
    {
      l = ((edp)localedr.NdY.get(localedr.NdY.size() - 1)).Id;
      params = n.FmM;
      if (l <= n.a.aRZ(this.userName).field_storyID) {
        break label551;
      }
    }
    label551:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        l = ((edp)localedr.NdY.get(localedr.NdY.size() - 1)).Id;
        params = this.userName;
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.Fmy;
        if (Util.isEqual(params, j.b.fau()))
        {
          params = n.FmM;
          params = this.userName;
          p.h(params, "userName");
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.Fmy;
          paramArrayOfByte = j.b.foc();
          locala = com.tencent.mm.plugin.story.i.a.FvD;
          paramInt1 = com.tencent.mm.plugin.story.i.a.fqG();
          p.h(params, "userName");
          params = "UPDATE " + k.TABLE + " SET sourceType = " + paramInt1 + " Where userName = '" + params + "' AND storyID < " + l;
          Log.d(k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(params)));
          paramArrayOfByte.db.execSQL(k.TABLE, params);
        }
      }
      a(localedr);
      params = this.callback;
      if (params == null) {
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.q)this);
      AppMethodBeat.o(118809);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.e
 * JD-Core Version:    0.7.0.1
 */