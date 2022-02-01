package com.tencent.mm.plugin.story.f.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.m;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.i.a.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.cyj;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import d.n.d;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "(Ljava/lang/String;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "deleteFaultdData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "existFaultData", "getType", "insertList", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryPageResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
  public static final a ygq;
  private com.tencent.mm.al.g callback;
  private boolean diE;
  private com.tencent.mm.al.b rr;
  private int sourceType;
  public String userName;
  public boolean wES;
  private long wET;
  private long wEU;
  private String wFy;
  public long wGn;
  private long ygo;
  
  static
  {
    AppMethodBeat.i(118812);
    ygq = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
    AppMethodBeat.o(118812);
  }
  
  public e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(118811);
    this.userName = paramString;
    this.wET = paramLong;
    this.diE = paramBoolean;
    this.wFy = "";
    if (this.wET == 0L) {
      ad.i(TAG, "fp mUserName " + this.userName);
    }
    int j;
    for (;;)
    {
      paramString = com.tencent.mm.plugin.story.i.a.yor;
      j = com.tencent.mm.plugin.story.i.a.dJJ();
      paramString = com.tencent.mm.plugin.story.i.a.yor;
      this.sourceType = (j | com.tencent.mm.plugin.story.i.a.dJH());
      paramString = new b.a();
      paramString.c((com.tencent.mm.bx.a)new cyj());
      paramString.d((com.tencent.mm.bx.a)new cyk());
      paramString.wg("/cgi-bin/micromsg-bin/mmstoryhistorypage");
      paramString.nB(191);
      paramString.nD(0);
      paramString.nE(0);
      paramString = paramString.atI();
      d.g.b.k.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = this.rr.auL();
      if (paramString != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageRequest");
      AppMethodBeat.o(118811);
      throw paramString;
      ad.i(TAG, "np mUserName " + this.userName);
    }
    paramString = (cyj)paramString;
    paramString.mAQ = this.userName;
    paramString.Emo = this.wET;
    Object localObject;
    if (this.wET == 0L)
    {
      paramBoolean = true;
      this.wES = paramBoolean;
      localObject = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHm();
      j = o.a.ary(this.userName);
      localObject = com.tencent.mm.plugin.story.f.j.yfh;
      localObject = j.b.dHd();
      if (!this.wES) {
        break label531;
      }
    }
    label531:
    for (paramLong = l;; paramLong = this.wET)
    {
      this.wEU = ((com.tencent.mm.plugin.story.i.k)localObject).S(paramLong, j);
      paramString.Enz = this.wEU;
      paramString.EnA = 0;
      try
      {
        localObject = bt.eGH();
        d.g.b.k.g(localObject, "Util.getTimeZoneOffset()");
        float f = Float.parseFloat((String)localObject);
        i = (int)f;
      }
      catch (Exception localException)
      {
        label359:
        a.a locala;
        break label359;
      }
      paramString.oXI = i;
      if (this.wES)
      {
        localObject = com.tencent.mm.plugin.story.f.j.yfh;
        localObject = j.b.dHe();
        locala = com.tencent.mm.plugin.story.i.a.yor;
        this.wFy = ((com.tencent.mm.plugin.story.i.g)localObject).arT(com.tencent.mm.plugin.story.i.a.dJN());
        if (this.wFy == null) {
          this.wFy = "";
        }
        paramString.Emn = this.wFy;
      }
      this.ygo = this.wET;
      ad.i(TAG, "req.mUserName:" + paramString.mAQ + " req.MaxId:" + paramString.Emo + " req.MinFilterId:" + paramString.Enz + " req.LastRequestTime:" + paramString.EnA + " req.FirstPageMd5:" + paramString.Emn + " req.TimeZone:" + paramString.oXI);
      AppMethodBeat.o(118811);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final void a(cyk paramcyk)
  {
    AppMethodBeat.i(118810);
    Object localObject1 = paramcyk.Eqy;
    d.g.b.k.g(localObject1, "resp.HistoryItemList");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      cyi localcyi = (cyi)localIterator.next();
      ad.d(TAG, "date=" + localcyi.DcA + " count=" + localcyi.EpS + " id=" + localcyi.Id);
      localObject1 = com.tencent.mm.plugin.story.f.n.yfw;
      Object localObject4 = this.userName;
      Object localObject3 = localcyi.Eqj;
      d.g.b.k.g(localObject3, "it.StoryObject");
      int i = this.sourceType;
      d.g.b.k.h(localObject4, "userName");
      d.g.b.k.h(localObject3, "storyObj");
      localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      localObject1 = j.b.dHd();
      ad.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "insertStory storyObj.id:" + ((cyt)localObject3).Id);
      Object localObject2 = ((com.tencent.mm.plugin.story.i.k)localObject1).tT(((cyt)localObject3).Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      d.g.b.k.h(localObject1, "storyInfo");
      d.g.b.k.h(localObject3, "storyObj");
      d.g.b.k.h(localObject4, "userName");
      if ((((cyt)localObject3).EqL == null) || (((cyt)localObject3).EqL.getBuffer() == null)) {
        ad.i(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "object desc is null");
      }
      for (;;)
      {
        localObject1 = m.yfv;
        d.g.b.k.g(localcyi, "it");
        d.g.b.k.h(localcyi, "item");
        localObject1 = h.ypb;
        d.g.b.k.h(localcyi, "item");
        localObject3 = new h();
        localObject2 = localcyi.DcA;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((h)localObject3).field_date = ((String)localObject1);
        ((h)localObject3).field_count = localcyi.EpS;
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dHi().a((h)localObject3);
        break;
        localObject2 = ((cyt)localObject3).EqL.getBuffer().toByteArray();
        d.g.b.k.g(localObject2, "storyObj.ObjDesc.getBuffer().toByteArray()");
        localObject2 = new String((byte[])localObject2, d.UTF_8);
        ad.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "from server %d \n%s", new Object[] { Long.valueOf(((cyt)localObject3).Id), localObject2 });
        localObject4 = com.tencent.mm.plugin.story.f.q.yfy;
        localObject4 = q.a.arA((String)localObject2);
        if ((!bt.isNullOrNil((String)localObject2)) && (localObject4 != null) && (((com.tencent.mm.plugin.story.i.j)localObject1).c((czd)localObject4)))
        {
          ad.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "from server xml ok %d \n ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(((cyt)localObject3).Id) });
          ((cyt)localObject3).EqL.setBuffer(new byte[0]);
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = ((cyt)localObject3).mAQ;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = ((cyt)localObject3).CreateTime;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = ((cyt)localObject3).Id;
          if (!((cyt)localObject3).EqM.isEmpty()) {
            ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = ((cyt)localObject3).toByteArray();
          }
          ad.i(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "id:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID + " createTime:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime + " CommentListSize:" + ((cyt)localObject3).EqM.size() + " BubbleListSize:" + ((cyt)localObject3).EqO.size());
          ((com.tencent.mm.plugin.story.i.j)localObject1).MY(i);
          localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).dKH();
          ((czd)localObject2).mAQ = ((cyt)localObject3).mAQ;
          ((com.tencent.mm.plugin.story.i.j)localObject1).b((czd)localObject2);
          localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
          localObject2 = j.b.dHd();
          long l = ((cyt)localObject3).Id;
          localObject4 = "select *,rowid from MMStoryInfo  where " + com.tencent.mm.plugin.story.i.k.TABLE + ".storyID = " + l;
          localObject2 = ((com.tencent.mm.plugin.story.i.k)localObject2).db.rawQuery((String)localObject4, null);
          d.g.b.k.g(localObject2, "cu");
          i = ((Cursor)localObject2).getCount();
          ((Cursor)localObject2).close();
          if (i > 0) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label803;
            }
            localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
            j.b.dHd().e((com.tencent.mm.plugin.story.i.j)localObject1);
            localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
            j.b.dHd().tW(((cyt)localObject3).Id);
            break;
          }
          label803:
          localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dHd().f((com.tencent.mm.plugin.story.i.j)localObject1);
        }
      }
    }
    if (this.wET == 0L)
    {
      localObject1 = paramcyk.Eqy;
      d.g.b.k.g(localObject1, "resp.HistoryItemList");
      this.wET = ((cyi)((LinkedList)localObject1).getFirst()).Id;
    }
    localObject1 = paramcyk.Eqy;
    d.g.b.k.g(localObject1, "resp.HistoryItemList");
    this.wEU = ((cyi)((LinkedList)localObject1).getLast()).Id;
    ad.i(TAG, "insertList mUserName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.wET), Long.valueOf(this.wEU), Integer.valueOf(paramcyk.EnI) });
    AppMethodBeat.o(118810);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(118808);
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(118808);
    return i;
  }
  
  public final int getType()
  {
    return 191;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118809);
    ad.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    paramq = this.rr.auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageResponse");
      AppMethodBeat.o(118809);
      throw paramString;
    }
    cyk localcyk = (cyk)paramq;
    this.wGn = localcyk.Eql;
    paramArrayOfByte = localcyk.Emn;
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = "";
    }
    ad.i(TAG, "objCount:" + localcyk.Eqx + " firstPageMd5:" + paramq + ", expiredTime:" + localcyk.Ctq);
    if (localcyk.Eqy.isEmpty())
    {
      ad.i(TAG, "server give size zero");
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118809);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.story.f.j.yfh;
    paramArrayOfByte = j.b.dHe();
    a.a locala = com.tencent.mm.plugin.story.i.a.yor;
    paramArrayOfByte.jt(com.tencent.mm.plugin.story.i.a.dJN(), paramq);
    long l;
    if (this.wES)
    {
      l = ((cyi)localcyk.Eqy.get(localcyk.Eqy.size() - 1)).Id;
      paramq = com.tencent.mm.plugin.story.f.n.yfw;
      if (l <= n.a.arx(this.userName).field_storyID) {
        break label551;
      }
    }
    label551:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        l = ((cyi)localcyk.Eqy.get(localcyk.Eqy.size() - 1)).Id;
        paramq = this.userName;
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.yfh;
        if (bt.kU(paramq, j.b.dta()))
        {
          paramq = com.tencent.mm.plugin.story.f.n.yfw;
          paramq = this.userName;
          d.g.b.k.h(paramq, "userName");
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.yfh;
          paramArrayOfByte = j.b.dHd();
          locala = com.tencent.mm.plugin.story.i.a.yor;
          paramInt1 = com.tencent.mm.plugin.story.i.a.dJH();
          d.g.b.k.h(paramq, "userName");
          paramq = "UPDATE " + com.tencent.mm.plugin.story.i.k.TABLE + " SET sourceType = " + paramInt1 + " Where userName = '" + paramq + "' AND storyID < " + l;
          ad.d(com.tencent.mm.plugin.story.i.k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(paramq)));
          paramArrayOfByte.db.execSQL(com.tencent.mm.plugin.story.i.k.TABLE, paramq);
        }
      }
      a(localcyk);
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118809);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.e
 * JD-Core Version:    0.7.0.1
 */