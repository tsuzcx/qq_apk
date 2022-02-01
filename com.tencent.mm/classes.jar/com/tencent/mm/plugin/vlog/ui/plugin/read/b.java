package com.tencent.mm.plugin.vlog.ui.plugin.read;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "inputText", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "getInputText", "()Ljava/lang/String;", "outputSpeech", "", "getOutputSpeech", "()[B", "setOutputSpeech", "([B)V", "reqId", "", "getReqId", "()I", "setReqId", "(I)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-vlog_release"})
public final class b
  extends q
  implements m
{
  public static final a GLU;
  public byte[] GLS;
  public final String GLT;
  private i callback;
  public long durationMs;
  private d hJu;
  public int wJG;
  
  static
  {
    AppMethodBeat.i(191809);
    GLU = new a((byte)0);
    AppMethodBeat.o(191809);
  }
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191808);
    this.GLT = paramString2;
    paramString2 = new d.a();
    paramString2.MB("/cgi-bin/micromsg-bin/findertexttospeech");
    paramString2.sG(getType());
    bdm localbdm = new bdm();
    localbdm.finderUsername = paramString1;
    localbdm.GLT = this.GLT;
    paramString2.c((a)localbdm);
    paramString2.d((a)new bdn());
    paramString1 = paramString2.aXF();
    p.g(paramString1, "builder.buildInstance()");
    this.hJu = paramString1;
    AppMethodBeat.o(191808);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(191806);
    Log.i("MicroMsg.NetSceneFinderTextToSpeech", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(191806);
    return i;
  }
  
  public final int getType()
  {
    return 5207;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(191807);
    Log.i("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd, errType:" + paramInt2 + ", errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd error");
    }
    params = this.hJu.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderTextToSpeechResp");
      AppMethodBeat.o(191807);
      throw paramString;
    }
    paramArrayOfByte = (bdn)params;
    params = paramArrayOfByte.LNl;
    if (params != null) {}
    for (params = params.zy;; params = null)
    {
      this.GLS = params;
      this.durationMs = paramArrayOfByte.durationMs;
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(191807);
      return;
    }
    AppMethodBeat.o(191807);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.b
 * JD-Core Version:    0.7.0.1
 */