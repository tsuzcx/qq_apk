package com.tencent.mm.view.e;

import com.tencent.mm.view.SmileyPanelViewPager;

public final class a$6
  implements Runnable
{
  public a$6(a parama, String paramString) {}
  
  public final void run()
  {
    if ((a.c(this.wzg) == null) || (a.d(this.wzg) == null) || (a.d(this.wzg).afc(this.iXv) == null)) {
      return;
    }
    a.a(this.wzg, a.d(this.wzg).afc(this.iXv).hxB);
    a.c(this.wzg).setCurrentItem(a.e(this.wzg));
    a.d(this.wzg).wzE = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.e.a.6
 * JD-Core Version:    0.7.0.1
 */