package com.tencent.mm.plugin.story.f.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.i.a.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.enq;
import com.tencent.mm.protocal.protobuf.enr;
import com.tencent.mm.protocal.protobuf.ens;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "(Ljava/lang/String;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "deleteFaultdData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "existFaultData", "getType", "insertList", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryPageResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m
{
  public static final a LHH;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
  private String JVL;
  public boolean JVe;
  private long JVf;
  private long JVg;
  public long JWB;
  private long LHF;
  private com.tencent.mm.an.i callback;
  private boolean fCB;
  private com.tencent.mm.an.d rr;
  private int sourceType;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118812);
    LHH = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryHistoryPage";
    AppMethodBeat.o(118812);
  }
  
  public e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(118811);
    this.userName = paramString;
    this.JVf = paramLong;
    this.fCB = paramBoolean;
    this.JVL = "";
    if (this.JVf == 0L) {
      Log.i(TAG, "fp mUserName " + this.userName);
    }
    int j;
    for (;;)
    {
      paramString = com.tencent.mm.plugin.story.i.a.LPG;
      j = com.tencent.mm.plugin.story.i.a.gfe();
      paramString = com.tencent.mm.plugin.story.i.a.LPG;
      this.sourceType = (j | com.tencent.mm.plugin.story.i.a.gfc());
      paramString = new d.a();
      paramString.c((com.tencent.mm.cd.a)new enr());
      paramString.d((com.tencent.mm.cd.a)new ens());
      paramString.TW("/cgi-bin/micromsg-bin/mmstoryhistorypage");
      paramString.vD(191);
      paramString.vF(0);
      paramString.vG(0);
      paramString = paramString.bgN();
      p.j(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = this.rr.bhX();
      if (paramString != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageRequest");
      AppMethodBeat.o(118811);
      throw paramString;
      Log.i(TAG, "np mUserName " + this.userName);
    }
    paramString = (enr)paramString;
    paramString.UserName = this.userName;
    paramString.UlB = this.JVf;
    Object localObject;
    if (this.JVf == 0L)
    {
      paramBoolean = true;
      this.JVe = paramBoolean;
      localObject = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcF();
      j = o.a.bde(this.userName);
      localObject = com.tencent.mm.plugin.story.f.j.LGA;
      localObject = j.b.gcw();
      if (!this.JVe) {
        break label531;
      }
    }
    label531:
    for (paramLong = l;; paramLong = this.JVf)
    {
      this.JVg = ((k)localObject).ak(paramLong, j);
      paramString.UmO = this.JVg;
      paramString.UmP = 0;
      try
      {
        localObject = Util.getTimeZoneOffset();
        p.j(localObject, "Util.getTimeZoneOffset()");
        float f = Float.parseFloat((String)localObject);
        i = (int)f;
      }
      catch (Exception localException)
      {
        label359:
        a.a locala;
        break label359;
      }
      paramString.vhG = i;
      if (this.JVe)
      {
        localObject = com.tencent.mm.plugin.story.f.j.LGA;
        localObject = j.b.gcx();
        locala = com.tencent.mm.plugin.story.i.a.LPG;
        this.JVL = ((com.tencent.mm.plugin.story.i.g)localObject).bdy(com.tencent.mm.plugin.story.i.a.gfi());
        if (this.JVL == null) {
          this.JVL = "";
        }
        paramString.UlA = this.JVL;
      }
      this.LHF = this.JVf;
      Log.i(TAG, "req.mUserName:" + paramString.UserName + " req.MaxId:" + paramString.UlB + " req.MinFilterId:" + paramString.UmO + " req.LastRequestTime:" + paramString.UmP + " req.FirstPageMd5:" + paramString.UlA + " req.TimeZone:" + paramString.vhG);
      AppMethodBeat.o(118811);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final void a(ens paramens)
  {
    AppMethodBeat.i(118810);
    Object localObject1 = paramens.Uqx;
    p.j(localObject1, "resp.HistoryItemList");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      enq localenq = (enq)localIterator.next();
      Log.d(TAG, "date=" + localenq.SsO + " count=" + localenq.UpR + " id=" + localenq.Id);
      localObject1 = n.LGO;
      Object localObject4 = this.userName;
      Object localObject3 = localenq.Uqi;
      p.j(localObject3, "it.StoryObject");
      int i = this.sourceType;
      p.k(localObject4, "userName");
      p.k(localObject3, "storyObj");
      localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      localObject1 = j.b.gcw();
      Log.d(n.access$getTAG$cp(), "insertStory storyObj.id:" + ((eob)localObject3).Id);
      Object localObject2 = ((k)localObject1).RR(((eob)localObject3).Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      p.k(localObject1, "storyInfo");
      p.k(localObject3, "storyObj");
      p.k(localObject4, "userName");
      if ((((eob)localObject3).UqL == null) || (((eob)localObject3).UqL.Tkb == null)) {
        Log.i(n.access$getTAG$cp(), "object desc is null");
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.story.f.m.LGN;
        p.j(localenq, "it");
        p.k(localenq, "item");
        localObject1 = h.LQq;
        p.k(localenq, "item");
        localObject3 = new h();
        localObject2 = localenq.SsO;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((h)localObject3).field_date = ((String)localObject1);
        ((h)localObject3).field_count = localenq.UpR;
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.gcB().a((h)localObject3);
        break;
        localObject2 = ((eob)localObject3).UqL.Tkb.toByteArray();
        p.j(localObject2, "storyObj.ObjDesc.getBuffer().toByteArray()");
        localObject2 = new String((byte[])localObject2, kotlin.n.d.UTF_8);
        Log.d(n.access$getTAG$cp(), "from server %d \n%s", new Object[] { Long.valueOf(((eob)localObject3).Id), localObject2 });
        localObject4 = com.tencent.mm.plugin.story.f.q.LGQ;
        localObject4 = q.a.bdf((String)localObject2);
        if ((!Util.isNullOrNil((String)localObject2)) && (localObject4 != null) && (((com.tencent.mm.plugin.story.i.j)localObject1).c((eol)localObject4)))
        {
          Log.d(n.access$getTAG$cp(), "from server xml ok %d \n ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(((eob)localObject3).Id) });
          ((eob)localObject3).UqL.dc(new byte[0]);
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = ((eob)localObject3).UserName;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = ((eob)localObject3).CreateTime;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = ((eob)localObject3).Id;
          if (!((eob)localObject3).UqM.isEmpty()) {
            ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = ((eob)localObject3).toByteArray();
          }
          Log.i(n.access$getTAG$cp(), "id:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID + " createTime:" + ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime + " CommentListSize:" + ((eob)localObject3).UqM.size() + " BubbleListSize:" + ((eob)localObject3).UqO.size());
          ((com.tencent.mm.plugin.story.i.j)localObject1).addSourceFlag(i);
          localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).ggc();
          ((eol)localObject2).UserName = ((eob)localObject3).UserName;
          ((com.tencent.mm.plugin.story.i.j)localObject1).b((eol)localObject2);
          localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
          localObject2 = j.b.gcw();
          long l = ((eob)localObject3).Id;
          localObject4 = "select *,rowid from MMStoryInfo  where " + k.Alf + ".storyID = " + l;
          localObject2 = ((k)localObject2).db.rawQuery((String)localObject4, null);
          p.j(localObject2, "cu");
          i = ((Cursor)localObject2).getCount();
          ((Cursor)localObject2).close();
          if (i > 0) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label803;
            }
            localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
            j.b.gcw().e((com.tencent.mm.plugin.story.i.j)localObject1);
            localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
            j.b.gcw().RU(((eob)localObject3).Id);
            break;
          }
          label803:
          localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.gcw().f((com.tencent.mm.plugin.story.i.j)localObject1);
        }
      }
    }
    if (this.JVf == 0L)
    {
      localObject1 = paramens.Uqx;
      p.j(localObject1, "resp.HistoryItemList");
      this.JVf = ((enq)((LinkedList)localObject1).getFirst()).Id;
    }
    localObject1 = paramens.Uqx;
    p.j(localObject1, "resp.HistoryItemList");
    this.JVg = ((enq)((LinkedList)localObject1).getLast()).Id;
    Log.i(TAG, "insertList mUserName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.JVf), Long.valueOf(this.JVg), Integer.valueOf(paramens.Unb) });
    AppMethodBeat.o(118810);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(118808);
    p.k(parami, "callback");
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
    params = this.rr.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageResponse");
      AppMethodBeat.o(118809);
      throw paramString;
    }
    ens localens = (ens)params;
    this.JWB = localens.Uqk;
    paramArrayOfByte = localens.UlA;
    params = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      params = "";
    }
    Log.i(TAG, "objCount:" + localens.Uqw + " firstPageMd5:" + params + ", expiredTime:" + localens.SXb);
    if (localens.Uqx.isEmpty())
    {
      Log.i(TAG, "server give size zero");
      params = this.callback;
      if (params == null) {
        p.bGy("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.an.q)this);
      AppMethodBeat.o(118809);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.story.f.j.LGA;
    paramArrayOfByte = j.b.gcx();
    a.a locala = com.tencent.mm.plugin.story.i.a.LPG;
    paramArrayOfByte.lf(com.tencent.mm.plugin.story.i.a.gfi(), params);
    long l;
    if (this.JVe)
    {
      l = ((enq)localens.Uqx.get(localens.Uqx.size() - 1)).Id;
      params = n.LGO;
      if (l <= n.a.bdd(this.userName).field_storyID) {
        break label551;
      }
    }
    label551:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        l = ((enq)localens.Uqx.get(localens.Uqx.size() - 1)).Id;
        params = this.userName;
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.LGA;
        if (Util.isEqual(params, j.b.fOo()))
        {
          params = n.LGO;
          params = this.userName;
          p.k(params, "userName");
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.LGA;
          paramArrayOfByte = j.b.gcw();
          locala = com.tencent.mm.plugin.story.i.a.LPG;
          paramInt1 = com.tencent.mm.plugin.story.i.a.gfc();
          p.k(params, "userName");
          params = "UPDATE " + k.Alf + " SET sourceType = " + paramInt1 + " Where userName = '" + params + "' AND storyID < " + l;
          Log.d(k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(params)));
          paramArrayOfByte.db.execSQL(k.Alf, params);
        }
      }
      a(localens);
      params = this.callback;
      if (params == null) {
        p.bGy("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.an.q)this);
      AppMethodBeat.o(118809);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.e
 * JD-Core Version:    0.7.0.1
 */