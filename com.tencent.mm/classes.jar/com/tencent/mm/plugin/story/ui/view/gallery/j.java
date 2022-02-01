package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "", "()V", "BAD_NETWORK_PRELOAD_QUEUE", "", "", "getBAD_NETWORK_PRELOAD_QUEUE", "()Ljava/util/List;", "BAD_NETWORK_SPEED", "getBAD_NETWORK_SPEED", "()I", "setBAD_NETWORK_SPEED", "(I)V", "CAN_UPGRADES", "", "getCAN_UPGRADES", "()Z", "GOOD_NETWORK_PRELOAD_QUEUE", "getGOOD_NETWORK_PRELOAD_QUEUE", "GOOD_NETWORK_SPEED", "getGOOD_NETWORK_SPEED", "setGOOD_NETWORK_SPEED", "PRELOAD_CONNECTION_COUNT", "getPRELOAD_CONNECTION_COUNT", "PRELOAD_PERCENT", "getPRELOAD_PERCENT", "plugin-story_release"})
public final class j
{
  final boolean BdK;
  public final int BdL;
  int BdM;
  int BdN;
  final List<Integer> BdO;
  final List<Integer> BdP;
  final List<Integer> BdQ;
  
  public j()
  {
    AppMethodBeat.i(120397);
    this.BdL = 30;
    this.BdM = 450;
    this.BdN = 200;
    this.BdO = d.a.j.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3) });
    this.BdP = d.a.j.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
    this.BdQ = d.a.j.listOf(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
    AppMethodBeat.o(120397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.j
 * JD-Core Version:    0.7.0.1
 */