package com.tencent.mm.plugin.webview.ui.tools.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "", "()V", "canAddJsApiNow", "", "getCanAddJsApiNow", "()Z", "setCanAddJsApiNow", "(Z)V", "jsApiList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/ui/tools/floatball/JSApiInfo;", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "addJsApi", "", "jsApiInfo", "getJsApiList", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final LinkedList<a> Iuu;
  public boolean XbV;
  public String title;
  
  public c()
  {
    AppMethodBeat.i(296268);
    this.XbV = true;
    this.Iuu = new LinkedList();
    AppMethodBeat.o(296268);
  }
  
  public final void a(a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(296276);
        s.u(parama, "jsApiInfo");
        if (!this.XbV)
        {
          AppMethodBeat.o(296276);
          return;
        }
        Iterator localIterator = ((Iterable)this.Iuu).iterator();
        a locala;
        if (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          if (locala.id == parama.id)
          {
            if (locala != null) {
              this.Iuu.remove(locala);
            }
            this.Iuu.add(parama);
            AppMethodBeat.o(296276);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.floatball.c
 * JD-Core Version:    0.7.0.1
 */