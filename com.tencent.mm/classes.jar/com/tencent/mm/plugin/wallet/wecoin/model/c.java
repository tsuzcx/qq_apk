package com.tencent.mm.plugin.wallet.wecoin.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.epw;
import com.tencent.mm.protocal.protobuf.epx;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.StandardCharsets;

public final class c
  extends q
  implements m
{
  private i heq;
  private d rAy;
  
  public c()
  {
    AppMethodBeat.i(214137);
    this.rAy = null;
    this.heq = null;
    d.a locala = new d.a();
    locala.iLN = new epw();
    locala.iLO = new epx();
    locala.funcId = 5249;
    locala.uri = "/cgi-bin/micromsg-bin/verifysignaturetest";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rAy = locala.aXF();
    AppMethodBeat.o(214137);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(214138);
    this.heq = parami;
    parami = (epw)this.rAy.iLK.iLR;
    String str = com.tencent.mm.network.b.bjq().RO("TestSignData");
    byte[] arrayOfByte = str.getBytes(StandardCharsets.ISO_8859_1);
    if (!TextUtils.isEmpty(str))
    {
      Log.i("MMVerifyCgiSignatureTest", "after sign data length " + str.length() + " byte length " + arrayOfByte.length);
      parami.LoA = new com.tencent.mm.bw.b(arrayOfByte);
      parami.Nnu = new com.tencent.mm.bw.b("TestSignData".getBytes());
      Log.d("MMVerifyCgiSignatureTest", "zyzhang verify result ".concat(String.valueOf(com.tencent.mm.network.b.bjq().bL("TestSignData", str))));
      int i = dispatch(paramg, this.rAy, this);
      AppMethodBeat.o(214138);
      return i;
    }
    Log.e("MMVerifyCgiSignatureTest", "sign failed");
    AppMethodBeat.o(214138);
    return -1;
  }
  
  public final int getType()
  {
    return 5249;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214139);
    Log.i("MMVerifyCgiSignatureTest", "receive response " + paramInt2 + " code " + paramInt3 + " message " + paramString + " code " + params.getRespObj().getRetCode());
    paramArrayOfByte = (epx)this.rAy.iLL.iLR;
    params = params.getRespObj().getProfile();
    if (params != null) {
      Log.d("MMVerifyCgiSignatureTest", "profile " + params.startConnectTime + " " + params.readPacketFinishedTime + " " + params.taskStartTime + " " + params.startHandshakeTime + " " + params.handshakeSuccessfulTime);
    }
    while ((paramArrayOfByte != null) && (paramArrayOfByte.BaseResponse != null))
    {
      Log.d("MMVerifyCgiSignatureTest", "response ret " + paramArrayOfByte.BaseResponse.Ret);
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(214139);
      return;
      Log.d("MMVerifyCgiSignatureTest", "profile is null");
    }
    params = new StringBuilder("response or BaseResponse is null ");
    if (paramArrayOfByte == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.e("MMVerifyCgiSignatureTest", bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.c
 * JD-Core Version:    0.7.0.1
 */