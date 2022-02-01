package com.tencent.mm.plugin.taskbar.ui.section;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "", "sectionType", "", "multiTaskTypes", "", "(I[I)V", "getMultiTaskTypes", "()[I", "sectionData", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSectionData", "()Ljava/util/List;", "setSectionData", "(Ljava/util/List;)V", "getSectionType", "()I", "showDataList", "getShowDataList", "checkBlockedByTeenMode", "", "updateShowData", "", "Companion", "plugin-taskbar_release"})
public final class g
{
  private static final g FVK;
  public static final g.a FVL;
  public List<MultiTaskInfo> FVH;
  public final List<MultiTaskInfo> FVI;
  public final int[] FVJ;
  public final int FVr;
  
  static
  {
    AppMethodBeat.i(238524);
    FVL = new g.a((byte)0);
    FVK = new g(-1, new int[0]);
    AppMethodBeat.o(238524);
  }
  
  public g(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(238523);
    this.FVr = paramInt;
    this.FVJ = paramArrayOfInt;
    this.FVH = ((List)new ArrayList());
    this.FVI = ((List)new ArrayList());
    AppMethodBeat.o(238523);
  }
  
  public final void fvk()
  {
    AppMethodBeat.i(238522);
    Log.i("MicroMsg.TaskBarSectionViewModel", "update show data oldCount:" + this.FVI.size() + " new:" + this.FVH.size());
    this.FVI.clear();
    this.FVI.addAll((Collection)this.FVH.subList(0, Math.min(this.FVH.size(), 5)));
    AppMethodBeat.o(238522);
  }
  
  public final void hD(List<MultiTaskInfo> paramList)
  {
    AppMethodBeat.i(238521);
    p.h(paramList, "<set-?>");
    this.FVH = paramList;
    AppMethodBeat.o(238521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.g
 * JD-Core Version:    0.7.0.1
 */