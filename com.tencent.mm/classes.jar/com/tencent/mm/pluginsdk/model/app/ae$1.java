package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.g.a.wh.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;

final class ae$1
  implements g.a
{
  ae$1(ae paramae) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(27359);
    ab.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.vLF.fFo, Integer.valueOf(paramInt), paramc, paramd });
    if (paramInt == -21005)
    {
      ab.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.vLF.fFo });
      AppMethodBeat.o(27359);
      return 0;
    }
    if (paramInt != 0)
    {
      this.vLF.cEE.setStatus(5);
      e.qrI.idkeyStat(111L, 34L, 1L, true);
      aw.aaz();
      com.tencent.mm.model.c.YC().a(this.vLF.cEE.field_msgId, this.vLF.cEE);
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.vLF.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).ake();
      this.vLF.callback.onSceneEnd(3, paramInt, "", this.vLF);
      AppMethodBeat.o(27359);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode != 0)
      {
        ab.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb });
        this.vLF.cEE.setStatus(5);
        e.qrI.idkeyStat(111L, 34L, 1L, true);
        aw.aaz();
        com.tencent.mm.model.c.YC().a(this.vLF.cEE.field_msgId, this.vLF.cEE);
        paramc = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.vLF.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb });
        new com.tencent.mm.g.b.a.f(paramc).ake();
        new com.tencent.mm.g.b.a.d(paramc).ake();
        this.vLF.callback.onSceneEnd(3, paramd.field_retCode, "", this.vLF);
      }
    }
    else
    {
      if ((paramString != null) && (paramString.equals(this.vLF.fFo)) && (this.vLF.reR != null) && (this.vLF.reR.cNM.cNN != -1))
      {
        com.tencent.mm.sdk.b.a.ymk.l(this.vLF.reR);
        this.vLF.reR = null;
      }
      AppMethodBeat.o(27359);
      return 0;
    }
    if ((this.vLF.fWd > 0) && (paramd.field_fileLength > 0) && (this.vLF.cEE.getType() != 738197553))
    {
      paramc = this.vLF.fWd + "," + paramd.field_fileLength + "," + paramd.field_fileId;
      if (this.vLF.fWd * 2 <= paramd.field_fileLength) {
        break label922;
      }
    }
    label922:
    for (boolean bool = true;; bool = false)
    {
      ao.D("SendAppMsgThumbTooBig", paramc, bool);
      ab.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Boolean.valueOf(paramBoolean), Boolean.valueOf(paramd.field_exist_whencheck), bo.aqg(paramd.field_aesKey), paramd.field_filemd5 });
      if (this.vLF.cEE.getType() == 738197553) {
        l.a(this.vLF.cEE.field_msgId, "", paramd, false);
      }
      aw.Rc().a(new af(this.vLF.cpO, false, paramd, new af.a()
      {
        public final void cG(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(27358);
          ab.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(1), Long.valueOf(ae.1.this.vLF.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb })).ake();
          ae.1.this.vLF.callback.onSceneEnd(paramAnonymousInt1, paramAnonymousInt2, "", ae.1.this.vLF);
          AppMethodBeat.o(27358);
        }
      }, this.vLF.mSessionId, null), 0);
      break;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ae.1
 * JD-Core Version:    0.7.0.1
 */