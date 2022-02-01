package com.tencent.mm.plugin.offline.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ae;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/offline/util/LegacyPriorBankcardStore;", "Lcom/tencent/mm/plugin/offline/util/WalletOfflinePriorBankcardStore$IPriorBankcardStore;", "()V", "priorBankcard", "Lcom/tencent/mm/plugin/wallet_core/model/Bankcard;", "needJudgeDefaultCardState", "", "priorBindSerial", "", "reload", "", "resetPriorBankcard", "setPriorBindSerial", "bindSerial", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c.a
{
  public final void aQJ(String paramString)
  {
    AppMethodBeat.i(269099);
    s.u(paramString, "bindSerial");
    d.aQL(paramString);
    k.gvj();
    k.gvl().Mxy = paramString;
    AppMethodBeat.o(269099);
  }
  
  public final Bankcard gwv()
  {
    AppMethodBeat.i(269091);
    Bankcard localBankcard = ae.HI(false);
    if (localBankcard != null)
    {
      k.gvj();
      k.gvl().Mxy = localBankcard.field_bindSerial;
    }
    AppMethodBeat.o(269091);
    return localBankcard;
  }
  
  public final void gww()
  {
    AppMethodBeat.i(269094);
    Bankcard localBankcard = ae.HI(true);
    if (localBankcard != null)
    {
      d.aQL(localBankcard.field_bindSerial);
      k.gvj();
      k.gvl().Mxy = localBankcard.field_bindSerial;
    }
    AppMethodBeat.o(269094);
  }
  
  public final void reload() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a
 * JD-Core Version:    0.7.0.1
 */