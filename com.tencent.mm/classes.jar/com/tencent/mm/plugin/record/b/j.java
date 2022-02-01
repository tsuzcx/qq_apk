package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.an.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class j
  extends i<com.tencent.mm.plugin.record.a.j>
{
  private g.a iZc;
  
  public j()
  {
    AppMethodBeat.i(9493);
    this.iZc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9492);
        Log.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, startRet[%d], mediaId[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymousc != null) {
          Log.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, mediaid[%s], totallen[%d], offset[%d]", new Object[] { paramAnonymousc.mediaId, Long.valueOf(paramAnonymousc.field_toltalLength), Long.valueOf(paramAnonymousc.field_finishedLength) });
        }
        if ((paramAnonymousInt == -21006) || (paramAnonymousInt == -21005))
        {
          j.this.eIq();
          AppMethodBeat.o(9492);
          return 0;
        }
        final com.tencent.mm.plugin.record.a.j localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(paramAnonymousString);
        if (localj == null)
        {
          Log.w("MicroMsg.RecordMsgCDNService", "onCdnCallback info null, mediaId[%s]", new Object[] { paramAnonymousString });
          j.this.eIq();
          AppMethodBeat.o(9492);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.RecordMsgCDNService", "[record] tran fail, startRet[%d], mediaId[%s], type[%d]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Integer.valueOf(localj.field_type) });
          if (-5103059 == paramAnonymousInt)
          {
            localj.field_status = 4;
            localj.field_errCode = paramAnonymousInt;
            ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj, new String[] { "localId" });
          }
        }
        for (;;)
        {
          j.this.eIq();
          label327:
          do
          {
            for (;;)
            {
              AppMethodBeat.o(9492);
              return 0;
              localj.field_status = 3;
              break;
              if (paramAnonymousc == null) {
                break label327;
              }
              localj.field_offset = ((int)paramAnonymousc.field_finishedLength);
              localj.field_totalLen = ((int)paramAnonymousc.field_toltalLength);
              localj.field_status = 1;
              ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj, new String[] { "localId" });
            }
          } while (paramAnonymousd == null);
          paramAnonymousInt = paramAnonymousd.field_retCode;
          int i = paramAnonymousd.field_UploadHitCacheType;
          boolean bool2 = paramAnonymousd.field_exist_whencheck;
          paramAnonymousc = Util.secPrint(paramAnonymousd.field_aesKey);
          String str = paramAnonymousd.field_filemd5;
          boolean bool1;
          if (1 == localj.field_type)
          {
            bool1 = true;
            label380:
            Log.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn cdnCallback upload attach by cdn, retCode:%d isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s], mediaId:%s, isDownload:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(bool2), paramAnonymousc, str, paramAnonymousString, Boolean.valueOf(bool1) });
            if (paramAnonymousd.field_retCode < 0) {
              break label868;
            }
            localj.field_status = 2;
            if (1 != localj.field_type) {
              break label623;
            }
            paramAnonymousString = localj.field_path + ".temp";
            paramAnonymousd = localj.field_path;
            if ((!Util.isNullOrNil(paramAnonymousString)) && (!Util.isNullOrNil(paramAnonymousd))) {
              break label561;
            }
            Log.w("MicroMsg.RecordMsgCDNService", "do rename and copy file, but path error");
          }
          for (;;)
          {
            ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(localj, new String[] { "localId" });
            break;
            bool1 = false;
            break label380;
            label561:
            paramAnonymousc = new o(paramAnonymousString);
            paramAnonymousd = new o(paramAnonymousd);
            if (paramAnonymousc.exists()) {
              Log.v("MicroMsg.RecordMsgCDNService", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(paramAnonymousc.am(paramAnonymousd)), paramAnonymousString, paramAnonymousd });
            }
          }
          label623:
          Log.i("MicroMsg.RecordMsgCDNService", "transfer done, mediaid=%s, md5=%s", new Object[] { paramAnonymousd.mediaId, paramAnonymousString });
          Log.d("MicroMsg.RecordMsgCDNService", "transfer done, completeInfo=%s", new Object[] { paramAnonymousd });
          Log.d("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload field_aesKey[%s], field_fileId[%s]", new Object[] { paramAnonymousd.field_aesKey, paramAnonymousd.field_fileId });
          if (paramAnonymousd.alL())
          {
            Log.i("MicroMsg.RecordMsgCDNService", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s], newmd5[%s]", new Object[] { Boolean.valueOf(paramAnonymousd.field_upload_by_safecdn), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Integer.valueOf(paramAnonymousd.field_filecrc), paramAnonymousd.field_aesKey, paramAnonymousd.field_mp4identifymd5 });
            com.tencent.mm.kernel.g.aAg().hqi.a(new e(paramAnonymousd.field_fileId, paramAnonymousd.field_filemd5, paramAnonymousd.field_mp4identifymd5, paramAnonymousd.field_filecrc, new e.a()
            {
              public final void ax(String paramAnonymous2String, int paramAnonymous2Int1, int paramAnonymous2Int2)
              {
                AppMethodBeat.i(9491);
                Log.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
                if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
                {
                  Log.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", new Object[] { Integer.valueOf(localj.field_status), Integer.valueOf(localj.field_offset), Integer.valueOf(localj.field_totalLen) });
                  localj.field_offset = 0;
                  localj.field_totalLen = 0;
                  localj.field_status = 0;
                  ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj, new String[] { "localId" });
                  j.this.b(localj, false);
                  AppMethodBeat.o(9491);
                  return;
                }
                localj.field_cdnKey = paramAnonymous2String;
                localj.field_cdnUrl = paramAnonymousd.field_fileId;
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj, new String[] { "localId" });
                j.this.eIq();
                AppMethodBeat.o(9491);
              }
            }), 0);
            AppMethodBeat.o(9492);
            return 0;
          }
          localj.field_cdnKey = paramAnonymousd.field_aesKey;
          localj.field_cdnUrl = paramAnonymousd.field_fileId;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj, new String[] { "localId" });
        }
        label868:
        Log.e("MicroMsg.RecordMsgCDNService", "transfer error, mediaid=%s, retCode:%d", new Object[] { paramAnonymousd.mediaId, Integer.valueOf(paramAnonymousd.field_retCode) });
        if (-5103059 == paramAnonymousd.field_retCode) {}
        for (localj.field_status = 4;; localj.field_status = 3)
        {
          localj.field_errCode = paramAnonymousd.field_retCode;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj, new String[] { "localId" });
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
    if ((paramc instanceof com.tencent.mm.plugin.record.a.j)) {
      b((com.tencent.mm.plugin.record.a.j)paramc, true);
    }
    AppMethodBeat.o(9496);
  }
  
  final void b(com.tencent.mm.plugin.record.a.j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(9495);
    Log.i("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, md5:%s, mediaId:%s, jobType[%d], jobStatus[%s]", new Object[] { paramj.field_dataId, paramj.field_mediaId, Integer.valueOf(paramj.field_type), Integer.valueOf(paramj.field_status) });
    if (-1 == paramj.field_status)
    {
      AppMethodBeat.o(9495);
      return;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_RecordMsgCDNService";
    localg.gqy = this.iZc;
    localg.field_mediaId = paramj.field_mediaId;
    if (2 == paramj.field_type)
    {
      localg.ehd = true;
      localg.field_priority = com.tencent.mm.i.a.gpL;
      localg.field_needStorage = false;
      localg.field_totalLen = paramj.field_totalLen;
      localg.field_aesKey = paramj.field_cdnKey;
      localg.field_fileId = paramj.field_cdnUrl;
      localg.gqy = this.iZc;
      localg.field_fullpath = paramj.field_path;
      localg.field_fileType = paramj.field_fileType;
      localg.field_talker = paramj.field_toUser;
      localg.field_force_aeskeycdn = false;
      localg.field_trysafecdn = true;
      localg.field_enable_hitcheck = paramBoolean;
      Log.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_UPLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", new Object[] { Boolean.valueOf(localg.field_force_aeskeycdn), Integer.valueOf(localg.field_fileType), localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn), Boolean.valueOf(localg.field_enable_hitcheck), localg.field_mediaId });
      f.baQ().f(localg);
    }
    for (;;)
    {
      Log.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, isSend:%B totallen:%d, aseKey:%s, url[%s], fullPath[%s], fileType[%d], enable_hitcheck[%b], force_aeskeycdn[%b]", new Object[] { Boolean.valueOf(localg.ehd), Integer.valueOf(localg.field_totalLen), localg.field_aesKey, localg.field_fileId, localg.field_fullpath, Integer.valueOf(localg.field_fileType), Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_force_aeskeycdn) });
      AppMethodBeat.o(9495);
      return;
      localg.ehd = false;
      localg.field_priority = com.tencent.mm.i.a.gpM;
      localg.field_needStorage = false;
      localg.field_totalLen = paramj.field_totalLen;
      localg.field_aesKey = paramj.field_cdnKey;
      localg.field_fileId = paramj.field_cdnUrl;
      localg.gqy = this.iZc;
      localg.field_fullpath = (paramj.field_path + ".temp");
      localg.field_fileType = paramj.field_fileType;
      if (!Util.isNullOrNil(paramj.field_tpdataurl))
      {
        localg.field_fileType = 19;
        localg.field_authKey = paramj.field_tpauthkey;
        localg.field_aesKey = paramj.field_tpaeskey;
        localg.gqB = paramj.field_tpdataurl;
        localg.field_fileId = "";
      }
      Log.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_DOWNLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", new Object[] { Boolean.valueOf(localg.field_force_aeskeycdn), Integer.valueOf(localg.field_fileType), localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn), Boolean.valueOf(localg.field_enable_hitcheck), localg.field_mediaId });
      f.baQ().b(localg, -1);
    }
  }
  
  protected final List<com.tencent.mm.plugin.record.a.j> eIp()
  {
    AppMethodBeat.i(9494);
    List localList = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().eIk();
    Log.d("MicroMsg.RecordMsgCDNService", "get to do jobs, size %d", new Object[] { Integer.valueOf(localList.size()) });
    AppMethodBeat.o(9494);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.j
 * JD-Core Version:    0.7.0.1
 */