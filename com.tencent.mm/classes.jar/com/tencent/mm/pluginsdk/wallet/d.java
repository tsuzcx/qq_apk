package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.xp;
import com.tencent.mm.g.a.xp.b;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static String aCU(String paramString)
  {
    AppMethodBeat.i(116323);
    Object localObject = ((k)g.ab(k.class)).cOI().agM(paramString);
    int k;
    int j;
    int i;
    if (localObject != null)
    {
      ad.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      Iterator localIterator = ((List)localObject).iterator();
      k = 0;
      j = 0;
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (bl)localIterator.next();
        if (!aD((bl)localObject)) {
          break label343;
        }
        if (((bl)localObject).getType() == 419430449)
        {
          k += 1;
        }
        else
        {
          if (((bl)localObject).getType() != 436207665) {
            break label343;
          }
          localObject = ((du)localObject).field_content;
          if (localObject == null) {
            break label346;
          }
        }
      }
    }
    label343:
    label346:
    for (localObject = k.b.rx((String)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        if ("1001".equals(((k.b)localObject).gIN))
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
          if (w.pF(paramString))
          {
            paramString = aj.getContext().getString(2131765237, new Object[] { Integer.valueOf(j) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((i > 0) && (k <= 0))
          {
            paramString = aj.getContext().getString(2131765239, new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((k > 0) && (i <= 0))
          {
            paramString = aj.getContext().getString(2131765240, new Object[] { Integer.valueOf(k) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((k > 0) && (i > 0))
          {
            paramString = aj.getContext().getString(2131765238, new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
            AppMethodBeat.o(116323);
            return paramString;
          }
        }
        AppMethodBeat.o(116323);
        return null;
      }
    }
  }
  
  public static boolean aD(bl parambl)
  {
    Object localObject1 = null;
    AppMethodBeat.i(116324);
    if (parambl.getType() == 419430449)
    {
      if (parambl.field_isSend != 0) {
        break label330;
      }
      localObject1 = parambl.field_content;
      if (localObject1 == null) {
        break label344;
      }
    }
    label330:
    label337:
    label344:
    for (parambl = k.b.ar((String)localObject1, parambl.field_reserved);; parambl = null)
    {
      int i;
      if (parambl != null)
      {
        localObject1 = new xq();
        ((xq)localObject1).dDQ.dnZ = parambl.gIn;
        a.ESL.l((b)localObject1);
        j = ((xq)localObject1).dDR.status;
        i = j;
        if (j <= 0) {
          i = parambl.gIk;
        }
        if ((i >= 0) && ((i == 1) || (i == 7)))
        {
          AppMethodBeat.o(116324);
          return true;
          if ((parambl.getType() == 436207665) && (parambl.field_isSend == 0))
          {
            Object localObject2 = parambl.field_content;
            if (localObject2 != null) {
              localObject1 = k.b.rx((String)localObject2);
            }
            if (localObject1 != null) {
              if ((!"1001".equals(((k.b)localObject1).gIN)) && (!w.pF(parambl.field_talker)))
              {
                parambl = new xp();
                if (!bt.isNullOrNil(((k.b)localObject1).gIO))
                {
                  parambl.dDK.dDM = ((k.b)localObject1).gIO;
                  a.ESL.l(parambl);
                  if (parambl.dDL.dDP == 0)
                  {
                    AppMethodBeat.o(116324);
                    return true;
                  }
                }
              }
              else if (w.pF(parambl.field_talker))
              {
                parambl = u.aqG();
                if (bt.gL(((k.b)localObject1).gJd)) {
                  break label337;
                }
                localObject1 = ((k.b)localObject1).gJd.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = ((String)((Iterator)localObject1).next()).split(",");
                  if ((localObject2.length == 3) && (localObject2[0].equals(parambl))) {
                    i = bt.getInt(localObject2[2], -1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.d
 * JD-Core Version:    0.7.0.1
 */