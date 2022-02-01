package com.tencent.mm.plugin.story.f.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.m;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.i.a.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ddu;
import com.tencent.mm.protocal.protobuf.ddv;
import com.tencent.mm.protocal.protobuf.ddw;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import d.n.d;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "(Ljava/lang/String;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "deleteFaultdData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "existFaultData", "getType", "insertList", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryPageResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
  public static final e.a ztq;
  private com.tencent.mm.ak.g callback;
  private boolean dfZ;
  private com.tencent.mm.ak.b rr;
  private int sourceType;
  public String userName;
  private String xRS;
  public boolean xRn;
  private long xRo;
  private long xRp;
  public long xSH;
  private long zto;
  
  static
  {
    AppMethodBeat.i(118812);
    ztq = new e.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
    AppMethodBeat.o(118812);
  }
  
  public e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(118811);
    this.userName = paramString;
    this.xRo = paramLong;
    this.dfZ = paramBoolean;
    this.xRS = "";
    if (this.xRo == 0L) {
      ac.i(TAG, "fp mUserName " + this.userName);
    }
    int j;
    for (;;)
    {
      paramString = com.tencent.mm.plugin.story.i.a.zBQ;
      j = com.tencent.mm.plugin.story.i.a.dYk();
      paramString = com.tencent.mm.plugin.story.i.a.zBQ;
      this.sourceType = (j | com.tencent.mm.plugin.story.i.a.dYi());
      paramString = new b.a();
      paramString.c((com.tencent.mm.bw.a)new ddv());
      paramString.d((com.tencent.mm.bw.a)new ddw());
      paramString.Am("/cgi-bin/micromsg-bin/mmstoryhistorypage");
      paramString.op(191);
      paramString.or(0);
      paramString.os(0);
      paramString = paramString.aAz();
      d.g.b.k.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = this.rr.aBC();
      if (paramString != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageRequest");
      AppMethodBeat.o(118811);
      throw paramString;
      ac.i(TAG, "np mUserName " + this.userName);
    }
    paramString = (ddv)paramString;
    paramString.ncR = this.userName;
    paramString.FJn = this.xRo;
    Object localObject;
    if (this.xRo == 0L)
    {
      paramBoolean = true;
      this.xRn = paramBoolean;
      localObject = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVN();
      j = o.a.awH(this.userName);
      localObject = com.tencent.mm.plugin.story.f.j.zsh;
      localObject = j.b.dVE();
      if (!this.xRn) {
        break label531;
      }
    }
    label531:
    for (paramLong = l;; paramLong = this.xRo)
    {
      this.xRp = ((com.tencent.mm.plugin.story.i.k)localObject).V(paramLong, j);
      paramString.FKy = this.xRp;
      paramString.FKz = 0;
      try
      {
        localObject = bs.eWc();
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
      paramString.pAT = i;
      if (this.xRn)
      {
        localObject = com.tencent.mm.plugin.story.f.j.zsh;
        localObject = j.b.dVF();
        locala = com.tencent.mm.plugin.story.i.a.zBQ;
        this.xRS = ((com.tencent.mm.plugin.story.i.g)localObject).axc(com.tencent.mm.plugin.story.i.a.dYo());
        if (this.xRS == null) {
          this.xRS = "";
        }
        paramString.FJm = this.xRS;
      }
      this.zto = this.xRo;
      ac.i(TAG, "req.mUserName:" + paramString.ncR + " req.MaxId:" + paramString.FJn + " req.MinFilterId:" + paramString.FKy + " req.LastRequestTime:" + paramString.FKz + " req.FirstPageMd5:" + paramString.FJm + " req.TimeZone:" + paramString.pAT);
      AppMethodBeat.o(118811);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final void a(ddw paramddw)
  {
    AppMethodBeat.i(118810);
    Object localObject1 = paramddw.FNA;
    d.g.b.k.g(localObject1, "resp.HistoryItemList");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      ddu localddu = (ddu)localIterator.next();
      ac.d(TAG, "date=" + localddu.EvH + " count=" + localddu.FMU + " id=" + localddu.Id);
      localObject1 = com.tencent.mm.plugin.story.f.n.zsw;
      Object localObject4 = this.userName;
      Object localObject3 = localddu.FNl;
      d.g.b.k.g(localObject3, "it.StoryObject");
      int i = this.sourceType;
      d.g.b.k.h(localObject4, "userName");
      d.g.b.k.h(localObject3, "storyObj");
      localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      localObject1 = j.b.dVE();
      ac.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "insertStory storyObj.id:" + ((def)localObject3).Id);
      Object localObject2 = ((com.tencent.mm.plugin.story.i.k)localObject1).yw(((def)localObject3).Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      d.g.b.k.h(localObject1, "storyInfo");
      d.g.b.k.h(localObject3, "storyObj");
      d.g.b.k.h(localObject4, "userName");
      if ((((def)localObject3).FNN == null) || (((def)localObject3).FNN.getBuffer() == null)) {
        ac.i(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "object desc is null");
      }
      for (;;)
      {
        localObject1 = m.zsv;
        d.g.b.k.g(localddu, "it");
        d.g.b.k.h(localddu, "item");
        localObject1 = h.zCA;
        d.g.b.k.h(localddu, "item");
        localObject3 = new h();
        localObject2 = localddu.EvH;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((h)localObject3).field_date = ((String)localObject1);
        ((h)localObject3).field_count = localddu.FMU;
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dVJ().a((h)localObject3);
        break;
        localObject2 = ((def)localObject3).FNN.getBuffer().toByteArray();
        d.g.b.k.g(localObject2, "storyObj.ObjDesc.getBuffer().toByteArray()");
        localObject2 = new String((byte[])localObject2, d.UTF_8);
        ac.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "from server %d \n%s", new Object[] { Long.valueOf(((def)localObject3).Id), localObject2 });
        localObject4 = com.tencent.mm.plugin.story.f.q.zsy;
        localObject4 = q.a.awJ((String)localObject2);
        if ((!bs.isNullOrNil((String)localObject2)) && (localObject4 != null) && (((com.tencent.mm.plugin.story.i.j)localObject1).c((dep)localObject4)))
        {
          ac.d(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "from server xml ok %d \n ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(((def)localObject3).Id) });
          ((def)localObject3).FNN.setBuffer(new byte[0]);
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = ((def)localObject3).ncR;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = ((def)localObject3).CreateTime;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = ((def)localObject3).Id;
          if (!((def)localObject3).FNO.isEmpty()) {
            ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = ((def)localObject3).toByteArray();
          }
          ac.i(com.tencent.mm.plugin.story.f.n.access$getTAG$cp(), "id:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID + " createTime:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime + " CommentListSize:" + ((def)localObject3).FNO.size() + " BubbleListSize:" + ((def)localObject3).FNQ.size());
          ((com.tencent.mm.plugin.story.i.j)localObject1).Pb(i);
          localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).dZi();
          ((dep)localObject2).ncR = ((def)localObject3).ncR;
          ((com.tencent.mm.plugin.story.i.j)localObject1).b((dep)localObject2);
          localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
          localObject2 = j.b.dVE();
          long l = ((def)localObject3).Id;
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
            localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
            j.b.dVE().e((com.tencent.mm.plugin.story.i.j)localObject1);
            localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
            j.b.dVE().yz(((def)localObject3).Id);
            break;
          }
          label803:
          localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dVE().f((com.tencent.mm.plugin.story.i.j)localObject1);
        }
      }
    }
    if (this.xRo == 0L)
    {
      localObject1 = paramddw.FNA;
      d.g.b.k.g(localObject1, "resp.HistoryItemList");
      this.xRo = ((ddu)((LinkedList)localObject1).getFirst()).Id;
    }
    localObject1 = paramddw.FNA;
    d.g.b.k.g(localObject1, "resp.HistoryItemList");
    this.xRp = ((ddu)((LinkedList)localObject1).getLast()).Id;
    ac.i(TAG, "insertList mUserName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.xRo), Long.valueOf(this.xRp), Integer.valueOf(paramddw.FKH) });
    AppMethodBeat.o(118810);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    paramq = this.rr.aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageResponse");
      AppMethodBeat.o(118809);
      throw paramString;
    }
    ddw localddw = (ddw)paramq;
    this.xSH = localddw.FNn;
    paramArrayOfByte = localddw.FJm;
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = "";
    }
    ac.i(TAG, "objCount:" + localddw.FNz + " firstPageMd5:" + paramq + ", expiredTime:" + localddw.DLH);
    if (localddw.FNA.isEmpty())
    {
      ac.i(TAG, "server give size zero");
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118809);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.story.f.j.zsh;
    paramArrayOfByte = j.b.dVF();
    a.a locala = com.tencent.mm.plugin.story.i.a.zBQ;
    paramArrayOfByte.jR(com.tencent.mm.plugin.story.i.a.dYo(), paramq);
    long l;
    if (this.xRn)
    {
      l = ((ddu)localddw.FNA.get(localddw.FNA.size() - 1)).Id;
      paramq = com.tencent.mm.plugin.story.f.n.zsw;
      if (l <= n.a.awG(this.userName).field_storyID) {
        break label551;
      }
    }
    label551:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        l = ((ddu)localddw.FNA.get(localddw.FNA.size() - 1)).Id;
        paramq = this.userName;
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.zsh;
        if (bs.lr(paramq, j.b.dHx()))
        {
          paramq = com.tencent.mm.plugin.story.f.n.zsw;
          paramq = this.userName;
          d.g.b.k.h(paramq, "userName");
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.zsh;
          paramArrayOfByte = j.b.dVE();
          locala = com.tencent.mm.plugin.story.i.a.zBQ;
          paramInt1 = com.tencent.mm.plugin.story.i.a.dYi();
          d.g.b.k.h(paramq, "userName");
          paramq = "UPDATE " + com.tencent.mm.plugin.story.i.k.TABLE + " SET sourceType = " + paramInt1 + " Where userName = '" + paramq + "' AND storyID < " + l;
          ac.d(com.tencent.mm.plugin.story.i.k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(paramq)));
          paramArrayOfByte.db.execSQL(com.tencent.mm.plugin.story.i.k.TABLE, paramq);
        }
      }
      a(localddw);
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118809);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.e
 * JD-Core Version:    0.7.0.1
 */