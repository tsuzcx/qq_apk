package com.tencent.mm.sns_compose.plugin;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sns_compose.SnsWithTaUI;
import com.tencent.mm.sns_compose.a.b;
import com.tencent.mm.sns_compose.a.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/plugin/PluginSnsWithTa;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/sns_compose/api/IPluginSnsWithTa;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "startWithTaUI", "context", "Landroid/content/Context;", "platformOp", "Lcom/tencent/mm/sns_compose/api/IWithTaComposeOp;", "hasRedDot", "", "source", "", "sns-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginSnsWithTa
  extends f
  implements b
{
  public final void execute(g paramg) {}
  
  public final void installed()
  {
    AppMethodBeat.i(235395);
    super.installed();
    alias(b.class);
    AppMethodBeat.o(235395);
  }
  
  public final void startWithTaUI(Context paramContext, c paramc, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(235409);
    s.u(paramContext, "context");
    s.u(paramc, "platformOp");
    com.tencent.mm.sns_compose.a locala = com.tencent.mm.sns_compose.a.acyR;
    com.tencent.mm.sns_compose.a.a(paramc);
    paramc = new Intent(paramContext, SnsWithTaUI.class);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramc.putExtra("has_dot", i);
      paramc.putExtra("CONTACT_INFO_UI_SOURCE", paramInt);
      paramc = new com.tencent.mm.hellhoundlib.b.a().cG(paramc);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramc.aYi(), "com/tencent/mm/sns_compose/plugin/PluginSnsWithTa", "startWithTaUI", "(Landroid/content/Context;Lcom/tencent/mm/sns_compose/api/IWithTaComposeOp;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramc.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/sns_compose/plugin/PluginSnsWithTa", "startWithTaUI", "(Landroid/content/Context;Lcom/tencent/mm/sns_compose/api/IWithTaComposeOp;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(235409);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sns_compose.plugin.PluginSnsWithTa
 * JD-Core Version:    0.7.0.1
 */