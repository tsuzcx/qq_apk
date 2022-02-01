package com.tencent.mm.plugin.thumbplayer.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayerFactory;", "", "()V", "Companion", "plugin-thumbplayer_release"})
public final class d
{
  public static final a GhZ;
  
  static
  {
    AppMethodBeat.i(238749);
    GhZ = new a((byte)0);
    AppMethodBeat.o(238749);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayerFactory$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "context", "Landroid/content/Context;", "threadLooper", "Landroid/os/Looper;", "callbackLoop", "createCdnPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "plugin-thumbplayer_release"})
  public static final class a
  {
    public static a ht(Context paramContext)
    {
      AppMethodBeat.i(238747);
      p.h(paramContext, "context");
      paramContext = (a)new c(paramContext);
      AppMethodBeat.o(238747);
      return paramContext;
    }
    
    public static b hu(Context paramContext)
    {
      AppMethodBeat.i(238748);
      p.h(paramContext, "context");
      paramContext = new b(paramContext);
      AppMethodBeat.o(238748);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.e.d
 * JD-Core Version:    0.7.0.1
 */