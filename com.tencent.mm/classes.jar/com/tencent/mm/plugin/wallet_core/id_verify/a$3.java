package com.tencent.mm.plugin.wallet_core.id_verify;

import android.text.SpannableString;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$3
  extends g
{
  a$3(a parama, MMActivity paramMMActivity, i parami)
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
    Object localObject = null;
    if (paramInt == 0)
    {
      String str = this.gfb.getString(a.i.wallet_real_name_verify_cur_verify_id_tip);
      localObject = this.gfb.getString(a.i.wallet_real_name_verify_change_to_bindcard);
      str = this.gfb.getString(a.i.wallet_real_name_verify_tip, new Object[] { str, localObject });
      h localh = new h(this.gfb);
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(localh, str.length() - ((String)localObject).length(), str.length(), 33);
      localObject = localSpannableString.subSequence(0, localSpannableString.length());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a.3
 * JD-Core Version:    0.7.0.1
 */