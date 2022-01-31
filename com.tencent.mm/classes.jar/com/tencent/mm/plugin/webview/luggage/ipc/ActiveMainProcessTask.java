package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;

public class ActiveMainProcessTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ActiveMainProcessTask> CREATOR;
  
  static
  {
    AppMethodBeat.i(6245);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(6245);
  }
  
  public ActiveMainProcessTask() {}
  
  private ActiveMainProcessTask(byte paramByte) {}
  
  public final void ata()
  {
    AppMethodBeat.i(6244);
    ab.i("MicroMsg.ActiveMainProcessTask", "active");
    AppMethodBeat.o(6244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask
 * JD-Core Version:    0.7.0.1
 */