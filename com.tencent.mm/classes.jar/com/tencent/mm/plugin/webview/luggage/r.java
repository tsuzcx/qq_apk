package com.tencent.mm.plugin.webview.luggage;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class r
{
  private static HashMap<String, Integer> DQa;
  private static f DQb;
  
  static
  {
    AppMethodBeat.i(78434);
    DQa = new HashMap();
    DQb = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(78426);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.ime != null))
        {
          ad.i("MicroMsg.LuggageWebViewFloatBallManager", "handleBallInfoClicked, openWebPage ballInfo:%s", new Object[] { paramAnonymousBallInfo });
          String str1 = paramAnonymousBallInfo.key;
          String str2 = paramAnonymousBallInfo.ime.getString("rawUrl");
          int i = paramAnonymousBallInfo.ime.getInt("minimize_secene", 0);
          Intent localIntent = new Intent();
          localIntent.putExtras(paramAnonymousBallInfo.ime);
          localIntent.putExtra("rawUrl", str2);
          localIntent.putExtra("minimize_secene", i);
          localIntent.putExtra("float_ball_key", str1);
          localIntent.putExtra("title", paramAnonymousBallInfo.name);
          d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        }
        AppMethodBeat.o(78426);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(78427);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.ime != null)) {
          ToolsProcessIPCService.a(new IPCString(paramAnonymousBallInfo.key), r.a.class, null);
        }
        AppMethodBeat.o(78427);
      }
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(78434);
  }
  
  public static void a(String paramString, p paramp, com.tencent.mm.plugin.webview.e.c paramc)
  {
    AppMethodBeat.i(207903);
    if (DQa.containsKey(paramString))
    {
      AppMethodBeat.o(207903);
      return;
    }
    int i = n.a(paramp, paramc);
    DQa.put(paramString, Integer.valueOf(i));
    AppMethodBeat.o(207903);
  }
  
  public static int aGZ(String paramString)
  {
    AppMethodBeat.i(78430);
    int i = bt.a((Integer)DQa.remove(paramString), -1);
    AppMethodBeat.o(78430);
    return i;
  }
  
  public static void aHa(String paramString)
  {
    AppMethodBeat.i(78431);
    if (DQa.containsKey(paramString)) {
      n.remove(bt.m(DQa.remove(paramString), -1));
    }
    AppMethodBeat.o(78431);
  }
  
  public static void ePC()
  {
    AppMethodBeat.i(78432);
    ad.d("MicroMsg.LuggageWebViewFloatBallManager", "addFloatBallInfoEventListener");
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null)
    {
      ad.d("MicroMsg.LuggageWebViewFloatBallManager", "addFloatBallInfoEventListener true");
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(5, DQb);
    }
    AppMethodBeat.o(78432);
  }
  
  public static void ePD()
  {
    AppMethodBeat.i(78433);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(5, DQb);
    }
    AppMethodBeat.o(78433);
  }
  
  static class a
    implements b<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.r
 * JD-Core Version:    0.7.0.1
 */