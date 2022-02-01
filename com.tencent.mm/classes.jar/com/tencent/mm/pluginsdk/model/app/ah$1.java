package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yg.a;
import com.tencent.mm.g.b.a.f;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.io.ByteArrayOutputStream;

final class ah$1
  implements g.a
{
  ah$1(ah paramah) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(31052);
    ad.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.BQr.hhN, Integer.valueOf(paramInt), paramc, paramd });
    if (paramInt == -21005)
    {
      ad.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.BQr.hhN });
      AppMethodBeat.o(31052);
      return 0;
    }
    if (paramInt != 0)
    {
      this.BQr.drF.setStatus(5);
      e.vIY.idkeyStat(111L, 34L, 1L, true);
      az.arV();
      com.tencent.mm.model.c.apO().a(this.BQr.drF.field_msgId, this.BQr.drF);
      new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.BQr.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aBj();
      this.BQr.callback.onSceneEnd(3, paramInt, "", this.BQr);
      AppMethodBeat.o(31052);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode != 0)
      {
        ad.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fns });
        this.BQr.drF.setStatus(5);
        e.vIY.idkeyStat(111L, 34L, 1L, true);
        az.arV();
        com.tencent.mm.model.c.apO().a(this.BQr.drF.field_msgId, this.BQr.drF);
        paramc = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.BQr.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fns });
        new com.tencent.mm.g.b.a.h(paramc).aBj();
        new f(paramc).aBj();
        this.BQr.callback.onSceneEnd(3, paramd.field_retCode, "", this.BQr);
      }
    }
    else
    {
      if ((paramString != null) && (paramString.equals(this.BQr.hhN)) && (this.BQr.wFp != null) && (this.BQr.wFp.dEL.dEM != -1))
      {
        com.tencent.mm.sdk.b.a.ESL.l(this.BQr.wFp);
        this.BQr.wFp = null;
      }
      AppMethodBeat.o(31052);
      return 0;
    }
    if ((this.BQr.BQq > 0L) && (paramd.field_fileLength > 0L) && (this.BQr.drF.getType() != 738197553))
    {
      paramc = this.BQr.BQq + "," + paramd.field_fileLength + "," + paramd.field_fileId;
      if (this.BQr.BQq * 2L <= paramd.field_fileLength) {
        break label941;
      }
    }
    label941:
    for (boolean bool = true;; bool = false)
    {
      au.D("SendAppMsgThumbTooBig", paramc, bool);
      ad.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Boolean.valueOf(paramBoolean), Boolean.valueOf(paramd.field_exist_whencheck), bt.aGs(paramd.field_aesKey), paramd.field_filemd5 });
      if (this.BQr.drF.getType() == 738197553) {
        m.a(this.BQr.drF.field_msgId, "", paramd, false);
      }
      az.aeS().a(new ai(this.BQr.msgId, paramd, new ai.a()
      {
        public final void dm(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(31051);
          ad.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(1), Long.valueOf(ah.1.this.BQr.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fns })).aBj();
          ah.1.this.BQr.callback.onSceneEnd(paramAnonymousInt1, paramAnonymousInt2, "", ah.1.this.BQr);
          AppMethodBeat.o(31051);
        }
      }, this.BQr.mSessionId, this.BQr.dvY, this.BQr.BQo), 0);
      break;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah.1
 * JD-Core Version:    0.7.0.1
 */