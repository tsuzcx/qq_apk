package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n.b;

final class n$2
  implements n.b
{
  n$2(Context paramContext) {}
  
  public final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    ad localad;
    if (paramTextView != null)
    {
      au.Hx();
      localad = c.Fw().abl(paramMenuItem.getTitle());
      if ((localad == null) || ((int)localad.dBe <= 0)) {
        paramTextView.setText(paramMenuItem.getTitle());
      }
    }
    else
    {
      return;
    }
    paramTextView.setText(j.b(this.val$context, localad.Bp()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.2
 * JD-Core Version:    0.7.0.1
 */