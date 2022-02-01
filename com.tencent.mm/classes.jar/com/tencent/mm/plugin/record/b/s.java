package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.e.a;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bv;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
  implements com.tencent.mm.ak.f, com.tencent.mm.plugin.record.a.d, com.tencent.mm.plugin.record.a.i
{
  boolean xGJ;
  SparseArray<e> xGM;
  LinkedList<com.tencent.mm.plugin.record.a.k> xGN;
  private int xHi;
  
  public s()
  {
    AppMethodBeat.i(9572);
    this.xGJ = false;
    this.xGM = new SparseArray();
    this.xGN = new LinkedList();
    this.xHi = 7;
    com.tencent.mm.kernel.g.ajQ().gDv.a(632, this);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    try
    {
      this.xHi = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCX, 7);
      AppMethodBeat.o(9572);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.RecordMsgSendService", localException, "RecordMsgSendService init error.", new Object[0]);
      AppMethodBeat.o(9572);
    }
  }
  
  private boolean a(j paramj, ajx paramajx, int paramInt)
  {
    AppMethodBeat.i(9581);
    com.tencent.mm.protocal.b.a.c localc = p.awG(paramajx.GAK);
    if (localc == null)
    {
      ae.i("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() msgData == null");
      AppMethodBeat.o(9581);
      return false;
    }
    boolean bool = a(paramj, localc.hFT, paramInt + 1);
    ae.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramajx.aQc(p.a(localc, paramajx.GAK));
    }
    AppMethodBeat.o(9581);
    return bool;
  }
  
  private boolean a(j paramj, List<ajx> paramList, int paramInt)
  {
    AppMethodBeat.i(9580);
    paramList = paramList.iterator();
    boolean bool1 = false;
    ajx localajx;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label229;
        }
        localajx = (ajx)paramList.next();
        int i = localajx.dataType;
        ae.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localajx.dua, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = a(paramj, localajx, paramInt);
      }
    } while (!paramj.field_dataId.equals(p.eR(p.aha(localajx.dua), paramInt)));
    ae.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localajx.Gzw, paramj.field_cdnKey, localajx.hCS, paramj.field_cdnUrl, Long.valueOf(localajx.GAg), Integer.valueOf(paramj.field_totalLen) });
    localajx.aPF(paramj.field_cdnKey);
    localajx.aPE(paramj.field_cdnUrl);
    if (!bu.jB(paramInt, 1)) {
      localajx.aPP(p.dm(localajx.toString(), localajx.dataType));
    }
    boolean bool2 = true;
    label229:
    AppMethodBeat.o(9580);
    return bool2;
  }
  
  private boolean b(j paramj, ajx paramajx, int paramInt)
  {
    AppMethodBeat.i(9583);
    com.tencent.mm.protocal.b.a.c localc = p.awG(paramajx.GAK);
    if (localc == null)
    {
      ae.i("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() msgData == null");
      AppMethodBeat.o(9583);
      return false;
    }
    boolean bool = b(paramj, localc.hFT, paramInt + 1);
    ae.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramajx.aQc(p.a(localc, paramajx.GAK));
    }
    AppMethodBeat.o(9583);
    return bool;
  }
  
  private boolean b(j paramj, List<ajx> paramList, int paramInt)
  {
    AppMethodBeat.i(9582);
    paramList = paramList.iterator();
    boolean bool1 = false;
    ajx localajx;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label228;
        }
        localajx = (ajx)paramList.next();
        int i = localajx.dataType;
        ae.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localajx.dua, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = b(paramj, localajx, paramInt);
      }
    } while (!paramj.field_dataId.equals(p.eR(localajx.dua, paramInt)));
    ae.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localajx.GzC, paramj.field_cdnKey, localajx.GzA, paramj.field_cdnUrl, Long.valueOf(localajx.GzV), Integer.valueOf(paramj.field_totalLen) });
    localajx.aPH(paramj.field_cdnKey);
    localajx.aPG(paramj.field_cdnUrl);
    if (!bu.jB(paramInt, 1)) {
      localajx.aPP(p.dm(localajx.toString(), localajx.dataType));
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
      ae.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(9579);
      return;
    }
    if (paramj == null)
    {
      ae.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
      AppMethodBeat.o(9579);
      return;
    }
    if (2 != paramj.field_type)
    {
      ae.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload , mediaid:%s, recordLocalId:%d, status:%d", new Object[] { paramj.field_mediaId, Integer.valueOf(paramj.field_recordLocalId), Integer.valueOf(paramj.field_status) });
      AppMethodBeat.o(9579);
      return;
    }
    if ((paramj.field_status == 0) || (1 == paramj.field_status) || (-1 == paramj.field_status))
    {
      ae.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
      AppMethodBeat.o(9579);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().Oe(paramj.field_recordLocalId);
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (j)((Iterator)localObject2).next();
      if ((((j)localObject3).field_status == 0) || (1 == ((j)localObject3).field_status) || (-1 == ((j)localObject3).field_status)) {
        ae.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[] { ((j)localObject3).field_mediaId });
      }
    }
    for (paramInt = 0;; paramInt = 1)
    {
      ae.i("MicroMsg.RecordMsgSendService", "on cdn storage changed cdnInfoList.size:%d,", new Object[] { Integer.valueOf(((List)localObject1).size()) });
      if (paramInt == 0)
      {
        AppMethodBeat.o(9579);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Og(paramj.field_recordLocalId);
      paramInt = paramj.field_recordLocalId;
      boolean bool;
      if (localObject2 != null)
      {
        bool = true;
        ae.i("MicroMsg.RecordMsgSendService", "finish get record info, id %d result %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (localObject2 != null)
        {
          paramj = ((com.tencent.mm.plugin.record.a.k)localObject2).field_dataProto.oeJ;
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
          ae.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", new Object[] { localj.field_dataId, Boolean.valueOf(localj.field_isThumb) });
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
      this.xGJ = false;
      a(null, false);
      AppMethodBeat.o(9579);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.record.a.k paramk)
  {
    AppMethodBeat.i(224264);
    a(paramk, false);
    AppMethodBeat.o(224264);
  }
  
  public final void a(final com.tencent.mm.plugin.record.a.k paramk, final boolean paramBoolean)
  {
    AppMethodBeat.i(9574);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9551);
        if (paramk != null)
        {
          if ((s.e)s.this.xGM.get(paramk.field_localId) == null)
          {
            ae.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[] { Integer.valueOf(paramk.field_localId), Long.valueOf(paramk.field_msgId) });
            localObject1 = new s.e((byte)0);
            s.this.xGM.put(paramk.field_localId, localObject1);
          }
          s.this.b(paramk);
        }
        s locals = s.this;
        boolean bool = paramBoolean;
        if (locals.xGJ)
        {
          ae.i("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
          AppMethodBeat.o(9551);
          return;
        }
        if (locals.xGN.isEmpty())
        {
          ae.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
          localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().dHy().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.record.a.k)((Iterator)localObject1).next();
            if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(((com.tencent.mm.plugin.record.a.k)localObject2).field_msgId).getType() != 49)
            {
              ae.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId), Long.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_msgId) });
              ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Of(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId);
            }
            else
            {
              localObject3 = (s.e)locals.xGM.get(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId);
              if (localObject3 != null)
              {
                if ((((s.e)localObject3).iQA < 0) && (SystemClock.elapsedRealtime() - ((s.e)localObject3).xGQ < 300000L)) {
                  continue;
                }
                if (((s.e)localObject3).iQA < 0) {
                  ((s.e)localObject3).iQA = 3;
                }
              }
              for (;;)
              {
                ae.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId), Long.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_msgId) });
                locals.b((com.tencent.mm.plugin.record.a.k)localObject2);
                break;
                localObject3 = new s.e((byte)0);
                locals.xGM.put(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId, localObject3);
              }
            }
          }
        }
        if (locals.xGN.isEmpty())
        {
          ae.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
          locals.finish();
          AppMethodBeat.o(9551);
          return;
        }
        Object localObject3 = (com.tencent.mm.plugin.record.a.k)locals.xGN.removeFirst();
        Object localObject2 = (s.e)locals.xGM.get(((com.tencent.mm.plugin.record.a.k)localObject3).field_localId);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new s.e((byte)0);
          locals.xGM.put(((com.tencent.mm.plugin.record.a.k)localObject3).field_localId, localObject1);
        }
        ((s.e)localObject1).iQA -= 1;
        int i;
        if (((s.e)localObject1).iQA < 0) {
          if (300000L > SystemClock.elapsedRealtime() - ((s.e)localObject1).xGQ) {
            i = 0;
          }
        }
        while (i != 0)
        {
          locals.xGJ = true;
          switch (((com.tencent.mm.plugin.record.a.k)localObject3).field_type)
          {
          default: 
            locals.xGJ = false;
            AppMethodBeat.o(9551);
            return;
            ((s.e)localObject1).iQA = 2;
            ((s.e)localObject1).xGQ = SystemClock.elapsedRealtime();
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
    if (!this.xGN.contains(paramk)) {
      this.xGN.add(paramk);
    }
    AppMethodBeat.o(9575);
  }
  
  final void b(com.tencent.mm.plugin.record.a.k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(9584);
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramk.field_msgId);
    ae.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d, afterCdnUpload %s, toUser:%s", new Object[] { Boolean.FALSE, Long.valueOf(localbv.field_msgId), Long.valueOf(paramk.field_msgId), Integer.valueOf(paramk.field_localId), Boolean.valueOf(paramBoolean), paramk.field_toUser });
    if (localbv.field_msgId == paramk.field_msgId)
    {
      localbv.setContent(p.a(paramk.field_title, paramk.field_desc, paramk.field_dataProto, paramk.field_favFrom, paramk.field_msgId));
      localbv.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramk.field_msgId, localbv);
    }
    com.tencent.mm.ah.k localk = com.tencent.mm.plugin.s.a.dBh().yb(paramk.field_msgId);
    if (localk != null)
    {
      localk.field_xml = localbv.field_content;
      com.tencent.mm.plugin.s.a.dBh().update(localk, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Of(paramk.field_localId);
    this.xGM.remove(paramk.field_localId);
    if (localbv.field_createTime + this.xHi * 24 * 3600 * 1000 < ch.aDb())
    {
      ae.i("MicroMsg.RecordMsgSendService", "doSendContinue, out of wait time, " + localbv.field_createTime);
      localbv.setStatus(5);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramk.field_msgId, localbv);
      AppMethodBeat.o(9584);
      return;
    }
    if (!p.a(paramk.field_toUser, paramk.field_msgId, true, "")) {
      ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.g.class)).zb(paramk.field_msgId);
    }
    AppMethodBeat.o(9584);
  }
  
  final void e(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(9578);
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramLong);
    if (localbv.field_msgId == paramLong)
    {
      localbv.setContent(paramString);
      localbv.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramLong, localbv);
    }
    paramString = com.tencent.mm.plugin.s.a.dBh().yb(paramLong);
    if (paramString != null)
    {
      paramString.field_xml = localbv.field_content;
      com.tencent.mm.plugin.s.a.dBh().update(paramString, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Of(paramInt);
    this.xGM.remove(paramInt);
    ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.g.class)).zb(paramLong);
    ae.i("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(9578);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(9576);
    this.xGN.clear();
    this.xGM.clear();
    this.xGJ = false;
    AppMethodBeat.o(9576);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(9577);
    ae.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ae.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
      AppMethodBeat.o(9577);
      return;
    }
    switch (paramn.getType())
    {
    default: 
      this.xGJ = false;
      a(null, false);
      AppMethodBeat.o(9577);
      return;
    }
    ae.i("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (g)paramn;
    int k = paramInt1;
    int i = paramInt2;
    ajx localajx;
    if (paramInt1 == 3)
    {
      paramn = paramString.xGG.field_dataProto.oeJ.iterator();
      do
      {
        if (!paramn.hasNext()) {
          break;
        }
        localajx = (ajx)paramn.next();
      } while ((bu.isNullOrNil(localajx.GzA)) && (bu.isNullOrNil(localajx.hCS)));
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
        e(paramString.xGG.field_msgId, paramString.xGG.field_localId, paramString.xGF);
        break;
      }
      ae.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[] { Long.valueOf(paramString.xGG.field_msgId), Integer.valueOf(paramString.xGG.field_localId) });
      ae.w("MicroMsg.RecordMsgSendService", "try upload from local");
      paramn = paramString.xGG.field_dataProto.oeJ.iterator();
      while (paramn.hasNext())
      {
        localajx = (ajx)paramn.next();
        String str;
        Object localObject;
        boolean bool;
        if (localajx.GzV > 0L)
        {
          str = p.g(localajx.dua, paramString.xGG.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF(str) == null)
          {
            localObject = new j();
            ((j)localObject).field_cdnKey = localajx.GzC;
            ((j)localObject).field_cdnUrl = localajx.GzA;
            ((j)localObject).field_dataId = localajx.dua;
            ((j)localObject).field_mediaId = str;
            ((j)localObject).field_totalLen = ((int)localajx.GzV);
            ((j)localObject).field_localId = ((j)localObject).field_mediaId.hashCode();
            ((j)localObject).field_path = p.c(localajx, paramString.xGG.field_msgId);
            ((j)localObject).field_type = 2;
            ((j)localObject).field_fileType = p.hh(localajx.dataType, (int)localajx.GzV);
            ((j)localObject).field_recordLocalId = paramString.xGG.field_localId;
            ((j)localObject).field_toUser = paramString.xGG.field_toUser;
            ((j)localObject).field_isThumb = false;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject);
            ae.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(((j)localObject).field_localId), Boolean.valueOf(bool) });
          }
        }
        if (localajx.GAg > 0L)
        {
          str = p.aha(localajx.dua);
          localObject = p.g(str, paramString.xGG.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF((String)localObject) == null)
          {
            j localj = new j();
            localj.field_cdnKey = localajx.Gzw;
            localj.field_cdnUrl = localajx.hCS;
            localj.field_dataId = str;
            localj.field_mediaId = ((String)localObject);
            localj.field_totalLen = ((int)localajx.GAg);
            localj.field_localId = localj.field_mediaId.hashCode();
            localj.field_path = p.f(localajx, paramString.xGG.field_msgId);
            localj.field_type = 2;
            localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            localj.field_recordLocalId = paramString.xGG.field_localId;
            localj.field_toUser = paramString.xGG.field_toUser;
            localj.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
            ae.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
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
    private com.tencent.mm.plugin.record.a.k xGG;
    
    public a(com.tencent.mm.plugin.record.a.k paramk)
    {
      this.xGG = paramk;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9553);
      int m = 0;
      int i = 0;
      ae.i("MicroMsg.RecordMsgSendService", "dojob ChatDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.xGG.field_msgId) });
      int j;
      int k;
      ajx localajx;
      Object localObject1;
      Object localObject2;
      boolean bool;
      if ((this.xGG != null) && (this.xGG.field_dataProto != null) && (this.xGG.field_dataProto.oeJ != null))
      {
        Iterator localIterator = this.xGG.field_dataProto.oeJ.iterator();
        j = 0;
        m = i;
        k = j;
        if (!localIterator.hasNext()) {
          break label1167;
        }
        localajx = (ajx)localIterator.next();
        if ((bu.isNullOrNil(localajx.GzA)) && (!com.tencent.mm.vfs.o.fB(localajx.GzY))) {
          break label1335;
        }
        localObject1 = localajx.GzY;
        localObject2 = p.c(localajx, this.xGG.field_msgId);
        if (com.tencent.mm.vfs.o.mF((String)localObject1, (String)localObject2) > 0L)
        {
          bool = true;
          label167:
          ae.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[] { localajx.GzA, localObject1, localObject2, Boolean.valueOf(bool) });
          k = i;
          if (!bool) {
            break label1330;
          }
          if (bu.isNullOrNil(localajx.GzR))
          {
            ae.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
            localajx.aPN(com.tencent.mm.vfs.o.aRh((String)localObject2));
            i = 1;
          }
          k = i;
          if (!bu.isNullOrNil(localajx.GzT)) {
            break label1330;
          }
          ae.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
          localObject1 = com.tencent.mm.vfs.o.bb((String)localObject2, 0, 256);
          if (localObject1 != null) {
            break label990;
          }
          localObject1 = null;
          label281:
          localajx.aPO((String)localObject1);
          i = 1;
          label291:
          if (com.tencent.mm.vfs.o.aZR((String)localObject2) != 0L) {
            localajx.De(com.tencent.mm.vfs.o.aZR((String)localObject2));
          }
          localObject1 = p.g(localajx.dua, this.xGG.field_msgId, false);
          localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF((String)localObject1);
          if (localObject2 != null) {
            break label1000;
          }
          localObject2 = new j();
          ((j)localObject2).field_cdnKey = localajx.GzC;
          ((j)localObject2).field_cdnUrl = localajx.GzA;
          ((j)localObject2).field_dataId = localajx.dua;
          ((j)localObject2).field_mediaId = ((String)localObject1);
          ((j)localObject2).field_totalLen = ((int)localajx.GzV);
          ((j)localObject2).field_localId = ((j)localObject2).field_mediaId.hashCode();
          ((j)localObject2).field_path = p.c(localajx, this.xGG.field_msgId);
          ((j)localObject2).field_type = 2;
          ((j)localObject2).field_fileType = p.hh(localajx.dataType, (int)localajx.GzV);
          ((j)localObject2).field_recordLocalId = this.xGG.field_localId;
          ((j)localObject2).field_toUser = this.xGG.field_toUser;
          ((j)localObject2).field_isThumb = false;
          bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject2);
          m = 1;
          ae.i("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[] { Integer.valueOf(((j)localObject2).field_localId), Boolean.valueOf(bool), Integer.valueOf(((j)localObject2).field_fileType), localObject1 });
          k = i;
        }
      }
      for (;;)
      {
        label572:
        if (bu.isNullOrNil(localajx.hCS))
        {
          j = k;
          if (!com.tencent.mm.vfs.o.fB(localajx.GAa)) {}
        }
        else
        {
          localObject1 = localajx.GAa;
          localObject2 = p.f(localajx, this.xGG.field_msgId);
          if (com.tencent.mm.vfs.o.mF((String)localObject1, (String)localObject2) > 0L) {}
          j localj;
          for (bool = true;; bool = false)
          {
            ae.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
            localajx.Df(com.tencent.mm.vfs.o.aZR((String)localObject2));
            i = k;
            if (bool)
            {
              i = k;
              if (bu.isNullOrNil(localajx.GAc))
              {
                ae.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                localajx.aPS(com.tencent.mm.vfs.o.aRh((String)localObject2));
                i = 1;
              }
              if (bu.isNullOrNil(localajx.GAe))
              {
                ae.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                localajx.aPT(com.tencent.mm.b.g.eu((String)localObject2));
                i = 1;
              }
            }
            localObject1 = p.aha(localajx.dua);
            localObject2 = p.g((String)localObject1, this.xGG.field_msgId, false);
            localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF((String)localObject2);
            if (localj != null) {
              break label1093;
            }
            localj = new j();
            localj.field_cdnKey = localajx.Gzw;
            localj.field_cdnUrl = localajx.hCS;
            localj.field_dataId = ((String)localObject1);
            localj.field_mediaId = ((String)localObject2);
            localj.field_totalLen = ((int)localajx.GAg);
            localj.field_localId = localj.field_mediaId.hashCode();
            localj.field_path = p.f(localajx, this.xGG.field_msgId);
            localj.field_type = 2;
            localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            localj.field_recordLocalId = this.xGG.field_localId;
            localj.field_toUser = this.xGG.field_toUser;
            localj.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
            ae.i("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
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
            ae.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, cdnInfo status:%s", new Object[] { Integer.valueOf(((j)localObject2).field_status) });
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
                  ae.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, thumb cdnInfo status:%s", new Object[] { Integer.valueOf(localj.field_status) });
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
            ae.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.xGG.field_localId), Long.valueOf(this.xGG.field_msgId), Integer.valueOf(this.xGG.field_type) });
            ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.xGG, new String[] { "localId" });
          }
          if (k == 0)
          {
            ae.i("MicroMsg.RecordMsgSendService", "doSendContinue without cdn task");
            s.this.b(this.xGG, false);
            s.this.xGJ = false;
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
    implements com.tencent.mm.ak.f, t.a, Runnable
  {
    private boolean cQF;
    private int i;
    private com.tencent.mm.plugin.record.a.k xGG;
    HashMap<Long, Boolean> xHc;
    HashMap<Long, String> xHm;
    
    public b(com.tencent.mm.plugin.record.a.k paramk)
    {
      AppMethodBeat.i(9556);
      this.i = 0;
      this.xHc = new HashMap();
      this.xHm = new HashMap();
      this.cQF = false;
      this.xGG = paramk;
      com.tencent.mm.modelvideo.o.aNh().a(this, Looper.getMainLooper());
      com.tencent.mm.kernel.g.ajQ().gDv.a(221, this);
      AppMethodBeat.o(9556);
    }
    
    private void a(HashMap<Long, Boolean> paramHashMap, boolean paramBoolean, com.tencent.mm.plugin.record.a.k paramk)
    {
      AppMethodBeat.i(9561);
      if ((l(paramHashMap)) && (paramBoolean))
      {
        com.tencent.mm.modelvideo.o.aNh().a(this);
        paramk.field_type = 2;
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(paramk, new String[] { "localId" });
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramk);
      }
      AppMethodBeat.o(9561);
    }
    
    private void az(bv parambv)
    {
      AppMethodBeat.i(9560);
      Object localObject = k.b.zb(parambv.field_content);
      if (localObject == null)
      {
        ae.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[] { parambv.field_content });
        AppMethodBeat.o(9560);
        return;
      }
      if ((bu.isNullOrNil(((k.b)localObject).dlu)) && (!bu.isNullOrNil(((k.b)localObject).hCR)))
      {
        ae.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[] { parambv.field_content });
        ((k.b)localObject).dlu = ((k.b)localObject).hCR.hashCode();
      }
      localObject = ((k.b)localObject).dlu;
      if (!a.a(parambv, a.r((String)localObject, parambv.field_msgId)))
      {
        this.xHc.put(Long.valueOf(parambv.field_msgId), Boolean.FALSE);
        this.xHm.put(Long.valueOf(parambv.field_msgId), localObject);
        a.az(parambv);
      }
      AppMethodBeat.o(9560);
    }
    
    private static boolean l(HashMap<Long, Boolean> paramHashMap)
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
      parama = u.Ia(parama.fileName);
      if (parama != null)
      {
        bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(parama.iwZ);
        if (parama.aNw())
        {
          this.xHc.put(Long.valueOf(localbv.field_msgId), Boolean.TRUE);
          a(this.xHc, this.cQF, this.xGG);
        }
        AppMethodBeat.o(9558);
        return;
      }
      a(null, this.cQF, this.xGG);
      AppMethodBeat.o(9558);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(9559);
      if ((paramn instanceof f))
      {
        com.tencent.mm.kernel.g.ajQ().gDv.b(221, this);
        if (this.xHm != null) {
          paramn = this.xHm.entrySet().iterator();
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
          if ((l <= 0L) || (((Boolean)this.xHc.get(Long.valueOf(l))).booleanValue())) {
            continue;
          }
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(l);
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
          this.xHc.put(Long.valueOf(l), Boolean.TRUE);
          paramString = this.xGG.field_dataProto.oeJ.iterator();
          while (paramString.hasNext())
          {
            ajx localajx = (ajx)paramString.next();
            if (localajx.GAG == l) {
              localajx.aPQ(localc.field_fileFullPath);
            }
          }
          break;
          a(this.xHc, this.cQF, this.xGG);
          AppMethodBeat.o(9559);
          return;
          a(null, this.cQF, this.xGG);
          AppMethodBeat.o(9559);
          return;
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(9557);
      this.i = 0;
      this.cQF = false;
      ae.i("MicroMsg.RecordMsgSendService", "dojob ChatDataDownloadRunnable, info id:%s", new Object[] { Long.valueOf(this.xGG.field_msgId) });
      if (this.xGG.field_dataProto == null)
      {
        ae.w("MicroMsg.RecordMsgSendService", "ChatDataDownloadRunnable info.field_dataProto null");
        this.cQF = true;
        s.this.xGJ = false;
        a(null, this.cQF, this.xGG);
        AppMethodBeat.o(9557);
        return;
      }
      Iterator localIterator = this.xGG.field_dataProto.oeJ.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (ajx)localIterator.next();
        final long l = ((ajx)localObject1).GAG;
        label443:
        if (l > 0L)
        {
          final bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(l);
          Object localObject2 = ((ajx)localObject1).GzY;
          if ((System.currentTimeMillis() - localbv.field_createTime > 259200000L) && ((bu.isNullOrNil((String)localObject2)) || (!com.tencent.mm.vfs.o.fB((String)localObject2)))) {}
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              break label239;
            }
            ae.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", new Object[] { Integer.valueOf(localbv.getType()) });
            break;
          }
          label239:
          if (((ajx)localObject1).dataType == 2)
          {
            if (localbv.ftg())
            {
              localObject2 = com.tencent.mm.av.q.aIX().F(localbv.field_talker, localbv.field_msgSvrId);
              if (localbv.field_isSend == 1) {
                if (((com.tencent.mm.av.g)localObject2).aIB()) {
                  j = 1;
                }
              }
              for (;;)
              {
                if ((((com.tencent.mm.av.g)localObject2).offset >= ((com.tencent.mm.av.g)localObject2).hPI) && (((com.tencent.mm.av.g)localObject2).hPI != 0)) {
                  break label443;
                }
                this.xHc.put(Long.valueOf(l), Boolean.FALSE);
                this.i = this.xGG.field_dataProto.oeJ.indexOf(localObject1);
                com.tencent.mm.av.q.aIY().a(((com.tencent.mm.av.g)localObject2).doE, localbv.field_msgId, j, localObject1, 2131231564, new e.a()
                {
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
                  {
                    AppMethodBeat.i(9555);
                    s.b.this.xHc.put(Long.valueOf(l), Boolean.TRUE);
                    s.b.a(s.b.this, s.b.this.xHc, s.b.c(s.b.this), s.b.b(s.b.this));
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
                      ae.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                      if (!(paramAnonymousObject instanceof ajx)) {
                        break label303;
                      }
                      paramAnonymousObject = (ajx)paramAnonymousObject;
                      paramAnonymousObject.aPQ(com.tencent.mm.av.q.aIX().o(com.tencent.mm.av.h.c(this.iel), "", ""));
                      paramAnonymousObject.aPR(com.tencent.mm.av.q.aIX().R(localbv.field_imgPath, true));
                      paramAnonymousString = bx.M(this.iel.icA, "msg");
                      if (paramAnonymousString == null) {
                        break label279;
                      }
                      paramAnonymousObject.aPG((String)paramAnonymousString.get(".msg.img.$cdnbigimgurl"));
                      paramAnonymousObject.De(bu.getInt((String)paramAnonymousString.get(".msg.img.$length"), 0));
                      paramAnonymousObject.aPH((String)paramAnonymousString.get(".msg.img.$aeskey"));
                      s.b.b(s.b.this).field_dataProto.oeJ.set(s.b.a(s.b.this), paramAnonymousObject);
                      label216:
                      s.b.this.xHc.put(Long.valueOf(paramAnonymousObject.GAG), Boolean.TRUE);
                    }
                    for (;;)
                    {
                      s.b.a(s.b.this, s.b.this.xHc, s.b.c(s.b.this), s.b.b(s.b.this));
                      AppMethodBeat.o(9554);
                      return;
                      bool = false;
                      break;
                      label279:
                      ae.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", new Object[] { this.iel.icA });
                      break label216;
                      label303:
                      s.b.this.xHc.put(Long.valueOf(l), Boolean.TRUE);
                    }
                  }
                });
                break;
                j = 0;
                continue;
                if (!((com.tencent.mm.av.g)localObject2).aIB())
                {
                  j = 0;
                }
                else
                {
                  com.tencent.mm.av.g localg = com.tencent.mm.av.h.a((com.tencent.mm.av.g)localObject2);
                  if (!com.tencent.mm.vfs.o.fB(com.tencent.mm.av.q.aIX().o(localg.ico, "", ""))) {
                    j = 0;
                  } else {
                    j = 1;
                  }
                }
              }
            }
            else if (localbv.fvK())
            {
              az(localbv);
            }
          }
          else if ((((ajx)localObject1).dataType == 4) || (((ajx)localObject1).dataType == 15))
          {
            localObject1 = u.Ia(localbv.field_imgPath);
            if ((localObject1 != null) && (((com.tencent.mm.modelvideo.s)localObject1).status != 199))
            {
              this.xHc.put(Long.valueOf(l), Boolean.FALSE);
              if (((com.tencent.mm.modelvideo.s)localObject1).aNv())
              {
                ae.i("MicroMsg.RecordMsgSendService", "start complete online video");
                u.Ih(localbv.field_imgPath);
              }
              else
              {
                ae.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                u.HV(localbv.field_imgPath);
              }
            }
          }
          else if ((((ajx)localObject1).dataType == 8) && (!bu.isNullOrNil(((ajx)localObject1).GAS)))
          {
            az(localbv);
          }
        }
      }
      this.cQF = true;
      s.this.xGJ = false;
      a(this.xHc, this.cQF, this.xGG);
      AppMethodBeat.o(9557);
    }
  }
  
  final class c
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k xGG;
    
    public c(com.tencent.mm.plugin.record.a.k paramk)
    {
      this.xGG = paramk;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9564);
      ae.i("MicroMsg.RecordMsgSendService", "dojob FavDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.xGG.field_msgId) });
      Object localObject = this.xGG.field_dataProto.oeJ.iterator();
      for (int i = 0; ((Iterator)localObject).hasNext(); i = 1)
      {
        label46:
        ajx localajx = (ajx)((Iterator)localObject).next();
        gx localgx = new gx();
        localgx.dub.type = 2;
        localgx.dub.dud = localajx;
        com.tencent.mm.sdk.b.a.IvT.l(localgx);
        ae.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[] { localajx.dua, Integer.valueOf(localajx.dataType) });
        String str;
        if (!bu.isNullOrNil(localgx.duc.path))
        {
          str = p.c(localajx, this.xGG.field_msgId);
          ae.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[] { localgx.duc.path, str });
          if (!localgx.duc.path.equals(str)) {
            com.tencent.mm.vfs.o.mF(localgx.duc.path, str);
          }
        }
        if (!bu.isNullOrNil(localgx.duc.thumbPath))
        {
          str = p.f(localajx, this.xGG.field_msgId);
          ae.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[] { localgx.duc.thumbPath, str });
          if (!localgx.duc.thumbPath.equals(str)) {
            com.tencent.mm.vfs.o.mF(localgx.duc.thumbPath, str);
          }
        }
        if (localajx.dataType == 3)
        {
          ae.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
          localajx.aPH("");
          localajx.aPG("");
          localajx.aPF("");
          localajx.aPE("");
        }
        if ((bu.isNullOrNil(localajx.GzA)) && (bu.isNullOrNil(localajx.hCS))) {
          break label46;
        }
      }
      if (i != 0)
      {
        com.tencent.mm.kernel.g.ajQ().gDv.a(new g(this.xGG), 0);
        AppMethodBeat.o(9564);
        return;
      }
      localObject = k.b.a(p.a(this.xGG.field_title, this.xGG.field_desc, this.xGG.field_dataProto), null, null);
      s.this.e(this.xGG.field_msgId, this.xGG.field_localId, (String)localObject);
      s.this.xGJ = false;
      s.this.a(null, false);
      AppMethodBeat.o(9564);
    }
  }
  
  final class d
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k xGG;
    private boolean xHp;
    
    public d(com.tencent.mm.plugin.record.a.k paramk, boolean paramBoolean)
    {
      this.xGG = paramk;
      this.xHp = paramBoolean;
    }
    
    private byte a(ajx paramajx, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(9568);
      int k = 0;
      int j = 0;
      int i = 0;
      int m = paramajx.dataType;
      byte b1;
      if ((paramBoolean) && (m == 17))
      {
        ae.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() inner record");
        paramajx = p.awG(paramajx.GAK);
        if (paramajx == null)
        {
          AppMethodBeat.o(9568);
          return 0;
        }
        paramajx = paramajx.hFT.iterator();
        for (b1 = 0; paramajx.hasNext(); b1 = (byte)(i | b1))
        {
          i = a((ajx)paramajx.next(), paramInt + 1, paramBoolean);
          ae.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable circleTraverseFavDataItem() %s result:%s ", new Object[] { Long.toBinaryString(i), Long.toBinaryString((byte)(i | b1)) });
        }
        AppMethodBeat.o(9568);
        return b1;
      }
      String str1;
      String str2;
      if ((!bu.isNullOrNil(paramajx.GzA)) || (!bu.isNullOrNil(paramajx.GAS)))
      {
        str1 = p.a(paramajx, this.xGG.field_oriMsgId, paramInt);
        str2 = p.a(paramajx, this.xGG.field_msgId, paramInt);
        if (com.tencent.mm.vfs.o.mF(str1, str2) <= 0L) {
          break label1059;
        }
        paramBoolean = true;
        ae.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          if (!bu.isNullOrNil(paramajx.GzR)) {
            break label1232;
          }
          ae.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
          paramajx.aPN(com.tencent.mm.vfs.o.aRh(str2));
        }
      }
      label689:
      label1213:
      label1232:
      for (i = 1;; i = 0)
      {
        if (bu.isNullOrNil(paramajx.GzT))
        {
          ae.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
          paramajx.aPO(com.tencent.mm.b.g.eu(str2));
        }
        for (j = 1;; j = i)
        {
          str2 = p.eR(paramajx.dua, paramInt);
          str1 = p.g(str2, this.xGG.field_msgId, false);
          Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF(str1);
          j localj;
          if (localObject == null)
          {
            localObject = new j();
            ((j)localObject).field_cdnKey = paramajx.GzC;
            ((j)localObject).field_cdnUrl = paramajx.GzA;
            ((j)localObject).field_dataId = str2;
            ((j)localObject).field_mediaId = str1;
            ((j)localObject).field_totalLen = ((int)paramajx.GzV);
            ((j)localObject).field_localId = ((j)localObject).field_mediaId.hashCode();
            ((j)localObject).field_path = p.a(paramajx, this.xGG.field_msgId, paramInt);
            ((j)localObject).field_type = 2;
            ((j)localObject).field_fileType = p.hh(paramajx.dataType, (int)paramajx.GzV);
            ((j)localObject).field_recordLocalId = this.xGG.field_localId;
            ((j)localObject).field_toUser = this.xGG.field_toUser;
            ((j)localObject).field_isThumb = false;
            str2 = p.a(paramajx, this.xGG.field_msgId, paramInt);
            if ((!bu.isNullOrNil(paramajx.GAS)) && (!com.tencent.mm.vfs.o.fB(str2)))
            {
              ((j)localObject).field_status = -1;
              a(paramajx, str2, str1);
            }
            i = 1;
            paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject);
            ae.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(((j)localObject).field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(((j)localObject).field_recordLocalId), ((j)localObject).field_dataId, ((j)localObject).field_mediaId });
            k = j;
            if (bu.isNullOrNil(paramajx.hCS))
            {
              j = i;
              if (bu.isNullOrNil(paramajx.hCJ)) {}
            }
            else
            {
              str1 = p.b(paramajx, this.xGG.field_oriMsgId, paramInt);
              str2 = p.b(paramajx, this.xGG.field_msgId, paramInt);
              if (com.tencent.mm.vfs.o.mF(str1, str2) <= 0L) {
                break label1136;
              }
              paramBoolean = true;
              ae.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
              str1 = p.eR(p.aha(paramajx.dua), paramInt);
              str2 = p.g(str1, this.xGG.field_msgId, false);
              localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF(str2);
              localObject = p.b(paramajx, this.xGG.field_msgId, paramInt);
              if (localj != null) {
                break label1141;
              }
              localj = new j();
              localj.field_cdnKey = paramajx.Gzw;
              localj.field_cdnUrl = paramajx.hCS;
              localj.field_dataId = str1;
              localj.field_mediaId = str2;
              localj.field_totalLen = ((int)paramajx.GAg);
              localj.field_localId = localj.field_mediaId.hashCode();
              localj.field_path = p.b(paramajx, this.xGG.field_msgId, paramInt);
              localj.field_type = 2;
              localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
              localj.field_recordLocalId = this.xGG.field_localId;
              localj.field_toUser = this.xGG.field_toUser;
              localj.field_isThumb = true;
              if ((!bu.isNullOrNil(paramajx.hCJ)) && (!com.tencent.mm.vfs.o.fB((String)localObject)))
              {
                localj.field_status = -1;
                b(paramajx, (String)localObject, str2);
              }
              j = 1;
              paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
              ae.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(localj.field_recordLocalId), localj.field_dataId, localj.field_mediaId });
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
            a(paramajx, p.a(paramajx, this.xGG.field_msgId, paramInt), str1);
          }
          for (i = 1;; i = 0)
          {
            if (((j)localObject).field_status == 0) {
              i = 1;
            }
            ae.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(((j)localObject).field_status) });
            k = j;
            break;
            label1136:
            paramBoolean = false;
            break label689;
            label1141:
            if (localj.field_status == -1)
            {
              b(paramajx, p.b(paramajx, this.xGG.field_msgId, paramInt), str2);
              i = 1;
            }
            if (localj.field_status == 0) {
              i = 1;
            }
            ae.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(localj.field_status) });
            j = i;
            break label1026;
            b1 = 0;
            break label1034;
          }
        }
      }
    }
    
    private void a(final ajx paramajx, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9569);
      ae.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", new Object[] { paramajx.dua, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.fLl = "task_RecordMsgSendService_1";
      localg.field_fileType = 19;
      localg.field_authKey = paramajx.hCO;
      localg.field_aesKey = paramajx.GAP;
      localg.fLp = paramajx.GAS;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.fLm = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9565);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              ae.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl done id:%s, mediaId:%s, path:%s", new Object[] { paramajx.dua, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramajx.dua;
                localObject = paramString1;
                if (paramAnonymousd != null) {
                  break label279;
                }
                i = 0;
                ae.e("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl error id:%s, mediaId:%s, path:%s, err:(%d,%d)", new Object[] { paramAnonymousc, paramAnonymousString, localObject, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramajx.dua;
                  String str = paramString1;
                  if (paramAnonymousd == null) {}
                  for (i = 0;; i = paramAnonymousd.field_retCode)
                  {
                    ae.e("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl error id:%s, mediaId:%s, tempMediaId:%s, path:%s, err:(%d,%d), cdnInfo==null", new Object[] { localObject, paramAnonymousString, paramAnonymousc, str, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
        if (!com.tencent.mm.an.f.aGZ().b(localg, -1)) {
          ae.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
        }
        AppMethodBeat.o(9569);
        return;
        paramString2 = paramString2 + "_tp";
      }
    }
    
    private void b(final ajx paramajx, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9570);
      ae.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramajx.dua, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.fLl = "task_RecordMsgSendService_2";
      localg.field_fileType = 19;
      localg.field_authKey = paramajx.hCO;
      localg.field_aesKey = paramajx.hCP;
      localg.fLp = paramajx.hCJ;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.fLm = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9566);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              ae.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramajx.dua, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramajx.dua;
                localObject = paramString1;
                if (paramAnonymousd != null) {
                  break label279;
                }
                i = 0;
                ae.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, thumbPath:%s err:(%d,%d)", new Object[] { paramAnonymousc, paramAnonymousString, localObject, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramajx.dua;
                  String str = paramString1;
                  if (paramAnonymousd == null) {}
                  for (i = 0;; i = paramAnonymousd.field_retCode)
                  {
                    ae.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, tempMediaId:%s, thumbPath:%s err:(%d,%d)", new Object[] { localObject, paramAnonymousString, paramAnonymousc, str, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
        if (!com.tencent.mm.an.f.aGZ().b(localg, -1)) {
          ae.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
        }
        AppMethodBeat.o(9570);
        return;
        paramString2 = paramString2 + "_tp";
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(9567);
      if (this.xGG.field_dataProto == null)
      {
        ae.w("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable info.field_dataProto null");
        s.this.xGJ = false;
        AppMethodBeat.o(9567);
        return;
      }
      Iterator localIterator = this.xGG.field_dataProto.oeJ.iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      if (localIterator.hasNext())
      {
        int i = a((ajx)localIterator.next(), 1, this.xHp);
        ae.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() state: %s ", new Object[] { Long.toBinaryString(i) });
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
        ae.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable startEmbedded:%s infochanged:%s, needRun:%s", new Object[] { Boolean.valueOf(this.xHp), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (bool2)
        {
          ae.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.xGG.field_localId), Long.valueOf(this.xGG.field_msgId), Integer.valueOf(this.xGG.field_type) });
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.xGG, new String[] { "localId" });
        }
        if (!bool1)
        {
          ae.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable doSendContinue");
          s.this.b(this.xGG, false);
          s.this.xGJ = false;
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
    int iQA;
    long xGQ;
    
    private e()
    {
      AppMethodBeat.i(9571);
      this.xGQ = SystemClock.elapsedRealtime();
      this.iQA = 3;
      AppMethodBeat.o(9571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.s
 * JD-Core Version:    0.7.0.1
 */