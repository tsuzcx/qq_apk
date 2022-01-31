package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;

final class g$1
  extends a
{
  g$1(g paramg, MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami, paramBundle);
  }
  
  public final CharSequence vy(int paramInt)
  {
    if (paramInt == 0) {
      return this.gfb.getString(a.i.wallet_check_pwd_modify_pwd_tip_payu);
    }
    return super.vy(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.g.1
 * JD-Core Version:    0.7.0.1
 */