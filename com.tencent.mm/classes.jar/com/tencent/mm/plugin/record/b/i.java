package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class i
  extends h<com.tencent.mm.plugin.record.a.i>
{
  private g.a fFy;
  
  public i()
  {
    AppMethodBeat.i(135671);
    this.fFy = new i.1(this);
    AppMethodBeat.o(135671);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(135674);
    if ((paramc instanceof com.tencent.mm.plugin.record.a.i)) {
      a((com.tencent.mm.plugin.record.a.i)paramc, true);
    }
    AppMethodBeat.o(135674);
  }
  
  final void a(com.tencent.mm.plugin.record.a.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(135673);
    ab.i("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, md5:%s, mediaId:%s, jobType[%d], jobStatus[%s]", new Object[] { parami.field_dataId, parami.field_mediaId, Integer.valueOf(parami.field_type), Integer.valueOf(parami.field_status) });
    if (-1 == parami.field_status)
    {
      AppMethodBeat.o(135673);
      return;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.edp = this.fFy;
    localg.field_mediaId = parami.field_mediaId;
    if (2 == parami.field_type)
    {
      localg.cMU = true;
      localg.field_priority = com.tencent.mm.i.a.ecE;
      localg.field_needStorage = false;
      localg.field_totalLen = parami.field_totalLen;
      localg.field_aesKey = parami.field_cdnKey;
      localg.field_fileId = parami.field_cdnUrl;
      localg.edp = this.fFy;
      localg.field_fullpath = parami.field_path;
      localg.field_fileType = parami.field_fileType;
      localg.field_talker = parami.field_toUser;
      localg.field_force_aeskeycdn = false;
      localg.field_trysafecdn = true;
      localg.field_enable_hitcheck = paramBoolean;
      ab.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_UPLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", new Object[] { Boolean.valueOf(localg.field_force_aeskeycdn), Integer.valueOf(localg.field_fileType), localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn), Boolean.valueOf(localg.field_enable_hitcheck), localg.field_mediaId });
      f.afO().e(localg);
    }
    for (;;)
    {
      ab.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, isSend:%B totallen:%d, aseKey:%s, url[%s], fullPath[%s], fileType[%d], enable_hitcheck[%b], force_aeskeycdn[%b]", new Object[] { Boolean.valueOf(localg.cMU), Integer.valueOf(localg.field_totalLen), localg.field_aesKey, localg.field_fileId, localg.field_fullpath, Integer.valueOf(localg.field_fileType), Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_force_aeskeycdn) });
      AppMethodBeat.o(135673);
      return;
      localg.cMU = false;
      localg.field_priority = com.tencent.mm.i.a.ecF;
      localg.field_needStorage = false;
      localg.field_totalLen = parami.field_totalLen;
      localg.field_aesKey = parami.field_cdnKey;
      localg.field_fileId = parami.field_cdnUrl;
      localg.edp = this.fFy;
      localg.field_fullpath = (parami.field_path + ".temp");
      localg.field_fileType = parami.field_fileType;
      if (!bo.isNullOrNil(parami.field_tpdataurl))
      {
        localg.field_fileType = 19;
        localg.field_authKey = parami.field_tpauthkey;
        localg.field_aesKey = parami.field_tpaeskey;
        localg.eds = parami.field_tpdataurl;
        localg.field_fileId = "";
      }
      ab.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_DOWNLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", new Object[] { Boolean.valueOf(localg.field_force_aeskeycdn), Integer.valueOf(localg.field_fileType), localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn), Boolean.valueOf(localg.field_enable_hitcheck), localg.field_mediaId });
      f.afO().b(localg, -1);
    }
  }
  
  protected final List<com.tencent.mm.plugin.record.a.i> cfR()
  {
    AppMethodBeat.i(135672);
    List localList = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().cfM();
    ab.d("MicroMsg.RecordMsgCDNService", "get to do jobs, size %d", new Object[] { Integer.valueOf(localList.size()) });
    AppMethodBeat.o(135672);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.i
 * JD-Core Version:    0.7.0.1
 */