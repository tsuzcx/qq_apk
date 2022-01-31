package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

final class q$d
  implements Runnable
{
  private boolean pYV;
  private j pYr;
  
  public q$d(q paramq, j paramj, boolean paramBoolean)
  {
    this.pYr = paramj;
    this.pYV = paramBoolean;
  }
  
  private byte a(aca paramaca, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146013);
    int k = 0;
    int j = 0;
    int i = 0;
    int m = paramaca.dataType;
    byte b1;
    if ((paramBoolean) && (m == 17))
    {
      ab.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() inner record");
      paramaca = n.XS(paramaca.wTM);
      if (paramaca == null)
      {
        AppMethodBeat.o(146013);
        return 0;
      }
      paramaca = paramaca.fjy.iterator();
      for (b1 = 0; paramaca.hasNext(); b1 = (byte)(i | b1))
      {
        i = a((aca)paramaca.next(), paramInt + 1, paramBoolean);
        ab.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable circleTraverseFavDataItem() %s result:%s ", new Object[] { Long.toBinaryString(i), Long.toBinaryString((byte)(i | b1)) });
      }
      AppMethodBeat.o(146013);
      return b1;
    }
    String str1;
    String str2;
    if ((!bo.isNullOrNil(paramaca.wSC)) || (!bo.isNullOrNil(paramaca.wTU)))
    {
      str1 = n.a(paramaca, this.pYr.field_oriMsgId, paramInt);
      str2 = n.a(paramaca, this.pYr.field_msgId, paramInt);
      if (com.tencent.mm.vfs.e.C(str1, str2) <= 0L) {
        break label1055;
      }
      paramBoolean = true;
      ab.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        if (!bo.isNullOrNil(paramaca.wST)) {
          break label1228;
        }
        ab.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
        paramaca.anB(com.tencent.mm.a.g.getMD5(str2));
      }
    }
    label686:
    label1209:
    label1228:
    for (i = 1;; i = 0)
    {
      if (bo.isNullOrNil(paramaca.wSV))
      {
        ab.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
        paramaca.anC(com.tencent.mm.a.g.cT(str2));
      }
      for (j = 1;; j = i)
      {
        str2 = n.df(paramaca.mBq, paramInt);
        str1 = n.h(str2, this.pYr.field_msgId, false);
        Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR(str1);
        i locali;
        if (localObject == null)
        {
          localObject = new i();
          ((i)localObject).field_cdnKey = paramaca.wSE;
          ((i)localObject).field_cdnUrl = paramaca.wSC;
          ((i)localObject).field_dataId = str2;
          ((i)localObject).field_mediaId = str1;
          ((i)localObject).field_totalLen = ((int)paramaca.wSX);
          ((i)localObject).field_localId = ((i)localObject).field_mediaId.hashCode();
          ((i)localObject).field_path = n.a(paramaca, this.pYr.field_msgId, paramInt);
          ((i)localObject).field_type = 2;
          ((i)localObject).field_fileType = n.fl(paramaca.dataType, (int)paramaca.wSX);
          ((i)localObject).field_recordLocalId = this.pYr.field_localId;
          ((i)localObject).field_toUser = this.pYr.field_toUser;
          ((i)localObject).field_isThumb = false;
          str2 = n.a(paramaca, this.pYr.field_msgId, paramInt);
          if ((!bo.isNullOrNil(paramaca.wTU)) && (!com.tencent.mm.vfs.e.cN(str2)))
          {
            ((i)localObject).field_status = -1;
            a(paramaca, str2, str1);
          }
          i = 1;
          paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((i)localObject);
          ab.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(((i)localObject).field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(((i)localObject).field_recordLocalId), ((i)localObject).field_dataId, ((i)localObject).field_mediaId });
          k = j;
          if (bo.isNullOrNil(paramaca.fgM))
          {
            j = i;
            if (bo.isNullOrNil(paramaca.fgD)) {}
          }
          else
          {
            str1 = n.b(paramaca, this.pYr.field_oriMsgId, paramInt);
            str2 = n.b(paramaca, this.pYr.field_msgId, paramInt);
            if (com.tencent.mm.vfs.e.C(str1, str2) <= 0L) {
              break label1132;
            }
            paramBoolean = true;
            ab.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
            str1 = n.df(n.Ny(paramaca.mBq), paramInt);
            str2 = n.h(str1, this.pYr.field_msgId, false);
            locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR(str2);
            localObject = n.b(paramaca, this.pYr.field_msgId, paramInt);
            if (locali != null) {
              break label1137;
            }
            locali = new i();
            locali.field_cdnKey = paramaca.wSy;
            locali.field_cdnUrl = paramaca.fgM;
            locali.field_dataId = str1;
            locali.field_mediaId = str2;
            locali.field_totalLen = ((int)paramaca.wTi);
            locali.field_localId = locali.field_mediaId.hashCode();
            locali.field_path = n.b(paramaca, this.pYr.field_msgId, paramInt);
            locali.field_type = 2;
            locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            locali.field_recordLocalId = this.pYr.field_localId;
            locali.field_toUser = this.pYr.field_toUser;
            locali.field_isThumb = true;
            if ((!bo.isNullOrNil(paramaca.fgD)) && (!com.tencent.mm.vfs.e.cN((String)localObject)))
            {
              locali.field_status = -1;
              b(paramaca, (String)localObject, str2);
            }
            j = 1;
            paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
            ab.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(locali.field_recordLocalId), locali.field_dataId, locali.field_mediaId });
          }
          label1023:
          if (k == 0) {
            break label1209;
          }
          b1 = 1;
          byte b2 = b1;
          if (j != 0) {
            b2 = (byte)(b1 | 0x2);
          }
          AppMethodBeat.o(146013);
          return b2;
          paramBoolean = false;
          break;
        }
        if (((i)localObject).field_status == -1) {
          a(paramaca, n.a(paramaca, this.pYr.field_msgId, paramInt), str1);
        }
        for (i = 1;; i = 0)
        {
          if (((i)localObject).field_status == 0) {
            i = 1;
          }
          ab.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(((i)localObject).field_status) });
          k = j;
          break;
          label1132:
          paramBoolean = false;
          break label686;
          label1137:
          if (locali.field_status == -1)
          {
            b(paramaca, n.b(paramaca, this.pYr.field_msgId, paramInt), str2);
            i = 1;
          }
          if (locali.field_status == 0) {
            i = 1;
          }
          ab.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(locali.field_status) });
          j = i;
          break label1023;
          b1 = 0;
          break label1031;
        }
      }
    }
  }
  
  private void a(aca paramaca, String paramString1, String paramString2)
  {
    AppMethodBeat.i(135739);
    ab.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", new Object[] { paramaca.mBq, paramString2, paramString1 });
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.field_fileType = 19;
    localg.field_authKey = paramaca.fgI;
    localg.field_aesKey = paramaca.wTR;
    localg.eds = paramaca.wTU;
    localg.field_fullpath = paramString1;
    localg.field_mediaId = paramString2;
    localg.edp = new q.d.1(this, paramaca, paramString1);
    if (!f.afO().b(localg, -1)) {
      ab.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
    }
    AppMethodBeat.o(135739);
  }
  
  private void b(aca paramaca, String paramString1, String paramString2)
  {
    AppMethodBeat.i(135740);
    ab.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramaca.mBq, paramString2, paramString1 });
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.field_fileType = 19;
    localg.field_authKey = paramaca.fgI;
    localg.field_aesKey = paramaca.fgJ;
    localg.eds = paramaca.fgD;
    localg.field_fullpath = paramString1;
    localg.field_mediaId = paramString2;
    localg.edp = new q.d.2(this, paramaca, paramString1);
    if (!f.afO().b(localg, -1)) {
      ab.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
    }
    AppMethodBeat.o(135740);
  }
  
  public final void run()
  {
    AppMethodBeat.i(135738);
    if (this.pYr.field_dataProto == null)
    {
      ab.w("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable info.field_dataProto null");
      this.pYR.pYu = false;
      AppMethodBeat.o(135738);
      return;
    }
    Iterator localIterator = this.pYr.field_dataProto.wVc.iterator();
    boolean bool1 = false;
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      int i = a((aca)localIterator.next(), 1, this.pYV);
      ab.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() state: %s ", new Object[] { Long.toBinaryString(i) });
      if ((i & 0x1) == 1) {
        bool2 = true;
      }
      if ((i & 0x2) != 2) {
        break label319;
      }
      bool1 = true;
    }
    label319:
    for (;;)
    {
      break;
      ab.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable startEmbedded:%s infochanged:%s, needRun:%s", new Object[] { Boolean.valueOf(this.pYV), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2)
      {
        ab.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.pYr.field_localId), Long.valueOf(this.pYr.field_msgId), Integer.valueOf(this.pYr.field_type) });
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.pYr, new String[] { "localId" });
      }
      if (!bool1)
      {
        ab.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable doSendContinue");
        this.pYR.b(this.pYr, false);
        this.pYR.pYu = false;
        this.pYR.a(null, false);
      }
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
      AppMethodBeat.o(135738);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.q.d
 * JD-Core Version:    0.7.0.1
 */