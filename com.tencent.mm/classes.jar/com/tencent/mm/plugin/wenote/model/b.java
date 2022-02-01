package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  public int EQQ;
  private String EQR;
  private akl EQS;
  private LinkedList<akl> EQT;
  public int EQU;
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public b(int paramInt1, int paramInt2, String paramString, LinkedList<akl> paramLinkedList, akl paramakl)
  {
    AppMethodBeat.i(30287);
    this.callback = null;
    this.EQQ = 1;
    this.EQR = "";
    this.EQS = null;
    this.EQT = new LinkedList();
    this.EQU = 0;
    this.EQT = paramLinkedList;
    this.EQS = paramakl;
    this.EQR = paramString;
    this.EQQ = paramInt2;
    this.EQU = paramInt1;
    paramString = new b.a();
    paramString.hQF = new akr();
    paramString.hQG = new aks();
    paramString.uri = "/cgi-bin/micromsg-bin/favsecurity ";
    paramString.funcId = 921;
    paramString.hQH = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.aDS();
    AppMethodBeat.o(30287);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(30288);
    akr localakr = (akr)this.rr.hQD.hQJ;
    localakr.gvx = this.EQQ;
    localakr.GCk = this.EQS;
    localakr.GCj = this.EQT;
    localakr.FZl = this.EQR;
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(30288);
    return i;
  }
  
  public final int getType()
  {
    return 921;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30289);
    ae.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (aks)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if (paramInt2 != 0)
    {
      ae.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", new Object[] { Integer.valueOf(paramInt2) });
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if ((paramq == null) || (paramq.getBaseResponse() == null))
    {
      ae.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if (paramq.getBaseResponse().Ret != 0)
    {
      ae.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if (paramq.GCl > 0)
    {
      ae.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    ae.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
    this.callback.onSceneEnd(paramInt2, 0, paramString, this);
    AppMethodBeat.o(30289);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.b
 * JD-Core Version:    0.7.0.1
 */