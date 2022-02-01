package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.api.s;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.f;

public final class b
  implements com.tencent.mm.an.i
{
  private List<com.tencent.mm.api.i> jQH;
  private a jQI;
  private s jQJ;
  
  public b(List<com.tencent.mm.api.i> paramList, s params, a parama)
  {
    AppMethodBeat.i(114101);
    com.tencent.mm.kernel.h.aGY().a(825, this);
    this.jQJ = params;
    this.jQI = parama;
    this.jQH = paramList;
    AppMethodBeat.o(114101);
  }
  
  private static String LV(String paramString)
  {
    AppMethodBeat.i(114106);
    paramString = ".addmsg".concat(String.valueOf(paramString));
    AppMethodBeat.o(114106);
    return paramString;
  }
  
  private static db a(db paramdb, String paramString)
  {
    AppMethodBeat.i(114105);
    if (paramdb == null)
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
    if (localMap.containsKey(LV(".msgid")))
    {
      i = Util.getInt((String)localMap.get(LV(".msgid")), 0);
      paramdb.HlE = i;
      localStringBuilder.append("msgid:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(LV(".newmsgid")))
    {
      long l = Util.getLong((String)localMap.get(LV(".newmsgid")), 0L);
      paramdb.HlH = l;
      localStringBuilder.append(" newMsgId:".concat(String.valueOf(l)));
    }
    if (localMap.containsKey(LV(".msgseq")))
    {
      i = Util.getInt((String)localMap.get(LV(".msgseq")), 0);
      paramdb.RIK = i;
      localStringBuilder.append(" msgSeq:".concat(String.valueOf(i)));
    }
    String str;
    if (localMap.containsKey(LV(".fromusername")))
    {
      str = (String)localMap.get(LV(".fromusername"));
      paramdb.RID = z.ZW(str);
      localStringBuilder.append(" fromUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(LV(".tousername")))
    {
      str = (String)localMap.get(LV(".tousername"));
      paramdb.RIE = z.ZW(str);
      localStringBuilder.append(" toUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(LV(".msgtype")))
    {
      i = Util.getInt((String)localMap.get(LV(".msgtype")), 0);
      paramdb.COi = i;
      localStringBuilder.append(" msgType:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(LV(".status")))
    {
      i = Util.getInt((String)localMap.get(LV(".status")), 0);
      paramdb.rVU = i;
      localStringBuilder.append(" status:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(LV(".content")))
    {
      paramdb.RIF = z.ZW(f.bIm(paramString.substring(paramString.indexOf("<content>") + 9, paramString.indexOf("</content>"))));
      localStringBuilder.append(" msgContent:*");
    }
    for (;;)
    {
      if (localMap.containsKey(LV(".msgsource")))
      {
        paramdb.RII = f.bIm(paramString.substring(paramString.indexOf("<msgsource>") + 11, paramString.indexOf("</msgsource>")));
        localStringBuilder.append(" msgSource:*");
      }
      if (localMap.containsKey(LV(".pushcontent")))
      {
        paramdb.RIJ = f.bIm(paramString.substring(paramString.indexOf("<pushcontent>") + 13, paramString.indexOf("</pushcontent>")));
        localStringBuilder.append(" pushContent:*");
      }
      if (localMap.containsKey(LV(".imgstatus")))
      {
        i = Util.getInt((String)localMap.get(LV(".imgstatus")), 0);
        paramdb.RIG = i;
        localStringBuilder.append(" ImgStatus:".concat(String.valueOf(i)));
      }
      if (localMap.containsKey(LV(".imgbuf")))
      {
        paramdb.RIH = z.ZX((String)localMap.get(LV(".imgbuf")));
        localStringBuilder.append(" imgBuf:*");
      }
      if (localMap.containsKey(LV(".createtime")))
      {
        i = Util.getInt((String)localMap.get(LV(".createtime")), 0);
        paramdb.CreateTime = i;
        localStringBuilder.append(" createTime:".concat(String.valueOf(i)));
      }
      Log.i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", new Object[] { localStringBuilder.toString() });
      AppMethodBeat.o(114105);
      return paramdb;
      localStringBuilder.append(" msgContent:null");
      paramdb.RIF = null;
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(114103);
    com.tencent.mm.kernel.h.aGY().b(825, this);
    AppMethodBeat.o(114103);
  }
  
  public final void aDZ()
  {
    AppMethodBeat.i(114102);
    Iterator localIterator = this.jQH.iterator();
    label267:
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.api.i)localIterator.next();
      if ((localObject != null) && (((com.tencent.mm.api.i)localObject).field_cgi != null) && (((com.tencent.mm.api.i)localObject).field_cmdid > 0))
      {
        Log.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", new Object[] { ((com.tencent.mm.api.i)localObject).field_functionmsgid });
        ((com.tencent.mm.api.i)localObject).field_status = 0;
        this.jQJ.a(((com.tencent.mm.api.i)localObject).field_functionmsgid, ((com.tencent.mm.api.i)localObject).field_businessInfo);
        localObject = new a((com.tencent.mm.api.i)localObject);
        com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
      }
      else if (localObject != null)
      {
        db localdb = a(((com.tencent.mm.api.i)localObject).field_addMsg, ((com.tencent.mm.api.i)localObject).field_defaultContent);
        Log.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", new Object[] { localdb });
        ((com.tencent.mm.api.i)localObject).a(localdb);
        int i;
        if (((com.tencent.mm.api.i)localObject).field_actionTime > cm.bfC() / 1000L)
        {
          i = -2;
          label173:
          ((com.tencent.mm.api.i)localObject).field_status = i;
          bs localbs = bs.VGw;
          bs.a(((com.tencent.mm.api.i)localObject).field_functionmsgid, (com.tencent.mm.api.i)localObject);
          if ((localdb == null) || (!this.jQH.remove(localObject))) {
            break label243;
          }
          this.jQI.a((com.tencent.mm.api.i)localObject);
        }
        for (;;)
        {
          if (this.jQH.size() > 0) {
            break label267;
          }
          release();
          break;
          i = 2;
          break label173;
          label243:
          if (this.jQH.remove(localObject)) {
            this.jQI.b((com.tencent.mm.api.i)localObject);
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
    if (this.jQH == null)
    {
      Log.e("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] mFetchItemList is null.");
      AppMethodBeat.o(114104);
      return;
    }
    paramq = (a)paramq;
    Object localObject = paramq.mtO;
    paramq = paramq.mtP;
    Log.i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(this.jQH.size()), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (this.jQH.contains(paramq))
    {
      if ((paramInt2 == 0) && ((paramInt2 != 0) || (localObject != null)) && ((localObject == null) || (((bvh)localObject).RLe != 2)) && ((localObject == null) || (((bvh)localObject).RLe != 1))) {
        break label776;
      }
      paramString = paramq.field_functionmsgid;
      long l1 = paramq.field_preVersion;
      long l2 = paramq.field_version;
      if (localObject != null) {
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
      if (localObject != null) {
        break label575;
      }
      bool = true;
      label265:
      Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (localObject == null) {
        break label618;
      }
      Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", new Object[] { Integer.valueOf(((bvh)localObject).RLe), Integer.valueOf(((bvh)localObject).Tfp) });
      if (((bvh)localObject).RLe != 2) {
        break label581;
      }
      paramq.field_actionTime = ((bvh)localObject).Tfp;
      paramq.field_retryCount += 1;
      paramq.field_status = -1;
      label380:
      paramq.gk(((bvh)localObject).Tfm);
      label390:
      paramString = bs.VGw;
      bs.a(paramq.field_functionmsgid, paramq);
      if (paramq.field_status == 3) {
        break label667;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(paramq.field_reportid, paramq.field_failkey, 1L, false);
      Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", new Object[] { Long.valueOf((paramq.field_actionTime - cm.bfC() / 1000L) * 1000L), Integer.valueOf(paramq.field_retryCount) });
      label479:
      if (((paramq.field_status != 2) && (paramq.field_status != -2)) || (!this.jQH.remove(paramq))) {
        break label980;
      }
      this.jQI.a(paramq);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(paramq.field_reportid, paramq.field_successkey, 1L, false);
    }
    for (;;)
    {
      if (this.jQH.size() <= 0) {
        release();
      }
      AppMethodBeat.o(114104);
      return;
      label566:
      paramInt1 = ((bvh)localObject).RLe;
      break;
      label575:
      bool = false;
      break label265;
      label581:
      if (((bvh)localObject).RLe == 1)
      {
        paramq.field_status = 3;
        paramq.field_retryCount = paramq.field_retryCountLimit;
        break label380;
      }
      paramq.field_status = 3;
      break label380;
      label618:
      paramq.field_status = -1;
      paramq.field_actionTime = (cm.bfC() / 1000L + paramq.field_retryinterval);
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
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(paramq.field_reportid, paramq.field_finalfailkey, 1L, false);
        }
        paramString = bs.VGw;
        bs.a(paramq.field_functionmsgid, paramq);
        break;
      }
      label776:
      if ((localObject == null) || (paramInt2 != 0) || ((((bvh)localObject).RLe != 3) && (((bvh)localObject).RLe != 0))) {
        break label479;
      }
      Log.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", new Object[] { paramq.field_functionmsgid, Long.valueOf(((bvh)localObject).TaE), Long.valueOf(paramq.field_version), Integer.valueOf(((bvh)localObject).Tfp), Integer.valueOf(((bvh)localObject).RLe) });
      if (((bvh)localObject).RLe == 3) {}
      for (paramInt1 = -2;; paramInt1 = 2)
      {
        paramq.field_status = paramInt1;
        paramq.field_businessInfo = ((bvh)localObject).Tfn;
        paramq.field_actionTime = ((bvh)localObject).Tfp;
        paramq.a(((bvh)localObject).Tfo);
        if (!((bvh)localObject).RIP.isEmpty())
        {
          paramString = ((bvh)localObject).RIP;
          localObject = new dd();
          ((dd)localObject).RIP.addAll(paramString);
          paramq.field_addMsgs = ((dd)localObject);
        }
        paramString = bs.VGw;
        bs.a(paramq.field_functionmsgid, paramq);
        break;
      }
      label980:
      if (this.jQH.remove(paramq)) {
        this.jQI.b(paramq);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.api.i parami);
    
    public abstract void b(com.tencent.mm.api.i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.u.b
 * JD-Core Version:    0.7.0.1
 */