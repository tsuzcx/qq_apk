package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.protocal.protobuf.cfc;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class x
  extends m
  implements k
{
  public f callback;
  private int ctW;
  private long rfr;
  private b rr;
  
  public x(long paramLong, String paramString)
  {
    AppMethodBeat.i(36333);
    this.rfr = 0L;
    ab.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + paramLong + " tagName " + paramString);
    this.rfr = paramLong;
    this.ctW = 3;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cfc();
    ((b.a)localObject).fsY = new cfd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
    ((b.a)localObject).funcId = 290;
    ((b.a)localObject).reqCmdId = 114;
    ((b.a)localObject).respCmdId = 1000000114;
    this.rr = ((b.a)localObject).ado();
    localObject = (cfc)this.rr.fsV.fta;
    ((cfc)localObject).OpCode = 3;
    ((cfc)localObject).xPq = paramLong;
    ((cfc)localObject).ntn = paramString;
    AppMethodBeat.o(36333);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(36334);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36334);
    return i;
  }
  
  public final int getType()
  {
    return 290;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36335);
    ab.d("MicroMsg.NetSceneSnsTagOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36335);
      return;
    }
    paramq = ((cfd)((b)paramq).fsW.fta).xPs;
    ab.d("MicroMsg.NetSceneSnsTagOption", paramq.toString());
    switch (this.ctW)
    {
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36335);
      return;
      paramArrayOfByte = ag.cpl().mb(paramq.xPq);
      paramArrayOfByte.field_tagId = paramq.xPq;
      paramArrayOfByte.field_tagName = bo.bf(paramq.ntn, "");
      paramArrayOfByte.field_count = paramq.jJu;
      paramArrayOfByte.dj(paramq.jJv);
      ag.cpl().a(paramArrayOfByte);
      continue;
      ab.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL ".concat(String.valueOf(ag.cpl().mc(this.rfr))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.x
 * JD-Core Version:    0.7.0.1
 */