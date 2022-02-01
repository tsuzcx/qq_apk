package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.model.cm;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.protocal.protobuf.eon;
import com.tencent.mm.protocal.protobuf.eoo;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "mRoomId", "source", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMRoomId", "()Ljava/lang/String;", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "requestTime", "getRequestTime", "()I", "setRequestTime", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "sourceType", "getUserName", "setUserName", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getInfo", "getType", "insertList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryUserPageResponse;", "isFavSelectSource", "isFavSource", "isProfileSource", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class i
  extends q
  implements m
{
  private static final Vector<String> JWt;
  public static final a LHT;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
  public int BAV;
  private String JVL;
  public boolean JVe;
  private long JVf;
  private long JVg;
  private int JVi;
  public long JWB;
  private long LHF;
  private com.tencent.mm.an.i callback;
  private boolean fCB;
  private final String jaK;
  private d rr;
  public final int source;
  private int sourceType;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118843);
    LHT = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
    JWt = new Vector();
    AppMethodBeat.o(118843);
  }
  
  public i(String paramString1, long paramLong, boolean paramBoolean, String paramString2, int paramInt)
  {
    AppMethodBeat.i(118841);
    this.userName = paramString1;
    this.JVf = paramLong;
    this.fCB = paramBoolean;
    this.jaK = paramString2;
    this.source = paramInt;
    this.JVL = "";
    if (this.JVf == 0L)
    {
      Log.i(TAG, "fp mUserName " + this.userName);
      if (!this.fCB) {
        break label247;
      }
      paramString1 = com.tencent.mm.plugin.story.i.a.LPG;
    }
    for (paramInt = com.tencent.mm.plugin.story.i.a.gfc();; paramInt = com.tencent.mm.plugin.story.i.a.gfd())
    {
      this.sourceType = paramInt;
      paramString1 = new d.a();
      paramString1.c((com.tencent.mm.cd.a)new eon());
      paramString1.d((com.tencent.mm.cd.a)new eoo());
      paramString1.TW("/cgi-bin/micromsg-bin/mmstoryuserpage");
      paramString1.vD(273);
      paramString1.vF(400);
      paramString1.vG(1000000400);
      paramString1 = paramString1.bgN();
      p.j(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.bhX();
      if (paramString1 != null) {
        break label259;
      }
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageRequest");
      AppMethodBeat.o(118841);
      throw paramString1;
      Log.i(TAG, "np mUserName " + this.userName);
      break;
      label247:
      paramString1 = com.tencent.mm.plugin.story.i.a.LPG;
    }
    label259:
    eon localeon = (eon)paramString1;
    localeon.UserName = this.userName;
    localeon.UlB = this.JVf;
    localeon.Cqs = this.source;
    if (this.JVf == 0L) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.JVe = paramBoolean;
      localeon.UmO = 0L;
      if (kotlin.n.n.a((CharSequence)this.jaK, "@", 0, false, 6) <= 0) {
        break label412;
      }
      paramString1 = this.jaK;
      paramInt = kotlin.n.n.a((CharSequence)this.jaK, "@", 0, false, 6);
      if (paramString1 != null) {
        break;
      }
      paramString1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118841);
      throw paramString1;
    }
    paramString1 = paramString1.substring(0, paramInt);
    p.j(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localeon.Urf = Util.safeParseLong(paramString1);
    label412:
    localeon.UmP = 0;
    localeon.RIi = this.jaK;
    if (this.JVe)
    {
      paramInt = this.source;
      paramString1 = com.tencent.mm.plugin.story.i.a.LPG;
      if (paramInt != com.tencent.mm.plugin.story.i.a.gfF()) {
        break label652;
      }
      paramString1 = com.tencent.mm.plugin.story.f.j.LGA;
      paramString1 = j.b.gcx();
      paramString2 = this.userName;
      p.k(paramString2, "userName");
      paramString2 = paramString1.bdx(paramString2).field_favoriteMd5;
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    for (paramString1 = "";; paramString1 = j.b.gcx().bdy(this.userName))
    {
      this.JVL = paramString1;
      if (this.JVL == null) {
        this.JVL = "";
      }
      localeon.UlA = this.JVL;
      this.LHF = this.JVf;
      Log.i(TAG, this + " req.mUserName:" + localeon.UserName + " req.MaxId:" + localeon.UlB + " req.MinFilterId:" + localeon.UmO + " req.LastRequestTime:" + localeon.UmP + " ChatRoomName " + this.jaK + " req.FirstPageMd5:" + localeon.UlA + " souorce:" + this.source);
      AppMethodBeat.o(118841);
      return;
      label652:
      paramString1 = com.tencent.mm.plugin.story.f.j.LGA;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(118839);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
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
    params = this.rr.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageResponse");
      AppMethodBeat.o(118840);
      throw paramString;
    }
    eoo localeoo = (eoo)params;
    this.JWB = localeoo.Uqk;
    this.BAV = localeoo.Unb;
    if ((paramInt2 != 0) && (paramInt2 != 4))
    {
      Log.w(TAG, "onGYNetEnd errorType:" + paramInt2 + " errorCode:" + paramInt3 + ", return");
      params = this.callback;
      if (params == null) {
        p.bGy("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(118840);
      return;
    }
    paramArrayOfByte = localeoo.UlA;
    params = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      params = "";
    }
    Log.i(TAG, "onGYNetEnd resp: ObjCount " + localeoo.Urg + ", size " + localeoo.Urh.size() + "; md5 req " + this.JVL + ", resp " + params + ", source: " + this.source + ", expiredTime:" + localeoo.SXb);
    label391:
    long l;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = (CharSequence)this.JVL;
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
        if ((paramInt1 != 0) || (!Util.isEqual(this.JVL, params))) {
          break label523;
        }
        params = com.tencent.mm.plugin.story.f.j.LGA;
        params = j.b.gcw();
        if (!this.JVe) {
          break label514;
        }
        l = 0L;
        label427:
        this.JVg = params.b(l, this.JVi, this.userName, this.fCB);
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
          p.bGy("callback");
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
        l = this.LHF;
        break label427;
        label523:
        paramInt1 = this.source;
        paramArrayOfByte = com.tencent.mm.plugin.story.i.a.LPG;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.gfF())
        {
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.gcx().ly(this.userName, params);
          paramInt1 = 0;
          continue;
        }
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.gcx().lf(this.userName, params);
        paramInt1 = 0;
        continue;
        if (paramInt2 != 4) {
          break label1467;
        }
        params = com.tencent.mm.plugin.story.i.a.LPG;
        if (paramInt3 != com.tencent.mm.plugin.story.i.a.gfk()) {
          break label1467;
        }
        paramInt1 = 1;
        continue;
      }
      params = localeoo.Urh;
      p.j(params, "resp.ObjList");
      params = (eob)kotlin.a.j.lp((List)params);
      if (params != null)
      {
        l = params.Id;
        this.JVf = l;
        params = localeoo.Urh;
        p.j(params, "resp.ObjList");
        params = (eob)kotlin.a.j.lr((List)params);
        if (params == null) {
          break label936;
        }
      }
      Object localObject1;
      Object localObject2;
      label936:
      for (l = params.Id;; l = 0L)
      {
        this.JVg = l;
        Log.i(TAG, "onGYNetEnd replace insert " + localeoo.Urh.size() + ", max " + this.JVf + ", min " + this.JVg);
        Log.i(TAG, "determin clear fav: " + this.source + ", " + paramInt3 + ", " + this.JVe);
        paramInt1 = this.source;
        params = com.tencent.mm.plugin.story.i.a.LPG;
        if (paramInt1 != com.tencent.mm.plugin.story.i.a.gfF()) {
          break label1006;
        }
        if (!this.JVe) {
          break label942;
        }
        Log.i(TAG, "fetch first page, clear all fav");
        params = com.tencent.mm.plugin.story.f.j.LGA;
        params = j.b.gcw();
        paramArrayOfByte = this.userName;
        localObject1 = this.userName;
        localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
        params = ((Iterable)params.cM(paramArrayOfByte, Util.isEqual((String)localObject1, j.b.fOo()))).iterator();
        while (params.hasNext())
        {
          paramArrayOfByte = (com.tencent.mm.plugin.story.i.j)params.next();
          localObject1 = com.tencent.mm.plugin.story.f.n.LGO;
          n.a.kn((int)paramArrayOfByte.systemRowid, 0);
        }
        l = 0L;
        break;
      }
      label942:
      params = com.tencent.mm.plugin.story.f.n.LGO;
      n.a.c(this.userName, (List)localeoo.Urh, this.sourceType);
      for (;;)
      {
        params = this.callback;
        if (params == null) {
          p.bGy("callback");
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(118840);
        return;
        label1006:
        paramInt1 = this.source;
        params = com.tencent.mm.plugin.story.i.a.LPG;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.gfE())
        {
          params = com.tencent.mm.plugin.story.f.n.LGO;
          n.a.c(this.userName, (List)localeoo.Urh, this.sourceType);
        }
        else
        {
          paramInt1 = this.source;
          params = com.tencent.mm.plugin.story.i.a.LPG;
          if (paramInt1 == com.tencent.mm.plugin.story.i.a.gfD())
          {
            if (this.fCB)
            {
              params = com.tencent.mm.plugin.story.f.j.LGA;
              params = j.b.gcw();
              paramArrayOfByte = this.userName;
              paramInt1 = cm.bfF();
              localObject1 = com.tencent.mm.plugin.story.f.i.LGd;
              params = params.a(paramArrayOfByte, true, paramInt1 - com.tencent.mm.plugin.story.f.i.gcn(), true);
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
                paramArrayOfByte = localeoo.Urh;
                p.j(paramArrayOfByte, "resp.ObjList");
                paramArrayOfByte = (Iterable)paramArrayOfByte;
                if ((!(paramArrayOfByte instanceof Collection)) || (!((Collection)paramArrayOfByte).isEmpty()))
                {
                  paramArrayOfByte = paramArrayOfByte.iterator();
                  if (paramArrayOfByte.hasNext()) {
                    if (((eob)paramArrayOfByte.next()).Id == params.field_storyID)
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
                  if ((paramInt1 == 0) || (params.ggg())) {
                    break label1343;
                  }
                  paramArrayOfByte = com.tencent.mm.plugin.story.f.j.LGA;
                  localObject2 = j.b.gcw();
                  l = params.field_storyID;
                  paramArrayOfByte = params.field_userName;
                  params = paramArrayOfByte;
                  if (paramArrayOfByte == null) {
                    params = "";
                  }
                  ((com.tencent.mm.plugin.story.i.k)localObject2).U(l, params);
                  break label1128;
                  params = com.tencent.mm.plugin.story.f.j.LGA;
                  params = j.b.gcw().cK(this.userName, false);
                  break;
                  paramInt1 = 0;
                  break label1246;
                  break label1212;
                }
              }
            }
            label1338:
            label1345:
            params = com.tencent.mm.plugin.story.f.n.LGO;
            params = (com.tencent.mm.plugin.story.i.j)kotlin.a.j.M((List)n.a.c(this.userName, (List)localeoo.Urh, this.sourceType), 0);
            if (params == null)
            {
              Log.i(TAG, "onGYNetEnd clear ext sync");
              params = com.tencent.mm.plugin.story.f.k.LGJ;
              com.tencent.mm.plugin.story.f.k.bcU(this.userName);
            }
            else
            {
              Log.i(TAG, "onGYNetEnd update ext sync, " + params.field_storyID + ' ' + params.field_createTime);
              paramArrayOfByte = com.tencent.mm.plugin.story.f.k.LGJ;
              com.tencent.mm.plugin.story.f.k.a(this.userName, params);
            }
          }
        }
      }
      label1467:
      paramInt1 = 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage$Companion;", "", "()V", "TAG", "", "userPageLock", "Ljava/util/Vector;", "addStoryUserReq", "", "muserName", "removeUserReq", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.i
 * JD-Core Version:    0.7.0.1
 */