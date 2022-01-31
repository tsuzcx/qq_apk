package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class c$2
  implements Runnable
{
  public c$2(c paramc, ArrayList paramArrayList) {}
  
  public final void run()
  {
    ArrayList localArrayList = h.a(c.d(this.rHC), this.rHD, false);
    y.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, start mNotifyListener.setUpNoteData(dataItems, true)");
    if (c.e(this.rHC) != null) {
      c.e(this.rHC).d(localArrayList, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.c.2
 * JD-Core Version:    0.7.0.1
 */