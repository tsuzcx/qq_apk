package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class MobileRemitBaseUI
  extends WalletBaseUI
{
  protected a vxK = a.vxL;
  
  protected final void djK()
  {
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName(aj.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitBaseUI", "finishMobileRemitProcess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
    this.vxK = a.vxN;
  }
  
  public void onResume()
  {
    super.onResume();
    this.vxK = a.vxM;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(67680);
      vxL = new a("ACTIVITY_INIT", 0);
      vxM = new a("ACTIVITY_RESUME", 1);
      vxN = new a("ACTIVITY_PAUSE", 2);
      vxO = new a[] { vxL, vxM, vxN };
      AppMethodBeat.o(67680);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI
 * JD-Core Version:    0.7.0.1
 */