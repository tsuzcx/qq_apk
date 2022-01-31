package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  public int vvI;
  private String vvJ;
  private aco vvK;
  private LinkedList<aco> vvL;
  public int vvM;
  
  public b(int paramInt1, int paramInt2, String paramString, LinkedList<aco> paramLinkedList, aco paramaco)
  {
    AppMethodBeat.i(26595);
    this.callback = null;
    this.vvI = 1;
    this.vvJ = "";
    this.vvK = null;
    this.vvL = new LinkedList();
    this.vvM = 0;
    this.vvL = paramLinkedList;
    this.vvK = paramaco;
    this.vvJ = paramString;
    this.vvI = paramInt2;
    this.vvM = paramInt1;
    paramString = new b.a();
    paramString.fsX = new acu();
    paramString.fsY = new acv();
    paramString.uri = "/cgi-bin/micromsg-bin/favsecurity ";
    paramString.funcId = 921;
    paramString.reqCmdId = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.ado();
    AppMethodBeat.o(26595);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26596);
    acu localacu = (acu)this.rr.fsV.fta;
    localacu.nrS = this.vvI;
    localacu.wVh = this.vvK;
    localacu.wVg = this.vvL;
    localacu.wxW = this.vvJ;
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26596);
    return i;
  }
  
  public final int getType()
  {
    return 921;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26597);
    ab.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (acv)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (paramInt2 != 0)
    {
      ab.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", new Object[] { Integer.valueOf(paramInt2) });
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(26597);
      return;
    }
    if ((paramq == null) || (paramq.getBaseResponse() == null))
    {
      ab.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(26597);
      return;
    }
    if (paramq.getBaseResponse().Ret != 0)
    {
      ab.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
      this.callback.onSceneEnd(paramInt2, 0, paramString, this);
      AppMethodBeat.o(26597);
      return;
    }
    if (paramq.wVi > 0)
    {
      ab.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(26597);
      return;
    }
    ab.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
    this.callback.onSceneEnd(paramInt2, 0, paramString, this);
    AppMethodBeat.o(26597);
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.b
 * JD-Core Version:    0.7.0.1
 */