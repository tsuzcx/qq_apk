package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ri;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class c
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.pluginsdk.model.app.b pYg;
  private com.tencent.mm.ai.b rr;
  
  public c(com.tencent.mm.pluginsdk.model.app.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(135639);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ri();
    ((b.a)localObject).fsY = new rj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
    ((b.a)localObject).funcId = 728;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    this.pYg = paramb;
    localObject = (ri)this.rr.fsV.fta;
    ((ri)localObject).wDo = paramString1;
    ((ri)localObject).wJz = paramb.field_totalLen;
    ((ri)localObject).wJA = paramString2;
    ((ri)localObject).fMs = paramString3;
    ((ri)localObject).wJB = paramString4;
    ((ri)localObject).num = paramString5;
    ((ri)localObject).nul = ((String)g.RL().Ru().get(2, ""));
    ((ri)localObject).wrs = com.tencent.mm.i.a.ecH;
    ab.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", new Object[] { bo.aqg(((ri)localObject).wDo), ((ri)localObject).wJA, ((ri)localObject).fMs, ((ri)localObject).wJB, Long.valueOf(((ri)localObject).wJz), Integer.valueOf(((ri)localObject).wrs), bo.dtY() });
    AppMethodBeat.o(135639);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(135640);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(135640);
    return i;
  }
  
  public final String getMediaId()
  {
    if (this.pYg != null) {
      return this.pYg.field_mediaSvrId;
    }
    return "";
  }
  
  public final int getType()
  {
    return 728;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135641);
    ab.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (rj)((com.tencent.mm.ai.b)paramq).fsW.fta;
      this.pYg.field_signature = paramq.gwS;
      this.pYg.field_fakeAeskey = paramq.wJD;
      this.pYg.field_fakeSignature = paramq.wJE;
      boolean bool = com.tencent.mm.plugin.s.a.aUJ().a(this.pYg, new String[0]);
      ab.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[] { bo.aqg(this.pYg.field_signature), bo.aqg(this.pYg.field_fakeAeskey), bo.aqg(this.pYg.field_fakeSignature), Boolean.valueOf(bool) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(135641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.c
 * JD-Core Version:    0.7.0.1
 */