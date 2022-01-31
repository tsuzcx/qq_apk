package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.model.au;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.caz;
import com.tencent.mm.protocal.c.cba;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.UUID;

public final class c
  extends m
  implements k
{
  private String clientId;
  private com.tencent.mm.ah.b dmK;
  f dmL;
  public boolean eJS = false;
  private boolean eLB = false;
  private int eLF = 0;
  am ebj = new am(new c.1(this), true);
  String filename = null;
  public int igH;
  int qSs = 0;
  public String qSt;
  public boolean qSu;
  public String talker;
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    this.igH = paramInt;
    this.talker = paramString2;
    this.filename = paramString1;
    this.eLF = 0;
    this.clientId = UUID.randomUUID().toString();
  }
  
  private static String d(bmk parambmk)
  {
    if ((parambmk != null) && (parambmk.tFM != null)) {
      return parambmk.tFM.coM();
    }
    return null;
  }
  
  protected final int Ka()
  {
    return 20;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    int j = 0;
    this.dmL = paramf;
    int m = com.tencent.mm.a.e.bJ(this.filename);
    if (m <= 0)
    {
      y.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", new Object[] { this.filename });
      j = -1;
      return j;
    }
    int k = m - this.qSs;
    int i;
    if (k > 3960) {
      i = 3960;
    }
    for (;;)
    {
      y.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", new Object[] { Integer.valueOf(m), Integer.valueOf(this.qSs), Boolean.valueOf(this.eJS), Boolean.valueOf(this.eLB), this.filename });
      paramf = com.tencent.mm.a.e.c(this.filename, this.qSs, i);
      if (paramf != null) {
        break label254;
      }
      if (this.eLB) {
        break;
      }
      y.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.eJS), Boolean.valueOf(this.eLB) });
      return -1;
      if ((k < 3300) && (!this.eJS))
      {
        y.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", new Object[] { Integer.valueOf(k), Boolean.valueOf(this.eJS) });
        return -1;
      }
      i = k;
      if (this.eJS)
      {
        this.eLB = true;
        i = k;
      }
    }
    label254:
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new caz();
    ((b.a)localObject).ecI = new cba();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).ecG = 349;
    ((b.a)localObject).ecJ = 158;
    ((b.a)localObject).ecK = 1000000158;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (caz)this.dmK.ecE.ecN;
    au.Hx();
    ((caz)localObject).hPY = ((String)com.tencent.mm.model.c.Dz().get(2, ""));
    ((caz)localObject).ndi = new bmk().bs(paramf);
    ((caz)localObject).sDT = this.qSs;
    ((caz)localObject).tQb = this.clientId;
    if (this.eLB)
    {
      i = 1;
      ((caz)localObject).euw = i;
      ((caz)localObject).tQc = 0;
      ((caz)localObject).sxS = 0;
      ((caz)localObject).tQd = this.eLF;
      ((caz)localObject).sxP = 0;
      i = a(parame, this.dmK, this);
      j = ((caz)localObject).sDT;
      this.qSs = (((caz)localObject).ndi.tFK + j);
      if (!this.eJS) {
        break label535;
      }
    }
    label535:
    for (long l = 0L;; l = 500L)
    {
      y.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", new Object[] { this.filename, Long.valueOf(l), Integer.valueOf(i) });
      this.ebj.S(l, l);
      return i;
      i = 0;
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.filename });
    paramq = (cba)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    do
    {
      return;
      y.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", new Object[] { Integer.valueOf(paramq.euw), d(paramq.tQe) });
    } while (paramq.euw != 1);
    this.qSu = true;
    paramq = d(paramq.tQe);
    if (paramq != null) {
      this.qSt = paramq;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final void a(m.a parama)
  {
    this.dmL.onSceneEnd(3, 0, "securityCheckError", this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 349;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.c
 * JD-Core Version:    0.7.0.1
 */