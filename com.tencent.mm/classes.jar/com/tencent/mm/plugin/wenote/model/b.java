package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.ahr;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private LinkedList<ahl> CUA;
  public int CUB;
  public int CUx;
  private String CUy;
  private ahl CUz;
  private g callback;
  private final com.tencent.mm.ak.b rr;
  
  public b(int paramInt1, int paramInt2, String paramString, LinkedList<ahl> paramLinkedList, ahl paramahl)
  {
    AppMethodBeat.i(30287);
    this.callback = null;
    this.CUx = 1;
    this.CUy = "";
    this.CUz = null;
    this.CUA = new LinkedList();
    this.CUB = 0;
    this.CUA = paramLinkedList;
    this.CUz = paramahl;
    this.CUy = paramString;
    this.CUx = paramInt2;
    this.CUB = paramInt1;
    paramString = new b.a();
    paramString.hvt = new ahr();
    paramString.hvu = new ahs();
    paramString.uri = "/cgi-bin/micromsg-bin/favsecurity ";
    paramString.funcId = 921;
    paramString.reqCmdId = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.aAz();
    AppMethodBeat.o(30287);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(30288);
    ahr localahr = (ahr)this.rr.hvr.hvw;
    localahr.fZz = this.CUx;
    localahr.EBP = this.CUz;
    localahr.EBO = this.CUA;
    localahr.Ebg = this.CUy;
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (ahs)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if (paramInt2 != 0)
    {
      ac.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", new Object[] { Integer.valueOf(paramInt2) });
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if ((paramq == null) || (paramq.getBaseResponse() == null))
    {
      ac.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if (paramq.getBaseResponse().Ret != 0)
    {
      ac.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if (paramq.EBQ > 0)
    {
      ac.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    ac.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
    this.callback.onSceneEnd(paramInt2, 0, paramString, this);
    AppMethodBeat.o(30289);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.b
 * JD-Core Version:    0.7.0.1
 */