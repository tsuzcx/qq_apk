package com.tencent.mm.ui.base;

import android.widget.TextView;

final class MMCollapsibleTextView$2
  implements Runnable
{
  MMCollapsibleTextView$2(MMCollapsibleTextView paramMMCollapsibleTextView) {}
  
  public final void run()
  {
    MMCollapsibleTextView.d(this.uUB).setMaxLines(10);
    MMCollapsibleTextView.e(this.uUB).setVisibility(0);
    MMCollapsibleTextView.e(this.uUB).setText(MMCollapsibleTextView.f(this.uUB));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMCollapsibleTextView.2
 * JD-Core Version:    0.7.0.1
 */