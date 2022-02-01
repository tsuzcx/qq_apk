package com.tencent.mm.plugin.taskbar.ui.section;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.teenmode.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel$Companion;", "", "()V", "DUMMY", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "getDUMMY", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "TAG", "", "checkBlockedByTeenMode", "", "sectionType", "", "plugin-taskbar_release"})
public final class g$a
{
  public static boolean abK(int paramInt)
  {
    AppMethodBeat.i(238520);
    a locala = g.af(b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (!((b)locala).Vt())
    {
      AppMethodBeat.o(238520);
      return false;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(238520);
      return false;
    case 1: 
      locala = g.af(b.class);
      p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
      if (((b)locala).fvp() == 2)
      {
        AppMethodBeat.o(238520);
        return true;
      }
      AppMethodBeat.o(238520);
      return false;
    case 2: 
    case 4: 
      locala = g.af(b.class);
      p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
      if (((b)locala).dxW() == 2)
      {
        AppMethodBeat.o(238520);
        return true;
      }
      AppMethodBeat.o(238520);
      return false;
    }
    locala = g.af(b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (((b)locala).fvo() == 2)
    {
      AppMethodBeat.o(238520);
      return true;
    }
    AppMethodBeat.o(238520);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.g.a
 * JD-Core Version:    0.7.0.1
 */