package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.e.a;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.record.a.d, com.tencent.mm.plugin.record.a.i
{
  boolean BGI;
  SparseArray<e> BGL;
  LinkedList<com.tencent.mm.plugin.record.a.k> BGM;
  private int BHh;
  
  public s()
  {
    AppMethodBeat.i(9572);
    this.BGI = false;
    this.BGL = new SparseArray();
    this.BGM = new LinkedList();
    this.BHh = 7;
    com.tencent.mm.kernel.g.aAg().hqi.a(632, this);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    try
    {
      this.BHh = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVQ, 7);
      AppMethodBeat.o(9572);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.RecordMsgSendService", localException, "RecordMsgSendService init error.", new Object[0]);
      AppMethodBeat.o(9572);
    }
  }
  
  private boolean a(j paramj, aml paramaml, int paramInt)
  {
    AppMethodBeat.i(9581);
    com.tencent.mm.protocal.b.a.c localc = p.aKY(paramaml.Lwx);
    if (localc == null)
    {
      Log.i("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() msgData == null");
      AppMethodBeat.o(9581);
      return false;
    }
    boolean bool = a(paramj, localc.iAd, paramInt + 1);
    Log.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramaml.bgF(p.a(localc, paramaml.Lwx));
    }
    AppMethodBeat.o(9581);
    return bool;
  }
  
  private boolean a(j paramj, List<aml> paramList, int paramInt)
  {
    AppMethodBeat.i(9580);
    paramList = paramList.iterator();
    boolean bool1 = false;
    aml localaml;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label229;
        }
        localaml = (aml)paramList.next();
        int i = localaml.dataType;
        Log.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localaml.dLl, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = a(paramj, localaml, paramInt);
      }
    } while (!paramj.field_dataId.equals(p.fj(p.arI(localaml.dLl), paramInt)));
    Log.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localaml.Lvk, paramj.field_cdnKey, localaml.iwX, paramj.field_cdnUrl, Long.valueOf(localaml.LvT), Integer.valueOf(paramj.field_totalLen) });
    localaml.bgi(paramj.field_cdnKey);
    localaml.bgh(paramj.field_cdnUrl);
    if (!Util.isEqual(paramInt, 1)) {
      localaml.bgs(p.ds(localaml.toString(), localaml.dataType));
    }
    boolean bool2 = true;
    label229:
    AppMethodBeat.o(9580);
    return bool2;
  }
  
  private boolean b(j paramj, aml paramaml, int paramInt)
  {
    AppMethodBeat.i(9583);
    com.tencent.mm.protocal.b.a.c localc = p.aKY(paramaml.Lwx);
    if (localc == null)
    {
      Log.i("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() msgData == null");
      AppMethodBeat.o(9583);
      return false;
    }
    boolean bool = b(paramj, localc.iAd, paramInt + 1);
    Log.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramaml.bgF(p.a(localc, paramaml.Lwx));
    }
    AppMethodBeat.o(9583);
    return bool;
  }
  
  private boolean b(j paramj, List<aml> paramList, int paramInt)
  {
    AppMethodBeat.i(9582);
    paramList = paramList.iterator();
    boolean bool1 = false;
    aml localaml;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label228;
        }
        localaml = (aml)paramList.next();
        int i = localaml.dataType;
        Log.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localaml.dLl, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = b(paramj, localaml, paramInt);
      }
    } while (!paramj.field_dataId.equals(p.fj(localaml.dLl, paramInt)));
    Log.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localaml.Lvp, paramj.field_cdnKey, localaml.KuR, paramj.field_cdnUrl, Long.valueOf(localaml.LvI), Integer.valueOf(paramj.field_totalLen) });
    localaml.bgk(paramj.field_cdnKey);
    localaml.bgj(paramj.field_cdnUrl);
    if (!Util.isEqual(paramInt, 1)) {
      localaml.bgs(p.ds(localaml.toString(), localaml.dataType));
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
      Log.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(9579);
      return;
    }
    if (paramj == null)
    {
      Log.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
      AppMethodBeat.o(9579);
      return;
    }
    if (2 != paramj.field_type)
    {
      Log.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload , mediaid:%s, recordLocalId:%d, status:%d", new Object[] { paramj.field_mediaId, Integer.valueOf(paramj.field_recordLocalId), Integer.valueOf(paramj.field_status) });
      AppMethodBeat.o(9579);
      return;
    }
    if ((paramj.field_status == 0) || (1 == paramj.field_status) || (-1 == paramj.field_status))
    {
      Log.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
      AppMethodBeat.o(9579);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().Vt(paramj.field_recordLocalId);
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (j)((Iterator)localObject2).next();
      if ((((j)localObject3).field_status == 0) || (1 == ((j)localObject3).field_status) || (-1 == ((j)localObject3).field_status)) {
        Log.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[] { ((j)localObject3).field_mediaId });
      }
    }
    for (paramInt = 0;; paramInt = 1)
    {
      Log.i("MicroMsg.RecordMsgSendService", "on cdn storage changed cdnInfoList.size:%d,", new Object[] { Integer.valueOf(((List)localObject1).size()) });
      if (paramInt == 0)
      {
        AppMethodBeat.o(9579);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Vv(paramj.field_recordLocalId);
      paramInt = paramj.field_recordLocalId;
      boolean bool;
      if (localObject2 != null)
      {
        bool = true;
        Log.i("MicroMsg.RecordMsgSendService", "finish get record info, id %d result %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (localObject2 != null)
        {
          paramj = ((com.tencent.mm.plugin.record.a.k)localObject2).field_dataProto.ppH;
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
          Log.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", new Object[] { localj.field_dataId, Boolean.valueOf(localj.field_isThumb) });
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
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((j)localObject1, new String[] { "localId" });
      }
      this.BGI = false;
      a(null, false);
      AppMethodBeat.o(9579);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.record.a.k paramk)
  {
    AppMethodBeat.i(258374);
    a(paramk, false);
    AppMethodBeat.o(258374);
  }
  
  public final void a(final com.tencent.mm.plugin.record.a.k paramk, final boolean paramBoolean)
  {
    AppMethodBeat.i(9574);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9551);
        if (paramk != null)
        {
          if ((s.e)s.this.BGL.get(paramk.field_localId) == null)
          {
            Log.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[] { Integer.valueOf(paramk.field_localId), Long.valueOf(paramk.field_msgId) });
            localObject1 = new s.e((byte)0);
            s.this.BGL.put(paramk.field_localId, localObject1);
          }
          s.this.b(paramk);
        }
        s locals = s.this;
        boolean bool = paramBoolean;
        if (locals.BGI)
        {
          Log.i("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
          AppMethodBeat.o(9551);
          return;
        }
        if (locals.BGM.isEmpty())
        {
          Log.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
          localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().eIl().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.record.a.k)((Iterator)localObject1).next();
            if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(((com.tencent.mm.plugin.record.a.k)localObject2).field_msgId).getType() != 49)
            {
              Log.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId), Long.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_msgId) });
              ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Vu(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId);
            }
            else
            {
              localObject3 = (s.e)locals.BGL.get(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId);
              if (localObject3 != null)
              {
                if ((((s.e)localObject3).jNv < 0) && (SystemClock.elapsedRealtime() - ((s.e)localObject3).BGP < 300000L)) {
                  continue;
                }
                if (((s.e)localObject3).jNv < 0) {
                  ((s.e)localObject3).jNv = 3;
                }
              }
              for (;;)
              {
                Log.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId), Long.valueOf(((com.tencent.mm.plugin.record.a.k)localObject2).field_msgId) });
                locals.b((com.tencent.mm.plugin.record.a.k)localObject2);
                break;
                localObject3 = new s.e((byte)0);
                locals.BGL.put(((com.tencent.mm.plugin.record.a.k)localObject2).field_localId, localObject3);
              }
            }
          }
        }
        if (locals.BGM.isEmpty())
        {
          Log.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
          locals.finish();
          AppMethodBeat.o(9551);
          return;
        }
        Object localObject3 = (com.tencent.mm.plugin.record.a.k)locals.BGM.removeFirst();
        Object localObject2 = (s.e)locals.BGL.get(((com.tencent.mm.plugin.record.a.k)localObject3).field_localId);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new s.e((byte)0);
          locals.BGL.put(((com.tencent.mm.plugin.record.a.k)localObject3).field_localId, localObject1);
        }
        ((s.e)localObject1).jNv -= 1;
        int i;
        if (((s.e)localObject1).jNv < 0) {
          if (300000L > SystemClock.elapsedRealtime() - ((s.e)localObject1).BGP) {
            i = 0;
          }
        }
        while (i != 0)
        {
          locals.BGI = true;
          switch (((com.tencent.mm.plugin.record.a.k)localObject3).field_type)
          {
          default: 
            locals.BGI = false;
            AppMethodBeat.o(9551);
            return;
            ((s.e)localObject1).jNv = 2;
            ((s.e)localObject1).BGP = SystemClock.elapsedRealtime();
            i = 1;
            break;
          case 1: 
            ThreadPool.post(new s.c(locals, (com.tencent.mm.plugin.record.a.k)localObject3), "RecordMsgSendService_favDataCopy");
            AppMethodBeat.o(9551);
            return;
          case 2: 
            ThreadPool.post(new s.a(locals, (com.tencent.mm.plugin.record.a.k)localObject3), "RecordMsgSendService_chatDataCopy");
            AppMethodBeat.o(9551);
            return;
          case 0: 
            ThreadPool.post(new s.d(locals, (com.tencent.mm.plugin.record.a.k)localObject3, bool), "RecordMsgSendService_normalDataCopy");
            AppMethodBeat.o(9551);
            return;
          case 3: 
            ThreadPool.post(new s.b(locals, (com.tencent.mm.plugin.record.a.k)localObject3), "RecordMsgSendService_chatDataDownLoad");
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
    if (!this.BGM.contains(paramk)) {
      this.BGM.add(paramk);
    }
    AppMethodBeat.o(9575);
  }
  
  final void b(com.tencent.mm.plugin.record.a.k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(9584);
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramk.field_msgId);
    Log.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d, afterCdnUpload %s, toUser:%s", new Object[] { Boolean.FALSE, Long.valueOf(localca.field_msgId), Long.valueOf(paramk.field_msgId), Integer.valueOf(paramk.field_localId), Boolean.valueOf(paramBoolean), paramk.field_toUser });
    if (localca.field_msgId == paramk.field_msgId)
    {
      localca.setContent(p.a(paramk.field_title, paramk.field_desc, paramk.field_dataProto, paramk.field_favFrom, paramk.field_msgId));
      localca.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(paramk.field_msgId, localca);
    }
    com.tencent.mm.ag.k localk = com.tencent.mm.plugin.r.a.eAT().GL(paramk.field_msgId);
    if (localk != null)
    {
      localk.field_xml = localca.field_content;
      com.tencent.mm.plugin.r.a.eAT().update(localk, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Vu(paramk.field_localId);
    this.BGL.remove(paramk.field_localId);
    if (localca.field_createTime + this.BHh * 24 * 3600 * 1000 < cl.aWz())
    {
      Log.i("MicroMsg.RecordMsgSendService", "doSendContinue, out of wait time, " + localca.field_createTime);
      localca.setStatus(5);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(paramk.field_msgId, localca);
      AppMethodBeat.o(9584);
      return;
    }
    if (!p.a(paramk.field_toUser, paramk.field_msgId, true, "")) {
      ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.g.class)).HR(paramk.field_msgId);
    }
    AppMethodBeat.o(9584);
  }
  
  final void f(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(9578);
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramLong);
    if (localca.field_msgId == paramLong)
    {
      localca.setContent(paramString);
      localca.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(paramLong, localca);
    }
    paramString = com.tencent.mm.plugin.r.a.eAT().GL(paramLong);
    if (paramString != null)
    {
      paramString.field_xml = localca.field_content;
      com.tencent.mm.plugin.r.a.eAT().update(paramString, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Vu(paramInt);
    this.BGL.remove(paramInt);
    ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.g.class)).HR(paramLong);
    Log.i("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(9578);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(9576);
    this.BGM.clear();
    this.BGL.clear();
    this.BGI = false;
    AppMethodBeat.o(9576);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(9577);
    Log.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramq == null)
    {
      Log.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
      AppMethodBeat.o(9577);
      return;
    }
    switch (paramq.getType())
    {
    default: 
      this.BGI = false;
      a(null, false);
      AppMethodBeat.o(9577);
      return;
    }
    Log.i("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (g)paramq;
    int k = paramInt1;
    int i = paramInt2;
    aml localaml;
    if (paramInt1 == 3)
    {
      paramq = paramString.BGF.field_dataProto.ppH.iterator();
      do
      {
        if (!paramq.hasNext()) {
          break;
        }
        localaml = (aml)paramq.next();
      } while ((Util.isNullOrNil(localaml.KuR)) && (Util.isNullOrNil(localaml.iwX)));
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
        f(paramString.BGF.field_msgId, paramString.BGF.field_localId, paramString.BGE);
        break;
      }
      Log.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[] { Long.valueOf(paramString.BGF.field_msgId), Integer.valueOf(paramString.BGF.field_localId) });
      Log.w("MicroMsg.RecordMsgSendService", "try upload from local");
      paramq = paramString.BGF.field_dataProto.ppH.iterator();
      while (paramq.hasNext())
      {
        localaml = (aml)paramq.next();
        String str;
        Object localObject;
        boolean bool;
        if (localaml.LvI > 0L)
        {
          str = p.g(localaml.dLl, paramString.BGF.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(str) == null)
          {
            localObject = new j();
            ((j)localObject).field_cdnKey = localaml.Lvp;
            ((j)localObject).field_cdnUrl = localaml.KuR;
            ((j)localObject).field_dataId = localaml.dLl;
            ((j)localObject).field_mediaId = str;
            ((j)localObject).field_totalLen = ((int)localaml.LvI);
            ((j)localObject).field_localId = ((j)localObject).field_mediaId.hashCode();
            ((j)localObject).field_path = p.c(localaml, paramString.BGF.field_msgId);
            ((j)localObject).field_type = 2;
            ((j)localObject).field_fileType = p.hR(localaml.dataType, (int)localaml.LvI);
            ((j)localObject).field_recordLocalId = paramString.BGF.field_localId;
            ((j)localObject).field_toUser = paramString.BGF.field_toUser;
            ((j)localObject).field_isThumb = false;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject);
            Log.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(((j)localObject).field_localId), Boolean.valueOf(bool) });
          }
        }
        if (localaml.LvT > 0L)
        {
          str = p.arI(localaml.dLl);
          localObject = p.g(str, paramString.BGF.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX((String)localObject) == null)
          {
            j localj = new j();
            localj.field_cdnKey = localaml.Lvk;
            localj.field_cdnUrl = localaml.iwX;
            localj.field_dataId = str;
            localj.field_mediaId = ((String)localObject);
            localj.field_totalLen = ((int)localaml.LvT);
            localj.field_localId = localj.field_mediaId.hashCode();
            localj.field_path = p.f(localaml, paramString.BGF.field_msgId);
            localj.field_type = 2;
            localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            localj.field_recordLocalId = paramString.BGF.field_localId;
            localj.field_toUser = paramString.BGF.field_toUser;
            localj.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
            Log.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
          }
        }
      }
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
      AppMethodBeat.o(9577);
      return;
    }
  }
  
  final class a
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k BGF;
    
    public a(com.tencent.mm.plugin.record.a.k paramk)
    {
      this.BGF = paramk;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9553);
      int m = 0;
      int i = 0;
      Log.i("MicroMsg.RecordMsgSendService", "dojob ChatDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.BGF.field_msgId) });
      int j;
      int k;
      aml localaml;
      Object localObject1;
      Object localObject2;
      boolean bool;
      if ((this.BGF != null) && (this.BGF.field_dataProto != null) && (this.BGF.field_dataProto.ppH != null))
      {
        Iterator localIterator = this.BGF.field_dataProto.ppH.iterator();
        j = 0;
        m = i;
        k = j;
        if (!localIterator.hasNext()) {
          break label1167;
        }
        localaml = (aml)localIterator.next();
        if ((Util.isNullOrNil(localaml.KuR)) && (!com.tencent.mm.vfs.s.YS(localaml.LvL))) {
          break label1335;
        }
        localObject1 = localaml.LvL;
        localObject2 = p.c(localaml, this.BGF.field_msgId);
        if (com.tencent.mm.vfs.s.nw((String)localObject1, (String)localObject2) > 0L)
        {
          bool = true;
          label167:
          Log.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[] { localaml.KuR, localObject1, localObject2, Boolean.valueOf(bool) });
          k = i;
          if (!bool) {
            break label1330;
          }
          if (Util.isNullOrNil(localaml.LvE))
          {
            Log.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
            localaml.bgq(com.tencent.mm.vfs.s.bhK((String)localObject2));
            i = 1;
          }
          k = i;
          if (!Util.isNullOrNil(localaml.LvG)) {
            break label1330;
          }
          Log.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
          localObject1 = com.tencent.mm.vfs.s.aW((String)localObject2, 0, 256);
          if (localObject1 != null) {
            break label990;
          }
          localObject1 = null;
          label281:
          localaml.bgr((String)localObject1);
          i = 1;
          label291:
          if (com.tencent.mm.vfs.s.boW((String)localObject2) != 0L) {
            localaml.Mu(com.tencent.mm.vfs.s.boW((String)localObject2));
          }
          localObject1 = p.g(localaml.dLl, this.BGF.field_msgId, false);
          localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX((String)localObject1);
          if (localObject2 != null) {
            break label1000;
          }
          localObject2 = new j();
          ((j)localObject2).field_cdnKey = localaml.Lvp;
          ((j)localObject2).field_cdnUrl = localaml.KuR;
          ((j)localObject2).field_dataId = localaml.dLl;
          ((j)localObject2).field_mediaId = ((String)localObject1);
          ((j)localObject2).field_totalLen = ((int)localaml.LvI);
          ((j)localObject2).field_localId = ((j)localObject2).field_mediaId.hashCode();
          ((j)localObject2).field_path = p.c(localaml, this.BGF.field_msgId);
          ((j)localObject2).field_type = 2;
          ((j)localObject2).field_fileType = p.hR(localaml.dataType, (int)localaml.LvI);
          ((j)localObject2).field_recordLocalId = this.BGF.field_localId;
          ((j)localObject2).field_toUser = this.BGF.field_toUser;
          ((j)localObject2).field_isThumb = false;
          bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject2);
          m = 1;
          Log.i("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[] { Integer.valueOf(((j)localObject2).field_localId), Boolean.valueOf(bool), Integer.valueOf(((j)localObject2).field_fileType), localObject1 });
          k = i;
        }
      }
      for (;;)
      {
        label572:
        if (Util.isNullOrNil(localaml.iwX))
        {
          j = k;
          if (!com.tencent.mm.vfs.s.YS(localaml.LvN)) {}
        }
        else
        {
          localObject1 = localaml.LvN;
          localObject2 = p.f(localaml, this.BGF.field_msgId);
          if (com.tencent.mm.vfs.s.nw((String)localObject1, (String)localObject2) > 0L) {}
          j localj;
          for (bool = true;; bool = false)
          {
            Log.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
            localaml.Mv(com.tencent.mm.vfs.s.boW((String)localObject2));
            i = k;
            if (bool)
            {
              i = k;
              if (Util.isNullOrNil(localaml.LvP))
              {
                Log.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                localaml.bgv(com.tencent.mm.vfs.s.bhK((String)localObject2));
                i = 1;
              }
              if (Util.isNullOrNil(localaml.LvR))
              {
                Log.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                localaml.bgw(com.tencent.mm.b.g.fb((String)localObject2));
                i = 1;
              }
            }
            localObject1 = p.arI(localaml.dLl);
            localObject2 = p.g((String)localObject1, this.BGF.field_msgId, false);
            localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX((String)localObject2);
            if (localj != null) {
              break label1093;
            }
            localj = new j();
            localj.field_cdnKey = localaml.Lvk;
            localj.field_cdnUrl = localaml.iwX;
            localj.field_dataId = ((String)localObject1);
            localj.field_mediaId = ((String)localObject2);
            localj.field_totalLen = ((int)localaml.LvT);
            localj.field_localId = localj.field_mediaId.hashCode();
            localj.field_path = p.f(localaml, this.BGF.field_msgId);
            localj.field_type = 2;
            localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            localj.field_recordLocalId = this.BGF.field_localId;
            localj.field_toUser = this.BGF.field_toUser;
            localj.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
            Log.i("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
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
            Log.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, cdnInfo status:%s", new Object[] { Integer.valueOf(((j)localObject2).field_status) });
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
                  Log.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, thumb cdnInfo status:%s", new Object[] { Integer.valueOf(localj.field_status) });
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
            Log.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.BGF.field_localId), Long.valueOf(this.BGF.field_msgId), Integer.valueOf(this.BGF.field_type) });
            ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.BGF, new String[] { "localId" });
          }
          if (k == 0)
          {
            Log.i("MicroMsg.RecordMsgSendService", "doSendContinue without cdn task");
            s.this.b(this.BGF, false);
            s.this.BGI = false;
            s.this.a(null, false);
          }
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
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
    implements com.tencent.mm.ak.i, t.a, Runnable
  {
    private com.tencent.mm.plugin.record.a.k BGF;
    HashMap<Long, Boolean> BHb;
    HashMap<Long, String> BHl;
    private boolean dgZ;
    private int i;
    
    public b(com.tencent.mm.plugin.record.a.k paramk)
    {
      AppMethodBeat.i(9556);
      this.i = 0;
      this.BHb = new HashMap();
      this.BHl = new HashMap();
      this.dgZ = false;
      this.BGF = paramk;
      o.bhj().a(this, Looper.getMainLooper());
      com.tencent.mm.kernel.g.aAg().hqi.a(221, this);
      AppMethodBeat.o(9556);
    }
    
    private void a(HashMap<Long, Boolean> paramHashMap, boolean paramBoolean, com.tencent.mm.plugin.record.a.k paramk)
    {
      AppMethodBeat.i(9561);
      if ((m(paramHashMap)) && (paramBoolean))
      {
        o.bhj().a(this);
        paramk.field_type = 2;
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(paramk, new String[] { "localId" });
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramk);
      }
      AppMethodBeat.o(9561);
    }
    
    private void aK(ca paramca)
    {
      AppMethodBeat.i(9560);
      Object localObject = k.b.HD(paramca.field_content);
      if (localObject == null)
      {
        Log.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[] { paramca.field_content });
        AppMethodBeat.o(9560);
        return;
      }
      if ((Util.isNullOrNil(((k.b)localObject).dCK)) && (!Util.isNullOrNil(((k.b)localObject).iwW)))
      {
        Log.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[] { paramca.field_content });
        ((k.b)localObject).dCK = ((k.b)localObject).iwW.hashCode();
      }
      localObject = ((k.b)localObject).dCK;
      if (!a.a(paramca, a.s((String)localObject, paramca.field_msgId)))
      {
        this.BHb.put(Long.valueOf(paramca.field_msgId), Boolean.FALSE);
        this.BHl.put(Long.valueOf(paramca.field_msgId), localObject);
        a.aK(paramca);
      }
      AppMethodBeat.o(9560);
    }
    
    private static boolean m(HashMap<Long, Boolean> paramHashMap)
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
      parama = u.QN(parama.fileName);
      if (parama != null)
      {
        ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(parama.jso);
        if (parama.bhy())
        {
          this.BHb.put(Long.valueOf(localca.field_msgId), Boolean.TRUE);
          a(this.BHb, this.dgZ, this.BGF);
        }
        AppMethodBeat.o(9558);
        return;
      }
      a(null, this.dgZ, this.BGF);
      AppMethodBeat.o(9558);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(9559);
      if ((paramq instanceof f))
      {
        com.tencent.mm.kernel.g.aAg().hqi.b(221, this);
        if (this.BHl != null) {
          paramq = this.BHl.entrySet().iterator();
        }
      }
      label291:
      label294:
      for (;;)
      {
        long l;
        com.tencent.mm.pluginsdk.model.app.c localc;
        if (paramq.hasNext())
        {
          paramString = (Map.Entry)paramq.next();
          l = ((Long)paramString.getKey()).longValue();
          paramString = (String)paramString.getValue();
          if ((l <= 0L) || (((Boolean)this.BHb.get(Long.valueOf(l))).booleanValue())) {
            continue;
          }
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(l);
          localc = a.s(paramString, l);
          if (localc == null) {
            break label291;
          }
        }
        for (paramString = localc.field_fileFullPath;; paramString = null)
        {
          if ((paramString == null) || (paramString.length() <= 0)) {
            break label294;
          }
          this.BHb.put(Long.valueOf(l), Boolean.TRUE);
          paramString = this.BGF.field_dataProto.ppH.iterator();
          while (paramString.hasNext())
          {
            aml localaml = (aml)paramString.next();
            if (localaml.Lwt == l) {
              localaml.bgt(localc.field_fileFullPath);
            }
          }
          break;
          a(this.BHb, this.dgZ, this.BGF);
          AppMethodBeat.o(9559);
          return;
          a(null, this.dgZ, this.BGF);
          AppMethodBeat.o(9559);
          return;
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(9557);
      this.i = 0;
      this.dgZ = false;
      Log.i("MicroMsg.RecordMsgSendService", "dojob ChatDataDownloadRunnable, info id:%s", new Object[] { Long.valueOf(this.BGF.field_msgId) });
      if (this.BGF.field_dataProto == null)
      {
        Log.w("MicroMsg.RecordMsgSendService", "ChatDataDownloadRunnable info.field_dataProto null");
        this.dgZ = true;
        s.this.BGI = false;
        a(null, this.dgZ, this.BGF);
        AppMethodBeat.o(9557);
        return;
      }
      Iterator localIterator = this.BGF.field_dataProto.ppH.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (aml)localIterator.next();
        final long l = ((aml)localObject1).Lwt;
        label443:
        if (l > 0L)
        {
          final ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(l);
          Object localObject2 = ((aml)localObject1).LvL;
          if ((System.currentTimeMillis() - localca.field_createTime > 259200000L) && ((Util.isNullOrNil((String)localObject2)) || (!com.tencent.mm.vfs.s.YS((String)localObject2)))) {}
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              break label239;
            }
            Log.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", new Object[] { Integer.valueOf(localca.getType()) });
            break;
          }
          label239:
          if (((aml)localObject1).dataType == 2)
          {
            if (localca.gAz())
            {
              localObject2 = com.tencent.mm.av.q.bcR().G(localca.field_talker, localca.field_msgSvrId);
              if (localca.field_isSend == 1) {
                if (((com.tencent.mm.av.g)localObject2).bcv()) {
                  j = 1;
                }
              }
              for (;;)
              {
                if ((((com.tencent.mm.av.g)localObject2).offset >= ((com.tencent.mm.av.g)localObject2).iKP) && (((com.tencent.mm.av.g)localObject2).iKP != 0)) {
                  break label443;
                }
                this.BHb.put(Long.valueOf(l), Boolean.FALSE);
                this.i = this.BGF.field_dataProto.ppH.indexOf(localObject1);
                com.tencent.mm.av.q.bcS().a(((com.tencent.mm.av.g)localObject2).localId, localca.field_msgId, j, localObject1, 2131231628, new e.a()
                {
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
                  {
                    AppMethodBeat.i(9555);
                    s.b.this.BHb.put(Long.valueOf(l), Boolean.TRUE);
                    s.b.a(s.b.this, s.b.this.BHb, s.b.c(s.b.this), s.b.b(s.b.this));
                    AppMethodBeat.o(9555);
                  }
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.ak.q paramAnonymousq) {}
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
                  {
                    AppMethodBeat.i(9554);
                    boolean bool;
                    if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0))
                    {
                      bool = true;
                      Log.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                      if (!(paramAnonymousObject instanceof aml)) {
                        break label304;
                      }
                      paramAnonymousObject = (aml)paramAnonymousObject;
                      paramAnonymousObject.bgt(com.tencent.mm.av.q.bcR().o(com.tencent.mm.av.h.c(this.iZh), "", ""));
                      paramAnonymousObject.bgu(com.tencent.mm.av.q.bcR().R(localca.field_imgPath, true));
                      paramAnonymousString = XmlParser.parseXml(this.iZh.iXy, "msg", null);
                      if (paramAnonymousString == null) {
                        break label280;
                      }
                      paramAnonymousObject.bgj((String)paramAnonymousString.get(".msg.img.$cdnbigimgurl"));
                      paramAnonymousObject.Mu(Util.getInt((String)paramAnonymousString.get(".msg.img.$length"), 0));
                      paramAnonymousObject.bgk((String)paramAnonymousString.get(".msg.img.$aeskey"));
                      s.b.b(s.b.this).field_dataProto.ppH.set(s.b.a(s.b.this), paramAnonymousObject);
                      label217:
                      s.b.this.BHb.put(Long.valueOf(paramAnonymousObject.Lwt), Boolean.TRUE);
                    }
                    for (;;)
                    {
                      s.b.a(s.b.this, s.b.this.BHb, s.b.c(s.b.this), s.b.b(s.b.this));
                      AppMethodBeat.o(9554);
                      return;
                      bool = false;
                      break;
                      label280:
                      Log.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", new Object[] { this.iZh.iXy });
                      break label217;
                      label304:
                      s.b.this.BHb.put(Long.valueOf(l), Boolean.TRUE);
                    }
                  }
                });
                break;
                j = 0;
                continue;
                if (!((com.tencent.mm.av.g)localObject2).bcv())
                {
                  j = 0;
                }
                else
                {
                  com.tencent.mm.av.g localg = com.tencent.mm.av.h.a((com.tencent.mm.av.g)localObject2);
                  if (!com.tencent.mm.vfs.s.YS(com.tencent.mm.av.q.bcR().o(localg.iXm, "", ""))) {
                    j = 0;
                  } else {
                    j = 1;
                  }
                }
              }
            }
            else if (localca.gDr())
            {
              aK(localca);
            }
          }
          else if ((((aml)localObject1).dataType == 4) || (((aml)localObject1).dataType == 15))
          {
            localObject1 = u.QN(localca.field_imgPath);
            if ((localObject1 != null) && (((com.tencent.mm.modelvideo.s)localObject1).status != 199))
            {
              this.BHb.put(Long.valueOf(l), Boolean.FALSE);
              if (((com.tencent.mm.modelvideo.s)localObject1).bhx())
              {
                Log.i("MicroMsg.RecordMsgSendService", "start complete online video");
                u.QT(localca.field_imgPath);
              }
              else
              {
                Log.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                u.QI(localca.field_imgPath);
              }
            }
          }
          else if ((((aml)localObject1).dataType == 8) && (!Util.isNullOrNil(((aml)localObject1).LwF)))
          {
            aK(localca);
          }
        }
      }
      this.dgZ = true;
      s.this.BGI = false;
      a(this.BHb, this.dgZ, this.BGF);
      AppMethodBeat.o(9557);
    }
  }
  
  final class c
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k BGF;
    
    public c(com.tencent.mm.plugin.record.a.k paramk)
    {
      this.BGF = paramk;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9564);
      Log.i("MicroMsg.RecordMsgSendService", "dojob FavDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.BGF.field_msgId) });
      Object localObject = this.BGF.field_dataProto.ppH.iterator();
      for (int i = 0; ((Iterator)localObject).hasNext(); i = 1)
      {
        label46:
        aml localaml = (aml)((Iterator)localObject).next();
        hb localhb = new hb();
        localhb.dLm.type = 2;
        localhb.dLm.dLo = localaml;
        EventCenter.instance.publish(localhb);
        Log.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[] { localaml.dLl, Integer.valueOf(localaml.dataType) });
        String str;
        if (!Util.isNullOrNil(localhb.dLn.path))
        {
          str = p.c(localaml, this.BGF.field_msgId);
          Log.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[] { localhb.dLn.path, str });
          if (!localhb.dLn.path.equals(str)) {
            com.tencent.mm.vfs.s.nw(localhb.dLn.path, str);
          }
        }
        if (!Util.isNullOrNil(localhb.dLn.thumbPath))
        {
          str = p.f(localaml, this.BGF.field_msgId);
          Log.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[] { localhb.dLn.thumbPath, str });
          if (!localhb.dLn.thumbPath.equals(str)) {
            com.tencent.mm.vfs.s.nw(localhb.dLn.thumbPath, str);
          }
        }
        if (localaml.dataType == 3)
        {
          Log.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
          localaml.bgk("");
          localaml.bgj("");
          localaml.bgi("");
          localaml.bgh("");
        }
        if ((Util.isNullOrNil(localaml.KuR)) && (Util.isNullOrNil(localaml.iwX))) {
          break label46;
        }
      }
      if (i != 0)
      {
        com.tencent.mm.kernel.g.aAg().hqi.a(new g(this.BGF), 0);
        AppMethodBeat.o(9564);
        return;
      }
      localObject = k.b.a(p.a(this.BGF.field_title, this.BGF.field_desc, this.BGF.field_dataProto), null, null);
      s.this.f(this.BGF.field_msgId, this.BGF.field_localId, (String)localObject);
      s.this.BGI = false;
      s.this.a(null, false);
      AppMethodBeat.o(9564);
    }
  }
  
  final class d
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k BGF;
    private boolean BHo;
    
    public d(com.tencent.mm.plugin.record.a.k paramk, boolean paramBoolean)
    {
      this.BGF = paramk;
      this.BHo = paramBoolean;
    }
    
    private byte a(aml paramaml, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(9568);
      int k = 0;
      int j = 0;
      int i = 0;
      int m = paramaml.dataType;
      byte b1;
      if ((paramBoolean) && (m == 17))
      {
        Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() inner record");
        paramaml = p.aKY(paramaml.Lwx);
        if (paramaml == null)
        {
          AppMethodBeat.o(9568);
          return 0;
        }
        paramaml = paramaml.iAd.iterator();
        for (b1 = 0; paramaml.hasNext(); b1 = (byte)(i | b1))
        {
          i = a((aml)paramaml.next(), paramInt + 1, paramBoolean);
          Log.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable circleTraverseFavDataItem() %s result:%s ", new Object[] { Long.toBinaryString(i), Long.toBinaryString((byte)(i | b1)) });
        }
        AppMethodBeat.o(9568);
        return b1;
      }
      String str1;
      String str2;
      if ((!Util.isNullOrNil(paramaml.KuR)) || (!Util.isNullOrNil(paramaml.LwF)))
      {
        str1 = p.a(paramaml, this.BGF.field_oriMsgId, paramInt);
        str2 = p.a(paramaml, this.BGF.field_msgId, paramInt);
        if (com.tencent.mm.vfs.s.nw(str1, str2) <= 0L) {
          break label1059;
        }
        paramBoolean = true;
        Log.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          if (!Util.isNullOrNil(paramaml.LvE)) {
            break label1232;
          }
          Log.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
          paramaml.bgq(com.tencent.mm.vfs.s.bhK(str2));
        }
      }
      label689:
      label1213:
      label1232:
      for (i = 1;; i = 0)
      {
        if (Util.isNullOrNil(paramaml.LvG))
        {
          Log.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
          paramaml.bgr(com.tencent.mm.b.g.fb(str2));
        }
        for (j = 1;; j = i)
        {
          str2 = p.fj(paramaml.dLl, paramInt);
          str1 = p.g(str2, this.BGF.field_msgId, false);
          Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(str1);
          j localj;
          if (localObject == null)
          {
            localObject = new j();
            ((j)localObject).field_cdnKey = paramaml.Lvp;
            ((j)localObject).field_cdnUrl = paramaml.KuR;
            ((j)localObject).field_dataId = str2;
            ((j)localObject).field_mediaId = str1;
            ((j)localObject).field_totalLen = ((int)paramaml.LvI);
            ((j)localObject).field_localId = ((j)localObject).field_mediaId.hashCode();
            ((j)localObject).field_path = p.a(paramaml, this.BGF.field_msgId, paramInt);
            ((j)localObject).field_type = 2;
            ((j)localObject).field_fileType = p.hR(paramaml.dataType, (int)paramaml.LvI);
            ((j)localObject).field_recordLocalId = this.BGF.field_localId;
            ((j)localObject).field_toUser = this.BGF.field_toUser;
            ((j)localObject).field_isThumb = false;
            str2 = p.a(paramaml, this.BGF.field_msgId, paramInt);
            if ((!Util.isNullOrNil(paramaml.LwF)) && (!com.tencent.mm.vfs.s.YS(str2)))
            {
              ((j)localObject).field_status = -1;
              a(paramaml, str2, str1);
            }
            i = 1;
            paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject);
            Log.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(((j)localObject).field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(((j)localObject).field_recordLocalId), ((j)localObject).field_dataId, ((j)localObject).field_mediaId });
            k = j;
            if (Util.isNullOrNil(paramaml.iwX))
            {
              j = i;
              if (Util.isNullOrNil(paramaml.iwO)) {}
            }
            else
            {
              str1 = p.b(paramaml, this.BGF.field_oriMsgId, paramInt);
              str2 = p.b(paramaml, this.BGF.field_msgId, paramInt);
              if (com.tencent.mm.vfs.s.nw(str1, str2) <= 0L) {
                break label1136;
              }
              paramBoolean = true;
              Log.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
              str1 = p.fj(p.arI(paramaml.dLl), paramInt);
              str2 = p.g(str1, this.BGF.field_msgId, false);
              localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(str2);
              localObject = p.b(paramaml, this.BGF.field_msgId, paramInt);
              if (localj != null) {
                break label1141;
              }
              localj = new j();
              localj.field_cdnKey = paramaml.Lvk;
              localj.field_cdnUrl = paramaml.iwX;
              localj.field_dataId = str1;
              localj.field_mediaId = str2;
              localj.field_totalLen = ((int)paramaml.LvT);
              localj.field_localId = localj.field_mediaId.hashCode();
              localj.field_path = p.b(paramaml, this.BGF.field_msgId, paramInt);
              localj.field_type = 2;
              localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
              localj.field_recordLocalId = this.BGF.field_localId;
              localj.field_toUser = this.BGF.field_toUser;
              localj.field_isThumb = true;
              if ((!Util.isNullOrNil(paramaml.iwO)) && (!com.tencent.mm.vfs.s.YS((String)localObject)))
              {
                localj.field_status = -1;
                b(paramaml, (String)localObject, str2);
              }
              j = 1;
              paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
              Log.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(localj.field_recordLocalId), localj.field_dataId, localj.field_mediaId });
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
            a(paramaml, p.a(paramaml, this.BGF.field_msgId, paramInt), str1);
          }
          for (i = 1;; i = 0)
          {
            if (((j)localObject).field_status == 0) {
              i = 1;
            }
            Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(((j)localObject).field_status) });
            k = j;
            break;
            label1136:
            paramBoolean = false;
            break label689;
            label1141:
            if (localj.field_status == -1)
            {
              b(paramaml, p.b(paramaml, this.BGF.field_msgId, paramInt), str2);
              i = 1;
            }
            if (localj.field_status == 0) {
              i = 1;
            }
            Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(localj.field_status) });
            j = i;
            break label1026;
            b1 = 0;
            break label1034;
          }
        }
      }
    }
    
    private void a(final aml paramaml, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9569);
      Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", new Object[] { paramaml.dLl, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.taskName = "task_RecordMsgSendService_1";
      localg.field_fileType = 19;
      localg.field_authKey = paramaml.iwT;
      localg.field_aesKey = paramaml.LwC;
      localg.gqB = paramaml.LwF;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.gqy = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9565);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl done id:%s, mediaId:%s, path:%s", new Object[] { paramaml.dLl, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramaml.dLl;
                localObject = paramString1;
                if (paramAnonymousd != null) {
                  break label279;
                }
                i = 0;
                Log.e("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl error id:%s, mediaId:%s, path:%s, err:(%d,%d)", new Object[] { paramAnonymousc, paramAnonymousString, localObject, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramaml.dLl;
                  String str = paramString1;
                  if (paramAnonymousd == null) {}
                  for (i = 0;; i = paramAnonymousd.field_retCode)
                  {
                    Log.e("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl error id:%s, mediaId:%s, tempMediaId:%s, path:%s, err:(%d,%d), cdnInfo==null", new Object[] { localObject, paramAnonymousString, paramAnonymousc, str, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
                    AppMethodBeat.o(9565);
                    return 0;
                    i = paramAnonymousd.field_retCode;
                    break;
                  }
                }
                ((j)localObject).field_status = 0;
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((j)localObject);
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
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
        if (!com.tencent.mm.an.f.baQ().b(localg, -1)) {
          Log.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
        }
        AppMethodBeat.o(9569);
        return;
        paramString2 = paramString2 + "_tp";
      }
    }
    
    private void b(final aml paramaml, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9570);
      Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramaml.dLl, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.taskName = "task_RecordMsgSendService_2";
      localg.field_fileType = 19;
      localg.field_authKey = paramaml.iwT;
      localg.field_aesKey = paramaml.iwU;
      localg.gqB = paramaml.iwO;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.gqy = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9566);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramaml.dLl, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramaml.dLl;
                localObject = paramString1;
                if (paramAnonymousd != null) {
                  break label279;
                }
                i = 0;
                Log.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, thumbPath:%s err:(%d,%d)", new Object[] { paramAnonymousc, paramAnonymousString, localObject, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramaml.dLl;
                  String str = paramString1;
                  if (paramAnonymousd == null) {}
                  for (i = 0;; i = paramAnonymousd.field_retCode)
                  {
                    Log.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, tempMediaId:%s, thumbPath:%s err:(%d,%d)", new Object[] { localObject, paramAnonymousString, paramAnonymousc, str, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
                    AppMethodBeat.o(9566);
                    return 0;
                    i = paramAnonymousd.field_retCode;
                    break;
                  }
                }
                ((j)localObject).field_status = 0;
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((j)localObject);
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
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
        if (!com.tencent.mm.an.f.baQ().b(localg, -1)) {
          Log.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
        }
        AppMethodBeat.o(9570);
        return;
        paramString2 = paramString2 + "_tp";
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(9567);
      if (this.BGF.field_dataProto == null)
      {
        Log.w("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable info.field_dataProto null");
        s.this.BGI = false;
        AppMethodBeat.o(9567);
        return;
      }
      Iterator localIterator = this.BGF.field_dataProto.ppH.iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      if (localIterator.hasNext())
      {
        int i = a((aml)localIterator.next(), 1, this.BHo);
        Log.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() state: %s ", new Object[] { Long.toBinaryString(i) });
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
        Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable startEmbedded:%s infochanged:%s, needRun:%s", new Object[] { Boolean.valueOf(this.BHo), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (bool2)
        {
          Log.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.BGF.field_localId), Long.valueOf(this.BGF.field_msgId), Integer.valueOf(this.BGF.field_type) });
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.BGF, new String[] { "localId" });
        }
        if (!bool1)
        {
          Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable doSendContinue");
          s.this.b(this.BGF, false);
          s.this.BGI = false;
          s.this.a(null, false);
        }
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9567);
        return;
      }
    }
  }
  
  static final class e
  {
    long BGP;
    int jNv;
    
    private e()
    {
      AppMethodBeat.i(9571);
      this.BGP = SystemClock.elapsedRealtime();
      this.jNv = 3;
      AppMethodBeat.o(9571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.s
 * JD-Core Version:    0.7.0.1
 */