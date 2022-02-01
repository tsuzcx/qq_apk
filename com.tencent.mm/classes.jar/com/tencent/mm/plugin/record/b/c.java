package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class c
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private b rr;
  private final com.tencent.mm.pluginsdk.model.app.c wiN;
  
  public c(com.tencent.mm.pluginsdk.model.app.c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(9459);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new uh();
    ((b.a)localObject).hvu = new ui();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
    ((b.a)localObject).funcId = 728;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    this.wiN = paramc;
    localObject = (uh)this.rr.hvr.hvw;
    ((uh)localObject).EhA = paramString1;
    ((uh)localObject).DUE = paramc.field_totalLen;
    ((uh)localObject).Eot = paramString2;
    ((uh)localObject).Eou = paramString3;
    ((uh)localObject).DUF = paramString4;
    ((uh)localObject).tlK = paramString5;
    ((uh)localObject).tlJ = ((String)com.tencent.mm.kernel.g.agR().agA().get(2, ""));
    ((uh)localObject).DTc = com.tencent.mm.i.a.fqr;
    ac.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", new Object[] { bs.aLJ(((uh)localObject).EhA), ((uh)localObject).Eot, ((uh)localObject).Eou, ((uh)localObject).DUF, Long.valueOf(((uh)localObject).DUE), Integer.valueOf(((uh)localObject).DTc), bs.eWi() });
    AppMethodBeat.o(9459);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(9460);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(9460);
    return i;
  }
  
  public final String getMediaId()
  {
    if (this.wiN != null) {
      return this.wiN.field_mediaSvrId;
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
    ac.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ui)((b)paramq).hvs.hvw;
      this.wiN.field_signature = paramq.iJW;
      this.wiN.field_fakeAeskey = paramq.Eow;
      this.wiN.field_fakeSignature = paramq.Eox;
      boolean bool = com.tencent.mm.plugin.s.a.bEO().a(this.wiN, new String[0]);
      ac.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[] { bs.aLJ(this.wiN.field_signature), bs.aLJ(this.wiN.field_fakeAeskey), bs.aLJ(this.wiN.field_fakeSignature), Boolean.valueOf(bool) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(9461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.c
 * JD-Core Version:    0.7.0.1
 */