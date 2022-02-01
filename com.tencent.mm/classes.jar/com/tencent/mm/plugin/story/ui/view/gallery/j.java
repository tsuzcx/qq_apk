package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "", "()V", "BAD_NETWORK_PRELOAD_QUEUE", "", "", "getBAD_NETWORK_PRELOAD_QUEUE", "()Ljava/util/List;", "BAD_NETWORK_SPEED", "getBAD_NETWORK_SPEED", "()I", "setBAD_NETWORK_SPEED", "(I)V", "CAN_UPGRADES", "", "getCAN_UPGRADES", "()Z", "GOOD_NETWORK_PRELOAD_QUEUE", "getGOOD_NETWORK_PRELOAD_QUEUE", "GOOD_NETWORK_SPEED", "getGOOD_NETWORK_SPEED", "setGOOD_NETWORK_SPEED", "PRELOAD_CONNECTION_COUNT", "getPRELOAD_CONNECTION_COUNT", "PRELOAD_PERCENT", "getPRELOAD_PERCENT", "plugin-story_release"})
public final class j
{
  final boolean FFT;
  public final int FFU;
  int FFV;
  int FFW;
  final List<Integer> FFX;
  final List<Integer> FFY;
  final List<Integer> FFZ;
  
  public j()
  {
    AppMethodBeat.i(120397);
    this.FFU = 30;
    this.FFV = 450;
    this.FFW = 200;
    this.FFX = kotlin.a.j.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3) });
    this.FFY = kotlin.a.j.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
    this.FFZ = kotlin.a.j.listOf(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
    AppMethodBeat.o(120397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.j
 * JD-Core Version:    0.7.0.1
 */