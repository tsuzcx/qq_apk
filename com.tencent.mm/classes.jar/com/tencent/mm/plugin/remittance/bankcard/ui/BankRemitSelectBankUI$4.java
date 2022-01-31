package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.remittance.bankcard.model.a;
import com.tencent.mm.plugin.remittance.bankcard.model.b;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.protocal.c.fx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.wallet_core.c.n.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

final class BankRemitSelectBankUI$4
  implements n.a
{
  BankRemitSelectBankUI$4(BankRemitSelectBankUI paramBankRemitSelectBankUI, h paramh) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramm = new ArrayList();
    Object localObject2 = this.nxt.nuX.taZ;
    paramString = this.nxt.nuX.taY;
    Object localObject1 = new b();
    Object localObject3;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      y.i("MicroMsg.BankRemitSelectBankUI", "freq card count: %s", new Object[] { Integer.valueOf(paramString.size()) });
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (fx)((Iterator)localObject2).next();
        d locald = new d();
        locald.vem = "☆";
        locald.data = localObject3;
        paramm.add(locald);
      }
    }
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      y.i("MicroMsg.BankRemitSelectBankUI", "card count: %s", new Object[] { Integer.valueOf(paramString.size()) });
      Collections.sort(paramString, (Comparator)localObject1);
      localObject1 = paramString.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (fx)((Iterator)localObject1).next();
        if (!bk.bl(((fx)localObject2).lnT))
        {
          if (!bk.bl(((fx)localObject2).szY)) {
            y.i("MicroMsg.BankRemitSelectBankUI", "use sort pingyin: %s", new Object[] { ((fx)localObject2).szY });
          }
          for (paramString = ((fx)localObject2).szY.toUpperCase().charAt(0);; paramString = a.LK(((fx)localObject2).lnT))
          {
            localObject3 = new d();
            ((d)localObject3).vem = paramString;
            ((d)localObject3).data = localObject2;
            paramm.add(localObject3);
            break;
          }
        }
      }
    }
    BankRemitSelectBankUI.a(this.nxs).dM(paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.4
 * JD-Core Version:    0.7.0.1
 */