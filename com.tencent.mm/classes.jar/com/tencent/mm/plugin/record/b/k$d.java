package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ak.b;
import com.tencent.mm.j.a;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class k$d
  implements Runnable
{
  private com.tencent.mm.plugin.record.a.g nsL;
  
  public k$d(k paramk, com.tencent.mm.plugin.record.a.g paramg)
  {
    this.nsL = paramg;
  }
  
  private void a(xv paramxv, String paramString1, String paramString2)
  {
    y.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", new Object[] { paramxv.kgC, paramString2, paramString1 });
    com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
    localf.field_fileType = 19;
    localf.field_authKey = paramxv.dQH;
    localf.field_aesKey = paramxv.sVV;
    localf.dlQ = paramxv.sVY;
    localf.field_fullpath = paramString1;
    localf.field_mediaId = paramString2;
    localf.dlP = new k.d.1(this, paramxv, paramString1);
    if (!com.tencent.mm.ak.f.Nd().b(localf, -1)) {
      y.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
    }
  }
  
  private void b(xv paramxv, String paramString1, String paramString2)
  {
    y.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramxv.kgC, paramString2, paramString1 });
    com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
    localf.field_fileType = 19;
    localf.field_authKey = paramxv.dQH;
    localf.field_aesKey = paramxv.dQI;
    localf.dlQ = paramxv.dQC;
    localf.field_fullpath = paramString1;
    localf.field_mediaId = paramString2;
    localf.dlP = new k.d.2(this, paramxv, paramString1);
    if (!com.tencent.mm.ak.f.Nd().b(localf, -1)) {
      y.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
    }
  }
  
  public final void run()
  {
    int m = 0;
    Iterator localIterator = this.nsL.field_dataProto.sXc.iterator();
    int j = 0;
    int i;
    int k;
    if (localIterator.hasNext())
    {
      xv localxv = (xv)localIterator.next();
      boolean bool;
      label112:
      String str2;
      if (bk.bl(localxv.sUG))
      {
        i = j;
        k = m;
        if (bk.bl(localxv.sVY)) {}
      }
      else
      {
        str1 = h.c(localxv, this.nsL.field_oriMsgId);
        localObject = h.c(localxv, this.nsL.field_msgId);
        if (com.tencent.mm.vfs.e.r(str1, (String)localObject) <= 0L) {
          break label866;
        }
        bool = true;
        y.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[] { str1, localObject, Boolean.valueOf(bool) });
        k = m;
        if (bool)
        {
          k = m;
          if (bk.bl(localxv.sUX))
          {
            y.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
            localxv.XF(com.tencent.mm.a.g.bQ((String)localObject));
            k = 1;
          }
          if (bk.bl(localxv.sUZ))
          {
            y.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
            localxv.XG(com.tencent.mm.a.g.bR((String)localObject));
            k = 1;
          }
        }
        str1 = h.h(localxv.kgC, this.nsL.field_msgId, false);
        localObject = n.getRecordMsgCDNStorage().LG(str1);
        if (localObject != null) {
          break label877;
        }
        localObject = new com.tencent.mm.plugin.record.a.f();
        ((com.tencent.mm.plugin.record.a.f)localObject).field_cdnKey = localxv.sUI;
        ((com.tencent.mm.plugin.record.a.f)localObject).field_cdnUrl = localxv.sUG;
        ((com.tencent.mm.plugin.record.a.f)localObject).field_dataId = localxv.kgC;
        ((com.tencent.mm.plugin.record.a.f)localObject).field_mediaId = str1;
        ((com.tencent.mm.plugin.record.a.f)localObject).field_totalLen = ((int)localxv.sVb);
        ((com.tencent.mm.plugin.record.a.f)localObject).field_localId = ((com.tencent.mm.plugin.record.a.f)localObject).field_mediaId.hashCode();
        ((com.tencent.mm.plugin.record.a.f)localObject).field_path = h.c(localxv, this.nsL.field_msgId);
        ((com.tencent.mm.plugin.record.a.f)localObject).field_type = 2;
        ((com.tencent.mm.plugin.record.a.f)localObject).field_fileType = h.wB(localxv.aYU);
        ((com.tencent.mm.plugin.record.a.f)localObject).field_recordLocalId = this.nsL.field_localId;
        ((com.tencent.mm.plugin.record.a.f)localObject).field_toUser = this.nsL.field_toUser;
        ((com.tencent.mm.plugin.record.a.f)localObject).field_isThumb = false;
        str2 = h.c(localxv, this.nsL.field_msgId);
        if ((bk.bl(localxv.sVY)) || (com.tencent.mm.vfs.e.bK(str2))) {
          break label872;
        }
        ((com.tencent.mm.plugin.record.a.f)localObject).field_status = -1;
        a(localxv, str2, str1);
        i = j;
        label436:
        bool = n.getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.f)localObject);
        y.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.f)localObject).field_localId), Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.plugin.record.a.f)localObject).field_recordLocalId) });
      }
      label490:
      if ((bk.bl(localxv.dQL)) && (bk.bl(localxv.dQC))) {
        break label1077;
      }
      String str1 = h.f(localxv, this.nsL.field_oriMsgId);
      Object localObject = h.f(localxv, this.nsL.field_msgId);
      label555:
      com.tencent.mm.plugin.record.a.f localf;
      if (com.tencent.mm.vfs.e.r(str1, (String)localObject) > 0L)
      {
        bool = true;
        y.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { str1, localObject, Boolean.valueOf(bool) });
        str1 = h.Cw(localxv.kgC);
        localObject = h.h(str1, this.nsL.field_msgId, false);
        localf = n.getRecordMsgCDNStorage().LG((String)localObject);
        str2 = h.f(localxv, this.nsL.field_msgId);
        if (localf != null) {
          break label935;
        }
        localf = new com.tencent.mm.plugin.record.a.f();
        localf.field_cdnKey = localxv.sUC;
        localf.field_cdnUrl = localxv.dQL;
        localf.field_dataId = str1;
        localf.field_mediaId = ((String)localObject);
        localf.field_totalLen = ((int)localxv.sVm);
        localf.field_localId = localf.field_mediaId.hashCode();
        localf.field_path = h.f(localxv, this.nsL.field_msgId);
        localf.field_type = 2;
        localf.field_fileType = a.MediaType_FULLSIZEIMAGE;
        localf.field_recordLocalId = this.nsL.field_localId;
        localf.field_toUser = this.nsL.field_toUser;
        localf.field_isThumb = true;
        if ((bk.bl(localxv.dQC)) || (com.tencent.mm.vfs.e.bK(str2))) {
          break label930;
        }
        localf.field_status = -1;
        b(localxv, str2, (String)localObject);
      }
      for (;;)
      {
        bool = n.getRecordMsgCDNStorage().b(localf);
        y.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d", new Object[] { Integer.valueOf(localf.field_localId), Boolean.valueOf(bool), Integer.valueOf(localf.field_recordLocalId) });
        j = i;
        m = k;
        break;
        label866:
        bool = false;
        break label112;
        label872:
        i = 1;
        break label436;
        label877:
        if (((com.tencent.mm.plugin.record.a.f)localObject).field_status == -1) {
          a(localxv, h.c(localxv, this.nsL.field_msgId), str1);
        }
        if (((com.tencent.mm.plugin.record.a.f)localObject).field_status == 0)
        {
          i = 1;
          break label490;
        }
        i = 0;
        break label490;
        bool = false;
        break label555;
        label930:
        i = 1;
      }
      label935:
      if (localf.field_status == -1) {
        b(localxv, h.f(localxv, this.nsL.field_msgId), (String)localObject);
      }
      if (localf.field_status == 0) {
        i = 1;
      }
    }
    label1077:
    for (;;)
    {
      j = i;
      m = k;
      break;
      i = 0;
      continue;
      if (m != 0)
      {
        y.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.nsL.field_localId), Long.valueOf(this.nsL.field_msgId), Integer.valueOf(this.nsL.field_type) });
        n.bvz().c(this.nsL, new String[] { "localId" });
      }
      if (j != 0) {
        n.bvB().run();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.k.d
 * JD-Core Version:    0.7.0.1
 */