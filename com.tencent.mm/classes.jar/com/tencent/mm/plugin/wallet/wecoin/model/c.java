package com.tencent.mm.plugin.wallet.wecoin.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.fwl;
import com.tencent.mm.protocal.protobuf.fwm;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.StandardCharsets;

public final class c
  extends p
  implements m
{
  private h mAY;
  private com.tencent.mm.am.c ysd;
  
  public c()
  {
    AppMethodBeat.i(315777);
    this.ysd = null;
    this.mAY = null;
    c.a locala = new c.a();
    locala.otE = new fwl();
    locala.otF = new fwm();
    locala.funcId = 5249;
    locala.uri = "/cgi-bin/micromsg-bin/verifysignaturetest";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.ysd = locala.bEF();
    AppMethodBeat.o(315777);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(315789);
    this.mAY = paramh;
    paramh = (fwl)c.b.b(this.ysd.otB);
    String str = com.tencent.mm.network.b.bQD().Rs("TestSignData");
    byte[] arrayOfByte = str.getBytes(StandardCharsets.ISO_8859_1);
    if (!TextUtils.isEmpty(str))
    {
      Log.i("MMVerifyCgiSignatureTest", "after sign data length " + str.length() + " byte length " + arrayOfByte.length);
      paramh.ZoS = new com.tencent.mm.bx.b(arrayOfByte);
      paramh.abUn = new com.tencent.mm.bx.b("TestSignData".getBytes());
      Log.d("MMVerifyCgiSignatureTest", "zyzhang verify result ".concat(String.valueOf(com.tencent.mm.network.b.bQD().bZ("TestSignData", str))));
      int i = dispatch(paramg, this.ysd, this);
      AppMethodBeat.o(315789);
      return i;
    }
    Log.e("MMVerifyCgiSignatureTest", "sign failed");
    AppMethodBeat.o(315789);
    return -1;
  }
  
  public final int getType()
  {
    return 5249;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(315799);
    Log.i("MMVerifyCgiSignatureTest", "receive response " + paramInt2 + " code " + paramInt3 + " message " + paramString + " code " + params.getRespObj().getRetCode());
    paramArrayOfByte = (fwm)c.c.b(this.ysd.otC);
    params = params.getRespObj().getProfile();
    if (params != null) {
      Log.d("MMVerifyCgiSignatureTest", "profile " + params.startConnectTime + " " + params.readPacketFinishedTime + " " + params.taskStartTime + " " + params.startHandshakeTime + " " + params.handshakeSuccessfulTime);
    }
    while ((paramArrayOfByte != null) && (paramArrayOfByte.BaseResponse != null))
    {
      Log.d("MMVerifyCgiSignatureTest", "response ret " + paramArrayOfByte.BaseResponse.Idd);
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(315799);
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