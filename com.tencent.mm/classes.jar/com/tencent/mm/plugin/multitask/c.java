package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/HasTaskInfo;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "TAG", "", "invoke", "id", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements m<IPCString, IPCBoolean>
{
  private final String TAG;
  
  public c()
  {
    AppMethodBeat.i(303701);
    this.TAG = "MicroMsg.MultiTask.GetTaskInfo";
    Log.i(this.TAG, "create has task info");
    AppMethodBeat.o(303701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.c
 * JD-Core Version:    0.7.0.1
 */