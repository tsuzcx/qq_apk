package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cvz;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class w
  extends n
  implements k
{
  public g callback;
  private int diR;
  private b rr;
  private long wFP;
  
  public w(long paramLong, String paramString)
  {
    AppMethodBeat.i(95658);
    this.wFP = 0L;
    ad.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + paramLong + " tagName " + paramString);
    this.wFP = paramLong;
    this.diR = 3;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cvz();
    ((b.a)localObject).gUV = new cwa();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
    ((b.a)localObject).funcId = 290;
    ((b.a)localObject).reqCmdId = 114;
    ((b.a)localObject).respCmdId = 1000000114;
    this.rr = ((b.a)localObject).atI();
    localObject = (cvz)this.rr.gUS.gUX;
    ((cvz)localObject).OpCode = 3;
    ((cvz)localObject).Enw = paramLong;
    ((cvz)localObject).scP = paramString;
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
    ad.d("MicroMsg.NetSceneSnsTagOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
    }
    paramq = ((cwa)((b)paramq).gUT.gUX).Eny;
    ad.d("MicroMsg.NetSceneSnsTagOption", paramq.toString());
    switch (this.diR)
    {
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
      paramArrayOfByte = af.dtA().tj(paramq.Enw);
      paramArrayOfByte.field_tagId = paramq.Enw;
      paramArrayOfByte.field_tagName = bt.by(paramq.scP, "");
      paramArrayOfByte.field_count = paramq.mAK;
      paramArrayOfByte.fz(paramq.mAL);
      af.dtA().a(paramArrayOfByte);
      continue;
      ad.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL ".concat(String.valueOf(af.dtA().tk(this.wFP))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.w
 * JD-Core Version:    0.7.0.1
 */