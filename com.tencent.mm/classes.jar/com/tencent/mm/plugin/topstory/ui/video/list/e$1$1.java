package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;

final class e$1$1
  implements Runnable
{
  e$1$1(e.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(126423);
    Log.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "show education pop window");
    g.a locala = new g.a(MMApplicationContext.getContext());
    locala.bDE(e.f(this.TPa.TOZ).fWt().getString(c.g.top_story_video_education)).NF(true);
    locala.aEX(c.g.app_i_known).b(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).d(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(126422);
        h.baE().ban().set(at.a.acVZ, Integer.valueOf(1));
        AppMethodBeat.o(126422);
      }
    }).show();
    AppMethodBeat.o(126423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e.1.1
 * JD-Core Version:    0.7.0.1
 */