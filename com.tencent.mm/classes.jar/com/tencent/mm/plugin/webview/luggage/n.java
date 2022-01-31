package com.tencent.mm.plugin.webview.luggage;

import android.os.Looper;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.m;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.luggage.permission.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;

public final class n
{
  private static HashMap<String, Integer> uSL;
  
  static
  {
    AppMethodBeat.i(6218);
    uSL = new HashMap();
    AppMethodBeat.o(6218);
  }
  
  public static int a(k paramk, LuggageGetA8Key paramLuggageGetA8Key)
  {
    AppMethodBeat.i(6216);
    int i = m.a(ah.getContext(), paramk).intValue();
    b.a(paramk.hashCode(), paramLuggageGetA8Key);
    AppMethodBeat.o(6216);
    return i;
  }
  
  public static void remove(int paramInt)
  {
    AppMethodBeat.i(6217);
    k localk = m.a(Integer.valueOf(paramInt));
    if (localk != null)
    {
      b.JT(localk.hashCode());
      if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
        try
        {
          localk.destroy();
          AppMethodBeat.o(6217);
          return;
        }
        catch (Exception localException)
        {
          d.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
          AppMethodBeat.o(6217);
          return;
        }
      }
      al.d(new n.1(localException));
    }
    AppMethodBeat.o(6217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.n
 * JD-Core Version:    0.7.0.1
 */