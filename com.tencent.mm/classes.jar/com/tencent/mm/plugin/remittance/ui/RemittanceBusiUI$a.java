package com.tencent.mm.plugin.remittance.ui;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.wallet_core.c.l.a;

public abstract class RemittanceBusiUI$a<InputType>
  implements l.a<InputType>
{
  public RemittanceBusiUI$a(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public void djE() {}
  
  public final int djF()
  {
    return 1072;
  }
  
  public void djH() {}
  
  public final void djL()
  {
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName(aj.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
    ((Intent)localObject).addFlags(67108864);
    RemittanceBusiUI localRemittanceBusiUI = this.vFO;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localRemittanceBusiUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localRemittanceBusiUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localRemittanceBusiUI, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.a
 * JD-Core Version:    0.7.0.1
 */