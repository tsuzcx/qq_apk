package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ad;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.u;

final class ag$10
  implements AdapterView.OnItemClickListener
{
  ag$10(ag paramag) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(31652);
    paramAdapterView = (bi)ag.d(this.zHJ).getItem(paramInt);
    if ((paramAdapterView != null) && (!bo.isNullOrNil(paramAdapterView.field_talker)))
    {
      this.zHJ.dIY();
      ((i)this.zHJ.caz.ay(i.class)).be(paramAdapterView);
      if (!this.zHJ.zHA)
      {
        this.zHJ.zHA = true;
        this.zHJ.caz.zJB.setBottomViewVisible(true);
        this.zHJ.caz.zJA.dGN();
      }
      this.zHJ.caz.zJB.dGL();
      this.zHJ.caz.zJB.setIsBottomShowAll(false);
      ((h)this.zHJ.caz.ay(h.class)).a(paramAdapterView.field_msgId, false, d.a.zOA);
    }
    AppMethodBeat.o(31652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ag.10
 * JD-Core Version:    0.7.0.1
 */