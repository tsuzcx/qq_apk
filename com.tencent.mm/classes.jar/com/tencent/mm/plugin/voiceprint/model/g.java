package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bm.a;
import com.tencent.mm.model.bm.b;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cvk;
import com.tencent.mm.protocal.protobuf.erw;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class g
  extends p
  implements m
{
  String UsX;
  int UsY;
  private String UsZ;
  private h callback;
  private final s ouH;
  
  public g(String paramString)
  {
    AppMethodBeat.i(29773);
    this.UsX = "";
    this.UsY = 0;
    this.UsZ = "";
    this.ouH = new a();
    bm.a locala = (bm.a)this.ouH.getReqObj();
    Log.i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(73), paramString });
    locala.ols.aaAT = 73;
    locala.ols.YOu = paramString;
    AppMethodBeat.o(29773);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(29774);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
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
    paramArrayOfByte = (bm.b)params.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29772);
          new o().doScene(g.a(g.this), new h()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
            {
              AppMethodBeat.i(29771);
              Log.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2p.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                g.b(g.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", g.this);
                AppMethodBeat.o(29771);
                return;
              }
              g.this.doScene(g.c(g.this), g.b(g.this));
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
    if (paramArrayOfByte.olt.aaAU != null)
    {
      this.UsX = new String(paramArrayOfByte.olt.aaAU.abvL.aaxD.Op);
      this.UsY = paramArrayOfByte.olt.aaAU.abth;
      Log.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", new Object[] { Integer.valueOf(this.UsY), this.UsZ, this.UsX });
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.g
 * JD-Core Version:    0.7.0.1
 */