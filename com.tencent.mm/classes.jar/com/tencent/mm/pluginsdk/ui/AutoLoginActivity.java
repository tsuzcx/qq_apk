package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public abstract class AutoLoginActivity
  extends MMActivity
{
  private void aqb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = ".concat(String.valueOf(paramInt)));
      a(a.RbF, getIntent());
      return;
    case -1: 
      a(a.RbE, getIntent());
      return;
    case 0: 
      fje();
      return;
    }
    a(a.RbG, getIntent());
  }
  
  protected abstract boolean Z(Intent paramIntent);
  
  protected abstract void a(a parama, Intent paramIntent);
  
  protected boolean fje()
  {
    h.aHE();
    if ((!b.aGL()) || (b.aGE()))
    {
      Log.w("MicroMsg.AutoLoginActivity", "not login");
      Intent localIntent1 = new Intent(this, getClass());
      localIntent1.putExtras(getIntent());
      localIntent1.addFlags(67108864);
      localIntent1.setDataAndType(getIntent().getData(), getIntent().getType());
      localIntent1.setAction(getIntent().getAction());
      Intent localIntent2 = new Intent();
      localIntent2.putExtras(getIntent());
      c.a(this, "account", "com.tencent.mm.plugin.account.ui.SimpleLoginUI", localIntent2, localIntent1);
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
      Log.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
      finish();
      return;
    }
    c.hok();
    Log.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + paramBundle.getAction());
    int i = IntentUtil.getIntExtra(paramBundle, "wizard_activity_result_code", -2);
    Log.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = ".concat(String.valueOf(i)));
    if (i != -2)
    {
      aqb(i);
      return;
    }
    if (!Z(paramBundle))
    {
      Log.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
      finish();
      return;
    }
    if (fje())
    {
      finish();
      Log.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
      return;
    }
    a(a.RbE, paramBundle);
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
    int i = IntentUtil.getIntExtra(paramIntent, "wizard_activity_result_code", 0);
    Log.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = ".concat(String.valueOf(i)));
    aqb(i);
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
      RbE = new a("LOGIN_OK", 0);
      RbF = new a("LOGIN_FAIL", 1);
      RbG = new a("LOGIN_CANCEL", 2);
      RbH = new a[] { RbE, RbF, RbG };
      AppMethodBeat.o(155389);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AutoLoginActivity
 * JD-Core Version:    0.7.0.1
 */