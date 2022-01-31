package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

final class q$a
  implements Runnable
{
  private j pYr;
  
  public q$a(q paramq, j paramj)
  {
    this.pYr = paramj;
  }
  
  public final void run()
  {
    AppMethodBeat.i(135724);
    int m = 0;
    int i = 0;
    ab.i("MicroMsg.RecordMsgSendService", "dojob ChatDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.pYr.field_msgId) });
    int j;
    int k;
    aca localaca;
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((this.pYr != null) && (this.pYr.field_dataProto != null) && (this.pYr.field_dataProto.wVc != null))
    {
      Iterator localIterator = this.pYr.field_dataProto.wVc.iterator();
      j = 0;
      m = i;
      k = j;
      if (!localIterator.hasNext()) {
        break label1166;
      }
      localaca = (aca)localIterator.next();
      if ((bo.isNullOrNil(localaca.wSC)) && (!com.tencent.mm.vfs.e.cN(localaca.wTa))) {
        break label1333;
      }
      localObject1 = localaca.wTa;
      localObject2 = n.c(localaca, this.pYr.field_msgId);
      if (com.tencent.mm.vfs.e.C((String)localObject1, (String)localObject2) > 0L)
      {
        bool = true;
        label166:
        ab.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[] { localaca.wSC, localObject1, localObject2, Boolean.valueOf(bool) });
        k = i;
        if (!bool) {
          break label1328;
        }
        if (bo.isNullOrNil(localaca.wST))
        {
          ab.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
          localaca.anB(com.tencent.mm.vfs.e.avP((String)localObject2));
          i = 1;
        }
        k = i;
        if (!bo.isNullOrNil(localaca.wSV)) {
          break label1328;
        }
        ab.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
        localObject1 = com.tencent.mm.vfs.e.i((String)localObject2, 0, 256);
        if (localObject1 != null) {
          break label989;
        }
        localObject1 = null;
        label280:
        localaca.anC((String)localObject1);
        i = 1;
        label290:
        if (com.tencent.mm.vfs.e.avI((String)localObject2) != 0L) {
          localaca.nC(com.tencent.mm.vfs.e.avI((String)localObject2));
        }
        localObject1 = n.h(localaca.mBq, this.pYr.field_msgId, false);
        localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR((String)localObject1);
        if (localObject2 != null) {
          break label999;
        }
        localObject2 = new i();
        ((i)localObject2).field_cdnKey = localaca.wSE;
        ((i)localObject2).field_cdnUrl = localaca.wSC;
        ((i)localObject2).field_dataId = localaca.mBq;
        ((i)localObject2).field_mediaId = ((String)localObject1);
        ((i)localObject2).field_totalLen = ((int)localaca.wSX);
        ((i)localObject2).field_localId = ((i)localObject2).field_mediaId.hashCode();
        ((i)localObject2).field_path = n.c(localaca, this.pYr.field_msgId);
        ((i)localObject2).field_type = 2;
        ((i)localObject2).field_fileType = n.fl(localaca.dataType, (int)localaca.wSX);
        ((i)localObject2).field_recordLocalId = this.pYr.field_localId;
        ((i)localObject2).field_toUser = this.pYr.field_toUser;
        ((i)localObject2).field_isThumb = false;
        bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((i)localObject2);
        m = 1;
        ab.i("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[] { Integer.valueOf(((i)localObject2).field_localId), Boolean.valueOf(bool), Integer.valueOf(((i)localObject2).field_fileType), localObject1 });
        k = i;
      }
    }
    for (;;)
    {
      label571:
      if (bo.isNullOrNil(localaca.fgM))
      {
        j = k;
        if (!com.tencent.mm.vfs.e.cN(localaca.wTc)) {}
      }
      else
      {
        localObject1 = localaca.wTc;
        localObject2 = n.f(localaca, this.pYr.field_msgId);
        if (com.tencent.mm.vfs.e.C((String)localObject1, (String)localObject2) > 0L) {}
        i locali;
        for (bool = true;; bool = false)
        {
          ab.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
          localaca.nD(com.tencent.mm.vfs.e.avI((String)localObject2));
          i = k;
          if (bool)
          {
            i = k;
            if (bo.isNullOrNil(localaca.wTe))
            {
              ab.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
              localaca.anG(com.tencent.mm.a.g.getMD5((String)localObject2));
              i = 1;
            }
            if (bo.isNullOrNil(localaca.wTg))
            {
              ab.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
              localaca.anH(com.tencent.mm.a.g.cT((String)localObject2));
              i = 1;
            }
          }
          localObject1 = n.Ny(localaca.mBq);
          localObject2 = n.h((String)localObject1, this.pYr.field_msgId, false);
          locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR((String)localObject2);
          if (locali != null) {
            break label1092;
          }
          locali = new i();
          locali.field_cdnKey = localaca.wSy;
          locali.field_cdnUrl = localaca.fgM;
          locali.field_dataId = ((String)localObject1);
          locali.field_mediaId = ((String)localObject2);
          locali.field_totalLen = ((int)localaca.wTi);
          locali.field_localId = locali.field_mediaId.hashCode();
          locali.field_path = n.f(localaca, this.pYr.field_msgId);
          locali.field_type = 2;
          locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
          locali.field_recordLocalId = this.pYr.field_localId;
          locali.field_toUser = this.pYr.field_toUser;
          locali.field_isThumb = true;
          bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
          ab.i("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
          j = 1;
          break;
          bool = false;
          break label166;
          label989:
          localObject1 = com.tencent.mm.a.g.w((byte[])localObject1);
          break label280;
          label999:
          m = j;
          k = i;
          if (((i)localObject2).field_status == 2) {
            break label571;
          }
          m = j;
          k = i;
          if (((i)localObject2).field_status == 3) {
            break label571;
          }
          m = j;
          k = i;
          if (((i)localObject2).field_status == 4) {
            break label571;
          }
          m = j;
          k = i;
          if (((i)localObject2).field_status == -1) {
            break label571;
          }
          ab.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, cdnInfo status:%s", new Object[] { Integer.valueOf(((i)localObject2).field_status) });
          m = 1;
          k = i;
          break label571;
        }
        label1092:
        j = i;
        if (locali.field_status != 2)
        {
          j = i;
          if (locali.field_status != 3)
          {
            j = i;
            if (locali.field_status != 4)
            {
              j = i;
              if (locali.field_status != -1) {
                ab.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, thumb cdnInfo status:%s", new Object[] { Integer.valueOf(locali.field_status) });
              }
            }
          }
        }
      }
      for (j = 1;; j = m)
      {
        break;
        k = 0;
        label1166:
        if (m != 0)
        {
          ab.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.pYr.field_localId), Long.valueOf(this.pYr.field_msgId), Integer.valueOf(this.pYr.field_type) });
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.pYr, new String[] { "localId" });
        }
        if (k == 0)
        {
          ab.i("MicroMsg.RecordMsgSendService", "doSendContinue without cdn task");
          this.pYR.b(this.pYr, false);
          this.pYR.pYu = false;
          this.pYR.a(null, false);
        }
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(135724);
        return;
        i = j;
      }
      label1328:
      i = k;
      break label290;
      label1333:
      m = j;
      k = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.q.a
 * JD-Core Version:    0.7.0.1
 */