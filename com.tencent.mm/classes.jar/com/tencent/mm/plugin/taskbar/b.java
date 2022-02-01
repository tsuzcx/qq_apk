package com.tencent.mm.plugin.taskbar;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/DeleteTaskInfoTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "TAG", "", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements d<Bundle, Bundle>
{
  private final String TAG;
  
  public b()
  {
    AppMethodBeat.i(263971);
    this.TAG = "MicroMsg.TaskBar.DeleteTaskInfoTask";
    Log.i(this.TAG, "create delete task info");
    AppMethodBeat.o(263971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.b
 * JD-Core Version:    0.7.0.1
 */