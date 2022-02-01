package com.tencent.mm.plugin.multitask;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/UpdateTaskInfoTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "TAG", "", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements d<Bundle, Bundle>
{
  private final String TAG;
  
  public m()
  {
    AppMethodBeat.i(303889);
    this.TAG = "MicroMsg.MultiTask.UpdateTaskInfoTask";
    Log.i(this.TAG, "create update task info");
    AppMethodBeat.o(303889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.m
 * JD-Core Version:    0.7.0.1
 */