package com.tencent.mm.plugin.textstatus.conversation.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.h.f.i;
import com.tencent.mm.plugin.textstatus.proto.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/cgi/NetSceneGetV6Stranger;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "sessionsToNames", "", "Lkotlin/Pair;", "", "canTalk", "", "(Ljava/util/List;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/GetV6StrangerReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/GetV6StrangerResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/GetV6StrangerResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/GetV6StrangerResp;)V", "getSessionsToNames", "()Ljava/util/List;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "print", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.am.p
  implements m
{
  public static final a.a TiA;
  private final List<r<String, String>> TiB;
  private final boolean TiC;
  private final e TiD;
  public com.tencent.mm.plugin.textstatus.proto.g TiE;
  private com.tencent.mm.am.h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(290858);
    TiA = new a.a((byte)0);
    AppMethodBeat.o(290858);
  }
  
  public a(List<r<String, String>> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(290853);
    this.TiB = paramList;
    this.TiC = paramBoolean;
    paramList = new c.a();
    paramList.funcId = getType();
    paramList.uri = "/cgi-bin/micromsg-bin/getv6stranger";
    paramList.otE = ((com.tencent.mm.bx.a)new e());
    paramList.otF = ((com.tencent.mm.bx.a)new com.tencent.mm.plugin.textstatus.proto.g());
    paramList = paramList.bEF();
    kotlin.g.b.s.s(paramList, "commReqRespBuilder.buildInstance()");
    this.oDw = paramList;
    paramList = c.b.b(this.oDw.otB);
    if (paramList == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.GetV6StrangerReq");
      AppMethodBeat.o(290853);
      throw paramList;
    }
    this.TiD = ((e)paramList);
    paramList = this.TiB.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)((r)paramList.next()).bsD;
      if (localObject != null)
      {
        LinkedList localLinkedList = this.TiD.ToF;
        com.tencent.mm.plugin.textstatus.proto.f localf = new com.tencent.mm.plugin.textstatus.proto.f();
        localf.ToG = ((String)localObject);
        localObject = ah.aiuX;
        localLinkedList.add(localf);
      }
    }
    Log.i("MicroMsg.TextStatus.NetSceneGetV6Stranger", "req sessionsToNames:" + this.TiB + " canTalk:" + this.TiC);
    AppMethodBeat.o(290853);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(290868);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(290868);
    return i;
  }
  
  public final int getType()
  {
    return 5829;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290878);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneGetV6Stranger", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    label106:
    Object localObject1;
    label120:
    int i;
    label183:
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if ((params instanceof com.tencent.mm.plugin.textstatus.proto.g))
      {
        params = (com.tencent.mm.plugin.textstatus.proto.g)params;
        this.TiE = params;
        params = this.TiE;
        if (params != null) {
          break label493;
        }
        params = null;
        localObject1 = this.TiE;
        if (localObject1 != null) {
          break label524;
        }
        paramArrayOfByte = null;
        Log.i("MicroMsg.TextStatus.NetSceneGetV6Stranger", "rsp size %s ret %s", new Object[] { params, paramArrayOfByte });
        params = this.TiE;
        if (params == null) {
          break label670;
        }
        params = params.ToF;
        if (params == null) {
          break label670;
        }
        params = (Iterable)params;
        paramInt1 = 0;
        paramArrayOfByte = params.iterator();
        if (!paramArrayOfByte.hasNext()) {
          break label670;
        }
        params = paramArrayOfByte.next();
        i = paramInt1 + 1;
        if (paramInt1 < 0) {
          kotlin.a.p.kkW();
        }
        localObject1 = (com.tencent.mm.plugin.textstatus.proto.h)params;
        if (((com.tencent.mm.plugin.textstatus.proto.h)localObject1).ret != 0) {
          break label664;
        }
        localObject2 = (r)this.TiB.get(paramInt1);
        params = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
        params = com.tencent.mm.plugin.textstatus.conversation.g.a.bdK((String)((r)localObject2).bsC);
        if (params != null) {
          break label702;
        }
        params = new com.tencent.mm.plugin.textstatus.h.f.h();
        params.field_sessionId = ((String)((r)localObject2).bsC);
      }
    }
    label524:
    label664:
    label670:
    label702:
    for (;;)
    {
      kotlin.g.b.s.s(localObject1, "it");
      kotlin.g.b.s.u(params, "<this>");
      kotlin.g.b.s.u(localObject1, "info");
      params.field_nickname = ((com.tencent.mm.plugin.textstatus.proto.h)localObject1).nickname;
      params.field_sex = ((com.tencent.mm.plugin.textstatus.proto.h)localObject1).sex;
      params.field_province = ((com.tencent.mm.plugin.textstatus.proto.h)localObject1).province;
      params.field_city = ((com.tencent.mm.plugin.textstatus.proto.h)localObject1).city;
      params.field_signature = ((com.tencent.mm.plugin.textstatus.proto.h)localObject1).signature;
      params.field_bigHeadImgUrl = ((com.tencent.mm.plugin.textstatus.proto.h)localObject1).ToH;
      params.field_smallHeadImgUrl = ((com.tencent.mm.plugin.textstatus.proto.h)localObject1).ToI;
      params.field_textStatusExtInfo = ((com.tencent.mm.plugin.textstatus.proto.h)localObject1).ToJ;
      params.field_country = ((com.tencent.mm.plugin.textstatus.proto.h)localObject1).country;
      params.field_userName = ((com.tencent.mm.plugin.textstatus.proto.h)localObject1).ToG;
      params.field_textStatusId = ((com.tencent.mm.plugin.textstatus.proto.h)localObject1).ToK;
      if (((com.tencent.mm.plugin.textstatus.proto.h)localObject1).ToL) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        params.field_block = paramInt1;
        if (this.TiC) {
          params.field_canTalk = 1;
        }
        if (params.systemRowid != -1L) {
          break label643;
        }
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        com.tencent.mm.plugin.textstatus.b.f.hGK().insert((IAutoDBItem)params);
        paramInt1 = i;
        break label183;
        params = null;
        break;
        label493:
        params = params.ToF;
        if (params == null)
        {
          params = null;
          break label106;
        }
        params = Integer.valueOf(params.size());
        break label106;
        paramArrayOfByte = new StringBuilder();
        localObject1 = ((com.tencent.mm.plugin.textstatus.proto.g)localObject1).ToF.iterator();
        paramInt1 = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.textstatus.proto.h)((Iterator)localObject1).next();
          paramArrayOfByte.append(paramInt1 + ':' + ((com.tencent.mm.plugin.textstatus.proto.h)localObject2).ret + ' ' + ((com.tencent.mm.plugin.textstatus.proto.h)localObject2).hNw);
          paramInt1 += 1;
        }
        paramArrayOfByte = paramArrayOfByte.toString();
        kotlin.g.b.s.s(paramArrayOfByte, "sb.toString()");
        break label120;
      }
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      com.tencent.mm.plugin.textstatus.b.f.hGK().update((IAutoDBItem)params, new String[0]);
      paramInt1 = i;
      break label183;
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      }
      AppMethodBeat.o(290878);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.b.a
 * JD-Core Version:    0.7.0.1
 */