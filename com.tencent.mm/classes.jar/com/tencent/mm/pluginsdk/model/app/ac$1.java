package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.io.File;

final class ac$1
  implements f.a
{
  ac$1(ac paramac) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    if (paramc == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      y.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd, Boolean.valueOf(paramBoolean) });
      if (paramInt != -21006) {
        break;
      }
      y.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { this.rUJ.eoQ });
      return 0;
    }
    if (paramInt != 0)
    {
      l.hb(this.rUJ.rUA.ujK);
      new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(this.rUJ.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_FILE), Integer.valueOf(0), "" })).QX();
      this.rUJ.dmL.onSceneEnd(3, paramInt, "", this.rUJ);
      return 0;
    }
    this.rUJ.rUA = l.ap(paramString, this.rUJ.bIt);
    if (this.rUJ.rUA == null)
    {
      y.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
      this.rUJ.dmL.onSceneEnd(3, paramInt, "", this.rUJ);
      return 0;
    }
    if (this.rUJ.rUA.field_status == 102L)
    {
      y.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(this.rUJ.rUA.field_status) });
      com.tencent.mm.ak.f.Nd().lL(this.rUJ.eoQ);
      this.rUJ.dmL.onSceneEnd(3, paramInt, "attach  has paused, status=" + this.rUJ.rUA.field_status, this.rUJ);
      return 0;
    }
    if (paramc != null)
    {
      if (paramc.field_finishedLength == this.rUJ.rUA.field_totalLen)
      {
        y.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
        return 0;
      }
      if (this.rUJ.rUA.field_offset > paramc.field_finishedLength)
      {
        y.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(this.rUJ.rUA.field_offset), Integer.valueOf(paramc.field_finishedLength) });
        l.hb(this.rUJ.rUA.ujK);
        this.rUJ.dmL.onSceneEnd(3, paramInt, "", this.rUJ);
        return 0;
      }
      this.rUJ.rUA.field_offset = paramc.field_finishedLength;
      ap.avh().c(this.rUJ.rUA, new String[0]);
      if (this.rUJ.eoM != null) {
        ai.d(new ac.1.1(this));
      }
      y.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { this.rUJ.eoQ, Integer.valueOf(paramc.field_finishedLength), Integer.valueOf(paramc.field_toltalLength) });
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode == 0) {
        break label1008;
      }
      l.hb(this.rUJ.rUA.ujK);
      y.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramd.field_retCode) });
      this.rUJ.dmL.onSceneEnd(3, paramd.field_retCode, "", this.rUJ);
      new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(2), Long.valueOf(this.rUJ.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_FILE), Long.valueOf(this.rUJ.rUA.field_totalLen), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.dlG })).QX();
      if (paramd.field_retCode != 0) {
        new com.tencent.mm.h.b.a.d(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(2), Long.valueOf(this.rUJ.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_FILE), Long.valueOf(this.rUJ.rUA.field_totalLen), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.dlG })).QX();
      }
      if (this.rUJ.eoM != null) {
        ai.d(new ac.1.2(this));
      }
    }
    return 0;
    label1008:
    new File(this.rUJ.rUF).renameTo(new File(this.rUJ.rUA.field_fileFullPath));
    this.rUJ.rUA.field_status = 199L;
    this.rUJ.rUA.field_offset = this.rUJ.rUA.field_totalLen;
    ap.avh().c(this.rUJ.rUA, new String[0]);
    h.nFQ.a(198L, 45L, this.rUJ.rUA.field_totalLen, false);
    h.nFQ.a(198L, 46L, 1L, false);
    paramc = h.nFQ;
    label1148:
    long l;
    if (this.rUJ.bWO == null)
    {
      paramString = "";
      if (!s.fn(paramString)) {
        break label1261;
      }
      l = 48L;
      label1160:
      paramc.a(198L, l, 1L, false);
      au.Hx();
      paramString = com.tencent.mm.model.c.Fy().fd(this.rUJ.rUA.field_msgInfoId);
      if (paramString.field_status != 5) {
        break label1269;
      }
      paramString.setStatus(3);
      au.Hx();
      com.tencent.mm.model.c.Fy().a(paramString.field_msgId, paramString);
    }
    for (;;)
    {
      this.rUJ.dmL.onSceneEnd(0, 0, "", this.rUJ);
      break;
      paramString = this.rUJ.bWO.field_talker;
      break label1148;
      label1261:
      l = 47L;
      break label1160;
      label1269:
      au.Hx();
      com.tencent.mm.model.c.Fy().a(new g.c(paramString.field_talker, "update", paramString));
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ac.1
 * JD-Core Version:    0.7.0.1
 */