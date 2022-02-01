package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.protocal.protobuf.wk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class d
  extends n
  implements k
{
  private f callback;
  private b rr;
  private final c xGv;
  
  public d(c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(9459);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new wj();
    ((b.a)localObject).hQG = new wk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
    ((b.a)localObject).funcId = 728;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    this.xGv = paramc;
    localObject = (wj)this.rr.hQD.hQJ;
    ((wj)localObject).Ghg = paramString1;
    ((wj)localObject).FSx = paramc.field_totalLen;
    ((wj)localObject).Goe = paramString2;
    ((wj)localObject).Gof = paramString3;
    ((wj)localObject).FSy = paramString4;
    ((wj)localObject).uvG = paramString5;
    ((wj)localObject).uvF = ((String)g.ajR().ajA().get(2, ""));
    ((wj)localObject).FQT = com.tencent.mm.i.a.fKC;
    ae.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", new Object[] { bu.aSM(((wj)localObject).Ghg), ((wj)localObject).Goe, ((wj)localObject).Gof, ((wj)localObject).FSy, Long.valueOf(((wj)localObject).FSx), Integer.valueOf(((wj)localObject).FQT), bu.fpN() });
    AppMethodBeat.o(9459);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(9460);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(9460);
    return i;
  }
  
  public final String getMediaId()
  {
    if (this.xGv != null) {
      return this.xGv.field_mediaSvrId;
    }
    return "";
  }
  
  public final int getType()
  {
    return 728;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9461);
    ae.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (wk)((b)paramq).hQE.hQJ;
      this.xGv.field_signature = paramq.jfY;
      this.xGv.field_fakeAeskey = paramq.Goh;
      this.xGv.field_fakeSignature = paramq.Goi;
      boolean bool = com.tencent.mm.plugin.s.a.bJV().a(this.xGv, new String[0]);
      ae.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[] { bu.aSM(this.xGv.field_signature), bu.aSM(this.xGv.field_fakeAeskey), bu.aSM(this.xGv.field_fakeSignature), Boolean.valueOf(bool) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(9461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.d
 * JD-Core Version:    0.7.0.1
 */