package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
public final class l$a
  implements f.c
{
  public l$a(Context paramContext, Intent paramIntent, al paramal) {}
  
  public final void g(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(259664);
    try
    {
      paramString = this.$context;
      Object localObject = this.FRN;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/music/model/MusicUIUtil$launchQQMusic$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/music/model/MusicUIUtil$launchQQMusic$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString = this.FRO;
      if (paramString != null)
      {
        paramString.y(true, false);
        AppMethodBeat.o(259664);
        return;
      }
      AppMethodBeat.o(259664);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MusicUIUtil", (Throwable)paramString, "launchQQMusic exception", new Object[0]);
      paramString = this.FRO;
      if (paramString != null)
      {
        paramString.y(false, false);
        AppMethodBeat.o(259664);
        return;
      }
      AppMethodBeat.o(259664);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.l.a
 * JD-Core Version:    0.7.0.1
 */