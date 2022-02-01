package com.tencent.mm.plugin.wallet.wecoin.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.protocal.protobuf.fai;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.wn;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.StandardCharsets;

public final class c
  extends q
  implements m
{
  private i jQg;
  private d vgf;
  
  public c()
  {
    AppMethodBeat.i(228438);
    this.vgf = null;
    this.jQg = null;
    d.a locala = new d.a();
    locala.lBU = new fah();
    locala.lBV = new fai();
    locala.funcId = 5249;
    locala.uri = "/cgi-bin/micromsg-bin/verifysignaturetest";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.vgf = locala.bgN();
    AppMethodBeat.o(228438);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(228444);
    this.jQg = parami;
    parami = (fah)d.b.b(this.vgf.lBR);
    String str = com.tencent.mm.network.b.bsU().Zo("TestSignData");
    byte[] arrayOfByte = str.getBytes(StandardCharsets.ISO_8859_1);
    if (!TextUtils.isEmpty(str))
    {
      Log.i("MMVerifyCgiSignatureTest", "after sign data length " + str.length() + " byte length " + arrayOfByte.length);
      parami.SpW = new com.tencent.mm.cd.b(arrayOfByte);
      parami.UAl = new com.tencent.mm.cd.b("TestSignData".getBytes());
      Log.d("MMVerifyCgiSignatureTest", "zyzhang verify result ".concat(String.valueOf(com.tencent.mm.network.b.bsU().bO("TestSignData", str))));
      int i = dispatch(paramg, this.vgf, this);
      AppMethodBeat.o(228444);
      return i;
    }
    Log.e("MMVerifyCgiSignatureTest", "sign failed");
    AppMethodBeat.o(228444);
    return -1;
  }
  
  public final int getType()
  {
    return 5249;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(228448);
    Log.i("MMVerifyCgiSignatureTest", "receive response " + paramInt2 + " code " + paramInt3 + " message " + paramString + " code " + params.getRespObj().getRetCode());
    paramArrayOfByte = (fai)d.c.b(this.vgf.lBS);
    params = params.getRespObj().getProfile();
    if (params != null) {
      Log.d("MMVerifyCgiSignatureTest", "profile " + params.startConnectTime + " " + params.readPacketFinishedTime + " " + params.taskStartTime + " " + params.startHandshakeTime + " " + params.handshakeSuccessfulTime);
    }
    while ((paramArrayOfByte != null) && (paramArrayOfByte.BaseResponse != null))
    {
      Log.d("MMVerifyCgiSignatureTest", "response ret " + paramArrayOfByte.BaseResponse.CqV);
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(228448);
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