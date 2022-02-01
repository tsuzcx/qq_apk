package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.s;
import com.tencent.mm.bm.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bs;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.f;

public final class b
  implements com.tencent.mm.ak.i
{
  private List<com.tencent.mm.api.i> heP;
  private a heQ;
  private s heR;
  
  public b(List<com.tencent.mm.api.i> paramList, s params, a parama)
  {
    AppMethodBeat.i(114101);
    g.azz().a(825, this);
    this.heR = params;
    this.heQ = parama;
    this.heP = paramList;
    AppMethodBeat.o(114101);
  }
  
  private static String Fc(String paramString)
  {
    AppMethodBeat.i(114106);
    paramString = ".addmsg".concat(String.valueOf(paramString));
    AppMethodBeat.o(114106);
    return paramString;
  }
  
  private static de a(de paramde, String paramString)
  {
    AppMethodBeat.i(114105);
    if (paramde == null)
    {
      Log.w("FunctionMsg.FunctionMsgFetcher", "null == raw");
      AppMethodBeat.o(114105);
      return null;
    }
    int i = paramString.indexOf("<addmsg");
    if (i == -1)
    {
      Log.e("FunctionMsg.FunctionMsgFetcher", "msgContent not start with <addmsg! content is null?%s", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramString)) });
      AppMethodBeat.o(114105);
      return null;
    }
    Map localMap = XmlParser.parseXml(paramString.substring(i), "addmsg", null);
    StringBuilder localStringBuilder = new StringBuilder();
    if (localMap.containsKey(Fc(".msgid")))
    {
      i = Util.getInt((String)localMap.get(Fc(".msgid")), 0);
      paramde.Brl = i;
      localStringBuilder.append("msgid:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(Fc(".newmsgid")))
    {
      long l = Util.getLong((String)localMap.get(Fc(".newmsgid")), 0L);
      paramde.Brn = l;
      localStringBuilder.append(" newMsgId:".concat(String.valueOf(l)));
    }
    if (localMap.containsKey(Fc(".msgseq")))
    {
      i = Util.getInt((String)localMap.get(Fc(".msgseq")), 0);
      paramde.KHs = i;
      localStringBuilder.append(" msgSeq:".concat(String.valueOf(i)));
    }
    String str;
    if (localMap.containsKey(Fc(".fromusername")))
    {
      str = (String)localMap.get(Fc(".fromusername"));
      paramde.KHl = z.Su(str);
      localStringBuilder.append(" fromUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(Fc(".tousername")))
    {
      str = (String)localMap.get(Fc(".tousername"));
      paramde.KHm = z.Su(str);
      localStringBuilder.append(" toUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(Fc(".msgtype")))
    {
      i = Util.getInt((String)localMap.get(Fc(".msgtype")), 0);
      paramde.xKb = i;
      localStringBuilder.append(" msgType:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(Fc(".status")))
    {
      i = Util.getInt((String)localMap.get(Fc(".status")), 0);
      paramde.oTW = i;
      localStringBuilder.append(" status:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(Fc(".content")))
    {
      paramde.KHn = z.Su(f.bvi(paramString.substring(paramString.indexOf("<content>") + 9, paramString.indexOf("</content>"))));
      localStringBuilder.append(" msgContent:*");
    }
    for (;;)
    {
      if (localMap.containsKey(Fc(".msgsource")))
      {
        paramde.KHq = f.bvi(paramString.substring(paramString.indexOf("<msgsource>") + 11, paramString.indexOf("</msgsource>")));
        localStringBuilder.append(" msgSource:*");
      }
      if (localMap.containsKey(Fc(".pushcontent")))
      {
        paramde.KHr = f.bvi(paramString.substring(paramString.indexOf("<pushcontent>") + 13, paramString.indexOf("</pushcontent>")));
        localStringBuilder.append(" pushContent:*");
      }
      if (localMap.containsKey(Fc(".imgstatus")))
      {
        i = Util.getInt((String)localMap.get(Fc(".imgstatus")), 0);
        paramde.KHo = i;
        localStringBuilder.append(" ImgStatus:".concat(String.valueOf(i)));
      }
      if (localMap.containsKey(Fc(".imgbuf")))
      {
        paramde.KHp = z.Sv((String)localMap.get(Fc(".imgbuf")));
        localStringBuilder.append(" imgBuf:*");
      }
      if (localMap.containsKey(Fc(".createtime")))
      {
        i = Util.getInt((String)localMap.get(Fc(".createtime")), 0);
        paramde.CreateTime = i;
        localStringBuilder.append(" createTime:".concat(String.valueOf(i)));
      }
      Log.i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", new Object[] { localStringBuilder.toString() });
      AppMethodBeat.o(114105);
      return paramde;
      localStringBuilder.append(" msgContent:null");
      paramde.KHn = null;
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(114103);
    g.azz().b(825, this);
    AppMethodBeat.o(114103);
  }
  
  public final void awH()
  {
    AppMethodBeat.i(114102);
    Iterator localIterator = this.heP.iterator();
    label263:
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.api.i)localIterator.next();
      if ((localObject != null) && (((com.tencent.mm.api.i)localObject).field_cgi != null) && (((com.tencent.mm.api.i)localObject).field_cmdid > 0))
      {
        Log.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", new Object[] { ((com.tencent.mm.api.i)localObject).field_functionmsgid });
        ((com.tencent.mm.api.i)localObject).field_status = 0;
        this.heR.b(((com.tencent.mm.api.i)localObject).field_businessInfo);
        localObject = new a((com.tencent.mm.api.i)localObject);
        g.azz().a((q)localObject, 0);
      }
      else if (localObject != null)
      {
        de localde = a(((com.tencent.mm.api.i)localObject).field_addMsg, ((com.tencent.mm.api.i)localObject).field_defaultContent);
        Log.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", new Object[] { localde });
        ((com.tencent.mm.api.i)localObject).a(localde);
        int i;
        if (((com.tencent.mm.api.i)localObject).field_actionTime > cl.aWy() / 1000L)
        {
          i = -2;
          label169:
          ((com.tencent.mm.api.i)localObject).field_status = i;
          bs localbs = bs.OqA;
          bs.a(((com.tencent.mm.api.i)localObject).field_functionmsgid, (com.tencent.mm.api.i)localObject);
          if ((localde == null) || (!this.heP.remove(localObject))) {
            break label239;
          }
          this.heQ.a((com.tencent.mm.api.i)localObject);
        }
        for (;;)
        {
          if (this.heP.size() > 0) {
            break label263;
          }
          release();
          break;
          i = 2;
          break label169;
          label239:
          if (this.heP.remove(localObject)) {
            this.heQ.b((com.tencent.mm.api.i)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(114102);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(114104);
    if (paramq.getType() != 825)
    {
      AppMethodBeat.o(114104);
      return;
    }
    if (this.heP == null)
    {
      Log.e("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] mFetchItemList is null.");
      AppMethodBeat.o(114104);
      return;
    }
    paramq = (a)paramq;
    bnr localbnr = paramq.jDl;
    paramq = paramq.jDm;
    Log.i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(this.heP.size()), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (this.heP.contains(paramq))
    {
      if ((paramInt2 == 0) && ((paramInt2 != 0) || (localbnr != null)) && ((localbnr == null) || (localbnr.OpCode != 2)) && ((localbnr == null) || (localbnr.OpCode != 1))) {
        break label776;
      }
      paramString = paramq.field_functionmsgid;
      long l1 = paramq.field_preVersion;
      long l2 = paramq.field_version;
      if (localbnr != null) {
        break label566;
      }
      paramInt1 = -1;
      Log.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s op:%s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramInt1) });
      if (paramq.field_retryCount >= paramq.field_retryCountLimit) {
        break label658;
      }
      paramInt1 = paramq.field_retryCount;
      paramString = paramq.field_functionmsgid;
      paramInt2 = paramq.field_retryinterval;
      if (localbnr != null) {
        break label575;
      }
      bool = true;
      label265:
      Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (localbnr == null) {
        break label618;
      }
      Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", new Object[] { Integer.valueOf(localbnr.OpCode), Integer.valueOf(localbnr.LWh) });
      if (localbnr.OpCode != 2) {
        break label581;
      }
      paramq.field_actionTime = localbnr.LWh;
      paramq.field_retryCount += 1;
      paramq.field_status = -1;
      label380:
      paramq.fz(localbnr.LWe);
      label390:
      paramString = bs.OqA;
      bs.a(paramq.field_functionmsgid, paramq);
      if (paramq.field_status == 3) {
        break label667;
      }
      h.CyF.idkeyStat(paramq.field_reportid, paramq.field_failkey, 1L, false);
      Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", new Object[] { Long.valueOf((paramq.field_actionTime - cl.aWy() / 1000L) * 1000L), Integer.valueOf(paramq.field_retryCount) });
      label479:
      if (((paramq.field_status != 2) && (paramq.field_status != -2)) || (!this.heP.remove(paramq))) {
        break label937;
      }
      this.heQ.a(paramq);
      h.CyF.idkeyStat(paramq.field_reportid, paramq.field_successkey, 1L, false);
    }
    for (;;)
    {
      if (this.heP.size() <= 0) {
        release();
      }
      AppMethodBeat.o(114104);
      return;
      label566:
      paramInt1 = localbnr.OpCode;
      break;
      label575:
      bool = false;
      break label265;
      label581:
      if (localbnr.OpCode == 1)
      {
        paramq.field_status = 3;
        paramq.field_retryCount = paramq.field_retryCountLimit;
        break label380;
      }
      paramq.field_status = 3;
      break label380;
      label618:
      paramq.field_status = -1;
      paramq.field_actionTime = (cl.aWy() / 1000L + paramq.field_retryinterval);
      paramq.field_retryCount += 1;
      break label390;
      label658:
      paramq.field_status = 3;
      break label390;
      label667:
      paramString = a(paramq.field_addMsg, paramq.field_defaultContent);
      Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailFetch] addMsgDefault is null? %s", new Object[] { paramString });
      paramq.a(paramString);
      if (paramString == null) {}
      for (paramInt1 = 3;; paramInt1 = 2)
      {
        paramq.field_status = paramInt1;
        if (3 == paramq.field_status)
        {
          paramq.field_version = paramq.field_preVersion;
          h.CyF.idkeyStat(paramq.field_reportid, paramq.field_finalfailkey, 1L, false);
        }
        paramString = bs.OqA;
        bs.a(paramq.field_functionmsgid, paramq);
        break;
      }
      label776:
      if ((localbnr == null) || (paramInt2 != 0) || ((localbnr.OpCode != 3) && (localbnr.OpCode != 0))) {
        break label479;
      }
      Log.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", new Object[] { paramq.field_functionmsgid, Long.valueOf(localbnr.LRV), Long.valueOf(paramq.field_version), Integer.valueOf(localbnr.LWh), Integer.valueOf(localbnr.OpCode) });
      if (localbnr.OpCode == 3) {}
      for (paramInt1 = -2;; paramInt1 = 2)
      {
        paramq.field_status = paramInt1;
        paramq.a(localbnr.LWg);
        paramq.field_businessInfo = localbnr.LWf;
        paramq.field_actionTime = localbnr.LWh;
        paramString = bs.OqA;
        bs.a(paramq.field_functionmsgid, paramq);
        break;
      }
      label937:
      if (this.heP.remove(paramq)) {
        this.heQ.b(paramq);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.api.i parami);
    
    public abstract void b(com.tencent.mm.api.i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.u.b
 * JD-Core Version:    0.7.0.1
 */