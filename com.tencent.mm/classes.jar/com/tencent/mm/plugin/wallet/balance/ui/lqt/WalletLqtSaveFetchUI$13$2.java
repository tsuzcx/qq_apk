package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.math.RoundingMode;

final class WalletLqtSaveFetchUI$13$2
  implements a<Void, bpu>
{
  WalletLqtSaveFetchUI$13$2(WalletLqtSaveFetchUI.13 param13, int paramInt) {}
  
  private Void a(bpu parambpu)
  {
    AppMethodBeat.i(155081);
    ab.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", new Object[] { Integer.valueOf(parambpu.xDH) });
    Intent localIntent = new Intent(this.tSf.tRZ, WalletLqtSaveFetchFinishUI.class);
    localIntent.putExtra("key_amount", e.b(this.tSg, "100", RoundingMode.HALF_UP));
    localIntent.putExtra("key_mode", 1);
    localIntent.putExtra("profile_date_wording", parambpu.xDJ);
    localIntent.putExtra("profile_upgrade_wording", parambpu.xDI);
    if (parambpu.xDK != null) {}
    try
    {
      localIntent.putExtra("key_guide_cell", parambpu.xDK.toByteArray());
      this.tSf.tRZ.startActivity(localIntent);
      this.tSf.tRZ.finish();
      parambpu = AOo;
      AppMethodBeat.o(155081);
      return parambpu;
    }
    catch (IOException parambpu)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", parambpu, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.13.2
 * JD-Core Version:    0.7.0.1
 */