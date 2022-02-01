package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends q
  implements m
{
  public int JGC;
  private String JGD;
  private amz JGE;
  private LinkedList<amz> JGF;
  public int JGG;
  private i callback;
  private final d rr;
  
  public b(int paramInt1, int paramInt2, String paramString, LinkedList<amz> paramLinkedList, amz paramamz)
  {
    AppMethodBeat.i(30287);
    this.callback = null;
    this.JGC = 1;
    this.JGD = "";
    this.JGE = null;
    this.JGF = new LinkedList();
    this.JGG = 0;
    this.JGF = paramLinkedList;
    this.JGE = paramamz;
    this.JGD = paramString;
    this.JGC = paramInt2;
    this.JGG = paramInt1;
    paramString = new d.a();
    paramString.iLN = new anf();
    paramString.iLO = new ang();
    paramString.uri = "/cgi-bin/micromsg-bin/favsecurity ";
    paramString.funcId = 921;
    paramString.iLP = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.aXF();
    AppMethodBeat.o(30287);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30288);
    anf localanf = (anf)this.rr.iLK.iLR;
    localanf.him = this.JGC;
    localanf.Lyg = this.JGE;
    localanf.Lyf = this.JGF;
    localanf.KTg = this.JGD;
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
    params = (ang)((d)params).iLL.iLR;
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
    if (params.getBaseResponse().Ret != 0)
    {
      Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if (params.Lyh > 0)
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
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.b
 * JD-Core Version:    0.7.0.1
 */