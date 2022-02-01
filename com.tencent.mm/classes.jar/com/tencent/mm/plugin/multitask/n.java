package com.tencent.mm.plugin.multitask;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/getMultiTaskItemPosition;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "TAG", "", "invoke", "data", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements m<Bundle, IPCString>
{
  private final String TAG;
  
  public n()
  {
    AppMethodBeat.i(303881);
    this.TAG = "MicroMsg.MultiTask.getMultiTaskItemPosition";
    Log.i(this.TAG, "create multiTaskItemPosition");
    AppMethodBeat.o(303881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.n
 * JD-Core Version:    0.7.0.1
 */