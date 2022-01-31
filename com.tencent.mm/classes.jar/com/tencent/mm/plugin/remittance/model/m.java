package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.pr;
import com.tencent.mm.protocal.protobuf.ps;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;
import java.net.URLDecoder;

public final class m
  extends p
{
  private final String TAG;
  public ps qjp;
  
  public m(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(44750);
    this.TAG = "MicroMsg.NetSceneF2fDynamicCode";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new pr();
    ((b.a)localObject).fsY = new ps();
    ((b.a)localObject).funcId = 2736;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (pr)this.rr.fsV.fta;
    ((pr)localObject).okH = paramInt;
    ((pr)localObject).kqi = paramString1;
    ((pr)localObject).qkn = paramString2;
    ((pr)localObject).wHX = URLDecoder.decode(paramString3);
    ((pr)localObject).qjV = paramString4;
    ((pr)localObject).qjW = paramString5;
    ((pr)localObject).qkq = paramString6;
    ((pr)localObject).nickname = paramString7;
    ((pr)localObject).qjK = paramString8;
    ab.i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", new Object[] { Integer.valueOf(paramInt), paramString1, URLDecoder.decode(paramString3) });
    AppMethodBeat.o(44750);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44751);
    ab.i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qjp = ((ps)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qjp.cnK), this.qjp.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44751);
  }
  
  public final void e(q paramq)
  {
    paramq = (ps)((b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 2736;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.m
 * JD-Core Version:    0.7.0.1
 */