package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.adj;
import com.tencent.mm.autogen.a.adj.b;
import com.tencent.mm.autogen.a.adk;
import com.tencent.mm.autogen.a.adk.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.j;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ar.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static boolean bD(cc paramcc)
  {
    Object localObject1 = null;
    AppMethodBeat.i(116324);
    if (paramcc.getType() == 419430449)
    {
      if (paramcc.field_isSend != 0) {
        break label366;
      }
      localObject1 = paramcc.field_content;
      if (localObject1 == null) {
        break label380;
      }
    }
    label366:
    label373:
    label380:
    for (localObject1 = k.b.aP((String)localObject1, paramcc.field_reserved);; localObject1 = null)
    {
      int i;
      if (localObject1 != null)
      {
        Object localObject2 = (j)((k.b)localObject1).aK(j.class);
        if ((au.bwE(paramcc.field_talker)) && (!z.bAM().equals(((j)localObject2).nQU)))
        {
          AppMethodBeat.o(116324);
          return false;
        }
        paramcc = new adk();
        paramcc.ihB.hPj = ((k.b)localObject1).nSk;
        paramcc.publish();
        j = paramcc.ihC.status;
        i = j;
        if (j <= 0) {
          i = ((k.b)localObject1).nSh;
        }
        if ((i >= 0) && ((i == 1) || (i == 7)))
        {
          AppMethodBeat.o(116324);
          return true;
          if ((paramcc.getType() == 436207665) && (paramcc.field_isSend == 0))
          {
            localObject2 = paramcc.field_content;
            if (localObject2 != null) {
              localObject1 = k.b.Hf((String)localObject2);
            }
            if (localObject1 != null) {
              if ((!"1001".equals(((k.b)localObject1).nSK)) && (!au.bwE(paramcc.field_talker)))
              {
                paramcc = new adj();
                if (!Util.isNullOrNil(((k.b)localObject1).nSL))
                {
                  paramcc.ihv.ihx = ((k.b)localObject1).nSL;
                  paramcc.publish();
                  if (paramcc.ihw.ihA == 0)
                  {
                    AppMethodBeat.o(116324);
                    return true;
                  }
                }
              }
              else if (au.bwE(paramcc.field_talker))
              {
                paramcc = z.bAM();
                if (Util.isNullOrNil(((k.b)localObject1).nTa)) {
                  break label373;
                }
                localObject1 = ((k.b)localObject1).nTa.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = ((String)((Iterator)localObject1).next()).split(",");
                  if ((localObject2.length == 3) && (localObject2[0].equals(paramcc))) {
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
  
  public static String brY(String paramString)
  {
    AppMethodBeat.i(116323);
    paramString = ((n)h.ax(n.class)).gaZ().aMd(paramString);
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
        paramString = (cc)localIterator.next();
        if (!bD(paramString)) {
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
    for (paramString = k.b.Hf(paramString);; paramString = null)
    {
      if (paramString != null)
      {
        if ("1001".equals(paramString.nSK))
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