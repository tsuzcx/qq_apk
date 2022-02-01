package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.multitask.b.a;
import com.tencent.mm.plugin.music.e.a.d;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "()V", "ADD_HISTORY_DURATION_LIMIT", "", "getADD_HISTORY_DURATION_LIMIT", "()I", "fillMultiTaskData", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "extras", "Landroid/os/Bundle;", "onClose", "", "way", "ended", "reset", "Companion", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends a
{
  public static final k.a LME;
  private static final k.b LMG;
  private final int LMF = 10000;
  
  static
  {
    AppMethodBeat.i(271142);
    LME = new k.a((byte)0);
    LMG = new k.b();
    AppMethodBeat.o(271142);
  }
  
  public static final void evw()
  {
    AppMethodBeat.i(271126);
    b localb = (b)h.ax(b.class);
    if (localb != null) {
      localb.a(6, (b.a)LMG);
    }
    AppMethodBeat.o(271126);
  }
  
  public static final void evx()
  {
    AppMethodBeat.i(271134);
    b localb = (b)h.ax(b.class);
    if (localb != null) {
      localb.b(6, (b.a)LMG);
    }
    AppMethodBeat.o(271134);
  }
  
  public final boolean af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(271151);
    d locald = j.gnw().gnj();
    if (locald == null) {}
    for (paramInt = 0;; paramInt = locald.gmA())
    {
      Log.i("MicroMsg.MusicPlayerMultiTaskHelper", s.X("onClose ", Integer.valueOf(paramInt)));
      if (this.LCE != null) {
        break;
      }
      AppMethodBeat.o(271151);
      return true;
    }
    if (paramInt > this.LMF)
    {
      Log.i("MicroMsg.MusicPlayerMultiTaskHelper", "add historyTaskInfo");
      as(null);
    }
    for (;;)
    {
      this.LCE = null;
      AppMethodBeat.o(271151);
      return true;
      d(null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.k
 * JD-Core Version:    0.7.0.1
 */