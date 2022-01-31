package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bb.a;
import com.tencent.mm.model.bb.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class e
  extends m
  implements k
{
  f callback;
  String eiu;
  private final q ftU;
  private int ftx;
  
  public e(String paramString)
  {
    AppMethodBeat.i(26083);
    this.eiu = "";
    this.ftx = 2;
    this.ftU = new b();
    bb.a locala = (bb.a)this.ftU.getReqObj();
    locala.fmm.jJA = paramString;
    locala.fmm.xha = 1;
    ab.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", new Object[] { Integer.valueOf(1), paramString });
    AppMethodBeat.o(26083);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(26084);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(26084);
    return i;
  }
  
  public final int getType()
  {
    return 618;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26085);
    paramArrayOfByte = (bb.b)paramq.getRespObj();
    this.eiu = paramArrayOfByte.fmn.xhb;
    ab.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " mTicket: " + this.eiu);
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      ax.a(true, paramArrayOfByte.fmn.wvY, paramArrayOfByte.fmn.wvZ, paramArrayOfByte.fmn.wvX);
      this.ftx -= 1;
      if (this.ftx <= 0)
      {
        ab.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "reach redirect limit, invoke callback");
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(26085);
        return;
      }
      ab.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "redirect IDC");
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(26085);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ab.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      aw.RO().ac(new e.1(this, paramInt1));
      AppMethodBeat.o(26085);
      return;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26085);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26085);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.e
 * JD-Core Version:    0.7.0.1
 */