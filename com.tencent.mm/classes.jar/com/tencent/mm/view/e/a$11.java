package com.tencent.mm.view.e;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.view.SmileyPanelViewPager;
import com.tencent.mm.view.a.g;

final class a$11
  implements j.a
{
  a$11(a parama) {}
  
  public final void a(String paramString, l paraml)
  {
    paramString = paraml.obj;
    int i;
    if ((paramString instanceof Integer))
    {
      i = ((Integer)paramString).intValue();
      if ((a.d(this.wzg).cMh()) || (i < 3)) {
        break label69;
      }
      a.d(this.wzg).cMi();
      a.i(this.wzg);
      this.wzg.cLR();
    }
    label69:
    while ((a.j(this.wzg) == null) || (a.c(this.wzg) == null))
    {
      return;
      i = 0;
      break;
    }
    a.j(this.wzg).aw(a.c(this.wzg).getCurrentItem(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.e.a.11
 * JD-Core Version:    0.7.0.1
 */