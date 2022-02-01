package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.eue;
import com.tencent.mm.protocal.protobuf.euf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrievalV2;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqKeyList", "", "", "isClick", "", "(Ljava/util/List;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/ScanV2RetrievalLiteResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends com.tencent.mm.am.p
  implements m
{
  public static final a ORH;
  private h callback;
  public final c oDw;
  
  static
  {
    AppMethodBeat.i(314371);
    ORH = new a((byte)0);
    AppMethodBeat.o(314371);
  }
  
  public n(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(314368);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new eue());
    ((c.a)localObject).otF = ((a)new euf());
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/mmbizscan_v2_retrieval_lite";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).timeout = ac.gRh();
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.oDw = ((c)localObject);
    localObject = c.b.b(this.oDw.otB);
    if (localObject == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ScanV2RetrievalLiteRequest");
      AppMethodBeat.o(314368);
      throw paramList;
    }
    localObject = (eue)localObject;
    ((eue)localObject).abxg.addAll((Collection)paramList);
    ((eue)localObject).Zmv = paramBoolean;
    Log.d("MicroMsg.NetSceneBizAiScanImageRetrieval", "alvinluo AiScanImageRetrieval reqKeyList: %s, isClick: %s", new Object[] { kotlin.a.p.a((Iterable)paramList, (CharSequence)",", null, null, 0, null, null, 62), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(314368);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(314379);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(314379);
    return i;
  }
  
  public final int getType()
  {
    return 5107;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(314387);
    Log.i("MicroMsg.NetSceneBizAiScanImageRetrieval", "AiScanImageRetrieval onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    AppMethodBeat.o(314387);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrievalV2$Companion;", "", "()V", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.n
 * JD-Core Version:    0.7.0.1
 */