package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
    ac.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "show education pop window");
    f.a locala = new f.a(ai.getContext());
    locala.aRQ(e.f(this.AfN.AfM).cYC().getString(2131764516)).yi(true);
    locala.acQ(2131755793).b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).b(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(126422);
        g.agR().agA().set(ah.a.GQH, Integer.valueOf(1));
        AppMethodBeat.o(126422);
      }
    }).show();
    AppMethodBeat.o(126423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e.1.1
 * JD-Core Version:    0.7.0.1
 */