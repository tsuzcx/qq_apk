package com.tencent.mm.plugin.mv.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onBinded", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$ab
  extends l
{
  c$ab(c paramc) {}
  
  public final void cxX()
  {
    AppMethodBeat.i(287021);
    try
    {
      Object localObject = c.l(this.MjI);
      if (localObject != null)
      {
        localObject = ((e)localObject).irJ();
        if (localObject != null)
        {
          f localf = (f)c.m(this.MjI);
          e locale = c.l(this.MjI);
          if (locale == null) {}
          for (int i = 0;; i = locale.irL())
          {
            ((com.tencent.mm.plugin.webview.stub.e)localObject).a(localf, i);
            AppMethodBeat.o(287021);
            return;
          }
        }
      }
      return;
    }
    finally
    {
      Log.printErrStackTrace(c.access$getTAG$cp(), localThrowable, "initWebViewController exception", new Object[0]);
      AppMethodBeat.o(287021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.c.ab
 * JD-Core Version:    0.7.0.1
 */