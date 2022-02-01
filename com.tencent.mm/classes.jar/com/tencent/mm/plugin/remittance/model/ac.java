package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ac
{
  private static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
  public Object lock;
  public HashMap<String, String> ypy;
  
  public ac()
  {
    AppMethodBeat.i(67903);
    this.ypy = new HashMap();
    this.lock = new Object();
    AppMethodBeat.o(67903);
  }
  
  private boolean axE(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(67906);
        Object localObject;
        if (!axF(paramString))
        {
          localObject = dMz();
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
            g.ajR().ajA().set(am.a.ISb, ((StringBuilder)localObject).toString());
            bool = true;
            AppMethodBeat.o(67906);
            return bool;
          }
        }
        else
        {
          ae.i(TAG, "it is a duplicate msg");
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
  
  private static boolean axF(String paramString)
  {
    AppMethodBeat.i(67910);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67910);
      return false;
    }
    boolean bool = dMz().contains(paramString);
    AppMethodBeat.o(67910);
    return bool;
  }
  
  private static void axG(String paramString)
  {
    AppMethodBeat.i(67911);
    List localList = dMz();
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
    g.ajR().ajA().set(am.a.ISb, paramString.toString());
    AppMethodBeat.o(67911);
  }
  
  private static List<String> dMz()
  {
    AppMethodBeat.i(67909);
    Object localObject = (String)g.ajR().ajA().get(am.a.ISb, "");
    ArrayList localArrayList = new ArrayList();
    if (!bu.isNullOrNil((String)localObject))
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
      ae.e(TAG, "msgxml or toUserName or antiRepeatid is null");
      AppMethodBeat.o(67908);
      return false;
    }
    if (!axE(paramString1))
    {
      AppMethodBeat.o(67908);
      return false;
    }
    bv localbv = new bv();
    localbv.setContent(paramString2);
    localbv.setStatus(2);
    localbv.ui(paramString3);
    localbv.qN(bl.BQ(paramString3));
    localbv.kt(1);
    localbv.setType(419430449);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar(localbv);
    if (l < 0L)
    {
      ae.e(TAG, f.abr() + "insert msg failed :" + l);
      axG(paramString1);
      AppMethodBeat.o(67908);
      return false;
    }
    localbv.setMsgId(l);
    boolean bool1;
    if (localbv.cVH())
    {
      b.iqT.b(localbv, com.tencent.mm.ah.l.r(localbv));
      paramString3 = new k();
      paramString3.field_xml = localbv.field_content;
      paramString2 = bu.aSA(paramString2);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.aB(paramString2, localbv.field_reserved);
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
      paramString2 = a.dBh().yb(l);
      if ((paramString2 == null) || (paramString2.field_msgId != l)) {
        break label386;
      }
      bool1 = a.dBh().update(paramString3, new String[0]);
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString2 = new com.tencent.mm.plugin.remittance.b.c();
        paramString2.field_locaMsgId = localbv.field_msgId;
        paramString2.field_transferId = paramString1.hDL;
        paramString2.field_receiveStatus = -1;
        paramString2.field_isSend = true;
        com.tencent.mm.plugin.remittance.a.c.dLS();
        com.tencent.mm.plugin.remittance.a.c.dLU().a(paramString2);
      }
      AppMethodBeat.o(67908);
      return bool1;
      b.iqT.q(localbv);
      break;
      label386:
      boolean bool2 = a.dBh().insert(paramString3);
      bool1 = bool2;
      if (!bool2)
      {
        ae.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
        bool1 = bool2;
      }
    }
  }
  
  public final boolean axD(String paramString)
  {
    AppMethodBeat.i(67905);
    synchronized (this.lock)
    {
      boolean bool = axF(paramString);
      AppMethodBeat.o(67905);
      return bool;
    }
  }
  
  public final void ja(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67904);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.e(TAG, "saveMsgContent param error");
      AppMethodBeat.o(67904);
      return;
    }
    this.ypy.put(paramString1, paramString2);
    AppMethodBeat.o(67904);
  }
  
  public final boolean jb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67907);
    String str = (String)this.ypy.get(paramString1);
    if (bu.isNullOrNil(str))
    {
      ae.w(TAG, "empty transid: %s", new Object[] { paramString1 });
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