package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScene;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "sessionId", "", "type", "", "mode", "seqNum", "searchInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "decodeResult", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "cdnUploadResult", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "cdnInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "Lkotlin/collections/ArrayList;", "([BJIIILcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;Ljava/util/ArrayList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class f
  extends q
  implements m
{
  public static final a IKN;
  private i callback;
  public long fwK;
  public final d rr;
  
  static
  {
    AppMethodBeat.i(221431);
    IKN = new a((byte)0);
    AppMethodBeat.o(221431);
  }
  
  public f(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, mu parammu, ml paramml, ScanImagePHashInfo paramScanImagePHashInfo, ArrayList<mi> paramArrayList)
  {
    AppMethodBeat.i(221429);
    this.fwK = paramLong;
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new ms());
    ((d.a)localObject).d((a)new mt());
    ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_scene");
    ((d.a)localObject).vD(1100);
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.bhX();
    if (localObject == null)
    {
      paramArrayOfByte = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneRequest");
      AppMethodBeat.o(221429);
      throw paramArrayOfByte;
    }
    ms localms = (ms)localObject;
    localms.type = paramInt1;
    localms.mode = paramInt2;
    localms.ROx = 0;
    if (paramArrayOfByte != null) {
      localms.RSg = b.cU(paramArrayOfByte);
    }
    localms.RSk = paramLong;
    localms.RSG = parammu;
    localms.IKy = paramml;
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
    localms.RSD = ((String)localObject);
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
    localms.RSE = ((String)localObject);
    if (paramArrayList != null) {
      localms.RSL.addAll((Collection)paramArrayList);
    }
    localObject = new StringBuilder("alvinluo NetSceneAiScanImageScene imageSize: ");
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);
      localObject = ((StringBuilder)localObject).append(paramArrayOfByte).append(", type: ").append(paramInt1).append(", mode: ").append(paramInt2).append(", sessionId: ").append(paramLong).append(", seqNum: 0, cdnUploadResult: ").append(null).append(", cdnInfoList: ");
      if (paramArrayList == null) {
        break label510;
      }
      paramArrayOfByte = Integer.valueOf(paramArrayList.size());
      label360:
      Log.i("MicroMsg.NetSceneAiScanImageScene", paramArrayOfByte);
      if (parammu == null) {
        break label515;
      }
      paramArrayOfByte = Integer.valueOf(parammu.RSO);
      label388:
      if (paramml == null) {
        break label520;
      }
      parammu = Float.valueOf(paramml.latitude);
      label403:
      if (paramml == null) {
        break label526;
      }
      paramArrayList = Float.valueOf(paramml.longitude);
      label418:
      if (paramml == null) {
        break label532;
      }
      paramml = Float.valueOf(paramml.RSf);
      label433:
      if (paramScanImagePHashInfo == null) {
        break label538;
      }
      localObject = paramScanImagePHashInfo.pHash;
      label445:
      if (paramScanImagePHashInfo == null) {
        break label544;
      }
    }
    label515:
    label520:
    label526:
    label532:
    label538:
    label544:
    for (paramScanImagePHashInfo = paramScanImagePHashInfo.pHashVersion;; paramScanImagePHashInfo = null)
    {
      Log.v("MicroMsg.NetSceneAiScanImageScene", "alvinluo NetSceneAiScanImageScene %s, %s, %s, %s, pHash: %s, pHashVersion: %s", new Object[] { paramArrayOfByte, parammu, paramArrayList, paramml, localObject, paramScanImagePHashInfo });
      AppMethodBeat.o(221429);
      return;
      paramArrayOfByte = null;
      break;
      label510:
      paramArrayOfByte = null;
      break label360;
      paramArrayOfByte = null;
      break label388;
      parammu = null;
      break label403;
      paramArrayList = null;
      break label418;
      paramml = null;
      break label433;
      localObject = null;
      break label445;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(221410);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(221410);
    return i;
  }
  
  public final int getType()
  {
    return 1100;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221406);
    Log.i("MicroMsg.NetSceneAiScanImageScene", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(221406);
      return;
    }
    AppMethodBeat.o(221406);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScene$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.f
 * JD-Core Version:    0.7.0.1
 */