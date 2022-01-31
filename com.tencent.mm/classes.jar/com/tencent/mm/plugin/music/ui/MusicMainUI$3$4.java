package com.tencent.mm.plugin.music.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.g.a.ki.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class MusicMainUI$3$4
  implements Runnable
{
  MusicMainUI$3$4(MusicMainUI.3 param3, ki paramki) {}
  
  public final void run()
  {
    AppMethodBeat.i(105094);
    b localb = MusicMainUI.i(this.pcf.pcd);
    String str = this.pce.cAc.cAd;
    Iterator localIterator = localb.pbA.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      b.a locala = (b.a)((View)((Map.Entry)localIterator.next()).getValue()).getTag();
      if (!locala.oZD.field_musicId.equals(str)) {
        break label133;
      }
      locala.d(e.bVM().VC(str), true);
      i = 1;
    }
    label133:
    for (;;)
    {
      break;
      if (i == 0)
      {
        ab.i("MicroMsg.Music.MusicMainAdapter", "holder song id is not exist, do refresh all");
        localb.notifyDataSetChanged();
      }
      AppMethodBeat.o(105094);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.3.4
 * JD-Core Version:    0.7.0.1
 */