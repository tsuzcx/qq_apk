package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScenePreview;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "sessionId", "", "seqNum", "", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "(JILcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageScenePreviewResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"})
public final class g
  extends n
  implements k
{
  public static final a yCM;
  private f callback;
  long dmK;
  final b rr;
  
  static
  {
    AppMethodBeat.i(189567);
    yCM = new a((byte)0);
    AppMethodBeat.o(189567);
  }
  
  public g(long paramLong, ScanImagePHashInfo paramScanImagePHashInfo)
  {
    AppMethodBeat.i(189566);
    this.dmK = paramLong;
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new mh());
    ((b.a)localObject).d((a)new mi());
    ((b.a)localObject).DN("/cgi-bin/mmbiz-bin/imgretrieval/aiscan_image_scene_preview");
    ((b.a)localObject).oS(5079);
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      paramScanImagePHashInfo = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageScenePreviewRequest");
      AppMethodBeat.o(189566);
      throw paramScanImagePHashInfo;
    }
    mh localmh = (mh)localObject;
    localmh.FXv = paramLong;
    localmh.FTU = 0;
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
    localmh.FXQ = ((String)localObject);
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
    localmh.FXR = ((String)localObject);
    ae.i("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo NetSceneAiScanImageScenePreview sessionId: %d, seqNum: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(0) });
    if (paramScanImagePHashInfo != null) {}
    for (localObject = paramScanImagePHashInfo.pHash;; localObject = null)
    {
      if (paramScanImagePHashInfo != null) {
        str1 = paramScanImagePHashInfo.pHashVersion;
      }
      ae.v("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo NetSceneAiScanImageScenePreview pHash: %s, pHashVersion: %s", new Object[] { localObject, str1 });
      AppMethodBeat.o(189566);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(189565);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(189565);
    return i;
  }
  
  public final int getType()
  {
    return 5079;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189564);
    ae.i("MicroMsg.NetSceneAiScanImageScenePreview", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189564);
      return;
    }
    AppMethodBeat.o(189564);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScenePreview$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.g
 * JD-Core Version:    0.7.0.1
 */