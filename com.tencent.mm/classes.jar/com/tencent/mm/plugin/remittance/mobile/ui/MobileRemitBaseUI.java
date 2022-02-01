package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class MobileRemitBaseUI
  extends WalletBaseUI
{
  protected MobileRemitBaseUI.a wHP = MobileRemitBaseUI.a.wHQ;
  
  protected final void dxM()
  {
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName(ai.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitBaseUI", "finishMobileRemitProcess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitBaseUI", "finishMobileRemitProcess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public boolean needLockPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.wHP = MobileRemitBaseUI.a.wHS;
  }
  
  public void onResume()
  {
    super.onResume();
    this.wHP = MobileRemitBaseUI.a.wHR;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI
 * JD-Core Version:    0.7.0.1
 */