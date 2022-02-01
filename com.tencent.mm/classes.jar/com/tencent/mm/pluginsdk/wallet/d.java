package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.za;
import com.tencent.mm.g.a.za.b;
import com.tencent.mm.g.a.zb;
import com.tencent.mm.g.a.zb.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static boolean aH(bv parambv)
  {
    Object localObject1 = null;
    AppMethodBeat.i(116324);
    if (parambv.getType() == 419430449)
    {
      if (parambv.field_isSend != 0) {
        break label330;
      }
      localObject1 = parambv.field_content;
      if (localObject1 == null) {
        break label344;
      }
    }
    label330:
    label337:
    label344:
    for (parambv = k.b.aB((String)localObject1, parambv.field_reserved);; parambv = null)
    {
      int i;
      if (parambv != null)
      {
        localObject1 = new zb();
        ((zb)localObject1).dPf.dyA = parambv.hDL;
        a.IvT.l((b)localObject1);
        j = ((zb)localObject1).dPg.status;
        i = j;
        if (j <= 0) {
          i = parambv.hDI;
        }
        if ((i >= 0) && ((i == 1) || (i == 7)))
        {
          AppMethodBeat.o(116324);
          return true;
          if ((parambv.getType() == 436207665) && (parambv.field_isSend == 0))
          {
            Object localObject2 = parambv.field_content;
            if (localObject2 != null) {
              localObject1 = k.b.zb((String)localObject2);
            }
            if (localObject1 != null) {
              if ((!"1001".equals(((k.b)localObject1).hEk)) && (!x.wb(parambv.field_talker)))
              {
                parambv = new za();
                if (!bu.isNullOrNil(((k.b)localObject1).hEl))
                {
                  parambv.dOZ.dPb = ((k.b)localObject1).hEl;
                  a.IvT.l(parambv);
                  if (parambv.dPa.dPe == 0)
                  {
                    AppMethodBeat.o(116324);
                    return true;
                  }
                }
              }
              else if (x.wb(parambv.field_talker))
              {
                parambv = v.aAC();
                if (bu.ht(((k.b)localObject1).hEA)) {
                  break label337;
                }
                localObject1 = ((k.b)localObject1).hEA.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = ((String)((Iterator)localObject1).next()).split(",");
                  if ((localObject2.length == 3) && (localObject2[0].equals(parambv))) {
                    i = bu.getInt(localObject2[2], -1);
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
  
  public static String aPl(String paramString)
  {
    AppMethodBeat.i(116323);
    Object localObject = ((l)g.ab(l.class)).doJ().arz(paramString);
    int k;
    int j;
    int i;
    if (localObject != null)
    {
      ae.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      Iterator localIterator = ((List)localObject).iterator();
      k = 0;
      j = 0;
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (bv)localIterator.next();
        if (!aH((bv)localObject)) {
          break label343;
        }
        if (((bv)localObject).getType() == 419430449)
        {
          k += 1;
        }
        else
        {
          if (((bv)localObject).getType() != 436207665) {
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
    for (localObject = k.b.zb((String)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        if ("1001".equals(((k.b)localObject).hEk))
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
          if (x.wb(paramString))
          {
            paramString = ak.getContext().getString(2131765237, new Object[] { Integer.valueOf(j) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((i > 0) && (k <= 0))
          {
            paramString = ak.getContext().getString(2131765239, new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((k > 0) && (i <= 0))
          {
            paramString = ak.getContext().getString(2131765240, new Object[] { Integer.valueOf(k) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((k > 0) && (i > 0))
          {
            paramString = ak.getContext().getString(2131765238, new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
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