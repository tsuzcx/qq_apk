package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.be.a;
import com.tencent.mm.model.be.b;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class e
  extends n
  implements k
{
  g callback;
  String fsw;
  private int gVE;
  private final q gVZ;
  
  public e(String paramString)
  {
    AppMethodBeat.i(29764);
    this.fsw = "";
    this.gVE = 2;
    this.gVZ = new b();
    be.a locala = (be.a)this.gVZ.getReqObj();
    locala.gNA.mAQ = paramString;
    locala.gNA.DAc = 1;
    ad.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", new Object[] { Integer.valueOf(1), paramString });
    AppMethodBeat.o(29764);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(29765);
    this.callback = paramg;
    int i = dispatch(parame, this.gVZ, this);
    AppMethodBeat.o(29765);
    return i;
  }
  
  public final int getType()
  {
    return 618;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29766);
    paramArrayOfByte = (be.b)paramq.getRespObj();
    this.fsw = paramArrayOfByte.gNB.DAd;
    ad.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " mTicket: " + this.fsw);
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      ba.a(true, paramArrayOfByte.gNB.CGh, paramArrayOfByte.gNB.CGi, paramArrayOfByte.gNB.CGg);
      this.gVE -= 1;
      if (this.gVE <= 0)
      {
        ad.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "reach redirect limit, invoke callback");
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(29766);
        return;
      }
      ad.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "redirect IDC");
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(29766);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ad.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29763);
          new l().doScene(e.this.dispatcher(), new g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(29762);
              ad.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                e.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", e.this);
                AppMethodBeat.o(29762);
                return;
              }
              e.this.doScene(e.this.dispatcher(), e.this.callback);
              AppMethodBeat.o(29762);
            }
          });
          AppMethodBeat.o(29763);
        }
      });
      AppMethodBeat.o(29766);
      return;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29766);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29766);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.e
 * JD-Core Version:    0.7.0.1
 */