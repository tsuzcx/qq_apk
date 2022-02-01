package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.yu;
import com.tencent.mm.g.a.yu.b;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.a.yv.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static boolean aI(bu parambu)
  {
    Object localObject1 = null;
    AppMethodBeat.i(116324);
    if (parambu.getType() == 419430449)
    {
      if (parambu.field_isSend != 0) {
        break label330;
      }
      localObject1 = parambu.field_content;
      if (localObject1 == null) {
        break label344;
      }
    }
    label330:
    label337:
    label344:
    for (parambu = k.b.aA((String)localObject1, parambu.field_reserved);; parambu = null)
    {
      int i;
      if (parambu != null)
      {
        localObject1 = new yv();
        ((yv)localObject1).dNP.dxv = parambu.hAX;
        a.IbL.l((b)localObject1);
        j = ((yv)localObject1).dNQ.status;
        i = j;
        if (j <= 0) {
          i = parambu.hAU;
        }
        if ((i >= 0) && ((i == 1) || (i == 7)))
        {
          AppMethodBeat.o(116324);
          return true;
          if ((parambu.getType() == 436207665) && (parambu.field_isSend == 0))
          {
            Object localObject2 = parambu.field_content;
            if (localObject2 != null) {
              localObject1 = k.b.yr((String)localObject2);
            }
            if (localObject1 != null) {
              if ((!"1001".equals(((k.b)localObject1).hBw)) && (!w.vF(parambu.field_talker)))
              {
                parambu = new yu();
                if (!bt.isNullOrNil(((k.b)localObject1).hBx))
                {
                  parambu.dNJ.dNL = ((k.b)localObject1).hBx;
                  a.IbL.l(parambu);
                  if (parambu.dNK.dNO == 0)
                  {
                    AppMethodBeat.o(116324);
                    return true;
                  }
                }
              }
              else if (w.vF(parambu.field_talker))
              {
                parambu = u.aAm();
                if (bt.hj(((k.b)localObject1).hBM)) {
                  break label337;
                }
                localObject1 = ((k.b)localObject1).hBM.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = ((String)((Iterator)localObject1).next()).split(",");
                  if ((localObject2.length == 3) && (localObject2[0].equals(parambu))) {
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
  
  public static String aNO(String paramString)
  {
    AppMethodBeat.i(116323);
    Object localObject = ((l)g.ab(l.class)).dlK().aqu(paramString);
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
        localObject = (bu)localIterator.next();
        if (!aI((bu)localObject)) {
          break label343;
        }
        if (((bu)localObject).getType() == 419430449)
        {
          k += 1;
        }
        else
        {
          if (((bu)localObject).getType() != 436207665) {
            break label343;
          }
          localObject = ((ei)localObject).field_content;
          if (localObject == null) {
            break label346;
          }
        }
      }
    }
    label343:
    label346:
    for (localObject = k.b.yr((String)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        if ("1001".equals(((k.b)localObject).hBw))
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
          if (w.vF(paramString))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.d
 * JD-Core Version:    0.7.0.1
 */