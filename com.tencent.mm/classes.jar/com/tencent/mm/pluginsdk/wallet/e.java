package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.tt;
import com.tencent.mm.h.a.tt.b;
import com.tencent.mm.h.a.tu;
import com.tencent.mm.h.a.tu.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.ai.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static String Xe(String paramString)
  {
    Object localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HZ(paramString);
    int k;
    int j;
    int i;
    if (localObject != null)
    {
      y.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      Iterator localIterator = ((List)localObject).iterator();
      k = 0;
      j = 0;
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (bi)localIterator.next();
        if (!af((bi)localObject)) {
          break label309;
        }
        if (((bi)localObject).getType() == 419430449)
        {
          k += 1;
        }
        else
        {
          if (((bi)localObject).getType() != 436207665) {
            break label309;
          }
          localObject = ((cs)localObject).field_content;
          if (localObject == null) {
            break label312;
          }
        }
      }
    }
    label309:
    label312:
    for (localObject = g.a.gp((String)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        if ("1001".equals(((g.a)localObject).dSh))
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
          if (s.fn(paramString)) {
            return ae.getContext().getString(a.h.wallet_delete_note_aa_stub, new Object[] { Integer.valueOf(j) });
          }
          if ((i > 0) && (k <= 0)) {
            return ae.getContext().getString(a.h.wallet_delete_note_luckymoney_stub, new Object[] { Integer.valueOf(i) });
          }
          if ((k > 0) && (i <= 0)) {
            return ae.getContext().getString(a.h.wallet_delete_note_remittance_stub, new Object[] { Integer.valueOf(k) });
          }
          if ((k > 0) && (i > 0)) {
            return ae.getContext().getString(a.h.wallet_delete_note_luckymoney_remittance_stub, new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
          }
        }
        return null;
      }
    }
  }
  
  public static boolean af(bi parambi)
  {
    Object localObject1 = null;
    if (parambi.getType() == 419430449)
    {
      if (parambi.field_isSend != 0) {
        break label310;
      }
      localObject1 = parambi.field_content;
      if (localObject1 == null) {
        break label319;
      }
    }
    label310:
    label312:
    label319:
    for (parambi = g.a.M((String)localObject1, parambi.field_reserved);; parambi = null)
    {
      int i;
      if (parambi != null)
      {
        localObject1 = new tu();
        ((tu)localObject1).cee.bQR = parambi.dRH;
        a.udP.m((b)localObject1);
        j = ((tu)localObject1).cef.status;
        i = j;
        if (j <= 0) {
          i = parambi.dRE;
        }
        if ((i >= 0) && ((i == 1) || (i == 7)))
        {
          return true;
          if ((parambi.getType() == 436207665) && (parambi.field_isSend == 0))
          {
            Object localObject2 = parambi.field_content;
            if (localObject2 != null) {
              localObject1 = g.a.gp((String)localObject2);
            }
            if (localObject1 != null) {
              if ((!"1001".equals(((g.a)localObject1).dSh)) && (!s.fn(parambi.field_talker)))
              {
                parambi = new tt();
                if (!bk.bl(((g.a)localObject1).dSi))
                {
                  parambi.cdZ.ceb = ((g.a)localObject1).dSi;
                  a.udP.m(parambi);
                  if (parambi.cea.ced == 0) {
                    return true;
                  }
                }
              }
              else if (s.fn(parambi.field_talker))
              {
                parambi = q.Gj();
                if (bk.dk(((g.a)localObject1).dSx)) {
                  break label312;
                }
                localObject1 = ((g.a)localObject1).dSx.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = ((String)((Iterator)localObject1).next()).split(",");
                  if ((localObject2.length == 3) && (localObject2[0].equals(parambi))) {
                    i = bk.getInt(localObject2[2], -1);
                  }
                }
              }
            }
          }
        }
      }
      for (int j = 1;; j = 0)
      {
        return (j != 0) && (i == 1);
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.e
 * JD-Core Version:    0.7.0.1
 */