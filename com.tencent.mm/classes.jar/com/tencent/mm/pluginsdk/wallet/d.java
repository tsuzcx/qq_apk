package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.aaf;
import com.tencent.mm.g.a.aaf.b;
import com.tencent.mm.g.a.aag;
import com.tencent.mm.g.a.aag.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static boolean aU(ca paramca)
  {
    Object localObject1 = null;
    AppMethodBeat.i(116324);
    if (paramca.getType() == 419430449)
    {
      if (paramca.field_isSend != 0) {
        break label330;
      }
      localObject1 = paramca.field_content;
      if (localObject1 == null) {
        break label344;
      }
    }
    label330:
    label337:
    label344:
    for (paramca = k.b.aD((String)localObject1, paramca.field_reserved);; paramca = null)
    {
      int i;
      if (paramca != null)
      {
        localObject1 = new aag();
        ((aag)localObject1).ehb.dQp = paramca.ixQ;
        EventCenter.instance.publish((IEvent)localObject1);
        j = ((aag)localObject1).ehc.status;
        i = j;
        if (j <= 0) {
          i = paramca.ixN;
        }
        if ((i >= 0) && ((i == 1) || (i == 7)))
        {
          AppMethodBeat.o(116324);
          return true;
          if ((paramca.getType() == 436207665) && (paramca.field_isSend == 0))
          {
            Object localObject2 = paramca.field_content;
            if (localObject2 != null) {
              localObject1 = k.b.HD((String)localObject2);
            }
            if (localObject1 != null) {
              if ((!"1001".equals(((k.b)localObject1).iyq)) && (!ab.Eq(paramca.field_talker)))
              {
                paramca = new aaf();
                if (!Util.isNullOrNil(((k.b)localObject1).iyr))
                {
                  paramca.egV.egX = ((k.b)localObject1).iyr;
                  EventCenter.instance.publish(paramca);
                  if (paramca.egW.eha == 0)
                  {
                    AppMethodBeat.o(116324);
                    return true;
                  }
                }
              }
              else if (ab.Eq(paramca.field_talker))
              {
                paramca = z.aTY();
                if (Util.isNullOrNil(((k.b)localObject1).iyG)) {
                  break label337;
                }
                localObject1 = ((k.b)localObject1).iyG.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = ((String)((Iterator)localObject1).next()).split(",");
                  if ((localObject2.length == 3) && (localObject2[0].equals(paramca))) {
                    i = Util.getInt(localObject2[2], -1);
                  }
                }
              }
            }
          }
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((j != 0) && (i == 1))
        {
          AppMethodBeat.o(116324);
          return true;
        }
        AppMethodBeat.o(116324);
        return false;
        i = 0;
      }
    }
  }
  
  public static String bfO(String paramString)
  {
    AppMethodBeat.i(116323);
    Object localObject = ((l)g.af(l.class)).eiy().aEU(paramString);
    int k;
    int j;
    int i;
    if (localObject != null)
    {
      Log.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      Iterator localIterator = ((List)localObject).iterator();
      k = 0;
      j = 0;
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ca)localIterator.next();
        if (!aU((ca)localObject)) {
          break label343;
        }
        if (((ca)localObject).getType() == 419430449)
        {
          k += 1;
        }
        else
        {
          if (((ca)localObject).getType() != 436207665) {
            break label343;
          }
          localObject = ((eo)localObject).field_content;
          if (localObject == null) {
            break label346;
          }
        }
      }
    }
    label343:
    label346:
    for (localObject = k.b.HD((String)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        if ("1001".equals(((k.b)localObject).iyq))
        {
          j += 1;
          break;
        }
        i += 1;
      }
      for (;;)
      {
        break;
        if ((i > 0) || (j > 0) || (k > 0))
        {
          if (ab.Eq(paramString))
          {
            paramString = MMApplicationContext.getContext().getString(2131767680, new Object[] { Integer.valueOf(j) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((i > 0) && (k <= 0))
          {
            paramString = MMApplicationContext.getContext().getString(2131767682, new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((k > 0) && (i <= 0))
          {
            paramString = MMApplicationContext.getContext().getString(2131767683, new Object[] { Integer.valueOf(k) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((k > 0) && (i > 0))
          {
            paramString = MMApplicationContext.getContext().getString(2131767681, new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
            AppMethodBeat.o(116323);
            return paramString;
          }
        }
        AppMethodBeat.o(116323);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.d
 * JD-Core Version:    0.7.0.1
 */