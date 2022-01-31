package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class SnsTimeLineUI$42
  implements n.c
{
  SnsTimeLineUI$42(SnsTimeLineUI paramSnsTimeLineUI, List paramList) {}
  
  public final void a(l paraml)
  {
    Iterator localIterator = this.fng.iterator();
    while (localIterator.hasNext()) {
      paraml.i((m)localIterator.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.42
 * JD-Core Version:    0.7.0.1
 */