package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.eug;
import com.tencent.mm.protocal.protobuf.euh;
import com.tencent.mm.protocal.protobuf.eui;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageV2;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "imageWidth", "", "imageHeight", "mode", "scanType", "sessionId", "", "scanProductInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanProductInfo;", "adInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "jsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "location", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "([BIIIIJLcom/tencent/mm/plugin/scanner/model/ScanProductInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "requestLocation", "requestTrackIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLocation", "getRequestTrackIdList", "", "getResp", "Lcom/tencent/mm/protocal/protobuf/ScanV2UploadResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends com.tencent.mm.am.p
  implements m
{
  public static final l.a ORD;
  private nq ORE;
  public ArrayList<Integer> ORF;
  private h callback;
  public long hBk;
  private final c rr;
  
  static
  {
    AppMethodBeat.i(314392);
    ORD = new l.a((byte)0);
    AppMethodBeat.o(314392);
  }
  
  public l(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, ScanProductInfo paramScanProductInfo)
  {
    AppMethodBeat.i(314380);
    this.ORF = new ArrayList();
    this.hBk = paramLong;
    this.ORE = null;
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = ((a)new euh());
    ((c.a)localObject1).otF = ((a)new eui());
    ((c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/mmbizscan_v2_upload";
    ((c.a)localObject1).funcId = 5105;
    ((c.a)localObject1).otG = 0;
    ((c.a)localObject1).respCmdId = 0;
    ((c.a)localObject1).timeout = ac.gRg();
    localObject1 = ((c.a)localObject1).bEF();
    kotlin.g.b.s.s(localObject1, "builder.buildInstance()");
    this.rr = ((c)localObject1);
    localObject1 = c.b.b(this.rr.otB);
    if (localObject1 == null)
    {
      paramArrayOfByte = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ScanV2UploadRequest");
      AppMethodBeat.o(314380);
      throw paramArrayOfByte;
    }
    localObject1 = (euh)localObject1;
    ((euh)localObject1).mode = paramInt3;
    ((euh)localObject1).aaxM = paramLong;
    ((euh)localObject1).YPS = (System.currentTimeMillis() / 1000L);
    ((euh)localObject1).abxi = paramInt4;
    ((euh)localObject1).abxj = false;
    LinkedList localLinkedList = ((euh)localObject1).msn;
    eug localeug = new eug();
    localeug.YPG = b.cX(paramArrayOfByte);
    Object localObject2 = localeug.YPw;
    nl localnl = new nl();
    this.ORF.add(Integer.valueOf(paramScanProductInfo.getId()));
    localnl.YPp = paramScanProductInfo.getId();
    Object localObject3 = new GoodsObject();
    ((GoodsObject)localObject3).relative_minx = 0.0F;
    ((GoodsObject)localObject3).relative_miny = 0.0F;
    ((GoodsObject)localObject3).relative_maxx = paramInt1;
    ((GoodsObject)localObject3).relative_maxy = paramInt2;
    ah localah = ah.aiuX;
    localnl.YPq = ((GoodsObject)localObject3);
    localnl.YPr = paramScanProductInfo.getProb();
    localObject3 = ah.aiuX;
    ((LinkedList)localObject2).add(localnl);
    localObject2 = ah.aiuX;
    localLinkedList.add(localeug);
    ((euh)localObject1).YPQ = null;
    ((euh)localObject1).YPR = null;
    ((euh)localObject1).ORh = null;
    Log.i("MicroMsg.NetSceneAiScanImageV2", "alvinluo NetSceneAiScanImageV2 imageSize: " + paramArrayOfByte.length + ", mode; " + paramInt3 + ", prob: " + paramScanProductInfo.getProb() + ", trackId: " + paramScanProductInfo.getId() + ", isPreload: " + ((euh)localObject1).abxj + ", sessionId: " + paramLong + ", mode: " + ((euh)localObject1).mode + ", imageWidth: " + paramInt1 + ", imageHeight: " + paramInt2 + ", send_srv_time: " + ((euh)localObject1).YPS);
    AppMethodBeat.o(314380);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(314414);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(314414);
    return i;
  }
  
  public final eui gQT()
  {
    AppMethodBeat.i(314423);
    if (c.c.b(this.rr.otC) != null)
    {
      Object localObject = c.c.b(this.rr.otC);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ScanV2UploadResponse");
        AppMethodBeat.o(314423);
        throw ((Throwable)localObject);
      }
      localObject = (eui)localObject;
      AppMethodBeat.o(314423);
      return localObject;
    }
    AppMethodBeat.o(314423);
    return null;
  }
  
  public final int getType()
  {
    return 5105;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(314404);
    Log.i("MicroMsg.NetSceneAiScanImageV2", "onGYNetEnd errType: " + paramInt2 + ", errCode: " + paramInt3 + ", errMsg: " + paramString + ", type: " + getType());
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    paramString = gQT();
    if (paramString != null)
    {
      paramString = paramString.abxk;
      kotlin.g.b.s.s(paramString, "resp.mark_results");
      paramString = (nm)kotlin.a.p.oL((List)paramString);
      if (paramString != null) {
        break label157;
      }
      paramString = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneAiScanImageV2", kotlin.g.b.s.X("onGYNetEnd reqKey: ", paramString));
      AppMethodBeat.o(314404);
      return;
      label157:
      paramString = paramString.YPw;
      if (paramString == null)
      {
        paramString = null;
      }
      else
      {
        paramString = (nl)kotlin.a.p.oL((List)paramString);
        if (paramString == null) {
          paramString = null;
        } else {
          paramString = paramString.hMy;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.l
 * JD-Core Version:    0.7.0.1
 */