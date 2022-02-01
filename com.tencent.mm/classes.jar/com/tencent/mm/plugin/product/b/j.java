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
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.dnt;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.eak;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class j
  extends q
  implements m
{
  public String GSX;
  public LinkedList<alj> GTi;
  public LinkedList<bb> GTj;
  private i callback;
  private d rr;
  
  public j(LinkedList<eak> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(66900);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dnt();
    ((d.a)localObject).lBV = new dnu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/presubmitorder";
    ((d.a)localObject).funcId = 554;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dnt)d.b.b(this.rr.lBR);
    ((dnt)localObject).Sdm = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((dnt)localObject).GIu = i;
    ((dnt)localObject).TUY = paramInt;
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
    paramArrayOfByte = (dnu)d.c.b(((d)params).lBS);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.RPr == 0))
    {
      Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + paramArrayOfByte.Tgz);
      Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + paramArrayOfByte.Sdn);
      this.GTi = paramArrayOfByte.TUZ;
      this.GSX = paramArrayOfByte.Sdn;
      this.GTj = paramArrayOfByte.TVa;
    }
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
    Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.j
 * JD-Core Version:    0.7.0.1
 */