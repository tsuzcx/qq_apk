package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class i
  extends h<com.tencent.mm.plugin.record.a.i>
{
  private g.a hhW;
  
  public i()
  {
    AppMethodBeat.i(9493);
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9492);
        ad.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, startRet[%d], mediaId[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymousc != null) {
          ad.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, mediaid[%s], totallen[%d], offset[%d]", new Object[] { paramAnonymousc.mediaId, Long.valueOf(paramAnonymousc.field_toltalLength), Long.valueOf(paramAnonymousc.field_finishedLength) });
        }
        if ((paramAnonymousInt == -21006) || (paramAnonymousInt == -21005))
        {
          i.this.dgi();
          AppMethodBeat.o(9492);
          return 0;
        }
        final com.tencent.mm.plugin.record.a.i locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als(paramAnonymousString);
        if (locali == null)
        {
          ad.w("MicroMsg.RecordMsgCDNService", "onCdnCallback info null, mediaId[%s]", new Object[] { paramAnonymousString });
          i.this.dgi();
          AppMethodBeat.o(9492);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ad.w("MicroMsg.RecordMsgCDNService", "[record] tran fail, startRet[%d], mediaId[%s], type[%d]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Integer.valueOf(locali.field_type) });
          if (-5103059 == paramAnonymousInt)
          {
            locali.field_status = 4;
            locali.field_errCode = paramAnonymousInt;
            ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali, new String[] { "localId" });
          }
        }
        for (;;)
        {
          i.this.dgi();
          label327:
          do
          {
            for (;;)
            {
              AppMethodBeat.o(9492);
              return 0;
              locali.field_status = 3;
              break;
              if (paramAnonymousc == null) {
                break label327;
              }
              locali.field_offset = ((int)paramAnonymousc.field_finishedLength);
              locali.field_totalLen = ((int)paramAnonymousc.field_toltalLength);
              locali.field_status = 1;
              ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali, new String[] { "localId" });
            }
          } while (paramAnonymousd == null);
          paramAnonymousInt = paramAnonymousd.field_retCode;
          int i = paramAnonymousd.field_UploadHitCacheType;
          boolean bool2 = paramAnonymousd.field_exist_whencheck;
          paramAnonymousc = bt.aGs(paramAnonymousd.field_aesKey);
          String str = paramAnonymousd.field_filemd5;
          boolean bool1;
          if (1 == locali.field_type)
          {
            bool1 = true;
            label380:
            ad.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn cdnCallback upload attach by cdn, retCode:%d isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s], mediaId:%s, isDownload:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(bool2), paramAnonymousc, str, paramAnonymousString, Boolean.valueOf(bool1) });
            if (paramAnonymousd.field_retCode < 0) {
              break label868;
            }
            locali.field_status = 2;
            if (1 != locali.field_type) {
              break label623;
            }
            paramAnonymousString = locali.field_path + ".temp";
            paramAnonymousd = locali.field_path;
            if ((!bt.isNullOrNil(paramAnonymousString)) && (!bt.isNullOrNil(paramAnonymousd))) {
              break label561;
            }
            ad.w("MicroMsg.RecordMsgCDNService", "do rename and copy file, but path error");
          }
          for (;;)
          {
            ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(locali, new String[] { "localId" });
            break;
            bool1 = false;
            break label380;
            label561:
            paramAnonymousc = new com.tencent.mm.vfs.e(paramAnonymousString);
            paramAnonymousd = new com.tencent.mm.vfs.e(paramAnonymousd);
            if (paramAnonymousc.exists()) {
              ad.v("MicroMsg.RecordMsgCDNService", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(paramAnonymousc.af(paramAnonymousd)), paramAnonymousString, paramAnonymousd });
            }
          }
          label623:
          ad.i("MicroMsg.RecordMsgCDNService", "transfer done, mediaid=%s, md5=%s", new Object[] { paramAnonymousd.mediaId, paramAnonymousString });
          ad.d("MicroMsg.RecordMsgCDNService", "transfer done, completeInfo=%s", new Object[] { paramAnonymousd });
          ad.d("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload field_aesKey[%s], field_fileId[%s]", new Object[] { paramAnonymousd.field_aesKey, paramAnonymousd.field_fileId });
          if (paramAnonymousd.UC())
          {
            ad.i("MicroMsg.RecordMsgCDNService", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s], newmd5[%s]", new Object[] { Boolean.valueOf(paramAnonymousd.field_upload_by_safecdn), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Integer.valueOf(paramAnonymousd.field_filecrc), paramAnonymousd.field_aesKey, paramAnonymousd.field_mp4identifymd5 });
            com.tencent.mm.kernel.g.afA().gcy.a(new d(paramAnonymousd.field_fileId, paramAnonymousd.field_filemd5, paramAnonymousd.field_mp4identifymd5, paramAnonymousd.field_filecrc, new d.a()
            {
              public final void ar(String paramAnonymous2String, int paramAnonymous2Int1, int paramAnonymous2Int2)
              {
                AppMethodBeat.i(9491);
                ad.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
                if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
                {
                  ad.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", new Object[] { Integer.valueOf(locali.field_status), Integer.valueOf(locali.field_offset), Integer.valueOf(locali.field_totalLen) });
                  locali.field_offset = 0;
                  locali.field_totalLen = 0;
                  locali.field_status = 0;
                  ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali, new String[] { "localId" });
                  i.this.b(locali, false);
                  AppMethodBeat.o(9491);
                  return;
                }
                locali.field_cdnKey = paramAnonymous2String;
                locali.field_cdnUrl = paramAnonymousd.field_fileId;
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali, new String[] { "localId" });
                i.this.dgi();
                AppMethodBeat.o(9491);
              }
            }), 0);
            AppMethodBeat.o(9492);
            return 0;
          }
          locali.field_cdnKey = paramAnonymousd.field_aesKey;
          locali.field_cdnUrl = paramAnonymousd.field_fileId;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali, new String[] { "localId" });
        }
        label868:
        ad.e("MicroMsg.RecordMsgCDNService", "transfer error, mediaid=%s, retCode:%d", new Object[] { paramAnonymousd.mediaId, Integer.valueOf(paramAnonymousd.field_retCode) });
        if (-5103059 == paramAnonymousd.field_retCode) {}
        for (locali.field_status = 4;; locali.field_status = 3)
        {
          locali.field_errCode = paramAnonymousd.field_retCode;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali, new String[] { "localId" });
          break;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    AppMethodBeat.o(9493);
  }
  
  public final void a(com.tencent.mm.plugin.record.a.c paramc)
  {
    AppMethodBeat.i(9496);
    if ((paramc instanceof com.tencent.mm.plugin.record.a.i)) {
      b((com.tencent.mm.plugin.record.a.i)paramc, true);
    }
    AppMethodBeat.o(9496);
  }
  
  final void b(com.tencent.mm.plugin.record.a.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(9495);
    ad.i("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, md5:%s, mediaId:%s, jobType[%d], jobStatus[%s]", new Object[] { parami.field_dataId, parami.field_mediaId, Integer.valueOf(parami.field_type), Integer.valueOf(parami.field_status) });
    if (-1 == parami.field_status)
    {
      AppMethodBeat.o(9495);
      return;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fnH = this.hhW;
    localg.field_mediaId = parami.field_mediaId;
    if (2 == parami.field_type)
    {
      localg.dDS = true;
      localg.field_priority = com.tencent.mm.i.a.fmU;
      localg.field_needStorage = false;
      localg.field_totalLen = parami.field_totalLen;
      localg.field_aesKey = parami.field_cdnKey;
      localg.field_fileId = parami.field_cdnUrl;
      localg.fnH = this.hhW;
      localg.field_fullpath = parami.field_path;
      localg.field_fileType = parami.field_fileType;
      localg.field_talker = parami.field_toUser;
      localg.field_force_aeskeycdn = false;
      localg.field_trysafecdn = true;
      localg.field_enable_hitcheck = paramBoolean;
      ad.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_UPLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", new Object[] { Boolean.valueOf(localg.field_force_aeskeycdn), Integer.valueOf(localg.field_fileType), localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn), Boolean.valueOf(localg.field_enable_hitcheck), localg.field_mediaId });
      f.awL().e(localg);
    }
    for (;;)
    {
      ad.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, isSend:%B totallen:%d, aseKey:%s, url[%s], fullPath[%s], fileType[%d], enable_hitcheck[%b], force_aeskeycdn[%b]", new Object[] { Boolean.valueOf(localg.dDS), Integer.valueOf(localg.field_totalLen), localg.field_aesKey, localg.field_fileId, localg.field_fullpath, Integer.valueOf(localg.field_fileType), Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_force_aeskeycdn) });
      AppMethodBeat.o(9495);
      return;
      localg.dDS = false;
      localg.field_priority = com.tencent.mm.i.a.fmV;
      localg.field_needStorage = false;
      localg.field_totalLen = parami.field_totalLen;
      localg.field_aesKey = parami.field_cdnKey;
      localg.field_fileId = parami.field_cdnUrl;
      localg.fnH = this.hhW;
      localg.field_fullpath = (parami.field_path + ".temp");
      localg.field_fileType = parami.field_fileType;
      if (!bt.isNullOrNil(parami.field_tpdataurl))
      {
        localg.field_fileType = 19;
        localg.field_authKey = parami.field_tpauthkey;
        localg.field_aesKey = parami.field_tpaeskey;
        localg.fnK = parami.field_tpdataurl;
        localg.field_fileId = "";
      }
      ad.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_DOWNLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", new Object[] { Boolean.valueOf(localg.field_force_aeskeycdn), Integer.valueOf(localg.field_fileType), localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn), Boolean.valueOf(localg.field_enable_hitcheck), localg.field_mediaId });
      f.awL().b(localg, -1);
    }
  }
  
  protected final List<com.tencent.mm.plugin.record.a.i> dgh()
  {
    AppMethodBeat.i(9494);
    List localList = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().dgc();
    ad.d("MicroMsg.RecordMsgCDNService", "get to do jobs, size %d", new Object[] { Integer.valueOf(localList.size()) });
    AppMethodBeat.o(9494);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.i
 * JD-Core Version:    0.7.0.1
 */