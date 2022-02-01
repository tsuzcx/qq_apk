package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
  implements com.tencent.mm.al.f, com.tencent.mm.plugin.record.a.d, com.tencent.mm.plugin.record.a.i
{
  boolean xqM;
  SparseArray<e> xqP;
  LinkedList<com.tencent.mm.plugin.record.a.k> xqQ;
  private int xrl;
  
  public s()
  {
    AppMethodBeat.i(9572);
    this.xqM = false;
    this.xqP = new SparseArray();
    this.xqQ = new LinkedList();
    this.xrl = 7;
    com.tencent.mm.kernel.g.ajB().gAO.a(632, this);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    try
    {
      this.xrl = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qvY, 7);
      AppMethodBeat.o(9572);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.RecordMsgSendService", localException, "RecordMsgSendService init error.", new Object[0]);
      AppMethodBeat.o(9572);
    }
  }
  
  private boolean a(j paramj, ajn paramajn, int paramInt)
  {
    AppMethodBeat.i(9581);
    com.tencent.mm.protocal.b.a.c localc = p.avr(paramajn.Gib);
    if (localc == null)
    {
      ad.i("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() msgData == null");
      AppMethodBeat.o(9581);
      return false;
    }
    boolean bool = a(paramj, localc.hDb, paramInt + 1);
    ad.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramajn.aOF(p.a(localc, paramajn.Gib));
    }
    AppMethodBeat.o(9581);
    return bool;
  }
  
  private boolean a(j paramj, List<ajn> paramList, int paramInt)
  {
    AppMethodBeat.i(9580);
    paramList = paramList.iterator();
    boolean bool1 = false;
    ajn localajn;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label229;
        }
        localajn = (ajn)paramList.next();
        int i = localajn.dataType;
        ad.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localajn.dsU, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = a(paramj, localajn, paramInt);
      }
    } while (!paramj.field_dataId.equals(p.eJ(p.agd(localajn.dsU), paramInt)));
    ad.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localajn.GgN, paramj.field_cdnKey, localajn.hAe, paramj.field_cdnUrl, Long.valueOf(localajn.Ghx), Integer.valueOf(paramj.field_totalLen) });
    localajn.aOi(paramj.field_cdnKey);
    localajn.aOh(paramj.field_cdnUrl);
    if (!bt.jx(paramInt, 1)) {
      localajn.aOs(p.di(localajn.toString(), localajn.dataType));
    }
    boolean bool2 = true;
    label229:
    AppMethodBeat.o(9580);
    return bool2;
  }
  
  private boolean b(j paramj, ajn paramajn, int paramInt)
  {
    AppMethodBeat.i(9583);
    com.tencent.mm.protocal.b.a.c localc = p.avr(paramajn.Gib);
    if (localc == null)
    {
      ad.i("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() msgData == null");
      AppMethodBeat.o(9583);
      return false;
    }
    boolean bool = b(paramj, localc.hDb, paramInt + 1);
    ad.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramajn.aOF(p.a(localc, paramajn.Gib));
    }
    AppMethodBeat.o(9583);
    return bool;
  }
  
  private boolean b(j paramj, List<ajn> paramList, int paramInt)
  {
    AppMethodBeat.i(9582);
    paramList = paramList.iterator();
    boolean bool1 = false;
    ajn localajn;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label228;
        }
        localajn = (ajn)paramList.next();
        int i = localajn.dataType;
        ad.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localajn.dsU, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = b(paramj, localajn, paramInt);
      }
    } while (!paramj.field_dataId.equals(p.eJ(localajn.dsU, paramInt)));
    ad.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localajn.GgT, paramj.field_cdnKey, localajn.GgR, paramj.field_cdnUrl, Long.valueOf(localajn.Ghm), Integer.valueOf(paramj.field_totalLen) });
    localajn.aOk(paramj.field_cdnKey);
    localajn.aOj(paramj.field_cdnUrl);
    if (!bt.jx(paramInt, 1)) {
      localajn.aOs(p.di(localajn.toString(), localajn.dataType));
    }
    boolean bool2 = true;
    label228:
    AppMethodBeat.o(9582);
    return bool2;
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(9579);
    if (1 != paramInt)
    {
      ad.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(9579);
      return;
    }
    if (paramj == null)
    {
      ad.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
      AppMethodBeat.o(9579);
      return;
    }
    if (2 != paramj.field_type)
    {
      ad.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload , mediaid:%s, recordLocalId:%d, status:%d", new Object[] { paramj.field_mediaId, Integer.valueOf(paramj.field_recordLocalId), Integer.valueOf(paramj.field_status) });
      AppMethodBeat.o(9579);
      return;
    }
    if ((paramj.field_status == 0) || (1 == paramj.field_status) || (-1 == paramj.field_status))
    {
      ad.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
      AppMethodBeat.o(9579);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().Ny(paramj.field_recordLocalId);
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (j)((Iterator)localObject2).next();
      if ((((j)localObject3).field_status == 0) || (1 == ((j)localObject3).field_status) || (-1 == ((j)localObject3).field_status)) {
        ad.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[] { ((j)localObject3).field_mediaId });
      }
    }
    for (paramInt = 0;; paramInt = 1)
    {
      ad.i("MicroMsg.RecordMsgSendService", "on cdn storage changed cdnInfoList.size:%d,", new Object[] { Integer.valueOf(((List)localObject1).size()) });
      if (paramInt == 0)
      {
        AppMethodBeat.o(9579);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().NA(paramj.field_recordLocalId);
      paramInt = paramj.field_recordLocalId;
      boolean bool;
      if (localObject2 != null)
      {
        bool = true;
        ad.i("MicroMsg.RecordMsgSendService", "finish get record info, id %d result %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (localObject2 != null)
        {
          paramj = ((com.tencent.mm.plugin.record.a.k)localObject2).field_dataProto.nZa;
          localObject3 = ((List)localObject1).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label462;
          }
          j localj = (j)((Iterator)localObject3).next();
          ad.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", new Object[] { localj.field_dataId, Boolean.valueOf(localj.field_isThumb) });
          if (localj.field_isThumb)
          {
            a(localj, paramj, 1);
            continue;
            bool = false;
            break;
          }
          b(localj, paramj, 1);
        }
        label462:
        b((com.tencent.mm.plugin.record.a.k)localObject2, true);
      }
      paramj = ((List)localObject1).iterator();
      while (paramj.hasNext())
      {
        localObject1 = (j)paramj.next();
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((j)localObject1, new String[] { "localId" });
      }
      this.xqM = false;
      a(null, false);
      AppMethodBeat.o(9579);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.record.a.k paramk)
  {
    AppMethodBeat.i(221619);
    a(paramk, false);
    AppMethodBeat.o(221619);
  }
  
  public final void a(final com.tencent.mm.plugin.record.a.k paramk, final boolean paramBoolean)
  {
    AppMethodBeat.i(9574);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9551);
        if (paramk != null)
        {
          if ((s.e)s.this.xqP.get(paramk.field_localId) == null)
          {
            ad.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[] { Integer.valueOf(paramk.field_localId), Long.valueOf(paramk.field_msgId) });
            localObject1 = new s.e((byte)0);
            s.this.xqP.put(paramk.field_localId, localObject1);
          }
          s.this.b(paramk);
        }
        s locals = s.this;
        boolean bool = paramBoolean;
        if (locals.xqM)
        {
          ad.i("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
          AppMethodBeat.o(9551);
          return;
        }
        if (locals.xqQ.isEmpty())
        {
          ad.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
          localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().dEh().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.record.a.k)((Iterator)localObject1).next();
            if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(((com.tencent.mm.plugin.record.a.k)localObject2).field_msgId).getType() != 49)
            {
              ad.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId), Long.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_msgId) });
              ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Nz(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId);
            }
            else
            {
              localObject3 = (s.e)locals.xqP.get(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId);
              if (localObject3 != null)
              {
                if ((((s.e)localObject3).iNG < 0) && (SystemClock.elapsedRealtime() - ((s.e)localObject3).xqT < 300000L)) {
                  continue;
                }
                if (((s.e)localObject3).iNG < 0) {
                  ((s.e)localObject3).iNG = 3;
                }
              }
              for (;;)
              {
                ad.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId), Long.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_msgId) });
                locals.b((com.tencent.mm.plugin.record.a.k)localObject2);
                break;
                localObject3 = new s.e((byte)0);
                locals.xqP.put(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId, localObject3);
              }
            }
          }
        }
        if (locals.xqQ.isEmpty())
        {
          ad.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
          locals.finish();
          AppMethodBeat.o(9551);
          return;
        }
        Object localObject3 = (com.tencent.mm.plugin.record.a.k)locals.xqQ.removeFirst();
        Object localObject2 = (s.e)locals.xqP.get(((com.tencent.mm.plugin.record.a.k)localObject3).field_localId);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new s.e((byte)0);
          locals.xqP.put(((com.tencent.mm.plugin.record.a.k)localObject3).field_localId, localObject1);
        }
        ((s.e)localObject1).iNG -= 1;
        int i;
        if (((s.e)localObject1).iNG < 0) {
          if (300000L > SystemClock.elapsedRealtime() - ((s.e)localObject1).xqT) {
            i = 0;
          }
        }
        while (i != 0)
        {
          locals.xqM = true;
          switch (((com.tencent.mm.plugin.record.a.k)localObject3).field_type)
          {
          default: 
            locals.xqM = false;
            AppMethodBeat.o(9551);
            return;
            ((s.e)localObject1).iNG = 2;
            ((s.e)localObject1).xqT = SystemClock.elapsedRealtime();
            i = 1;
            break;
          case 1: 
            com.tencent.mm.sdk.g.b.c(new s.c(locals, (com.tencent.mm.plugin.record.a.k)localObject3), "RecordMsgSendService_favDataCopy");
            AppMethodBeat.o(9551);
            return;
          case 2: 
            com.tencent.mm.sdk.g.b.c(new s.a(locals, (com.tencent.mm.plugin.record.a.k)localObject3), "RecordMsgSendService_chatDataCopy");
            AppMethodBeat.o(9551);
            return;
          case 0: 
            com.tencent.mm.sdk.g.b.c(new s.d(locals, (com.tencent.mm.plugin.record.a.k)localObject3, bool), "RecordMsgSendService_normalDataCopy");
            AppMethodBeat.o(9551);
            return;
          case 3: 
            com.tencent.mm.sdk.g.b.c(new s.b(locals, (com.tencent.mm.plugin.record.a.k)localObject3), "RecordMsgSendService_chatDataDownLoad");
            AppMethodBeat.o(9551);
            return;
          }
        }
        locals.a(null, false);
        AppMethodBeat.o(9551);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(9552);
        String str = super.toString() + "|run";
        AppMethodBeat.o(9552);
        return str;
      }
    });
    AppMethodBeat.o(9574);
  }
  
  final void b(com.tencent.mm.plugin.record.a.k paramk)
  {
    AppMethodBeat.i(9575);
    if (!this.xqQ.contains(paramk)) {
      this.xqQ.add(paramk);
    }
    AppMethodBeat.o(9575);
  }
  
  final void b(com.tencent.mm.plugin.record.a.k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(9584);
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramk.field_msgId);
    ad.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d, afterCdnUpload %s, toUser:%s", new Object[] { Boolean.FALSE, Long.valueOf(localbu.field_msgId), Long.valueOf(paramk.field_msgId), Integer.valueOf(paramk.field_localId), Boolean.valueOf(paramBoolean), paramk.field_toUser });
    if (localbu.field_msgId == paramk.field_msgId)
    {
      localbu.setContent(p.a(paramk.field_title, paramk.field_desc, paramk.field_dataProto, paramk.field_favFrom, paramk.field_msgId));
      localbu.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(paramk.field_msgId, localbu);
    }
    com.tencent.mm.ai.k localk = com.tencent.mm.plugin.s.a.dxR().xH(paramk.field_msgId);
    if (localk != null)
    {
      localk.field_xml = localbu.field_content;
      com.tencent.mm.plugin.s.a.dxR().update(localk, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Nz(paramk.field_localId);
    this.xqP.remove(paramk.field_localId);
    if (localbu.field_createTime + this.xrl * 24 * 3600 * 1000 < cf.aCL())
    {
      ad.i("MicroMsg.RecordMsgSendService", "doSendContinue, out of wait time, " + localbu.field_createTime);
      localbu.setStatus(5);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(paramk.field_msgId, localbu);
      AppMethodBeat.o(9584);
      return;
    }
    if (!p.a(paramk.field_toUser, paramk.field_msgId, true, "")) {
      ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.g.class)).yC(paramk.field_msgId);
    }
    AppMethodBeat.o(9584);
  }
  
  final void e(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(9578);
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramLong);
    if (localbu.field_msgId == paramLong)
    {
      localbu.setContent(paramString);
      localbu.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(paramLong, localbu);
    }
    paramString = com.tencent.mm.plugin.s.a.dxR().xH(paramLong);
    if (paramString != null)
    {
      paramString.field_xml = localbu.field_content;
      com.tencent.mm.plugin.s.a.dxR().update(paramString, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Nz(paramInt);
    this.xqP.remove(paramInt);
    ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.g.class)).yC(paramLong);
    ad.i("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(9578);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(9576);
    this.xqQ.clear();
    this.xqP.clear();
    this.xqM = false;
    AppMethodBeat.o(9576);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(9577);
    ad.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ad.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
      AppMethodBeat.o(9577);
      return;
    }
    switch (paramn.getType())
    {
    default: 
      this.xqM = false;
      a(null, false);
      AppMethodBeat.o(9577);
      return;
    }
    ad.i("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (g)paramn;
    int k = paramInt1;
    int i = paramInt2;
    ajn localajn;
    if (paramInt1 == 3)
    {
      paramn = paramString.xqJ.field_dataProto.nZa.iterator();
      do
      {
        if (!paramn.hasNext()) {
          break;
        }
        localajn = (ajn)paramn.next();
      } while ((bt.isNullOrNil(localajn.GgR)) && (bt.isNullOrNil(localajn.hAe)));
    }
    for (int j = 1;; j = 0)
    {
      k = paramInt1;
      i = paramInt2;
      if (j == 0)
      {
        k = 0;
        i = 0;
      }
      if ((k == 0) && (i == 0))
      {
        e(paramString.xqJ.field_msgId, paramString.xqJ.field_localId, paramString.xqI);
        break;
      }
      ad.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[] { Long.valueOf(paramString.xqJ.field_msgId), Integer.valueOf(paramString.xqJ.field_localId) });
      ad.w("MicroMsg.RecordMsgSendService", "try upload from local");
      paramn = paramString.xqJ.field_dataProto.nZa.iterator();
      while (paramn.hasNext())
      {
        localajn = (ajn)paramn.next();
        String str;
        Object localObject;
        boolean bool;
        if (localajn.Ghm > 0L)
        {
          str = p.g(localajn.dsU, paramString.xqJ.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq(str) == null)
          {
            localObject = new j();
            ((j)localObject).field_cdnKey = localajn.GgT;
            ((j)localObject).field_cdnUrl = localajn.GgR;
            ((j)localObject).field_dataId = localajn.dsU;
            ((j)localObject).field_mediaId = str;
            ((j)localObject).field_totalLen = ((int)localajn.Ghm);
            ((j)localObject).field_localId = ((j)localObject).field_mediaId.hashCode();
            ((j)localObject).field_path = p.c(localajn, paramString.xqJ.field_msgId);
            ((j)localObject).field_type = 2;
            ((j)localObject).field_fileType = p.hf(localajn.dataType, (int)localajn.Ghm);
            ((j)localObject).field_recordLocalId = paramString.xqJ.field_localId;
            ((j)localObject).field_toUser = paramString.xqJ.field_toUser;
            ((j)localObject).field_isThumb = false;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject);
            ad.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(((j)localObject).field_localId), Boolean.valueOf(bool) });
          }
        }
        if (localajn.Ghx > 0L)
        {
          str = p.agd(localajn.dsU);
          localObject = p.g(str, paramString.xqJ.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq((String)localObject) == null)
          {
            j localj = new j();
            localj.field_cdnKey = localajn.GgN;
            localj.field_cdnUrl = localajn.hAe;
            localj.field_dataId = str;
            localj.field_mediaId = ((String)localObject);
            localj.field_totalLen = ((int)localajn.Ghx);
            localj.field_localId = localj.field_mediaId.hashCode();
            localj.field_path = p.f(localajn, paramString.xqJ.field_msgId);
            localj.field_type = 2;
            localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            localj.field_recordLocalId = paramString.xqJ.field_localId;
            localj.field_toUser = paramString.xqJ.field_toUser;
            localj.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
            ad.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
          }
        }
      }
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
      AppMethodBeat.o(9577);
      return;
    }
  }
  
  final class a
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k xqJ;
    
    public a(com.tencent.mm.plugin.record.a.k paramk)
    {
      this.xqJ = paramk;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9553);
      int m = 0;
      int i = 0;
      ad.i("MicroMsg.RecordMsgSendService", "dojob ChatDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.xqJ.field_msgId) });
      int j;
      int k;
      ajn localajn;
      Object localObject1;
      Object localObject2;
      boolean bool;
      if ((this.xqJ != null) && (this.xqJ.field_dataProto != null) && (this.xqJ.field_dataProto.nZa != null))
      {
        Iterator localIterator = this.xqJ.field_dataProto.nZa.iterator();
        j = 0;
        m = i;
        k = j;
        if (!localIterator.hasNext()) {
          break label1167;
        }
        localajn = (ajn)localIterator.next();
        if ((bt.isNullOrNil(localajn.GgR)) && (!com.tencent.mm.vfs.i.fv(localajn.Ghp))) {
          break label1335;
        }
        localObject1 = localajn.Ghp;
        localObject2 = p.c(localajn, this.xqJ.field_msgId);
        if (com.tencent.mm.vfs.i.mz((String)localObject1, (String)localObject2) > 0L)
        {
          bool = true;
          label167:
          ad.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[] { localajn.GgR, localObject1, localObject2, Boolean.valueOf(bool) });
          k = i;
          if (!bool) {
            break label1330;
          }
          if (bt.isNullOrNil(localajn.Ghi))
          {
            ad.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
            localajn.aOq(com.tencent.mm.vfs.i.aPK((String)localObject2));
            i = 1;
          }
          k = i;
          if (!bt.isNullOrNil(localajn.Ghk)) {
            break label1330;
          }
          ad.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
          localObject1 = com.tencent.mm.vfs.i.aY((String)localObject2, 0, 256);
          if (localObject1 != null) {
            break label990;
          }
          localObject1 = null;
          label281:
          localajn.aOr((String)localObject1);
          i = 1;
          label291:
          if (com.tencent.mm.vfs.i.aYo((String)localObject2) != 0L) {
            localajn.CG(com.tencent.mm.vfs.i.aYo((String)localObject2));
          }
          localObject1 = p.g(localajn.dsU, this.xqJ.field_msgId, false);
          localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq((String)localObject1);
          if (localObject2 != null) {
            break label1000;
          }
          localObject2 = new j();
          ((j)localObject2).field_cdnKey = localajn.GgT;
          ((j)localObject2).field_cdnUrl = localajn.GgR;
          ((j)localObject2).field_dataId = localajn.dsU;
          ((j)localObject2).field_mediaId = ((String)localObject1);
          ((j)localObject2).field_totalLen = ((int)localajn.Ghm);
          ((j)localObject2).field_localId = ((j)localObject2).field_mediaId.hashCode();
          ((j)localObject2).field_path = p.c(localajn, this.xqJ.field_msgId);
          ((j)localObject2).field_type = 2;
          ((j)localObject2).field_fileType = p.hf(localajn.dataType, (int)localajn.Ghm);
          ((j)localObject2).field_recordLocalId = this.xqJ.field_localId;
          ((j)localObject2).field_toUser = this.xqJ.field_toUser;
          ((j)localObject2).field_isThumb = false;
          bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject2);
          m = 1;
          ad.i("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[] { Integer.valueOf(((j)localObject2).field_localId), Boolean.valueOf(bool), Integer.valueOf(((j)localObject2).field_fileType), localObject1 });
          k = i;
        }
      }
      for (;;)
      {
        label572:
        if (bt.isNullOrNil(localajn.hAe))
        {
          j = k;
          if (!com.tencent.mm.vfs.i.fv(localajn.Ghr)) {}
        }
        else
        {
          localObject1 = localajn.Ghr;
          localObject2 = p.f(localajn, this.xqJ.field_msgId);
          if (com.tencent.mm.vfs.i.mz((String)localObject1, (String)localObject2) > 0L) {}
          j localj;
          for (bool = true;; bool = false)
          {
            ad.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
            localajn.CH(com.tencent.mm.vfs.i.aYo((String)localObject2));
            i = k;
            if (bool)
            {
              i = k;
              if (bt.isNullOrNil(localajn.Ght))
              {
                ad.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                localajn.aOv(com.tencent.mm.vfs.i.aPK((String)localObject2));
                i = 1;
              }
              if (bt.isNullOrNil(localajn.Ghv))
              {
                ad.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                localajn.aOw(com.tencent.mm.b.g.ep((String)localObject2));
                i = 1;
              }
            }
            localObject1 = p.agd(localajn.dsU);
            localObject2 = p.g((String)localObject1, this.xqJ.field_msgId, false);
            localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq((String)localObject2);
            if (localj != null) {
              break label1093;
            }
            localj = new j();
            localj.field_cdnKey = localajn.GgN;
            localj.field_cdnUrl = localajn.hAe;
            localj.field_dataId = ((String)localObject1);
            localj.field_mediaId = ((String)localObject2);
            localj.field_totalLen = ((int)localajn.Ghx);
            localj.field_localId = localj.field_mediaId.hashCode();
            localj.field_path = p.f(localajn, this.xqJ.field_msgId);
            localj.field_type = 2;
            localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            localj.field_recordLocalId = this.xqJ.field_localId;
            localj.field_toUser = this.xqJ.field_toUser;
            localj.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
            ad.i("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
            j = 1;
            break;
            bool = false;
            break label167;
            label990:
            localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
            break label281;
            label1000:
            m = j;
            k = i;
            if (((j)localObject2).field_status == 2) {
              break label572;
            }
            m = j;
            k = i;
            if (((j)localObject2).field_status == 3) {
              break label572;
            }
            m = j;
            k = i;
            if (((j)localObject2).field_status == 4) {
              break label572;
            }
            m = j;
            k = i;
            if (((j)localObject2).field_status == -1) {
              break label572;
            }
            ad.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, cdnInfo status:%s", new Object[] { Integer.valueOf(((j)localObject2).field_status) });
            m = 1;
            k = i;
            break label572;
          }
          label1093:
          j = i;
          if (localj.field_status != 2)
          {
            j = i;
            if (localj.field_status != 3)
            {
              j = i;
              if (localj.field_status != 4)
              {
                j = i;
                if (localj.field_status != -1) {
                  ad.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, thumb cdnInfo status:%s", new Object[] { Integer.valueOf(localj.field_status) });
                }
              }
            }
          }
        }
        for (j = 1;; j = m)
        {
          break;
          k = 0;
          label1167:
          if (m != 0)
          {
            ad.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.xqJ.field_localId), Long.valueOf(this.xqJ.field_msgId), Integer.valueOf(this.xqJ.field_type) });
            ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.xqJ, new String[] { "localId" });
          }
          if (k == 0)
          {
            ad.i("MicroMsg.RecordMsgSendService", "doSendContinue without cdn task");
            s.this.b(this.xqJ, false);
            s.this.xqM = false;
            s.this.a(null, false);
          }
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
          AppMethodBeat.o(9553);
          return;
          i = j;
        }
        label1330:
        i = k;
        break label291;
        label1335:
        m = j;
        k = i;
      }
    }
  }
  
  final class b
    implements com.tencent.mm.al.f, t.a, Runnable
  {
    private boolean cPV;
    private int i;
    private com.tencent.mm.plugin.record.a.k xqJ;
    HashMap<Long, Boolean> xrf;
    HashMap<Long, String> xrp;
    
    public b(com.tencent.mm.plugin.record.a.k paramk)
    {
      AppMethodBeat.i(9556);
      this.i = 0;
      this.xrf = new HashMap();
      this.xrp = new HashMap();
      this.cPV = false;
      this.xqJ = paramk;
      o.aMJ().a(this, Looper.getMainLooper());
      com.tencent.mm.kernel.g.ajB().gAO.a(221, this);
      AppMethodBeat.o(9556);
    }
    
    private void a(HashMap<Long, Boolean> paramHashMap, boolean paramBoolean, com.tencent.mm.plugin.record.a.k paramk)
    {
      AppMethodBeat.i(9561);
      if ((k(paramHashMap)) && (paramBoolean))
      {
        o.aMJ().a(this);
        paramk.field_type = 2;
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(paramk, new String[] { "localId" });
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramk);
      }
      AppMethodBeat.o(9561);
    }
    
    private void aA(bu parambu)
    {
      AppMethodBeat.i(9560);
      Object localObject = k.b.yr(parambu.field_content);
      if (localObject == null)
      {
        ad.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[] { parambu.field_content });
        AppMethodBeat.o(9560);
        return;
      }
      if ((bt.isNullOrNil(((k.b)localObject).dks)) && (!bt.isNullOrNil(((k.b)localObject).hAd)))
      {
        ad.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[] { parambu.field_content });
        ((k.b)localObject).dks = ((k.b)localObject).hAd.hashCode();
      }
      localObject = ((k.b)localObject).dks;
      if (!a.a(parambu, a.r((String)localObject, parambu.field_msgId)))
      {
        this.xrf.put(Long.valueOf(parambu.field_msgId), Boolean.FALSE);
        this.xrp.put(Long.valueOf(parambu.field_msgId), localObject);
        a.aA(parambu);
      }
      AppMethodBeat.o(9560);
    }
    
    private static boolean k(HashMap<Long, Boolean> paramHashMap)
    {
      AppMethodBeat.i(9562);
      if (paramHashMap == null)
      {
        AppMethodBeat.o(9562);
        return true;
      }
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext()) {
        if (!((Boolean)((Map.Entry)paramHashMap.next()).getValue()).booleanValue())
        {
          AppMethodBeat.o(9562);
          return false;
        }
      }
      AppMethodBeat.o(9562);
      return true;
    }
    
    public final void a(t.a.a parama)
    {
      AppMethodBeat.i(9558);
      parama = u.Hy(parama.fileName);
      if (parama != null)
      {
        bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(parama.iuf);
        if (parama.aMY())
        {
          this.xrf.put(Long.valueOf(localbu.field_msgId), Boolean.TRUE);
          a(this.xrf, this.cPV, this.xqJ);
        }
        AppMethodBeat.o(9558);
        return;
      }
      a(null, this.cPV, this.xqJ);
      AppMethodBeat.o(9558);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(9559);
      if ((paramn instanceof f))
      {
        com.tencent.mm.kernel.g.ajB().gAO.b(221, this);
        if (this.xrp != null) {
          paramn = this.xrp.entrySet().iterator();
        }
      }
      label291:
      label294:
      for (;;)
      {
        long l;
        com.tencent.mm.pluginsdk.model.app.c localc;
        if (paramn.hasNext())
        {
          paramString = (Map.Entry)paramn.next();
          l = ((Long)paramString.getKey()).longValue();
          paramString = (String)paramString.getValue();
          if ((l <= 0L) || (((Boolean)this.xrf.get(Long.valueOf(l))).booleanValue())) {
            continue;
          }
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(l);
          localc = a.r(paramString, l);
          if (localc == null) {
            break label291;
          }
        }
        for (paramString = localc.field_fileFullPath;; paramString = null)
        {
          if ((paramString == null) || (paramString.length() <= 0)) {
            break label294;
          }
          this.xrf.put(Long.valueOf(l), Boolean.TRUE);
          paramString = this.xqJ.field_dataProto.nZa.iterator();
          while (paramString.hasNext())
          {
            ajn localajn = (ajn)paramString.next();
            if (localajn.GhX == l) {
              localajn.aOt(localc.field_fileFullPath);
            }
          }
          break;
          a(this.xrf, this.cPV, this.xqJ);
          AppMethodBeat.o(9559);
          return;
          a(null, this.cPV, this.xqJ);
          AppMethodBeat.o(9559);
          return;
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(9557);
      this.i = 0;
      this.cPV = false;
      ad.i("MicroMsg.RecordMsgSendService", "dojob ChatDataDownloadRunnable, info id:%s", new Object[] { Long.valueOf(this.xqJ.field_msgId) });
      if (this.xqJ.field_dataProto == null)
      {
        ad.w("MicroMsg.RecordMsgSendService", "ChatDataDownloadRunnable info.field_dataProto null");
        this.cPV = true;
        s.this.xqM = false;
        a(null, this.cPV, this.xqJ);
        AppMethodBeat.o(9557);
        return;
      }
      Iterator localIterator = this.xqJ.field_dataProto.nZa.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (ajn)localIterator.next();
        final long l = ((ajn)localObject1).GhX;
        label443:
        if (l > 0L)
        {
          final bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(l);
          Object localObject2 = ((ajn)localObject1).Ghp;
          if ((System.currentTimeMillis() - localbu.field_createTime > 259200000L) && ((bt.isNullOrNil((String)localObject2)) || (!com.tencent.mm.vfs.i.fv((String)localObject2)))) {}
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              break label239;
            }
            ad.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", new Object[] { Integer.valueOf(localbu.getType()) });
            break;
          }
          label239:
          if (((ajn)localObject1).dataType == 2)
          {
            if (localbu.fpi())
            {
              localObject2 = com.tencent.mm.aw.q.aIF().F(localbu.field_talker, localbu.field_msgSvrId);
              if (localbu.field_isSend == 1) {
                if (((com.tencent.mm.aw.g)localObject2).aIj()) {
                  j = 1;
                }
              }
              for (;;)
              {
                if ((((com.tencent.mm.aw.g)localObject2).offset >= ((com.tencent.mm.aw.g)localObject2).hMP) && (((com.tencent.mm.aw.g)localObject2).hMP != 0)) {
                  break label443;
                }
                this.xrf.put(Long.valueOf(l), Boolean.FALSE);
                this.i = this.xqJ.field_dataProto.nZa.indexOf(localObject1);
                com.tencent.mm.aw.q.aIG().a(((com.tencent.mm.aw.g)localObject2).dnz, localbu.field_msgId, j, localObject1, 2131231564, new e.a()
                {
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
                  {
                    AppMethodBeat.i(9555);
                    s.b.this.xrf.put(Long.valueOf(l), Boolean.TRUE);
                    s.b.a(s.b.this, s.b.this.xrf, s.b.c(s.b.this), s.b.b(s.b.this));
                    AppMethodBeat.o(9555);
                  }
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, n paramAnonymousn) {}
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, n paramAnonymousn)
                  {
                    AppMethodBeat.i(9554);
                    boolean bool;
                    if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0))
                    {
                      bool = true;
                      ad.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                      if (!(paramAnonymousObject instanceof ajn)) {
                        break label303;
                      }
                      paramAnonymousObject = (ajn)paramAnonymousObject;
                      paramAnonymousObject.aOt(com.tencent.mm.aw.q.aIF().o(com.tencent.mm.aw.h.c(this.ibs), "", ""));
                      paramAnonymousObject.aOu(com.tencent.mm.aw.q.aIF().R(localbu.field_imgPath, true));
                      paramAnonymousString = bw.M(this.ibs.hZI, "msg");
                      if (paramAnonymousString == null) {
                        break label279;
                      }
                      paramAnonymousObject.aOj((String)paramAnonymousString.get(".msg.img.$cdnbigimgurl"));
                      paramAnonymousObject.CG(bt.getInt((String)paramAnonymousString.get(".msg.img.$length"), 0));
                      paramAnonymousObject.aOk((String)paramAnonymousString.get(".msg.img.$aeskey"));
                      s.b.b(s.b.this).field_dataProto.nZa.set(s.b.a(s.b.this), paramAnonymousObject);
                      label216:
                      s.b.this.xrf.put(Long.valueOf(paramAnonymousObject.GhX), Boolean.TRUE);
                    }
                    for (;;)
                    {
                      s.b.a(s.b.this, s.b.this.xrf, s.b.c(s.b.this), s.b.b(s.b.this));
                      AppMethodBeat.o(9554);
                      return;
                      bool = false;
                      break;
                      label279:
                      ad.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", new Object[] { this.ibs.hZI });
                      break label216;
                      label303:
                      s.b.this.xrf.put(Long.valueOf(l), Boolean.TRUE);
                    }
                  }
                });
                break;
                j = 0;
                continue;
                if (!((com.tencent.mm.aw.g)localObject2).aIj())
                {
                  j = 0;
                }
                else
                {
                  com.tencent.mm.aw.g localg = com.tencent.mm.aw.h.a((com.tencent.mm.aw.g)localObject2);
                  if (!com.tencent.mm.vfs.i.fv(com.tencent.mm.aw.q.aIF().o(localg.hZw, "", ""))) {
                    j = 0;
                  } else {
                    j = 1;
                  }
                }
              }
            }
            else if (localbu.frK())
            {
              aA(localbu);
            }
          }
          else if ((((ajn)localObject1).dataType == 4) || (((ajn)localObject1).dataType == 15))
          {
            localObject1 = u.Hy(localbu.field_imgPath);
            if ((localObject1 != null) && (((com.tencent.mm.modelvideo.s)localObject1).status != 199))
            {
              this.xrf.put(Long.valueOf(l), Boolean.FALSE);
              if (((com.tencent.mm.modelvideo.s)localObject1).aMX())
              {
                ad.i("MicroMsg.RecordMsgSendService", "start complete online video");
                u.HF(localbu.field_imgPath);
              }
              else
              {
                ad.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                u.Ht(localbu.field_imgPath);
              }
            }
          }
          else if ((((ajn)localObject1).dataType == 8) && (!bt.isNullOrNil(((ajn)localObject1).Gij)))
          {
            aA(localbu);
          }
        }
      }
      this.cPV = true;
      s.this.xqM = false;
      a(this.xrf, this.cPV, this.xqJ);
      AppMethodBeat.o(9557);
    }
  }
  
  final class c
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k xqJ;
    
    public c(com.tencent.mm.plugin.record.a.k paramk)
    {
      this.xqJ = paramk;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9564);
      ad.i("MicroMsg.RecordMsgSendService", "dojob FavDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.xqJ.field_msgId) });
      Object localObject = this.xqJ.field_dataProto.nZa.iterator();
      for (int i = 0; ((Iterator)localObject).hasNext(); i = 1)
      {
        label46:
        ajn localajn = (ajn)((Iterator)localObject).next();
        gw localgw = new gw();
        localgw.dsV.type = 2;
        localgw.dsV.dsX = localajn;
        com.tencent.mm.sdk.b.a.IbL.l(localgw);
        ad.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[] { localajn.dsU, Integer.valueOf(localajn.dataType) });
        String str;
        if (!bt.isNullOrNil(localgw.dsW.path))
        {
          str = p.c(localajn, this.xqJ.field_msgId);
          ad.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[] { localgw.dsW.path, str });
          if (!localgw.dsW.path.equals(str)) {
            com.tencent.mm.vfs.i.mz(localgw.dsW.path, str);
          }
        }
        if (!bt.isNullOrNil(localgw.dsW.thumbPath))
        {
          str = p.f(localajn, this.xqJ.field_msgId);
          ad.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[] { localgw.dsW.thumbPath, str });
          if (!localgw.dsW.thumbPath.equals(str)) {
            com.tencent.mm.vfs.i.mz(localgw.dsW.thumbPath, str);
          }
        }
        if (localajn.dataType == 3)
        {
          ad.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
          localajn.aOk("");
          localajn.aOj("");
          localajn.aOi("");
          localajn.aOh("");
        }
        if ((bt.isNullOrNil(localajn.GgR)) && (bt.isNullOrNil(localajn.hAe))) {
          break label46;
        }
      }
      if (i != 0)
      {
        com.tencent.mm.kernel.g.ajB().gAO.a(new g(this.xqJ), 0);
        AppMethodBeat.o(9564);
        return;
      }
      localObject = k.b.a(p.a(this.xqJ.field_title, this.xqJ.field_desc, this.xqJ.field_dataProto), null, null);
      s.this.e(this.xqJ.field_msgId, this.xqJ.field_localId, (String)localObject);
      s.this.xqM = false;
      s.this.a(null, false);
      AppMethodBeat.o(9564);
    }
  }
  
  final class d
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k xqJ;
    private boolean xrs;
    
    public d(com.tencent.mm.plugin.record.a.k paramk, boolean paramBoolean)
    {
      this.xqJ = paramk;
      this.xrs = paramBoolean;
    }
    
    private byte a(ajn paramajn, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(9568);
      int k = 0;
      int j = 0;
      int i = 0;
      int m = paramajn.dataType;
      byte b1;
      if ((paramBoolean) && (m == 17))
      {
        ad.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() inner record");
        paramajn = p.avr(paramajn.Gib);
        if (paramajn == null)
        {
          AppMethodBeat.o(9568);
          return 0;
        }
        paramajn = paramajn.hDb.iterator();
        for (b1 = 0; paramajn.hasNext(); b1 = (byte)(i | b1))
        {
          i = a((ajn)paramajn.next(), paramInt + 1, paramBoolean);
          ad.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable circleTraverseFavDataItem() %s result:%s ", new Object[] { Long.toBinaryString(i), Long.toBinaryString((byte)(i | b1)) });
        }
        AppMethodBeat.o(9568);
        return b1;
      }
      String str1;
      String str2;
      if ((!bt.isNullOrNil(paramajn.GgR)) || (!bt.isNullOrNil(paramajn.Gij)))
      {
        str1 = p.a(paramajn, this.xqJ.field_oriMsgId, paramInt);
        str2 = p.a(paramajn, this.xqJ.field_msgId, paramInt);
        if (com.tencent.mm.vfs.i.mz(str1, str2) <= 0L) {
          break label1059;
        }
        paramBoolean = true;
        ad.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          if (!bt.isNullOrNil(paramajn.Ghi)) {
            break label1232;
          }
          ad.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
          paramajn.aOq(com.tencent.mm.vfs.i.aPK(str2));
        }
      }
      label689:
      label1213:
      label1232:
      for (i = 1;; i = 0)
      {
        if (bt.isNullOrNil(paramajn.Ghk))
        {
          ad.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
          paramajn.aOr(com.tencent.mm.b.g.ep(str2));
        }
        for (j = 1;; j = i)
        {
          str2 = p.eJ(paramajn.dsU, paramInt);
          str1 = p.g(str2, this.xqJ.field_msgId, false);
          Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq(str1);
          j localj;
          if (localObject == null)
          {
            localObject = new j();
            ((j)localObject).field_cdnKey = paramajn.GgT;
            ((j)localObject).field_cdnUrl = paramajn.GgR;
            ((j)localObject).field_dataId = str2;
            ((j)localObject).field_mediaId = str1;
            ((j)localObject).field_totalLen = ((int)paramajn.Ghm);
            ((j)localObject).field_localId = ((j)localObject).field_mediaId.hashCode();
            ((j)localObject).field_path = p.a(paramajn, this.xqJ.field_msgId, paramInt);
            ((j)localObject).field_type = 2;
            ((j)localObject).field_fileType = p.hf(paramajn.dataType, (int)paramajn.Ghm);
            ((j)localObject).field_recordLocalId = this.xqJ.field_localId;
            ((j)localObject).field_toUser = this.xqJ.field_toUser;
            ((j)localObject).field_isThumb = false;
            str2 = p.a(paramajn, this.xqJ.field_msgId, paramInt);
            if ((!bt.isNullOrNil(paramajn.Gij)) && (!com.tencent.mm.vfs.i.fv(str2)))
            {
              ((j)localObject).field_status = -1;
              a(paramajn, str2, str1);
            }
            i = 1;
            paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject);
            ad.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(((j)localObject).field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(((j)localObject).field_recordLocalId), ((j)localObject).field_dataId, ((j)localObject).field_mediaId });
            k = j;
            if (bt.isNullOrNil(paramajn.hAe))
            {
              j = i;
              if (bt.isNullOrNil(paramajn.hzV)) {}
            }
            else
            {
              str1 = p.b(paramajn, this.xqJ.field_oriMsgId, paramInt);
              str2 = p.b(paramajn, this.xqJ.field_msgId, paramInt);
              if (com.tencent.mm.vfs.i.mz(str1, str2) <= 0L) {
                break label1136;
              }
              paramBoolean = true;
              ad.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
              str1 = p.eJ(p.agd(paramajn.dsU), paramInt);
              str2 = p.g(str1, this.xqJ.field_msgId, false);
              localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq(str2);
              localObject = p.b(paramajn, this.xqJ.field_msgId, paramInt);
              if (localj != null) {
                break label1141;
              }
              localj = new j();
              localj.field_cdnKey = paramajn.GgN;
              localj.field_cdnUrl = paramajn.hAe;
              localj.field_dataId = str1;
              localj.field_mediaId = str2;
              localj.field_totalLen = ((int)paramajn.Ghx);
              localj.field_localId = localj.field_mediaId.hashCode();
              localj.field_path = p.b(paramajn, this.xqJ.field_msgId, paramInt);
              localj.field_type = 2;
              localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
              localj.field_recordLocalId = this.xqJ.field_localId;
              localj.field_toUser = this.xqJ.field_toUser;
              localj.field_isThumb = true;
              if ((!bt.isNullOrNil(paramajn.hzV)) && (!com.tencent.mm.vfs.i.fv((String)localObject)))
              {
                localj.field_status = -1;
                b(paramajn, (String)localObject, str2);
              }
              j = 1;
              paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
              ad.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(localj.field_recordLocalId), localj.field_dataId, localj.field_mediaId });
            }
            if (k == 0) {
              break label1213;
            }
            b1 = 1;
            byte b2 = b1;
            if (j != 0) {
              b2 = (byte)(b1 | 0x2);
            }
            AppMethodBeat.o(9568);
            return b2;
            paramBoolean = false;
            break;
          }
          if (((j)localObject).field_status == -1) {
            a(paramajn, p.a(paramajn, this.xqJ.field_msgId, paramInt), str1);
          }
          for (i = 1;; i = 0)
          {
            if (((j)localObject).field_status == 0) {
              i = 1;
            }
            ad.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(((j)localObject).field_status) });
            k = j;
            break;
            label1136:
            paramBoolean = false;
            break label689;
            label1141:
            if (localj.field_status == -1)
            {
              b(paramajn, p.b(paramajn, this.xqJ.field_msgId, paramInt), str2);
              i = 1;
            }
            if (localj.field_status == 0) {
              i = 1;
            }
            ad.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(localj.field_status) });
            j = i;
            break label1026;
            b1 = 0;
            break label1034;
          }
        }
      }
    }
    
    private void a(final ajn paramajn, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9569);
      ad.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", new Object[] { paramajn.dsU, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.fJi = "task_RecordMsgSendService_1";
      localg.field_fileType = 19;
      localg.field_authKey = paramajn.hAa;
      localg.field_aesKey = paramajn.Gig;
      localg.fJm = paramajn.Gij;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.fJj = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9565);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              ad.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl done id:%s, mediaId:%s, path:%s", new Object[] { paramajn.dsU, paramAnonymousString, paramString1 });
            }
            for (int i = 1;; i = 0)
            {
              int j;
              Object localObject;
              if (paramAnonymousInt == 0)
              {
                j = i;
                if (paramAnonymousd != null)
                {
                  j = i;
                  if (paramAnonymousd.field_retCode == 0) {}
                }
              }
              else
              {
                paramAnonymousc = paramajn.dsU;
                localObject = paramString1;
                if (paramAnonymousd != null) {
                  break label279;
                }
                i = 0;
                ad.e("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl error id:%s, mediaId:%s, path:%s, err:(%d,%d)", new Object[] { paramAnonymousc, paramAnonymousString, localObject, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
                j = 1;
              }
              if (j != 0) {
                if ((paramAnonymousString == null) || (!paramAnonymousString.endsWith("_tp"))) {
                  break label352;
                }
              }
              label279:
              label352:
              for (paramAnonymousc = paramAnonymousString.substring(0, paramAnonymousString.length() - 3);; paramAnonymousc = paramAnonymousString)
              {
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramajn.dsU;
                  String str = paramString1;
                  if (paramAnonymousd == null) {}
                  for (i = 0;; i = paramAnonymousd.field_retCode)
                  {
                    ad.e("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl error id:%s, mediaId:%s, tempMediaId:%s, path:%s, err:(%d,%d), cdnInfo==null", new Object[] { localObject, paramAnonymousString, paramAnonymousc, str, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
                    AppMethodBeat.o(9565);
                    return 0;
                    i = paramAnonymousd.field_retCode;
                    break;
                  }
                }
                ((j)localObject).field_status = 0;
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((j)localObject);
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
                AppMethodBeat.o(9565);
                return 0;
              }
            }
          }
          
          public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
          
          public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
          {
            return new byte[0];
          }
        };
        if (!com.tencent.mm.ao.f.aGI().b(localg, -1)) {
          ad.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
        }
        AppMethodBeat.o(9569);
        return;
        paramString2 = paramString2 + "_tp";
      }
    }
    
    private void b(final ajn paramajn, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9570);
      ad.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramajn.dsU, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.fJi = "task_RecordMsgSendService_2";
      localg.field_fileType = 19;
      localg.field_authKey = paramajn.hAa;
      localg.field_aesKey = paramajn.hAb;
      localg.fJm = paramajn.hzV;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.fJj = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9566);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              ad.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramajn.dsU, paramAnonymousString, paramString1 });
            }
            for (int i = 1;; i = 0)
            {
              int j;
              Object localObject;
              if (paramAnonymousInt == 0)
              {
                j = i;
                if (paramAnonymousd != null)
                {
                  j = i;
                  if (paramAnonymousd.field_retCode == 0) {}
                }
              }
              else
              {
                paramAnonymousc = paramajn.dsU;
                localObject = paramString1;
                if (paramAnonymousd != null) {
                  break label279;
                }
                i = 0;
                ad.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, thumbPath:%s err:(%d,%d)", new Object[] { paramAnonymousc, paramAnonymousString, localObject, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
                j = 1;
              }
              if (j != 0) {
                if ((paramAnonymousString == null) || (!paramAnonymousString.endsWith("_tp"))) {
                  break label352;
                }
              }
              label279:
              label352:
              for (paramAnonymousc = paramAnonymousString.substring(0, paramAnonymousString.length() - 3);; paramAnonymousc = paramAnonymousString)
              {
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramajn.dsU;
                  String str = paramString1;
                  if (paramAnonymousd == null) {}
                  for (i = 0;; i = paramAnonymousd.field_retCode)
                  {
                    ad.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, tempMediaId:%s, thumbPath:%s err:(%d,%d)", new Object[] { localObject, paramAnonymousString, paramAnonymousc, str, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
                    AppMethodBeat.o(9566);
                    return 0;
                    i = paramAnonymousd.field_retCode;
                    break;
                  }
                }
                ((j)localObject).field_status = 0;
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((j)localObject);
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
                AppMethodBeat.o(9566);
                return 0;
              }
            }
          }
          
          public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
          
          public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
          {
            return new byte[0];
          }
        };
        if (!com.tencent.mm.ao.f.aGI().b(localg, -1)) {
          ad.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
        }
        AppMethodBeat.o(9570);
        return;
        paramString2 = paramString2 + "_tp";
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(9567);
      if (this.xqJ.field_dataProto == null)
      {
        ad.w("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable info.field_dataProto null");
        s.this.xqM = false;
        AppMethodBeat.o(9567);
        return;
      }
      Iterator localIterator = this.xqJ.field_dataProto.nZa.iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      if (localIterator.hasNext())
      {
        int i = a((ajn)localIterator.next(), 1, this.xrs);
        ad.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() state: %s ", new Object[] { Long.toBinaryString(i) });
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
        ad.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable startEmbedded:%s infochanged:%s, needRun:%s", new Object[] { Boolean.valueOf(this.xrs), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (bool2)
        {
          ad.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.xqJ.field_localId), Long.valueOf(this.xqJ.field_msgId), Integer.valueOf(this.xqJ.field_type) });
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.xqJ, new String[] { "localId" });
        }
        if (!bool1)
        {
          ad.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable doSendContinue");
          s.this.b(this.xqJ, false);
          s.this.xqM = false;
          s.this.a(null, false);
        }
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9567);
        return;
      }
    }
  }
  
  static final class e
  {
    int iNG;
    long xqT;
    
    private e()
    {
      AppMethodBeat.i(9571);
      this.xqT = SystemClock.elapsedRealtime();
      this.iNG = 3;
      AppMethodBeat.o(9571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.s
 * JD-Core Version:    0.7.0.1
 */