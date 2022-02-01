package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.protocal.protobuf.mj;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScene;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "sessionId", "", "mode", "", "seqNum", "searchInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "([BJIILcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class f
  extends n
  implements k
{
  public static final f.a yCL;
  private com.tencent.mm.ak.f callback;
  long dmK;
  final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(189563);
    yCL = new f.a((byte)0);
    AppMethodBeat.o(189563);
  }
  
  public f(byte[] paramArrayOfByte, long paramLong, int paramInt, ml paramml, mc parammc, ScanImagePHashInfo paramScanImagePHashInfo)
  {
    AppMethodBeat.i(189562);
    this.dmK = paramLong;
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new mj());
    ((b.a)localObject).d((a)new mk());
    ((b.a)localObject).DN("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_scene");
    ((b.a)localObject).oS(1100);
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      paramArrayOfByte = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneRequest");
      AppMethodBeat.o(189562);
      throw paramArrayOfByte;
    }
    mj localmj = (mj)localObject;
    localmj.mode = paramInt;
    localmj.FTU = 0;
    localmj.FXp = com.tencent.mm.bw.b.cm(paramArrayOfByte);
    localmj.FXv = paramLong;
    localmj.FXT = paramml;
    localmj.FXB = parammc;
    String str;
    if (paramScanImagePHashInfo != null)
    {
      str = paramScanImagePHashInfo.pHash;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localmj.FXQ = ((String)localObject);
    if (paramScanImagePHashInfo != null)
    {
      str = paramScanImagePHashInfo.pHashVersion;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localmj.FXR = ((String)localObject);
    ae.i("MicroMsg.NetSceneAiScanImageScene", "alvinluo NetSceneAiScanImageScene imageSize: %d, mode: %d, sessionId: %d, seqNum: %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(0) });
    if (paramml != null)
    {
      paramArrayOfByte = Integer.valueOf(paramml.FXW);
      if (parammc == null) {
        break label426;
      }
      paramml = Float.valueOf(parammc.dzE);
      label320:
      if (parammc == null) {
        break label432;
      }
      localObject = Float.valueOf(parammc.dBu);
      label335:
      if (parammc == null) {
        break label438;
      }
      parammc = Float.valueOf(parammc.FXo);
      label350:
      if (paramScanImagePHashInfo == null) {
        break label444;
      }
      str = paramScanImagePHashInfo.pHash;
      label362:
      if (paramScanImagePHashInfo == null) {
        break label450;
      }
    }
    label426:
    label432:
    label438:
    label444:
    label450:
    for (paramScanImagePHashInfo = paramScanImagePHashInfo.pHashVersion;; paramScanImagePHashInfo = null)
    {
      ae.v("MicroMsg.NetSceneAiScanImageScene", "alvinluo NetSceneAiScanImageScene %s, %s, %s, %s, pHash: %s, pHashVersion: %s", new Object[] { paramArrayOfByte, paramml, localObject, parammc, str, paramScanImagePHashInfo });
      AppMethodBeat.o(189562);
      return;
      paramArrayOfByte = null;
      break;
      paramml = null;
      break label320;
      localObject = null;
      break label335;
      parammc = null;
      break label350;
      str = null;
      break label362;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(189561);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(189561);
    return i;
  }
  
  public final int getType()
  {
    return 1100;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189560);
    ae.i("MicroMsg.NetSceneAiScanImageScene", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189560);
      return;
    }
    AppMethodBeat.o(189560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.f
 * JD-Core Version:    0.7.0.1
 */