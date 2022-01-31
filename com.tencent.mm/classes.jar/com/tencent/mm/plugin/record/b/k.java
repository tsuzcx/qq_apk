package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.pluginsdk.model.app.ao.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  implements com.tencent.mm.ah.f, com.tencent.mm.plugin.record.a.c
{
  boolean nsO = false;
  SparseArray<k.e> nsR = new SparseArray();
  LinkedList<com.tencent.mm.plugin.record.a.g> nsS = new LinkedList();
  
  public k()
  {
    au.Dk().a(632, this);
    n.getRecordMsgCDNStorage().a(this);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.f paramf)
  {
    if (1 != paramInt)
    {
      y.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (paramf == null)
    {
      y.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
      return;
    }
    if (2 != paramf.field_type)
    {
      y.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload , mediaid:%s, recordLocalId:%d, status:%d", new Object[] { paramf.field_mediaId, Integer.valueOf(paramf.field_recordLocalId), Integer.valueOf(paramf.field_status) });
      return;
    }
    if ((paramf.field_status == 0) || (1 == paramf.field_status) || (-1 == paramf.field_status))
    {
      y.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
      return;
    }
    Object localObject1 = n.getRecordMsgCDNStorage().wy(paramf.field_recordLocalId);
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.record.a.f)((Iterator)localObject2).next();
      if ((((com.tencent.mm.plugin.record.a.f)localObject3).field_status == 0) || (1 == ((com.tencent.mm.plugin.record.a.f)localObject3).field_status) || (-1 == ((com.tencent.mm.plugin.record.a.f)localObject3).field_status)) {
        y.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[] { ((com.tencent.mm.plugin.record.a.f)localObject3).field_mediaId });
      }
    }
    for (paramInt = 0;; paramInt = 1)
    {
      y.d("MicroMsg.RecordMsgSendService", "on cdn storage changed cdnInfoList.size:%d,", new Object[] { Integer.valueOf(((List)localObject1).size()) });
      if (paramInt == 0) {
        break;
      }
      localObject2 = n.bvz().wA(paramf.field_recordLocalId);
      paramInt = paramf.field_recordLocalId;
      boolean bool;
      if (localObject2 != null)
      {
        bool = true;
        y.d("MicroMsg.RecordMsgSendService", "finish get record info, id %d result %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (localObject2 == null) {
          break label865;
        }
        paramf = ((com.tencent.mm.plugin.record.a.g)localObject2).field_dataProto.sXc;
        localObject3 = ((List)localObject1).iterator();
        label307:
        break label521;
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label650;
        }
        com.tencent.mm.plugin.record.a.f localf = (com.tencent.mm.plugin.record.a.f)((Iterator)localObject3).next();
        y.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", new Object[] { localf.field_dataId, Boolean.valueOf(localf.field_isThumb) });
        xv localxv;
        if (localf.field_isThumb)
        {
          localIterator = paramf.iterator();
          if (!localIterator.hasNext()) {
            continue;
          }
          localxv = (xv)localIterator.next();
          if (!localf.field_dataId.equals(h.Cw(localxv.kgC))) {
            break label307;
          }
          y.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localxv.sUC, localf.field_cdnKey, localxv.dQL, localf.field_cdnUrl, Long.valueOf(localxv.sVm), Integer.valueOf(localf.field_totalLen) });
          localxv.Xx(localf.field_cdnKey);
          localxv.Xw(localf.field_cdnUrl);
          continue;
          bool = false;
          break;
        }
        Iterator localIterator = paramf.iterator();
        label521:
        if (localIterator.hasNext())
        {
          localxv = (xv)localIterator.next();
          if (!localf.field_dataId.equals(localxv.kgC)) {
            break label307;
          }
          y.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localxv.sUI, localf.field_cdnKey, localxv.sUG, localf.field_cdnUrl, Long.valueOf(localxv.sVb), Integer.valueOf(localf.field_totalLen) });
          localxv.Xz(localf.field_cdnKey);
          localxv.Xy(localf.field_cdnUrl);
        }
      }
      label650:
      au.Hx();
      paramf = com.tencent.mm.model.c.Fy().fd(((com.tencent.mm.plugin.record.a.g)localObject2).field_msgId);
      y.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d", new Object[] { Boolean.valueOf(false), Long.valueOf(paramf.field_msgId), Long.valueOf(((com.tencent.mm.plugin.record.a.g)localObject2).field_msgId), Integer.valueOf(((com.tencent.mm.plugin.record.a.g)localObject2).field_localId) });
      if (paramf.field_msgId == ((com.tencent.mm.plugin.record.a.g)localObject2).field_msgId)
      {
        paramf.setContent(h.a(((com.tencent.mm.plugin.record.a.g)localObject2).field_title, ((com.tencent.mm.plugin.record.a.g)localObject2).field_desc, ((com.tencent.mm.plugin.record.a.g)localObject2).field_dataProto, ((com.tencent.mm.plugin.record.a.g)localObject2).field_favFrom));
        paramf.setStatus(1);
        au.Hx();
        com.tencent.mm.model.c.Fy().a(((com.tencent.mm.plugin.record.a.g)localObject2).field_msgId, paramf);
      }
      localObject3 = ap.clc().gZ(((com.tencent.mm.plugin.record.a.g)localObject2).field_msgId);
      if (localObject3 != null)
      {
        ((com.tencent.mm.ae.g)localObject3).field_xml = paramf.field_content;
        ap.clc().c((com.tencent.mm.sdk.e.c)localObject3, new String[] { "msgId" });
      }
      n.bvz().wz(((com.tencent.mm.plugin.record.a.g)localObject2).field_localId);
      this.nsR.remove(((com.tencent.mm.plugin.record.a.g)localObject2).field_localId);
      ap.cle();
      ao.a.hd(((com.tencent.mm.plugin.record.a.g)localObject2).field_msgId);
      label865:
      paramf = ((List)localObject1).iterator();
      while (paramf.hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.record.a.f)paramf.next();
        n.getRecordMsgCDNStorage().a((com.tencent.mm.plugin.record.a.f)localObject1, new String[] { "localId" });
      }
      this.nsO = false;
      a(null);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.record.a.g paramg)
  {
    au.DS().O(new k.1(this, paramg));
  }
  
  final void b(com.tencent.mm.plugin.record.a.g paramg)
  {
    if (!this.nsS.contains(paramg)) {
      this.nsS.add(paramg);
    }
  }
  
  final void d(long paramLong, int paramInt, String paramString)
  {
    au.Hx();
    bi localbi = com.tencent.mm.model.c.Fy().fd(paramLong);
    if (localbi.field_msgId == paramLong)
    {
      localbi.setContent(paramString);
      localbi.setStatus(1);
      au.Hx();
      com.tencent.mm.model.c.Fy().a(paramLong, localbi);
    }
    paramString = ap.clc().gZ(paramLong);
    if (paramString != null)
    {
      paramString.field_xml = localbi.field_content;
      ap.clc().c(paramString, new String[] { "msgId" });
    }
    n.bvz().wz(paramInt);
    this.nsR.remove(paramInt);
    ap.cle();
    ao.a.hd(paramLong);
    y.d("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
  }
  
  final void finish()
  {
    this.nsS.clear();
    this.nsR.clear();
    this.nsO = false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null)
    {
      y.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
      return;
    }
    switch (paramm.getType())
    {
    default: 
      this.nsO = false;
      a(null);
      return;
    }
    y.d("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (a)paramm;
    int k = paramInt1;
    int i = paramInt2;
    xv localxv;
    if (paramInt1 == 3)
    {
      paramm = paramString.nsL.field_dataProto.sXc.iterator();
      do
      {
        if (!paramm.hasNext()) {
          break;
        }
        localxv = (xv)paramm.next();
      } while ((bk.bl(localxv.sUG)) && (bk.bl(localxv.dQL)));
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
        d(paramString.nsL.field_msgId, paramString.nsL.field_localId, paramString.nsK);
        break;
      }
      y.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[] { Long.valueOf(paramString.nsL.field_msgId), Integer.valueOf(paramString.nsL.field_localId) });
      y.w("MicroMsg.RecordMsgSendService", "try upload from local");
      paramm = paramString.nsL.field_dataProto.sXc.iterator();
      while (paramm.hasNext())
      {
        localxv = (xv)paramm.next();
        String str;
        Object localObject;
        boolean bool;
        if (localxv.sVb > 0L)
        {
          str = h.h(localxv.kgC, paramString.nsL.field_msgId, false);
          if (n.getRecordMsgCDNStorage().LG(str) == null)
          {
            localObject = new com.tencent.mm.plugin.record.a.f();
            ((com.tencent.mm.plugin.record.a.f)localObject).field_cdnKey = localxv.sUI;
            ((com.tencent.mm.plugin.record.a.f)localObject).field_cdnUrl = localxv.sUG;
            ((com.tencent.mm.plugin.record.a.f)localObject).field_dataId = localxv.kgC;
            ((com.tencent.mm.plugin.record.a.f)localObject).field_mediaId = str;
            ((com.tencent.mm.plugin.record.a.f)localObject).field_totalLen = ((int)localxv.sVb);
            ((com.tencent.mm.plugin.record.a.f)localObject).field_localId = ((com.tencent.mm.plugin.record.a.f)localObject).field_mediaId.hashCode();
            ((com.tencent.mm.plugin.record.a.f)localObject).field_path = h.c(localxv, paramString.nsL.field_msgId);
            ((com.tencent.mm.plugin.record.a.f)localObject).field_type = 2;
            ((com.tencent.mm.plugin.record.a.f)localObject).field_fileType = h.wB(localxv.aYU);
            ((com.tencent.mm.plugin.record.a.f)localObject).field_recordLocalId = paramString.nsL.field_localId;
            ((com.tencent.mm.plugin.record.a.f)localObject).field_toUser = paramString.nsL.field_toUser;
            ((com.tencent.mm.plugin.record.a.f)localObject).field_isThumb = false;
            bool = n.getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.f)localObject);
            y.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.f)localObject).field_localId), Boolean.valueOf(bool) });
          }
        }
        if (localxv.sVm > 0L)
        {
          str = h.Cw(localxv.kgC);
          localObject = h.h(str, paramString.nsL.field_msgId, false);
          if (n.getRecordMsgCDNStorage().LG((String)localObject) == null)
          {
            com.tencent.mm.plugin.record.a.f localf = new com.tencent.mm.plugin.record.a.f();
            localf.field_cdnKey = localxv.sUC;
            localf.field_cdnUrl = localxv.dQL;
            localf.field_dataId = str;
            localf.field_mediaId = ((String)localObject);
            localf.field_totalLen = ((int)localxv.sVm);
            localf.field_localId = localf.field_mediaId.hashCode();
            localf.field_path = h.f(localxv, paramString.nsL.field_msgId);
            localf.field_type = 2;
            localf.field_fileType = com.tencent.mm.j.a.MediaType_FULLSIZEIMAGE;
            localf.field_recordLocalId = paramString.nsL.field_localId;
            localf.field_toUser = paramString.nsL.field_toUser;
            localf.field_isThumb = true;
            bool = n.getRecordMsgCDNStorage().b(localf);
            y.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localf.field_localId), Boolean.valueOf(bool) });
          }
        }
      }
      n.bvB().run();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.k
 * JD-Core Version:    0.7.0.1
 */