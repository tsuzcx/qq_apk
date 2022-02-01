package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.api.h;
import com.tencent.mm.bm.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bn;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.ak.f
{
  private List<h> gtf;
  private a gtg;
  private com.tencent.mm.api.q gth;
  
  public b(List<h> paramList, com.tencent.mm.api.q paramq, a parama)
  {
    AppMethodBeat.i(114101);
    com.tencent.mm.kernel.g.ajj().a(825, this);
    this.gth = paramq;
    this.gtg = parama;
    this.gtf = paramList;
    AppMethodBeat.o(114101);
  }
  
  private static cv a(cv paramcv, String paramString)
  {
    AppMethodBeat.i(114105);
    if (paramcv == null)
    {
      ae.w("FunctionMsg.FunctionMsgFetcher", "null == raw");
      AppMethodBeat.o(114105);
      return null;
    }
    int i = paramString.indexOf("<addmsg");
    if (i == -1)
    {
      ae.e("FunctionMsg.FunctionMsgFetcher", "msgContent not start with <addmsg! content is null?%s", new Object[] { Boolean.valueOf(bu.isNullOrNil(paramString)) });
      AppMethodBeat.o(114105);
      return null;
    }
    Map localMap = bx.M(paramString.substring(i), "addmsg");
    StringBuilder localStringBuilder = new StringBuilder();
    if (localMap.containsKey(wL(".msgid")))
    {
      i = bu.getInt((String)localMap.get(wL(".msgid")), 0);
      paramcv.xri = i;
      localStringBuilder.append("msgid:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(wL(".newmsgid")))
    {
      long l = bu.getLong((String)localMap.get(wL(".newmsgid")), 0L);
      paramcv.xrk = l;
      localStringBuilder.append(" newMsgId:".concat(String.valueOf(l)));
    }
    if (localMap.containsKey(wL(".msgseq")))
    {
      i = bu.getInt((String)localMap.get(wL(".msgseq")), 0);
      paramcv.FNN = i;
      localStringBuilder.append(" msgSeq:".concat(String.valueOf(i)));
    }
    String str;
    if (localMap.containsKey(wL(".fromusername")))
    {
      str = (String)localMap.get(wL(".fromusername"));
      paramcv.FNG = z.Jw(str);
      localStringBuilder.append(" fromUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(wL(".tousername")))
    {
      str = (String)localMap.get(wL(".tousername"));
      paramcv.FNH = z.Jw(str);
      localStringBuilder.append(" toUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(wL(".msgtype")))
    {
      i = bu.getInt((String)localMap.get(wL(".msgtype")), 0);
      paramcv.urJ = i;
      localStringBuilder.append(" msgType:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(wL(".status")))
    {
      i = bu.getInt((String)localMap.get(wL(".status")), 0);
      paramcv.nJb = i;
      localStringBuilder.append(" status:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(wL(".content")))
    {
      paramcv.FNI = z.Jw(org.apache.commons.b.f.bfs(paramString.substring(paramString.indexOf("<content>") + 9, paramString.indexOf("</content>"))));
      localStringBuilder.append(" msgContent:*");
    }
    for (;;)
    {
      if (localMap.containsKey(wL(".msgsource")))
      {
        paramcv.FNL = org.apache.commons.b.f.bfs(paramString.substring(paramString.indexOf("<msgsource>") + 11, paramString.indexOf("</msgsource>")));
        localStringBuilder.append(" msgSource:*");
      }
      if (localMap.containsKey(wL(".pushcontent")))
      {
        paramcv.FNM = org.apache.commons.b.f.bfs(paramString.substring(paramString.indexOf("<pushcontent>") + 13, paramString.indexOf("</pushcontent>")));
        localStringBuilder.append(" pushContent:*");
      }
      if (localMap.containsKey(wL(".imgstatus")))
      {
        i = bu.getInt((String)localMap.get(wL(".imgstatus")), 0);
        paramcv.FNJ = i;
        localStringBuilder.append(" ImgStatus:".concat(String.valueOf(i)));
      }
      if (localMap.containsKey(wL(".imgbuf")))
      {
        paramcv.FNK = z.Jx((String)localMap.get(wL(".imgbuf")));
        localStringBuilder.append(" imgBuf:*");
      }
      if (localMap.containsKey(wL(".createtime")))
      {
        i = bu.getInt((String)localMap.get(wL(".createtime")), 0);
        paramcv.CreateTime = i;
        localStringBuilder.append(" createTime:".concat(String.valueOf(i)));
      }
      ae.i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", new Object[] { localStringBuilder.toString() });
      AppMethodBeat.o(114105);
      return paramcv;
      localStringBuilder.append(" msgContent:null");
      paramcv.FNI = null;
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(114103);
    com.tencent.mm.kernel.g.ajj().b(825, this);
    AppMethodBeat.o(114103);
  }
  
  private static String wL(String paramString)
  {
    AppMethodBeat.i(114106);
    paramString = ".addmsg".concat(String.valueOf(paramString));
    AppMethodBeat.o(114106);
    return paramString;
  }
  
  public final void agI()
  {
    AppMethodBeat.i(114102);
    Iterator localIterator = this.gtf.iterator();
    label263:
    while (localIterator.hasNext())
    {
      Object localObject = (h)localIterator.next();
      if ((localObject != null) && (((h)localObject).field_cgi != null) && (((h)localObject).field_cmdid > 0))
      {
        ae.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", new Object[] { ((h)localObject).field_functionmsgid });
        ((h)localObject).field_status = 0;
        this.gth.b(((h)localObject).field_businessInfo);
        localObject = new a((h)localObject);
        com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
      }
      else if (localObject != null)
      {
        cv localcv = a(((h)localObject).field_addMsg, ((h)localObject).field_defaultContent);
        ae.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", new Object[] { localcv });
        ((h)localObject).a(localcv);
        int i;
        if (((h)localObject).field_actionTime > ch.aDa() / 1000L)
        {
          i = -2;
          label169:
          ((h)localObject).field_status = i;
          bn localbn = bn.JgJ;
          bn.a(((h)localObject).field_functionmsgid, (h)localObject);
          if ((localcv == null) || (!this.gtf.remove(localObject))) {
            break label239;
          }
          this.gtg.a((h)localObject);
        }
        for (;;)
        {
          if (this.gtf.size() > 0) {
            break label263;
          }
          release();
          break;
          i = 2;
          break label169;
          label239:
          if (this.gtf.remove(localObject)) {
            this.gtg.b((h)localObject);
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
    if (this.gtf == null)
    {
      ae.e("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] mFetchItemList is null.");
      AppMethodBeat.o(114104);
      return;
    }
    paramn = (a)paramn;
    bcf localbcf = paramn.iHc;
    paramn = paramn.iHd;
    ae.i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(this.gtf.size()), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (this.gtf.contains(paramn))
    {
      if ((paramInt2 == 0) && ((paramInt2 != 0) || (localbcf != null)) && ((localbcf == null) || (localbcf.OpCode != 2)) && ((localbcf == null) || (localbcf.OpCode != 1))) {
        break label776;
      }
      paramString = paramn.field_functionmsgid;
      long l1 = paramn.field_preVersion;
      long l2 = paramn.field_version;
      if (localbcf != null) {
        break label566;
      }
      paramInt1 = -1;
      ae.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s op:%s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramInt1) });
      if (paramn.field_retryCount >= paramn.field_retryCountLimit) {
        break label658;
      }
      paramInt1 = paramn.field_retryCount;
      paramString = paramn.field_functionmsgid;
      paramInt2 = paramn.field_retryinterval;
      if (localbcf != null) {
        break label575;
      }
      bool = true;
      label265:
      ae.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (localbcf == null) {
        break label618;
      }
      ae.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", new Object[] { Integer.valueOf(localbcf.OpCode), Integer.valueOf(localbcf.GSc) });
      if (localbcf.OpCode != 2) {
        break label581;
      }
      paramn.field_actionTime = localbcf.GSc;
      paramn.field_retryCount += 1;
      paramn.field_status = -1;
      label380:
      paramn.eN(localbcf.GRZ);
      label390:
      paramString = bn.JgJ;
      bn.a(paramn.field_functionmsgid, paramn);
      if (paramn.field_status == 3) {
        break label667;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(paramn.field_reportid, paramn.field_failkey, 1L, false);
      ae.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", new Object[] { Long.valueOf((paramn.field_actionTime - ch.aDa() / 1000L) * 1000L), Integer.valueOf(paramn.field_retryCount) });
      label479:
      if (((paramn.field_status != 2) && (paramn.field_status != -2)) || (!this.gtf.remove(paramn))) {
        break label937;
      }
      this.gtg.a(paramn);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(paramn.field_reportid, paramn.field_successkey, 1L, false);
    }
    for (;;)
    {
      if (this.gtf.size() <= 0) {
        release();
      }
      AppMethodBeat.o(114104);
      return;
      label566:
      paramInt1 = localbcf.OpCode;
      break;
      label575:
      bool = false;
      break label265;
      label581:
      if (localbcf.OpCode == 1)
      {
        paramn.field_status = 3;
        paramn.field_retryCount = paramn.field_retryCountLimit;
        break label380;
      }
      paramn.field_status = 3;
      break label380;
      label618:
      paramn.field_status = -1;
      paramn.field_actionTime = (ch.aDa() / 1000L + paramn.field_retryinterval);
      paramn.field_retryCount += 1;
      break label390;
      label658:
      paramn.field_status = 3;
      break label390;
      label667:
      paramString = a(paramn.field_addMsg, paramn.field_defaultContent);
      ae.i("FunctionMsg.FunctionMsgFetcher", "[handleFailFetch] addMsgDefault is null? %s", new Object[] { paramString });
      paramn.a(paramString);
      if (paramString == null) {}
      for (paramInt1 = 3;; paramInt1 = 2)
      {
        paramn.field_status = paramInt1;
        if (3 == paramn.field_status)
        {
          paramn.field_version = paramn.field_preVersion;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(paramn.field_reportid, paramn.field_finalfailkey, 1L, false);
        }
        paramString = bn.JgJ;
        bn.a(paramn.field_functionmsgid, paramn);
        break;
      }
      label776:
      if ((localbcf == null) || (paramInt2 != 0) || ((localbcf.OpCode != 3) && (localbcf.OpCode != 0))) {
        break label479;
      }
      ae.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", new Object[] { paramn.field_functionmsgid, Long.valueOf(localbcf.GNP), Long.valueOf(paramn.field_version), Integer.valueOf(localbcf.GSc), Integer.valueOf(localbcf.OpCode) });
      if (localbcf.OpCode == 3) {}
      for (paramInt1 = -2;; paramInt1 = 2)
      {
        paramn.field_status = paramInt1;
        paramn.a(localbcf.GSb);
        paramn.field_businessInfo = localbcf.GSa;
        paramn.field_actionTime = localbcf.GSc;
        paramString = bn.JgJ;
        bn.a(paramn.field_functionmsgid, paramn);
        break;
      }
      label937:
      if (this.gtf.remove(paramn)) {
        this.gtg.b(paramn);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(h paramh);
    
    public abstract void b(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.u.b
 * JD-Core Version:    0.7.0.1
 */