package com.tencent.mm.plugin.multitask;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/getMultiTaskItemPosition;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "TAG", "", "invoke", "data", "plugin-multitask_release"})
public final class m
  implements k<Bundle, IPCString>
{
  private final String TAG;
  
  public m()
  {
    AppMethodBeat.i(200556);
    this.TAG = "MicroMsg.MultiTask.getMultiTaskItemPosition";
    Log.i(this.TAG, "create multiTaskItemPosition");
    AppMethodBeat.o(200556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.m
 * JD-Core Version:    0.7.0.1
 */