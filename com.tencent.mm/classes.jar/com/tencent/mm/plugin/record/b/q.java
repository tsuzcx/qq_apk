package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.d.a;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class q
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.record.a.d, com.tencent.mm.plugin.record.a.h
{
  boolean wjb;
  SparseArray<q.e> wje;
  LinkedList<j> wjf;
  private int wjv;
  
  public q()
  {
    AppMethodBeat.i(9572);
    this.wjb = false;
    this.wje = new SparseArray();
    this.wjf = new LinkedList();
    this.wjv = 7;
    com.tencent.mm.kernel.g.agQ().ghe.a(632, this);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    try
    {
      this.wjv = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pRB, 7);
      AppMethodBeat.o(9572);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.RecordMsgSendService", localException, "RecordMsgSendService init error.", new Object[0]);
      AppMethodBeat.o(9572);
    }
  }
  
  private boolean a(com.tencent.mm.plugin.record.a.i parami, agx paramagx, int paramInt)
  {
    AppMethodBeat.i(9581);
    com.tencent.mm.protocal.b.a.c localc = n.aqs(paramagx.EAp);
    if (localc == null)
    {
      ac.i("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() msgData == null");
      AppMethodBeat.o(9581);
      return false;
    }
    boolean bool = a(parami, localc.hkS, paramInt + 1);
    ac.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramagx.aJc(n.a(localc, paramagx.EAp));
    }
    AppMethodBeat.o(9581);
    return bool;
  }
  
  private boolean a(com.tencent.mm.plugin.record.a.i parami, List<agx> paramList, int paramInt)
  {
    AppMethodBeat.i(9580);
    paramList = paramList.iterator();
    boolean bool1 = false;
    agx localagx;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label229;
        }
        localagx = (agx)paramList.next();
        int i = localagx.dataType;
        ac.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localagx.dhw, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = a(parami, localagx, paramInt);
      }
    } while (!parami.field_dataId.equals(n.eq(n.aco(localagx.dhw), paramInt)));
    ac.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localagx.Ezb, parami.field_cdnKey, localagx.hhV, parami.field_cdnUrl, Long.valueOf(localagx.EzL), Integer.valueOf(parami.field_totalLen) });
    localagx.aIF(parami.field_cdnKey);
    localagx.aIE(parami.field_cdnUrl);
    if (!bs.jl(paramInt, 1)) {
      localagx.aIP(n.cY(localagx.toString(), localagx.dataType));
    }
    boolean bool2 = true;
    label229:
    AppMethodBeat.o(9580);
    return bool2;
  }
  
  private boolean b(com.tencent.mm.plugin.record.a.i parami, agx paramagx, int paramInt)
  {
    AppMethodBeat.i(9583);
    com.tencent.mm.protocal.b.a.c localc = n.aqs(paramagx.EAp);
    if (localc == null)
    {
      ac.i("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() msgData == null");
      AppMethodBeat.o(9583);
      return false;
    }
    boolean bool = b(parami, localc.hkS, paramInt + 1);
    ac.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramagx.aJc(n.a(localc, paramagx.EAp));
    }
    AppMethodBeat.o(9583);
    return bool;
  }
  
  private boolean b(com.tencent.mm.plugin.record.a.i parami, List<agx> paramList, int paramInt)
  {
    AppMethodBeat.i(9582);
    paramList = paramList.iterator();
    boolean bool1 = false;
    agx localagx;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label228;
        }
        localagx = (agx)paramList.next();
        int i = localagx.dataType;
        ac.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localagx.dhw, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = b(parami, localagx, paramInt);
      }
    } while (!parami.field_dataId.equals(n.eq(localagx.dhw, paramInt)));
    ac.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localagx.Ezh, parami.field_cdnKey, localagx.Ezf, parami.field_cdnUrl, Long.valueOf(localagx.EzA), Integer.valueOf(parami.field_totalLen) });
    localagx.aIH(parami.field_cdnKey);
    localagx.aIG(parami.field_cdnUrl);
    if (!bs.jl(paramInt, 1)) {
      localagx.aIP(n.cY(localagx.toString(), localagx.dataType));
    }
    boolean bool2 = true;
    label228:
    AppMethodBeat.o(9582);
    return bool2;
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.i parami)
  {
    AppMethodBeat.i(9579);
    if (1 != paramInt)
    {
      ac.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(9579);
      return;
    }
    if (parami == null)
    {
      ac.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
      AppMethodBeat.o(9579);
      return;
    }
    if (2 != parami.field_type)
    {
      ac.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload , mediaid:%s, recordLocalId:%d, status:%d", new Object[] { parami.field_mediaId, Integer.valueOf(parami.field_recordLocalId), Integer.valueOf(parami.field_status) });
      AppMethodBeat.o(9579);
      return;
    }
    if ((parami.field_status == 0) || (1 == parami.field_status) || (-1 == parami.field_status))
    {
      ac.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
      AppMethodBeat.o(9579);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().LZ(parami.field_recordLocalId);
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.record.a.i)((Iterator)localObject2).next();
      if ((((com.tencent.mm.plugin.record.a.i)localObject3).field_status == 0) || (1 == ((com.tencent.mm.plugin.record.a.i)localObject3).field_status) || (-1 == ((com.tencent.mm.plugin.record.a.i)localObject3).field_status)) {
        ac.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[] { ((com.tencent.mm.plugin.record.a.i)localObject3).field_mediaId });
      }
    }
    for (paramInt = 0;; paramInt = 1)
    {
      ac.i("MicroMsg.RecordMsgSendService", "on cdn storage changed cdnInfoList.size:%d,", new Object[] { Integer.valueOf(((List)localObject1).size()) });
      if (paramInt == 0)
      {
        AppMethodBeat.o(9579);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Mb(parami.field_recordLocalId);
      paramInt = parami.field_recordLocalId;
      boolean bool;
      if (localObject2 != null)
      {
        bool = true;
        ac.i("MicroMsg.RecordMsgSendService", "finish get record info, id %d result %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (localObject2 != null)
        {
          parami = ((j)localObject2).field_dataProto.nxC;
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
          com.tencent.mm.plugin.record.a.i locali = (com.tencent.mm.plugin.record.a.i)((Iterator)localObject3).next();
          ac.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", new Object[] { locali.field_dataId, Boolean.valueOf(locali.field_isThumb) });
          if (locali.field_isThumb)
          {
            a(locali, parami, 1);
            continue;
            bool = false;
            break;
          }
          b(locali, parami, 1);
        }
        label462:
        b((j)localObject2, true);
      }
      parami = ((List)localObject1).iterator();
      while (parami.hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.record.a.i)parami.next();
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((com.tencent.mm.plugin.record.a.i)localObject1, new String[] { "localId" });
      }
      this.wjb = false;
      a(null, false);
      AppMethodBeat.o(9579);
      return;
    }
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(210014);
    a(paramj, false);
    AppMethodBeat.o(210014);
  }
  
  public final void a(final j paramj, final boolean paramBoolean)
  {
    AppMethodBeat.i(9574);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9551);
        if (paramj != null)
        {
          if ((q.e)q.this.wje.get(paramj.field_localId) == null)
          {
            ac.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[] { Integer.valueOf(paramj.field_localId), Long.valueOf(paramj.field_msgId) });
            localObject1 = new q.e((byte)0);
            q.this.wje.put(paramj.field_localId, localObject1);
          }
          q.this.b(paramj);
        }
        q localq = q.this;
        boolean bool = paramBoolean;
        if (localq.wjb)
        {
          ac.i("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
          AppMethodBeat.o(9551);
          return;
        }
        if (localq.wjf.isEmpty())
        {
          ac.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
          localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().dtK().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (j)((Iterator)localObject1).next();
            if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(((j)localObject2).field_msgId).getType() != 49)
            {
              ac.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", new Object[] { Integer.valueOf(((j)localObject2).field_localId), Long.valueOf(((j)localObject2).field_msgId) });
              ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Ma(((j)localObject2).field_localId);
            }
            else
            {
              localObject3 = (q.e)localq.wje.get(((j)localObject2).field_localId);
              if (localObject3 != null)
              {
                if ((((q.e)localObject3).iuD < 0) && (SystemClock.elapsedRealtime() - ((q.e)localObject3).wji < 300000L)) {
                  continue;
                }
                if (((q.e)localObject3).iuD < 0) {
                  ((q.e)localObject3).iuD = 3;
                }
              }
              for (;;)
              {
                ac.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", new Object[] { Integer.valueOf(((j)localObject2).field_localId), Long.valueOf(((j)localObject2).field_msgId) });
                localq.b((j)localObject2);
                break;
                localObject3 = new q.e((byte)0);
                localq.wje.put(((j)localObject2).field_localId, localObject3);
              }
            }
          }
        }
        if (localq.wjf.isEmpty())
        {
          ac.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
          localq.finish();
          AppMethodBeat.o(9551);
          return;
        }
        Object localObject3 = (j)localq.wjf.removeFirst();
        Object localObject2 = (q.e)localq.wje.get(((j)localObject3).field_localId);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new q.e((byte)0);
          localq.wje.put(((j)localObject3).field_localId, localObject1);
        }
        ((q.e)localObject1).iuD -= 1;
        int i;
        if (((q.e)localObject1).iuD < 0) {
          if (300000L > SystemClock.elapsedRealtime() - ((q.e)localObject1).wji) {
            i = 0;
          }
        }
        while (i != 0)
        {
          localq.wjb = true;
          switch (((j)localObject3).field_type)
          {
          default: 
            localq.wjb = false;
            AppMethodBeat.o(9551);
            return;
            ((q.e)localObject1).iuD = 2;
            ((q.e)localObject1).wji = SystemClock.elapsedRealtime();
            i = 1;
            break;
          case 1: 
            com.tencent.mm.sdk.g.b.c(new q.c(localq, (j)localObject3), "RecordMsgSendService_favDataCopy");
            AppMethodBeat.o(9551);
            return;
          case 2: 
            com.tencent.mm.sdk.g.b.c(new q.a(localq, (j)localObject3), "RecordMsgSendService_chatDataCopy");
            AppMethodBeat.o(9551);
            return;
          case 0: 
            com.tencent.mm.sdk.g.b.c(new q.d(localq, (j)localObject3, bool), "RecordMsgSendService_normalDataCopy");
            AppMethodBeat.o(9551);
            return;
          case 3: 
            com.tencent.mm.sdk.g.b.c(new q.b(localq, (j)localObject3), "RecordMsgSendService_chatDataDownLoad");
            AppMethodBeat.o(9551);
            return;
          }
        }
        localq.a(null, false);
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
  
  final void b(j paramj)
  {
    AppMethodBeat.i(9575);
    if (!this.wjf.contains(paramj)) {
      this.wjf.add(paramj);
    }
    AppMethodBeat.o(9575);
  }
  
  final void b(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(9584);
    bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramj.field_msgId);
    ac.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d, afterCdnUpload %s", new Object[] { Boolean.FALSE, Long.valueOf(localbo.field_msgId), Long.valueOf(paramj.field_msgId), Integer.valueOf(paramj.field_localId), Boolean.valueOf(paramBoolean) });
    if (localbo.field_msgId == paramj.field_msgId)
    {
      localbo.setContent(n.a(paramj.field_title, paramj.field_desc, paramj.field_dataProto, paramj.field_favFrom, paramj.field_msgId));
      localbo.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramj.field_msgId, localbo);
    }
    com.tencent.mm.ah.k localk = com.tencent.mm.plugin.s.a.dnz().zN(paramj.field_msgId);
    if (localk != null)
    {
      localk.field_xml = localbo.field_content;
      com.tencent.mm.plugin.s.a.dnz().update(localk, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Ma(paramj.field_localId);
    this.wje.remove(paramj.field_localId);
    if (localbo.field_createTime + this.wjv * 24 * 3600 * 1000 < ce.azI())
    {
      ac.i("MicroMsg.RecordMsgSendService", "doSendContinue, out of wait time, " + localbo.field_createTime);
      localbo.setStatus(5);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramj.field_msgId, localbo);
      AppMethodBeat.o(9584);
      return;
    }
    ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).wq(paramj.field_msgId);
    AppMethodBeat.o(9584);
  }
  
  final void e(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(9578);
    bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramLong);
    if (localbo.field_msgId == paramLong)
    {
      localbo.setContent(paramString);
      localbo.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramLong, localbo);
    }
    paramString = com.tencent.mm.plugin.s.a.dnz().zN(paramLong);
    if (paramString != null)
    {
      paramString.field_xml = localbo.field_content;
      com.tencent.mm.plugin.s.a.dnz().update(paramString, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Ma(paramInt);
    this.wje.remove(paramInt);
    ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).wq(paramLong);
    ac.i("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(9578);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(9576);
    this.wjf.clear();
    this.wje.clear();
    this.wjb = false;
    AppMethodBeat.o(9576);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(9577);
    ac.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ac.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
      AppMethodBeat.o(9577);
      return;
    }
    switch (paramn.getType())
    {
    default: 
      this.wjb = false;
      a(null, false);
      AppMethodBeat.o(9577);
      return;
    }
    ac.i("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (f)paramn;
    int k = paramInt1;
    int i = paramInt2;
    agx localagx;
    if (paramInt1 == 3)
    {
      paramn = paramString.wiY.field_dataProto.nxC.iterator();
      do
      {
        if (!paramn.hasNext()) {
          break;
        }
        localagx = (agx)paramn.next();
      } while ((bs.isNullOrNil(localagx.Ezf)) && (bs.isNullOrNil(localagx.hhV)));
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
        e(paramString.wiY.field_msgId, paramString.wiY.field_localId, paramString.wiX);
        break;
      }
      ac.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[] { Long.valueOf(paramString.wiY.field_msgId), Integer.valueOf(paramString.wiY.field_localId) });
      ac.w("MicroMsg.RecordMsgSendService", "try upload from local");
      paramn = paramString.wiY.field_dataProto.nxC.iterator();
      while (paramn.hasNext())
      {
        localagx = (agx)paramn.next();
        String str;
        Object localObject;
        boolean bool;
        if (localagx.EzA > 0L)
        {
          str = n.h(localagx.dhw, paramString.wiY.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr(str) == null)
          {
            localObject = new com.tencent.mm.plugin.record.a.i();
            ((com.tencent.mm.plugin.record.a.i)localObject).field_cdnKey = localagx.Ezh;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_cdnUrl = localagx.Ezf;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_dataId = localagx.dhw;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_mediaId = str;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_totalLen = ((int)localagx.EzA);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_localId = ((com.tencent.mm.plugin.record.a.i)localObject).field_mediaId.hashCode();
            ((com.tencent.mm.plugin.record.a.i)localObject).field_path = n.c(localagx, paramString.wiY.field_msgId);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_type = 2;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_fileType = n.gO(localagx.dataType, (int)localagx.EzA);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_recordLocalId = paramString.wiY.field_localId;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_toUser = paramString.wiY.field_toUser;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_isThumb = false;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.i)localObject);
            ac.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_localId), Boolean.valueOf(bool) });
          }
        }
        if (localagx.EzL > 0L)
        {
          str = n.aco(localagx.dhw);
          localObject = n.h(str, paramString.wiY.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr((String)localObject) == null)
          {
            com.tencent.mm.plugin.record.a.i locali = new com.tencent.mm.plugin.record.a.i();
            locali.field_cdnKey = localagx.Ezb;
            locali.field_cdnUrl = localagx.hhV;
            locali.field_dataId = str;
            locali.field_mediaId = ((String)localObject);
            locali.field_totalLen = ((int)localagx.EzL);
            locali.field_localId = locali.field_mediaId.hashCode();
            locali.field_path = n.f(localagx, paramString.wiY.field_msgId);
            locali.field_type = 2;
            locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            locali.field_recordLocalId = paramString.wiY.field_localId;
            locali.field_toUser = paramString.wiY.field_toUser;
            locali.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
            ac.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
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
    private j wiY;
    
    public a(j paramj)
    {
      this.wiY = paramj;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9553);
      int m = 0;
      int i = 0;
      ac.i("MicroMsg.RecordMsgSendService", "dojob ChatDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.wiY.field_msgId) });
      int j;
      int k;
      agx localagx;
      Object localObject1;
      Object localObject2;
      boolean bool;
      if ((this.wiY != null) && (this.wiY.field_dataProto != null) && (this.wiY.field_dataProto.nxC != null))
      {
        Iterator localIterator = this.wiY.field_dataProto.nxC.iterator();
        j = 0;
        m = i;
        k = j;
        if (!localIterator.hasNext()) {
          break label1167;
        }
        localagx = (agx)localIterator.next();
        if ((bs.isNullOrNil(localagx.Ezf)) && (!com.tencent.mm.vfs.i.eA(localagx.EzD))) {
          break label1335;
        }
        localObject1 = localagx.EzD;
        localObject2 = n.c(localagx, this.wiY.field_msgId);
        if (com.tencent.mm.vfs.i.lZ((String)localObject1, (String)localObject2) > 0L)
        {
          bool = true;
          label167:
          ac.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[] { localagx.Ezf, localObject1, localObject2, Boolean.valueOf(bool) });
          k = i;
          if (!bool) {
            break label1330;
          }
          if (bs.isNullOrNil(localagx.Ezw))
          {
            ac.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
            localagx.aIN(com.tencent.mm.vfs.i.aKe((String)localObject2));
            i = 1;
          }
          k = i;
          if (!bs.isNullOrNil(localagx.Ezy)) {
            break label1330;
          }
          ac.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
          localObject1 = com.tencent.mm.vfs.i.aU((String)localObject2, 0, 256);
          if (localObject1 != null) {
            break label990;
          }
          localObject1 = null;
          label281:
          localagx.aIO((String)localObject1);
          i = 1;
          label291:
          if (com.tencent.mm.vfs.i.aSp((String)localObject2) != 0L) {
            localagx.zS(com.tencent.mm.vfs.i.aSp((String)localObject2));
          }
          localObject1 = n.h(localagx.dhw, this.wiY.field_msgId, false);
          localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr((String)localObject1);
          if (localObject2 != null) {
            break label1000;
          }
          localObject2 = new com.tencent.mm.plugin.record.a.i();
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_cdnKey = localagx.Ezh;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_cdnUrl = localagx.Ezf;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_dataId = localagx.dhw;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_mediaId = ((String)localObject1);
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_totalLen = ((int)localagx.EzA);
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_localId = ((com.tencent.mm.plugin.record.a.i)localObject2).field_mediaId.hashCode();
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_path = n.c(localagx, this.wiY.field_msgId);
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_type = 2;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_fileType = n.gO(localagx.dataType, (int)localagx.EzA);
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_recordLocalId = this.wiY.field_localId;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_toUser = this.wiY.field_toUser;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_isThumb = false;
          bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.i)localObject2);
          m = 1;
          ac.i("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject2).field_localId), Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject2).field_fileType), localObject1 });
          k = i;
        }
      }
      for (;;)
      {
        label572:
        if (bs.isNullOrNil(localagx.hhV))
        {
          j = k;
          if (!com.tencent.mm.vfs.i.eA(localagx.EzF)) {}
        }
        else
        {
          localObject1 = localagx.EzF;
          localObject2 = n.f(localagx, this.wiY.field_msgId);
          if (com.tencent.mm.vfs.i.lZ((String)localObject1, (String)localObject2) > 0L) {}
          com.tencent.mm.plugin.record.a.i locali;
          for (bool = true;; bool = false)
          {
            ac.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
            localagx.zT(com.tencent.mm.vfs.i.aSp((String)localObject2));
            i = k;
            if (bool)
            {
              i = k;
              if (bs.isNullOrNil(localagx.EzH))
              {
                ac.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                localagx.aIS(com.tencent.mm.vfs.i.aKe((String)localObject2));
                i = 1;
              }
              if (bs.isNullOrNil(localagx.EzJ))
              {
                ac.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                localagx.aIT(com.tencent.mm.b.g.dt((String)localObject2));
                i = 1;
              }
            }
            localObject1 = n.aco(localagx.dhw);
            localObject2 = n.h((String)localObject1, this.wiY.field_msgId, false);
            locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr((String)localObject2);
            if (locali != null) {
              break label1093;
            }
            locali = new com.tencent.mm.plugin.record.a.i();
            locali.field_cdnKey = localagx.Ezb;
            locali.field_cdnUrl = localagx.hhV;
            locali.field_dataId = ((String)localObject1);
            locali.field_mediaId = ((String)localObject2);
            locali.field_totalLen = ((int)localagx.EzL);
            locali.field_localId = locali.field_mediaId.hashCode();
            locali.field_path = n.f(localagx, this.wiY.field_msgId);
            locali.field_type = 2;
            locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            locali.field_recordLocalId = this.wiY.field_localId;
            locali.field_toUser = this.wiY.field_toUser;
            locali.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
            ac.i("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
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
            if (((com.tencent.mm.plugin.record.a.i)localObject2).field_status == 2) {
              break label572;
            }
            m = j;
            k = i;
            if (((com.tencent.mm.plugin.record.a.i)localObject2).field_status == 3) {
              break label572;
            }
            m = j;
            k = i;
            if (((com.tencent.mm.plugin.record.a.i)localObject2).field_status == 4) {
              break label572;
            }
            m = j;
            k = i;
            if (((com.tencent.mm.plugin.record.a.i)localObject2).field_status == -1) {
              break label572;
            }
            ac.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, cdnInfo status:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject2).field_status) });
            m = 1;
            k = i;
            break label572;
          }
          label1093:
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
                  ac.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, thumb cdnInfo status:%s", new Object[] { Integer.valueOf(locali.field_status) });
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
            ac.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.wiY.field_localId), Long.valueOf(this.wiY.field_msgId), Integer.valueOf(this.wiY.field_type) });
            ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.wiY, new String[] { "localId" });
          }
          if (k == 0)
          {
            ac.i("MicroMsg.RecordMsgSendService", "doSendContinue without cdn task");
            q.this.b(this.wiY, false);
            q.this.wjb = false;
            q.this.a(null, false);
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
    implements com.tencent.mm.ak.g, t.a, Runnable
  {
    private boolean cEQ;
    private int i;
    private j wiY;
    HashMap<Long, Boolean> wjt;
    HashMap<Long, String> wjz;
    
    public b(j paramj)
    {
      AppMethodBeat.i(9556);
      this.i = 0;
      this.wjt = new HashMap();
      this.wjz = new HashMap();
      this.cEQ = false;
      this.wiY = paramj;
      com.tencent.mm.modelvideo.o.aJy().a(this, Looper.getMainLooper());
      com.tencent.mm.kernel.g.agQ().ghe.a(221, this);
      AppMethodBeat.o(9556);
    }
    
    private void a(HashMap<Long, Boolean> paramHashMap, boolean paramBoolean, j paramj)
    {
      AppMethodBeat.i(9561);
      if ((k(paramHashMap)) && (paramBoolean))
      {
        com.tencent.mm.modelvideo.o.aJy().a(this);
        paramj.field_type = 2;
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(paramj, new String[] { "localId" });
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramj);
      }
      AppMethodBeat.o(9561);
    }
    
    private void ax(bo parambo)
    {
      AppMethodBeat.i(9560);
      Object localObject = k.b.vA(parambo.field_content);
      if (localObject == null)
      {
        ac.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[] { parambo.field_content });
        AppMethodBeat.o(9560);
        return;
      }
      if ((bs.isNullOrNil(((k.b)localObject).cZa)) && (!bs.isNullOrNil(((k.b)localObject).hhU)))
      {
        ac.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[] { parambo.field_content });
        ((k.b)localObject).cZa = ((k.b)localObject).hhU.hashCode();
      }
      localObject = ((k.b)localObject).cZa;
      if (!a.a(parambo, a.q((String)localObject, parambo.field_msgId)))
      {
        this.wjt.put(Long.valueOf(parambo.field_msgId), Boolean.FALSE);
        this.wjz.put(Long.valueOf(parambo.field_msgId), localObject);
        a.ax(parambo);
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
      parama = u.Ej(parama.fileName);
      if (parama != null)
      {
        bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(parama.iaJ);
        if (parama.aJN())
        {
          this.wjt.put(Long.valueOf(localbo.field_msgId), Boolean.TRUE);
          a(this.wjt, this.cEQ, this.wiY);
        }
        AppMethodBeat.o(9558);
        return;
      }
      a(null, this.cEQ, this.wiY);
      AppMethodBeat.o(9558);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(9559);
      if ((paramn instanceof e))
      {
        com.tencent.mm.kernel.g.agQ().ghe.b(221, this);
        if (this.wjz != null) {
          paramn = this.wjz.entrySet().iterator();
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
          if ((l <= 0L) || (((Boolean)this.wjt.get(Long.valueOf(l))).booleanValue())) {
            continue;
          }
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(l);
          localc = a.q(paramString, l);
          if (localc == null) {
            break label291;
          }
        }
        for (paramString = localc.field_fileFullPath;; paramString = null)
        {
          if ((paramString == null) || (paramString.length() <= 0)) {
            break label294;
          }
          this.wjt.put(Long.valueOf(l), Boolean.TRUE);
          paramString = this.wiY.field_dataProto.nxC.iterator();
          while (paramString.hasNext())
          {
            agx localagx = (agx)paramString.next();
            if (localagx.EAl == l) {
              localagx.aIQ(localc.field_fileFullPath);
            }
          }
          break;
          a(this.wjt, this.cEQ, this.wiY);
          AppMethodBeat.o(9559);
          return;
          a(null, this.cEQ, this.wiY);
          AppMethodBeat.o(9559);
          return;
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(9557);
      this.i = 0;
      this.cEQ = false;
      ac.i("MicroMsg.RecordMsgSendService", "dojob ChatDataDownloadRunnable, info id:%s", new Object[] { Long.valueOf(this.wiY.field_msgId) });
      if (this.wiY.field_dataProto == null)
      {
        ac.w("MicroMsg.RecordMsgSendService", "ChatDataDownloadRunnable info.field_dataProto null");
        this.cEQ = true;
        q.this.wjb = false;
        a(null, this.cEQ, this.wiY);
        AppMethodBeat.o(9557);
        return;
      }
      Iterator localIterator = this.wiY.field_dataProto.nxC.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (agx)localIterator.next();
        final long l = ((agx)localObject1).EAl;
        label438:
        if (l > 0L)
        {
          final bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(l);
          Object localObject2 = ((agx)localObject1).EzD;
          if ((System.currentTimeMillis() - localbo.field_createTime > 259200000L) && ((bs.isNullOrNil((String)localObject2)) || (!com.tencent.mm.vfs.i.eA((String)localObject2)))) {}
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              break label239;
            }
            ac.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", new Object[] { Integer.valueOf(localbo.getType()) });
            break;
          }
          label239:
          if (((agx)localObject1).dataType == 2)
          {
            if (localbo.eZm())
            {
              localObject2 = com.tencent.mm.av.o.aFx().qf(localbo.field_msgSvrId);
              if (localbo.field_isSend == 1) {
                if (((com.tencent.mm.av.e)localObject2).aFa()) {
                  j = 1;
                }
              }
              for (;;)
              {
                if ((((com.tencent.mm.av.e)localObject2).offset >= ((com.tencent.mm.av.e)localObject2).hux) && (((com.tencent.mm.av.e)localObject2).hux != 0)) {
                  break label438;
                }
                this.wjt.put(Long.valueOf(l), Boolean.FALSE);
                this.i = this.wiY.field_dataProto.nxC.indexOf(localObject1);
                com.tencent.mm.av.o.aFy().a(((com.tencent.mm.av.e)localObject2).dcd, localbo.field_msgId, j, localObject1, 2131231564, new d.a()
                {
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
                  {
                    AppMethodBeat.i(9555);
                    q.b.this.wjt.put(Long.valueOf(l), Boolean.TRUE);
                    q.b.a(q.b.this, q.b.this.wjt, q.b.c(q.b.this), q.b.b(q.b.this));
                    AppMethodBeat.o(9555);
                  }
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.ak.n paramAnonymousn) {}
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
                  {
                    AppMethodBeat.i(9554);
                    boolean bool;
                    if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0))
                    {
                      bool = true;
                      ac.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                      if (!(paramAnonymousObject instanceof agx)) {
                        break label303;
                      }
                      paramAnonymousObject = (agx)paramAnonymousObject;
                      paramAnonymousObject.aIQ(com.tencent.mm.av.o.aFx().p(com.tencent.mm.av.f.c(this.hIE), "", ""));
                      paramAnonymousObject.aIR(com.tencent.mm.av.o.aFx().R(localbo.field_imgPath, true));
                      paramAnonymousString = bv.L(this.hIE.hGY, "msg");
                      if (paramAnonymousString == null) {
                        break label279;
                      }
                      paramAnonymousObject.aIG((String)paramAnonymousString.get(".msg.img.$cdnbigimgurl"));
                      paramAnonymousObject.zS(bs.getInt((String)paramAnonymousString.get(".msg.img.$length"), 0));
                      paramAnonymousObject.aIH((String)paramAnonymousString.get(".msg.img.$aeskey"));
                      q.b.b(q.b.this).field_dataProto.nxC.set(q.b.a(q.b.this), paramAnonymousObject);
                      label216:
                      q.b.this.wjt.put(Long.valueOf(paramAnonymousObject.EAl), Boolean.TRUE);
                    }
                    for (;;)
                    {
                      q.b.a(q.b.this, q.b.this.wjt, q.b.c(q.b.this), q.b.b(q.b.this));
                      AppMethodBeat.o(9554);
                      return;
                      bool = false;
                      break;
                      label279:
                      ac.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", new Object[] { this.hIE.hGY });
                      break label216;
                      label303:
                      q.b.this.wjt.put(Long.valueOf(l), Boolean.TRUE);
                    }
                  }
                });
                break;
                j = 0;
                continue;
                if (!((com.tencent.mm.av.e)localObject2).aFa())
                {
                  j = 0;
                }
                else
                {
                  com.tencent.mm.av.e locale = com.tencent.mm.av.f.a((com.tencent.mm.av.e)localObject2);
                  if (!com.tencent.mm.vfs.i.eA(com.tencent.mm.av.o.aFx().p(locale.hGM, "", ""))) {
                    j = 0;
                  } else {
                    j = 1;
                  }
                }
              }
            }
            else if (localbo.fbG())
            {
              ax(localbo);
            }
          }
          else if ((((agx)localObject1).dataType == 4) || (((agx)localObject1).dataType == 15))
          {
            localObject1 = u.Ej(localbo.field_imgPath);
            if ((localObject1 != null) && (((s)localObject1).status != 199))
            {
              this.wjt.put(Long.valueOf(l), Boolean.FALSE);
              if (((s)localObject1).aJM())
              {
                ac.i("MicroMsg.RecordMsgSendService", "start complete online video");
                u.Eq(localbo.field_imgPath);
              }
              else
              {
                ac.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                u.Ee(localbo.field_imgPath);
              }
            }
          }
          else if ((((agx)localObject1).dataType == 8) && (!bs.isNullOrNil(((agx)localObject1).EAx)))
          {
            ax(localbo);
          }
        }
      }
      this.cEQ = true;
      q.this.wjb = false;
      a(this.wjt, this.cEQ, this.wiY);
      AppMethodBeat.o(9557);
    }
  }
  
  final class c
    implements Runnable
  {
    private j wiY;
    
    public c(j paramj)
    {
      this.wiY = paramj;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9564);
      ac.i("MicroMsg.RecordMsgSendService", "dojob FavDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.wiY.field_msgId) });
      Object localObject = this.wiY.field_dataProto.nxC.iterator();
      for (int i = 0; ((Iterator)localObject).hasNext(); i = 1)
      {
        label46:
        agx localagx = (agx)((Iterator)localObject).next();
        gt localgt = new gt();
        localgt.dhx.type = 2;
        localgt.dhx.dhz = localagx;
        com.tencent.mm.sdk.b.a.GpY.l(localgt);
        ac.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[] { localagx.dhw, Integer.valueOf(localagx.dataType) });
        String str;
        if (!bs.isNullOrNil(localgt.dhy.path))
        {
          str = n.c(localagx, this.wiY.field_msgId);
          ac.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[] { localgt.dhy.path, str });
          if (!localgt.dhy.path.equals(str)) {
            com.tencent.mm.vfs.i.lZ(localgt.dhy.path, str);
          }
        }
        if (!bs.isNullOrNil(localgt.dhy.thumbPath))
        {
          str = n.f(localagx, this.wiY.field_msgId);
          ac.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[] { localgt.dhy.thumbPath, str });
          if (!localgt.dhy.thumbPath.equals(str)) {
            com.tencent.mm.vfs.i.lZ(localgt.dhy.thumbPath, str);
          }
        }
        if (localagx.dataType == 3)
        {
          ac.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
          localagx.aIH("");
          localagx.aIG("");
          localagx.aIF("");
          localagx.aIE("");
        }
        if ((bs.isNullOrNil(localagx.Ezf)) && (bs.isNullOrNil(localagx.hhV))) {
          break label46;
        }
      }
      if (i != 0)
      {
        com.tencent.mm.kernel.g.agQ().ghe.a(new f(this.wiY), 0);
        AppMethodBeat.o(9564);
        return;
      }
      localObject = k.b.a(n.a(this.wiY.field_title, this.wiY.field_desc, this.wiY.field_dataProto), null, null);
      q.this.e(this.wiY.field_msgId, this.wiY.field_localId, (String)localObject);
      q.this.wjb = false;
      q.this.a(null, false);
      AppMethodBeat.o(9564);
    }
  }
  
  final class d
    implements Runnable
  {
    private j wiY;
    private boolean wjC;
    
    public d(j paramj, boolean paramBoolean)
    {
      this.wiY = paramj;
      this.wjC = paramBoolean;
    }
    
    private byte a(agx paramagx, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(9568);
      int k = 0;
      int j = 0;
      int i = 0;
      int m = paramagx.dataType;
      byte b1;
      if ((paramBoolean) && (m == 17))
      {
        ac.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() inner record");
        paramagx = n.aqs(paramagx.EAp);
        if (paramagx == null)
        {
          AppMethodBeat.o(9568);
          return 0;
        }
        paramagx = paramagx.hkS.iterator();
        for (b1 = 0; paramagx.hasNext(); b1 = (byte)(i | b1))
        {
          i = a((agx)paramagx.next(), paramInt + 1, paramBoolean);
          ac.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable circleTraverseFavDataItem() %s result:%s ", new Object[] { Long.toBinaryString(i), Long.toBinaryString((byte)(i | b1)) });
        }
        AppMethodBeat.o(9568);
        return b1;
      }
      String str1;
      String str2;
      if ((!bs.isNullOrNil(paramagx.Ezf)) || (!bs.isNullOrNil(paramagx.EAx)))
      {
        str1 = n.a(paramagx, this.wiY.field_oriMsgId, paramInt);
        str2 = n.a(paramagx, this.wiY.field_msgId, paramInt);
        if (com.tencent.mm.vfs.i.lZ(str1, str2) <= 0L) {
          break label1059;
        }
        paramBoolean = true;
        ac.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          if (!bs.isNullOrNil(paramagx.Ezw)) {
            break label1232;
          }
          ac.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
          paramagx.aIN(com.tencent.mm.vfs.i.aKe(str2));
        }
      }
      label689:
      label1213:
      label1232:
      for (i = 1;; i = 0)
      {
        if (bs.isNullOrNil(paramagx.Ezy))
        {
          ac.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
          paramagx.aIO(com.tencent.mm.b.g.dt(str2));
        }
        for (j = 1;; j = i)
        {
          str2 = n.eq(paramagx.dhw, paramInt);
          str1 = n.h(str2, this.wiY.field_msgId, false);
          Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr(str1);
          com.tencent.mm.plugin.record.a.i locali;
          if (localObject == null)
          {
            localObject = new com.tencent.mm.plugin.record.a.i();
            ((com.tencent.mm.plugin.record.a.i)localObject).field_cdnKey = paramagx.Ezh;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_cdnUrl = paramagx.Ezf;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_dataId = str2;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_mediaId = str1;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_totalLen = ((int)paramagx.EzA);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_localId = ((com.tencent.mm.plugin.record.a.i)localObject).field_mediaId.hashCode();
            ((com.tencent.mm.plugin.record.a.i)localObject).field_path = n.a(paramagx, this.wiY.field_msgId, paramInt);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_type = 2;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_fileType = n.gO(paramagx.dataType, (int)paramagx.EzA);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_recordLocalId = this.wiY.field_localId;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_toUser = this.wiY.field_toUser;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_isThumb = false;
            str2 = n.a(paramagx, this.wiY.field_msgId, paramInt);
            if ((!bs.isNullOrNil(paramagx.EAx)) && (!com.tencent.mm.vfs.i.eA(str2)))
            {
              ((com.tencent.mm.plugin.record.a.i)localObject).field_status = -1;
              a(paramagx, str2, str1);
            }
            i = 1;
            paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.i)localObject);
            ac.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_recordLocalId), ((com.tencent.mm.plugin.record.a.i)localObject).field_dataId, ((com.tencent.mm.plugin.record.a.i)localObject).field_mediaId });
            k = j;
            if (bs.isNullOrNil(paramagx.hhV))
            {
              j = i;
              if (bs.isNullOrNil(paramagx.hhM)) {}
            }
            else
            {
              str1 = n.b(paramagx, this.wiY.field_oriMsgId, paramInt);
              str2 = n.b(paramagx, this.wiY.field_msgId, paramInt);
              if (com.tencent.mm.vfs.i.lZ(str1, str2) <= 0L) {
                break label1136;
              }
              paramBoolean = true;
              ac.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
              str1 = n.eq(n.aco(paramagx.dhw), paramInt);
              str2 = n.h(str1, this.wiY.field_msgId, false);
              locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr(str2);
              localObject = n.b(paramagx, this.wiY.field_msgId, paramInt);
              if (locali != null) {
                break label1141;
              }
              locali = new com.tencent.mm.plugin.record.a.i();
              locali.field_cdnKey = paramagx.Ezb;
              locali.field_cdnUrl = paramagx.hhV;
              locali.field_dataId = str1;
              locali.field_mediaId = str2;
              locali.field_totalLen = ((int)paramagx.EzL);
              locali.field_localId = locali.field_mediaId.hashCode();
              locali.field_path = n.b(paramagx, this.wiY.field_msgId, paramInt);
              locali.field_type = 2;
              locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
              locali.field_recordLocalId = this.wiY.field_localId;
              locali.field_toUser = this.wiY.field_toUser;
              locali.field_isThumb = true;
              if ((!bs.isNullOrNil(paramagx.hhM)) && (!com.tencent.mm.vfs.i.eA((String)localObject)))
              {
                locali.field_status = -1;
                b(paramagx, (String)localObject, str2);
              }
              j = 1;
              paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
              ac.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(locali.field_recordLocalId), locali.field_dataId, locali.field_mediaId });
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
          if (((com.tencent.mm.plugin.record.a.i)localObject).field_status == -1) {
            a(paramagx, n.a(paramagx, this.wiY.field_msgId, paramInt), str1);
          }
          for (i = 1;; i = 0)
          {
            if (((com.tencent.mm.plugin.record.a.i)localObject).field_status == 0) {
              i = 1;
            }
            ac.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_status) });
            k = j;
            break;
            label1136:
            paramBoolean = false;
            break label689;
            label1141:
            if (locali.field_status == -1)
            {
              b(paramagx, n.b(paramagx, this.wiY.field_msgId, paramInt), str2);
              i = 1;
            }
            if (locali.field_status == 0) {
              i = 1;
            }
            ac.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(locali.field_status) });
            j = i;
            break label1026;
            b1 = 0;
            break label1034;
          }
        }
      }
    }
    
    private void a(final agx paramagx, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9569);
      ac.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", new Object[] { paramagx.dhw, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.field_fileType = 19;
      localg.field_authKey = paramagx.hhR;
      localg.field_aesKey = paramagx.EAu;
      localg.fre = paramagx.EAx;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.frb = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9565);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              ac.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl done id:%s, mediaId:%s, path:%s", new Object[] { paramagx.dhw, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramagx.dhw;
                localObject = paramString1;
                if (paramAnonymousd != null) {
                  break label279;
                }
                i = 0;
                ac.e("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl error id:%s, mediaId:%s, path:%s, err:(%d,%d)", new Object[] { paramAnonymousc, paramAnonymousString, localObject, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramagx.dhw;
                  String str = paramString1;
                  if (paramAnonymousd == null) {}
                  for (i = 0;; i = paramAnonymousd.field_retCode)
                  {
                    ac.e("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl error id:%s, mediaId:%s, tempMediaId:%s, path:%s, err:(%d,%d), cdnInfo==null", new Object[] { localObject, paramAnonymousString, paramAnonymousc, str, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
                    AppMethodBeat.o(9565);
                    return 0;
                    i = paramAnonymousd.field_retCode;
                    break;
                  }
                }
                ((com.tencent.mm.plugin.record.a.i)localObject).field_status = 0;
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((com.tencent.mm.plugin.record.a.i)localObject);
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
        if (!com.tencent.mm.an.f.aDD().b(localg, -1)) {
          ac.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
        }
        AppMethodBeat.o(9569);
        return;
        paramString2 = paramString2 + "_tp";
      }
    }
    
    private void b(final agx paramagx, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9570);
      ac.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramagx.dhw, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.field_fileType = 19;
      localg.field_authKey = paramagx.hhR;
      localg.field_aesKey = paramagx.hhS;
      localg.fre = paramagx.hhM;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.frb = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9566);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              ac.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramagx.dhw, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramagx.dhw;
                localObject = paramString1;
                if (paramAnonymousd != null) {
                  break label279;
                }
                i = 0;
                ac.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, thumbPath:%s err:(%d,%d)", new Object[] { paramAnonymousc, paramAnonymousString, localObject, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramagx.dhw;
                  String str = paramString1;
                  if (paramAnonymousd == null) {}
                  for (i = 0;; i = paramAnonymousd.field_retCode)
                  {
                    ac.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, tempMediaId:%s, thumbPath:%s err:(%d,%d)", new Object[] { localObject, paramAnonymousString, paramAnonymousc, str, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
                    AppMethodBeat.o(9566);
                    return 0;
                    i = paramAnonymousd.field_retCode;
                    break;
                  }
                }
                ((com.tencent.mm.plugin.record.a.i)localObject).field_status = 0;
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((com.tencent.mm.plugin.record.a.i)localObject);
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
        if (!com.tencent.mm.an.f.aDD().b(localg, -1)) {
          ac.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
        }
        AppMethodBeat.o(9570);
        return;
        paramString2 = paramString2 + "_tp";
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(9567);
      if (this.wiY.field_dataProto == null)
      {
        ac.w("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable info.field_dataProto null");
        q.this.wjb = false;
        AppMethodBeat.o(9567);
        return;
      }
      Iterator localIterator = this.wiY.field_dataProto.nxC.iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      if (localIterator.hasNext())
      {
        int i = a((agx)localIterator.next(), 1, this.wjC);
        ac.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() state: %s ", new Object[] { Long.toBinaryString(i) });
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
        ac.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable startEmbedded:%s infochanged:%s, needRun:%s", new Object[] { Boolean.valueOf(this.wjC), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (bool2)
        {
          ac.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.wiY.field_localId), Long.valueOf(this.wiY.field_msgId), Integer.valueOf(this.wiY.field_type) });
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.wiY, new String[] { "localId" });
        }
        if (!bool1)
        {
          ac.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable doSendContinue");
          q.this.b(this.wiY, false);
          q.this.wjb = false;
          q.this.a(null, false);
        }
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9567);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.q
 * JD-Core Version:    0.7.0.1
 */