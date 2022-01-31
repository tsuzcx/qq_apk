package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.io.File;

final class e$1
  implements g.a
{
  e$1(e parame) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(135653);
    if (paramc == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ab.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd, Boolean.valueOf(paramBoolean) });
      if (paramInt != -21006) {
        break;
      }
      ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { this.pYo.fFo });
      AppMethodBeat.o(135653);
      return 0;
    }
    if (paramInt != 0)
    {
      a.kX(this.pYo.pYg.systemRowid);
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(this.pYo.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).ake();
      al.d(new e.1.1(this, paramInt));
      AppMethodBeat.o(135653);
      return 0;
    }
    this.pYo.pYg = a.q(paramString, this.pYo.cpO);
    if (this.pYo.pYg == null)
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
      al.d(new e.1.2(this, paramInt));
      AppMethodBeat.o(135653);
      return 0;
    }
    if (this.pYo.pYg.field_status == 102L)
    {
      ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(this.pYo.pYg.field_status) });
      com.tencent.mm.al.f.afO().sI(this.pYo.fFo);
      al.d(new e.1.3(this, paramInt));
      AppMethodBeat.o(135653);
      return 0;
    }
    if (paramc != null)
    {
      if (paramc.field_finishedLength == this.pYo.pYg.field_totalLen)
      {
        ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
        AppMethodBeat.o(135653);
        return 0;
      }
      if (this.pYo.pYg.field_offset > paramc.field_finishedLength)
      {
        ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(this.pYo.pYg.field_offset), Integer.valueOf(paramc.field_finishedLength) });
        a.kX(this.pYo.pYg.systemRowid);
        al.d(new e.1.4(this, paramInt));
        AppMethodBeat.o(135653);
        return 0;
      }
      this.pYo.pYg.field_offset = paramc.field_finishedLength;
      com.tencent.mm.plugin.s.a.aUJ().a(this.pYo.pYg, new String[0]);
      if (this.pYo.fFj != null) {
        al.d(new e.1.5(this));
      }
      ab.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { this.pYo.fFo, Integer.valueOf(paramc.field_finishedLength), Integer.valueOf(paramc.field_toltalLength) });
      AppMethodBeat.o(135653);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode == 0) {
        break label995;
      }
      a.kX(this.pYo.pYg.systemRowid);
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramd.field_retCode) });
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(2), Long.valueOf(this.pYo.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.pYo.pYg.field_totalLen), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb })).ake();
      if (paramd.field_retCode != 0) {
        new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(2), Long.valueOf(this.pYo.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.pYo.pYg.field_totalLen), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb })).ake();
      }
      if (this.pYo.fFj != null) {
        al.d(new e.1.6(this));
      }
      if (paramd.field_retCode == 0) {
        break label1287;
      }
      al.d(new e.1.7(this, paramd));
    }
    for (;;)
    {
      AppMethodBeat.o(135653);
      return 0;
      label995:
      new File(this.pYo.pYk).renameTo(new File(this.pYo.pYg.field_fileFullPath));
      this.pYo.pYg.field_status = 199L;
      this.pYo.pYg.field_offset = this.pYo.pYg.field_totalLen;
      com.tencent.mm.plugin.s.a.aUJ().a(this.pYo.pYg, new String[0]);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 45L, this.pYo.pYg.field_totalLen, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 46L, 1L, false);
      paramc = com.tencent.mm.plugin.report.service.h.qsU;
      if (this.pYo.cEE == null)
      {
        paramString = "";
        label1135:
        if (!t.lA(paramString)) {
          break label1242;
        }
      }
      label1242:
      for (long l = 48L;; l = 47L)
      {
        paramc.idkeyStat(198L, l, 1L, false);
        paramString = ((j)g.E(j.class)).bPQ().kB(this.pYo.pYg.field_msgInfoId);
        if (paramString.field_status != 5) {
          break label1250;
        }
        paramString.setStatus(3);
        ((j)g.E(j.class)).bPQ().a(paramString.field_msgId, paramString);
        break;
        paramString = this.pYo.cEE.field_talker;
        break label1135;
      }
      label1250:
      ((j)g.E(j.class)).bPQ().a(new h.c(paramString.field_talker, "update", paramString));
      break;
      label1287:
      al.d(new e.1.8(this));
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.e.1
 * JD-Core Version:    0.7.0.1
 */