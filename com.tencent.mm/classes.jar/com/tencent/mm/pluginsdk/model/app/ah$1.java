package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;

final class ah$1
  implements g.a
{
  ah$1(ah paramah) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(27375);
    paramString = this.vLM.fFo;
    boolean bool1;
    if (paramc != null)
    {
      bool1 = true;
      if (paramd == null) {
        break label149;
      }
    }
    label149:
    for (boolean bool2 = true;; bool2 = false)
    {
      ab.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) });
      al.aUJ().get(this.vLM.pYi, this.vLM.pYg);
      if (paramInt != -21005) {
        break label155;
      }
      ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.vLM.fFo });
      AppMethodBeat.o(27375);
      return 0;
      bool1 = false;
      break;
    }
    label155:
    if (paramInt != 0)
    {
      l.kX(this.vLM.pYg.systemRowid);
      al.aUJ().get(this.vLM.pYi, this.vLM.pYg);
      this.vLM.pYg.field_signature = "";
      paramBoolean = al.aUJ().a(this.vLM.pYg, new String[0]);
      ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.vLM.pYi), Boolean.valueOf(paramBoolean) });
      this.vLM.callback.onSceneEnd(3, paramInt, "", this.vLM);
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.vLM.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(com.tencent.mm.sdk.platformtools.ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).ake();
      AppMethodBeat.o(27375);
      return 0;
    }
    if (this.vLM.pYg.field_status == 105L)
    {
      ab.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[] { Long.valueOf(this.vLM.pYg.field_status), Long.valueOf(this.vLM.pYi) });
      com.tencent.mm.al.f.afO().sI(this.vLM.fFo);
      this.vLM.callback.onSceneEnd(3, paramInt, "attach  has paused, status" + this.vLM.pYg.field_status, this.vLM);
      AppMethodBeat.o(27375);
      return 0;
    }
    if (paramc != null)
    {
      this.vLM.pYg.field_lastModifyTime = bo.aox();
      this.vLM.pYg.field_offset = paramc.field_finishedLength;
      paramBoolean = al.aUJ().a(this.vLM.pYg, new String[0]);
      if (!paramBoolean)
      {
        ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(paramBoolean)));
        this.vLM.retCode = (-10000 - g.getLine());
        this.vLM.callback.onSceneEnd(3, paramInt, "", this.vLM);
        AppMethodBeat.o(27375);
        return 0;
      }
      AppMethodBeat.o(27375);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode == 0) {
        break label1037;
      }
      ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb });
      l.kX(this.vLM.pYg.systemRowid);
      al.aUJ().get(this.vLM.pYi, this.vLM.pYg);
      this.vLM.pYg.field_signature = "";
      paramBoolean = al.aUJ().a(this.vLM.pYg, new String[0]);
      ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramd.field_retCode), Long.valueOf(this.vLM.pYi), Boolean.valueOf(paramBoolean) });
      paramString = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.vLM.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(com.tencent.mm.sdk.platformtools.ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb });
      new com.tencent.mm.g.b.a.f(paramString).ake();
      new com.tencent.mm.g.b.a.d(paramString).ake();
      this.vLM.callback.onSceneEnd(3, paramd.field_retCode, "", this.vLM);
    }
    for (;;)
    {
      AppMethodBeat.o(27375);
      return 0;
      label1037:
      ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Boolean.valueOf(paramBoolean), Boolean.valueOf(paramd.field_exist_whencheck), bo.aqg(this.vLM.pYg.field_signature) });
      if (paramBoolean)
      {
        if (paramd.field_exist_whencheck)
        {
          aw.Rc().a(new z(this.vLM.cmR, this.vLM.pYg.field_fileFullPath, this.vLM.toUser, new ah.1.1(this, paramInt, paramd)), 0);
        }
        else
        {
          ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
          aw.Rc().a(new z(null, this.vLM.pYg.field_fileFullPath, this.vLM.toUser, new ah.1.2(this, paramInt)), 0);
        }
      }
      else {
        a(paramInt, paramd);
      }
    }
  }
  
  final void a(int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(27376);
    this.vLM.pYg.field_status = 199L;
    boolean bool = al.aUJ().a(this.vLM.pYg, new String[0]);
    if (!bool)
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
      this.vLM.retCode = (-10000 - g.getLine());
      this.vLM.callback.onSceneEnd(3, paramInt, "", this.vLM);
      AppMethodBeat.o(27376);
      return;
    }
    l.a(this.vLM.pYg.field_msgInfoId, this.vLM.pYg.field_mediaSvrId, paramd, true);
    aw.Rc().a(new af(this.vLM.pYg.field_msgInfoId, true, paramd, new ah.1.3(this, paramd), this.vLM.cpW, this.vLM.pYg), 0);
    AppMethodBeat.o(27376);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah.1
 * JD-Core Version:    0.7.0.1
 */