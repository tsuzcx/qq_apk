package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.d.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class q
  implements com.tencent.mm.ai.f, d, com.tencent.mm.plugin.record.a.h
{
  private int pYO;
  boolean pYu;
  SparseArray<q.e> pYx;
  LinkedList<com.tencent.mm.plugin.record.a.j> pYy;
  
  public q()
  {
    AppMethodBeat.i(135742);
    this.pYu = false;
    this.pYx = new SparseArray();
    this.pYy = new LinkedList();
    this.pYO = 7;
    com.tencent.mm.kernel.g.RK().eHt.a(632, this);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    try
    {
      this.pYO = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUS, 7);
      AppMethodBeat.o(135742);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.RecordMsgSendService", localException, "RecordMsgSendService init error.", new Object[0]);
      AppMethodBeat.o(135742);
    }
  }
  
  private boolean a(i parami, aca paramaca, int paramInt)
  {
    AppMethodBeat.i(146017);
    c localc = n.XS(paramaca.wTM);
    if (localc == null)
    {
      ab.i("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() msgData == null");
      AppMethodBeat.o(146017);
      return false;
    }
    boolean bool = a(parami, localc.fjy, paramInt + 1);
    ab.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramaca.anQ(n.a(localc, paramaca.wTM));
    }
    AppMethodBeat.o(146017);
    return bool;
  }
  
  private boolean a(i parami, List<aca> paramList, int paramInt)
  {
    AppMethodBeat.i(146016);
    paramList = paramList.iterator();
    boolean bool1 = false;
    aca localaca;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label228;
        }
        localaca = (aca)paramList.next();
        int i = localaca.dataType;
        ab.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localaca.mBq, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = a(parami, localaca, paramInt);
      }
    } while (!parami.field_dataId.equals(n.df(n.Ny(localaca.mBq), paramInt)));
    ab.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localaca.wSy, parami.field_cdnKey, localaca.fgM, parami.field_cdnUrl, Long.valueOf(localaca.wTi), Integer.valueOf(parami.field_totalLen) });
    localaca.ant(parami.field_cdnKey);
    localaca.ans(parami.field_cdnUrl);
    if (!bo.hl(paramInt, 1)) {
      localaca.anD(n.cj(localaca.toString(), localaca.dataType));
    }
    boolean bool2 = true;
    label228:
    AppMethodBeat.o(146016);
    return bool2;
  }
  
  private boolean b(i parami, aca paramaca, int paramInt)
  {
    AppMethodBeat.i(146019);
    c localc = n.XS(paramaca.wTM);
    if (localc == null)
    {
      ab.i("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() msgData == null");
      AppMethodBeat.o(146019);
      return false;
    }
    boolean bool = b(parami, localc.fjy, paramInt + 1);
    ab.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() ifReplace:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      paramaca.anQ(n.a(localc, paramaca.wTM));
    }
    AppMethodBeat.o(146019);
    return bool;
  }
  
  private boolean b(i parami, List<aca> paramList, int paramInt)
  {
    AppMethodBeat.i(146018);
    paramList = paramList.iterator();
    boolean bool1 = false;
    aca localaca;
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label228;
        }
        localaca = (aca)paramList.next();
        int i = localaca.dataType;
        ab.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfo() dataItem.getDataId:%s msgType:%s", new Object[] { localaca.mBq, Integer.valueOf(i) });
        if (i != 17) {
          break;
        }
        bool1 = b(parami, localaca, paramInt);
      }
    } while (!parami.field_dataId.equals(n.df(localaca.mBq, paramInt)));
    ab.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localaca.wSE, parami.field_cdnKey, localaca.wSC, parami.field_cdnUrl, Long.valueOf(localaca.wSX), Integer.valueOf(parami.field_totalLen) });
    localaca.anv(parami.field_cdnKey);
    localaca.anu(parami.field_cdnUrl);
    if (!bo.hl(paramInt, 1)) {
      localaca.anD(n.cj(localaca.toString(), localaca.dataType));
    }
    boolean bool2 = true;
    label228:
    AppMethodBeat.o(146018);
    return bool2;
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(135748);
    if (1 != paramInt)
    {
      ab.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(135748);
      return;
    }
    if (parami == null)
    {
      ab.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
      AppMethodBeat.o(135748);
      return;
    }
    if (2 != parami.field_type)
    {
      ab.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload , mediaid:%s, recordLocalId:%d, status:%d", new Object[] { parami.field_mediaId, Integer.valueOf(parami.field_recordLocalId), Integer.valueOf(parami.field_status) });
      AppMethodBeat.o(135748);
      return;
    }
    if ((parami.field_status == 0) || (1 == parami.field_status) || (-1 == parami.field_status))
    {
      ab.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
      AppMethodBeat.o(135748);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().Ck(parami.field_recordLocalId);
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (i)((Iterator)localObject2).next();
      if ((((i)localObject3).field_status == 0) || (1 == ((i)localObject3).field_status) || (-1 == ((i)localObject3).field_status)) {
        ab.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[] { ((i)localObject3).field_mediaId });
      }
    }
    for (paramInt = 0;; paramInt = 1)
    {
      ab.i("MicroMsg.RecordMsgSendService", "on cdn storage changed cdnInfoList.size:%d,", new Object[] { Integer.valueOf(((List)localObject1).size()) });
      if (paramInt == 0)
      {
        AppMethodBeat.o(135748);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Cm(parami.field_recordLocalId);
      paramInt = parami.field_recordLocalId;
      boolean bool;
      if (localObject2 != null)
      {
        bool = true;
        ab.i("MicroMsg.RecordMsgSendService", "finish get record info, id %d result %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (localObject2 != null)
        {
          parami = ((com.tencent.mm.plugin.record.a.j)localObject2).field_dataProto.wVc;
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
          i locali = (i)((Iterator)localObject3).next();
          ab.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", new Object[] { locali.field_dataId, Boolean.valueOf(locali.field_isThumb) });
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
        b((com.tencent.mm.plugin.record.a.j)localObject2, true);
      }
      parami = ((List)localObject1).iterator();
      while (parami.hasNext())
      {
        localObject1 = (i)parami.next();
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((i)localObject1, new String[] { "localId" });
      }
      this.pYu = false;
      a(null, false);
      AppMethodBeat.o(135748);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.record.a.j paramj)
  {
    AppMethodBeat.i(156871);
    a(paramj, false);
    AppMethodBeat.o(156871);
  }
  
  public final void a(com.tencent.mm.plugin.record.a.j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(146015);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().ac(new q.1(this, paramj, paramBoolean));
    AppMethodBeat.o(146015);
  }
  
  final void b(com.tencent.mm.plugin.record.a.j paramj)
  {
    AppMethodBeat.i(135744);
    if (!this.pYy.contains(paramj)) {
      this.pYy.add(paramj);
    }
    AppMethodBeat.o(135744);
  }
  
  final void b(com.tencent.mm.plugin.record.a.j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(135749);
    bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(paramj.field_msgId);
    ab.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d, afterCdnUpload %s", new Object[] { Boolean.FALSE, Long.valueOf(localbi.field_msgId), Long.valueOf(paramj.field_msgId), Integer.valueOf(paramj.field_localId), Boolean.valueOf(paramBoolean) });
    if (localbi.field_msgId == paramj.field_msgId)
    {
      localbi.setContent(n.a(paramj.field_title, paramj.field_desc, paramj.field_dataProto, paramj.field_favFrom, paramj.field_msgId));
      localbi.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(paramj.field_msgId, localbi);
    }
    com.tencent.mm.af.j localj = com.tencent.mm.plugin.s.a.cad().nx(paramj.field_msgId);
    if (localj != null)
    {
      localj.field_xml = localbi.field_content;
      com.tencent.mm.plugin.s.a.cad().update(localj, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Cl(paramj.field_localId);
    this.pYx.remove(paramj.field_localId);
    if (localbi.field_createTime + this.pYO * 24 * 3600 * 1000 < cb.abq())
    {
      ab.i("MicroMsg.RecordMsgSendService", "doSendContinue, out of wait time, " + localbi.field_createTime);
      localbi.setStatus(5);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(paramj.field_msgId, localbi);
      AppMethodBeat.o(135749);
      return;
    }
    ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.record.a.f.class)).kW(paramj.field_msgId);
    AppMethodBeat.o(135749);
  }
  
  final void d(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(135747);
    bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(paramLong);
    if (localbi.field_msgId == paramLong)
    {
      localbi.setContent(paramString);
      localbi.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(paramLong, localbi);
    }
    paramString = com.tencent.mm.plugin.s.a.cad().nx(paramLong);
    if (paramString != null)
    {
      paramString.field_xml = localbi.field_content;
      com.tencent.mm.plugin.s.a.cad().update(paramString, new String[] { "msgId" });
    }
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Cl(paramInt);
    this.pYx.remove(paramInt);
    ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.record.a.f.class)).kW(paramLong);
    ab.i("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(135747);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(135745);
    this.pYy.clear();
    this.pYx.clear();
    this.pYu = false;
    AppMethodBeat.o(135745);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(135746);
    ab.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null)
    {
      ab.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
      AppMethodBeat.o(135746);
      return;
    }
    switch (paramm.getType())
    {
    default: 
      this.pYu = false;
      a(null, false);
      AppMethodBeat.o(135746);
      return;
    }
    ab.i("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (f)paramm;
    int k = paramInt1;
    int i = paramInt2;
    aca localaca;
    if (paramInt1 == 3)
    {
      paramm = paramString.pYr.field_dataProto.wVc.iterator();
      do
      {
        if (!paramm.hasNext()) {
          break;
        }
        localaca = (aca)paramm.next();
      } while ((bo.isNullOrNil(localaca.wSC)) && (bo.isNullOrNil(localaca.fgM)));
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
        d(paramString.pYr.field_msgId, paramString.pYr.field_localId, paramString.pYq);
        break;
      }
      ab.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[] { Long.valueOf(paramString.pYr.field_msgId), Integer.valueOf(paramString.pYr.field_localId) });
      ab.w("MicroMsg.RecordMsgSendService", "try upload from local");
      paramm = paramString.pYr.field_dataProto.wVc.iterator();
      while (paramm.hasNext())
      {
        localaca = (aca)paramm.next();
        String str;
        Object localObject;
        boolean bool;
        if (localaca.wSX > 0L)
        {
          str = n.h(localaca.mBq, paramString.pYr.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR(str) == null)
          {
            localObject = new i();
            ((i)localObject).field_cdnKey = localaca.wSE;
            ((i)localObject).field_cdnUrl = localaca.wSC;
            ((i)localObject).field_dataId = localaca.mBq;
            ((i)localObject).field_mediaId = str;
            ((i)localObject).field_totalLen = ((int)localaca.wSX);
            ((i)localObject).field_localId = ((i)localObject).field_mediaId.hashCode();
            ((i)localObject).field_path = n.c(localaca, paramString.pYr.field_msgId);
            ((i)localObject).field_type = 2;
            ((i)localObject).field_fileType = n.fl(localaca.dataType, (int)localaca.wSX);
            ((i)localObject).field_recordLocalId = paramString.pYr.field_localId;
            ((i)localObject).field_toUser = paramString.pYr.field_toUser;
            ((i)localObject).field_isThumb = false;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((i)localObject);
            ab.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(((i)localObject).field_localId), Boolean.valueOf(bool) });
          }
        }
        if (localaca.wTi > 0L)
        {
          str = n.Ny(localaca.mBq);
          localObject = n.h(str, paramString.pYr.field_msgId, false);
          if (((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR((String)localObject) == null)
          {
            i locali = new i();
            locali.field_cdnKey = localaca.wSy;
            locali.field_cdnUrl = localaca.fgM;
            locali.field_dataId = str;
            locali.field_mediaId = ((String)localObject);
            locali.field_totalLen = ((int)localaca.wTi);
            locali.field_localId = locali.field_mediaId.hashCode();
            locali.field_path = n.f(localaca, paramString.pYr.field_msgId);
            locali.field_type = 2;
            locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            locali.field_recordLocalId = paramString.pYr.field_localId;
            locali.field_toUser = paramString.pYr.field_toUser;
            locali.field_isThumb = true;
            bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
            ab.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
          }
        }
      }
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
      AppMethodBeat.o(135746);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.q
 * JD-Core Version:    0.7.0.1
 */