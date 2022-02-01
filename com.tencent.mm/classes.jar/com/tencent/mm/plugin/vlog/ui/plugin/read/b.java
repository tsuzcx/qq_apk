package com.tencent.mm.plugin.vlog.ui.plugin.read;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "inputText", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "getInputText", "()Ljava/lang/String;", "outputSpeech", "", "getOutputSpeech", "()[B", "setOutputSpeech", "([B)V", "reqId", "", "getReqId", "()I", "setReqId", "(I)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-vlog_release"})
public final class b
  extends n
  implements k
{
  public static final a BRt;
  public int BRd;
  byte[] BRr;
  final String BRs;
  long bup;
  private f callback;
  private com.tencent.mm.al.b gPp;
  
  static
  {
    AppMethodBeat.i(196623);
    BRt = new a((byte)0);
    AppMethodBeat.o(196623);
  }
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196622);
    this.BRs = paramString2;
    paramString2 = new com.tencent.mm.al.b.a();
    paramString2.Dl("/cgi-bin/micromsg-bin/findertexttospeech");
    paramString2.oP(getType());
    asb localasb = new asb();
    localasb.rTn = paramString1;
    localasb.BRs = this.BRs;
    paramString2.c((a)localasb);
    paramString2.d((a)new asc());
    paramString1 = paramString2.aDC();
    p.g(paramString1, "builder.buildInstance()");
    this.gPp = paramString1;
    AppMethodBeat.o(196622);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(196620);
    ad.i("MicroMsg.NetSceneFinderTextToSpeech", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(196620);
    return i;
  }
  
  public final int getType()
  {
    return 5207;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196621);
    ad.i("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd, errType:" + paramInt2 + ", errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd error");
    }
    paramq = this.gPp.aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderTextToSpeechResp");
      AppMethodBeat.o(196621);
      throw paramString;
    }
    paramArrayOfByte = (asc)paramq;
    paramq = paramArrayOfByte.Gqm;
    if (paramq != null) {}
    for (paramq = paramq.getBytes();; paramq = null)
    {
      this.BRr = paramq;
      this.bup = paramArrayOfByte.bup;
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(196621);
      return;
    }
    AppMethodBeat.o(196621);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.b
 * JD-Core Version:    0.7.0.1
 */