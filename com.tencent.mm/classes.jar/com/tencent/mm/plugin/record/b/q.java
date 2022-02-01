package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class q
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.record.a.d, com.tencent.mm.plugin.record.a.h
{
  private int vaH;
  boolean van;
  SparseArray<e> vaq;
  LinkedList<j> var;
  
  public q()
  {
    AppMethodBeat.i(9572);
    this.van = false;
    this.vaq = new SparseArray();
    this.var = new LinkedList();
    this.vaH = 7;
    com.tencent.mm.kernel.g.afA().gcy.a(632, this);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    try
    {
      this.vaH = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pob, 7);
      AppMethodBeat.o(9572);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.RecordMsgSendService", localException, "RecordMsgSendService init error.", new Object[0]);
      AppMethodBeat.o(9572);
    }
  }
  
  private boolean a(com.tencent.mm.plugin.record.a.i parami, afy paramafy, int paramInt)
  {
    AppMethodBeat.i(9581);
    com.tencent.mm.protocal.b.a.c localc = n.alt(paramafy.Dhj);
    if (localc == null)
    {
      ad.i("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() msgData == null");
      AppMethodBeat.o(9581);
      return false;
    }
    boolean bool = a(parami, localc.gKs, paramInt + 1);
    ad.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramafy.aDL(n.a(localc, paramafy.Dhj));
    }
    AppMethodBeat.o(9581);
    return bool;
  }
  
  private boolean a(com.tencent.mm.plugin.record.a.i parami, List<afy> paramList, int paramInt)
  {
    AppMethodBeat.i(9580);
    paramList = paramList.iterator();
    boolean bool1 = false;
    afy localafy;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label229;
        }
        localafy = (afy)paramList.next();
        int i = localafy.dataType;
        ad.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localafy.dkb, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = a(parami, localafy, paramInt);
      }
    } while (!parami.field_dataId.equals(n.ej(n.XS(localafy.dkb), paramInt)));
    ad.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localafy.DfV, parami.field_cdnKey, localafy.gHu, parami.field_cdnUrl, Long.valueOf(localafy.DgF), Integer.valueOf(parami.field_totalLen) });
    localafy.aDo(parami.field_cdnKey);
    localafy.aDn(parami.field_cdnUrl);
    if (!bt.iY(paramInt, 1)) {
      localafy.aDy(n.cT(localafy.toString(), localafy.dataType));
    }
    boolean bool2 = true;
    label229:
    AppMethodBeat.o(9580);
    return bool2;
  }
  
  private boolean b(com.tencent.mm.plugin.record.a.i parami, afy paramafy, int paramInt)
  {
    AppMethodBeat.i(9583);
    com.tencent.mm.protocal.b.a.c localc = n.alt(paramafy.Dhj);
    if (localc == null)
    {
      ad.i("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() msgData == null");
      AppMethodBeat.o(9583);
      return false;
    }
    boolean bool = b(parami, localc.gKs, paramInt + 1);
    ad.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramafy.aDL(n.a(localc, paramafy.Dhj));
    }
    AppMethodBeat.o(9583);
    return bool;
  }
  
  private boolean b(com.tencent.mm.plugin.record.a.i parami, List<afy> paramList, int paramInt)
  {
    AppMethodBeat.i(9582);
    paramList = paramList.iterator();
    boolean bool1 = false;
    afy localafy;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label228;
        }
        localafy = (afy)paramList.next();
        int i = localafy.dataType;
        ad.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localafy.dkb, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = b(parami, localafy, paramInt);
      }
    } while (!parami.field_dataId.equals(n.ej(localafy.dkb, paramInt)));
    ad.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localafy.Dgb, parami.field_cdnKey, localafy.DfZ, parami.field_cdnUrl, Long.valueOf(localafy.Dgu), Integer.valueOf(parami.field_totalLen) });
    localafy.aDq(parami.field_cdnKey);
    localafy.aDp(parami.field_cdnUrl);
    if (!bt.iY(paramInt, 1)) {
      localafy.aDy(n.cT(localafy.toString(), localafy.dataType));
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
      ad.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(9579);
      return;
    }
    if (parami == null)
    {
      ad.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
      AppMethodBeat.o(9579);
      return;
    }
    if (2 != parami.field_type)
    {
      ad.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload , mediaid:%s, recordLocalId:%d, status:%d", new Object[] { parami.field_mediaId, Integer.valueOf(parami.field_recordLocalId), Integer.valueOf(parami.field_status) });
      AppMethodBeat.o(9579);
      return;
    }
    if ((parami.field_status == 0) || (1 == parami.field_status) || (-1 == parami.field_status))
    {
      ad.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
      AppMethodBeat.o(9579);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().Ka(parami.field_recordLocalId);
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.record.a.i)((Iterator)localObject2).next();
      if ((((com.tencent.mm.plugin.record.a.i)localObject3).field_status == 0) || (1 == ((com.tencent.mm.plugin.record.a.i)localObject3).field_status) || (-1 == ((com.tencent.mm.plugin.record.a.i)localObject3).field_status)) {
        ad.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[] { ((com.tencent.mm.plugin.record.a.i)localObject3).field_mediaId });
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
      localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Kc(parami.field_recordLocalId);
      paramInt = parami.field_recordLocalId;
      boolean bool;
      if (localObject2 != null)
      {
        bool = true;
        ad.i("MicroMsg.RecordMsgSendService", "finish get record info, id %d result %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (localObject2 != null)
        {
          parami = ((j)localObject2).field_dataProto.mVb;
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
          ad.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", new Object[] { locali.field_dataId, Boolean.valueOf(locali.field_isThumb) });
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
      this.van = false;
      a(null, false);
      AppMethodBeat.o(9579);
      return;
    }
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(204817);
    a(paramj, false);
    AppMethodBeat.o(204817);
  }
  
  public final void a(final j paramj, final boolean paramBoolean)
  {
    AppMethodBeat.i(9574);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9551);
        if (paramj != null)
        {
          if ((q.e)q.this.vaq.get(paramj.field_localId) == null)
          {
            ad.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[] { Integer.valueOf(paramj.field_localId), Long.valueOf(paramj.field_msgId) });
            localObject1 = new q.e((byte)0);
            q.this.vaq.put(paramj.field_localId, localObject1);
          }
          q.this.b(paramj);
        }
        q localq = q.this;
        boolean bool = paramBoolean;
        if (localq.van)
        {
          ad.i("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
          AppMethodBeat.o(9551);
          return;
        }
        if (localq.var.isEmpty())
        {
          ad.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
          localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().dgd().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (j)((Iterator)localObject1).next();
            if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(((j)localObject2).field_msgId).getType() != 49)
            {
              ad.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", new Object[] { Integer.valueOf(((j)localObject2).field_localId), Long.valueOf(((j)localObject2).field_msgId) });
              ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Kb(((j)localObject2).field_localId);
            }
            else
            {
              localObject3 = (q.e)localq.vaq.get(((j)localObject2).field_localId);
              if (localObject3 != null)
              {
                if ((((q.e)localObject3).hUz < 0) && (SystemClock.elapsedRealtime() - ((q.e)localObject3).vau < 300000L)) {
                  continue;
                }
                if (((q.e)localObject3).hUz < 0) {
                  ((q.e)localObject3).hUz = 3;
                }
              }
              for (;;)
              {
                ad.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", new Object[] { Integer.valueOf(((j)localObject2).field_localId), Long.valueOf(((j)localObject2).field_msgId) });
                localq.b((j)localObject2);
                break;
                localObject3 = new q.e((byte)0);
                localq.vaq.put(((j)localObject2).field_localId, localObject3);
              }
            }
          }
        }
        if (localq.var.isEmpty())
        {
          ad.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
          localq.finish();
          AppMethodBeat.o(9551);
          return;
        }
        Object localObject3 = (j)localq.var.removeFirst();
        Object localObject2 = (q.e)localq.vaq.get(((j)localObject3).field_localId);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new q.e((byte)0);
          localq.vaq.put(((j)localObject3).field_localId, localObject1);
        }
        ((q.e)localObject1).hUz -= 1;
        int i;
        if (((q.e)localObject1).hUz < 0) {
          if (300000L > SystemClock.elapsedRealtime() - ((q.e)localObject1).vau) {
            i = 0;
          }
        }
        while (i != 0)
        {
          localq.van = true;
          switch (((j)localObject3).field_type)
          {
          default: 
            localq.van = false;
            AppMethodBeat.o(9551);
            return;
            ((q.e)localObject1).hUz = 2;
            ((q.e)localObject1).vau = SystemClock.elapsedRealtime();
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
    if (!this.var.contains(paramj)) {
      this.var.add(paramj);
    }
    AppMethodBeat.o(9575);
  }
  
  final void b(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(9584);
    bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramj.field_msgId);
    ad.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d, afterCdnUpload %s", new Object[] { Boolean.FALSE, Long.valueOf(localbl.field_msgId), Long.valueOf(paramj.field_msgId), Integer.valueOf(paramj.field_localId), Boolean.valueOf(paramBoolean) });
    if (localbl.field_msgId == paramj.field_msgId)
    {
      localbl.setContent(n.a(paramj.field_title, paramj.field_desc, paramj.field_dataProto, paramj.field_favFrom, paramj.field_msgId));
      localbl.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramj.field_msgId, localbl);
    }
    com.tencent.mm.ai.k localk = com.tencent.mm.plugin.s.a.cZR().vk(paramj.field_msgId);
    if (localk != null)
    {
      localk.field_xml = localbl.field_content;
      com.tencent.mm.plugin.s.a.cZR().update(localk, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Kb(paramj.field_localId);
    this.vaq.remove(paramj.field_localId);
    if (localbl.field_createTime + this.vaH * 24 * 3600 * 1000 < ce.asR())
    {
      ad.i("MicroMsg.RecordMsgSendService", "doSendContinue, out of wait time, " + localbl.field_createTime);
      localbl.setStatus(5);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramj.field_msgId, localbl);
      AppMethodBeat.o(9584);
      return;
    }
    ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).rN(paramj.field_msgId);
    AppMethodBeat.o(9584);
  }
  
  final void d(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(9578);
    bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramLong);
    if (localbl.field_msgId == paramLong)
    {
      localbl.setContent(paramString);
      localbl.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramLong, localbl);
    }
    paramString = com.tencent.mm.plugin.s.a.cZR().vk(paramLong);
    if (paramString != null)
    {
      paramString.field_xml = localbl.field_content;
      com.tencent.mm.plugin.s.a.cZR().update(paramString, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Kb(paramInt);
    this.vaq.remove(paramInt);
    ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).rN(paramLong);
    ad.i("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(9578);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(9576);
    this.var.clear();
    this.vaq.clear();
    this.van = false;
    AppMethodBeat.o(9576);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
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
      this.van = false;
      a(null, false);
      AppMethodBeat.o(9577);
      return;
    }
    ad.i("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (f)paramn;
    int k = paramInt1;
    int i = paramInt2;
    afy localafy;
    if (paramInt1 == 3)
    {
      paramn = paramString.vak.field_dataProto.mVb.iterator();
      do
      {
        if (!paramn.hasNext()) {
          break;
        }
        localafy = (afy)paramn.next();
      } while ((bt.isNullOrNil(localafy.DfZ)) && (bt.isNullOrNil(localafy.gHu)));
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
        d(paramString.vak.field_msgId, paramString.vak.field_localId, paramString.vaj);
        break;
      }
      ad.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[] { Long.valueOf(paramString.vak.field_msgId), Integer.valueOf(paramString.vak.field_localId) });
      ad.w("MicroMsg.RecordMsgSendService", "try upload from local");
      paramn = paramString.vak.field_dataProto.mVb.iterator();
      while (paramn.hasNext())
      {
        localafy = (afy)paramn.next();
        String str;
        Object localObject;
        boolean bool;
        if (localafy.Dgu > 0L)
        {
          str = n.h(localafy.dkb, paramString.vak.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als(str) == null)
          {
            localObject = new com.tencent.mm.plugin.record.a.i();
            ((com.tencent.mm.plugin.record.a.i)localObject).field_cdnKey = localafy.Dgb;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_cdnUrl = localafy.DfZ;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_dataId = localafy.dkb;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_mediaId = str;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_totalLen = ((int)localafy.Dgu);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_localId = ((com.tencent.mm.plugin.record.a.i)localObject).field_mediaId.hashCode();
            ((com.tencent.mm.plugin.record.a.i)localObject).field_path = n.c(localafy, paramString.vak.field_msgId);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_type = 2;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_fileType = n.gH(localafy.dataType, (int)localafy.Dgu);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_recordLocalId = paramString.vak.field_localId;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_toUser = paramString.vak.field_toUser;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_isThumb = false;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.i)localObject);
            ad.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_localId), Boolean.valueOf(bool) });
          }
        }
        if (localafy.DgF > 0L)
        {
          str = n.XS(localafy.dkb);
          localObject = n.h(str, paramString.vak.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als((String)localObject) == null)
          {
            com.tencent.mm.plugin.record.a.i locali = new com.tencent.mm.plugin.record.a.i();
            locali.field_cdnKey = localafy.DfV;
            locali.field_cdnUrl = localafy.gHu;
            locali.field_dataId = str;
            locali.field_mediaId = ((String)localObject);
            locali.field_totalLen = ((int)localafy.DgF);
            locali.field_localId = locali.field_mediaId.hashCode();
            locali.field_path = n.f(localafy, paramString.vak.field_msgId);
            locali.field_type = 2;
            locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            locali.field_recordLocalId = paramString.vak.field_localId;
            locali.field_toUser = paramString.vak.field_toUser;
            locali.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
            ad.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
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
    private j vak;
    
    public a(j paramj)
    {
      this.vak = paramj;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9553);
      int m = 0;
      int i = 0;
      ad.i("MicroMsg.RecordMsgSendService", "dojob ChatDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.vak.field_msgId) });
      int j;
      int k;
      afy localafy;
      Object localObject1;
      Object localObject2;
      boolean bool;
      if ((this.vak != null) && (this.vak.field_dataProto != null) && (this.vak.field_dataProto.mVb != null))
      {
        Iterator localIterator = this.vak.field_dataProto.mVb.iterator();
        j = 0;
        m = i;
        k = j;
        if (!localIterator.hasNext()) {
          break label1167;
        }
        localafy = (afy)localIterator.next();
        if ((bt.isNullOrNil(localafy.DfZ)) && (!com.tencent.mm.vfs.i.eK(localafy.Dgx))) {
          break label1335;
        }
        localObject1 = localafy.Dgx;
        localObject2 = n.c(localafy, this.vak.field_msgId);
        if (com.tencent.mm.vfs.i.lC((String)localObject1, (String)localObject2) > 0L)
        {
          bool = true;
          label167:
          ad.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[] { localafy.DfZ, localObject1, localObject2, Boolean.valueOf(bool) });
          k = i;
          if (!bool) {
            break label1330;
          }
          if (bt.isNullOrNil(localafy.Dgq))
          {
            ad.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
            localafy.aDw(com.tencent.mm.vfs.i.aEN((String)localObject2));
            i = 1;
          }
          k = i;
          if (!bt.isNullOrNil(localafy.Dgs)) {
            break label1330;
          }
          ad.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
          localObject1 = com.tencent.mm.vfs.i.aR((String)localObject2, 0, 256);
          if (localObject1 != null) {
            break label990;
          }
          localObject1 = null;
          label281:
          localafy.aDx((String)localObject1);
          i = 1;
          label291:
          if (com.tencent.mm.vfs.i.aMN((String)localObject2) != 0L) {
            localafy.vp(com.tencent.mm.vfs.i.aMN((String)localObject2));
          }
          localObject1 = n.h(localafy.dkb, this.vak.field_msgId, false);
          localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als((String)localObject1);
          if (localObject2 != null) {
            break label1000;
          }
          localObject2 = new com.tencent.mm.plugin.record.a.i();
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_cdnKey = localafy.Dgb;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_cdnUrl = localafy.DfZ;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_dataId = localafy.dkb;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_mediaId = ((String)localObject1);
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_totalLen = ((int)localafy.Dgu);
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_localId = ((com.tencent.mm.plugin.record.a.i)localObject2).field_mediaId.hashCode();
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_path = n.c(localafy, this.vak.field_msgId);
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_type = 2;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_fileType = n.gH(localafy.dataType, (int)localafy.Dgu);
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_recordLocalId = this.vak.field_localId;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_toUser = this.vak.field_toUser;
          ((com.tencent.mm.plugin.record.a.i)localObject2).field_isThumb = false;
          bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.i)localObject2);
          m = 1;
          ad.i("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject2).field_localId), Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject2).field_fileType), localObject1 });
          k = i;
        }
      }
      for (;;)
      {
        label572:
        if (bt.isNullOrNil(localafy.gHu))
        {
          j = k;
          if (!com.tencent.mm.vfs.i.eK(localafy.Dgz)) {}
        }
        else
        {
          localObject1 = localafy.Dgz;
          localObject2 = n.f(localafy, this.vak.field_msgId);
          if (com.tencent.mm.vfs.i.lC((String)localObject1, (String)localObject2) > 0L) {}
          com.tencent.mm.plugin.record.a.i locali;
          for (bool = true;; bool = false)
          {
            ad.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
            localafy.vq(com.tencent.mm.vfs.i.aMN((String)localObject2));
            i = k;
            if (bool)
            {
              i = k;
              if (bt.isNullOrNil(localafy.DgB))
              {
                ad.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                localafy.aDB(com.tencent.mm.vfs.i.aEN((String)localObject2));
                i = 1;
              }
              if (bt.isNullOrNil(localafy.DgD))
              {
                ad.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                localafy.aDC(com.tencent.mm.b.g.dE((String)localObject2));
                i = 1;
              }
            }
            localObject1 = n.XS(localafy.dkb);
            localObject2 = n.h((String)localObject1, this.vak.field_msgId, false);
            locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als((String)localObject2);
            if (locali != null) {
              break label1093;
            }
            locali = new com.tencent.mm.plugin.record.a.i();
            locali.field_cdnKey = localafy.DfV;
            locali.field_cdnUrl = localafy.gHu;
            locali.field_dataId = ((String)localObject1);
            locali.field_mediaId = ((String)localObject2);
            locali.field_totalLen = ((int)localafy.DgF);
            locali.field_localId = locali.field_mediaId.hashCode();
            locali.field_path = n.f(localafy, this.vak.field_msgId);
            locali.field_type = 2;
            locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            locali.field_recordLocalId = this.vak.field_localId;
            locali.field_toUser = this.vak.field_toUser;
            locali.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
            ad.i("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
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
            ad.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, cdnInfo status:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject2).field_status) });
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
                  ad.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, thumb cdnInfo status:%s", new Object[] { Integer.valueOf(locali.field_status) });
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
            ad.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.vak.field_localId), Long.valueOf(this.vak.field_msgId), Integer.valueOf(this.vak.field_type) });
            ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.vak, new String[] { "localId" });
          }
          if (k == 0)
          {
            ad.i("MicroMsg.RecordMsgSendService", "doSendContinue without cdn task");
            q.this.b(this.vak, false);
            q.this.van = false;
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
    implements com.tencent.mm.al.g, t.a, Runnable
  {
    private boolean cHI;
    private int i;
    HashMap<Long, Boolean> vaF;
    HashMap<Long, String> vaL;
    private j vak;
    
    public b(j paramj)
    {
      AppMethodBeat.i(9556);
      this.i = 0;
      this.vaF = new HashMap();
      this.vaL = new HashMap();
      this.cHI = false;
      this.vak = paramj;
      com.tencent.mm.modelvideo.o.aCI().a(this, Looper.getMainLooper());
      com.tencent.mm.kernel.g.afA().gcy.a(221, this);
      AppMethodBeat.o(9556);
    }
    
    private void a(HashMap<Long, Boolean> paramHashMap, boolean paramBoolean, j paramj)
    {
      AppMethodBeat.i(9561);
      if ((j(paramHashMap)) && (paramBoolean))
      {
        com.tencent.mm.modelvideo.o.aCI().a(this);
        paramj.field_type = 2;
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(paramj, new String[] { "localId" });
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramj);
      }
      AppMethodBeat.o(9561);
    }
    
    private void av(bl parambl)
    {
      AppMethodBeat.i(9560);
      Object localObject = k.b.rx(parambl.field_content);
      if (localObject == null)
      {
        ad.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[] { parambl.field_content });
        AppMethodBeat.o(9560);
        return;
      }
      if ((bt.isNullOrNil(((k.b)localObject).dbA)) && (!bt.isNullOrNil(((k.b)localObject).gHt)))
      {
        ad.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[] { parambl.field_content });
        ((k.b)localObject).dbA = ((k.b)localObject).gHt.hashCode();
      }
      localObject = ((k.b)localObject).dbA;
      if (!a.a(parambl, a.q((String)localObject, parambl.field_msgId)))
      {
        this.vaF.put(Long.valueOf(parambl.field_msgId), Boolean.FALSE);
        this.vaL.put(Long.valueOf(parambl.field_msgId), localObject);
        a.av(parambl);
      }
      AppMethodBeat.o(9560);
    }
    
    private static boolean j(HashMap<Long, Boolean> paramHashMap)
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
      parama = u.Ae(parama.fileName);
      if (parama != null)
      {
        bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(parama.hAi);
        if (parama.aCW())
        {
          this.vaF.put(Long.valueOf(localbl.field_msgId), Boolean.TRUE);
          a(this.vaF, this.cHI, this.vak);
        }
        AppMethodBeat.o(9558);
        return;
      }
      a(null, this.cHI, this.vak);
      AppMethodBeat.o(9558);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(9559);
      if ((paramn instanceof e))
      {
        com.tencent.mm.kernel.g.afA().gcy.b(221, this);
        if (this.vaL != null) {
          paramn = this.vaL.entrySet().iterator();
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
          if ((l <= 0L) || (((Boolean)this.vaF.get(Long.valueOf(l))).booleanValue())) {
            continue;
          }
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(l);
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
          this.vaF.put(Long.valueOf(l), Boolean.TRUE);
          paramString = this.vak.field_dataProto.mVb.iterator();
          while (paramString.hasNext())
          {
            afy localafy = (afy)paramString.next();
            if (localafy.Dhf == l) {
              localafy.aDz(localc.field_fileFullPath);
            }
          }
          break;
          a(this.vaF, this.cHI, this.vak);
          AppMethodBeat.o(9559);
          return;
          a(null, this.cHI, this.vak);
          AppMethodBeat.o(9559);
          return;
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(9557);
      this.i = 0;
      this.cHI = false;
      ad.i("MicroMsg.RecordMsgSendService", "dojob ChatDataDownloadRunnable, info id:%s", new Object[] { Long.valueOf(this.vak.field_msgId) });
      if (this.vak.field_dataProto == null)
      {
        ad.w("MicroMsg.RecordMsgSendService", "ChatDataDownloadRunnable info.field_dataProto null");
        this.cHI = true;
        q.this.van = false;
        a(null, this.cHI, this.vak);
        AppMethodBeat.o(9557);
        return;
      }
      Iterator localIterator = this.vak.field_dataProto.mVb.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (afy)localIterator.next();
        final long l = ((afy)localObject1).Dhf;
        label438:
        if (l > 0L)
        {
          final bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(l);
          Object localObject2 = ((afy)localObject1).Dgx;
          if ((System.currentTimeMillis() - localbl.field_createTime > 259200000L) && ((bt.isNullOrNil((String)localObject2)) || (!com.tencent.mm.vfs.i.eK((String)localObject2)))) {}
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              break label239;
            }
            ad.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", new Object[] { Integer.valueOf(localbl.getType()) });
            break;
          }
          label239:
          if (((afy)localObject1).dataType == 2)
          {
            if (localbl.eJO())
            {
              localObject2 = com.tencent.mm.aw.o.ayF().mr(localbl.field_msgSvrId);
              if (localbl.field_isSend == 1) {
                if (((com.tencent.mm.aw.e)localObject2).ayi()) {
                  j = 1;
                }
              }
              for (;;)
              {
                if ((((com.tencent.mm.aw.e)localObject2).offset >= ((com.tencent.mm.aw.e)localObject2).gTY) && (((com.tencent.mm.aw.e)localObject2).gTY != 0)) {
                  break label438;
                }
                this.vaF.put(Long.valueOf(l), Boolean.FALSE);
                this.i = this.vak.field_dataProto.mVb.indexOf(localObject1);
                com.tencent.mm.aw.o.ayG().a(((com.tencent.mm.aw.e)localObject2).deI, localbl.field_msgId, j, localObject1, 2131231564, new d.a()
                {
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
                  {
                    AppMethodBeat.i(9555);
                    q.b.this.vaF.put(Long.valueOf(l), Boolean.TRUE);
                    q.b.a(q.b.this, q.b.this.vaF, q.b.c(q.b.this), q.b.b(q.b.this));
                    AppMethodBeat.o(9555);
                  }
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.al.n paramAnonymousn) {}
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
                  {
                    AppMethodBeat.i(9554);
                    boolean bool;
                    if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0))
                    {
                      bool = true;
                      ad.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                      if (!(paramAnonymousObject instanceof afy)) {
                        break label303;
                      }
                      paramAnonymousObject = (afy)paramAnonymousObject;
                      paramAnonymousObject.aDz(com.tencent.mm.aw.o.ayF().p(com.tencent.mm.aw.f.c(this.hib), "", ""));
                      paramAnonymousObject.aDA(com.tencent.mm.aw.o.ayF().Q(localbl.field_imgPath, true));
                      paramAnonymousString = bw.K(this.hib.hgv, "msg");
                      if (paramAnonymousString == null) {
                        break label279;
                      }
                      paramAnonymousObject.aDp((String)paramAnonymousString.get(".msg.img.$cdnbigimgurl"));
                      paramAnonymousObject.vp(bt.getInt((String)paramAnonymousString.get(".msg.img.$length"), 0));
                      paramAnonymousObject.aDq((String)paramAnonymousString.get(".msg.img.$aeskey"));
                      q.b.b(q.b.this).field_dataProto.mVb.set(q.b.a(q.b.this), paramAnonymousObject);
                      label216:
                      q.b.this.vaF.put(Long.valueOf(paramAnonymousObject.Dhf), Boolean.TRUE);
                    }
                    for (;;)
                    {
                      q.b.a(q.b.this, q.b.this.vaF, q.b.c(q.b.this), q.b.b(q.b.this));
                      AppMethodBeat.o(9554);
                      return;
                      bool = false;
                      break;
                      label279:
                      ad.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", new Object[] { this.hib.hgv });
                      break label216;
                      label303:
                      q.b.this.vaF.put(Long.valueOf(l), Boolean.TRUE);
                    }
                  }
                });
                break;
                j = 0;
                continue;
                if (!((com.tencent.mm.aw.e)localObject2).ayi())
                {
                  j = 0;
                }
                else
                {
                  com.tencent.mm.aw.e locale = com.tencent.mm.aw.f.a((com.tencent.mm.aw.e)localObject2);
                  if (!com.tencent.mm.vfs.i.eK(com.tencent.mm.aw.o.ayF().p(locale.hgj, "", ""))) {
                    j = 0;
                  } else {
                    j = 1;
                  }
                }
              }
            }
            else if (localbl.eMb())
            {
              av(localbl);
            }
          }
          else if ((((afy)localObject1).dataType == 4) || (((afy)localObject1).dataType == 15))
          {
            localObject1 = u.Ae(localbl.field_imgPath);
            if ((localObject1 != null) && (((s)localObject1).status != 199))
            {
              this.vaF.put(Long.valueOf(l), Boolean.FALSE);
              if (((s)localObject1).aCV())
              {
                ad.i("MicroMsg.RecordMsgSendService", "start complete online video");
                u.Al(localbl.field_imgPath);
              }
              else
              {
                ad.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                u.zZ(localbl.field_imgPath);
              }
            }
          }
          else if ((((afy)localObject1).dataType == 8) && (!bt.isNullOrNil(((afy)localObject1).Dhr)))
          {
            av(localbl);
          }
        }
      }
      this.cHI = true;
      q.this.van = false;
      a(this.vaF, this.cHI, this.vak);
      AppMethodBeat.o(9557);
    }
  }
  
  final class c
    implements Runnable
  {
    private j vak;
    
    public c(j paramj)
    {
      this.vak = paramj;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9564);
      ad.i("MicroMsg.RecordMsgSendService", "dojob FavDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.vak.field_msgId) });
      Object localObject = this.vak.field_dataProto.mVb.iterator();
      for (int i = 0; ((Iterator)localObject).hasNext(); i = 1)
      {
        label46:
        afy localafy = (afy)((Iterator)localObject).next();
        gs localgs = new gs();
        localgs.dkc.type = 2;
        localgs.dkc.dke = localafy;
        com.tencent.mm.sdk.b.a.ESL.l(localgs);
        ad.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[] { localafy.dkb, Integer.valueOf(localafy.dataType) });
        String str;
        if (!bt.isNullOrNil(localgs.dkd.path))
        {
          str = n.c(localafy, this.vak.field_msgId);
          ad.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[] { localgs.dkd.path, str });
          if (!localgs.dkd.path.equals(str)) {
            com.tencent.mm.vfs.i.lC(localgs.dkd.path, str);
          }
        }
        if (!bt.isNullOrNil(localgs.dkd.thumbPath))
        {
          str = n.f(localafy, this.vak.field_msgId);
          ad.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[] { localgs.dkd.thumbPath, str });
          if (!localgs.dkd.thumbPath.equals(str)) {
            com.tencent.mm.vfs.i.lC(localgs.dkd.thumbPath, str);
          }
        }
        if (localafy.dataType == 3)
        {
          ad.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
          localafy.aDq("");
          localafy.aDp("");
          localafy.aDo("");
          localafy.aDn("");
        }
        if ((bt.isNullOrNil(localafy.DfZ)) && (bt.isNullOrNil(localafy.gHu))) {
          break label46;
        }
      }
      if (i != 0)
      {
        com.tencent.mm.kernel.g.afA().gcy.a(new f(this.vak), 0);
        AppMethodBeat.o(9564);
        return;
      }
      localObject = k.b.a(n.a(this.vak.field_title, this.vak.field_desc, this.vak.field_dataProto), null, null);
      q.this.d(this.vak.field_msgId, this.vak.field_localId, (String)localObject);
      q.this.van = false;
      q.this.a(null, false);
      AppMethodBeat.o(9564);
    }
  }
  
  final class d
    implements Runnable
  {
    private boolean vaO;
    private j vak;
    
    public d(j paramj, boolean paramBoolean)
    {
      this.vak = paramj;
      this.vaO = paramBoolean;
    }
    
    private byte a(afy paramafy, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(9568);
      int k = 0;
      int j = 0;
      int i = 0;
      int m = paramafy.dataType;
      byte b1;
      if ((paramBoolean) && (m == 17))
      {
        ad.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() inner record");
        paramafy = n.alt(paramafy.Dhj);
        if (paramafy == null)
        {
          AppMethodBeat.o(9568);
          return 0;
        }
        paramafy = paramafy.gKs.iterator();
        for (b1 = 0; paramafy.hasNext(); b1 = (byte)(i | b1))
        {
          i = a((afy)paramafy.next(), paramInt + 1, paramBoolean);
          ad.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable circleTraverseFavDataItem() %s result:%s ", new Object[] { Long.toBinaryString(i), Long.toBinaryString((byte)(i | b1)) });
        }
        AppMethodBeat.o(9568);
        return b1;
      }
      String str1;
      String str2;
      if ((!bt.isNullOrNil(paramafy.DfZ)) || (!bt.isNullOrNil(paramafy.Dhr)))
      {
        str1 = n.a(paramafy, this.vak.field_oriMsgId, paramInt);
        str2 = n.a(paramafy, this.vak.field_msgId, paramInt);
        if (com.tencent.mm.vfs.i.lC(str1, str2) <= 0L) {
          break label1059;
        }
        paramBoolean = true;
        ad.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          if (!bt.isNullOrNil(paramafy.Dgq)) {
            break label1232;
          }
          ad.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
          paramafy.aDw(com.tencent.mm.vfs.i.aEN(str2));
        }
      }
      label689:
      label1213:
      label1232:
      for (i = 1;; i = 0)
      {
        if (bt.isNullOrNil(paramafy.Dgs))
        {
          ad.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
          paramafy.aDx(com.tencent.mm.b.g.dE(str2));
        }
        for (j = 1;; j = i)
        {
          str2 = n.ej(paramafy.dkb, paramInt);
          str1 = n.h(str2, this.vak.field_msgId, false);
          Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als(str1);
          com.tencent.mm.plugin.record.a.i locali;
          if (localObject == null)
          {
            localObject = new com.tencent.mm.plugin.record.a.i();
            ((com.tencent.mm.plugin.record.a.i)localObject).field_cdnKey = paramafy.Dgb;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_cdnUrl = paramafy.DfZ;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_dataId = str2;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_mediaId = str1;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_totalLen = ((int)paramafy.Dgu);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_localId = ((com.tencent.mm.plugin.record.a.i)localObject).field_mediaId.hashCode();
            ((com.tencent.mm.plugin.record.a.i)localObject).field_path = n.a(paramafy, this.vak.field_msgId, paramInt);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_type = 2;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_fileType = n.gH(paramafy.dataType, (int)paramafy.Dgu);
            ((com.tencent.mm.plugin.record.a.i)localObject).field_recordLocalId = this.vak.field_localId;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_toUser = this.vak.field_toUser;
            ((com.tencent.mm.plugin.record.a.i)localObject).field_isThumb = false;
            str2 = n.a(paramafy, this.vak.field_msgId, paramInt);
            if ((!bt.isNullOrNil(paramafy.Dhr)) && (!com.tencent.mm.vfs.i.eK(str2)))
            {
              ((com.tencent.mm.plugin.record.a.i)localObject).field_status = -1;
              a(paramafy, str2, str1);
            }
            i = 1;
            paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.i)localObject);
            ad.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_recordLocalId), ((com.tencent.mm.plugin.record.a.i)localObject).field_dataId, ((com.tencent.mm.plugin.record.a.i)localObject).field_mediaId });
            k = j;
            if (bt.isNullOrNil(paramafy.gHu))
            {
              j = i;
              if (bt.isNullOrNil(paramafy.gHl)) {}
            }
            else
            {
              str1 = n.b(paramafy, this.vak.field_oriMsgId, paramInt);
              str2 = n.b(paramafy, this.vak.field_msgId, paramInt);
              if (com.tencent.mm.vfs.i.lC(str1, str2) <= 0L) {
                break label1136;
              }
              paramBoolean = true;
              ad.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
              str1 = n.ej(n.XS(paramafy.dkb), paramInt);
              str2 = n.h(str1, this.vak.field_msgId, false);
              locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als(str2);
              localObject = n.b(paramafy, this.vak.field_msgId, paramInt);
              if (locali != null) {
                break label1141;
              }
              locali = new com.tencent.mm.plugin.record.a.i();
              locali.field_cdnKey = paramafy.DfV;
              locali.field_cdnUrl = paramafy.gHu;
              locali.field_dataId = str1;
              locali.field_mediaId = str2;
              locali.field_totalLen = ((int)paramafy.DgF);
              locali.field_localId = locali.field_mediaId.hashCode();
              locali.field_path = n.b(paramafy, this.vak.field_msgId, paramInt);
              locali.field_type = 2;
              locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
              locali.field_recordLocalId = this.vak.field_localId;
              locali.field_toUser = this.vak.field_toUser;
              locali.field_isThumb = true;
              if ((!bt.isNullOrNil(paramafy.gHl)) && (!com.tencent.mm.vfs.i.eK((String)localObject)))
              {
                locali.field_status = -1;
                b(paramafy, (String)localObject, str2);
              }
              j = 1;
              paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
              ad.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(locali.field_recordLocalId), locali.field_dataId, locali.field_mediaId });
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
            a(paramafy, n.a(paramafy, this.vak.field_msgId, paramInt), str1);
          }
          for (i = 1;; i = 0)
          {
            if (((com.tencent.mm.plugin.record.a.i)localObject).field_status == 0) {
              i = 1;
            }
            ad.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_status) });
            k = j;
            break;
            label1136:
            paramBoolean = false;
            break label689;
            label1141:
            if (locali.field_status == -1)
            {
              b(paramafy, n.b(paramafy, this.vak.field_msgId, paramInt), str2);
              i = 1;
            }
            if (locali.field_status == 0) {
              i = 1;
            }
            ad.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(locali.field_status) });
            j = i;
            break label1026;
            b1 = 0;
            break label1034;
          }
        }
      }
    }
    
    private void a(final afy paramafy, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9569);
      ad.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", new Object[] { paramafy.dkb, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.field_fileType = 19;
      localg.field_authKey = paramafy.gHq;
      localg.field_aesKey = paramafy.Dho;
      localg.fnK = paramafy.Dhr;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.fnH = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9565);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              ad.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl done id:%s, mediaId:%s, path:%s", new Object[] { paramafy.dkb, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramafy.dkb;
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramafy.dkb;
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
        if (!com.tencent.mm.ao.f.awL().b(localg, -1)) {
          ad.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
        }
        AppMethodBeat.o(9569);
        return;
        paramString2 = paramString2 + "_tp";
      }
    }
    
    private void b(final afy paramafy, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9570);
      ad.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramafy.dkb, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.field_fileType = 19;
      localg.field_authKey = paramafy.gHq;
      localg.field_aesKey = paramafy.gHr;
      localg.fnK = paramafy.gHl;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.fnH = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9566);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              ad.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramafy.dkb, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramafy.dkb;
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramafy.dkb;
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
        if (!com.tencent.mm.ao.f.awL().b(localg, -1)) {
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
      if (this.vak.field_dataProto == null)
      {
        ad.w("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable info.field_dataProto null");
        q.this.van = false;
        AppMethodBeat.o(9567);
        return;
      }
      Iterator localIterator = this.vak.field_dataProto.mVb.iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      if (localIterator.hasNext())
      {
        int i = a((afy)localIterator.next(), 1, this.vaO);
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
        ad.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable startEmbedded:%s infochanged:%s, needRun:%s", new Object[] { Boolean.valueOf(this.vaO), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (bool2)
        {
          ad.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.vak.field_localId), Long.valueOf(this.vak.field_msgId), Integer.valueOf(this.vak.field_type) });
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.vak, new String[] { "localId" });
        }
        if (!bool1)
        {
          ad.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable doSendContinue");
          q.this.b(this.vak, false);
          q.this.van = false;
          q.this.a(null, false);
        }
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9567);
        return;
      }
    }
  }
  
  static final class e
  {
    int hUz;
    long vau;
    
    private e()
    {
      AppMethodBeat.i(9571);
      this.vau = SystemClock.elapsedRealtime();
      this.hUz = 3;
      AppMethodBeat.o(9571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.q
 * JD-Core Version:    0.7.0.1
 */