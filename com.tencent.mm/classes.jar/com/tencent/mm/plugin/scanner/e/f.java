package com.tencent.mm.plugin.scanner.e;

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
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.a.b;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ocr/NetSceneBizImageOCR;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "sessionId", "", "source", "", "seqNum", "decodeResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "cdnUploadResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "([BJIILcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizOcrChatImageResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class f
  extends q
  implements m
{
  public static final f.a CIK;
  private i callback;
  public long dDZ;
  public final d rr;
  
  static
  {
    AppMethodBeat.i(240557);
    CIK = new f.a((byte)0);
    AppMethodBeat.o(240557);
  }
  
  public f(byte[] paramArrayOfByte, long paramLong, int paramInt, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(240556);
    this.dDZ = paramLong;
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new oz());
    ((d.a)localObject).d((a)new pa());
    ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/imgretrieval/ocr_chat_image");
    ((d.a)localObject).sG(getType());
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramArrayOfByte = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizOcrChatImageRequest");
      AppMethodBeat.o(240556);
      throw paramArrayOfByte;
    }
    localObject = (oz)localObject;
    ((oz)localObject).KRi = paramLong;
    ((oz)localObject).source = paramInt;
    ((oz)localObject).KND = 0;
    if (paramArrayOfByte != null) {
      ((oz)localObject).KRc = b.cD(paramArrayOfByte);
    }
    if (paramb != null)
    {
      Log.i("MicroMsg.NetSceneBizImageOCR", "alvinluo NetSceneBizImageOCR decodeResult: %s, %s", new Object[] { Integer.valueOf(paramb.xlg), Integer.valueOf(paramb.xlh) });
      ((oz)localObject).KRJ = paramb.xlg;
      ((oz)localObject).KRK = paramb.xlh;
    }
    if (parama != null)
    {
      Log.d("MicroMsg.NetSceneBizImageOCR", "alvinluo NetSceneBizImageOCR cdnUploadResult: %s, %s, %s", new Object[] { parama.aesKey, parama.fileID, parama.imageUrl });
      ((oz)localObject).KRI = parama.aesKey;
      ((oz)localObject).KRH = parama.fileID;
      ((oz)localObject).xve = parama.imageUrl;
    }
    paramb = new StringBuilder("alvinluo NetSceneBizImageOCR imageSize: ");
    if (paramArrayOfByte != null) {}
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = null)
    {
      Log.i("MicroMsg.NetSceneBizImageOCR", paramArrayOfByte + ", sessionId: " + paramLong + ", source: " + paramInt + ", seqNum: 0");
      AppMethodBeat.o(240556);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(240555);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(240555);
    return i;
  }
  
  public final int getType()
  {
    return 5131;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(240554);
    Log.i("MicroMsg.NetSceneBizImageOCR", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(240554);
      return;
    }
    AppMethodBeat.o(240554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.f
 * JD-Core Version:    0.7.0.1
 */