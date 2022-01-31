package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public abstract class AutoLoginActivity
  extends MMActivity
{
  private void DT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = " + paramInt);
      a(AutoLoginActivity.a.rYY, getIntent());
      return;
    case -1: 
      a(AutoLoginActivity.a.rYX, getIntent());
      return;
    case 0: 
      boC();
      return;
    }
    a(AutoLoginActivity.a.rYZ, getIntent());
  }
  
  public abstract void a(AutoLoginActivity.a parama, Intent paramIntent);
  
  public boolean boC()
  {
    g.DN();
    if ((!com.tencent.mm.kernel.a.Db()) || (com.tencent.mm.kernel.a.CW()))
    {
      y.w("MicroMsg.AutoLoginActivity", "not login");
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
      y.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
      finish();
      return;
    }
    d.coz();
    y.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + paramBundle.getAction());
    int i = t.a(paramBundle, "wizard_activity_result_code", -2);
    y.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = " + i);
    if (i != -2)
    {
      DT(i);
      return;
    }
    if (!w(paramBundle))
    {
      y.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
      finish();
      return;
    }
    if (boC())
    {
      finish();
      y.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
      return;
    }
    a(AutoLoginActivity.a.rYX, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    int i = t.a(paramIntent, "wizard_activity_result_code", 0);
    y.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = " + i);
    DT(i);
  }
  
  public abstract boolean w(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AutoLoginActivity
 * JD-Core Version:    0.7.0.1
 */