package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eak;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public f(LinkedList<eak> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(66888);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new tn();
    ((d.a)localObject).lBV = new to();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/cancelpreorder";
    ((d.a)localObject).funcId = 555;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (tn)d.b.b(this.rr.lBR);
    ((tn)localObject).Sdm = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((tn)localObject).GIu = i;
    ((tn)localObject).Sdn = paramString;
    Log.d("MicroMsg.NetSceneMallCancelPreOrder", "lockId ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(66888);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(66890);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66890);
    return i;
  }
  
  public final int getType()
  {
    return 555;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66889);
    paramArrayOfByte = (to)d.c.b(((d)params).lBS);
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramArrayOfByte.RPr != 0)
      {
        paramInt1 = paramArrayOfByte.RPr;
        params = paramArrayOfByte.RPs;
      }
    }
    Log.d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.f
 * JD-Core Version:    0.7.0.1
 */