package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class e
  extends n
  implements k
{
  f callback;
  String fPq;
  private final q hON;
  private int hOs;
  
  public e(String paramString)
  {
    AppMethodBeat.i(29764);
    this.fPq = "";
    this.hOs = 2;
    this.hON = new b();
    bf.a locala = (bf.a)this.hON.getReqObj();
    locala.hGs.nDo = paramString;
    locala.hGs.GEW = 1;
    ad.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", new Object[] { Integer.valueOf(1), paramString });
    AppMethodBeat.o(29764);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(29765);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
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
    paramArrayOfByte = (bf.b)paramq.getRespObj();
    this.fPq = paramArrayOfByte.hGt.GEX;
    ad.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " mTicket: " + this.fPq);
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      bb.a(true, paramArrayOfByte.hGt.FEd, paramArrayOfByte.hGt.FEe, paramArrayOfByte.hGt.FEc);
      this.hOs -= 1;
      if (this.hOs <= 0)
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
      ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29763);
          new l().doScene(e.this.dispatcher(), new f()
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
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.e
 * JD-Core Version:    0.7.0.1
 */