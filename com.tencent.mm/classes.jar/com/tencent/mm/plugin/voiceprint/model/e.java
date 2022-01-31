package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.av;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ai;

public final class e
  extends m
  implements k
{
  f dmL;
  String dqS = "";
  private final q edR = new b();
  private int edu = 2;
  
  public e(String paramString)
  {
    az.a locala = (az.a)this.edR.Kv();
    locala.dWc.hPY = paramString;
    locala.dWc.tin = 1;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", new Object[] { Integer.valueOf(1), paramString });
  }
  
  protected final int Ka()
  {
    return 3;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (az.b)paramq.HF();
    this.dqS = paramArrayOfByte.dWd.tio;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " mTicket: " + this.dqS);
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      av.a(true, paramArrayOfByte.dWd.sBE, paramArrayOfByte.dWd.sBF, paramArrayOfByte.dWd.sBD);
      this.edu -= 1;
      if (this.edu <= 0)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "reach redirect limit, invoke callback");
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "redirect IDC");
      a(this.edc, this.dmL);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.Kv().spM.ver;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      au.DS().O(new e.1(this, paramInt1));
      return;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final void a(m.a parama) {}
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 618;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.e
 * JD-Core Version:    0.7.0.1
 */