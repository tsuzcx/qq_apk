package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.bh.a;
import com.tencent.mm.bw.c;
import com.tencent.mm.bw.d;
import com.tencent.mm.bw.e;
import com.tencent.mm.model.cn;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.r;

public final class b
  implements e
{
  private List<j> mpO;
  private a mpP;
  private u mpQ;
  
  public b(List<j> paramList, u paramu, a parama)
  {
    AppMethodBeat.i(114101);
    this.mpQ = paramu;
    this.mpP = parama;
    this.mpO = paramList;
    AppMethodBeat.o(114101);
  }
  
  private static String EC(String paramString)
  {
    AppMethodBeat.i(114106);
    paramString = ".addmsg".concat(String.valueOf(paramString));
    AppMethodBeat.o(114106);
    return paramString;
  }
  
  private static dl a(dl paramdl, String paramString)
  {
    AppMethodBeat.i(114105);
    if (paramdl == null)
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
    if (localMap.containsKey(EC(".msgid")))
    {
      i = Util.getInt((String)localMap.get(EC(".msgid")), 0);
      paramdl.Njs = i;
      localStringBuilder.append("msgid:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(EC(".newmsgid")))
    {
      long l = Util.getLong((String)localMap.get(EC(".newmsgid")), 0L);
      paramdl.Njv = l;
      localStringBuilder.append(" newMsgId:".concat(String.valueOf(l)));
    }
    if (localMap.containsKey(EC(".msgseq")))
    {
      i = Util.getInt((String)localMap.get(EC(".msgseq")), 0);
      paramdl.YFL = i;
      localStringBuilder.append(" msgSeq:".concat(String.valueOf(i)));
    }
    String str;
    if (localMap.containsKey(EC(".fromusername")))
    {
      str = (String)localMap.get(EC(".fromusername"));
      paramdl.YFE = w.Sk(str);
      localStringBuilder.append(" fromUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(EC(".tousername")))
    {
      str = (String)localMap.get(EC(".tousername"));
      paramdl.YFF = w.Sk(str);
      localStringBuilder.append(" toUsername:".concat(String.valueOf(str)));
    }
    if (localMap.containsKey(EC(".msgtype")))
    {
      i = Util.getInt((String)localMap.get(EC(".msgtype")), 0);
      paramdl.IIs = i;
      localStringBuilder.append(" msgType:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(EC(".status")))
    {
      i = Util.getInt((String)localMap.get(EC(".status")), 0);
      paramdl.vhk = i;
      localStringBuilder.append(" status:".concat(String.valueOf(i)));
    }
    if (localMap.containsKey(EC(".content")))
    {
      paramdl.YFG = w.Sk(org.apache.commons.c.h.bLg(paramString.substring(paramString.indexOf("<content>") + 9, paramString.indexOf("</content>"))));
      localStringBuilder.append(" msgContent:*");
    }
    for (;;)
    {
      if (localMap.containsKey(EC(".msgsource")))
      {
        paramdl.YFJ = org.apache.commons.c.h.bLg(paramString.substring(paramString.indexOf("<msgsource>") + 11, paramString.indexOf("</msgsource>")));
        localStringBuilder.append(" msgSource:*");
      }
      if (localMap.containsKey(EC(".pushcontent")))
      {
        paramdl.YFK = org.apache.commons.c.h.bLg(paramString.substring(paramString.indexOf("<pushcontent>") + 13, paramString.indexOf("</pushcontent>")));
        localStringBuilder.append(" pushContent:*");
      }
      if (localMap.containsKey(EC(".imgstatus")))
      {
        i = Util.getInt((String)localMap.get(EC(".imgstatus")), 0);
        paramdl.YFH = i;
        localStringBuilder.append(" ImgStatus:".concat(String.valueOf(i)));
      }
      if (localMap.containsKey(EC(".imgbuf")))
      {
        paramdl.YFI = w.ak((String)localMap.get(EC(".imgbuf")), true);
        localStringBuilder.append(" imgBuf:*");
      }
      if (localMap.containsKey(EC(".createtime")))
      {
        i = Util.getInt((String)localMap.get(EC(".createtime")), 0);
        paramdl.CreateTime = i;
        localStringBuilder.append(" createTime:".concat(String.valueOf(i)));
      }
      Log.i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", new Object[] { localStringBuilder.toString() });
      AppMethodBeat.o(114105);
      return paramdl;
      localStringBuilder.append(" msgContent:null");
      paramdl.YFG = null;
    }
  }
  
  public final void a(int paramInt, String paramString, p paramp)
  {
    AppMethodBeat.i(231427);
    if (paramp.getType() != 825)
    {
      AppMethodBeat.o(231427);
      return;
    }
    if (this.mpO == null)
    {
      Log.e("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] mFetchItemList is null.");
      AppMethodBeat.o(231427);
      return;
    }
    paramp = (a)paramp;
    Object localObject = paramp.pnh;
    paramp = paramp.pnj;
    Log.i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s errCode:%s errMsg:%s functionMsgId:%s", new Object[] { Integer.valueOf(this.mpO.size()), Integer.valueOf(paramInt), paramString, paramp.field_functionmsgid });
    if (this.mpO.contains(paramp))
    {
      boolean bool;
      if ((paramInt != 0) || ((paramInt == 0) && (localObject == null)) || ((localObject != null) && (((ckj)localObject).YIq == 2)) || ((localObject != null) && (((ckj)localObject).YIq == 1)))
      {
        paramString = paramp.field_functionmsgid;
        long l1 = paramp.field_preVersion;
        long l2 = paramp.field_version;
        if (localObject == null)
        {
          paramInt = -1;
          Log.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s op:%s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramInt) });
          if (paramp.field_retryCount >= paramp.field_retryCountLimit) {
            break label609;
          }
          paramInt = paramp.field_retryCount;
          paramString = paramp.field_functionmsgid;
          int i = paramp.field_retryinterval;
          if (localObject != null) {
            break label535;
          }
          bool = true;
          label258:
          Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(i), Boolean.valueOf(bool) });
          if (localObject == null) {
            break label574;
          }
          Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", new Object[] { Integer.valueOf(((ckj)localObject).YIq), Integer.valueOf(((ckj)localObject).aasJ) });
          if (((ckj)localObject).YIq != 2) {
            break label541;
          }
          paramp.field_actionTime = ((ckj)localObject).aasJ;
          paramp.field_retryCount += 1;
          paramp.field_status = -1;
          label370:
          paramp.hL(((ckj)localObject).aasG);
          label379:
          paramString = bu.adkj;
          bu.a(paramp.field_functionmsgid, paramp);
          if (paramp.field_status == 3) {
            break label617;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(paramp.field_reportid, paramp.field_failkey, 1L, false);
          Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", new Object[] { Long.valueOf((paramp.field_actionTime - cn.bDu() / 1000L) * 1000L), Integer.valueOf(paramp.field_retryCount) });
        }
      }
      for (;;)
      {
        if (((paramp.field_status == 2) || (paramp.field_status == -2)) && (this.mpO.remove(paramp)))
        {
          this.mpP.a(paramp);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(paramp.field_reportid, paramp.field_successkey, 1L, false);
          AppMethodBeat.o(231427);
          return;
          paramInt = ((ckj)localObject).YIq;
          break;
          label535:
          bool = false;
          break label258;
          label541:
          if (((ckj)localObject).YIq == 1)
          {
            paramp.field_status = 3;
            paramp.field_retryCount = paramp.field_retryCountLimit;
            break label370;
          }
          paramp.field_status = 3;
          break label370;
          label574:
          paramp.field_status = -1;
          paramp.field_actionTime = (cn.bDu() / 1000L + paramp.field_retryinterval);
          paramp.field_retryCount += 1;
          break label379;
          label609:
          paramp.field_status = 3;
          break label379;
          label617:
          paramString = a(paramp.field_addMsg, paramp.field_defaultContent);
          Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailFetch] addMsgDefault is null? %s", new Object[] { paramString });
          paramp.a(paramString);
          if (paramString == null) {}
          for (paramInt = 3;; paramInt = 2)
          {
            paramp.field_status = paramInt;
            if (3 == paramp.field_status)
            {
              paramp.field_version = paramp.field_preVersion;
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(paramp.field_reportid, paramp.field_finalfailkey, 1L, false);
            }
            paramString = bu.adkj;
            bu.a(paramp.field_functionmsgid, paramp);
            break;
          }
          if ((localObject != null) && (paramInt == 0) && ((((ckj)localObject).YIq == 3) || (((ckj)localObject).YIq == 0)))
          {
            Log.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", new Object[] { paramp.field_functionmsgid, Long.valueOf(((ckj)localObject).aanC), Long.valueOf(paramp.field_version), Integer.valueOf(((ckj)localObject).aasJ), Integer.valueOf(((ckj)localObject).YIq) });
            if (((ckj)localObject).YIq == 3) {}
            for (paramInt = -2;; paramInt = 2)
            {
              paramp.field_status = paramInt;
              paramp.field_businessInfo = ((ckj)localObject).aasH;
              paramp.field_actionTime = ((ckj)localObject).aasJ;
              paramp.a(((ckj)localObject).aasI);
              if (!((ckj)localObject).YFQ.isEmpty())
              {
                paramString = ((ckj)localObject).YFQ;
                localObject = new dn();
                ((dn)localObject).YFQ.addAll(paramString);
                paramp.field_addMsgs = ((dn)localObject);
              }
              paramString = bu.adkj;
              bu.a(paramp.field_functionmsgid, paramp);
              break;
            }
          }
        }
      }
      if (this.mpO.remove(paramp)) {
        this.mpP.b(paramp);
      }
    }
    AppMethodBeat.o(231427);
  }
  
  public final void aXc()
  {
    AppMethodBeat.i(114102);
    Iterator localIterator = this.mpO.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      Object localObject;
      if ((localj != null) && (localj.field_cgi != null) && (localj.field_cmdid > 0))
      {
        Log.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", new Object[] { localj.field_functionmsgid });
        localj.field_status = 0;
        this.mpQ.a(localj.field_functionmsgid, localj.field_businessInfo);
        localObject = c.YwQ;
        c.axm(localj.field_cmdid).k(new r(localj, this));
      }
      else if (localj != null)
      {
        localObject = a(localj.field_addMsg, localj.field_defaultContent);
        Log.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", new Object[] { localObject });
        localj.a((dl)localObject);
        if (localj.field_actionTime > cn.bDu() / 1000L) {}
        for (int i = -2;; i = 2)
        {
          localj.field_status = i;
          bu localbu = bu.adkj;
          bu.a(localj.field_functionmsgid, localj);
          if ((localObject == null) || (!this.mpO.remove(localj))) {
            break label235;
          }
          this.mpP.a(localj);
          break;
        }
        label235:
        if (this.mpO.remove(localj)) {
          this.mpP.b(localj);
        }
      }
    }
    AppMethodBeat.o(114102);
  }
  
  public static abstract interface a
  {
    public abstract void a(j paramj);
    
    public abstract void b(j paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.s.b
 * JD-Core Version:    0.7.0.1
 */