package com.tencent.mm.plugin.story.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.m.a;
import com.tencent.mm.protocal.protobuf.fiz;
import com.tencent.mm.protocal.protobuf.fjl;
import com.tencent.mm.protocal.protobuf.fjm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "mRoomId", "source", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMRoomId", "()Ljava/lang/String;", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "requestTime", "getRequestTime", "()I", "setRequestTime", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "sourceType", "getUserName", "setUserName", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getInfo", "getType", "insertList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryUserPageResponse;", "isFavSelectSource", "isFavSource", "isProfileSource", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.am.p
  implements com.tencent.mm.network.m
{
  private static final Vector<String> Qtz;
  public static final i.a Slu;
  private static final String TAG;
  public int Hit;
  private String QsM;
  public boolean Qsg;
  private long Qsh;
  private int Qsj;
  public long QtH;
  private long Sli;
  private h callback;
  private boolean hHq;
  private final String lyn;
  private long maxId;
  private c rr;
  public final int source;
  private int sourceType;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118843);
    Slu = new i.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
    Qtz = new Vector();
    AppMethodBeat.o(118843);
  }
  
  public i(String paramString1, long paramLong, boolean paramBoolean, String paramString2, int paramInt)
  {
    AppMethodBeat.i(118841);
    this.userName = paramString1;
    this.maxId = paramLong;
    this.hHq = paramBoolean;
    this.lyn = paramString2;
    this.source = paramInt;
    this.QsM = "";
    if (this.maxId == 0L)
    {
      Log.i(TAG, kotlin.g.b.s.X("fp mUserName ", this.userName));
      if (!this.hHq) {
        break label230;
      }
      paramString1 = com.tencent.mm.plugin.story.h.a.Sry;
    }
    for (paramInt = com.tencent.mm.plugin.story.h.a.hyu();; paramInt = com.tencent.mm.plugin.story.h.a.hyv())
    {
      this.sourceType = paramInt;
      paramString1 = new c.a();
      paramString1.otE = ((com.tencent.mm.bx.a)new fjl());
      paramString1.otF = ((com.tencent.mm.bx.a)new fjm());
      paramString1.uri = "/cgi-bin/micromsg-bin/mmstoryuserpage";
      paramString1.funcId = 273;
      paramString1.otG = 400;
      paramString1.respCmdId = 1000000400;
      paramString1 = paramString1.bEF();
      kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = c.b.b(this.rr.otB);
      if (paramString1 != null) {
        break label242;
      }
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageRequest");
      AppMethodBeat.o(118841);
      throw paramString1;
      Log.i(TAG, kotlin.g.b.s.X("np mUserName ", this.userName));
      break;
      label230:
      paramString1 = com.tencent.mm.plugin.story.h.a.Sry;
    }
    label242:
    fjl localfjl = (fjl)paramString1;
    localfjl.UserName = this.userName;
    localfjl.abDv = this.maxId;
    localfjl.IcB = this.source;
    if (this.maxId == 0L) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Qsg = paramBoolean;
      localfjl.abEV = 0L;
      if (n.a((CharSequence)this.lyn, "@", 0, false, 6) <= 0) {
        break label395;
      }
      paramString1 = this.lyn;
      paramInt = n.a((CharSequence)this.lyn, "@", 0, false, 6);
      if (paramString1 != null) {
        break;
      }
      paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118841);
      throw paramString1;
    }
    paramString1 = paramString1.substring(0, paramInt);
    kotlin.g.b.s.s(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localfjl.abKe = Util.safeParseLong(paramString1);
    label395:
    localfjl.abEW = 0;
    localfjl.YFk = this.lyn;
    if (this.Qsg)
    {
      paramInt = this.source;
      paramString1 = com.tencent.mm.plugin.story.h.a.Sry;
      if (paramInt != com.tencent.mm.plugin.story.h.a.hyX()) {
        break label635;
      }
      paramString1 = StoryCore.SjP;
      paramString1 = StoryCore.b.hvS();
      paramString2 = this.userName;
      kotlin.g.b.s.u(paramString2, "userName");
      paramString2 = paramString1.bck(paramString2).field_favoriteMd5;
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    for (paramString1 = "";; paramString1 = StoryCore.b.hvS().aZS(this.userName))
    {
      this.QsM = paramString1;
      if (this.QsM == null) {
        this.QsM = "";
      }
      localfjl.abDu = this.QsM;
      this.Sli = this.maxId;
      Log.i(TAG, this + " req.mUserName:" + localfjl.UserName + " req.MaxId:" + localfjl.abDv + " req.MinFilterId:" + localfjl.abEV + " req.LastRequestTime:" + localfjl.abEW + " ChatRoomName " + this.lyn + " req.FirstPageMd5:" + localfjl.abDu + " souorce:" + this.source);
      AppMethodBeat.o(118841);
      return;
      label635:
      paramString1 = StoryCore.SjP;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(118839);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (com.tencent.mm.network.m)this);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118840);
    Log.i(TAG, this + " netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " source:" + this.source);
    params = c.c.b(this.rr.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageResponse");
      AppMethodBeat.o(118840);
      throw paramString;
    }
    fjm localfjm = (fjm)params;
    this.QtH = localfjm.abJj;
    this.Hit = localfjm.abFi;
    if ((paramInt2 != 0) && (paramInt2 != 4))
    {
      Log.w(TAG, "onGYNetEnd errorType:" + paramInt2 + " errorCode:" + paramInt3 + ", return");
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      AppMethodBeat.o(118840);
      return;
    }
    paramArrayOfByte = localfjm.abDu;
    params = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      params = "";
    }
    Log.i(TAG, "onGYNetEnd resp: ObjCount " + localfjm.abKf + ", size " + localfjm.abKg.size() + "; md5 req " + this.QsM + ", resp " + params + ", source: " + this.source + ", expiredTime:" + localfjm.aaiS);
    switch (paramInt2)
    {
    default: 
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label649;
      }
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      AppMethodBeat.o(118840);
      return;
      paramArrayOfByte = (CharSequence)this.QsM;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length() == 0))
      {
        paramInt1 = 1;
        label458:
        if (paramInt1 != 0) {
          break label569;
        }
        if (((CharSequence)params).length() != 0) {
          break label555;
        }
        paramInt1 = 1;
        label477:
        if ((paramInt1 != 0) || (!Util.isEqual(this.QsM, params))) {
          break label569;
        }
        params = StoryCore.SjP;
        params = StoryCore.b.hvR();
        if (!this.Qsg) {
          break label560;
        }
      }
      label555:
      label560:
      for (l = 0L;; l = this.Sli)
      {
        this.Qsh = params.b(l, this.Qsj, this.userName, this.hHq);
        Log.i(TAG, "md5 is nochange");
        paramInt1 = 1;
        break;
        paramInt1 = 0;
        break label458;
        paramInt1 = 0;
        break label477;
      }
      label569:
      paramInt1 = this.source;
      paramArrayOfByte = com.tencent.mm.plugin.story.h.a.Sry;
      if (paramInt1 == com.tencent.mm.plugin.story.h.a.hyX())
      {
        paramArrayOfByte = StoryCore.SjP;
        StoryCore.b.hvS().ng(this.userName, params);
        paramInt1 = 0;
      }
      else
      {
        paramArrayOfByte = StoryCore.SjP;
        StoryCore.b.hvS().mO(this.userName, params);
        paramInt1 = 0;
        continue;
        params = com.tencent.mm.plugin.story.h.a.Sry;
        if (paramInt3 != com.tencent.mm.plugin.story.h.a.hyC()) {
          break;
        }
        paramInt1 = 1;
      }
    }
    label649:
    params = localfjm.abKg;
    kotlin.g.b.s.s(params, "resp.ObjList");
    params = (fiz)kotlin.a.p.oL((List)params);
    if (params == null)
    {
      l = 0L;
      this.maxId = l;
      params = localfjm.abKg;
      kotlin.g.b.s.s(params, "resp.ObjList");
      params = (fiz)kotlin.a.p.oN((List)params);
      if (params != null) {
        break label973;
      }
    }
    Object localObject1;
    Object localObject2;
    label973:
    for (long l = 0L;; l = params.Id)
    {
      this.Qsh = l;
      Log.i(TAG, "onGYNetEnd replace insert " + localfjm.abKg.size() + ", max " + this.maxId + ", min " + this.Qsh);
      Log.i(TAG, "determin clear fav: " + this.source + ", " + paramInt3 + ", " + this.Qsg);
      paramInt1 = this.source;
      params = com.tencent.mm.plugin.story.h.a.Sry;
      if (paramInt1 != com.tencent.mm.plugin.story.h.a.hyX()) {
        break label1054;
      }
      if (!this.Qsg) {
        break label983;
      }
      Log.i(TAG, "fetch first page, clear all fav");
      params = StoryCore.SjP;
      params = StoryCore.b.hvR();
      paramArrayOfByte = this.userName;
      localObject1 = this.userName;
      localObject2 = StoryCore.SjP;
      params = ((Iterable)params.ds(paramArrayOfByte, Util.isEqual((String)localObject1, StoryCore.b.hgg()))).iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (com.tencent.mm.plugin.story.h.j)params.next();
        localObject1 = com.tencent.mm.plugin.story.model.m.Sks;
        m.a.lZ((int)paramArrayOfByte.systemRowid, 0);
      }
      l = params.Id;
      break;
    }
    label983:
    params = com.tencent.mm.plugin.story.model.m.Sks;
    m.a.e(this.userName, (List)localfjm.abKg, this.sourceType);
    for (;;)
    {
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      AppMethodBeat.o(118840);
      return;
      label1054:
      paramInt1 = this.source;
      params = com.tencent.mm.plugin.story.h.a.Sry;
      if (paramInt1 == com.tencent.mm.plugin.story.h.a.hyW())
      {
        params = com.tencent.mm.plugin.story.model.m.Sks;
        m.a.e(this.userName, (List)localfjm.abKg, this.sourceType);
      }
      else
      {
        paramInt1 = this.source;
        params = com.tencent.mm.plugin.story.h.a.Sry;
        if (paramInt1 == com.tencent.mm.plugin.story.h.a.hyV())
        {
          if (this.hHq)
          {
            params = StoryCore.SjP;
            params = StoryCore.b.hvR();
            paramArrayOfByte = this.userName;
            paramInt1 = cn.getSyncServerTimeSecond();
            localObject1 = com.tencent.mm.plugin.story.model.i.SjL;
            params = params.a(paramArrayOfByte, true, paramInt1 - com.tencent.mm.plugin.story.model.i.hvz(), true);
            localObject1 = ((Iterable)params).iterator();
          }
          label1176:
          label1260:
          label1391:
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label1393;
            }
            params = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject1).next();
            if (params.field_storyID != 0L)
            {
              paramArrayOfByte = localfjm.abKg;
              kotlin.g.b.s.s(paramArrayOfByte, "resp.ObjList");
              paramArrayOfByte = (Iterable)paramArrayOfByte;
              if ((!(paramArrayOfByte instanceof Collection)) || (!((Collection)paramArrayOfByte).isEmpty()))
              {
                paramArrayOfByte = paramArrayOfByte.iterator();
                if (paramArrayOfByte.hasNext()) {
                  if (((fiz)paramArrayOfByte.next()).Id == params.field_storyID)
                  {
                    paramInt1 = 1;
                    if (paramInt1 == 0) {
                      break label1386;
                    }
                  }
                }
              }
              for (paramInt1 = 0;; paramInt1 = 1)
              {
                if ((paramInt1 == 0) || (params.hzx())) {
                  break label1391;
                }
                paramArrayOfByte = StoryCore.SjP;
                localObject2 = StoryCore.b.hvR();
                l = params.field_storyID;
                paramArrayOfByte = params.field_userName;
                params = paramArrayOfByte;
                if (paramArrayOfByte == null) {
                  params = "";
                }
                ((k)localObject2).aj(l, params);
                break label1176;
                params = StoryCore.SjP;
                params = StoryCore.b.hvR().dq(this.userName, false);
                break;
                paramInt1 = 0;
                break label1294;
                break label1260;
              }
            }
          }
          label1294:
          label1386:
          label1393:
          params = com.tencent.mm.plugin.story.model.m.Sks;
          params = (com.tencent.mm.plugin.story.h.j)kotlin.a.p.ae((List)m.a.e(this.userName, (List)localfjm.abKg, this.sourceType), 0);
          if (params == null)
          {
            Log.i(TAG, "onGYNetEnd clear ext sync");
            params = com.tencent.mm.plugin.story.model.j.Skm;
            com.tencent.mm.plugin.story.model.j.bbH(this.userName);
          }
          else
          {
            Log.i(TAG, "onGYNetEnd update ext sync, " + params.field_storyID + ' ' + params.field_createTime);
            paramArrayOfByte = com.tencent.mm.plugin.story.model.j.Skm;
            com.tencent.mm.plugin.story.model.j.a(this.userName, params);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.i
 * JD-Core Version:    0.7.0.1
 */