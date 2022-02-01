package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.u.d;

final class p$2
  implements u.d
{
  p$2(Context paramContext) {}
  
  public final void onAttach(TextView paramTextView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(34462);
    if (paramTextView != null)
    {
      bh.bCz();
      au localau = c.bzA().JE(paramMenuItem.getTitle());
      if ((localau == null) || ((int)localau.maN <= 0))
      {
        paramTextView.setText(paramMenuItem.getTitle());
        AppMethodBeat.o(34462);
        return;
      }
      paramTextView.setText(p.b(this.val$context, localau.aSU()));
    }
    AppMethodBeat.o(34462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p.2
 * JD-Core Version:    0.7.0.1
 */