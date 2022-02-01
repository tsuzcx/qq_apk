package com.tencent.mm.plugin.record.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.m;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class e
  extends p
  implements m
{
  private final com.tencent.mm.pluginsdk.model.app.c NAc;
  private com.tencent.mm.am.h callback;
  private com.tencent.mm.am.c rr;
  private boolean xrV;
  
  public e(com.tencent.mm.pluginsdk.model.app.c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramc, paramString1, paramString2, paramString3, paramString4, paramString5, false);
    AppMethodBeat.i(9459);
    AppMethodBeat.o(9459);
  }
  
  public e(com.tencent.mm.pluginsdk.model.app.c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    AppMethodBeat.i(305325);
    this.xrV = false;
    this.xrV = paramBoolean;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new zw();
    ((c.a)localObject).otF = new zx();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
    ((c.a)localObject).funcId = 728;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    this.NAc = paramc;
    localObject = (zw)c.b.b(this.rr.otB);
    ((zw)localObject).ZaN = paramString1;
    ((zw)localObject).YKr = paramc.field_totalLen;
    ((zw)localObject).Ida = paramString2;
    ((zw)localObject).IcZ = paramString3;
    ((zw)localObject).YKs = paramString4;
    ((zw)localObject).IMh = paramString5;
    ((zw)localObject).IMg = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, ""));
    ((zw)localObject).YIE = com.tencent.mm.g.a.lwb;
    Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] autoDownload[%s] stack[%s]", new Object[] { Util.secPrint(((zw)localObject).ZaN), ((zw)localObject).Ida, ((zw)localObject).IcZ, ((zw)localObject).YKs, Long.valueOf(((zw)localObject).YKr), Integer.valueOf(((zw)localObject).YIE), Boolean.valueOf(paramBoolean), Util.getStack() });
    AppMethodBeat.o(305325);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(9460);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(9460);
    return i;
  }
  
  public final String getMediaId()
  {
    if (this.NAc != null) {
      return this.NAc.field_mediaSvrId;
    }
    return "";
  }
  
  public final int getType()
  {
    return 728;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9461);
    Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (zx)c.c.b(((com.tencent.mm.am.c)params).otC);
      this.NAc.field_signature = params.pSi;
      this.NAc.field_fakeAeskey = params.Zit;
      this.NAc.field_fakeSignature = params.Ziu;
      boolean bool = com.tencent.mm.plugin.openapi.a.cWJ().a(this.NAc, new String[0]);
      Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[] { Util.secPrint(this.NAc.field_signature), Util.secPrint(this.NAc.field_fakeAeskey), Util.secPrint(this.NAc.field_fakeSignature), Boolean.valueOf(bool) });
      if (this.xrV) {
        if (this.NAc.field_signature != null) {
          break label300;
        }
      }
    }
    label300:
    for (paramInt1 = -1;; paramInt1 = this.NAc.field_signature.length())
    {
      Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach", new Object[] { Integer.valueOf(paramInt1) });
      this.NAc.field_status = 101L;
      this.NAc.field_lastModifyTime = Util.nowSecond();
      com.tencent.mm.plugin.openapi.a.cWJ().a(this.NAc, new String[0]);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new g(this.NAc.field_msgInfoId, this.NAc.field_mediaId, null), 0);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(9461);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.e
 * JD-Core Version:    0.7.0.1
 */