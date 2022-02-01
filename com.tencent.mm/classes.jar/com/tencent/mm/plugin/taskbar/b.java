package com.tencent.mm.plugin.taskbar;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/DeleteTaskInfoTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "TAG", "", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-taskbar_release"})
public final class b
  implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
{
  private final String TAG;
  
  public b()
  {
    AppMethodBeat.i(238392);
    this.TAG = "MicroMsg.TaskBar.DeleteTaskInfoTask";
    Log.i(this.TAG, "create delete task info");
    AppMethodBeat.o(238392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.b
 * JD-Core Version:    0.7.0.1
 */