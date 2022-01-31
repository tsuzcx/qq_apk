package com.tencent.mm.ui.chatting.viewitems;

import android.widget.ImageView;
import com.tencent.mm.R.g;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.bi;

final class r$j$4
  implements e.a
{
  r$j$4(r.j paramj, r.c paramc, bi parambi) {}
  
  public final void onFinish()
  {
    this.vDG.vDC.ifL.setVisibility(0);
    if ((this.dUy.field_msgId + "_0").equals(this.vDG.vBb))
    {
      this.vDG.vDC.ifH.setImageResource(R.g.chatting_item_biz_music_pause_selector);
      return;
    }
    this.vDG.vDC.ifH.setImageResource(R.g.chatting_item_biz_music_play_selector);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.j.4
 * JD-Core Version:    0.7.0.1
 */