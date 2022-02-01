package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class d
  extends n
  implements k
{
  private f callback;
  private b rr;
  private final c xqy;
  
  public d(c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(9459);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new wg();
    ((b.a)localObject).hNN = new wh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
    ((b.a)localObject).funcId = 728;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    this.xqy = paramc;
    localObject = (wg)this.rr.hNK.hNQ;
    ((wg)localObject).FOH = paramString1;
    ((wg)localObject).FzZ = paramc.field_totalLen;
    ((wg)localObject).FVF = paramString2;
    ((wg)localObject).FVG = paramString3;
    ((wg)localObject).FAa = paramString4;
    ((wg)localObject).ukj = paramString5;
    ((wg)localObject).uki = ((String)g.ajC().ajl().get(2, ""));
    ((wg)localObject).Fyv = com.tencent.mm.i.a.fIy;
    ad.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", new Object[] { bt.aRp(((wg)localObject).FOH), ((wg)localObject).FVF, ((wg)localObject).FVG, ((wg)localObject).FAa, Long.valueOf(((wg)localObject).FzZ), Integer.valueOf(((wg)localObject).Fyv), bt.flS() });
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
    if (this.xqy != null) {
      return this.xqy.field_mediaSvrId;
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
      paramq = (wh)((b)paramq).hNL.hNQ;
      this.xqy.field_signature = paramq.jdf;
      this.xqy.field_fakeAeskey = paramq.FVI;
      this.xqy.field_fakeSignature = paramq.FVJ;
      boolean bool = com.tencent.mm.plugin.s.a.bIX().a(this.xqy, new String[0]);
      ad.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[] { bt.aRp(this.xqy.field_signature), bt.aRp(this.xqy.field_fakeAeskey), bt.aRp(this.xqy.field_fakeSignature), Boolean.valueOf(bool) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(9461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.d
 * JD-Core Version:    0.7.0.1
 */