package com.tencent.mm.plugin.talkroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.i;

final class TalkRoomUI$2
  implements View.OnClickListener
{
  TalkRoomUI$2(TalkRoomUI paramTalkRoomUI, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29591);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.SOR.dismiss();
    a.a(this, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(29591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.2
 * JD-Core Version:    0.7.0.1
 */