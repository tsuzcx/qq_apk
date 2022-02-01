package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

final class e$1$1
  implements Runnable
{
  e$1$1(e.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(126423);
    Log.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "show education pop window");
    f.a locala = new f.a(MMApplicationContext.getContext());
    locala.bow(e.f(this.GpE.GpD).eeF().getString(2131766860)).Dq(true);
    locala.apa(2131755874).b(new f.c()
    {
      public final void e(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).b(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(126422);
        g.aAh().azQ().set(ar.a.Oga, Integer.valueOf(1));
        AppMethodBeat.o(126422);
      }
    }).show();
    AppMethodBeat.o(126423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e.1.1
 * JD-Core Version:    0.7.0.1
 */