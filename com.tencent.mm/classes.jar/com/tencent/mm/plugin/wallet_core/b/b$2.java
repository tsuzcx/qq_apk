package com.tencent.mm.plugin.wallet_core.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$2
  extends g
{
  b$2(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46469);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof a))
      {
        paramString = (a)paramm;
        b.a(this.ubp).putString("kreq_token", paramString.getToken());
        if (this.ubp.c(this.hwZ, b.b(this.ubp)))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BindCardProcess", "need update bankcardlist");
          this.AXB.a(new com.tencent.mm.plugin.wallet_core.c.ab(null, 12), false);
        }
        for (;;)
        {
          AppMethodBeat.o(46469);
          return true;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BindCardProcess", "not need update bankcardlist");
          this.ubp.a(this.hwZ, 0, b.c(this.ubp));
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BindCardProcess", "update bankcardlist success!");
        this.ubp.a(this.hwZ, 0, b.d(this.ubp));
        AppMethodBeat.o(46469);
        return true;
      }
    }
    AppMethodBeat.o(46469);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(46470);
    this.ubp.G(new Object[] { "onNext", paramVarArgs });
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BindCardProcess", "onNext, do bind bank card!");
    paramVarArgs = (Authen)paramVarArgs[0];
    paramVarArgs.bsY = this.ubp.cSV();
    this.AXB.a(new a(paramVarArgs), true, 1);
    AppMethodBeat.o(46470);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.b.2
 * JD-Core Version:    0.7.0.1
 */