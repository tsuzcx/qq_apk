package com.tencent.mm.plugin.webview.luggage;

import android.os.Looper;
import com.tencent.luggage.e.k;
import com.tencent.luggage.e.m;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.luggage.permission.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;

public final class o
{
  private static HashMap<String, Integer> rcO = new HashMap();
  
  public static int a(k paramk, LuggageGetA8Key paramLuggageGetA8Key)
  {
    int i = m.a(ae.getContext(), paramk).intValue();
    b.a(paramk.hashCode(), paramLuggageGetA8Key);
    return i;
  }
  
  public static void remove(int paramInt)
  {
    k localk = m.a(Integer.valueOf(paramInt));
    if (localk != null)
    {
      b.BZ(localk.hashCode());
      if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {}
    }
    else
    {
      try
      {
        localk.destroy();
        return;
      }
      catch (Exception localException)
      {
        c.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
        return;
      }
    }
    ai.d(new o.1(localException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.o
 * JD-Core Version:    0.7.0.1
 */