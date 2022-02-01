package com.tencent.mm.plugin.taskbar.ui.section;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "", "sectionType", "", "multiTaskTypes", "", "(I[I)V", "getMultiTaskTypes", "()[I", "sectionData", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSectionData", "()Ljava/util/List;", "setSectionData", "(Ljava/util/List;)V", "getSectionType", "()I", "showDataList", "getShowDataList", "updateShowData", "", "Companion", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a SUa;
  private static final d SUe;
  public final int STX;
  public final int[] SUb;
  public List<MultiTaskInfo> SUc;
  public final List<MultiTaskInfo> SUd;
  
  static
  {
    AppMethodBeat.i(264274);
    SUa = new a((byte)0);
    SUe = new d(-1, new int[0]);
    AppMethodBeat.o(264274);
  }
  
  public d(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(264263);
    this.STX = paramInt;
    this.SUb = paramArrayOfInt;
    this.SUc = ((List)new ArrayList());
    this.SUd = ((List)new ArrayList());
    AppMethodBeat.o(264263);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel$Companion;", "", "()V", "DUMMY", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "getDUMMY", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "TAG", "", "blockShowSnapshot", "", "multiTaskType", "", "checkBlockedByTeenMode", "shouldLoadSnapshot", "typeBlockedByExpt", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean aoe(int paramInt)
    {
      AppMethodBeat.i(264233);
      if (!aof(paramInt))
      {
        switch (paramInt)
        {
        }
        for (paramInt = 0; paramInt != 0; paramInt = 1)
        {
          AppMethodBeat.o(264233);
          return true;
        }
      }
      AppMethodBeat.o(264233);
      return false;
    }
    
    private static boolean aof(int paramInt)
    {
      AppMethodBeat.i(264246);
      Object localObject1 = ((c)h.ax(c.class)).a(c.a.zud, "-1");
      Log.i("MicroMsg.TaskBarSectionViewModel", s.X("block expt: ", localObject1));
      try
      {
        s.s(localObject1, "expt");
        localObject1 = ((Iterable)n.a((CharSequence)localObject1, new String[] { "," })).iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (paramInt == Integer.parseInt((String)((Iterator)localObject1).next()))
          {
            AppMethodBeat.o(264246);
            return true;
          }
        }
      }
      finally
      {
        Log.i("MicroMsg.TaskBarSectionViewModel", "failed", new Object[] { localObject2 });
        AppMethodBeat.o(264246);
      }
      return false;
    }
    
    public static boolean aog(int paramInt)
    {
      AppMethodBeat.i(264255);
      if (!((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
      {
        AppMethodBeat.o(264255);
        return false;
      }
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(264255);
        return false;
      case 1: 
        if (((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEr() == 2)
        {
          AppMethodBeat.o(264255);
          return true;
        }
        AppMethodBeat.o(264255);
        return false;
      case 21: 
      case 22: 
        if (((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD() == 2)
        {
          AppMethodBeat.o(264255);
          return true;
        }
        AppMethodBeat.o(264255);
        return false;
      }
      if (((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEq() == 2)
      {
        AppMethodBeat.o(264255);
        return true;
      }
      AppMethodBeat.o(264255);
      return false;
    }
    
    public static ArrayList<Integer> hEh()
    {
      AppMethodBeat.i(264224);
      localArrayList = new ArrayList();
      String str = ((c)h.ax(c.class)).a(c.a.zuc, "-1");
      try
      {
        s.s(str, "expt");
        Iterator localIterator = ((Iterable)n.b((CharSequence)str, new String[] { "," })).iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(Integer.valueOf(Integer.parseInt((String)localIterator.next())));
        }
        return localArrayList;
      }
      finally
      {
        Log.i("MicroMsg.TaskBarSectionViewModel", "failed", new Object[] { localObject });
        Log.i("MicroMsg.TaskBarSectionViewModel", s.X("block expt: ", str));
        AppMethodBeat.o(264224);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.d
 * JD-Core Version:    0.7.0.1
 */