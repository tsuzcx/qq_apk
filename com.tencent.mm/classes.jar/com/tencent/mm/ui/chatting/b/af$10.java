package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.h;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.v;

final class af$10
  implements AdapterView.OnItemClickListener
{
  af$10(af paramaf) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bi)af.d(this.vsd).getItem(paramInt);
    if ((paramAdapterView != null) && (!bk.bl(paramAdapterView.field_talker)))
    {
      this.vsd.cFg();
      ((h)this.vsd.byx.ac(h.class)).aT(paramAdapterView);
      if (!this.vsd.vrU)
      {
        this.vsd.vrU = true;
        this.vsd.byx.vtB.setBottomViewVisible(true);
        this.vsd.byx.vtA.cDb();
      }
      this.vsd.byx.vtB.cCZ();
      this.vsd.byx.vtB.setIsBottomShowAll(false);
      ((g)this.vsd.byx.ac(g.class)).a(paramAdapterView.field_msgId, false, d.a.vyf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.af.10
 * JD-Core Version:    0.7.0.1
 */