package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "launchSuccess", "", "launchCancel", "onLaunchApp"})
final class l$a
  implements al
{
  public static final a AkJ;
  
  static
  {
    AppMethodBeat.i(219990);
    AkJ = new a();
    AppMethodBeat.o(219990);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219989);
    Log.i("MusicUIUtil", "onLaunchApp launchSuccess:%b, launchCancel:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(219989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.l.a
 * JD-Core Version:    0.7.0.1
 */