package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.protocal.protobuf.dhs;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class x
  extends n
  implements k
{
  public f callback;
  private int dsO;
  private b rr;
  private long zyS;
  
  public x(long paramLong, String paramString)
  {
    AppMethodBeat.i(95658);
    this.zyS = 0L;
    ae.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + paramLong + " tagName " + paramString);
    this.zyS = paramLong;
    this.dsO = 3;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dhs();
    ((b.a)localObject).hQG = new dht();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
    ((b.a)localObject).funcId = 290;
    ((b.a)localObject).hQH = 114;
    ((b.a)localObject).respCmdId = 1000000114;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dhs)this.rr.hQD.hQJ;
    ((dhs)localObject).OpCode = 3;
    ((dhs)localObject).HOG = paramLong;
    ((dhs)localObject).uum = paramString;
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
    ae.d("MicroMsg.NetSceneSnsTagOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
    }
    paramq = ((dht)((b)paramq).hQE.hQJ).HOI;
    ae.d("MicroMsg.NetSceneSnsTagOption", paramq.toString());
    switch (this.dsO)
    {
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
      paramArrayOfByte = ah.dXK().AI(paramq.HOG);
      paramArrayOfByte.field_tagId = paramq.HOG;
      paramArrayOfByte.field_tagName = bu.bI(paramq.uum, "");
      paramArrayOfByte.field_count = paramq.nID;
      paramArrayOfByte.gb(paramq.nIE);
      ah.dXK().a(paramArrayOfByte);
      continue;
      ae.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL ".concat(String.valueOf(ah.dXK().AJ(this.zyS))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.x
 * JD-Core Version:    0.7.0.1
 */