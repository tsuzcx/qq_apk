package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.n.b;

final class n$2
  implements n.b
{
  n$2(Context paramContext) {}
  
  public final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(34462);
    if (paramTextView != null)
    {
      bc.aCg();
      an localan = com.tencent.mm.model.c.azF().BH(paramMenuItem.getTitle());
      if ((localan == null) || ((int)localan.ght <= 0))
      {
        paramTextView.setText(paramMenuItem.getTitle());
        AppMethodBeat.o(34462);
        return;
      }
      paramTextView.setText(k.c(this.val$context, localan.adF()));
    }
    AppMethodBeat.o(34462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.2
 * JD-Core Version:    0.7.0.1
 */