package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class w
  extends n
  implements k
{
  public f callback;
  private int drI;
  private b rr;
  private long zid;
  
  public w(long paramLong, String paramString)
  {
    AppMethodBeat.i(95658);
    this.zid = 0L;
    ad.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + paramLong + " tagName " + paramString);
    this.zid = paramLong;
    this.drI = 3;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dgy();
    ((b.a)localObject).hNN = new dgz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
    ((b.a)localObject).funcId = 290;
    ((b.a)localObject).hNO = 114;
    ((b.a)localObject).respCmdId = 1000000114;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dgy)this.rr.hNK.hNQ;
    ((dgy)localObject).OpCode = 3;
    ((dgy)localObject).Hvd = paramLong;
    ((dgy)localObject).uiP = paramString;
    AppMethodBeat.o(95658);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(95659);
    this.callback = paramf;
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
    ad.d("MicroMsg.NetSceneSnsTagOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
    }
    paramq = ((dgz)((b)paramq).hNL.hNQ).Hvf;
    ad.d("MicroMsg.NetSceneSnsTagOption", paramq.toString());
    switch (this.drI)
    {
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
      paramArrayOfByte = ag.dUk().Ak(paramq.Hvd);
      paramArrayOfByte.field_tagId = paramq.Hvd;
      paramArrayOfByte.field_tagName = bt.bI(paramq.uiP, "");
      paramArrayOfByte.field_count = paramq.nDi;
      paramArrayOfByte.fS(paramq.nDj);
      ag.dUk().a(paramArrayOfByte);
      continue;
      ad.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL ".concat(String.valueOf(ag.dUk().Al(this.zid))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.w
 * JD-Core Version:    0.7.0.1
 */