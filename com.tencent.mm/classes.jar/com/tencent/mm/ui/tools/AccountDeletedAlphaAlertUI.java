package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.w;
import com.tencent.mm.model.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class AccountDeletedAlphaAlertUI
  extends MMActivity
{
  private static AccountDeletedAlphaAlertUI vXC = null;
  
  public static AccountDeletedAlphaAlertUI cIH()
  {
    return vXC;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vXC = this;
    paramBundle = new w();
    com.tencent.mm.sdk.b.a.udP.m(paramBundle);
    au.hold();
    paramBundle = com.tencent.mm.i.a.eI(getIntent().getStringExtra("errmsg"));
    if (paramBundle != null)
    {
      paramBundle.a(this, new AccountDeletedAlphaAlertUI.1(this), null);
      return;
    }
    h.a(this, getString(R.l.main_err_account_delete), null, false, new AccountDeletedAlphaAlertUI.2(this));
  }
  
  public void onDestroy()
  {
    if (equals(vXC)) {
      vXC = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI
 * JD-Core Version:    0.7.0.1
 */