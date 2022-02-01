package com.tencent.mm.plugin.multitask;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/UpdateTaskInfoByTitleTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "TAG", "", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-multitask_release"})
public final class l
  implements d<Bundle, Bundle>
{
  private final String TAG;
  
  public l()
  {
    AppMethodBeat.i(248147);
    this.TAG = "MicroMsg.MultiTask.UpdateTaskInfoByTitleTask";
    Log.i(this.TAG, "create update task info by title");
    AppMethodBeat.o(248147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.l
 * JD-Core Version:    0.7.0.1
 */