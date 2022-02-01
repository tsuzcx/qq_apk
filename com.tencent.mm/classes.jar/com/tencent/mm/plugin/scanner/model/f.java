package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.protocal.protobuf.mj;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScene;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "sessionId", "", "mode", "", "seqNum", "searchInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanImagePHashInfo;", "([BJIILcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;Lcom/tencent/mm/plugin/scanner/model/ScanImagePHashInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class f
  extends n
  implements k
{
  public static final f.a ymN;
  private com.tencent.mm.al.f callback;
  long dlI;
  final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(186278);
    ymN = new f.a((byte)0);
    AppMethodBeat.o(186278);
  }
  
  public f(byte[] paramArrayOfByte, long paramLong, int paramInt, mj parammj, mc parammc, ScanImagePHashInfo paramScanImagePHashInfo)
  {
    AppMethodBeat.i(186277);
    this.dlI = paramLong;
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new mh());
    ((b.a)localObject).d((a)new mi());
    ((b.a)localObject).Dl("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_scene");
    ((b.a)localObject).oP(1100);
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.al.b)localObject);
    localObject = this.rr.aEE();
    if (localObject == null)
    {
      paramArrayOfByte = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneRequest");
      AppMethodBeat.o(186277);
      throw paramArrayOfByte;
    }
    mh localmh = (mh)localObject;
    localmh.mode = paramInt;
    localmh.FBz = 0;
    localmh.FEU = com.tencent.mm.bx.b.cj(paramArrayOfByte);
    localmh.FFa = paramLong;
    localmh.FFu = parammj;
    localmh.FFg = parammc;
    String str;
    if (paramScanImagePHashInfo != null)
    {
      str = paramScanImagePHashInfo.getPHash();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localmh.FFw = ((String)localObject);
    if (paramScanImagePHashInfo != null)
    {
      str = paramScanImagePHashInfo.getPHashVersion();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localmh.FFx = ((String)localObject);
    ad.i("MicroMsg.NetSceneAiScanImageScene", "alvinluo NetSceneAiScanImageScene imageSize: %d, mode: %d, sessionId: %d, seqNum: %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(0) });
    if (parammj != null)
    {
      paramArrayOfByte = Integer.valueOf(parammj.FFA);
      if (parammc == null) {
        break label426;
      }
      parammj = Float.valueOf(parammc.dyz);
      label320:
      if (parammc == null) {
        break label432;
      }
      localObject = Float.valueOf(parammc.dAp);
      label335:
      if (parammc == null) {
        break label438;
      }
      parammc = Float.valueOf(parammc.FET);
      label350:
      if (paramScanImagePHashInfo == null) {
        break label444;
      }
      str = paramScanImagePHashInfo.getPHash();
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
    for (paramScanImagePHashInfo = paramScanImagePHashInfo.getPHashVersion();; paramScanImagePHashInfo = null)
    {
      ad.v("MicroMsg.NetSceneAiScanImageScene", "alvinluo NetSceneAiScanImageScene %s, %s, %s, %s, pHash: %s, pHashVersion: %s", new Object[] { paramArrayOfByte, parammj, localObject, parammc, str, paramScanImagePHashInfo });
      AppMethodBeat.o(186277);
      return;
      paramArrayOfByte = null;
      break;
      parammj = null;
      break label320;
      localObject = null;
      break label335;
      parammc = null;
      break label350;
      str = null;
      break label362;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(186276);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(186276);
    return i;
  }
  
  public final int getType()
  {
    return 1100;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186275);
    ad.i("MicroMsg.NetSceneAiScanImageScene", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(186275);
      return;
    }
    AppMethodBeat.o(186275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.f
 * JD-Core Version:    0.7.0.1
 */