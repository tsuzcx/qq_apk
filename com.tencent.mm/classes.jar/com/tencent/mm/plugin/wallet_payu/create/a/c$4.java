package com.tencent.mm.plugin.wallet_payu.create.a;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class c$4
  extends g
{
  c$4(c paramc, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48380);
    if (((paramm instanceof a)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.d("MicroMsg.PayUOpenProcess", "hy: create user success");
      com.tencent.mm.wallet_core.a.b(this.hwZ, this.uCp.mEJ, 0);
      c.d(this.uCp).putInt("key_open_error_code", 0);
      t.makeText(this.hwZ, this.hwZ.getString(2131305515), 0).show();
      AppMethodBeat.o(48380);
      return true;
    }
    if (((paramm instanceof b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.d("MicroMsg.PayUOpenProcess", "hy: link user success");
      com.tencent.mm.wallet_core.a.b(this.hwZ, this.uCp.mEJ, 0);
      c.e(this.uCp).putInt("key_open_error_code", 0);
      t.makeText(this.hwZ, this.hwZ.getString(2131305515), 0).show();
      AppMethodBeat.o(48380);
      return true;
    }
    AppMethodBeat.o(48380);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48381);
    Object localObject = (u)paramVarArgs[0];
    paramVarArgs = this.uCp.mEJ.getString("dial_code");
    String str1 = this.uCp.mEJ.getString("key_mobile");
    localObject = ((u)localObject).gww;
    String str2 = this.uCp.mEJ.getString("key_question_id");
    String str3 = this.uCp.mEJ.getString("key_question_answer");
    String str4 = this.uCp.mEJ.getString("payu_reference");
    if (!this.uCp.mEJ.getBoolean("key_is_has_mobile")) {
      this.AXB.a(new a(paramVarArgs, str1, (String)localObject, str2, str3, str4), true);
    }
    for (;;)
    {
      AppMethodBeat.o(48381);
      return true;
      this.AXB.a(new b(paramVarArgs, str1, (String)localObject, str4), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.c.4
 * JD-Core Version:    0.7.0.1
 */