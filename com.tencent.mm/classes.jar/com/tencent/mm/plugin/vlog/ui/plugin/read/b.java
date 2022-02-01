package com.tencent.mm.plugin.vlog.ui.plugin.read;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "inputText", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "getInputText", "()Ljava/lang/String;", "outputSpeech", "", "getOutputSpeech", "()[B", "setOutputSpeech", "([B)V", "reqId", "", "getReqId", "()I", "setReqId", "(I)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-vlog_release"})
public final class b
  extends q
  implements m
{
  public static final a Nzz;
  int Nzh;
  byte[] Nzx;
  final String Nzy;
  private i callback;
  long durationMs;
  private d kwO;
  
  static
  {
    AppMethodBeat.i(250335);
    Nzz = new a((byte)0);
    AppMethodBeat.o(250335);
  }
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(250332);
    this.Nzy = paramString2;
    paramString2 = new d.a();
    paramString2.TW("/cgi-bin/micromsg-bin/findertexttospeech");
    paramString2.vD(getType());
    bkk localbkk = new bkk();
    localbkk.finderUsername = paramString1;
    localbkk.Nzy = this.Nzy;
    paramString2.c((a)localbkk);
    paramString2.d((a)new bkl());
    paramString1 = paramString2.bgN();
    p.j(paramString1, "builder.buildInstance()");
    this.kwO = paramString1;
    AppMethodBeat.o(250332);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(250325);
    Log.i("MicroMsg.NetSceneFinderTextToSpeech", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.kwO, (m)this);
    AppMethodBeat.o(250325);
    return i;
  }
  
  public final int getType()
  {
    return 5207;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(250330);
    Log.i("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd, errType:" + paramInt2 + ", errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd error");
    }
    params = this.kwO.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderTextToSpeechResp");
      AppMethodBeat.o(250330);
      throw paramString;
    }
    paramArrayOfByte = (bkl)params;
    params = paramArrayOfByte.SVq;
    if (params != null) {}
    for (params = params.UH;; params = null)
    {
      this.Nzx = params;
      this.durationMs = paramArrayOfByte.durationMs;
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(250330);
      return;
    }
    AppMethodBeat.o(250330);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.b
 * JD-Core Version:    0.7.0.1
 */