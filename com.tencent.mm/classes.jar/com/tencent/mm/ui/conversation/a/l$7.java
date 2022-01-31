package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.be;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class l$7
  implements View.OnClickListener
{
  l$7(l paraml, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34682);
    be.aaG().cs(this.bHS, this.yWR);
    paramView = (Context)this.AmR.vUD.get();
    int i;
    if ((r.Zy() & 0x10000) == 0)
    {
      i = 1;
      if (i == 0) {
        break label95;
      }
      d.H(paramView, "masssend", ".ui.MassSendHistoryUI");
    }
    for (;;)
    {
      h.qsU.e(11002, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
      AppMethodBeat.o(34682);
      return;
      i = 0;
      break;
      label95:
      d.b(paramView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l.7
 * JD-Core Version:    0.7.0.1
 */