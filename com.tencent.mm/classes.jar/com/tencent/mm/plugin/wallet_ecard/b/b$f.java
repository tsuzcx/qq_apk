package com.tencent.mm.plugin.wallet_ecard.b;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet.balance.model.lqt.aj;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.a;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$f
  extends g
{
  public b$f(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71729);
    if ((paramq instanceof aj))
    {
      Log.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      Object localObject = (aj)paramq;
      Bundle localBundle = new Bundle();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((aj)localObject).OmI;
        if ((paramString.fZQ != null) && ((this.activity instanceof WalletOpenLqbProxyUI)))
        {
          paramq = (WalletOpenLqbProxyUI)this.activity;
          localObject = paramString.fZQ;
          if (paramq.Pjh != null) {
            paramq.Pjh.a((ctd)localObject, null);
          }
        }
        if (paramString.tqa == 0)
        {
          b.P(this.PiH).putBoolean("key_goto_lqt_detail", true);
          localBundle.putInt("key_process_result_code", -1);
        }
      }
      for (;;)
      {
        this.PiH.b(this.activity, localBundle);
        AppMethodBeat.o(71729);
        return true;
        if (paramString.fZQ == null)
        {
          Log.i("MicroMsg.OpenECardProcess", "toast: %s", new Object[] { paramString.tqb });
          Toast.makeText(this.activity, paramString.tqb, 1).show();
          continue;
          Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
          h.c(this.activity, paramString, "", false);
        }
      }
    }
    AppMethodBeat.o(71729);
    return false;
  }
  
  public final boolean r(Object... paramVarArgs)
  {
    AppMethodBeat.i(71728);
    ((Integer)paramVarArgs[0]).intValue();
    paramVarArgs = (String)paramVarArgs[1];
    this.YVX.addSceneEndListener(2996);
    paramVarArgs = new aj(b.b(this.PiH), paramVarArgs);
    this.YVX.b(paramVarArgs, true);
    AppMethodBeat.o(71728);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.f
 * JD-Core Version:    0.7.0.1
 */