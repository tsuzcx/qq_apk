package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.plugin.webview.luggage.webview_impl.LuggageWebMultiTaskUIC;
import com.tencent.mm.plugin.webview.luggage.webview_impl.LuggageWebMultiTaskUIC.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class r
{
  private static HashMap<String, Integer> IUO;
  private static LuggageWebMultiTaskUIC.b IUP;
  
  static
  {
    AppMethodBeat.i(78434);
    IUO = new HashMap();
    IUP = new LuggageWebMultiTaskUIC.b()
    {
      public final void p(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(210940);
        ToolsProcessIPCService.a(new IPCString(paramAnonymousMultiTaskInfo.field_id), r.a.class, null);
        AppMethodBeat.o(210940);
      }
    };
    AppMethodBeat.o(78434);
  }
  
  public static void a(String paramString, com.tencent.luggage.d.p paramp, c paramc)
  {
    AppMethodBeat.i(210941);
    if (IUO.containsKey(paramString))
    {
      AppMethodBeat.o(210941);
      return;
    }
    int i = n.a(paramp, paramc);
    Log.i("MicroMsg.LuggageWebViewFloatBallManager", "onMultiTaskItemClick, stash, ballKey = %s, ticket = %d", new Object[] { paramString, Integer.valueOf(i) });
    IUO.put(paramString, Integer.valueOf(i));
    AppMethodBeat.o(210941);
  }
  
  public static int aYv(String paramString)
  {
    AppMethodBeat.i(78430);
    Log.i("MicroMsg.LuggageWebViewFloatBallManager", "onMultiTaskItemClick, size = %d", new Object[] { Integer.valueOf(IUO.size()) });
    int i = Util.nullAs((Integer)IUO.remove(paramString), -1);
    AppMethodBeat.o(78430);
    return i;
  }
  
  public static void aYw(String paramString)
  {
    AppMethodBeat.i(78431);
    if (IUO.containsKey(paramString)) {
      n.remove(Util.nullAsInt(IUO.remove(paramString), -1));
    }
    AppMethodBeat.o(78431);
  }
  
  public static void gcb()
  {
    AppMethodBeat.i(78432);
    Log.d("MicroMsg.LuggageWebViewFloatBallManager", "addFloatBallInfoEventListener");
    Object localObject = LuggageWebMultiTaskUIC.IXk;
    localObject = IUP;
    kotlin.g.b.p.h(localObject, "listener");
    LuggageWebMultiTaskUIC.gcs().add(localObject);
    AppMethodBeat.o(78432);
  }
  
  public static void gcc()
  {
    AppMethodBeat.i(78433);
    Object localObject = LuggageWebMultiTaskUIC.IXk;
    localObject = IUP;
    kotlin.g.b.p.h(localObject, "listener");
    LuggageWebMultiTaskUIC.gcs().remove(localObject);
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