package com.tencent.mm.plugin.talkroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class TalkRoomUI$16
  implements View.OnClickListener
{
  TalkRoomUI$16(TalkRoomUI paramTalkRoomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29606);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.Mlw.onBackPressed();
    a.a(this, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(29606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.16
 * JD-Core Version:    0.7.0.1
 */