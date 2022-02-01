package com.tencent.mm.plugin.webview.luggage;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class r
{
  private static HashMap<String, Integer> Eia;
  private static f Eib;
  
  static
  {
    AppMethodBeat.i(78434);
    Eia = new HashMap();
    Eib = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(78426);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.ioY != null))
        {
          ae.i("MicroMsg.LuggageWebViewFloatBallManager", "handleBallInfoClicked, openWebPage ballInfo:%s", new Object[] { paramAnonymousBallInfo });
          String str1 = paramAnonymousBallInfo.key;
          String str2 = paramAnonymousBallInfo.ioY.getString("rawUrl");
          int i = paramAnonymousBallInfo.ioY.getInt("minimize_secene", 0);
          Intent localIntent = new Intent();
          localIntent.putExtras(paramAnonymousBallInfo.ioY);
          localIntent.putExtra("rawUrl", str2);
          localIntent.putExtra("minimize_secene", i);
          localIntent.putExtra("float_ball_key", str1);
          localIntent.putExtra("title", paramAnonymousBallInfo.name);
          d.b(ak.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        }
        AppMethodBeat.o(78426);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(78427);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.ioY != null)) {
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
    AppMethodBeat.i(198083);
    if (Eia.containsKey(paramString))
    {
      AppMethodBeat.o(198083);
      return;
    }
    int i = n.a(paramp, paramc);
    Eia.put(paramString, Integer.valueOf(i));
    AppMethodBeat.o(198083);
  }
  
  public static int aIt(String paramString)
  {
    AppMethodBeat.i(78430);
    int i = bu.a((Integer)Eia.remove(paramString), -1);
    AppMethodBeat.o(78430);
    return i;
  }
  
  public static void aIu(String paramString)
  {
    AppMethodBeat.i(78431);
    if (Eia.containsKey(paramString)) {
      n.remove(bu.m(Eia.remove(paramString), -1));
    }
    AppMethodBeat.o(78431);
  }
  
  public static void eTo()
  {
    AppMethodBeat.i(78432);
    ae.d("MicroMsg.LuggageWebViewFloatBallManager", "addFloatBallInfoEventListener");
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null)
    {
      ae.d("MicroMsg.LuggageWebViewFloatBallManager", "addFloatBallInfoEventListener true");
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(5, Eib);
    }
    AppMethodBeat.o(78432);
  }
  
  public static void eTp()
  {
    AppMethodBeat.i(78433);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(5, Eib);
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