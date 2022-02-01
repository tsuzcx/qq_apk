package com.tencent.mm.plugin.webview.luggage;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public final class q
{
  private static HashMap<String, Integer> CmF;
  private static f CmG;
  
  static
  {
    AppMethodBeat.i(78434);
    CmF = new HashMap();
    CmG = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(78426);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.hSN != null))
        {
          ac.i("MicroMsg.LuggageWebViewFloatBallManager", "handleBallInfoClicked, openWebPage ballInfo:%s", new Object[] { paramAnonymousBallInfo });
          String str1 = paramAnonymousBallInfo.key;
          String str2 = paramAnonymousBallInfo.hSN.getString("rawUrl");
          int i = paramAnonymousBallInfo.hSN.getInt("minimize_secene", 0);
          Intent localIntent = new Intent();
          localIntent.putExtras(paramAnonymousBallInfo.hSN);
          localIntent.putExtra("rawUrl", str2);
          localIntent.putExtra("minimize_secene", i);
          localIntent.putExtra("float_ball_key", str1);
          localIntent.putExtra("title", paramAnonymousBallInfo.name);
          d.b(ai.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        }
        AppMethodBeat.o(78426);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(78427);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.hSN != null)) {
          ToolsProcessIPCService.a(new IPCString(paramAnonymousBallInfo.key), q.a.class, null);
        }
        AppMethodBeat.o(78427);
      }
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(78434);
  }
  
  public static void a(String paramString, k paramk, com.tencent.mm.plugin.webview.e.c paramc)
  {
    AppMethodBeat.i(188298);
    if (CmF.containsKey(paramString))
    {
      AppMethodBeat.o(188298);
      return;
    }
    int i = m.a(paramk, paramc);
    CmF.put(paramString, Integer.valueOf(i));
    AppMethodBeat.o(188298);
  }
  
  public static int aBB(String paramString)
  {
    AppMethodBeat.i(78430);
    int i = bs.a((Integer)CmF.remove(paramString), -1);
    AppMethodBeat.o(78430);
    return i;
  }
  
  public static void aBC(String paramString)
  {
    AppMethodBeat.i(78431);
    if (CmF.containsKey(paramString)) {
      m.remove(bs.l(CmF.remove(paramString), -1));
    }
    AppMethodBeat.o(78431);
  }
  
  public static void eAK()
  {
    AppMethodBeat.i(78432);
    ac.d("MicroMsg.LuggageWebViewFloatBallManager", "addFloatBallInfoEventListener");
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null)
    {
      ac.d("MicroMsg.LuggageWebViewFloatBallManager", "addFloatBallInfoEventListener true");
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(5, CmG);
    }
    AppMethodBeat.o(78432);
  }
  
  public static void eAL()
  {
    AppMethodBeat.i(78433);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(5, CmG);
    }
    AppMethodBeat.o(78433);
  }
  
  static class a
    implements b<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.q
 * JD-Core Version:    0.7.0.1
 */