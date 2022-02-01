package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eem;
import com.tencent.mm.protocal.protobuf.een;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "mRoomId", "source", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMRoomId", "()Ljava/lang/String;", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "requestTime", "getRequestTime", "()I", "setRequestTime", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "sourceType", "getUserName", "setUserName", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getInfo", "getType", "insertList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryUserPageResponse;", "isFavSelectSource", "isFavSource", "isProfileSource", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class i
  extends q
  implements m
{
  private static final Vector<String> DJt;
  public static final a FnR;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
  private String DIL;
  public boolean DIe;
  private long DIf;
  private long DIg;
  private int DIi;
  public long DJB;
  private long FnD;
  private com.tencent.mm.ak.i callback;
  private boolean dJM;
  private final String gwx;
  private d rr;
  public final int source;
  private int sourceType;
  public String userName;
  public int wHW;
  
  static
  {
    AppMethodBeat.i(118843);
    FnR = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
    DJt = new Vector();
    AppMethodBeat.o(118843);
  }
  
  public i(String paramString1, long paramLong, boolean paramBoolean, String paramString2, int paramInt)
  {
    AppMethodBeat.i(118841);
    this.userName = paramString1;
    this.DIf = paramLong;
    this.dJM = paramBoolean;
    this.gwx = paramString2;
    this.source = paramInt;
    this.DIL = "";
    if (this.DIf == 0L)
    {
      Log.i(TAG, "fp mUserName " + this.userName);
      if (!this.dJM) {
        break label247;
      }
      paramString1 = com.tencent.mm.plugin.story.i.a.FvD;
    }
    for (paramInt = com.tencent.mm.plugin.story.i.a.fqG();; paramInt = com.tencent.mm.plugin.story.i.a.fqH())
    {
      this.sourceType = paramInt;
      paramString1 = new d.a();
      paramString1.c((com.tencent.mm.bw.a)new eem());
      paramString1.d((com.tencent.mm.bw.a)new een());
      paramString1.MB("/cgi-bin/micromsg-bin/mmstoryuserpage");
      paramString1.sG(273);
      paramString1.sI(400);
      paramString1.sJ(1000000400);
      paramString1 = paramString1.aXF();
      p.g(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.aYJ();
      if (paramString1 != null) {
        break label259;
      }
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageRequest");
      AppMethodBeat.o(118841);
      throw paramString1;
      Log.i(TAG, "np mUserName " + this.userName);
      break;
      label247:
      paramString1 = com.tencent.mm.plugin.story.i.a.FvD;
    }
    label259:
    eem localeem = (eem)paramString1;
    localeem.UserName = this.userName;
    localeem.MZh = this.DIf;
    localeem.xub = this.source;
    if (this.DIf == 0L) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.DIe = paramBoolean;
      localeem.Nau = 0L;
      if (kotlin.n.n.a((CharSequence)this.gwx, "@", 0, false, 6) <= 0) {
        break label412;
      }
      paramString1 = this.gwx;
      paramInt = kotlin.n.n.a((CharSequence)this.gwx, "@", 0, false, 6);
      if (paramString1 != null) {
        break;
      }
      paramString1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118841);
      throw paramString1;
    }
    paramString1 = paramString1.substring(0, paramInt);
    p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localeem.NeG = Util.safeParseLong(paramString1);
    label412:
    localeem.Nav = 0;
    localeem.KGO = this.gwx;
    if (this.DIe)
    {
      paramInt = this.source;
      paramString1 = com.tencent.mm.plugin.story.i.a.FvD;
      if (paramInt != com.tencent.mm.plugin.story.i.a.frj()) {
        break label652;
      }
      paramString1 = com.tencent.mm.plugin.story.f.j.Fmy;
      paramString1 = j.b.fod();
      paramString2 = this.userName;
      p.h(paramString2, "userName");
      paramString2 = paramString1.aSt(paramString2).field_favoriteMd5;
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    for (paramString1 = "";; paramString1 = j.b.fod().aSu(this.userName))
    {
      this.DIL = paramString1;
      if (this.DIL == null) {
        this.DIL = "";
      }
      localeem.MZg = this.DIL;
      this.FnD = this.DIf;
      Log.i(TAG, this + " req.mUserName:" + localeem.UserName + " req.MaxId:" + localeem.MZh + " req.MinFilterId:" + localeem.Nau + " req.LastRequestTime:" + localeem.Nav + " ChatRoomName " + this.gwx + " req.FirstPageMd5:" + localeem.MZg + " souorce:" + this.source);
      AppMethodBeat.o(118841);
      return;
      label652:
      paramString1 = com.tencent.mm.plugin.story.f.j.Fmy;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(118839);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(118839);
    return i;
  }
  
  public final String getInfo()
  {
    return this.userName;
  }
  
  public final int getType()
  {
    return 273;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118840);
    Log.i(TAG, this + " netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " source:" + this.source);
    params = this.rr.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageResponse");
      AppMethodBeat.o(118840);
      throw paramString;
    }
    een localeen = (een)params;
    this.DJB = localeen.NdN;
    this.wHW = localeen.NaG;
    if ((paramInt2 != 0) && (paramInt2 != 4))
    {
      Log.w(TAG, "onGYNetEnd errorType:" + paramInt2 + " errorCode:" + paramInt3 + ", return");
      params = this.callback;
      if (params == null) {
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(118840);
      return;
    }
    paramArrayOfByte = localeen.MZg;
    params = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      params = "";
    }
    Log.i(TAG, "onGYNetEnd resp: ObjCount " + localeen.NeH + ", size " + localeen.NeI.size() + "; md5 req " + this.DIL + ", resp " + params + ", source: " + this.source + ", expiredTime:" + localeen.KCC);
    label391:
    long l;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = (CharSequence)this.DIL;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length() == 0))
      {
        paramInt1 = 1;
        if (paramInt1 != 0) {
          break label523;
        }
        if (((CharSequence)params).length() != 0) {
          break label509;
        }
        paramInt1 = 1;
        if ((paramInt1 != 0) || (!Util.isEqual(this.DIL, params))) {
          break label523;
        }
        params = com.tencent.mm.plugin.story.f.j.Fmy;
        params = j.b.foc();
        if (!this.DIe) {
          break label514;
        }
        l = 0L;
        label427:
        this.DIg = params.c(l, this.DIi, this.userName, this.dJM);
        Log.i(TAG, "md5 is nochange");
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        params = this.callback;
        if (params == null) {
          p.btv("callback");
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(118840);
        return;
        paramInt1 = 0;
        break;
        label509:
        paramInt1 = 0;
        break label391;
        label514:
        l = this.FnD;
        break label427;
        label523:
        paramInt1 = this.source;
        paramArrayOfByte = com.tencent.mm.plugin.story.i.a.FvD;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.frj())
        {
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.fod().lb(this.userName, params);
          paramInt1 = 0;
          continue;
        }
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.fod().kJ(this.userName, params);
        paramInt1 = 0;
        continue;
        if (paramInt2 != 4) {
          break label1467;
        }
        params = com.tencent.mm.plugin.story.i.a.FvD;
        if (paramInt3 != com.tencent.mm.plugin.story.i.a.fqO()) {
          break label1467;
        }
        paramInt1 = 1;
        continue;
      }
      params = localeen.NeI;
      p.g(params, "resp.ObjList");
      params = (eea)kotlin.a.j.kt((List)params);
      if (params != null)
      {
        l = params.Id;
        this.DIf = l;
        params = localeen.NeI;
        p.g(params, "resp.ObjList");
        params = (eea)kotlin.a.j.kv((List)params);
        if (params == null) {
          break label936;
        }
      }
      Object localObject1;
      Object localObject2;
      label936:
      for (l = params.Id;; l = 0L)
      {
        this.DIg = l;
        Log.i(TAG, "onGYNetEnd replace insert " + localeen.NeI.size() + ", max " + this.DIf + ", min " + this.DIg);
        Log.i(TAG, "determin clear fav: " + this.source + ", " + paramInt3 + ", " + this.DIe);
        paramInt1 = this.source;
        params = com.tencent.mm.plugin.story.i.a.FvD;
        if (paramInt1 != com.tencent.mm.plugin.story.i.a.frj()) {
          break label1006;
        }
        if (!this.DIe) {
          break label942;
        }
        Log.i(TAG, "fetch first page, clear all fav");
        params = com.tencent.mm.plugin.story.f.j.Fmy;
        params = j.b.foc();
        paramArrayOfByte = this.userName;
        localObject1 = this.userName;
        localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
        params = ((Iterable)params.cy(paramArrayOfByte, Util.isEqual((String)localObject1, j.b.fau()))).iterator();
        while (params.hasNext())
        {
          paramArrayOfByte = (com.tencent.mm.plugin.story.i.j)params.next();
          localObject1 = com.tencent.mm.plugin.story.f.n.FmM;
          n.a.jd((int)paramArrayOfByte.systemRowid, 0);
        }
        l = 0L;
        break;
      }
      label942:
      params = com.tencent.mm.plugin.story.f.n.FmM;
      n.a.b(this.userName, (List)localeen.NeI, this.sourceType);
      for (;;)
      {
        params = this.callback;
        if (params == null) {
          p.btv("callback");
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(118840);
        return;
        label1006:
        paramInt1 = this.source;
        params = com.tencent.mm.plugin.story.i.a.FvD;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.fri())
        {
          params = com.tencent.mm.plugin.story.f.n.FmM;
          n.a.b(this.userName, (List)localeen.NeI, this.sourceType);
        }
        else
        {
          paramInt1 = this.source;
          params = com.tencent.mm.plugin.story.i.a.FvD;
          if (paramInt1 == com.tencent.mm.plugin.story.i.a.frh())
          {
            if (this.dJM)
            {
              params = com.tencent.mm.plugin.story.f.j.Fmy;
              params = j.b.foc();
              paramArrayOfByte = this.userName;
              paramInt1 = cl.aWB();
              localObject1 = com.tencent.mm.plugin.story.f.i.Fmb;
              params = params.a(paramArrayOfByte, true, paramInt1 - com.tencent.mm.plugin.story.f.i.fnT(), true);
              localObject1 = ((Iterable)params).iterator();
            }
            label1212:
            label1343:
            for (;;)
            {
              label1128:
              if (!((Iterator)localObject1).hasNext()) {
                break label1345;
              }
              params = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
              if (params.field_storyID != 0L)
              {
                paramArrayOfByte = localeen.NeI;
                p.g(paramArrayOfByte, "resp.ObjList");
                paramArrayOfByte = (Iterable)paramArrayOfByte;
                if ((!(paramArrayOfByte instanceof Collection)) || (!((Collection)paramArrayOfByte).isEmpty()))
                {
                  paramArrayOfByte = paramArrayOfByte.iterator();
                  if (paramArrayOfByte.hasNext()) {
                    if (((eea)paramArrayOfByte.next()).Id == params.field_storyID)
                    {
                      paramInt1 = 1;
                      label1246:
                      if (paramInt1 == 0) {
                        break label1338;
                      }
                    }
                  }
                }
                for (paramInt1 = 0;; paramInt1 = 1)
                {
                  if ((paramInt1 == 0) || (params.frK())) {
                    break label1343;
                  }
                  paramArrayOfByte = com.tencent.mm.plugin.story.f.j.Fmy;
                  localObject2 = j.b.foc();
                  l = params.field_storyID;
                  paramArrayOfByte = params.field_userName;
                  params = paramArrayOfByte;
                  if (paramArrayOfByte == null) {
                    params = "";
                  }
                  ((com.tencent.mm.plugin.story.i.k)localObject2).M(l, params);
                  break label1128;
                  params = com.tencent.mm.plugin.story.f.j.Fmy;
                  params = j.b.foc().cw(this.userName, false);
                  break;
                  paramInt1 = 0;
                  break label1246;
                  break label1212;
                }
              }
            }
            label1338:
            label1345:
            params = com.tencent.mm.plugin.story.f.n.FmM;
            params = (com.tencent.mm.plugin.story.i.j)kotlin.a.j.L((List)n.a.b(this.userName, (List)localeen.NeI, this.sourceType), 0);
            if (params == null)
            {
              Log.i(TAG, "onGYNetEnd clear ext sync");
              params = com.tencent.mm.plugin.story.f.k.FmH;
              com.tencent.mm.plugin.story.f.k.aRQ(this.userName);
            }
            else
            {
              Log.i(TAG, "onGYNetEnd update ext sync, " + params.field_storyID + ' ' + params.field_createTime);
              paramArrayOfByte = com.tencent.mm.plugin.story.f.k.FmH;
              com.tencent.mm.plugin.story.f.k.a(this.userName, params);
            }
          }
        }
      }
      label1467:
      paramInt1 = 0;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage$Companion;", "", "()V", "TAG", "", "userPageLock", "Ljava/util/Vector;", "addStoryUserReq", "", "muserName", "removeUserReq", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.i
 * JD-Core Version:    0.7.0.1
 */