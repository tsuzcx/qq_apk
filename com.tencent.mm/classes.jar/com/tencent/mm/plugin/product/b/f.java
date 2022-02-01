package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public f(LinkedList<dqn> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(66888);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new tl();
    ((d.a)localObject).iLO = new tm();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/cancelpreorder";
    ((d.a)localObject).funcId = 555;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (tl)this.rr.iLK.iLR;
    ((tl)localObject).LbZ = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((tl)localObject).APg = i;
    ((tl)localObject).Lca = paramString;
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
    paramArrayOfByte = (tm)((d)params).iLL.iLR;
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramArrayOfByte.KOt != 0)
      {
        paramInt1 = paramArrayOfByte.KOt;
        params = paramArrayOfByte.KOu;
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