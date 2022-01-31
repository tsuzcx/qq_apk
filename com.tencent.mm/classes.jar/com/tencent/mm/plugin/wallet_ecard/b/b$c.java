package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.plugin.wallet_ecard.a.e;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

final class b$c
  extends g
{
  public b$c(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48086);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramIntent = new Bundle();
    paramIntent.putInt("key_process_result_code", 0);
    this.uzs.b(this.hwZ, paramIntent);
    AppMethodBeat.o(48086);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48085);
    if ((paramm instanceof e))
    {
      this.AXB.removeSceneEndListener(1958);
      paramm = (e)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramm.uzp.koj == 0)
        {
          paramString = new Bundle();
          ab.i("MicroMsg.OpenECardProcess", "req_serial: %s", new Object[] { paramm.uzp.wvo });
          b.f(this.uzs).putString(a.uyL, paramm.uzp.wvo);
          ab.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", new Object[] { paramm.token, Boolean.valueOf(paramm.uzp.xwN), Boolean.valueOf(paramm.uzp.xwO) });
          if (!bo.isNullOrNil(paramm.token)) {
            paramString.putBoolean(a.uyM, paramm.uzp.xwN);
          }
          if (paramm.uzp.xwO) {
            paramString.putBoolean(a.uzb, true);
          }
          paramString.putInt("key_ecard_proxy_action", 1);
          this.uzs.a(this.hwZ, 0, paramString);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(48085);
        return true;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.hwZ, paramm.uzp.wvq)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.hwZ, paramm, paramm.cnK, paramm.kNv, paramm.uzp.koj, paramm.uzp.kok)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwZ, new String[] { paramm.uzp.kok, paramm.kNv, paramString });
          h.a(this.hwZ, paramString, "", false, new b.c.1(this));
          continue;
          ab.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwZ, new String[] { paramString });
          h.a(this.hwZ, paramString, "", false, new b.c.2(this));
        }
      }
    }
    if ((paramm instanceof d))
    {
      this.AXB.removeSceneEndListener(1985);
      paramm = (d)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramm.uzl.koj == 0)
        {
          b.g(this.uzs).putInt(a.uyN, a.uze);
          b.h(this.uzs).putString(a.uyQ, paramm.uzm);
          b.i(this.uzs).putString(a.uyR, paramm.uzn);
          b.j(this.uzs).putString(a.uyS, paramm.uzo);
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
          b.k(this.uzs).putByteArray(a.uzc, paramm.uzl.wvr.toByteArray());
          paramString.putInt("key_ecard_proxy_action", 2);
          this.uzs.a(this.hwZ, 0, paramString);
          AppMethodBeat.o(48085);
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
          h.a(this.hwZ, paramString, "", false, new b.c.3(this));
          continue;
          ab.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwZ, new String[] { paramString });
          h.a(this.hwZ, paramString, "", false, new b.c.4(this));
        }
      }
    }
    AppMethodBeat.o(48085);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48084);
    int i;
    if (((Integer)paramVarArgs[0]).intValue() == 1)
    {
      ab.i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
      i = ((Integer)paramVarArgs[1]).intValue();
      paramVarArgs = (String)paramVarArgs[2];
      this.AXB.addSceneEndListener(1958);
      paramVarArgs = new e(b.b(this.uzs), null, i, paramVarArgs);
      this.AXB.a(paramVarArgs, true);
    }
    for (;;)
    {
      AppMethodBeat.o(48084);
      return true;
      ab.i("MicroMsg.OpenECardProcess", "onNext do ecard open");
      i = ((Integer)paramVarArgs[1]).intValue();
      this.AXB.addSceneEndListener(1985);
      paramVarArgs = new d(b.b(this.uzs), b.e(this.uzs), i);
      this.AXB.a(paramVarArgs, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.c
 * JD-Core Version:    0.7.0.1
 */