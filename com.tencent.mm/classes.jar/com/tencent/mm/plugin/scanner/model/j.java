package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScene;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "sessionId", "", "type", "", "mode", "seqNum", "searchInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "decodeResult", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "cdnUploadResult", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "cdnInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "Lkotlin/collections/ArrayList;", "([BJIIILcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;Ljava/util/ArrayList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends p
  implements m
{
  public static final j.a ORB;
  private h callback;
  public long hBk;
  public final c rr;
  
  static
  {
    AppMethodBeat.i(314399);
    ORB = new j.a((byte)0);
    AppMethodBeat.o(314399);
  }
  
  public j(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, nz paramnz, nq paramnq, ScanImagePHashInfo paramScanImagePHashInfo, ArrayList<nn> paramArrayList)
  {
    AppMethodBeat.i(314388);
    this.hBk = paramLong;
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new nx());
    ((c.a)localObject).otF = ((a)new ny());
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_scene";
    ((c.a)localObject).funcId = 1100;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.rr = ((c)localObject);
    localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      paramArrayOfByte = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneRequest");
      AppMethodBeat.o(314388);
      throw paramArrayOfByte;
    }
    nx localnx = (nx)localObject;
    localnx.type = paramInt1;
    localnx.mode = paramInt2;
    localnx.YLL = 0;
    if (paramArrayOfByte != null) {
      localnx.YPG = b.cX(paramArrayOfByte);
    }
    localnx.YPK = paramLong;
    localnx.YQg = paramnz;
    localnx.ORh = paramnq;
    if (paramScanImagePHashInfo == null)
    {
      localObject = "";
      localnx.YQd = ((String)localObject);
      if (paramScanImagePHashInfo != null) {
        break label451;
      }
      localObject = "";
      label219:
      localnx.YQe = ((String)localObject);
      if (paramArrayList != null) {
        localnx.YQl.addAll((Collection)paramArrayList);
      }
      localObject = new StringBuilder("alvinluo NetSceneAiScanImageScene imageSize: ");
      if (paramArrayOfByte != null) {
        break label474;
      }
      paramArrayOfByte = null;
      label262:
      localObject = ((StringBuilder)localObject).append(paramArrayOfByte).append(", type: ").append(paramInt1).append(", mode: ").append(paramInt2).append(", sessionId: ").append(paramLong).append(", seqNum: 0, cdnUploadResult: ").append(null).append(", cdnInfoList: ");
      if (paramArrayList != null) {
        break label483;
      }
      paramArrayOfByte = null;
      label320:
      Log.i("MicroMsg.NetSceneAiScanImageScene", paramArrayOfByte);
      if (paramnz != null) {
        break label495;
      }
      paramArrayOfByte = null;
      label341:
      if (paramnq != null) {
        break label507;
      }
      paramnz = null;
      label349:
      if (paramnq != null) {
        break label520;
      }
      paramArrayList = null;
      label357:
      if (paramnq != null) {
        break label533;
      }
      paramnq = null;
      label365:
      if (paramScanImagePHashInfo != null) {
        break label546;
      }
      localObject = null;
      label373:
      if (paramScanImagePHashInfo != null) {
        break label556;
      }
    }
    label520:
    label533:
    label546:
    label556:
    for (paramScanImagePHashInfo = null;; paramScanImagePHashInfo = paramScanImagePHashInfo.pHashVersion)
    {
      Log.v("MicroMsg.NetSceneAiScanImageScene", "alvinluo NetSceneAiScanImageScene %s, %s, %s, %s, pHash: %s, pHashVersion: %s", new Object[] { paramArrayOfByte, paramnz, paramArrayList, paramnq, localObject, paramScanImagePHashInfo });
      AppMethodBeat.o(314388);
      return;
      String str = paramScanImagePHashInfo.pHash;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label451:
      str = paramScanImagePHashInfo.pHashVersion;
      localObject = str;
      if (str != null) {
        break label219;
      }
      localObject = "";
      break label219;
      label474:
      paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);
      break label262;
      label483:
      paramArrayOfByte = Integer.valueOf(paramArrayList.size());
      break label320;
      label495:
      paramArrayOfByte = Integer.valueOf(paramnz.YQo);
      break label341;
      label507:
      paramnz = Float.valueOf(paramnq.latitude);
      break label349;
      paramArrayList = Float.valueOf(paramnq.longitude);
      break label357;
      paramnq = Float.valueOf(paramnq.YPF);
      break label365;
      localObject = paramScanImagePHashInfo.pHash;
      break label373;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(314409);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(314409);
    return i;
  }
  
  public final int getType()
  {
    return 1100;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(314405);
    Log.i("MicroMsg.NetSceneAiScanImageScene", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(314405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.j
 * JD-Core Version:    0.7.0.1
 */