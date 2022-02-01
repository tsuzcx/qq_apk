package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.multitask.c.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/GetMultiInfoListTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-multitask_release"})
final class b
  implements d<IPCVoid, MultiTaskListParcel>
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/GetMultiInfoListTask$invoke$1", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "onGetMultiTaskInfoList", "", "multiTaskInfoList", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "plugin-multitask_release"})
  public static final class a
    implements a
  {
    a(f paramf) {}
    
    public final void bA(List<? extends MultiTaskInfo> paramList)
    {
      AppMethodBeat.i(247577);
      p.k(paramList, "multiTaskInfoList");
      this.nyL.aH(new MultiTaskListParcel(paramList));
      AppMethodBeat.o(247577);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.b
 * JD-Core Version:    0.7.0.1
 */