package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;

final class j$10
  implements Runnable
{
  j$10(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(34479);
    long l = j.f(this.Alf).Mm();
    if (j.g(this.Alf) == null) {}
    for (int i = -2;; i = j.g(this.Alf).hashCode())
    {
      ab.d("MicroMsg.InitHelper", "dkinit showProgressDlg t:%d initScene:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      if ((j.h(this.Alf) != null) && (j.h(this.Alf).isShowing())) {
        j.h(this.Alf).dismiss();
      }
      j localj = this.Alf;
      Activity localActivity = j.a(this.Alf);
      j.a(this.Alf).getString(2131297087);
      j.a(localj, h.b(localActivity, j.a(this.Alf).getString(2131296988), false, new j.10.1(this)));
      aw.RO().Bk();
      AppMethodBeat.o(34479);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.10
 * JD-Core Version:    0.7.0.1
 */