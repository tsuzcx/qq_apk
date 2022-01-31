package com.tencent.mm.v;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.api.e;
import com.tencent.mm.api.k;
import com.tencent.mm.bk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.afy;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ba;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.a.a.b.d;

public final class b
  implements f
{
  private List<e> dBt;
  private b.a dBu;
  private k dBv;
  
  public b(List<e> paramList, k paramk, b.a parama)
  {
    g.Dk().a(825, this);
    this.dBv = paramk;
    this.dBu = parama;
    this.dBt = paramList;
  }
  
  private static cd a(cd paramcd, String paramString)
  {
    if (paramcd == null)
    {
      y.w("FunctionMsg.FunctionMsgFetcher", "null == raw");
      return null;
    }
    int i = paramString.indexOf("<addmsg");
    if (i == -1)
    {
      y.e("FunctionMsg.FunctionMsgFetcher", "msgContent not start with <addmsg! content is null?%s", new Object[] { Boolean.valueOf(bk.bl(paramString)) });
      return null;
    }
    Map localMap = bn.s(paramString.substring(i), "addmsg");
    StringBuilder localStringBuilder = new StringBuilder();
    if (localMap.containsKey(fu(".msgid")))
    {
      i = bk.getInt((String)localMap.get(fu(".msgid")), 0);
      paramcd.ndm = i;
      localStringBuilder.append("msgid:" + i);
    }
    if (localMap.containsKey(fu(".newmsgid")))
    {
      long l = bk.getLong((String)localMap.get(fu(".newmsgid")), 0L);
      paramcd.ndp = l;
      localStringBuilder.append(" newMsgId:" + l);
    }
    if (localMap.containsKey(fu(".msgseq")))
    {
      i = bk.getInt((String)localMap.get(fu(".msgseq")), 0);
      paramcd.svM = i;
      localStringBuilder.append(" msgSeq:" + i);
    }
    String str;
    if (localMap.containsKey(fu(".fromusername")))
    {
      str = (String)localMap.get(fu(".fromusername"));
      paramcd.svF = aa.pj(str);
      localStringBuilder.append(" fromUsername:" + str);
    }
    if (localMap.containsKey(fu(".tousername")))
    {
      str = (String)localMap.get(fu(".tousername"));
      paramcd.svG = aa.pj(str);
      localStringBuilder.append(" toUsername:" + str);
    }
    if (localMap.containsKey(fu(".msgtype")))
    {
      i = bk.getInt((String)localMap.get(fu(".msgtype")), 0);
      paramcd.kSW = i;
      localStringBuilder.append(" msgType:" + i);
    }
    if (localMap.containsKey(fu(".status")))
    {
      i = bk.getInt((String)localMap.get(fu(".status")), 0);
      paramcd.hQq = i;
      localStringBuilder.append(" status:" + i);
    }
    if (localMap.containsKey(fu(".content")))
    {
      paramcd.svH = aa.pj(d.ahq(paramString.substring(paramString.indexOf("<content>") + 9, paramString.indexOf("</content>"))));
      localStringBuilder.append(" msgContent:*");
    }
    for (;;)
    {
      if (localMap.containsKey(fu(".msgsource")))
      {
        paramcd.svK = d.ahq(paramString.substring(paramString.indexOf("<msgsource>") + 11, paramString.indexOf("</msgsource>")));
        localStringBuilder.append(" msgSource:*");
      }
      if (localMap.containsKey(fu(".pushcontent")))
      {
        paramcd.svL = d.ahq(paramString.substring(paramString.indexOf("<pushcontent>") + 13, paramString.indexOf("</pushcontent>")));
        localStringBuilder.append(" pushContent:*");
      }
      if (localMap.containsKey(fu(".imgstatus")))
      {
        i = bk.getInt((String)localMap.get(fu(".imgstatus")), 0);
        paramcd.svI = i;
        localStringBuilder.append(" ImgStatus:" + i);
      }
      if (localMap.containsKey(fu(".imgbuf")))
      {
        paramcd.svJ = aa.pk((String)localMap.get(fu(".imgbuf")));
        localStringBuilder.append(" imgBuf:*");
      }
      if (localMap.containsKey(fu(".createtime")))
      {
        i = bk.getInt((String)localMap.get(fu(".createtime")), 0);
        paramcd.mPL = i;
        localStringBuilder.append(" createTime:" + i);
      }
      y.i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", new Object[] { localStringBuilder.toString() });
      return paramcd;
      localStringBuilder.append(" msgContent:null");
      paramcd.svH = null;
    }
  }
  
  private static String fu(String paramString)
  {
    return ".addmsg" + paramString;
  }
  
  private void release()
  {
    g.Dk().b(825, this);
  }
  
  public final void By()
  {
    Iterator localIterator = this.dBt.iterator();
    label267:
    while (localIterator.hasNext())
    {
      Object localObject1 = (e)localIterator.next();
      Object localObject2;
      Object localObject3;
      if ((localObject1 != null) && (((e)localObject1).field_cgi != null) && (((e)localObject1).field_cmdid > 0))
      {
        y.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", new Object[] { ((e)localObject1).field_functionmsgid });
        ((e)localObject1).field_status = 0;
        localObject2 = this.dBv;
        localObject3 = ((e)localObject1).field_functionmsgid;
        ((k)localObject2).b(((e)localObject1).field_businessInfo);
        localObject1 = new a((e)localObject1);
        g.Dk().a((m)localObject1, 0);
      }
      else if (localObject1 != null)
      {
        localObject2 = a(((e)localObject1).field_addMsg, ((e)localObject1).field_defaultContent);
        y.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", new Object[] { localObject2 });
        ((e)localObject1).a((cd)localObject2);
        int i;
        if (((e)localObject1).field_actionTime > bz.Is() / 1000L)
        {
          i = -2;
          label173:
          ((e)localObject1).field_status = i;
          localObject3 = ba.uBO;
          ba.a(((e)localObject1).field_functionmsgid, (e)localObject1);
          if ((localObject2 == null) || (!this.dBt.remove(localObject1))) {
            break label243;
          }
          this.dBu.a((e)localObject1);
        }
        for (;;)
        {
          if (this.dBt.size() > 0) {
            break label267;
          }
          release();
          break;
          i = 2;
          break label173;
          label243:
          if (this.dBt.remove(localObject1)) {
            this.dBu.b((e)localObject1);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 825) {}
    label210:
    label861:
    for (;;)
    {
      return;
      paramString = (a)paramm;
      paramm = paramString.eNq;
      paramString = paramString.eNr;
      y.i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s", new Object[] { Integer.valueOf(this.dBt.size()) });
      boolean bool;
      if (this.dBt.contains(paramString))
      {
        if ((paramInt2 == 0) && ((paramInt2 != 0) || (paramm != null)) && ((paramm == null) || (paramm.ssq != 2)) && ((paramm == null) || (paramm.ssq != 1))) {
          break label683;
        }
        String str = paramString.field_functionmsgid;
        long l1 = paramString.field_preVersion;
        long l2 = paramString.field_version;
        if (paramm != null) {
          break label489;
        }
        paramInt1 = -1;
        y.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s op:%s", new Object[] { str, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramInt1) });
        if (paramString.field_retryCount >= paramString.field_retryCountLimit) {
          break label572;
        }
        paramInt1 = paramString.field_retryCount;
        str = paramString.field_functionmsgid;
        paramInt2 = paramString.field_retryinterval;
        if (paramm != null) {
          break label498;
        }
        bool = true;
        y.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s", new Object[] { Integer.valueOf(paramInt1), str, Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
        if (paramm == null) {
          break label537;
        }
        y.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", new Object[] { Integer.valueOf(paramm.ssq), Integer.valueOf(paramm.tdQ) });
        if (paramm.ssq != 2) {
          break label504;
        }
        paramString.field_actionTime = paramm.tdQ;
        paramString.field_retryCount += 1;
        paramString.field_status = -1;
        paramString.bW(paramm.tdM);
        paramm = ba.uBO;
        ba.a(paramString.field_functionmsgid, paramString);
        if (paramString.field_status == 3) {
          break label580;
        }
        h.nFQ.a(paramString.field_reportid, paramString.field_failkey, 1L, false);
        y.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", new Object[] { Long.valueOf((paramString.field_actionTime - bz.Is() / 1000L) * 1000L), Integer.valueOf(paramString.field_retryCount) });
        if (((paramString.field_status != 2) && (paramString.field_status != -2)) || (!this.dBt.remove(paramString))) {
          break label837;
        }
        this.dBu.a(paramString);
        h.nFQ.a(paramString.field_reportid, paramString.field_successkey, 1L, false);
      }
      for (;;)
      {
        if (this.dBt.size() > 0) {
          break label861;
        }
        release();
        return;
        label489:
        paramInt1 = paramm.ssq;
        break;
        label498:
        bool = false;
        break label210;
        label504:
        if (paramm.ssq == 1)
        {
          paramString.field_status = 3;
          paramString.field_retryCount = paramString.field_retryCountLimit;
          break label322;
        }
        paramString.field_status = 3;
        break label322;
        paramString.field_status = -1;
        paramString.field_actionTime = (bz.Is() / 1000L + paramString.field_retryinterval);
        paramString.field_retryCount += 1;
        break label322;
        paramString.field_status = 3;
        break label331;
        paramm = a(paramString.field_addMsg, paramString.field_defaultContent);
        y.i("FunctionMsg.FunctionMsgFetcher", "[handleFailFetch] addMsgDefault is null? %s", new Object[] { paramm });
        paramString.a(paramm);
        if (paramm == null) {}
        for (paramInt1 = 3;; paramInt1 = 2)
        {
          paramString.field_status = paramInt1;
          if (3 == paramString.field_status)
          {
            paramString.field_version = paramString.field_preVersion;
            h.nFQ.a(paramString.field_reportid, paramString.field_finalfailkey, 1L, false);
          }
          paramm = ba.uBO;
          ba.a(paramString.field_functionmsgid, paramString);
          break;
        }
        if ((paramm == null) || (paramInt2 != 0) || ((paramm.ssq != 3) && (paramm.ssq != 0))) {
          break label414;
        }
        y.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", new Object[] { paramString.field_functionmsgid, Long.valueOf(paramm.tdO), Long.valueOf(paramString.field_version), Integer.valueOf(paramm.tdQ), Integer.valueOf(paramm.ssq) });
        if (paramm.ssq == 3) {}
        for (paramInt1 = -2;; paramInt1 = 2)
        {
          paramString.field_status = paramInt1;
          paramString.a(paramm.tdP);
          paramString.field_businessInfo = paramm.tdN;
          paramString.field_actionTime = paramm.tdQ;
          paramm = ba.uBO;
          ba.a(paramString.field_functionmsgid, paramString);
          break;
        }
        if (this.dBt.remove(paramString)) {
          this.dBu.b(paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.v.b
 * JD-Core Version:    0.7.0.1
 */