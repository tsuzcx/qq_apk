package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.api.l;
import com.tencent.mm.bl.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ba;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.ai.f
{
  private List<com.tencent.mm.api.f> eyK;
  private b.a eyL;
  private l eyM;
  
  public b(List<com.tencent.mm.api.f> paramList, l paraml, b.a parama)
  {
    AppMethodBeat.i(35449);
    g.Rc().a(825, this);
    this.eyM = paraml;
    this.eyL = parama;
    this.eyK = paramList;
    AppMethodBeat.o(35449);
  }
  
  private static cm a(cm paramcm, String paramString)
  {
    AppMethodBeat.i(35453);
    if (paramcm == null)
    {
      ab.w("FunctionMsg.FunctionMsgFetcher", "null == raw");
      AppMethodBeat.o(35453);
      return null;
    }
    int i = paramString.indexOf("<addmsg");
    if (i == -1)
    {
      ab.e("FunctionMsg.FunctionMsgFetcher", "msgContent not start with <addmsg! content is null?%s", new Object[] { Boolean.valueOf(bo.isNullOrNil(paramString)) });
      AppMethodBeat.o(35453);
      return null;
    }
    Map localMap = br.F(paramString.substring(i), "addmsg");
    StringBuilder localStringBuilder = new StringBuilder();
    if (localMap.containsKey(lM(".msgid")))
    {
      i = bo.getInt((String)localMap.get(lM(".msgid")), 0);
      paramcm.pIE = i;
      localStringBuilder.append("msgid:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(lM(".newmsgid")))
    {
      long l = bo.getLong((String)localMap.get(lM(".newmsgid")), 0L);
      paramcm.pIG = l;
      localStringBuilder.append(" newMsgId:".concat(String.valueOf(l)));
    }
    if (localMap.containsKey(lM(".msgseq")))
    {
      i = bo.getInt((String)localMap.get(lM(".msgseq")), 0);
      paramcm.woW = i;
      localStringBuilder.append(" msgSeq:".concat(String.valueOf(i)));
    }
    String str;
    if (localMap.containsKey(lM(".fromusername")))
    {
      str = (String)localMap.get(lM(".fromusername"));
      paramcm.woP = aa.wA(str);
      localStringBuilder.append(" fromUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(lM(".tousername")))
    {
      str = (String)localMap.get(lM(".tousername"));
      paramcm.woQ = aa.wA(str);
      localStringBuilder.append(" toUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(lM(".msgtype")))
    {
      i = bo.getInt((String)localMap.get(lM(".msgtype")), 0);
      paramcm.nqW = i;
      localStringBuilder.append(" msgType:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(lM(".status")))
    {
      i = bo.getInt((String)localMap.get(lM(".status")), 0);
      paramcm.jJS = i;
      localStringBuilder.append(" status:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(lM(".content")))
    {
      paramcm.woR = aa.wA(org.apache.commons.b.f.azJ(paramString.substring(paramString.indexOf("<content>") + 9, paramString.indexOf("</content>"))));
      localStringBuilder.append(" msgContent:*");
    }
    for (;;)
    {
      if (localMap.containsKey(lM(".msgsource")))
      {
        paramcm.woU = org.apache.commons.b.f.azJ(paramString.substring(paramString.indexOf("<msgsource>") + 11, paramString.indexOf("</msgsource>")));
        localStringBuilder.append(" msgSource:*");
      }
      if (localMap.containsKey(lM(".pushcontent")))
      {
        paramcm.woV = org.apache.commons.b.f.azJ(paramString.substring(paramString.indexOf("<pushcontent>") + 13, paramString.indexOf("</pushcontent>")));
        localStringBuilder.append(" pushContent:*");
      }
      if (localMap.containsKey(lM(".imgstatus")))
      {
        i = bo.getInt((String)localMap.get(lM(".imgstatus")), 0);
        paramcm.woS = i;
        localStringBuilder.append(" ImgStatus:".concat(String.valueOf(i)));
      }
      if (localMap.containsKey(lM(".imgbuf")))
      {
        paramcm.woT = aa.wB((String)localMap.get(lM(".imgbuf")));
        localStringBuilder.append(" imgBuf:*");
      }
      if (localMap.containsKey(lM(".createtime")))
      {
        i = bo.getInt((String)localMap.get(lM(".createtime")), 0);
        paramcm.CreateTime = i;
        localStringBuilder.append(" createTime:".concat(String.valueOf(i)));
      }
      ab.i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", new Object[] { localStringBuilder.toString() });
      AppMethodBeat.o(35453);
      return paramcm;
      localStringBuilder.append(" msgContent:null");
      paramcm.woR = null;
    }
  }
  
  private static String lM(String paramString)
  {
    AppMethodBeat.i(35454);
    paramString = ".addmsg".concat(String.valueOf(paramString));
    AppMethodBeat.o(35454);
    return paramString;
  }
  
  private void release()
  {
    AppMethodBeat.i(35451);
    g.Rc().b(825, this);
    AppMethodBeat.o(35451);
  }
  
  public final void Pm()
  {
    AppMethodBeat.i(35450);
    Iterator localIterator = this.eyK.iterator();
    label263:
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.api.f)localIterator.next();
      if ((localObject != null) && (((com.tencent.mm.api.f)localObject).field_cgi != null) && (((com.tencent.mm.api.f)localObject).field_cmdid > 0))
      {
        ab.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", new Object[] { ((com.tencent.mm.api.f)localObject).field_functionmsgid });
        ((com.tencent.mm.api.f)localObject).field_status = 0;
        this.eyM.b(((com.tencent.mm.api.f)localObject).field_businessInfo);
        localObject = new a((com.tencent.mm.api.f)localObject);
        g.Rc().a((m)localObject, 0);
      }
      else if (localObject != null)
      {
        cm localcm = a(((com.tencent.mm.api.f)localObject).field_addMsg, ((com.tencent.mm.api.f)localObject).field_defaultContent);
        ab.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", new Object[] { localcm });
        ((com.tencent.mm.api.f)localObject).a(localcm);
        int i;
        if (((com.tencent.mm.api.f)localObject).field_actionTime > cb.abp() / 1000L)
        {
          i = -2;
          label169:
          ((com.tencent.mm.api.f)localObject).field_status = i;
          ba localba = ba.yOa;
          ba.a(((com.tencent.mm.api.f)localObject).field_functionmsgid, (com.tencent.mm.api.f)localObject);
          if ((localcm == null) || (!this.eyK.remove(localObject))) {
            break label239;
          }
          this.eyL.a((com.tencent.mm.api.f)localObject);
        }
        for (;;)
        {
          if (this.eyK.size() > 0) {
            break label263;
          }
          release();
          break;
          i = 2;
          break label169;
          label239:
          if (this.eyK.remove(localObject)) {
            this.eyL.b((com.tencent.mm.api.f)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(35450);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(35452);
    if (paramm.getType() != 825)
    {
      AppMethodBeat.o(35452);
      return;
    }
    paramm = (a)paramm;
    akr localakr = paramm.gcW;
    paramm = paramm.gcX;
    ab.i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(this.eyK.size()), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (this.eyK.contains(paramm))
    {
      if ((paramInt2 == 0) && ((paramInt2 != 0) || (localakr != null)) && ((localakr == null) || (localakr.OpCode != 2)) && ((localakr == null) || (localakr.OpCode != 1))) {
        break label754;
      }
      paramString = paramm.field_functionmsgid;
      long l1 = paramm.field_preVersion;
      long l2 = paramm.field_version;
      if (localakr != null) {
        break label544;
      }
      paramInt1 = -1;
      ab.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s op:%s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramInt1) });
      if (paramm.field_retryCount >= paramm.field_retryCountLimit) {
        break label636;
      }
      paramInt1 = paramm.field_retryCount;
      paramString = paramm.field_functionmsgid;
      paramInt2 = paramm.field_retryinterval;
      if (localakr != null) {
        break label553;
      }
      bool = true;
      label243:
      ab.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (localakr == null) {
        break label596;
      }
      ab.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", new Object[] { Integer.valueOf(localakr.OpCode), Integer.valueOf(localakr.xbP) });
      if (localakr.OpCode != 2) {
        break label559;
      }
      paramm.field_actionTime = localakr.xbP;
      paramm.field_retryCount += 1;
      paramm.field_status = -1;
      label358:
      paramm.cY(localakr.xbL);
      label368:
      paramString = ba.yOa;
      ba.a(paramm.field_functionmsgid, paramm);
      if (paramm.field_status == 3) {
        break label645;
      }
      h.qsU.idkeyStat(paramm.field_reportid, paramm.field_failkey, 1L, false);
      ab.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", new Object[] { Long.valueOf((paramm.field_actionTime - cb.abp() / 1000L) * 1000L), Integer.valueOf(paramm.field_retryCount) });
      label457:
      if (((paramm.field_status != 2) && (paramm.field_status != -2)) || (!this.eyK.remove(paramm))) {
        break label915;
      }
      this.eyL.a(paramm);
      h.qsU.idkeyStat(paramm.field_reportid, paramm.field_successkey, 1L, false);
    }
    for (;;)
    {
      if (this.eyK.size() <= 0) {
        release();
      }
      AppMethodBeat.o(35452);
      return;
      label544:
      paramInt1 = localakr.OpCode;
      break;
      label553:
      bool = false;
      break label243;
      label559:
      if (localakr.OpCode == 1)
      {
        paramm.field_status = 3;
        paramm.field_retryCount = paramm.field_retryCountLimit;
        break label358;
      }
      paramm.field_status = 3;
      break label358;
      label596:
      paramm.field_status = -1;
      paramm.field_actionTime = (cb.abp() / 1000L + paramm.field_retryinterval);
      paramm.field_retryCount += 1;
      break label368;
      label636:
      paramm.field_status = 3;
      break label368;
      label645:
      paramString = a(paramm.field_addMsg, paramm.field_defaultContent);
      ab.i("FunctionMsg.FunctionMsgFetcher", "[handleFailFetch] addMsgDefault is null? %s", new Object[] { paramString });
      paramm.a(paramString);
      if (paramString == null) {}
      for (paramInt1 = 3;; paramInt1 = 2)
      {
        paramm.field_status = paramInt1;
        if (3 == paramm.field_status)
        {
          paramm.field_version = paramm.field_preVersion;
          h.qsU.idkeyStat(paramm.field_reportid, paramm.field_finalfailkey, 1L, false);
        }
        paramString = ba.yOa;
        ba.a(paramm.field_functionmsgid, paramm);
        break;
      }
      label754:
      if ((localakr == null) || (paramInt2 != 0) || ((localakr.OpCode != 3) && (localakr.OpCode != 0))) {
        break label457;
      }
      ab.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", new Object[] { paramm.field_functionmsgid, Long.valueOf(localakr.xbN), Long.valueOf(paramm.field_version), Integer.valueOf(localakr.xbP), Integer.valueOf(localakr.OpCode) });
      if (localakr.OpCode == 3) {}
      for (paramInt1 = -2;; paramInt1 = 2)
      {
        paramm.field_status = paramInt1;
        paramm.a(localakr.xbO);
        paramm.field_businessInfo = localakr.xbM;
        paramm.field_actionTime = localakr.xbP;
        paramString = ba.yOa;
        ba.a(paramm.field_functionmsgid, paramm);
        break;
      }
      label915:
      if (this.eyK.remove(paramm)) {
        this.eyL.b(paramm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.u.b
 * JD-Core Version:    0.7.0.1
 */