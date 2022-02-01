package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class d
  extends q
  implements m
{
  private final c BGu;
  private i callback;
  private com.tencent.mm.ak.d rr;
  
  public d(c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(9459);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new xt();
    ((d.a)localObject).iLO = new xu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
    ((d.a)localObject).funcId = 728;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    this.BGu = paramc;
    localObject = (xt)this.rr.iLK.iLR;
    ((xt)localObject).LbJ = paramString1;
    ((xt)localObject).KMg = paramc.field_totalLen;
    ((xt)localObject).xuB = paramString2;
    ((xt)localObject).xuz = paramString3;
    ((xt)localObject).KMh = paramString4;
    ((xt)localObject).xNH = paramString5;
    ((xt)localObject).xNG = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, ""));
    ((xt)localObject).KKA = com.tencent.mm.i.a.gpO;
    Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", new Object[] { Util.secPrint(((xt)localObject).LbJ), ((xt)localObject).xuB, ((xt)localObject).xuz, ((xt)localObject).KMh, Long.valueOf(((xt)localObject).KMg), Integer.valueOf(((xt)localObject).KKA), Util.getStack() });
    AppMethodBeat.o(9459);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(9460);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(9460);
    return i;
  }
  
  public final String getMediaId()
  {
    if (this.BGu != null) {
      return this.BGu.field_mediaSvrId;
    }
    return "";
  }
  
  public final int getType()
  {
    return 728;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9461);
    Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (xu)((com.tencent.mm.ak.d)params).iLL.iLR;
      this.BGu.field_signature = params.keb;
      this.BGu.field_fakeAeskey = params.LiS;
      this.BGu.field_fakeSignature = params.LiT;
      boolean bool = com.tencent.mm.plugin.r.a.cgO().a(this.BGu, new String[0]);
      Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[] { Util.secPrint(this.BGu.field_signature), Util.secPrint(this.BGu.field_fakeAeskey), Util.secPrint(this.BGu.field_fakeSignature), Boolean.valueOf(bool) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(9461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.d
 * JD-Core Version:    0.7.0.1
 */