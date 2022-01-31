package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class f$1
  extends g
{
  f$1(f paramf, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48645);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.wxcredit.a.f)))
    {
      this.vHv.a(this.hwZ, 0, f.a(this.vHv));
      AppMethodBeat.o(48645);
      return true;
    }
    AppMethodBeat.o(48645);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48646);
    if (!f.b(this.vHv).getBoolean("key_is_show_detail", true))
    {
      paramVarArgs = (Bankcard)f.c(this.vHv).getParcelable("key_bankcard");
      this.AXB.a(new com.tencent.mm.plugin.wxcredit.a.f(paramVarArgs.field_bankcardType, paramVarArgs.field_bindSerial, f.d(this.vHv).getString("key_pwd1")), true, 1);
      AppMethodBeat.o(48646);
      return true;
    }
    AppMethodBeat.o(48646);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.f.1
 * JD-Core Version:    0.7.0.1
 */