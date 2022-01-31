package com.tencent.mm.plugin.story.model.a;

import a.l;
import a.l.d;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.story.h.a.a;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.model.o.a;
import com.tencent.mm.plugin.story.model.q.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "(Ljava/lang/String;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "deleteFaultdData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "existFaultData", "getType", "insertList", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryPageResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class f
  extends com.tencent.mm.ai.m
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
  public static final f.a sxg;
  private com.tencent.mm.ai.f callback;
  private int cpG;
  private boolean ctJ;
  public boolean rew;
  private long rex;
  private long rey;
  public long rfK;
  private String rfa;
  private com.tencent.mm.ai.b rr;
  private long sxe;
  public String userName;
  
  static
  {
    AppMethodBeat.i(109229);
    sxg = new f.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
    AppMethodBeat.o(109229);
  }
  
  public f(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(109228);
    this.userName = paramString;
    this.rex = paramLong;
    this.ctJ = paramBoolean;
    this.rfa = "";
    if (this.rex == 0L) {
      ab.i(TAG, "fp mUserName " + this.userName);
    }
    int j;
    for (;;)
    {
      paramString = com.tencent.mm.plugin.story.h.a.sFV;
      j = com.tencent.mm.plugin.story.h.a.cDQ();
      paramString = com.tencent.mm.plugin.story.h.a.sFV;
      this.cpG = (j | com.tencent.mm.plugin.story.h.a.cDO());
      paramString = new b.a();
      paramString.a((com.tencent.mm.bv.a)new chh());
      paramString.b((com.tencent.mm.bv.a)new chi());
      paramString.rl("/cgi-bin/micromsg-bin/mmstoryhistorypage");
      paramString.kT(191);
      paramString.kU(0);
      paramString.kV(0);
      paramString = paramString.ado();
      a.f.b.j.p(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = this.rr.adm();
      if (paramString != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageRequest");
      AppMethodBeat.o(109228);
      throw paramString;
      ab.i(TAG, "np mUserName " + this.userName);
    }
    paramString = (chh)paramString;
    paramString.jJA = this.userName;
    paramString.xOl = this.rex;
    Object localObject;
    if (this.rex == 0L)
    {
      paramBoolean = true;
      this.rew = paramBoolean;
      localObject = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAL();
      j = o.a.adg(this.userName);
      localObject = com.tencent.mm.plugin.story.model.j.svi;
      localObject = j.b.cAB();
      if (!this.rew) {
        break label531;
      }
    }
    label531:
    for (paramLong = l;; paramLong = this.rex)
    {
      this.rey = ((com.tencent.mm.plugin.story.h.k)localObject).H(paramLong, j);
      paramString.xPt = this.rey;
      paramString.xPu = 0;
      try
      {
        localObject = bo.dtS();
        a.f.b.j.p(localObject, "Util.getTimeZoneOffset()");
        float f = Float.parseFloat((String)localObject);
        i = (int)f;
      }
      catch (Exception localException)
      {
        label359:
        a.a locala;
        break label359;
      }
      paramString.lGX = i;
      if (this.rew)
      {
        localObject = com.tencent.mm.plugin.story.model.j.svi;
        localObject = j.b.cAC();
        locala = com.tencent.mm.plugin.story.h.a.sFV;
        this.rfa = ((g)localObject).adA(com.tencent.mm.plugin.story.h.a.cDU());
        if (this.rfa == null) {
          this.rfa = "";
        }
        paramString.xOk = this.rfa;
      }
      this.sxe = this.rex;
      ab.i(TAG, "req.mUserName:" + paramString.jJA + " req.MaxId:" + paramString.xOl + " req.MinFilterId:" + paramString.xPt + " req.LastRequestTime:" + paramString.xPu + " req.FirstPageMd5:" + paramString.xOk + " req.TimeZone:" + paramString.lGX);
      AppMethodBeat.o(109228);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final void a(chi paramchi)
  {
    AppMethodBeat.i(109227);
    Object localObject1 = paramchi.xSl;
    a.f.b.j.p(localObject1, "resp.HistoryItemList");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      chg localchg = (chg)localIterator.next();
      ab.d(TAG, "date=" + localchg.xRQ + " count=" + localchg.xRy + " id=" + localchg.Id);
      localObject1 = n.svx;
      Object localObject4 = this.userName;
      Object localObject3 = localchg.xRP;
      a.f.b.j.p(localObject3, "it.StoryObject");
      int i = this.cpG;
      a.f.b.j.q(localObject4, "userName");
      a.f.b.j.q(localObject3, "storyObj");
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAB();
      ab.d(n.access$getTAG$cp(), "insertStory storyObj.id:" + ((chs)localObject3).Id);
      Object localObject2 = ((com.tencent.mm.plugin.story.h.k)localObject1).mR(((chs)localObject3).Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.h.j();
      }
      a.f.b.j.q(localObject1, "storyInfo");
      a.f.b.j.q(localObject3, "storyObj");
      a.f.b.j.q(localObject4, "userName");
      if ((((chs)localObject3).xSx == null) || (((chs)localObject3).xSx.getBuffer() == null)) {
        ab.i(n.access$getTAG$cp(), "object desc is null");
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.story.model.m.svw;
        a.f.b.j.p(localchg, "it");
        a.f.b.j.q(localchg, "item");
        localObject1 = h.sGI;
        a.f.b.j.q(localchg, "item");
        localObject3 = new h();
        localObject2 = localchg.xRQ;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((h)localObject3).field_date = ((String)localObject1);
        ((h)localObject3).field_count = localchg.xRy;
        localObject1 = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAH().a((h)localObject3);
        break;
        localObject2 = ((chs)localObject3).xSx.getBuffer().toByteArray();
        a.f.b.j.p(localObject2, "storyObj.ObjDesc.getBuffer().toByteArray()");
        localObject2 = new String((byte[])localObject2, d.UTF_8);
        ab.d(n.access$getTAG$cp(), "from server %d \n%s", new Object[] { Long.valueOf(((chs)localObject3).Id), localObject2 });
        localObject4 = com.tencent.mm.plugin.story.model.q.svz;
        localObject4 = q.a.adi((String)localObject2);
        if ((!bo.isNullOrNil((String)localObject2)) && (localObject4 != null) && (((com.tencent.mm.plugin.story.h.j)localObject1).c((cic)localObject4)))
        {
          ab.d(n.access$getTAG$cp(), "from server xml ok %d \n ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(((chs)localObject3).Id) });
          ((chs)localObject3).xSx.setBuffer(new byte[0]);
          ((com.tencent.mm.plugin.story.h.j)localObject1).field_userName = ((chs)localObject3).jJA;
          ((com.tencent.mm.plugin.story.h.j)localObject1).field_createTime = ((chs)localObject3).CreateTime;
          ((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID = ((chs)localObject3).Id;
          if (!((chs)localObject3).xSy.isEmpty()) {
            ((com.tencent.mm.plugin.story.h.j)localObject1).field_attrBuf = ((chs)localObject3).toByteArray();
          }
          ab.i(n.access$getTAG$cp(), "id:" + ((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID + " createTime:" + ((com.tencent.mm.plugin.story.h.j)localObject1).field_createTime + " CommentListSize:" + ((chs)localObject3).xSy.size() + " BubbleListSize:" + ((chs)localObject3).xSA.size());
          ((com.tencent.mm.plugin.story.h.j)localObject1).Eu(i);
          localObject2 = ((com.tencent.mm.plugin.story.h.j)localObject1).cEY();
          ((cic)localObject2).jJA = ((chs)localObject3).jJA;
          ((com.tencent.mm.plugin.story.h.j)localObject1).b((cic)localObject2);
          localObject2 = com.tencent.mm.plugin.story.model.j.svi;
          if (j.b.cAB().lR(((chs)localObject3).Id))
          {
            localObject2 = com.tencent.mm.plugin.story.model.j.svi;
            j.b.cAB().b(((chs)localObject3).Id, (com.tencent.mm.plugin.story.h.j)localObject1);
            localObject1 = com.tencent.mm.plugin.story.model.j.svi;
            j.b.cAB().mV(((chs)localObject3).Id);
          }
          else
          {
            localObject2 = com.tencent.mm.plugin.story.model.j.svi;
            j.b.cAB().e((com.tencent.mm.plugin.story.h.j)localObject1);
          }
        }
      }
    }
    if (this.rex == 0L)
    {
      localObject1 = paramchi.xSl;
      a.f.b.j.p(localObject1, "resp.HistoryItemList");
      this.rex = ((chg)((LinkedList)localObject1).getFirst()).Id;
    }
    localObject1 = paramchi.xSl;
    a.f.b.j.p(localObject1, "resp.HistoryItemList");
    this.rey = ((chg)((LinkedList)localObject1).getLast()).Id;
    ab.i(TAG, "insertList mUserName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.rex), Long.valueOf(this.rey), Integer.valueOf(paramchi.xPz) });
    AppMethodBeat.o(109227);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(109225);
    a.f.b.j.q(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(109225);
    return i;
  }
  
  public final int getType()
  {
    return 191;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109226);
    ab.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    paramq = this.rr.adn();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageResponse");
      AppMethodBeat.o(109226);
      throw paramString;
    }
    chi localchi = (chi)paramq;
    this.rfK = localchi.xRS;
    paramArrayOfByte = localchi.xOk;
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = "";
    }
    ab.i(TAG, "objCount:" + localchi.xSk + " firstPageMd5:" + paramq + ", expiredTime:" + localchi.wlc);
    if (this.rew)
    {
      paramArrayOfByte = this.userName;
      localObject = com.tencent.mm.plugin.story.model.j.svi;
      if (bo.isEqual(paramArrayOfByte, j.b.coK()))
      {
        paramArrayOfByte = n.svx;
        paramArrayOfByte = this.userName;
        a.f.b.j.q(paramArrayOfByte, "userName");
        localObject = com.tencent.mm.plugin.story.model.j.svi;
        localObject = j.b.cAB();
        a.a locala = com.tencent.mm.plugin.story.h.a.sFV;
        paramInt1 = com.tencent.mm.plugin.story.h.a.cDO();
        a.f.b.j.q(paramArrayOfByte, "userName");
        paramArrayOfByte = "UPDATE " + com.tencent.mm.plugin.story.h.k.sGE + " SET sourceType = " + paramInt1 + " Where userName = '" + paramArrayOfByte + "' AND storyID < 0";
        ab.d(com.tencent.mm.plugin.story.h.k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(paramArrayOfByte)));
        ((com.tencent.mm.plugin.story.h.k)localObject).db.execSQL(com.tencent.mm.plugin.story.h.k.sGE, paramArrayOfByte);
      }
    }
    if (localchi.xSl.isEmpty())
    {
      ab.i(TAG, "server give size zero");
      paramq = this.callback;
      if (paramq == null) {
        a.f.b.j.ays("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ai.m)this);
      AppMethodBeat.o(109226);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.story.model.j.svi;
    paramArrayOfByte = j.b.cAC();
    Object localObject = com.tencent.mm.plugin.story.h.a.sFV;
    paramArrayOfByte.gQ(com.tencent.mm.plugin.story.h.a.cDU(), paramq);
    a(localchi);
    paramq = this.callback;
    if (paramq == null) {
      a.f.b.j.ays("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ai.m)this);
    AppMethodBeat.o(109226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.f
 * JD-Core Version:    0.7.0.1
 */