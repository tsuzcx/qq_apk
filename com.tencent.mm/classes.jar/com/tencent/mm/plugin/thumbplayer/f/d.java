package com.tencent.mm.plugin.thumbplayer.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayerFactory;", "", "()V", "Companion", "plugin-thumbplayer_release"})
public final class d
{
  public static final a MTv;
  
  static
  {
    AppMethodBeat.i(191197);
    MTv = new a((byte)0);
    AppMethodBeat.o(191197);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayerFactory$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "context", "Landroid/content/Context;", "threadLooper", "Landroid/os/Looper;", "callbackLoop", "createCdnPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "plugin-thumbplayer_release"})
  public static final class a
  {
    public static b iA(Context paramContext)
    {
      AppMethodBeat.i(191188);
      p.k(paramContext, "context");
      paramContext = new b(paramContext);
      AppMethodBeat.o(191188);
      return paramContext;
    }
    
    public static a iz(Context paramContext)
    {
      AppMethodBeat.i(191186);
      p.k(paramContext, "context");
      paramContext = (a)new c(paramContext);
      AppMethodBeat.o(191186);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.f.d
 * JD-Core Version:    0.7.0.1
 */