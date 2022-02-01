package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends p
  implements m
{
  public int Xzs;
  private String Xzt;
  private art Xzu;
  private LinkedList<art> Xzv;
  public int Xzw;
  private h callback;
  private final c rr;
  
  public b(int paramInt1, int paramInt2, String paramString, LinkedList<art> paramLinkedList, art paramart)
  {
    AppMethodBeat.i(30287);
    this.callback = null;
    this.Xzs = 1;
    this.Xzt = "";
    this.Xzu = null;
    this.Xzv = new LinkedList();
    this.Xzw = 0;
    this.Xzv = paramLinkedList;
    this.Xzu = paramart;
    this.Xzt = paramString;
    this.Xzs = paramInt2;
    this.Xzw = paramInt1;
    paramString = new c.a();
    paramString.otE = new arz();
    paramString.otF = new asa();
    paramString.uri = "/cgi-bin/micromsg-bin/favsecurity ";
    paramString.funcId = 921;
    paramString.otG = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.bEF();
    AppMethodBeat.o(30287);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(30288);
    arz localarz = (arz)c.b.b(this.rr.otB);
    localarz.muC = this.Xzs;
    localarz.ZBz = this.Xzu;
    localarz.ZBy = this.Xzv;
    localarz.YRE = this.Xzt;
    this.callback = paramh;
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
    params = (asa)c.c.b(((c)params).otC);
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
    if (params.getBaseResponse().Idd != 0)
    {
      Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if (params.ZBA > 0)
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.b
 * JD-Core Version:    0.7.0.1
 */