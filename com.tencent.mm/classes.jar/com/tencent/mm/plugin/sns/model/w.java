package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class w
  extends n
  implements k
{
  public g callback;
  private int dgm;
  private b rr;
  private long xSj;
  
  public w(long paramLong, String paramString)
  {
    AppMethodBeat.i(95658);
    this.xSj = 0L;
    ac.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + paramLong + " tagName " + paramString);
    this.xSj = paramLong;
    this.dgm = 3;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dbl();
    ((b.a)localObject).hvu = new dbm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
    ((b.a)localObject).funcId = 290;
    ((b.a)localObject).reqCmdId = 114;
    ((b.a)localObject).respCmdId = 1000000114;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dbl)this.rr.hvr.hvw;
    ((dbl)localObject).OpCode = 3;
    ((dbl)localObject).FKv = paramLong;
    ((dbl)localObject).tkJ = paramString;
    AppMethodBeat.o(95658);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(95659);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95659);
    return i;
  }
  
  public final int getType()
  {
    return 290;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95660);
    ac.d("MicroMsg.NetSceneSnsTagOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
    }
    paramq = ((dbm)((b)paramq).hvs.hvw).FKx;
    ac.d("MicroMsg.NetSceneSnsTagOption", paramq.toString());
    switch (this.dgm)
    {
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
      paramArrayOfByte = af.dHX().xM(paramq.FKv);
      paramArrayOfByte.field_tagId = paramq.FKv;
      paramArrayOfByte.field_tagName = bs.bG(paramq.tkJ, "");
      paramArrayOfByte.field_count = paramq.ncL;
      paramArrayOfByte.fH(paramq.ncM);
      af.dHX().a(paramArrayOfByte);
      continue;
      ac.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL ".concat(String.valueOf(af.dHX().xN(this.xSj))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.w
 * JD-Core Version:    0.7.0.1
 */