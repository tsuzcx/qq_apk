package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class c
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private b rr;
  private final com.tencent.mm.pluginsdk.model.app.c uZZ;
  
  public c(com.tencent.mm.pluginsdk.model.app.c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(9459);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new tx();
    ((b.a)localObject).gUV = new ty();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
    ((b.a)localObject).funcId = 728;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    this.uZZ = paramc;
    localObject = (tx)this.rr.gUS.gUX;
    ((tx)localObject).COP = paramString1;
    ((tx)localObject).CCh = paramc.field_totalLen;
    ((tx)localObject).CVJ = paramString2;
    ((tx)localObject).CVK = paramString3;
    ((tx)localObject).CCi = paramString4;
    ((tx)localObject).sdQ = paramString5;
    ((tx)localObject).sdP = ((String)com.tencent.mm.kernel.g.afB().afk().get(2, ""));
    ((tx)localObject).CAG = com.tencent.mm.i.a.fmX;
    ad.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", new Object[] { bt.aGs(((tx)localObject).COP), ((tx)localObject).CVJ, ((tx)localObject).CVK, ((tx)localObject).CCi, Long.valueOf(((tx)localObject).CCh), Integer.valueOf(((tx)localObject).CAG), bt.eGN() });
    AppMethodBeat.o(9459);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(9460);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(9460);
    return i;
  }
  
  public final String getMediaId()
  {
    if (this.uZZ != null) {
      return this.uZZ.field_mediaSvrId;
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
    ad.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ty)((b)paramq).gUT.gUX;
      this.uZZ.field_signature = paramq.ijP;
      this.uZZ.field_fakeAeskey = paramq.CVM;
      this.uZZ.field_fakeSignature = paramq.CVN;
      boolean bool = com.tencent.mm.plugin.s.a.bxS().a(this.uZZ, new String[0]);
      ad.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[] { bt.aGs(this.uZZ.field_signature), bt.aGs(this.uZZ.field_fakeAeskey), bt.aGs(this.uZZ.field_fakeSignature), Boolean.valueOf(bool) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(9461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.c
 * JD-Core Version:    0.7.0.1
 */