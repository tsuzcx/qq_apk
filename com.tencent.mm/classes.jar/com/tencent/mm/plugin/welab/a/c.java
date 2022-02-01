package com.tencent.mm.plugin.welab.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.e.b;
import com.tencent.mm.plugin.welab.ui.WelabMainUI;

public final class c
  implements com.tencent.mm.plugin.welab.a.a.c
{
  public final void aL(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(146243);
    paramIntent.setClass(paramContext, WelabMainUI.class);
    if ((iDD()) || (iDE())) {}
    for (int i = 1;; i = 0)
    {
      paramIntent.putExtra("para_from_with_red_point", i);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/welab/api/LabUIExporter", "startWelabUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/welab/api/LabUIExporter", "startWelabUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(146243);
      return;
    }
  }
  
  public final boolean iDD()
  {
    AppMethodBeat.i(146244);
    b.iDO();
    if ((b.iDR()) && (!iDE()))
    {
      AppMethodBeat.o(146244);
      return true;
    }
    AppMethodBeat.o(146244);
    return false;
  }
  
  public final boolean iDE()
  {
    AppMethodBeat.i(146245);
    b.iDO();
    if (!b.iDS())
    {
      b.iDO();
      if (b.iDR())
      {
        AppMethodBeat.o(146245);
        return true;
      }
    }
    AppMethodBeat.o(146245);
    return false;
  }
  
  public final boolean iDF()
  {
    AppMethodBeat.i(146246);
    if (!iDE())
    {
      AppMethodBeat.o(146246);
      return true;
    }
    AppMethodBeat.o(146246);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a.c
 * JD-Core Version:    0.7.0.1
 */