package com.tencent.mm.pluginsdk.model;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends FileObserver
{
  private String CZI;
  private a JVF;
  
  public v(String paramString, a parama)
  {
    super(paramString);
    AppMethodBeat.i(151647);
    Log.i("MicroMsg.ScreenshotObserver", "observer  ".concat(String.valueOf(paramString)));
    this.JVF = parama;
    AppMethodBeat.o(151647);
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(151648);
    if ((paramString != null) && (paramInt == 8) && ((this.CZI == null) || (!paramString.equalsIgnoreCase(this.CZI))))
    {
      this.CZI = paramString;
      this.JVF.eCy();
      Log.i("MicroMsg.ScreenshotObserver", "Send event to listener. ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(151648);
  }
  
  public final void start()
  {
    AppMethodBeat.i(151649);
    super.startWatching();
    AppMethodBeat.o(151649);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(151650);
    super.stopWatching();
    AppMethodBeat.o(151650);
  }
  
  public static abstract interface a
  {
    public abstract void eCy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.v
 * JD-Core Version:    0.7.0.1
 */