package com.tencent.mm.plugin.story.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.story.g.f;
import com.tencent.mm.plugin.story.h.a.d;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.e;
import com.tencent.mm.plugin.story.model.p.a;
import com.tencent.mm.plugin.story.model.r;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.protocal.protobuf.fiz;
import com.tencent.mm.protocal.protobuf.fjd;
import com.tencent.mm.protocal.protobuf.fje;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "clientId", "localId", "", "groupList", "", "blackList", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isDel", "", "()Z", "setDel", "(Z)V", "getLocalId", "()I", "setLocalId", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getStoryLocalId", "getType", "onError", "", "onErrorServer", "errCode", "storyPostResponse", "Lcom/tencent/mm/protocal/protobuf/StoryPostResponse;", "errmsg", "onGYNetEnd", "netId", "errType", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateMediaFileName", "old", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "cnt", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.am.p
  implements m
{
  private final String TAG;
  private h callback;
  public int icg;
  private long idH;
  private final com.tencent.mm.am.c rr;
  
  public g(String paramString1, String paramString2, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(118822);
    this.icg = paramInt;
    this.TAG = "MicroMsg.StoryCgi.StoryNetSceneStoryPost";
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)new fjd());
    ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)new fje());
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmstorypost";
    ((c.a)localObject1).funcId = 351;
    ((c.a)localObject1).otG = 0;
    ((c.a)localObject1).respCmdId = 0;
    localObject1 = ((c.a)localObject1).bEF();
    kotlin.g.b.s.s(localObject1, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.am.c)localObject1);
    localObject1 = c.b.b(this.rr.otB);
    if (localObject1 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostRequest");
      AppMethodBeat.o(118822);
      throw paramString1;
    }
    localObject1 = (fjd)localObject1;
    Object localObject2 = new gol();
    paramString1 = paramString1.getBytes(kotlin.n.d.UTF_8);
    kotlin.g.b.s.s(paramString1, "(this as java.lang.String).getBytes(charset)");
    ((gol)localObject2).df(paramString1);
    ((fjd)localObject1).abJK = ((gol)localObject2);
    ((fjd)localObject1).nUv = paramString2;
    ((fjd)localObject1).YKa = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
    paramString1 = ((Iterable)paramList1).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      localObject2 = new etl();
      ((etl)localObject2).btH(paramString2);
      ((fjd)localObject1).GroupUser.add(localObject2);
    }
    ((fjd)localObject1).GroupUserCount = paramList1.size();
    paramString1 = ((Iterable)paramList2).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramList1 = new etl();
      paramList1.btH(paramString2);
      ((fjd)localObject1).BlackList.add(paramList1);
    }
    ((fjd)localObject1).BlackListCount = paramList2.size();
    AppMethodBeat.o(118822);
  }
  
  private final boolean a(long paramLong, fjj paramfjj1, fjj paramfjj2)
  {
    AppMethodBeat.i(118821);
    if ((paramfjj1 == null) || (paramfjj2 == null) || (paramfjj1.abJZ == null) || (paramfjj2.abJZ == null))
    {
      AppMethodBeat.o(118821);
      return false;
    }
    String str1 = paramfjj2.UserName;
    int i = 0;
    while ((i < paramfjj1.abJZ.Zpr.size()) && (i < paramfjj2.abJZ.Zpr.size()))
    {
      Object localObject3 = (fis)paramfjj1.abJZ.Zpr.get(i);
      Object localObject1 = (fis)paramfjj2.abJZ.Zpr.get(i);
      Object localObject2 = com.tencent.mm.plugin.story.model.k.Skq;
      localObject2 = com.tencent.mm.plugin.story.model.k.bbM(((fis)localObject3).Id);
      Object localObject4 = com.tencent.mm.plugin.story.model.k.Skq;
      localObject3 = com.tencent.mm.plugin.story.model.k.bbN(((fis)localObject3).Id);
      localObject4 = com.tencent.mm.plugin.story.model.k.Skq.nc(((fis)localObject1).Url, str1);
      String str2 = com.tencent.mm.plugin.story.model.k.Skq.nd(((fis)localObject1).Url, str1);
      Log.d(this.TAG, "updateMediaFileName " + (String)localObject2 + " to " + (String)localObject4);
      Log.d(this.TAG, "updateMediaFileName " + (String)localObject3 + " to " + str2);
      y.bDX(y.bEo(str2));
      y.qn((String)localObject2, (String)localObject4);
      y.O((String)localObject3, str2, false);
      localObject2 = r.Slb;
      kotlin.g.b.s.s(localObject1, "mediaObjCnt");
      kotlin.g.b.s.u(localObject1, "media");
      localObject2 = r.a((fis)localObject1, str1);
      int j = (int)y.bEl((String)localObject2);
      localObject3 = StoryCore.SjP;
      if (StoryCore.b.hvV().wf(paramLong) == null)
      {
        localObject3 = new n();
        ((n)localObject3).field_storyId = paramLong;
        ((n)localObject3).field_url = ((fis)localObject1).Url;
        ((n)localObject3).field_cacheSize = j;
        ((n)localObject3).field_totalSize = j;
        ((n)localObject3).field_filePath = ((String)localObject2);
        localObject1 = StoryCore.SjP;
        StoryCore.b.hvV().a((n)localObject3);
      }
      i += 1;
    }
    AppMethodBeat.o(118821);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(118819);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    Log.d(this.TAG, "doScene");
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(118819);
    return i;
  }
  
  public final int getType()
  {
    return 351;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118820);
    Log.i(this.TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    params = c.c.b(this.rr.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostResponse");
      AppMethodBeat.o(118820);
      throw paramString;
    }
    fje localfje = (fje)params;
    if (paramInt2 == 4)
    {
      params = StoryCore.SjP;
      params = StoryCore.b.hvR().anv(this.icg);
      long l;
      if (params != null)
      {
        try
        {
          paramArrayOfByte = new fit().parseFrom(params.field_postBuf);
          if (paramArrayOfByte != null) {
            break label278;
          }
          paramArrayOfByte = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
          AppMethodBeat.o(118820);
          throw paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte) {}
        if (localfje != null) {
          break label323;
        }
        l = 0L;
      }
      for (;;)
      {
        params.field_storyID = l;
        params.setItemDie();
        paramArrayOfByte = StoryCore.SjP;
        StoryCore.b.hvR().a(this.icg, params);
        params = StoryCore.SjP;
        StoryCore.b.hvY().akC(this.icg);
        paramArrayOfByte = this.callback;
        params = paramArrayOfByte;
        if (paramArrayOfByte == null)
        {
          kotlin.g.b.s.bIx("callback");
          params = null;
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
        AppMethodBeat.o(118820);
        return;
        label278:
        paramArrayOfByte = (fit)paramArrayOfByte;
        paramArrayOfByte.aaTP = paramInt3;
        paramArrayOfByte.abJE = paramString;
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        kotlin.g.b.s.s(paramArrayOfByte, "postinfo.toByteArray()");
        params.setPostBuf(paramArrayOfByte);
        break;
        label323:
        paramArrayOfByte = localfje.abJh;
        if (paramArrayOfByte == null) {
          l = 0L;
        } else {
          l = paramArrayOfByte.Id;
        }
      }
    }
    if (paramInt3 != 0)
    {
      params = StoryCore.SjP;
      StoryCore.b.hvY().akC(this.icg);
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      AppMethodBeat.o(118820);
      return;
    }
    params = this.TAG;
    paramArrayOfByte = new StringBuilder("resp.StoryObject==null ");
    if (localfje.abJh == null)
    {
      bool = true;
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc==null ");
      if (localfje.abJh.abJK != null) {
        break label633;
      }
      bool = true;
      label475:
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc.getBuffer()==null ");
      if (localfje.abJh.abJK.aaxD != null) {
        break label639;
      }
    }
    label633:
    label639:
    for (boolean bool = true;; bool = false)
    {
      Log.i(params, bool);
      if ((localfje.abJh != null) && (localfje.abJh.abJK != null) && (localfje.abJh.abJK.aaxD != null)) {
        break label645;
      }
      Log.e(this.TAG, "err respone buffer is null ignore");
      params = StoryCore.SjP;
      StoryCore.b.hvR().alC(this.icg);
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      AppMethodBeat.o(118820);
      return;
      bool = false;
      break;
      bool = false;
      break label475;
    }
    label645:
    params = f.SqX;
    f.hxT();
    params = localfje.abJh.abJK.aaxD.toByteArray();
    kotlin.g.b.s.s(params, "resp.StoryObject.ObjDesc.getBuffer().toByteArray()");
    params = new String(params, kotlin.n.d.UTF_8);
    Log.d(this.TAG, kotlin.g.b.s.X("resp.xml:\n ", params));
    paramArrayOfByte = com.tencent.mm.plugin.story.model.p.Sku;
    fjj localfjj = p.a.bbS(params);
    if (localfjj == null)
    {
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      AppMethodBeat.o(118820);
      return;
    }
    params = StoryCore.SjP;
    paramArrayOfByte = StoryCore.b.hvR().anv(this.icg);
    params = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      params = new j();
    }
    a(localfje.abJh.Id, params.hzt(), localfjj);
    if (localfje.abJh.abJH == 1)
    {
      paramArrayOfByte = com.tencent.mm.plugin.story.h.a.Sry;
      params.ant(com.tencent.mm.plugin.story.h.a.hyU());
    }
    for (;;)
    {
      params.field_createTime = localfje.abJh.CreateTime;
      params.c(localfjj);
      paramInt1 = params.field_localFlag;
      paramArrayOfByte = a.d.Ssx;
      params.field_localFlag = (paramInt1 & (a.d.hza() ^ 0xFFFFFFFF));
      params.field_storyID = localfje.abJh.Id;
      paramArrayOfByte = localfje.abJh;
      paramArrayOfByte.abJK.df(new byte[0]);
      this.idH = localfje.abJh.Id;
      params.field_attrBuf = paramArrayOfByte.toByteArray();
      params.clearItemDie();
      paramArrayOfByte = StoryCore.SjP;
      StoryCore.b.hvR().wc(localfje.abJh.Id);
      paramArrayOfByte = StoryCore.SjP;
      StoryCore.b.hvR().a(this.icg, params);
      params = StoryCore.SjP;
      StoryCore.b.hvY().akC(this.icg);
      params = StoryCore.SjP;
      StoryCore.b.hvX().checkPost();
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      AppMethodBeat.o(118820);
      return;
      paramArrayOfByte = com.tencent.mm.plugin.story.h.a.Sry;
      params.anu(com.tencent.mm.plugin.story.h.a.hyU());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.g
 * JD-Core Version:    0.7.0.1
 */