package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.ui.widget.b.e.c;

final class e$1$1
  implements Runnable
{
  e$1$1(e.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(2029);
    ab.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "show education pop window");
    e.a locala = new e.a(ah.getContext());
    locala.avu(this.tlo.tln.thM.bMN().getString(2131304375)).rI(true);
    locala.Rm(2131296977).b(new e.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).b(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(2028);
        g.RL().Ru().set(ac.a.yJG, Integer.valueOf(1));
        AppMethodBeat.o(2028);
      }
    }).show();
    AppMethodBeat.o(2029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e.1.1
 * JD-Core Version:    0.7.0.1
 */