package com.tencent.mm.plugin.scanner.f;

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
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.protocal.protobuf.qe;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/NetSceneBizImageOCR;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "sessionId", "", "source", "", "seqNum", "decodeResult", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "cdnUploadResult", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "cdnInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "Lkotlin/collections/ArrayList;", "([BJIILcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;Ljava/util/ArrayList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizOcrChatImageResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends p
  implements m
{
  public static final a OVc;
  private h callback;
  public long hBk;
  public final c rr;
  
  static
  {
    AppMethodBeat.i(313487);
    OVc = new a((byte)0);
    AppMethodBeat.o(313487);
  }
  
  private i(byte[] paramArrayOfByte, long paramLong, int paramInt, ArrayList<nn> paramArrayList)
  {
    AppMethodBeat.i(313471);
    this.hBk = paramLong;
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new qe());
    ((c.a)localObject).otF = ((a)new qf());
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/imgretrieval/ocr_chat_image";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.rr = ((c)localObject);
    localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      paramArrayOfByte = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizOcrChatImageRequest");
      AppMethodBeat.o(313471);
      throw paramArrayOfByte;
    }
    localObject = (qe)localObject;
    ((qe)localObject).YPK = paramLong;
    ((qe)localObject).source = paramInt;
    ((qe)localObject).YLL = 0;
    if (paramArrayOfByte != null) {
      ((qe)localObject).YPG = b.cX(paramArrayOfByte);
    }
    if (paramArrayList != null) {
      ((qe)localObject).YQl.addAll((Collection)paramArrayList);
    }
    paramArrayList = new StringBuilder("alvinluo NetSceneBizImageOCR imageSize: ");
    if (paramArrayOfByte == null) {}
    for (paramArrayOfByte = null;; paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length))
    {
      Log.i("MicroMsg.NetSceneBizImageOCR", paramArrayOfByte + ", sessionId: " + paramLong + ", source: " + paramInt + ", seqNum: 0, cdn_image_list: " + ((qe)localObject).YQl);
      AppMethodBeat.o(313471);
      return;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(313508);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(313508);
    return i;
  }
  
  public final int getType()
  {
    return 5131;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(313496);
    Log.i("MicroMsg.NetSceneBizImageOCR", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(313496);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/NetSceneBizImageOCR$Companion;", "", "()V", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.i
 * JD-Core Version:    0.7.0.1
 */