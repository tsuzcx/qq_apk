package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.ya.b;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static boolean aF(bo parambo)
  {
    Object localObject1 = null;
    AppMethodBeat.i(116324);
    if (parambo.getType() == 419430449)
    {
      if (parambo.field_isSend != 0) {
        break label330;
      }
      localObject1 = parambo.field_content;
      if (localObject1 == null) {
        break label344;
      }
    }
    label330:
    label337:
    label344:
    for (parambo = k.b.az((String)localObject1, parambo.field_reserved);; parambo = null)
    {
      int i;
      if (parambo != null)
      {
        localObject1 = new yb();
        ((yb)localObject1).dBC.dlI = parambo.hiO;
        a.GpY.l((b)localObject1);
        j = ((yb)localObject1).dBD.status;
        i = j;
        if (j <= 0) {
          i = parambo.hiL;
        }
        if ((i >= 0) && ((i == 1) || (i == 7)))
        {
          AppMethodBeat.o(116324);
          return true;
          if ((parambo.getType() == 436207665) && (parambo.field_isSend == 0))
          {
            Object localObject2 = parambo.field_content;
            if (localObject2 != null) {
              localObject1 = k.b.vA((String)localObject2);
            }
            if (localObject1 != null) {
              if ((!"1001".equals(((k.b)localObject1).hjn)) && (!w.sQ(parambo.field_talker)))
              {
                parambo = new ya();
                if (!bs.isNullOrNil(((k.b)localObject1).hjo))
                {
                  parambo.dBw.dBy = ((k.b)localObject1).hjo;
                  a.GpY.l(parambo);
                  if (parambo.dBx.dBB == 0)
                  {
                    AppMethodBeat.o(116324);
                    return true;
                  }
                }
              }
              else if (w.sQ(parambo.field_talker))
              {
                parambo = u.axw();
                if (bs.gY(((k.b)localObject1).hjD)) {
                  break label337;
                }
                localObject1 = ((k.b)localObject1).hjD.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = ((String)((Iterator)localObject1).next()).split(",");
                  if ((localObject2.length == 3) && (localObject2[0].equals(parambo))) {
                    i = bs.getInt(localObject2[2], -1);
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
  
  public static String aIl(String paramString)
  {
    AppMethodBeat.i(116323);
    Object localObject = ((k)g.ab(k.class)).dcr().alG(paramString);
    int k;
    int j;
    int i;
    if (localObject != null)
    {
      ac.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      Iterator localIterator = ((List)localObject).iterator();
      k = 0;
      j = 0;
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (bo)localIterator.next();
        if (!aF((bo)localObject)) {
          break label343;
        }
        if (((bo)localObject).getType() == 419430449)
        {
          k += 1;
        }
        else
        {
          if (((bo)localObject).getType() != 436207665) {
            break label343;
          }
          localObject = ((dy)localObject).field_content;
          if (localObject == null) {
            break label346;
          }
        }
      }
    }
    label343:
    label346:
    for (localObject = k.b.vA((String)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        if ("1001".equals(((k.b)localObject).hjn))
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
          if (w.sQ(paramString))
          {
            paramString = ai.getContext().getString(2131765237, new Object[] { Integer.valueOf(j) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((i > 0) && (k <= 0))
          {
            paramString = ai.getContext().getString(2131765239, new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((k > 0) && (i <= 0))
          {
            paramString = ai.getContext().getString(2131765240, new Object[] { Integer.valueOf(k) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((k > 0) && (i > 0))
          {
            paramString = ai.getContext().getString(2131765238, new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
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