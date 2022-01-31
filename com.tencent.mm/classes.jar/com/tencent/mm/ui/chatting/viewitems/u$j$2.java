package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class u$j$2
  implements e.a
{
  u$j$2(u.j paramj, int paramInt, u.c paramc) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(33080);
    if (this.euv > 1)
    {
      this.zUR.zUI.pUs.setTextColor(u.j.a(this.zUT).zJz.getContext().getResources().getColor(2131690709));
      this.zUR.zUI.pUs.setBackgroundResource(2130837928);
    }
    this.zUR.zUI.pUt.setVisibility(0);
    AppMethodBeat.o(33080);
  }
  
  public final void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.j.2
 * JD-Core Version:    0.7.0.1
 */