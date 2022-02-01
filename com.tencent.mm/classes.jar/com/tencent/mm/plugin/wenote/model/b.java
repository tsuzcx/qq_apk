package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.aki;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  public int Eyu;
  private String Eyv;
  private akb Eyw;
  private LinkedList<akb> Eyx;
  public int Eyy;
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public b(int paramInt1, int paramInt2, String paramString, LinkedList<akb> paramLinkedList, akb paramakb)
  {
    AppMethodBeat.i(30287);
    this.callback = null;
    this.Eyu = 1;
    this.Eyv = "";
    this.Eyw = null;
    this.Eyx = new LinkedList();
    this.Eyy = 0;
    this.Eyx = paramLinkedList;
    this.Eyw = paramakb;
    this.Eyv = paramString;
    this.Eyu = paramInt2;
    this.Eyy = paramInt1;
    paramString = new b.a();
    paramString.hNM = new akh();
    paramString.hNN = new aki();
    paramString.uri = "/cgi-bin/micromsg-bin/favsecurity ";
    paramString.funcId = 921;
    paramString.hNO = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.aDC();
    AppMethodBeat.o(30287);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(30288);
    akh localakh = (akh)this.rr.hNK.hNQ;
    localakh.gsV = this.Eyu;
    localakh.GjB = this.Eyw;
    localakh.GjA = this.Eyx;
    localakh.FGP = this.Eyv;
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
    ad.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (aki)((com.tencent.mm.al.b)paramq).hNL.hNQ;
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
    if (paramq.GjC > 0)
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
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.b
 * JD-Core Version:    0.7.0.1
 */