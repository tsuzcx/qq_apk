package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ak.b;
import com.tencent.mm.j.a;
import com.tencent.mm.j.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class d
  extends c<com.tencent.mm.plugin.record.a.f>
{
  private f.a epa = new d.1(this);
  
  final void a(com.tencent.mm.plugin.record.a.f paramf, boolean paramBoolean)
  {
    y.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, md5:%s, mediaId:%s, jobType[%d], jobStatus[%s]", new Object[] { paramf.field_dataId, paramf.field_mediaId, Integer.valueOf(paramf.field_type), Integer.valueOf(paramf.field_status) });
    if (-1 == paramf.field_status) {
      return;
    }
    com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
    localf.dlP = this.epa;
    localf.field_mediaId = paramf.field_mediaId;
    if (2 == paramf.field_type)
    {
      localf.ceg = true;
      localf.field_priority = a.dlj;
      localf.field_needStorage = false;
      localf.field_totalLen = paramf.field_totalLen;
      localf.field_aesKey = paramf.field_cdnKey;
      localf.field_fileId = paramf.field_cdnUrl;
      localf.dlP = this.epa;
      localf.field_fullpath = paramf.field_path;
      localf.field_fileType = paramf.field_fileType;
      localf.field_talker = paramf.field_toUser;
      localf.field_force_aeskeycdn = false;
      localf.field_trysafecdn = true;
      localf.field_enable_hitcheck = paramBoolean;
      y.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_UPLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", new Object[] { Boolean.valueOf(localf.field_force_aeskeycdn), Integer.valueOf(localf.field_fileType), localf.field_aesKey, localf.field_fileId, Boolean.valueOf(localf.field_force_aeskeycdn), Boolean.valueOf(localf.field_trysafecdn), Boolean.valueOf(localf.field_enable_hitcheck), localf.field_mediaId });
      com.tencent.mm.ak.f.Nd().c(localf);
    }
    for (;;)
    {
      y.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, isSend:%B totallen:%d, aseKey:%s, url[%s], fullPath[%s], fileType[%d], enable_hitcheck[%b], force_aeskeycdn[%b]", new Object[] { Boolean.valueOf(localf.ceg), Integer.valueOf(localf.field_totalLen), localf.field_aesKey, localf.field_fileId, localf.field_fullpath, Integer.valueOf(localf.field_fileType), Boolean.valueOf(localf.field_enable_hitcheck), Boolean.valueOf(localf.field_force_aeskeycdn) });
      return;
      localf.ceg = false;
      localf.field_priority = a.dlk;
      localf.field_needStorage = false;
      localf.field_totalLen = paramf.field_totalLen;
      localf.field_aesKey = paramf.field_cdnKey;
      localf.field_fileId = paramf.field_cdnUrl;
      localf.dlP = this.epa;
      localf.field_fullpath = (paramf.field_path + ".temp");
      localf.field_fileType = paramf.field_fileType;
      if (!bk.bl(paramf.field_tpdataurl))
      {
        localf.field_fileType = 19;
        localf.field_authKey = paramf.field_tpauthkey;
        localf.field_aesKey = paramf.field_tpaeskey;
        localf.dlQ = paramf.field_tpdataurl;
        localf.field_fileId = "";
      }
      y.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_DOWNLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", new Object[] { Boolean.valueOf(localf.field_force_aeskeycdn), Integer.valueOf(localf.field_fileType), localf.field_aesKey, localf.field_fileId, Boolean.valueOf(localf.field_force_aeskeycdn), Boolean.valueOf(localf.field_trysafecdn), Boolean.valueOf(localf.field_enable_hitcheck), localf.field_mediaId });
      com.tencent.mm.ak.f.Nd().b(localf, -1);
    }
  }
  
  protected final List<com.tencent.mm.plugin.record.a.f> bvw()
  {
    List localList = n.getRecordMsgCDNStorage().bvt();
    y.d("MicroMsg.RecordMsgCDNService", "get to do jobs, size %d", new Object[] { Integer.valueOf(localList.size()) });
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.d
 * JD-Core Version:    0.7.0.1
 */