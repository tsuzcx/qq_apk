package com.tencent.mm.plugin.taskbar.ui.section;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel$Companion;", "", "()V", "DUMMY", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "getDUMMY", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "TAG", "", "blockShowSnapshot", "", "multiTaskType", "", "checkBlockedByTeenMode", "shouldLoadSnapshot", "typeBlockedByExpt", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "plugin-taskbar_release"})
public final class d$a
{
  public static boolean ajc(int paramInt)
  {
    AppMethodBeat.i(215564);
    if (!ajd(paramInt))
    {
      switch (paramInt)
      {
      }
      for (paramInt = 0; paramInt != 0; paramInt = 1)
      {
        AppMethodBeat.o(215564);
        return true;
      }
    }
    AppMethodBeat.o(215564);
    return false;
  }
  
  private static boolean ajd(int paramInt)
  {
    AppMethodBeat.i(215567);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waC, "-1");
    Log.i("MicroMsg.TaskBarSectionViewModel", "block expt: ".concat(String.valueOf(localObject)));
    try
    {
      p.j(localObject, "expt");
      localObject = ((Iterable)n.a((CharSequence)localObject, new String[] { "," })).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramInt == Integer.parseInt((String)((Iterator)localObject).next()))
        {
          AppMethodBeat.o(215567);
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Log.i("MicroMsg.TaskBarSectionViewModel", "failed", new Object[] { localThrowable });
      AppMethodBeat.o(215567);
    }
    return false;
  }
  
  public static boolean aje(int paramInt)
  {
    AppMethodBeat.i(215569);
    a locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (!((com.tencent.mm.plugin.teenmode.a.b)locala).ZM())
    {
      AppMethodBeat.o(215569);
      return false;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(215569);
      return false;
    case 1: 
      locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
      p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
      if (((com.tencent.mm.plugin.teenmode.a.b)locala).gks() == 2)
      {
        AppMethodBeat.o(215569);
        return true;
      }
      AppMethodBeat.o(215569);
      return false;
    case 21: 
    case 22: 
      locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
      p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
      if (((com.tencent.mm.plugin.teenmode.a.b)locala).dYS() == 2)
      {
        AppMethodBeat.o(215569);
        return true;
      }
      AppMethodBeat.o(215569);
      return false;
    }
    locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)locala).gkr() == 2)
    {
      AppMethodBeat.o(215569);
      return true;
    }
    AppMethodBeat.o(215569);
    return false;
  }
  
  public static ArrayList<Integer> gki()
  {
    AppMethodBeat.i(215561);
    localArrayList = new ArrayList();
    String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waB, "-1");
    try
    {
      p.j(str, "expt");
      Iterator localIterator = ((Iterable)n.b((CharSequence)str, new String[] { "," })).iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(Integer.valueOf(Integer.parseInt((String)localIterator.next())));
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      Log.i("MicroMsg.TaskBarSectionViewModel", "failed", new Object[] { localThrowable });
      Log.i("MicroMsg.TaskBarSectionViewModel", "block expt: ".concat(String.valueOf(str)));
      AppMethodBeat.o(215561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.d.a
 * JD-Core Version:    0.7.0.1
 */