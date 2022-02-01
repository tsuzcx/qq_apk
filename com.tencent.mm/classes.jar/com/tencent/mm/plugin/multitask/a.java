package com.tencent.mm.plugin.multitask;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/AddTaskInfoTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "TAG", "", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-multitask_release"})
public final class a
  implements b<Bundle, Bundle>
{
  private final String TAG;
  
  public a()
  {
    AppMethodBeat.i(200277);
    this.TAG = "MicroMsg.MultiTask.AddTaskInfoTask";
    Log.i(this.TAG, "create add task info");
    AppMethodBeat.o(200277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.a
 * JD-Core Version:    0.7.0.1
 */