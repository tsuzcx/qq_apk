package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.multitask.b.a;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "()V", "ADD_HISTORY_DURATION_LIMIT", "", "getADD_HISTORY_DURATION_LIMIT", "()I", "fillMultiTaskData", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "extras", "Landroid/os/Bundle;", "onClose", "", "way", "ended", "reset", "Companion", "plugin-music_release"})
public final class k
  extends a
{
  private static final k.b FRK;
  public static final k.a FRL;
  private final int FRJ = 10000;
  
  static
  {
    AppMethodBeat.i(260580);
    FRL = new k.a((byte)0);
    FRK = new k.b();
    AppMethodBeat.o(260580);
  }
  
  public static final void dFh()
  {
    AppMethodBeat.i(260582);
    b localb = (b)h.ae(b.class);
    if (localb != null)
    {
      localb.a(6, (b.a)FRK);
      AppMethodBeat.o(260582);
      return;
    }
    AppMethodBeat.o(260582);
  }
  
  public static final void dFi()
  {
    AppMethodBeat.i(260584);
    b localb = (b)h.ae(b.class);
    if (localb != null)
    {
      localb.b(6, (b.a)FRK);
      AppMethodBeat.o(260584);
      return;
    }
    AppMethodBeat.o(260584);
  }
  
  public final boolean Q(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(260579);
    Object localObject = com.tencent.mm.plugin.music.e.k.fet();
    p.j(localObject, "MusicPlayerManager.Instance()");
    localObject = ((com.tencent.mm.plugin.music.e.k)localObject).feg();
    if (localObject != null) {}
    for (paramInt = ((d)localObject).fdx();; paramInt = 0)
    {
      Log.i("MicroMsg.MusicPlayerMultiTaskHelper", "onClose ".concat(String.valueOf(paramInt)));
      if (this.FHd != null) {
        break;
      }
      AppMethodBeat.o(260579);
      return true;
    }
    if (paramInt > this.FRJ)
    {
      Log.i("MicroMsg.MusicPlayerMultiTaskHelper", "add historyTaskInfo");
      ag(null);
    }
    for (;;)
    {
      this.FHd = null;
      AppMethodBeat.o(260579);
      return true;
      c(null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.k
 * JD-Core Version:    0.7.0.1
 */