package com.tencent.mm.plugin.music.ui;

import android.view.View;
import com.tencent.mm.h.a.jy;
import com.tencent.mm.h.a.jy.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class MusicMainUI$3$4
  implements Runnable
{
  MusicMainUI$3$4(MusicMainUI.3 param3, jy paramjy) {}
  
  public final void run()
  {
    b localb = MusicMainUI.i(this.mCc.mCa);
    String str = this.mCb.bSA.bSB;
    Iterator localIterator = localb.mBv.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      b.a locala = (b.a)((View)((Map.Entry)localIterator.next()).getValue()).getTag();
      if (!locala.mzx.field_musicId.equals(str)) {
        break label123;
      }
      locala.c(e.bnq().JE(str), true);
      i = 1;
    }
    label123:
    for (;;)
    {
      break;
      if (i == 0)
      {
        y.i("MicroMsg.Music.MusicMainAdapter", "holder song id is not exist, do refresh all");
        localb.notifyDataSetChanged();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.3.4
 * JD-Core Version:    0.7.0.1
 */