package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.bn.b;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class e
  extends p
  implements m
{
  private h callback;
  String lCS;
  private final s ouH;
  private int ouk;
  
  public e(String paramString)
  {
    AppMethodBeat.i(29764);
    this.lCS = "";
    this.ouk = 2;
    this.ouH = new b();
    bn.a locala = (bn.a)this.ouH.getReqObj();
    locala.olu.UserName = paramString;
    locala.olu.aaAV = 1;
    Log.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", new Object[] { Integer.valueOf(1), paramString });
    AppMethodBeat.o(29764);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(29765);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
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
    paramArrayOfByte = (bn.b)params.getRespObj();
    this.lCS = paramArrayOfByte.olv.aaAW;
    Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " mTicket: " + this.lCS);
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      bj.a(true, paramArrayOfByte.olv.YOA, paramArrayOfByte.olv.YOB, paramArrayOfByte.olv.YOz, true, 0);
      this.ouk -= 1;
      if (this.ouk <= 0)
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
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29763);
          new o().doScene(e.a(e.this), new h()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
            {
              AppMethodBeat.i(29762);
              Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2p.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                e.b(e.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", e.this);
                AppMethodBeat.o(29762);
                return;
              }
              e.this.doScene(e.c(e.this), e.b(e.this));
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.e
 * JD-Core Version:    0.7.0.1
 */