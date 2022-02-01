package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bn.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.f;

public final class b
  implements com.tencent.mm.al.g
{
  private List<com.tencent.mm.api.h> fTp;
  private a fTq;
  private com.tencent.mm.api.q fTr;
  
  public b(List<com.tencent.mm.api.h> paramList, com.tencent.mm.api.q paramq, a parama)
  {
    AppMethodBeat.i(114101);
    com.tencent.mm.kernel.g.aeS().a(825, this);
    this.fTr = paramq;
    this.fTq = parama;
    this.fTp = paramList;
    AppMethodBeat.o(114101);
  }
  
  private static cs a(cs paramcs, String paramString)
  {
    AppMethodBeat.i(114105);
    if (paramcs == null)
    {
      ad.w("FunctionMsg.FunctionMsgFetcher", "null == raw");
      AppMethodBeat.o(114105);
      return null;
    }
    int i = paramString.indexOf("<addmsg");
    if (i == -1)
    {
      ad.e("FunctionMsg.FunctionMsgFetcher", "msgContent not start with <addmsg! content is null?%s", new Object[] { Boolean.valueOf(bt.isNullOrNil(paramString)) });
      AppMethodBeat.o(114105);
      return null;
    }
    Map localMap = bw.K(paramString.substring(i), "addmsg");
    StringBuilder localStringBuilder = new StringBuilder();
    if (localMap.containsKey(pZ(".msgid")))
    {
      i = bt.getInt((String)localMap.get(pZ(".msgid")), 0);
      paramcs.uKX = i;
      localStringBuilder.append("msgid:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(pZ(".newmsgid")))
    {
      long l = bt.getLong((String)localMap.get(pZ(".newmsgid")), 0L);
      paramcs.uKZ = l;
      localStringBuilder.append(" newMsgId:".concat(String.valueOf(l)));
    }
    if (localMap.containsKey(pZ(".msgseq")))
    {
      i = bt.getInt((String)localMap.get(pZ(".msgseq")), 0);
      paramcs.CxE = i;
      localStringBuilder.append(" msgSeq:".concat(String.valueOf(i)));
    }
    String str;
    if (localMap.containsKey(pZ(".fromusername")))
    {
      str = (String)localMap.get(pZ(".fromusername"));
      paramcs.Cxx = z.BE(str);
      localStringBuilder.append(" fromUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(pZ(".tousername")))
    {
      str = (String)localMap.get(pZ(".tousername"));
      paramcs.Cxy = z.BE(str);
      localStringBuilder.append(" toUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(pZ(".msgtype")))
    {
      i = bt.getInt((String)localMap.get(pZ(".msgtype")), 0);
      paramcs.saz = i;
      localStringBuilder.append(" msgType:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(pZ(".status")))
    {
      i = bt.getInt((String)localMap.get(pZ(".status")), 0);
      paramcs.mBi = i;
      localStringBuilder.append(" status:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(pZ(".content")))
    {
      paramcs.Cxz = z.BE(f.aRu(paramString.substring(paramString.indexOf("<content>") + 9, paramString.indexOf("</content>"))));
      localStringBuilder.append(" msgContent:*");
    }
    for (;;)
    {
      if (localMap.containsKey(pZ(".msgsource")))
      {
        paramcs.CxC = f.aRu(paramString.substring(paramString.indexOf("<msgsource>") + 11, paramString.indexOf("</msgsource>")));
        localStringBuilder.append(" msgSource:*");
      }
      if (localMap.containsKey(pZ(".pushcontent")))
      {
        paramcs.CxD = f.aRu(paramString.substring(paramString.indexOf("<pushcontent>") + 13, paramString.indexOf("</pushcontent>")));
        localStringBuilder.append(" pushContent:*");
      }
      if (localMap.containsKey(pZ(".imgstatus")))
      {
        i = bt.getInt((String)localMap.get(pZ(".imgstatus")), 0);
        paramcs.CxA = i;
        localStringBuilder.append(" ImgStatus:".concat(String.valueOf(i)));
      }
      if (localMap.containsKey(pZ(".imgbuf")))
      {
        paramcs.CxB = z.BF((String)localMap.get(pZ(".imgbuf")));
        localStringBuilder.append(" imgBuf:*");
      }
      if (localMap.containsKey(pZ(".createtime")))
      {
        i = bt.getInt((String)localMap.get(pZ(".createtime")), 0);
        paramcs.CreateTime = i;
        localStringBuilder.append(" createTime:".concat(String.valueOf(i)));
      }
      ad.i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", new Object[] { localStringBuilder.toString() });
      AppMethodBeat.o(114105);
      return paramcs;
      localStringBuilder.append(" msgContent:null");
      paramcs.Cxz = null;
    }
  }
  
  private static String pZ(String paramString)
  {
    AppMethodBeat.i(114106);
    paramString = ".addmsg".concat(String.valueOf(paramString));
    AppMethodBeat.o(114106);
    return paramString;
  }
  
  private void release()
  {
    AppMethodBeat.i(114103);
    com.tencent.mm.kernel.g.aeS().b(825, this);
    AppMethodBeat.o(114103);
  }
  
  public final void acI()
  {
    AppMethodBeat.i(114102);
    Iterator localIterator = this.fTp.iterator();
    label263:
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.api.h)localIterator.next();
      if ((localObject != null) && (((com.tencent.mm.api.h)localObject).field_cgi != null) && (((com.tencent.mm.api.h)localObject).field_cmdid > 0))
      {
        ad.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", new Object[] { ((com.tencent.mm.api.h)localObject).field_functionmsgid });
        ((com.tencent.mm.api.h)localObject).field_status = 0;
        this.fTr.b(((com.tencent.mm.api.h)localObject).field_businessInfo);
        localObject = new a((com.tencent.mm.api.h)localObject);
        com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
      }
      else if (localObject != null)
      {
        cs localcs = a(((com.tencent.mm.api.h)localObject).field_addMsg, ((com.tencent.mm.api.h)localObject).field_defaultContent);
        ad.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", new Object[] { localcs });
        ((com.tencent.mm.api.h)localObject).a(localcs);
        int i;
        if (((com.tencent.mm.api.h)localObject).field_actionTime > ce.asQ() / 1000L)
        {
          i = -2;
          label169:
          ((com.tencent.mm.api.h)localObject).field_status = i;
          bd localbd = bd.FzL;
          bd.a(((com.tencent.mm.api.h)localObject).field_functionmsgid, (com.tencent.mm.api.h)localObject);
          if ((localcs == null) || (!this.fTp.remove(localObject))) {
            break label239;
          }
          this.fTq.a((com.tencent.mm.api.h)localObject);
        }
        for (;;)
        {
          if (this.fTp.size() > 0) {
            break label263;
          }
          release();
          break;
          i = 2;
          break label169;
          label239:
          if (this.fTp.remove(localObject)) {
            this.fTq.b((com.tencent.mm.api.h)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(114102);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(114104);
    if (paramn.getType() != 825)
    {
      AppMethodBeat.o(114104);
      return;
    }
    paramn = (a)paramn;
    auh localauh = paramn.hKv;
    paramn = paramn.hKw;
    ad.i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(this.fTp.size()), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (this.fTp.contains(paramn))
    {
      if ((paramInt2 == 0) && ((paramInt2 != 0) || (localauh != null)) && ((localauh == null) || (localauh.OpCode != 2)) && ((localauh == null) || (localauh.OpCode != 1))) {
        break label754;
      }
      paramString = paramn.field_functionmsgid;
      long l1 = paramn.field_preVersion;
      long l2 = paramn.field_version;
      if (localauh != null) {
        break label544;
      }
      paramInt1 = -1;
      ad.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s op:%s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramInt1) });
      if (paramn.field_retryCount >= paramn.field_retryCountLimit) {
        break label636;
      }
      paramInt1 = paramn.field_retryCount;
      paramString = paramn.field_functionmsgid;
      paramInt2 = paramn.field_retryinterval;
      if (localauh != null) {
        break label553;
      }
      bool = true;
      label243:
      ad.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (localauh == null) {
        break label596;
      }
      ad.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", new Object[] { Integer.valueOf(localauh.OpCode), Integer.valueOf(localauh.Dui) });
      if (localauh.OpCode != 2) {
        break label559;
      }
      paramn.field_actionTime = localauh.Dui;
      paramn.field_retryCount += 1;
      paramn.field_status = -1;
      label358:
      paramn.dY(localauh.Duf);
      label368:
      paramString = bd.FzL;
      bd.a(paramn.field_functionmsgid, paramn);
      if (paramn.field_status == 3) {
        break label645;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(paramn.field_reportid, paramn.field_failkey, 1L, false);
      ad.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", new Object[] { Long.valueOf((paramn.field_actionTime - ce.asQ() / 1000L) * 1000L), Integer.valueOf(paramn.field_retryCount) });
      label457:
      if (((paramn.field_status != 2) && (paramn.field_status != -2)) || (!this.fTp.remove(paramn))) {
        break label915;
      }
      this.fTq.a(paramn);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(paramn.field_reportid, paramn.field_successkey, 1L, false);
    }
    for (;;)
    {
      if (this.fTp.size() <= 0) {
        release();
      }
      AppMethodBeat.o(114104);
      return;
      label544:
      paramInt1 = localauh.OpCode;
      break;
      label553:
      bool = false;
      break label243;
      label559:
      if (localauh.OpCode == 1)
      {
        paramn.field_status = 3;
        paramn.field_retryCount = paramn.field_retryCountLimit;
        break label358;
      }
      paramn.field_status = 3;
      break label358;
      label596:
      paramn.field_status = -1;
      paramn.field_actionTime = (ce.asQ() / 1000L + paramn.field_retryinterval);
      paramn.field_retryCount += 1;
      break label368;
      label636:
      paramn.field_status = 3;
      break label368;
      label645:
      paramString = a(paramn.field_addMsg, paramn.field_defaultContent);
      ad.i("FunctionMsg.FunctionMsgFetcher", "[handleFailFetch] addMsgDefault is null? %s", new Object[] { paramString });
      paramn.a(paramString);
      if (paramString == null) {}
      for (paramInt1 = 3;; paramInt1 = 2)
      {
        paramn.field_status = paramInt1;
        if (3 == paramn.field_status)
        {
          paramn.field_version = paramn.field_preVersion;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(paramn.field_reportid, paramn.field_finalfailkey, 1L, false);
        }
        paramString = bd.FzL;
        bd.a(paramn.field_functionmsgid, paramn);
        break;
      }
      label754:
      if ((localauh == null) || (paramInt2 != 0) || ((localauh.OpCode != 3) && (localauh.OpCode != 0))) {
        break label457;
      }
      ad.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", new Object[] { paramn.field_functionmsgid, Long.valueOf(localauh.Dql), Long.valueOf(paramn.field_version), Integer.valueOf(localauh.Dui), Integer.valueOf(localauh.OpCode) });
      if (localauh.OpCode == 3) {}
      for (paramInt1 = -2;; paramInt1 = 2)
      {
        paramn.field_status = paramInt1;
        paramn.a(localauh.Duh);
        paramn.field_businessInfo = localauh.Dug;
        paramn.field_actionTime = localauh.Dui;
        paramString = bd.FzL;
        bd.a(paramn.field_functionmsgid, paramn);
        break;
      }
      label915:
      if (this.fTp.remove(paramn)) {
        this.fTq.b(paramn);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.api.h paramh);
    
    public abstract void b(com.tencent.mm.api.h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.u.b
 * JD-Core Version:    0.7.0.1
 */