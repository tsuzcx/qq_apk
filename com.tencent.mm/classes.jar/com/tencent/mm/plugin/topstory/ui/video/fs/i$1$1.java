package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

final class i$1$1
  implements Runnable
{
  i$1$1(i.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(126393);
    f.a locala = new f.a(MMApplicationContext.getContext());
    locala.bow(i.e(this.Gpu.Gpt).eeF().getString(2131766860)).Dq(true);
    locala.apa(2131768713).b(new f.c()
    {
      public final void e(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).b(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(126392);
        g.aAh().azQ().set(ar.a.Oga, Integer.valueOf(1));
        g.aAh().azQ().gBI();
        AppMethodBeat.o(126392);
      }
    }).show();
    AppMethodBeat.o(126393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.i.1.1
 * JD-Core Version:    0.7.0.1
 */