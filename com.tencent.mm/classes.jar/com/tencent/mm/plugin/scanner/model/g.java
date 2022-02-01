package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScenePreview;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "sessionId", "", "seqNum", "", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "(JILcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageScenePreviewResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"})
public final class g
  extends q
  implements m
{
  public static final a IKO;
  private i callback;
  public long fwK;
  public final d rr;
  
  static
  {
    AppMethodBeat.i(217007);
    IKO = new a((byte)0);
    AppMethodBeat.o(217007);
  }
  
  private g(long paramLong, ScanImagePHashInfo paramScanImagePHashInfo)
  {
    AppMethodBeat.i(217006);
    this.fwK = paramLong;
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new mq());
    ((d.a)localObject).d((a)new mr());
    ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/imgretrieval/aiscan_image_scene_preview");
    ((d.a)localObject).vD(5079);
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.bhX();
    if (localObject == null)
    {
      paramScanImagePHashInfo = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageScenePreviewRequest");
      AppMethodBeat.o(217006);
      throw paramScanImagePHashInfo;
    }
    mq localmq = (mq)localObject;
    localmq.RSk = paramLong;
    localmq.ROx = 0;
    String str2;
    if (paramScanImagePHashInfo != null)
    {
      str2 = paramScanImagePHashInfo.pHash;
      localObject = str2;
      if (str2 != null) {}
    }
    else
    {
      localObject = "";
    }
    localmq.RSD = ((String)localObject);
    if (paramScanImagePHashInfo != null)
    {
      str2 = paramScanImagePHashInfo.pHashVersion;
      localObject = str2;
      if (str2 != null) {}
    }
    else
    {
      localObject = "";
    }
    localmq.RSE = ((String)localObject);
    Log.i("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo NetSceneAiScanImageScenePreview sessionId: %d, seqNum: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(0) });
    if (paramScanImagePHashInfo != null) {}
    for (localObject = paramScanImagePHashInfo.pHash;; localObject = null)
    {
      if (paramScanImagePHashInfo != null) {
        str1 = paramScanImagePHashInfo.pHashVersion;
      }
      Log.v("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo NetSceneAiScanImageScenePreview pHash: %s, pHashVersion: %s", new Object[] { localObject, str1 });
      AppMethodBeat.o(217006);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(217004);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(217004);
    return i;
  }
  
  public final int getType()
  {
    return 5079;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217003);
    Log.i("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(217003);
      return;
    }
    AppMethodBeat.o(217003);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScenePreview$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.g
 * JD-Core Version:    0.7.0.1
 */