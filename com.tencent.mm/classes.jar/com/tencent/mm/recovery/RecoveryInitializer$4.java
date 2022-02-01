package com.tencent.mm.recovery;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.b;
import com.tencent.mm.bz.c;
import com.tencent.mm.recovery.ui.RecoveryUI;

final class RecoveryInitializer$4
  implements b
{
  public final void a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(194715);
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_crash_count", paramc.Giy);
    localIntent.setClass(paramContext, RecoveryUI.class);
    localIntent.addFlags(276824064);
    paramc = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramc.aeD(), "com/tencent/mm/recovery/RecoveryInitializer$4", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramc.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/recovery/RecoveryInitializer$4", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(194715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recovery.RecoveryInitializer.4
 * JD-Core Version:    0.7.0.1
 */