package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.api.h;
import com.tencent.mm.bn.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bbp;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bm;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.al.f
{
  private List<h> gqF;
  private a gqG;
  private com.tencent.mm.api.q gqH;
  
  public b(List<h> paramList, com.tencent.mm.api.q paramq, a parama)
  {
    AppMethodBeat.i(114101);
    com.tencent.mm.kernel.g.aiU().a(825, this);
    this.gqH = paramq;
    this.gqG = parama;
    this.gqF = paramList;
    AppMethodBeat.o(114101);
  }
  
  private static cv a(cv paramcv, String paramString)
  {
    AppMethodBeat.i(114105);
    if (paramcv == null)
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
    Map localMap = bw.M(paramString.substring(i), "addmsg");
    StringBuilder localStringBuilder = new StringBuilder();
    if (localMap.containsKey(wc(".msgid")))
    {
      i = bt.getInt((String)localMap.get(wc(".msgid")), 0);
      paramcv.xbr = i;
      localStringBuilder.append("msgid:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(wc(".newmsgid")))
    {
      long l = bt.getLong((String)localMap.get(wc(".newmsgid")), 0L);
      paramcv.xbt = l;
      localStringBuilder.append(" newMsgId:".concat(String.valueOf(l)));
    }
    if (localMap.containsKey(wc(".msgseq")))
    {
      i = bt.getInt((String)localMap.get(wc(".msgseq")), 0);
      paramcv.Fvp = i;
      localStringBuilder.append(" msgSeq:".concat(String.valueOf(i)));
    }
    String str;
    if (localMap.containsKey(wc(".fromusername")))
    {
      str = (String)localMap.get(wc(".fromusername"));
      paramcv.Fvi = z.IX(str);
      localStringBuilder.append(" fromUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(wc(".tousername")))
    {
      str = (String)localMap.get(wc(".tousername"));
      paramcv.Fvj = z.IX(str);
      localStringBuilder.append(" toUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(wc(".msgtype")))
    {
      i = bt.getInt((String)localMap.get(wc(".msgtype")), 0);
      paramcv.ugm = i;
      localStringBuilder.append(" msgType:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(wc(".status")))
    {
      i = bt.getInt((String)localMap.get(wc(".status")), 0);
      paramcv.nDG = i;
      localStringBuilder.append(" status:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(wc(".content")))
    {
      paramcv.Fvk = z.IX(org.apache.commons.b.f.bdO(paramString.substring(paramString.indexOf("<content>") + 9, paramString.indexOf("</content>"))));
      localStringBuilder.append(" msgContent:*");
    }
    for (;;)
    {
      if (localMap.containsKey(wc(".msgsource")))
      {
        paramcv.Fvn = org.apache.commons.b.f.bdO(paramString.substring(paramString.indexOf("<msgsource>") + 11, paramString.indexOf("</msgsource>")));
        localStringBuilder.append(" msgSource:*");
      }
      if (localMap.containsKey(wc(".pushcontent")))
      {
        paramcv.Fvo = org.apache.commons.b.f.bdO(paramString.substring(paramString.indexOf("<pushcontent>") + 13, paramString.indexOf("</pushcontent>")));
        localStringBuilder.append(" pushContent:*");
      }
      if (localMap.containsKey(wc(".imgstatus")))
      {
        i = bt.getInt((String)localMap.get(wc(".imgstatus")), 0);
        paramcv.Fvl = i;
        localStringBuilder.append(" ImgStatus:".concat(String.valueOf(i)));
      }
      if (localMap.containsKey(wc(".imgbuf")))
      {
        paramcv.Fvm = z.IY((String)localMap.get(wc(".imgbuf")));
        localStringBuilder.append(" imgBuf:*");
      }
      if (localMap.containsKey(wc(".createtime")))
      {
        i = bt.getInt((String)localMap.get(wc(".createtime")), 0);
        paramcv.CreateTime = i;
        localStringBuilder.append(" createTime:".concat(String.valueOf(i)));
      }
      ad.i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", new Object[] { localStringBuilder.toString() });
      AppMethodBeat.o(114105);
      return paramcv;
      localStringBuilder.append(" msgContent:null");
      paramcv.Fvk = null;
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(114103);
    com.tencent.mm.kernel.g.aiU().b(825, this);
    AppMethodBeat.o(114103);
  }
  
  private static String wc(String paramString)
  {
    AppMethodBeat.i(114106);
    paramString = ".addmsg".concat(String.valueOf(paramString));
    AppMethodBeat.o(114106);
    return paramString;
  }
  
  public final void agu()
  {
    AppMethodBeat.i(114102);
    Iterator localIterator = this.gqF.iterator();
    label263:
    while (localIterator.hasNext())
    {
      Object localObject = (h)localIterator.next();
      if ((localObject != null) && (((h)localObject).field_cgi != null) && (((h)localObject).field_cmdid > 0))
      {
        ad.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", new Object[] { ((h)localObject).field_functionmsgid });
        ((h)localObject).field_status = 0;
        this.gqH.b(((h)localObject).field_businessInfo);
        localObject = new a((h)localObject);
        com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
      }
      else if (localObject != null)
      {
        cv localcv = a(((h)localObject).field_addMsg, ((h)localObject).field_defaultContent);
        ad.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", new Object[] { localcv });
        ((h)localObject).a(localcv);
        int i;
        if (((h)localObject).field_actionTime > cf.aCK() / 1000L)
        {
          i = -2;
          label169:
          ((h)localObject).field_status = i;
          bm localbm = bm.IMc;
          bm.a(((h)localObject).field_functionmsgid, (h)localObject);
          if ((localcv == null) || (!this.gqF.remove(localObject))) {
            break label239;
          }
          this.gqG.a((h)localObject);
        }
        for (;;)
        {
          if (this.gqF.size() > 0) {
            break label263;
          }
          release();
          break;
          i = 2;
          break label169;
          label239:
          if (this.gqF.remove(localObject)) {
            this.gqG.b((h)localObject);
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
    if (this.gqF == null)
    {
      ad.e("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] mFetchItemList is null.");
      AppMethodBeat.o(114104);
      return;
    }
    paramn = (a)paramn;
    bbp localbbp = paramn.iEj;
    paramn = paramn.iEk;
    ad.i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(this.gqF.size()), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (this.gqF.contains(paramn))
    {
      if ((paramInt2 == 0) && ((paramInt2 != 0) || (localbbp != null)) && ((localbbp == null) || (localbbp.OpCode != 2)) && ((localbbp == null) || (localbbp.OpCode != 1))) {
        break label776;
      }
      paramString = paramn.field_functionmsgid;
      long l1 = paramn.field_preVersion;
      long l2 = paramn.field_version;
      if (localbbp != null) {
        break label566;
      }
      paramInt1 = -1;
      ad.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s op:%s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramInt1) });
      if (paramn.field_retryCount >= paramn.field_retryCountLimit) {
        break label658;
      }
      paramInt1 = paramn.field_retryCount;
      paramString = paramn.field_functionmsgid;
      paramInt2 = paramn.field_retryinterval;
      if (localbbp != null) {
        break label575;
      }
      bool = true;
      label265:
      ad.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (localbbp == null) {
        break label618;
      }
      ad.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", new Object[] { Integer.valueOf(localbbp.OpCode), Integer.valueOf(localbbp.GyC) });
      if (localbbp.OpCode != 2) {
        break label581;
      }
      paramn.field_actionTime = localbbp.GyC;
      paramn.field_retryCount += 1;
      paramn.field_status = -1;
      label380:
      paramn.eI(localbbp.Gyz);
      label390:
      paramString = bm.IMc;
      bm.a(paramn.field_functionmsgid, paramn);
      if (paramn.field_status == 3) {
        break label667;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(paramn.field_reportid, paramn.field_failkey, 1L, false);
      ad.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", new Object[] { Long.valueOf((paramn.field_actionTime - cf.aCK() / 1000L) * 1000L), Integer.valueOf(paramn.field_retryCount) });
      label479:
      if (((paramn.field_status != 2) && (paramn.field_status != -2)) || (!this.gqF.remove(paramn))) {
        break label937;
      }
      this.gqG.a(paramn);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(paramn.field_reportid, paramn.field_successkey, 1L, false);
    }
    for (;;)
    {
      if (this.gqF.size() <= 0) {
        release();
      }
      AppMethodBeat.o(114104);
      return;
      label566:
      paramInt1 = localbbp.OpCode;
      break;
      label575:
      bool = false;
      break label265;
      label581:
      if (localbbp.OpCode == 1)
      {
        paramn.field_status = 3;
        paramn.field_retryCount = paramn.field_retryCountLimit;
        break label380;
      }
      paramn.field_status = 3;
      break label380;
      label618:
      paramn.field_status = -1;
      paramn.field_actionTime = (cf.aCK() / 1000L + paramn.field_retryinterval);
      paramn.field_retryCount += 1;
      break label390;
      label658:
      paramn.field_status = 3;
      break label390;
      label667:
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
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(paramn.field_reportid, paramn.field_finalfailkey, 1L, false);
        }
        paramString = bm.IMc;
        bm.a(paramn.field_functionmsgid, paramn);
        break;
      }
      label776:
      if ((localbbp == null) || (paramInt2 != 0) || ((localbbp.OpCode != 3) && (localbbp.OpCode != 0))) {
        break label479;
      }
      ad.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", new Object[] { paramn.field_functionmsgid, Long.valueOf(localbbp.Guq), Long.valueOf(paramn.field_version), Integer.valueOf(localbbp.GyC), Integer.valueOf(localbbp.OpCode) });
      if (localbbp.OpCode == 3) {}
      for (paramInt1 = -2;; paramInt1 = 2)
      {
        paramn.field_status = paramInt1;
        paramn.a(localbbp.GyB);
        paramn.field_businessInfo = localbbp.GyA;
        paramn.field_actionTime = localbbp.GyC;
        paramString = bm.IMc;
        bm.a(paramn.field_functionmsgid, paramn);
        break;
      }
      label937:
      if (this.gqF.remove(paramn)) {
        this.gqG.b(paramn);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(h paramh);
    
    public abstract void b(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.v.b
 * JD-Core Version:    0.7.0.1
 */