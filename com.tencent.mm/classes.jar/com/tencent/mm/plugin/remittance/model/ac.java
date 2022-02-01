package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.r.a;
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

public final class ac
{
  private static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
  public HashMap<String, String> Cqp;
  public Object lock;
  
  public ac()
  {
    AppMethodBeat.i(67903);
    this.Cqp = new HashMap();
    this.lock = new Object();
    AppMethodBeat.o(67903);
  }
  
  private boolean aMe(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(67906);
        Object localObject;
        if (!aMf(paramString))
        {
          localObject = eNz();
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
            g.aAh().azQ().set(ar.a.Oad, ((StringBuilder)localObject).toString());
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
  
  private static boolean aMf(String paramString)
  {
    AppMethodBeat.i(67910);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67910);
      return false;
    }
    boolean bool = eNz().contains(paramString);
    AppMethodBeat.o(67910);
    return bool;
  }
  
  private static void aMg(String paramString)
  {
    AppMethodBeat.i(67911);
    List localList = eNz();
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
    g.aAh().azQ().set(ar.a.Oad, paramString.toString());
    AppMethodBeat.o(67911);
  }
  
  private static List<String> eNz()
  {
    AppMethodBeat.i(67909);
    Object localObject = (String)g.aAh().azQ().get(ar.a.Oad, "");
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
  
  public final boolean aF(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67908);
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      Log.e(TAG, "msgxml or toUserName or antiRepeatid is null");
      AppMethodBeat.o(67908);
      return false;
    }
    if (!aMe(paramString1))
    {
      AppMethodBeat.o(67908);
      return false;
    }
    ca localca = new ca();
    localca.setContent(paramString2);
    localca.setStatus(2);
    localca.Cy(paramString3);
    localca.setCreateTime(bp.Kw(paramString3));
    localca.nv(1);
    localca.setType(419430449);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
    if (l < 0L)
    {
      Log.e(TAG, f.apq() + "insert msg failed :" + l);
      aMg(paramString1);
      AppMethodBeat.o(67908);
      return false;
    }
    localca.setMsgId(l);
    boolean bool1;
    if (localca.dOQ())
    {
      b.jmd.b(localca, com.tencent.mm.ag.l.t(localca));
      paramString3 = new k();
      paramString3.field_xml = localca.field_content;
      paramString2 = Util.processXml(paramString2);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.aD(paramString2, localca.field_reserved);
        paramString1 = paramString2;
        if (paramString2 != null)
        {
          paramString3.field_title = paramString2.title;
          paramString3.field_description = paramString2.description;
          paramString1 = paramString2;
        }
      }
      paramString3.field_type = 2000;
      paramString3.field_msgId = l;
      paramString2 = a.eAT().GL(l);
      if ((paramString2 == null) || (paramString2.field_msgId != l)) {
        break label386;
      }
      bool1 = a.eAT().update(paramString3, new String[0]);
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString2 = new com.tencent.mm.plugin.remittance.b.c();
        paramString2.field_locaMsgId = localca.field_msgId;
        paramString2.field_transferId = paramString1.ixQ;
        paramString2.field_receiveStatus = -1;
        paramString2.field_isSend = true;
        com.tencent.mm.plugin.remittance.a.c.eMU();
        com.tencent.mm.plugin.remittance.a.c.eMW().a(paramString2);
      }
      AppMethodBeat.o(67908);
      return bool1;
      b.jmd.s(localca);
      break;
      label386:
      boolean bool2 = a.eAT().insert(paramString3);
      bool1 = bool2;
      if (!bool2)
      {
        Log.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
        bool1 = bool2;
      }
    }
  }
  
  public final boolean aMd(String paramString)
  {
    AppMethodBeat.i(67905);
    synchronized (this.lock)
    {
      boolean bool = aMf(paramString);
      AppMethodBeat.o(67905);
      return bool;
    }
  }
  
  public final void jL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67904);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e(TAG, "saveMsgContent param error");
      AppMethodBeat.o(67904);
      return;
    }
    this.Cqp.put(paramString1, paramString2);
    AppMethodBeat.o(67904);
  }
  
  public final boolean jM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67907);
    String str = (String)this.Cqp.get(paramString1);
    if (Util.isNullOrNil(str))
    {
      Log.w(TAG, "empty transid: %s", new Object[] { paramString1 });
      AppMethodBeat.o(67907);
      return false;
    }
    boolean bool = aF(paramString1, str, paramString2);
    AppMethodBeat.o(67907);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ac
 * JD-Core Version:    0.7.0.1
 */