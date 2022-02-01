package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bm.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bg;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.f;

public final class b
  implements com.tencent.mm.ak.g
{
  private List<com.tencent.mm.api.h> fXj;
  private a fXk;
  private com.tencent.mm.api.q fXl;
  
  public b(List<com.tencent.mm.api.h> paramList, com.tencent.mm.api.q paramq, a parama)
  {
    AppMethodBeat.i(114101);
    com.tencent.mm.kernel.g.agi().a(825, this);
    this.fXl = paramq;
    this.fXk = parama;
    this.fXj = paramList;
    AppMethodBeat.o(114101);
  }
  
  private static cu a(cu paramcu, String paramString)
  {
    AppMethodBeat.i(114105);
    if (paramcu == null)
    {
      ac.w("FunctionMsg.FunctionMsgFetcher", "null == raw");
      AppMethodBeat.o(114105);
      return null;
    }
    int i = paramString.indexOf("<addmsg");
    if (i == -1)
    {
      ac.e("FunctionMsg.FunctionMsgFetcher", "msgContent not start with <addmsg! content is null?%s", new Object[] { Boolean.valueOf(bs.isNullOrNil(paramString)) });
      AppMethodBeat.o(114105);
      return null;
    }
    Map localMap = bv.L(paramString.substring(i), "addmsg");
    StringBuilder localStringBuilder = new StringBuilder();
    if (localMap.containsKey(tm(".msgid")))
    {
      i = bs.getInt((String)localMap.get(tm(".msgid")), 0);
      paramcu.vTO = i;
      localStringBuilder.append("msgid:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(tm(".newmsgid")))
    {
      long l = bs.getLong((String)localMap.get(tm(".newmsgid")), 0L);
      paramcu.vTQ = l;
      localStringBuilder.append(" newMsgId:".concat(String.valueOf(l)));
    }
    if (localMap.containsKey(tm(".msgseq")))
    {
      i = bs.getInt((String)localMap.get(tm(".msgseq")), 0);
      paramcu.DQa = i;
      localStringBuilder.append(" msgSeq:".concat(String.valueOf(i)));
    }
    String str;
    if (localMap.containsKey(tm(".fromusername")))
    {
      str = (String)localMap.get(tm(".fromusername"));
      paramcu.DPT = z.FI(str);
      localStringBuilder.append(" fromUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(tm(".tousername")))
    {
      str = (String)localMap.get(tm(".tousername"));
      paramcu.DPU = z.FI(str);
      localStringBuilder.append(" toUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(tm(".msgtype")))
    {
      i = bs.getInt((String)localMap.get(tm(".msgtype")), 0);
      paramcu.tit = i;
      localStringBuilder.append(" msgType:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(tm(".status")))
    {
      i = bs.getInt((String)localMap.get(tm(".status")), 0);
      paramcu.ndj = i;
      localStringBuilder.append(" status:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(tm(".content")))
    {
      paramcu.DPV = z.FI(f.aXu(paramString.substring(paramString.indexOf("<content>") + 9, paramString.indexOf("</content>"))));
      localStringBuilder.append(" msgContent:*");
    }
    for (;;)
    {
      if (localMap.containsKey(tm(".msgsource")))
      {
        paramcu.DPY = f.aXu(paramString.substring(paramString.indexOf("<msgsource>") + 11, paramString.indexOf("</msgsource>")));
        localStringBuilder.append(" msgSource:*");
      }
      if (localMap.containsKey(tm(".pushcontent")))
      {
        paramcu.DPZ = f.aXu(paramString.substring(paramString.indexOf("<pushcontent>") + 13, paramString.indexOf("</pushcontent>")));
        localStringBuilder.append(" pushContent:*");
      }
      if (localMap.containsKey(tm(".imgstatus")))
      {
        i = bs.getInt((String)localMap.get(tm(".imgstatus")), 0);
        paramcu.DPW = i;
        localStringBuilder.append(" ImgStatus:".concat(String.valueOf(i)));
      }
      if (localMap.containsKey(tm(".imgbuf")))
      {
        paramcu.DPX = z.FJ((String)localMap.get(tm(".imgbuf")));
        localStringBuilder.append(" imgBuf:*");
      }
      if (localMap.containsKey(tm(".createtime")))
      {
        i = bs.getInt((String)localMap.get(tm(".createtime")), 0);
        paramcu.CreateTime = i;
        localStringBuilder.append(" createTime:".concat(String.valueOf(i)));
      }
      ac.i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", new Object[] { localStringBuilder.toString() });
      AppMethodBeat.o(114105);
      return paramcu;
      localStringBuilder.append(" msgContent:null");
      paramcu.DPV = null;
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(114103);
    com.tencent.mm.kernel.g.agi().b(825, this);
    AppMethodBeat.o(114103);
  }
  
  private static String tm(String paramString)
  {
    AppMethodBeat.i(114106);
    paramString = ".addmsg".concat(String.valueOf(paramString));
    AppMethodBeat.o(114106);
    return paramString;
  }
  
  public final void adO()
  {
    AppMethodBeat.i(114102);
    Iterator localIterator = this.fXj.iterator();
    label263:
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.api.h)localIterator.next();
      if ((localObject != null) && (((com.tencent.mm.api.h)localObject).field_cgi != null) && (((com.tencent.mm.api.h)localObject).field_cmdid > 0))
      {
        ac.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", new Object[] { ((com.tencent.mm.api.h)localObject).field_functionmsgid });
        ((com.tencent.mm.api.h)localObject).field_status = 0;
        this.fXl.b(((com.tencent.mm.api.h)localObject).field_businessInfo);
        localObject = new a((com.tencent.mm.api.h)localObject);
        com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
      }
      else if (localObject != null)
      {
        cu localcu = a(((com.tencent.mm.api.h)localObject).field_addMsg, ((com.tencent.mm.api.h)localObject).field_defaultContent);
        ac.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", new Object[] { localcu });
        ((com.tencent.mm.api.h)localObject).a(localcu);
        int i;
        if (((com.tencent.mm.api.h)localObject).field_actionTime > ce.azH() / 1000L)
        {
          i = -2;
          label169:
          ((com.tencent.mm.api.h)localObject).field_status = i;
          bg localbg = bg.GYN;
          bg.a(((com.tencent.mm.api.h)localObject).field_functionmsgid, (com.tencent.mm.api.h)localObject);
          if ((localcu == null) || (!this.fXj.remove(localObject))) {
            break label239;
          }
          this.fXk.a((com.tencent.mm.api.h)localObject);
        }
        for (;;)
        {
          if (this.fXj.size() > 0) {
            break label263;
          }
          release();
          break;
          i = 2;
          break label169;
          label239:
          if (this.fXj.remove(localObject)) {
            this.fXk.b((com.tencent.mm.api.h)localObject);
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
    axn localaxn = paramn.ikS;
    paramn = paramn.ikT;
    ac.i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(this.fXj.size()), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (this.fXj.contains(paramn))
    {
      if ((paramInt2 == 0) && ((paramInt2 != 0) || (localaxn != null)) && ((localaxn == null) || (localaxn.OpCode != 2)) && ((localaxn == null) || (localaxn.OpCode != 1))) {
        break label754;
      }
      paramString = paramn.field_functionmsgid;
      long l1 = paramn.field_preVersion;
      long l2 = paramn.field_version;
      if (localaxn != null) {
        break label544;
      }
      paramInt1 = -1;
      ac.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s op:%s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramInt1) });
      if (paramn.field_retryCount >= paramn.field_retryCountLimit) {
        break label636;
      }
      paramInt1 = paramn.field_retryCount;
      paramString = paramn.field_functionmsgid;
      paramInt2 = paramn.field_retryinterval;
      if (localaxn != null) {
        break label553;
      }
      bool = true;
      label243:
      ac.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (localaxn == null) {
        break label596;
      }
      ac.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", new Object[] { Integer.valueOf(localaxn.OpCode), Integer.valueOf(localaxn.EPr) });
      if (localaxn.OpCode != 2) {
        break label559;
      }
      paramn.field_actionTime = localaxn.EPr;
      paramn.field_retryCount += 1;
      paramn.field_status = -1;
      label358:
      paramn.dN(localaxn.EPo);
      label368:
      paramString = bg.GYN;
      bg.a(paramn.field_functionmsgid, paramn);
      if (paramn.field_status == 3) {
        break label645;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(paramn.field_reportid, paramn.field_failkey, 1L, false);
      ac.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", new Object[] { Long.valueOf((paramn.field_actionTime - ce.azH() / 1000L) * 1000L), Integer.valueOf(paramn.field_retryCount) });
      label457:
      if (((paramn.field_status != 2) && (paramn.field_status != -2)) || (!this.fXj.remove(paramn))) {
        break label915;
      }
      this.fXk.a(paramn);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(paramn.field_reportid, paramn.field_successkey, 1L, false);
    }
    for (;;)
    {
      if (this.fXj.size() <= 0) {
        release();
      }
      AppMethodBeat.o(114104);
      return;
      label544:
      paramInt1 = localaxn.OpCode;
      break;
      label553:
      bool = false;
      break label243;
      label559:
      if (localaxn.OpCode == 1)
      {
        paramn.field_status = 3;
        paramn.field_retryCount = paramn.field_retryCountLimit;
        break label358;
      }
      paramn.field_status = 3;
      break label358;
      label596:
      paramn.field_status = -1;
      paramn.field_actionTime = (ce.azH() / 1000L + paramn.field_retryinterval);
      paramn.field_retryCount += 1;
      break label368;
      label636:
      paramn.field_status = 3;
      break label368;
      label645:
      paramString = a(paramn.field_addMsg, paramn.field_defaultContent);
      ac.i("FunctionMsg.FunctionMsgFetcher", "[handleFailFetch] addMsgDefault is null? %s", new Object[] { paramString });
      paramn.a(paramString);
      if (paramString == null) {}
      for (paramInt1 = 3;; paramInt1 = 2)
      {
        paramn.field_status = paramInt1;
        if (3 == paramn.field_status)
        {
          paramn.field_version = paramn.field_preVersion;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(paramn.field_reportid, paramn.field_finalfailkey, 1L, false);
        }
        paramString = bg.GYN;
        bg.a(paramn.field_functionmsgid, paramn);
        break;
      }
      label754:
      if ((localaxn == null) || (paramInt2 != 0) || ((localaxn.OpCode != 3) && (localaxn.OpCode != 0))) {
        break label457;
      }
      ac.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", new Object[] { paramn.field_functionmsgid, Long.valueOf(localaxn.ELn), Long.valueOf(paramn.field_version), Integer.valueOf(localaxn.EPr), Integer.valueOf(localaxn.OpCode) });
      if (localaxn.OpCode == 3) {}
      for (paramInt1 = -2;; paramInt1 = 2)
      {
        paramn.field_status = paramInt1;
        paramn.a(localaxn.EPq);
        paramn.field_businessInfo = localaxn.EPp;
        paramn.field_actionTime = localaxn.EPr;
        paramString = bg.GYN;
        bg.a(paramn.field_functionmsgid, paramn);
        break;
      }
      label915:
      if (this.fXj.remove(paramn)) {
        this.fXk.b(paramn);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.api.h paramh);
    
    public abstract void b(com.tencent.mm.api.h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.u.b
 * JD-Core Version:    0.7.0.1
 */