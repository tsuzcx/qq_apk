package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.multitask.c.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/GetMultiInfoListTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-multitask_release"})
final class b
  implements com.tencent.mm.ipcinvoker.b<IPCVoid, MultiTaskListParcel>
{
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/GetMultiInfoListTask$invoke$1", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "onGetMultiTaskInfoList", "", "multiTaskInfoList", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "plugin-multitask_release"})
  public static final class a
    implements a
  {
    a(d paramd) {}
    
    public final void bC(List<? extends MultiTaskInfo> paramList)
    {
      AppMethodBeat.i(200278);
      p.h(paramList, "multiTaskInfoList");
      this.kFf.bn(new MultiTaskListParcel(paramList));
      AppMethodBeat.o(200278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.b
 * JD-Core Version:    0.7.0.1
 */