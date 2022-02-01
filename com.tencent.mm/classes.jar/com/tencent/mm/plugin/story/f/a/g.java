package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.cd.b;
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
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.protocal.protobuf.eof;
import com.tencent.mm.protocal.protobuf.eog;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "clientId", "localId", "", "groupList", "", "blackList", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isDel", "", "()Z", "setDel", "(Z)V", "getLocalId", "()I", "setLocalId", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getStoryLocalId", "getType", "onError", "", "onErrorServer", "errCode", "storyPostResponse", "Lcom/tencent/mm/protocal/protobuf/StoryPostResponse;", "errmsg", "onGYNetEnd", "netId", "errType", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateMediaFileName", "old", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "cnt", "plugin-story_release"})
public final class g
  extends com.tencent.mm.an.q
  implements m
{
  private final String TAG;
  private i callback;
  public int fWh;
  private long fXG;
  private final com.tencent.mm.an.d rr;
  
  public g(String paramString1, String paramString2, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(118822);
    this.fWh = paramInt;
    this.TAG = "MicroMsg.StoryCgi.StoryNetSceneStoryPost";
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((com.tencent.mm.cd.a)new eof());
    ((d.a)localObject1).d((com.tencent.mm.cd.a)new eog());
    ((d.a)localObject1).TW("/cgi-bin/micromsg-bin/mmstorypost");
    ((d.a)localObject1).vD(351);
    ((d.a)localObject1).vF(0);
    ((d.a)localObject1).vG(0);
    localObject1 = ((d.a)localObject1).bgN();
    p.j(localObject1, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.an.d)localObject1);
    localObject1 = this.rr.bhX();
    if (localObject1 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostRequest");
      AppMethodBeat.o(118822);
      throw paramString1;
    }
    localObject1 = (eof)localObject1;
    Object localObject2 = new eae();
    paramString1 = paramString1.getBytes(kotlin.n.d.UTF_8);
    p.j(paramString1, "(this as java.lang.String).getBytes(charset)");
    ((eae)localObject2).dc(paramString1);
    ((eof)localObject1).UqL = ((eae)localObject2);
    ((eof)localObject1).lps = paramString2;
    ((eof)localObject1).RMM = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
    paramString1 = ((Iterable)paramList1).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      localObject2 = new eaf();
      ((eaf)localObject2).btQ(paramString2);
      ((eof)localObject1).GroupUser.add(localObject2);
    }
    ((eof)localObject1).GroupUserCount = paramList1.size();
    paramString1 = ((Iterable)paramList2).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramList1 = new eaf();
      paramList1.btQ(paramString2);
      ((eof)localObject1).BlackList.add(paramList1);
    }
    ((eof)localObject1).BlackListCount = paramList2.size();
    AppMethodBeat.o(118822);
  }
  
  private final boolean a(long paramLong, eol parameol1, eol parameol2)
  {
    AppMethodBeat.i(118821);
    if ((parameol1 == null) || (parameol2 == null) || (parameol1.Ura == null) || (parameol2.Ura == null))
    {
      AppMethodBeat.o(118821);
      return false;
    }
    String str1 = parameol2.UserName;
    int i = 0;
    while ((i < parameol1.Ura.Sqr.size()) && (i < parameol2.Ura.Sqr.size()))
    {
      Object localObject3 = (enu)parameol1.Ura.Sqr.get(i);
      Object localObject1 = (enu)parameol2.Ura.Sqr.get(i);
      Object localObject2 = com.tencent.mm.plugin.story.f.l.LGM;
      localObject2 = com.tencent.mm.plugin.story.f.l.bcZ(((enu)localObject3).Id);
      Object localObject4 = com.tencent.mm.plugin.story.f.l.LGM;
      localObject3 = com.tencent.mm.plugin.story.f.l.bda(((enu)localObject3).Id);
      localObject4 = com.tencent.mm.plugin.story.f.l.LGM.lu(((enu)localObject1).Url, str1);
      String str2 = com.tencent.mm.plugin.story.f.l.LGM.lv(((enu)localObject1).Url, str1);
      Log.d(this.TAG, "updateMediaFileName " + (String)localObject2 + " to " + (String)localObject4);
      Log.d(this.TAG, "updateMediaFileName " + (String)localObject3 + " to " + str2);
      u.bBD(u.bBT(str2));
      u.oo((String)localObject2, (String)localObject4);
      u.on((String)localObject3, str2);
      localObject2 = com.tencent.mm.plugin.story.f.s.LHA;
      p.j(localObject1, "mediaObjCnt");
      p.k(localObject1, "media");
      localObject2 = com.tencent.mm.plugin.story.f.s.a((enu)localObject1, str1);
      int j = (int)u.bBQ((String)localObject2);
      localObject3 = com.tencent.mm.plugin.story.f.j.LGA;
      if (j.b.gcA().RW(paramLong) == null)
      {
        localObject3 = new n();
        ((n)localObject3).field_storyId = paramLong;
        ((n)localObject3).field_url = ((enu)localObject1).Url;
        ((n)localObject3).field_cacheSize = j;
        ((n)localObject3).field_totalSize = j;
        ((n)localObject3).field_filePath = ((String)localObject2);
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.gcA().a((n)localObject3);
      }
      i += 1;
    }
    AppMethodBeat.o(118821);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(118819);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
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
    params = this.rr.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostResponse");
      AppMethodBeat.o(118820);
      throw paramString;
    }
    eog localeog = (eog)params;
    if (paramInt2 == 4)
    {
      params = com.tencent.mm.plugin.story.f.j.LGA;
      params = j.b.gcw().aiv(this.fWh);
      if (params != null)
      {
        try
        {
          paramArrayOfByte = new env().parseFrom(params.field_postBuf);
          if (paramArrayOfByte != null) {
            break label284;
          }
          paramArrayOfByte = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
          AppMethodBeat.o(118820);
          throw paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte) {}
        if (localeog == null) {
          break label329;
        }
        paramArrayOfByte = localeog.Uqi;
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
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.gcw().a(this.fWh, params);
        params = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.gcD().afN(this.fWh);
        params = this.callback;
        if (params == null) {
          p.bGy("callback");
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.an.q)this);
        AppMethodBeat.o(118820);
        return;
        paramArrayOfByte = (env)paramArrayOfByte;
        paramArrayOfByte.TEj = paramInt3;
        paramArrayOfByte.UqF = paramString;
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        p.j(paramArrayOfByte, "postinfo.toByteArray()");
        params.setPostBuf(paramArrayOfByte);
        break;
      }
    }
    if (paramInt3 != 0)
    {
      params = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcD().afN(this.fWh);
      params = this.callback;
      if (params == null) {
        p.bGy("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.an.q)this);
      AppMethodBeat.o(118820);
      return;
    }
    params = this.TAG;
    paramArrayOfByte = new StringBuilder("resp.StoryObject==null ");
    if (localeog.Uqi == null)
    {
      bool = true;
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc==null ");
      if (localeog.Uqi.UqL != null) {
        break label603;
      }
      bool = true;
      label452:
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc.getBuffer()==null ");
      if (localeog.Uqi.UqL.Tkb != null) {
        break label609;
      }
    }
    label603:
    label609:
    for (boolean bool = true;; bool = false)
    {
      Log.i(params, bool);
      if ((localeog.Uqi != null) && (localeog.Uqi.UqL != null) && (localeog.Uqi.UqL.Tkb != null)) {
        break label615;
      }
      Log.e(this.TAG, "err respone buffer is null ignore");
      params = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcw().agJ(this.fWh);
      params = this.callback;
      if (params == null) {
        p.bGy("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.an.q)this);
      AppMethodBeat.o(118820);
      return;
      bool = false;
      break;
      bool = false;
      break label452;
    }
    label615:
    params = f.LOj;
    f.geB();
    params = localeog.Uqi.UqL.Tkb.toByteArray();
    p.j(params, "resp.StoryObject.ObjDesc.getBuffer().toByteArray()");
    params = new String(params, kotlin.n.d.UTF_8);
    Log.d(this.TAG, "resp.xml:\n ".concat(String.valueOf(params)));
    paramArrayOfByte = com.tencent.mm.plugin.story.f.q.LGQ;
    eol localeol = q.a.bdf(params);
    if (localeol == null)
    {
      params = this.callback;
      if (params == null) {
        p.bGy("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.an.q)this);
      AppMethodBeat.o(118820);
      return;
    }
    params = com.tencent.mm.plugin.story.f.j.LGA;
    paramArrayOfByte = j.b.gcw().aiv(this.fWh);
    params = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      params = new com.tencent.mm.plugin.story.i.j();
    }
    a(localeog.Uqi.Id, params.ggc(), localeol);
    if (localeog.Uqi.UqI == 1)
    {
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.LPG;
      params.ait(com.tencent.mm.plugin.story.i.a.gfC());
    }
    for (;;)
    {
      params.field_createTime = localeog.Uqi.CreateTime;
      params.c(localeol);
      paramInt1 = params.field_localFlag;
      paramArrayOfByte = a.d.LPP;
      params.field_localFlag = (paramInt1 & (a.d.gfI() ^ 0xFFFFFFFF));
      params.field_storyID = localeog.Uqi.Id;
      paramArrayOfByte = localeog.Uqi;
      paramArrayOfByte.UqL.dc(new byte[0]);
      this.fXG = localeog.Uqi.Id;
      params.field_attrBuf = paramArrayOfByte.toByteArray();
      params.clearItemDie();
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcw().RT(localeog.Uqi.Id);
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcw().a(this.fWh, params);
      params = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcD().afN(this.fWh);
      params = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcC().checkPost();
      params = this.callback;
      if (params == null) {
        p.bGy("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.an.q)this);
      AppMethodBeat.o(118820);
      return;
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.LPG;
      params.aiu(com.tencent.mm.plugin.story.i.a.gfC());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.g
 * JD-Core Version:    0.7.0.1
 */