package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$1
  extends g
{
  b$1(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    return false;
  }
  
  public final CharSequence vy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.vy(paramInt);
    case 1: 
      return this.gfb.getString(a.i.wallet_index_ui_bind_card_pref);
    }
    return this.gfb.getString(a.i.wallet_check_pwd_tip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.b.1
 * JD-Core Version:    0.7.0.1
 */