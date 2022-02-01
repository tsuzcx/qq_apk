package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/HasTaskInfo;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "TAG", "", "invoke", "id", "plugin-multitask_release"})
public final class c
  implements m<IPCString, IPCBoolean>
{
  private final String TAG;
  
  public c()
  {
    AppMethodBeat.i(248985);
    this.TAG = "MicroMsg.MultiTask.GetTaskInfo";
    Log.i(this.TAG, "create has task info");
    AppMethodBeat.o(248985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.c
 * JD-Core Version:    0.7.0.1
 */