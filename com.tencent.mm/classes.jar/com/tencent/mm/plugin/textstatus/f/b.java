package com.tencent.mm.plugin.textstatus.f;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneModTextStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getPostInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class b
  extends q
  implements m
{
  public static final b.a FYR;
  private com.tencent.mm.plugin.textstatus.g.c FYO;
  private com.tencent.mm.plugin.textstatus.g.d FYP;
  private final v FYQ;
  private i callback;
  private final com.tencent.mm.ak.d iUB;
  
  static
  {
    AppMethodBeat.i(216178);
    FYR = new b.a((byte)0);
    AppMethodBeat.o(216178);
  }
  
  public b(v paramv)
  {
    AppMethodBeat.i(216177);
    this.FYQ = paramv;
    paramv = new d.a();
    paramv.sG(getType());
    paramv.MB("/cgi-bin/micromsg-bin/modtextstatus");
    paramv.c((com.tencent.mm.bw.a)new com.tencent.mm.plugin.textstatus.g.c());
    paramv.d((com.tencent.mm.bw.a)new com.tencent.mm.plugin.textstatus.g.d());
    paramv = paramv.aXF();
    p.g(paramv, "commReqRespBuilder.buildInstance()");
    this.iUB = paramv;
    paramv = this.iUB.aYJ();
    if (paramv == null)
    {
      paramv = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.ModTextStatusReq");
      AppMethodBeat.o(216177);
      throw paramv;
    }
    this.FYO = ((com.tencent.mm.plugin.textstatus.g.c)paramv);
    Object localObject2 = this.FYO;
    paramv = this.FYQ;
    Object localObject3;
    if (paramv != null)
    {
      paramv = paramv.GaU;
      if (paramv != null)
      {
        paramv = paramv.toByteArray();
        paramv = Base64.encode(paramv, 2);
        p.g(paramv, "Base64.encode(postInfo?.…eArray(), Base64.NO_WRAP)");
        localObject3 = StandardCharsets.UTF_8;
        p.g(localObject3, "StandardCharsets.UTF_8");
        ((com.tencent.mm.plugin.textstatus.g.c)localObject2).Gaq = new String(paramv, (Charset)localObject3);
        localObject2 = this.FYO;
        paramv = this.FYQ;
        if (paramv == null) {
          break label307;
        }
        paramv = paramv.GaV;
        label204:
        ((com.tencent.mm.plugin.textstatus.g.c)localObject2).Gar = paramv;
        localObject2 = new StringBuilder("rowId:");
        paramv = this.FYQ;
        if (paramv == null) {
          break label312;
        }
      }
    }
    label307:
    label312:
    for (paramv = Long.valueOf(paramv.Gba);; paramv = null)
    {
      localObject2 = ((StringBuilder)localObject2).append(paramv).append(" text:");
      localObject3 = this.FYQ;
      paramv = localObject1;
      if (localObject3 != null)
      {
        localObject3 = ((v)localObject3).GaU;
        paramv = localObject1;
        if (localObject3 != null) {
          paramv = ((com.tencent.mm.plugin.textstatus.g.g)localObject3).description;
        }
      }
      Log.i("MicroMsg.TxtStatus.NetSceneModeTextStatus", Util.secPrint(paramv));
      AppMethodBeat.o(216177);
      return;
      paramv = null;
      break;
      paramv = null;
      break label204;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(216175);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(216175);
    return i;
  }
  
  public final int getType()
  {
    return 5293;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216176);
    p.h(params, "rr");
    Log.i("MicroMsg.TxtStatus.NetSceneModeTextStatus", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    com.tencent.mm.plugin.textstatus.g.d locald;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.iUB.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.ModTextStatusResp");
        AppMethodBeat.o(216176);
        throw paramString;
      }
      this.FYP = ((com.tencent.mm.plugin.textstatus.g.d)params);
      locald = this.FYP;
      if (locald != null)
      {
        paramArrayOfByte = locald.Gas;
        params = locald.Gaq;
        Object localObject1 = (CharSequence)paramArrayOfByte;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label525;
        }
        paramInt1 = 1;
        label304:
        if (paramInt1 == 0)
        {
          params = (CharSequence)params;
          if ((params != null) && (params.length() != 0)) {
            break label530;
          }
          paramInt1 = 1;
          label177:
          if (paramInt1 == 0)
          {
            com.tencent.mm.plugin.textstatus.g.g localg = new com.tencent.mm.plugin.textstatus.g.g();
            localg.parseFrom(Base64.decode(locald.Gaq, 0));
            params = com.tencent.mm.plugin.textstatus.f.h.c.FZX;
            localObject1 = com.tencent.mm.plugin.textstatus.f.h.c.fwe();
            if (localObject1 == null) {
              break label546;
            }
            params = com.tencent.mm.kernel.g.aAh();
            p.g(params, "MMKernel.storage()");
            params = params.getDataDB();
            Object localObject2 = Thread.currentThread();
            p.g(localObject2, "Thread.currentThread()");
            long l1 = params.beginTransaction(((Thread)localObject2).getId());
            params = null;
            localObject2 = this.FYQ;
            if (localObject2 == null) {
              break label535;
            }
            params = f.FXJ;
            long l2 = ((v)localObject2).Gba;
            params = Boolean.valueOf(f.fvM().delete(l2));
            localObject2 = f.FXJ;
            localObject2 = com.tencent.mm.plugin.auth.a.a.ceA();
            p.g(localObject2, "Account.username()");
            l2 = f.a((String)localObject2, paramArrayOfByte, localg, 4);
            paramArrayOfByte = com.tencent.mm.kernel.g.aAh();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.getDataDB().endTransaction(l1);
            paramArrayOfByte = com.tencent.mm.plugin.textstatus.f.h.c.FZX;
            com.tencent.mm.plugin.textstatus.f.h.c.fwf();
            paramArrayOfByte = com.tencent.mm.plugin.textstatus.k.a.UsD;
            localObject2 = ((v)localObject1).Usb;
            String str = locald.Gas;
            paramArrayOfByte = localg.Gau;
            if (paramArrayOfByte != null)
            {
              localObject1 = paramArrayOfByte.GaI;
              paramArrayOfByte = (byte[])localObject1;
              if (localObject1 != null) {}
            }
            else
            {
              paramArrayOfByte = "";
            }
            com.tencent.mm.plugin.textstatus.k.a.a((String)localObject2, Long.valueOf(1L), str, paramArrayOfByte);
            Log.i("MicroMsg.TxtStatus.NetSceneModeTextStatus", "onSceneEnd mod statusId:" + locald.Gas + ", expireTime:" + localg.pRN + " result:" + params + " rowId:" + l2);
          }
        }
      }
    }
    for (;;)
    {
      params = this.callback;
      if (params == null) {
        break label581;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(216176);
      return;
      label525:
      paramInt1 = 0;
      break;
      label530:
      paramInt1 = 0;
      break label177;
      label535:
      Log.e("MicroMsg.TxtStatus.NetSceneModeTextStatus", "postInfo is null?");
      break label304;
      label546:
      Log.w("MicroMsg.TxtStatus.NetSceneModeTextStatus", "onSceneEnd mod statusId:" + locald.Gas + ", this is deleted");
    }
    label581:
    AppMethodBeat.o(216176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.b
 * JD-Core Version:    0.7.0.1
 */