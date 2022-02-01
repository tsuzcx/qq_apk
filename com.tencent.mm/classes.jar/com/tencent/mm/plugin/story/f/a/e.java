package com.tencent.mm.plugin.story.f.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
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
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.protocal.protobuf.dkd;
import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.n.d;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "(Ljava/lang/String;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "deleteFaultdData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "existFaultData", "getType", "insertList", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryPageResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  public static final e.a BcN;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
  private long BcL;
  private f callback;
  private boolean dsB;
  private com.tencent.mm.ak.b rr;
  private int sourceType;
  public String userName;
  public boolean zxW;
  private long zxX;
  private long zxY;
  private String zyB;
  public long zzQ;
  
  static
  {
    AppMethodBeat.i(118812);
    BcN = new e.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
    AppMethodBeat.o(118812);
  }
  
  public e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(118811);
    this.userName = paramString;
    this.zxX = paramLong;
    this.dsB = paramBoolean;
    this.zyB = "";
    if (this.zxX == 0L) {
      ae.i(TAG, "fp mUserName " + this.userName);
    }
    int j;
    for (;;)
    {
      paramString = com.tencent.mm.plugin.story.i.a.BkN;
      j = com.tencent.mm.plugin.story.i.a.eoi();
      paramString = com.tencent.mm.plugin.story.i.a.BkN;
      this.sourceType = (j | com.tencent.mm.plugin.story.i.a.eog());
      paramString = new b.a();
      paramString.c((com.tencent.mm.bw.a)new dkd());
      paramString.d((com.tencent.mm.bw.a)new dke());
      paramString.DN("/cgi-bin/micromsg-bin/mmstoryhistorypage");
      paramString.oS(191);
      paramString.oU(0);
      paramString.oV(0);
      paramString = paramString.aDS();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = this.rr.aEU();
      if (paramString != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageRequest");
      AppMethodBeat.o(118811);
      throw paramString;
      ae.i(TAG, "np mUserName " + this.userName);
    }
    paramString = (dkd)paramString;
    paramString.nIJ = this.userName;
    paramString.HNy = this.zxX;
    Object localObject;
    if (this.zxX == 0L)
    {
      paramBoolean = true;
      this.zxW = paramBoolean;
      localObject = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elK();
      j = o.a.aDf(this.userName);
      localObject = com.tencent.mm.plugin.story.f.j.BbE;
      localObject = j.b.elB();
      if (!this.zxW) {
        break label531;
      }
    }
    label531:
    for (paramLong = l;; paramLong = this.zxX)
    {
      this.zxY = ((com.tencent.mm.plugin.story.i.k)localObject).aa(paramLong, j);
      paramString.HOJ = this.zxY;
      paramString.HOK = 0;
      try
      {
        localObject = bu.fpH();
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
      paramString.qld = i;
      if (this.zxW)
      {
        localObject = com.tencent.mm.plugin.story.f.j.BbE;
        localObject = j.b.elC();
        locala = com.tencent.mm.plugin.story.i.a.BkN;
        this.zyB = ((g)localObject).aDz(com.tencent.mm.plugin.story.i.a.eom());
        if (this.zyB == null) {
          this.zyB = "";
        }
        paramString.HNx = this.zyB;
      }
      this.BcL = this.zxX;
      ae.i(TAG, "req.mUserName:" + paramString.nIJ + " req.MaxId:" + paramString.HNy + " req.MinFilterId:" + paramString.HOJ + " req.LastRequestTime:" + paramString.HOK + " req.FirstPageMd5:" + paramString.HNx + " req.TimeZone:" + paramString.qld);
      AppMethodBeat.o(118811);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final void a(dke paramdke)
  {
    AppMethodBeat.i(118810);
    Object localObject1 = paramdke.HRW;
    p.g(localObject1, "resp.HistoryItemList");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      dkc localdkc = (dkc)localIterator.next();
      ae.d(TAG, "date=" + localdkc.GvK + " count=" + localdkc.HRq + " id=" + localdkc.Id);
      localObject1 = com.tencent.mm.plugin.story.f.n.BbT;
      Object localObject4 = this.userName;
      Object localObject3 = localdkc.HRH;
      p.g(localObject3, "it.StoryObject");
      int i = this.sourceType;
      p.h(localObject4, "userName");
      p.h(localObject3, "storyObj");
      localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      localObject1 = j.b.elB();
      ae.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "insertStory storyObj.id:" + ((dkn)localObject3).Id);
      Object localObject2 = ((com.tencent.mm.plugin.story.i.k)localObject1).Bs(((dkn)localObject3).Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      p.h(localObject1, "storyInfo");
      p.h(localObject3, "storyObj");
      p.h(localObject4, "userName");
      if ((((dkn)localObject3).HSj == null) || (((dkn)localObject3).HSj.getBuffer() == null)) {
        ae.i(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "object desc is null");
      }
      for (;;)
      {
        localObject1 = m.BbS;
        p.g(localdkc, "it");
        p.h(localdkc, "item");
        localObject1 = h.Blx;
        p.h(localdkc, "item");
        localObject3 = new h();
        localObject2 = localdkc.GvK;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((h)localObject3).field_date = ((String)localObject1);
        ((h)localObject3).field_count = localdkc.HRq;
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.elG().a((h)localObject3);
        break;
        localObject2 = ((dkn)localObject3).HSj.getBuffer().toByteArray();
        p.g(localObject2, "storyObj.ObjDesc.getBuffer().toByteArray()");
        localObject2 = new String((byte[])localObject2, d.UTF_8);
        ae.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "from server %d \n%s", new Object[] { Long.valueOf(((dkn)localObject3).Id), localObject2 });
        localObject4 = com.tencent.mm.plugin.story.f.q.BbV;
        localObject4 = q.a.aDg((String)localObject2);
        if ((!bu.isNullOrNil((String)localObject2)) && (localObject4 != null) && (((com.tencent.mm.plugin.story.i.j)localObject1).c((dkx)localObject4)))
        {
          ae.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "from server xml ok %d \n ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(((dkn)localObject3).Id) });
          ((dkn)localObject3).HSj.setBuffer(new byte[0]);
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = ((dkn)localObject3).nIJ;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = ((dkn)localObject3).CreateTime;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = ((dkn)localObject3).Id;
          if (!((dkn)localObject3).HSk.isEmpty()) {
            ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = ((dkn)localObject3).toByteArray();
          }
          ae.i(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "id:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID + " createTime:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime + " CommentListSize:" + ((dkn)localObject3).HSk.size() + " BubbleListSize:" + ((dkn)localObject3).HSm.size());
          ((com.tencent.mm.plugin.story.i.j)localObject1).Rq(i);
          localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).epg();
          ((dkx)localObject2).nIJ = ((dkn)localObject3).nIJ;
          ((com.tencent.mm.plugin.story.i.j)localObject1).b((dkx)localObject2);
          localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
          localObject2 = j.b.elB();
          long l = ((dkn)localObject3).Id;
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
            localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
            j.b.elB().e((com.tencent.mm.plugin.story.i.j)localObject1);
            localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
            j.b.elB().Bv(((dkn)localObject3).Id);
            break;
          }
          label803:
          localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.elB().f((com.tencent.mm.plugin.story.i.j)localObject1);
        }
      }
    }
    if (this.zxX == 0L)
    {
      localObject1 = paramdke.HRW;
      p.g(localObject1, "resp.HistoryItemList");
      this.zxX = ((dkc)((LinkedList)localObject1).getFirst()).Id;
    }
    localObject1 = paramdke.HRW;
    p.g(localObject1, "resp.HistoryItemList");
    this.zxY = ((dkc)((LinkedList)localObject1).getLast()).Id;
    ae.i(TAG, "insertList mUserName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.zxX), Long.valueOf(this.zxY), Integer.valueOf(paramdke.HOS) });
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
    ae.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    paramq = this.rr.aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageResponse");
      AppMethodBeat.o(118809);
      throw paramString;
    }
    dke localdke = (dke)paramq;
    this.zzQ = localdke.HRJ;
    paramArrayOfByte = localdke.HNx;
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = "";
    }
    ae.i(TAG, "objCount:" + localdke.HRV + " firstPageMd5:" + paramq + ", expiredTime:" + localdke.FJk);
    if (localdke.HRW.isEmpty())
    {
      ae.i(TAG, "server give size zero");
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118809);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.story.f.j.BbE;
    paramArrayOfByte = j.b.elC();
    a.a locala = com.tencent.mm.plugin.story.i.a.BkN;
    paramArrayOfByte.jV(com.tencent.mm.plugin.story.i.a.eom(), paramq);
    long l;
    if (this.zxW)
    {
      l = ((dkc)localdke.HRW.get(localdke.HRW.size() - 1)).Id;
      paramq = com.tencent.mm.plugin.story.f.n.BbT;
      if (l <= n.a.aDe(this.userName).field_storyID) {
        break label551;
      }
    }
    label551:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        l = ((dkc)localdke.HRW.get(localdke.HRW.size() - 1)).Id;
        paramq = this.userName;
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.BbE;
        if (bu.lX(paramq, j.b.dXj()))
        {
          paramq = com.tencent.mm.plugin.story.f.n.BbT;
          paramq = this.userName;
          p.h(paramq, "userName");
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.BbE;
          paramArrayOfByte = j.b.elB();
          locala = com.tencent.mm.plugin.story.i.a.BkN;
          paramInt1 = com.tencent.mm.plugin.story.i.a.eog();
          p.h(paramq, "userName");
          paramq = "UPDATE " + com.tencent.mm.plugin.story.i.k.TABLE + " SET sourceType = " + paramInt1 + " Where userName = '" + paramq + "' AND storyID < " + l;
          ae.d(com.tencent.mm.plugin.story.i.k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(paramq)));
          paramArrayOfByte.db.execSQL(com.tencent.mm.plugin.story.i.k.TABLE, paramq);
        }
      }
      a(localdke);
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118809);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.e
 * JD-Core Version:    0.7.0.1
 */