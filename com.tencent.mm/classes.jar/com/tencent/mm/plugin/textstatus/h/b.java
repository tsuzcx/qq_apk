package com.tencent.mm.plugin.textstatus.h;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.bg;
import com.tencent.mm.plugin.textstatus.proto.i;
import com.tencent.mm.plugin.textstatus.proto.j;
import com.tencent.mm.plugin.textstatus.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneModTextStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getPostInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends p
  implements m
{
  public static final b.a Tmz;
  private final bg TmA;
  private i TmB;
  private j TmC;
  private h callback;
  private final com.tencent.mm.am.c oDw;
  
  static
  {
    AppMethodBeat.i(290548);
    Tmz = new b.a((byte)0);
    AppMethodBeat.o(290548);
  }
  
  public b(bg parambg)
  {
    AppMethodBeat.i(290528);
    this.TmA = parambg;
    parambg = new c.a();
    parambg.funcId = getType();
    parambg.uri = "/cgi-bin/micromsg-bin/modtextstatus";
    parambg.otE = ((com.tencent.mm.bx.a)new i());
    parambg.otF = ((com.tencent.mm.bx.a)new j());
    parambg = parambg.bEF();
    kotlin.g.b.s.s(parambg, "commReqRespBuilder.buildInstance()");
    this.oDw = parambg;
    parambg = c.b.b(this.oDw.otB);
    if (parambg == null)
    {
      parambg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.ModTextStatusReq");
      AppMethodBeat.o(290528);
      throw parambg;
    }
    this.TmB = ((i)parambg);
    Object localObject2 = this.TmB;
    parambg = this.TmA;
    Object localObject3;
    if (parambg == null)
    {
      parambg = null;
      parambg = Base64.encode(parambg, 2);
      kotlin.g.b.s.s(parambg, "encode(postInfo?.textSta…eArray(), Base64.NO_WRAP)");
      localObject3 = StandardCharsets.UTF_8;
      kotlin.g.b.s.s(localObject3, "UTF_8");
      ((i)localObject2).ToJ = new String(parambg, (Charset)localObject3);
      localObject2 = this.TmB;
      parambg = this.TmA;
      if (parambg != null) {
        break label364;
      }
      parambg = null;
      label192:
      ((i)localObject2).ToM = parambg;
      localObject2 = this.TmB;
      parambg = this.TmA;
      if (parambg != null) {
        break label372;
      }
      parambg = null;
      label213:
      ((i)localObject2).ToK = parambg;
      localObject2 = new StringBuilder("rowId:");
      parambg = this.TmA;
      if (parambg != null) {
        break label380;
      }
      parambg = null;
      label239:
      localObject2 = ((StringBuilder)localObject2).append(parambg).append(" text:");
      parambg = this.TmA;
      if (parambg != null) {
        break label391;
      }
      parambg = null;
      label261:
      localObject2 = ((StringBuilder)localObject2).append(Util.secPrint(parambg)).append(" statusId:").append(this.TmB.ToK).append(" option:");
      parambg = this.TmA;
      if (parambg != null) {
        break label413;
      }
      parambg = null;
      label301:
      localObject2 = ((StringBuilder)localObject2).append(parambg).append(" extInfo:");
      parambg = this.TmA;
      if (parambg != null) {
        break label438;
      }
      parambg = localObject1;
    }
    for (;;)
    {
      Log.i("MicroMsg.TextStatus.NetSceneModTextStatus", parambg);
      AppMethodBeat.o(290528);
      return;
      parambg = parambg.Tqi;
      if (parambg == null)
      {
        parambg = null;
        break;
      }
      parambg = parambg.toByteArray();
      break;
      label364:
      parambg = parambg.Tqj;
      break label192;
      label372:
      parambg = parambg.ToK;
      break label213;
      label380:
      parambg = Long.valueOf(parambg.Tqo);
      break label239;
      label391:
      parambg = parambg.Tqi;
      if (parambg == null)
      {
        parambg = null;
        break label261;
      }
      parambg = parambg.description;
      break label261;
      label413:
      parambg = parambg.Tqi;
      if (parambg == null)
      {
        parambg = null;
        break label301;
      }
      parambg = Long.valueOf(parambg.option);
      break label301;
      label438:
      localObject3 = parambg.Tqi;
      parambg = localObject1;
      if (localObject3 != null) {
        parambg = d.e((TextStatusExtInfo)localObject3);
      }
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(290558);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(290558);
    return i;
  }
  
  public final int getType()
  {
    return 5293;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290571);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneModTextStatus", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    j localj;
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.ModTextStatusResp");
        AppMethodBeat.o(290571);
        throw paramString;
      }
      this.TmC = ((j)params);
      localj = this.TmC;
      if (localj != null)
      {
        params = localj.ToK;
        paramArrayOfByte = localj.ToJ;
        localObject1 = (CharSequence)params;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label300;
        }
        paramInt1 = 1;
        if (paramInt1 == 0)
        {
          paramArrayOfByte = (CharSequence)paramArrayOfByte;
          if ((paramArrayOfByte != null) && (paramArrayOfByte.length() != 0)) {
            break label305;
          }
        }
      }
    }
    label300:
    label305:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        localObject1 = new TextStatusExtInfo();
        ((TextStatusExtInfo)localObject1).parseFrom(Base64.decode(localj.ToJ, 0));
        paramArrayOfByte = com.tencent.mm.plugin.textstatus.h.h.c.Tob;
        paramArrayOfByte = com.tencent.mm.plugin.textstatus.h.h.c.hHU();
        if (paramArrayOfByte != null) {
          break label310;
        }
        params = null;
        if (params == null) {
          Log.w("MicroMsg.TextStatus.NetSceneModTextStatus", "onSceneEnd mod statusId:" + localj.ToK + ", this is deleted");
        }
      }
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(290571);
      return;
      paramInt1 = 0;
      break;
    }
    label310:
    Object localObject2 = f.TjQ;
    localObject2 = com.tencent.mm.plugin.auth.a.a.cUx();
    kotlin.g.b.s.s(localObject2, "username()");
    kotlin.g.b.s.s(params, "statusID");
    long l = f.a((String)localObject2, params, (TextStatusExtInfo)localObject1, 4, null, 16);
    params = com.tencent.mm.plugin.textstatus.h.h.c.Tob;
    com.tencent.mm.plugin.textstatus.h.h.c.hHV();
    params = com.tencent.mm.plugin.textstatus.i.b.Trt;
    localObject2 = paramArrayOfByte.Tqq;
    params = ((TextStatusExtInfo)localObject1).topicInfo;
    if (params == null) {
      params = "";
    }
    for (;;)
    {
      com.tencent.mm.plugin.textstatus.i.b.a((String)localObject2, Long.valueOf(1L), params, localj.ToK);
      Log.i("MicroMsg.TextStatus.NetSceneModTextStatus", "onSceneEnd mod statusId:" + localj.ToK + ", expireTime:" + ((TextStatusExtInfo)localObject1).expireTime + " rowId:" + l + " extInfo:" + d.e((TextStatusExtInfo)localObject1));
      params = ah.aiuX;
      break;
      paramArrayOfByte = params.topicId;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        params = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.b
 * JD-Core Version:    0.7.0.1
 */