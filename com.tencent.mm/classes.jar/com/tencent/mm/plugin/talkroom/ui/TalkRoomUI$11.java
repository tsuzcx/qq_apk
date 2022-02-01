package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.talkroom.model.g;
import com.tencent.mm.ui.base.h;

final class TalkRoomUI$11
  implements View.OnClickListener
{
  TalkRoomUI$11(TalkRoomUI paramTalkRoomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29599);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    h.a(this.FRv, this.FRv.getString(2131766616), this.FRv.getString(2131766615), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29598);
        TalkRoomUI.j(TalkRoomUI.11.this.FRv);
        com.tencent.mm.plugin.talkroom.model.b.ftN().fub();
        TalkRoomUI.11.this.FRv.finish();
        AppMethodBeat.o(29598);
      }
    }, null);
    a.a(this, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(29599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.11
 * JD-Core Version:    0.7.0.1
 */