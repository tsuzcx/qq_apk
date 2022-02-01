package com.tencent.mm.plugin.taskbar;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/AddOrUpdateTaskInfoTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "TAG", "", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-taskbar_release"})
public final class a
  implements d<Bundle, Bundle>
{
  private final String TAG;
  
  public a()
  {
    AppMethodBeat.i(214159);
    this.TAG = "MicroMsg.TaskBar.AddTaskInfoTask";
    Log.i(this.TAG, "create add task info");
    AppMethodBeat.o(214159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.a
 * JD-Core Version:    0.7.0.1
 */