package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.e.b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/view/MMCdnTPPlayerRecycler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "busyPlayerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "", "getBusyPlayerMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getContext", "()Landroid/content/Context;", "idlePlayers", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getIdlePlayers", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "destroy", "", "getOrCreatePlayer", "recyclePlayer", "player", "plugin-thumbplayer_release"})
public final class a
{
  public final ConcurrentLinkedDeque<b> Gia;
  public final ConcurrentHashMap<b, Long> Gib;
  private final String TAG;
  private final Context context;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(238750);
    this.context = paramContext;
    this.TAG = "MicroMsg.TP.MMCdnTPPlayerRecycler";
    this.Gia = new ConcurrentLinkedDeque();
    this.Gib = new ConcurrentHashMap();
    AppMethodBeat.o(238750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.a
 * JD-Core Version:    0.7.0.1
 */