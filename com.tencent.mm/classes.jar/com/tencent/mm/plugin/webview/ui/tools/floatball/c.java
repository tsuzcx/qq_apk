package com.tencent.mm.plugin.webview.ui.tools.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "", "()V", "canAddJsApiNow", "", "getCanAddJsApiNow", "()Z", "setCanAddJsApiNow", "(Z)V", "jsApiList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/ui/tools/floatball/JSApiInfo;", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "addJsApi", "", "jsApiInfo", "getJsApiList", "plugin-webview_release"})
public final class c
{
  public final LinkedList<a> CAI;
  public boolean Qkd;
  public String title;
  
  public c()
  {
    AppMethodBeat.i(226305);
    this.CAI = new LinkedList();
    AppMethodBeat.o(226305);
  }
  
  public final void a(a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(226303);
        p.k(parama, "jsApiInfo");
        if (!this.Qkd)
        {
          AppMethodBeat.o(226303);
          return;
        }
        Iterator localIterator = ((Iterable)this.CAI).iterator();
        a locala;
        if (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          if (locala.id == parama.id)
          {
            if (locala != null) {
              this.CAI.remove(locala);
            }
            this.CAI.add(parama);
            AppMethodBeat.o(226303);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.floatball.c
 * JD-Core Version:    0.7.0.1
 */