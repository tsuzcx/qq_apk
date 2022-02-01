package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;

final class i$1$1
  implements Runnable
{
  i$1$1(i.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(126393);
    g.a locala = new g.a(MMApplicationContext.getContext());
    locala.bDE(i.e(this.TOQ.TOO).fWt().getString(c.g.top_story_video_education)).NF(true);
    locala.aEX(c.g.welcome_i_know).b(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).d(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(126392);
        h.baE().ban().set(at.a.acVZ, Integer.valueOf(1));
        h.baE().ban().iZy();
        AppMethodBeat.o(126392);
      }
    }).show();
    AppMethodBeat.o(126393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.i.1.1
 * JD-Core Version:    0.7.0.1
 */