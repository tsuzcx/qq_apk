package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public abstract class AutoLoginActivity
  extends MMActivity
{
  private void YI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      ad.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = ".concat(String.valueOf(paramInt)));
      a(a.ERO, getIntent());
      return;
    case -1: 
      a(a.ERN, getIntent());
      return;
    case 0: 
      duC();
      return;
    }
    a(a.ERP, getIntent());
  }
  
  protected abstract void a(a parama, Intent paramIntent);
  
  protected abstract boolean ab(Intent paramIntent);
  
  protected boolean duC()
  {
    g.ajA();
    if ((!com.tencent.mm.kernel.a.aiJ()) || (com.tencent.mm.kernel.a.aiE()))
    {
      ad.w("MicroMsg.AutoLoginActivity", "not login");
      Intent localIntent1 = new Intent(this, getClass());
      localIntent1.putExtras(getIntent());
      localIntent1.addFlags(67108864);
      localIntent1.setDataAndType(getIntent().getData(), getIntent().getType());
      localIntent1.setAction(getIntent().getAction());
      Intent localIntent2 = new Intent();
      localIntent2.putExtras(getIntent());
      d.a(this, "account", "com.tencent.mm.plugin.account.ui.SimpleLoginUI", localIntent2, localIntent1);
      return true;
    }
    return false;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      ad.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
      finish();
      return;
    }
    d.ffH();
    ad.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + paramBundle.getAction());
    int i = y.getIntExtra(paramBundle, "wizard_activity_result_code", -2);
    ad.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = ".concat(String.valueOf(i)));
    if (i != -2)
    {
      YI(i);
      return;
    }
    if (!ab(paramBundle))
    {
      ad.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
      finish();
      return;
    }
    if (duC())
    {
      finish();
      ad.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
      return;
    }
    a(a.ERN, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    int i = y.getIntExtra(paramIntent, "wizard_activity_result_code", 0);
    ad.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = ".concat(String.valueOf(i)));
    YI(i);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(155389);
      ERN = new a("LOGIN_OK", 0);
      ERO = new a("LOGIN_FAIL", 1);
      ERP = new a("LOGIN_CANCEL", 2);
      ERQ = new a[] { ERN, ERO, ERP };
      AppMethodBeat.o(155389);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AutoLoginActivity
 * JD-Core Version:    0.7.0.1
 */