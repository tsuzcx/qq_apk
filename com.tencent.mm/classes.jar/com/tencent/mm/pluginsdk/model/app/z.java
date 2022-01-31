package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.j.a;
import com.tencent.mm.model.au;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.og;
import com.tencent.mm.protocal.c.oh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class z
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private final b rUA;
  
  public z(b paramb, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new og();
    ((b.a)localObject).ecI = new oh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
    ((b.a)localObject).ecG = 728;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    this.rUA = paramb;
    localObject = (og)this.dmK.ecE.ecN;
    ((og)localObject).sGQ = paramString1;
    ((og)localObject).sLM = paramb.field_totalLen;
    ((og)localObject).sLN = paramString2;
    ((og)localObject).ewD = paramString3;
    ((og)localObject).sLO = paramString4;
    ((og)localObject).kWn = paramString5;
    au.Hx();
    ((og)localObject).kWm = ((String)com.tencent.mm.model.c.Dz().get(2, ""));
    ((og)localObject).sxP = a.dlm;
    y.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", new Object[] { bk.aac(((og)localObject).sGQ), ((og)localObject).sLN, ((og)localObject).ewD, ((og)localObject).sLO, Long.valueOf(((og)localObject).sLM), Integer.valueOf(((og)localObject).sxP), bk.csb() });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (oh)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      this.rUA.field_signature = paramq.ffk;
      this.rUA.field_fakeAeskey = paramq.sLQ;
      this.rUA.field_fakeSignature = paramq.sLR;
      boolean bool = ap.avh().c(this.rUA, new String[0]);
      y.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[] { bk.aac(this.rUA.field_signature), bk.aac(this.rUA.field_fakeAeskey), bk.aac(this.rUA.field_fakeSignature), Boolean.valueOf(bool) });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 728;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.z
 * JD-Core Version:    0.7.0.1
 */