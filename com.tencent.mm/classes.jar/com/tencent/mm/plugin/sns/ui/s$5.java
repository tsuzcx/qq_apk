package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

final class s$5
  implements n.c
{
  s$5(s params, List paramList1, List paramList2) {}
  
  public final void a(l paraml)
  {
    paraml.clear();
    int i = 0;
    while (i < this.fng.size())
    {
      paraml.e(((Integer)this.oPH.get(i)).intValue(), (CharSequence)this.fng.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s.5
 * JD-Core Version:    0.7.0.1
 */