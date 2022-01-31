package com.tencent.mm.plugin.wallet_ecard.b;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.balance.a.a.ad;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.sdk.platformtools.ab;
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48097);
    if ((paramm instanceof ad))
    {
      ab.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ad localad = (ad)paramm;
      Bundle localBundle = new Bundle();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = localad.tNB;
        if (paramString.koj == 0)
        {
          b.P(this.uzs).putBoolean("key_goto_lqt_detail", true);
          localBundle.putInt("key_process_result_code", -1);
        }
      }
      for (;;)
      {
        this.uzs.b(this.hwZ, localBundle);
        AppMethodBeat.o(48097);
        return true;
        ab.i("MicroMsg.OpenECardProcess", "toast: %s", new Object[] { paramString.kok });
        Toast.makeText(this.hwZ, paramString.kok, 1).show();
        continue;
        ab.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
        paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwZ, new String[] { paramString });
        h.b(this.hwZ, paramString, "", false);
      }
    }
    AppMethodBeat.o(48097);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48096);
    ((Integer)paramVarArgs[0]).intValue();
    paramVarArgs = (String)paramVarArgs[1];
    this.AXB.addSceneEndListener(2996);
    paramVarArgs = new ad(b.b(this.uzs), paramVarArgs);
    this.AXB.a(paramVarArgs, true);
    AppMethodBeat.o(48096);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.f
 * JD-Core Version:    0.7.0.1
 */