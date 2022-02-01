package com.tencent.mm.plugin.talkroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.i;

final class TalkRoomUI$2
  implements View.OnClickListener
{
  TalkRoomUI$2(TalkRoomUI paramTalkRoomUI, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29591);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.FRw.dismiss();
    a.a(this, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(29591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.2
 * JD-Core Version:    0.7.0.1
 */