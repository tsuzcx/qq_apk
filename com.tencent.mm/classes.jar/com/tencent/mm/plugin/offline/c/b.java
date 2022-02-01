package com.tencent.mm.plugin.offline.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet.model.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/offline/util/OnlinePriorBankcardStore;", "Lcom/tencent/mm/plugin/offline/util/WalletOfflinePriorBankcardStore$IPriorBankcardStore;", "()V", "priorBindSerial", "", "priorBankcard", "Lcom/tencent/mm/plugin/wallet_core/model/Bankcard;", "needJudgeDefaultCardState", "", "reload", "", "resetPriorBankcard", "setPriorBindSerial", "bindSerial", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements c.a
{
  private String MCZ = "";
  
  public final void aQJ(String paramString)
  {
    AppMethodBeat.i(269102);
    s.u(paramString, "bindSerial");
    this.MCZ = paramString;
    k.gvj();
    k.gvl().Mxy = paramString;
    p.ifO();
    paramString = p.ifP().bgE(paramString);
    if (paramString != null)
    {
      if (ae.h(paramString))
      {
        p.ifO();
        p.ifP();
        am.bgJ(paramString.field_bindSerial);
        AppMethodBeat.o(269102);
        return;
      }
      Log.w("MicroMsg.OfflinePriorBankcardLogic", "can't set as default card: " + paramString.field_bindSerial + ", " + paramString.field_bankcardType);
    }
    AppMethodBeat.o(269102);
  }
  
  public final Bankcard gwv()
  {
    AppMethodBeat.i(269093);
    p.ifO();
    Bankcard localBankcard = p.ifP().bgE(this.MCZ);
    AppMethodBeat.o(269093);
    return localBankcard;
  }
  
  public final void gww()
  {
    AppMethodBeat.i(269097);
    p.ifO();
    Bankcard localBankcard = p.ifP().bgE(this.MCZ);
    if ((localBankcard != null) && (!ae.h(localBankcard))) {
      reload();
    }
    AppMethodBeat.o(269097);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(269104);
    this.MCZ = ((String)h.baE().ban().get(at.a.acVJ, null));
    k.gvj();
    k.gvl().Mxy = this.MCZ;
    AppMethodBeat.o(269104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.b
 * JD-Core Version:    0.7.0.1
 */