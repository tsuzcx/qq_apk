package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.l.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class p
{
  private static p Wsf;
  private final String TAG = "WebSearchShakeCheckingManager";
  public boolean Wse = false;
  public boolean isStartShake = false;
  public long lastShakeTime;
  public d shakeSensor;
  
  public static p iqU()
  {
    AppMethodBeat.i(315218);
    if (Wsf == null) {}
    try
    {
      Wsf = new p();
      p localp = Wsf;
      AppMethodBeat.o(315218);
      return localp;
    }
    finally
    {
      AppMethodBeat.o(315218);
    }
  }
  
  public static abstract interface a
  {
    public abstract void call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.p
 * JD-Core Version:    0.7.0.1
 */