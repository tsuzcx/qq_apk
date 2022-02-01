package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.protocal.protobuf.na;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScenePreview;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "sessionId", "", "seqNum", "", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "(JILcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageScenePreviewResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"})
public final class i
  extends q
  implements m
{
  public static final a CFB;
  private com.tencent.mm.ak.i callback;
  long dDZ;
  final d rr;
  
  static
  {
    AppMethodBeat.i(240410);
    CFB = new a((byte)0);
    AppMethodBeat.o(240410);
  }
  
  public i(long paramLong, ScanImagePHashInfo paramScanImagePHashInfo)
  {
    AppMethodBeat.i(240409);
    this.dDZ = paramLong;
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new mz());
    ((d.a)localObject).d((a)new na());
    ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/imgretrieval/aiscan_image_scene_preview");
    ((d.a)localObject).sG(5079);
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramScanImagePHashInfo = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageScenePreviewRequest");
      AppMethodBeat.o(240409);
      throw paramScanImagePHashInfo;
    }
    mz localmz = (mz)localObject;
    localmz.KRi = paramLong;
    localmz.KND = 0;
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
    localmz.KRD = ((String)localObject);
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
    localmz.KRE = ((String)localObject);
    Log.i("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo NetSceneAiScanImageScenePreview sessionId: %d, seqNum: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(0) });
    if (paramScanImagePHashInfo != null) {}
    for (localObject = paramScanImagePHashInfo.pHash;; localObject = null)
    {
      if (paramScanImagePHashInfo != null) {
        str1 = paramScanImagePHashInfo.pHashVersion;
      }
      Log.v("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo NetSceneAiScanImageScenePreview pHash: %s, pHashVersion: %s", new Object[] { localObject, str1 });
      AppMethodBeat.o(240409);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(240408);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(240408);
    return i;
  }
  
  public final int getType()
  {
    return 5079;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(240407);
    Log.i("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(240407);
      return;
    }
    AppMethodBeat.o(240407);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScenePreview$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.i
 * JD-Core Version:    0.7.0.1
 */