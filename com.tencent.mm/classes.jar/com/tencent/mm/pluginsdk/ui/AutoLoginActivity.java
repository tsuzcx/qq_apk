package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public abstract class AutoLoginActivity
  extends MMActivity
{
  private void WM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      ac.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = ".concat(String.valueOf(paramInt)));
      a(a.DmL, getIntent());
      return;
    case -1: 
      a(a.DmK, getIntent());
      return;
    case 0: 
      dkq();
      return;
    }
    a(a.DmM, getIntent());
  }
  
  protected abstract boolean Z(Intent paramIntent);
  
  protected abstract void a(a parama, Intent paramIntent);
  
  protected boolean dkq()
  {
    g.agP();
    if ((!com.tencent.mm.kernel.a.afX()) || (com.tencent.mm.kernel.a.afS()))
    {
      ac.w("MicroMsg.AutoLoginActivity", "not login");
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
      ac.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
      finish();
      return;
    }
    d.eQD();
    ac.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + paramBundle.getAction());
    int i = x.getIntExtra(paramBundle, "wizard_activity_result_code", -2);
    ac.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = ".concat(String.valueOf(i)));
    if (i != -2)
    {
      WM(i);
      return;
    }
    if (!Z(paramBundle))
    {
      ac.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
      finish();
      return;
    }
    if (dkq())
    {
      finish();
      ac.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
      return;
    }
    a(a.DmK, paramBundle);
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
    int i = x.getIntExtra(paramIntent, "wizard_activity_result_code", 0);
    ac.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = ".concat(String.valueOf(i)));
    WM(i);
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
      DmK = new a("LOGIN_OK", 0);
      DmL = new a("LOGIN_FAIL", 1);
      DmM = new a("LOGIN_CANCEL", 2);
      DmN = new a[] { DmK, DmL, DmM };
      AppMethodBeat.o(155389);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AutoLoginActivity
 * JD-Core Version:    0.7.0.1
 */