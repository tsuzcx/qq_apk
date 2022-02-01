package com.tencent.mm.plugin.vlog.ui.plugin.read;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bxn;
import com.tencent.mm.protocal.protobuf.bxo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "inputText", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "getInputText", "()Ljava/lang/String;", "outputSpeech", "", "getOutputSpeech", "()[B", "setOutputSpeech", "([B)V", "reqId", "", "getReqId", "()I", "setReqId", "(I)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends p
  implements m
{
  public static final a Ums;
  int Ume;
  final String Umt;
  byte[] Umu;
  private h callback;
  long durationMs;
  private c nao;
  
  static
  {
    AppMethodBeat.i(282929);
    Ums = new a((byte)0);
    AppMethodBeat.o(282929);
  }
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(282922);
    this.Umt = paramString2;
    paramString2 = new c.a();
    paramString2.uri = "/cgi-bin/micromsg-bin/findertexttospeech";
    paramString2.funcId = getType();
    bxn localbxn = new bxn();
    localbxn.finderUsername = paramString1;
    localbxn.Umt = this.Umt;
    paramString2.otE = ((a)localbxn);
    paramString2.otF = ((a)new bxo());
    paramString1 = paramString2.bEF();
    kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
    this.nao = paramString1;
    AppMethodBeat.o(282922);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(282933);
    Log.i("MicroMsg.NetSceneFinderTextToSpeech", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(282933);
    return i;
  }
  
  public final int getType()
  {
    return 5207;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(282949);
    Log.i("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd, errType:" + paramInt2 + ", errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd error");
    }
    params = c.c.b(this.nao.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderTextToSpeechResp");
      AppMethodBeat.o(282949);
      throw paramString;
    }
    paramArrayOfByte = (bxo)params;
    params = paramArrayOfByte.aago;
    if (params == null) {}
    for (params = null;; params = params.Op)
    {
      this.Umu = params;
      this.durationMs = paramArrayOfByte.durationMs;
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(282949);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.b
 * JD-Core Version:    0.7.0.1
 */