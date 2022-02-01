package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class e
  extends q
  implements com.tencent.mm.network.m
{
  i callback;
  String gwF;
  private final s iMO;
  private int iMt;
  
  public e(String paramString)
  {
    AppMethodBeat.i(29764);
    this.gwF = "";
    this.iMt = 2;
    this.iMO = new b();
    bl.a locala = (bl.a)this.iMO.getReqObj();
    locala.iDU.UserName = paramString;
    locala.iDU.Mdo = 1;
    Log.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", new Object[] { Integer.valueOf(1), paramString });
    AppMethodBeat.o(29764);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29765);
    this.callback = parami;
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(29765);
    return i;
  }
  
  public final int getType()
  {
    return 618;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29766);
    paramArrayOfByte = (bl.b)params.getRespObj();
    this.gwF = paramArrayOfByte.iDV.Mdp;
    Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " mTicket: " + this.gwF);
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      bh.a(true, paramArrayOfByte.iDV.KQk, paramArrayOfByte.iDV.KQl, paramArrayOfByte.iDV.KQj);
      this.iMt -= 1;
      if (this.iMt <= 0)
      {
        Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "reach redirect limit, invoke callback");
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(29766);
        return;
      }
      Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "redirect IDC");
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(29766);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29763);
          new com.tencent.mm.modelsimple.m().doScene(e.this.dispatcher(), new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(29762);
              Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.e
 * JD-Core Version:    0.7.0.1
 */