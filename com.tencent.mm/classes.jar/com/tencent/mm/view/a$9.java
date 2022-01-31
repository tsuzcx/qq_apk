package com.tencent.mm.view;

import com.tencent.mm.api.j;
import com.tencent.mm.api.r.a;
import com.tencent.mm.bt.b;
import com.tencent.mm.sdk.platformtools.y;

final class a$9
  implements r.a
{
  a$9(a parama) {}
  
  public final void a(j paramj)
  {
    y.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramj });
    this.wvE.getPresenter().d(paramj);
    onHide();
  }
  
  public final void onHide()
  {
    this.wvE.setActionBarVisible(true);
    this.wvE.od(true);
    this.wvE.setFooterVisible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.a.9
 * JD-Core Version:    0.7.0.1
 */