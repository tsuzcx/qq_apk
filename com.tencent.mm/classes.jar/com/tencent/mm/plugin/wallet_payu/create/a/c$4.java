package com.tencent.mm.plugin.wallet_payu.create.a;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class c$4
  extends g
{
  c$4(c paramc, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (((paramm instanceof a)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      y.d("MicroMsg.PayUOpenProcess", "hy: create user success");
      com.tencent.mm.wallet_core.a.b(this.gfb, this.qNi.kke, 0);
      c.d(this.qNi).putInt("key_open_error_code", 0);
      s.makeText(this.gfb, this.gfb.getString(a.i.wallet_payu_start_success), 0).show();
      return true;
    }
    if (((paramm instanceof b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      y.d("MicroMsg.PayUOpenProcess", "hy: link user success");
      com.tencent.mm.wallet_core.a.b(this.gfb, this.qNi.kke, 0);
      c.e(this.qNi).putInt("key_open_error_code", 0);
      s.makeText(this.gfb, this.gfb.getString(a.i.wallet_payu_start_success), 0).show();
      return true;
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    Object localObject = (p)paramVarArgs[0];
    paramVarArgs = this.qNi.kke.getString("dial_code");
    String str1 = this.qNi.kke.getString("key_mobile");
    localObject = ((p)localObject).feN;
    String str2 = this.qNi.kke.getString("key_question_id");
    String str3 = this.qNi.kke.getString("key_question_answer");
    String str4 = this.qNi.kke.getString("payu_reference");
    if (!this.qNi.kke.getBoolean("key_is_has_mobile"))
    {
      this.wBd.a(new a(paramVarArgs, str1, (String)localObject, str2, str3, str4), true);
      return true;
    }
    this.wBd.a(new b(paramVarArgs, str1, (String)localObject, str4), true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.c.4
 * JD-Core Version:    0.7.0.1
 */