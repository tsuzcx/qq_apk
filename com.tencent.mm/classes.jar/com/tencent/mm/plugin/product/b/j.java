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
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.dee;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class j
  extends q
  implements m
{
  public String AYZ;
  public LinkedList<akg> AZk;
  public LinkedList<bd> AZl;
  private i callback;
  private d rr;
  
  public j(LinkedList<dqn> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(66900);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ded();
    ((d.a)localObject).iLO = new dee();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/presubmitorder";
    ((d.a)localObject).funcId = 554;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ded)this.rr.iLK.iLR;
    ((ded)localObject).LbZ = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((ded)localObject).APg = i;
    ((ded)localObject).MJj = paramInt;
    AppMethodBeat.o(66900);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(66902);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66902);
    return i;
  }
  
  public final int getType()
  {
    return 554;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66901);
    paramArrayOfByte = (dee)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.KOt == 0))
    {
      Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + paramArrayOfByte.LXb);
      Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + paramArrayOfByte.Lca);
      this.AZk = paramArrayOfByte.MJk;
      this.AYZ = paramArrayOfByte.Lca;
      this.AZl = paramArrayOfByte.MJl;
    }
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
    Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.j
 * JD-Core Version:    0.7.0.1
 */