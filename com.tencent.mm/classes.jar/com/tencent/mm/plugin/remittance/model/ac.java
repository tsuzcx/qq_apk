package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ac
{
  private static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
  public Object lock;
  public HashMap<String, String> wLZ;
  
  public ac()
  {
    AppMethodBeat.i(67903);
    this.wLZ = new HashMap();
    this.lock = new Object();
    AppMethodBeat.o(67903);
  }
  
  private boolean arp(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(67906);
        Object localObject;
        if (!arq(paramString))
        {
          localObject = dxP();
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
            g.agR().agA().set(ah.a.GLl, ((StringBuilder)localObject).toString());
            bool = true;
            AppMethodBeat.o(67906);
            return bool;
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ac.i(TAG, "it is a duplicate msg");
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
  
  private static boolean arq(String paramString)
  {
    AppMethodBeat.i(67910);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67910);
      return false;
    }
    boolean bool = dxP().contains(paramString);
    AppMethodBeat.o(67910);
    return bool;
  }
  
  private static void arr(String paramString)
  {
    AppMethodBeat.i(67911);
    List localList = dxP();
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
    g.agR().agA().set(ah.a.GLl, paramString.toString());
    AppMethodBeat.o(67911);
  }
  
  private static List<String> dxP()
  {
    AppMethodBeat.i(67909);
    Object localObject = (String)g.agR().agA().get(ah.a.GLl, "");
    ArrayList localArrayList = new ArrayList();
    if (!bs.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject.length > 0) {
        localArrayList.addAll(Arrays.asList((Object[])localObject));
      }
    }
    AppMethodBeat.o(67909);
    return localArrayList;
  }
  
  public final boolean am(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67908);
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      com.tencent.mm.sdk.platformtools.ac.e(TAG, "msgxml or toUserName or antiRepeatid is null");
      AppMethodBeat.o(67908);
      return false;
    }
    if (!arp(paramString1))
    {
      AppMethodBeat.o(67908);
      return false;
    }
    bo localbo = new bo();
    localbo.setContent(paramString2);
    localbo.setStatus(2);
    localbo.re(paramString3);
    localbo.oA(bi.yp(paramString3));
    localbo.jT(1);
    localbo.setType(419430449);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(localbo);
    if (l < 0L)
    {
      com.tencent.mm.sdk.platformtools.ac.e(TAG, f.YG() + "insert msg failed :" + l);
      arr(paramString1);
      AppMethodBeat.o(67908);
      return false;
    }
    localbo.setMsgId(l);
    boolean bool1;
    if (localbo.cKN())
    {
      b.hUE.b(localbo, com.tencent.mm.ah.l.r(localbo));
      paramString3 = new com.tencent.mm.ah.k();
      paramString3.field_xml = localbo.field_content;
      paramString2 = bs.aLx(paramString2);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.az(paramString2, localbo.field_reserved);
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
      paramString2 = a.dnz().zN(l);
      if ((paramString2 == null) || (paramString2.field_msgId != l)) {
        break label386;
      }
      bool1 = a.dnz().update(paramString3, new String[0]);
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString2 = new com.tencent.mm.plugin.remittance.b.c();
        paramString2.field_locaMsgId = localbo.field_msgId;
        paramString2.field_transferId = paramString1.hiO;
        paramString2.field_receiveStatus = -1;
        paramString2.field_isSend = true;
        com.tencent.mm.plugin.remittance.a.c.dxj();
        com.tencent.mm.plugin.remittance.a.c.dxl().a(paramString2);
      }
      AppMethodBeat.o(67908);
      return bool1;
      b.hUE.q(localbo);
      break;
      label386:
      boolean bool2 = a.dnz().insert(paramString3);
      bool1 = bool2;
      if (!bool2)
      {
        com.tencent.mm.sdk.platformtools.ac.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
        bool1 = bool2;
      }
    }
  }
  
  public final boolean aro(String paramString)
  {
    AppMethodBeat.i(67905);
    synchronized (this.lock)
    {
      boolean bool = arq(paramString);
      AppMethodBeat.o(67905);
      return bool;
    }
  }
  
  public final void iH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67904);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      com.tencent.mm.sdk.platformtools.ac.e(TAG, "saveMsgContent param error");
      AppMethodBeat.o(67904);
      return;
    }
    this.wLZ.put(paramString1, paramString2);
    AppMethodBeat.o(67904);
  }
  
  public final boolean iI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67907);
    String str = (String)this.wLZ.get(paramString1);
    if (bs.isNullOrNil(str))
    {
      com.tencent.mm.sdk.platformtools.ac.w(TAG, "empty transid: %s", new Object[] { paramString1 });
      AppMethodBeat.o(67907);
      return false;
    }
    boolean bool = am(paramString1, str, paramString2);
    AppMethodBeat.o(67907);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ac
 * JD-Core Version:    0.7.0.1
 */