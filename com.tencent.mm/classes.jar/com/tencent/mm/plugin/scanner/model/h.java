package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScene;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "sessionId", "", "type", "", "mode", "seqNum", "searchInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "decodeResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "cdnUploadResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "([BJIIILcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class h
  extends q
  implements m
{
  public static final h.a CFA;
  private i callback;
  long dDZ;
  final d rr;
  
  static
  {
    AppMethodBeat.i(240406);
    CFA = new h.a((byte)0);
    AppMethodBeat.o(240406);
  }
  
  public h(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, nd paramnd, mu parammu, ScanImagePHashInfo paramScanImagePHashInfo, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(240405);
    this.dDZ = paramLong;
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new nb());
    ((d.a)localObject).d((a)new nc());
    ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_scene");
    ((d.a)localObject).sG(1100);
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramArrayOfByte = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneRequest");
      AppMethodBeat.o(240405);
      throw paramArrayOfByte;
    }
    nb localnb = (nb)localObject;
    localnb.type = paramInt1;
    localnb.mode = paramInt2;
    localnb.KND = 0;
    if (paramArrayOfByte != null) {
      localnb.KRc = b.cD(paramArrayOfByte);
    }
    localnb.KRi = paramLong;
    localnb.KRG = paramnd;
    localnb.KRo = parammu;
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
    localnb.KRD = ((String)localObject);
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
    localnb.KRE = ((String)localObject);
    if (paramb != null)
    {
      localnb.KRJ = paramb.xlg;
      localnb.KRK = paramb.xlh;
    }
    if (parama != null)
    {
      localnb.KRI = parama.aesKey;
      localnb.KRH = parama.fileID;
      localnb.xve = parama.imageUrl;
    }
    paramb = new StringBuilder("alvinluo NetSceneAiScanImageScene imageSize: ");
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);
      paramb = paramb.append(paramArrayOfByte).append(", type: ").append(paramInt1).append(", mode: ").append(paramInt2).append(", sessionId: ").append(paramLong).append(", seqNum: 0, fileId:");
      if (parama == null) {
        break label542;
      }
      paramArrayOfByte = parama.fileID;
      label390:
      Log.i("MicroMsg.NetSceneAiScanImageScene", paramArrayOfByte);
      if (paramnd == null) {
        break label547;
      }
      paramArrayOfByte = Integer.valueOf(paramnd.KRN);
      label419:
      if (parammu == null) {
        break label552;
      }
      paramnd = Float.valueOf(parammu.latitude);
      label434:
      if (parammu == null) {
        break label558;
      }
      paramb = Float.valueOf(parammu.dTj);
      label449:
      if (parammu == null) {
        break label564;
      }
      parammu = Float.valueOf(parammu.KRb);
      label464:
      if (paramScanImagePHashInfo == null) {
        break label570;
      }
      parama = paramScanImagePHashInfo.pHash;
      label476:
      if (paramScanImagePHashInfo == null) {
        break label576;
      }
    }
    label542:
    label547:
    label552:
    label558:
    label564:
    label570:
    label576:
    for (paramScanImagePHashInfo = paramScanImagePHashInfo.pHashVersion;; paramScanImagePHashInfo = null)
    {
      Log.v("MicroMsg.NetSceneAiScanImageScene", "alvinluo NetSceneAiScanImageScene %s, %s, %s, %s, pHash: %s, pHashVersion: %s", new Object[] { paramArrayOfByte, paramnd, paramb, parammu, parama, paramScanImagePHashInfo });
      AppMethodBeat.o(240405);
      return;
      paramArrayOfByte = null;
      break;
      paramArrayOfByte = null;
      break label390;
      paramArrayOfByte = null;
      break label419;
      paramnd = null;
      break label434;
      paramb = null;
      break label449;
      parammu = null;
      break label464;
      parama = null;
      break label476;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(240404);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(240404);
    return i;
  }
  
  public final int getType()
  {
    return 1100;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(240403);
    Log.i("MicroMsg.NetSceneAiScanImageScene", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(240403);
      return;
    }
    AppMethodBeat.o(240403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.h
 * JD-Core Version:    0.7.0.1
 */