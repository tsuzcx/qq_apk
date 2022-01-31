package com.tencent.mm.plugin.record.b;

import com.tencent.mm.j.a;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class k$a
  implements Runnable
{
  private com.tencent.mm.plugin.record.a.g nsL;
  
  public k$a(k paramk, com.tencent.mm.plugin.record.a.g paramg)
  {
    this.nsL = paramg;
  }
  
  public final void run()
  {
    Iterator localIterator = this.nsL.field_dataProto.sXc.iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      xv localxv = (xv)localIterator.next();
      int i;
      Object localObject1;
      Object localObject2;
      label99:
      int k;
      if (bk.bl(localxv.sUG))
      {
        i = j;
        if (!com.tencent.mm.vfs.e.bK(localxv.sVe)) {}
      }
      else
      {
        localObject1 = localxv.sVe;
        localObject2 = h.c(localxv, this.nsL.field_msgId);
        if (com.tencent.mm.vfs.e.r((String)localObject1, (String)localObject2) <= 0L) {
          break label863;
        }
        bool = true;
        y.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[] { localxv.sUG, localObject1, localObject2, Boolean.valueOf(bool) });
        k = j;
        if (bool)
        {
          if (bk.bl(localxv.sUX))
          {
            y.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
            localxv.XF(com.tencent.mm.vfs.e.aeY((String)localObject2));
            j = 1;
          }
          k = j;
          if (bk.bl(localxv.sUZ))
          {
            y.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
            localObject1 = com.tencent.mm.vfs.e.c((String)localObject2, 0, 256);
            if (localObject1 != null) {
              break label869;
            }
            localObject1 = null;
            label213:
            localxv.XG((String)localObject1);
            k = 1;
          }
        }
        if (com.tencent.mm.vfs.e.aeQ((String)localObject2) != 0L) {
          localxv.hf(com.tencent.mm.vfs.e.aeQ((String)localObject2));
        }
        localObject1 = h.h(localxv.kgC, this.nsL.field_msgId, false);
        i = k;
        if (n.getRecordMsgCDNStorage().LG((String)localObject1) == null)
        {
          localObject2 = new f();
          ((f)localObject2).field_cdnKey = localxv.sUI;
          ((f)localObject2).field_cdnUrl = localxv.sUG;
          ((f)localObject2).field_dataId = localxv.kgC;
          ((f)localObject2).field_mediaId = ((String)localObject1);
          ((f)localObject2).field_totalLen = ((int)localxv.sVb);
          ((f)localObject2).field_localId = ((f)localObject2).field_mediaId.hashCode();
          ((f)localObject2).field_path = h.c(localxv, this.nsL.field_msgId);
          ((f)localObject2).field_type = 2;
          ((f)localObject2).field_fileType = h.wB(localxv.aYU);
          ((f)localObject2).field_recordLocalId = this.nsL.field_localId;
          ((f)localObject2).field_toUser = this.nsL.field_toUser;
          ((f)localObject2).field_isThumb = false;
          bool = n.getRecordMsgCDNStorage().b((f)localObject2);
          y.d("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[] { Integer.valueOf(((f)localObject2).field_localId), Boolean.valueOf(bool), Integer.valueOf(((f)localObject2).field_fileType), localObject1 });
          i = k;
        }
      }
      if (bk.bl(localxv.dQL))
      {
        k = i;
        if (!com.tencent.mm.vfs.e.bK(localxv.sVg)) {}
      }
      else
      {
        localObject1 = localxv.sVg;
        localObject2 = h.f(localxv, this.nsL.field_msgId);
        if (com.tencent.mm.vfs.e.r((String)localObject1, (String)localObject2) <= 0L) {
          break label879;
        }
      }
      label863:
      label869:
      label879:
      for (boolean bool = true;; bool = false)
      {
        y.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
        localxv.hg(com.tencent.mm.vfs.e.aeQ((String)localObject2));
        j = i;
        if (bool)
        {
          if (bk.bl(localxv.sVi))
          {
            y.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
            localxv.XK(com.tencent.mm.a.g.bQ((String)localObject2));
            i = 1;
          }
          j = i;
          if (bk.bl(localxv.sVk))
          {
            y.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
            localxv.XL(com.tencent.mm.a.g.bR((String)localObject2));
            j = 1;
          }
        }
        localObject1 = h.Cw(localxv.kgC);
        localObject2 = h.h((String)localObject1, this.nsL.field_msgId, false);
        k = j;
        if (n.getRecordMsgCDNStorage().LG((String)localObject2) == null)
        {
          f localf = new f();
          localf.field_cdnKey = localxv.sUC;
          localf.field_cdnUrl = localxv.dQL;
          localf.field_dataId = ((String)localObject1);
          localf.field_mediaId = ((String)localObject2);
          localf.field_totalLen = ((int)localxv.sVm);
          localf.field_localId = localf.field_mediaId.hashCode();
          localf.field_path = h.f(localxv, this.nsL.field_msgId);
          localf.field_type = 2;
          localf.field_fileType = a.MediaType_FULLSIZEIMAGE;
          localf.field_recordLocalId = this.nsL.field_localId;
          localf.field_toUser = this.nsL.field_toUser;
          localf.field_isThumb = true;
          bool = n.getRecordMsgCDNStorage().b(localf);
          y.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localf.field_localId), Boolean.valueOf(bool) });
          k = j;
        }
        j = k;
        break;
        bool = false;
        break label99;
        localObject1 = com.tencent.mm.a.g.o((byte[])localObject1);
        break label213;
      }
    }
    if (j != 0)
    {
      y.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.nsL.field_localId), Long.valueOf(this.nsL.field_msgId), Integer.valueOf(this.nsL.field_type) });
      n.bvz().c(this.nsL, new String[] { "localId" });
    }
    n.bvB().run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.k.a
 * JD-Core Version:    0.7.0.1
 */