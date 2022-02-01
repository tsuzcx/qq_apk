package com.tencent.mm.plugin.webview.luggage;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.webview.luggage.d.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class s
{
  private static HashMap<String, Integer> WHC;
  private static b.b WHD;
  private static e WHE;
  
  static
  {
    AppMethodBeat.i(78434);
    WHC = new HashMap();
    WHD = new b.b()
    {
      public final void r(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(295879);
        ToolsProcessIPCService.a(new IPCString(paramAnonymousMultiTaskInfo.field_id), s.a.class, null);
        AppMethodBeat.o(295879);
      }
    };
    WHE = new f()
    {
      public final void b(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(295874);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.oSS != null))
        {
          Log.i("MicroMsg.LuggageWebViewFloatBallManager", "handleBallInfoClicked, openWebPage ballInfo:%s", new Object[] { paramAnonymousBallInfo });
          String str1 = paramAnonymousBallInfo.key;
          String str2 = paramAnonymousBallInfo.oSS.getString("rawUrl");
          int i = paramAnonymousBallInfo.oSS.getInt("minimize_secene", 0);
          Intent localIntent = new Intent();
          localIntent.putExtras(paramAnonymousBallInfo.oSS);
          localIntent.putExtra("rawUrl", str2);
          localIntent.putExtra("minimize_secene", i);
          localIntent.putExtra("float_ball_key", str1);
          localIntent.putExtra("title", paramAnonymousBallInfo.name);
          com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        }
        AppMethodBeat.o(295874);
      }
      
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(78434);
  }
  
  public static void a(String paramString, p paramp, com.tencent.mm.plugin.webview.e.c paramc)
  {
    AppMethodBeat.i(295932);
    if (WHC.containsKey(paramString))
    {
      AppMethodBeat.o(295932);
      return;
    }
    int i = o.a(paramp, paramc);
    Log.i("MicroMsg.LuggageWebViewFloatBallManager", "onMultiTaskItemClick, stash, ballKey = %s, ticket = %d", new Object[] { paramString, Integer.valueOf(i) });
    WHC.put(paramString, Integer.valueOf(i));
    AppMethodBeat.o(295932);
  }
  
  public static int bka(String paramString)
  {
    AppMethodBeat.i(78430);
    Log.i("MicroMsg.LuggageWebViewFloatBallManager", "onMultiTaskItemClick, size = %d", new Object[] { Integer.valueOf(WHC.size()) });
    int i = Util.nullAs((Integer)WHC.remove(paramString), -1);
    AppMethodBeat.o(78430);
    return i;
  }
  
  public static void bkb(String paramString)
  {
    AppMethodBeat.i(78431);
    if (WHC.containsKey(paramString)) {
      o.remove(Util.nullAsInt(WHC.remove(paramString), -1));
    }
    AppMethodBeat.o(78431);
  }
  
  public static void iuI()
  {
    AppMethodBeat.i(78432);
    Log.d("MicroMsg.LuggageWebViewFloatBallManager", "addFloatBallInfoEventListener");
    Object localObject = com.tencent.mm.plugin.webview.luggage.d.b.WKl;
    localObject = WHD;
    kotlin.g.b.s.u(localObject, "listener");
    com.tencent.mm.plugin.webview.luggage.d.b.iuY().add(localObject);
    if (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).a(5, WHE);
    }
    AppMethodBeat.o(78432);
  }
  
  public static void iuJ()
  {
    AppMethodBeat.i(78433);
    Object localObject = com.tencent.mm.plugin.webview.luggage.d.b.WKl;
    localObject = WHD;
    kotlin.g.b.s.u(localObject, "listener");
    com.tencent.mm.plugin.webview.luggage.d.b.iuY().remove(localObject);
    if (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).b(5, WHE);
    }
    AppMethodBeat.o(78433);
  }
  
  static class a
    implements d<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.s
 * JD-Core Version:    0.7.0.1
 */