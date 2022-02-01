package com.tencent.mm.plugin.taskbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/HasTaskInfo;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "TAG", "", "invoke", "id", "plugin-taskbar_release"})
public final class c
  implements k<IPCString, IPCBoolean>
{
  private final String TAG;
  
  public c()
  {
    AppMethodBeat.i(238394);
    this.TAG = "MicroMsg.TaskBar.GetTaskInfo";
    Log.i(this.TAG, "create get task info");
    AppMethodBeat.o(238394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.c
 * JD-Core Version:    0.7.0.1
 */