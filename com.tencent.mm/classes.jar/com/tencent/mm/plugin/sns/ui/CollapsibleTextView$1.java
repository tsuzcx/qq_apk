package com.tencent.mm.plugin.sns.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;

final class CollapsibleTextView$1
  implements Runnable
{
  CollapsibleTextView$1(CollapsibleTextView paramCollapsibleTextView) {}
  
  public final void run()
  {
    if ((this.oOm.oOf != null) && ((this.oOm.oOf.getTag() instanceof ar)) && (((ar)this.oOm.oOf.getTag()).bRV.equals(CollapsibleTextView.a(this.oOm))))
    {
      this.oOm.oOf.setMaxLines(6);
      this.oOm.oOh.setVisibility(0);
      this.oOm.oOh.setText(CollapsibleTextView.b(this.oOm));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.CollapsibleTextView.1
 * JD-Core Version:    0.7.0.1
 */