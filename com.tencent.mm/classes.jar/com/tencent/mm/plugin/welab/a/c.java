package com.tencent.mm.plugin.welab.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.e.b;
import com.tencent.mm.plugin.welab.ui.WelabMainUI;

public final class c
  implements com.tencent.mm.plugin.welab.a.a.c
{
  public final void af(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(146243);
    paramIntent.setClass(paramContext, WelabMainUI.class);
    if ((fad()) || (fae())) {}
    for (int i = 1;; i = 0)
    {
      paramIntent.putExtra("para_from_with_red_point", i);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahE(), "com/tencent/mm/plugin/welab/api/LabUIExporter", "startWelabUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/welab/api/LabUIExporter", "startWelabUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(146243);
      return;
    }
  }
  
  public final boolean fad()
  {
    AppMethodBeat.i(146244);
    b.fap();
    if ((b.fas()) && (!fae()))
    {
      AppMethodBeat.o(146244);
      return true;
    }
    AppMethodBeat.o(146244);
    return false;
  }
  
  public final boolean fae()
  {
    AppMethodBeat.i(146245);
    b.fap();
    if (!b.fat())
    {
      b.fap();
      if (b.fas())
      {
        AppMethodBeat.o(146245);
        return true;
      }
    }
    AppMethodBeat.o(146245);
    return false;
  }
  
  public final boolean faf()
  {
    AppMethodBeat.i(146246);
    if (!fae())
    {
      AppMethodBeat.o(146246);
      return true;
    }
    AppMethodBeat.o(146246);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a.c
 * JD-Core Version:    0.7.0.1
 */