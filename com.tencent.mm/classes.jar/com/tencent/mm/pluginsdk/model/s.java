package com.tencent.mm.pluginsdk.model;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class s
  extends FileObserver
{
  private String qGD;
  private s.a vKN;
  
  public s(String paramString, s.a parama)
  {
    super(paramString);
    AppMethodBeat.i(79226);
    ab.i("MicroMsg.ScreenshotObserver", "observer  ".concat(String.valueOf(paramString)));
    this.vKN = parama;
    AppMethodBeat.o(79226);
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(79227);
    if ((paramString != null) && (paramInt == 8) && ((this.qGD == null) || (!paramString.equalsIgnoreCase(this.qGD))))
    {
      this.qGD = paramString;
      this.vKN.cuT();
      ab.i("MicroMsg.ScreenshotObserver", "Send event to listener. ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(79227);
  }
  
  public final void start()
  {
    AppMethodBeat.i(79228);
    super.startWatching();
    AppMethodBeat.o(79228);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(79229);
    super.stopWatching();
    AppMethodBeat.o(79229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.s
 * JD-Core Version:    0.7.0.1
 */