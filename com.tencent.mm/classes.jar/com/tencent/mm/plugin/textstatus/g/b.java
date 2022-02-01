package com.tencent.mm.plugin.textstatus.g;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.k.e;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneModTextStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getPostInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class b
  extends q
  implements m
{
  public static final b.a MDb;
  private com.tencent.mm.plugin.textstatus.proto.b MCY;
  private com.tencent.mm.plugin.textstatus.proto.c MCZ;
  private final al MDa;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(235699);
    MDb = new b.a((byte)0);
    AppMethodBeat.o(235699);
  }
  
  public b(al paramal)
  {
    AppMethodBeat.i(235697);
    this.MDa = paramal;
    paramal = new d.a();
    paramal.vD(getType());
    paramal.TW("/cgi-bin/micromsg-bin/modtextstatus");
    paramal.c((com.tencent.mm.cd.a)new com.tencent.mm.plugin.textstatus.proto.b());
    paramal.d((com.tencent.mm.cd.a)new com.tencent.mm.plugin.textstatus.proto.c());
    paramal = paramal.bgN();
    p.j(paramal, "commReqRespBuilder.buildInstance()");
    this.lKU = paramal;
    paramal = this.lKU.bhX();
    if (paramal == null)
    {
      paramal = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.ModTextStatusReq");
      AppMethodBeat.o(235697);
      throw paramal;
    }
    this.MCY = ((com.tencent.mm.plugin.textstatus.proto.b)paramal);
    paramal = this.MDa;
    if (paramal != null)
    {
      paramal = paramal.MFN;
      if (paramal != null)
      {
        boolean bool = com.tencent.mm.plugin.textstatus.a.t.gls();
        p.k(paramal, "$this$setSendToSquare");
        if (!bool) {
          break label471;
        }
        paramal.option |= 0x2;
      }
    }
    Object localObject2 = this.MCY;
    paramal = this.MDa;
    label192:
    Object localObject3;
    if (paramal != null)
    {
      paramal = paramal.MFN;
      if (paramal != null)
      {
        paramal = paramal.toByteArray();
        paramal = Base64.encode(paramal, 2);
        p.j(paramal, "Base64.encode(postInfo?.…eArray(), Base64.NO_WRAP)");
        localObject3 = StandardCharsets.UTF_8;
        p.j(localObject3, "StandardCharsets.UTF_8");
        ((com.tencent.mm.plugin.textstatus.proto.b)localObject2).MEL = new String(paramal, (Charset)localObject3);
        localObject2 = this.MCY;
        paramal = this.MDa;
        if (paramal == null) {
          break label491;
        }
        paramal = paramal.MFO;
        label251:
        ((com.tencent.mm.plugin.textstatus.proto.b)localObject2).MEM = paramal;
        localObject2 = this.MCY;
        paramal = this.MDa;
        if (paramal == null) {
          break label496;
        }
        paramal = paramal.MEN;
        label277:
        ((com.tencent.mm.plugin.textstatus.proto.b)localObject2).MEN = paramal;
        localObject2 = new StringBuilder("rowId:");
        paramal = this.MDa;
        if (paramal == null) {
          break label501;
        }
        paramal = Long.valueOf(paramal.MFT);
        label311:
        localObject2 = ((StringBuilder)localObject2).append(paramal).append(" text:");
        paramal = this.MDa;
        if (paramal == null) {
          break label506;
        }
        paramal = paramal.MFN;
        if (paramal == null) {
          break label506;
        }
        paramal = paramal.description;
        label347:
        localObject2 = ((StringBuilder)localObject2).append(Util.secPrint(paramal)).append(" statusId:").append(this.MCY.MEN).append(" option:");
        paramal = this.MDa;
        if (paramal == null) {
          break label511;
        }
        paramal = paramal.MFN;
        if (paramal == null) {
          break label511;
        }
      }
    }
    label471:
    label491:
    label496:
    label501:
    label506:
    label511:
    for (paramal = Long.valueOf(paramal.option);; paramal = null)
    {
      localObject2 = ((StringBuilder)localObject2).append(paramal).append(" extInfo:");
      localObject3 = this.MDa;
      paramal = localObject1;
      if (localObject3 != null)
      {
        localObject3 = ((al)localObject3).MFN;
        paramal = localObject1;
        if (localObject3 != null) {
          paramal = e.c((TextStatusExtInfo)localObject3);
        }
      }
      Log.i("MicroMsg.TextStatus.NetSceneModTextStatus", paramal);
      AppMethodBeat.o(235697);
      return;
      paramal.option &= 0xFFFFFFFD;
      break;
      paramal = null;
      break label192;
      paramal = null;
      break label251;
      paramal = null;
      break label277;
      paramal = null;
      break label311;
      paramal = null;
      break label347;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(235694);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(235694);
    return i;
  }
  
  public final int getType()
  {
    return 5293;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(235695);
    p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneModTextStatus", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    com.tencent.mm.plugin.textstatus.proto.c localc;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.lKU.bhY();
      if (params == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.ModTextStatusResp");
        AppMethodBeat.o(235695);
        throw paramString;
      }
      this.MCZ = ((com.tencent.mm.plugin.textstatus.proto.c)params);
      localc = this.MCZ;
      if (localc != null)
      {
        params = localc.MEN;
        paramArrayOfByte = localc.MEL;
        Object localObject1 = (CharSequence)params;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label427;
        }
        paramInt1 = 1;
        if (paramInt1 == 0)
        {
          paramArrayOfByte = (CharSequence)paramArrayOfByte;
          if ((paramArrayOfByte != null) && (paramArrayOfByte.length() != 0)) {
            break label432;
          }
          paramInt1 = 1;
          label182:
          if (paramInt1 == 0)
          {
            localObject1 = new TextStatusExtInfo();
            ((TextStatusExtInfo)localObject1).parseFrom(Base64.decode(localc.MEL, 0));
            paramArrayOfByte = com.tencent.mm.plugin.textstatus.g.g.c.MEt;
            paramArrayOfByte = com.tencent.mm.plugin.textstatus.g.g.c.gmk();
            if (paramArrayOfByte == null) {
              break label437;
            }
            Object localObject2 = f.MAm;
            String str = com.tencent.mm.plugin.auth.a.a.crN();
            p.j(str, "Account.username()");
            long l = f.a((f)localObject2, str, params, (TextStatusExtInfo)localObject1, 4, null, 16);
            params = com.tencent.mm.plugin.textstatus.g.g.c.MEt;
            com.tencent.mm.plugin.textstatus.g.g.c.gml();
            params = com.tencent.mm.plugin.textstatus.h.a.MGJ;
            localObject2 = paramArrayOfByte.MFV;
            params = ((TextStatusExtInfo)localObject1).topicInfo;
            if (params != null)
            {
              paramArrayOfByte = params.topicId;
              params = paramArrayOfByte;
              if (paramArrayOfByte != null) {}
            }
            else
            {
              params = "";
            }
            com.tencent.mm.plugin.textstatus.h.a.a((String)localObject2, Long.valueOf(1L), params, localc.MEN);
            Log.i("MicroMsg.TextStatus.NetSceneModTextStatus", "onSceneEnd mod statusId:" + localc.MEN + ", expireTime:" + ((TextStatusExtInfo)localObject1).expireTime + " rowId:" + l + " extInfo:" + e.c((TextStatusExtInfo)localObject1));
          }
        }
      }
    }
    for (;;)
    {
      params = this.callback;
      if (params == null) {
        break label473;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(235695);
      return;
      label427:
      paramInt1 = 0;
      break;
      label432:
      paramInt1 = 0;
      break label182;
      label437:
      Log.w("MicroMsg.TextStatus.NetSceneModTextStatus", "onSceneEnd mod statusId:" + localc.MEN + ", this is deleted");
    }
    label473:
    AppMethodBeat.o(235695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.b
 * JD-Core Version:    0.7.0.1
 */