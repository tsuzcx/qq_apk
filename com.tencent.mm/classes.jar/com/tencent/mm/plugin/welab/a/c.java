package com.tencent.mm.plugin.welab.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.e.b;
import com.tencent.mm.plugin.welab.ui.WelabMainUI;

public final class c
  implements com.tencent.mm.plugin.welab.a.a.c
{
  public final void ad(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(146243);
    paramIntent.setClass(paramContext, WelabMainUI.class);
    if ((eHy()) || (eHz())) {}
    for (int i = 1;; i = 0)
    {
      paramIntent.putExtra("para_from_with_red_point", i);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/welab/api/LabUIExporter", "startWelabUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/welab/api/LabUIExporter", "startWelabUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(146243);
      return;
    }
  }
  
  public final boolean eHA()
  {
    AppMethodBeat.i(146246);
    if (!eHz())
    {
      AppMethodBeat.o(146246);
      return true;
    }
    AppMethodBeat.o(146246);
    return false;
  }
  
  public final boolean eHy()
  {
    AppMethodBeat.i(146244);
    b.eHK();
    if ((b.eHN()) && (!eHz()))
    {
      AppMethodBeat.o(146244);
      return true;
    }
    AppMethodBeat.o(146244);
    return false;
  }
  
  public final boolean eHz()
  {
    AppMethodBeat.i(146245);
    b.eHK();
    if (!b.eHO())
    {
      b.eHK();
      if (b.eHN())
      {
        AppMethodBeat.o(146245);
        return true;
      }
    }
    AppMethodBeat.o(146245);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a.c
 * JD-Core Version:    0.7.0.1
 */