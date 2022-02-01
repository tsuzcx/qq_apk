package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ac;

public class ActiveMainProcessTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ActiveMainProcessTask> CREATOR;
  public Runnable callback;
  
  static
  {
    AppMethodBeat.i(78486);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(78486);
  }
  
  public ActiveMainProcessTask() {}
  
  private ActiveMainProcessTask(byte paramByte) {}
  
  public final void aLq()
  {
    AppMethodBeat.i(78484);
    ac.i("MicroMsg.ActiveMainProcessTask", "active");
    bet();
    AppMethodBeat.o(78484);
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(78485);
    ac.i("MicroMsg.ActiveMainProcessTask", "runInClientProcess");
    if (this.callback != null) {
      this.callback.run();
    }
    AppMethodBeat.o(78485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask
 * JD-Core Version:    0.7.0.1
 */