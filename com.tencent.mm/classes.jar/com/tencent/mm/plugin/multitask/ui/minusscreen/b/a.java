package com.tencent.mm.plugin.multitask.ui.minusscreen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "multiTaskInfoObj", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "getMultiTaskInfoObj", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getItemId", "", "getItemType", "", "ui-multitask_release"})
public final class a
  implements com.tencent.mm.view.recyclerview.a
{
  public final MultiTaskInfo FKP;
  
  public a(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(197531);
    this.FKP = paramMultiTaskInfo;
    AppMethodBeat.o(197531);
  }
  
  public final int bAQ()
  {
    return this.FKP.field_type;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(197529);
    long l = this.FKP.field_id.hashCode() + Integer.valueOf(this.FKP.field_type).hashCode();
    AppMethodBeat.o(197529);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.b.a
 * JD-Core Version:    0.7.0.1
 */