package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.ab.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ak
{
  private static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
  public HashMap<String, String> InG;
  public Object lock;
  
  public ak()
  {
    AppMethodBeat.i(67903);
    this.InG = new HashMap();
    this.lock = new Object();
    AppMethodBeat.o(67903);
  }
  
  private boolean aWI(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(67906);
        Object localObject;
        if (!aWJ(paramString))
        {
          localObject = fAp();
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
            h.aHG().aHp().set(ar.a.Vof, ((StringBuilder)localObject).toString());
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
  
  private static boolean aWJ(String paramString)
  {
    AppMethodBeat.i(67910);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67910);
      return false;
    }
    boolean bool = fAp().contains(paramString);
    AppMethodBeat.o(67910);
    return bool;
  }
  
  private static void aWK(String paramString)
  {
    AppMethodBeat.i(67911);
    List localList = fAp();
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
    h.aHG().aHp().set(ar.a.Vof, paramString.toString());
    AppMethodBeat.o(67911);
  }
  
  private static List<String> fAp()
  {
    AppMethodBeat.i(67909);
    Object localObject = (String)h.aHG().aHp().get(ar.a.Vof, "");
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
  
  public static boolean kc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197724);
    ca localca = new ca();
    localca.pJ(0);
    localca.setStatus(6);
    localca.Jm(paramString1);
    localca.setContent(paramString2);
    if (0L > 0L) {
      localca.setCreateTime(0L);
    }
    for (;;)
    {
      localca.setType(10000);
      long l = ((n)h.ae(n.class)).eSe().aM(localca);
      Log.i(TAG, "sendLocalSysMsg msgId:".concat(String.valueOf(l)));
      if (l < 0L) {
        break;
      }
      AppMethodBeat.o(197724);
      return true;
      localca.setCreateTime(bq.RP(paramString1));
    }
    AppMethodBeat.o(197724);
    return false;
  }
  
  public final boolean F(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(197729);
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      Log.e(TAG, "msgxml or toUserName or antiRepeatid is null");
      AppMethodBeat.o(197729);
      return false;
    }
    if (!aWI(paramString1))
    {
      AppMethodBeat.o(197729);
      return false;
    }
    ca localca = new ca();
    localca.setContent(paramString2);
    localca.setStatus(2);
    localca.Jm(paramString3);
    localca.setCreateTime(bq.RP(paramString3));
    localca.pJ(1);
    localca.setType(419430449);
    long l = ((n)h.ae(n.class)).eSe().aM(localca);
    if (l < 0L)
    {
      Log.e(TAG, com.tencent.mm.compatible.util.f.avD() + "insert msg failed :" + l);
      aWK(paramString1);
      AppMethodBeat.o(197729);
      return false;
    }
    localca.setMsgId(l);
    k localk;
    boolean bool1;
    if (localca.erk())
    {
      b.mcf.d(localca, com.tencent.mm.aj.l.v(localca));
      localk = new k();
      localk.field_xml = localca.field_content;
      paramString2 = Util.processXml(paramString2);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.aG(paramString2, localca.field_reserved);
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
      paramString2 = a.fmA().NR(l);
      if ((paramString2 == null) || (paramString2.field_msgId != l)) {
        break label404;
      }
      bool1 = a.fmA().update(localk, new String[0]);
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString2 = new com.tencent.mm.plugin.remittance.b.c();
        paramString2.field_locaMsgId = localca.field_msgId;
        paramString2.field_transferId = paramString1.lnf;
        paramString2.field_receiveStatus = -1;
        paramString2.field_isSend = true;
        paramString2.field_talker = paramString3;
        paramString2.field_receiverName = paramString4;
        com.tencent.mm.plugin.remittance.a.c.fzJ();
        com.tencent.mm.plugin.remittance.a.c.fzL().a(paramString2);
      }
      AppMethodBeat.o(197729);
      return bool1;
      b.mcf.u(localca);
      break;
      label404:
      boolean bool2 = a.fmA().insert(localk);
      bool1 = bool2;
      if (!bool2)
      {
        Log.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
        bool1 = bool2;
      }
    }
  }
  
  public final boolean aA(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(197725);
    String str = (String)this.InG.get(paramString1);
    if (Util.isNullOrNil(str))
    {
      Log.w(TAG, "empty transid: %s", new Object[] { paramString1 });
      AppMethodBeat.o(197725);
      return false;
    }
    boolean bool = F(paramString1, str, paramString2, paramString3);
    AppMethodBeat.o(197725);
    return bool;
  }
  
  public final boolean aWH(String paramString)
  {
    AppMethodBeat.i(67905);
    synchronized (this.lock)
    {
      boolean bool = aWJ(paramString);
      AppMethodBeat.o(67905);
      return bool;
    }
  }
  
  public final void kb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67904);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e(TAG, "saveMsgContent param error");
      AppMethodBeat.o(67904);
      return;
    }
    this.InG.put(paramString1, paramString2);
    AppMethodBeat.o(67904);
  }
  
  public final boolean kd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67907);
    boolean bool = aA(paramString1, paramString2, "");
    AppMethodBeat.o(67907);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ak
 * JD-Core Version:    0.7.0.1
 */