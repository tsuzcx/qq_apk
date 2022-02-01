package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.openapi.a;
import com.tencent.mm.plugin.remittance.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class am
{
  private static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
  public HashMap<String, String> OkW;
  public Object lock;
  
  public am()
  {
    AppMethodBeat.i(67903);
    this.OkW = new HashMap();
    this.lock = new Object();
    AppMethodBeat.o(67903);
  }
  
  private boolean aTW(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(67906);
        Object localObject;
        if (!aTX(paramString))
        {
          localObject = gMb();
          ((List)localObject).add(paramString);
          if (((List)localObject).size() > 50)
          {
            paramString = ((List)localObject).subList(((List)localObject).size() - 50, ((List)localObject).size());
            localObject = new StringBuilder();
            Iterator localIterator = paramString.iterator();
            i = 0;
            if (localIterator.hasNext())
            {
              ((StringBuilder)localObject).append((String)localIterator.next());
              if (i == paramString.size() - 1) {
                break label190;
              }
              ((StringBuilder)localObject).append(",");
              break label190;
            }
            h.baE().ban().set(at.a.acPB, ((StringBuilder)localObject).toString());
            bool = true;
            AppMethodBeat.o(67906);
            return bool;
          }
        }
        else
        {
          Log.i(TAG, "it is a duplicate msg");
          AppMethodBeat.o(67906);
          continue;
        }
        paramString = (String)localObject;
      }
      finally {}
      continue;
      label190:
      i += 1;
    }
  }
  
  private static boolean aTX(String paramString)
  {
    AppMethodBeat.i(67910);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67910);
      return false;
    }
    boolean bool = gMb().contains(paramString);
    AppMethodBeat.o(67910);
    return bool;
  }
  
  private static void aTY(String paramString)
  {
    AppMethodBeat.i(67911);
    List localList = gMb();
    localList.remove(paramString);
    paramString = new StringBuilder();
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paramString.append((String)localIterator.next());
      if (i != localList.size() - 1) {
        paramString.append(",");
      }
      i += 1;
    }
    h.baE().ban().set(at.a.acPB, paramString.toString());
    AppMethodBeat.o(67911);
  }
  
  private static List<String> gMb()
  {
    AppMethodBeat.i(67909);
    Object localObject = (String)h.baE().ban().get(at.a.acPB, "");
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject.length > 0) {
        localArrayList.addAll(Arrays.asList((Object[])localObject));
      }
    }
    AppMethodBeat.o(67909);
    return localArrayList;
  }
  
  public static boolean ly(String paramString1, String paramString2)
  {
    AppMethodBeat.i(288796);
    cc localcc = new cc();
    localcc.pI(0);
    localcc.setStatus(6);
    localcc.BS(paramString1);
    localcc.setContent(paramString2);
    if (0L > 0L) {
      localcc.setCreateTime(0L);
    }
    for (;;)
    {
      localcc.setType(10000);
      long l = ((n)h.ax(n.class)).gaZ().ba(localcc);
      Log.i(TAG, "sendLocalSysMsg msgId:".concat(String.valueOf(l)));
      if (l < 0L) {
        break;
      }
      AppMethodBeat.o(288796);
      return true;
      localcc.setCreateTime(br.JN(paramString1));
    }
    AppMethodBeat.o(288796);
    return false;
  }
  
  public final boolean H(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(288821);
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      Log.e(TAG, "msgxml or toUserName or antiRepeatid is null");
      AppMethodBeat.o(288821);
      return false;
    }
    if (!aTW(paramString1))
    {
      AppMethodBeat.o(288821);
      return false;
    }
    cc localcc = new cc();
    localcc.setContent(paramString2);
    localcc.setStatus(2);
    localcc.BS(paramString3);
    localcc.setCreateTime(br.JN(paramString3));
    localcc.pI(1);
    localcc.setType(419430449);
    long l = ((n)h.ax(n.class)).gaZ().ba(localcc);
    if (l < 0L)
    {
      Log.e(TAG, com.tencent.mm.compatible.util.f.aPX() + "insert msg failed :" + l);
      aTY(paramString1);
      AppMethodBeat.o(288821);
      return false;
    }
    localcc.setMsgId(l);
    k localk;
    boolean bool1;
    if (localcc.fxR())
    {
      b.oUZ.d(localcc, com.tencent.mm.message.l.v(localcc));
      localk = new k();
      localk.field_xml = localcc.field_content;
      paramString2 = Util.processXml(paramString2);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.aP(paramString2, localcc.field_reserved);
        paramString1 = paramString2;
        if (paramString2 != null)
        {
          localk.field_title = paramString2.title;
          localk.field_description = paramString2.description;
          paramString1 = paramString2;
        }
      }
      localk.field_type = 2000;
      localk.field_msgId = l;
      paramString2 = a.gxo().rI(l);
      if ((paramString2 == null) || (paramString2.field_msgId != l)) {
        break label404;
      }
      bool1 = a.gxo().update(localk, new String[0]);
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString2 = new com.tencent.mm.plugin.remittance.a.c();
        paramString2.field_locaMsgId = localcc.field_msgId;
        paramString2.field_transferId = paramString1.nSk;
        paramString2.field_receiveStatus = -1;
        paramString2.field_isSend = true;
        paramString2.field_talker = paramString3;
        paramString2.field_receiverName = paramString4;
        com.tencent.mm.plugin.remittance.app.c.gLv();
        com.tencent.mm.plugin.remittance.app.c.gLx().a(paramString2);
      }
      AppMethodBeat.o(288821);
      return bool1;
      b.oUZ.u(localcc);
      break;
      label404:
      boolean bool2 = a.gxo().insert(localk);
      bool1 = bool2;
      if (!bool2)
      {
        Log.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
        bool1 = bool2;
      }
    }
  }
  
  public final boolean aO(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(288815);
    String str = (String)this.OkW.get(paramString1);
    if (Util.isNullOrNil(str))
    {
      Log.w(TAG, "empty transid: %s", new Object[] { paramString1 });
      AppMethodBeat.o(288815);
      return false;
    }
    boolean bool = H(paramString1, str, paramString2, paramString3);
    AppMethodBeat.o(288815);
    return bool;
  }
  
  public final boolean aTV(String paramString)
  {
    AppMethodBeat.i(67905);
    synchronized (this.lock)
    {
      boolean bool = aTX(paramString);
      AppMethodBeat.o(67905);
      return bool;
    }
  }
  
  public final void lx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67904);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e(TAG, "saveMsgContent param error");
      AppMethodBeat.o(67904);
      return;
    }
    this.OkW.put(paramString1, paramString2);
    AppMethodBeat.o(67904);
  }
  
  public final boolean lz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67907);
    boolean bool = aO(paramString1, paramString2, "");
    AppMethodBeat.o(67907);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.am
 * JD-Core Version:    0.7.0.1
 */