package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.edm;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private final d rr;
  
  public m(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 0);
  }
  
  public m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(73780);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new edm();
    ((d.a)localObject).lBV = new edn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sendfeedback";
    ((d.a)localObject).funcId = 153;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (edm)d.b.b(this.rr.lBR);
    ((edm)localObject).UhQ = paramString1;
    ((edm)localObject).lpy = paramString2;
    ((edm)localObject).TwH = paramInt;
    AppMethodBeat.o(73780);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(73781);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(73781);
    return i;
  }
  
  public final int getType()
  {
    return 153;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73782);
    Log.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + paramInt2 + " code:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.m
 * JD-Core Version:    0.7.0.1
 */