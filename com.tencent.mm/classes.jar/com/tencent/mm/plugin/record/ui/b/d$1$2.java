package com.tencent.mm.plugin.record.ui.b;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class d$1$2
  implements n.d
{
  d$1$2(d.1 param1, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (paramInt == 0)
    {
      ((ClipboardManager)this.nuG.nuF.context.getSystemService("clipboard")).setText(this.dpT.getText());
      h.bB(this.nuG.nuF.context, this.nuG.nuF.context.getString(R.l.app_copy_ok));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d.1.2
 * JD-Core Version:    0.7.0.1
 */