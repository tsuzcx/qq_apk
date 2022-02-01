package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class s
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.record.a.d, com.tencent.mm.plugin.record.a.i
{
  private boolean HCO;
  private SparseArray<e> HCR;
  private LinkedList<com.tencent.mm.plugin.record.a.k> HCS;
  private int HDn;
  
  public s()
  {
    AppMethodBeat.i(9572);
    this.HCO = false;
    this.HCR = new SparseArray();
    this.HCS = new LinkedList();
    this.HDn = 7;
    com.tencent.mm.kernel.h.aHF().kcd.a(632, this);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    try
    {
      this.HDn = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vCq, 7);
      AppMethodBeat.o(9572);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.RecordMsgSendService", localException, "RecordMsgSendService init error.", new Object[0]);
      AppMethodBeat.o(9572);
    }
  }
  
  private boolean a(j paramj, anm paramanm, int paramInt)
  {
    AppMethodBeat.i(9581);
    com.tencent.mm.protocal.b.a.c localc = p.aVz(paramanm.SyW);
    if (localc == null)
    {
      Log.i("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() msgData == null");
      AppMethodBeat.o(9581);
      return false;
    }
    boolean bool = a(paramj, localc.lpz, paramInt + 1);
    Log.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramanm.bsX(p.a(localc, paramanm.SyW));
    }
    AppMethodBeat.o(9581);
    return bool;
  }
  
  private boolean a(j paramj, List<anm> paramList, int paramInt)
  {
    AppMethodBeat.i(9580);
    paramList = paramList.iterator();
    boolean bool1 = false;
    anm localanm;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label231;
        }
        localanm = (anm)paramList.next();
        int i = localanm.dataType;
        Log.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localanm.fEa, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = a(paramj, localanm, paramInt);
      }
    } while (!paramj.field_dataId.equals(p.fL(p.azJ(localanm.fEa), paramInt)));
    Log.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localanm.SxK, paramj.field_cdnKey, localanm.lmm, paramj.field_cdnUrl, Long.valueOf(localanm.Sys), Integer.valueOf(paramj.field_totalLen) });
    localanm.bsA(paramj.field_cdnKey);
    localanm.bsz(paramj.field_cdnUrl);
    if (!Util.isEqual(paramInt, 1)) {
      localanm.bsK(p.dN(localanm.toString(), localanm.dataType));
    }
    boolean bool2 = true;
    label231:
    AppMethodBeat.o(9580);
    return bool2;
  }
  
  private void b(com.tencent.mm.plugin.record.a.k paramk)
  {
    AppMethodBeat.i(9575);
    if (!this.HCS.contains(paramk)) {
      this.HCS.add(paramk);
    }
    AppMethodBeat.o(9575);
  }
  
  private void b(com.tencent.mm.plugin.record.a.k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(9584);
    ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramk.field_msgId);
    Log.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d, afterCdnUpload %s, toUser:%s", new Object[] { Boolean.FALSE, Long.valueOf(localca.field_msgId), Long.valueOf(paramk.field_msgId), Integer.valueOf(paramk.field_localId), Boolean.valueOf(paramBoolean), paramk.field_toUser });
    if (localca.field_msgId == paramk.field_msgId)
    {
      localca.setContent(p.a(paramk.field_title, paramk.field_desc, paramk.field_dataProto, paramk.field_favFrom, paramk.field_msgId));
      localca.setStatus(1);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramk.field_msgId, localca);
    }
    com.tencent.mm.aj.k localk = com.tencent.mm.plugin.ab.a.fmA().NR(paramk.field_msgId);
    if (localk != null)
    {
      localk.field_xml = localca.field_content;
      com.tencent.mm.plugin.ab.a.fmA().update(localk, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().acc(paramk.field_localId);
    this.HCR.remove(paramk.field_localId);
    if (localca.field_createTime + this.HDn * 24 * 3600 * 1000 < cm.bfD())
    {
      Log.i("MicroMsg.RecordMsgSendService", "doSendContinue, out of wait time, " + localca.field_createTime);
      localca.setStatus(5);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramk.field_msgId, localca);
      AppMethodBeat.o(9584);
      return;
    }
    if (!p.a(paramk.field_toUser, paramk.field_msgId, true, "")) {
      ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.record.a.g.class)).Pm(paramk.field_msgId);
    }
    AppMethodBeat.o(9584);
  }
  
  private boolean b(j paramj, anm paramanm, int paramInt)
  {
    AppMethodBeat.i(9583);
    com.tencent.mm.protocal.b.a.c localc = p.aVz(paramanm.SyW);
    if (localc == null)
    {
      Log.i("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() msgData == null");
      AppMethodBeat.o(9583);
      return false;
    }
    boolean bool = b(paramj, localc.lpz, paramInt + 1);
    Log.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramanm.bsX(p.a(localc, paramanm.SyW));
    }
    AppMethodBeat.o(9583);
    return bool;
  }
  
  private boolean b(j paramj, List<anm> paramList, int paramInt)
  {
    AppMethodBeat.i(9582);
    paramList = paramList.iterator();
    boolean bool1 = false;
    anm localanm;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label228;
        }
        localanm = (anm)paramList.next();
        int i = localanm.dataType;
        Log.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localanm.fEa, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = b(paramj, localanm, paramInt);
      }
    } while (!paramj.field_dataId.equals(p.fL(localanm.fEa, paramInt)));
    Log.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localanm.SxP, paramj.field_cdnKey, localanm.Rwb, paramj.field_cdnUrl, Long.valueOf(localanm.Syi), Integer.valueOf(paramj.field_totalLen) });
    localanm.bsC(paramj.field_cdnKey);
    localanm.bsB(paramj.field_cdnUrl);
    if (!Util.isEqual(paramInt, 1)) {
      localanm.bsK(p.dN(localanm.toString(), localanm.dataType));
    }
    boolean bool2 = true;
    label228:
    AppMethodBeat.o(9582);
    return bool2;
  }
  
  private void e(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(9578);
    ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong);
    if (localca.field_msgId == paramLong)
    {
      localca.setContent(paramString);
      localca.setStatus(1);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramLong, localca);
    }
    paramString = com.tencent.mm.plugin.ab.a.fmA().NR(paramLong);
    if (paramString != null)
    {
      paramString.field_xml = localca.field_content;
      com.tencent.mm.plugin.ab.a.fmA().update(paramString, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().acc(paramInt);
    this.HCR.remove(paramInt);
    ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.record.a.g.class)).Pm(paramLong);
    Log.i("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(9578);
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
    Object localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().acb(paramj.field_recordLocalId);
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
      localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().acd(paramj.field_recordLocalId);
      paramInt = paramj.field_recordLocalId;
      boolean bool;
      if (localObject2 != null)
      {
        bool = true;
        Log.i("MicroMsg.RecordMsgSendService", "finish get record info, id %d result %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (localObject2 != null)
        {
          paramj = ((com.tencent.mm.plugin.record.a.k)localObject2).field_dataProto.syG;
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
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((j)localObject1, new String[] { "localId" });
      }
      this.HCO = false;
      a(null, false);
      AppMethodBeat.o(9579);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.record.a.k paramk)
  {
    AppMethodBeat.i(292710);
    a(paramk, false);
    AppMethodBeat.o(292710);
  }
  
  public final void a(final com.tencent.mm.plugin.record.a.k paramk, final boolean paramBoolean)
  {
    AppMethodBeat.i(9574);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9551);
        if (paramk != null)
        {
          if ((s.e)s.a(s.this).get(paramk.field_localId) == null)
          {
            Log.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[] { Integer.valueOf(paramk.field_localId), Long.valueOf(paramk.field_msgId) });
            s.e locale = new s.e((byte)0);
            s.a(s.this).put(paramk.field_localId, locale);
          }
          s.a(s.this, paramk);
        }
        s.a(s.this, paramBoolean);
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
  
  public final void finish()
  {
    AppMethodBeat.i(9576);
    this.HCS.clear();
    this.HCR.clear();
    this.HCO = false;
    AppMethodBeat.o(9576);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
      this.HCO = false;
      a(null, false);
      AppMethodBeat.o(9577);
      return;
    }
    Log.i("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (g)paramq;
    int k = paramInt1;
    int i = paramInt2;
    anm localanm;
    if (paramInt1 == 3)
    {
      paramq = paramString.HCL.field_dataProto.syG.iterator();
      do
      {
        if (!paramq.hasNext()) {
          break;
        }
        localanm = (anm)paramq.next();
      } while ((Util.isNullOrNil(localanm.Rwb)) && (Util.isNullOrNil(localanm.lmm)));
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
        e(paramString.HCL.field_msgId, paramString.HCL.field_localId, paramString.HCK);
        break;
      }
      Log.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[] { Long.valueOf(paramString.HCL.field_msgId), Integer.valueOf(paramString.HCL.field_localId) });
      Log.w("MicroMsg.RecordMsgSendService", "try upload from local");
      paramq = paramString.HCL.field_dataProto.syG.iterator();
      while (paramq.hasNext())
      {
        localanm = (anm)paramq.next();
        String str;
        Object localObject;
        boolean bool;
        if (localanm.Syi > 0L)
        {
          str = p.f(localanm.fEa, paramString.HCL.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(str) == null)
          {
            localObject = new j();
            ((j)localObject).field_cdnKey = localanm.SxP;
            ((j)localObject).field_cdnUrl = localanm.Rwb;
            ((j)localObject).field_dataId = localanm.fEa;
            ((j)localObject).field_mediaId = str;
            ((j)localObject).field_totalLen = ((int)localanm.Syi);
            ((j)localObject).field_localId = ((j)localObject).field_mediaId.hashCode();
            ((j)localObject).field_path = p.c(localanm, paramString.HCL.field_msgId);
            ((j)localObject).field_type = 2;
            ((j)localObject).field_fileType = p.iW(localanm.dataType, (int)localanm.Syi);
            ((j)localObject).field_recordLocalId = paramString.HCL.field_localId;
            ((j)localObject).field_toUser = paramString.HCL.field_toUser;
            ((j)localObject).field_isThumb = false;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject);
            Log.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(((j)localObject).field_localId), Boolean.valueOf(bool) });
          }
        }
        if (localanm.Sys > 0L)
        {
          str = p.azJ(localanm.fEa);
          localObject = p.f(str, paramString.HCL.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy((String)localObject) == null)
          {
            j localj = new j();
            localj.field_cdnKey = localanm.SxK;
            localj.field_cdnUrl = localanm.lmm;
            localj.field_dataId = str;
            localj.field_mediaId = ((String)localObject);
            localj.field_totalLen = ((int)localanm.Sys);
            localj.field_localId = localj.field_mediaId.hashCode();
            localj.field_path = p.f(localanm, paramString.HCL.field_msgId);
            localj.field_type = 2;
            localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            localj.field_recordLocalId = paramString.HCL.field_localId;
            localj.field_toUser = paramString.HCL.field_toUser;
            localj.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
            Log.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
          }
        }
      }
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
      AppMethodBeat.o(9577);
      return;
    }
  }
  
  final class a
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k HCL;
    
    public a(com.tencent.mm.plugin.record.a.k paramk)
    {
      this.HCL = paramk;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9553);
      int m = 0;
      int i = 0;
      Log.i("MicroMsg.RecordMsgSendService", "dojob ChatDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.HCL.field_msgId) });
      int j;
      int k;
      anm localanm;
      Object localObject1;
      Object localObject2;
      boolean bool;
      if ((this.HCL != null) && (this.HCL.field_dataProto != null) && (this.HCL.field_dataProto.syG != null))
      {
        Iterator localIterator = this.HCL.field_dataProto.syG.iterator();
        j = 0;
        m = i;
        k = j;
        if (!localIterator.hasNext()) {
          break label1167;
        }
        localanm = (anm)localIterator.next();
        if ((Util.isNullOrNil(localanm.Rwb)) && (!u.agG(localanm.Syl))) {
          break label1334;
        }
        localObject1 = localanm.Syl;
        localObject2 = p.c(localanm, this.HCL.field_msgId);
        if (u.on((String)localObject1, (String)localObject2) > 0L)
        {
          bool = true;
          label167:
          Log.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[] { localanm.Rwb, localObject1, localObject2, Boolean.valueOf(bool) });
          k = i;
          if (!bool) {
            break label1329;
          }
          if (Util.isNullOrNil(localanm.Sye))
          {
            Log.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
            localanm.bsI(u.buc((String)localObject2));
            i = 1;
          }
          k = i;
          if (!Util.isNullOrNil(localanm.Syg)) {
            break label1329;
          }
          Log.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
          localObject1 = u.aY((String)localObject2, 0, 256);
          if (localObject1 != null) {
            break label990;
          }
          localObject1 = null;
          label281:
          localanm.bsJ((String)localObject1);
          i = 1;
          label291:
          if (u.bBQ((String)localObject2) != 0L) {
            localanm.TY(u.bBQ((String)localObject2));
          }
          localObject1 = p.f(localanm.fEa, this.HCL.field_msgId, false);
          localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy((String)localObject1);
          if (localObject2 != null) {
            break label1000;
          }
          localObject2 = new j();
          ((j)localObject2).field_cdnKey = localanm.SxP;
          ((j)localObject2).field_cdnUrl = localanm.Rwb;
          ((j)localObject2).field_dataId = localanm.fEa;
          ((j)localObject2).field_mediaId = ((String)localObject1);
          ((j)localObject2).field_totalLen = ((int)localanm.Syi);
          ((j)localObject2).field_localId = ((j)localObject2).field_mediaId.hashCode();
          ((j)localObject2).field_path = p.c(localanm, this.HCL.field_msgId);
          ((j)localObject2).field_type = 2;
          ((j)localObject2).field_fileType = p.iW(localanm.dataType, (int)localanm.Syi);
          ((j)localObject2).field_recordLocalId = this.HCL.field_localId;
          ((j)localObject2).field_toUser = this.HCL.field_toUser;
          ((j)localObject2).field_isThumb = false;
          bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject2);
          m = 1;
          Log.i("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[] { Integer.valueOf(((j)localObject2).field_localId), Boolean.valueOf(bool), Integer.valueOf(((j)localObject2).field_fileType), localObject1 });
          k = i;
        }
      }
      for (;;)
      {
        label572:
        if (Util.isNullOrNil(localanm.lmm))
        {
          j = k;
          if (!u.agG(localanm.Syn)) {}
        }
        else
        {
          localObject1 = localanm.Syn;
          localObject2 = p.f(localanm, this.HCL.field_msgId);
          if (u.on((String)localObject1, (String)localObject2) > 0L) {}
          j localj;
          for (bool = true;; bool = false)
          {
            Log.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
            localanm.TZ(u.bBQ((String)localObject2));
            i = k;
            if (bool)
            {
              i = k;
              if (Util.isNullOrNil(localanm.Kll))
              {
                Log.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                localanm.bsN(u.buc((String)localObject2));
                i = 1;
              }
              if (Util.isNullOrNil(localanm.Syq))
              {
                Log.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                localanm.bsO(com.tencent.mm.b.g.fR((String)localObject2));
                i = 1;
              }
            }
            localObject1 = p.azJ(localanm.fEa);
            localObject2 = p.f((String)localObject1, this.HCL.field_msgId, false);
            localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy((String)localObject2);
            if (localj != null) {
              break label1093;
            }
            localj = new j();
            localj.field_cdnKey = localanm.SxK;
            localj.field_cdnUrl = localanm.lmm;
            localj.field_dataId = ((String)localObject1);
            localj.field_mediaId = ((String)localObject2);
            localj.field_totalLen = ((int)localanm.Sys);
            localj.field_localId = localj.field_mediaId.hashCode();
            localj.field_path = p.f(localanm, this.HCL.field_msgId);
            localj.field_type = 2;
            localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            localj.field_recordLocalId = this.HCL.field_localId;
            localj.field_toUser = this.HCL.field_toUser;
            localj.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
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
            Log.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.HCL.field_localId), Long.valueOf(this.HCL.field_msgId), Integer.valueOf(this.HCL.field_type) });
            ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.HCL, new String[] { "localId" });
          }
          if (k == 0)
          {
            Log.i("MicroMsg.RecordMsgSendService", "doSendContinue without cdn task");
            s.b(s.this, this.HCL);
            s.b(s.this);
            s.this.a(null, false);
          }
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
          AppMethodBeat.o(9553);
          return;
          i = j;
        }
        label1329:
        i = k;
        break label291;
        label1334:
        m = j;
        k = i;
      }
    }
  }
  
  final class b
    implements com.tencent.mm.an.i, x.a, Runnable
  {
    private com.tencent.mm.plugin.record.a.k HCL;
    HashMap<Long, Boolean> HDh;
    HashMap<Long, String> HDr;
    private boolean eYG;
    private int i;
    
    public b(com.tencent.mm.plugin.record.a.k paramk)
    {
      AppMethodBeat.i(9556);
      this.i = 0;
      this.HDh = new HashMap();
      this.HDr = new HashMap();
      this.eYG = false;
      this.HCL = paramk;
      com.tencent.mm.modelvideo.s.bqB().a(this, Looper.getMainLooper());
      com.tencent.mm.kernel.h.aHF().kcd.a(221, this);
      AppMethodBeat.o(9556);
    }
    
    private void a(HashMap<Long, Boolean> paramHashMap, boolean paramBoolean, com.tencent.mm.plugin.record.a.k paramk)
    {
      AppMethodBeat.i(9561);
      if ((p(paramHashMap)) && (paramBoolean))
      {
        com.tencent.mm.modelvideo.s.bqB().a(this);
        paramk.field_type = 2;
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(paramk, new String[] { "localId" });
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramk);
      }
      AppMethodBeat.o(9561);
    }
    
    private void aW(ca paramca)
    {
      AppMethodBeat.i(9560);
      Object localObject = k.b.OQ(paramca.field_content);
      if (localObject == null)
      {
        Log.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[] { paramca.field_content });
        AppMethodBeat.o(9560);
        return;
      }
      if ((Util.isNullOrNil(((k.b)localObject).fvr)) && (!Util.isNullOrNil(((k.b)localObject).lml)))
      {
        Log.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[] { paramca.field_content });
        ((k.b)localObject).fvr = ((k.b)localObject).lml.hashCode();
      }
      localObject = ((k.b)localObject).fvr;
      if (!a.a(paramca, a.p((String)localObject, paramca.field_msgId)))
      {
        this.HDh.put(Long.valueOf(paramca.field_msgId), Boolean.FALSE);
        this.HDr.put(Long.valueOf(paramca.field_msgId), localObject);
        a.aW(paramca);
      }
      AppMethodBeat.o(9560);
    }
    
    private static boolean p(HashMap<Long, Boolean> paramHashMap)
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
    
    public final void a(x.a.a parama)
    {
      AppMethodBeat.i(9558);
      parama = y.Yk(parama.fileName);
      if (parama != null)
      {
        ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(parama.mhR);
        if (parama.bqS())
        {
          this.HDh.put(Long.valueOf(localca.field_msgId), Boolean.TRUE);
          a(this.HDh, this.eYG, this.HCL);
        }
        AppMethodBeat.o(9558);
        return;
      }
      a(null, this.eYG, this.HCL);
      AppMethodBeat.o(9558);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(9559);
      if ((paramq instanceof f))
      {
        com.tencent.mm.kernel.h.aHF().kcd.b(221, this);
        if (this.HDr != null) {
          paramq = this.HDr.entrySet().iterator();
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
          if ((l <= 0L) || (((Boolean)this.HDh.get(Long.valueOf(l))).booleanValue())) {
            continue;
          }
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(l);
          localc = a.p(paramString, l);
          if (localc == null) {
            break label291;
          }
        }
        for (paramString = localc.field_fileFullPath;; paramString = null)
        {
          if ((paramString == null) || (paramString.length() <= 0)) {
            break label294;
          }
          this.HDh.put(Long.valueOf(l), Boolean.TRUE);
          paramString = this.HCL.field_dataProto.syG.iterator();
          while (paramString.hasNext())
          {
            anm localanm = (anm)paramString.next();
            if (localanm.SyS == l) {
              localanm.bsL(localc.field_fileFullPath);
            }
          }
          break;
          a(this.HDh, this.eYG, this.HCL);
          AppMethodBeat.o(9559);
          return;
          a(null, this.eYG, this.HCL);
          AppMethodBeat.o(9559);
          return;
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(9557);
      this.i = 0;
      this.eYG = false;
      Log.i("MicroMsg.RecordMsgSendService", "dojob ChatDataDownloadRunnable, info id:%s", new Object[] { Long.valueOf(this.HCL.field_msgId) });
      if (this.HCL.field_dataProto == null)
      {
        Log.w("MicroMsg.RecordMsgSendService", "ChatDataDownloadRunnable info.field_dataProto null");
        this.eYG = true;
        s.b(s.this);
        a(null, this.eYG, this.HCL);
        AppMethodBeat.o(9557);
        return;
      }
      Iterator localIterator = this.HCL.field_dataProto.syG.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (anm)localIterator.next();
        final long l = ((anm)localObject1).SyS;
        label443:
        if (l > 0L)
        {
          final ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(l);
          Object localObject2 = ((anm)localObject1).Syl;
          if ((System.currentTimeMillis() - localca.field_createTime > 259200000L) && ((Util.isNullOrNil((String)localObject2)) || (!u.agG((String)localObject2)))) {}
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              break label239;
            }
            Log.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", new Object[] { Integer.valueOf(localca.getType()) });
            break;
          }
          label239:
          if (((anm)localObject1).dataType == 2)
          {
            if (localca.hwG())
            {
              localObject2 = com.tencent.mm.ay.q.bmh().C(localca.field_talker, localca.field_msgSvrId);
              if (localca.field_isSend == 1) {
                if (((com.tencent.mm.ay.g)localObject2).blK()) {
                  j = 1;
                }
              }
              for (;;)
              {
                if ((((com.tencent.mm.ay.g)localObject2).offset >= ((com.tencent.mm.ay.g)localObject2).lAW) && (((com.tencent.mm.ay.g)localObject2).lAW != 0)) {
                  break label443;
                }
                this.HDh.put(Long.valueOf(l), Boolean.FALSE);
                this.i = this.HCL.field_dataProto.syG.indexOf(localObject1);
                com.tencent.mm.ay.q.bmi().a(((com.tencent.mm.ay.g)localObject2).localId, localca.field_msgId, j, localObject1, a.a.chat_img_template, new e.a()
                {
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
                  {
                    AppMethodBeat.i(9555);
                    s.b.this.HDh.put(Long.valueOf(l), Boolean.TRUE);
                    s.b.a(s.b.this, s.b.this.HDh, s.b.c(s.b.this), s.b.b(s.b.this));
                    AppMethodBeat.o(9555);
                  }
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.an.q paramAnonymousq) {}
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
                  {
                    AppMethodBeat.i(9554);
                    boolean bool;
                    if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0))
                    {
                      bool = true;
                      Log.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                      if (!(paramAnonymousObject instanceof anm)) {
                        break label304;
                      }
                      paramAnonymousObject = (anm)paramAnonymousObject;
                      paramAnonymousObject.bsL(com.tencent.mm.ay.q.bmh().r(com.tencent.mm.ay.h.c(this.lPC), "", ""));
                      paramAnonymousObject.bsM(com.tencent.mm.ay.q.bmh().T(localca.field_imgPath, true));
                      paramAnonymousString = XmlParser.parseXml(this.lPC.lNS, "msg", null);
                      if (paramAnonymousString == null) {
                        break label280;
                      }
                      paramAnonymousObject.bsB((String)paramAnonymousString.get(".msg.img.$cdnbigimgurl"));
                      paramAnonymousObject.TY(Util.getInt((String)paramAnonymousString.get(".msg.img.$length"), 0));
                      paramAnonymousObject.bsC((String)paramAnonymousString.get(".msg.img.$aeskey"));
                      s.b.b(s.b.this).field_dataProto.syG.set(s.b.a(s.b.this), paramAnonymousObject);
                      label217:
                      s.b.this.HDh.put(Long.valueOf(paramAnonymousObject.SyS), Boolean.TRUE);
                    }
                    for (;;)
                    {
                      s.b.a(s.b.this, s.b.this.HDh, s.b.c(s.b.this), s.b.b(s.b.this));
                      AppMethodBeat.o(9554);
                      return;
                      bool = false;
                      break;
                      label280:
                      Log.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", new Object[] { this.lPC.lNS });
                      break label217;
                      label304:
                      s.b.this.HDh.put(Long.valueOf(l), Boolean.TRUE);
                    }
                  }
                });
                break;
                j = 0;
                continue;
                if (!((com.tencent.mm.ay.g)localObject2).blK())
                {
                  j = 0;
                }
                else
                {
                  com.tencent.mm.ay.g localg = com.tencent.mm.ay.h.a((com.tencent.mm.ay.g)localObject2);
                  if (!u.agG(com.tencent.mm.ay.q.bmh().r(localg.lNH, "", ""))) {
                    j = 0;
                  } else {
                    j = 1;
                  }
                }
              }
            }
            else if (localca.hzF())
            {
              aW(localca);
            }
          }
          else if ((((anm)localObject1).dataType == 4) || (((anm)localObject1).dataType == 15))
          {
            localObject1 = y.Yk(localca.field_imgPath);
            if ((localObject1 != null) && (((w)localObject1).status != 199))
            {
              this.HDh.put(Long.valueOf(l), Boolean.FALSE);
              if (((w)localObject1).bqR())
              {
                Log.i("MicroMsg.RecordMsgSendService", "start complete online video");
                y.Yq(localca.field_imgPath);
              }
              else
              {
                Log.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                y.Yf(localca.field_imgPath);
              }
            }
          }
          else if ((((anm)localObject1).dataType == 8) && (!Util.isNullOrNil(((anm)localObject1).Sze)))
          {
            aW(localca);
          }
        }
      }
      this.eYG = true;
      s.b(s.this);
      a(this.HDh, this.eYG, this.HCL);
      AppMethodBeat.o(9557);
    }
  }
  
  final class c
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k HCL;
    
    public c(com.tencent.mm.plugin.record.a.k paramk)
    {
      this.HCL = paramk;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9564);
      Log.i("MicroMsg.RecordMsgSendService", "dojob FavDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.HCL.field_msgId) });
      Object localObject = this.HCL.field_dataProto.syG.iterator();
      for (int i = 0; ((Iterator)localObject).hasNext(); i = 1)
      {
        label46:
        anm localanm = (anm)((Iterator)localObject).next();
        hi localhi = new hi();
        localhi.fEb.type = 2;
        localhi.fEb.fEd = localanm;
        EventCenter.instance.publish(localhi);
        Log.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[] { localanm.fEa, Integer.valueOf(localanm.dataType) });
        String str;
        if (!Util.isNullOrNil(localhi.fEc.path))
        {
          str = p.c(localanm, this.HCL.field_msgId);
          Log.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[] { localhi.fEc.path, str });
          if (!localhi.fEc.path.equals(str)) {
            u.on(localhi.fEc.path, str);
          }
        }
        if (!Util.isNullOrNil(localhi.fEc.thumbPath))
        {
          str = p.f(localanm, this.HCL.field_msgId);
          Log.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[] { localhi.fEc.thumbPath, str });
          if (!localhi.fEc.thumbPath.equals(str)) {
            u.on(localhi.fEc.thumbPath, str);
          }
        }
        if (localanm.dataType == 3)
        {
          Log.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
          localanm.bsC("");
          localanm.bsB("");
          localanm.bsA("");
          localanm.bsz("");
        }
        if ((Util.isNullOrNil(localanm.Rwb)) && (Util.isNullOrNil(localanm.lmm))) {
          break label46;
        }
      }
      if (i != 0)
      {
        com.tencent.mm.kernel.h.aHF().kcd.a(new g(this.HCL), 0);
        AppMethodBeat.o(9564);
        return;
      }
      localObject = k.b.a(p.a(this.HCL.field_title, this.HCL.field_desc, this.HCL.field_dataProto), null, null);
      s.a(s.this, this.HCL.field_msgId, this.HCL.field_localId, (String)localObject);
      s.b(s.this);
      s.this.a(null, false);
      AppMethodBeat.o(9564);
    }
  }
  
  final class d
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k HCL;
    private boolean HDu;
    
    public d(com.tencent.mm.plugin.record.a.k paramk, boolean paramBoolean)
    {
      this.HCL = paramk;
      this.HDu = paramBoolean;
    }
    
    private byte a(anm paramanm, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(9568);
      int k = 0;
      int j = 0;
      int i = 0;
      int m = paramanm.dataType;
      byte b1;
      if ((paramBoolean) && (m == 17))
      {
        Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() inner record");
        paramanm = p.aVz(paramanm.SyW);
        if (paramanm == null)
        {
          AppMethodBeat.o(9568);
          return 0;
        }
        paramanm = paramanm.lpz.iterator();
        for (b1 = 0; paramanm.hasNext(); b1 = (byte)(i | b1))
        {
          i = a((anm)paramanm.next(), paramInt + 1, paramBoolean);
          Log.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable circleTraverseFavDataItem() %s result:%s ", new Object[] { Long.toBinaryString(i), Long.toBinaryString((byte)(i | b1)) });
        }
        AppMethodBeat.o(9568);
        return b1;
      }
      String str1;
      String str2;
      if ((!Util.isNullOrNil(paramanm.Rwb)) || (!Util.isNullOrNil(paramanm.Sze)))
      {
        str1 = p.a(paramanm, this.HCL.field_oriMsgId, paramInt);
        str2 = p.a(paramanm, this.HCL.field_msgId, paramInt);
        if (u.on(str1, str2) <= 0L) {
          break label1059;
        }
        paramBoolean = true;
        Log.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          if (!Util.isNullOrNil(paramanm.Sye)) {
            break label1232;
          }
          Log.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
          paramanm.bsI(u.buc(str2));
        }
      }
      label689:
      label1213:
      label1232:
      for (i = 1;; i = 0)
      {
        if (Util.isNullOrNil(paramanm.Syg))
        {
          Log.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
          paramanm.bsJ(com.tencent.mm.b.g.fR(str2));
        }
        for (j = 1;; j = i)
        {
          str2 = p.fL(paramanm.fEa, paramInt);
          str1 = p.f(str2, this.HCL.field_msgId, false);
          Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(str1);
          j localj;
          if (localObject == null)
          {
            localObject = new j();
            ((j)localObject).field_cdnKey = paramanm.SxP;
            ((j)localObject).field_cdnUrl = paramanm.Rwb;
            ((j)localObject).field_dataId = str2;
            ((j)localObject).field_mediaId = str1;
            ((j)localObject).field_totalLen = ((int)paramanm.Syi);
            ((j)localObject).field_localId = ((j)localObject).field_mediaId.hashCode();
            ((j)localObject).field_path = p.a(paramanm, this.HCL.field_msgId, paramInt);
            ((j)localObject).field_type = 2;
            ((j)localObject).field_fileType = p.iW(paramanm.dataType, (int)paramanm.Syi);
            ((j)localObject).field_recordLocalId = this.HCL.field_localId;
            ((j)localObject).field_toUser = this.HCL.field_toUser;
            ((j)localObject).field_isThumb = false;
            str2 = p.a(paramanm, this.HCL.field_msgId, paramInt);
            if ((!Util.isNullOrNil(paramanm.Sze)) && (!u.agG(str2)))
            {
              ((j)localObject).field_status = -1;
              a(paramanm, str2, str1);
            }
            i = 1;
            paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject);
            Log.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(((j)localObject).field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(((j)localObject).field_recordLocalId), ((j)localObject).field_dataId, ((j)localObject).field_mediaId });
            k = j;
            if (Util.isNullOrNil(paramanm.lmm))
            {
              j = i;
              if (Util.isNullOrNil(paramanm.lmd)) {}
            }
            else
            {
              str1 = p.b(paramanm, this.HCL.field_oriMsgId, paramInt);
              str2 = p.b(paramanm, this.HCL.field_msgId, paramInt);
              if (u.on(str1, str2) <= 0L) {
                break label1136;
              }
              paramBoolean = true;
              Log.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
              str1 = p.fL(p.azJ(paramanm.fEa), paramInt);
              str2 = p.f(str1, this.HCL.field_msgId, false);
              localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(str2);
              localObject = p.b(paramanm, this.HCL.field_msgId, paramInt);
              if (localj != null) {
                break label1141;
              }
              localj = new j();
              localj.field_cdnKey = paramanm.SxK;
              localj.field_cdnUrl = paramanm.lmm;
              localj.field_dataId = str1;
              localj.field_mediaId = str2;
              localj.field_totalLen = ((int)paramanm.Sys);
              localj.field_localId = localj.field_mediaId.hashCode();
              localj.field_path = p.b(paramanm, this.HCL.field_msgId, paramInt);
              localj.field_type = 2;
              localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
              localj.field_recordLocalId = this.HCL.field_localId;
              localj.field_toUser = this.HCL.field_toUser;
              localj.field_isThumb = true;
              if ((!Util.isNullOrNil(paramanm.lmd)) && (!u.agG((String)localObject)))
              {
                localj.field_status = -1;
                b(paramanm, (String)localObject, str2);
              }
              j = 1;
              paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
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
            a(paramanm, p.a(paramanm, this.HCL.field_msgId, paramInt), str1);
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
              b(paramanm, p.b(paramanm, this.HCL.field_msgId, paramInt), str2);
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
    
    private void a(final anm paramanm, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9569);
      Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", new Object[] { paramanm.fEa, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.taskName = "task_RecordMsgSendService_1";
      localg.field_fileType = 19;
      localg.field_authKey = paramanm.lmi;
      localg.field_aesKey = paramanm.Szb;
      localg.iUJ = paramanm.Sze;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.iUG = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9565);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl done id:%s, mediaId:%s, path:%s", new Object[] { paramanm.fEa, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramanm.fEa;
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramanm.fEa;
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
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((j)localObject);
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
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
        if (!com.tencent.mm.aq.f.bkg().b(localg, -1)) {
          Log.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
        }
        AppMethodBeat.o(9569);
        return;
        paramString2 = paramString2 + "_tp";
      }
    }
    
    private void b(final anm paramanm, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9570);
      Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramanm.fEa, paramString2, paramString1 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.taskName = "task_RecordMsgSendService_2";
      localg.field_fileType = 19;
      localg.field_authKey = paramanm.lmi;
      localg.field_aesKey = paramanm.lmj;
      localg.iUJ = paramanm.lmd;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.iUG = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9566);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramanm.fEa, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramanm.fEa;
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramanm.fEa;
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
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((j)localObject);
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
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
        if (!com.tencent.mm.aq.f.bkg().b(localg, -1)) {
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
      if (this.HCL.field_dataProto == null)
      {
        Log.w("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable info.field_dataProto null");
        s.b(s.this);
        AppMethodBeat.o(9567);
        return;
      }
      Iterator localIterator = this.HCL.field_dataProto.syG.iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      if (localIterator.hasNext())
      {
        int i = a((anm)localIterator.next(), 1, this.HDu);
        Log.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() state: %s ", new Object[] { Long.toBinaryString(i) });
        if ((i & 0x1) == 1) {
          bool2 = true;
        }
        if ((i & 0x2) != 2) {
          break label318;
        }
        bool1 = true;
      }
      label318:
      for (;;)
      {
        break;
        Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable startEmbedded:%s infochanged:%s, needRun:%s", new Object[] { Boolean.valueOf(this.HDu), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (bool2)
        {
          Log.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.HCL.field_localId), Long.valueOf(this.HCL.field_msgId), Integer.valueOf(this.HCL.field_type) });
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.HCL, new String[] { "localId" });
        }
        if (!bool1)
        {
          Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable doSendContinue");
          s.b(s.this, this.HCL);
          s.b(s.this);
          s.this.a(null, false);
        }
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9567);
        return;
      }
    }
  }
  
  static final class e
  {
    long HCV;
    int mED;
    
    private e()
    {
      AppMethodBeat.i(9571);
      this.HCV = SystemClock.elapsedRealtime();
      this.mED = 3;
      AppMethodBeat.o(9571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.s
 * JD-Core Version:    0.7.0.1
 */