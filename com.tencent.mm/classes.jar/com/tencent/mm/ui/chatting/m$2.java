package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.o.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.n.b;

final class m$2
  implements n.b
{
  m$2(Context paramContext) {}
  
  public final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(34462);
    if (paramTextView != null)
    {
      ba.aBQ();
      am localam = c.azp().Bf(paramMenuItem.getTitle());
      if ((localam == null) || ((int)localam.gfj <= 0))
      {
        paramTextView.setText(paramMenuItem.getTitle());
        AppMethodBeat.o(34462);
        return;
      }
      paramTextView.setText(k.c(this.val$context, localam.adu()));
    }
    AppMethodBeat.o(34462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.2
 * JD-Core Version:    0.7.0.1
 */