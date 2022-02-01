package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ac
{
  private static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
  public Object lock;
  public HashMap<String, String> vBU;
  
  public ac()
  {
    AppMethodBeat.i(67903);
    this.vBU = new HashMap();
    this.lock = new Object();
    AppMethodBeat.o(67903);
  }
  
  private boolean ami(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(67906);
        Object localObject;
        if (!amj(paramString))
        {
          localObject = djN();
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
            g.afB().afk().set(ae.a.Fnw, ((StringBuilder)localObject).toString());
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
  
  private static boolean amj(String paramString)
  {
    AppMethodBeat.i(67910);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67910);
      return false;
    }
    boolean bool = djN().contains(paramString);
    AppMethodBeat.o(67910);
    return bool;
  }
  
  private static void amk(String paramString)
  {
    AppMethodBeat.i(67911);
    List localList = djN();
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
    g.afB().afk().set(ae.a.Fnw, paramString.toString());
    AppMethodBeat.o(67911);
  }
  
  private static List<String> djN()
  {
    AppMethodBeat.i(67909);
    Object localObject = (String)g.afB().afk().get(ae.a.Fnw, "");
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
  
  public final boolean al(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67908);
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      ad.e(TAG, "msgxml or toUserName or antiRepeatid is null");
      AppMethodBeat.o(67908);
      return false;
    }
    if (!ami(paramString1))
    {
      AppMethodBeat.o(67908);
      return false;
    }
    bl localbl = new bl();
    localbl.setContent(paramString2);
    localbl.setStatus(2);
    localbl.nY(paramString3);
    localbl.kY(bi.uj(paramString3));
    localbl.jV(1);
    localbl.setType(419430449);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(localbl);
    if (l < 0L)
    {
      ad.e(TAG, f.XJ() + "insert msg failed :" + l);
      amk(paramString1);
      AppMethodBeat.o(67908);
      return false;
    }
    localbl.setMsgId(l);
    boolean bool1;
    if (localbl.cxB())
    {
      b.huc.b(localbl, com.tencent.mm.ai.l.r(localbl));
      paramString3 = new com.tencent.mm.ai.k();
      paramString3.field_xml = localbl.field_content;
      paramString2 = bt.aGg(paramString2);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.ar(paramString2, localbl.field_reserved);
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
      paramString2 = a.cZR().vk(l);
      if ((paramString2 == null) || (paramString2.field_msgId != l)) {
        break label386;
      }
      bool1 = a.cZR().update(paramString3, new String[0]);
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString2 = new com.tencent.mm.plugin.remittance.b.c();
        paramString2.field_locaMsgId = localbl.field_msgId;
        paramString2.field_transferId = paramString1.gIn;
        paramString2.field_receiveStatus = -1;
        paramString2.field_isSend = true;
        com.tencent.mm.plugin.remittance.a.c.djj();
        com.tencent.mm.plugin.remittance.a.c.djl().a(paramString2);
      }
      AppMethodBeat.o(67908);
      return bool1;
      b.huc.q(localbl);
      break;
      label386:
      boolean bool2 = a.cZR().insert(paramString3);
      bool1 = bool2;
      if (!bool2)
      {
        ad.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
        bool1 = bool2;
      }
    }
  }
  
  public final boolean amh(String paramString)
  {
    AppMethodBeat.i(67905);
    synchronized (this.lock)
    {
      boolean bool = amj(paramString);
      AppMethodBeat.o(67905);
      return bool;
    }
  }
  
  public final void in(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67904);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      ad.e(TAG, "saveMsgContent param error");
      AppMethodBeat.o(67904);
      return;
    }
    this.vBU.put(paramString1, paramString2);
    AppMethodBeat.o(67904);
  }
  
  public final boolean io(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67907);
    String str = (String)this.vBU.get(paramString1);
    if (bt.isNullOrNil(str))
    {
      ad.w(TAG, "empty transid: %s", new Object[] { paramString1 });
      AppMethodBeat.o(67907);
      return false;
    }
    boolean bool = al(paramString1, str, paramString2);
    AppMethodBeat.o(67907);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ac
 * JD-Core Version:    0.7.0.1
 */