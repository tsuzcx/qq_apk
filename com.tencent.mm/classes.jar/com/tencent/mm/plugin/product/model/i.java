package com.tencent.mm.plugin.product.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.egi;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.protocal.protobuf.etr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class i
  extends p
  implements m
{
  public String MQB;
  public LinkedList<aou> MQM;
  public LinkedList<be> MQN;
  private h callback;
  private c rr;
  
  public i(LinkedList<etr> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(66900);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new egi();
    ((c.a)localObject).otF = new egj();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/presubmitorder";
    ((c.a)localObject).funcId = 554;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (egi)c.b.b(this.rr.otB);
    ((egi)localObject).Zbf = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((egi)localObject).MFk = i;
    ((egi)localObject).ZvF = paramInt;
    AppMethodBeat.o(66900);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(66902);
    this.callback = paramh;
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
    paramArrayOfByte = (egj)c.c.b(((c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.YME == 0))
    {
      Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + paramArrayOfByte.aatP);
      Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + paramArrayOfByte.Zbg);
      this.MQM = paramArrayOfByte.ablJ;
      this.MQB = paramArrayOfByte.Zbg;
      this.MQN = paramArrayOfByte.ablK;
    }
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramArrayOfByte.YME != 0)
      {
        paramInt1 = paramArrayOfByte.YME;
        params = paramArrayOfByte.YMF;
      }
    }
    Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.i
 * JD-Core Version:    0.7.0.1
 */