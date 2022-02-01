package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.protobuf.ekw;
import com.tencent.mm.protocal.protobuf.elb;
import com.tencent.mm.protocal.protobuf.elc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
  extends q
  implements m
{
  private long JWc;
  public i callback;
  private int fCN;
  private d rr;
  
  public y(long paramLong, String paramString)
  {
    AppMethodBeat.i(95658);
    this.JWc = 0L;
    Log.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + paramLong + " tagName " + paramString);
    this.JWc = paramLong;
    this.fCN = 3;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new elb();
    ((d.a)localObject).lBV = new elc();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
    ((d.a)localObject).funcId = 290;
    ((d.a)localObject).lBW = 114;
    ((d.a)localObject).respCmdId = 1000000114;
    this.rr = ((d.a)localObject).bgN();
    localObject = (elb)d.b.b(this.rr.lBR);
    ((elb)localObject).RLe = 3;
    ((elb)localObject).UmL = paramLong;
    ((elb)localObject).CQx = paramString;
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
    params = ((elc)d.c.b(((d)params).lBS)).UmN;
    Log.d("MicroMsg.NetSceneSnsTagOption", params.toString());
    switch (this.fCN)
    {
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
      paramArrayOfByte = aj.fOO().Rf(params.UmL);
      paramArrayOfByte.field_tagId = params.UmL;
      paramArrayOfByte.field_tagName = Util.nullAs(params.CQx, "");
      paramArrayOfByte.field_count = params.rVx;
      paramArrayOfByte.hF(params.rVy);
      aj.fOO().a(paramArrayOfByte);
      continue;
      Log.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL ".concat(String.valueOf(aj.fOO().Rg(this.JWc))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.y
 * JD-Core Version:    0.7.0.1
 */