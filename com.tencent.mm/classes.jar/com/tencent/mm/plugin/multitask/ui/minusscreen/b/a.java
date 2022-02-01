package com.tencent.mm.plugin.multitask.ui.minusscreen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "multiTaskInfoObj", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "getMultiTaskInfoObj", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getItemId", "", "getItemType", "", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.view.recyclerview.a
{
  public final MultiTaskInfo LGa;
  
  public a(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(304334);
    this.LGa = paramMultiTaskInfo;
    AppMethodBeat.o(304334);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(304339);
    long l = this.LGa.field_id.hashCode() + this.LGa.field_type;
    AppMethodBeat.o(304339);
    return l;
  }
  
  public final int bZB()
  {
    return this.LGa.field_type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.b.a
 * JD-Core Version:    0.7.0.1
 */