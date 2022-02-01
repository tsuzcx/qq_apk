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
  protected a xVw = a.xVx;
  
  protected final void dJe()
  {
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName(aj.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitBaseUI", "finishMobileRemitProcess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
    this.xVw = a.xVz;
  }
  
  public void onResume()
  {
    super.onResume();
    this.xVw = a.xVy;
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
      xVx = new a("ACTIVITY_INIT", 0);
      xVy = new a("ACTIVITY_RESUME", 1);
      xVz = new a("ACTIVITY_PAUSE", 2);
      xVA = new a[] { xVx, xVy, xVz };
      AppMethodBeat.o(67680);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI
 * JD-Core Version:    0.7.0.1
 */