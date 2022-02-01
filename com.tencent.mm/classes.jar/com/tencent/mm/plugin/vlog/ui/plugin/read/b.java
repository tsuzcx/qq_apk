package com.tencent.mm.plugin.vlog.ui.plugin.read;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "inputText", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "getInputText", "()Ljava/lang/String;", "outputSpeech", "", "getOutputSpeech", "()[B", "setOutputSpeech", "([B)V", "reqId", "", "getReqId", "()I", "setReqId", "(I)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-vlog_release"})
public final class b
  extends n
  implements k
{
  public static final a CiT;
  int CiC;
  byte[] CiR;
  final String CiS;
  long bup;
  private f callback;
  private com.tencent.mm.ak.b gRX;
  
  static
  {
    AppMethodBeat.i(192084);
    CiT = new a((byte)0);
    AppMethodBeat.o(192084);
  }
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192083);
    this.CiS = paramString2;
    paramString2 = new com.tencent.mm.ak.b.a();
    paramString2.DN("/cgi-bin/micromsg-bin/findertexttospeech");
    paramString2.oS(getType());
    asq localasq = new asq();
    localasq.sbR = paramString1;
    localasq.CiS = this.CiS;
    paramString2.c((a)localasq);
    paramString2.d((a)new asr());
    paramString1 = paramString2.aDS();
    p.g(paramString1, "builder.buildInstance()");
    this.gRX = paramString1;
    AppMethodBeat.o(192083);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(192081);
    ae.i("MicroMsg.NetSceneFinderTextToSpeech", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(192081);
    return i;
  }
  
  public final int getType()
  {
    return 5207;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(192082);
    ae.i("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd, errType:" + paramInt2 + ", errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd error");
    }
    paramq = this.gRX.aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderTextToSpeechResp");
      AppMethodBeat.o(192082);
      throw paramString;
    }
    paramArrayOfByte = (asr)paramq;
    paramq = paramArrayOfByte.GJH;
    if (paramq != null) {}
    for (paramq = paramq.getBytes();; paramq = null)
    {
      this.CiR = paramq;
      this.bup = paramArrayOfByte.bup;
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(192082);
      return;
    }
    AppMethodBeat.o(192082);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.b
 * JD-Core Version:    0.7.0.1
 */