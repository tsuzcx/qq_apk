package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

final class FlipView$2
  implements n.c
{
  FlipView$2(FlipView paramFlipView, List paramList1, List paramList2) {}
  
  public final void a(l paraml)
  {
    paraml.clear();
    int i = 0;
    while (i < this.kbG.size())
    {
      paraml.e(((Integer)this.oOX.get(i)).intValue(), (CharSequence)this.kbG.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView.2
 * JD-Core Version:    0.7.0.1
 */