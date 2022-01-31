package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.remittance.bankcard.model.a;
import com.tencent.mm.plugin.remittance.bankcard.model.b;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.wallet_core.c.p.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

final class BankRemitSelectBankUI$4
  implements p.a
{
  BankRemitSelectBankUI$4(BankRemitSelectBankUI paramBankRemitSelectBankUI, h paramh) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44666);
    paramm = new ArrayList();
    Object localObject2 = this.qiu.qfQ.wZq;
    paramString = this.qiu.qfQ.wZp;
    Object localObject1 = new b();
    Object localObject3;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      ab.i("MicroMsg.BankRemitSelectBankUI", "freq card count: %s", new Object[] { Integer.valueOf(paramString.size()) });
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (hi)((Iterator)localObject2).next();
        d locald = new d();
        locald.zsM = "☆";
        locald.data = localObject3;
        paramm.add(locald);
      }
    }
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      ab.i("MicroMsg.BankRemitSelectBankUI", "card count: %s", new Object[] { Integer.valueOf(paramString.size()) });
      Collections.sort(paramString, (Comparator)localObject1);
      localObject1 = paramString.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (hi)((Iterator)localObject1).next();
        if (!bo.isNullOrNil(((hi)localObject2).nLq))
        {
          if (!bo.isNullOrNil(((hi)localObject2).wub)) {
            ab.i("MicroMsg.BankRemitSelectBankUI", "use sort pingyin: %s", new Object[] { ((hi)localObject2).wub });
          }
          for (paramString = ((hi)localObject2).wub.toUpperCase().charAt(0);; paramString = a.Yc(((hi)localObject2).nLq))
          {
            localObject3 = new d();
            ((d)localObject3).zsM = paramString;
            ((d)localObject3).data = localObject2;
            paramm.add(localObject3);
            break;
          }
        }
      }
    }
    BankRemitSelectBankUI.a(this.qit).dI(paramm);
    AppMethodBeat.o(44666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.4
 * JD-Core Version:    0.7.0.1
 */