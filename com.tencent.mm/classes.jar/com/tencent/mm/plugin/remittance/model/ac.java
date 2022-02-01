package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ac
{
  private static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
  public Object lock;
  public HashMap<String, String> xZG;
  
  public ac()
  {
    AppMethodBeat.i(67903);
    this.xZG = new HashMap();
    this.lock = new Object();
    AppMethodBeat.o(67903);
  }
  
  private boolean awp(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(67906);
        Object localObject;
        if (!awq(paramString))
        {
          localObject = dJh();
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
            g.ajC().ajl().set(al.a.IxD, ((StringBuilder)localObject).toString());
            bool = true;
            AppMethodBeat.o(67906);
            return bool;
          }
        }
        else
        {
          ad.i(TAG, "it is a duplicate msg");
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
  
  private static boolean awq(String paramString)
  {
    AppMethodBeat.i(67910);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67910);
      return false;
    }
    boolean bool = dJh().contains(paramString);
    AppMethodBeat.o(67910);
    return bool;
  }
  
  private static void awr(String paramString)
  {
    AppMethodBeat.i(67911);
    List localList = dJh();
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
    g.ajC().ajl().set(al.a.IxD, paramString.toString());
    AppMethodBeat.o(67911);
  }
  
  private static List<String> dJh()
  {
    AppMethodBeat.i(67909);
    Object localObject = (String)g.ajC().ajl().get(al.a.IxD, "");
    ArrayList localArrayList = new ArrayList();
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject.length > 0) {
        localArrayList.addAll(Arrays.asList((Object[])localObject));
      }
    }
    AppMethodBeat.o(67909);
    return localArrayList;
  }
  
  public final boolean au(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67908);
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      ad.e(TAG, "msgxml or toUserName or antiRepeatid is null");
      AppMethodBeat.o(67908);
      return false;
    }
    if (!awp(paramString1))
    {
      AppMethodBeat.o(67908);
      return false;
    }
    bu localbu = new bu();
    localbu.setContent(paramString2);
    localbu.setStatus(2);
    localbu.tN(paramString3);
    localbu.qA(bj.Bo(paramString3));
    localbu.kr(1);
    localbu.setType(419430449);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().as(localbu);
    if (l < 0L)
    {
      ad.e(TAG, f.abi() + "insert msg failed :" + l);
      awr(paramString1);
      AppMethodBeat.o(67908);
      return false;
    }
    localbu.setMsgId(l);
    boolean bool1;
    if (localbu.cTc())
    {
      b.inZ.b(localbu, com.tencent.mm.ai.l.r(localbu));
      paramString3 = new k();
      paramString3.field_xml = localbu.field_content;
      paramString2 = bt.aRd(paramString2);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.aA(paramString2, localbu.field_reserved);
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
      paramString2 = a.dxR().xH(l);
      if ((paramString2 == null) || (paramString2.field_msgId != l)) {
        break label386;
      }
      bool1 = a.dxR().update(paramString3, new String[0]);
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString2 = new com.tencent.mm.plugin.remittance.b.c();
        paramString2.field_locaMsgId = localbu.field_msgId;
        paramString2.field_transferId = paramString1.hAX;
        paramString2.field_receiveStatus = -1;
        paramString2.field_isSend = true;
        com.tencent.mm.plugin.remittance.a.c.dIB();
        com.tencent.mm.plugin.remittance.a.c.dID().a(paramString2);
      }
      AppMethodBeat.o(67908);
      return bool1;
      b.inZ.q(localbu);
      break;
      label386:
      boolean bool2 = a.dxR().insert(paramString3);
      bool1 = bool2;
      if (!bool2)
      {
        ad.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
        bool1 = bool2;
      }
    }
  }
  
  public final boolean awo(String paramString)
  {
    AppMethodBeat.i(67905);
    synchronized (this.lock)
    {
      boolean bool = awq(paramString);
      AppMethodBeat.o(67905);
      return bool;
    }
  }
  
  public final void iU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67904);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      ad.e(TAG, "saveMsgContent param error");
      AppMethodBeat.o(67904);
      return;
    }
    this.xZG.put(paramString1, paramString2);
    AppMethodBeat.o(67904);
  }
  
  public final boolean iV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67907);
    String str = (String)this.xZG.get(paramString1);
    if (bt.isNullOrNil(str))
    {
      ad.w(TAG, "empty transid: %s", new Object[] { paramString1 });
      AppMethodBeat.o(67907);
      return false;
    }
    boolean bool = au(paramString1, str, paramString2);
    AppMethodBeat.o(67907);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ac
 * JD-Core Version:    0.7.0.1
 */