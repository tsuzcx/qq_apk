package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n.b;

final class al$2
  implements n.b
{
  al$2(Context paramContext) {}
  
  public final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(31011);
    if (paramTextView != null)
    {
      aw.aaz();
      ad localad = c.YA().arw(paramMenuItem.getTitle());
      if ((localad == null) || ((int)localad.euF <= 0))
      {
        paramTextView.setText(paramMenuItem.getTitle());
        AppMethodBeat.o(31011);
        return;
      }
      paramTextView.setText(j.b(this.val$context, localad.Oe(), paramTextView.getTextSize()));
    }
    AppMethodBeat.o(31011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.2
 * JD-Core Version:    0.7.0.1
 */