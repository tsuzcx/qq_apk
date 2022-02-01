package com.tencent.mm.plugin.selectrecord.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/selectrecord/model/HistoryRecordPackMsgLogic;", "", "()V", "TAG", "", "getNewSvrId", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "packMsg", "Lcom/tencent/mm/protocal/protobuf/ChatHistoryMsgList;", "msgList", "", "Lcom/tencent/mm/storage/MsgInfo;", "plugin-select-record_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Pmz;
  
  static
  {
    AppMethodBeat.i(266758);
    Pmz = new b();
    AppMethodBeat.o(266758);
  }
  
  public static long d(dl paramdl)
  {
    AppMethodBeat.i(266752);
    s.u(paramdl, "addMsg");
    int i = x.z(z.bAM(), cn.bDu()).hashCode();
    Object localObject = "msg_" + paramdl.YFE + '_' + paramdl.YFF + '_' + paramdl.Njv + '_' + i;
    Charset localCharset = d.UTF_8;
    if (localObject == null)
    {
      paramdl = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(266752);
      throw paramdl;
    }
    localObject = ((String)localObject).getBytes(localCharset);
    s.s(localObject, "(this as java.lang.String).getBytes(charset)");
    localObject = com.tencent.mm.b.g.getMessageDigest((byte[])localObject);
    s.s(localObject, "content");
    localObject = ((String)localObject).getBytes(d.UTF_8);
    s.s(localObject, "(this as java.lang.String).getBytes(charset)");
    localObject = ByteBuffer.wrap((byte[])localObject);
    s.s(localObject, "wrap(content.toByteArray())");
    long l = ((ByteBuffer)localObject).getLong();
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.selectRecord.HistoryRecordPackMsgLogic", "getNewSvrId newSvrId:%s content:%s", new Object[] { Long.valueOf(l), paramdl.YFG });
    }
    AppMethodBeat.o(266752);
    return l;
  }
  
  public static ze km(List<? extends cc> paramList)
  {
    AppMethodBeat.i(266743);
    if (paramList == null)
    {
      AppMethodBeat.o(266743);
      return null;
    }
    ze localze = new ze();
    String str1 = z.bAM();
    Object localObject = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      ((ArrayList)localObject).add(cc.bI((cc)paramList.next()));
    }
    Context localContext = MMApplicationContext.getContext();
    Iterator localIterator = ((Iterable)localObject).iterator();
    cc localcc;
    dl localdl;
    label176:
    int i;
    label240:
    int j;
    label371:
    int m;
    if (localIterator.hasNext())
    {
      localcc = (cc)localIterator.next();
      localdl = new dl();
      localdl.YFE = new etl().btH(localcc.field_talker);
      int k;
      if (localcc.field_isSend == 1)
      {
        localdl.YFF = new etl().btH(str1);
        paramList = str1;
        localdl.vhk = 4;
        localdl.YFH = localcc.field_status;
        localdl.YFI = new gol();
        localdl.CreateTime = ((int)(localcc.getCreateTime() / 1000L));
        localdl.Njv = localcc.field_msgSvrId;
        if (localcc.fxR())
        {
          i = 49;
          localdl.IIs = i;
          localdl.YFG = new etl().btH(Util.nullAs(localcc.field_content, ""));
          ((com.tencent.mm.plugin.record.a.g)h.ax(com.tencent.mm.plugin.record.a.g.class)).a(localContext, localcc, localdl);
          localObject = localdl.YFG;
          if (localObject == null) {
            break label704;
          }
          String str2 = ((etl)localObject).abwM;
          if (str2 == null) {
            break label704;
          }
          i = br.JG(str2);
          localObject = str2;
          if (i == -1) {
            break label664;
          }
          localObject = str2.substring(i + 1);
          s.s(localObject, "(this as java.lang.String).substring(startIndex)");
          localObject = (CharSequence)localObject;
          j = 0;
          i = ((CharSequence)localObject).length() - 1;
          for (k = 0;; k = 1)
          {
            if (j > i) {
              break label648;
            }
            if (k != 0) {
              break;
            }
            m = j;
            label383:
            if (s.compare(((CharSequence)localObject).charAt(m), 32) > 0) {
              break label623;
            }
            m = 1;
            label403:
            if (k != 0) {
              break label636;
            }
            if (m != 0) {
              break label629;
            }
          }
        }
      }
      else
      {
        i = br.JG(localcc.field_content);
        if (i == -1) {
          break label795;
        }
        paramList = localcc.field_content;
        s.s(paramList, "msg.content");
        paramList = paramList.substring(0, i);
        s.s(paramList, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramList = (CharSequence)paramList;
        j = 0;
        i = paramList.length() - 1;
        k = 0;
        while (j <= i)
        {
          if (k == 0)
          {
            m = j;
            label488:
            if (s.compare(paramList.charAt(m), 32) > 0) {
              break label527;
            }
            m = 1;
          }
          for (;;)
          {
            if (k == 0)
            {
              if (m == 0)
              {
                k = 1;
                break;
                m = i;
                break label488;
                label527:
                m = 0;
                continue;
              }
              j += 1;
              break;
            }
          }
          if (m == 0) {
            break;
          }
          i -= 1;
        }
        paramList = paramList.subSequence(j, i + 1).toString();
        if (((CharSequence)paramList).length() > 0)
        {
          i = 1;
          label580:
          if (i == 0) {
            break label795;
          }
        }
      }
    }
    for (;;)
    {
      localdl.YFF = new etl().btH(paramList);
      break label176;
      i = 0;
      break label580;
      i = localcc.getType();
      break label240;
      m = i;
      break label383;
      label623:
      m = 0;
      break label403;
      label629:
      j += 1;
      break label371;
      label636:
      if (m != 0)
      {
        i -= 1;
        break label371;
      }
      label648:
      localObject = ((CharSequence)localObject).subSequence(j, i + 1).toString();
      label664:
      localdl.YFG = new etl().btH(paramList + ":\n" + (String)localObject);
      label704:
      long l = d(localdl);
      localdl.YFJ = bt.b(localdl.YFJ, localcc.getCreateTime(), localdl.Njv, l);
      localze.PmC.add(localdl);
      Log.d("MicroMsg.selectRecord.HistoryRecordPackMsgLogic", "packMsg oriMsgId:" + localdl.Njv + ", newMsgId:" + l);
      break;
      AppMethodBeat.o(266743);
      return localze;
      label795:
      paramList = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.b
 * JD-Core Version:    0.7.0.1
 */