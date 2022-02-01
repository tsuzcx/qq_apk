package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.o.c;

final class an$2
  implements o.c
{
  an$2(Context paramContext) {}
  
  public final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(34897);
    if (paramTextView != null)
    {
      bg.aVF();
      as localas = com.tencent.mm.model.c.aSN().Kn(paramMenuItem.getTitle());
      if ((localas == null) || ((int)localas.gMZ <= 0))
      {
        paramTextView.setText(paramMenuItem.getTitle());
        AppMethodBeat.o(34897);
        return;
      }
      paramTextView.setText(l.b(this.val$context, localas.arI(), paramTextView.getTextSize()));
    }
    AppMethodBeat.o(34897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.an.2
 * JD-Core Version:    0.7.0.1
 */