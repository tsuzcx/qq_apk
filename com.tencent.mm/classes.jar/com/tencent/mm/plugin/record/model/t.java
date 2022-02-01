package com.tencent.mm.plugin.record.model;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.g.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.f;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class t
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.record.a.d, com.tencent.mm.plugin.record.a.i
{
  private int NAP;
  private boolean NAq;
  private SparseArray<e> NAt;
  private LinkedList<com.tencent.mm.plugin.record.a.k> NAu;
  
  public t()
  {
    AppMethodBeat.i(9572);
    this.NAq = false;
    this.NAt = new SparseArray();
    this.NAu = new LinkedList();
    this.NAP = 7;
    com.tencent.mm.kernel.h.baD().mCm.a(632, this);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    try
    {
      this.NAP = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yQK, 7);
      AppMethodBeat.o(9572);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.RecordMsgSendService", localException, "RecordMsgSendService init error.", new Object[0]);
      AppMethodBeat.o(9572);
    }
  }
  
  private boolean a(com.tencent.mm.plugin.record.a.j paramj, arf paramarf, int paramInt)
  {
    AppMethodBeat.i(9581);
    com.tencent.mm.protocal.b.a.c localc = q.aSH(paramarf.ZzO);
    if (localc == null)
    {
      Log.i("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() msgData == null");
      AppMethodBeat.o(9581);
      return false;
    }
    boolean bool = a(paramj, localc.nUC, paramInt + 1);
    Log.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramarf.bsO(q.a(localc, paramarf.ZzO));
    }
    AppMethodBeat.o(9581);
    return bool;
  }
  
  private boolean a(com.tencent.mm.plugin.record.a.j paramj, List<arf> paramList, int paramInt)
  {
    AppMethodBeat.i(9580);
    paramList = paramList.iterator();
    boolean bool1 = false;
    arf localarf;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label231;
        }
        localarf = (arf)paramList.next();
        int i = localarf.dataType;
        Log.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localarf.hIQ, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = a(paramj, localarf, paramInt);
      }
    } while (!paramj.field_dataId.equals(q.gD(q.atP(localarf.hIQ), paramInt)));
    Log.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localarf.ZyC, paramj.field_cdnKey, localarf.nRr, paramj.field_cdnUrl, Long.valueOf(localarf.Zzk), Integer.valueOf(paramj.field_totalLen) });
    localarf.bsr(paramj.field_cdnKey);
    localarf.bsq(paramj.field_cdnUrl);
    if (!Util.isEqual(paramInt, 1)) {
      localarf.bsB(q.er(localarf.toString(), localarf.dataType));
    }
    boolean bool2 = true;
    label231:
    AppMethodBeat.o(9580);
    return bool2;
  }
  
  private void b(com.tencent.mm.plugin.record.a.k paramk)
  {
    AppMethodBeat.i(9575);
    if (!this.NAu.contains(paramk)) {
      this.NAu.add(paramk);
    }
    AppMethodBeat.o(9575);
  }
  
  private void b(com.tencent.mm.plugin.record.a.k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(9584);
    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramk.field_msgId);
    boolean bool;
    if (localcc == null)
    {
      bool = true;
      if (localcc != null) {
        break label366;
      }
    }
    label366:
    for (long l = -1L;; l = localcc.field_msgId)
    {
      Log.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d, afterCdnUpload %s, toUser:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Long.valueOf(paramk.field_msgId), Integer.valueOf(paramk.field_localId), Boolean.valueOf(paramBoolean), paramk.field_toUser });
      if ((localcc != null) && (localcc.field_msgId == paramk.field_msgId))
      {
        localcc.setContent(q.a(paramk.field_title, paramk.field_desc, paramk.field_dataProto, paramk.field_favFrom, paramk.field_msgId));
        localcc.setStatus(1);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramk.field_msgId, localcc);
      }
      com.tencent.mm.message.k localk = com.tencent.mm.plugin.openapi.a.gxo().rI(paramk.field_msgId);
      if (localk != null)
      {
        localk.field_xml = localcc.field_content;
        com.tencent.mm.plugin.openapi.a.gxo().update(localk, new String[] { "msgId" });
      }
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().agq(paramk.field_localId);
      this.NAt.remove(paramk.field_localId);
      if ((localcc == null) || (localcc.getCreateTime() + this.NAP * 24 * 3600 * 1000 >= cn.bDv())) {
        break label376;
      }
      Log.i("MicroMsg.RecordMsgSendService", "doSendContinue, out of wait time, " + localcc.getCreateTime());
      localcc.setStatus(5);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramk.field_msgId, localcc);
      AppMethodBeat.o(9584);
      return;
      bool = false;
      break;
    }
    label376:
    if (!q.a(paramk.field_toUser, paramk.field_msgId, true, "")) {
      ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.record.a.g.class)).tm(paramk.field_msgId);
    }
    AppMethodBeat.o(9584);
  }
  
  private boolean b(com.tencent.mm.plugin.record.a.j paramj, arf paramarf, int paramInt)
  {
    AppMethodBeat.i(9583);
    com.tencent.mm.protocal.b.a.c localc = q.aSH(paramarf.ZzO);
    if (localc == null)
    {
      Log.i("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() msgData == null");
      AppMethodBeat.o(9583);
      return false;
    }
    boolean bool = b(paramj, localc.nUC, paramInt + 1);
    Log.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramarf.bsO(q.a(localc, paramarf.ZzO));
    }
    AppMethodBeat.o(9583);
    return bool;
  }
  
  private boolean b(com.tencent.mm.plugin.record.a.j paramj, List<arf> paramList, int paramInt)
  {
    AppMethodBeat.i(9582);
    paramList = paramList.iterator();
    boolean bool1 = false;
    arf localarf;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label228;
        }
        localarf = (arf)paramList.next();
        int i = localarf.dataType;
        Log.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localarf.hIQ, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = b(paramj, localarf, paramInt);
      }
    } while (!paramj.field_dataId.equals(q.gD(localarf.hIQ, paramInt)));
    Log.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localarf.ZyH, paramj.field_cdnKey, localarf.Ysw, paramj.field_cdnUrl, Long.valueOf(localarf.Zza), Integer.valueOf(paramj.field_totalLen) });
    localarf.bst(paramj.field_cdnKey);
    localarf.bss(paramj.field_cdnUrl);
    if (!Util.isEqual(paramInt, 1)) {
      localarf.bsB(q.er(localarf.toString(), localarf.dataType));
    }
    boolean bool2 = true;
    label228:
    AppMethodBeat.o(9582);
    return bool2;
  }
  
  private void e(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(9578);
    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong);
    if ((localcc != null) && (localcc.field_msgId == paramLong))
    {
      localcc.setContent(paramString);
      localcc.setStatus(1);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramLong, localcc);
    }
    paramString = com.tencent.mm.plugin.openapi.a.gxo().rI(paramLong);
    if (paramString != null)
    {
      paramString.field_xml = localcc.field_content;
      com.tencent.mm.plugin.openapi.a.gxo().update(paramString, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().agq(paramInt);
    this.NAt.remove(paramInt);
    ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.record.a.g.class)).tm(paramLong);
    Log.i("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(9578);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.j paramj)
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
    Object localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().agp(paramj.field_recordLocalId);
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.record.a.j)((Iterator)localObject2).next();
      if ((((com.tencent.mm.plugin.record.a.j)localObject3).field_status == 0) || (1 == ((com.tencent.mm.plugin.record.a.j)localObject3).field_status) || (-1 == ((com.tencent.mm.plugin.record.a.j)localObject3).field_status)) {
        Log.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[] { ((com.tencent.mm.plugin.record.a.j)localObject3).field_mediaId });
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
      localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().agr(paramj.field_recordLocalId);
      paramInt = paramj.field_recordLocalId;
      boolean bool;
      if (localObject2 != null)
      {
        bool = true;
        Log.i("MicroMsg.RecordMsgSendService", "finish get record info, id %d result %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (localObject2 != null)
        {
          paramj = ((com.tencent.mm.plugin.record.a.k)localObject2).field_dataProto.vEn;
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
          com.tencent.mm.plugin.record.a.j localj = (com.tencent.mm.plugin.record.a.j)((Iterator)localObject3).next();
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
        localObject1 = (com.tencent.mm.plugin.record.a.j)paramj.next();
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((com.tencent.mm.plugin.record.a.j)localObject1, new String[] { "localId" });
      }
      this.NAq = false;
      a(null, false);
      AppMethodBeat.o(9579);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.record.a.k paramk)
  {
    AppMethodBeat.i(369889);
    a(paramk, false);
    AppMethodBeat.o(369889);
  }
  
  public final void a(final com.tencent.mm.plugin.record.a.k paramk, final boolean paramBoolean)
  {
    AppMethodBeat.i(9574);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9551);
        if (paramk != null)
        {
          if ((t.e)t.a(t.this).get(paramk.field_localId) == null)
          {
            Log.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[] { Integer.valueOf(paramk.field_localId), Long.valueOf(paramk.field_msgId) });
            t.e locale = new t.e((byte)0);
            t.a(t.this).put(paramk.field_localId, locale);
          }
          t.a(t.this, paramk);
        }
        t.a(t.this, paramBoolean);
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
    this.NAu.clear();
    this.NAt.clear();
    this.NAq = false;
    AppMethodBeat.o(9576);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(9577);
    Log.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramp == null)
    {
      Log.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
      AppMethodBeat.o(9577);
      return;
    }
    switch (paramp.getType())
    {
    default: 
      this.NAq = false;
      a(null, false);
      AppMethodBeat.o(9577);
      return;
    }
    Log.i("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (h)paramp;
    int k = paramInt1;
    int i = paramInt2;
    arf localarf;
    if (paramInt1 == 3)
    {
      paramp = paramString.NAn.field_dataProto.vEn.iterator();
      do
      {
        if (!paramp.hasNext()) {
          break;
        }
        localarf = (arf)paramp.next();
      } while ((Util.isNullOrNil(localarf.Ysw)) && (Util.isNullOrNil(localarf.nRr)));
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
        e(paramString.NAn.field_msgId, paramString.NAn.field_localId, paramString.NAm);
        break;
      }
      Log.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[] { Long.valueOf(paramString.NAn.field_msgId), Integer.valueOf(paramString.NAn.field_localId) });
      Log.w("MicroMsg.RecordMsgSendService", "try upload from local");
      paramp = paramString.NAn.field_dataProto.vEn.iterator();
      while (paramp.hasNext())
      {
        localarf = (arf)paramp.next();
        String str;
        Object localObject;
        boolean bool;
        if (localarf.Zza > 0L)
        {
          str = q.f(localarf.hIQ, paramString.NAn.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(str) == null)
          {
            localObject = new com.tencent.mm.plugin.record.a.j();
            ((com.tencent.mm.plugin.record.a.j)localObject).field_cdnKey = localarf.ZyH;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_cdnUrl = localarf.Ysw;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_dataId = localarf.hIQ;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_mediaId = str;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_totalLen = ((int)localarf.Zza);
            ((com.tencent.mm.plugin.record.a.j)localObject).field_localId = ((com.tencent.mm.plugin.record.a.j)localObject).field_mediaId.hashCode();
            ((com.tencent.mm.plugin.record.a.j)localObject).field_path = q.c(localarf, paramString.NAn.field_msgId);
            ((com.tencent.mm.plugin.record.a.j)localObject).field_type = 2;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_fileType = q.kC(localarf.dataType, (int)localarf.Zza);
            ((com.tencent.mm.plugin.record.a.j)localObject).field_recordLocalId = paramString.NAn.field_localId;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_toUser = paramString.NAn.field_toUser;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_isThumb = false;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.j)localObject);
            Log.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.j)localObject).field_localId), Boolean.valueOf(bool) });
          }
        }
        if (localarf.Zzk > 0L)
        {
          str = q.atP(localarf.hIQ);
          localObject = q.f(str, paramString.NAn.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG((String)localObject) == null)
          {
            com.tencent.mm.plugin.record.a.j localj = new com.tencent.mm.plugin.record.a.j();
            localj.field_cdnKey = localarf.ZyC;
            localj.field_cdnUrl = localarf.nRr;
            localj.field_dataId = str;
            localj.field_mediaId = ((String)localObject);
            localj.field_totalLen = ((int)localarf.Zzk);
            localj.field_localId = localj.field_mediaId.hashCode();
            localj.field_path = q.f(localarf, paramString.NAn.field_msgId);
            localj.field_type = 2;
            localj.field_fileType = com.tencent.mm.g.a.MediaType_FULLSIZEIMAGE;
            localj.field_recordLocalId = paramString.NAn.field_localId;
            localj.field_toUser = paramString.NAn.field_toUser;
            localj.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
            Log.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
          }
        }
      }
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
      AppMethodBeat.o(9577);
      return;
    }
  }
  
  final class a
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k NAn;
    
    public a(com.tencent.mm.plugin.record.a.k paramk)
    {
      this.NAn = paramk;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9553);
      int m = 0;
      int i = 0;
      Log.i("MicroMsg.RecordMsgSendService", "dojob ChatDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.NAn.field_msgId) });
      int j;
      int k;
      arf localarf;
      Object localObject1;
      Object localObject2;
      boolean bool;
      if ((this.NAn != null) && (this.NAn.field_dataProto != null) && (this.NAn.field_dataProto.vEn != null))
      {
        Iterator localIterator = this.NAn.field_dataProto.vEn.iterator();
        j = 0;
        m = i;
        k = j;
        if (!localIterator.hasNext()) {
          break label1169;
        }
        localarf = (arf)localIterator.next();
        if ((Util.isNullOrNil(localarf.Ysw)) && (!y.ZC(localarf.Zzd))) {
          break label1336;
        }
        localObject1 = localarf.Zzd;
        localObject2 = q.c(localarf, this.NAn.field_msgId);
        if (y.O((String)localObject1, (String)localObject2, false) > 0L)
        {
          bool = true;
          label168:
          Log.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[] { localarf.Ysw, localObject1, localObject2, Boolean.valueOf(bool) });
          k = i;
          if (!bool) {
            break label1331;
          }
          if (Util.isNullOrNil(localarf.ZyW))
          {
            Log.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
            localarf.bsz(y.bub((String)localObject2));
            i = 1;
          }
          k = i;
          if (!Util.isNullOrNil(localarf.ZyY)) {
            break label1331;
          }
          Log.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
          localObject1 = y.bi((String)localObject2, 0, 256);
          if (localObject1 != null) {
            break label992;
          }
          localObject1 = null;
          label282:
          localarf.bsA((String)localObject1);
          i = 1;
          label292:
          if (y.bEl((String)localObject2) != 0L) {
            localarf.yo(y.bEl((String)localObject2));
          }
          localObject1 = q.f(localarf.hIQ, this.NAn.field_msgId, false);
          localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG((String)localObject1);
          if (localObject2 != null) {
            break label1002;
          }
          localObject2 = new com.tencent.mm.plugin.record.a.j();
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_cdnKey = localarf.ZyH;
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_cdnUrl = localarf.Ysw;
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_dataId = localarf.hIQ;
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_mediaId = ((String)localObject1);
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_totalLen = ((int)localarf.Zza);
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_localId = ((com.tencent.mm.plugin.record.a.j)localObject2).field_mediaId.hashCode();
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_path = q.c(localarf, this.NAn.field_msgId);
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_type = 2;
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_fileType = q.kC(localarf.dataType, (int)localarf.Zza);
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_recordLocalId = this.NAn.field_localId;
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_toUser = this.NAn.field_toUser;
          ((com.tencent.mm.plugin.record.a.j)localObject2).field_isThumb = false;
          bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.j)localObject2);
          m = 1;
          Log.i("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.j)localObject2).field_localId), Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.plugin.record.a.j)localObject2).field_fileType), localObject1 });
          k = i;
        }
      }
      for (;;)
      {
        label573:
        if (Util.isNullOrNil(localarf.nRr))
        {
          j = k;
          if (!y.ZC(localarf.Zzf)) {}
        }
        else
        {
          localObject1 = localarf.Zzf;
          localObject2 = q.f(localarf, this.NAn.field_msgId);
          if (y.O((String)localObject1, (String)localObject2, false) > 0L) {}
          com.tencent.mm.plugin.record.a.j localj;
          for (bool = true;; bool = false)
          {
            Log.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
            localarf.yp(y.bEl((String)localObject2));
            i = k;
            if (bool)
            {
              i = k;
              if (Util.isNullOrNil(localarf.QJs))
              {
                Log.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                localarf.bsE(y.bub((String)localObject2));
                i = 1;
              }
              if (Util.isNullOrNil(localarf.Zzi))
              {
                Log.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                localarf.bsF(com.tencent.mm.b.g.hu((String)localObject2));
                i = 1;
              }
            }
            localObject1 = q.atP(localarf.hIQ);
            localObject2 = q.f((String)localObject1, this.NAn.field_msgId, false);
            localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG((String)localObject2);
            if (localj != null) {
              break label1095;
            }
            localj = new com.tencent.mm.plugin.record.a.j();
            localj.field_cdnKey = localarf.ZyC;
            localj.field_cdnUrl = localarf.nRr;
            localj.field_dataId = ((String)localObject1);
            localj.field_mediaId = ((String)localObject2);
            localj.field_totalLen = ((int)localarf.Zzk);
            localj.field_localId = localj.field_mediaId.hashCode();
            localj.field_path = q.f(localarf, this.NAn.field_msgId);
            localj.field_type = 2;
            localj.field_fileType = com.tencent.mm.g.a.MediaType_FULLSIZEIMAGE;
            localj.field_recordLocalId = this.NAn.field_localId;
            localj.field_toUser = this.NAn.field_toUser;
            localj.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
            Log.i("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
            j = 1;
            break;
            bool = false;
            break label168;
            label992:
            localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
            break label282;
            label1002:
            m = j;
            k = i;
            if (((com.tencent.mm.plugin.record.a.j)localObject2).field_status == 2) {
              break label573;
            }
            m = j;
            k = i;
            if (((com.tencent.mm.plugin.record.a.j)localObject2).field_status == 3) {
              break label573;
            }
            m = j;
            k = i;
            if (((com.tencent.mm.plugin.record.a.j)localObject2).field_status == 4) {
              break label573;
            }
            m = j;
            k = i;
            if (((com.tencent.mm.plugin.record.a.j)localObject2).field_status == -1) {
              break label573;
            }
            Log.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, cdnInfo status:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.j)localObject2).field_status) });
            m = 1;
            k = i;
            break label573;
          }
          label1095:
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
          label1169:
          if (m != 0)
          {
            Log.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.NAn.field_localId), Long.valueOf(this.NAn.field_msgId), Integer.valueOf(this.NAn.field_type) });
            ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.NAn, new String[] { "localId" });
          }
          if (k == 0)
          {
            Log.i("MicroMsg.RecordMsgSendService", "doSendContinue without cdn task");
            t.b(t.this, this.NAn);
            t.b(t.this);
            t.this.a(null, false);
          }
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
          AppMethodBeat.o(9553);
          return;
          i = j;
        }
        label1331:
        i = k;
        break label292;
        label1336:
        m = j;
        k = i;
      }
    }
  }
  
  final class b
    implements com.tencent.mm.am.h, aa.a, Runnable
  {
    HashMap<Long, Boolean> NAJ;
    HashMap<Long, String> NAT;
    private com.tencent.mm.plugin.record.a.k NAn;
    private boolean hcg;
    private int i;
    
    public b(com.tencent.mm.plugin.record.a.k paramk)
    {
      AppMethodBeat.i(9556);
      this.i = 0;
      this.NAJ = new HashMap();
      this.NAT = new HashMap();
      this.hcg = false;
      this.NAn = paramk;
      v.bOh().a(this, Looper.getMainLooper());
      com.tencent.mm.kernel.h.baD().mCm.a(221, this);
      AppMethodBeat.o(9556);
    }
    
    private boolean a(HashMap<Long, Boolean> paramHashMap, boolean paramBoolean, com.tencent.mm.plugin.record.a.k paramk)
    {
      AppMethodBeat.i(305367);
      if ((s(paramHashMap)) && (paramBoolean))
      {
        v.bOh().a(this);
        paramk.field_type = 2;
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(paramk, new String[] { "localId" });
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramk);
        AppMethodBeat.o(305367);
        return true;
      }
      AppMethodBeat.o(305367);
      return false;
    }
    
    private void bn(cc paramcc)
    {
      AppMethodBeat.i(9560);
      Object localObject = k.b.Hf(paramcc.field_content);
      if (localObject == null)
      {
        Log.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[] { paramcc.field_content });
        AppMethodBeat.o(9560);
        return;
      }
      if ((Util.isNullOrNil(((k.b)localObject).hzM)) && (!Util.isNullOrNil(((k.b)localObject).nRq)))
      {
        Log.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[] { paramcc.field_content });
        ((k.b)localObject).hzM = ((k.b)localObject).nRq.hashCode();
      }
      localObject = ((k.b)localObject).hzM;
      if (!a.a(paramcc, a.q((String)localObject, paramcc.field_msgId)))
      {
        this.NAJ.put(Long.valueOf(paramcc.field_msgId), Boolean.FALSE);
        this.NAT.put(Long.valueOf(paramcc.field_msgId), localObject);
        a.bn(paramcc);
      }
      AppMethodBeat.o(9560);
    }
    
    private static boolean s(HashMap<Long, Boolean> paramHashMap)
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
    
    public final void a(aa.a.a parama)
    {
      AppMethodBeat.i(9558);
      parama = ab.Qo(parama.fileName);
      if (parama != null)
      {
        cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(parama.pbc);
        if ((localcc != null) && (parama.bOx()))
        {
          this.NAJ.put(Long.valueOf(localcc.field_msgId), Boolean.TRUE);
          a(this.NAJ, this.hcg, this.NAn);
        }
        AppMethodBeat.o(9558);
        return;
      }
      a(null, this.hcg, this.NAn);
      AppMethodBeat.o(9558);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(9559);
      if ((paramp instanceof g))
      {
        com.tencent.mm.kernel.h.baD().mCm.b(221, this);
        if (this.NAT != null) {
          paramp = this.NAT.entrySet().iterator();
        }
      }
      label293:
      label296:
      for (;;)
      {
        long l;
        com.tencent.mm.pluginsdk.model.app.c localc;
        if (paramp.hasNext())
        {
          paramString = (Map.Entry)paramp.next();
          l = ((Long)paramString.getKey()).longValue();
          paramString = (String)paramString.getValue();
          if ((l <= 0L) || (((Boolean)this.NAJ.get(Long.valueOf(l))).booleanValue())) {
            continue;
          }
          ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(l);
          localc = a.q(paramString, l);
          if (localc == null) {
            break label293;
          }
        }
        for (paramString = localc.field_fileFullPath;; paramString = null)
        {
          if ((paramString == null) || (paramString.length() <= 0)) {
            break label296;
          }
          this.NAJ.put(Long.valueOf(l), Boolean.TRUE);
          paramString = this.NAn.field_dataProto.vEn.iterator();
          while (paramString.hasNext())
          {
            arf localarf = (arf)paramString.next();
            if (localarf.ZzK == l) {
              localarf.bsC(localc.field_fileFullPath);
            }
          }
          break;
          a(this.NAJ, this.hcg, this.NAn);
          AppMethodBeat.o(9559);
          return;
          a(null, this.hcg, this.NAn);
          AppMethodBeat.o(9559);
          return;
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(9557);
      this.i = 0;
      this.hcg = false;
      if (this.NAn.field_dataProto == null)
      {
        Log.w("MicroMsg.RecordMsgSendService", "ChatDataDownloadRunnable info.field_dataProto null id:%s", new Object[] { Long.valueOf(this.NAn.field_msgId) });
        this.hcg = true;
        t.b(t.this);
        a(null, this.hcg, this.NAn);
        AppMethodBeat.o(9557);
        return;
      }
      Log.i("MicroMsg.RecordMsgSendService", "dojob ChatDataDownloadRunnable, info id:%s dataListSize:%s", new Object[] { Long.valueOf(this.NAn.field_msgId), this.NAn.field_dataProto.vEn });
      Iterator localIterator = this.NAn.field_dataProto.vEn.iterator();
      while (localIterator.hasNext())
      {
        arf localarf = (arf)localIterator.next();
        final long l1 = localarf.ZzK;
        if (l1 > 0L)
        {
          final cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(l1);
          label549:
          if (localcc != null)
          {
            Object localObject = localarf.Zzd;
            long l2 = System.currentTimeMillis();
            long l3 = localcc.getCreateTime();
            boolean bool = y.ZC((String)localObject);
            if ((l2 - l3 > 259200000L) && (!bool)) {}
            for (int j = 1;; j = 0)
            {
              if (j == 0) {
                break label298;
              }
              Log.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgId: %s msgType:%s dataId:%s", new Object[] { Long.valueOf(localcc.field_msgId), Integer.valueOf(localcc.getType()), localarf.hIQ });
              break;
            }
            label298:
            if (localarf.dataType == 2)
            {
              if (localcc != null) {
                if (localcc.iYk())
                {
                  localObject = r.bKa().G(localcc.field_talker, localcc.field_msgSvrId);
                  if (localcc.field_isSend == 1) {
                    if (((com.tencent.mm.modelimage.h)localObject).bJE()) {
                      j = 1;
                    }
                  }
                  for (;;)
                  {
                    if ((((com.tencent.mm.modelimage.h)localObject).offset >= ((com.tencent.mm.modelimage.h)localObject).osy) && (((com.tencent.mm.modelimage.h)localObject).osy != 0)) {
                      break label549;
                    }
                    this.NAJ.put(Long.valueOf(l1), Boolean.FALSE);
                    this.i = this.NAn.field_dataProto.vEn.indexOf(localarf);
                    Log.i("MicroMsg.RecordMsgSendService", "need download imgDataItem MsgId:%s imgLocalId:%s dataId:%s", new Object[] { Long.valueOf(localcc.field_msgId), Long.valueOf(((com.tencent.mm.modelimage.h)localObject).localId), localarf.hIQ });
                    r.bKb().a(((com.tencent.mm.modelimage.h)localObject).localId, localcc.field_msgId, j, localarf, a.a.chat_img_template, new f.a()
                    {
                      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
                      {
                        AppMethodBeat.i(9555);
                        t.b.this.NAJ.put(Long.valueOf(l1), Boolean.TRUE);
                        t.b.a(t.b.this, t.b.this.NAJ, t.b.c(t.b.this), t.b.b(t.b.this));
                        AppMethodBeat.o(9555);
                      }
                      
                      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, p paramAnonymousp) {}
                      
                      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, p paramAnonymousp)
                      {
                        AppMethodBeat.i(9554);
                        boolean bool;
                        if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0))
                        {
                          bool = true;
                          Log.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                          if (!(paramAnonymousObject instanceof arf)) {
                            break label305;
                          }
                          paramAnonymousObject = (arf)paramAnonymousObject;
                          paramAnonymousObject.bsC(r.bKa().v(com.tencent.mm.modelimage.i.c(this.oIE), "", ""));
                          paramAnonymousObject.bsD(r.bKa().X(localcc.field_imgPath, true));
                          paramAnonymousString = XmlParser.parseXml(this.oIE.oGC, "msg", null);
                          if (paramAnonymousString == null) {
                            break label281;
                          }
                          paramAnonymousObject.bss((String)paramAnonymousString.get(".msg.img.$cdnbigimgurl"));
                          paramAnonymousObject.yo(Util.getInt((String)paramAnonymousString.get(".msg.img.$length"), 0));
                          paramAnonymousObject.bst((String)paramAnonymousString.get(".msg.img.$aeskey"));
                          t.b.b(t.b.this).field_dataProto.vEn.set(t.b.a(t.b.this), paramAnonymousObject);
                          label217:
                          t.b.this.NAJ.put(Long.valueOf(paramAnonymousObject.ZzK), Boolean.TRUE);
                        }
                        for (;;)
                        {
                          t.b.a(t.b.this, t.b.this.NAJ, t.b.c(t.b.this), t.b.b(t.b.this));
                          AppMethodBeat.o(9554);
                          return;
                          bool = false;
                          break;
                          label281:
                          Log.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", new Object[] { this.oIE.oGC });
                          break label217;
                          label305:
                          t.b.this.NAJ.put(Long.valueOf(l1), Boolean.TRUE);
                        }
                      }
                    });
                    break;
                    j = 0;
                    continue;
                    if (!((com.tencent.mm.modelimage.h)localObject).bJE())
                    {
                      j = 0;
                    }
                    else
                    {
                      com.tencent.mm.modelimage.h localh = com.tencent.mm.modelimage.i.a((com.tencent.mm.modelimage.h)localObject);
                      if (!y.ZC(r.bKa().v(localh.oGr, "", ""))) {
                        j = 0;
                      } else {
                        j = 1;
                      }
                    }
                  }
                }
                else if (localcc.jbK())
                {
                  bn(localcc);
                }
              }
            }
            else if ((localarf.dataType == 4) || (localarf.dataType == 15))
            {
              if (localcc != null)
              {
                localObject = ab.Qo(localcc.field_imgPath);
                if ((localObject != null) && (((z)localObject).status != 199))
                {
                  this.NAJ.put(Long.valueOf(l1), Boolean.FALSE);
                  Log.i("MicroMsg.RecordMsgSendService", "need download videoInfo MsgId:%s dataId:%s", new Object[] { Long.valueOf(localcc.field_msgId), localarf.hIQ });
                  if (((z)localObject).bOw())
                  {
                    Log.i("MicroMsg.RecordMsgSendService", "start complete online video");
                    ab.Qu(localcc.field_imgPath);
                  }
                  else
                  {
                    Log.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                    ab.Qj(localcc.field_imgPath);
                  }
                }
              }
            }
            else if ((localarf.dataType == 8) && (!Util.isNullOrNil(localarf.ZzW))) {
              bn(localcc);
            }
          }
        }
      }
      this.hcg = true;
      t.b(t.this);
      if (!a(this.NAJ, this.hcg, this.NAn))
      {
        Log.i("MicroMsg.RecordMsgSendService", "checkIsReadyForUpload downloadMap:%s finish:%s Id:%s localId:%s", new Object[] { this.NAJ.toString(), Boolean.valueOf(this.hcg), Long.valueOf(this.NAn.field_msgId), Integer.valueOf(this.NAn.field_localId) });
        t.this.a(null, false);
      }
      AppMethodBeat.o(9557);
    }
  }
  
  final class c
    implements Runnable
  {
    private com.tencent.mm.plugin.record.a.k NAn;
    
    public c(com.tencent.mm.plugin.record.a.k paramk)
    {
      this.NAn = paramk;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9564);
      Log.i("MicroMsg.RecordMsgSendService", "dojob FavDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.NAn.field_msgId) });
      Object localObject = this.NAn.field_dataProto.vEn.iterator();
      for (int i = 0; ((Iterator)localObject).hasNext(); i = 1)
      {
        label46:
        arf localarf = (arf)((Iterator)localObject).next();
        ht localht = new ht();
        localht.hIR.type = 2;
        localht.hIR.hIT = localarf;
        localht.publish();
        Log.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[] { localarf.hIQ, Integer.valueOf(localarf.dataType) });
        String str;
        if (!Util.isNullOrNil(localht.hIS.path))
        {
          str = q.c(localarf, this.NAn.field_msgId);
          Log.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[] { localht.hIS.path, str });
          if (!localht.hIS.path.equals(str)) {
            y.O(localht.hIS.path, str, false);
          }
        }
        if (!Util.isNullOrNil(localht.hIS.thumbPath))
        {
          str = q.f(localarf, this.NAn.field_msgId);
          Log.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[] { localht.hIS.thumbPath, str });
          if (!localht.hIS.thumbPath.equals(str)) {
            y.O(localht.hIS.thumbPath, str, false);
          }
        }
        if (localarf.dataType == 3)
        {
          Log.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
          localarf.bst("");
          localarf.bss("");
          localarf.bsr("");
          localarf.bsq("");
        }
        if ((Util.isNullOrNil(localarf.Ysw)) && (Util.isNullOrNil(localarf.nRr))) {
          break label46;
        }
      }
      if (i != 0)
      {
        com.tencent.mm.kernel.h.baD().mCm.a(new h(this.NAn), 0);
        AppMethodBeat.o(9564);
        return;
      }
      localObject = k.b.a(q.a(this.NAn.field_title, this.NAn.field_desc, this.NAn.field_dataProto), null, null);
      t.a(t.this, this.NAn.field_msgId, this.NAn.field_localId, (String)localObject);
      t.b(t.this);
      t.this.a(null, false);
      AppMethodBeat.o(9564);
    }
  }
  
  final class d
    implements Runnable
  {
    private boolean NAW;
    private com.tencent.mm.plugin.record.a.k NAn;
    
    public d(com.tencent.mm.plugin.record.a.k paramk, boolean paramBoolean)
    {
      this.NAn = paramk;
      this.NAW = paramBoolean;
    }
    
    private byte a(arf paramarf, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(9568);
      int k = 0;
      int j = 0;
      int i = 0;
      int m = paramarf.dataType;
      byte b1;
      if ((paramBoolean) && (m == 17))
      {
        Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() inner record");
        paramarf = q.aSH(paramarf.ZzO);
        if (paramarf == null)
        {
          AppMethodBeat.o(9568);
          return 0;
        }
        paramarf = paramarf.nUC.iterator();
        for (b1 = 0; paramarf.hasNext(); b1 = (byte)(i | b1))
        {
          i = a((arf)paramarf.next(), paramInt + 1, paramBoolean);
          Log.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable circleTraverseFavDataItem() %s result:%s ", new Object[] { Long.toBinaryString(i), Long.toBinaryString((byte)(i | b1)) });
        }
        AppMethodBeat.o(9568);
        return b1;
      }
      String str1;
      String str2;
      if ((!Util.isNullOrNil(paramarf.Ysw)) || (!Util.isNullOrNil(paramarf.ZzW)))
      {
        str1 = q.a(paramarf, this.NAn.field_oriMsgId, paramInt);
        str2 = q.a(paramarf, this.NAn.field_msgId, paramInt);
        if (y.O(str1, str2, false) <= 0L) {
          break label1061;
        }
        paramBoolean = true;
        Log.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          if (!Util.isNullOrNil(paramarf.ZyW)) {
            break label1234;
          }
          Log.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
          paramarf.bsz(y.bub(str2));
        }
      }
      label691:
      label1215:
      label1234:
      for (i = 1;; i = 0)
      {
        if (Util.isNullOrNil(paramarf.ZyY))
        {
          Log.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
          paramarf.bsA(com.tencent.mm.b.g.hu(str2));
        }
        for (j = 1;; j = i)
        {
          str2 = q.gD(paramarf.hIQ, paramInt);
          str1 = q.f(str2, this.NAn.field_msgId, false);
          Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(str1);
          com.tencent.mm.plugin.record.a.j localj;
          if (localObject == null)
          {
            localObject = new com.tencent.mm.plugin.record.a.j();
            ((com.tencent.mm.plugin.record.a.j)localObject).field_cdnKey = paramarf.ZyH;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_cdnUrl = paramarf.Ysw;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_dataId = str2;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_mediaId = str1;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_totalLen = ((int)paramarf.Zza);
            ((com.tencent.mm.plugin.record.a.j)localObject).field_localId = ((com.tencent.mm.plugin.record.a.j)localObject).field_mediaId.hashCode();
            ((com.tencent.mm.plugin.record.a.j)localObject).field_path = q.a(paramarf, this.NAn.field_msgId, paramInt);
            ((com.tencent.mm.plugin.record.a.j)localObject).field_type = 2;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_fileType = q.kC(paramarf.dataType, (int)paramarf.Zza);
            ((com.tencent.mm.plugin.record.a.j)localObject).field_recordLocalId = this.NAn.field_localId;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_toUser = this.NAn.field_toUser;
            ((com.tencent.mm.plugin.record.a.j)localObject).field_isThumb = false;
            str2 = q.a(paramarf, this.NAn.field_msgId, paramInt);
            if ((!Util.isNullOrNil(paramarf.ZzW)) && (!y.ZC(str2)))
            {
              ((com.tencent.mm.plugin.record.a.j)localObject).field_status = -1;
              a(paramarf, str2, str1);
            }
            i = 1;
            paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.j)localObject);
            Log.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.j)localObject).field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(((com.tencent.mm.plugin.record.a.j)localObject).field_recordLocalId), ((com.tencent.mm.plugin.record.a.j)localObject).field_dataId, ((com.tencent.mm.plugin.record.a.j)localObject).field_mediaId });
            k = j;
            if (Util.isNullOrNil(paramarf.nRr))
            {
              j = i;
              if (Util.isNullOrNil(paramarf.nRi)) {}
            }
            else
            {
              str1 = q.b(paramarf, this.NAn.field_oriMsgId, paramInt);
              str2 = q.b(paramarf, this.NAn.field_msgId, paramInt);
              if (y.O(str1, str2, false) <= 0L) {
                break label1138;
              }
              paramBoolean = true;
              Log.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(paramBoolean) });
              str1 = q.gD(q.atP(paramarf.hIQ), paramInt);
              str2 = q.f(str1, this.NAn.field_msgId, false);
              localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(str2);
              localObject = q.b(paramarf, this.NAn.field_msgId, paramInt);
              if (localj != null) {
                break label1143;
              }
              localj = new com.tencent.mm.plugin.record.a.j();
              localj.field_cdnKey = paramarf.ZyC;
              localj.field_cdnUrl = paramarf.nRr;
              localj.field_dataId = str1;
              localj.field_mediaId = str2;
              localj.field_totalLen = ((int)paramarf.Zzk);
              localj.field_localId = localj.field_mediaId.hashCode();
              localj.field_path = q.b(paramarf, this.NAn.field_msgId, paramInt);
              localj.field_type = 2;
              localj.field_fileType = com.tencent.mm.g.a.MediaType_FULLSIZEIMAGE;
              localj.field_recordLocalId = this.NAn.field_localId;
              localj.field_toUser = this.NAn.field_toUser;
              localj.field_isThumb = true;
              if ((!Util.isNullOrNil(paramarf.nRi)) && (!y.ZC((String)localObject)))
              {
                localj.field_status = -1;
                b(paramarf, (String)localObject, str2);
              }
              j = 1;
              paramBoolean = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
              Log.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(paramBoolean), Integer.valueOf(localj.field_recordLocalId), localj.field_dataId, localj.field_mediaId });
            }
            if (k == 0) {
              break label1215;
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
          if (((com.tencent.mm.plugin.record.a.j)localObject).field_status == -1) {
            a(paramarf, q.a(paramarf, this.NAn.field_msgId, paramInt), str1);
          }
          for (i = 1;; i = 0)
          {
            if (((com.tencent.mm.plugin.record.a.j)localObject).field_status == 0) {
              i = 1;
            }
            Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.j)localObject).field_status) });
            k = j;
            break;
            label1138:
            paramBoolean = false;
            break label691;
            label1143:
            if (localj.field_status == -1)
            {
              b(paramarf, q.b(paramarf, this.NAn.field_msgId, paramInt), str2);
              i = 1;
            }
            if (localj.field_status == 0) {
              i = 1;
            }
            Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", new Object[] { Integer.valueOf(localj.field_status) });
            j = i;
            break label1028;
            b1 = 0;
            break label1036;
          }
        }
      }
    }
    
    private void a(final arf paramarf, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9569);
      Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", new Object[] { paramarf.hIQ, paramString2, paramString1 });
      com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
      localg.taskName = "task_RecordMsgSendService_1";
      localg.field_fileType = 19;
      localg.field_authKey = paramarf.nRn;
      localg.field_aesKey = paramarf.ZzT;
      localg.lwO = paramarf.ZzW;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.lwL = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9565);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl done id:%s, mediaId:%s, path:%s", new Object[] { paramarf.hIQ, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramarf.hIQ;
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramarf.hIQ;
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
                ((com.tencent.mm.plugin.record.a.j)localObject).field_status = 0;
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((com.tencent.mm.plugin.record.a.j)localObject);
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
                AppMethodBeat.o(9565);
                return 0;
              }
            }
          }
          
          public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
          
          public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
          {
            return new byte[0];
          }
        };
        if (!com.tencent.mm.modelcdntran.k.bHW().b(localg, -1)) {
          Log.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
        }
        AppMethodBeat.o(9569);
        return;
        paramString2 = paramString2 + "_tp";
      }
    }
    
    private void b(final arf paramarf, final String paramString1, String paramString2)
    {
      AppMethodBeat.i(9570);
      Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramarf.hIQ, paramString2, paramString1 });
      com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
      localg.taskName = "task_RecordMsgSendService_2";
      localg.field_fileType = 19;
      localg.field_authKey = paramarf.nRn;
      localg.field_aesKey = paramarf.nRo;
      localg.lwO = paramarf.nRi;
      localg.field_fullpath = paramString1;
      if (paramString2 == null) {}
      for (;;)
      {
        localg.field_mediaId = paramString2;
        localg.lwL = new g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(9566);
            if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0)) {
              Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", new Object[] { paramarf.hIQ, paramAnonymousString, paramString1 });
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
                paramAnonymousc = paramarf.hIQ;
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
                localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(paramAnonymousc);
                if (localObject == null)
                {
                  localObject = paramarf.hIQ;
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
                ((com.tencent.mm.plugin.record.a.j)localObject).field_status = 0;
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((com.tencent.mm.plugin.record.a.j)localObject);
                ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
                AppMethodBeat.o(9566);
                return 0;
              }
            }
          }
          
          public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
          
          public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
          {
            return new byte[0];
          }
        };
        if (!com.tencent.mm.modelcdntran.k.bHW().b(localg, -1)) {
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
      if (this.NAn.field_dataProto == null)
      {
        Log.w("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable info.field_dataProto null");
        t.b(t.this);
        AppMethodBeat.o(9567);
        return;
      }
      Iterator localIterator = this.NAn.field_dataProto.vEn.iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      if (localIterator.hasNext())
      {
        int i = a((arf)localIterator.next(), 1, this.NAW);
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
        Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable startEmbedded:%s infochanged:%s, needRun:%s", new Object[] { Boolean.valueOf(this.NAW), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (bool2)
        {
          Log.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.NAn.field_localId), Long.valueOf(this.NAn.field_msgId), Integer.valueOf(this.NAn.field_type) });
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.NAn, new String[] { "localId" });
        }
        if (!bool1)
        {
          Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable doSendContinue");
          t.b(t.this, this.NAn);
          t.b(t.this);
          t.this.a(null, false);
        }
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9567);
        return;
      }
    }
  }
  
  static final class e
  {
    long NAx;
    int pBg;
    
    private e()
    {
      AppMethodBeat.i(9571);
      this.NAx = SystemClock.elapsedRealtime();
      this.pBg = 3;
      AppMethodBeat.o(9571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.t
 * JD-Core Version:    0.7.0.1
 */