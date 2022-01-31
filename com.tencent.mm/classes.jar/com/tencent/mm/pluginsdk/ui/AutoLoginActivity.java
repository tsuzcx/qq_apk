package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public abstract class AutoLoginActivity
  extends MMActivity
{
  private void LP(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = ".concat(String.valueOf(paramInt)));
      a(AutoLoginActivity.a.vPO, getIntent());
      return;
    case -1: 
      a(AutoLoginActivity.a.vPN, getIntent());
      return;
    case 0: 
      bXc();
      return;
    }
    a(AutoLoginActivity.a.vPP, getIntent());
  }
  
  protected abstract boolean O(Intent paramIntent);
  
  protected abstract void a(AutoLoginActivity.a parama, Intent paramIntent);
  
  protected boolean bXc()
  {
    g.RJ();
    if ((!com.tencent.mm.kernel.a.QT()) || (com.tencent.mm.kernel.a.QP()))
    {
      ab.w("MicroMsg.AutoLoginActivity", "not login");
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
      ab.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
      finish();
      return;
    }
    d.dpU();
    ab.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + paramBundle.getAction());
    int i = w.a(paramBundle, "wizard_activity_result_code", -2);
    ab.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = ".concat(String.valueOf(i)));
    if (i != -2)
    {
      LP(i);
      return;
    }
    if (!O(paramBundle))
    {
      ab.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
      finish();
      return;
    }
    if (bXc())
    {
      finish();
      ab.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
      return;
    }
    a(AutoLoginActivity.a.vPN, paramBundle);
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
    int i = w.a(paramIntent, "wizard_activity_result_code", 0);
    ab.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = ".concat(String.valueOf(i)));
    LP(i);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AutoLoginActivity
 * JD-Core Version:    0.7.0.1
 */