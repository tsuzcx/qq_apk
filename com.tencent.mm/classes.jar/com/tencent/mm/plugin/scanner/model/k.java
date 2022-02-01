package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScenePreview;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "sessionId", "", "seqNum", "", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "(JILcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageScenePreviewResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends p
  implements m
{
  public static final a ORC;
  private h callback;
  public long hBk;
  public final c rr;
  
  static
  {
    AppMethodBeat.i(314384);
    ORC = new a((byte)0);
    AppMethodBeat.o(314384);
  }
  
  private k(long paramLong, ScanImagePHashInfo paramScanImagePHashInfo)
  {
    AppMethodBeat.i(314370);
    this.hBk = paramLong;
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = ((a)new nv());
    ((c.a)localObject1).otF = ((a)new nw());
    ((c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/imgretrieval/aiscan_image_scene_preview";
    ((c.a)localObject1).funcId = 5079;
    ((c.a)localObject1).otG = 0;
    ((c.a)localObject1).respCmdId = 0;
    localObject1 = ((c.a)localObject1).bEF();
    kotlin.g.b.s.s(localObject1, "builder.buildInstance()");
    this.rr = ((c)localObject1);
    localObject1 = c.b.b(this.rr.otB);
    if (localObject1 == null)
    {
      paramScanImagePHashInfo = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageScenePreviewRequest");
      AppMethodBeat.o(314370);
      throw paramScanImagePHashInfo;
    }
    nv localnv = (nv)localObject1;
    localnv.YPK = paramLong;
    localnv.YLL = 0;
    if (paramScanImagePHashInfo == null)
    {
      localObject1 = "";
      localnv.YQd = ((String)localObject1);
      if (paramScanImagePHashInfo != null) {
        break label273;
      }
      localObject1 = "";
      label179:
      localnv.YQe = ((String)localObject1);
      Log.i("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo NetSceneAiScanImageScenePreview sessionId: %d, seqNum: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(0) });
      if (paramScanImagePHashInfo != null) {
        break label295;
      }
      localObject1 = null;
      label218:
      if (paramScanImagePHashInfo != null) {
        break label304;
      }
    }
    label273:
    label295:
    label304:
    for (paramScanImagePHashInfo = localObject2;; paramScanImagePHashInfo = paramScanImagePHashInfo.pHashVersion)
    {
      Log.v("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo NetSceneAiScanImageScenePreview pHash: %s, pHashVersion: %s", new Object[] { localObject1, paramScanImagePHashInfo });
      AppMethodBeat.o(314370);
      return;
      String str = paramScanImagePHashInfo.pHash;
      localObject1 = str;
      if (str != null) {
        break;
      }
      localObject1 = "";
      break;
      str = paramScanImagePHashInfo.pHashVersion;
      localObject1 = str;
      if (str != null) {
        break label179;
      }
      localObject1 = "";
      break label179;
      localObject1 = paramScanImagePHashInfo.pHash;
      break label218;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(314410);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(314410);
    return i;
  }
  
  public final int getType()
  {
    return 5079;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(314395);
    Log.i("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(314395);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScenePreview$Companion;", "", "()V", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.k
 * JD-Core Version:    0.7.0.1
 */