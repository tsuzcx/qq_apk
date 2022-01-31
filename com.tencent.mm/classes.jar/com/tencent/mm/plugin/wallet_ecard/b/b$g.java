package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.jj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

final class b$g
  extends g
{
  public b$g(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(48098);
    String str = this.hwZ.getIntent().getStringExtra(a.uyX);
    AppMethodBeat.o(48098);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48102);
    ab.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.uzs.b(this.hwZ, new Bundle());
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(48102);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48101);
    if ((paramm instanceof com.tencent.mm.plugin.wallet_ecard.a.c))
    {
      this.AXB.removeSceneEndListener(1986);
      paramm = (com.tencent.mm.plugin.wallet_ecard.a.c)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramm.uzk.koj != 0) {
          break label155;
        }
        paramString = new Bundle();
        if (paramm.uzk.wvr != null) {
          ab.i("MicroMsg.OpenECardProcess", "succ title: %s", new Object[] { paramm.uzk.wvr.title });
        }
      }
      for (;;)
      {
        try
        {
          b.F(this.uzs).putByteArray(a.uzc, paramm.uzk.wvr.toByteArray());
          this.uzs.a(this.hwZ, 0, paramString);
          AppMethodBeat.o(48101);
          return true;
        }
        catch (IOException paramm)
        {
          ab.printErrStackTrace("MicroMsg.OpenECardProcess", paramm, "", new Object[0]);
          continue;
        }
        label155:
        if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.hwZ, paramm.uzk.wvq))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwZ, new String[] { paramm.uzk.kok, paramString });
          h.b(this.hwZ, paramString, "", false);
        }
      }
    }
    if ((paramm instanceof d))
    {
      this.AXB.removeSceneEndListener(1985);
      paramm = (d)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramm.uzl.koj == 0) {
          this.hwZ.getIntent().putExtra(a.uyW, paramm.uzl.wvp);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(48101);
        return true;
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
    AppMethodBeat.o(48101);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48100);
    b.C(this.uzs).getString("key_pwd1");
    paramVarArgs = b.D(this.uzs).getString("key_verify_code");
    String str1 = b.e(this.uzs);
    int i = b.E(this.uzs).getInt(a.uyJ);
    String str2 = this.hwZ.getIntent().getStringExtra(a.uyW);
    paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.c(b.b(this.uzs), str1, paramVarArgs, str2, i);
    this.AXB.addSceneEndListener(1986);
    this.AXB.a(paramVarArgs, true, 3);
    AppMethodBeat.o(48100);
    return true;
  }
  
  public final boolean y(Object... paramVarArgs)
  {
    AppMethodBeat.i(48099);
    int i = b.u(this.uzs).getInt(a.uyN);
    paramVarArgs = b.e(this.uzs);
    int j = b.v(this.uzs).getInt(a.uzg);
    ab.i("MicroMsg.OpenECardProcess", "bind action: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    String str1;
    String str2;
    String str3;
    if (i == a.uze)
    {
      str1 = b.w(this.uzs).getString(a.uyQ);
      str2 = b.x(this.uzs).getString(a.uyR);
      str3 = b.y(this.uzs).getString(a.uyS);
    }
    for (paramVarArgs = new d(b.b(this.uzs), paramVarArgs, str1, str2, str3, b.n(this.uzs), true, true, j, "");; paramVarArgs = new d(b.b(this.uzs), paramVarArgs, str1, str2, str3, b.n(this.uzs), false, true, j, ""))
    {
      this.AXB.addSceneEndListener(1985);
      this.AXB.a(paramVarArgs, true);
      AppMethodBeat.o(48099);
      return true;
      str1 = b.z(this.uzs).getString(a.uyT);
      str2 = b.A(this.uzs).getString(a.uyU);
      str3 = b.B(this.uzs).getString(a.uyV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.g
 * JD-Core Version:    0.7.0.1
 */