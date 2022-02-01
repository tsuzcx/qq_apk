package com.tencent.mm.plugin.webview.luggage;

import android.content.Intent;
import android.os.Bundle;
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

public final class r
{
  private static HashMap<String, Integer> PRf;
  private static b.b PRg;
  private static e PRh;
  
  static
  {
    AppMethodBeat.i(78434);
    PRf = new HashMap();
    PRg = new b.b()
    {
      public final void r(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(219081);
        ToolsProcessIPCService.a(new IPCString(paramAnonymousMultiTaskInfo.field_id), r.a.class, null);
        AppMethodBeat.o(219081);
      }
    };
    PRh = new f()
    {
      public final void b(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(246570);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.mab != null))
        {
          Log.i("MicroMsg.LuggageWebViewFloatBallManager", "handleBallInfoClicked, openWebPage ballInfo:%s", new Object[] { paramAnonymousBallInfo });
          String str1 = paramAnonymousBallInfo.key;
          String str2 = paramAnonymousBallInfo.mab.getString("rawUrl");
          int i = paramAnonymousBallInfo.mab.getInt("minimize_secene", 0);
          Intent localIntent = new Intent();
          localIntent.putExtras(paramAnonymousBallInfo.mab);
          localIntent.putExtra("rawUrl", str2);
          localIntent.putExtra("minimize_secene", i);
          localIntent.putExtra("float_ball_key", str1);
          localIntent.putExtra("title", paramAnonymousBallInfo.name);
          com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        }
        AppMethodBeat.o(246570);
      }
      
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(78434);
  }
  
  public static void a(String paramString, com.tencent.luggage.d.p paramp, com.tencent.mm.plugin.webview.f.c paramc)
  {
    AppMethodBeat.i(217076);
    if (PRf.containsKey(paramString))
    {
      AppMethodBeat.o(217076);
      return;
    }
    int i = n.a(paramp, paramc);
    Log.i("MicroMsg.LuggageWebViewFloatBallManager", "onMultiTaskItemClick, stash, ballKey = %s, ticket = %d", new Object[] { paramString, Integer.valueOf(i) });
    PRf.put(paramString, Integer.valueOf(i));
    AppMethodBeat.o(217076);
  }
  
  public static int bkq(String paramString)
  {
    AppMethodBeat.i(78430);
    Log.i("MicroMsg.LuggageWebViewFloatBallManager", "onMultiTaskItemClick, size = %d", new Object[] { Integer.valueOf(PRf.size()) });
    int i = Util.nullAs((Integer)PRf.remove(paramString), -1);
    AppMethodBeat.o(78430);
    return i;
  }
  
  public static void bkr(String paramString)
  {
    AppMethodBeat.i(78431);
    if (PRf.containsKey(paramString)) {
      n.remove(Util.nullAsInt(PRf.remove(paramString), -1));
    }
    AppMethodBeat.o(78431);
  }
  
  public static void gUX()
  {
    AppMethodBeat.i(78432);
    Log.d("MicroMsg.LuggageWebViewFloatBallManager", "addFloatBallInfoEventListener");
    Object localObject = com.tencent.mm.plugin.webview.luggage.d.b.PTA;
    localObject = PRg;
    kotlin.g.b.p.k(localObject, "listener");
    com.tencent.mm.plugin.webview.luggage.d.b.gVn().add(localObject);
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(5, PRh);
    }
    AppMethodBeat.o(78432);
  }
  
  public static void gUY()
  {
    AppMethodBeat.i(78433);
    Object localObject = com.tencent.mm.plugin.webview.luggage.d.b.PTA;
    localObject = PRg;
    kotlin.g.b.p.k(localObject, "listener");
    com.tencent.mm.plugin.webview.luggage.d.b.gVn().remove(localObject);
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).b(5, PRh);
    }
    AppMethodBeat.o(78433);
  }
  
  static class a
    implements d<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.r
 * JD-Core Version:    0.7.0.1
 */