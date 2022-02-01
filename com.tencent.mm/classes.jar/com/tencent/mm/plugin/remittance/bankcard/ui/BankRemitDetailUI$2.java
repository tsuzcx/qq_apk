package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

final class BankRemitDetailUI$2
  implements View.OnClickListener
{
  BankRemitDetailUI$2(BankRemitDetailUI paramBankRemitDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67509);
    ac.i("MicroMsg.BankRemitDetailUI", "click finish btn");
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName(ai.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
    ((Intent)localObject).addFlags(67108864);
    paramView = this.wGh;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitDetailUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitDetailUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(67509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.2
 * JD-Core Version:    0.7.0.1
 */