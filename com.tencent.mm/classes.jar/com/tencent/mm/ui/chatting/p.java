package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.x;

public final class p
{
  public a byx;
  public long[] vjF = null;
  
  public p(a parama, long[] paramArrayOfLong)
  {
    this.byx = parama;
    this.vjF = paramArrayOfLong;
    this.byx.vtz.removeAllOptionMenu();
    this.byx.vtz.addTextOptionMenu(2, this.byx.vtz.getMMResources().getString(R.l.biz_report_confirm), new p.1(this), null, s.b.uNx);
    parama = (g)this.byx.ac(g.class);
    parama.e(new p.2(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p
 * JD-Core Version:    0.7.0.1
 */