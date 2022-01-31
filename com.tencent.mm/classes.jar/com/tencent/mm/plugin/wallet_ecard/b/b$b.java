package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.e;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$b
  extends g
{
  public b$b(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48079);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramIntent = new Bundle();
    paramIntent.putInt("key_process_result_code", 0);
    this.uzs.b(this.hwZ, paramIntent);
    AppMethodBeat.o(48079);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48078);
    if ((paramm instanceof e))
    {
      this.AXB.removeSceneEndListener(1958);
      paramm = (e)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramm.uzp.koj == 0)
        {
          paramString = new Bundle();
          ab.i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", new Object[] { paramm.uzp.wvo, Boolean.valueOf(paramm.uzp.xwO) });
          b.d(this.uzs).putString(a.uyL, paramm.uzp.wvo);
          if (paramm.uzp.xwO) {
            paramString.putBoolean(a.uzb, true);
          }
          this.uzs.a(this.hwZ, 0, paramString);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(48078);
        return true;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.hwZ, paramm.uzp.wvq)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.hwZ, paramm, paramm.cnK, paramm.kNv, paramm.uzp.koj, paramm.uzp.kok)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwZ, new String[] { paramm.uzp.kok, paramm.kNv, paramString });
          h.a(this.hwZ, paramString, "", false, new b.b.1(this));
          continue;
          ab.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwZ, new String[] { paramString });
          h.a(this.hwZ, paramString, "", false, new b.b.2(this));
        }
      }
    }
    AppMethodBeat.o(48078);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48077);
    paramVarArgs = (String)paramVarArgs[0];
    int i = b.a(this.uzs).getInt(a.uyJ);
    this.AXB.addSceneEndListener(1958);
    e locale = new e(b.b(this.uzs), paramVarArgs, i, null);
    this.AXB.a(locale, true);
    b.c(this.uzs).putString("key_pwd1", paramVarArgs);
    AppMethodBeat.o(48077);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.b
 * JD-Core Version:    0.7.0.1
 */