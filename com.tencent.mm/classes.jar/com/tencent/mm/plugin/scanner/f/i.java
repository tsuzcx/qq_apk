package com.tencent.mm.plugin.scanner.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/NetSceneBizImageOCR;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "sessionId", "", "source", "", "seqNum", "decodeResult", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "cdnUploadResult", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "cdnInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "Lkotlin/collections/ArrayList;", "([BJIILcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;Ljava/util/ArrayList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizOcrChatImageResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class i
  extends q
  implements m
{
  public static final a IOa;
  private com.tencent.mm.an.i callback;
  public long fwK;
  public final d rr;
  
  static
  {
    AppMethodBeat.i(218496);
    IOa = new a((byte)0);
    AppMethodBeat.o(218496);
  }
  
  private i(byte[] paramArrayOfByte, long paramLong, int paramInt, ArrayList<mi> paramArrayList)
  {
    AppMethodBeat.i(218494);
    this.fwK = paramLong;
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new ov());
    ((d.a)localObject).d((a)new ow());
    ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/imgretrieval/ocr_chat_image");
    ((d.a)localObject).vD(getType());
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.bhX();
    if (localObject == null)
    {
      paramArrayOfByte = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizOcrChatImageRequest");
      AppMethodBeat.o(218494);
      throw paramArrayOfByte;
    }
    localObject = (ov)localObject;
    ((ov)localObject).RSk = paramLong;
    ((ov)localObject).source = paramInt;
    ((ov)localObject).ROx = 0;
    if (paramArrayOfByte != null) {
      ((ov)localObject).RSg = b.cU(paramArrayOfByte);
    }
    if (paramArrayList != null) {
      ((ov)localObject).RSL.addAll((Collection)paramArrayList);
    }
    paramArrayList = new StringBuilder("alvinluo NetSceneBizImageOCR imageSize: ");
    if (paramArrayOfByte != null) {}
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = null)
    {
      Log.i("MicroMsg.NetSceneBizImageOCR", paramArrayOfByte + ", sessionId: " + paramLong + ", source: " + paramInt + ", seqNum: 0, cdn_image_list: " + ((ov)localObject).RSL);
      AppMethodBeat.o(218494);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(218493);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(218493);
    return i;
  }
  
  public final int getType()
  {
    return 5131;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218492);
    Log.i("MicroMsg.NetSceneBizImageOCR", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(218492);
      return;
    }
    AppMethodBeat.o(218492);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/NetSceneBizImageOCR$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.i
 * JD-Core Version:    0.7.0.1
 */