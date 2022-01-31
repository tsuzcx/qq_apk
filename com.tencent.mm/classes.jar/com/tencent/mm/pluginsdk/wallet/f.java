package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.g.a.vp.b;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.List;

public final class f
{
  public static boolean am(bi parambi)
  {
    Object localObject1 = null;
    AppMethodBeat.i(70470);
    if (parambi.getType() == 419430449)
    {
      if (parambi.field_isSend != 0) {
        break label330;
      }
      localObject1 = parambi.field_content;
      if (localObject1 == null) {
        break label344;
      }
    }
    label330:
    label337:
    label344:
    for (parambi = j.b.ab((String)localObject1, parambi.field_reserved);; parambi = null)
    {
      int i;
      if (parambi != null)
      {
        localObject1 = new vq();
        ((vq)localObject1).cMS.cyr = parambi.fhG;
        a.ymk.l((b)localObject1);
        j = ((vq)localObject1).cMT.status;
        i = j;
        if (j <= 0) {
          i = parambi.fhD;
        }
        if ((i >= 0) && ((i == 1) || (i == 7)))
        {
          AppMethodBeat.o(70470);
          return true;
          if ((parambi.getType() == 436207665) && (parambi.field_isSend == 0))
          {
            Object localObject2 = parambi.field_content;
            if (localObject2 != null) {
              localObject1 = j.b.mY((String)localObject2);
            }
            if (localObject1 != null) {
              if ((!"1001".equals(((j.b)localObject1).fig)) && (!t.lA(parambi.field_talker)))
              {
                parambi = new vp();
                if (!bo.isNullOrNil(((j.b)localObject1).fih))
                {
                  parambi.cMM.cMO = ((j.b)localObject1).fih;
                  a.ymk.l(parambi);
                  if (parambi.cMN.cMR == 0)
                  {
                    AppMethodBeat.o(70470);
                    return true;
                  }
                }
              }
              else if (t.lA(parambi.field_talker))
              {
                parambi = r.Zn();
                if (bo.es(((j.b)localObject1).fiw)) {
                  break label337;
                }
                localObject1 = ((j.b)localObject1).fiw.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = ((String)((Iterator)localObject1).next()).split(",");
                  if ((localObject2.length == 3) && (localObject2[0].equals(parambi))) {
                    i = bo.getInt(localObject2[2], -1);
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
          AppMethodBeat.o(70470);
          return true;
        }
        AppMethodBeat.o(70470);
        return false;
        i = 0;
      }
    }
  }
  
  public static String amZ(String paramString)
  {
    AppMethodBeat.i(70469);
    Object localObject = ((j)g.E(j.class)).bPQ().TI(paramString);
    int k;
    int j;
    int i;
    if (localObject != null)
    {
      ab.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      Iterator localIterator = ((List)localObject).iterator();
      k = 0;
      j = 0;
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (bi)localIterator.next();
        if (!am((bi)localObject)) {
          break label343;
        }
        if (((bi)localObject).getType() == 419430449)
        {
          k += 1;
        }
        else
        {
          if (((bi)localObject).getType() != 436207665) {
            break label343;
          }
          localObject = ((dd)localObject).field_content;
          if (localObject == null) {
            break label346;
          }
        }
      }
    }
    label343:
    label346:
    for (localObject = j.b.mY((String)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        if ("1001".equals(((j.b)localObject).fig))
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
          if (t.lA(paramString))
          {
            paramString = ah.getContext().getString(2131305045, new Object[] { Integer.valueOf(j) });
            AppMethodBeat.o(70469);
            return paramString;
          }
          if ((i > 0) && (k <= 0))
          {
            paramString = ah.getContext().getString(2131305047, new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(70469);
            return paramString;
          }
          if ((k > 0) && (i <= 0))
          {
            paramString = ah.getContext().getString(2131305048, new Object[] { Integer.valueOf(k) });
            AppMethodBeat.o(70469);
            return paramString;
          }
          if ((k > 0) && (i > 0))
          {
            paramString = ah.getContext().getString(2131305046, new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
            AppMethodBeat.o(70469);
            return paramString;
          }
        }
        AppMethodBeat.o(70469);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.f
 * JD-Core Version:    0.7.0.1
 */