package com.tencent.mm.plugin.multitask.ui.minusscreen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "multiTaskInfoObj", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "getMultiTaskInfoObj", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getItemId", "", "getItemType", "", "ui-multitask_release"})
public final class a
  implements com.tencent.mm.view.recyclerview.a
{
  public final MultiTaskInfo Aen;
  
  public a(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(236502);
    this.Aen = paramMultiTaskInfo;
    AppMethodBeat.o(236502);
  }
  
  public final int cxn()
  {
    return this.Aen.field_type;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(236501);
    long l = this.Aen.field_id.hashCode() + Integer.valueOf(this.Aen.field_type).hashCode();
    AppMethodBeat.o(236501);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.b.a
 * JD-Core Version:    0.7.0.1
 */