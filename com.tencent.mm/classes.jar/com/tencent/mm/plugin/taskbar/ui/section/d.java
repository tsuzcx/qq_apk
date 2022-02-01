package com.tencent.mm.plugin.taskbar.ui.section;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "", "sectionType", "", "multiTaskTypes", "", "(I[I)V", "getMultiTaskTypes", "()[I", "sectionData", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSectionData", "()Ljava/util/List;", "setSectionData", "(Ljava/util/List;)V", "getSectionType", "()I", "showDataList", "getShowDataList", "updateShowData", "", "Companion", "plugin-taskbar_release"})
public final class d
{
  private static final d MqX;
  public static final d.a MqY;
  public final int MqM;
  public List<MultiTaskInfo> MqU;
  public final List<MultiTaskInfo> MqV;
  public final int[] MqW;
  
  static
  {
    AppMethodBeat.i(214800);
    MqY = new d.a((byte)0);
    MqX = new d(-1, new int[0]);
    AppMethodBeat.o(214800);
  }
  
  public d(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(214799);
    this.MqM = paramInt;
    this.MqW = paramArrayOfInt;
    this.MqU = ((List)new ArrayList());
    this.MqV = ((List)new ArrayList());
    AppMethodBeat.o(214799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.d
 * JD-Core Version:    0.7.0.1
 */