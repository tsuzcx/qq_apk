package com.tencent.mm.plugin.sns.model;

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
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.protocal.protobuf.ffe;
import com.tencent.mm.protocal.protobuf.ffj;
import com.tencent.mm.protocal.protobuf.ffk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
  extends p
  implements m
{
  private long Qtd;
  public h callback;
  private int hHC;
  private c rr;
  
  public y(long paramLong, String paramString)
  {
    AppMethodBeat.i(95658);
    this.Qtd = 0L;
    Log.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + paramLong + " tagName " + paramString);
    this.Qtd = paramLong;
    this.hHC = 3;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ffj();
    ((c.a)localObject).otF = new ffk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
    ((c.a)localObject).funcId = 290;
    ((c.a)localObject).otG = 114;
    ((c.a)localObject).respCmdId = 1000000114;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ffj)c.b.b(this.rr.otB);
    ((ffj)localObject).YIq = 3;
    ((ffj)localObject).abES = paramLong;
    ((ffj)localObject).IKH = paramString;
    AppMethodBeat.o(95658);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(95659);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95659);
    return i;
  }
  
  public final int getType()
  {
    return 290;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95660);
    Log.d("MicroMsg.NetSceneSnsTagOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
    }
    ffe localffe = ((ffk)c.c.b(((c)params).otC)).abEU;
    Log.d("MicroMsg.NetSceneSnsTagOption", localffe.toString());
    switch (this.hHC)
    {
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95660);
      return;
      paramArrayOfByte = al.hgI().vl(localffe.abES);
      params = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        params = new ac();
      }
      params.field_tagId = localffe.abES;
      params.field_tagName = Util.nullAs(localffe.IKH, "");
      params.field_count = localffe.vgN;
      params.kG(localffe.vgO);
      al.hgI().a(params);
      continue;
      Log.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL ".concat(String.valueOf(al.hgI().vm(this.Qtd))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.y
 * JD-Core Version:    0.7.0.1
 */