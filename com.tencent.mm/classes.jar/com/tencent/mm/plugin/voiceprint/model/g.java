package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.model.bk.b;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxn;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class g
  extends q
  implements com.tencent.mm.network.m
{
  String GQM;
  int GQN;
  private String GQO;
  i callback;
  private final s iMO;
  
  public g(String paramString)
  {
    AppMethodBeat.i(29773);
    this.GQM = "";
    this.GQN = 0;
    this.GQO = "";
    this.iMO = new a();
    bk.a locala = (bk.a)this.iMO.getReqObj();
    Log.i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(73), paramString });
    locala.iDS.Mdl = 73;
    locala.iDS.Mdm = paramString;
    AppMethodBeat.o(29773);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(29774);
    this.callback = parami;
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(29774);
    return i;
  }
  
  public final int getType()
  {
    return 616;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29775);
    Log.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bk.b)params.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29772);
          new com.tencent.mm.modelsimple.m().doScene(g.this.dispatcher(), new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(29771);
              Log.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                g.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", g.this);
                AppMethodBeat.o(29771);
                return;
              }
              g.this.doScene(g.this.dispatcher(), g.this.callback);
              AppMethodBeat.o(29771);
            }
          });
          AppMethodBeat.o(29772);
        }
      });
      AppMethodBeat.o(29775);
      return;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29775);
      return;
    }
    if (paramArrayOfByte.iDT.Mdn != null)
    {
      this.GQM = new String(paramArrayOfByte.iDT.Mdn.MSr.getBufferToBytes());
      this.GQN = paramArrayOfByte.iDT.Mdn.MPS;
      Log.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", new Object[] { Integer.valueOf(this.GQN), this.GQO, this.GQM });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29775);
      return;
      Log.e("MicroMsg.NetSceneRsaGetVoicePrintResource", "resp ResourceData null ");
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.g
 * JD-Core Version:    0.7.0.1
 */