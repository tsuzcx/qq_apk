package com.tencent.mm.plugin.story.f.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.m;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.i.a.a;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.n.d;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "(Ljava/lang/String;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "deleteFaultdData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "existFaultData", "getType", "insertList", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryPageResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  public static final e.a ALk;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
  private long ALi;
  private f callback;
  private boolean drv;
  private com.tencent.mm.al.b rr;
  private int sourceType;
  public String userName;
  private String zhM;
  public boolean zhh;
  private long zhi;
  private long zhj;
  public long ziB;
  
  static
  {
    AppMethodBeat.i(118812);
    ALk = new e.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
    AppMethodBeat.o(118812);
  }
  
  public e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(118811);
    this.userName = paramString;
    this.zhi = paramLong;
    this.drv = paramBoolean;
    this.zhM = "";
    if (this.zhi == 0L) {
      ad.i(TAG, "fp mUserName " + this.userName);
    }
    int j;
    for (;;)
    {
      paramString = com.tencent.mm.plugin.story.i.a.ATp;
      j = com.tencent.mm.plugin.story.i.a.ekz();
      paramString = com.tencent.mm.plugin.story.i.a.ATp;
      this.sourceType = (j | com.tencent.mm.plugin.story.i.a.ekx());
      paramString = new b.a();
      paramString.c((com.tencent.mm.bx.a)new dji());
      paramString.d((com.tencent.mm.bx.a)new djj());
      paramString.Dl("/cgi-bin/micromsg-bin/mmstoryhistorypage");
      paramString.oP(191);
      paramString.oR(0);
      paramString.oS(0);
      paramString = paramString.aDC();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = this.rr.aEE();
      if (paramString != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageRequest");
      AppMethodBeat.o(118811);
      throw paramString;
      ad.i(TAG, "np mUserName " + this.userName);
    }
    paramString = (dji)paramString;
    paramString.nDo = this.userName;
    paramString.HtV = this.zhi;
    Object localObject;
    if (this.zhi == 0L)
    {
      paramBoolean = true;
      this.zhh = paramBoolean;
      localObject = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.eic();
      j = o.a.aBM(this.userName);
      localObject = com.tencent.mm.plugin.story.f.j.AKb;
      localObject = j.b.ehT();
      if (!this.zhh) {
        break label531;
      }
    }
    label531:
    for (paramLong = l;; paramLong = this.zhi)
    {
      this.zhj = ((com.tencent.mm.plugin.story.i.k)localObject).aa(paramLong, j);
      paramString.Hvg = this.zhj;
      paramString.Hvh = 0;
      try
      {
        localObject = bt.flM();
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
      paramString.qey = i;
      if (this.zhh)
      {
        localObject = com.tencent.mm.plugin.story.f.j.AKb;
        localObject = j.b.ehU();
        locala = com.tencent.mm.plugin.story.i.a.ATp;
        this.zhM = ((g)localObject).aCg(com.tencent.mm.plugin.story.i.a.ekD());
        if (this.zhM == null) {
          this.zhM = "";
        }
        paramString.HtU = this.zhM;
      }
      this.ALi = this.zhi;
      ad.i(TAG, "req.mUserName:" + paramString.nDo + " req.MaxId:" + paramString.HtV + " req.MinFilterId:" + paramString.Hvg + " req.LastRequestTime:" + paramString.Hvh + " req.FirstPageMd5:" + paramString.HtU + " req.TimeZone:" + paramString.qey);
      AppMethodBeat.o(118811);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final void a(djj paramdjj)
  {
    AppMethodBeat.i(118810);
    Object localObject1 = paramdjj.Hyl;
    p.g(localObject1, "resp.HistoryItemList");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      djh localdjh = (djh)localIterator.next();
      ad.d(TAG, "date=" + localdjh.Gdd + " count=" + localdjh.HxF + " id=" + localdjh.Id);
      localObject1 = com.tencent.mm.plugin.story.f.n.AKq;
      Object localObject4 = this.userName;
      Object localObject3 = localdjh.HxW;
      p.g(localObject3, "it.StoryObject");
      int i = this.sourceType;
      p.h(localObject4, "userName");
      p.h(localObject3, "storyObj");
      localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      localObject1 = j.b.ehT();
      ad.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "insertStory storyObj.id:" + ((djs)localObject3).Id);
      Object localObject2 = ((com.tencent.mm.plugin.story.i.k)localObject1).AU(((djs)localObject3).Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      p.h(localObject1, "storyInfo");
      p.h(localObject3, "storyObj");
      p.h(localObject4, "userName");
      if ((((djs)localObject3).Hyy == null) || (((djs)localObject3).Hyy.getBuffer() == null)) {
        ad.i(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "object desc is null");
      }
      for (;;)
      {
        localObject1 = m.AKp;
        p.g(localdjh, "it");
        p.h(localdjh, "item");
        localObject1 = h.ATZ;
        p.h(localdjh, "item");
        localObject3 = new h();
        localObject2 = localdjh.Gdd;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((h)localObject3).field_date = ((String)localObject1);
        ((h)localObject3).field_count = localdjh.HxF;
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.ehY().a((h)localObject3);
        break;
        localObject2 = ((djs)localObject3).Hyy.getBuffer().toByteArray();
        p.g(localObject2, "storyObj.ObjDesc.getBuffer().toByteArray()");
        localObject2 = new String((byte[])localObject2, d.UTF_8);
        ad.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "from server %d \n%s", new Object[] { Long.valueOf(((djs)localObject3).Id), localObject2 });
        localObject4 = com.tencent.mm.plugin.story.f.q.AKs;
        localObject4 = q.a.aBN((String)localObject2);
        if ((!bt.isNullOrNil((String)localObject2)) && (localObject4 != null) && (((com.tencent.mm.plugin.story.i.j)localObject1).c((dkc)localObject4)))
        {
          ad.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "from server xml ok %d \n ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(((djs)localObject3).Id) });
          ((djs)localObject3).Hyy.setBuffer(new byte[0]);
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = ((djs)localObject3).nDo;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = ((djs)localObject3).CreateTime;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = ((djs)localObject3).Id;
          if (!((djs)localObject3).Hyz.isEmpty()) {
            ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = ((djs)localObject3).toByteArray();
          }
          ad.i(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "id:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID + " createTime:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime + " CommentListSize:" + ((djs)localObject3).Hyz.size() + " BubbleListSize:" + ((djs)localObject3).HyB.size());
          ((com.tencent.mm.plugin.story.i.j)localObject1).QJ(i);
          localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).elx();
          ((dkc)localObject2).nDo = ((djs)localObject3).nDo;
          ((com.tencent.mm.plugin.story.i.j)localObject1).b((dkc)localObject2);
          localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
          localObject2 = j.b.ehT();
          long l = ((djs)localObject3).Id;
          localObject4 = "select *,rowid from MMStoryInfo  where " + com.tencent.mm.plugin.story.i.k.TABLE + ".storyID = " + l;
          localObject2 = ((com.tencent.mm.plugin.story.i.k)localObject2).db.rawQuery((String)localObject4, null);
          p.g(localObject2, "cu");
          i = ((Cursor)localObject2).getCount();
          ((Cursor)localObject2).close();
          if (i > 0) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label803;
            }
            localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
            j.b.ehT().e((com.tencent.mm.plugin.story.i.j)localObject1);
            localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
            j.b.ehT().AX(((djs)localObject3).Id);
            break;
          }
          label803:
          localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.ehT().f((com.tencent.mm.plugin.story.i.j)localObject1);
        }
      }
    }
    if (this.zhi == 0L)
    {
      localObject1 = paramdjj.Hyl;
      p.g(localObject1, "resp.HistoryItemList");
      this.zhi = ((djh)((LinkedList)localObject1).getFirst()).Id;
    }
    localObject1 = paramdjj.Hyl;
    p.g(localObject1, "resp.HistoryItemList");
    this.zhj = ((djh)((LinkedList)localObject1).getLast()).Id;
    ad.i(TAG, "insertList mUserName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.zhi), Long.valueOf(this.zhj), Integer.valueOf(paramdjj.Hvp) });
    AppMethodBeat.o(118810);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(118808);
    p.h(paramf, "callback");
    this.callback = paramf;
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
    paramq = this.rr.aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageResponse");
      AppMethodBeat.o(118809);
      throw paramString;
    }
    djj localdjj = (djj)paramq;
    this.ziB = localdjj.HxY;
    paramArrayOfByte = localdjj.HtU;
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = "";
    }
    ad.i(TAG, "objCount:" + localdjj.Hyk + " firstPageMd5:" + paramq + ", expiredTime:" + localdjj.FqM);
    if (localdjj.Hyl.isEmpty())
    {
      ad.i(TAG, "server give size zero");
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118809);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.story.f.j.AKb;
    paramArrayOfByte = j.b.ehU();
    a.a locala = com.tencent.mm.plugin.story.i.a.ATp;
    paramArrayOfByte.kg(com.tencent.mm.plugin.story.i.a.ekD(), paramq);
    long l;
    if (this.zhh)
    {
      l = ((djh)localdjj.Hyl.get(localdjj.Hyl.size() - 1)).Id;
      paramq = com.tencent.mm.plugin.story.f.n.AKq;
      if (l <= n.a.aBL(this.userName).field_storyID) {
        break label551;
      }
    }
    label551:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        l = ((djh)localdjj.Hyl.get(localdjj.Hyl.size() - 1)).Id;
        paramq = this.userName;
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.AKb;
        if (bt.lQ(paramq, j.b.dTJ()))
        {
          paramq = com.tencent.mm.plugin.story.f.n.AKq;
          paramq = this.userName;
          p.h(paramq, "userName");
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.AKb;
          paramArrayOfByte = j.b.ehT();
          locala = com.tencent.mm.plugin.story.i.a.ATp;
          paramInt1 = com.tencent.mm.plugin.story.i.a.ekx();
          p.h(paramq, "userName");
          paramq = "UPDATE " + com.tencent.mm.plugin.story.i.k.TABLE + " SET sourceType = " + paramInt1 + " Where userName = '" + paramq + "' AND storyID < " + l;
          ad.d(com.tencent.mm.plugin.story.i.k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(paramq)));
          paramArrayOfByte.db.execSQL(com.tencent.mm.plugin.story.i.k.TABLE, paramq);
        }
      }
      a(localdjj);
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118809);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.e
 * JD-Core Version:    0.7.0.1
 */