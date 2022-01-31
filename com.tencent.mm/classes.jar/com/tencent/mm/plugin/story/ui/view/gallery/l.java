package com.tencent.mm.plugin.story.ui.view.gallery;

import a.a.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "", "()V", "BAD_NETWORK_PRELOAD_QUEUE", "", "", "getBAD_NETWORK_PRELOAD_QUEUE", "()Ljava/util/List;", "BAD_NETWORK_SPEED", "getBAD_NETWORK_SPEED", "()I", "setBAD_NETWORK_SPEED", "(I)V", "CAN_UPGRADES", "", "getCAN_UPGRADES", "()Z", "GOOD_NETWORK_PRELOAD_QUEUE", "getGOOD_NETWORK_PRELOAD_QUEUE", "GOOD_NETWORK_SPEED", "getGOOD_NETWORK_SPEED", "setGOOD_NETWORK_SPEED", "PRELOAD_CONNECTION_COUNT", "getPRELOAD_CONNECTION_COUNT", "PRELOAD_PERCENT", "getPRELOAD_PERCENT", "plugin-story_release"})
public final class l
{
  final boolean sTb;
  public final int sTc;
  int sTd;
  int sTe;
  final List<Integer> sTf;
  final List<Integer> sTg;
  final List<Integer> sTh;
  
  public l()
  {
    AppMethodBeat.i(110763);
    this.sTc = 30;
    this.sTd = 450;
    this.sTe = 200;
    this.sTf = j.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3) });
    this.sTg = j.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
    this.sTh = j.listOf(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
    AppMethodBeat.o(110763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.l
 * JD-Core Version:    0.7.0.1
 */