package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public abstract class AutoLoginActivity
  extends MMActivity
{
  private void Zo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      ae.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = ".concat(String.valueOf(paramInt)));
      a(a.Fkj, getIntent());
      return;
    case -1: 
      a(a.Fki, getIntent());
      return;
    case 0: 
      dxS();
      return;
    }
    a(a.Fkk, getIntent());
  }
  
  protected abstract void a(a parama, Intent paramIntent);
  
  protected abstract boolean ab(Intent paramIntent);
  
  protected boolean dxS()
  {
    g.ajP();
    if ((!com.tencent.mm.kernel.a.aiY()) || (com.tencent.mm.kernel.a.aiT()))
    {
      ae.w("MicroMsg.AutoLoginActivity", "not login");
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
      ae.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
      finish();
      return;
    }
    d.fjx();
    ae.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + paramBundle.getAction());
    int i = z.getIntExtra(paramBundle, "wizard_activity_result_code", -2);
    ae.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = ".concat(String.valueOf(i)));
    if (i != -2)
    {
      Zo(i);
      return;
    }
    if (!ab(paramBundle))
    {
      ae.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
      finish();
      return;
    }
    if (dxS())
    {
      finish();
      ae.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
      return;
    }
    a(a.Fki, paramBundle);
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
    int i = z.getIntExtra(paramIntent, "wizard_activity_result_code", 0);
    ae.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = ".concat(String.valueOf(i)));
    Zo(i);
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
      Fki = new a("LOGIN_OK", 0);
      Fkj = new a("LOGIN_FAIL", 1);
      Fkk = new a("LOGIN_CANCEL", 2);
      Fkl = new a[] { Fki, Fkj, Fkk };
      AppMethodBeat.o(155389);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AutoLoginActivity
 * JD-Core Version:    0.7.0.1
 */