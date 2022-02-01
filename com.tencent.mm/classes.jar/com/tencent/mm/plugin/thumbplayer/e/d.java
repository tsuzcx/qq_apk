package com.tencent.mm.plugin.thumbplayer.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayerFactory;", "", "()V", "Companion", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a TFK;
  
  static
  {
    AppMethodBeat.i(272112);
    TFK = new a((byte)0);
    AppMethodBeat.o(272112);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayerFactory$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "context", "Landroid/content/Context;", "threadLooper", "Landroid/os/Looper;", "callbackLoop", "createCdnPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a kr(Context paramContext)
    {
      AppMethodBeat.i(272082);
      s.u(paramContext, "context");
      paramContext = (a)new c(paramContext);
      AppMethodBeat.o(272082);
      return paramContext;
    }
    
    public static b ks(Context paramContext)
    {
      AppMethodBeat.i(272092);
      s.u(paramContext, "context");
      paramContext = new b(paramContext);
      AppMethodBeat.o(272092);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.e.d
 * JD-Core Version:    0.7.0.1
 */