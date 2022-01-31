package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ah.p;
import com.tencent.mm.j.c;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.File;

final class d$1
  implements f.a
{
  d$1(d paramd) {}
  
  public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    y.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, startRet[%d], mediaId[%s]", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramc != null) {
      y.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, mediaid[%s], totallen[%d], offset[%d]", new Object[] { paramc.bUi, Integer.valueOf(paramc.field_toltalLength), Integer.valueOf(paramc.field_finishedLength) });
    }
    if ((paramInt == -21006) || (paramInt == -21005))
    {
      this.nsW.bvx();
      return 0;
    }
    f localf = n.getRecordMsgCDNStorage().LG(paramString);
    if (localf == null)
    {
      y.w("MicroMsg.RecordMsgCDNService", "onCdnCallback info null, mediaId[%s]", new Object[] { paramString });
      this.nsW.bvx();
      return 0;
    }
    if (paramInt != 0)
    {
      y.w("MicroMsg.RecordMsgCDNService", "[record] tran fail, startRet[%d], mediaId[%s], type[%d]", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(localf.field_type) });
      if (-5103059 == paramInt)
      {
        localf.field_status = 4;
        localf.field_errCode = paramInt;
        n.getRecordMsgCDNStorage().b(localf, new String[] { "localId" });
      }
    }
    for (;;)
    {
      this.nsW.bvx();
      label271:
      do
      {
        for (;;)
        {
          return 0;
          localf.field_status = 3;
          break;
          if (paramc == null) {
            break label271;
          }
          localf.field_offset = paramc.field_finishedLength;
          localf.field_totalLen = paramc.field_toltalLength;
          localf.field_status = 1;
          n.getRecordMsgCDNStorage().b(localf, new String[] { "localId" });
        }
      } while (paramd == null);
      paramInt = paramd.field_retCode;
      int i = paramd.field_UploadHitCacheType;
      boolean bool2 = paramd.field_exist_whencheck;
      paramc = bk.aac(paramd.field_aesKey);
      String str = paramd.field_filemd5;
      boolean bool1;
      if (1 == localf.field_type)
      {
        bool1 = true;
        label324:
        y.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn cdnCallback upload attach by cdn, retCode:%d isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s], mediaId:%s, isDownload:%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), paramc, str, paramString, Boolean.valueOf(bool1) });
        if (paramd.field_retCode < 0) {
          break label783;
        }
        localf.field_status = 2;
        if (1 != localf.field_type) {
          break label557;
        }
        paramString = localf.field_path + ".temp";
        paramd = localf.field_path;
        if ((!bk.bl(paramString)) && (!bk.bl(paramd))) {
          break label495;
        }
        y.w("MicroMsg.RecordMsgCDNService", "do rename and copy file, but path error");
      }
      for (;;)
      {
        n.getRecordMsgCDNStorage().a(localf, new String[] { "localId" });
        break;
        bool1 = false;
        break label324;
        label495:
        paramc = new File(paramString);
        paramd = new File(paramd);
        if (paramc.exists()) {
          y.v("MicroMsg.RecordMsgCDNService", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(paramc.renameTo(paramd)), paramString, paramd });
        }
      }
      label557:
      y.i("MicroMsg.RecordMsgCDNService", "transfer done, mediaid=%s, md5=%s", new Object[] { paramd.bUi, paramString });
      y.d("MicroMsg.RecordMsgCDNService", "transfer done, completeInfo=%s", new Object[] { paramd });
      y.d("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload field_aesKey[%s], field_fileId[%s]", new Object[] { paramd.field_aesKey, paramd.field_fileId });
      if (paramd.wV())
      {
        y.i("MicroMsg.RecordMsgCDNService", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s], newmd5[%s]", new Object[] { Boolean.valueOf(paramd.field_upload_by_safecdn), Integer.valueOf(paramd.field_UploadHitCacheType), Integer.valueOf(paramd.field_filecrc), paramd.field_aesKey, paramd.field_mp4identifymd5 });
        au.Dk().a(new ab(paramd.field_fileId, paramd.field_filemd5, paramd.field_mp4identifymd5, paramd.field_filecrc, new d.1.1(this, localf, paramd)), 0);
        return 0;
      }
      localf.field_cdnKey = paramd.field_aesKey;
      localf.field_cdnUrl = paramd.field_fileId;
      n.getRecordMsgCDNStorage().b(localf, new String[] { "localId" });
    }
    label783:
    y.e("MicroMsg.RecordMsgCDNService", "transfer error, mediaid=%s, retCode:%d", new Object[] { paramd.bUi, Integer.valueOf(paramd.field_retCode) });
    if (-5103059 == paramd.field_retCode) {}
    for (localf.field_status = 4;; localf.field_status = 3)
    {
      localf.field_errCode = paramd.field_retCode;
      n.getRecordMsgCDNStorage().b(localf, new String[] { "localId" });
      break;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.d.1
 * JD-Core Version:    0.7.0.1
 */