package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xz;
import com.tencent.mm.protocal.protobuf.ya;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class d
  extends q
  implements m
{
  private final com.tencent.mm.pluginsdk.model.app.c HCz;
  private i callback;
  private com.tencent.mm.an.d rr;
  private boolean ulJ;
  
  public d(com.tencent.mm.pluginsdk.model.app.c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramc, paramString1, paramString2, paramString3, paramString4, paramString5, false);
    AppMethodBeat.i(9459);
    AppMethodBeat.o(9459);
  }
  
  public d(com.tencent.mm.pluginsdk.model.app.c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    AppMethodBeat.i(210065);
    this.ulJ = false;
    this.ulJ = paramBoolean;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new xz();
    ((d.a)localObject).lBV = new ya();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
    ((d.a)localObject).funcId = 728;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    this.HCz = paramc;
    localObject = (xz)d.b.b(this.rr.lBR);
    ((xz)localObject).ScV = paramString1;
    ((xz)localObject).RNd = paramc.field_totalLen;
    ((xz)localObject).CqS = paramString2;
    ((xz)localObject).CqQ = paramString3;
    ((xz)localObject).RNe = paramString4;
    ((xz)localObject).CRR = paramString5;
    ((xz)localObject).CRQ = ((String)h.aHG().aHp().b(2, ""));
    ((xz)localObject).RLs = com.tencent.mm.i.a.iTW;
    Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] autoDownload[%s] stack[%s]", new Object[] { Util.secPrint(((xz)localObject).ScV), ((xz)localObject).CqS, ((xz)localObject).CqQ, ((xz)localObject).RNe, Long.valueOf(((xz)localObject).RNd), Integer.valueOf(((xz)localObject).RLs), Boolean.valueOf(paramBoolean), Util.getStack() });
    AppMethodBeat.o(210065);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(9460);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(9460);
    return i;
  }
  
  public final String getMediaId()
  {
    if (this.HCz != null) {
      return this.HCz.field_mediaSvrId;
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
      params = (ya)d.c.b(((com.tencent.mm.an.d)params).lBS);
      this.HCz.field_signature = params.mVB;
      this.HCz.field_fakeAeskey = params.Skj;
      this.HCz.field_fakeSignature = params.Skk;
      boolean bool = com.tencent.mm.plugin.ab.a.ctZ().a(this.HCz, new String[0]);
      Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[] { Util.secPrint(this.HCz.field_signature), Util.secPrint(this.HCz.field_fakeAeskey), Util.secPrint(this.HCz.field_fakeSignature), Boolean.valueOf(bool) });
      if (this.ulJ) {
        if (this.HCz.field_signature != null) {
          break label300;
        }
      }
    }
    label300:
    for (paramInt1 = -1;; paramInt1 = this.HCz.field_signature.length())
    {
      Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach", new Object[] { Integer.valueOf(paramInt1) });
      this.HCz.field_status = 101L;
      this.HCz.field_lastModifyTime = Util.nowSecond();
      com.tencent.mm.plugin.ab.a.ctZ().a(this.HCz, new String[0]);
      h.aHH();
      h.aHF().kcd.a(new f(this.HCz.field_msgInfoId, this.HCz.field_mediaId, null), 0);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(9461);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.d
 * JD-Core Version:    0.7.0.1
 */