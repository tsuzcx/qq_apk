package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.abm;
import com.tencent.mm.f.a.abm.b;
import com.tencent.mm.f.a.abn;
import com.tencent.mm.f.a.abn.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aq.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static boolean bn(ca paramca)
  {
    Object localObject1 = null;
    AppMethodBeat.i(116324);
    if (paramca.getType() == 419430449)
    {
      if (paramca.field_isSend != 0) {
        break label372;
      }
      localObject1 = paramca.field_content;
      if (localObject1 == null) {
        break label386;
      }
    }
    label386:
    for (localObject1 = k.b.aG((String)localObject1, paramca.field_reserved);; localObject1 = null)
    {
      int i;
      if (localObject1 != null)
      {
        Object localObject2 = (j)((k.b)localObject1).ar(j.class);
        if ((ab.Lj(paramca.field_talker)) && (!z.bcZ().equals(((j)localObject2).llO)))
        {
          AppMethodBeat.o(116324);
          return false;
        }
        paramca = new abn();
        paramca.gbr.fJG = ((k.b)localObject1).lnf;
        EventCenter.instance.publish(paramca);
        j = paramca.gbs.status;
        i = j;
        if (j <= 0) {
          i = ((k.b)localObject1).lnc;
        }
        if ((i >= 0) && ((i == 1) || (i == 7)))
        {
          AppMethodBeat.o(116324);
          return true;
          if ((paramca.getType() == 436207665) && (paramca.field_isSend == 0))
          {
            localObject2 = paramca.field_content;
            if (localObject2 != null) {
              localObject1 = k.b.OQ((String)localObject2);
            }
            if (localObject1 != null) {
              if ((!"1001".equals(((k.b)localObject1).lnG)) && (!ab.Lj(paramca.field_talker)))
              {
                paramca = new abm();
                if (!Util.isNullOrNil(((k.b)localObject1).lnH))
                {
                  paramca.gbl.gbn = ((k.b)localObject1).lnH;
                  EventCenter.instance.publish(paramca);
                  if (paramca.gbm.gbq == 0)
                  {
                    AppMethodBeat.o(116324);
                    return true;
                  }
                }
              }
              else if (ab.Lj(paramca.field_talker))
              {
                paramca = z.bcZ();
                if (Util.isNullOrNil(((k.b)localObject1).lnW)) {
                  break label379;
                }
                localObject1 = ((k.b)localObject1).lnW.iterator();
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
        label372:
        AppMethodBeat.o(116324);
        return false;
        label379:
        i = 0;
      }
    }
  }
  
  public static String bsh(String paramString)
  {
    AppMethodBeat.i(116323);
    paramString = ((n)h.ae(n.class)).eSe().aPe(paramString);
    int k;
    int j;
    int i;
    if (paramString != null)
    {
      Log.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", new Object[] { Integer.valueOf(paramString.size()) });
      Iterator localIterator = paramString.iterator();
      k = 0;
      j = 0;
      i = 0;
      while (localIterator.hasNext())
      {
        paramString = (ca)localIterator.next();
        if (!bn(paramString)) {
          break label329;
        }
        if (paramString.getType() == 419430449)
        {
          k += 1;
        }
        else
        {
          if (paramString.getType() != 436207665) {
            break label329;
          }
          paramString = paramString.field_content;
          if (paramString == null) {
            break label332;
          }
        }
      }
    }
    label329:
    label332:
    for (paramString = k.b.OQ(paramString);; paramString = null)
    {
      if (paramString != null)
      {
        if ("1001".equals(paramString.lnG))
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
          if (j > 0)
          {
            paramString = MMApplicationContext.getContext().getString(a.h.wallet_delete_note_aa_stub, new Object[] { Integer.valueOf(j) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((i > 0) && (k <= 0))
          {
            paramString = MMApplicationContext.getContext().getString(a.h.wallet_delete_note_luckymoney_stub, new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((k > 0) && (i <= 0))
          {
            paramString = MMApplicationContext.getContext().getString(a.h.wallet_delete_note_remittance_stub, new Object[] { Integer.valueOf(k) });
            AppMethodBeat.o(116323);
            return paramString;
          }
          if ((k > 0) && (i > 0))
          {
            paramString = MMApplicationContext.getContext().getString(a.h.wallet_delete_note_luckymoney_remittance_stub, new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.d
 * JD-Core Version:    0.7.0.1
 */