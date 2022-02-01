package com.tencent.mm.plugin.multitask;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/UpdateTaskInfoByTitleTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "TAG", "", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements d<Bundle, Bundle>
{
  private final String TAG;
  
  public l()
  {
    AppMethodBeat.i(303868);
    this.TAG = "MicroMsg.MultiTask.UpdateTaskInfoByTitleTask";
    Log.i(this.TAG, "create update task info by title");
    AppMethodBeat.o(303868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.l
 * JD-Core Version:    0.7.0.1
 */