package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.n.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.n.b;

final class al$2
  implements n.b
{
  al$2(Context paramContext) {}
  
  public final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(34897);
    if (paramTextView != null)
    {
      az.ayM();
      ai localai = c.awB().aNt(paramMenuItem.getTitle());
      if ((localai == null) || ((int)localai.fLJ <= 0))
      {
        paramTextView.setText(paramMenuItem.getTitle());
        AppMethodBeat.o(34897);
        return;
      }
      paramTextView.setText(k.b(this.val$context, localai.aaR(), paramTextView.getTextSize()));
    }
    AppMethodBeat.o(34897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.2
 * JD-Core Version:    0.7.0.1
 */