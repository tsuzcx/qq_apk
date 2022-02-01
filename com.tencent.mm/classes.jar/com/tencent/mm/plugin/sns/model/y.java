package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.ebb;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
  extends q
  implements m
{
  private long DJc;
  public i callback;
  private int dJY;
  private d rr;
  
  public y(long paramLong, String paramString)
  {
    AppMethodBeat.i(95658);
    this.DJc = 0L;
    Log.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + paramLong + " tagName " + paramString);
    this.DJc = paramLong;
    this.dJY = 3;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ebb();
    ((d.a)localObject).iLO = new ebc();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
    ((d.a)localObject).funcId = 290;
    ((d.a)localObject).iLP = 114;
    ((d.a)localObject).respCmdId = 1000000114;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ebb)this.rr.iLK.iLR;
    ((ebb)localObject).OpCode = 3;
    ((ebb)localObject).Nar = paramLong;
    ((ebb)localObject).xMo = paramString;
    AppMethodBeat.o(95658);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95659);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95659);
    return i;
  }
  
  public final int getType()
  {
    return 290;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95660);
    Log.d("MicroMsg.NetSceneSnsTagOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
    }
    params = ((ebc)((d)params).iLL.iLR).Nat;
    Log.d("MicroMsg.NetSceneSnsTagOption", params.toString());
    switch (this.dJY)
    {
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
      paramArrayOfByte = aj.faU().JL(params.Nar);
      paramArrayOfByte.field_tagId = params.Nar;
      paramArrayOfByte.field_tagName = Util.nullAs(params.xMo, "");
      paramArrayOfByte.field_count = params.oTz;
      paramArrayOfByte.gX(params.oTA);
      aj.faU().a(paramArrayOfByte);
      continue;
      Log.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL ".concat(String.valueOf(aj.faU().JM(this.DJc))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.y
 * JD-Core Version:    0.7.0.1
 */