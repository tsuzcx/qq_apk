package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/nfc_open/logic/BusCardRechargeNfcProcessor;", "Lcom/tencent/mm/plugin/nfc_open/logic/INfcProcessor;", "()V", "name", "", "getName", "()Ljava/lang/String;", "priority", "", "getPriority", "()I", "process", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  public static final a Mtr;
  private final String name = "BusCardRecharge";
  private final int priority = 2147483647;
  
  static
  {
    AppMethodBeat.i(261782);
    Mtr = new a((byte)0);
    AppMethodBeat.o(261782);
  }
  
  public final boolean aD(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(261791);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    paramIntent = new Intent(paramIntent);
    paramIntent.setClass(paramContext, NfcWebViewUI.class);
    paramIntent.addFlags(536870912);
    try
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/nfc_open/logic/BusCardRechargeNfcProcessor", "process", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/nfc_open/logic/BusCardRechargeNfcProcessor", "process", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      bool = true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.i("MicroMsg.Nfc.BusCardRechargeNfcProcessor", "process, intent to start NfcWebViewUI is unavailable");
        boolean bool = false;
      }
    }
    AppMethodBeat.o(261791);
    return bool;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final int getPriority()
  {
    return this.priority;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/nfc_open/logic/BusCardRechargeNfcProcessor$Companion;", "", "()V", "TAG", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.a
 * JD-Core Version:    0.7.0.1
 */