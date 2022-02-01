package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  public int BCr;
  private String BCs;
  private agm BCt;
  private LinkedList<agm> BCu;
  public int BCv;
  private g callback;
  private final com.tencent.mm.al.b rr;
  
  public b(int paramInt1, int paramInt2, String paramString, LinkedList<agm> paramLinkedList, agm paramagm)
  {
    AppMethodBeat.i(30287);
    this.callback = null;
    this.BCr = 1;
    this.BCs = "";
    this.BCt = null;
    this.BCu = new LinkedList();
    this.BCv = 0;
    this.BCu = paramLinkedList;
    this.BCt = paramagm;
    this.BCs = paramString;
    this.BCr = paramInt2;
    this.BCv = paramInt1;
    paramString = new b.a();
    paramString.gUU = new ags();
    paramString.gUV = new agt();
    paramString.uri = "/cgi-bin/micromsg-bin/favsecurity ";
    paramString.funcId = 921;
    paramString.reqCmdId = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.atI();
    AppMethodBeat.o(30287);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(30288);
    ags localags = (ags)this.rr.gUS.gUX;
    localags.fVE = this.BCr;
    localags.DiJ = this.BCt;
    localags.DiI = this.BCu;
    localags.CIE = this.BCs;
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
    ad.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (agt)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if (paramInt2 != 0)
    {
      ad.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", new Object[] { Integer.valueOf(paramInt2) });
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if ((paramq == null) || (paramq.getBaseResponse() == null))
    {
      ad.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if (paramq.getBaseResponse().Ret != 0)
    {
      ad.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    if (paramq.DiK > 0)
    {
      ad.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(30289);
      return;
    }
    ad.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
    this.callback.onSceneEnd(paramInt2, 0, paramString, this);
    AppMethodBeat.o(30289);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.b
 * JD-Core Version:    0.7.0.1
 */