package com.tencent.mm.plugin.webview.ui.tools.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "", "()V", "canAddJsApiNow", "", "getCanAddJsApiNow", "()Z", "setCanAddJsApiNow", "(Z)V", "jsApiList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/ui/tools/floatball/JSApiInfo;", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "addJsApi", "", "jsApiInfo", "getJsApiList", "plugin-webview_release"})
public final class c
{
  public boolean JmM;
  public String title;
  public final LinkedList<a> xwA;
  
  public c()
  {
    AppMethodBeat.i(210491);
    this.xwA = new LinkedList();
    AppMethodBeat.o(210491);
  }
  
  public final void a(a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(210490);
        p.h(parama, "jsApiInfo");
        if (!this.JmM)
        {
          AppMethodBeat.o(210490);
          return;
        }
        Iterator localIterator = ((Iterable)this.xwA).iterator();
        a locala;
        if (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          if (locala.id == parama.id)
          {
            if (locala != null) {
              this.xwA.remove(locala);
            }
            this.xwA.add(parama);
            AppMethodBeat.o(210490);
          }
        }
        else
        {
          locala = null;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.floatball.c
 * JD-Core Version:    0.7.0.1
 */