package com.tencent.mm.pluginsdk.model;

import android.os.FileObserver;
import com.tencent.mm.sdk.platformtools.y;

public final class t
  extends FileObserver
{
  private String nSF;
  private t.a rTQ;
  
  public t(String paramString, t.a parama)
  {
    super(paramString);
    y.i("MicroMsg.ScreenshotObserver", "observer  " + paramString);
    this.rTQ = parama;
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    if ((paramString != null) && (paramInt == 8) && ((this.nSF == null) || (!paramString.equalsIgnoreCase(this.nSF))))
    {
      this.nSF = paramString;
      this.rTQ.bIy();
      y.i("MicroMsg.ScreenshotObserver", "Send event to listener. " + paramString);
    }
  }
  
  public final void start()
  {
    super.startWatching();
  }
  
  public final void stop()
  {
    super.stopWatching();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.t
 * JD-Core Version:    0.7.0.1
 */