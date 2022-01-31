package com.tencent.mm.ui.base;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;

final class MMCollapsibleTextView$1
  implements View.OnClickListener
{
  MMCollapsibleTextView$1(MMCollapsibleTextView paramMMCollapsibleTextView) {}
  
  public final void onClick(View paramView)
  {
    switch (MMCollapsibleTextView.b(this.uUB).get(MMCollapsibleTextView.a(this.uUB), -1))
    {
    default: 
      return;
    case 1: 
      MMCollapsibleTextView.b(this.uUB).put(MMCollapsibleTextView.a(this.uUB), 2);
    }
    for (;;)
    {
      MMCollapsibleTextView.c(this.uUB);
      return;
      MMCollapsibleTextView.b(this.uUB).put(MMCollapsibleTextView.a(this.uUB), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMCollapsibleTextView.1
 * JD-Core Version:    0.7.0.1
 */