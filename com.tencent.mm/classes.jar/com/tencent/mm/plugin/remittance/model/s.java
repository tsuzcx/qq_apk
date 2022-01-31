package com.tencent.mm.plugin.remittance.model;

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
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.sdk.platformtools.ab;

public final class s
  extends m
  implements k
{
  private f callback;
  private b goo;
  public qx qjx;
  
  public s(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(44764);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new qw();
    ((b.a)localObject).fsY = new qx();
    ((b.a)localObject).funcId = 1779;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.goo = ((b.a)localObject).ado();
    localObject = (qw)this.goo.fsV.fta;
    ((qw)localObject).cwk = paramString1;
    ((qw)localObject).wJc = paramString2;
    ((qw)localObject).qkt = paramString3;
    ((qw)localObject).qkn = paramString4;
    ((qw)localObject).qmt = paramLong;
    ((qw)localObject).wIJ = paramString5;
    ab.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(44764);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44765);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(44765);
    return i;
  }
  
  public final int getType()
  {
    return 1779;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(44766);
    ab.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qjx = ((qx)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.qjx.cnK), this.qjx.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(44766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.s
 * JD-Core Version:    0.7.0.1
 */