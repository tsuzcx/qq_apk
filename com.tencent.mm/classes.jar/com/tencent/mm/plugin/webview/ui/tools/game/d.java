package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  public static WebResourceResponse oA(boolean paramBoolean)
  {
    AppMethodBeat.i(8689);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(8689);
      return null;
    }
    Object localObject1 = i.p(ah.getContext(), "game.js");
    if (!bo.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).replaceFirst("#__usewepkg__#", String.valueOf(paramBoolean));
      Object localObject2 = (PowerManager)ah.getContext().getSystemService("power");
      if ((localObject2 != null) && (Build.VERSION.SDK_INT >= 21)) {}
      for (paramBoolean = ((PowerManager)localObject2).isPowerSaveMode();; paramBoolean = false)
      {
        localObject1 = ((String)localObject1).replaceFirst("#__lowPowerMode__#", String.valueOf(paramBoolean)).replaceFirst("#__lowPower__#", String.valueOf(BatteryManager.vme));
        try
        {
          localObject1 = new WebResourceResponse("application/javascript", "utf-8", new ByteArrayInputStream(((String)localObject1).getBytes("UTF-8")));
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("Cache-Control", "no-cache, no-store, must-revalidate");
          ((HashMap)localObject2).put("Pragma", "no-cache");
          ((HashMap)localObject2).put("Expires", "0");
          ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
          AppMethodBeat.o(8689);
          return localObject1;
        }
        catch (Exception localException)
        {
          com.tencent.luggage.g.d.a("MicroMsg.GameScriptManager", "", new Object[] { localException });
        }
      }
    }
    AppMethodBeat.o(8689);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.d
 * JD-Core Version:    0.7.0.1
 */