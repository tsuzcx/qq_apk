package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.aog;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends q
  implements m
{
  public int QFU;
  private String QFV;
  private aoa QFW;
  private LinkedList<aoa> QFX;
  public int QFY;
  private i callback;
  private final d rr;
  
  public b(int paramInt1, int paramInt2, String paramString, LinkedList<aoa> paramLinkedList, aoa paramaoa)
  {
    AppMethodBeat.i(30287);
    this.callback = null;
    this.QFU = 1;
    this.QFV = "";
    this.QFW = null;
    this.QFX = new LinkedList();
    this.QFY = 0;
    this.QFX = paramLinkedList;
    this.QFW = paramaoa;
    this.QFV = paramString;
    this.QFU = paramInt2;
    this.QFY = paramInt1;
    paramString = new d.a();
    paramString.lBU = new aog();
    paramString.lBV = new aoh();
    paramString.uri = "/cgi-bin/micromsg-bin/favsecurity ";
    paramString.funcId = 921;
    paramString.lBW = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.bgN();
    AppMethodBeat.o(30287);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30288);
    aog localaog = (aog)d.b.b(this.rr.lBR);
    localaog.jUk = this.QFU;
    localaog.SAH = this.QFW;
    localaog.SAG = this.QFX;
    localaog.RUd = this.QFV;
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(30288);
    return i;
  }
  
  public final int getType()
  {
    return 921;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30289);
    Log.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (aoh)d.c.b(((d)params).lBS);
    if (paramInt2 != 0)
    {
      Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", new Object[] { Integer.valueOf(paramInt2) });
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if ((params == null) || (params.getBaseResponse() == null))
    {
      Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if (params.getBaseResponse().CqV != 0)
    {
      Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if (params.SAI > 0)
    {
      Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
    this.callback.onSceneEnd(paramInt2, 0, paramString, this);
    AppMethodBeat.o(30289);
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.b
 * JD-Core Version:    0.7.0.1
 */