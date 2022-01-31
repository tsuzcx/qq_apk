package com.tencent.mm.plugin.wallet_ecard.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

final class b$e
  extends g
{
  public b$e(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48095);
    if ((paramm instanceof d))
    {
      this.AXB.removeSceneEndListener(1985);
      paramm = (d)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramm.uzl.koj == 0)
        {
          paramString = new Bundle();
          if (paramm.uzl.wvr != null)
          {
            ab.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(a.uyY, false);
          }
        }
      }
      for (;;)
      {
        try
        {
          b.O(this.uzs).putByteArray(a.uzc, paramm.uzl.wvr.toByteArray());
          this.uzs.a(this.hwZ, 0, paramString);
          AppMethodBeat.o(48095);
          return true;
        }
        catch (IOException paramm)
        {
          ab.printErrStackTrace("MicroMsg.OpenECardProcess", paramm, "", new Object[0]);
          continue;
        }
        ab.i("MicroMsg.OpenECardProcess", "need verfiy sms");
        paramString.putBoolean(a.uyY, true);
        paramString.putString(a.uyW, paramm.uzl.wvp);
        paramString.putString(a.uyX, paramm.uzl.xwT);
        continue;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.hwZ, paramm.uzl.wvq)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.hwZ, paramm, paramm.cnK, paramm.kNv, paramm.uzl.koj, paramm.uzl.kok)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwZ, new String[] { paramm.uzl.kok, paramm.kNv, paramString });
          h.b(this.hwZ, paramString, "", false);
          continue;
          ab.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwZ, new String[] { paramString });
          h.b(this.hwZ, paramString, "", false);
        }
      }
    }
    AppMethodBeat.o(48095);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48094);
    paramVarArgs = ((ElementQuery)paramVarArgs[0]).poq;
    String str1 = b.M(this.uzs).getString(a.uyT);
    String str2 = b.N(this.uzs).getString(a.uyU);
    this.AXB.addSceneEndListener(1985);
    paramVarArgs = new d(b.b(this.uzs), b.e(this.uzs), str1, str2, paramVarArgs, b.n(this.uzs), false, 0, "");
    this.AXB.a(paramVarArgs, true);
    AppMethodBeat.o(48094);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.e
 * JD-Core Version:    0.7.0.1
 */