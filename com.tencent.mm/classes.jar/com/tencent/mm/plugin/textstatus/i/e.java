package com.tencent.mm.plugin.textstatus.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/report/TextStatusSessionManager;", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusSessionService;", "()V", "TAG", "", "isLogOpen", "", "pageIdStack", "Ljava/util/Stack;", "getPageIdStack", "()Ljava/util/Stack;", "setPageIdStack", "(Ljava/util/Stack;)V", "sceneSessionIdStack", "getSceneSessionIdStack", "setSceneSessionIdStack", "sessionIdStack", "getSessionIdStack", "setSessionIdStack", "getPageId", "getPageIdUICClz", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "getSceneSessionId", "getSceneSessionIdUICClz", "getSessionId", "getSessionIdUICClz", "popPageId", "", "popSceneSessionId", "popSessionId", "pushPageId", "pushSceneSessionId", "pushSessionId", "replaceSessionId", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements u
{
  public static final e Tru;
  private static Stack<String> Trv;
  private static Stack<String> Trw;
  private static Stack<String> Trx;
  
  static
  {
    AppMethodBeat.i(289668);
    Tru = new e();
    Trv = new Stack();
    Trw = new Stack();
    Trx = new Stack();
    AppMethodBeat.o(289668);
  }
  
  public static String hHZ()
  {
    AppMethodBeat.i(289654);
    if (Trw.empty())
    {
      Log.d("MicroMsg.TextStatus.TextStatusSessionManager", "getSceneSessionId() with empty stack");
      AppMethodBeat.o(289654);
      return "";
    }
    Object localObject = Trw.peek();
    s.s(localObject, "sceneSessionIdStack.peek()");
    localObject = (String)localObject;
    AppMethodBeat.o(289654);
    return localObject;
  }
  
  public static String hIa()
  {
    AppMethodBeat.i(289662);
    if (Trx.empty())
    {
      Log.d("MicroMsg.TextStatus.TextStatusSessionManager", "getPageId() with empty stack");
      AppMethodBeat.o(289662);
      return "";
    }
    Object localObject = Trx.peek();
    s.s(localObject, "pageIdStack.peek()");
    localObject = (String)localObject;
    AppMethodBeat.o(289662);
    return localObject;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(289677);
    if (Trv.empty())
    {
      Log.d("MicroMsg.TextStatus.TextStatusSessionManager", "getSessionId() with empty stack");
      hFz();
    }
    Object localObject = Trv.peek();
    s.s(localObject, "sessionIdStack.peek()");
    localObject = (String)localObject;
    AppMethodBeat.o(289677);
    return localObject;
  }
  
  public final void hFA()
  {
    AppMethodBeat.i(289675);
    if (!Trv.empty()) {
      Trv.pop();
    }
    AppMethodBeat.o(289675);
  }
  
  public final String hFB()
  {
    AppMethodBeat.i(289680);
    String str = com.tencent.mm.plugin.fts.a.d.We(3);
    Trw.push(str);
    str = hHZ();
    AppMethodBeat.o(289680);
    return str;
  }
  
  public final void hFC()
  {
    AppMethodBeat.i(289683);
    if (!Trw.empty()) {
      Trw.pop();
    }
    AppMethodBeat.o(289683);
  }
  
  public final String hFD()
  {
    AppMethodBeat.i(289689);
    String str = com.tencent.mm.plugin.fts.a.d.We(4);
    Trx.push(str);
    str = hIa();
    AppMethodBeat.o(289689);
    return str;
  }
  
  public final void hFE()
  {
    AppMethodBeat.i(289694);
    if (!Trx.empty()) {
      Trx.pop();
    }
    AppMethodBeat.o(289694);
  }
  
  public final Class<? extends UIComponent> hFF()
  {
    return d.class;
  }
  
  public final Class<? extends UIComponent> hFG()
  {
    return a.class;
  }
  
  public final String hFz()
  {
    AppMethodBeat.i(289671);
    String str = com.tencent.mm.plugin.fts.a.d.We(1);
    Trv.push(str);
    str = getSessionId();
    AppMethodBeat.o(289671);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.i.e
 * JD-Core Version:    0.7.0.1
 */