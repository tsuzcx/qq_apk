package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.story.f.e;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.protocal.protobuf.eef;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "clientId", "localId", "", "groupList", "", "blackList", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isDel", "", "()Z", "setDel", "(Z)V", "getLocalId", "()I", "setLocalId", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getStoryLocalId", "getType", "onError", "", "onErrorServer", "errCode", "storyPostResponse", "Lcom/tencent/mm/protocal/protobuf/StoryPostResponse;", "errmsg", "onGYNetEnd", "netId", "errType", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateMediaFileName", "old", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "cnt", "plugin-story_release"})
public final class g
  extends com.tencent.mm.ak.q
  implements m
{
  private final String TAG;
  private i callback;
  public int ecf;
  private long edx;
  private final com.tencent.mm.ak.d rr;
  
  public g(String paramString1, String paramString2, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(118822);
    this.ecf = paramInt;
    this.TAG = "MicroMsg.StoryCgi.StoryNetSceneStoryPost";
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((com.tencent.mm.bw.a)new eee());
    ((d.a)localObject1).d((com.tencent.mm.bw.a)new eef());
    ((d.a)localObject1).MB("/cgi-bin/micromsg-bin/mmstorypost");
    ((d.a)localObject1).sG(351);
    ((d.a)localObject1).sI(0);
    ((d.a)localObject1).sJ(0);
    localObject1 = ((d.a)localObject1).aXF();
    p.g(localObject1, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.d)localObject1);
    localObject1 = this.rr.aYJ();
    if (localObject1 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostRequest");
      AppMethodBeat.o(118822);
      throw paramString1;
    }
    localObject1 = (eee)localObject1;
    Object localObject2 = new SKBuiltinBuffer_t();
    paramString1 = paramString1.getBytes(kotlin.n.d.UTF_8);
    p.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramString1);
    ((eee)localObject1).Nem = ((SKBuiltinBuffer_t)localObject2);
    ((eee)localObject1).izX = paramString2;
    ((eee)localObject1).KLP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exJ());
    paramString1 = ((Iterable)paramList1).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      localObject2 = new dqi();
      ((dqi)localObject2).bhy(paramString2);
      ((eee)localObject1).GroupUser.add(localObject2);
    }
    ((eee)localObject1).GroupUserCount = paramList1.size();
    paramString1 = ((Iterable)paramList2).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramList1 = new dqi();
      paramList1.bhy(paramString2);
      ((eee)localObject1).BlackList.add(paramList1);
    }
    ((eee)localObject1).BlackListCount = paramList2.size();
    AppMethodBeat.o(118822);
  }
  
  private final boolean a(long paramLong, eek parameek1, eek parameek2)
  {
    AppMethodBeat.i(118821);
    if ((parameek1 == null) || (parameek2 == null) || (parameek1.NeB == null) || (parameek2.NeB == null))
    {
      AppMethodBeat.o(118821);
      return false;
    }
    String str1 = parameek2.UserName;
    int i = 0;
    while ((i < parameek1.NeB.LoV.size()) && (i < parameek2.NeB.LoV.size()))
    {
      Object localObject3 = (edt)parameek1.NeB.LoV.get(i);
      Object localObject1 = (edt)parameek2.NeB.LoV.get(i);
      Object localObject2 = com.tencent.mm.plugin.story.f.l.FmK;
      localObject2 = com.tencent.mm.plugin.story.f.l.aRV(((edt)localObject3).Id);
      Object localObject4 = com.tencent.mm.plugin.story.f.l.FmK;
      localObject3 = com.tencent.mm.plugin.story.f.l.aRW(((edt)localObject3).Id);
      localObject4 = com.tencent.mm.plugin.story.f.l.FmK.kX(((edt)localObject1).Url, str1);
      String str2 = com.tencent.mm.plugin.story.f.l.FmK.kY(((edt)localObject1).Url, str1);
      Log.d(this.TAG, "updateMediaFileName " + (String)localObject2 + " to " + (String)localObject4);
      Log.d(this.TAG, "updateMediaFileName " + (String)localObject3 + " to " + str2);
      com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(str2));
      com.tencent.mm.vfs.s.nx((String)localObject2, (String)localObject4);
      com.tencent.mm.vfs.s.nw((String)localObject3, str2);
      localObject2 = com.tencent.mm.plugin.story.f.s.Fny;
      p.g(localObject1, "mediaObjCnt");
      p.h(localObject1, "media");
      localObject2 = com.tencent.mm.plugin.story.f.s.a((edt)localObject1, str1);
      int j = (int)com.tencent.mm.vfs.s.boW((String)localObject2);
      localObject3 = com.tencent.mm.plugin.story.f.j.Fmy;
      if (j.b.fog().KC(paramLong) == null)
      {
        localObject3 = new n();
        ((n)localObject3).field_storyId = paramLong;
        ((n)localObject3).field_url = ((edt)localObject1).Url;
        ((n)localObject3).field_cacheSize = j;
        ((n)localObject3).field_totalSize = j;
        ((n)localObject3).field_filePath = ((String)localObject2);
        localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.fog().a((n)localObject3);
      }
      i += 1;
    }
    AppMethodBeat.o(118821);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(118819);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
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
    params = this.rr.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostResponse");
      AppMethodBeat.o(118820);
      throw paramString;
    }
    eef localeef = (eef)params;
    if (paramInt2 == 4)
    {
      params = com.tencent.mm.plugin.story.f.j.Fmy;
      params = j.b.foc().aba(this.ecf);
      if (params != null)
      {
        try
        {
          paramArrayOfByte = new edu().parseFrom(params.field_postBuf);
          if (paramArrayOfByte != null) {
            break label284;
          }
          paramArrayOfByte = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
          AppMethodBeat.o(118820);
          throw paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte) {}
        if (localeef == null) {
          break label329;
        }
        paramArrayOfByte = localeef.NdL;
        if (paramArrayOfByte == null) {
          break label329;
        }
      }
      label284:
      label329:
      for (long l = paramArrayOfByte.Id;; l = 0L)
      {
        params.field_storyID = l;
        params.setItemDie();
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.foc().a(this.ecf, params);
        params = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.foj().Yv(this.ecf);
        params = this.callback;
        if (params == null) {
          p.btv("callback");
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.q)this);
        AppMethodBeat.o(118820);
        return;
        paramArrayOfByte = (edu)paramArrayOfByte;
        paramArrayOfByte.Mtd = paramInt3;
        paramArrayOfByte.Neg = paramString;
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        p.g(paramArrayOfByte, "postinfo.toByteArray()");
        params.setPostBuf(paramArrayOfByte);
        break;
      }
    }
    if (paramInt3 != 0)
    {
      params = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.foj().Yv(this.ecf);
      params = this.callback;
      if (params == null) {
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.q)this);
      AppMethodBeat.o(118820);
      return;
    }
    params = this.TAG;
    paramArrayOfByte = new StringBuilder("resp.StoryObject==null ");
    if (localeef.NdL == null)
    {
      bool = true;
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc==null ");
      if (localeef.NdL.Nem != null) {
        break label603;
      }
      bool = true;
      label452:
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc.getBuffer()==null ");
      if (localeef.NdL.Nem.getBuffer() != null) {
        break label609;
      }
    }
    label603:
    label609:
    for (boolean bool = true;; bool = false)
    {
      Log.i(params, bool);
      if ((localeef.NdL != null) && (localeef.NdL.Nem != null) && (localeef.NdL.Nem.getBuffer() != null)) {
        break label615;
      }
      Log.e(this.TAG, "err respone buffer is null ignore");
      params = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.foc().Zs(this.ecf);
      params = this.callback;
      if (params == null) {
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.q)this);
      AppMethodBeat.o(118820);
      return;
      bool = false;
      break;
      bool = false;
      break label452;
    }
    label615:
    params = f.Fui;
    f.fqf();
    params = localeef.NdL.Nem.getBuffer().toByteArray();
    p.g(params, "resp.StoryObject.ObjDesc.getBuffer().toByteArray()");
    params = new String(params, kotlin.n.d.UTF_8);
    Log.d(this.TAG, "resp.xml:\n ".concat(String.valueOf(params)));
    paramArrayOfByte = com.tencent.mm.plugin.story.f.q.FmO;
    eek localeek = q.a.aSb(params);
    if (localeek == null)
    {
      params = this.callback;
      if (params == null) {
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.q)this);
      AppMethodBeat.o(118820);
      return;
    }
    params = com.tencent.mm.plugin.story.f.j.Fmy;
    paramArrayOfByte = j.b.foc().aba(this.ecf);
    params = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      params = new com.tencent.mm.plugin.story.i.j();
    }
    a(localeef.NdL.Id, params.frG(), localeek);
    if (localeef.NdL.Nej == 1)
    {
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.FvD;
      params.aaY(com.tencent.mm.plugin.story.i.a.frg());
    }
    for (;;)
    {
      params.field_createTime = localeef.NdL.CreateTime;
      params.c(localeek);
      paramInt1 = params.field_localFlag;
      paramArrayOfByte = a.d.FvM;
      params.field_localFlag = (paramInt1 & (a.d.frm() ^ 0xFFFFFFFF));
      params.field_storyID = localeef.NdL.Id;
      paramArrayOfByte = localeef.NdL;
      paramArrayOfByte.Nem.setBuffer(new byte[0]);
      this.edx = localeef.NdL.Id;
      params.field_attrBuf = paramArrayOfByte.toByteArray();
      params.clearItemDie();
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.foc().Kz(localeef.NdL.Id);
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.foc().a(this.ecf, params);
      params = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.foj().Yv(this.ecf);
      params = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.foi().checkPost();
      params = this.callback;
      if (params == null) {
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.q)this);
      AppMethodBeat.o(118820);
      return;
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.FvD;
      params.aaZ(com.tencent.mm.plugin.story.i.a.frg());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.g
 * JD-Core Version:    0.7.0.1
 */