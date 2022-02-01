package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.multitask.c.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/GetMultiInfoListTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b
  implements d<IPCVoid, MultiTaskListParcel>
{
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/GetMultiInfoListTask$invoke$1", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "onGetMultiTaskInfoList", "", "multiTaskInfoList", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements a
  {
    a(f<MultiTaskListParcel> paramf) {}
    
    public final void dl(List<? extends MultiTaskInfo> paramList)
    {
      AppMethodBeat.i(303726);
      s.u(paramList, "multiTaskInfoList");
      this.mht.onCallback(new MultiTaskListParcel(paramList));
      AppMethodBeat.o(303726);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.b
 * JD-Core Version:    0.7.0.1
 */